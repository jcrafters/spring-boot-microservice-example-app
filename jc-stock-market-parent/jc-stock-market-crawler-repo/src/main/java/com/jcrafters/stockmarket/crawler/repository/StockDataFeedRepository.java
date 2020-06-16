package com.jcrafters.stockmarket.crawler.repository;

import com.jcrafters.stockmarket.crawler.jpa.StockDataFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDataFeedRepository extends JpaRepository<StockDataFeed, Long> {


}
