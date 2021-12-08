package com.company.RyanMalaniCodyGoudeauCapstone.viewmodel;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    // properties

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
    @NotEmpty(message = "You must supply a value for item id.")
    @Size(max = 11, message = "You must supply a value less than 11 characters.")
    private int item_id;
    @NotEmpty(message = "You must supply a value for unit price.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(3, 2)
    private BigDecimal unit_price;
    @NotEmpty(message = "You must supply a value for quantity.")
    @Size(max = 11, "You must supply a value less than 11 characters.")
    private int quantity;
    @NotEmpty(message = "You must supply a value for subtotal.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(9, 2)
    private BigDecimal subtotal;
    @NotEmpty(message = "You must supply a value for tax.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(3, 2)
    private BigDecimal tax;
    @NotEmpty(message = "You must supply a value for processing fee.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(3, 2)
    private BigDecimal processing_fee;
    @NotEmpty(message = "You must supply a value for total.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(9, 2)
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
        Invoice invoice = (Invoice) o;
        return getId() == invoice.getId() && getItem_id() == invoice.getItem_id() && getQuantity() == invoice.getQuantity() && Objects.equals(getName(), invoice.getName()) && Objects.equals(getStreet(), invoice.getStreet()) && Objects.equals(getCity(), invoice.getCity()) && Objects.equals(getState(), invoice.getState()) && Objects.equals(getZipcode(), invoice.getZipcode()) && Objects.equals(getItem_type(), invoice.getItem_type()) && Objects.equals(getUnit_price(), invoice.getUnit_price()) && Objects.equals(getSubtotal(), invoice.getSubtotal()) && Objects.equals(getTax(), invoice.getTax()) && Objects.equals(getProcessing_fee(), invoice.getProcessing_fee()) && Objects.equals(getTotal(), invoice.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItem_type(), getItem_id(), getUnit_price(), getQuantity(), getSubtotal(), getTax(), getProcessing_fee(), getTotal());
    }

    // toString

    @Override
    public String toString() {
        return "Invoice{" +
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
                '}';
    }
}
