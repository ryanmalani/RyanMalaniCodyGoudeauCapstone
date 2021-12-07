package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
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
public class ConsoleInventoryDaoTest {

    @Autowired
    protected ConsoleInventoryDao dao;

    @Before
    public void setUp() throws Exception{
        List<Console> mList = dao.getAllConsoles();

        for (Console console: mList){
            dao.deleteConsole(console.getId());
        }
    }

    @Test
    public void addGetDeleteConsoles() {

        Console console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Playstation");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(300);

        console = dao.addConsole(console);
        Console console1 = dao.getConsole(console.getId());

        assertEquals(console,console1);

        dao.deleteConsole(console.getId());
        console1 = dao.getConsole(console.getId());

        assertNull(console1);

    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Playstation");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(300);

        console = dao.addConsole(console);

        console.setModel("XboxX");

        dao.updateConsole(console);

        Console console1 = dao.getConsole(console.getId());

        assertEquals(console, console1);
    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Playstation");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(300);

        dao.addConsole(console);

        console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("500GB");
        console.setProcessor("OkayProcessor");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(340);

        dao.addConsole(console);
        List<Console> consoleList = dao.getAllConsoles();

        assertEquals(2, consoleList.size());
    }

    @Test
    public void getConsolesByManufacturer() {

        Console console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Playstation");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(300);

        dao.addConsole(console);

        console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Amazon");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(300);

        dao.addConsole(console);

        console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Amazon");
        console.setMemory_amount("670GB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(300);

        dao.addConsole(console);
        List<Console> mList = dao.getConsolesByManufacturer("Amazon");

        assertEquals(2, mList.size());

        mList = dao.getConsolesByManufacturer("Playstation");

        assertEquals(1, mList.size());

        mList = dao.getConsolesByManufacturer("Microsoft");

        assertEquals(0, mList.size());
    }

}