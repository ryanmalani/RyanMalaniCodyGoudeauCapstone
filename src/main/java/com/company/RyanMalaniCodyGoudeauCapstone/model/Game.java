package com.company.RyanMalaniCodyGoudeauCapstone.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Game {

    // properties

    @Id
    private int id;
    @NotEmpty(message = "You must supply a value for title.")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String title;
    @NotEmpty(message = "You must supply a value for esrb rating.")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String esrb_rating;
    @NotEmpty(message = "You must supply a value for description.")
    @Size(max = 255, message = "You must supply a value less than 255 characters.")
    private String description;
    @NotEmpty(message = "You must supply a value for price.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(3, 2)
    private BigDecimal price;
    @NotEmpty(message = "You must supply a value for studio")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String studio;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        Game game = (Game) o;
        return getId() == game.getId() && Objects.equals(getTitle(), game.getTitle()) && Objects.equals(getEsrb_rating(), game.getEsrb_rating()) && Objects.equals(getDescription(), game.getDescription()) && Objects.equals(getPrice(), game.getPrice()) && Objects.equals(getStudio(), game.getStudio()) && Objects.equals(getQuantity(), game.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getEsrb_rating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }

    // toString

    @Override
    public String toString() {
        return "game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", esrb_rating='" + esrb_rating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
