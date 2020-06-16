package com.jcrafters.stockmarket.external.stock.api.model;

import java.math.BigDecimal;

public class StockPriceDto {

    private Long id;
    private BigDecimal amount;
    private String currency;
    private String amountDatetime;

    public StockPriceDto() {
    }

    private StockPriceDto(Builder builder) {
        setAmount(builder.amount);
        setCurrency(builder.currency);
        setAmountDatetime(builder.amountDatetime);
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


    public static final class Builder {
        private BigDecimal amount;
        private String currency;
        private String amountDatetime;

        public Builder() {
        }

        public Builder amount(BigDecimal val) {
            amount = val;
            return this;
        }

        public Builder currency(String val) {
            currency = val;
            return this;
        }

        public Builder amountDatetime(String val) {
            amountDatetime = val;
            return this;
        }

        public StockPriceDto build() {
            return new StockPriceDto(this);
        }
    }

    @Override
    public String toString() {
        return "StockPriceDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", amountDatetime='" + amountDatetime + '\'' +
                '}';
    }
}
