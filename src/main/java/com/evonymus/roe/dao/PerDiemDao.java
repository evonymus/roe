package com.evonymus.roe.dao;

import java.util.List;

import com.evonymus.roe.model.PerDiem;

public interface PerDiemDao {
    List<PerDiem> getCurrentPerDiemList();
    PerDiem getCountryPerDiem(int idCountry); 
}
