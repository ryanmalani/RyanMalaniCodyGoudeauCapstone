package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Sales_Tax_Rate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Sales_Tax_RateJdbcTemplateDaoImpl implements Sales_Tax_RateDao {

    // prepared statement

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "select * from sales_tax_rate where state = ?";

    private JdbcTemplate jdbcTemplate;

    public Sales_Tax_RateJdbcTemplateDaoImpl() {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Sales_Tax_Rate getSales_Tax_Rate(String state) {

        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL, this::mapRowToSalesTaxRate, state);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("State code must be two letter abbreviation of one of the 50 US states.");
        }
    }

    public Sales_Tax_Rate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {

        Sales_Tax_Rate sales_tax_rate = new Sales_Tax_Rate();
        sales_tax_rate.setState(rs.getString("state"));
        sales_tax_rate.setRate(rs.getBigDecimal("rate"));

        return sales_tax_rate;
    }
}
