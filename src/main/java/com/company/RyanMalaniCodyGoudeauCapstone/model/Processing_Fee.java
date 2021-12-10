package com.company.RyanMalaniCodyGoudeauCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Processing_Fee {

    // properties

    private String productType;
    private BigDecimal fee;

    // getters and setters

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processing_Fee that = (Processing_Fee) o;
        return Objects.equals(productType, that.productType) && Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }

    // toString

    @Override
    public String toString() {
        return "Processing_Fee{" +
                "productType='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
