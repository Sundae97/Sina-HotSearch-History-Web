# -*- coding: utf-8 -*-
import os
import configparser

__rootDir = os.path.split(os.path.realpath(__file__))[0]
__configFilePath = os.path.join(__rootDir, 'config.txt')


def get_config_value(section, option):
    config = configparser.ConfigParser()
    config.read(__configFilePath)
    return config.get(section=section, option=option)


crawl_blog_num = int(get_config_value('config', 'crawl_blog_num'))
expiration_time = int(get_config_value('config', 'expiration_time'))  # 在Redis中存储热搜标题的过期时间 秒
