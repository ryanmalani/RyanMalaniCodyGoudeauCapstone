package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.controller.ConsoleController;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.*;
import com.company.RyanMalaniCodyGoudeauCapstone.model.*;
import com.company.RyanMalaniCodyGoudeauCapstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Repository
public class ServiceLayer implements ConsoleInventoryDao {

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
    @Autowired
    private ConsoleInventoryDao consoleInventoryDao;

    @Autowired
    private GameInventoryDao gameInventoryDao;

    @Autowired
    private InvoiceInventoryDao invoiceInventoryDao;

    @Autowired
    private Processing_FeeDao processing_feeDao;

    @Autowired
    private Sales_Tax_RateDao sales_tax_rateDao;

    @Autowired
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

    private double getProcessing_Fee(int quantity, Processing_Fee processing_fee) {

        if(quantity > 10) {

            return processing_fee.getFee().doubleValue() + 15.49;
        }
        else {
            return processing_fee.getFee().doubleValue();
        }
    }

    @Transactional
    public InvoiceViewModel createInvoice(InvoiceViewModel invoiceViewModel) {

        String item_type = invoiceViewModel.getItem_type();

        if(item_type.toLowerCase().equals("t-shirt")) {
            T_Shirt purchasedT_Shirt = t_shirtInventoryDao.getT_Shirt(invoiceViewModel.getItem_id());
            if(invoiceViewModel.getQuantity() <= purchasedT_Shirt.getQuantity()) {
                purchasedT_Shirt.setQuantity(purchasedT_Shirt.getQuantity() - invoiceViewModel.getQuantity());
                t_shirtInventoryDao.updateT_Shirt(purchasedT_Shirt);

                double subtotal = invoiceViewModel.getQuantity() * invoiceViewModel.getUnit_price().doubleValue();

                double sales_tax_rate = sales_tax_rateDao.getSales_Tax_Rate(invoiceViewModel.getState()).getRate().doubleValue();
                double tax = subtotal * sales_tax_rate;

                double processing_fee = getProcessing_Fee(invoiceViewModel.getQuantity(), processing_feeDao.getProcessing_Fee(item_type));

                double total = subtotal + tax + processing_fee;

                invoiceViewModel.setSubtotal(BigDecimal.valueOf(subtotal));
                invoiceViewModel.setTax(BigDecimal.valueOf(tax));
                invoiceViewModel.setProcessing_fee(BigDecimal.valueOf(processing_fee));
                invoiceViewModel.setTotal(BigDecimal.valueOf(total));
            }
        }
        else if(item_type.toLowerCase().equals("console")) {
            Console purchasedConsole = consoleInventoryDao.getConsole(invoiceViewModel.getItem_id());
            if(invoiceViewModel.getQuantity() <= purchasedConsole.getQuantity()) {
                purchasedConsole.setQuantity(purchasedConsole.getQuantity() - invoiceViewModel.getQuantity());
                consoleInventoryDao.updateConsole(purchasedConsole);

                double subtotal = invoiceViewModel.getQuantity() * invoiceViewModel.getUnit_price().doubleValue();

                double sales_tax_rate = sales_tax_rateDao.getSales_Tax_Rate(invoiceViewModel.getState()).getRate().doubleValue();
                double tax = subtotal * sales_tax_rate;

                double processing_fee = getProcessing_Fee(invoiceViewModel.getQuantity(), processing_feeDao.getProcessing_Fee(item_type));

                double total = subtotal + tax + processing_fee;

                invoiceViewModel.setSubtotal(BigDecimal.valueOf(subtotal));
                invoiceViewModel.setTax(BigDecimal.valueOf(tax));
                invoiceViewModel.setProcessing_fee(BigDecimal.valueOf(processing_fee));
                invoiceViewModel.setTotal(BigDecimal.valueOf(total));
            }
        }
        else if(item_type.toLowerCase().equals("game")) {
            Game purchasedGame = gameInventoryDao.getGame(invoiceViewModel.getItem_id());
            if(invoiceViewModel.getQuantity() <= purchasedGame.getQuantity()) {
                purchasedGame.setQuantity(purchasedGame.getQuantity() - invoiceViewModel.getQuantity());
                gameInventoryDao.updateGame(purchasedGame);

                double subtotal = invoiceViewModel.getQuantity() * invoiceViewModel.getUnit_price().doubleValue();

                double sales_tax_rate = sales_tax_rateDao.getSales_Tax_Rate(invoiceViewModel.getState()).getRate().doubleValue();
                double tax = subtotal * sales_tax_rate;

                double processing_fee = getProcessing_Fee(invoiceViewModel.getQuantity(), processing_feeDao.getProcessing_Fee(item_type));

                double total = subtotal + tax + processing_fee;

                invoiceViewModel.setSubtotal(BigDecimal.valueOf(subtotal));
                invoiceViewModel.setTax(BigDecimal.valueOf(tax));
                invoiceViewModel.setProcessing_fee(BigDecimal.valueOf(processing_fee));
                invoiceViewModel.setTotal(BigDecimal.valueOf(total));
            }
        }
        else {
            throw new IllegalArgumentException("Item type must be t-shirt, console, or game.");
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

        return invoiceViewModel;
    }


    @Override
    public Console getConsole(int id) {

        return consoleInventoryDao.getConsole(id);
    }

    @Override
    public List<Console> getAllConsoles() {

        List<Console> consoleList = consoleInventoryDao.getAllConsoles();

        return consoleList;
    }

    @Override
    public Console addConsole(Console console) {

        return consoleInventoryDao.addConsole(console);
    }

    @Override
    public void updateConsole(Console console) {

        if (console.getId() != console.getId()) {
            throw new IllegalArgumentException("Console ID must match parameter given.");
        }

        consoleInventoryDao.updateConsole(console);
    }

    @Override
    public void deleteConsole(int id) {

        consoleInventoryDao.deleteConsole(id);
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {

        List<Console> consoleList = consoleInventoryDao.getConsolesByManufacturer(manufacturer);

         return consoleInventoryDao.getConsolesByManufacturer(manufacturer);

    }
}
