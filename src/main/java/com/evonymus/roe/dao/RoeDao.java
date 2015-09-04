package com.evonymus.roe.dao;

import java.util.Date;
import java.util.List;

import com.evonymus.roe.model.Roe;

public interface RoeDao {
	List<Roe> getListForDay(Date date);
	Roe getRoeForDay(Date date, String code);
    List<String>getCodeList();
}
