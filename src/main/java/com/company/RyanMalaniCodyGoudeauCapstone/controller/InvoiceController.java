package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

    private List<Invoice> invoiceList;

    private static int idCounter =1;

    public InvoiceController(){
        invoiceList = new ArrayList<>();

        invoiceList.add(new Invoice("Cody", "113th Street", "Chicago", "Illinois", "11234", "T_Shirt", 45, "19.99", 1, "19.99", "0.50", "0.50", "20.00", idCounter++));
        invoiceList.add(new Invoice("Sam", "56th Street", "Salt Lake City", "Utah", "75836", "Console", 50, "499.99", 10, "499.99", "0.40", "0.40", "500.79", idCounter++));
        invoiceList.add(new Invoice("Robert", "King Road", "Des Moines", "Iowa", "85736", "Game", 14, "59.99", 600, "59.99", "0.40", "0.40", "60.79", idCounter++));

    }

    // Create

    @PostMapping
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice) {

        invoice.setId(idCounter++);
        invoiceList.add(invoice);

        return invoice;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id) {

        Invoice foundInvoice = null;

        for (Invoice invoice : invoiceList) {
            if (invoice.getId() == id) {
                foundInvoice = invoice;
                break;
            }
        }

        return foundInvoice;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoices(@RequestParam(required = false) String name, @RequestParam(required = false) String total) {

         List<Invoice> returnList = new ArrayList<>();

        if (name != null) {
            for (Invoice invoice : invoiceList) {
                if (invoice.getName().contains(name)) {
                    returnList.add(invoice);
                }
            }
        } else if (total != null) {
            for (Invoice invoice : invoiceList) {
                if (invoice.getName().contains(name)){
                    returnList.add(invoice);
                }
            }
        } else {
            returnList = invoiceList;
        }

        return returnList;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable int id, @RequestBody @Valid Invoice invoice) {

        int index =-1;

        for (int i=0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getId() == id) {
                index =-1;
                break;
            }

            if (index >=0 ) {
                invoiceList.set(index,invoice);
            }
        }
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id) {
        int index = -1;

        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getId() == id) {
                index = i;
                break;
            }
        }


        if (index >= 0) {
            invoiceList.remove(index);
        }
    }
}
