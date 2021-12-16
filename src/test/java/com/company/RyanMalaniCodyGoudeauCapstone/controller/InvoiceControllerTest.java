package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
import com.company.RyanMalaniCodyGoudeauCapstone.viewmodel.InvoiceViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
    }

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

    // testing POST /invoice

    @Test
    public void shouldCreateInvoice() throws Exception {

        // ARRANGE

        InvoiceViewModel inputInvoice = new InvoiceViewModel();
        inputInvoice.setName("Random");
        inputInvoice.setStreet("1256 Short Street");
        inputInvoice.setCity("Cincinnati");
        inputInvoice.setState("OH");
        inputInvoice.setZipcode("45241");
        inputInvoice.setItem_type("Consoles");
        inputInvoice.setItem_id(1);
        inputInvoice.setUnit_price(new BigDecimal("239.99"));
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal(new BigDecimal("239.99"));
        inputInvoice.setTax(new BigDecimal("6.84"));
        inputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        inputInvoice.setTotal(new BigDecimal("261.82"));

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputInvoice);

        when(serviceLayer.createInvoice(inputInvoice)).thenReturn(inputInvoice);

        // ACT

        mockMvc.perform(
                        post("/invoice") // perform post request
                                .content(inputJson)  // set request body
                                .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(inputJson)); // ASSERT
    }
}