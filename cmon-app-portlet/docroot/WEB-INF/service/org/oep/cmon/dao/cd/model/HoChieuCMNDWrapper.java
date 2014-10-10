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
 * This class is a wrapper for {@link HoChieuCMND}.
 * </p>
 *
 * @author    LIEMNN
 * @see       HoChieuCMND
 * @generated
 */
public class HoChieuCMNDWrapper implements HoChieuCMND,
	ModelWrapper<HoChieuCMND> {
	public HoChieuCMNDWrapper(HoChieuCMND hoChieuCMND) {
		_hoChieuCMND = hoChieuCMND;
	}

	public Class<?> getModelClass() {
		return HoChieuCMND.class;
	}

	public String getModelClassName() {
		return HoChieuCMND.class.getName();
	}

	/**
	* Returns the primary key of this ho chieu c m n d.
	*
	* @return the primary key of this ho chieu c m n d
	*/
	public long getPrimaryKey() {
		return _hoChieuCMND.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho chieu c m n d.
	*
	* @param primaryKey the primary key of this ho chieu c m n d
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoChieuCMND.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ho chieu c m n d.
	*
	* @return the ID of this ho chieu c m n d
	*/
	public long getId() {
		return _hoChieuCMND.getId();
	}

	/**
	* Sets the ID of this ho chieu c m n d.
	*
	* @param id the ID of this ho chieu c m n d
	*/
	public void setId(long id) {
		_hoChieuCMND.setId(id);
	}

	/**
	* Returns the so of this ho chieu c m n d.
	*
	* @return the so of this ho chieu c m n d
	*/
	public java.lang.String getSo() {
		return _hoChieuCMND.getSo();
	}

	/**
	* Sets the so of this ho chieu c m n d.
	*
	* @param so the so of this ho chieu c m n d
	*/
	public void setSo(java.lang.String so) {
		_hoChieuCMND.setSo(so);
	}

	/**
	* Returns the ngay cap of this ho chieu c m n d.
	*
	* @return the ngay cap of this ho chieu c m n d
	*/
	public java.util.Date getNgayCap() {
		return _hoChieuCMND.getNgayCap();
	}

	/**
	* Sets the ngay cap of this ho chieu c m n d.
	*
	* @param ngayCap the ngay cap of this ho chieu c m n d
	*/
	public void setNgayCap(java.util.Date ngayCap) {
		_hoChieuCMND.setNgayCap(ngayCap);
	}

	/**
	* Returns the ngay het han of this ho chieu c m n d.
	*
	* @return the ngay het han of this ho chieu c m n d
	*/
	public java.util.Date getNgayHetHan() {
		return _hoChieuCMND.getNgayHetHan();
	}

	/**
	* Sets the ngay het han of this ho chieu c m n d.
	*
	* @param ngayHetHan the ngay het han of this ho chieu c m n d
	*/
	public void setNgayHetHan(java.util.Date ngayHetHan) {
		_hoChieuCMND.setNgayHetHan(ngayHetHan);
	}

	/**
	* Returns the noi cap ID of this ho chieu c m n d.
	*
	* @return the noi cap ID of this ho chieu c m n d
	*/
	public java.lang.Long getNoiCapId() {
		return _hoChieuCMND.getNoiCapId();
	}

	/**
	* Sets the noi cap ID of this ho chieu c m n d.
	*
	* @param noiCapId the noi cap ID of this ho chieu c m n d
	*/
	public void setNoiCapId(java.lang.Long noiCapId) {
		_hoChieuCMND.setNoiCapId(noiCapId);
	}

	/**
	* Returns the noi cap of this ho chieu c m n d.
	*
	* @return the noi cap of this ho chieu c m n d
	*/
	public java.lang.String getNoiCap() {
		return _hoChieuCMND.getNoiCap();
	}

	/**
	* Sets the noi cap of this ho chieu c m n d.
	*
	* @param noiCap the noi cap of this ho chieu c m n d
	*/
	public void setNoiCap(java.lang.String noiCap) {
		_hoChieuCMND.setNoiCap(noiCap);
	}

	/**
	* Returns the gi chu of this ho chieu c m n d.
	*
	* @return the gi chu of this ho chieu c m n d
	*/
	public java.lang.String getGiChu() {
		return _hoChieuCMND.getGiChu();
	}

	/**
	* Sets the gi chu of this ho chieu c m n d.
	*
	* @param giChu the gi chu of this ho chieu c m n d
	*/
	public void setGiChu(java.lang.String giChu) {
		_hoChieuCMND.setGiChu(giChu);
	}

	/**
	* Returns the loai of this ho chieu c m n d.
	*
	* @return the loai of this ho chieu c m n d
	*/
	public int getLoai() {
		return _hoChieuCMND.getLoai();
	}

	/**
	* Sets the loai of this ho chieu c m n d.
	*
	* @param loai the loai of this ho chieu c m n d
	*/
	public void setLoai(int loai) {
		_hoChieuCMND.setLoai(loai);
	}

	/**
	* Returns the trang thai of this ho chieu c m n d.
	*
	* @return the trang thai of this ho chieu c m n d
	*/
	public int getTrangThai() {
		return _hoChieuCMND.getTrangThai();
	}

	/**
	* Sets the trang thai of this ho chieu c m n d.
	*
	* @param trangThai the trang thai of this ho chieu c m n d
	*/
	public void setTrangThai(int trangThai) {
		_hoChieuCMND.setTrangThai(trangThai);
	}

	/**
	* Returns the nguoi tao of this ho chieu c m n d.
	*
	* @return the nguoi tao of this ho chieu c m n d
	*/
	public java.lang.String getNguoiTao() {
		return _hoChieuCMND.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this ho chieu c m n d.
	*
	* @param nguoiTao the nguoi tao of this ho chieu c m n d
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_hoChieuCMND.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this ho chieu c m n d.
	*
	* @return the ngay tao of this ho chieu c m n d
	*/
	public java.util.Date getNgayTao() {
		return _hoChieuCMND.getNgayTao();
	}

	/**
	* Sets the ngay tao of this ho chieu c m n d.
	*
	* @param ngayTao the ngay tao of this ho chieu c m n d
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_hoChieuCMND.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this ho chieu c m n d.
	*
	* @return the nguoi sua of this ho chieu c m n d
	*/
	public java.lang.String getNguoiSua() {
		return _hoChieuCMND.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this ho chieu c m n d.
	*
	* @param nguoiSua the nguoi sua of this ho chieu c m n d
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_hoChieuCMND.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this ho chieu c m n d.
	*
	* @return the ngay sua of this ho chieu c m n d
	*/
	public java.util.Date getNgaySua() {
		return _hoChieuCMND.getNgaySua();
	}

	/**
	* Sets the ngay sua of this ho chieu c m n d.
	*
	* @param ngaySua the ngay sua of this ho chieu c m n d
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_hoChieuCMND.setNgaySua(ngaySua);
	}

	/**
	* Returns the cong dan i d of this ho chieu c m n d.
	*
	* @return the cong dan i d of this ho chieu c m n d
	*/
	public java.lang.Long getCongDanID() {
		return _hoChieuCMND.getCongDanID();
	}

	/**
	* Sets the cong dan i d of this ho chieu c m n d.
	*
	* @param congDanID the cong dan i d of this ho chieu c m n d
	*/
	public void setCongDanID(java.lang.Long congDanID) {
		_hoChieuCMND.setCongDanID(congDanID);
	}

	public boolean isNew() {
		return _hoChieuCMND.isNew();
	}

	public void setNew(boolean n) {
		_hoChieuCMND.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoChieuCMND.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoChieuCMND.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoChieuCMND.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoChieuCMND.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoChieuCMND.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoChieuCMND.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoChieuCMND.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoChieuCMNDWrapper((HoChieuCMND)_hoChieuCMND.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.HoChieuCMND hoChieuCMND) {
		return _hoChieuCMND.compareTo(hoChieuCMND);
	}

	@Override
	public int hashCode() {
		return _hoChieuCMND.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.HoChieuCMND> toCacheModel() {
		return _hoChieuCMND.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.HoChieuCMND toEscapedModel() {
		return new HoChieuCMNDWrapper(_hoChieuCMND.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoChieuCMND.toString();
	}

	public java.lang.String toXmlString() {
		return _hoChieuCMND.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoChieuCMND.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoChieuCMND getWrappedHoChieuCMND() {
		return _hoChieuCMND;
	}

	public HoChieuCMND getWrappedModel() {
		return _hoChieuCMND;
	}

	public void resetOriginalValues() {
		_hoChieuCMND.resetOriginalValues();
	}

	private HoChieuCMND _hoChieuCMND;
}