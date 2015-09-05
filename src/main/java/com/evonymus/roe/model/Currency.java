package com.evonymus.roe.model;

public class Currency {
    private Integer id;
    private String code;
    private String name;

    public Currency() {
    }

    public Currency(Integer id,
            String curCode,
            String curName) {
        this.id = id;
        this.code = curCode;
        this.name = curName;
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
    public String getCode() {
        return code;
    }

    /**
     * @param curCode the curCode to set
     */
    public void setCode(String curCode) {
        this.code = curCode;
    }

    /**
     * @return the curName
     */
    public String getName() {
        return name;
    }

    /**
     * @param curName the curName to set
     */
    public void setName(String curName) {
        this.name = curName;
    }

}
