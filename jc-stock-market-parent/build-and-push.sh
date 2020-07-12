#!/bin/bash

#chmod +x build-images.sh 

mvn clean package
docker image build -t jcrafters/jc-stock-market-eureka-app jc-stock-market-eureka-app 
docker image build -t jcrafters/jc-stock-market-config-app jc-stock-market-config-app
docker image build -t jcrafters/jc-stock-market-gateway-app jc-stock-market-gateway-app
docker image build -t jcrafters/jc-stock-market-crawler-app jc-stock-market-crawler-app
docker image build -t jcrafters/jc-stock-market-app jc-stock-market-app


docker push jcrafters/jc-stock-market-eureka-app
docker push jcrafters/jc-stock-market-config-app
docker push jcrafters/jc-stock-market-gateway-app
docker push jcrafters/jc-stock-market-crawler-app
docker push jcrafters/jc-stock-market-app