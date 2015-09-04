package com.evonymus.roe.service;

import java.util.List;

import com.evonymus.roe.dao.CurrencyDao;
import com.evonymus.roe.model.Currency;

public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyDao currencyDao;
    public List<Currency>getCurrencyList() {
        return currencyDao.getCurrencyList();
    }

    /**
     * @return the currencyDao
     */
    public CurrencyDao getCurrencyDao() {
        return currencyDao;
    }

    /**
     * @param currencyDao the currencyDao to set
     */
    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }
    
}
