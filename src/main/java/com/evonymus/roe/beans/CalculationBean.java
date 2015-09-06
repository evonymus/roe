package com.evonymus.roe.beans;

import java.util.Date;

import com.evonymus.roe.model.Country;
import com.evonymus.roe.model.Currency;
import com.evonymus.roe.model.PerDiem;
import com.evonymus.roe.model.Roe;

/* class containig details of settlemnt of per diem
 */
public class CalculationBean {
    private Date dateFrom;
    private Date dateTo;
    private int days;
    private int hours;
    private Currency currency;
    private double dueInCurrency;
    private Roe roe;
    private double dueInPLN;
    private Country country;
    private PerDiem perDiem;

    /**
     * @return the dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return the days
     */
    public int getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the dueInCurrency
     */
    public double getDueInCurrency() {
        return dueInCurrency;
    }

    /**
     * @param dueInCurrency the dueInCurrency to set
     */
    public void setDueInCurrency(double dueInCurrency) {
        this.dueInCurrency = dueInCurrency;
    }

    /**
     * @return the roe
     */
    public Roe getRoe() {
        return roe;
    }

    /**
     * @param roe the roe to set
     */
    public void setRoe(Roe roe) {
        this.roe = roe;
    }

    /**
     * @return the dueInPLN
     */
    public double getDueInPLN() {
        return dueInPLN;
    }

    /**
     * @param dueInPLN the dueInPLN to set
     */
    public void setDueInPLN(double dueInPLN) {
        this.dueInPLN = dueInPLN;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the perDiem
     */
    public PerDiem getPerDiem() {
        return perDiem;
    }

    /**
     * @param perDiem the perDiem to set
     */
    public void setPerDiem(PerDiem perDiem) {
        this.perDiem = perDiem;
    }
}
