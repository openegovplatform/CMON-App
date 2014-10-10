package org.oep.sharedservice.cmon.provider.thamso;

import java.io.Serializable;

public class AnhXaInput implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String appCode;
	private String table;
	private String code;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private Long id;
	
	
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
