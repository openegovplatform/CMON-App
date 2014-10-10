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
 * This class is a wrapper for {@link NhomThuTucHanhChinh}.
 * </p>
 *
 * @author    liemnn
 * @see       NhomThuTucHanhChinh
 * @generated
 */
public class NhomThuTucHanhChinhWrapper implements NhomThuTucHanhChinh,
	ModelWrapper<NhomThuTucHanhChinh> {
	public NhomThuTucHanhChinhWrapper(NhomThuTucHanhChinh nhomThuTucHanhChinh) {
		_nhomThuTucHanhChinh = nhomThuTucHanhChinh;
	}

	public Class<?> getModelClass() {
		return NhomThuTucHanhChinh.class;
	}

	public String getModelClassName() {
		return NhomThuTucHanhChinh.class.getName();
	}

	/**
	* Returns the primary key of this nhom thu tuc hanh chinh.
	*
	* @return the primary key of this nhom thu tuc hanh chinh
	*/
	public long getPrimaryKey() {
		return _nhomThuTucHanhChinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nhom thu tuc hanh chinh.
	*
	* @param primaryKey the primary key of this nhom thu tuc hanh chinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_nhomThuTucHanhChinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this nhom thu tuc hanh chinh.
	*
	* @return the ID of this nhom thu tuc hanh chinh
	*/
	public long getId() {
		return _nhomThuTucHanhChinh.getId();
	}

	/**
	* Sets the ID of this nhom thu tuc hanh chinh.
	*
	* @param id the ID of this nhom thu tuc hanh chinh
	*/
	public void setId(long id) {
		_nhomThuTucHanhChinh.setId(id);
	}

	/**
	* Returns the ma of this nhom thu tuc hanh chinh.
	*
	* @return the ma of this nhom thu tuc hanh chinh
	*/
	public java.lang.String getMa() {
		return _nhomThuTucHanhChinh.getMa();
	}

	/**
	* Sets the ma of this nhom thu tuc hanh chinh.
	*
	* @param ma the ma of this nhom thu tuc hanh chinh
	*/
	public void setMa(java.lang.String ma) {
		_nhomThuTucHanhChinh.setMa(ma);
	}

	/**
	* Returns the ten of this nhom thu tuc hanh chinh.
	*
	* @return the ten of this nhom thu tuc hanh chinh
	*/
	public java.lang.String getTen() {
		return _nhomThuTucHanhChinh.getTen();
	}

	/**
	* Sets the ten of this nhom thu tuc hanh chinh.
	*
	* @param ten the ten of this nhom thu tuc hanh chinh
	*/
	public void setTen(java.lang.String ten) {
		_nhomThuTucHanhChinh.setTen(ten);
	}

	/**
	* Returns the ngay tao of this nhom thu tuc hanh chinh.
	*
	* @return the ngay tao of this nhom thu tuc hanh chinh
	*/
	public java.util.Date getNgayTao() {
		return _nhomThuTucHanhChinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this nhom thu tuc hanh chinh.
	*
	* @param ngayTao the ngay tao of this nhom thu tuc hanh chinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_nhomThuTucHanhChinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this nhom thu tuc hanh chinh.
	*
	* @return the ngay sua of this nhom thu tuc hanh chinh
	*/
	public java.util.Date getNgaySua() {
		return _nhomThuTucHanhChinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this nhom thu tuc hanh chinh.
	*
	* @param ngaySua the ngay sua of this nhom thu tuc hanh chinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_nhomThuTucHanhChinh.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this nhom thu tuc hanh chinh.
	*
	* @return the da xoa of this nhom thu tuc hanh chinh
	*/
	public int getDaXoa() {
		return _nhomThuTucHanhChinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this nhom thu tuc hanh chinh.
	*
	* @param daXoa the da xoa of this nhom thu tuc hanh chinh
	*/
	public void setDaXoa(int daXoa) {
		_nhomThuTucHanhChinh.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi sua of this nhom thu tuc hanh chinh.
	*
	* @return the nguoi sua of this nhom thu tuc hanh chinh
	*/
	public java.lang.String getNguoiSua() {
		return _nhomThuTucHanhChinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this nhom thu tuc hanh chinh.
	*
	* @param nguoiSua the nguoi sua of this nhom thu tuc hanh chinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_nhomThuTucHanhChinh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the nguoi tao of this nhom thu tuc hanh chinh.
	*
	* @return the nguoi tao of this nhom thu tuc hanh chinh
	*/
	public java.lang.String getNguoiTao() {
		return _nhomThuTucHanhChinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this nhom thu tuc hanh chinh.
	*
	* @param nguoiTao the nguoi tao of this nhom thu tuc hanh chinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_nhomThuTucHanhChinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the danh muc ung dung ID of this nhom thu tuc hanh chinh.
	*
	* @return the danh muc ung dung ID of this nhom thu tuc hanh chinh
	*/
	public long getDanhMucUngDungId() {
		return _nhomThuTucHanhChinh.getDanhMucUngDungId();
	}

	/**
	* Sets the danh muc ung dung ID of this nhom thu tuc hanh chinh.
	*
	* @param danhMucUngDungId the danh muc ung dung ID of this nhom thu tuc hanh chinh
	*/
	public void setDanhMucUngDungId(long danhMucUngDungId) {
		_nhomThuTucHanhChinh.setDanhMucUngDungId(danhMucUngDungId);
	}

	/**
	* Returns the phien ban of this nhom thu tuc hanh chinh.
	*
	* @return the phien ban of this nhom thu tuc hanh chinh
	*/
	public long getPhienBan() {
		return _nhomThuTucHanhChinh.getPhienBan();
	}

	/**
	* Sets the phien ban of this nhom thu tuc hanh chinh.
	*
	* @param phienBan the phien ban of this nhom thu tuc hanh chinh
	*/
	public void setPhienBan(long phienBan) {
		_nhomThuTucHanhChinh.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _nhomThuTucHanhChinh.isNew();
	}

	public void setNew(boolean n) {
		_nhomThuTucHanhChinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _nhomThuTucHanhChinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_nhomThuTucHanhChinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _nhomThuTucHanhChinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _nhomThuTucHanhChinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nhomThuTucHanhChinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nhomThuTucHanhChinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nhomThuTucHanhChinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NhomThuTucHanhChinhWrapper((NhomThuTucHanhChinh)_nhomThuTucHanhChinh.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh nhomThuTucHanhChinh) {
		return _nhomThuTucHanhChinh.compareTo(nhomThuTucHanhChinh);
	}

	@Override
	public int hashCode() {
		return _nhomThuTucHanhChinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> toCacheModel() {
		return _nhomThuTucHanhChinh.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh toEscapedModel() {
		return new NhomThuTucHanhChinhWrapper(_nhomThuTucHanhChinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nhomThuTucHanhChinh.toString();
	}

	public java.lang.String toXmlString() {
		return _nhomThuTucHanhChinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nhomThuTucHanhChinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NhomThuTucHanhChinh getWrappedNhomThuTucHanhChinh() {
		return _nhomThuTucHanhChinh;
	}

	public NhomThuTucHanhChinh getWrappedModel() {
		return _nhomThuTucHanhChinh;
	}

	public void resetOriginalValues() {
		_nhomThuTucHanhChinh.resetOriginalValues();
	}

	private NhomThuTucHanhChinh _nhomThuTucHanhChinh;
}