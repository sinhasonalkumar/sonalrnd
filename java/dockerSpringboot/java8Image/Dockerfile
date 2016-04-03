FROM ubuntu

WORKDIR /data

RUN \
	echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
	apt-get update && \
	apt-get install software-properties-common \
	wget -y && \
	add-apt-repository -y ppa:webupd8team/java && \
	apt-get update && \
	apt-get install oracle-java8-set-default -y && \
	rm -rf /var/lib/apt/lists/* && \
	rm -rf /var/cache/oracle-jdk8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle


