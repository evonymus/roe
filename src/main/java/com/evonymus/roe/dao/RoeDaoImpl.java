package com.evonymus.roe.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evonymus.roe.model.Roe;
@Component
public class RoeDaoImpl extends BaseDaoImpl implements RoeDao {
	private final static String ALL_FOR_DAY = "SELECT id, published, tab_id, code, roe, name_pl FROM nbp_roe WHERE published = ?";
	private final static String ROE_FOR_DAY = "SELECT id, published, tab_id, code, roe, name_pl FROM nbp_roe WHERE published < ? AND code=? order by published desc limit 1";
    private final static String ALL_CODE = "SELECT code FROM nbp_roe GROUP BY code";

	public List<Roe> getListForDay(Date date) {
        //removing time part from date value
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);

        Date args[] = new Date[] {cal.getTime()};
        return jdbcTemplate.query(ALL_FOR_DAY, args, new RoeRowMapper());
	}

	public Roe getRoeForDay(Date date, String code) {
        //removing time part from date value
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);

		Object args[] = new Object[] {cal.getTime(), code.toUpperCase()};
		return jdbcTemplate.queryForObject(ROE_FOR_DAY, args, new RoeRowMapper());
	}

    public List<String>getCodeList() {
        return jdbcTemplate.queryForList(ALL_CODE, String.class);

    }

}
