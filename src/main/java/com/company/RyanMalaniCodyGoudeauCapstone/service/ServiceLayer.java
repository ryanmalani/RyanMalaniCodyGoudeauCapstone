package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.*;
import com.company.RyanMalaniCodyGoudeauCapstone.model.*;
import com.company.RyanMalaniCodyGoudeauCapstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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
    private InvoiceInventoryDao invoiceInventoryDao;
    private Processing_FeeDao processing_feeDao;
    private Sales_Tax_RateDao sales_tax_rateDao;
    private T_ShirtInventoryDao t_shirtInventoryDao;


    @Autowired
    public ServiceLayer(ConsoleInventoryDao consoleInventoryDao, GameInventoryDao gameInventoryDao, InvoiceInventoryDao invoiceInventoryDao, Processing_FeeDao processing_feeDao, Sales_Tax_RateDao sales_tax_rateDao, T_ShirtInventoryDao t_shirtInventoryDao) {

        this.consoleInventoryDao = consoleInventoryDao;
        this.gameInventoryDao = gameInventoryDao;
        this.invoiceInventoryDao = invoiceInventoryDao;
        this.processing_feeDao = processing_feeDao;
        this.sales_tax_rateDao = sales_tax_rateDao;
        this.t_shirtInventoryDao = t_shirtInventoryDao;
    }

    private double taxCalculation(double subtotal, double sales_tax_rate) {
        return subtotal * sales_tax_rate;
    }

    private double getProcessing_Fee(int quantity, Processing_Fee processing_fee) {

        if(quantity > 10) {

            return processing_fee.getFee().doubleValue() + 15.49;
        }
        else {
            return processing_fee.getFee().doubleValue();
        }
    }

    @Transactional
    public Invoice createInvoice(InvoiceViewModel invoiceViewModel) {

        double subtotal = invoiceViewModel.getQuantity() * invoiceViewModel.getUnit_price().doubleValue();

        double sales_tax_rate = sales_tax_rateDao.getSales_Tax_Rate(invoiceViewModel.getState()).getRate().doubleValue();
        double tax = taxCalculation(subtotal, sales_tax_rate);

        String item_type = invoiceViewModel.getItem_type();
        double processing_fee = getProcessing_Fee(invoiceViewModel.getQuantity(), processing_feeDao.getProcessing_Fee(item_type));

        double total = subtotal + tax + processing_fee;

        if(item_type.toLowerCase().equals("t_shirt")) {
            T_Shirt purchasedT_Shirt = t_shirtInventoryDao.getT_Shirt(invoiceViewModel.getItem_id());
            purchasedT_Shirt.setQuantity(purchasedT_Shirt.getQuantity() - invoiceViewModel.getQuantity());
        }
        else if(item_type.toLowerCase().equals("console")) {
            Console purchasedConsole = consoleInventoryDao.getConsole(invoiceViewModel.getItem_id());
            purchasedConsole.setQuantity(purchasedConsole.getQuantity() - invoiceViewModel.getQuantity());
        }
        else if(item_type.toLowerCase().equals("game")) {
            Game purchasedGame = gameInventoryDao.getGame(invoiceViewModel.getItem_id());
            purchasedGame.setQuantity(purchasedGame.getQuantity() - invoiceViewModel.getQuantity());
        }
        else {
            throw new IllegalArgumentException("Item type must be t_shirt, console, or game.");
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

        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItem_type(invoiceViewModel.getItem_type());
        invoice.setItem_id(invoiceViewModel.getItem_id());
        invoice.setUnit_price(invoiceViewModel.getUnit_price());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubtotal(BigDecimal.valueOf(subtotal));
        invoice.setTax(BigDecimal.valueOf(tax));
        invoice.setProcessing_fee(BigDecimal.valueOf(processing_fee));
        invoice.setTotal(BigDecimal.valueOf(total));

        return invoiceInventoryDao.addInvoice(invoice);
    }
}
