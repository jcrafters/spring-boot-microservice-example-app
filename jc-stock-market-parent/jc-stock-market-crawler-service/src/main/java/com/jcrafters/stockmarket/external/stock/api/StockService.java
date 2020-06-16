package com.jcrafters.stockmarket.external.stock.api;

import com.jcrafters.stockmarket.external.stock.api.model.AddStockPriceRequest;
import com.jcrafters.stockmarket.external.stock.api.model.AddStockPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "stock-market-app")
public interface StockService {

    @PostMapping("api/stock/{stockName}/price")
    AddStockPriceResponse addStockPrice(AddStockPriceRequest request, @PathVariable("stockName") String stockName);

}
