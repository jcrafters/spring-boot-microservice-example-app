package com.jcrafters.stockmarket.crawler.jpa;


import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;


@Entity(name = "StockDataFeed")
@Table(name = "stock_data_feed")
public class StockDataFeed implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "stock_data_feedSEQ", sequenceName = "stock_data_feed_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_data_feedSEQ")
    private Long id;

    @Column(name = "description", nullable = false, unique = false)
    private String description;

    @Column(name = "www", nullable = false, unique = false)
    private String www;

    @Column(name = "path_to_data", nullable = false, unique = false)
    private String pathToData;

    @Column(name = "stock_name", nullable = false, unique = false)
    private String stockName;

    @Column(name = "creation_date", nullable = false, unique = false)
    private OffsetDateTime creationDate;

    public StockDataFeed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getPathToData() {
        return pathToData;
    }

    public void setPathToData(String pathToData) {
        this.pathToData = pathToData;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
