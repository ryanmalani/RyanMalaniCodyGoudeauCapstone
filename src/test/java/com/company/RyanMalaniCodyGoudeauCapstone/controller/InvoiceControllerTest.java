package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

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

    @Test
    public void shouldCreateInvoice() {

        // ARRANGE
        Invoice inputInvoice = new Invoice();
        inputInvoice.setName("Random");
        inputInvoice.setStreet("1256 Short Street");
        inputInvoice.setCity("Cincinnati");
        inputInvoice.setState("Ohio");
        inputInvoice.setZipcode("45241");
        inputInvoice.setItem_type("Console");
        inputInvoice.setItem_id(1);
        inputInvoice.setUnit_price("239.99");
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal("239.99");
        inputInvoice.setTax("6.84");
        inputInvoice.setProcessing_fee("14.99");
        inputInvoice.setTotal("261.82");

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputInvoice);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setName("Random");
        outputInvoice.setStreet("1256 Short Street");
        outputInvoice.setCity("Cincinnati");
        outputInvoice.setState("Ohio");
        outputInvoice.setZipcode("45241");
        outputInvoice.setItem_type("Console");
        outputInvoice.setItem_id(1);
        outputInvoice.setUnit_price("239.99");
        outputInvoice.setQuantity(1);
        outputInvoice.setSubtotal("239.99");
        outputInvoice.setTax("6.84");
        outputInvoice.setProcessing_fee("14.99");
        outputInvoice.setTotal("261.82");
        outputInvoice.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputInvoice);

        // ACT
        mockMvc.perform(
                        post("/invoice") // perform post request
                                .content(inputJson)  // set request body
                                .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson)); // ASSERT
    }
}