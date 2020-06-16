package com.jcrafters.stockmarket.external.stock.api.model;

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

    @Override
    public String toString() {
        return "AddStockPriceResponse{" +
                "stockPrice=" + stockPrice +
                '}';
    }
}
