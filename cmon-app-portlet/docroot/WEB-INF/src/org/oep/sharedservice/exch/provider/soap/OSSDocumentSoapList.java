package org.oep.sharedservice.exch.provider.soap;

public class OSSDocumentSoapList extends AuthSoap {

	private static final long serialVersionUID = -5968538391832512766L;
	
	private OSSDocumentSoap[] ossDocumentSoapList = new OSSDocumentSoap[0];

	/**
	 * @return the ossDocumentSoapList
	 */
	public OSSDocumentSoap[] getOssDocumentSoapList() {
		return ossDocumentSoapList;
	}

	/**
	 * @param ossDocumentSoapList the ossDocumentSoapList to set
	 */
	public void setOssDocumentSoapList(OSSDocumentSoap[] ossDocumentSoapList) {
		this.ossDocumentSoapList = ossDocumentSoapList;
	}	
	
}
