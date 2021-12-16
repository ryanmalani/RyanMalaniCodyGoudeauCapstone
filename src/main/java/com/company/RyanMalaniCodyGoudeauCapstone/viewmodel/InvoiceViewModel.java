package com.company.RyanMalaniCodyGoudeauCapstone.viewmodel;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    // properties

    @Id
    private int id;
    @NotEmpty(message = "You must supply a value for name.")
    @Size(max = 80, message = "You must supply a value less than 80 characters.")
    private String name;
    @NotEmpty(message = "You must supply a value for street.")
    @Size(max = 30, message = "You must supply a value less than 30 characters.")
    private String street;
    @NotEmpty(message = "You must supply a value for city.")
    @Size(max = 30, message = "You must supply a value less than 30 characters.")
    private String city;
    @NotEmpty(message = "You must supply a value for state.")
    @Size(max = 30, message = "You must supply a value less than 30 characters.")
    private String state;
    @NotEmpty(message = "You must supply a value for zipcode.")
    @Size(min = 5, max = 5, message = "You must supply a value with exactly 5 digits.")
    private String zipcode;
    @NotEmpty(message = "You must supply a value for item type.")
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String item_type;
    private int item_id;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 3,fraction = 2)
    private BigDecimal unit_price;
    private int quantity;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 9,fraction = 2)
    private BigDecimal subtotal;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 3,fraction = 2)
    private BigDecimal tax;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 3,fraction = 2)
    private BigDecimal processing_fee;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 9,fraction = 2)
    private BigDecimal total;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return id == that.id && item_id == that.item_id && quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zipcode, that.zipcode) && Objects.equals(item_type, that.item_type) && Objects.equals(unit_price, that.unit_price) && Objects.equals(subtotal, that.subtotal) && Objects.equals(tax, that.tax) && Objects.equals(processing_fee, that.processing_fee) && Objects.equals(total, that.total) && Objects.equals(consoles, that.consoles) && Objects.equals(games, that.games) && Objects.equals(t_shirts, that.t_shirts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total, consoles, games, t_shirts);
    }


    // toString

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_type='" + item_type + '\'' +
                ", item_id=" + item_id +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", processing_fee=" + processing_fee +
                ", total=" + total +
                ", consoles=" + consoles +
                ", games=" + games +
                ", t_shirts=" + t_shirts +
                '}';
    }
}
