package org.oep.sharedservice.exch.provider.soap;

import java.io.Serializable;

import com.liferay.portal.kernel.util.StringPool;

public class ResponseSignalSoap implements Serializable {
	
	private static final long serialVersionUID = -6070748633787182452L;

	/** Error code */
	private String errCode = "0";
	
	/** Error message */
	private String errMsg = StringPool.BLANK;

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
