package org.oep.sharedservice.exch.provider.soap;

import java.io.Serializable;

import com.liferay.portal.kernel.util.StringPool;

public class OnlineAttachmentSoap implements Serializable {
	
	/** Ten tai lieu dinh kem */
	private String tenTaiLieuDinhKem = StringPool.BLANK;
	
	/** URL dung de download tai lieu dinh kem */
	private String urlTaiLieuDinhKem = StringPool.BLANK;
	
	/** Ten file upload */
	private String tenFile = StringPool.BLANK;

	/**
	 * @return the tenTaiLieuDinhKem
	 */
	public String getTenTaiLieuDinhKem() {
		return tenTaiLieuDinhKem;
	}

	/**
	 * @param tenTaiLieuDinhKem the tenTaiLieuDinhKem to set
	 */
	public void setTenTaiLieuDinhKem(String tenTaiLieuDinhKem) {
		this.tenTaiLieuDinhKem = tenTaiLieuDinhKem;
	}

	/**
	 * @return the urlTaiLieuDinhKem
	 */
	public String getUrlTaiLieuDinhKem() {
		return urlTaiLieuDinhKem;
	}

	/**
	 * @param urlTaiLieuDinhKem the urlTaiLieuDinhKem to set
	 */
	public void setUrlTaiLieuDinhKem(String urlTaiLieuDinhKem) {
		this.urlTaiLieuDinhKem = urlTaiLieuDinhKem;
	}

	/**
	 * @return the tenFile
	 */
	public String getTenFile() {
		return tenFile;
	}

	/**
	 * @param tenFile the tenFile to set
	 */
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
}
