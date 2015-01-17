FROM phusion/baseimage:0.9.15
MAINTAINER angeljcc <angeljcc@gmail.com>

ENV HOME /root

RUN apt-get update && apt-get install -y mysql-server mysql-client && apt-get install -y apache2 && apt-get clean && rm -rf /var/lib/apt/lists/*
 
ADD my.cnf /etc/mysql/my.cnf
RUN mkdir /etc/service/mysql
ADD mysql /etc/service/mysql/run
RUN chmod +x /etc/service/mysql/run

ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2


RUN rm -R /var/lib/mysql && \
	mkdir /var/lib/mysql && \
    mkdir /mnt/keys

VOLUME ["/var/lib/mysql", "/mnt/keys"]
 
RUN apt-get clean && \
	rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

EXPOSE 22 3306 8080 80 

CMD ["/usr/sbin/apache2","-D","FOREGROUND"]