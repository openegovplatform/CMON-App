/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.oep.cmon.dao.report.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ReportTongHop}.
 * </p>
 *
 * @author    VIENPN
 * @see       ReportTongHop
 * @generated
 */
public class ReportTongHopWrapper implements ReportTongHop,
	ModelWrapper<ReportTongHop> {
	public ReportTongHopWrapper(ReportTongHop reportTongHop) {
		_reportTongHop = reportTongHop;
	}

	public Class<?> getModelClass() {
		return ReportTongHop.class;
	}

	public String getModelClassName() {
		return ReportTongHop.class.getName();
	}

	/**
	* Returns the primary key of this report tong hop.
	*
	* @return the primary key of this report tong hop
	*/
	public org.oep.cmon.dao.report.service.persistence.ReportTongHopPK getPrimaryKey() {
		return _reportTongHop.getPrimaryKey();
	}

	/**
	* Sets the primary key of this report tong hop.
	*
	* @param primaryKey the primary key of this report tong hop
	*/
	public void setPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK primaryKey) {
		_reportTongHop.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the c o q u a n q u a n l y i d of this report tong hop.
	*
	* @return the c o q u a n q u a n l y i d of this report tong hop
	*/
	public long getCOQUANQUANLYID() {
		return _reportTongHop.getCOQUANQUANLYID();
	}

	/**
	* Sets the c o q u a n q u a n l y i d of this report tong hop.
	*
	* @param COQUANQUANLYID the c o q u a n q u a n l y i d of this report tong hop
	*/
	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_reportTongHop.setCOQUANQUANLYID(COQUANQUANLYID);
	}

	/**
	* Returns the n h o m t h u t u c h a n h c h i n h i d of this report tong hop.
	*
	* @return the n h o m t h u t u c h a n h c h i n h i d of this report tong hop
	*/
	public long getNHOMTHUTUCHANHCHINHID() {
		return _reportTongHop.getNHOMTHUTUCHANHCHINHID();
	}

	/**
	* Sets the n h o m t h u t u c h a n h c h i n h i d of this report tong hop.
	*
	* @param NHOMTHUTUCHANHCHINHID the n h o m t h u t u c h a n h c h i n h i d of this report tong hop
	*/
	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_reportTongHop.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the t h a n g of this report tong hop.
	*
	* @return the t h a n g of this report tong hop
	*/
	public int getTHANG() {
		return _reportTongHop.getTHANG();
	}

	/**
	* Sets the t h a n g of this report tong hop.
	*
	* @param THANG the t h a n g of this report tong hop
	*/
	public void setTHANG(int THANG) {
		_reportTongHop.setTHANG(THANG);
	}

	/**
	* Returns the n a m of this report tong hop.
	*
	* @return the n a m of this report tong hop
	*/
	public int getNAM() {
		return _reportTongHop.getNAM();
	}

	/**
	* Sets the n a m of this report tong hop.
	*
	* @param NAM the n a m of this report tong hop
	*/
	public void setNAM(int NAM) {
		_reportTongHop.setNAM(NAM);
	}

	/**
	* Returns the t o n g n h a n of this report tong hop.
	*
	* @return the t o n g n h a n of this report tong hop
	*/
	public long getTONGNHAN() {
		return _reportTongHop.getTONGNHAN();
	}

	/**
	* Sets the t o n g n h a n of this report tong hop.
	*
	* @param TONGNHAN the t o n g n h a n of this report tong hop
	*/
	public void setTONGNHAN(long TONGNHAN) {
		_reportTongHop.setTONGNHAN(TONGNHAN);
	}

	/**
	* Returns the t i e p n h a n of this report tong hop.
	*
	* @return the t i e p n h a n of this report tong hop
	*/
	public long getTIEPNHAN() {
		return _reportTongHop.getTIEPNHAN();
	}

	/**
	* Sets the t i e p n h a n of this report tong hop.
	*
	* @param TIEPNHAN the t i e p n h a n of this report tong hop
	*/
	public void setTIEPNHAN(long TIEPNHAN) {
		_reportTongHop.setTIEPNHAN(TIEPNHAN);
	}

	/**
	* Returns the t o n d a u of this report tong hop.
	*
	* @return the t o n d a u of this report tong hop
	*/
	public long getTONDAU() {
		return _reportTongHop.getTONDAU();
	}

	/**
	* Sets the t o n d a u of this report tong hop.
	*
	* @param TONDAU the t o n d a u of this report tong hop
	*/
	public void setTONDAU(long TONDAU) {
		_reportTongHop.setTONDAU(TONDAU);
	}

	/**
	* Returns the t o n g d a g i a i q u y e t of this report tong hop.
	*
	* @return the t o n g d a g i a i q u y e t of this report tong hop
	*/
	public long getTONGDAGIAIQUYET() {
		return _reportTongHop.getTONGDAGIAIQUYET();
	}

	/**
	* Sets the t o n g d a g i a i q u y e t of this report tong hop.
	*
	* @param TONGDAGIAIQUYET the t o n g d a g i a i q u y e t of this report tong hop
	*/
	public void setTONGDAGIAIQUYET(long TONGDAGIAIQUYET) {
		_reportTongHop.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
	}

	/**
	* Returns the s o m of this report tong hop.
	*
	* @return the s o m of this report tong hop
	*/
	public long getSOM() {
		return _reportTongHop.getSOM();
	}

	/**
	* Sets the s o m of this report tong hop.
	*
	* @param SOM the s o m of this report tong hop
	*/
	public void setSOM(long SOM) {
		_reportTongHop.setSOM(SOM);
	}

	/**
	* Returns the d u n g of this report tong hop.
	*
	* @return the d u n g of this report tong hop
	*/
	public long getDUNG() {
		return _reportTongHop.getDUNG();
	}

	/**
	* Sets the d u n g of this report tong hop.
	*
	* @param DUNG the d u n g of this report tong hop
	*/
	public void setDUNG(long DUNG) {
		_reportTongHop.setDUNG(DUNG);
	}

	/**
	* Returns the t r e of this report tong hop.
	*
	* @return the t r e of this report tong hop
	*/
	public long getTRE() {
		return _reportTongHop.getTRE();
	}

	/**
	* Sets the t r e of this report tong hop.
	*
	* @param TRE the t r e of this report tong hop
	*/
	public void setTRE(long TRE) {
		_reportTongHop.setTRE(TRE);
	}

	/**
	* Returns the t o n g d a n g g i a i q u y e t of this report tong hop.
	*
	* @return the t o n g d a n g g i a i q u y e t of this report tong hop
	*/
	public long getTONGDANGGIAIQUYET() {
		return _reportTongHop.getTONGDANGGIAIQUYET();
	}

	/**
	* Sets the t o n g d a n g g i a i q u y e t of this report tong hop.
	*
	* @param TONGDANGGIAIQUYET the t o n g d a n g g i a i q u y e t of this report tong hop
	*/
	public void setTONGDANGGIAIQUYET(long TONGDANGGIAIQUYET) {
		_reportTongHop.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
	}

	/**
	* Returns the c h u a d e n h a n of this report tong hop.
	*
	* @return the c h u a d e n h a n of this report tong hop
	*/
	public long getCHUADENHAN() {
		return _reportTongHop.getCHUADENHAN();
	}

	/**
	* Sets the c h u a d e n h a n of this report tong hop.
	*
	* @param CHUADENHAN the c h u a d e n h a n of this report tong hop
	*/
	public void setCHUADENHAN(long CHUADENHAN) {
		_reportTongHop.setCHUADENHAN(CHUADENHAN);
	}

	/**
	* Returns the q u a h a n of this report tong hop.
	*
	* @return the q u a h a n of this report tong hop
	*/
	public long getQUAHAN() {
		return _reportTongHop.getQUAHAN();
	}

	/**
	* Sets the q u a h a n of this report tong hop.
	*
	* @param QUAHAN the q u a h a n of this report tong hop
	*/
	public void setQUAHAN(long QUAHAN) {
		_reportTongHop.setQUAHAN(QUAHAN);
	}

	/**
	* Returns the r u t h o s o of this report tong hop.
	*
	* @return the r u t h o s o of this report tong hop
	*/
	public long getRUTHOSO() {
		return _reportTongHop.getRUTHOSO();
	}

	/**
	* Sets the r u t h o s o of this report tong hop.
	*
	* @param RUTHOSO the r u t h o s o of this report tong hop
	*/
	public void setRUTHOSO(long RUTHOSO) {
		_reportTongHop.setRUTHOSO(RUTHOSO);
	}

	/**
	* Returns the k h o n g h o p l e of this report tong hop.
	*
	* @return the k h o n g h o p l e of this report tong hop
	*/
	public long getKHONGHOPLE() {
		return _reportTongHop.getKHONGHOPLE();
	}

	/**
	* Sets the k h o n g h o p l e of this report tong hop.
	*
	* @param KHONGHOPLE the k h o n g h o p l e of this report tong hop
	*/
	public void setKHONGHOPLE(long KHONGHOPLE) {
		_reportTongHop.setKHONGHOPLE(KHONGHOPLE);
	}

	/**
	* Returns the t y l e of this report tong hop.
	*
	* @return the t y l e of this report tong hop
	*/
	public double getTYLE() {
		return _reportTongHop.getTYLE();
	}

	/**
	* Sets the t y l e of this report tong hop.
	*
	* @param TYLE the t y l e of this report tong hop
	*/
	public void setTYLE(double TYLE) {
		_reportTongHop.setTYLE(TYLE);
	}

	/**
	* Returns the t o n c u o i of this report tong hop.
	*
	* @return the t o n c u o i of this report tong hop
	*/
	public long getTONCUOI() {
		return _reportTongHop.getTONCUOI();
	}

	/**
	* Sets the t o n c u o i of this report tong hop.
	*
	* @param TONCUOI the t o n c u o i of this report tong hop
	*/
	public void setTONCUOI(long TONCUOI) {
		_reportTongHop.setTONCUOI(TONCUOI);
	}

	public boolean isNew() {
		return _reportTongHop.isNew();
	}

	public void setNew(boolean n) {
		_reportTongHop.setNew(n);
	}

	public boolean isCachedModel() {
		return _reportTongHop.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_reportTongHop.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _reportTongHop.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _reportTongHop.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reportTongHop.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reportTongHop.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reportTongHop.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportTongHopWrapper((ReportTongHop)_reportTongHop.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.ReportTongHop reportTongHop) {
		return _reportTongHop.compareTo(reportTongHop);
	}

	@Override
	public int hashCode() {
		return _reportTongHop.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.ReportTongHop> toCacheModel() {
		return _reportTongHop.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.ReportTongHop toEscapedModel() {
		return new ReportTongHopWrapper(_reportTongHop.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reportTongHop.toString();
	}

	public java.lang.String toXmlString() {
		return _reportTongHop.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportTongHop.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ReportTongHop getWrappedReportTongHop() {
		return _reportTongHop;
	}

	public ReportTongHop getWrappedModel() {
		return _reportTongHop;
	}

	public void resetOriginalValues() {
		_reportTongHop.resetOriginalValues();
	}

	private ReportTongHop _reportTongHop;
}