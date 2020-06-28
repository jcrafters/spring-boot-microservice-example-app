#!/bin/bash

#chmod +x build-images.sh 

mvn clean package
docker image build -t jc-stock-market-eureka-app jc-stock-market-eureka-app 
docker image build -t jc-stock-market-config-app jc-stock-market-config-app
docker image build -t jc-stock-market-gateway-app jc-stock-market-gateway-app
docker image build -t jc-stock-market-crawler-app jc-stock-market-crawler-app
docker image build -t jc-stock-market-app jc-stock-market-app