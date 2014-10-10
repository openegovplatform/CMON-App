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
 * This class is a wrapper for {@link Role2TTHC}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2TTHC
 * @generated
 */
public class Role2TTHCWrapper implements Role2TTHC, ModelWrapper<Role2TTHC> {
	public Role2TTHCWrapper(Role2TTHC role2TTHC) {
		_role2TTHC = role2TTHC;
	}

	public Class<?> getModelClass() {
		return Role2TTHC.class;
	}

	public String getModelClassName() {
		return Role2TTHC.class.getName();
	}

	/**
	* Returns the primary key of this role2 t t h c.
	*
	* @return the primary key of this role2 t t h c
	*/
	public long getPrimaryKey() {
		return _role2TTHC.getPrimaryKey();
	}

	/**
	* Sets the primary key of this role2 t t h c.
	*
	* @param primaryKey the primary key of this role2 t t h c
	*/
	public void setPrimaryKey(long primaryKey) {
		_role2TTHC.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this role2 t t h c.
	*
	* @return the i d of this role2 t t h c
	*/
	public long getID() {
		return _role2TTHC.getID();
	}

	/**
	* Sets the i d of this role2 t t h c.
	*
	* @param ID the i d of this role2 t t h c
	*/
	public void setID(long ID) {
		_role2TTHC.setID(ID);
	}

	/**
	* Returns the r p d a n h m u c r o l e i d of this role2 t t h c.
	*
	* @return the r p d a n h m u c r o l e i d of this role2 t t h c
	*/
	public long getRPDANHMUCROLEID() {
		return _role2TTHC.getRPDANHMUCROLEID();
	}

	/**
	* Sets the r p d a n h m u c r o l e i d of this role2 t t h c.
	*
	* @param RPDANHMUCROLEID the r p d a n h m u c r o l e i d of this role2 t t h c
	*/
	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_role2TTHC.setRPDANHMUCROLEID(RPDANHMUCROLEID);
	}

	/**
	* Returns the r p d a n h m u c b a o c a o i d of this role2 t t h c.
	*
	* @return the r p d a n h m u c b a o c a o i d of this role2 t t h c
	*/
	public long getRPDANHMUCBAOCAOID() {
		return _role2TTHC.getRPDANHMUCBAOCAOID();
	}

	/**
	* Sets the r p d a n h m u c b a o c a o i d of this role2 t t h c.
	*
	* @param RPDANHMUCBAOCAOID the r p d a n h m u c b a o c a o i d of this role2 t t h c
	*/
	public void setRPDANHMUCBAOCAOID(long RPDANHMUCBAOCAOID) {
		_role2TTHC.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
	}

	/**
	* Returns the t h u t u c h a n h c h i n h i d of this role2 t t h c.
	*
	* @return the t h u t u c h a n h c h i n h i d of this role2 t t h c
	*/
	public long getTHUTUCHANHCHINHID() {
		return _role2TTHC.getTHUTUCHANHCHINHID();
	}

	/**
	* Sets the t h u t u c h a n h c h i n h i d of this role2 t t h c.
	*
	* @param THUTUCHANHCHINHID the t h u t u c h a n h c h i n h i d of this role2 t t h c
	*/
	public void setTHUTUCHANHCHINHID(long THUTUCHANHCHINHID) {
		_role2TTHC.setTHUTUCHANHCHINHID(THUTUCHANHCHINHID);
	}

	public boolean isNew() {
		return _role2TTHC.isNew();
	}

	public void setNew(boolean n) {
		_role2TTHC.setNew(n);
	}

	public boolean isCachedModel() {
		return _role2TTHC.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_role2TTHC.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _role2TTHC.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _role2TTHC.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_role2TTHC.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _role2TTHC.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_role2TTHC.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Role2TTHCWrapper((Role2TTHC)_role2TTHC.clone());
	}

	public int compareTo(org.oep.cmon.dao.report.model.Role2TTHC role2TTHC) {
		return _role2TTHC.compareTo(role2TTHC);
	}

	@Override
	public int hashCode() {
		return _role2TTHC.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.Role2TTHC> toCacheModel() {
		return _role2TTHC.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.Role2TTHC toEscapedModel() {
		return new Role2TTHCWrapper(_role2TTHC.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _role2TTHC.toString();
	}

	public java.lang.String toXmlString() {
		return _role2TTHC.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2TTHC.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Role2TTHC getWrappedRole2TTHC() {
		return _role2TTHC;
	}

	public Role2TTHC getWrappedModel() {
		return _role2TTHC;
	}

	public void resetOriginalValues() {
		_role2TTHC.resetOriginalValues();
	}

	private Role2TTHC _role2TTHC;
}