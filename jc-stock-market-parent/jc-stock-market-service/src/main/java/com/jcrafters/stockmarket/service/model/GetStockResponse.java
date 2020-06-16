package com.jcrafters.stockmarket.service.model;

import com.jcrafters.stockmarket.service.dto.StockDto;

public class GetStockResponse {

    private StockDto stock;

    public GetStockResponse() {
    }

    public GetStockResponse(StockDto stock) {
        this.stock = stock;
    }

    public StockDto getStock() {
        return stock;
    }

    public void setStock(StockDto stock) {
        this.stock = stock;
    }
}
