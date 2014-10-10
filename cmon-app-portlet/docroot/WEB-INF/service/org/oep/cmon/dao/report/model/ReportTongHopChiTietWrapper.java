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
 * This class is a wrapper for {@link ReportTongHopChiTiet}.
 * </p>
 *
 * @author    VIENPN
 * @see       ReportTongHopChiTiet
 * @generated
 */
public class ReportTongHopChiTietWrapper implements ReportTongHopChiTiet,
	ModelWrapper<ReportTongHopChiTiet> {
	public ReportTongHopChiTietWrapper(
		ReportTongHopChiTiet reportTongHopChiTiet) {
		_reportTongHopChiTiet = reportTongHopChiTiet;
	}

	public Class<?> getModelClass() {
		return ReportTongHopChiTiet.class;
	}

	public String getModelClassName() {
		return ReportTongHopChiTiet.class.getName();
	}

	/**
	* Returns the primary key of this report tong hop chi tiet.
	*
	* @return the primary key of this report tong hop chi tiet
	*/
	public org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK getPrimaryKey() {
		return _reportTongHopChiTiet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this report tong hop chi tiet.
	*
	* @param primaryKey the primary key of this report tong hop chi tiet
	*/
	public void setPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK primaryKey) {
		_reportTongHopChiTiet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the c o q u a n q u a n l y i d of this report tong hop chi tiet.
	*
	* @return the c o q u a n q u a n l y i d of this report tong hop chi tiet
	*/
	public long getCOQUANQUANLYID() {
		return _reportTongHopChiTiet.getCOQUANQUANLYID();
	}

	/**
	* Sets the c o q u a n q u a n l y i d of this report tong hop chi tiet.
	*
	* @param COQUANQUANLYID the c o q u a n q u a n l y i d of this report tong hop chi tiet
	*/
	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_reportTongHopChiTiet.setCOQUANQUANLYID(COQUANQUANLYID);
	}

	/**
	* Returns the n h o m t h u t u c h a n h c h i n h i d of this report tong hop chi tiet.
	*
	* @return the n h o m t h u t u c h a n h c h i n h i d of this report tong hop chi tiet
	*/
	public long getNHOMTHUTUCHANHCHINHID() {
		return _reportTongHopChiTiet.getNHOMTHUTUCHANHCHINHID();
	}

	/**
	* Sets the n h o m t h u t u c h a n h c h i n h i d of this report tong hop chi tiet.
	*
	* @param NHOMTHUTUCHANHCHINHID the n h o m t h u t u c h a n h c h i n h i d of this report tong hop chi tiet
	*/
	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_reportTongHopChiTiet.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the t h u t u c h a n h c h i n h i d of this report tong hop chi tiet.
	*
	* @return the t h u t u c h a n h c h i n h i d of this report tong hop chi tiet
	*/
	public long getTHUTUCHANHCHINHID() {
		return _reportTongHopChiTiet.getTHUTUCHANHCHINHID();
	}

	/**
	* Sets the t h u t u c h a n h c h i n h i d of this report tong hop chi tiet.
	*
	* @param THUTUCHANHCHINHID the t h u t u c h a n h c h i n h i d of this report tong hop chi tiet
	*/
	public void setTHUTUCHANHCHINHID(long THUTUCHANHCHINHID) {
		_reportTongHopChiTiet.setTHUTUCHANHCHINHID(THUTUCHANHCHINHID);
	}

	/**
	* Returns the t h a n g of this report tong hop chi tiet.
	*
	* @return the t h a n g of this report tong hop chi tiet
	*/
	public int getTHANG() {
		return _reportTongHopChiTiet.getTHANG();
	}

	/**
	* Sets the t h a n g of this report tong hop chi tiet.
	*
	* @param THANG the t h a n g of this report tong hop chi tiet
	*/
	public void setTHANG(int THANG) {
		_reportTongHopChiTiet.setTHANG(THANG);
	}

	/**
	* Returns the n a m of this report tong hop chi tiet.
	*
	* @return the n a m of this report tong hop chi tiet
	*/
	public int getNAM() {
		return _reportTongHopChiTiet.getNAM();
	}

	/**
	* Sets the n a m of this report tong hop chi tiet.
	*
	* @param NAM the n a m of this report tong hop chi tiet
	*/
	public void setNAM(int NAM) {
		_reportTongHopChiTiet.setNAM(NAM);
	}

	/**
	* Returns the t o n g n h a n of this report tong hop chi tiet.
	*
	* @return the t o n g n h a n of this report tong hop chi tiet
	*/
	public long getTONGNHAN() {
		return _reportTongHopChiTiet.getTONGNHAN();
	}

	/**
	* Sets the t o n g n h a n of this report tong hop chi tiet.
	*
	* @param TONGNHAN the t o n g n h a n of this report tong hop chi tiet
	*/
	public void setTONGNHAN(long TONGNHAN) {
		_reportTongHopChiTiet.setTONGNHAN(TONGNHAN);
	}

	/**
	* Returns the t i e p n h a n of this report tong hop chi tiet.
	*
	* @return the t i e p n h a n of this report tong hop chi tiet
	*/
	public long getTIEPNHAN() {
		return _reportTongHopChiTiet.getTIEPNHAN();
	}

	/**
	* Sets the t i e p n h a n of this report tong hop chi tiet.
	*
	* @param TIEPNHAN the t i e p n h a n of this report tong hop chi tiet
	*/
	public void setTIEPNHAN(long TIEPNHAN) {
		_reportTongHopChiTiet.setTIEPNHAN(TIEPNHAN);
	}

	/**
	* Returns the t o n d a u of this report tong hop chi tiet.
	*
	* @return the t o n d a u of this report tong hop chi tiet
	*/
	public long getTONDAU() {
		return _reportTongHopChiTiet.getTONDAU();
	}

	/**
	* Sets the t o n d a u of this report tong hop chi tiet.
	*
	* @param TONDAU the t o n d a u of this report tong hop chi tiet
	*/
	public void setTONDAU(long TONDAU) {
		_reportTongHopChiTiet.setTONDAU(TONDAU);
	}

	/**
	* Returns the t o n g d a g i a i q u y e t of this report tong hop chi tiet.
	*
	* @return the t o n g d a g i a i q u y e t of this report tong hop chi tiet
	*/
	public long getTONGDAGIAIQUYET() {
		return _reportTongHopChiTiet.getTONGDAGIAIQUYET();
	}

	/**
	* Sets the t o n g d a g i a i q u y e t of this report tong hop chi tiet.
	*
	* @param TONGDAGIAIQUYET the t o n g d a g i a i q u y e t of this report tong hop chi tiet
	*/
	public void setTONGDAGIAIQUYET(long TONGDAGIAIQUYET) {
		_reportTongHopChiTiet.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
	}

	/**
	* Returns the s o m of this report tong hop chi tiet.
	*
	* @return the s o m of this report tong hop chi tiet
	*/
	public long getSOM() {
		return _reportTongHopChiTiet.getSOM();
	}

	/**
	* Sets the s o m of this report tong hop chi tiet.
	*
	* @param SOM the s o m of this report tong hop chi tiet
	*/
	public void setSOM(long SOM) {
		_reportTongHopChiTiet.setSOM(SOM);
	}

	/**
	* Returns the d u n g of this report tong hop chi tiet.
	*
	* @return the d u n g of this report tong hop chi tiet
	*/
	public long getDUNG() {
		return _reportTongHopChiTiet.getDUNG();
	}

	/**
	* Sets the d u n g of this report tong hop chi tiet.
	*
	* @param DUNG the d u n g of this report tong hop chi tiet
	*/
	public void setDUNG(long DUNG) {
		_reportTongHopChiTiet.setDUNG(DUNG);
	}

	/**
	* Returns the t r e of this report tong hop chi tiet.
	*
	* @return the t r e of this report tong hop chi tiet
	*/
	public long getTRE() {
		return _reportTongHopChiTiet.getTRE();
	}

	/**
	* Sets the t r e of this report tong hop chi tiet.
	*
	* @param TRE the t r e of this report tong hop chi tiet
	*/
	public void setTRE(long TRE) {
		_reportTongHopChiTiet.setTRE(TRE);
	}

	/**
	* Returns the t o n g d a n g g i a i q u y e t of this report tong hop chi tiet.
	*
	* @return the t o n g d a n g g i a i q u y e t of this report tong hop chi tiet
	*/
	public long getTONGDANGGIAIQUYET() {
		return _reportTongHopChiTiet.getTONGDANGGIAIQUYET();
	}

	/**
	* Sets the t o n g d a n g g i a i q u y e t of this report tong hop chi tiet.
	*
	* @param TONGDANGGIAIQUYET the t o n g d a n g g i a i q u y e t of this report tong hop chi tiet
	*/
	public void setTONGDANGGIAIQUYET(long TONGDANGGIAIQUYET) {
		_reportTongHopChiTiet.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
	}

	/**
	* Returns the c h u a d e n h a n of this report tong hop chi tiet.
	*
	* @return the c h u a d e n h a n of this report tong hop chi tiet
	*/
	public long getCHUADENHAN() {
		return _reportTongHopChiTiet.getCHUADENHAN();
	}

	/**
	* Sets the c h u a d e n h a n of this report tong hop chi tiet.
	*
	* @param CHUADENHAN the c h u a d e n h a n of this report tong hop chi tiet
	*/
	public void setCHUADENHAN(long CHUADENHAN) {
		_reportTongHopChiTiet.setCHUADENHAN(CHUADENHAN);
	}

	/**
	* Returns the q u a h a n of this report tong hop chi tiet.
	*
	* @return the q u a h a n of this report tong hop chi tiet
	*/
	public long getQUAHAN() {
		return _reportTongHopChiTiet.getQUAHAN();
	}

	/**
	* Sets the q u a h a n of this report tong hop chi tiet.
	*
	* @param QUAHAN the q u a h a n of this report tong hop chi tiet
	*/
	public void setQUAHAN(long QUAHAN) {
		_reportTongHopChiTiet.setQUAHAN(QUAHAN);
	}

	/**
	* Returns the r u t h o s o of this report tong hop chi tiet.
	*
	* @return the r u t h o s o of this report tong hop chi tiet
	*/
	public long getRUTHOSO() {
		return _reportTongHopChiTiet.getRUTHOSO();
	}

	/**
	* Sets the r u t h o s o of this report tong hop chi tiet.
	*
	* @param RUTHOSO the r u t h o s o of this report tong hop chi tiet
	*/
	public void setRUTHOSO(long RUTHOSO) {
		_reportTongHopChiTiet.setRUTHOSO(RUTHOSO);
	}

	/**
	* Returns the k h o n g h o p l e of this report tong hop chi tiet.
	*
	* @return the k h o n g h o p l e of this report tong hop chi tiet
	*/
	public long getKHONGHOPLE() {
		return _reportTongHopChiTiet.getKHONGHOPLE();
	}

	/**
	* Sets the k h o n g h o p l e of this report tong hop chi tiet.
	*
	* @param KHONGHOPLE the k h o n g h o p l e of this report tong hop chi tiet
	*/
	public void setKHONGHOPLE(long KHONGHOPLE) {
		_reportTongHopChiTiet.setKHONGHOPLE(KHONGHOPLE);
	}

	/**
	* Returns the t y l e of this report tong hop chi tiet.
	*
	* @return the t y l e of this report tong hop chi tiet
	*/
	public double getTYLE() {
		return _reportTongHopChiTiet.getTYLE();
	}

	/**
	* Sets the t y l e of this report tong hop chi tiet.
	*
	* @param TYLE the t y l e of this report tong hop chi tiet
	*/
	public void setTYLE(double TYLE) {
		_reportTongHopChiTiet.setTYLE(TYLE);
	}

	/**
	* Returns the t o n c u o i of this report tong hop chi tiet.
	*
	* @return the t o n c u o i of this report tong hop chi tiet
	*/
	public long getTONCUOI() {
		return _reportTongHopChiTiet.getTONCUOI();
	}

	/**
	* Sets the t o n c u o i of this report tong hop chi tiet.
	*
	* @param TONCUOI the t o n c u o i of this report tong hop chi tiet
	*/
	public void setTONCUOI(long TONCUOI) {
		_reportTongHopChiTiet.setTONCUOI(TONCUOI);
	}

	public boolean isNew() {
		return _reportTongHopChiTiet.isNew();
	}

	public void setNew(boolean n) {
		_reportTongHopChiTiet.setNew(n);
	}

	public boolean isCachedModel() {
		return _reportTongHopChiTiet.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_reportTongHopChiTiet.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _reportTongHopChiTiet.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _reportTongHopChiTiet.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reportTongHopChiTiet.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reportTongHopChiTiet.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reportTongHopChiTiet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportTongHopChiTietWrapper((ReportTongHopChiTiet)_reportTongHopChiTiet.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet) {
		return _reportTongHopChiTiet.compareTo(reportTongHopChiTiet);
	}

	@Override
	public int hashCode() {
		return _reportTongHopChiTiet.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> toCacheModel() {
		return _reportTongHopChiTiet.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet toEscapedModel() {
		return new ReportTongHopChiTietWrapper(_reportTongHopChiTiet.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reportTongHopChiTiet.toString();
	}

	public java.lang.String toXmlString() {
		return _reportTongHopChiTiet.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportTongHopChiTiet.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ReportTongHopChiTiet getWrappedReportTongHopChiTiet() {
		return _reportTongHopChiTiet;
	}

	public ReportTongHopChiTiet getWrappedModel() {
		return _reportTongHopChiTiet;
	}

	public void resetOriginalValues() {
		_reportTongHopChiTiet.resetOriginalValues();
	}

	private ReportTongHopChiTiet _reportTongHopChiTiet;
}