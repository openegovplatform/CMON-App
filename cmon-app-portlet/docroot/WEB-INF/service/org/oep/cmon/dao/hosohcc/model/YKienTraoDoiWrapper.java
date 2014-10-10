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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link YKienTraoDoi}.
 * </p>
 *
 * @author    LIEMNn
 * @see       YKienTraoDoi
 * @generated
 */
public class YKienTraoDoiWrapper implements YKienTraoDoi,
	ModelWrapper<YKienTraoDoi> {
	public YKienTraoDoiWrapper(YKienTraoDoi yKienTraoDoi) {
		_yKienTraoDoi = yKienTraoDoi;
	}

	public Class<?> getModelClass() {
		return YKienTraoDoi.class;
	}

	public String getModelClassName() {
		return YKienTraoDoi.class.getName();
	}

	/**
	* Returns the primary key of this y kien trao doi.
	*
	* @return the primary key of this y kien trao doi
	*/
	public long getPrimaryKey() {
		return _yKienTraoDoi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this y kien trao doi.
	*
	* @param primaryKey the primary key of this y kien trao doi
	*/
	public void setPrimaryKey(long primaryKey) {
		_yKienTraoDoi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this y kien trao doi.
	*
	* @return the ID of this y kien trao doi
	*/
	public long getId() {
		return _yKienTraoDoi.getId();
	}

	/**
	* Sets the ID of this y kien trao doi.
	*
	* @param id the ID of this y kien trao doi
	*/
	public void setId(long id) {
		_yKienTraoDoi.setId(id);
	}

	/**
	* Returns the tieu de of this y kien trao doi.
	*
	* @return the tieu de of this y kien trao doi
	*/
	public java.lang.String getTieuDe() {
		return _yKienTraoDoi.getTieuDe();
	}

	/**
	* Sets the tieu de of this y kien trao doi.
	*
	* @param tieuDe the tieu de of this y kien trao doi
	*/
	public void setTieuDe(java.lang.String tieuDe) {
		_yKienTraoDoi.setTieuDe(tieuDe);
	}

	/**
	* Returns the noi dung y kien of this y kien trao doi.
	*
	* @return the noi dung y kien of this y kien trao doi
	*/
	public java.lang.String getNoiDungYKien() {
		return _yKienTraoDoi.getNoiDungYKien();
	}

	/**
	* Sets the noi dung y kien of this y kien trao doi.
	*
	* @param noiDungYKien the noi dung y kien of this y kien trao doi
	*/
	public void setNoiDungYKien(java.lang.String noiDungYKien) {
		_yKienTraoDoi.setNoiDungYKien(noiDungYKien);
	}

	/**
	* Returns the thoi gian gui y kien of this y kien trao doi.
	*
	* @return the thoi gian gui y kien of this y kien trao doi
	*/
	public java.util.Date getThoiGianGuiYKien() {
		return _yKienTraoDoi.getThoiGianGuiYKien();
	}

	/**
	* Sets the thoi gian gui y kien of this y kien trao doi.
	*
	* @param thoiGianGuiYKien the thoi gian gui y kien of this y kien trao doi
	*/
	public void setThoiGianGuiYKien(java.util.Date thoiGianGuiYKien) {
		_yKienTraoDoi.setThoiGianGuiYKien(thoiGianGuiYKien);
	}

	/**
	* Returns the trang thai of this y kien trao doi.
	*
	* @return the trang thai of this y kien trao doi
	*/
	public long getTrangThai() {
		return _yKienTraoDoi.getTrangThai();
	}

	/**
	* Sets the trang thai of this y kien trao doi.
	*
	* @param trangThai the trang thai of this y kien trao doi
	*/
	public void setTrangThai(long trangThai) {
		_yKienTraoDoi.setTrangThai(trangThai);
	}

	/**
	* Returns the ho so t t h c cong ID of this y kien trao doi.
	*
	* @return the ho so t t h c cong ID of this y kien trao doi
	*/
	public java.lang.Long getHoSoTTHCCongId() {
		return _yKienTraoDoi.getHoSoTTHCCongId();
	}

	/**
	* Sets the ho so t t h c cong ID of this y kien trao doi.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID of this y kien trao doi
	*/
	public void setHoSoTTHCCongId(java.lang.Long hoSoTTHCCongId) {
		_yKienTraoDoi.setHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the nguoi nhan ID of this y kien trao doi.
	*
	* @return the nguoi nhan ID of this y kien trao doi
	*/
	public java.lang.Long getNguoiNhanId() {
		return _yKienTraoDoi.getNguoiNhanId();
	}

	/**
	* Sets the nguoi nhan ID of this y kien trao doi.
	*
	* @param nguoiNhanId the nguoi nhan ID of this y kien trao doi
	*/
	public void setNguoiNhanId(java.lang.Long nguoiNhanId) {
		_yKienTraoDoi.setNguoiNhanId(nguoiNhanId);
	}

	/**
	* Returns the nguoi gui ID of this y kien trao doi.
	*
	* @return the nguoi gui ID of this y kien trao doi
	*/
	public java.lang.Long getNguoiGuiId() {
		return _yKienTraoDoi.getNguoiGuiId();
	}

	/**
	* Sets the nguoi gui ID of this y kien trao doi.
	*
	* @param nguoiGuiId the nguoi gui ID of this y kien trao doi
	*/
	public void setNguoiGuiId(java.lang.Long nguoiGuiId) {
		_yKienTraoDoi.setNguoiGuiId(nguoiGuiId);
	}

	/**
	* Returns the chai ID of this y kien trao doi.
	*
	* @return the chai ID of this y kien trao doi
	*/
	public java.lang.Long getChaiId() {
		return _yKienTraoDoi.getChaiId();
	}

	/**
	* Sets the chai ID of this y kien trao doi.
	*
	* @param chaiId the chai ID of this y kien trao doi
	*/
	public void setChaiId(java.lang.Long chaiId) {
		_yKienTraoDoi.setChaiId(chaiId);
	}

	/**
	* Returns the noi luu tru ID of this y kien trao doi.
	*
	* @return the noi luu tru ID of this y kien trao doi
	*/
	public java.lang.Long getNoiLuuTruId() {
		return _yKienTraoDoi.getNoiLuuTruId();
	}

	/**
	* Sets the noi luu tru ID of this y kien trao doi.
	*
	* @param noiLuuTruId the noi luu tru ID of this y kien trao doi
	*/
	public void setNoiLuuTruId(java.lang.Long noiLuuTruId) {
		_yKienTraoDoi.setNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the loai of this y kien trao doi.
	*
	* @return the loai of this y kien trao doi
	*/
	public long getLoai() {
		return _yKienTraoDoi.getLoai();
	}

	/**
	* Sets the loai of this y kien trao doi.
	*
	* @param loai the loai of this y kien trao doi
	*/
	public void setLoai(long loai) {
		_yKienTraoDoi.setLoai(loai);
	}

	public boolean isNew() {
		return _yKienTraoDoi.isNew();
	}

	public void setNew(boolean n) {
		_yKienTraoDoi.setNew(n);
	}

	public boolean isCachedModel() {
		return _yKienTraoDoi.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_yKienTraoDoi.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _yKienTraoDoi.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _yKienTraoDoi.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_yKienTraoDoi.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _yKienTraoDoi.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_yKienTraoDoi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YKienTraoDoiWrapper((YKienTraoDoi)_yKienTraoDoi.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi) {
		return _yKienTraoDoi.compareTo(yKienTraoDoi);
	}

	@Override
	public int hashCode() {
		return _yKienTraoDoi.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> toCacheModel() {
		return _yKienTraoDoi.toCacheModel();
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi toEscapedModel() {
		return new YKienTraoDoiWrapper(_yKienTraoDoi.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _yKienTraoDoi.toString();
	}

	public java.lang.String toXmlString() {
		return _yKienTraoDoi.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_yKienTraoDoi.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public YKienTraoDoi getWrappedYKienTraoDoi() {
		return _yKienTraoDoi;
	}

	public YKienTraoDoi getWrappedModel() {
		return _yKienTraoDoi;
	}

	public void resetOriginalValues() {
		_yKienTraoDoi.resetOriginalValues();
	}

	private YKienTraoDoi _yKienTraoDoi;
}