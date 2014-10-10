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
 * This class is a wrapper for {@link ReportThongKe}.
 * </p>
 *
 * @author    VIENPN
 * @see       ReportThongKe
 * @generated
 */
public class ReportThongKeWrapper implements ReportThongKe,
	ModelWrapper<ReportThongKe> {
	public ReportThongKeWrapper(ReportThongKe reportThongKe) {
		_reportThongKe = reportThongKe;
	}

	public Class<?> getModelClass() {
		return ReportThongKe.class;
	}

	public String getModelClassName() {
		return ReportThongKe.class.getName();
	}

	/**
	* Returns the primary key of this report thong ke.
	*
	* @return the primary key of this report thong ke
	*/
	public org.oep.cmon.dao.report.service.persistence.ReportThongKePK getPrimaryKey() {
		return _reportThongKe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this report thong ke.
	*
	* @param primaryKey the primary key of this report thong ke
	*/
	public void setPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportThongKePK primaryKey) {
		_reportThongKe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the c a p c o q u a n q u a n l y i d of this report thong ke.
	*
	* @return the c a p c o q u a n q u a n l y i d of this report thong ke
	*/
	public long getCAPCOQUANQUANLYID() {
		return _reportThongKe.getCAPCOQUANQUANLYID();
	}

	/**
	* Sets the c a p c o q u a n q u a n l y i d of this report thong ke.
	*
	* @param CAPCOQUANQUANLYID the c a p c o q u a n q u a n l y i d of this report thong ke
	*/
	public void setCAPCOQUANQUANLYID(long CAPCOQUANQUANLYID) {
		_reportThongKe.setCAPCOQUANQUANLYID(CAPCOQUANQUANLYID);
	}

	/**
	* Returns the c o q u a n q u a n l y i d of this report thong ke.
	*
	* @return the c o q u a n q u a n l y i d of this report thong ke
	*/
	public long getCOQUANQUANLYID() {
		return _reportThongKe.getCOQUANQUANLYID();
	}

	/**
	* Sets the c o q u a n q u a n l y i d of this report thong ke.
	*
	* @param COQUANQUANLYID the c o q u a n q u a n l y i d of this report thong ke
	*/
	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_reportThongKe.setCOQUANQUANLYID(COQUANQUANLYID);
	}

	/**
	* Returns the t h a n g of this report thong ke.
	*
	* @return the t h a n g of this report thong ke
	*/
	public int getTHANG() {
		return _reportThongKe.getTHANG();
	}

	/**
	* Sets the t h a n g of this report thong ke.
	*
	* @param THANG the t h a n g of this report thong ke
	*/
	public void setTHANG(int THANG) {
		_reportThongKe.setTHANG(THANG);
	}

	/**
	* Returns the n a m of this report thong ke.
	*
	* @return the n a m of this report thong ke
	*/
	public int getNAM() {
		return _reportThongKe.getNAM();
	}

	/**
	* Sets the n a m of this report thong ke.
	*
	* @param NAM the n a m of this report thong ke
	*/
	public void setNAM(int NAM) {
		_reportThongKe.setNAM(NAM);
	}

	/**
	* Returns the t o n g n h a n of this report thong ke.
	*
	* @return the t o n g n h a n of this report thong ke
	*/
	public long getTONGNHAN() {
		return _reportThongKe.getTONGNHAN();
	}

	/**
	* Sets the t o n g n h a n of this report thong ke.
	*
	* @param TONGNHAN the t o n g n h a n of this report thong ke
	*/
	public void setTONGNHAN(long TONGNHAN) {
		_reportThongKe.setTONGNHAN(TONGNHAN);
	}

	/**
	* Returns the t i e p n h a n of this report thong ke.
	*
	* @return the t i e p n h a n of this report thong ke
	*/
	public long getTIEPNHAN() {
		return _reportThongKe.getTIEPNHAN();
	}

	/**
	* Sets the t i e p n h a n of this report thong ke.
	*
	* @param TIEPNHAN the t i e p n h a n of this report thong ke
	*/
	public void setTIEPNHAN(long TIEPNHAN) {
		_reportThongKe.setTIEPNHAN(TIEPNHAN);
	}

	/**
	* Returns the t o n d a u of this report thong ke.
	*
	* @return the t o n d a u of this report thong ke
	*/
	public long getTONDAU() {
		return _reportThongKe.getTONDAU();
	}

	/**
	* Sets the t o n d a u of this report thong ke.
	*
	* @param TONDAU the t o n d a u of this report thong ke
	*/
	public void setTONDAU(long TONDAU) {
		_reportThongKe.setTONDAU(TONDAU);
	}

	/**
	* Returns the t o n g d a g i a i q u y e t of this report thong ke.
	*
	* @return the t o n g d a g i a i q u y e t of this report thong ke
	*/
	public long getTONGDAGIAIQUYET() {
		return _reportThongKe.getTONGDAGIAIQUYET();
	}

	/**
	* Sets the t o n g d a g i a i q u y e t of this report thong ke.
	*
	* @param TONGDAGIAIQUYET the t o n g d a g i a i q u y e t of this report thong ke
	*/
	public void setTONGDAGIAIQUYET(long TONGDAGIAIQUYET) {
		_reportThongKe.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
	}

	/**
	* Returns the s o m of this report thong ke.
	*
	* @return the s o m of this report thong ke
	*/
	public long getSOM() {
		return _reportThongKe.getSOM();
	}

	/**
	* Sets the s o m of this report thong ke.
	*
	* @param SOM the s o m of this report thong ke
	*/
	public void setSOM(long SOM) {
		_reportThongKe.setSOM(SOM);
	}

	/**
	* Returns the d u n g of this report thong ke.
	*
	* @return the d u n g of this report thong ke
	*/
	public long getDUNG() {
		return _reportThongKe.getDUNG();
	}

	/**
	* Sets the d u n g of this report thong ke.
	*
	* @param DUNG the d u n g of this report thong ke
	*/
	public void setDUNG(long DUNG) {
		_reportThongKe.setDUNG(DUNG);
	}

	/**
	* Returns the t r e of this report thong ke.
	*
	* @return the t r e of this report thong ke
	*/
	public long getTRE() {
		return _reportThongKe.getTRE();
	}

	/**
	* Sets the t r e of this report thong ke.
	*
	* @param TRE the t r e of this report thong ke
	*/
	public void setTRE(long TRE) {
		_reportThongKe.setTRE(TRE);
	}

	/**
	* Returns the t o n g d a n g g i a i q u y e t of this report thong ke.
	*
	* @return the t o n g d a n g g i a i q u y e t of this report thong ke
	*/
	public long getTONGDANGGIAIQUYET() {
		return _reportThongKe.getTONGDANGGIAIQUYET();
	}

	/**
	* Sets the t o n g d a n g g i a i q u y e t of this report thong ke.
	*
	* @param TONGDANGGIAIQUYET the t o n g d a n g g i a i q u y e t of this report thong ke
	*/
	public void setTONGDANGGIAIQUYET(long TONGDANGGIAIQUYET) {
		_reportThongKe.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
	}

	/**
	* Returns the c h u a d e n h a n of this report thong ke.
	*
	* @return the c h u a d e n h a n of this report thong ke
	*/
	public long getCHUADENHAN() {
		return _reportThongKe.getCHUADENHAN();
	}

	/**
	* Sets the c h u a d e n h a n of this report thong ke.
	*
	* @param CHUADENHAN the c h u a d e n h a n of this report thong ke
	*/
	public void setCHUADENHAN(long CHUADENHAN) {
		_reportThongKe.setCHUADENHAN(CHUADENHAN);
	}

	/**
	* Returns the q u a h a n of this report thong ke.
	*
	* @return the q u a h a n of this report thong ke
	*/
	public long getQUAHAN() {
		return _reportThongKe.getQUAHAN();
	}

	/**
	* Sets the q u a h a n of this report thong ke.
	*
	* @param QUAHAN the q u a h a n of this report thong ke
	*/
	public void setQUAHAN(long QUAHAN) {
		_reportThongKe.setQUAHAN(QUAHAN);
	}

	/**
	* Returns the r u t h o s o of this report thong ke.
	*
	* @return the r u t h o s o of this report thong ke
	*/
	public long getRUTHOSO() {
		return _reportThongKe.getRUTHOSO();
	}

	/**
	* Sets the r u t h o s o of this report thong ke.
	*
	* @param RUTHOSO the r u t h o s o of this report thong ke
	*/
	public void setRUTHOSO(long RUTHOSO) {
		_reportThongKe.setRUTHOSO(RUTHOSO);
	}

	/**
	* Returns the k h o n g h o p l e of this report thong ke.
	*
	* @return the k h o n g h o p l e of this report thong ke
	*/
	public long getKHONGHOPLE() {
		return _reportThongKe.getKHONGHOPLE();
	}

	/**
	* Sets the k h o n g h o p l e of this report thong ke.
	*
	* @param KHONGHOPLE the k h o n g h o p l e of this report thong ke
	*/
	public void setKHONGHOPLE(long KHONGHOPLE) {
		_reportThongKe.setKHONGHOPLE(KHONGHOPLE);
	}

	/**
	* Returns the t y l e of this report thong ke.
	*
	* @return the t y l e of this report thong ke
	*/
	public double getTYLE() {
		return _reportThongKe.getTYLE();
	}

	/**
	* Sets the t y l e of this report thong ke.
	*
	* @param TYLE the t y l e of this report thong ke
	*/
	public void setTYLE(double TYLE) {
		_reportThongKe.setTYLE(TYLE);
	}

	/**
	* Returns the t o n c u o i of this report thong ke.
	*
	* @return the t o n c u o i of this report thong ke
	*/
	public long getTONCUOI() {
		return _reportThongKe.getTONCUOI();
	}

	/**
	* Sets the t o n c u o i of this report thong ke.
	*
	* @param TONCUOI the t o n c u o i of this report thong ke
	*/
	public void setTONCUOI(long TONCUOI) {
		_reportThongKe.setTONCUOI(TONCUOI);
	}

	public boolean isNew() {
		return _reportThongKe.isNew();
	}

	public void setNew(boolean n) {
		_reportThongKe.setNew(n);
	}

	public boolean isCachedModel() {
		return _reportThongKe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_reportThongKe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _reportThongKe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _reportThongKe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reportThongKe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reportThongKe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reportThongKe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportThongKeWrapper((ReportThongKe)_reportThongKe.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.ReportThongKe reportThongKe) {
		return _reportThongKe.compareTo(reportThongKe);
	}

	@Override
	public int hashCode() {
		return _reportThongKe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.ReportThongKe> toCacheModel() {
		return _reportThongKe.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.ReportThongKe toEscapedModel() {
		return new ReportThongKeWrapper(_reportThongKe.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reportThongKe.toString();
	}

	public java.lang.String toXmlString() {
		return _reportThongKe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportThongKe.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ReportThongKe getWrappedReportThongKe() {
		return _reportThongKe;
	}

	public ReportThongKe getWrappedModel() {
		return _reportThongKe;
	}

	public void resetOriginalValues() {
		_reportThongKe.resetOriginalValues();
	}

	private ReportThongKe _reportThongKe;
}