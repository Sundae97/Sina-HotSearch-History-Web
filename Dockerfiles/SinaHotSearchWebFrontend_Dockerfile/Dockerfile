FROM nginx:1.17

ADD dist.tar.gz /
RUN rm -rf /usr/share/nginx/html/* && mv /dist/* /usr/share/nginx/html/

