package com.evonymus.roe.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.evonymus.roe.dao.CountryDao;
import com.evonymus.roe.model.Country;

public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao;

    public List<Country> getCountryList() {
        try {
            return countryDao.getCountryList();

        } catch(EmptyResultDataAccessException ex) {
            return null;
        }
    }

    /**
     * @return the countryDao
     */
    public CountryDao getCountryDao() {
        return countryDao;
    }

    /**
     * @param countryDao the countryDao to set
     */
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
    
}
