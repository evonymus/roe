package com.evonymus.roe.service;

import java.util.List;

import com.evonymus.roe.model.PerDiem;

public interface PerDiemService {
    List<PerDiem>getCurrentPerDiemList();
    PerDiem getCountryPerDiem(int idCountry);
    
}
