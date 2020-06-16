package com.jcrafters.stockmarket.external.stock.api.model;

public class AddStockPriceRequest {

    private StockPriceDto stockPrice;

    public AddStockPriceRequest() {
    }

    public AddStockPriceRequest(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }

    public StockPriceDto getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(StockPriceDto stockPrice) {
        this.stockPrice = stockPrice;
    }
}
