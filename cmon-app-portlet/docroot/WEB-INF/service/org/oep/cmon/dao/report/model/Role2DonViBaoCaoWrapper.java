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
 * This class is a wrapper for {@link Role2DonViBaoCao}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2DonViBaoCao
 * @generated
 */
public class Role2DonViBaoCaoWrapper implements Role2DonViBaoCao,
	ModelWrapper<Role2DonViBaoCao> {
	public Role2DonViBaoCaoWrapper(Role2DonViBaoCao role2DonViBaoCao) {
		_role2DonViBaoCao = role2DonViBaoCao;
	}

	public Class<?> getModelClass() {
		return Role2DonViBaoCao.class;
	}

	public String getModelClassName() {
		return Role2DonViBaoCao.class.getName();
	}

	/**
	* Returns the primary key of this role2 don vi bao cao.
	*
	* @return the primary key of this role2 don vi bao cao
	*/
	public long getPrimaryKey() {
		return _role2DonViBaoCao.getPrimaryKey();
	}

	/**
	* Sets the primary key of this role2 don vi bao cao.
	*
	* @param primaryKey the primary key of this role2 don vi bao cao
	*/
	public void setPrimaryKey(long primaryKey) {
		_role2DonViBaoCao.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this role2 don vi bao cao.
	*
	* @return the i d of this role2 don vi bao cao
	*/
	public long getID() {
		return _role2DonViBaoCao.getID();
	}

	/**
	* Sets the i d of this role2 don vi bao cao.
	*
	* @param ID the i d of this role2 don vi bao cao
	*/
	public void setID(long ID) {
		_role2DonViBaoCao.setID(ID);
	}

	/**
	* Returns the r p d a n h m u c r o l e i d of this role2 don vi bao cao.
	*
	* @return the r p d a n h m u c r o l e i d of this role2 don vi bao cao
	*/
	public long getRPDANHMUCROLEID() {
		return _role2DonViBaoCao.getRPDANHMUCROLEID();
	}

	/**
	* Sets the r p d a n h m u c r o l e i d of this role2 don vi bao cao.
	*
	* @param RPDANHMUCROLEID the r p d a n h m u c r o l e i d of this role2 don vi bao cao
	*/
	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_role2DonViBaoCao.setRPDANHMUCROLEID(RPDANHMUCROLEID);
	}

	/**
	* Returns the r p d a n h m u c b a o c a o i d of this role2 don vi bao cao.
	*
	* @return the r p d a n h m u c b a o c a o i d of this role2 don vi bao cao
	*/
	public long getRPDANHMUCBAOCAOID() {
		return _role2DonViBaoCao.getRPDANHMUCBAOCAOID();
	}

	/**
	* Sets the r p d a n h m u c b a o c a o i d of this role2 don vi bao cao.
	*
	* @param RPDANHMUCBAOCAOID the r p d a n h m u c b a o c a o i d of this role2 don vi bao cao
	*/
	public void setRPDANHMUCBAOCAOID(long RPDANHMUCBAOCAOID) {
		_role2DonViBaoCao.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
	}

	/**
	* Returns the c o q u a n q u a n l y i d of this role2 don vi bao cao.
	*
	* @return the c o q u a n q u a n l y i d of this role2 don vi bao cao
	*/
	public long getCOQUANQUANLYID() {
		return _role2DonViBaoCao.getCOQUANQUANLYID();
	}

	/**
	* Sets the c o q u a n q u a n l y i d of this role2 don vi bao cao.
	*
	* @param COQUANQUANLYID the c o q u a n q u a n l y i d of this role2 don vi bao cao
	*/
	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_role2DonViBaoCao.setCOQUANQUANLYID(COQUANQUANLYID);
	}

	public boolean isNew() {
		return _role2DonViBaoCao.isNew();
	}

	public void setNew(boolean n) {
		_role2DonViBaoCao.setNew(n);
	}

	public boolean isCachedModel() {
		return _role2DonViBaoCao.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_role2DonViBaoCao.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _role2DonViBaoCao.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _role2DonViBaoCao.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_role2DonViBaoCao.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _role2DonViBaoCao.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_role2DonViBaoCao.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Role2DonViBaoCaoWrapper((Role2DonViBaoCao)_role2DonViBaoCao.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao) {
		return _role2DonViBaoCao.compareTo(role2DonViBaoCao);
	}

	@Override
	public int hashCode() {
		return _role2DonViBaoCao.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.Role2DonViBaoCao> toCacheModel() {
		return _role2DonViBaoCao.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.Role2DonViBaoCao toEscapedModel() {
		return new Role2DonViBaoCaoWrapper(_role2DonViBaoCao.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _role2DonViBaoCao.toString();
	}

	public java.lang.String toXmlString() {
		return _role2DonViBaoCao.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2DonViBaoCao.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Role2DonViBaoCao getWrappedRole2DonViBaoCao() {
		return _role2DonViBaoCao;
	}

	public Role2DonViBaoCao getWrappedModel() {
		return _role2DonViBaoCao;
	}

	public void resetOriginalValues() {
		_role2DonViBaoCao.resetOriginalValues();
	}

	private Role2DonViBaoCao _role2DonViBaoCao;
}