package com.jcrafters.stockmarket.service.model;

import com.jcrafters.stockmarket.service.dto.StockPriceDto;

public class AddStockPriceRequest {

    private StockPriceDto stockPrice;

    public AddStockPriceRequest() {
    }

    public StockPriceDto getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }
}
