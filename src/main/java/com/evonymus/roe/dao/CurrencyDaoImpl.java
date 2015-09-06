package com.evonymus.roe.dao;

import java.util.List;

import com.evonymus.roe.model.Currency;

public class CurrencyDaoImpl extends BaseDaoImpl implements CurrencyDao {
    private static final String ALL_CUR="select id, code, name FROM currency order by code";
    private static final String CUR_COUNTRY = "select id_currency, currency_code, currency_name "
        + " FROM v_currency_country WHERE id_country=?";
    private static final String CUR_PER_DIEM = "select id_currency, currency_code, currency_name "
        + " FROM v_currency_per_diem_country WHERE per_diem_period_date_to is null AND  id_country=?";

    public List<Currency> getCurrencyList() {
        return jdbcTemplate.query(ALL_CUR, new CurrencyRowMapper());
    }
    public Currency getCountryCurrency(int idCountry){
        Object[] args = new Object[] {idCountry};
        return jdbcTemplate.queryForObject(CUR_COUNTRY, args, new CurrencyRowMapper());
    }
    public Currency getPerDiemCurrency(int idCountry){
        Object[] args = new Object[] {idCountry};
        return jdbcTemplate.queryForObject(CUR_PER_DIEM, args, new CurrencyRowMapper());
    }
}
