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

package org.oep.cmon.dao.tlct.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhMucGiayTo}.
 * </p>
 *
 * @author    Liemnn
 * @see       DanhMucGiayTo
 * @generated
 */
public class DanhMucGiayToWrapper implements DanhMucGiayTo,
	ModelWrapper<DanhMucGiayTo> {
	public DanhMucGiayToWrapper(DanhMucGiayTo danhMucGiayTo) {
		_danhMucGiayTo = danhMucGiayTo;
	}

	public Class<?> getModelClass() {
		return DanhMucGiayTo.class;
	}

	public String getModelClassName() {
		return DanhMucGiayTo.class.getName();
	}

	/**
	* Returns the primary key of this danh muc giay to.
	*
	* @return the primary key of this danh muc giay to
	*/
	public long getPrimaryKey() {
		return _danhMucGiayTo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh muc giay to.
	*
	* @param primaryKey the primary key of this danh muc giay to
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhMucGiayTo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this danh muc giay to.
	*
	* @return the ID of this danh muc giay to
	*/
	public long getId() {
		return _danhMucGiayTo.getId();
	}

	/**
	* Sets the ID of this danh muc giay to.
	*
	* @param id the ID of this danh muc giay to
	*/
	public void setId(long id) {
		_danhMucGiayTo.setId(id);
	}

	/**
	* Returns the ma of this danh muc giay to.
	*
	* @return the ma of this danh muc giay to
	*/
	public java.lang.String getMa() {
		return _danhMucGiayTo.getMa();
	}

	/**
	* Sets the ma of this danh muc giay to.
	*
	* @param ma the ma of this danh muc giay to
	*/
	public void setMa(java.lang.String ma) {
		_danhMucGiayTo.setMa(ma);
	}

	/**
	* Returns the ten of this danh muc giay to.
	*
	* @return the ten of this danh muc giay to
	*/
	public java.lang.String getTen() {
		return _danhMucGiayTo.getTen();
	}

	/**
	* Sets the ten of this danh muc giay to.
	*
	* @param ten the ten of this danh muc giay to
	*/
	public void setTen(java.lang.String ten) {
		_danhMucGiayTo.setTen(ten);
	}

	/**
	* Returns the mota of this danh muc giay to.
	*
	* @return the mota of this danh muc giay to
	*/
	public java.lang.String getMota() {
		return _danhMucGiayTo.getMota();
	}

	/**
	* Sets the mota of this danh muc giay to.
	*
	* @param mota the mota of this danh muc giay to
	*/
	public void setMota(java.lang.String mota) {
		_danhMucGiayTo.setMota(mota);
	}

	/**
	* Returns the gioi han dung luong of this danh muc giay to.
	*
	* @return the gioi han dung luong of this danh muc giay to
	*/
	public long getGioiHanDungLuong() {
		return _danhMucGiayTo.getGioiHanDungLuong();
	}

	/**
	* Sets the gioi han dung luong of this danh muc giay to.
	*
	* @param gioiHanDungLuong the gioi han dung luong of this danh muc giay to
	*/
	public void setGioiHanDungLuong(long gioiHanDungLuong) {
		_danhMucGiayTo.setGioiHanDungLuong(gioiHanDungLuong);
	}

	/**
	* Returns the kieu tai lieu of this danh muc giay to.
	*
	* @return the kieu tai lieu of this danh muc giay to
	*/
	public java.lang.String getKieuTaiLieu() {
		return _danhMucGiayTo.getKieuTaiLieu();
	}

	/**
	* Sets the kieu tai lieu of this danh muc giay to.
	*
	* @param kieuTaiLieu the kieu tai lieu of this danh muc giay to
	*/
	public void setKieuTaiLieu(java.lang.String kieuTaiLieu) {
		_danhMucGiayTo.setKieuTaiLieu(kieuTaiLieu);
	}

	/**
	* Returns the nguoi tao of this danh muc giay to.
	*
	* @return the nguoi tao of this danh muc giay to
	*/
	public java.lang.String getNguoiTao() {
		return _danhMucGiayTo.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this danh muc giay to.
	*
	* @param nguoiTao the nguoi tao of this danh muc giay to
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_danhMucGiayTo.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this danh muc giay to.
	*
	* @return the ngay tao of this danh muc giay to
	*/
	public java.util.Date getNgayTao() {
		return _danhMucGiayTo.getNgayTao();
	}

	/**
	* Sets the ngay tao of this danh muc giay to.
	*
	* @param ngayTao the ngay tao of this danh muc giay to
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_danhMucGiayTo.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this danh muc giay to.
	*
	* @return the nguoi sua of this danh muc giay to
	*/
	public java.lang.String getNguoiSua() {
		return _danhMucGiayTo.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this danh muc giay to.
	*
	* @param nguoiSua the nguoi sua of this danh muc giay to
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_danhMucGiayTo.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this danh muc giay to.
	*
	* @return the ngay sua of this danh muc giay to
	*/
	public java.util.Date getNgaySua() {
		return _danhMucGiayTo.getNgaySua();
	}

	/**
	* Sets the ngay sua of this danh muc giay to.
	*
	* @param ngaySua the ngay sua of this danh muc giay to
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_danhMucGiayTo.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this danh muc giay to.
	*
	* @return the da xoa of this danh muc giay to
	*/
	public int getDaXoa() {
		return _danhMucGiayTo.getDaXoa();
	}

	/**
	* Sets the da xoa of this danh muc giay to.
	*
	* @param daXoa the da xoa of this danh muc giay to
	*/
	public void setDaXoa(int daXoa) {
		_danhMucGiayTo.setDaXoa(daXoa);
	}

	/**
	* Returns the phien ban of this danh muc giay to.
	*
	* @return the phien ban of this danh muc giay to
	*/
	public long getPhienBan() {
		return _danhMucGiayTo.getPhienBan();
	}

	/**
	* Sets the phien ban of this danh muc giay to.
	*
	* @param phienBan the phien ban of this danh muc giay to
	*/
	public void setPhienBan(long phienBan) {
		_danhMucGiayTo.setPhienBan(phienBan);
	}

	/**
	* Returns the tailieu thay the ID of this danh muc giay to.
	*
	* @return the tailieu thay the ID of this danh muc giay to
	*/
	public java.lang.Long getTailieuThayTheId() {
		return _danhMucGiayTo.getTailieuThayTheId();
	}

	/**
	* Sets the tailieu thay the ID of this danh muc giay to.
	*
	* @param tailieuThayTheId the tailieu thay the ID of this danh muc giay to
	*/
	public void setTailieuThayTheId(java.lang.Long tailieuThayTheId) {
		_danhMucGiayTo.setTailieuThayTheId(tailieuThayTheId);
	}

	public boolean isNew() {
		return _danhMucGiayTo.isNew();
	}

	public void setNew(boolean n) {
		_danhMucGiayTo.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhMucGiayTo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhMucGiayTo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhMucGiayTo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhMucGiayTo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhMucGiayTo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhMucGiayTo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhMucGiayTo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhMucGiayToWrapper((DanhMucGiayTo)_danhMucGiayTo.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo) {
		return _danhMucGiayTo.compareTo(danhMucGiayTo);
	}

	@Override
	public int hashCode() {
		return _danhMucGiayTo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> toCacheModel() {
		return _danhMucGiayTo.toCacheModel();
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo toEscapedModel() {
		return new DanhMucGiayToWrapper(_danhMucGiayTo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhMucGiayTo.toString();
	}

	public java.lang.String toXmlString() {
		return _danhMucGiayTo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucGiayTo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhMucGiayTo getWrappedDanhMucGiayTo() {
		return _danhMucGiayTo;
	}

	public DanhMucGiayTo getWrappedModel() {
		return _danhMucGiayTo;
	}

	public void resetOriginalValues() {
		_danhMucGiayTo.resetOriginalValues();
	}

	private DanhMucGiayTo _danhMucGiayTo;
}