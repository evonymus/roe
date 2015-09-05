package com.evonymus.roe.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.evonymus.roe.dao.PerDiemDao;
import com.evonymus.roe.model.PerDiem;

public class PerDiemServiceImpl {

    private PerDiemDao perDiemDao;
    
    public List<PerDiem>getCurrentPerDiemList() {
        try {
            return perDiemDao.getCurrentPerDiemList();
        } catch (EmptyResultDataAccessException ex) {
            return  null;
        }
    }

	public PerDiem getCountryPerDiem(int idCountry) {
        try {
            return perDiemDao.getCountryPerDiem(idCountry);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

	/**
	 * @return the perDiemDao
	 */
	public PerDiemDao getPerDiemDao() {
		return perDiemDao;
	}

	/**
	 * @param perDiemDao the perDiemDao to set
	 */
	public void setPerDiemDao(PerDiemDao perDiemDao) {
		this.perDiemDao = perDiemDao;
	}
}
