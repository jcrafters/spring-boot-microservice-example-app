package com.jcrafters.stockmarket.service.model;

import com.jcrafters.stockmarket.service.dto.StockPriceDto;

import java.util.List;

public class GetStockPriceListResponse {

    private List<StockPriceDto> stockPrices;

    public GetStockPriceListResponse() {
    }

    public GetStockPriceListResponse(List<StockPriceDto> stockPrices) {
        this.stockPrices = stockPrices;
    }

    public List<StockPriceDto> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(List<StockPriceDto> stockPrices) {
        this.stockPrices = stockPrices;
    }
}
