package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class T_ShirtInventoryJdbcTemplateDao implements T_ShirtInventoryDao {

    //Prepared Statements
    private static final String INSERT_T_Shirt_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values(?, ?, ?, ?, ?)";

    private static final String SELECT_T_Shirt_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_T_Shirt_SQL =
            "select * from t_shirt";

    private static final String DELETE_T_Shirt_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String UPDATE_T_Shirt_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String SELECT_T_Shirt_BY_COLOR =
            "select * from t_shirt where color = ?";

    private static final String SELECT_T_Shirt_BY_SIZE =
            "select * from t_shirt where size = ?";

    //jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public T_ShirtInventoryJdbcTemplateDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    @Override
    public T_Shirt getT_Shirt(int id) {

        try
        {
            return jdbcTemplate.queryForObject(SELECT_T_Shirt_SQL, this::mapRowToT_Shirt, id);
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<T_Shirt> getAllT_Shirts() {
        return jdbcTemplate.query(SELECT_ALL_T_Shirt_SQL, this::mapRowToT_Shirt);
    }

    @Override
    public T_Shirt addT_Shirt(T_Shirt t_shirt) {

        jdbcTemplate.update(INSERT_T_Shirt_SQL,
                t_shirt.getSize(),
                t_shirt.getColor(),
                t_shirt.getDescription(),
                t_shirt.getPrice(),
                t_shirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        t_shirt.setId(id);

        return t_shirt;
    }

    @Override
    public void updateT_Shirt(T_Shirt t_shirt) {

        jdbcTemplate.update(UPDATE_T_Shirt_SQL,
                t_shirt.getSize(),
                t_shirt.getColor(),
                t_shirt.getDescription(),
                t_shirt.getPrice(),
                t_shirt.getQuantity(),
                t_shirt.getId());
    }

    @Override
    public void deleteT_Shirt(int id) {

        jdbcTemplate.update(DELETE_T_Shirt_SQL, id);

    }

    @Override
    public List<T_Shirt> getT_ShirtsByColor(String color) {

        return jdbcTemplate.query(SELECT_T_Shirt_BY_COLOR, this::mapRowToT_Shirt, color);
    }

    @Override
    public List<T_Shirt> getT_ShirtsBySize(String size) {
        return jdbcTemplate.query(SELECT_T_Shirt_BY_SIZE, this::mapRowToT_Shirt, size);
    }

    /*
    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;
     */

    private T_Shirt mapRowToT_Shirt(ResultSet rs,int rowNum) throws SQLException {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setId(rs.getInt("t_shirt_id"));
        t_shirt.setSize(rs.getString("size"));
        t_shirt.setColor(rs.getString("color"));
        t_shirt.setDescription(rs.getString("description"));
        t_shirt.setPrice(rs.getBigDecimal("price"));
        t_shirt.setQuantity(rs.getInt("quantity"));

        return t_shirt;

    }

}
