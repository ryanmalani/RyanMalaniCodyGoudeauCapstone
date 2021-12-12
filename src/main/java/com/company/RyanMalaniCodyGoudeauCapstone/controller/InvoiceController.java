package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createInvoice(@RequestBody @Valid Invoice invoice) {
        return null;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id) {
        return null;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        return null;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable int id, @RequestBody @Valid Invoice invoice) {
        return null;
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id) {
        return null;
    }
}
