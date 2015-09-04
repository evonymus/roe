package com.evonymus.roe.model;

public class Currency {
    private Integer id;
    private String curCode;
    private String curName;

    public Currency() {
    }

    public Currency(Integer id,
            String curCode,
            String curName) {
        this.id = id;
        this.curCode = curCode;
        this.curName = curName;
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
     * @return the curCode
     */
    public String getCurCode() {
        return curCode;
    }

    /**
     * @param curCode the curCode to set
     */
    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    /**
     * @return the curName
     */
    public String getCurName() {
        return curName;
    }

    /**
     * @param curName the curName to set
     */
    public void setCurName(String curName) {
        this.curName = curName;
    }

}
