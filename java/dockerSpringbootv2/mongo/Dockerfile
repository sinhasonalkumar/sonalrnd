FROM sinhasonalkumar/mongodbdocker:v1

ADD ./mongod.conf /var/mongo/config/mongod.conf

RUN mkdir /var/mongo/log && mkdir /var/mongo/db

ENTRYPOINT mongod --config /var/mongo/config/mongod.conf

#RUN mongod --config /var/mongo/config/mongod.conf