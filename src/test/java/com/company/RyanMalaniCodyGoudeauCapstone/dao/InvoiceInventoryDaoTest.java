package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceInventoryDaoTest {

    @Autowired
    protected InvoiceInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> mList = dao.getAllInvoices();

        for(Invoice invoice : mList){
            dao.deleteInvoice(invoice.getId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoice = dao.addInvoice(invoice);
        Invoice invoice1 = dao.getInvoice(invoice.getId());

        assertEquals(invoice, invoice1);

        dao.deleteInvoice(invoice.getId());
        invoice1 = dao.getInvoice(invoice.getId());

        assertNull(invoice1);
    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoice = dao.addInvoice(invoice);

        invoice.setName("Bill");

        dao.updateInvoice(invoice);

        Invoice invoice1 = dao.getInvoice(invoice.getId());

        assertEquals(invoice, invoice1);

    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        dao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Bill");
        invoice.setStreet("17th Street");
        invoice.setCity("Brookfield");
        invoice.setState("Montana");
        invoice.setZipcode("75837");
        invoice.setItem_type("Game");
        invoice.setItem_id(70);
        invoice.setUnit_price(new BigDecimal("59.99"));
        invoice.setQuantity(400);
        invoice.setSubtotal(new BigDecimal("59.99"));
        invoice.setTax(new BigDecimal("0.70"));
        invoice.setProcessing_fee(new BigDecimal("3.99"));
        invoice.setTotal(new BigDecimal("63.99"));

        dao.addInvoice(invoice);
        List<Invoice> invoiceList = dao.getAllInvoices();

        assertEquals(2, invoiceList.size());

    }
}