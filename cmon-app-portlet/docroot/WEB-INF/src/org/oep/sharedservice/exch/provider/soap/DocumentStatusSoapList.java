package org.oep.sharedservice.exch.provider.soap;

public class DocumentStatusSoapList extends AuthSoap{

	private static final long serialVersionUID = -5995099678756812291L;
	
	private DocumentStatusSoap[] documentStatusSoapList = new DocumentStatusSoap[0];

	/**
	 * @return the documentStatusSoapList
	 */
	public DocumentStatusSoap[] getDocumentStatusSoapList() {
		return documentStatusSoapList;
	}

	/**
	 * @param documentStatusSoapList the documentStatusSoapList to set
	 */
	public void setDocumentStatusSoapList(
			DocumentStatusSoap[] documentStatusSoapList) {
		this.documentStatusSoapList = documentStatusSoapList;
	}
	
}
