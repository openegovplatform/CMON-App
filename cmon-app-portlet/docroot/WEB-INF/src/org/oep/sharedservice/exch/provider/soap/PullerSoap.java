package org.oep.sharedservice.exch.provider.soap;

import com.liferay.portal.kernel.util.StringPool;

public class PullerSoap extends AuthSoap{
	
	private static final long serialVersionUID = -279761073651244823L;
	
	/** Ma don vi tiep nhan */
	private String maDonViTiepNhan = StringPool.BLANK;

	/**
	 * @return the maDonViTiepNhan
	 */
	public String getMaDonViTiepNhan() {
		return maDonViTiepNhan;
	}

	/**
	 * @param maDonViTiepNhan the maDonViTiepNhan to set
	 */
	public void setMaDonViTiepNhan(String maDonViTiepNhan) {
		this.maDonViTiepNhan = maDonViTiepNhan;
	}
}
