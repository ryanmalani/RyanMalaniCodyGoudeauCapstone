package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Sales_Tax_Rate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Sales_Tax_RateJdbcTemplateDaoImpl implements Sales_Tax_RateDao {

    private JdbcTemplate jdbcTemplate;

    public Sales_Tax_RateJdbcTemplateDaoImpl() {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Sales_Tax_Rate getSales_Tax_Rate(String state) {
        return null;
    }
}
