package com.company.RyanMalaniCodyGoudeauCapstone.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {

    // properties

    @Id
    private int id;
    @NotEmpty(message = "You must supply a value for model.")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String model;
    @NotEmpty(message = "You must supply a value for manufacturer.")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String manufacturer;
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String memory_amount;
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String processor;
    @NotEmpty(message = "You must supply a value for price.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(3, 2)
    private BigDecimal price;
    @NotEmpty(message = "You must supply a value for quantity.")
    @Size(max = 11, message = "You must supply a value less than 11 digits.")
    @Min(value = 0, message = "Quantity cannot be negative.")
    private int quantity;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        Console console = (Console) o;
        return getId() == console.getId() && getQuantity() == console.getQuantity() && Objects.equals(getModel(), console.getModel()) && Objects.equals(getManufacturer(), console.getManufacturer()) && Objects.equals(getMemory_amount(), console.getMemory_amount()) && Objects.equals(getProcessor(), console.getProcessor()) && Objects.equals(getPrice(), console.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getManufacturer(), getMemory_amount(), getProcessor(), getPrice(), getQuantity());
    }

    // toString

    @Override
    public String toString() {
        return "Console{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memory_amount='" + memory_amount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
