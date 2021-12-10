package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    protected InvoiceDao invoiceDao;
    @Autowired
    protected ConsoleInventoryDao consoleDao;
    @Autowired
    protected GameInventoryDao gameDao;
    @Autowired
    protected T_ShirtInventoryDao t_shirtDao;

    /*
    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String item_type;
    private int item_id;
    private BigDecimal unit_price;
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processing_fee;
    private BigDecimal total;
     */

    @Before
    public void setUp() throws Exception {
        removeAll();

        Invoice invoice1 = new Invoice();
        invoice1.setName("");
        invoice1.setStreet();
    }

    @After
    public void tearDown() throws Exception {
        removeAll();
    }

    private void removeAll() {

        // empty out test database
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        invoiceList.stream()
                .forEach(i -> {
                    invoiceDao.deleteInvoice(i.getId());
                });

        List<Console> consoleList = consoleDao.getAllConsoles();

        consoleList.stream()
                .forEach(c -> {
                    consoleDao.deleteConsole(c.getId());
                });

        List<Game> gameList = gameDao.getAllGames();

        gameList.stream()
                .forEach(g -> {
                    gameDao.deleteGame(g.getId());
                });

        List<T_Shirt> t_shirtList = t_shirtDao.getAllT_Shirts();

        t_shirtList.stream()
                .forEach(t -> {
                    t_shirtDao.deleteT_Shirt(t.getId());
                });
    }

    @Test
    public void shouldCreateInvoice() {


    }
}