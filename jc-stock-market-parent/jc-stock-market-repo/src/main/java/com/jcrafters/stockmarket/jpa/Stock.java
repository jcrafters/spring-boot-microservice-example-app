package com.jcrafters.stockmarket.jpa;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Stock")
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "stockSEQ", sequenceName = "stock_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stockSEQ")
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "creation_date", nullable = false, unique = false)
    private OffsetDateTime creationDate;

    @Column(name = "update_date", nullable = false, unique = false)
    private OffsetDateTime updateDate;

    @OneToMany(targetEntity = StockPrice.class, fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.REMOVE)
    private Set<StockPrice> stockPrices = new HashSet<StockPrice>();

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Set<StockPrice> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(Set<StockPrice> stockPrices) {
        this.stockPrices = stockPrices;
    }


    @PrePersist
    public void prePersist() {
        OffsetDateTime now = OffsetDateTime.now(Clock.systemDefaultZone());
        if (creationDate == null) {
            creationDate = now;
        }
        if (updateDate == null) {
            updateDate = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        OffsetDateTime now = OffsetDateTime.now(Clock.systemDefaultZone());
        if (creationDate == null) {
            creationDate = now;
        }
        updateDate = now;
    }
}
