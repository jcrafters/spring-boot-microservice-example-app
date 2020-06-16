package com.jcrafters.stockmarket.repository;

import com.jcrafters.stockmarket.jpa.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByName(String name);

}
