FROM python:3.7

RUN mkdir /sina-hotsearch-spider
COPY ../../sina-hotsearch-history-scrapy /sina-hotsearch-spider
RUN pip3 install /sina-hotsearch-spider/requirements.txt -i https://pypi.tuna.tsinghua.edu.cn/simple pip -U
WORKDIR /sina-hotsearch-spider/sina_hotsearch_history_scrapy

CMD ["python3", "__init__.py"]

#TODO Test