package org.oep.sharedservice.cmon.provider.model;

import java.io.Serializable;

import org.oep.cmon.dao.tlct.model.TaiLieuChungThucSoap;



public class ResultUpload implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean result = false;
	private String code;
	private TaiLieuChungThucSoap document;
	private Long fileId;
	private String url;
	private Long thuTuc2GiayToId;
	
	
	
	public Long getThuTuc2GiayToId() {
		return thuTuc2GiayToId;
	}
	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		this.thuTuc2GiayToId = thuTuc2GiayToId;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public TaiLieuChungThucSoap getDocument() {
		return document;
	}
	public void setDocument(TaiLieuChungThucSoap document) {
		this.document = document;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
