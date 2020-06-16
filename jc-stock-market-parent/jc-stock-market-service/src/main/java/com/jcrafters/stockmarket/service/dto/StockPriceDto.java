package com.jcrafters.stockmarket.service.dto;

import java.math.BigDecimal;

public class StockPriceDto {

    private Long id;
    private BigDecimal amount;
    private String currency;
    private String amountDatetime;

    public StockPriceDto() {
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

    public String getAmountDatetime() {
        return amountDatetime;
    }

    public void setAmountDatetime(String amountDatetime) {
        this.amountDatetime = amountDatetime;
    }
}
