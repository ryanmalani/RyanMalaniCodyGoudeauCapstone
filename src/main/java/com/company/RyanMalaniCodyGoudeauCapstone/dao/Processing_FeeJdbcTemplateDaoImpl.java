package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Processing_Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Processing_FeeJdbcTemplateDaoImpl implements Processing_FeeDao {

    // prepared statement

    private static final String SELECT_PROCESSING_FEE_SQL =
            "select * from processing_fee where product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Processing_FeeJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Processing_Fee getProcessing_Fee(String product_type) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToProcessingFee, product_type);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Product type must be t_shirt, console, or game");
        }
    }

    public Processing_Fee mapRowToProcessingFee(ResultSet resultSet, int rowNum) throws SQLException {
        return new Processing_Fee(
                resultSet.getString("product_type"),
                resultSet.getBigDecimal("fee"));
    }
}
