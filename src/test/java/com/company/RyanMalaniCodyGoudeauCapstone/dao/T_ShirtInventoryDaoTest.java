package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class T_ShirtInventoryDaoTest {

    @Autowired
    protected T_ShirtInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        List<T_Shirt> mList = dao.getAllT_Shirts();

        for(T_Shirt t_shirt: mList){
            dao.deleteT_Shirt(t_shirt.getId());
        }
    }

    /*
    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;
     */

    @Test
    public void addGetDeleteT_Shirt() {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirt = dao.addT_Shirt(t_shirt);
        T_Shirt t_shirt1 = dao.getT_Shirt(t_shirt.getId());

        assertEquals(t_shirt,t_shirt1);

        dao.deleteT_Shirt(t_shirt.getId());
        t_shirt1 = dao.getT_Shirt(t_shirt.getId());

        assertNull(t_shirt1);
    }

    @Test
    public void updateT_Shirt() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirt = dao.addT_Shirt(t_shirt);

        t_shirt.setSize("Large");

        dao.updateT_Shirt(t_shirt);

        T_Shirt t_shirt1 = dao.getT_Shirt(t_shirt.getId());

        assertEquals(t_shirt, t_shirt1);

    }

    @Test
    public void getAllT_Shirts() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        dao.addT_Shirt(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Large");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("The TShirt fits big");
        t_shirt.setPrice(new BigDecimal("10.99"));
        t_shirt.setQuantity(700);

        dao.addT_Shirt(t_shirt);
        List<T_Shirt> t_shirtList = dao.getAllT_Shirts();

        assertEquals(2, t_shirtList.size());
    }

    @Test
    public void getT_ShirtsByColor() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        dao.addT_Shirt(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Yellow");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        dao.addT_Shirt(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Yellow");
        t_shirt.setDescription("The TShirt is in limited quantity");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(40);

        dao.addT_Shirt(t_shirt);
        List<T_Shirt> mList = dao.getT_ShirtsByColor("Yellow");

        assertEquals(2, mList.size());

        mList = dao.getT_ShirtsByColor("Red");

        assertEquals(1, mList.size());

        mList = dao.getT_ShirtsByColor("Green");

        assertEquals(0, mList.size());
    }

    @Test
    public void getT_ShirtsBySize() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        dao.addT_Shirt(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Large");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        dao.addT_Shirt(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Large");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        dao.addT_Shirt(t_shirt);
        List<T_Shirt> mList = dao.getT_ShirtsBySize("Large");

        assertEquals(2, mList.size());

        mList = dao.getT_ShirtsBySize("Medium");

        assertEquals(1, mList.size());

        mList = dao.getT_ShirtsBySize("Small");

        assertEquals(0, mList.size());
    }

}