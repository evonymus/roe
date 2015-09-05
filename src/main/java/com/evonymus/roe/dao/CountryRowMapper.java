package com.evonymus.roe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evonymus.roe.model.Country;

public class CountryRowMapper implements RowMapper<Country> {
    public Country mapRow(ResultSet rs, int row) throws SQLException {
        return new Country(rs.getInt("ID"),
                rs.getString("NAME"),
                rs.getString("ISO"),
                rs.getInt("ID_CURRENCY"));
    }
    
}
