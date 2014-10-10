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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CapNhatKetQua}.
 * </p>
 *
 * @author    liemnn
 * @see       CapNhatKetQua
 * @generated
 */
public class CapNhatKetQuaWrapper implements CapNhatKetQua,
	ModelWrapper<CapNhatKetQua> {
	public CapNhatKetQuaWrapper(CapNhatKetQua capNhatKetQua) {
		_capNhatKetQua = capNhatKetQua;
	}

	public Class<?> getModelClass() {
		return CapNhatKetQua.class;
	}

	public String getModelClassName() {
		return CapNhatKetQua.class.getName();
	}

	/**
	* Returns the primary key of this cap nhat ket qua.
	*
	* @return the primary key of this cap nhat ket qua
	*/
	public long getPrimaryKey() {
		return _capNhatKetQua.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cap nhat ket qua.
	*
	* @param primaryKey the primary key of this cap nhat ket qua
	*/
	public void setPrimaryKey(long primaryKey) {
		_capNhatKetQua.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cap nhat ket qua.
	*
	* @return the ID of this cap nhat ket qua
	*/
	public long getId() {
		return _capNhatKetQua.getId();
	}

	/**
	* Sets the ID of this cap nhat ket qua.
	*
	* @param id the ID of this cap nhat ket qua
	*/
	public void setId(long id) {
		_capNhatKetQua.setId(id);
	}

	/**
	* Returns the ten bang of this cap nhat ket qua.
	*
	* @return the ten bang of this cap nhat ket qua
	*/
	public java.lang.String getTenBang() {
		return _capNhatKetQua.getTenBang();
	}

	/**
	* Sets the ten bang of this cap nhat ket qua.
	*
	* @param tenBang the ten bang of this cap nhat ket qua
	*/
	public void setTenBang(java.lang.String tenBang) {
		_capNhatKetQua.setTenBang(tenBang);
	}

	/**
	* Returns the ban ghi ID of this cap nhat ket qua.
	*
	* @return the ban ghi ID of this cap nhat ket qua
	*/
	public long getBanGhiId() {
		return _capNhatKetQua.getBanGhiId();
	}

	/**
	* Sets the ban ghi ID of this cap nhat ket qua.
	*
	* @param banGhiId the ban ghi ID of this cap nhat ket qua
	*/
	public void setBanGhiId(long banGhiId) {
		_capNhatKetQua.setBanGhiId(banGhiId);
	}

	/**
	* Returns the hanh dong of this cap nhat ket qua.
	*
	* @return the hanh dong of this cap nhat ket qua
	*/
	public int getHanhDong() {
		return _capNhatKetQua.getHanhDong();
	}

	/**
	* Sets the hanh dong of this cap nhat ket qua.
	*
	* @param hanhDong the hanh dong of this cap nhat ket qua
	*/
	public void setHanhDong(int hanhDong) {
		_capNhatKetQua.setHanhDong(hanhDong);
	}

	/**
	* Returns the ngay tao of this cap nhat ket qua.
	*
	* @return the ngay tao of this cap nhat ket qua
	*/
	public java.util.Date getNgayTao() {
		return _capNhatKetQua.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cap nhat ket qua.
	*
	* @param ngayTao the ngay tao of this cap nhat ket qua
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_capNhatKetQua.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this cap nhat ket qua.
	*
	* @return the nguoi tao of this cap nhat ket qua
	*/
	public java.lang.String getNguoiTao() {
		return _capNhatKetQua.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cap nhat ket qua.
	*
	* @param nguoiTao the nguoi tao of this cap nhat ket qua
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_capNhatKetQua.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this cap nhat ket qua.
	*
	* @return the ngay sua of this cap nhat ket qua
	*/
	public java.util.Date getNgaySua() {
		return _capNhatKetQua.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cap nhat ket qua.
	*
	* @param ngaySua the ngay sua of this cap nhat ket qua
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_capNhatKetQua.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this cap nhat ket qua.
	*
	* @return the nguoi sua of this cap nhat ket qua
	*/
	public java.lang.String getNguoiSua() {
		return _capNhatKetQua.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cap nhat ket qua.
	*
	* @param nguoiSua the nguoi sua of this cap nhat ket qua
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_capNhatKetQua.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this cap nhat ket qua.
	*
	* @return the da xoa of this cap nhat ket qua
	*/
	public int getDaXoa() {
		return _capNhatKetQua.getDaXoa();
	}

	/**
	* Sets the da xoa of this cap nhat ket qua.
	*
	* @param daXoa the da xoa of this cap nhat ket qua
	*/
	public void setDaXoa(int daXoa) {
		_capNhatKetQua.setDaXoa(daXoa);
	}

	/**
	* Returns the hoso t t h c c ID of this cap nhat ket qua.
	*
	* @return the hoso t t h c c ID of this cap nhat ket qua
	*/
	public long getHosoTTHCCId() {
		return _capNhatKetQua.getHosoTTHCCId();
	}

	/**
	* Sets the hoso t t h c c ID of this cap nhat ket qua.
	*
	* @param hosoTTHCCId the hoso t t h c c ID of this cap nhat ket qua
	*/
	public void setHosoTTHCCId(long hosoTTHCCId) {
		_capNhatKetQua.setHosoTTHCCId(hosoTTHCCId);
	}

	public boolean isNew() {
		return _capNhatKetQua.isNew();
	}

	public void setNew(boolean n) {
		_capNhatKetQua.setNew(n);
	}

	public boolean isCachedModel() {
		return _capNhatKetQua.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_capNhatKetQua.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _capNhatKetQua.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _capNhatKetQua.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_capNhatKetQua.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _capNhatKetQua.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_capNhatKetQua.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CapNhatKetQuaWrapper((CapNhatKetQua)_capNhatKetQua.clone());
	}

	public int compareTo(org.oep.cmon.dao.dvc.model.CapNhatKetQua capNhatKetQua) {
		return _capNhatKetQua.compareTo(capNhatKetQua);
	}

	@Override
	public int hashCode() {
		return _capNhatKetQua.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.CapNhatKetQua> toCacheModel() {
		return _capNhatKetQua.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.CapNhatKetQua toEscapedModel() {
		return new CapNhatKetQuaWrapper(_capNhatKetQua.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _capNhatKetQua.toString();
	}

	public java.lang.String toXmlString() {
		return _capNhatKetQua.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_capNhatKetQua.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CapNhatKetQua getWrappedCapNhatKetQua() {
		return _capNhatKetQua;
	}

	public CapNhatKetQua getWrappedModel() {
		return _capNhatKetQua;
	}

	public void resetOriginalValues() {
		_capNhatKetQua.resetOriginalValues();
	}

	private CapNhatKetQua _capNhatKetQua;
}