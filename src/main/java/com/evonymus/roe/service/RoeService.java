package com.evonymus.roe.service;

import java.util.Date;
import java.util.List;

import com.evonymus.roe.model.Roe;

public interface RoeService {
	List<Roe> getListForDay(Date date);
	Roe getRoeForDay(Date date, String code);
    List<String>getCodeList();
}
