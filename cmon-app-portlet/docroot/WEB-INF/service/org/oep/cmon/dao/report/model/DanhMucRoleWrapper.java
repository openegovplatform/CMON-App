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
 * This class is a wrapper for {@link DanhMucRole}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhMucRole
 * @generated
 */
public class DanhMucRoleWrapper implements DanhMucRole,
	ModelWrapper<DanhMucRole> {
	public DanhMucRoleWrapper(DanhMucRole danhMucRole) {
		_danhMucRole = danhMucRole;
	}

	public Class<?> getModelClass() {
		return DanhMucRole.class;
	}

	public String getModelClassName() {
		return DanhMucRole.class.getName();
	}

	/**
	* Returns the primary key of this danh muc role.
	*
	* @return the primary key of this danh muc role
	*/
	public long getPrimaryKey() {
		return _danhMucRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh muc role.
	*
	* @param primaryKey the primary key of this danh muc role
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhMucRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this danh muc role.
	*
	* @return the i d of this danh muc role
	*/
	public long getID() {
		return _danhMucRole.getID();
	}

	/**
	* Sets the i d of this danh muc role.
	*
	* @param ID the i d of this danh muc role
	*/
	public void setID(long ID) {
		_danhMucRole.setID(ID);
	}

	/**
	* Returns the n a m e of this danh muc role.
	*
	* @return the n a m e of this danh muc role
	*/
	public java.lang.String getNAME() {
		return _danhMucRole.getNAME();
	}

	/**
	* Sets the n a m e of this danh muc role.
	*
	* @param NAME the n a m e of this danh muc role
	*/
	public void setNAME(java.lang.String NAME) {
		_danhMucRole.setNAME(NAME);
	}

	/**
	* Returns the o r d e r s of this danh muc role.
	*
	* @return the o r d e r s of this danh muc role
	*/
	public int getORDERS() {
		return _danhMucRole.getORDERS();
	}

	/**
	* Sets the o r d e r s of this danh muc role.
	*
	* @param ORDERS the o r d e r s of this danh muc role
	*/
	public void setORDERS(int ORDERS) {
		_danhMucRole.setORDERS(ORDERS);
	}

	/**
	* Returns the s t a t u s of this danh muc role.
	*
	* @return the s t a t u s of this danh muc role
	*/
	public int getSTATUS() {
		return _danhMucRole.getSTATUS();
	}

	/**
	* Sets the s t a t u s of this danh muc role.
	*
	* @param STATUS the s t a t u s of this danh muc role
	*/
	public void setSTATUS(int STATUS) {
		_danhMucRole.setSTATUS(STATUS);
	}

	public boolean isNew() {
		return _danhMucRole.isNew();
	}

	public void setNew(boolean n) {
		_danhMucRole.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhMucRole.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhMucRole.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhMucRole.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhMucRole.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhMucRole.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhMucRole.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhMucRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhMucRoleWrapper((DanhMucRole)_danhMucRole.clone());
	}

	public int compareTo(org.oep.cmon.dao.report.model.DanhMucRole danhMucRole) {
		return _danhMucRole.compareTo(danhMucRole);
	}

	@Override
	public int hashCode() {
		return _danhMucRole.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.DanhMucRole> toCacheModel() {
		return _danhMucRole.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.DanhMucRole toEscapedModel() {
		return new DanhMucRoleWrapper(_danhMucRole.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhMucRole.toString();
	}

	public java.lang.String toXmlString() {
		return _danhMucRole.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucRole.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhMucRole getWrappedDanhMucRole() {
		return _danhMucRole;
	}

	public DanhMucRole getWrappedModel() {
		return _danhMucRole;
	}

	public void resetOriginalValues() {
		_danhMucRole.resetOriginalValues();
	}

	private DanhMucRole _danhMucRole;
}