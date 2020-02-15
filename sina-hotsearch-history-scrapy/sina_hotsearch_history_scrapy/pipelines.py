# -*- coding: utf-8 -*-

from sina_hotsearch_history_scrapy.items import HotSearchList, HotSearchListItem, HotSearchRank, HotSearchBlogItem
import logging
import pymysql
import pymysql.cursors
from DBUtils.PooledDB import PooledDB, SharedDBConnection
import config


class SinaHotsearchHistoryScrapyPipeline(object):
    __logging = logging.getLogger(__name__)

    def __init__(self):
        self.__mysqlPool = PooledDB(
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
            charset=config.get_config_value('mysql', 'charset')
        )

    def process_item(self, item, spider):
        if isinstance(item, HotSearchList):
            item = self.process_hotsearch_list(item, spider)
        elif isinstance(item, HotSearchListItem):
            item = self.process_hotsearch_list_detail(item, spider)
        return item

    def process_hotsearch_list(self, item, spider):
        time = str(item['time'])
        logging.info("time ------> " + time)
        conn = self.__mysqlPool.connection()
        cursor = conn.cursor()

        try:
            conn.begin()
            cursor.execute(
                "INSERT INTO hotsearch_list (time) VALUES (%s)",
                (time,)
            )
            cursor.execute("SELECT @@identity")     # 查询主键
            res = cursor.fetchone()
            logging.info("id ------> " + str(res[0]))
            conn.commit()
            logging.info("process_hotsearch_list ----> commit success")
        except Exception as e:
            logging.error("process_hotsearch_list ----> commit fail", e)
            conn.rollback()
        finally:
            cursor.close()
            conn.close()

        spider.hotsearch_list_id = res[0]   # 返回插入的ID

        return item

    def process_hotsearch_list_detail(self, item, spider):
        conn = self.__mysqlPool.connection()
        cursor = conn.cursor()

        hotsearch_id = item['hotsearch_id']
        hotsearch_rank = item['hotsearch_rank']
        icon = item['icon']
        desc = item['desc']
        desc_extr = item['desc_extr']
        scheme = item['scheme']
        detail_url = item['detail_url']

        try:
            conn.begin()
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

            insert_rank_sql = \
                "INSERT INTO hotsearch_rank " \
                "(hotsearch_id,hotsearch_detail_id,rank) " \
                "VALUES " \
                "(%s,%s,%s)"
            cursor.execute(insert_rank_sql,
                           (hotsearch_id, hotsearch_list_detail_id, hotsearch_rank))
            conn.commit()
            logging.info("process_hotsearch_list_detail ----> commit success")
        except Exception as e:
            logging.error("process_hotsearch_list_detail ----> commit fail", e)
            logging.error("last_execute_sql ----> " + cursor._last_executed)
            conn.rollback()
        finally:
            cursor.close()
            conn.close()
        return item

