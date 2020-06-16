
package com.jcrafters.stockmarket.jpa;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;


@Entity(name = "StockPrice")
@Table(name = "stock_price")
public class StockPrice implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "stock_priceSEQ", sequenceName = "stock_price_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_priceSEQ")
    private Long id;

    @Column(name = "amount", nullable = false, unique = false)
    private BigDecimal amount;

    @Column(name = "currency", length = 255, nullable = true, unique = false)
    private String currency;

    @Column(name = "amount_date", nullable = true, unique = false)
    private LocalDate amountDate;

    @Column(name = "amount_time", nullable = true, unique = false)
    private LocalTime amountTime;

    @Column(name = "amount_datetime", nullable = false, unique = false)
    private OffsetDateTime amountDatetime;

    @Column(name = "creation_date", nullable = false, unique = false)
    private OffsetDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Stock stock;

    @Column(name = "stock_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Long stockId;

    public StockPrice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getAmountDate() {
        return amountDate;
    }

    public void setAmountDate(LocalDate amountDate) {
        this.amountDate = amountDate;
    }

    public LocalTime getAmountTime() {
        return amountTime;
    }

    public void setAmountTime(LocalTime amountTime) {
        this.amountTime = amountTime;
    }

    public OffsetDateTime getAmountDatetime() {
        return amountDatetime;
    }

    public void setAmountDatetime(OffsetDateTime amountDatetime) {
        this.amountDatetime = amountDatetime;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @PrePersist
    public void prePersist() {
        OffsetDateTime now = OffsetDateTime.now(Clock.systemDefaultZone());
        if (creationDate == null) {
            creationDate = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        OffsetDateTime now = OffsetDateTime.now(Clock.systemDefaultZone());
        if (creationDate == null) {
            creationDate = now;
        }
    }
}
