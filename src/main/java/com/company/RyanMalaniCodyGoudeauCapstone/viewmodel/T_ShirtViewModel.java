package com.company.RyanMalaniCodyGoudeauCapstone.viewmodel;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class T_ShirtViewModel {

    @Id
    private int id;
    @NotEmpty(message = "You must supply a value for size.")
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String size;
    @NotEmpty(message = "You must supply a value for color.")
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String color;
    @NotEmpty(message = "You must supply a value for description.")
    @Size(max = 255, message = "You must supply a value less than 255 characters.")
    private String description;
    @NotEmpty(message = "You must supply a value for price.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(3, 2)
    private BigDecimal price;
    @NotEmpty(message = "You must supply a value for quantity.")
    @Size(max = 11, message = "You must supply a value less than 11 digits.")
    private int quantity;

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
