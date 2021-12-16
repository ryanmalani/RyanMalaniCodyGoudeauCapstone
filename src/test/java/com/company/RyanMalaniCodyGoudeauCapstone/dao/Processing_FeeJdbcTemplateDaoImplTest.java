package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Processing_Fee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class Processing_FeeJdbcTemplateDaoImplTest {

    @Autowired
    Processing_FeeDao processing_feeDao;

    @Before
    public void setUp() throws Exception {
    }

    /*
    private String product_type;
    private BigDecimal fee;
     */

    @Test
    public void getProcessing_Fee() {

        // ARRANGE

        String product_type = "console";
        Processing_Fee desiredProcessing_Fee = new Processing_Fee();
        desiredProcessing_Fee.setProductType(product_type);
        desiredProcessing_Fee.setFee(new BigDecimal("14.99"));

        // ACT

        Processing_Fee actualProcessing_Fee = processing_feeDao.getProcessing_Fee(product_type);

        // ASSERT

        assertEquals(desiredProcessing_Fee, actualProcessing_Fee);
    }
}