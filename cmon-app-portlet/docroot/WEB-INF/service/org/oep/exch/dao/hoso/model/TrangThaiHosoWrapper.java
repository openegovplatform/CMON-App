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
 * This class is a wrapper for {@link TrangThaiHoso}.
 * </p>
 *
 * @author    NAM
 * @see       TrangThaiHoso
 * @generated
 */
public class TrangThaiHosoWrapper implements TrangThaiHoso,
	ModelWrapper<TrangThaiHoso> {
	public TrangThaiHosoWrapper(TrangThaiHoso trangThaiHoso) {
		_trangThaiHoso = trangThaiHoso;
	}

	public Class<?> getModelClass() {
		return TrangThaiHoso.class;
	}

	public String getModelClassName() {
		return TrangThaiHoso.class.getName();
	}

	/**
	* Returns the primary key of this trang thai hoso.
	*
	* @return the primary key of this trang thai hoso
	*/
	public long getPrimaryKey() {
		return _trangThaiHoso.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trang thai hoso.
	*
	* @param primaryKey the primary key of this trang thai hoso
	*/
	public void setPrimaryKey(long primaryKey) {
		_trangThaiHoso.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this trang thai hoso.
	*
	* @return the ID of this trang thai hoso
	*/
	public long getId() {
		return _trangThaiHoso.getId();
	}

	/**
	* Sets the ID of this trang thai hoso.
	*
	* @param id the ID of this trang thai hoso
	*/
	public void setId(long id) {
		_trangThaiHoso.setId(id);
	}

	/**
	* Returns the ngay chuyen of this trang thai hoso.
	*
	* @return the ngay chuyen of this trang thai hoso
	*/
	public java.util.Date getNgayChuyen() {
		return _trangThaiHoso.getNgayChuyen();
	}

	/**
	* Sets the ngay chuyen of this trang thai hoso.
	*
	* @param NgayChuyen the ngay chuyen of this trang thai hoso
	*/
	public void setNgayChuyen(java.util.Date NgayChuyen) {
		_trangThaiHoso.setNgayChuyen(NgayChuyen);
	}

	/**
	* Returns the online ID of this trang thai hoso.
	*
	* @return the online ID of this trang thai hoso
	*/
	public long getOnlineId() {
		return _trangThaiHoso.getOnlineId();
	}

	/**
	* Sets the online ID of this trang thai hoso.
	*
	* @param OnlineId the online ID of this trang thai hoso
	*/
	public void setOnlineId(long OnlineId) {
		_trangThaiHoso.setOnlineId(OnlineId);
	}

	/**
	* Returns the ma so ho so of this trang thai hoso.
	*
	* @return the ma so ho so of this trang thai hoso
	*/
	public java.lang.String getMaSoHoSo() {
		return _trangThaiHoso.getMaSoHoSo();
	}

	/**
	* Sets the ma so ho so of this trang thai hoso.
	*
	* @param MaSoHoSo the ma so ho so of this trang thai hoso
	*/
	public void setMaSoHoSo(java.lang.String MaSoHoSo) {
		_trangThaiHoso.setMaSoHoSo(MaSoHoSo);
	}

	/**
	* Returns the ngay hen tra of this trang thai hoso.
	*
	* @return the ngay hen tra of this trang thai hoso
	*/
	public java.lang.String getNgayHenTra() {
		return _trangThaiHoso.getNgayHenTra();
	}

	/**
	* Sets the ngay hen tra of this trang thai hoso.
	*
	* @param NgayHenTra the ngay hen tra of this trang thai hoso
	*/
	public void setNgayHenTra(java.lang.String NgayHenTra) {
		_trangThaiHoso.setNgayHenTra(NgayHenTra);
	}

	/**
	* Returns the ma nguoi xu ly hien tai of this trang thai hoso.
	*
	* @return the ma nguoi xu ly hien tai of this trang thai hoso
	*/
	public java.lang.String getMaNguoiXuLyHienTai() {
		return _trangThaiHoso.getMaNguoiXuLyHienTai();
	}

	/**
	* Sets the ma nguoi xu ly hien tai of this trang thai hoso.
	*
	* @param MaNguoiXuLyHienTai the ma nguoi xu ly hien tai of this trang thai hoso
	*/
	public void setMaNguoiXuLyHienTai(java.lang.String MaNguoiXuLyHienTai) {
		_trangThaiHoso.setMaNguoiXuLyHienTai(MaNguoiXuLyHienTai);
	}

	/**
	* Returns the ten nguoi xu ly hien tai of this trang thai hoso.
	*
	* @return the ten nguoi xu ly hien tai of this trang thai hoso
	*/
	public java.lang.String getTenNguoiXuLyHienTai() {
		return _trangThaiHoso.getTenNguoiXuLyHienTai();
	}

	/**
	* Sets the ten nguoi xu ly hien tai of this trang thai hoso.
	*
	* @param TenNguoiXuLyHienTai the ten nguoi xu ly hien tai of this trang thai hoso
	*/
	public void setTenNguoiXuLyHienTai(java.lang.String TenNguoiXuLyHienTai) {
		_trangThaiHoso.setTenNguoiXuLyHienTai(TenNguoiXuLyHienTai);
	}

	/**
	* Returns the ten phong ban xu ly hien tai of this trang thai hoso.
	*
	* @return the ten phong ban xu ly hien tai of this trang thai hoso
	*/
	public java.lang.String getTenPhongBanXuLyHienTai() {
		return _trangThaiHoso.getTenPhongBanXuLyHienTai();
	}

	/**
	* Sets the ten phong ban xu ly hien tai of this trang thai hoso.
	*
	* @param TenPhongBanXuLyHienTai the ten phong ban xu ly hien tai of this trang thai hoso
	*/
	public void setTenPhongBanXuLyHienTai(
		java.lang.String TenPhongBanXuLyHienTai) {
		_trangThaiHoso.setTenPhongBanXuLyHienTai(TenPhongBanXuLyHienTai);
	}

	/**
	* Returns the ngay gio luan chuyen of this trang thai hoso.
	*
	* @return the ngay gio luan chuyen of this trang thai hoso
	*/
	public java.lang.String getNgayGioLuanChuyen() {
		return _trangThaiHoso.getNgayGioLuanChuyen();
	}

	/**
	* Sets the ngay gio luan chuyen of this trang thai hoso.
	*
	* @param NgayGioLuanChuyen the ngay gio luan chuyen of this trang thai hoso
	*/
	public void setNgayGioLuanChuyen(java.lang.String NgayGioLuanChuyen) {
		_trangThaiHoso.setNgayGioLuanChuyen(NgayGioLuanChuyen);
	}

	/**
	* Returns the so gio yeu cau xu ly of this trang thai hoso.
	*
	* @return the so gio yeu cau xu ly of this trang thai hoso
	*/
	public int getSoGioYeuCauXuLy() {
		return _trangThaiHoso.getSoGioYeuCauXuLy();
	}

	/**
	* Sets the so gio yeu cau xu ly of this trang thai hoso.
	*
	* @param SoGioYeuCauXuLy the so gio yeu cau xu ly of this trang thai hoso
	*/
	public void setSoGioYeuCauXuLy(int SoGioYeuCauXuLy) {
		_trangThaiHoso.setSoGioYeuCauXuLy(SoGioYeuCauXuLy);
	}

	/**
	* Returns the noi dung yeu cau xu ly of this trang thai hoso.
	*
	* @return the noi dung yeu cau xu ly of this trang thai hoso
	*/
	public java.lang.String getNoiDungYeuCauXuLy() {
		return _trangThaiHoso.getNoiDungYeuCauXuLy();
	}

	/**
	* Sets the noi dung yeu cau xu ly of this trang thai hoso.
	*
	* @param NoiDungYeuCauXuLy the noi dung yeu cau xu ly of this trang thai hoso
	*/
	public void setNoiDungYeuCauXuLy(java.lang.String NoiDungYeuCauXuLy) {
		_trangThaiHoso.setNoiDungYeuCauXuLy(NoiDungYeuCauXuLy);
	}

	/**
	* Returns the so gio thuc hien of this trang thai hoso.
	*
	* @return the so gio thuc hien of this trang thai hoso
	*/
	public int getSoGioThucHien() {
		return _trangThaiHoso.getSoGioThucHien();
	}

	/**
	* Sets the so gio thuc hien of this trang thai hoso.
	*
	* @param SoGioThucHien the so gio thuc hien of this trang thai hoso
	*/
	public void setSoGioThucHien(int SoGioThucHien) {
		_trangThaiHoso.setSoGioThucHien(SoGioThucHien);
	}

	/**
	* Returns the trang thai hien tai of this trang thai hoso.
	*
	* @return the trang thai hien tai of this trang thai hoso
	*/
	public int getTrangThaiHienTai() {
		return _trangThaiHoso.getTrangThaiHienTai();
	}

	/**
	* Sets the trang thai hien tai of this trang thai hoso.
	*
	* @param TrangThaiHienTai the trang thai hien tai of this trang thai hoso
	*/
	public void setTrangThaiHienTai(int TrangThaiHienTai) {
		_trangThaiHoso.setTrangThaiHienTai(TrangThaiHienTai);
	}

	/**
	* Returns the ma nguoi xu ly ke tiep of this trang thai hoso.
	*
	* @return the ma nguoi xu ly ke tiep of this trang thai hoso
	*/
	public java.lang.String getMaNguoiXuLyKeTiep() {
		return _trangThaiHoso.getMaNguoiXuLyKeTiep();
	}

	/**
	* Sets the ma nguoi xu ly ke tiep of this trang thai hoso.
	*
	* @param MaNguoiXuLyKeTiep the ma nguoi xu ly ke tiep of this trang thai hoso
	*/
	public void setMaNguoiXuLyKeTiep(java.lang.String MaNguoiXuLyKeTiep) {
		_trangThaiHoso.setMaNguoiXuLyKeTiep(MaNguoiXuLyKeTiep);
	}

	/**
	* Returns the ten nguoi xu ly ke tiep of this trang thai hoso.
	*
	* @return the ten nguoi xu ly ke tiep of this trang thai hoso
	*/
	public java.lang.String getTenNguoiXuLyKeTiep() {
		return _trangThaiHoso.getTenNguoiXuLyKeTiep();
	}

	/**
	* Sets the ten nguoi xu ly ke tiep of this trang thai hoso.
	*
	* @param TenNguoiXuLyKeTiep the ten nguoi xu ly ke tiep of this trang thai hoso
	*/
	public void setTenNguoiXuLyKeTiep(java.lang.String TenNguoiXuLyKeTiep) {
		_trangThaiHoso.setTenNguoiXuLyKeTiep(TenNguoiXuLyKeTiep);
	}

	/**
	* Returns the ten phong ban xu ly ke tiep of this trang thai hoso.
	*
	* @return the ten phong ban xu ly ke tiep of this trang thai hoso
	*/
	public java.lang.String getTenPhongBanXuLyKeTiep() {
		return _trangThaiHoso.getTenPhongBanXuLyKeTiep();
	}

	/**
	* Sets the ten phong ban xu ly ke tiep of this trang thai hoso.
	*
	* @param TenPhongBanXuLyKeTiep the ten phong ban xu ly ke tiep of this trang thai hoso
	*/
	public void setTenPhongBanXuLyKeTiep(java.lang.String TenPhongBanXuLyKeTiep) {
		_trangThaiHoso.setTenPhongBanXuLyKeTiep(TenPhongBanXuLyKeTiep);
	}

	/**
	* Returns the trang thai ke tiep of this trang thai hoso.
	*
	* @return the trang thai ke tiep of this trang thai hoso
	*/
	public int getTrangThaiKeTiep() {
		return _trangThaiHoso.getTrangThaiKeTiep();
	}

	/**
	* Sets the trang thai ke tiep of this trang thai hoso.
	*
	* @param TrangThaiKeTiep the trang thai ke tiep of this trang thai hoso
	*/
	public void setTrangThaiKeTiep(int TrangThaiKeTiep) {
		_trangThaiHoso.setTrangThaiKeTiep(TrangThaiKeTiep);
	}

	/**
	* Returns the don vi cung cap of this trang thai hoso.
	*
	* @return the don vi cung cap of this trang thai hoso
	*/
	public java.lang.String getDonViCungCap() {
		return _trangThaiHoso.getDonViCungCap();
	}

	/**
	* Sets the don vi cung cap of this trang thai hoso.
	*
	* @param DonViCungCap the don vi cung cap of this trang thai hoso
	*/
	public void setDonViCungCap(java.lang.String DonViCungCap) {
		_trangThaiHoso.setDonViCungCap(DonViCungCap);
	}

	/**
	* Returns the trang thai xu ly of this trang thai hoso.
	*
	* @return the trang thai xu ly of this trang thai hoso
	*/
	public int getTrangThaiXuLy() {
		return _trangThaiHoso.getTrangThaiXuLy();
	}

	/**
	* Sets the trang thai xu ly of this trang thai hoso.
	*
	* @param TrangThaiXuLy the trang thai xu ly of this trang thai hoso
	*/
	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_trangThaiHoso.setTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the ngay xu ly of this trang thai hoso.
	*
	* @return the ngay xu ly of this trang thai hoso
	*/
	public java.util.Date getNgayXuLy() {
		return _trangThaiHoso.getNgayXuLy();
	}

	/**
	* Sets the ngay xu ly of this trang thai hoso.
	*
	* @param NgayXuLy the ngay xu ly of this trang thai hoso
	*/
	public void setNgayXuLy(java.util.Date NgayXuLy) {
		_trangThaiHoso.setNgayXuLy(NgayXuLy);
	}

	/**
	* Returns the loi khi xu ly of this trang thai hoso.
	*
	* @return the loi khi xu ly of this trang thai hoso
	*/
	public java.lang.String getLoiKhiXuLy() {
		return _trangThaiHoso.getLoiKhiXuLy();
	}

	/**
	* Sets the loi khi xu ly of this trang thai hoso.
	*
	* @param LoiKhiXuLy the loi khi xu ly of this trang thai hoso
	*/
	public void setLoiKhiXuLy(java.lang.String LoiKhiXuLy) {
		_trangThaiHoso.setLoiKhiXuLy(LoiKhiXuLy);
	}

	public boolean isNew() {
		return _trangThaiHoso.isNew();
	}

	public void setNew(boolean n) {
		_trangThaiHoso.setNew(n);
	}

	public boolean isCachedModel() {
		return _trangThaiHoso.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trangThaiHoso.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trangThaiHoso.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trangThaiHoso.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trangThaiHoso.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trangThaiHoso.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trangThaiHoso.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrangThaiHosoWrapper((TrangThaiHoso)_trangThaiHoso.clone());
	}

	public int compareTo(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso) {
		return _trangThaiHoso.compareTo(trangThaiHoso);
	}

	@Override
	public int hashCode() {
		return _trangThaiHoso.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.exch.dao.hoso.model.TrangThaiHoso> toCacheModel() {
		return _trangThaiHoso.toCacheModel();
	}

	public org.oep.exch.dao.hoso.model.TrangThaiHoso toEscapedModel() {
		return new TrangThaiHosoWrapper(_trangThaiHoso.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trangThaiHoso.toString();
	}

	public java.lang.String toXmlString() {
		return _trangThaiHoso.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiHoso.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrangThaiHoso getWrappedTrangThaiHoso() {
		return _trangThaiHoso;
	}

	public TrangThaiHoso getWrappedModel() {
		return _trangThaiHoso;
	}

	public void resetOriginalValues() {
		_trangThaiHoso.resetOriginalValues();
	}

	private TrangThaiHoso _trangThaiHoso;
}