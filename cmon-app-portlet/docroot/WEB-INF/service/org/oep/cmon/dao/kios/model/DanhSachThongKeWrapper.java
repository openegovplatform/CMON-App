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

package org.oep.cmon.dao.kios.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhSachThongKe}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhSachThongKe
 * @generated
 */
public class DanhSachThongKeWrapper implements DanhSachThongKe,
	ModelWrapper<DanhSachThongKe> {
	public DanhSachThongKeWrapper(DanhSachThongKe danhSachThongKe) {
		_danhSachThongKe = danhSachThongKe;
	}

	public Class<?> getModelClass() {
		return DanhSachThongKe.class;
	}

	public String getModelClassName() {
		return DanhSachThongKe.class.getName();
	}

	/**
	* Returns the primary key of this danh sach thong ke.
	*
	* @return the primary key of this danh sach thong ke
	*/
	public long getPrimaryKey() {
		return _danhSachThongKe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh sach thong ke.
	*
	* @param primaryKey the primary key of this danh sach thong ke
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhSachThongKe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the c a p c o q u a n q u a n l y i d of this danh sach thong ke.
	*
	* @return the c a p c o q u a n q u a n l y i d of this danh sach thong ke
	*/
	public long getCAPCOQUANQUANLYID() {
		return _danhSachThongKe.getCAPCOQUANQUANLYID();
	}

	/**
	* Sets the c a p c o q u a n q u a n l y i d of this danh sach thong ke.
	*
	* @param CAPCOQUANQUANLYID the c a p c o q u a n q u a n l y i d of this danh sach thong ke
	*/
	public void setCAPCOQUANQUANLYID(long CAPCOQUANQUANLYID) {
		_danhSachThongKe.setCAPCOQUANQUANLYID(CAPCOQUANQUANLYID);
	}

	/**
	* Returns the c o q u a n q u a n l y i d of this danh sach thong ke.
	*
	* @return the c o q u a n q u a n l y i d of this danh sach thong ke
	*/
	public long getCOQUANQUANLYID() {
		return _danhSachThongKe.getCOQUANQUANLYID();
	}

	/**
	* Sets the c o q u a n q u a n l y i d of this danh sach thong ke.
	*
	* @param COQUANQUANLYID the c o q u a n q u a n l y i d of this danh sach thong ke
	*/
	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_danhSachThongKe.setCOQUANQUANLYID(COQUANQUANLYID);
	}

	/**
	* Returns the t h a n g of this danh sach thong ke.
	*
	* @return the t h a n g of this danh sach thong ke
	*/
	public int getTHANG() {
		return _danhSachThongKe.getTHANG();
	}

	/**
	* Sets the t h a n g of this danh sach thong ke.
	*
	* @param THANG the t h a n g of this danh sach thong ke
	*/
	public void setTHANG(int THANG) {
		_danhSachThongKe.setTHANG(THANG);
	}

	/**
	* Returns the n a m of this danh sach thong ke.
	*
	* @return the n a m of this danh sach thong ke
	*/
	public int getNAM() {
		return _danhSachThongKe.getNAM();
	}

	/**
	* Sets the n a m of this danh sach thong ke.
	*
	* @param NAM the n a m of this danh sach thong ke
	*/
	public void setNAM(int NAM) {
		_danhSachThongKe.setNAM(NAM);
	}

	/**
	* Returns the t o n g n h a n of this danh sach thong ke.
	*
	* @return the t o n g n h a n of this danh sach thong ke
	*/
	public long getTONGNHAN() {
		return _danhSachThongKe.getTONGNHAN();
	}

	/**
	* Sets the t o n g n h a n of this danh sach thong ke.
	*
	* @param TONGNHAN the t o n g n h a n of this danh sach thong ke
	*/
	public void setTONGNHAN(long TONGNHAN) {
		_danhSachThongKe.setTONGNHAN(TONGNHAN);
	}

	/**
	* Returns the t i e p n h a n of this danh sach thong ke.
	*
	* @return the t i e p n h a n of this danh sach thong ke
	*/
	public long getTIEPNHAN() {
		return _danhSachThongKe.getTIEPNHAN();
	}

	/**
	* Sets the t i e p n h a n of this danh sach thong ke.
	*
	* @param TIEPNHAN the t i e p n h a n of this danh sach thong ke
	*/
	public void setTIEPNHAN(long TIEPNHAN) {
		_danhSachThongKe.setTIEPNHAN(TIEPNHAN);
	}

	/**
	* Returns the t o n d a u of this danh sach thong ke.
	*
	* @return the t o n d a u of this danh sach thong ke
	*/
	public long getTONDAU() {
		return _danhSachThongKe.getTONDAU();
	}

	/**
	* Sets the t o n d a u of this danh sach thong ke.
	*
	* @param TONDAU the t o n d a u of this danh sach thong ke
	*/
	public void setTONDAU(long TONDAU) {
		_danhSachThongKe.setTONDAU(TONDAU);
	}

	/**
	* Returns the t o n g d a g i a i q u y e t of this danh sach thong ke.
	*
	* @return the t o n g d a g i a i q u y e t of this danh sach thong ke
	*/
	public long getTONGDAGIAIQUYET() {
		return _danhSachThongKe.getTONGDAGIAIQUYET();
	}

	/**
	* Sets the t o n g d a g i a i q u y e t of this danh sach thong ke.
	*
	* @param TONGDAGIAIQUYET the t o n g d a g i a i q u y e t of this danh sach thong ke
	*/
	public void setTONGDAGIAIQUYET(long TONGDAGIAIQUYET) {
		_danhSachThongKe.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
	}

	/**
	* Returns the s o m of this danh sach thong ke.
	*
	* @return the s o m of this danh sach thong ke
	*/
	public long getSOM() {
		return _danhSachThongKe.getSOM();
	}

	/**
	* Sets the s o m of this danh sach thong ke.
	*
	* @param SOM the s o m of this danh sach thong ke
	*/
	public void setSOM(long SOM) {
		_danhSachThongKe.setSOM(SOM);
	}

	/**
	* Returns the d u n g of this danh sach thong ke.
	*
	* @return the d u n g of this danh sach thong ke
	*/
	public long getDUNG() {
		return _danhSachThongKe.getDUNG();
	}

	/**
	* Sets the d u n g of this danh sach thong ke.
	*
	* @param DUNG the d u n g of this danh sach thong ke
	*/
	public void setDUNG(long DUNG) {
		_danhSachThongKe.setDUNG(DUNG);
	}

	/**
	* Returns the t r e of this danh sach thong ke.
	*
	* @return the t r e of this danh sach thong ke
	*/
	public long getTRE() {
		return _danhSachThongKe.getTRE();
	}

	/**
	* Sets the t r e of this danh sach thong ke.
	*
	* @param TRE the t r e of this danh sach thong ke
	*/
	public void setTRE(long TRE) {
		_danhSachThongKe.setTRE(TRE);
	}

	/**
	* Returns the t o n g d a n g g i a i q u y e t of this danh sach thong ke.
	*
	* @return the t o n g d a n g g i a i q u y e t of this danh sach thong ke
	*/
	public long getTONGDANGGIAIQUYET() {
		return _danhSachThongKe.getTONGDANGGIAIQUYET();
	}

	/**
	* Sets the t o n g d a n g g i a i q u y e t of this danh sach thong ke.
	*
	* @param TONGDANGGIAIQUYET the t o n g d a n g g i a i q u y e t of this danh sach thong ke
	*/
	public void setTONGDANGGIAIQUYET(long TONGDANGGIAIQUYET) {
		_danhSachThongKe.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
	}

	/**
	* Returns the c h u a d e n h a n of this danh sach thong ke.
	*
	* @return the c h u a d e n h a n of this danh sach thong ke
	*/
	public long getCHUADENHAN() {
		return _danhSachThongKe.getCHUADENHAN();
	}

	/**
	* Sets the c h u a d e n h a n of this danh sach thong ke.
	*
	* @param CHUADENHAN the c h u a d e n h a n of this danh sach thong ke
	*/
	public void setCHUADENHAN(long CHUADENHAN) {
		_danhSachThongKe.setCHUADENHAN(CHUADENHAN);
	}

	/**
	* Returns the q u a h a n of this danh sach thong ke.
	*
	* @return the q u a h a n of this danh sach thong ke
	*/
	public long getQUAHAN() {
		return _danhSachThongKe.getQUAHAN();
	}

	/**
	* Sets the q u a h a n of this danh sach thong ke.
	*
	* @param QUAHAN the q u a h a n of this danh sach thong ke
	*/
	public void setQUAHAN(long QUAHAN) {
		_danhSachThongKe.setQUAHAN(QUAHAN);
	}

	/**
	* Returns the r u t h o s o of this danh sach thong ke.
	*
	* @return the r u t h o s o of this danh sach thong ke
	*/
	public long getRUTHOSO() {
		return _danhSachThongKe.getRUTHOSO();
	}

	/**
	* Sets the r u t h o s o of this danh sach thong ke.
	*
	* @param RUTHOSO the r u t h o s o of this danh sach thong ke
	*/
	public void setRUTHOSO(long RUTHOSO) {
		_danhSachThongKe.setRUTHOSO(RUTHOSO);
	}

	/**
	* Returns the k h o n g h o p l e of this danh sach thong ke.
	*
	* @return the k h o n g h o p l e of this danh sach thong ke
	*/
	public long getKHONGHOPLE() {
		return _danhSachThongKe.getKHONGHOPLE();
	}

	/**
	* Sets the k h o n g h o p l e of this danh sach thong ke.
	*
	* @param KHONGHOPLE the k h o n g h o p l e of this danh sach thong ke
	*/
	public void setKHONGHOPLE(long KHONGHOPLE) {
		_danhSachThongKe.setKHONGHOPLE(KHONGHOPLE);
	}

	/**
	* Returns the t y l e of this danh sach thong ke.
	*
	* @return the t y l e of this danh sach thong ke
	*/
	public double getTYLE() {
		return _danhSachThongKe.getTYLE();
	}

	/**
	* Sets the t y l e of this danh sach thong ke.
	*
	* @param TYLE the t y l e of this danh sach thong ke
	*/
	public void setTYLE(double TYLE) {
		_danhSachThongKe.setTYLE(TYLE);
	}

	/**
	* Returns the t o n c u o i of this danh sach thong ke.
	*
	* @return the t o n c u o i of this danh sach thong ke
	*/
	public long getTONCUOI() {
		return _danhSachThongKe.getTONCUOI();
	}

	/**
	* Sets the t o n c u o i of this danh sach thong ke.
	*
	* @param TONCUOI the t o n c u o i of this danh sach thong ke
	*/
	public void setTONCUOI(long TONCUOI) {
		_danhSachThongKe.setTONCUOI(TONCUOI);
	}

	/**
	* Returns the t e n c a p c o q u a n q u a n l y of this danh sach thong ke.
	*
	* @return the t e n c a p c o q u a n q u a n l y of this danh sach thong ke
	*/
	public java.lang.String getTENCAPCOQUANQUANLY() {
		return _danhSachThongKe.getTENCAPCOQUANQUANLY();
	}

	/**
	* Sets the t e n c a p c o q u a n q u a n l y of this danh sach thong ke.
	*
	* @param TENCAPCOQUANQUANLY the t e n c a p c o q u a n q u a n l y of this danh sach thong ke
	*/
	public void setTENCAPCOQUANQUANLY(java.lang.String TENCAPCOQUANQUANLY) {
		_danhSachThongKe.setTENCAPCOQUANQUANLY(TENCAPCOQUANQUANLY);
	}

	/**
	* Returns the t e n c o q u a n q u a n l y of this danh sach thong ke.
	*
	* @return the t e n c o q u a n q u a n l y of this danh sach thong ke
	*/
	public java.lang.String getTENCOQUANQUANLY() {
		return _danhSachThongKe.getTENCOQUANQUANLY();
	}

	/**
	* Sets the t e n c o q u a n q u a n l y of this danh sach thong ke.
	*
	* @param TENCOQUANQUANLY the t e n c o q u a n q u a n l y of this danh sach thong ke
	*/
	public void setTENCOQUANQUANLY(java.lang.String TENCOQUANQUANLY) {
		_danhSachThongKe.setTENCOQUANQUANLY(TENCOQUANQUANLY);
	}

	public boolean isNew() {
		return _danhSachThongKe.isNew();
	}

	public void setNew(boolean n) {
		_danhSachThongKe.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhSachThongKe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhSachThongKe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhSachThongKe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhSachThongKe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhSachThongKe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhSachThongKe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhSachThongKe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhSachThongKeWrapper((DanhSachThongKe)_danhSachThongKe.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.kios.model.DanhSachThongKe danhSachThongKe) {
		return _danhSachThongKe.compareTo(danhSachThongKe);
	}

	@Override
	public int hashCode() {
		return _danhSachThongKe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.kios.model.DanhSachThongKe> toCacheModel() {
		return _danhSachThongKe.toCacheModel();
	}

	public org.oep.cmon.dao.kios.model.DanhSachThongKe toEscapedModel() {
		return new DanhSachThongKeWrapper(_danhSachThongKe.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhSachThongKe.toString();
	}

	public java.lang.String toXmlString() {
		return _danhSachThongKe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhSachThongKe.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhSachThongKe getWrappedDanhSachThongKe() {
		return _danhSachThongKe;
	}

	public DanhSachThongKe getWrappedModel() {
		return _danhSachThongKe;
	}

	public void resetOriginalValues() {
		_danhSachThongKe.resetOriginalValues();
	}

	private DanhSachThongKe _danhSachThongKe;
}