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

package org.oep.cmon.dao.qlhc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link QuocGia}.
 * </p>
 *
 * @author    LIEMNN
 * @see       QuocGia
 * @generated
 */
public class QuocGiaWrapper implements QuocGia, ModelWrapper<QuocGia> {
	public QuocGiaWrapper(QuocGia quocGia) {
		_quocGia = quocGia;
	}

	public Class<?> getModelClass() {
		return QuocGia.class;
	}

	public String getModelClassName() {
		return QuocGia.class.getName();
	}

	/**
	* Returns the primary key of this quoc gia.
	*
	* @return the primary key of this quoc gia
	*/
	public long getPrimaryKey() {
		return _quocGia.getPrimaryKey();
	}

	/**
	* Sets the primary key of this quoc gia.
	*
	* @param primaryKey the primary key of this quoc gia
	*/
	public void setPrimaryKey(long primaryKey) {
		_quocGia.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this quoc gia.
	*
	* @return the ID of this quoc gia
	*/
	public long getId() {
		return _quocGia.getId();
	}

	/**
	* Sets the ID of this quoc gia.
	*
	* @param id the ID of this quoc gia
	*/
	public void setId(long id) {
		_quocGia.setId(id);
	}

	/**
	* Returns the ma of this quoc gia.
	*
	* @return the ma of this quoc gia
	*/
	public java.lang.String getMa() {
		return _quocGia.getMa();
	}

	/**
	* Sets the ma of this quoc gia.
	*
	* @param ma the ma of this quoc gia
	*/
	public void setMa(java.lang.String ma) {
		_quocGia.setMa(ma);
	}

	/**
	* Returns the ten of this quoc gia.
	*
	* @return the ten of this quoc gia
	*/
	public java.lang.String getTen() {
		return _quocGia.getTen();
	}

	/**
	* Sets the ten of this quoc gia.
	*
	* @param ten the ten of this quoc gia
	*/
	public void setTen(java.lang.String ten) {
		_quocGia.setTen(ten);
	}

	/**
	* Returns the ngay tao of this quoc gia.
	*
	* @return the ngay tao of this quoc gia
	*/
	public java.util.Date getNgayTao() {
		return _quocGia.getNgayTao();
	}

	/**
	* Sets the ngay tao of this quoc gia.
	*
	* @param ngayTao the ngay tao of this quoc gia
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_quocGia.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this quoc gia.
	*
	* @return the ngay sua of this quoc gia
	*/
	public java.util.Date getNgaySua() {
		return _quocGia.getNgaySua();
	}

	/**
	* Sets the ngay sua of this quoc gia.
	*
	* @param ngaySua the ngay sua of this quoc gia
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_quocGia.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this quoc gia.
	*
	* @return the da xoa of this quoc gia
	*/
	public int getDaXoa() {
		return _quocGia.getDaXoa();
	}

	/**
	* Sets the da xoa of this quoc gia.
	*
	* @param daXoa the da xoa of this quoc gia
	*/
	public void setDaXoa(int daXoa) {
		_quocGia.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this quoc gia.
	*
	* @return the nguoi tao of this quoc gia
	*/
	public java.lang.String getNguoiTao() {
		return _quocGia.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this quoc gia.
	*
	* @param nguoiTao the nguoi tao of this quoc gia
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_quocGia.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this quoc gia.
	*
	* @return the nguoi sua of this quoc gia
	*/
	public java.lang.String getNguoiSua() {
		return _quocGia.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this quoc gia.
	*
	* @param nguoiSua the nguoi sua of this quoc gia
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_quocGia.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the phien ban of this quoc gia.
	*
	* @return the phien ban of this quoc gia
	*/
	public int getPhienBan() {
		return _quocGia.getPhienBan();
	}

	/**
	* Sets the phien ban of this quoc gia.
	*
	* @param phienBan the phien ban of this quoc gia
	*/
	public void setPhienBan(int phienBan) {
		_quocGia.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _quocGia.isNew();
	}

	public void setNew(boolean n) {
		_quocGia.setNew(n);
	}

	public boolean isCachedModel() {
		return _quocGia.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_quocGia.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _quocGia.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _quocGia.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_quocGia.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _quocGia.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_quocGia.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuocGiaWrapper((QuocGia)_quocGia.clone());
	}

	public int compareTo(org.oep.cmon.dao.qlhc.model.QuocGia quocGia) {
		return _quocGia.compareTo(quocGia);
	}

	@Override
	public int hashCode() {
		return _quocGia.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.qlhc.model.QuocGia> toCacheModel() {
		return _quocGia.toCacheModel();
	}

	public org.oep.cmon.dao.qlhc.model.QuocGia toEscapedModel() {
		return new QuocGiaWrapper(_quocGia.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _quocGia.toString();
	}

	public java.lang.String toXmlString() {
		return _quocGia.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_quocGia.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public QuocGia getWrappedQuocGia() {
		return _quocGia;
	}

	public QuocGia getWrappedModel() {
		return _quocGia;
	}

	public void resetOriginalValues() {
		_quocGia.resetOriginalValues();
	}

	private QuocGia _quocGia;
}