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

package org.oep.cmon.dao.thamso.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AnhXa}.
 * </p>
 *
 * @author    LIEMNN
 * @see       AnhXa
 * @generated
 */
public class AnhXaWrapper implements AnhXa, ModelWrapper<AnhXa> {
	public AnhXaWrapper(AnhXa anhXa) {
		_anhXa = anhXa;
	}

	public Class<?> getModelClass() {
		return AnhXa.class;
	}

	public String getModelClassName() {
		return AnhXa.class.getName();
	}

	/**
	* Returns the primary key of this anh xa.
	*
	* @return the primary key of this anh xa
	*/
	public long getPrimaryKey() {
		return _anhXa.getPrimaryKey();
	}

	/**
	* Sets the primary key of this anh xa.
	*
	* @param primaryKey the primary key of this anh xa
	*/
	public void setPrimaryKey(long primaryKey) {
		_anhXa.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this anh xa.
	*
	* @return the ID of this anh xa
	*/
	public long getId() {
		return _anhXa.getId();
	}

	/**
	* Sets the ID of this anh xa.
	*
	* @param Id the ID of this anh xa
	*/
	public void setId(long Id) {
		_anhXa.setId(Id);
	}

	/**
	* Returns the ma d n g of this anh xa.
	*
	* @return the ma d n g of this anh xa
	*/
	public java.lang.String getMaDNG() {
		return _anhXa.getMaDNG();
	}

	/**
	* Sets the ma d n g of this anh xa.
	*
	* @param maDNG the ma d n g of this anh xa
	*/
	public void setMaDNG(java.lang.String maDNG) {
		_anhXa.setMaDNG(maDNG);
	}

	/**
	* Returns the ten d n g of this anh xa.
	*
	* @return the ten d n g of this anh xa
	*/
	public java.lang.String getTenDNG() {
		return _anhXa.getTenDNG();
	}

	/**
	* Sets the ten d n g of this anh xa.
	*
	* @param tenDNG the ten d n g of this anh xa
	*/
	public void setTenDNG(java.lang.String tenDNG) {
		_anhXa.setTenDNG(tenDNG);
	}

	/**
	* Returns the ma khac of this anh xa.
	*
	* @return the ma khac of this anh xa
	*/
	public java.lang.String getMaKhac() {
		return _anhXa.getMaKhac();
	}

	/**
	* Sets the ma khac of this anh xa.
	*
	* @param maKhac the ma khac of this anh xa
	*/
	public void setMaKhac(java.lang.String maKhac) {
		_anhXa.setMaKhac(maKhac);
	}

	/**
	* Returns the ten khac of this anh xa.
	*
	* @return the ten khac of this anh xa
	*/
	public java.lang.String getTenKhac() {
		return _anhXa.getTenKhac();
	}

	/**
	* Sets the ten khac of this anh xa.
	*
	* @param tenKhac the ten khac of this anh xa
	*/
	public void setTenKhac(java.lang.String tenKhac) {
		_anhXa.setTenKhac(tenKhac);
	}

	/**
	* Returns the ten bang of this anh xa.
	*
	* @return the ten bang of this anh xa
	*/
	public java.lang.String getTenBang() {
		return _anhXa.getTenBang();
	}

	/**
	* Sets the ten bang of this anh xa.
	*
	* @param tenBang the ten bang of this anh xa
	*/
	public void setTenBang(java.lang.String tenBang) {
		_anhXa.setTenBang(tenBang);
	}

	/**
	* Returns the ung dung ID of this anh xa.
	*
	* @return the ung dung ID of this anh xa
	*/
	public long getUngDungId() {
		return _anhXa.getUngDungId();
	}

	/**
	* Sets the ung dung ID of this anh xa.
	*
	* @param UngDungId the ung dung ID of this anh xa
	*/
	public void setUngDungId(long UngDungId) {
		_anhXa.setUngDungId(UngDungId);
	}

	/**
	* Returns the ngay tao of this anh xa.
	*
	* @return the ngay tao of this anh xa
	*/
	public java.util.Date getNgayTao() {
		return _anhXa.getNgayTao();
	}

	/**
	* Sets the ngay tao of this anh xa.
	*
	* @param NgayTao the ngay tao of this anh xa
	*/
	public void setNgayTao(java.util.Date NgayTao) {
		_anhXa.setNgayTao(NgayTao);
	}

	/**
	* Returns the nguoi tao of this anh xa.
	*
	* @return the nguoi tao of this anh xa
	*/
	public java.lang.String getNguoiTao() {
		return _anhXa.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this anh xa.
	*
	* @param NguoiTao the nguoi tao of this anh xa
	*/
	public void setNguoiTao(java.lang.String NguoiTao) {
		_anhXa.setNguoiTao(NguoiTao);
	}

	/**
	* Returns the ngay sua of this anh xa.
	*
	* @return the ngay sua of this anh xa
	*/
	public java.util.Date getNgaySua() {
		return _anhXa.getNgaySua();
	}

	/**
	* Sets the ngay sua of this anh xa.
	*
	* @param NgaySua the ngay sua of this anh xa
	*/
	public void setNgaySua(java.util.Date NgaySua) {
		_anhXa.setNgaySua(NgaySua);
	}

	/**
	* Returns the nguoi sua of this anh xa.
	*
	* @return the nguoi sua of this anh xa
	*/
	public java.lang.String getNguoiSua() {
		return _anhXa.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this anh xa.
	*
	* @param NguoiSua the nguoi sua of this anh xa
	*/
	public void setNguoiSua(java.lang.String NguoiSua) {
		_anhXa.setNguoiSua(NguoiSua);
	}

	/**
	* Returns the da xoa of this anh xa.
	*
	* @return the da xoa of this anh xa
	*/
	public int getDaXoa() {
		return _anhXa.getDaXoa();
	}

	/**
	* Sets the da xoa of this anh xa.
	*
	* @param DaXoa the da xoa of this anh xa
	*/
	public void setDaXoa(int DaXoa) {
		_anhXa.setDaXoa(DaXoa);
	}

	public boolean isNew() {
		return _anhXa.isNew();
	}

	public void setNew(boolean n) {
		_anhXa.setNew(n);
	}

	public boolean isCachedModel() {
		return _anhXa.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_anhXa.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _anhXa.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _anhXa.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anhXa.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anhXa.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anhXa.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnhXaWrapper((AnhXa)_anhXa.clone());
	}

	public int compareTo(org.oep.cmon.dao.thamso.model.AnhXa anhXa) {
		return _anhXa.compareTo(anhXa);
	}

	@Override
	public int hashCode() {
		return _anhXa.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.thamso.model.AnhXa> toCacheModel() {
		return _anhXa.toCacheModel();
	}

	public org.oep.cmon.dao.thamso.model.AnhXa toEscapedModel() {
		return new AnhXaWrapper(_anhXa.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anhXa.toString();
	}

	public java.lang.String toXmlString() {
		return _anhXa.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anhXa.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AnhXa getWrappedAnhXa() {
		return _anhXa;
	}

	public AnhXa getWrappedModel() {
		return _anhXa;
	}

	public void resetOriginalValues() {
		_anhXa.resetOriginalValues();
	}

	private AnhXa _anhXa;
}