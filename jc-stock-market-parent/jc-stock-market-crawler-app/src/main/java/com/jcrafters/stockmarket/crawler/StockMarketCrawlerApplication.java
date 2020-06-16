package com.jcrafters.stockmarket.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jcrafters.stockmarket")
public class StockMarketCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockMarketCrawlerApplication.class, args);
    }

}
