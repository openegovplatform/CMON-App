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

package org.oep.cmon.dao.cc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChucVu}.
 * </p>
 *
 * @author    Liemnn
 * @see       ChucVu
 * @generated
 */
public class ChucVuWrapper implements ChucVu, ModelWrapper<ChucVu> {
	public ChucVuWrapper(ChucVu chucVu) {
		_chucVu = chucVu;
	}

	public Class<?> getModelClass() {
		return ChucVu.class;
	}

	public String getModelClassName() {
		return ChucVu.class.getName();
	}

	/**
	* Returns the primary key of this chuc vu.
	*
	* @return the primary key of this chuc vu
	*/
	public long getPrimaryKey() {
		return _chucVu.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chuc vu.
	*
	* @param primaryKey the primary key of this chuc vu
	*/
	public void setPrimaryKey(long primaryKey) {
		_chucVu.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this chuc vu.
	*
	* @return the ID of this chuc vu
	*/
	public long getId() {
		return _chucVu.getId();
	}

	/**
	* Sets the ID of this chuc vu.
	*
	* @param id the ID of this chuc vu
	*/
	public void setId(long id) {
		_chucVu.setId(id);
	}

	/**
	* Returns the ma of this chuc vu.
	*
	* @return the ma of this chuc vu
	*/
	public java.lang.String getMa() {
		return _chucVu.getMa();
	}

	/**
	* Sets the ma of this chuc vu.
	*
	* @param ma the ma of this chuc vu
	*/
	public void setMa(java.lang.String ma) {
		_chucVu.setMa(ma);
	}

	/**
	* Returns the ten of this chuc vu.
	*
	* @return the ten of this chuc vu
	*/
	public java.lang.String getTen() {
		return _chucVu.getTen();
	}

	/**
	* Sets the ten of this chuc vu.
	*
	* @param ten the ten of this chuc vu
	*/
	public void setTen(java.lang.String ten) {
		_chucVu.setTen(ten);
	}

	/**
	* Returns the phien ban of this chuc vu.
	*
	* @return the phien ban of this chuc vu
	*/
	public long getPhienBan() {
		return _chucVu.getPhienBan();
	}

	/**
	* Sets the phien ban of this chuc vu.
	*
	* @param phienBan the phien ban of this chuc vu
	*/
	public void setPhienBan(long phienBan) {
		_chucVu.setPhienBan(phienBan);
	}

	/**
	* Returns the ngay tao of this chuc vu.
	*
	* @return the ngay tao of this chuc vu
	*/
	public java.util.Date getNgayTao() {
		return _chucVu.getNgayTao();
	}

	/**
	* Sets the ngay tao of this chuc vu.
	*
	* @param ngayTao the ngay tao of this chuc vu
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_chucVu.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this chuc vu.
	*
	* @return the da xoa of this chuc vu
	*/
	public int getDaXoa() {
		return _chucVu.getDaXoa();
	}

	/**
	* Sets the da xoa of this chuc vu.
	*
	* @param daXoa the da xoa of this chuc vu
	*/
	public void setDaXoa(int daXoa) {
		_chucVu.setDaXoa(daXoa);
	}

	/**
	* Returns the ngay sua of this chuc vu.
	*
	* @return the ngay sua of this chuc vu
	*/
	public java.util.Date getNgaySua() {
		return _chucVu.getNgaySua();
	}

	/**
	* Sets the ngay sua of this chuc vu.
	*
	* @param ngaySua the ngay sua of this chuc vu
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_chucVu.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this chuc vu.
	*
	* @return the nguoi tao of this chuc vu
	*/
	public java.lang.String getNguoiTao() {
		return _chucVu.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this chuc vu.
	*
	* @param nguoiTao the nguoi tao of this chuc vu
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_chucVu.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this chuc vu.
	*
	* @return the nguoi sua of this chuc vu
	*/
	public java.lang.String getNguoiSua() {
		return _chucVu.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this chuc vu.
	*
	* @param nguoiSua the nguoi sua of this chuc vu
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_chucVu.setNguoiSua(nguoiSua);
	}

	public boolean isNew() {
		return _chucVu.isNew();
	}

	public void setNew(boolean n) {
		_chucVu.setNew(n);
	}

	public boolean isCachedModel() {
		return _chucVu.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_chucVu.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _chucVu.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _chucVu.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chucVu.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chucVu.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chucVu.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChucVuWrapper((ChucVu)_chucVu.clone());
	}

	public int compareTo(org.oep.cmon.dao.cc.model.ChucVu chucVu) {
		return _chucVu.compareTo(chucVu);
	}

	@Override
	public int hashCode() {
		return _chucVu.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cc.model.ChucVu> toCacheModel() {
		return _chucVu.toCacheModel();
	}

	public org.oep.cmon.dao.cc.model.ChucVu toEscapedModel() {
		return new ChucVuWrapper(_chucVu.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chucVu.toString();
	}

	public java.lang.String toXmlString() {
		return _chucVu.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chucVu.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ChucVu getWrappedChucVu() {
		return _chucVu;
	}

	public ChucVu getWrappedModel() {
		return _chucVu;
	}

	public void resetOriginalValues() {
		_chucVu.resetOriginalValues();
	}

	private ChucVu _chucVu;
}