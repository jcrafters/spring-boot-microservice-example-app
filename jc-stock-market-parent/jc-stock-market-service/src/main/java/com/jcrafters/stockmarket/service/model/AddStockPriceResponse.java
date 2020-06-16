package com.jcrafters.stockmarket.service.model;

import com.jcrafters.stockmarket.service.dto.StockPriceDto;

public class AddStockPriceResponse {

    private StockPriceDto stockPrice;

    public AddStockPriceResponse() {
    }

    public AddStockPriceResponse(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }

    public StockPriceDto getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }
}
