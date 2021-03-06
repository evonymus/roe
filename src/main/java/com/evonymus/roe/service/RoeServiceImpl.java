package com.evonymus.roe.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.evonymus.roe.dao.RoeDao;
import com.evonymus.roe.model.Roe;

public class RoeServiceImpl implements RoeService{
	private RoeDao roeDao;
	

	public final RoeDao getRoeDao() {
		return roeDao;
	}

	public final void setRoeDao(RoeDao roeDao) {
		this.roeDao = roeDao;
	}

	public List<Roe> getListForDay(final Date date) {
		try {
			return roeDao.getListForDay(date);
			
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	public Roe getRoeForDay(final Date date, String code) {
		try {
			return roeDao.getRoeForDay(date, code);
			
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
   public List<String>getCodeList() {
       try {
           return roeDao.getCodeList();
       } catch (EmptyResultDataAccessException ex) {
           return null;
       }
   }

}
