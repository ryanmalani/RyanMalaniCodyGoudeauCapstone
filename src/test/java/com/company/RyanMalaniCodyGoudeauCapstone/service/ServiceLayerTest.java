package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    /*
    Sales tax applies only to the cost of the items.
    Sales tax does not apply to any processing fees for an invoice.
    The processing fee is applied only once per order regardless of the number of items in the order unless the number of items on the order is greater than 10 in which case an additional processing fee of $15.49 is applied to the order.
    The order process logic must properly update the quantity on hand for the item in the order.
    Order quantity must be greater than zero.
    Order quantity must be less than or equal to the number of items on hand in inventory.
    Order must contain a valid state code.
    The REST API must properly handle and report all violations of business rules.
     */

    ServiceLayer serviceLayer;
    ConsoleInventoryDao consoleInventoryDao;
    GameInventoryDao gameInventoryDao;
    InvoiceInventoryDao invoiceInventoryDao;
    Processing_FeeDao processing_feeDao;
    Sales_Tax_RateDao sales_tax_rateDao;
    T_ShirtInventoryDao t_shirtInventoryDao;

    @Before
    public void setUp() throws Exception {

        setUpConsoleInventoryDaoMock();
        setUpGameInventoryDaoMock();
        setUpInvoiceInventoryDaoMock();
        setUpProcessing_FeeDaoMock();
        setUpSales_Tax_RateDaoMock();
        setUpT_ShirtInventoryDaoMock();

        serviceLayer = new ServiceLayer(consoleInventoryDao, gameInventoryDao, invoiceInventoryDao, processing_feeDao, sales_tax_rateDao, t_shirtInventoryDao);
    }

    // helper methods
    @Test
    public void setUpConsoleInventoryDaoMock() {

        consoleInventoryDao = mock(ConsoleInventoryJdbcTemplateDao.class);
    }
    @Test
    public void setUpGameInventoryDaoMock() {

        gameInventoryDao = mock(GameInventoryJdbcTemplateDao.class);
    }
    @Test
    public void setUpInvoiceInventoryDaoMock() {

        invoiceInventoryDao = mock(InvoiceInventoryJdbcTemplateDao.class);
    }
    @Test
    public void setUpProcessing_FeeDaoMock() {

        processing_feeDao = mock(Processing_FeeJdbcTemplateDaoImpl.class);
    }
    @Test
    public void setUpSales_Tax_RateDaoMock() {

        sales_tax_rateDao = mock(Sales_Tax_RateJdbcTemplateDaoImpl.class);
    }
    @Test
    public void setUpT_ShirtInventoryDaoMock() {

        t_shirtInventoryDao = mock(T_ShirtInventoryJdbcTemplateDao.class);
    }
}