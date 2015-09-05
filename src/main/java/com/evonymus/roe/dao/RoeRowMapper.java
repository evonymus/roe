package com.evonymus.roe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evonymus.roe.model.Roe;

public class RoeRowMapper implements RowMapper<Roe>{

	public Roe mapRow(ResultSet rs, int row) throws SQLException {
		
		Roe roe = new Roe();
		
		roe.setId(rs.getInt("ID"));
		roe.setPublished(rs.getDate("PUBLISHED"));
		roe.setTabId(rs.getString("TAB_ID"));
		roe.setCode(rs.getString("CODE"));
		roe.setRoe(rs.getDouble("ROE"));
		roe.setNamePL(rs.getString("NAME_PL"));
		
		return roe;
	}

}
