package com.evonymus.roe.model;
import java.io.Serializable;
import java.util.Date;

public class Roe implements Serializable{
	
	private static final long serialVersionUID = -4549035360872485262L;
	private Integer id;
	private Date published;
	private String tabId;
	private String code;
	private Double roe;
	private String name;
	
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final Date getPublished() {
		return published;
	}
	public final void setPublished(Date published) {
		this.published = published;
	}
	public final String getTabId() {
		return tabId;
	}
	public final void setTabId(String tabId) {
		this.tabId = tabId;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(String code) {
		this.code = code;
	}
	public final Double getRoe() {
		return roe;
	}
	public final void setRoe(Double roe) {
		this.roe = roe;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	


}
