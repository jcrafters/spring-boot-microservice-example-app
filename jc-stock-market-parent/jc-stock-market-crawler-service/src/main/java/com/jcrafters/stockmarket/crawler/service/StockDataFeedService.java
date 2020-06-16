package com.jcrafters.stockmarket.crawler.service;


import com.jcrafters.stockmarket.crawler.jpa.StockDataFeed;
import com.jcrafters.stockmarket.crawler.mapper.StockDataFeedMapper;
import com.jcrafters.stockmarket.crawler.repository.StockDataFeedRepository;
import com.jcrafters.stockmarket.crawler.service.model.CrawlerData;
import com.jcrafters.stockmarket.crawler.service.model.GetCrawlerListResponse;
import com.jcrafters.stockmarket.external.stock.api.model.AddStockPriceRequest;
import com.jcrafters.stockmarket.external.stock.api.model.AddStockPriceResponse;
import com.jcrafters.stockmarket.external.stock.api.model.StockPriceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RestController
@Service
@Transactional
@RequestMapping("api/stockdatafeed")
public class StockDataFeedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockDataFeedService.class.toString());

    @Autowired
    private StockDataFeedRepository stockDataFeedRepository;
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping
    public GetCrawlerListResponse getCrawlerList() {
        List<StockDataFeed> all = stockDataFeedRepository.findAll();
        return new GetCrawlerListResponse(StockDataFeedMapper.INSTANCE.toDtos(all));
    }


    @PostMapping("{stockDataFeedId}/data")
    public void testAddStockPriceIntegration1(@RequestBody CrawlerData crawlerData, @PathVariable("stockDataFeedId") Long stockDataFeedId) {
        LOGGER.info("data");
        StockDataFeed stockDataFeed = stockDataFeedRepository.findById(stockDataFeedId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found StockDataFeed, id: " + stockDataFeedId));

        String stockName = stockDataFeed.getStockName();
        String serviceUrl = "http://localhost:18080/api/stock/" + stockName + "/price";
        AddStockPriceRequest request = new AddStockPriceRequest();
        request.setStockPrice(new StockPriceDto.Builder().amount(crawlerData.getAmount()).amountDatetime(crawlerData.getAmountDate() + "T" + crawlerData.getAmountTime() + "Z").build());


        //TODO INTEGRACJA 1
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AddStockPriceResponse> addStockPriceResponseResponseEntity = restTemplate.postForEntity(serviceUrl, request, AddStockPriceResponse.class);
        AddStockPriceResponse body = addStockPriceResponseResponseEntity.getBody();

        LOGGER.info(body.toString());
    }

    @PostMapping("{stockDataFeedId}/ribbon/data")
    public void testAddStockPriceIntegration2(@RequestBody CrawlerData crawlerData, @PathVariable("stockDataFeedId") Long stockDataFeedId) {
        LOGGER.info("ribbon/data");
        StockDataFeed stockDataFeed = stockDataFeedRepository.findById(stockDataFeedId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found StockDataFeed, id: " + stockDataFeedId));

        String stockName = stockDataFeed.getStockName();
        ServiceInstance instance = loadBalancer.choose("stock-market-app");
        URI serviceUrl = URI.create(String.format("http://%s:%s/api/stock/%s/price", instance.getHost(), instance.getPort(), stockName));

        AddStockPriceRequest request = new AddStockPriceRequest();
        request.setStockPrice(new StockPriceDto.Builder().amount(crawlerData.getAmount()).amountDatetime(crawlerData.getAmountDate() + "T" + crawlerData.getAmountTime() + "Z").build());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AddStockPriceResponse> addStockPriceResponseResponseEntity = restTemplate.postForEntity(serviceUrl, request, AddStockPriceResponse.class);
        AddStockPriceResponse body = addStockPriceResponseResponseEntity.getBody();
        LOGGER.info(body.toString());
    }

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("{stockDataFeedId}/ribbon/resttemplate/data")
    public void testAddStockPriceIntegration3(@RequestBody CrawlerData crawlerData, @PathVariable("stockDataFeedId") Long stockDataFeedId) {
        LOGGER.info("ribbon/resttemplate/data");
        StockDataFeed stockDataFeed = stockDataFeedRepository.findById(stockDataFeedId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found StockDataFeed, id: " + stockDataFeedId));
        String stockName = stockDataFeed.getStockName();
        URI serviceUrl = URI.create(String.format("http://stock-market-app/api/stock/%s/price", stockName));
        AddStockPriceRequest request = new AddStockPriceRequest();
        request.setStockPrice(new StockPriceDto.Builder().amount(crawlerData.getAmount()).amountDatetime(crawlerData.getAmountDate() + "T" + crawlerData.getAmountTime() + "Z").build());
        ResponseEntity<AddStockPriceResponse> addStockPriceResponseResponseEntity = restTemplate.postForEntity(serviceUrl, request, AddStockPriceResponse.class);
        AddStockPriceResponse body = addStockPriceResponseResponseEntity.getBody();
        LOGGER.info(body.toString());
    }

    @PostMapping("{crawlerId}/data/test")
    public void testGetCrawlerData() {


    }


}
