from scrapy import cmdline
cmdline.execute("scrapy crawl SinaHotSearchPySpider".split());
#
# from bs4 import BeautifulSoup
# s = '''<a  href="https://m.weibo.cn/search?containerid=231522type%3D1%26t%3D10%26q%3D%23%E5%B0%8F%E7%BA%A2%E8%A2%84
# %23&luicode=10000011&lfid=100103type%3D1%26t%3D10%26q%3D%E5%B0%8F%E7%BA%A2%E8%A2%84" data-hide=""><span
# class="surl-text">#小红袄#</span></a><a  href="https://m.weibo.cn/search?containerid=231522type%3D1%26t%3D10%26q%3D%23
# %E9%87%91%E6%B5%B7%23&luicode=10000011&lfid=100103type%3D1%26t%3D10%26q%3D%E5%B0%8F%E7%BA%A2%E8%A2%84"
# data-hide=""><span class="surl-text">#金海#</span></a> 《新世界》小红袄就是十七，各位都猜到了吗，猜了大半部剧的小红袄，终于解开谜底了<span
# class="url-icon"><img alt=[笑cry] src="//h5.sinaimg.cn/m/emoticon/icon/default/d_xiaoku-d320324f00.png"
# style="width:1em; height:1em;" /></span> '''
#
# bs = BeautifulSoup(s, "html.parser")
# print(bs.text)