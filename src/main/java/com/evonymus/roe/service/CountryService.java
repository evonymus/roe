package com.evonymus.roe.service;

import java.util.List;

import com.evonymus.roe.model.Country;

public interface CountryService {
    List<Country> getCountryList();
    Country getCountry(int idCountry);
    
}
