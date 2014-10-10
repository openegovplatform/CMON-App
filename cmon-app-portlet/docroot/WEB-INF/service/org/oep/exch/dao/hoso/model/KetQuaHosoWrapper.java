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
 * This class is a wrapper for {@link KetQuaHoso}.
 * </p>
 *
 * @author    NAM
 * @see       KetQuaHoso
 * @generated
 */
public class KetQuaHosoWrapper implements KetQuaHoso, ModelWrapper<KetQuaHoso> {
	public KetQuaHosoWrapper(KetQuaHoso ketQuaHoso) {
		_ketQuaHoso = ketQuaHoso;
	}

	public Class<?> getModelClass() {
		return KetQuaHoso.class;
	}

	public String getModelClassName() {
		return KetQuaHoso.class.getName();
	}

	/**
	* Returns the primary key of this ket qua hoso.
	*
	* @return the primary key of this ket qua hoso
	*/
	public long getPrimaryKey() {
		return _ketQuaHoso.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ket qua hoso.
	*
	* @param primaryKey the primary key of this ket qua hoso
	*/
	public void setPrimaryKey(long primaryKey) {
		_ketQuaHoso.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ket qua hoso.
	*
	* @return the ID of this ket qua hoso
	*/
	public long getId() {
		return _ketQuaHoso.getId();
	}

	/**
	* Sets the ID of this ket qua hoso.
	*
	* @param id the ID of this ket qua hoso
	*/
	public void setId(long id) {
		_ketQuaHoso.setId(id);
	}

	/**
	* Returns the ngay chuyen of this ket qua hoso.
	*
	* @return the ngay chuyen of this ket qua hoso
	*/
	public java.util.Date getNgayChuyen() {
		return _ketQuaHoso.getNgayChuyen();
	}

	/**
	* Sets the ngay chuyen of this ket qua hoso.
	*
	* @param NgayChuyen the ngay chuyen of this ket qua hoso
	*/
	public void setNgayChuyen(java.util.Date NgayChuyen) {
		_ketQuaHoso.setNgayChuyen(NgayChuyen);
	}

	/**
	* Returns the ma so ho so of this ket qua hoso.
	*
	* @return the ma so ho so of this ket qua hoso
	*/
	public java.lang.String getMaSoHoSo() {
		return _ketQuaHoso.getMaSoHoSo();
	}

	/**
	* Sets the ma so ho so of this ket qua hoso.
	*
	* @param MaSoHoSo the ma so ho so of this ket qua hoso
	*/
	public void setMaSoHoSo(java.lang.String MaSoHoSo) {
		_ketQuaHoso.setMaSoHoSo(MaSoHoSo);
	}

	/**
	* Returns the ten nguoi nhan ket qua of this ket qua hoso.
	*
	* @return the ten nguoi nhan ket qua of this ket qua hoso
	*/
	public java.lang.String getTenNguoiNhanKetQua() {
		return _ketQuaHoso.getTenNguoiNhanKetQua();
	}

	/**
	* Sets the ten nguoi nhan ket qua of this ket qua hoso.
	*
	* @param TenNguoiNhanKetQua the ten nguoi nhan ket qua of this ket qua hoso
	*/
	public void setTenNguoiNhanKetQua(java.lang.String TenNguoiNhanKetQua) {
		_ketQuaHoso.setTenNguoiNhanKetQua(TenNguoiNhanKetQua);
	}

	/**
	* Returns the ngay nhan ket qua of this ket qua hoso.
	*
	* @return the ngay nhan ket qua of this ket qua hoso
	*/
	public java.lang.String getNgayNhanKetQua() {
		return _ketQuaHoso.getNgayNhanKetQua();
	}

	/**
	* Sets the ngay nhan ket qua of this ket qua hoso.
	*
	* @param NgayNhanKetQua the ngay nhan ket qua of this ket qua hoso
	*/
	public void setNgayNhanKetQua(java.lang.String NgayNhanKetQua) {
		_ketQuaHoso.setNgayNhanKetQua(NgayNhanKetQua);
	}

	/**
	* Returns the le phi ho so of this ket qua hoso.
	*
	* @return the le phi ho so of this ket qua hoso
	*/
	public int getLePhiHoSo() {
		return _ketQuaHoso.getLePhiHoSo();
	}

	/**
	* Sets the le phi ho so of this ket qua hoso.
	*
	* @param LePhiHoSo the le phi ho so of this ket qua hoso
	*/
	public void setLePhiHoSo(int LePhiHoSo) {
		_ketQuaHoso.setLePhiHoSo(LePhiHoSo);
	}

	/**
	* Returns the phi xu ly ho so of this ket qua hoso.
	*
	* @return the phi xu ly ho so of this ket qua hoso
	*/
	public int getPhiXuLyHoSo() {
		return _ketQuaHoso.getPhiXuLyHoSo();
	}

	/**
	* Sets the phi xu ly ho so of this ket qua hoso.
	*
	* @param PhiXuLyHoSo the phi xu ly ho so of this ket qua hoso
	*/
	public void setPhiXuLyHoSo(int PhiXuLyHoSo) {
		_ketQuaHoso.setPhiXuLyHoSo(PhiXuLyHoSo);
	}

	/**
	* Returns the ngay hoan thanh of this ket qua hoso.
	*
	* @return the ngay hoan thanh of this ket qua hoso
	*/
	public java.lang.String getNgayHoanThanh() {
		return _ketQuaHoso.getNgayHoanThanh();
	}

	/**
	* Sets the ngay hoan thanh of this ket qua hoso.
	*
	* @param NgayHoanThanh the ngay hoan thanh of this ket qua hoso
	*/
	public void setNgayHoanThanh(java.lang.String NgayHoanThanh) {
		_ketQuaHoso.setNgayHoanThanh(NgayHoanThanh);
	}

	/**
	* Returns the ma can bo tra ket qua of this ket qua hoso.
	*
	* @return the ma can bo tra ket qua of this ket qua hoso
	*/
	public java.lang.String getMaCanBoTraKetQua() {
		return _ketQuaHoso.getMaCanBoTraKetQua();
	}

	/**
	* Sets the ma can bo tra ket qua of this ket qua hoso.
	*
	* @param MaCanBoTraKetQua the ma can bo tra ket qua of this ket qua hoso
	*/
	public void setMaCanBoTraKetQua(java.lang.String MaCanBoTraKetQua) {
		_ketQuaHoso.setMaCanBoTraKetQua(MaCanBoTraKetQua);
	}

	/**
	* Returns the ten can bo tra ket qua of this ket qua hoso.
	*
	* @return the ten can bo tra ket qua of this ket qua hoso
	*/
	public java.lang.String getTenCanBoTraKetQua() {
		return _ketQuaHoso.getTenCanBoTraKetQua();
	}

	/**
	* Sets the ten can bo tra ket qua of this ket qua hoso.
	*
	* @param TenCanBoTraKetQua the ten can bo tra ket qua of this ket qua hoso
	*/
	public void setTenCanBoTraKetQua(java.lang.String TenCanBoTraKetQua) {
		_ketQuaHoso.setTenCanBoTraKetQua(TenCanBoTraKetQua);
	}

	/**
	* Returns the don vi cung cap of this ket qua hoso.
	*
	* @return the don vi cung cap of this ket qua hoso
	*/
	public java.lang.String getDonViCungCap() {
		return _ketQuaHoso.getDonViCungCap();
	}

	/**
	* Sets the don vi cung cap of this ket qua hoso.
	*
	* @param DonViCungCap the don vi cung cap of this ket qua hoso
	*/
	public void setDonViCungCap(java.lang.String DonViCungCap) {
		_ketQuaHoso.setDonViCungCap(DonViCungCap);
	}

	/**
	* Returns the trang thai xu ly of this ket qua hoso.
	*
	* @return the trang thai xu ly of this ket qua hoso
	*/
	public int getTrangThaiXuLy() {
		return _ketQuaHoso.getTrangThaiXuLy();
	}

	/**
	* Sets the trang thai xu ly of this ket qua hoso.
	*
	* @param TrangThaiXuLy the trang thai xu ly of this ket qua hoso
	*/
	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_ketQuaHoso.setTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the ngay xu ly of this ket qua hoso.
	*
	* @return the ngay xu ly of this ket qua hoso
	*/
	public java.util.Date getNgayXuLy() {
		return _ketQuaHoso.getNgayXuLy();
	}

	/**
	* Sets the ngay xu ly of this ket qua hoso.
	*
	* @param NgayXuLy the ngay xu ly of this ket qua hoso
	*/
	public void setNgayXuLy(java.util.Date NgayXuLy) {
		_ketQuaHoso.setNgayXuLy(NgayXuLy);
	}

	/**
	* Returns the loi khi xu ly of this ket qua hoso.
	*
	* @return the loi khi xu ly of this ket qua hoso
	*/
	public java.lang.String getLoiKhiXuLy() {
		return _ketQuaHoso.getLoiKhiXuLy();
	}

	/**
	* Sets the loi khi xu ly of this ket qua hoso.
	*
	* @param LoiKhiXuLy the loi khi xu ly of this ket qua hoso
	*/
	public void setLoiKhiXuLy(java.lang.String LoiKhiXuLy) {
		_ketQuaHoso.setLoiKhiXuLy(LoiKhiXuLy);
	}

	public boolean isNew() {
		return _ketQuaHoso.isNew();
	}

	public void setNew(boolean n) {
		_ketQuaHoso.setNew(n);
	}

	public boolean isCachedModel() {
		return _ketQuaHoso.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ketQuaHoso.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ketQuaHoso.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ketQuaHoso.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ketQuaHoso.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ketQuaHoso.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ketQuaHoso.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KetQuaHosoWrapper((KetQuaHoso)_ketQuaHoso.clone());
	}

	public int compareTo(org.oep.exch.dao.hoso.model.KetQuaHoso ketQuaHoso) {
		return _ketQuaHoso.compareTo(ketQuaHoso);
	}

	@Override
	public int hashCode() {
		return _ketQuaHoso.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.exch.dao.hoso.model.KetQuaHoso> toCacheModel() {
		return _ketQuaHoso.toCacheModel();
	}

	public org.oep.exch.dao.hoso.model.KetQuaHoso toEscapedModel() {
		return new KetQuaHosoWrapper(_ketQuaHoso.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ketQuaHoso.toString();
	}

	public java.lang.String toXmlString() {
		return _ketQuaHoso.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ketQuaHoso.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public KetQuaHoso getWrappedKetQuaHoso() {
		return _ketQuaHoso;
	}

	public KetQuaHoso getWrappedModel() {
		return _ketQuaHoso;
	}

	public void resetOriginalValues() {
		_ketQuaHoso.resetOriginalValues();
	}

	private KetQuaHoso _ketQuaHoso;
}