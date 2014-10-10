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
 * This class is a wrapper for {@link HoSoMotCua}.
 * </p>
 *
 * @author    NAM
 * @see       HoSoMotCua
 * @generated
 */
public class HoSoMotCuaWrapper implements HoSoMotCua, ModelWrapper<HoSoMotCua> {
	public HoSoMotCuaWrapper(HoSoMotCua hoSoMotCua) {
		_hoSoMotCua = hoSoMotCua;
	}

	public Class<?> getModelClass() {
		return HoSoMotCua.class;
	}

	public String getModelClassName() {
		return HoSoMotCua.class.getName();
	}

	/**
	* Returns the primary key of this ho so mot cua.
	*
	* @return the primary key of this ho so mot cua
	*/
	public long getPrimaryKey() {
		return _hoSoMotCua.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho so mot cua.
	*
	* @param primaryKey the primary key of this ho so mot cua
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoSoMotCua.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ho so mot cua.
	*
	* @return the ID of this ho so mot cua
	*/
	public long getId() {
		return _hoSoMotCua.getId();
	}

	/**
	* Sets the ID of this ho so mot cua.
	*
	* @param id the ID of this ho so mot cua
	*/
	public void setId(long id) {
		_hoSoMotCua.setId(id);
	}

	/**
	* Returns the ngay chuyen of this ho so mot cua.
	*
	* @return the ngay chuyen of this ho so mot cua
	*/
	public java.util.Date getNgayChuyen() {
		return _hoSoMotCua.getNgayChuyen();
	}

	/**
	* Sets the ngay chuyen of this ho so mot cua.
	*
	* @param NgayChuyen the ngay chuyen of this ho so mot cua
	*/
	public void setNgayChuyen(java.util.Date NgayChuyen) {
		_hoSoMotCua.setNgayChuyen(NgayChuyen);
	}

	/**
	* Returns the ma so ho so of this ho so mot cua.
	*
	* @return the ma so ho so of this ho so mot cua
	*/
	public java.lang.String getMaSoHoSo() {
		return _hoSoMotCua.getMaSoHoSo();
	}

	/**
	* Sets the ma so ho so of this ho so mot cua.
	*
	* @param MaSoHoSo the ma so ho so of this ho so mot cua
	*/
	public void setMaSoHoSo(java.lang.String MaSoHoSo) {
		_hoSoMotCua.setMaSoHoSo(MaSoHoSo);
	}

	/**
	* Returns the ma loai ho so of this ho so mot cua.
	*
	* @return the ma loai ho so of this ho so mot cua
	*/
	public java.lang.String getMaLoaiHoSo() {
		return _hoSoMotCua.getMaLoaiHoSo();
	}

	/**
	* Sets the ma loai ho so of this ho so mot cua.
	*
	* @param MaLoaiHoSo the ma loai ho so of this ho so mot cua
	*/
	public void setMaLoaiHoSo(java.lang.String MaLoaiHoSo) {
		_hoSoMotCua.setMaLoaiHoSo(MaLoaiHoSo);
	}

	/**
	* Returns the ma don vi tiep nhan of this ho so mot cua.
	*
	* @return the ma don vi tiep nhan of this ho so mot cua
	*/
	public java.lang.String getMaDonViTiepNhan() {
		return _hoSoMotCua.getMaDonViTiepNhan();
	}

	/**
	* Sets the ma don vi tiep nhan of this ho so mot cua.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan of this ho so mot cua
	*/
	public void setMaDonViTiepNhan(java.lang.String MaDonViTiepNhan) {
		_hoSoMotCua.setMaDonViTiepNhan(MaDonViTiepNhan);
	}

	/**
	* Returns the ngay nop ho so of this ho so mot cua.
	*
	* @return the ngay nop ho so of this ho so mot cua
	*/
	public java.lang.String getNgayNopHoSo() {
		return _hoSoMotCua.getNgayNopHoSo();
	}

	/**
	* Sets the ngay nop ho so of this ho so mot cua.
	*
	* @param NgayNopHoSo the ngay nop ho so of this ho so mot cua
	*/
	public void setNgayNopHoSo(java.lang.String NgayNopHoSo) {
		_hoSoMotCua.setNgayNopHoSo(NgayNopHoSo);
	}

	/**
	* Returns the ngay hen tra of this ho so mot cua.
	*
	* @return the ngay hen tra of this ho so mot cua
	*/
	public java.lang.String getNgayHenTra() {
		return _hoSoMotCua.getNgayHenTra();
	}

	/**
	* Sets the ngay hen tra of this ho so mot cua.
	*
	* @param NgayHenTra the ngay hen tra of this ho so mot cua
	*/
	public void setNgayHenTra(java.lang.String NgayHenTra) {
		_hoSoMotCua.setNgayHenTra(NgayHenTra);
	}

	/**
	* Returns the ho ten nguoi nop of this ho so mot cua.
	*
	* @return the ho ten nguoi nop of this ho so mot cua
	*/
	public java.lang.String getHoTenNguoiNop() {
		return _hoSoMotCua.getHoTenNguoiNop();
	}

	/**
	* Sets the ho ten nguoi nop of this ho so mot cua.
	*
	* @param HoTenNguoiNop the ho ten nguoi nop of this ho so mot cua
	*/
	public void setHoTenNguoiNop(java.lang.String HoTenNguoiNop) {
		_hoSoMotCua.setHoTenNguoiNop(HoTenNguoiNop);
	}

	/**
	* Returns the so cmnd of this ho so mot cua.
	*
	* @return the so cmnd of this ho so mot cua
	*/
	public java.lang.String getSoCmnd() {
		return _hoSoMotCua.getSoCmnd();
	}

	/**
	* Sets the so cmnd of this ho so mot cua.
	*
	* @param SoCmnd the so cmnd of this ho so mot cua
	*/
	public void setSoCmnd(java.lang.String SoCmnd) {
		_hoSoMotCua.setSoCmnd(SoCmnd);
	}

	/**
	* Returns the ngay sinh of this ho so mot cua.
	*
	* @return the ngay sinh of this ho so mot cua
	*/
	public java.lang.String getNgaySinh() {
		return _hoSoMotCua.getNgaySinh();
	}

	/**
	* Sets the ngay sinh of this ho so mot cua.
	*
	* @param NgaySinh the ngay sinh of this ho so mot cua
	*/
	public void setNgaySinh(java.lang.String NgaySinh) {
		_hoSoMotCua.setNgaySinh(NgaySinh);
	}

	/**
	* Returns the ma tinh thuong tru of this ho so mot cua.
	*
	* @return the ma tinh thuong tru of this ho so mot cua
	*/
	public java.lang.String getMaTinhThuongTru() {
		return _hoSoMotCua.getMaTinhThuongTru();
	}

	/**
	* Sets the ma tinh thuong tru of this ho so mot cua.
	*
	* @param MaTinhThuongTru the ma tinh thuong tru of this ho so mot cua
	*/
	public void setMaTinhThuongTru(java.lang.String MaTinhThuongTru) {
		_hoSoMotCua.setMaTinhThuongTru(MaTinhThuongTru);
	}

	/**
	* Returns the mo ta dia chi thuong tru of this ho so mot cua.
	*
	* @return the mo ta dia chi thuong tru of this ho so mot cua
	*/
	public java.lang.String getMoTaDiaChiThuongTru() {
		return _hoSoMotCua.getMoTaDiaChiThuongTru();
	}

	/**
	* Sets the mo ta dia chi thuong tru of this ho so mot cua.
	*
	* @param MoTaDiaChiThuongTru the mo ta dia chi thuong tru of this ho so mot cua
	*/
	public void setMoTaDiaChiThuongTru(java.lang.String MoTaDiaChiThuongTru) {
		_hoSoMotCua.setMoTaDiaChiThuongTru(MoTaDiaChiThuongTru);
	}

	/**
	* Returns the gioi tinh of this ho so mot cua.
	*
	* @return the gioi tinh of this ho so mot cua
	*/
	public int getGioiTinh() {
		return _hoSoMotCua.getGioiTinh();
	}

	/**
	* Sets the gioi tinh of this ho so mot cua.
	*
	* @param GioiTinh the gioi tinh of this ho so mot cua
	*/
	public void setGioiTinh(int GioiTinh) {
		_hoSoMotCua.setGioiTinh(GioiTinh);
	}

	/**
	* Returns the ma nguoi tiep nhan of this ho so mot cua.
	*
	* @return the ma nguoi tiep nhan of this ho so mot cua
	*/
	public java.lang.String getMaNguoiTiepNhan() {
		return _hoSoMotCua.getMaNguoiTiepNhan();
	}

	/**
	* Sets the ma nguoi tiep nhan of this ho so mot cua.
	*
	* @param MaNguoiTiepNhan the ma nguoi tiep nhan of this ho so mot cua
	*/
	public void setMaNguoiTiepNhan(java.lang.String MaNguoiTiepNhan) {
		_hoSoMotCua.setMaNguoiTiepNhan(MaNguoiTiepNhan);
	}

	/**
	* Returns the ten nguoi tiep nhan of this ho so mot cua.
	*
	* @return the ten nguoi tiep nhan of this ho so mot cua
	*/
	public java.lang.String getTenNguoiTiepNhan() {
		return _hoSoMotCua.getTenNguoiTiepNhan();
	}

	/**
	* Sets the ten nguoi tiep nhan of this ho so mot cua.
	*
	* @param TenNguoiTiepNhan the ten nguoi tiep nhan of this ho so mot cua
	*/
	public void setTenNguoiTiepNhan(java.lang.String TenNguoiTiepNhan) {
		_hoSoMotCua.setTenNguoiTiepNhan(TenNguoiTiepNhan);
	}

	/**
	* Returns the don vi cung cap of this ho so mot cua.
	*
	* @return the don vi cung cap of this ho so mot cua
	*/
	public java.lang.String getDonViCungCap() {
		return _hoSoMotCua.getDonViCungCap();
	}

	/**
	* Sets the don vi cung cap of this ho so mot cua.
	*
	* @param DonViCungCap the don vi cung cap of this ho so mot cua
	*/
	public void setDonViCungCap(java.lang.String DonViCungCap) {
		_hoSoMotCua.setDonViCungCap(DonViCungCap);
	}

	/**
	* Returns the trang thai xu ly of this ho so mot cua.
	*
	* @return the trang thai xu ly of this ho so mot cua
	*/
	public int getTrangThaiXuLy() {
		return _hoSoMotCua.getTrangThaiXuLy();
	}

	/**
	* Sets the trang thai xu ly of this ho so mot cua.
	*
	* @param TrangThaiXuLy the trang thai xu ly of this ho so mot cua
	*/
	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_hoSoMotCua.setTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the ngay xu ly of this ho so mot cua.
	*
	* @return the ngay xu ly of this ho so mot cua
	*/
	public java.util.Date getNgayXuLy() {
		return _hoSoMotCua.getNgayXuLy();
	}

	/**
	* Sets the ngay xu ly of this ho so mot cua.
	*
	* @param NgayXuLy the ngay xu ly of this ho so mot cua
	*/
	public void setNgayXuLy(java.util.Date NgayXuLy) {
		_hoSoMotCua.setNgayXuLy(NgayXuLy);
	}

	/**
	* Returns the loi khi xu ly of this ho so mot cua.
	*
	* @return the loi khi xu ly of this ho so mot cua
	*/
	public java.lang.String getLoiKhiXuLy() {
		return _hoSoMotCua.getLoiKhiXuLy();
	}

	/**
	* Sets the loi khi xu ly of this ho so mot cua.
	*
	* @param LoiKhiXuLy the loi khi xu ly of this ho so mot cua
	*/
	public void setLoiKhiXuLy(java.lang.String LoiKhiXuLy) {
		_hoSoMotCua.setLoiKhiXuLy(LoiKhiXuLy);
	}

	public boolean isNew() {
		return _hoSoMotCua.isNew();
	}

	public void setNew(boolean n) {
		_hoSoMotCua.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoSoMotCua.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoSoMotCua.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoSoMotCua.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoSoMotCua.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoSoMotCua.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoSoMotCua.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoSoMotCua.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoSoMotCuaWrapper((HoSoMotCua)_hoSoMotCua.clone());
	}

	public int compareTo(org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua) {
		return _hoSoMotCua.compareTo(hoSoMotCua);
	}

	@Override
	public int hashCode() {
		return _hoSoMotCua.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.exch.dao.hoso.model.HoSoMotCua> toCacheModel() {
		return _hoSoMotCua.toCacheModel();
	}

	public org.oep.exch.dao.hoso.model.HoSoMotCua toEscapedModel() {
		return new HoSoMotCuaWrapper(_hoSoMotCua.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoSoMotCua.toString();
	}

	public java.lang.String toXmlString() {
		return _hoSoMotCua.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoMotCua.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoSoMotCua getWrappedHoSoMotCua() {
		return _hoSoMotCua;
	}

	public HoSoMotCua getWrappedModel() {
		return _hoSoMotCua;
	}

	public void resetOriginalValues() {
		_hoSoMotCua.resetOriginalValues();
	}

	private HoSoMotCua _hoSoMotCua;
}