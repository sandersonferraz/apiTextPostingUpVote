#!/bin/bash -e
clear

# Criar uma container mongoDB
docker run --name mangodb -d  -p 27017:27017 mongo:latest

# Criar um container para app-client (Reactjs) 
docker-compose up -d --build

# executar a aplicação spring boot .jar
java -jar target/textPostUpvote-0.0.1-SNAPSHOT.jar


