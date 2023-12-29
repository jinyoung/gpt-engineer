FROM python:3.10-slim

RUN apt-get update \
 && apt-get install -y sudo tk tcl && apt-get install -y openjdk-17-jdk && apt-get -y install maven

WORKDIR /app

COPY . .
COPY docker/entrypoint.sh ./entrypoint.sh

RUN sudo pip install -e .

ENTRYPOINT ["bash", "/app/entrypoint.sh"]
