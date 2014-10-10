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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HangGiayPhepLaiXe}.
 * </p>
 *
 * @author    AnhNT
 * @see       HangGiayPhepLaiXe
 * @generated
 */
public class HangGiayPhepLaiXeWrapper implements HangGiayPhepLaiXe,
	ModelWrapper<HangGiayPhepLaiXe> {
	public HangGiayPhepLaiXeWrapper(HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		_hangGiayPhepLaiXe = hangGiayPhepLaiXe;
	}

	public Class<?> getModelClass() {
		return HangGiayPhepLaiXe.class;
	}

	public String getModelClassName() {
		return HangGiayPhepLaiXe.class.getName();
	}

	/**
	* Returns the primary key of this hang giay phep lai xe.
	*
	* @return the primary key of this hang giay phep lai xe
	*/
	public long getPrimaryKey() {
		return _hangGiayPhepLaiXe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this hang giay phep lai xe.
	*
	* @param primaryKey the primary key of this hang giay phep lai xe
	*/
	public void setPrimaryKey(long primaryKey) {
		_hangGiayPhepLaiXe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this hang giay phep lai xe.
	*
	* @return the ID of this hang giay phep lai xe
	*/
	public long getId() {
		return _hangGiayPhepLaiXe.getId();
	}

	/**
	* Sets the ID of this hang giay phep lai xe.
	*
	* @param id the ID of this hang giay phep lai xe
	*/
	public void setId(long id) {
		_hangGiayPhepLaiXe.setId(id);
	}

	/**
	* Returns the ten hang of this hang giay phep lai xe.
	*
	* @return the ten hang of this hang giay phep lai xe
	*/
	public java.lang.String getTenHang() {
		return _hangGiayPhepLaiXe.getTenHang();
	}

	/**
	* Sets the ten hang of this hang giay phep lai xe.
	*
	* @param tenHang the ten hang of this hang giay phep lai xe
	*/
	public void setTenHang(java.lang.String tenHang) {
		_hangGiayPhepLaiXe.setTenHang(tenHang);
	}

	/**
	* Returns the ngay tao of this hang giay phep lai xe.
	*
	* @return the ngay tao of this hang giay phep lai xe
	*/
	public java.util.Date getNgayTao() {
		return _hangGiayPhepLaiXe.getNgayTao();
	}

	/**
	* Sets the ngay tao of this hang giay phep lai xe.
	*
	* @param ngayTao the ngay tao of this hang giay phep lai xe
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_hangGiayPhepLaiXe.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this hang giay phep lai xe.
	*
	* @return the ngay sua of this hang giay phep lai xe
	*/
	public java.util.Date getNgaySua() {
		return _hangGiayPhepLaiXe.getNgaySua();
	}

	/**
	* Sets the ngay sua of this hang giay phep lai xe.
	*
	* @param ngaySua the ngay sua of this hang giay phep lai xe
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_hangGiayPhepLaiXe.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this hang giay phep lai xe.
	*
	* @return the nguoi tao of this hang giay phep lai xe
	*/
	public java.lang.String getNguoiTao() {
		return _hangGiayPhepLaiXe.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this hang giay phep lai xe.
	*
	* @param nguoiTao the nguoi tao of this hang giay phep lai xe
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_hangGiayPhepLaiXe.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this hang giay phep lai xe.
	*
	* @return the nguoi sua of this hang giay phep lai xe
	*/
	public java.lang.String getNguoiSua() {
		return _hangGiayPhepLaiXe.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this hang giay phep lai xe.
	*
	* @param nguoiSua the nguoi sua of this hang giay phep lai xe
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_hangGiayPhepLaiXe.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the xoa of this hang giay phep lai xe.
	*
	* @return the xoa of this hang giay phep lai xe
	*/
	public int getXoa() {
		return _hangGiayPhepLaiXe.getXoa();
	}

	/**
	* Sets the xoa of this hang giay phep lai xe.
	*
	* @param xoa the xoa of this hang giay phep lai xe
	*/
	public void setXoa(int xoa) {
		_hangGiayPhepLaiXe.setXoa(xoa);
	}

	/**
	* Returns the ma of this hang giay phep lai xe.
	*
	* @return the ma of this hang giay phep lai xe
	*/
	public java.lang.String getMa() {
		return _hangGiayPhepLaiXe.getMa();
	}

	/**
	* Sets the ma of this hang giay phep lai xe.
	*
	* @param ma the ma of this hang giay phep lai xe
	*/
	public void setMa(java.lang.String ma) {
		_hangGiayPhepLaiXe.setMa(ma);
	}

	public boolean isNew() {
		return _hangGiayPhepLaiXe.isNew();
	}

	public void setNew(boolean n) {
		_hangGiayPhepLaiXe.setNew(n);
	}

	public boolean isCachedModel() {
		return _hangGiayPhepLaiXe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hangGiayPhepLaiXe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hangGiayPhepLaiXe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hangGiayPhepLaiXe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hangGiayPhepLaiXe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hangGiayPhepLaiXe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hangGiayPhepLaiXe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HangGiayPhepLaiXeWrapper((HangGiayPhepLaiXe)_hangGiayPhepLaiXe.clone());
	}

	public int compareTo(HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		return _hangGiayPhepLaiXe.compareTo(hangGiayPhepLaiXe);
	}

	@Override
	public int hashCode() {
		return _hangGiayPhepLaiXe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<HangGiayPhepLaiXe> toCacheModel() {
		return _hangGiayPhepLaiXe.toCacheModel();
	}

	public HangGiayPhepLaiXe toEscapedModel() {
		return new HangGiayPhepLaiXeWrapper(_hangGiayPhepLaiXe.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hangGiayPhepLaiXe.toString();
	}

	public java.lang.String toXmlString() {
		return _hangGiayPhepLaiXe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hangGiayPhepLaiXe.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HangGiayPhepLaiXe getWrappedHangGiayPhepLaiXe() {
		return _hangGiayPhepLaiXe;
	}

	public HangGiayPhepLaiXe getWrappedModel() {
		return _hangGiayPhepLaiXe;
	}

	public void resetOriginalValues() {
		_hangGiayPhepLaiXe.resetOriginalValues();
	}

	private HangGiayPhepLaiXe _hangGiayPhepLaiXe;
}