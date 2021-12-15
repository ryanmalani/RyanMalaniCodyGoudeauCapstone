package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
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
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Invoice> invoiceList;

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

        Invoice inputInvoice = new Invoice();
        inputInvoice.setName("Random");
        inputInvoice.setStreet("1256 Short Street");
        inputInvoice.setCity("Cincinnati");
        inputInvoice.setState("Ohio");
        inputInvoice.setZipcode("45241");
        inputInvoice.setItem_type("Console");
        inputInvoice.setItem_id(1);
        inputInvoice.setUnit_price(new BigDecimal("239.99"));
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal(new BigDecimal("239.99"));
        inputInvoice.setTax(new BigDecimal("6.84"));
        inputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        inputInvoice.setTotal(new BigDecimal("261.82"));

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
        outputInvoice.setUnit_price(new BigDecimal("239.99"));
        outputInvoice.setQuantity(1);
        outputInvoice.setSubtotal(new BigDecimal("239.99"));
        outputInvoice.setTax(new BigDecimal("6.84"));
        outputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        outputInvoice.setTotal(new BigDecimal("14.99"));
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

    // testing GET /invoice/{id}

    @Test
    public void shouldGetInvoiceById() throws  Exception {

        // ARRANGE

        Invoice outputInvoice = new Invoice();
        outputInvoice.setName("Random");
        outputInvoice.setStreet("1256 Short Street");
        outputInvoice.setCity("Cincinnati");
        outputInvoice.setState("Ohio");
        outputInvoice.setZipcode("45241");
        outputInvoice.setItem_type("Console");
        outputInvoice.setItem_id(1);
        outputInvoice.setUnit_price(new BigDecimal("239.99"));
        outputInvoice.setQuantity(1);
        outputInvoice.setSubtotal(new BigDecimal("239.99"));
        outputInvoice.setTax(new BigDecimal("6.84"));
        outputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        outputInvoice.setTotal(new BigDecimal("261.82"));
        outputInvoice.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputInvoice);

        // ACT

        mockMvc.perform(get("/invoice/2")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /invoice

    @Test
    public void shouldGetAllInvoices() throws Exception {

        String outputJson = objectMapper.writeValueAsString(invoiceList);

        mockMvc.perform(get("/invoice")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing PUT /invoice/{id}

    @Test
    public void shouldUpdateInvoice() throws  Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        // ARRANGE

        Invoice inputInvoice = new Invoice();
        inputInvoice.setName("Random");
        inputInvoice.setStreet("123 Fake Street");
        inputInvoice.setCity("Cincinnati");
        inputInvoice.setState("Ohio");
        inputInvoice.setZipcode("45241");
        inputInvoice.setItem_type("Console");
        inputInvoice.setItem_id(1);
        inputInvoice.setUnit_price(new BigDecimal("239.99"));
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal(new BigDecimal("239.99"));
        inputInvoice.setTax(new BigDecimal("6.84"));
        inputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        inputInvoice.setTotal(new BigDecimal("261.82"));
        inputInvoice.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputInvoice);

        // ACT

        mockMvc.perform(
                        put("/invoice/2")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // testing DELETE /invoice/{id}

    @Test
    public void shouldDeleteInvoice() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/invoice/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {

        // ARRANGE

        Invoice inputInvoice = new Invoice();
        inputInvoice.setName("Random");
        inputInvoice.setState("Ohio");
        inputInvoice.setZipcode("45241");
        inputInvoice.setItem_type("Console");
        inputInvoice.setItem_id(1);
        inputInvoice.setUnit_price(new BigDecimal("239.99"));
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal(new BigDecimal("239.99"));
        inputInvoice.setTax(new BigDecimal("6.84"));
        inputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        inputInvoice.setTotal(new BigDecimal("261.82"));

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputInvoice);

        // ACT

        mockMvc.perform(
                        post("/invoice")                                // perform the POST request
                                .content(inputJson)                         // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
                )
                .andDo(print())                                     // print results to console
                .andExpect(status().isUnprocessableEntity());                   // ASSERT (status code is 422)
    }

    @Test
    public void shouldReturn404StatusCodeIfRecordNotFound() throws Exception {

        mockMvc.perform(get("/invoice/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn422StatusCodeIfIdsDoNotMatch() throws Exception {

        // ARRANGE

        Invoice inputInvoice = new Invoice();
        inputInvoice.setName("Random");
        inputInvoice.setStreet("1256 Short Street");
        inputInvoice.setCity("Cincinnati");
        inputInvoice.setState("Ohio");
        inputInvoice.setZipcode("45241");
        inputInvoice.setItem_type("Console");
        inputInvoice.setItem_id(1);
        inputInvoice.setUnit_price(new BigDecimal("239.99"));
        inputInvoice.setQuantity(1);
        inputInvoice.setSubtotal(new BigDecimal("239.99"));
        inputInvoice.setTax(new BigDecimal("6.84"));
        inputInvoice.setProcessing_fee(new BigDecimal("14.99"));
        inputInvoice.setTotal(new BigDecimal("261.82"));
        inputInvoice.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputInvoice);

        mockMvc.perform(
                        put("/invoice/5")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}