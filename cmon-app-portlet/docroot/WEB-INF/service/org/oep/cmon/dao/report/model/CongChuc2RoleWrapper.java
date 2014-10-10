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
 * This class is a wrapper for {@link CongChuc2Role}.
 * </p>
 *
 * @author    VIENPN
 * @see       CongChuc2Role
 * @generated
 */
public class CongChuc2RoleWrapper implements CongChuc2Role,
	ModelWrapper<CongChuc2Role> {
	public CongChuc2RoleWrapper(CongChuc2Role congChuc2Role) {
		_congChuc2Role = congChuc2Role;
	}

	public Class<?> getModelClass() {
		return CongChuc2Role.class;
	}

	public String getModelClassName() {
		return CongChuc2Role.class.getName();
	}

	/**
	* Returns the primary key of this cong chuc2 role.
	*
	* @return the primary key of this cong chuc2 role
	*/
	public long getPrimaryKey() {
		return _congChuc2Role.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cong chuc2 role.
	*
	* @param primaryKey the primary key of this cong chuc2 role
	*/
	public void setPrimaryKey(long primaryKey) {
		_congChuc2Role.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this cong chuc2 role.
	*
	* @return the i d of this cong chuc2 role
	*/
	public long getID() {
		return _congChuc2Role.getID();
	}

	/**
	* Sets the i d of this cong chuc2 role.
	*
	* @param ID the i d of this cong chuc2 role
	*/
	public void setID(long ID) {
		_congChuc2Role.setID(ID);
	}

	/**
	* Returns the c o n g c h u c i d of this cong chuc2 role.
	*
	* @return the c o n g c h u c i d of this cong chuc2 role
	*/
	public long getCONGCHUCID() {
		return _congChuc2Role.getCONGCHUCID();
	}

	/**
	* Sets the c o n g c h u c i d of this cong chuc2 role.
	*
	* @param CONGCHUCID the c o n g c h u c i d of this cong chuc2 role
	*/
	public void setCONGCHUCID(long CONGCHUCID) {
		_congChuc2Role.setCONGCHUCID(CONGCHUCID);
	}

	/**
	* Returns the r p d a n h m u c r o l e i d of this cong chuc2 role.
	*
	* @return the r p d a n h m u c r o l e i d of this cong chuc2 role
	*/
	public long getRPDANHMUCROLEID() {
		return _congChuc2Role.getRPDANHMUCROLEID();
	}

	/**
	* Sets the r p d a n h m u c r o l e i d of this cong chuc2 role.
	*
	* @param RPDANHMUCROLEID the r p d a n h m u c r o l e i d of this cong chuc2 role
	*/
	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_congChuc2Role.setRPDANHMUCROLEID(RPDANHMUCROLEID);
	}

	public boolean isNew() {
		return _congChuc2Role.isNew();
	}

	public void setNew(boolean n) {
		_congChuc2Role.setNew(n);
	}

	public boolean isCachedModel() {
		return _congChuc2Role.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_congChuc2Role.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _congChuc2Role.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _congChuc2Role.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_congChuc2Role.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _congChuc2Role.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_congChuc2Role.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CongChuc2RoleWrapper((CongChuc2Role)_congChuc2Role.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role) {
		return _congChuc2Role.compareTo(congChuc2Role);
	}

	@Override
	public int hashCode() {
		return _congChuc2Role.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.CongChuc2Role> toCacheModel() {
		return _congChuc2Role.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.CongChuc2Role toEscapedModel() {
		return new CongChuc2RoleWrapper(_congChuc2Role.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _congChuc2Role.toString();
	}

	public java.lang.String toXmlString() {
		return _congChuc2Role.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_congChuc2Role.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CongChuc2Role getWrappedCongChuc2Role() {
		return _congChuc2Role;
	}

	public CongChuc2Role getWrappedModel() {
		return _congChuc2Role;
	}

	public void resetOriginalValues() {
		_congChuc2Role.resetOriginalValues();
	}

	private CongChuc2Role _congChuc2Role;
}