# -*- coding: utf-8 -*-
import scrapy
import json
import urllib.parse
import datetime
import time
from sina_hotsearch_history_scrapy.items import HotSearchList, HotSearchListItem, HotSearchRank, HotSearchBlogItem


class SinaHotSearchPySpider(scrapy.Spider):
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
        start_time = start_time - datetime.timedelta(seconds=start_time.second) - datetime.timedelta(seconds=start_time.microsecond)
        item = HotSearchList()
        item['time'] = start_time
        yield item
        yield scrapy.Request(
            url=self.get_hotsearch_list_url.format(DISPLAY_TIME_PLACEHOLDER=hotsearch_start_time),
            callback=self.parse_get_hotsearch_list
        )
        pass

    def parse_get_hotsearch_list(self, response):
        response_body = self.responsebody_to_json(response)
        hotsearch_list = response_body['data']['cards'][0]['card_group']
        # del hotsearch_list[3]  # 移除推荐
        # del hotsearch_list[0]  # 移除置顶
        i = 0
        for item in enumerate(hotsearch_list):
            hotsearch_list_item = HotSearchListItem()
            if 'desc_extr' not in item.keys():  # 置顶
                continue
            elif 'promotion' in item.keys():    # 推荐广告
                continue

            hotsearch_list_item['hotsearch_id'] = self.hotsearch_list_id
            hotsearch_list_item['hotsearch_rank'] = i
            hotsearch_list_item['icon'] = item['icon'] if 'icon' in item.keys() else ''
            hotsearch_list_item['desc'] = item['desc']
            hotsearch_list_item['desc_extr'] = int(item['desc_extr'])
            hotsearch_list_item['scheme'] = item['scheme']

            scheme_url = item['scheme']
            param_map = self.url_param_to_map(scheme_url)
            url_param = urllib.parse.urlencode({"containerid": param_map["containerid"][0]})
            detail_url = self.get_hotsearch_detail_url.format(URL_PARAM=url_param)

            hotsearch_list_item['detail_url'] = detail_url

            yield hotsearch_list_item

            # yield scrapy.Request(
            #     url=detail_url,
            #     callback=self.parse_get_hotsearch_detail,
            #     meta={'index': i}
            # )
            i += 1
        pass

    def parse_get_hotsearch_detail(self, response):
        index = response.meta['index']
        response_body = self.responsebody_to_json(response)
        try:
            s = str(index) + " --> " + str(response_body['data']['cardlistInfo']['cardlist_title'])
        except (KeyError, UnboundLocalError):
            print(response_body)
        pass

    @staticmethod
    def parse_to_hotsearch_list(time, data):
        hotsearch_list = data['cards'][0]['card_group']
        resultList = []
        for i, item in enumerate(hotsearch_list):
            hotsearch = HotSearchListItem()
            hotsearch['time'] = time
            hotsearch['icon'] = item.icon
            hotsearch['desc'] = hotsearch_list
        pass

    @staticmethod
    def parse_to_hostsearch_list_detail_item(data):
        pass

    @staticmethod
    def responsebody_to_json(response):
        return json.loads(response.body)

    @staticmethod
    def url_param_to_map(url):
        param = url.split('?')[1]
        param = urllib.parse.parse_qs(param)
        return param
