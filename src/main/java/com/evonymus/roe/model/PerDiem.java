package com.evonymus.roe.model;

public class PerDiem {
    private Integer id;
    private Integer idCurrency;
    private Double rate;
    private Integer idPerDiemPeriod;

    public PerDiem() {}

    public PerDiem(Integer id,
            Integer idCurrency,
            Double rate,
            Integer idPerDiemPeriod) {

        this.id = id;
        this.idCurrency = idCurrency;
        this.rate = rate;
        this.idPerDiemPeriod = idPerDiemPeriod;

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
     * @return the idCurrency
     */
    public Integer getIdCurrency() {
        return idCurrency;
    }

    /**
     * @param idCurrency the idCurrency to set
     */
    public void setIdCurrency(Integer idCurrency) {
        this.idCurrency = idCurrency;
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
     * @return the idPerDiemPeriod
     */
    public Integer getIdPerDiemPeriod() {
        return idPerDiemPeriod;
    }

    /**
     * @param idPerDiemPeriod the idPerDiemPeriod to set
     */
    public void setIdPerDiemPeriod(Integer idPerDiemPeriod) {
        this.idPerDiemPeriod = idPerDiemPeriod;
    }
}
