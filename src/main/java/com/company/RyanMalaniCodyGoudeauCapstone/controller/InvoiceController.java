package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    // Create

    @RequestMapping(value = "/invoice", method = HttpMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createInvoice(@RequestBody Invoice invoice) {
        return null;
    }
}
