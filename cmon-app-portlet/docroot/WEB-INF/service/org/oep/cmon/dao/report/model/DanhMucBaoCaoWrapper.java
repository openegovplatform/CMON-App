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
 * This class is a wrapper for {@link DanhMucBaoCao}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhMucBaoCao
 * @generated
 */
public class DanhMucBaoCaoWrapper implements DanhMucBaoCao,
	ModelWrapper<DanhMucBaoCao> {
	public DanhMucBaoCaoWrapper(DanhMucBaoCao danhMucBaoCao) {
		_danhMucBaoCao = danhMucBaoCao;
	}

	public Class<?> getModelClass() {
		return DanhMucBaoCao.class;
	}

	public String getModelClassName() {
		return DanhMucBaoCao.class.getName();
	}

	/**
	* Returns the primary key of this danh muc bao cao.
	*
	* @return the primary key of this danh muc bao cao
	*/
	public long getPrimaryKey() {
		return _danhMucBaoCao.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh muc bao cao.
	*
	* @param primaryKey the primary key of this danh muc bao cao
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhMucBaoCao.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this danh muc bao cao.
	*
	* @return the i d of this danh muc bao cao
	*/
	public long getID() {
		return _danhMucBaoCao.getID();
	}

	/**
	* Sets the i d of this danh muc bao cao.
	*
	* @param ID the i d of this danh muc bao cao
	*/
	public void setID(long ID) {
		_danhMucBaoCao.setID(ID);
	}

	/**
	* Returns the t e n b a o c a o of this danh muc bao cao.
	*
	* @return the t e n b a o c a o of this danh muc bao cao
	*/
	public java.lang.String getTENBAOCAO() {
		return _danhMucBaoCao.getTENBAOCAO();
	}

	/**
	* Sets the t e n b a o c a o of this danh muc bao cao.
	*
	* @param TENBAOCAO the t e n b a o c a o of this danh muc bao cao
	*/
	public void setTENBAOCAO(java.lang.String TENBAOCAO) {
		_danhMucBaoCao.setTENBAOCAO(TENBAOCAO);
	}

	/**
	* Returns the d u o n g d a n of this danh muc bao cao.
	*
	* @return the d u o n g d a n of this danh muc bao cao
	*/
	public java.lang.String getDUONGDAN() {
		return _danhMucBaoCao.getDUONGDAN();
	}

	/**
	* Sets the d u o n g d a n of this danh muc bao cao.
	*
	* @param DUONGDAN the d u o n g d a n of this danh muc bao cao
	*/
	public void setDUONGDAN(java.lang.String DUONGDAN) {
		_danhMucBaoCao.setDUONGDAN(DUONGDAN);
	}

	/**
	* Returns the o r d e r s of this danh muc bao cao.
	*
	* @return the o r d e r s of this danh muc bao cao
	*/
	public int getORDERS() {
		return _danhMucBaoCao.getORDERS();
	}

	/**
	* Sets the o r d e r s of this danh muc bao cao.
	*
	* @param ORDERS the o r d e r s of this danh muc bao cao
	*/
	public void setORDERS(int ORDERS) {
		_danhMucBaoCao.setORDERS(ORDERS);
	}

	/**
	* Returns the s t a t u s of this danh muc bao cao.
	*
	* @return the s t a t u s of this danh muc bao cao
	*/
	public int getSTATUS() {
		return _danhMucBaoCao.getSTATUS();
	}

	/**
	* Sets the s t a t u s of this danh muc bao cao.
	*
	* @param STATUS the s t a t u s of this danh muc bao cao
	*/
	public void setSTATUS(int STATUS) {
		_danhMucBaoCao.setSTATUS(STATUS);
	}

	/**
	* Returns the p u b l i s h of this danh muc bao cao.
	*
	* @return the p u b l i s h of this danh muc bao cao
	*/
	public int getPUBLISH() {
		return _danhMucBaoCao.getPUBLISH();
	}

	/**
	* Sets the p u b l i s h of this danh muc bao cao.
	*
	* @param PUBLISH the p u b l i s h of this danh muc bao cao
	*/
	public void setPUBLISH(int PUBLISH) {
		_danhMucBaoCao.setPUBLISH(PUBLISH);
	}

	public boolean isNew() {
		return _danhMucBaoCao.isNew();
	}

	public void setNew(boolean n) {
		_danhMucBaoCao.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhMucBaoCao.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhMucBaoCao.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhMucBaoCao.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhMucBaoCao.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhMucBaoCao.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhMucBaoCao.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhMucBaoCao.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhMucBaoCaoWrapper((DanhMucBaoCao)_danhMucBaoCao.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao) {
		return _danhMucBaoCao.compareTo(danhMucBaoCao);
	}

	@Override
	public int hashCode() {
		return _danhMucBaoCao.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.DanhMucBaoCao> toCacheModel() {
		return _danhMucBaoCao.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.DanhMucBaoCao toEscapedModel() {
		return new DanhMucBaoCaoWrapper(_danhMucBaoCao.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhMucBaoCao.toString();
	}

	public java.lang.String toXmlString() {
		return _danhMucBaoCao.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucBaoCao.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhMucBaoCao getWrappedDanhMucBaoCao() {
		return _danhMucBaoCao;
	}

	public DanhMucBaoCao getWrappedModel() {
		return _danhMucBaoCao;
	}

	public void resetOriginalValues() {
		_danhMucBaoCao.resetOriginalValues();
	}

	private DanhMucBaoCao _danhMucBaoCao;
}