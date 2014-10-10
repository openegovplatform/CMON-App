package org.oep.sharedservice.exch.provider.soap;

public class DocumentResultSoapList extends AuthSoap{	

	private static final long serialVersionUID = -2042775979342085622L;
	
	private DocumentResultSoap[] documentResultSoapList = new DocumentResultSoap[0];

	/**
	 * @return the documentResultSoapList
	 */
	public DocumentResultSoap[] getDocumentResultSoapList() {
		return documentResultSoapList;
	}

	/**
	 * @param documentResultSoapList the documentResultSoapList to set
	 */
	public void setDocumentResultSoapList(
			DocumentResultSoap[] documentResultSoapList) {
		this.documentResultSoapList = documentResultSoapList;
	}
}
