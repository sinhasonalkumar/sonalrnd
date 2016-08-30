FROM 524369662707.dkr.ecr.us-west-2.amazonaws.com/mongo

WORKDIR /app/workdir

ADD ./mongod.conf /var/mongo/config/mongod.conf

ADD ./replicaset.key /var/mongo/sharedKey/replicaset.key

ENTRYPOINT ["mongod"]

CMD ["--config","/var/mongo/config/mongod.conf"]