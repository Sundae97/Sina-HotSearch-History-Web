# -*- coding: utf-8 -*-
from pymysql import InternalError

from sina_hotsearch_history_scrapy.items import HotSearchList, HotSearchListItem, HotSearchRank, HotSearchBlogItem
import logging
import pymysql
import pymysql.cursors
from DBUtils.PooledDB import PooledDB
import redis
import config
import json


class SinaHotsearchHistoryScrapyPipeline(object):
    __logging = logging.getLogger(__name__)

    def __init__(self):
        self.__init_mysql()
        self.__init_redis()

    def __init_mysql(self):
        self.__mysql_pool = PooledDB(
            creator=pymysql,
            maxconnections=3,
            mincached=2,
            maxcached=5,
            maxshared=3,
            blocking=True,  # 阻塞等待
            host=config.get_config_value('mysql', 'host'),
            port=int(config.get_config_value('mysql', 'port')),
            user=config.get_config_value('mysql', 'user'),
            password=config.get_config_value('mysql', 'password'),
            database=config.get_config_value('mysql', 'database'),
            charset=config.get_config_value('mysql', 'charset'),
        )

    def __init_redis(self):
        self.__redis_pool = redis.ConnectionPool(
            host=config.get_config_value('redis', 'host'),
            port=int(config.get_config_value('redis', 'port')),
            password=config.get_config_value('redis', 'password'),
            db=config.get_config_value('redis', 'db'),
            decode_responses=config.get_config_value('redis', 'decode_responses'),
            max_connections=512
        )

    def __get_mysql_connection(self):
        return self.__mysql_pool.connection()

    def __get_redis_connection(self):
        return redis.Redis(connection_pool=self.__redis_pool)

    def process_item(self, item, spider):
        if isinstance(item, HotSearchList):
            item = self.process_hotsearch_list(item, spider)
        elif isinstance(item, HotSearchListItem):
            item = self.process_hotsearch_list_detail(item, spider)
        elif isinstance(item, HotSearchBlogItem):
            item = self.process_hotsearch_blog(item, spider)
        return item

    def process_hotsearch_list(self, item, spider):
        time = str(item['time'])
        logging.info("time ------> " + time)

        mysql_conn = self.__get_mysql_connection()
        cursor = mysql_conn.cursor()

        try:
            mysql_conn.begin()
            cursor.execute(
                "INSERT INTO hotsearch_list (time) VALUES (%s)",
                (time,)
            )
            cursor.execute("SELECT @@identity")     # 查询主键
            res = cursor.fetchone()[0]
            logging.info("id ------> " + str(res))
            mysql_conn.commit()
            spider.hotsearch_list_id = res   # 返回插入的ID
            logging.info("process_hotsearch_list ----> commit success")
        except Exception as e:
            logging.error("process_hotsearch_list ----> commit fail", e)
            mysql_conn.rollback()
        finally:
            cursor.close()
            mysql_conn.close()

        return item

    def process_hotsearch_list_detail(self, item, spider):
        hotsearch_id = item['hotsearch_id']
        hotsearch_rank = item['hotsearch_rank']
        icon = item['icon']
        desc = item['desc']
        desc_extr = item['desc_extr']
        scheme = item['scheme']
        detail_url = item['detail_url']

        item_dict = {
            'hotsearch_id': hotsearch_id,
            'hotsearch_rank': hotsearch_rank,
            'icon': icon,
            'desc': desc,
            'desc_extr': desc_extr,
            'scheme': scheme,
            'detail_url': detail_url
        }

        redis_conn = self.__get_redis_connection()
        mysql_conn = self.__get_mysql_connection()
        cursor = mysql_conn.cursor()
        try:
            mysql_conn.begin()
            # 判断redis中是否存在这个标题的热搜
            spider.exists_the_hotsearch = redis_conn.exists(desc)
            if spider.exists_the_hotsearch:    # 如果存在就从redis中取出热搜的id,并且不插入数据库
                exist_item = json.loads(redis_conn.get(desc))
                hotsearch_list_detail_id = int(exist_item['id'])
            else:   # 否则就插入到mysql
                insert_list_detail_sql = \
                    "INSERT INTO hotsearch_list_detail " \
                    "(icon,`desc`,desc_extr,scheme,detail_url) " \
                    "VALUES " \
                    "(%s, %s, %s, %s, %s)"
                cursor.execute(insert_list_detail_sql,
                               (icon, desc, desc_extr, scheme, detail_url))
                cursor.execute("SELECT @@identity")     # 查询主键
                res = cursor.fetchone()
                hotsearch_list_detail_id = res[0]

            # 插入到热搜排行表
            insert_rank_sql = \
                "INSERT INTO hotsearch_rank " \
                "(hotsearch_id,hotsearch_detail_id,rank) " \
                "VALUES " \
                "(%s,%s,%s)"
            cursor.execute(insert_rank_sql,
                           (hotsearch_id, hotsearch_list_detail_id, hotsearch_rank))
            mysql_conn.commit()

            item_dict['id'] = hotsearch_list_detail_id
            redis_conn.set(desc, json.dumps(item_dict), ex=config.expiration_time)  # 重新设置redis,并且重置过期时间
            spider.hotsearch_item_id = hotsearch_list_detail_id   # 返回插入的ID
            logging.info("process_hotsearch_list_detail ----> commit success")
        except Exception as e:
            logging.error("process_hotsearch_list_detail ----> commit fail", e)
            logging.error("process_hotsearch_list_detail ----> last_execute_sql ----> " + cursor._last_executed)
            mysql_conn.rollback()
        finally:
            cursor.close()
            mysql_conn.close()
            redis_conn.close()
        return item

    def process_hotsearch_blog(self, item, spider):

        mysql_conn = self.__get_mysql_connection()
        cursor = mysql_conn.cursor()

        hotsearch_item_id = item['hotsearch_item_id']
        user_id = item['user_id']
        screen_name = item['screen_name']
        user_head_img = item['user_head_img']
        mblog_id = item['mblog_id']
        text = item['text']
        pic_urls_str = item['pic_urls_str']
        reports_count = item['reposts_count']
        comments_count = item['comments_count']
        attitudes_count = item['attitudes_count']

        try:
            mysql_conn.begin()
            insert_blog_detail_sql = \
                "INSERT INTO hotsearch_blog_detail " \
                "(hotsearch_item_id,user_id,screen_name,user_head_img,mblog_id,text," \
                "pic_urls_str,reposts_count,comments_count,attitudes_count) " \
                "VALUES " \
                "(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
            cursor.execute(insert_blog_detail_sql,
                           (hotsearch_item_id, user_id, screen_name, user_head_img, mblog_id,
                            text, pic_urls_str, reports_count, comments_count, attitudes_count))
            mysql_conn.commit()
            logging.info("process_hotsearch_blog ----> commit success")
        except Exception as e:
            logging.error("process_hotsearch_blog ----> commit fail", e)
            logging.error("process_hotsearch_blog ----> last_execute_sql ----> " + cursor._last_executed)
            mysql_conn.rollback()
        finally:
            cursor.close()
            mysql_conn.close()

        return item

