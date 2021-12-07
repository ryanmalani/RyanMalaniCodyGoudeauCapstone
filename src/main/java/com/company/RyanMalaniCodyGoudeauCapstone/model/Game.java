package com.company.RyanMalaniCodyGoudeauCapstone.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Game {

    private int id;
    private String title;
    private String esrb_rating;
    private String description;
    private BigDecimal price;
    private String studio;
    private int quantity;

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
