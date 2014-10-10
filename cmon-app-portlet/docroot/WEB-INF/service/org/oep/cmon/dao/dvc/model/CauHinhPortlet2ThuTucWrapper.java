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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CauHinhPortlet2ThuTuc}.
 * </p>
 *
 * @author    liemnn
 * @see       CauHinhPortlet2ThuTuc
 * @generated
 */
public class CauHinhPortlet2ThuTucWrapper implements CauHinhPortlet2ThuTuc,
	ModelWrapper<CauHinhPortlet2ThuTuc> {
	public CauHinhPortlet2ThuTucWrapper(
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		_cauHinhPortlet2ThuTuc = cauHinhPortlet2ThuTuc;
	}

	public Class<?> getModelClass() {
		return CauHinhPortlet2ThuTuc.class;
	}

	public String getModelClassName() {
		return CauHinhPortlet2ThuTuc.class.getName();
	}

	/**
	* Returns the primary key of this cau hinh portlet2 thu tuc.
	*
	* @return the primary key of this cau hinh portlet2 thu tuc
	*/
	public long getPrimaryKey() {
		return _cauHinhPortlet2ThuTuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cau hinh portlet2 thu tuc.
	*
	* @param primaryKey the primary key of this cau hinh portlet2 thu tuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_cauHinhPortlet2ThuTuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this cau hinh portlet2 thu tuc.
	*
	* @return the thu tuc hanh chinh ID of this cau hinh portlet2 thu tuc
	*/
	public long getThuTucHanhChinhId() {
		return _cauHinhPortlet2ThuTuc.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this cau hinh portlet2 thu tuc.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this cau hinh portlet2 thu tuc
	*/
	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_cauHinhPortlet2ThuTuc.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the portlet ID of this cau hinh portlet2 thu tuc.
	*
	* @return the portlet ID of this cau hinh portlet2 thu tuc
	*/
	public long getPortletId() {
		return _cauHinhPortlet2ThuTuc.getPortletId();
	}

	/**
	* Sets the portlet ID of this cau hinh portlet2 thu tuc.
	*
	* @param portletId the portlet ID of this cau hinh portlet2 thu tuc
	*/
	public void setPortletId(long portletId) {
		_cauHinhPortlet2ThuTuc.setPortletId(portletId);
	}

	/**
	* Returns the portlet name of this cau hinh portlet2 thu tuc.
	*
	* @return the portlet name of this cau hinh portlet2 thu tuc
	*/
	public java.lang.String getPortletName() {
		return _cauHinhPortlet2ThuTuc.getPortletName();
	}

	/**
	* Sets the portlet name of this cau hinh portlet2 thu tuc.
	*
	* @param portletName the portlet name of this cau hinh portlet2 thu tuc
	*/
	public void setPortletName(java.lang.String portletName) {
		_cauHinhPortlet2ThuTuc.setPortletName(portletName);
	}

	public boolean isNew() {
		return _cauHinhPortlet2ThuTuc.isNew();
	}

	public void setNew(boolean n) {
		_cauHinhPortlet2ThuTuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _cauHinhPortlet2ThuTuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cauHinhPortlet2ThuTuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cauHinhPortlet2ThuTuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cauHinhPortlet2ThuTuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cauHinhPortlet2ThuTuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cauHinhPortlet2ThuTuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cauHinhPortlet2ThuTuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CauHinhPortlet2ThuTucWrapper((CauHinhPortlet2ThuTuc)_cauHinhPortlet2ThuTuc.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		return _cauHinhPortlet2ThuTuc.compareTo(cauHinhPortlet2ThuTuc);
	}

	@Override
	public int hashCode() {
		return _cauHinhPortlet2ThuTuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> toCacheModel() {
		return _cauHinhPortlet2ThuTuc.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc toEscapedModel() {
		return new CauHinhPortlet2ThuTucWrapper(_cauHinhPortlet2ThuTuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cauHinhPortlet2ThuTuc.toString();
	}

	public java.lang.String toXmlString() {
		return _cauHinhPortlet2ThuTuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cauHinhPortlet2ThuTuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CauHinhPortlet2ThuTuc getWrappedCauHinhPortlet2ThuTuc() {
		return _cauHinhPortlet2ThuTuc;
	}

	public CauHinhPortlet2ThuTuc getWrappedModel() {
		return _cauHinhPortlet2ThuTuc;
	}

	public void resetOriginalValues() {
		_cauHinhPortlet2ThuTuc.resetOriginalValues();
	}

	private CauHinhPortlet2ThuTuc _cauHinhPortlet2ThuTuc;
}