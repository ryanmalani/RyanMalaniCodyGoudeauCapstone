package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;

import java.util.List;

public interface T_ShirtInventoryDao {

    T_Shirt getT_Shirt(int id);
    List<T_Shirt> getAllT_Shirts();
    T_Shirt addT_Shirt(T_Shirt t_shirt);
    void updateT_Shirt(T_Shirt t_shirt);
    void deleteT_Shirt(int id);
    List<T_Shirt> getT_ShirtsByColor(String color);
    List<T_Shirt> getT_ShirtsBySize(String size);
}
