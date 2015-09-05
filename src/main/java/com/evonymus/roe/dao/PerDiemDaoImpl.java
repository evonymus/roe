package com.evonymus.roe.dao;

import java.util.List;

import com.evonymus.roe.model.PerDiem;

public class PerDiemDaoImpl extends BaseDaoImpl implements PerDiemDao {
    private static final String CURRENT_LIST = "select p.id, p.rate, p.currency_id, p.id_currency, p.id_per_diem_period "
        + " c.code, c.name, d.date_from, d.date_to "
        + " from per_diem p "
        + " inner join currency c on c.id = p.id_currency "
        + " inner join per_diem_period d on d.id = p.per_diem_period "
        + " where d.dateTo is null";

    private static final String PER_DIEM_FOR_COUNTRY = "select p.id, p.rate, p.currency_id, p.id_currency, p.id_per_diem_period "
        + " c.code, c.name, d.date_from, d.date_to "
        + " from per_diem p "
        + " inner join currency c on c.id = p.id_currency "
        + " inner join per_diem_period d on d.id = p.per_diem_period "
        + " inner join country_x_per_diem x on x.id_per_diem = p.id AND x.id_country = ?"
        + " where d.dateTo is null AND ";

    public List<PerDiem> getCurrentPerDiemList() {
        return jdbcTemplate.query(CURRENT_LIST, new PerDiemRowMapper());
    }

    public PerDiem getCountryPerDiem(int idCountry) {
        Object[] args = new Object[] {idCountry};
        return jdbcTemplate.queryForObject(PER_DIEM_FOR_COUNTRY, args, new PerDiemRowMapper());
    }
    
}
