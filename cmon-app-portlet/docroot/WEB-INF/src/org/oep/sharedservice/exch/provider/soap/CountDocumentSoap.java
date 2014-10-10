package org.oep.sharedservice.exch.provider.soap;

public class CountDocumentSoap extends ResponseSignalSoap{
	
	/** Serial number */
	private static final long serialVersionUID = -3563167087202699958L;
	
	private int countDocument = 0;

	/**
	 * @return the countDocument
	 */
	public int getCountDocument() {
		return countDocument;
	}

	/**
	 * @param countDocument the countDocument to set
	 */
	public void setCountDocument(int countDocument) {
		this.countDocument = countDocument;
	}
}
