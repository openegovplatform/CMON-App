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
 * This class is a wrapper for {@link LichSuGiayToDinhKem}.
 * </p>
 *
 * @author    Liemnn
 * @see       LichSuGiayToDinhKem
 * @generated
 */
public class LichSuGiayToDinhKemWrapper implements LichSuGiayToDinhKem,
	ModelWrapper<LichSuGiayToDinhKem> {
	public LichSuGiayToDinhKemWrapper(LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		_lichSuGiayToDinhKem = lichSuGiayToDinhKem;
	}

	public Class<?> getModelClass() {
		return LichSuGiayToDinhKem.class;
	}

	public String getModelClassName() {
		return LichSuGiayToDinhKem.class.getName();
	}

	/**
	* Returns the primary key of this lich su giay to dinh kem.
	*
	* @return the primary key of this lich su giay to dinh kem
	*/
	public long getPrimaryKey() {
		return _lichSuGiayToDinhKem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lich su giay to dinh kem.
	*
	* @param primaryKey the primary key of this lich su giay to dinh kem
	*/
	public void setPrimaryKey(long primaryKey) {
		_lichSuGiayToDinhKem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this lich su giay to dinh kem.
	*
	* @return the ID of this lich su giay to dinh kem
	*/
	public long getId() {
		return _lichSuGiayToDinhKem.getId();
	}

	/**
	* Sets the ID of this lich su giay to dinh kem.
	*
	* @param id the ID of this lich su giay to dinh kem
	*/
	public void setId(long id) {
		_lichSuGiayToDinhKem.setId(id);
	}

	/**
	* Returns the giay to dinh kem ho so ID of this lich su giay to dinh kem.
	*
	* @return the giay to dinh kem ho so ID of this lich su giay to dinh kem
	*/
	public java.lang.Long getGiayToDinhKemHoSoId() {
		return _lichSuGiayToDinhKem.getGiayToDinhKemHoSoId();
	}

	/**
	* Sets the giay to dinh kem ho so ID of this lich su giay to dinh kem.
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID of this lich su giay to dinh kem
	*/
	public void setGiayToDinhKemHoSoId(java.lang.Long giayToDinhKemHoSoId) {
		_lichSuGiayToDinhKem.setGiayToDinhKemHoSoId(giayToDinhKemHoSoId);
	}

	/**
	* Returns the hanh dong of this lich su giay to dinh kem.
	*
	* @return the hanh dong of this lich su giay to dinh kem
	*/
	public int getHanhDong() {
		return _lichSuGiayToDinhKem.getHanhDong();
	}

	/**
	* Sets the hanh dong of this lich su giay to dinh kem.
	*
	* @param hanhDong the hanh dong of this lich su giay to dinh kem
	*/
	public void setHanhDong(int hanhDong) {
		_lichSuGiayToDinhKem.setHanhDong(hanhDong);
	}

	/**
	* Returns the nguoi tao of this lich su giay to dinh kem.
	*
	* @return the nguoi tao of this lich su giay to dinh kem
	*/
	public java.lang.String getNguoiTao() {
		return _lichSuGiayToDinhKem.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this lich su giay to dinh kem.
	*
	* @param nguoiTao the nguoi tao of this lich su giay to dinh kem
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_lichSuGiayToDinhKem.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the noi luu tru tai lieu ID of this lich su giay to dinh kem.
	*
	* @return the noi luu tru tai lieu ID of this lich su giay to dinh kem
	*/
	public long getNoiLuuTruTaiLieuId() {
		return _lichSuGiayToDinhKem.getNoiLuuTruTaiLieuId();
	}

	/**
	* Sets the noi luu tru tai lieu ID of this lich su giay to dinh kem.
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID of this lich su giay to dinh kem
	*/
	public void setNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId) {
		_lichSuGiayToDinhKem.setNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);
	}

	/**
	* Returns the ngay tao of this lich su giay to dinh kem.
	*
	* @return the ngay tao of this lich su giay to dinh kem
	*/
	public java.util.Date getNgayTao() {
		return _lichSuGiayToDinhKem.getNgayTao();
	}

	/**
	* Sets the ngay tao of this lich su giay to dinh kem.
	*
	* @param ngayTao the ngay tao of this lich su giay to dinh kem
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_lichSuGiayToDinhKem.setNgayTao(ngayTao);
	}

	/**
	* Returns the ten tai lieu of this lich su giay to dinh kem.
	*
	* @return the ten tai lieu of this lich su giay to dinh kem
	*/
	public java.lang.String getTenTaiLieu() {
		return _lichSuGiayToDinhKem.getTenTaiLieu();
	}

	/**
	* Sets the ten tai lieu of this lich su giay to dinh kem.
	*
	* @param tenTaiLieu the ten tai lieu of this lich su giay to dinh kem
	*/
	public void setTenTaiLieu(java.lang.String tenTaiLieu) {
		_lichSuGiayToDinhKem.setTenTaiLieu(tenTaiLieu);
	}

	public boolean isNew() {
		return _lichSuGiayToDinhKem.isNew();
	}

	public void setNew(boolean n) {
		_lichSuGiayToDinhKem.setNew(n);
	}

	public boolean isCachedModel() {
		return _lichSuGiayToDinhKem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_lichSuGiayToDinhKem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _lichSuGiayToDinhKem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _lichSuGiayToDinhKem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lichSuGiayToDinhKem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lichSuGiayToDinhKem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lichSuGiayToDinhKem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LichSuGiayToDinhKemWrapper((LichSuGiayToDinhKem)_lichSuGiayToDinhKem.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		return _lichSuGiayToDinhKem.compareTo(lichSuGiayToDinhKem);
	}

	@Override
	public int hashCode() {
		return _lichSuGiayToDinhKem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> toCacheModel() {
		return _lichSuGiayToDinhKem.toCacheModel();
	}

	public org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem toEscapedModel() {
		return new LichSuGiayToDinhKemWrapper(_lichSuGiayToDinhKem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lichSuGiayToDinhKem.toString();
	}

	public java.lang.String toXmlString() {
		return _lichSuGiayToDinhKem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lichSuGiayToDinhKem.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LichSuGiayToDinhKem getWrappedLichSuGiayToDinhKem() {
		return _lichSuGiayToDinhKem;
	}

	public LichSuGiayToDinhKem getWrappedModel() {
		return _lichSuGiayToDinhKem;
	}

	public void resetOriginalValues() {
		_lichSuGiayToDinhKem.resetOriginalValues();
	}

	private LichSuGiayToDinhKem _lichSuGiayToDinhKem;
}