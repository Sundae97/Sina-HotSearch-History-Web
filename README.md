# Sina-HotSearch-History-Web
新浪热搜历史记录

| 文件夹名 | 作用 |
| --- | --- |
| config | 各种需要用到的配置文件 |
| Dockerfiles |应用构建Docker镜像的dockerfile |
| sina-hotsearch-history-frontend(Need to modify) |基于Vue的网站前端页面项目 |
| sina-hotsearch-history-scrapy | 基于scrapy的爬虫 |
| sina-hotsearch-history-backend| 基于SpringBoot的网站后端|

 

## Dockerfile构建
//TODO
`docker build --rm -f "Dockerfile" -t sinahotsearchwebbackenddockerfile:1.0 "."`

`docker build --rm -f "Dockerfile" -t sina-hotsearch-history-scrapy:1.0 "."`



## 启动步骤
### step 1:启动redis
`docker run -itd --name redis-test --restart=always -p 6379:6379 redis --requirepass "123456"`

### step 2:启动mysql
`docker run -d -p 3306:3306 --restart=always --privileged=true -v /root/mysql/conf/mysql5.6.conf:/etc/mysql/my.cnf -v /root/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name mysql-test mysql:5.7`

| 参数 | 用途 |
|---|---|
| -v /root/mysql/conf/mysql5.6.conf:/etc/mysql/my.cnf | 映射mysql配置文件 |
| -v /root/mysql/data:/var/lib/mysql | 映射mysql数据文件，便于持久化和备份 |

### step 3:启动爬虫应用
`docker run -dit --name sina-hotsearch-scrapy -e TZ=Asia/Shanghai -v /root/sina-hotsearch-web/spider/log:/sina-hotsearch-history-scrapy/sina_hotsearch_history_scrapy/log -v /root/sina-hotsearch-web/spider/config.txt:/sina-hotsearch-history-scrapy/sina_hotsearch_history_scrapy/config.txt [镜像名]`

| 参数 | 用途 |
|---|---|
| -e TZ=Asia/Shanghai | 设置docker容器内时区 |
| -v /root/sina-hotsearch-web/spider/log:/sina-hotsearch-history-scrapy/sina_hotsearch_history_scrapy/log | 映射log存储位置 |
| -v /root/sina-hotsearch-web/spider/config.txt:/sina-hotsearch-history-scrapy/sina_hotsearch_history_scrapy/config.txt | 映射配置文件(Mysql,Redis连接信息) |

### step 4:启动后端应用

`docker run -dit --name hotsearch-web -e TZ=Asia/Shanghai -v /root/sina-hotsearch-web/application.yml:/app/application.yml -p 8081:8081 [镜像名]`

| 参数                                                         | 用途                   |
| ------------------------------------------------------------ | ---------------------- |
| -e TZ=Asia/Shanghai                                          | 设置docker容器内时区   |
| -v /root/sina-hotsearch-web/application.yml:/app/application.yml | 映射SpringBoot配置文件 |

### 

## TODO

- [x] 增加配置文件，用于docker启动时映射配置文件，需要修改程序
- [ ] 优化前端应用的代码结构 （不太熟悉前端，写的实在是太水了😑）
- [ ] ~~增加前端应用docker镜像~~
- [ ] 优化前端项目，服务器带宽太低，网页加载有些慢。
- [ ] 美化前端UI
- [ ] 增加后端log配置
- [x] 测试(基本功能实现)

[http://hotsearch.asundae.com/](http://hotsearch.asundae.com/)
