package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.ConsoleInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.InvoiceInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    InvoiceInventoryDao invoiceDao;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice) {

        invoiceDao.addInvoice(invoice);

        return invoice;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id) {

        return invoiceDao.getInvoice(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoices() {

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        return invoiceList;

    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable int id, @RequestBody @Valid Invoice invoice) {

        if (invoice.getId() == id) {
            invoice.setId(id);
        }

        if (invoice.getId() != id) {
            throw new IllegalArgumentException("Invoice ID must match parameter given");
        }

        invoiceDao.updateInvoice(invoice);
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id) {

        invoiceDao.deleteInvoice(id);
    }
}
