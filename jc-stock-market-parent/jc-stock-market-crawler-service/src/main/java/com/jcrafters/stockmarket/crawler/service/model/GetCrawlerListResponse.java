package com.jcrafters.stockmarket.crawler.service.model;

import com.jcrafters.stockmarket.crawler.service.dto.StockDataFeedDto;

import java.util.List;

public class GetCrawlerListResponse {

    private List<StockDataFeedDto> stockDataFeeds;

    public GetCrawlerListResponse() {
    }

    public GetCrawlerListResponse(List<StockDataFeedDto> stockDataFeeds) {
        this.stockDataFeeds = stockDataFeeds;
    }

    public List<StockDataFeedDto> getStockDataFeeds() {
        return stockDataFeeds;
    }

    public void setStockDataFeeds(List<StockDataFeedDto> stockDataFeeds) {
        this.stockDataFeeds = stockDataFeeds;
    }
}
