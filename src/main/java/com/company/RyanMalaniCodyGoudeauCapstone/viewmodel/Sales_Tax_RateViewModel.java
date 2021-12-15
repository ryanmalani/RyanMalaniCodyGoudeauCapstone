package com.company.RyanMalaniCodyGoudeauCapstone.viewmodel;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Sales_Tax_Rate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Sales_Tax_RateViewModel {

    // properties

    @NotEmpty(message = "You must supply a value for state.")
    @Size(min = 2, max = 2, message = "You must supply the two letter abbreviation.")
    private String state;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 1,fraction = 2)
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
