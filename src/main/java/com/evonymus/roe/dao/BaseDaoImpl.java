package com.evonymus.roe.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoImpl {
    protected JdbcTemplate jdbcTemplate;
    
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
