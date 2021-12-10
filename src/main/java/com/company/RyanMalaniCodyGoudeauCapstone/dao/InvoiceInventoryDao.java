package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Invoice;

import java.util.List;

public interface InvoiceInventoryDao {

    Invoice getInvoice(int id);
    List<Invoice> getAllInvoices();
    Invoice addInvoice(Invoice invoice);
    void updateInvoice(Invoice invoice);
    void deleteInvoice(int id);
}
