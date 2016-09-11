FROM sinhasonalkumar/mongodbdocker:v1

RUN pwd

ADD config/mongod.conf /var/mongo/config/mongod.conf

RUN mkdir /var/mongo/log && mkdir /var/mongo/db

EXPOSE 27017

ENTRYPOINT ["mongod","--config","/var/mongo/config/mongod.conf"]
