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
 * This class is a wrapper for {@link CongChuc2NhomThuTuc}.
 * </p>
 *
 * @author    Liemnn
 * @see       CongChuc2NhomThuTuc
 * @generated
 */
public class CongChuc2NhomThuTucWrapper implements CongChuc2NhomThuTuc,
	ModelWrapper<CongChuc2NhomThuTuc> {
	public CongChuc2NhomThuTucWrapper(CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		_congChuc2NhomThuTuc = congChuc2NhomThuTuc;
	}

	public Class<?> getModelClass() {
		return CongChuc2NhomThuTuc.class;
	}

	public String getModelClassName() {
		return CongChuc2NhomThuTuc.class.getName();
	}

	/**
	* Returns the primary key of this cong chuc2 nhom thu tuc.
	*
	* @return the primary key of this cong chuc2 nhom thu tuc
	*/
	public long getPrimaryKey() {
		return _congChuc2NhomThuTuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cong chuc2 nhom thu tuc.
	*
	* @param primaryKey the primary key of this cong chuc2 nhom thu tuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_congChuc2NhomThuTuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cong chuc2 nhom thu tuc.
	*
	* @return the ID of this cong chuc2 nhom thu tuc
	*/
	public long getId() {
		return _congChuc2NhomThuTuc.getId();
	}

	/**
	* Sets the ID of this cong chuc2 nhom thu tuc.
	*
	* @param id the ID of this cong chuc2 nhom thu tuc
	*/
	public void setId(long id) {
		_congChuc2NhomThuTuc.setId(id);
	}

	/**
	* Returns the cong chuc ID of this cong chuc2 nhom thu tuc.
	*
	* @return the cong chuc ID of this cong chuc2 nhom thu tuc
	*/
	public long getCongChucId() {
		return _congChuc2NhomThuTuc.getCongChucId();
	}

	/**
	* Sets the cong chuc ID of this cong chuc2 nhom thu tuc.
	*
	* @param congChucId the cong chuc ID of this cong chuc2 nhom thu tuc
	*/
	public void setCongChucId(long congChucId) {
		_congChuc2NhomThuTuc.setCongChucId(congChucId);
	}

	/**
	* Returns the nhom thu tuc ID of this cong chuc2 nhom thu tuc.
	*
	* @return the nhom thu tuc ID of this cong chuc2 nhom thu tuc
	*/
	public long getNhomThuTucId() {
		return _congChuc2NhomThuTuc.getNhomThuTucId();
	}

	/**
	* Sets the nhom thu tuc ID of this cong chuc2 nhom thu tuc.
	*
	* @param nhomThuTucId the nhom thu tuc ID of this cong chuc2 nhom thu tuc
	*/
	public void setNhomThuTucId(long nhomThuTucId) {
		_congChuc2NhomThuTuc.setNhomThuTucId(nhomThuTucId);
	}

	/**
	* Returns the ngay tao of this cong chuc2 nhom thu tuc.
	*
	* @return the ngay tao of this cong chuc2 nhom thu tuc
	*/
	public java.util.Date getNgayTao() {
		return _congChuc2NhomThuTuc.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cong chuc2 nhom thu tuc.
	*
	* @param ngayTao the ngay tao of this cong chuc2 nhom thu tuc
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_congChuc2NhomThuTuc.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this cong chuc2 nhom thu tuc.
	*
	* @return the nguoi tao of this cong chuc2 nhom thu tuc
	*/
	public java.lang.String getNguoiTao() {
		return _congChuc2NhomThuTuc.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cong chuc2 nhom thu tuc.
	*
	* @param nguoiTao the nguoi tao of this cong chuc2 nhom thu tuc
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_congChuc2NhomThuTuc.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this cong chuc2 nhom thu tuc.
	*
	* @return the ngay sua of this cong chuc2 nhom thu tuc
	*/
	public java.util.Date getNgaySua() {
		return _congChuc2NhomThuTuc.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cong chuc2 nhom thu tuc.
	*
	* @param ngaySua the ngay sua of this cong chuc2 nhom thu tuc
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_congChuc2NhomThuTuc.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this cong chuc2 nhom thu tuc.
	*
	* @return the nguoi sua of this cong chuc2 nhom thu tuc
	*/
	public java.lang.String getNguoiSua() {
		return _congChuc2NhomThuTuc.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cong chuc2 nhom thu tuc.
	*
	* @param nguoiSua the nguoi sua of this cong chuc2 nhom thu tuc
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_congChuc2NhomThuTuc.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this cong chuc2 nhom thu tuc.
	*
	* @return the da xoa of this cong chuc2 nhom thu tuc
	*/
	public int getDaXoa() {
		return _congChuc2NhomThuTuc.getDaXoa();
	}

	/**
	* Sets the da xoa of this cong chuc2 nhom thu tuc.
	*
	* @param daXoa the da xoa of this cong chuc2 nhom thu tuc
	*/
	public void setDaXoa(int daXoa) {
		_congChuc2NhomThuTuc.setDaXoa(daXoa);
	}

	/**
	* Returns the duoc phep edit cong dan of this cong chuc2 nhom thu tuc.
	*
	* @return the duoc phep edit cong dan of this cong chuc2 nhom thu tuc
	*/
	public int getDuocPhepEditCongDan() {
		return _congChuc2NhomThuTuc.getDuocPhepEditCongDan();
	}

	/**
	* Sets the duoc phep edit cong dan of this cong chuc2 nhom thu tuc.
	*
	* @param duocPhepEditCongDan the duoc phep edit cong dan of this cong chuc2 nhom thu tuc
	*/
	public void setDuocPhepEditCongDan(int duocPhepEditCongDan) {
		_congChuc2NhomThuTuc.setDuocPhepEditCongDan(duocPhepEditCongDan);
	}

	public boolean isNew() {
		return _congChuc2NhomThuTuc.isNew();
	}

	public void setNew(boolean n) {
		_congChuc2NhomThuTuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _congChuc2NhomThuTuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_congChuc2NhomThuTuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _congChuc2NhomThuTuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _congChuc2NhomThuTuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_congChuc2NhomThuTuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _congChuc2NhomThuTuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_congChuc2NhomThuTuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CongChuc2NhomThuTucWrapper((CongChuc2NhomThuTuc)_congChuc2NhomThuTuc.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		return _congChuc2NhomThuTuc.compareTo(congChuc2NhomThuTuc);
	}

	@Override
	public int hashCode() {
		return _congChuc2NhomThuTuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> toCacheModel() {
		return _congChuc2NhomThuTuc.toCacheModel();
	}

	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc toEscapedModel() {
		return new CongChuc2NhomThuTucWrapper(_congChuc2NhomThuTuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _congChuc2NhomThuTuc.toString();
	}

	public java.lang.String toXmlString() {
		return _congChuc2NhomThuTuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_congChuc2NhomThuTuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CongChuc2NhomThuTuc getWrappedCongChuc2NhomThuTuc() {
		return _congChuc2NhomThuTuc;
	}

	public CongChuc2NhomThuTuc getWrappedModel() {
		return _congChuc2NhomThuTuc;
	}

	public void resetOriginalValues() {
		_congChuc2NhomThuTuc.resetOriginalValues();
	}

	private CongChuc2NhomThuTuc _congChuc2NhomThuTuc;
}