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
 * This class is a wrapper for {@link NgheNghiep}.
 * </p>
 *
 * @author    LIEMNN
 * @see       NgheNghiep
 * @generated
 */
public class NgheNghiepWrapper implements NgheNghiep, ModelWrapper<NgheNghiep> {
	public NgheNghiepWrapper(NgheNghiep ngheNghiep) {
		_ngheNghiep = ngheNghiep;
	}

	public Class<?> getModelClass() {
		return NgheNghiep.class;
	}

	public String getModelClassName() {
		return NgheNghiep.class.getName();
	}

	/**
	* Returns the primary key of this nghe nghiep.
	*
	* @return the primary key of this nghe nghiep
	*/
	public long getPrimaryKey() {
		return _ngheNghiep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nghe nghiep.
	*
	* @param primaryKey the primary key of this nghe nghiep
	*/
	public void setPrimaryKey(long primaryKey) {
		_ngheNghiep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this nghe nghiep.
	*
	* @return the ID of this nghe nghiep
	*/
	public long getId() {
		return _ngheNghiep.getId();
	}

	/**
	* Sets the ID of this nghe nghiep.
	*
	* @param id the ID of this nghe nghiep
	*/
	public void setId(long id) {
		_ngheNghiep.setId(id);
	}

	/**
	* Returns the ma of this nghe nghiep.
	*
	* @return the ma of this nghe nghiep
	*/
	public java.lang.String getMa() {
		return _ngheNghiep.getMa();
	}

	/**
	* Sets the ma of this nghe nghiep.
	*
	* @param ma the ma of this nghe nghiep
	*/
	public void setMa(java.lang.String ma) {
		_ngheNghiep.setMa(ma);
	}

	/**
	* Returns the ten of this nghe nghiep.
	*
	* @return the ten of this nghe nghiep
	*/
	public java.lang.String getTen() {
		return _ngheNghiep.getTen();
	}

	/**
	* Sets the ten of this nghe nghiep.
	*
	* @param ten the ten of this nghe nghiep
	*/
	public void setTen(java.lang.String ten) {
		_ngheNghiep.setTen(ten);
	}

	/**
	* Returns the ngay tao of this nghe nghiep.
	*
	* @return the ngay tao of this nghe nghiep
	*/
	public java.util.Date getNgayTao() {
		return _ngheNghiep.getNgayTao();
	}

	/**
	* Sets the ngay tao of this nghe nghiep.
	*
	* @param ngayTao the ngay tao of this nghe nghiep
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_ngheNghiep.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this nghe nghiep.
	*
	* @return the da xoa of this nghe nghiep
	*/
	public int getDaXoa() {
		return _ngheNghiep.getDaXoa();
	}

	/**
	* Sets the da xoa of this nghe nghiep.
	*
	* @param daXoa the da xoa of this nghe nghiep
	*/
	public void setDaXoa(int daXoa) {
		_ngheNghiep.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this nghe nghiep.
	*
	* @return the nguoi tao of this nghe nghiep
	*/
	public java.lang.String getNguoiTao() {
		return _ngheNghiep.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this nghe nghiep.
	*
	* @param nguoiTao the nguoi tao of this nghe nghiep
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_ngheNghiep.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this nghe nghiep.
	*
	* @return the nguoi sua of this nghe nghiep
	*/
	public java.lang.String getNguoiSua() {
		return _ngheNghiep.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this nghe nghiep.
	*
	* @param nguoiSua the nguoi sua of this nghe nghiep
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_ngheNghiep.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this nghe nghiep.
	*
	* @return the ngay sua of this nghe nghiep
	*/
	public java.util.Date getNgaySua() {
		return _ngheNghiep.getNgaySua();
	}

	/**
	* Sets the ngay sua of this nghe nghiep.
	*
	* @param ngaySua the ngay sua of this nghe nghiep
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_ngheNghiep.setNgaySua(ngaySua);
	}

	/**
	* Returns the phien ban of this nghe nghiep.
	*
	* @return the phien ban of this nghe nghiep
	*/
	public long getPhienBan() {
		return _ngheNghiep.getPhienBan();
	}

	/**
	* Sets the phien ban of this nghe nghiep.
	*
	* @param phienBan the phien ban of this nghe nghiep
	*/
	public void setPhienBan(long phienBan) {
		_ngheNghiep.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _ngheNghiep.isNew();
	}

	public void setNew(boolean n) {
		_ngheNghiep.setNew(n);
	}

	public boolean isCachedModel() {
		return _ngheNghiep.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ngheNghiep.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ngheNghiep.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ngheNghiep.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ngheNghiep.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ngheNghiep.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ngheNghiep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NgheNghiepWrapper((NgheNghiep)_ngheNghiep.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep) {
		return _ngheNghiep.compareTo(ngheNghiep);
	}

	@Override
	public int hashCode() {
		return _ngheNghiep.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.NgheNghiep> toCacheModel() {
		return _ngheNghiep.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.NgheNghiep toEscapedModel() {
		return new NgheNghiepWrapper(_ngheNghiep.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ngheNghiep.toString();
	}

	public java.lang.String toXmlString() {
		return _ngheNghiep.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ngheNghiep.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NgheNghiep getWrappedNgheNghiep() {
		return _ngheNghiep;
	}

	public NgheNghiep getWrappedModel() {
		return _ngheNghiep;
	}

	public void resetOriginalValues() {
		_ngheNghiep.resetOriginalValues();
	}

	private NgheNghiep _ngheNghiep;
}