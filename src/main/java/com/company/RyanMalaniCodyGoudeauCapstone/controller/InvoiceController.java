package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.InvoiceInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
import com.company.RyanMalaniCodyGoudeauCapstone.viewmodel.InvoiceViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    @Autowired
    public InvoiceController(ServiceLayer serviceLayer) {

        this.serviceLayer = serviceLayer;
    }

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {

        return serviceLayer.createInvoice(invoiceViewModel);
    }
}
