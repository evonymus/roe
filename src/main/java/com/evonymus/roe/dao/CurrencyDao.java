package com.evonymus.roe.dao;

import java.util.List;
import com.evonymus.roe.model.Currency;

public interface CurrencyDao {
    List<Currency> getCurrencyList();
    Currency getCountryCurrency(int idCountry);
    Currency getPerDiemCurrency(int idCountry);
}
