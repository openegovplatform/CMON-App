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
 * This class is a wrapper for {@link HoSoTrucTuyen}.
 * </p>
 *
 * @author    NAM
 * @see       HoSoTrucTuyen
 * @generated
 */
public class HoSoTrucTuyenWrapper implements HoSoTrucTuyen,
	ModelWrapper<HoSoTrucTuyen> {
	public HoSoTrucTuyenWrapper(HoSoTrucTuyen hoSoTrucTuyen) {
		_hoSoTrucTuyen = hoSoTrucTuyen;
	}

	public Class<?> getModelClass() {
		return HoSoTrucTuyen.class;
	}

	public String getModelClassName() {
		return HoSoTrucTuyen.class.getName();
	}

	/**
	* Returns the primary key of this ho so truc tuyen.
	*
	* @return the primary key of this ho so truc tuyen
	*/
	public long getPrimaryKey() {
		return _hoSoTrucTuyen.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho so truc tuyen.
	*
	* @param primaryKey the primary key of this ho so truc tuyen
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoSoTrucTuyen.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ho so truc tuyen.
	*
	* @return the ID of this ho so truc tuyen
	*/
	public long getId() {
		return _hoSoTrucTuyen.getId();
	}

	/**
	* Sets the ID of this ho so truc tuyen.
	*
	* @param id the ID of this ho so truc tuyen
	*/
	public void setId(long id) {
		_hoSoTrucTuyen.setId(id);
	}

	/**
	* Returns the ngay trich xuat of this ho so truc tuyen.
	*
	* @return the ngay trich xuat of this ho so truc tuyen
	*/
	public java.util.Date getNgayTrichXuat() {
		return _hoSoTrucTuyen.getNgayTrichXuat();
	}

	/**
	* Sets the ngay trich xuat of this ho so truc tuyen.
	*
	* @param NgayTrichXuat the ngay trich xuat of this ho so truc tuyen
	*/
	public void setNgayTrichXuat(java.util.Date NgayTrichXuat) {
		_hoSoTrucTuyen.setNgayTrichXuat(NgayTrichXuat);
	}

	/**
	* Returns the online ID of this ho so truc tuyen.
	*
	* @return the online ID of this ho so truc tuyen
	*/
	public long getOnlineId() {
		return _hoSoTrucTuyen.getOnlineId();
	}

	/**
	* Sets the online ID of this ho so truc tuyen.
	*
	* @param OnlineId the online ID of this ho so truc tuyen
	*/
	public void setOnlineId(long OnlineId) {
		_hoSoTrucTuyen.setOnlineId(OnlineId);
	}

	/**
	* Returns the ma loai ho so of this ho so truc tuyen.
	*
	* @return the ma loai ho so of this ho so truc tuyen
	*/
	public java.lang.String getMaLoaiHoSo() {
		return _hoSoTrucTuyen.getMaLoaiHoSo();
	}

	/**
	* Sets the ma loai ho so of this ho so truc tuyen.
	*
	* @param MaLoaiHoSo the ma loai ho so of this ho so truc tuyen
	*/
	public void setMaLoaiHoSo(java.lang.String MaLoaiHoSo) {
		_hoSoTrucTuyen.setMaLoaiHoSo(MaLoaiHoSo);
	}

	/**
	* Returns the ma don vi tiep nhan of this ho so truc tuyen.
	*
	* @return the ma don vi tiep nhan of this ho so truc tuyen
	*/
	public java.lang.String getMaDonViTiepNhan() {
		return _hoSoTrucTuyen.getMaDonViTiepNhan();
	}

	/**
	* Sets the ma don vi tiep nhan of this ho so truc tuyen.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan of this ho so truc tuyen
	*/
	public void setMaDonViTiepNhan(java.lang.String MaDonViTiepNhan) {
		_hoSoTrucTuyen.setMaDonViTiepNhan(MaDonViTiepNhan);
	}

	/**
	* Returns the ho ten nguoi nop of this ho so truc tuyen.
	*
	* @return the ho ten nguoi nop of this ho so truc tuyen
	*/
	public java.lang.String getHoTenNguoiNop() {
		return _hoSoTrucTuyen.getHoTenNguoiNop();
	}

	/**
	* Sets the ho ten nguoi nop of this ho so truc tuyen.
	*
	* @param HoTenNguoiNop the ho ten nguoi nop of this ho so truc tuyen
	*/
	public void setHoTenNguoiNop(java.lang.String HoTenNguoiNop) {
		_hoSoTrucTuyen.setHoTenNguoiNop(HoTenNguoiNop);
	}

	/**
	* Returns the dia chi nguoi nop of this ho so truc tuyen.
	*
	* @return the dia chi nguoi nop of this ho so truc tuyen
	*/
	public java.lang.String getDiaChiNguoiNop() {
		return _hoSoTrucTuyen.getDiaChiNguoiNop();
	}

	/**
	* Sets the dia chi nguoi nop of this ho so truc tuyen.
	*
	* @param DiaChiNguoiNop the dia chi nguoi nop of this ho so truc tuyen
	*/
	public void setDiaChiNguoiNop(java.lang.String DiaChiNguoiNop) {
		_hoSoTrucTuyen.setDiaChiNguoiNop(DiaChiNguoiNop);
	}

	/**
	* Returns the ngay sinh of this ho so truc tuyen.
	*
	* @return the ngay sinh of this ho so truc tuyen
	*/
	public java.util.Date getNgaySinh() {
		return _hoSoTrucTuyen.getNgaySinh();
	}

	/**
	* Sets the ngay sinh of this ho so truc tuyen.
	*
	* @param NgaySinh the ngay sinh of this ho so truc tuyen
	*/
	public void setNgaySinh(java.util.Date NgaySinh) {
		_hoSoTrucTuyen.setNgaySinh(NgaySinh);
	}

	/**
	* Returns the so cmnd of this ho so truc tuyen.
	*
	* @return the so cmnd of this ho so truc tuyen
	*/
	public java.lang.String getSoCmnd() {
		return _hoSoTrucTuyen.getSoCmnd();
	}

	/**
	* Sets the so cmnd of this ho so truc tuyen.
	*
	* @param SoCmnd the so cmnd of this ho so truc tuyen
	*/
	public void setSoCmnd(java.lang.String SoCmnd) {
		_hoSoTrucTuyen.setSoCmnd(SoCmnd);
	}

	/**
	* Returns the email of this ho so truc tuyen.
	*
	* @return the email of this ho so truc tuyen
	*/
	public java.lang.String getEmail() {
		return _hoSoTrucTuyen.getEmail();
	}

	/**
	* Sets the email of this ho so truc tuyen.
	*
	* @param Email the email of this ho so truc tuyen
	*/
	public void setEmail(java.lang.String Email) {
		_hoSoTrucTuyen.setEmail(Email);
	}

	/**
	* Returns the so dt di dong of this ho so truc tuyen.
	*
	* @return the so dt di dong of this ho so truc tuyen
	*/
	public java.lang.String getSoDtDiDong() {
		return _hoSoTrucTuyen.getSoDtDiDong();
	}

	/**
	* Sets the so dt di dong of this ho so truc tuyen.
	*
	* @param SoDtDiDong the so dt di dong of this ho so truc tuyen
	*/
	public void setSoDtDiDong(java.lang.String SoDtDiDong) {
		_hoSoTrucTuyen.setSoDtDiDong(SoDtDiDong);
	}

	/**
	* Returns the so dt co dinh of this ho so truc tuyen.
	*
	* @return the so dt co dinh of this ho so truc tuyen
	*/
	public java.lang.String getSoDtCoDinh() {
		return _hoSoTrucTuyen.getSoDtCoDinh();
	}

	/**
	* Sets the so dt co dinh of this ho so truc tuyen.
	*
	* @param SoDtCoDinh the so dt co dinh of this ho so truc tuyen
	*/
	public void setSoDtCoDinh(java.lang.String SoDtCoDinh) {
		_hoSoTrucTuyen.setSoDtCoDinh(SoDtCoDinh);
	}

	/**
	* Returns the ngay dang ky ho so of this ho so truc tuyen.
	*
	* @return the ngay dang ky ho so of this ho so truc tuyen
	*/
	public java.util.Date getNgayDangKyHoSo() {
		return _hoSoTrucTuyen.getNgayDangKyHoSo();
	}

	/**
	* Sets the ngay dang ky ho so of this ho so truc tuyen.
	*
	* @param NgayDangKyHoSo the ngay dang ky ho so of this ho so truc tuyen
	*/
	public void setNgayDangKyHoSo(java.util.Date NgayDangKyHoSo) {
		_hoSoTrucTuyen.setNgayDangKyHoSo(NgayDangKyHoSo);
	}

	/**
	* Returns the noi chuyen ho so of this ho so truc tuyen.
	*
	* @return the noi chuyen ho so of this ho so truc tuyen
	*/
	public java.lang.String getNoiChuyenHoSo() {
		return _hoSoTrucTuyen.getNoiChuyenHoSo();
	}

	/**
	* Sets the noi chuyen ho so of this ho so truc tuyen.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so of this ho so truc tuyen
	*/
	public void setNoiChuyenHoSo(java.lang.String NoiChuyenHoSo) {
		_hoSoTrucTuyen.setNoiChuyenHoSo(NoiChuyenHoSo);
	}

	/**
	* Returns the trang thai xu ly of this ho so truc tuyen.
	*
	* @return the trang thai xu ly of this ho so truc tuyen
	*/
	public int getTrangThaiXuLy() {
		return _hoSoTrucTuyen.getTrangThaiXuLy();
	}

	/**
	* Sets the trang thai xu ly of this ho so truc tuyen.
	*
	* @param TrangThaiXuLy the trang thai xu ly of this ho so truc tuyen
	*/
	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_hoSoTrucTuyen.setTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the ngay chuyen of this ho so truc tuyen.
	*
	* @return the ngay chuyen of this ho so truc tuyen
	*/
	public java.util.Date getNgayChuyen() {
		return _hoSoTrucTuyen.getNgayChuyen();
	}

	/**
	* Sets the ngay chuyen of this ho so truc tuyen.
	*
	* @param NgayChuyen the ngay chuyen of this ho so truc tuyen
	*/
	public void setNgayChuyen(java.util.Date NgayChuyen) {
		_hoSoTrucTuyen.setNgayChuyen(NgayChuyen);
	}

	/**
	* Returns the gioi tinh of this ho so truc tuyen.
	*
	* @return the gioi tinh of this ho so truc tuyen
	*/
	public int getGioiTinh() {
		return _hoSoTrucTuyen.getGioiTinh();
	}

	/**
	* Sets the gioi tinh of this ho so truc tuyen.
	*
	* @param GioiTinh the gioi tinh of this ho so truc tuyen
	*/
	public void setGioiTinh(int GioiTinh) {
		_hoSoTrucTuyen.setGioiTinh(GioiTinh);
	}

	/**
	* Returns the chu so huu ho so of this ho so truc tuyen.
	*
	* @return the chu so huu ho so of this ho so truc tuyen
	*/
	public java.lang.String getChuSoHuuHoSo() {
		return _hoSoTrucTuyen.getChuSoHuuHoSo();
	}

	/**
	* Sets the chu so huu ho so of this ho so truc tuyen.
	*
	* @param ChuSoHuuHoSo the chu so huu ho so of this ho so truc tuyen
	*/
	public void setChuSoHuuHoSo(java.lang.String ChuSoHuuHoSo) {
		_hoSoTrucTuyen.setChuSoHuuHoSo(ChuSoHuuHoSo);
	}

	public boolean isNew() {
		return _hoSoTrucTuyen.isNew();
	}

	public void setNew(boolean n) {
		_hoSoTrucTuyen.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoSoTrucTuyen.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoSoTrucTuyen.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoSoTrucTuyen.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoSoTrucTuyen.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoSoTrucTuyen.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoSoTrucTuyen.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoSoTrucTuyen.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoSoTrucTuyenWrapper((HoSoTrucTuyen)_hoSoTrucTuyen.clone());
	}

	public int compareTo(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen) {
		return _hoSoTrucTuyen.compareTo(hoSoTrucTuyen);
	}

	@Override
	public int hashCode() {
		return _hoSoTrucTuyen.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> toCacheModel() {
		return _hoSoTrucTuyen.toCacheModel();
	}

	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen toEscapedModel() {
		return new HoSoTrucTuyenWrapper(_hoSoTrucTuyen.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoSoTrucTuyen.toString();
	}

	public java.lang.String toXmlString() {
		return _hoSoTrucTuyen.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoTrucTuyen.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoSoTrucTuyen getWrappedHoSoTrucTuyen() {
		return _hoSoTrucTuyen;
	}

	public HoSoTrucTuyen getWrappedModel() {
		return _hoSoTrucTuyen;
	}

	public void resetOriginalValues() {
		_hoSoTrucTuyen.resetOriginalValues();
	}

	private HoSoTrucTuyen _hoSoTrucTuyen;
}