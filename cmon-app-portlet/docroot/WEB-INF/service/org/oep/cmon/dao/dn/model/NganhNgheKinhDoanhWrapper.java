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

package org.oep.cmon.dao.dn.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NganhNgheKinhDoanh}.
 * </p>
 *
 * @author    Liemnn
 * @see       NganhNgheKinhDoanh
 * @generated
 */
public class NganhNgheKinhDoanhWrapper implements NganhNgheKinhDoanh,
	ModelWrapper<NganhNgheKinhDoanh> {
	public NganhNgheKinhDoanhWrapper(NganhNgheKinhDoanh nganhNgheKinhDoanh) {
		_nganhNgheKinhDoanh = nganhNgheKinhDoanh;
	}

	public Class<?> getModelClass() {
		return NganhNgheKinhDoanh.class;
	}

	public String getModelClassName() {
		return NganhNgheKinhDoanh.class.getName();
	}

	/**
	* Returns the primary key of this nganh nghe kinh doanh.
	*
	* @return the primary key of this nganh nghe kinh doanh
	*/
	public long getPrimaryKey() {
		return _nganhNgheKinhDoanh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nganh nghe kinh doanh.
	*
	* @param primaryKey the primary key of this nganh nghe kinh doanh
	*/
	public void setPrimaryKey(long primaryKey) {
		_nganhNgheKinhDoanh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this nganh nghe kinh doanh.
	*
	* @return the ID of this nganh nghe kinh doanh
	*/
	public long getId() {
		return _nganhNgheKinhDoanh.getId();
	}

	/**
	* Sets the ID of this nganh nghe kinh doanh.
	*
	* @param id the ID of this nganh nghe kinh doanh
	*/
	public void setId(long id) {
		_nganhNgheKinhDoanh.setId(id);
	}

	/**
	* Returns the ma of this nganh nghe kinh doanh.
	*
	* @return the ma of this nganh nghe kinh doanh
	*/
	public java.lang.String getMa() {
		return _nganhNgheKinhDoanh.getMa();
	}

	/**
	* Sets the ma of this nganh nghe kinh doanh.
	*
	* @param ma the ma of this nganh nghe kinh doanh
	*/
	public void setMa(java.lang.String ma) {
		_nganhNgheKinhDoanh.setMa(ma);
	}

	/**
	* Returns the ten of this nganh nghe kinh doanh.
	*
	* @return the ten of this nganh nghe kinh doanh
	*/
	public java.lang.String getTen() {
		return _nganhNgheKinhDoanh.getTen();
	}

	/**
	* Sets the ten of this nganh nghe kinh doanh.
	*
	* @param ten the ten of this nganh nghe kinh doanh
	*/
	public void setTen(java.lang.String ten) {
		_nganhNgheKinhDoanh.setTen(ten);
	}

	/**
	* Returns the cha ID of this nganh nghe kinh doanh.
	*
	* @return the cha ID of this nganh nghe kinh doanh
	*/
	public long getChaId() {
		return _nganhNgheKinhDoanh.getChaId();
	}

	/**
	* Sets the cha ID of this nganh nghe kinh doanh.
	*
	* @param chaId the cha ID of this nganh nghe kinh doanh
	*/
	public void setChaId(long chaId) {
		_nganhNgheKinhDoanh.setChaId(chaId);
	}

	/**
	* Returns the ngay tao of this nganh nghe kinh doanh.
	*
	* @return the ngay tao of this nganh nghe kinh doanh
	*/
	public java.util.Date getNgayTao() {
		return _nganhNgheKinhDoanh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this nganh nghe kinh doanh.
	*
	* @param ngayTao the ngay tao of this nganh nghe kinh doanh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_nganhNgheKinhDoanh.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this nganh nghe kinh doanh.
	*
	* @return the da xoa of this nganh nghe kinh doanh
	*/
	public int getDaXoa() {
		return _nganhNgheKinhDoanh.getDaXoa();
	}

	/**
	* Sets the da xoa of this nganh nghe kinh doanh.
	*
	* @param daXoa the da xoa of this nganh nghe kinh doanh
	*/
	public void setDaXoa(int daXoa) {
		_nganhNgheKinhDoanh.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this nganh nghe kinh doanh.
	*
	* @return the nguoi tao of this nganh nghe kinh doanh
	*/
	public java.lang.String getNguoiTao() {
		return _nganhNgheKinhDoanh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this nganh nghe kinh doanh.
	*
	* @param nguoiTao the nguoi tao of this nganh nghe kinh doanh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_nganhNgheKinhDoanh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this nganh nghe kinh doanh.
	*
	* @return the nguoi sua of this nganh nghe kinh doanh
	*/
	public java.lang.String getNguoiSua() {
		return _nganhNgheKinhDoanh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this nganh nghe kinh doanh.
	*
	* @param nguoiSua the nguoi sua of this nganh nghe kinh doanh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_nganhNgheKinhDoanh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this nganh nghe kinh doanh.
	*
	* @return the ngay sua of this nganh nghe kinh doanh
	*/
	public java.util.Date getNgaySua() {
		return _nganhNgheKinhDoanh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this nganh nghe kinh doanh.
	*
	* @param ngaySua the ngay sua of this nganh nghe kinh doanh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_nganhNgheKinhDoanh.setNgaySua(ngaySua);
	}

	/**
	* Returns the cap of this nganh nghe kinh doanh.
	*
	* @return the cap of this nganh nghe kinh doanh
	*/
	public long getCap() {
		return _nganhNgheKinhDoanh.getCap();
	}

	/**
	* Sets the cap of this nganh nghe kinh doanh.
	*
	* @param cap the cap of this nganh nghe kinh doanh
	*/
	public void setCap(long cap) {
		_nganhNgheKinhDoanh.setCap(cap);
	}

	/**
	* Returns the phien ban of this nganh nghe kinh doanh.
	*
	* @return the phien ban of this nganh nghe kinh doanh
	*/
	public long getPhienBan() {
		return _nganhNgheKinhDoanh.getPhienBan();
	}

	/**
	* Sets the phien ban of this nganh nghe kinh doanh.
	*
	* @param phienBan the phien ban of this nganh nghe kinh doanh
	*/
	public void setPhienBan(long phienBan) {
		_nganhNgheKinhDoanh.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _nganhNgheKinhDoanh.isNew();
	}

	public void setNew(boolean n) {
		_nganhNgheKinhDoanh.setNew(n);
	}

	public boolean isCachedModel() {
		return _nganhNgheKinhDoanh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_nganhNgheKinhDoanh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _nganhNgheKinhDoanh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _nganhNgheKinhDoanh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nganhNgheKinhDoanh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nganhNgheKinhDoanh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nganhNgheKinhDoanh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NganhNgheKinhDoanhWrapper((NganhNgheKinhDoanh)_nganhNgheKinhDoanh.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh) {
		return _nganhNgheKinhDoanh.compareTo(nganhNgheKinhDoanh);
	}

	@Override
	public int hashCode() {
		return _nganhNgheKinhDoanh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> toCacheModel() {
		return _nganhNgheKinhDoanh.toCacheModel();
	}

	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh toEscapedModel() {
		return new NganhNgheKinhDoanhWrapper(_nganhNgheKinhDoanh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nganhNgheKinhDoanh.toString();
	}

	public java.lang.String toXmlString() {
		return _nganhNgheKinhDoanh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nganhNgheKinhDoanh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NganhNgheKinhDoanh getWrappedNganhNgheKinhDoanh() {
		return _nganhNgheKinhDoanh;
	}

	public NganhNgheKinhDoanh getWrappedModel() {
		return _nganhNgheKinhDoanh;
	}

	public void resetOriginalValues() {
		_nganhNgheKinhDoanh.resetOriginalValues();
	}

	private NganhNgheKinhDoanh _nganhNgheKinhDoanh;
}