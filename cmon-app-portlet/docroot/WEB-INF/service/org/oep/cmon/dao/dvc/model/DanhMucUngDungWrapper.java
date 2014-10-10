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
 * This class is a wrapper for {@link DanhMucUngDung}.
 * </p>
 *
 * @author    liemnn
 * @see       DanhMucUngDung
 * @generated
 */
public class DanhMucUngDungWrapper implements DanhMucUngDung,
	ModelWrapper<DanhMucUngDung> {
	public DanhMucUngDungWrapper(DanhMucUngDung danhMucUngDung) {
		_danhMucUngDung = danhMucUngDung;
	}

	public Class<?> getModelClass() {
		return DanhMucUngDung.class;
	}

	public String getModelClassName() {
		return DanhMucUngDung.class.getName();
	}

	/**
	* Returns the primary key of this danh muc ung dung.
	*
	* @return the primary key of this danh muc ung dung
	*/
	public long getPrimaryKey() {
		return _danhMucUngDung.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh muc ung dung.
	*
	* @param primaryKey the primary key of this danh muc ung dung
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhMucUngDung.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this danh muc ung dung.
	*
	* @return the ID of this danh muc ung dung
	*/
	public long getId() {
		return _danhMucUngDung.getId();
	}

	/**
	* Sets the ID of this danh muc ung dung.
	*
	* @param id the ID of this danh muc ung dung
	*/
	public void setId(long id) {
		_danhMucUngDung.setId(id);
	}

	/**
	* Returns the ma of this danh muc ung dung.
	*
	* @return the ma of this danh muc ung dung
	*/
	public java.lang.String getMa() {
		return _danhMucUngDung.getMa();
	}

	/**
	* Sets the ma of this danh muc ung dung.
	*
	* @param ma the ma of this danh muc ung dung
	*/
	public void setMa(java.lang.String ma) {
		_danhMucUngDung.setMa(ma);
	}

	/**
	* Returns the ten of this danh muc ung dung.
	*
	* @return the ten of this danh muc ung dung
	*/
	public java.lang.String getTen() {
		return _danhMucUngDung.getTen();
	}

	/**
	* Sets the ten of this danh muc ung dung.
	*
	* @param ten the ten of this danh muc ung dung
	*/
	public void setTen(java.lang.String ten) {
		_danhMucUngDung.setTen(ten);
	}

	/**
	* Returns the ngay tao of this danh muc ung dung.
	*
	* @return the ngay tao of this danh muc ung dung
	*/
	public java.util.Date getNgayTao() {
		return _danhMucUngDung.getNgayTao();
	}

	/**
	* Sets the ngay tao of this danh muc ung dung.
	*
	* @param ngayTao the ngay tao of this danh muc ung dung
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_danhMucUngDung.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this danh muc ung dung.
	*
	* @return the ngay sua of this danh muc ung dung
	*/
	public java.util.Date getNgaySua() {
		return _danhMucUngDung.getNgaySua();
	}

	/**
	* Sets the ngay sua of this danh muc ung dung.
	*
	* @param ngaySua the ngay sua of this danh muc ung dung
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_danhMucUngDung.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this danh muc ung dung.
	*
	* @return the da xoa of this danh muc ung dung
	*/
	public int getDaXoa() {
		return _danhMucUngDung.getDaXoa();
	}

	/**
	* Sets the da xoa of this danh muc ung dung.
	*
	* @param daXoa the da xoa of this danh muc ung dung
	*/
	public void setDaXoa(int daXoa) {
		_danhMucUngDung.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi sua of this danh muc ung dung.
	*
	* @return the nguoi sua of this danh muc ung dung
	*/
	public java.lang.String getNguoiSua() {
		return _danhMucUngDung.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this danh muc ung dung.
	*
	* @param nguoiSua the nguoi sua of this danh muc ung dung
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_danhMucUngDung.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the nguoi tao of this danh muc ung dung.
	*
	* @return the nguoi tao of this danh muc ung dung
	*/
	public java.lang.String getNguoiTao() {
		return _danhMucUngDung.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this danh muc ung dung.
	*
	* @param nguoiTao the nguoi tao of this danh muc ung dung
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_danhMucUngDung.setNguoiTao(nguoiTao);
	}

	public boolean isNew() {
		return _danhMucUngDung.isNew();
	}

	public void setNew(boolean n) {
		_danhMucUngDung.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhMucUngDung.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhMucUngDung.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhMucUngDung.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhMucUngDung.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhMucUngDung.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhMucUngDung.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhMucUngDung.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhMucUngDungWrapper((DanhMucUngDung)_danhMucUngDung.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.DanhMucUngDung danhMucUngDung) {
		return _danhMucUngDung.compareTo(danhMucUngDung);
	}

	@Override
	public int hashCode() {
		return _danhMucUngDung.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.DanhMucUngDung> toCacheModel() {
		return _danhMucUngDung.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.DanhMucUngDung toEscapedModel() {
		return new DanhMucUngDungWrapper(_danhMucUngDung.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhMucUngDung.toString();
	}

	public java.lang.String toXmlString() {
		return _danhMucUngDung.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucUngDung.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhMucUngDung getWrappedDanhMucUngDung() {
		return _danhMucUngDung;
	}

	public DanhMucUngDung getWrappedModel() {
		return _danhMucUngDung;
	}

	public void resetOriginalValues() {
		_danhMucUngDung.resetOriginalValues();
	}

	private DanhMucUngDung _danhMucUngDung;
}