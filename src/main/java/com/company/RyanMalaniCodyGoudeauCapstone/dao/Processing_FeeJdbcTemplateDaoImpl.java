package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Processing_Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Processing_FeeJdbcTemplateDaoImpl implements Processing_FeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Processing_FeeJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Processing_Fee getProcessing_Fee(String product_type) {
        return null;
    }
}
