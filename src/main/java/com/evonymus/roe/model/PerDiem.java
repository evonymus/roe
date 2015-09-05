package com.evonymus.roe.model;

public class PerDiem {

    private Integer id;
    private Double rate;
    private Currency currency;
    private PerDiemPeriod perDiemPeriod;

    public PerDiem(){}

    public PerDiem(Integer id,
            Double rate,
            Currency currency,
            PerDiemPeriod perDiemPeriod) {

        this.id = id;
        this.rate = rate;
        this.currency = currency;
        this.perDiemPeriod = perDiemPeriod;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
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
     * @return the perDiemPeriod
     */
    public PerDiemPeriod getPerDiemPeriod() {
        return perDiemPeriod;
    }

    /**
     * @param perDiemPeriod the perDiemPeriod to set
     */
    public void setPerDiemPeriod(PerDiemPeriod perDiemPeriod) {
        this.perDiemPeriod = perDiemPeriod;
    }

}
