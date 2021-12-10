package com.company.RyanMalaniCodyGoudeauCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Sales_Tax_Rate {

    // properties

    private String state;
    private BigDecimal rate;

    // getters and setters

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales_Tax_Rate that = (Sales_Tax_Rate) o;
        return Objects.equals(state, that.state) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    // toString

    @Override
    public String toString() {
        return "Sales_Tax_Rate{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
