FROM sinhasonalkumar/java8:v1

WORKDIR /app/workdir

ADD ./target/SecuredRestServices-0.1.0.jar /var/app/bin/as.jar

EXPOSE 8080

ENTRYPOINT java -jar  /var/app/bin/as.jar