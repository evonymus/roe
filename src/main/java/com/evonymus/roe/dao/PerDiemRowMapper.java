package com.evonymus.roe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evonymus.roe.model.Currency;
import com.evonymus.roe.model.PerDiem;
import com.evonymus.roe.model.PerDiemPeriod;

public class PerDiemRowMapper implements RowMapper<PerDiem> {
   
    public PerDiem mapRow(ResultSet rs, int row) throws SQLException {
        Currency currency = new Currency(rs.getInt("ID_CURRENCY"),
                rs.getString("CODE"),
                rs.getString("NAME"));

        PerDiemPeriod perDiemPeriod = new PerDiemPeriod(rs.getInt("ID_PER_DIEM_PERIOD"),
                rs.getDate("DATE_FROM"),
                rs.getDate("DATE_TO"));

        PerDiem result = new PerDiem();
        result.setCurrency(currency);
        result.setPerDiemPeriod(perDiemPeriod);
        result.setId(rs.getInt("ID"));
        result.setRate(rs.getDouble("RATE"));

        return result;
    }
}
