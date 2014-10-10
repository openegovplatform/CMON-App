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
 * This class is a wrapper for {@link ThuTuc2GiayTo}.
 * </p>
 *
 * @author    liemnn
 * @see       ThuTuc2GiayTo
 * @generated
 */
public class ThuTuc2GiayToWrapper implements ThuTuc2GiayTo,
	ModelWrapper<ThuTuc2GiayTo> {
	public ThuTuc2GiayToWrapper(ThuTuc2GiayTo thuTuc2GiayTo) {
		_thuTuc2GiayTo = thuTuc2GiayTo;
	}

	public Class<?> getModelClass() {
		return ThuTuc2GiayTo.class;
	}

	public String getModelClassName() {
		return ThuTuc2GiayTo.class.getName();
	}

	/**
	* Returns the primary key of this thu tuc2 giay to.
	*
	* @return the primary key of this thu tuc2 giay to
	*/
	public long getPrimaryKey() {
		return _thuTuc2GiayTo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this thu tuc2 giay to.
	*
	* @param primaryKey the primary key of this thu tuc2 giay to
	*/
	public void setPrimaryKey(long primaryKey) {
		_thuTuc2GiayTo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this thu tuc2 giay to.
	*
	* @return the ID of this thu tuc2 giay to
	*/
	public long getId() {
		return _thuTuc2GiayTo.getId();
	}

	/**
	* Sets the ID of this thu tuc2 giay to.
	*
	* @param id the ID of this thu tuc2 giay to
	*/
	public void setId(long id) {
		_thuTuc2GiayTo.setId(id);
	}

	/**
	* Returns the ghi chu of this thu tuc2 giay to.
	*
	* @return the ghi chu of this thu tuc2 giay to
	*/
	public java.lang.String getGhiChu() {
		return _thuTuc2GiayTo.getGhiChu();
	}

	/**
	* Sets the ghi chu of this thu tuc2 giay to.
	*
	* @param ghiChu the ghi chu of this thu tuc2 giay to
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_thuTuc2GiayTo.setGhiChu(ghiChu);
	}

	/**
	* Returns the bat buoc of this thu tuc2 giay to.
	*
	* @return the bat buoc of this thu tuc2 giay to
	*/
	public int getBatBuoc() {
		return _thuTuc2GiayTo.getBatBuoc();
	}

	/**
	* Sets the bat buoc of this thu tuc2 giay to.
	*
	* @param batBuoc the bat buoc of this thu tuc2 giay to
	*/
	public void setBatBuoc(int batBuoc) {
		_thuTuc2GiayTo.setBatBuoc(batBuoc);
	}

	/**
	* Returns the thu tu hien thi of this thu tuc2 giay to.
	*
	* @return the thu tu hien thi of this thu tuc2 giay to
	*/
	public long getThuTuHienThi() {
		return _thuTuc2GiayTo.getThuTuHienThi();
	}

	/**
	* Sets the thu tu hien thi of this thu tuc2 giay to.
	*
	* @param thuTuHienThi the thu tu hien thi of this thu tuc2 giay to
	*/
	public void setThuTuHienThi(long thuTuHienThi) {
		_thuTuc2GiayTo.setThuTuHienThi(thuTuHienThi);
	}

	/**
	* Returns the ngay tao of this thu tuc2 giay to.
	*
	* @return the ngay tao of this thu tuc2 giay to
	*/
	public java.util.Date getNgayTao() {
		return _thuTuc2GiayTo.getNgayTao();
	}

	/**
	* Sets the ngay tao of this thu tuc2 giay to.
	*
	* @param ngayTao the ngay tao of this thu tuc2 giay to
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_thuTuc2GiayTo.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this thu tuc2 giay to.
	*
	* @return the ngay sua of this thu tuc2 giay to
	*/
	public java.util.Date getNgaySua() {
		return _thuTuc2GiayTo.getNgaySua();
	}

	/**
	* Sets the ngay sua of this thu tuc2 giay to.
	*
	* @param ngaySua the ngay sua of this thu tuc2 giay to
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_thuTuc2GiayTo.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this thu tuc2 giay to.
	*
	* @return the da xoa of this thu tuc2 giay to
	*/
	public int getDaXoa() {
		return _thuTuc2GiayTo.getDaXoa();
	}

	/**
	* Sets the da xoa of this thu tuc2 giay to.
	*
	* @param daXoa the da xoa of this thu tuc2 giay to
	*/
	public void setDaXoa(int daXoa) {
		_thuTuc2GiayTo.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this thu tuc2 giay to.
	*
	* @return the nguoi tao of this thu tuc2 giay to
	*/
	public java.lang.String getNguoiTao() {
		return _thuTuc2GiayTo.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this thu tuc2 giay to.
	*
	* @param nguoiTao the nguoi tao of this thu tuc2 giay to
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_thuTuc2GiayTo.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this thu tuc2 giay to.
	*
	* @return the nguoi sua of this thu tuc2 giay to
	*/
	public java.lang.String getNguoiSua() {
		return _thuTuc2GiayTo.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this thu tuc2 giay to.
	*
	* @param nguoiSua the nguoi sua of this thu tuc2 giay to
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_thuTuc2GiayTo.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this thu tuc2 giay to.
	*
	* @return the thu tuc hanh chinh ID of this thu tuc2 giay to
	*/
	public long getThuTucHanhChinhId() {
		return _thuTuc2GiayTo.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this thu tuc2 giay to.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this thu tuc2 giay to
	*/
	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTuc2GiayTo.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the danh muc giay to ID of this thu tuc2 giay to.
	*
	* @return the danh muc giay to ID of this thu tuc2 giay to
	*/
	public long getDanhMucGiayToId() {
		return _thuTuc2GiayTo.getDanhMucGiayToId();
	}

	/**
	* Sets the danh muc giay to ID of this thu tuc2 giay to.
	*
	* @param danhMucGiayToId the danh muc giay to ID of this thu tuc2 giay to
	*/
	public void setDanhMucGiayToId(long danhMucGiayToId) {
		_thuTuc2GiayTo.setDanhMucGiayToId(danhMucGiayToId);
	}

	/**
	* Returns the trang thai of this thu tuc2 giay to.
	*
	* @return the trang thai of this thu tuc2 giay to
	*/
	public int getTrangThai() {
		return _thuTuc2GiayTo.getTrangThai();
	}

	/**
	* Sets the trang thai of this thu tuc2 giay to.
	*
	* @param trangThai the trang thai of this thu tuc2 giay to
	*/
	public void setTrangThai(int trangThai) {
		_thuTuc2GiayTo.setTrangThai(trangThai);
	}

	/**
	* Returns the giaidoan of this thu tuc2 giay to.
	*
	* @return the giaidoan of this thu tuc2 giay to
	*/
	public int getGiaidoan() {
		return _thuTuc2GiayTo.getGiaidoan();
	}

	/**
	* Sets the giaidoan of this thu tuc2 giay to.
	*
	* @param giaidoan the giaidoan of this thu tuc2 giay to
	*/
	public void setGiaidoan(int giaidoan) {
		_thuTuc2GiayTo.setGiaidoan(giaidoan);
	}

	public boolean isNew() {
		return _thuTuc2GiayTo.isNew();
	}

	public void setNew(boolean n) {
		_thuTuc2GiayTo.setNew(n);
	}

	public boolean isCachedModel() {
		return _thuTuc2GiayTo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_thuTuc2GiayTo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _thuTuc2GiayTo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _thuTuc2GiayTo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_thuTuc2GiayTo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _thuTuc2GiayTo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_thuTuc2GiayTo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ThuTuc2GiayToWrapper((ThuTuc2GiayTo)_thuTuc2GiayTo.clone());
	}

	public int compareTo(org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo) {
		return _thuTuc2GiayTo.compareTo(thuTuc2GiayTo);
	}

	@Override
	public int hashCode() {
		return _thuTuc2GiayTo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> toCacheModel() {
		return _thuTuc2GiayTo.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo toEscapedModel() {
		return new ThuTuc2GiayToWrapper(_thuTuc2GiayTo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _thuTuc2GiayTo.toString();
	}

	public java.lang.String toXmlString() {
		return _thuTuc2GiayTo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_thuTuc2GiayTo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ThuTuc2GiayTo getWrappedThuTuc2GiayTo() {
		return _thuTuc2GiayTo;
	}

	public ThuTuc2GiayTo getWrappedModel() {
		return _thuTuc2GiayTo;
	}

	public void resetOriginalValues() {
		_thuTuc2GiayTo.resetOriginalValues();
	}

	private ThuTuc2GiayTo _thuTuc2GiayTo;
}