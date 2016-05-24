FROM sinhasonalkumar/java8:v1

LABEL app.name="DOCKERLOGBACKAPP" vesion="1.0" env=$ENV

WORKDIR /app/workdir

ENV DockerLogbackApp.log.path=/var/log/DockerLogbackApp.log

ENV JAVA_OPTS="-Xms512m -Xmx512m"

ADD ./target/DockerLogbackApp-0.1.0.jar /var/app/bin/DockerLogbackApp.jar

EXPOSE 8080

ENTRYPOINT java $JAVA_OPTS -jar  /var/app/bin/DockerLogbackApp.jar
