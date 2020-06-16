package com.jcrafters.stockmarket.repository;

import com.jcrafters.stockmarket.jpa.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

    List<StockPrice> findByStockIdOrderByIdDesc(Long stockId);

    Optional<StockPrice> findByIdAndStockId(Long id, Long stockId);

}
