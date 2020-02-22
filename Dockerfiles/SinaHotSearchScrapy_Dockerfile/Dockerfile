FROM python:3.7

ADD sina-hotsearch-history-scrapy.tar.gz /
RUN cd sina-hotsearch-history-scrapy && \
    pip3 install -r requirements.txt -i https://pypi.tuna.tsinghua.edu.cn/simple
WORKDIR /sina-hotsearch-history-scrapy/sina_hotsearch_history_scrapy

CMD ["python3", "__init__.py"]
