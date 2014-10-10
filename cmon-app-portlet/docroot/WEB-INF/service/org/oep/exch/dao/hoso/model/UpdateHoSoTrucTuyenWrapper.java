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
 * This class is a wrapper for {@link UpdateHoSoTrucTuyen}.
 * </p>
 *
 * @author    NAM
 * @see       UpdateHoSoTrucTuyen
 * @generated
 */
public class UpdateHoSoTrucTuyenWrapper implements UpdateHoSoTrucTuyen,
	ModelWrapper<UpdateHoSoTrucTuyen> {
	public UpdateHoSoTrucTuyenWrapper(UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		_updateHoSoTrucTuyen = updateHoSoTrucTuyen;
	}

	public Class<?> getModelClass() {
		return UpdateHoSoTrucTuyen.class;
	}

	public String getModelClassName() {
		return UpdateHoSoTrucTuyen.class.getName();
	}

	/**
	* Returns the primary key of this update ho so truc tuyen.
	*
	* @return the primary key of this update ho so truc tuyen
	*/
	public long getPrimaryKey() {
		return _updateHoSoTrucTuyen.getPrimaryKey();
	}

	/**
	* Sets the primary key of this update ho so truc tuyen.
	*
	* @param primaryKey the primary key of this update ho so truc tuyen
	*/
	public void setPrimaryKey(long primaryKey) {
		_updateHoSoTrucTuyen.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this update ho so truc tuyen.
	*
	* @return the ID of this update ho so truc tuyen
	*/
	public long getId() {
		return _updateHoSoTrucTuyen.getId();
	}

	/**
	* Sets the ID of this update ho so truc tuyen.
	*
	* @param id the ID of this update ho so truc tuyen
	*/
	public void setId(long id) {
		_updateHoSoTrucTuyen.setId(id);
	}

	/**
	* Returns the trang thai xu ly of this update ho so truc tuyen.
	*
	* @return the trang thai xu ly of this update ho so truc tuyen
	*/
	public int getTrangThaiXuLy() {
		return _updateHoSoTrucTuyen.getTrangThaiXuLy();
	}

	/**
	* Sets the trang thai xu ly of this update ho so truc tuyen.
	*
	* @param TrangThaiXuLy the trang thai xu ly of this update ho so truc tuyen
	*/
	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_updateHoSoTrucTuyen.setTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the ngay chuyen of this update ho so truc tuyen.
	*
	* @return the ngay chuyen of this update ho so truc tuyen
	*/
	public java.util.Date getNgayChuyen() {
		return _updateHoSoTrucTuyen.getNgayChuyen();
	}

	/**
	* Sets the ngay chuyen of this update ho so truc tuyen.
	*
	* @param NgayChuyen the ngay chuyen of this update ho so truc tuyen
	*/
	public void setNgayChuyen(java.util.Date NgayChuyen) {
		_updateHoSoTrucTuyen.setNgayChuyen(NgayChuyen);
	}

	public boolean isNew() {
		return _updateHoSoTrucTuyen.isNew();
	}

	public void setNew(boolean n) {
		_updateHoSoTrucTuyen.setNew(n);
	}

	public boolean isCachedModel() {
		return _updateHoSoTrucTuyen.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_updateHoSoTrucTuyen.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _updateHoSoTrucTuyen.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _updateHoSoTrucTuyen.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_updateHoSoTrucTuyen.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _updateHoSoTrucTuyen.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_updateHoSoTrucTuyen.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UpdateHoSoTrucTuyenWrapper((UpdateHoSoTrucTuyen)_updateHoSoTrucTuyen.clone());
	}

	public int compareTo(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		return _updateHoSoTrucTuyen.compareTo(updateHoSoTrucTuyen);
	}

	@Override
	public int hashCode() {
		return _updateHoSoTrucTuyen.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> toCacheModel() {
		return _updateHoSoTrucTuyen.toCacheModel();
	}

	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen toEscapedModel() {
		return new UpdateHoSoTrucTuyenWrapper(_updateHoSoTrucTuyen.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _updateHoSoTrucTuyen.toString();
	}

	public java.lang.String toXmlString() {
		return _updateHoSoTrucTuyen.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_updateHoSoTrucTuyen.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UpdateHoSoTrucTuyen getWrappedUpdateHoSoTrucTuyen() {
		return _updateHoSoTrucTuyen;
	}

	public UpdateHoSoTrucTuyen getWrappedModel() {
		return _updateHoSoTrucTuyen;
	}

	public void resetOriginalValues() {
		_updateHoSoTrucTuyen.resetOriginalValues();
	}

	private UpdateHoSoTrucTuyen _updateHoSoTrucTuyen;
}