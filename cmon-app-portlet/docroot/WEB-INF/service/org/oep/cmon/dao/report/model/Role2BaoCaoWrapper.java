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
 * This class is a wrapper for {@link Role2BaoCao}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2BaoCao
 * @generated
 */
public class Role2BaoCaoWrapper implements Role2BaoCao,
	ModelWrapper<Role2BaoCao> {
	public Role2BaoCaoWrapper(Role2BaoCao role2BaoCao) {
		_role2BaoCao = role2BaoCao;
	}

	public Class<?> getModelClass() {
		return Role2BaoCao.class;
	}

	public String getModelClassName() {
		return Role2BaoCao.class.getName();
	}

	/**
	* Returns the primary key of this role2 bao cao.
	*
	* @return the primary key of this role2 bao cao
	*/
	public long getPrimaryKey() {
		return _role2BaoCao.getPrimaryKey();
	}

	/**
	* Sets the primary key of this role2 bao cao.
	*
	* @param primaryKey the primary key of this role2 bao cao
	*/
	public void setPrimaryKey(long primaryKey) {
		_role2BaoCao.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this role2 bao cao.
	*
	* @return the i d of this role2 bao cao
	*/
	public long getID() {
		return _role2BaoCao.getID();
	}

	/**
	* Sets the i d of this role2 bao cao.
	*
	* @param ID the i d of this role2 bao cao
	*/
	public void setID(long ID) {
		_role2BaoCao.setID(ID);
	}

	/**
	* Returns the r p d a n h m u c r o l e i d of this role2 bao cao.
	*
	* @return the r p d a n h m u c r o l e i d of this role2 bao cao
	*/
	public long getRPDANHMUCROLEID() {
		return _role2BaoCao.getRPDANHMUCROLEID();
	}

	/**
	* Sets the r p d a n h m u c r o l e i d of this role2 bao cao.
	*
	* @param RPDANHMUCROLEID the r p d a n h m u c r o l e i d of this role2 bao cao
	*/
	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_role2BaoCao.setRPDANHMUCROLEID(RPDANHMUCROLEID);
	}

	/**
	* Returns the r p d a n h m u c b a o c a o i d of this role2 bao cao.
	*
	* @return the r p d a n h m u c b a o c a o i d of this role2 bao cao
	*/
	public long getRPDANHMUCBAOCAOID() {
		return _role2BaoCao.getRPDANHMUCBAOCAOID();
	}

	/**
	* Sets the r p d a n h m u c b a o c a o i d of this role2 bao cao.
	*
	* @param RPDANHMUCBAOCAOID the r p d a n h m u c b a o c a o i d of this role2 bao cao
	*/
	public void setRPDANHMUCBAOCAOID(long RPDANHMUCBAOCAOID) {
		_role2BaoCao.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
	}

	public boolean isNew() {
		return _role2BaoCao.isNew();
	}

	public void setNew(boolean n) {
		_role2BaoCao.setNew(n);
	}

	public boolean isCachedModel() {
		return _role2BaoCao.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_role2BaoCao.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _role2BaoCao.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _role2BaoCao.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_role2BaoCao.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _role2BaoCao.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_role2BaoCao.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Role2BaoCaoWrapper((Role2BaoCao)_role2BaoCao.clone());
	}

	public int compareTo(org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao) {
		return _role2BaoCao.compareTo(role2BaoCao);
	}

	@Override
	public int hashCode() {
		return _role2BaoCao.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.Role2BaoCao> toCacheModel() {
		return _role2BaoCao.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.Role2BaoCao toEscapedModel() {
		return new Role2BaoCaoWrapper(_role2BaoCao.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _role2BaoCao.toString();
	}

	public java.lang.String toXmlString() {
		return _role2BaoCao.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2BaoCao.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Role2BaoCao getWrappedRole2BaoCao() {
		return _role2BaoCao;
	}

	public Role2BaoCao getWrappedModel() {
		return _role2BaoCao;
	}

	public void resetOriginalValues() {
		_role2BaoCao.resetOriginalValues();
	}

	private Role2BaoCao _role2BaoCao;
}