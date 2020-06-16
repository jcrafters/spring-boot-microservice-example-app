package com.jcrafters.stockmarket.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class StockMarketGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockMarketGatewayApplication.class, args);
    }
}
