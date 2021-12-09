package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.ConsoleInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.GameInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.InvoiceDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.T_ShirtInventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceLayer {

    /*
    Sales tax applies only to the cost of the items.
    Sales tax does not apply to any processing fees for an invoice.
    The processing fee is applied only once per order regardless of the number of items in the order unless the number of items on the order is greater than 10 in which case an additional processing fee of $15.49 is applied to the order.
    The order process logic must properly update the quantity on hand for the item in the order.
    Order quantity must be greater than zero.
    Order quantity must be less than or equal to the number of items on hand in inventory.
    Order must contain a valid state code.
    The REST API must properly handle and report all violations of business rules.
     */

    private ConsoleInventoryDao consoleInventoryDao;
    private GameInventoryDao gameInventoryDao;
    private T_ShirtInventoryDao t_shirtInventoryDao;
    private InvoiceDao invoiceDao;

    @Transactional

}
