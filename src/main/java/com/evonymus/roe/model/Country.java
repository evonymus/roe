package com.evonymus.roe.model;

public class Country {
    private Integer id;
    private String name;
    private String iso;
    private Integer idCurrency;

    public Country() {}

    public Country(Integer id,
            String name,
            String iso,
            Integer idCurrency) {

        this.id = id;
        this.name = name;
        this.iso = iso;
        this.idCurrency = idCurrency;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the iso
     */
    public String getIso() {
        return iso;
    }

    /**
     * @param iso the iso to set
     */
    public void setIso(String iso) {
        this.iso = iso;
    }

    /**
     * @return the idCurrency
     */
    public Integer getIdCurrency() {
        return idCurrency;
    }

    /**
     * @param idCurrency the currency to set
     */
    public void setIdCurrency(Integer idCurrency) {
        this.idCurrency = idCurrency;
    }
}
