package com.evonymus.roe.dao;

import java.util.List;

import com.evonymus.roe.model.Currency;

public class CurrencyDaoImpl extends BaseDaoImpl implements CurrencyDao {
    private static final String ALL_CUR="select id, code, name FROM currency order by code";

   public List<Currency> getCurrencyList() {
       return jdbcTemplate.query(ALL_CUR, new CurrencyRowMapper());
   }
}
