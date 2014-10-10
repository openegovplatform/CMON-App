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
 * This class is a wrapper for {@link Role2NhomTTHC}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2NhomTTHC
 * @generated
 */
public class Role2NhomTTHCWrapper implements Role2NhomTTHC,
	ModelWrapper<Role2NhomTTHC> {
	public Role2NhomTTHCWrapper(Role2NhomTTHC role2NhomTTHC) {
		_role2NhomTTHC = role2NhomTTHC;
	}

	public Class<?> getModelClass() {
		return Role2NhomTTHC.class;
	}

	public String getModelClassName() {
		return Role2NhomTTHC.class.getName();
	}

	/**
	* Returns the primary key of this role2 nhom t t h c.
	*
	* @return the primary key of this role2 nhom t t h c
	*/
	public long getPrimaryKey() {
		return _role2NhomTTHC.getPrimaryKey();
	}

	/**
	* Sets the primary key of this role2 nhom t t h c.
	*
	* @param primaryKey the primary key of this role2 nhom t t h c
	*/
	public void setPrimaryKey(long primaryKey) {
		_role2NhomTTHC.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this role2 nhom t t h c.
	*
	* @return the i d of this role2 nhom t t h c
	*/
	public long getID() {
		return _role2NhomTTHC.getID();
	}

	/**
	* Sets the i d of this role2 nhom t t h c.
	*
	* @param ID the i d of this role2 nhom t t h c
	*/
	public void setID(long ID) {
		_role2NhomTTHC.setID(ID);
	}

	/**
	* Returns the r p d a n h m u c r o l e i d of this role2 nhom t t h c.
	*
	* @return the r p d a n h m u c r o l e i d of this role2 nhom t t h c
	*/
	public long getRPDANHMUCROLEID() {
		return _role2NhomTTHC.getRPDANHMUCROLEID();
	}

	/**
	* Sets the r p d a n h m u c r o l e i d of this role2 nhom t t h c.
	*
	* @param RPDANHMUCROLEID the r p d a n h m u c r o l e i d of this role2 nhom t t h c
	*/
	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_role2NhomTTHC.setRPDANHMUCROLEID(RPDANHMUCROLEID);
	}

	/**
	* Returns the r p d a n h m u c b a o c a o i d of this role2 nhom t t h c.
	*
	* @return the r p d a n h m u c b a o c a o i d of this role2 nhom t t h c
	*/
	public long getRPDANHMUCBAOCAOID() {
		return _role2NhomTTHC.getRPDANHMUCBAOCAOID();
	}

	/**
	* Sets the r p d a n h m u c b a o c a o i d of this role2 nhom t t h c.
	*
	* @param RPDANHMUCBAOCAOID the r p d a n h m u c b a o c a o i d of this role2 nhom t t h c
	*/
	public void setRPDANHMUCBAOCAOID(long RPDANHMUCBAOCAOID) {
		_role2NhomTTHC.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
	}

	/**
	* Returns the n h o m t h u t u c h a n h c h i n h i d of this role2 nhom t t h c.
	*
	* @return the n h o m t h u t u c h a n h c h i n h i d of this role2 nhom t t h c
	*/
	public long getNHOMTHUTUCHANHCHINHID() {
		return _role2NhomTTHC.getNHOMTHUTUCHANHCHINHID();
	}

	/**
	* Sets the n h o m t h u t u c h a n h c h i n h i d of this role2 nhom t t h c.
	*
	* @param NHOMTHUTUCHANHCHINHID the n h o m t h u t u c h a n h c h i n h i d of this role2 nhom t t h c
	*/
	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_role2NhomTTHC.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);
	}

	public boolean isNew() {
		return _role2NhomTTHC.isNew();
	}

	public void setNew(boolean n) {
		_role2NhomTTHC.setNew(n);
	}

	public boolean isCachedModel() {
		return _role2NhomTTHC.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_role2NhomTTHC.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _role2NhomTTHC.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _role2NhomTTHC.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_role2NhomTTHC.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _role2NhomTTHC.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_role2NhomTTHC.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Role2NhomTTHCWrapper((Role2NhomTTHC)_role2NhomTTHC.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC) {
		return _role2NhomTTHC.compareTo(role2NhomTTHC);
	}

	@Override
	public int hashCode() {
		return _role2NhomTTHC.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.Role2NhomTTHC> toCacheModel() {
		return _role2NhomTTHC.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.Role2NhomTTHC toEscapedModel() {
		return new Role2NhomTTHCWrapper(_role2NhomTTHC.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _role2NhomTTHC.toString();
	}

	public java.lang.String toXmlString() {
		return _role2NhomTTHC.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2NhomTTHC.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Role2NhomTTHC getWrappedRole2NhomTTHC() {
		return _role2NhomTTHC;
	}

	public Role2NhomTTHC getWrappedModel() {
		return _role2NhomTTHC;
	}

	public void resetOriginalValues() {
		_role2NhomTTHC.resetOriginalValues();
	}

	private Role2NhomTTHC _role2NhomTTHC;
}