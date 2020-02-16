# -*- coding: utf-8 -*-
import scrapy
import json
import urllib.parse
import datetime
import config
from bs4 import BeautifulSoup
from sina_hotsearch_history_scrapy.items import HotSearchList, HotSearchListItem, HotSearchRank, HotSearchBlogItem
import logging


class SinaHotSearchPySpider(scrapy.Spider):
    logging = logging.getLogger(__name__)
    name = 'SinaHotSearchPySpider'
    allowed_domains = ['m.weibo.cn']
    base_url = 'https://m.weibo.cn/api/container/getIndex?'
    start_urls = [
        base_url + 'containerid=231583&sudaref=m.weibo.cn&display=0&retcode=6102&page_type=searchall',
    ]
    get_hotsearch_list_url = base_url + "containerid=106003type%3D25%26t%3D3%26disable_hot%3D1%26filter_type" \
                                        "%3Drealtimehot&title=%E5%BE%AE%E5%8D%9A%E7%83%AD%E6%90%9C&extparam=pos%3D0_0" \
                                        "%26mi_cid%3D100103%26cate%3D10103%26filter_type%3Drealtimehot%26c_type%3D30" \
                                        "%26display_time%3D{DISPLAY_TIME_PLACEHOLDER}&luicode=10000011&lfid=231583"

    get_hotsearch_detail_url = base_url + "{URL_PARAM}"

    def parse(self, response):
        response_body = self.responsebody_to_json(response)
        hotsearch_start_time = response_body['data']['cardlistInfo']['starttime']
        start_time = datetime.datetime.fromtimestamp(hotsearch_start_time)
        start_time = start_time - datetime.timedelta(seconds=start_time.second) - datetime.timedelta(
            seconds=start_time.microsecond)
        item = HotSearchList()
        item['time'] = start_time
        yield item
        yield scrapy.Request(
            url=self.get_hotsearch_list_url.format(DISPLAY_TIME_PLACEHOLDER=hotsearch_start_time),
            callback=self.parse_get_hotsearch_list
        )
        pass

    def parse_get_hotsearch_list(self, response):
        '''
        获取微博热搜列表
        :param response:
        :return:
        '''
        response_body = self.responsebody_to_json(response)
        hotsearch_list = response_body['data']['cards'][0]['card_group']
        # del hotsearch_list[3]  # 移除推荐
        # del hotsearch_list[0]  # 移除置顶
        i = 0
        for item in hotsearch_list:
            if 'desc_extr' not in item.keys():  # 置顶
                continue
            elif 'promotion' in item.keys():  # 推荐广告
                continue

            hotsearch_list_item = self.parse_to_hotsearch_list_item(self.hotsearch_list_id, i, item)
            yield hotsearch_list_item

            if self.exists_the_hotsearch:   # 如果是已经在redis中存在的热搜 就不进行获取热门微博
                logging.info(item['desc'] + " ----> exist continue")
                continue
            yield scrapy.Request(
                url=hotsearch_list_item['detail_url'],
                callback=self.parse_get_hotsearch_blog_detail,
                meta={'hotsearch_item_id': self.hotsearch_item_id}
            )
            i += 1
        pass

    def parse_get_hotsearch_blog_detail(self, response):
        '''
        获取微博热搜的热门微博
        :param response:
        :return:
        '''
        try:
            hotsearch_item_id = response.meta['hotsearch_item_id']
            response_body = self.responsebody_to_json(response)
            cards = response_body['data']['cards']
            max_collection_num = config.crawl_blog_num  # 获取热门微博的数量
            i = 0
            for card in cards:
                if int(card['card_type']) == 9:
                    blog_data = card['mblog']
                    blog_item = self.parse_to_hostsearch_blog_detail(blog_data, hotsearch_item_id)
                    yield blog_item
                    i += 1
                else:
                    continue
                if i >= max_collection_num:
                    break
        except (KeyError, UnboundLocalError) as e:
            logging.error("parse_get_hotsearch_blog_detail ---> fail", e)
        pass

    @staticmethod
    def parse_to_hotsearch_list_item(hotsearch_list_id, rank, item):
        hotsearch_list_item = HotSearchListItem()
        hotsearch_list_item['hotsearch_id'] = hotsearch_list_id
        hotsearch_list_item['hotsearch_rank'] = rank
        hotsearch_list_item['icon'] = item['icon'] if 'icon' in item.keys() else ''
        hotsearch_list_item['desc'] = item['desc']
        hotsearch_list_item['desc_extr'] = int(item['desc_extr'])
        hotsearch_list_item['scheme'] = item['scheme']

        scheme_url = item['scheme']
        param_map = SinaHotSearchPySpider.url_param_to_map(scheme_url)
        url_param = urllib.parse.urlencode({"containerid": param_map["containerid"][0]})
        detail_url = SinaHotSearchPySpider.get_hotsearch_detail_url.format(URL_PARAM=url_param)

        hotsearch_list_item['detail_url'] = detail_url
        return hotsearch_list_item

    @staticmethod
    def parse_to_hostsearch_blog_detail(blog_data, hotsearch_item_id):
        blog_item = HotSearchBlogItem()
        blog_item['hotsearch_item_id'] = int(hotsearch_item_id)
        blog_item['user_id'] = int(blog_data['user']['id'])
        blog_item['screen_name'] = blog_data['user']['screen_name']
        blog_item['mblog_id'] = blog_data['id']
        blog_item['text'] = SinaHotSearchPySpider.cleanDate(blog_data['text'])
        blog_item['pic_urls_str'] = SinaHotSearchPySpider.get_pic_list_str(blog_data)
        blog_item['reposts_count'] = int(blog_data['reposts_count'])
        blog_item['comments_count'] = int(blog_data['comments_count'])
        blog_item['attitudes_count'] = int(blog_data['attitudes_count'])
        return blog_item

    @staticmethod
    def responsebody_to_json(response):
        return json.loads(response.body)

    @staticmethod
    def url_param_to_map(url):
        param = url.split('?')[1]
        param = urllib.parse.parse_qs(param)
        return param

    @staticmethod
    def cleanDate(str_data):
        bs = BeautifulSoup(str_data, "html.parser")
        return bs.text

    @staticmethod
    def get_pic_list_str(data):
        s = ''
        if 'pics' in data.keys():
            length = len(data['pics'])
            for i in range(length):
                pic = data['pics'][i]
                pic_url = pic['url']
                s += pic_url
                if i < length - 1:
                    s += ','
        return s
