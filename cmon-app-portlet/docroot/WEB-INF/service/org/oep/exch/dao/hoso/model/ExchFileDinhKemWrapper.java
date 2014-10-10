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

package org.oep.exch.dao.hoso.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExchFileDinhKem}.
 * </p>
 *
 * @author    NAM
 * @see       ExchFileDinhKem
 * @generated
 */
public class ExchFileDinhKemWrapper implements ExchFileDinhKem,
	ModelWrapper<ExchFileDinhKem> {
	public ExchFileDinhKemWrapper(ExchFileDinhKem exchFileDinhKem) {
		_exchFileDinhKem = exchFileDinhKem;
	}

	public Class<?> getModelClass() {
		return ExchFileDinhKem.class;
	}

	public String getModelClassName() {
		return ExchFileDinhKem.class.getName();
	}

	/**
	* Returns the primary key of this exch file dinh kem.
	*
	* @return the primary key of this exch file dinh kem
	*/
	public long getPrimaryKey() {
		return _exchFileDinhKem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this exch file dinh kem.
	*
	* @param primaryKey the primary key of this exch file dinh kem
	*/
	public void setPrimaryKey(long primaryKey) {
		_exchFileDinhKem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this exch file dinh kem.
	*
	* @return the ID of this exch file dinh kem
	*/
	public long getId() {
		return _exchFileDinhKem.getId();
	}

	/**
	* Sets the ID of this exch file dinh kem.
	*
	* @param id the ID of this exch file dinh kem
	*/
	public void setId(long id) {
		_exchFileDinhKem.setId(id);
	}

	/**
	* Returns the online ID of this exch file dinh kem.
	*
	* @return the online ID of this exch file dinh kem
	*/
	public long getOnlineId() {
		return _exchFileDinhKem.getOnlineId();
	}

	/**
	* Sets the online ID of this exch file dinh kem.
	*
	* @param OnlineId the online ID of this exch file dinh kem
	*/
	public void setOnlineId(long OnlineId) {
		_exchFileDinhKem.setOnlineId(OnlineId);
	}

	/**
	* Returns the ten tai lieu dinh kem of this exch file dinh kem.
	*
	* @return the ten tai lieu dinh kem of this exch file dinh kem
	*/
	public java.lang.String getTenTaiLieuDinhKem() {
		return _exchFileDinhKem.getTenTaiLieuDinhKem();
	}

	/**
	* Sets the ten tai lieu dinh kem of this exch file dinh kem.
	*
	* @param TenTaiLieuDinhKem the ten tai lieu dinh kem of this exch file dinh kem
	*/
	public void setTenTaiLieuDinhKem(java.lang.String TenTaiLieuDinhKem) {
		_exchFileDinhKem.setTenTaiLieuDinhKem(TenTaiLieuDinhKem);
	}

	/**
	* Returns the url tai lieu dinh kem of this exch file dinh kem.
	*
	* @return the url tai lieu dinh kem of this exch file dinh kem
	*/
	public java.lang.String getUrlTaiLieuDinhKem() {
		return _exchFileDinhKem.getUrlTaiLieuDinhKem();
	}

	/**
	* Sets the url tai lieu dinh kem of this exch file dinh kem.
	*
	* @param UrlTaiLieuDinhKem the url tai lieu dinh kem of this exch file dinh kem
	*/
	public void setUrlTaiLieuDinhKem(java.lang.String UrlTaiLieuDinhKem) {
		_exchFileDinhKem.setUrlTaiLieuDinhKem(UrlTaiLieuDinhKem);
	}

	/**
	* Returns the ten file of this exch file dinh kem.
	*
	* @return the ten file of this exch file dinh kem
	*/
	public java.lang.String getTenFile() {
		return _exchFileDinhKem.getTenFile();
	}

	/**
	* Sets the ten file of this exch file dinh kem.
	*
	* @param TenFile the ten file of this exch file dinh kem
	*/
	public void setTenFile(java.lang.String TenFile) {
		_exchFileDinhKem.setTenFile(TenFile);
	}

	public boolean isNew() {
		return _exchFileDinhKem.isNew();
	}

	public void setNew(boolean n) {
		_exchFileDinhKem.setNew(n);
	}

	public boolean isCachedModel() {
		return _exchFileDinhKem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_exchFileDinhKem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _exchFileDinhKem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _exchFileDinhKem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_exchFileDinhKem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _exchFileDinhKem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_exchFileDinhKem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExchFileDinhKemWrapper((ExchFileDinhKem)_exchFileDinhKem.clone());
	}

	public int compareTo(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem) {
		return _exchFileDinhKem.compareTo(exchFileDinhKem);
	}

	@Override
	public int hashCode() {
		return _exchFileDinhKem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.exch.dao.hoso.model.ExchFileDinhKem> toCacheModel() {
		return _exchFileDinhKem.toCacheModel();
	}

	public org.oep.exch.dao.hoso.model.ExchFileDinhKem toEscapedModel() {
		return new ExchFileDinhKemWrapper(_exchFileDinhKem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _exchFileDinhKem.toString();
	}

	public java.lang.String toXmlString() {
		return _exchFileDinhKem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_exchFileDinhKem.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ExchFileDinhKem getWrappedExchFileDinhKem() {
		return _exchFileDinhKem;
	}

	public ExchFileDinhKem getWrappedModel() {
		return _exchFileDinhKem;
	}

	public void resetOriginalValues() {
		_exchFileDinhKem.resetOriginalValues();
	}

	private ExchFileDinhKem _exchFileDinhKem;
}