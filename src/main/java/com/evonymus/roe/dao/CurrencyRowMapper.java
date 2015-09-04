package com.evonymus.roe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evonymus.roe.model.Currency;

public class CurrencyRowMapper implements RowMapper<Currency> {

    public Currency mapRow(ResultSet rs, int row) throws SQLException{
        Currency result = new Currency();
        result.setId(rs.getInt("ID"));
        result.setCurCode(rs.getString("CUR_CODE"));
        result.setCurName(rs.getString("CUR_NAME"));

        return result;
    }
    
}
