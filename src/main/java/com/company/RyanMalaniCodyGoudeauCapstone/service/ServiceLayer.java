package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.*;
import com.company.RyanMalaniCodyGoudeauCapstone.model.*;
import com.company.RyanMalaniCodyGoudeauCapstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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

    // CREATE console

    @Override
    public Console addConsole(Console console) {
        return consoleInventoryDao.addConsole();
    }

    // READ console

    @Override
    public Console getConsole(int console_id) {
        return consoleInventoryDao.getConsole(console_id);
    }

    @Override
    public List<Console> getAllConsoles() {
        return consoleInventoryDao.getAllConsoles();
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return consoleInventoryDao.getConsolesByManufacturer(manufacturer);
    }

    // UPDATE console

    @Override
    public void updateConsole(Console console) {
        consoleInventoryDao.updateConsole(console);
    }

    // DELETE console

    @Override
    public void deleteConsole(int console_id) {
        consoleInventoryDao.deleteConsole(console_id);
    }

    // CREATE game

    @Override
    public Game addGame(Game game) {
        gameInventoryDao.addGame(game);
    }

    // READ game

    @Override
    public Game getGame(int game_id) {
        gameInventoryDao.getGame(game_id);
    }

    @Override
    public List<Game> getAllGames() {
        gameInventoryDao.getAllGames();
    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        gameInventoryDao.getGamesByStudio(studio);
    }

    @Override
    public List<Game> getGamesByESRB_Rating(String esrb_rating) {
        gameInventoryDao.getGamesByESRB_Rating(esrb_rating);
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        gameInventoryDao.getGamesByTitle(title);
    }

    // UPDATE game

    @Override
    public void updateGame(Game game) {
        gameInventoryDao.updateGame(game);
    }

    // DELETE game

    @Override
    public void deleteGame(int game_id) {
        gameInventoryDao.deleteGame(game_id);
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
}
