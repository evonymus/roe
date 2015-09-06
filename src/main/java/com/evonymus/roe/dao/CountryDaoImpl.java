package com.evonymus.roe.dao;

import java.util.List;

import com.evonymus.roe.model.Country;

public class CountryDaoImpl extends BaseDaoImpl implements CountryDao {
    private static final String COUNTRY_LIST = "select id, name, iso, id_currency from country order by name";
    private static final String GET_COUNTRY = "select id, name, iso, id_currency from country where id = ?";
    public List<Country> getCountryList() {
        return jdbcTemplate.query(COUNTRY_LIST, new CountryRowMapper());
    }

    public Country getCountry(int idCountry) {
        Object[] args = new Object[] {idCountry};
        return jdbcTemplate.queryForObject(GET_COUNTRY, args, new CountryRowMapper());
    }
}
