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
 * This class is a wrapper for {@link CoQuanQuanLy2LinhVuc}.
 * </p>
 *
 * @author    VIENPN
 * @see       CoQuanQuanLy2LinhVuc
 * @generated
 */
public class CoQuanQuanLy2LinhVucWrapper implements CoQuanQuanLy2LinhVuc,
	ModelWrapper<CoQuanQuanLy2LinhVuc> {
	public CoQuanQuanLy2LinhVucWrapper(
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		_coQuanQuanLy2LinhVuc = coQuanQuanLy2LinhVuc;
	}

	public Class<?> getModelClass() {
		return CoQuanQuanLy2LinhVuc.class;
	}

	public String getModelClassName() {
		return CoQuanQuanLy2LinhVuc.class.getName();
	}

	/**
	* Returns the primary key of this co quan quan ly2 linh vuc.
	*
	* @return the primary key of this co quan quan ly2 linh vuc
	*/
	public long getPrimaryKey() {
		return _coQuanQuanLy2LinhVuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this co quan quan ly2 linh vuc.
	*
	* @param primaryKey the primary key of this co quan quan ly2 linh vuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_coQuanQuanLy2LinhVuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the n h o m t h u t u c h a n h c h i n h i d of this co quan quan ly2 linh vuc.
	*
	* @return the n h o m t h u t u c h a n h c h i n h i d of this co quan quan ly2 linh vuc
	*/
	public long getNHOMTHUTUCHANHCHINHID() {
		return _coQuanQuanLy2LinhVuc.getNHOMTHUTUCHANHCHINHID();
	}

	/**
	* Sets the n h o m t h u t u c h a n h c h i n h i d of this co quan quan ly2 linh vuc.
	*
	* @param NHOMTHUTUCHANHCHINHID the n h o m t h u t u c h a n h c h i n h i d of this co quan quan ly2 linh vuc
	*/
	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_coQuanQuanLy2LinhVuc.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the t e n n h o m t t h c of this co quan quan ly2 linh vuc.
	*
	* @return the t e n n h o m t t h c of this co quan quan ly2 linh vuc
	*/
	public java.lang.String getTENNHOMTTHC() {
		return _coQuanQuanLy2LinhVuc.getTENNHOMTTHC();
	}

	/**
	* Sets the t e n n h o m t t h c of this co quan quan ly2 linh vuc.
	*
	* @param TENNHOMTTHC the t e n n h o m t t h c of this co quan quan ly2 linh vuc
	*/
	public void setTENNHOMTTHC(java.lang.String TENNHOMTTHC) {
		_coQuanQuanLy2LinhVuc.setTENNHOMTTHC(TENNHOMTTHC);
	}

	public boolean isNew() {
		return _coQuanQuanLy2LinhVuc.isNew();
	}

	public void setNew(boolean n) {
		_coQuanQuanLy2LinhVuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _coQuanQuanLy2LinhVuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_coQuanQuanLy2LinhVuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _coQuanQuanLy2LinhVuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _coQuanQuanLy2LinhVuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_coQuanQuanLy2LinhVuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _coQuanQuanLy2LinhVuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_coQuanQuanLy2LinhVuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CoQuanQuanLy2LinhVucWrapper((CoQuanQuanLy2LinhVuc)_coQuanQuanLy2LinhVuc.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		return _coQuanQuanLy2LinhVuc.compareTo(coQuanQuanLy2LinhVuc);
	}

	@Override
	public int hashCode() {
		return _coQuanQuanLy2LinhVuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> toCacheModel() {
		return _coQuanQuanLy2LinhVuc.toCacheModel();
	}

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc toEscapedModel() {
		return new CoQuanQuanLy2LinhVucWrapper(_coQuanQuanLy2LinhVuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _coQuanQuanLy2LinhVuc.toString();
	}

	public java.lang.String toXmlString() {
		return _coQuanQuanLy2LinhVuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_coQuanQuanLy2LinhVuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CoQuanQuanLy2LinhVuc getWrappedCoQuanQuanLy2LinhVuc() {
		return _coQuanQuanLy2LinhVuc;
	}

	public CoQuanQuanLy2LinhVuc getWrappedModel() {
		return _coQuanQuanLy2LinhVuc;
	}

	public void resetOriginalValues() {
		_coQuanQuanLy2LinhVuc.resetOriginalValues();
	}

	private CoQuanQuanLy2LinhVuc _coQuanQuanLy2LinhVuc;
}