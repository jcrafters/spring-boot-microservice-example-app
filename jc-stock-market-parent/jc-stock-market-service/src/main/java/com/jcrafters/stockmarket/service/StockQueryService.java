package com.jcrafters.stockmarket.service;


import com.jcrafters.stockmarket.jpa.Stock;
import com.jcrafters.stockmarket.jpa.StockPrice;
import com.jcrafters.stockmarket.mapper.StockMapper;
import com.jcrafters.stockmarket.mapper.StockPriceMapper;
import com.jcrafters.stockmarket.repository.StockPriceRepository;
import com.jcrafters.stockmarket.repository.StockRepository;
import com.jcrafters.stockmarket.service.dto.StockPriceDto;
import com.jcrafters.stockmarket.service.model.GetStockPriceListResponse;
import com.jcrafters.stockmarket.service.model.GetStockPriceResponse;
import com.jcrafters.stockmarket.service.model.GetStockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@Service
@RequestMapping("api/stock")
public class StockQueryService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockPriceRepository stockPriceRepository;


    @GetMapping("{stockName}")
    public GetStockResponse getStock(@PathVariable("stockName") String stockName) {
        Optional<Stock> stockOpt = stockRepository.findByName(stockName);
        if (stockOpt.isPresent() == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found stock, name: " + stockName);
        }
        return new GetStockResponse(StockMapper.INSTANCE.toDto(stockOpt.get()));
    }

    @GetMapping("{stockName}/price")
    public GetStockPriceListResponse getStockPrices(@PathVariable("stockName") String stockName) {
        Optional<Stock> stockOpt = stockRepository.findByName(stockName);
        if (stockOpt.isPresent() == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found stock, name: " + stockName);
        }
        Stock stock = stockOpt.get();
        List<StockPrice> all = stockPriceRepository.findByStockIdOrderByIdDesc(stock.getId());
        List<StockPriceDto> dtos = StockPriceMapper.INSTANCE.toDtos(all);
        return new GetStockPriceListResponse(dtos);
    }

    @GetMapping("{stockName}/price/{stockPriceId}")
    public GetStockPriceResponse getStockPrices(@PathVariable("stockName") String stockName, @PathVariable("stockPriceId") Long stockPriceId) {
        Optional<Stock> stockOpt = stockRepository.findByName(stockName);
        if (stockOpt.isPresent() == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found stock, name: " + stockName);
        }
        Stock stock = stockOpt.get();
        Optional<StockPrice> stockPriceOpt = stockPriceRepository.findByIdAndStockId(stockPriceId, stock.getId());

        if (stockPriceOpt.isPresent() == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found stock price, id: " + stockPriceId);
        }
        StockPrice stockPrice = stockPriceOpt.get();
        return new GetStockPriceResponse(StockPriceMapper.INSTANCE.toDto(stockPrice));
    }

}
