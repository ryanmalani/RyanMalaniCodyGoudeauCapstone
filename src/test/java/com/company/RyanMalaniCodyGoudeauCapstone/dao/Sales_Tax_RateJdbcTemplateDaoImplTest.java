package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Sales_Tax_Rate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Sales_Tax_RateJdbcTemplateDaoImplTest {

    @Autowired
    Sales_Tax_RateDao sales_tax_rateDao;

    @Before
    public void setUp() throws Exception {
    }

    /*
    private String state;
    private BigDecimal rate;
     */

    @Test
    public void getSales_Tax_Rate() {

        // ARRANGE

        String state = "VA";
        Sales_Tax_Rate desiredSales_Tax_Rate = new Sales_Tax_Rate();
        desiredSales_Tax_Rate.setState(state);
        desiredSales_Tax_Rate.setRate(new BigDecimal("0.06"));

        // ACT

        Sales_Tax_Rate actualSales_Tax_Rate = sales_tax_rateDao.getSales_Tax_Rate(state);

        // ASSERT

        assertEquals(desiredSales_Tax_Rate, actualSales_Tax_Rate);
    }

    @Test
    public void invalidState() {

        // ARRANGE

        String state = "TA";
        Sales_Tax_Rate desiredSales_Tax_Rate = new Sales_Tax_Rate();
        desiredSales_Tax_Rate.setState(state);
        desiredSales_Tax_Rate.setRate(new BigDecimal("0.06"));

        // ASSERT

        assertThrows(IllegalArgumentException.class, () -> sales_tax_rateDao.getSales_Tax_Rate(state));
    }
}