package com.jcrafters.stockmarket.service;


import com.jcrafters.stockmarket.jpa.Stock;
import com.jcrafters.stockmarket.jpa.StockPrice;
import com.jcrafters.stockmarket.mapper.StockPriceMapper;
import com.jcrafters.stockmarket.repository.StockPriceRepository;
import com.jcrafters.stockmarket.repository.StockRepository;
import com.jcrafters.stockmarket.service.dto.StockPriceDto;
import com.jcrafters.stockmarket.service.model.AddStockPriceRequest;
import com.jcrafters.stockmarket.service.model.AddStockPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@Service
@RequestMapping("api/stock")
public class StockCommandService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @PostMapping("{stockName}/price")
    public AddStockPriceResponse addStockPrice(AddStockPriceRequest request, @PathVariable("stockName") String stockName) {
        Optional<Stock> stockOpt = stockRepository.findByName(stockName);
        if (stockOpt.isPresent() == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found stock, name: " + stockName);
        }
        Stock stock = stockOpt.get();

        StockPriceDto stockPriceDto = request.getStockPrice();
        StockPrice stockPrice = StockPriceMapper.INSTANCE.toJpa(stockPriceDto);
        stockPrice.setStock(stock);
        stockPrice = stockPriceRepository.save(stockPrice);
        return new AddStockPriceResponse(StockPriceMapper.INSTANCE.toDto(stockPrice));
    }


}
