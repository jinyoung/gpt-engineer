FROM python:3.10-slim

RUN apt-get update \
 && apt-get install -y sudo tk tcl && apt-get install -y openjdk-17-jdk && apt-get install -y wget

RUN wget -q https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp
RUN mkdir ~/sw/ 
RUN tar xf /tmp/apache-maven-*.tar.gz -C ~/sw/
RUN rm /tmp/apache-maven-*.tar.gz
RUN mv ~/sw/apache-maven-* ~/sw/maven

RUN echo 'MAVEN_HOME=~/sw/maven' >> ~/.bashrc
RUN echo 'M2_HOME=$MAVEN_HOME' >> ~/.bashrc
RUN echo 'PATH=$MAVEN_HOME/bin:${PATH}' >> ~/.bashrc


WORKDIR /app

COPY . .
COPY docker/entrypoint.sh ./entrypoint.sh

RUN sudo pip install -e .

ENTRYPOINT ["bash", "/app/entrypoint.sh"]
