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

package org.oep.cmon.dao.cd.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link QuanHeGiaDinh}.
 * </p>
 *
 * @author    LIEMNN
 * @see       QuanHeGiaDinh
 * @generated
 */
public class QuanHeGiaDinhWrapper implements QuanHeGiaDinh,
	ModelWrapper<QuanHeGiaDinh> {
	public QuanHeGiaDinhWrapper(QuanHeGiaDinh quanHeGiaDinh) {
		_quanHeGiaDinh = quanHeGiaDinh;
	}

	public Class<?> getModelClass() {
		return QuanHeGiaDinh.class;
	}

	public String getModelClassName() {
		return QuanHeGiaDinh.class.getName();
	}

	/**
	* Returns the primary key of this quan he gia dinh.
	*
	* @return the primary key of this quan he gia dinh
	*/
	public long getPrimaryKey() {
		return _quanHeGiaDinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this quan he gia dinh.
	*
	* @param primaryKey the primary key of this quan he gia dinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_quanHeGiaDinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this quan he gia dinh.
	*
	* @return the ID of this quan he gia dinh
	*/
	public long getId() {
		return _quanHeGiaDinh.getId();
	}

	/**
	* Sets the ID of this quan he gia dinh.
	*
	* @param id the ID of this quan he gia dinh
	*/
	public void setId(long id) {
		_quanHeGiaDinh.setId(id);
	}

	/**
	* Returns the ten of this quan he gia dinh.
	*
	* @return the ten of this quan he gia dinh
	*/
	public java.lang.String getTen() {
		return _quanHeGiaDinh.getTen();
	}

	/**
	* Sets the ten of this quan he gia dinh.
	*
	* @param ten the ten of this quan he gia dinh
	*/
	public void setTen(java.lang.String ten) {
		_quanHeGiaDinh.setTen(ten);
	}

	/**
	* Returns the ngay tao of this quan he gia dinh.
	*
	* @return the ngay tao of this quan he gia dinh
	*/
	public java.util.Date getNgayTao() {
		return _quanHeGiaDinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this quan he gia dinh.
	*
	* @param ngayTao the ngay tao of this quan he gia dinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_quanHeGiaDinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this quan he gia dinh.
	*
	* @return the da xoa of this quan he gia dinh
	*/
	public int getDaXoa() {
		return _quanHeGiaDinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this quan he gia dinh.
	*
	* @param daXoa the da xoa of this quan he gia dinh
	*/
	public void setDaXoa(int daXoa) {
		_quanHeGiaDinh.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this quan he gia dinh.
	*
	* @return the nguoi tao of this quan he gia dinh
	*/
	public java.lang.String getNguoiTao() {
		return _quanHeGiaDinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this quan he gia dinh.
	*
	* @param nguoiTao the nguoi tao of this quan he gia dinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_quanHeGiaDinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this quan he gia dinh.
	*
	* @return the nguoi sua of this quan he gia dinh
	*/
	public java.lang.String getNguoiSua() {
		return _quanHeGiaDinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this quan he gia dinh.
	*
	* @param nguoiSua the nguoi sua of this quan he gia dinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_quanHeGiaDinh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this quan he gia dinh.
	*
	* @return the ngay sua of this quan he gia dinh
	*/
	public java.util.Date getNgaySua() {
		return _quanHeGiaDinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this quan he gia dinh.
	*
	* @param ngaySua the ngay sua of this quan he gia dinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_quanHeGiaDinh.setNgaySua(ngaySua);
	}

	public boolean isNew() {
		return _quanHeGiaDinh.isNew();
	}

	public void setNew(boolean n) {
		_quanHeGiaDinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _quanHeGiaDinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_quanHeGiaDinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _quanHeGiaDinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _quanHeGiaDinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_quanHeGiaDinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _quanHeGiaDinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_quanHeGiaDinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuanHeGiaDinhWrapper((QuanHeGiaDinh)_quanHeGiaDinh.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh) {
		return _quanHeGiaDinh.compareTo(quanHeGiaDinh);
	}

	@Override
	public int hashCode() {
		return _quanHeGiaDinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> toCacheModel() {
		return _quanHeGiaDinh.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh toEscapedModel() {
		return new QuanHeGiaDinhWrapper(_quanHeGiaDinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _quanHeGiaDinh.toString();
	}

	public java.lang.String toXmlString() {
		return _quanHeGiaDinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_quanHeGiaDinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public QuanHeGiaDinh getWrappedQuanHeGiaDinh() {
		return _quanHeGiaDinh;
	}

	public QuanHeGiaDinh getWrappedModel() {
		return _quanHeGiaDinh;
	}

	public void resetOriginalValues() {
		_quanHeGiaDinh.resetOriginalValues();
	}

	private QuanHeGiaDinh _quanHeGiaDinh;
}