package com.company.RyanMalaniCodyGoudeauCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class T_Shirt {

    // properties

    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    //constructor
    public T_Shirt(){}

    //default constructor
    public T_Shirt(String size, String color, String description, BigDecimal price, int quantity, int id){

        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T_Shirt t_shirt = (T_Shirt) o;
        return getId() == t_shirt.getId() && getQuantity() == t_shirt.getQuantity() && Objects.equals(getSize(), t_shirt.getSize()) && Objects.equals(getColor(), t_shirt.getColor()) && Objects.equals(getDescription(), t_shirt.getDescription()) && Objects.equals(getPrice(), t_shirt.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

    // toString

    @Override
    public String toString() {
        return "T_Shirt{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
