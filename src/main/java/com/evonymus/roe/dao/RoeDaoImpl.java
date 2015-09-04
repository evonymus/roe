package com.evonymus.roe.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evonymus.roe.model.Roe;
@Component
public class RoeDaoImpl extends BaseDaoImpl implements RoeDao {
	private final static String ALL_FOR_DAY = "SELECT id, published, tab_id, code, roe, name FROM nbp_roe WHERE published = ?";
	private final static String ROE_FOR_DAY = "SELECT id, published, tab_id, code, roe, name FROM nbp_roe WHERE published = ? AND code=?";
    private final static String ALL_CODE = "SELECT code FROM nbp_roe GROUP BY code";

	public List<Roe> getListForDay(Date date) {
        Date args[] = new Date[] {date};
        return jdbcTemplate.query(ALL_FOR_DAY, args, new RoeRowMapper());
	}

	public Roe getRoeForDay(Date date, String code) {
		Object args[] = new Object[] {date, code.toUpperCase()};
		return jdbcTemplate.queryForObject(ROE_FOR_DAY, args, new RoeRowMapper());
	}

    public List<String>getCodeList() {
        return jdbcTemplate.queryForList(ALL_CODE, String.class);

    }

}
