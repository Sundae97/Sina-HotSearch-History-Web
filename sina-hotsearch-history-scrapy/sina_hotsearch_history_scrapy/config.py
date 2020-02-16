# -*- coding: utf-8 -*-
import os
import configparser

crawl_blog_num = 2

__rootDir = os.path.split(os.path.realpath(__file__))[0]
__configFilePath = os.path.join(__rootDir, 'config.txt')


def get_config_value(section, option):
    config = configparser.ConfigParser()
    config.read(__configFilePath)
    return config.get(section=section, option=option)
