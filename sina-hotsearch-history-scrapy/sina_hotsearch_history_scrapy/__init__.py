import subprocess
import sys
import os
import time

sys.path.append('.')
import schedule
from scrapy import cmdline
import config
import logging

logging = logging.getLogger(__name__)


def job():
    os.popen("scrapy crawl SinaHotSearchPySpider")


if __name__ == '__main__':
    schedule.every(config.interval).minutes.do(job)
    while True:
        schedule.run_pending()
        time.sleep(1)

