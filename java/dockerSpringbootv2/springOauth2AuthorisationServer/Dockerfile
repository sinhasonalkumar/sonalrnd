FROM sinhasonalkumar/java8:v1

WORKDIR /app/workdir

ADD ./target/springOauth2AuthorisationServer-0.1.0.jar /var/app/bin/as.jar

EXPOSE 8080

ENTRYPOINT java -jar  /var/app/bin/as.jar