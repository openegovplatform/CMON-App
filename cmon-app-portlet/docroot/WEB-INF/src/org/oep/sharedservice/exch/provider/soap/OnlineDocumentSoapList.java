package org.oep.sharedservice.exch.provider.soap;

import java.util.ArrayList;

public class OnlineDocumentSoapList extends ResponseSignalSoap {
	
	private static final long serialVersionUID = 8528700417754559866L;
	
	ArrayList<OnlineDocumentSoap> onlineDocumentSoapList = new ArrayList<OnlineDocumentSoap>();
	
	/** Flag co con record hay khong (0: Het, 1: Con tiep ) */
	private int conTiep = 0;

	/**
	 * @return the onlineDocumentSoapList
	 */
	public ArrayList<OnlineDocumentSoap> getOnlineDocumentSoapList() {
		return onlineDocumentSoapList;
	}

	/**
	 * @param onlineDocumentSoapList the onlineDocumentSoapList to set
	 */
	public void setOnlineDocumentSoapList(
			ArrayList<OnlineDocumentSoap> onlineDocumentSoapList) {
		this.onlineDocumentSoapList = onlineDocumentSoapList;
	}

	/**
	 * @return the conTiep
	 */
	public int getConTiep() {
		return conTiep;
	}

	/**
	 * @param conTiep the conTiep to set
	 */
	public void setConTiep(int conTiep) {
		this.conTiep = conTiep;
	}
}
