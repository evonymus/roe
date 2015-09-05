package com.evonymus.roe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evonymus.roe.model.PerDiemPeriod;

public class PerDiemRowMapper implements RowMapper<PerDiemPeriod> {
   
    public PerDiemPeriod mapRow(ResultSet rs, int row) throws SQLException {
        return new PerDiemPeriod(rs.getInt("ID"),
                rs.getDate("DATE_FROM"),
                rs.getDate("DATE_TO"));
    }
}
