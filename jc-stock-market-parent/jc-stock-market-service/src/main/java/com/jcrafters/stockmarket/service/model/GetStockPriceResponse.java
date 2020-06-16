package com.jcrafters.stockmarket.service.model;

import com.jcrafters.stockmarket.service.dto.StockPriceDto;

public class GetStockPriceResponse {

    private StockPriceDto stockPrice;

    public GetStockPriceResponse() {
    }

    public GetStockPriceResponse(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }

    public StockPriceDto getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }
}
