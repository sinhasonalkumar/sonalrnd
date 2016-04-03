FROM sinhasonalkumar/java8:v1

WORKDIR /app/workdir

ADD . /app/src

RUN \
#	apt-get update && \
	apt-get install software-properties-common \
	wget -y && \
	wget http://apache.cs.utah.edu/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz && \
	tar -xvf apache-maven-3.3.9-bin.tar.gz && \
	ln -s /app/workdir/apache-maven-3.3.9/bin/mvn /usr/local/bin/mvn && \
	rm -rf apache-maven-3.3.9-bin.tar.gz
