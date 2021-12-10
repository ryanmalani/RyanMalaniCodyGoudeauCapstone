package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createInvoice(@RequestBody @Valid Invoice invoice) {
        return null;
    }
}
