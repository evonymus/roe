package com.evonymus.roe.dao;

import java.util.List;

import com.evonymus.roe.model.Country;

public interface CountryDao {
    List<Country> getCountryList();
    List<Country> getCountryListSelected(String sel);
    Country getCountry(int idCountry);

}
