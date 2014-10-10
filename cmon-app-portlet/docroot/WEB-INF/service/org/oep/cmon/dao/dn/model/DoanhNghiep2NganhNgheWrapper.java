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
 * This class is a wrapper for {@link DoanhNghiep2NganhNghe}.
 * </p>
 *
 * @author    Liemnn
 * @see       DoanhNghiep2NganhNghe
 * @generated
 */
public class DoanhNghiep2NganhNgheWrapper implements DoanhNghiep2NganhNghe,
	ModelWrapper<DoanhNghiep2NganhNghe> {
	public DoanhNghiep2NganhNgheWrapper(
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		_doanhNghiep2NganhNghe = doanhNghiep2NganhNghe;
	}

	public Class<?> getModelClass() {
		return DoanhNghiep2NganhNghe.class;
	}

	public String getModelClassName() {
		return DoanhNghiep2NganhNghe.class.getName();
	}

	/**
	* Returns the primary key of this doanh nghiep2 nganh nghe.
	*
	* @return the primary key of this doanh nghiep2 nganh nghe
	*/
	public long getPrimaryKey() {
		return _doanhNghiep2NganhNghe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this doanh nghiep2 nganh nghe.
	*
	* @param primaryKey the primary key of this doanh nghiep2 nganh nghe
	*/
	public void setPrimaryKey(long primaryKey) {
		_doanhNghiep2NganhNghe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this doanh nghiep2 nganh nghe.
	*
	* @return the ID of this doanh nghiep2 nganh nghe
	*/
	public long getId() {
		return _doanhNghiep2NganhNghe.getId();
	}

	/**
	* Sets the ID of this doanh nghiep2 nganh nghe.
	*
	* @param id the ID of this doanh nghiep2 nganh nghe
	*/
	public void setId(long id) {
		_doanhNghiep2NganhNghe.setId(id);
	}

	/**
	* Returns the la nganh chinh of this doanh nghiep2 nganh nghe.
	*
	* @return the la nganh chinh of this doanh nghiep2 nganh nghe
	*/
	public int getLaNganhChinh() {
		return _doanhNghiep2NganhNghe.getLaNganhChinh();
	}

	/**
	* Sets the la nganh chinh of this doanh nghiep2 nganh nghe.
	*
	* @param laNganhChinh the la nganh chinh of this doanh nghiep2 nganh nghe
	*/
	public void setLaNganhChinh(int laNganhChinh) {
		_doanhNghiep2NganhNghe.setLaNganhChinh(laNganhChinh);
	}

	/**
	* Returns the ngay tao of this doanh nghiep2 nganh nghe.
	*
	* @return the ngay tao of this doanh nghiep2 nganh nghe
	*/
	public java.util.Date getNgayTao() {
		return _doanhNghiep2NganhNghe.getNgayTao();
	}

	/**
	* Sets the ngay tao of this doanh nghiep2 nganh nghe.
	*
	* @param ngayTao the ngay tao of this doanh nghiep2 nganh nghe
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_doanhNghiep2NganhNghe.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this doanh nghiep2 nganh nghe.
	*
	* @return the ngay sua of this doanh nghiep2 nganh nghe
	*/
	public java.util.Date getNgaySua() {
		return _doanhNghiep2NganhNghe.getNgaySua();
	}

	/**
	* Sets the ngay sua of this doanh nghiep2 nganh nghe.
	*
	* @param ngaySua the ngay sua of this doanh nghiep2 nganh nghe
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_doanhNghiep2NganhNghe.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this doanh nghiep2 nganh nghe.
	*
	* @return the nguoi tao of this doanh nghiep2 nganh nghe
	*/
	public java.lang.String getNguoiTao() {
		return _doanhNghiep2NganhNghe.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this doanh nghiep2 nganh nghe.
	*
	* @param nguoiTao the nguoi tao of this doanh nghiep2 nganh nghe
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_doanhNghiep2NganhNghe.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this doanh nghiep2 nganh nghe.
	*
	* @return the nguoi sua of this doanh nghiep2 nganh nghe
	*/
	public java.lang.String getNguoiSua() {
		return _doanhNghiep2NganhNghe.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this doanh nghiep2 nganh nghe.
	*
	* @param nguoiSua the nguoi sua of this doanh nghiep2 nganh nghe
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_doanhNghiep2NganhNghe.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this doanh nghiep2 nganh nghe.
	*
	* @return the da xoa of this doanh nghiep2 nganh nghe
	*/
	public int getDaXoa() {
		return _doanhNghiep2NganhNghe.getDaXoa();
	}

	/**
	* Sets the da xoa of this doanh nghiep2 nganh nghe.
	*
	* @param daXoa the da xoa of this doanh nghiep2 nganh nghe
	*/
	public void setDaXoa(int daXoa) {
		_doanhNghiep2NganhNghe.setDaXoa(daXoa);
	}

	/**
	* Returns the doanh nghiep ID of this doanh nghiep2 nganh nghe.
	*
	* @return the doanh nghiep ID of this doanh nghiep2 nganh nghe
	*/
	public long getDoanhNghiepId() {
		return _doanhNghiep2NganhNghe.getDoanhNghiepId();
	}

	/**
	* Sets the doanh nghiep ID of this doanh nghiep2 nganh nghe.
	*
	* @param doanhNghiepId the doanh nghiep ID of this doanh nghiep2 nganh nghe
	*/
	public void setDoanhNghiepId(long doanhNghiepId) {
		_doanhNghiep2NganhNghe.setDoanhNghiepId(doanhNghiepId);
	}

	/**
	* Returns the nganh nghe ID of this doanh nghiep2 nganh nghe.
	*
	* @return the nganh nghe ID of this doanh nghiep2 nganh nghe
	*/
	public long getNganhNgheId() {
		return _doanhNghiep2NganhNghe.getNganhNgheId();
	}

	/**
	* Sets the nganh nghe ID of this doanh nghiep2 nganh nghe.
	*
	* @param nganhNgheId the nganh nghe ID of this doanh nghiep2 nganh nghe
	*/
	public void setNganhNgheId(long nganhNgheId) {
		_doanhNghiep2NganhNghe.setNganhNgheId(nganhNgheId);
	}

	public boolean isNew() {
		return _doanhNghiep2NganhNghe.isNew();
	}

	public void setNew(boolean n) {
		_doanhNghiep2NganhNghe.setNew(n);
	}

	public boolean isCachedModel() {
		return _doanhNghiep2NganhNghe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_doanhNghiep2NganhNghe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _doanhNghiep2NganhNghe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _doanhNghiep2NganhNghe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_doanhNghiep2NganhNghe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _doanhNghiep2NganhNghe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_doanhNghiep2NganhNghe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DoanhNghiep2NganhNgheWrapper((DoanhNghiep2NganhNghe)_doanhNghiep2NganhNghe.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		return _doanhNghiep2NganhNghe.compareTo(doanhNghiep2NganhNghe);
	}

	@Override
	public int hashCode() {
		return _doanhNghiep2NganhNghe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> toCacheModel() {
		return _doanhNghiep2NganhNghe.toCacheModel();
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe toEscapedModel() {
		return new DoanhNghiep2NganhNgheWrapper(_doanhNghiep2NganhNghe.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _doanhNghiep2NganhNghe.toString();
	}

	public java.lang.String toXmlString() {
		return _doanhNghiep2NganhNghe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_doanhNghiep2NganhNghe.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DoanhNghiep2NganhNghe getWrappedDoanhNghiep2NganhNghe() {
		return _doanhNghiep2NganhNghe;
	}

	public DoanhNghiep2NganhNghe getWrappedModel() {
		return _doanhNghiep2NganhNghe;
	}

	public void resetOriginalValues() {
		_doanhNghiep2NganhNghe.resetOriginalValues();
	}

	private DoanhNghiep2NganhNghe _doanhNghiep2NganhNghe;
}