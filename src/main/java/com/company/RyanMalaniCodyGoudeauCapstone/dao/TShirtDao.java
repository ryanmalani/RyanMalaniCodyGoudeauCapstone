package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tshirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tshirt);

    void deleteTShirt(int id);

    List<TShirt> getTShirtsByColor(String color);

    List<TShirt> getTShirtsBySize(String size);
}
