package org.oep.sharedservice.exch.provider.soap;


public class OnlineRecordSoapList extends AuthSoap {

	private static final long serialVersionUID = 1667255197390405537L;
	
	/** Online record id list */
	private long[] idList = new long[0];

	/**
	 * @return the idList
	 */
	public long[] getIdList() {
		return idList;
	}

	/**
	 * @param idList the idList to set
	 */
	public void setIdList(long[] idList) {
		this.idList = idList;
	}
}
