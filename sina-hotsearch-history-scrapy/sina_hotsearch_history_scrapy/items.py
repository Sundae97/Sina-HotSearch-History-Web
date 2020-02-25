# -*- coding: utf-8 -*-

import scrapy


class HotSearchList(scrapy.Item):
    time = scrapy.Field()
    pass


class HotSearchRank(scrapy.Item):
    hotsearch_id = scrapy.Field()
    hotsearch_detail_id = scrapy.Field()
    rank = scrapy.Field()
    pass


class HotSearchListItem(scrapy.Item):

    hotsearch_id = scrapy.Field()
    hotsearch_rank = scrapy.Field()
    # 图标URL
    # data.cards[0].card_group[1].icon
    icon = scrapy.Field()

    # 标题
    # data.cards[0].card_group[1].desc
    desc = scrapy.Field()

    # 搜索热度值
    # data.cards[0].card_group[1].desc_extr
    desc_extr = scrapy.Field()

    # 详情页URL
    # data.cards[0].card_group[1].scheme
    scheme = scrapy.Field()

    # 详情页json请求URL
    detail_url = scrapy.Field()
    pass


class HotSearchBlogItem(scrapy.Item):

    hotsearch_item_id = scrapy.Field()

    # 用户的ID
    # data.cards[0].card_group[0].user.id
    user_id = scrapy.Field()

    # 用户显示的名字
    # data.cards[0].card_group[0].user.screen_name
    screen_name = scrapy.Field()

    # 用户显示的头像url
    # data.cards[0].card_group[0].user.avatar_hd
    user_head_img = scrapy.Field()

    # 微博正文ID
    # data.cards[0].mblog.id
    mblog_id = scrapy.Field()

    # 微博文本内容
    # data.cards[0].mblog.text
    text = scrapy.Field()

    # 图片ID列表的字符串
    # data.cards[0].mblog.pics[0].pid
    pic_urls_str = scrapy.Field()

    # 转发量
    # data.cards[0].mblog.reposts_count
    reposts_count = scrapy.Field()

    # 评论量
    # data.cards[0].mblog.comments_count
    comments_count = scrapy.Field()

    # 点赞量
    # data.cards[0].mblog.attitudes_count
    attitudes_count = scrapy.Field()
    pass
