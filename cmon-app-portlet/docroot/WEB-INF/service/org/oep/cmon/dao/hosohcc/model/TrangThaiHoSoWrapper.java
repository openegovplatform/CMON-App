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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrangThaiHoSo}.
 * </p>
 *
 * @author    LIEMNn
 * @see       TrangThaiHoSo
 * @generated
 */
public class TrangThaiHoSoWrapper implements TrangThaiHoSo,
	ModelWrapper<TrangThaiHoSo> {
	public TrangThaiHoSoWrapper(TrangThaiHoSo trangThaiHoSo) {
		_trangThaiHoSo = trangThaiHoSo;
	}

	public Class<?> getModelClass() {
		return TrangThaiHoSo.class;
	}

	public String getModelClassName() {
		return TrangThaiHoSo.class.getName();
	}

	/**
	* Returns the primary key of this trang thai ho so.
	*
	* @return the primary key of this trang thai ho so
	*/
	public long getPrimaryKey() {
		return _trangThaiHoSo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trang thai ho so.
	*
	* @param primaryKey the primary key of this trang thai ho so
	*/
	public void setPrimaryKey(long primaryKey) {
		_trangThaiHoSo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this trang thai ho so.
	*
	* @return the ID of this trang thai ho so
	*/
	public long getId() {
		return _trangThaiHoSo.getId();
	}

	/**
	* Sets the ID of this trang thai ho so.
	*
	* @param id the ID of this trang thai ho so
	*/
	public void setId(long id) {
		_trangThaiHoSo.setId(id);
	}

	/**
	* Returns the trang thai of this trang thai ho so.
	*
	* @return the trang thai of this trang thai ho so
	*/
	public java.lang.String getTrangThai() {
		return _trangThaiHoSo.getTrangThai();
	}

	/**
	* Sets the trang thai of this trang thai ho so.
	*
	* @param trangThai the trang thai of this trang thai ho so
	*/
	public void setTrangThai(java.lang.String trangThai) {
		_trangThaiHoSo.setTrangThai(trangThai);
	}

	/**
	* Returns the nguoi tao of this trang thai ho so.
	*
	* @return the nguoi tao of this trang thai ho so
	*/
	public java.lang.String getNguoiTao() {
		return _trangThaiHoSo.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this trang thai ho so.
	*
	* @param nguoiTao the nguoi tao of this trang thai ho so
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_trangThaiHoSo.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this trang thai ho so.
	*
	* @return the ngay tao of this trang thai ho so
	*/
	public java.util.Date getNgayTao() {
		return _trangThaiHoSo.getNgayTao();
	}

	/**
	* Sets the ngay tao of this trang thai ho so.
	*
	* @param ngayTao the ngay tao of this trang thai ho so
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_trangThaiHoSo.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this trang thai ho so.
	*
	* @return the nguoi sua of this trang thai ho so
	*/
	public java.lang.String getNguoiSua() {
		return _trangThaiHoSo.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this trang thai ho so.
	*
	* @param nguoiSua the nguoi sua of this trang thai ho so
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_trangThaiHoSo.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this trang thai ho so.
	*
	* @return the ngay sua of this trang thai ho so
	*/
	public java.util.Date getNgaySua() {
		return _trangThaiHoSo.getNgaySua();
	}

	/**
	* Sets the ngay sua of this trang thai ho so.
	*
	* @param ngaySua the ngay sua of this trang thai ho so
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_trangThaiHoSo.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this trang thai ho so.
	*
	* @return the da xoa of this trang thai ho so
	*/
	public int getDaXoa() {
		return _trangThaiHoSo.getDaXoa();
	}

	/**
	* Sets the da xoa of this trang thai ho so.
	*
	* @param daXoa the da xoa of this trang thai ho so
	*/
	public void setDaXoa(int daXoa) {
		_trangThaiHoSo.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _trangThaiHoSo.isNew();
	}

	public void setNew(boolean n) {
		_trangThaiHoSo.setNew(n);
	}

	public boolean isCachedModel() {
		return _trangThaiHoSo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trangThaiHoSo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trangThaiHoSo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trangThaiHoSo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trangThaiHoSo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trangThaiHoSo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trangThaiHoSo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrangThaiHoSoWrapper((TrangThaiHoSo)_trangThaiHoSo.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo) {
		return _trangThaiHoSo.compareTo(trangThaiHoSo);
	}

	@Override
	public int hashCode() {
		return _trangThaiHoSo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> toCacheModel() {
		return _trangThaiHoSo.toCacheModel();
	}

	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo toEscapedModel() {
		return new TrangThaiHoSoWrapper(_trangThaiHoSo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trangThaiHoSo.toString();
	}

	public java.lang.String toXmlString() {
		return _trangThaiHoSo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiHoSo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrangThaiHoSo getWrappedTrangThaiHoSo() {
		return _trangThaiHoSo;
	}

	public TrangThaiHoSo getWrappedModel() {
		return _trangThaiHoSo;
	}

	public void resetOriginalValues() {
		_trangThaiHoSo.resetOriginalValues();
	}

	private TrangThaiHoSo _trangThaiHoSo;
}