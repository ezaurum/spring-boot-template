FROM ubuntu:14.04
RUN apt-get install software-properties-common -y
RUN add-apt-repository ppa:openjdk-r/ppa -y
RUN apt-get update -y
RUN apt-get install openjdk-8-jdk -y
ADD build/libs/admin-0.0.1-SNAPSHOT.jar /var/www/admin-0.0.1-SNAPSHOT.jar
WORKDIR /var/www
CMD java -jar /var/www/admin-0.0.1-SNAPSHOT.jar

