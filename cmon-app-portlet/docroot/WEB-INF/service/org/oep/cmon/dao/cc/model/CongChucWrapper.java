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
 * This class is a wrapper for {@link CongChuc}.
 * </p>
 *
 * @author    Liemnn
 * @see       CongChuc
 * @generated
 */
public class CongChucWrapper implements CongChuc, ModelWrapper<CongChuc> {
	public CongChucWrapper(CongChuc congChuc) {
		_congChuc = congChuc;
	}

	public Class<?> getModelClass() {
		return CongChuc.class;
	}

	public String getModelClassName() {
		return CongChuc.class.getName();
	}

	/**
	* Returns the primary key of this cong chuc.
	*
	* @return the primary key of this cong chuc
	*/
	public long getPrimaryKey() {
		return _congChuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cong chuc.
	*
	* @param primaryKey the primary key of this cong chuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_congChuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cong chuc.
	*
	* @return the ID of this cong chuc
	*/
	public long getId() {
		return _congChuc.getId();
	}

	/**
	* Sets the ID of this cong chuc.
	*
	* @param id the ID of this cong chuc
	*/
	public void setId(long id) {
		_congChuc.setId(id);
	}

	/**
	* Returns the ma of this cong chuc.
	*
	* @return the ma of this cong chuc
	*/
	public java.lang.String getMa() {
		return _congChuc.getMa();
	}

	/**
	* Sets the ma of this cong chuc.
	*
	* @param ma the ma of this cong chuc
	*/
	public void setMa(java.lang.String ma) {
		_congChuc.setMa(ma);
	}

	/**
	* Returns the ho va ten of this cong chuc.
	*
	* @return the ho va ten of this cong chuc
	*/
	public java.lang.String getHoVaTen() {
		return _congChuc.getHoVaTen();
	}

	/**
	* Sets the ho va ten of this cong chuc.
	*
	* @param hoVaTen the ho va ten of this cong chuc
	*/
	public void setHoVaTen(java.lang.String hoVaTen) {
		_congChuc.setHoVaTen(hoVaTen);
	}

	/**
	* Returns the ngay sinh of this cong chuc.
	*
	* @return the ngay sinh of this cong chuc
	*/
	public java.util.Date getNgaySinh() {
		return _congChuc.getNgaySinh();
	}

	/**
	* Sets the ngay sinh of this cong chuc.
	*
	* @param ngaySinh the ngay sinh of this cong chuc
	*/
	public void setNgaySinh(java.util.Date ngaySinh) {
		_congChuc.setNgaySinh(ngaySinh);
	}

	/**
	* Returns the so cmnd of this cong chuc.
	*
	* @return the so cmnd of this cong chuc
	*/
	public java.lang.String getSoCmnd() {
		return _congChuc.getSoCmnd();
	}

	/**
	* Sets the so cmnd of this cong chuc.
	*
	* @param soCmnd the so cmnd of this cong chuc
	*/
	public void setSoCmnd(java.lang.String soCmnd) {
		_congChuc.setSoCmnd(soCmnd);
	}

	/**
	* Returns the ngay cap cmnd of this cong chuc.
	*
	* @return the ngay cap cmnd of this cong chuc
	*/
	public java.util.Date getNgayCapCmnd() {
		return _congChuc.getNgayCapCmnd();
	}

	/**
	* Sets the ngay cap cmnd of this cong chuc.
	*
	* @param ngayCapCmnd the ngay cap cmnd of this cong chuc
	*/
	public void setNgayCapCmnd(java.util.Date ngayCapCmnd) {
		_congChuc.setNgayCapCmnd(ngayCapCmnd);
	}

	/**
	* Returns the noi cap cmnd of this cong chuc.
	*
	* @return the noi cap cmnd of this cong chuc
	*/
	public java.lang.String getNoiCapCmnd() {
		return _congChuc.getNoiCapCmnd();
	}

	/**
	* Sets the noi cap cmnd of this cong chuc.
	*
	* @param noiCapCmnd the noi cap cmnd of this cong chuc
	*/
	public void setNoiCapCmnd(java.lang.String noiCapCmnd) {
		_congChuc.setNoiCapCmnd(noiCapCmnd);
	}

	/**
	* Returns the gioi tinh ID of this cong chuc.
	*
	* @return the gioi tinh ID of this cong chuc
	*/
	public long getGioiTinhId() {
		return _congChuc.getGioiTinhId();
	}

	/**
	* Sets the gioi tinh ID of this cong chuc.
	*
	* @param gioiTinhId the gioi tinh ID of this cong chuc
	*/
	public void setGioiTinhId(long gioiTinhId) {
		_congChuc.setGioiTinhId(gioiTinhId);
	}

	/**
	* Returns the ngay tao of this cong chuc.
	*
	* @return the ngay tao of this cong chuc
	*/
	public java.util.Date getNgayTao() {
		return _congChuc.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cong chuc.
	*
	* @param ngayTao the ngay tao of this cong chuc
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_congChuc.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this cong chuc.
	*
	* @return the ngay sua of this cong chuc
	*/
	public java.util.Date getNgaySua() {
		return _congChuc.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cong chuc.
	*
	* @param ngaySua the ngay sua of this cong chuc
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_congChuc.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this cong chuc.
	*
	* @return the da xoa of this cong chuc
	*/
	public int getDaXoa() {
		return _congChuc.getDaXoa();
	}

	/**
	* Sets the da xoa of this cong chuc.
	*
	* @param daXoa the da xoa of this cong chuc
	*/
	public void setDaXoa(int daXoa) {
		_congChuc.setDaXoa(daXoa);
	}

	/**
	* Returns the tai khoan nguoi dung ID of this cong chuc.
	*
	* @return the tai khoan nguoi dung ID of this cong chuc
	*/
	public java.lang.Long getTaiKhoanNguoiDungId() {
		return _congChuc.getTaiKhoanNguoiDungId();
	}

	/**
	* Sets the tai khoan nguoi dung ID of this cong chuc.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID of this cong chuc
	*/
	public void setTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId) {
		_congChuc.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Returns the nguoi sua of this cong chuc.
	*
	* @return the nguoi sua of this cong chuc
	*/
	public java.lang.String getNguoiSua() {
		return _congChuc.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cong chuc.
	*
	* @param nguoiSua the nguoi sua of this cong chuc
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_congChuc.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the chuc vu ID of this cong chuc.
	*
	* @return the chuc vu ID of this cong chuc
	*/
	public long getChucVuId() {
		return _congChuc.getChucVuId();
	}

	/**
	* Sets the chuc vu ID of this cong chuc.
	*
	* @param chucVuId the chuc vu ID of this cong chuc
	*/
	public void setChucVuId(long chucVuId) {
		_congChuc.setChucVuId(chucVuId);
	}

	/**
	* Returns the co quan quan ly ID of this cong chuc.
	*
	* @return the co quan quan ly ID of this cong chuc
	*/
	public long getCoQuanQuanLyId() {
		return _congChuc.getCoQuanQuanLyId();
	}

	/**
	* Sets the co quan quan ly ID of this cong chuc.
	*
	* @param coQuanQuanLyId the co quan quan ly ID of this cong chuc
	*/
	public void setCoQuanQuanLyId(long coQuanQuanLyId) {
		_congChuc.setCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns the nguoi tao of this cong chuc.
	*
	* @return the nguoi tao of this cong chuc
	*/
	public java.lang.String getNguoiTao() {
		return _congChuc.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cong chuc.
	*
	* @param nguoiTao the nguoi tao of this cong chuc
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_congChuc.setNguoiTao(nguoiTao);
	}

	public boolean isNew() {
		return _congChuc.isNew();
	}

	public void setNew(boolean n) {
		_congChuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _congChuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_congChuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _congChuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _congChuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_congChuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _congChuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_congChuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CongChucWrapper((CongChuc)_congChuc.clone());
	}

	public int compareTo(org.oep.cmon.dao.cc.model.CongChuc congChuc) {
		return _congChuc.compareTo(congChuc);
	}

	@Override
	public int hashCode() {
		return _congChuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cc.model.CongChuc> toCacheModel() {
		return _congChuc.toCacheModel();
	}

	public org.oep.cmon.dao.cc.model.CongChuc toEscapedModel() {
		return new CongChucWrapper(_congChuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _congChuc.toString();
	}

	public java.lang.String toXmlString() {
		return _congChuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_congChuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CongChuc getWrappedCongChuc() {
		return _congChuc;
	}

	public CongChuc getWrappedModel() {
		return _congChuc;
	}

	public void resetOriginalValues() {
		_congChuc.resetOriginalValues();
	}

	private CongChuc _congChuc;
}