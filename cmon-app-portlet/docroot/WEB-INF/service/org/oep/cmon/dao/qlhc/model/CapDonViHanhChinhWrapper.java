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

package org.oep.cmon.dao.qlhc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CapDonViHanhChinh}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CapDonViHanhChinh
 * @generated
 */
public class CapDonViHanhChinhWrapper implements CapDonViHanhChinh,
	ModelWrapper<CapDonViHanhChinh> {
	public CapDonViHanhChinhWrapper(CapDonViHanhChinh capDonViHanhChinh) {
		_capDonViHanhChinh = capDonViHanhChinh;
	}

	public Class<?> getModelClass() {
		return CapDonViHanhChinh.class;
	}

	public String getModelClassName() {
		return CapDonViHanhChinh.class.getName();
	}

	/**
	* Returns the primary key of this cap don vi hanh chinh.
	*
	* @return the primary key of this cap don vi hanh chinh
	*/
	public long getPrimaryKey() {
		return _capDonViHanhChinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cap don vi hanh chinh.
	*
	* @param primaryKey the primary key of this cap don vi hanh chinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_capDonViHanhChinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cap don vi hanh chinh.
	*
	* @return the ID of this cap don vi hanh chinh
	*/
	public long getId() {
		return _capDonViHanhChinh.getId();
	}

	/**
	* Sets the ID of this cap don vi hanh chinh.
	*
	* @param id the ID of this cap don vi hanh chinh
	*/
	public void setId(long id) {
		_capDonViHanhChinh.setId(id);
	}

	/**
	* Returns the ma of this cap don vi hanh chinh.
	*
	* @return the ma of this cap don vi hanh chinh
	*/
	public java.lang.String getMa() {
		return _capDonViHanhChinh.getMa();
	}

	/**
	* Sets the ma of this cap don vi hanh chinh.
	*
	* @param ma the ma of this cap don vi hanh chinh
	*/
	public void setMa(java.lang.String ma) {
		_capDonViHanhChinh.setMa(ma);
	}

	/**
	* Returns the ten of this cap don vi hanh chinh.
	*
	* @return the ten of this cap don vi hanh chinh
	*/
	public java.lang.String getTen() {
		return _capDonViHanhChinh.getTen();
	}

	/**
	* Sets the ten of this cap don vi hanh chinh.
	*
	* @param ten the ten of this cap don vi hanh chinh
	*/
	public void setTen(java.lang.String ten) {
		_capDonViHanhChinh.setTen(ten);
	}

	/**
	* Returns the cap of this cap don vi hanh chinh.
	*
	* @return the cap of this cap don vi hanh chinh
	*/
	public long getCap() {
		return _capDonViHanhChinh.getCap();
	}

	/**
	* Sets the cap of this cap don vi hanh chinh.
	*
	* @param cap the cap of this cap don vi hanh chinh
	*/
	public void setCap(long cap) {
		_capDonViHanhChinh.setCap(cap);
	}

	/**
	* Returns the phien ban of this cap don vi hanh chinh.
	*
	* @return the phien ban of this cap don vi hanh chinh
	*/
	public long getPhienBan() {
		return _capDonViHanhChinh.getPhienBan();
	}

	/**
	* Sets the phien ban of this cap don vi hanh chinh.
	*
	* @param phienBan the phien ban of this cap don vi hanh chinh
	*/
	public void setPhienBan(long phienBan) {
		_capDonViHanhChinh.setPhienBan(phienBan);
	}

	/**
	* Returns the ngay tao of this cap don vi hanh chinh.
	*
	* @return the ngay tao of this cap don vi hanh chinh
	*/
	public java.util.Date getNgayTao() {
		return _capDonViHanhChinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cap don vi hanh chinh.
	*
	* @param ngayTao the ngay tao of this cap don vi hanh chinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_capDonViHanhChinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this cap don vi hanh chinh.
	*
	* @return the ngay sua of this cap don vi hanh chinh
	*/
	public java.util.Date getNgaySua() {
		return _capDonViHanhChinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cap don vi hanh chinh.
	*
	* @param ngaySua the ngay sua of this cap don vi hanh chinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_capDonViHanhChinh.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this cap don vi hanh chinh.
	*
	* @return the da xoa of this cap don vi hanh chinh
	*/
	public int getDaXoa() {
		return _capDonViHanhChinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this cap don vi hanh chinh.
	*
	* @param daXoa the da xoa of this cap don vi hanh chinh
	*/
	public void setDaXoa(int daXoa) {
		_capDonViHanhChinh.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this cap don vi hanh chinh.
	*
	* @return the nguoi tao of this cap don vi hanh chinh
	*/
	public java.lang.String getNguoiTao() {
		return _capDonViHanhChinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cap don vi hanh chinh.
	*
	* @param nguoiTao the nguoi tao of this cap don vi hanh chinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_capDonViHanhChinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this cap don vi hanh chinh.
	*
	* @return the nguoi sua of this cap don vi hanh chinh
	*/
	public java.lang.String getNguoiSua() {
		return _capDonViHanhChinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cap don vi hanh chinh.
	*
	* @param nguoiSua the nguoi sua of this cap don vi hanh chinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_capDonViHanhChinh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the mota of this cap don vi hanh chinh.
	*
	* @return the mota of this cap don vi hanh chinh
	*/
	public java.lang.String getMota() {
		return _capDonViHanhChinh.getMota();
	}

	/**
	* Sets the mota of this cap don vi hanh chinh.
	*
	* @param mota the mota of this cap don vi hanh chinh
	*/
	public void setMota(java.lang.String mota) {
		_capDonViHanhChinh.setMota(mota);
	}

	public boolean isNew() {
		return _capDonViHanhChinh.isNew();
	}

	public void setNew(boolean n) {
		_capDonViHanhChinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _capDonViHanhChinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_capDonViHanhChinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _capDonViHanhChinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _capDonViHanhChinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_capDonViHanhChinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _capDonViHanhChinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_capDonViHanhChinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CapDonViHanhChinhWrapper((CapDonViHanhChinh)_capDonViHanhChinh.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh capDonViHanhChinh) {
		return _capDonViHanhChinh.compareTo(capDonViHanhChinh);
	}

	@Override
	public int hashCode() {
		return _capDonViHanhChinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> toCacheModel() {
		return _capDonViHanhChinh.toCacheModel();
	}

	public org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh toEscapedModel() {
		return new CapDonViHanhChinhWrapper(_capDonViHanhChinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _capDonViHanhChinh.toString();
	}

	public java.lang.String toXmlString() {
		return _capDonViHanhChinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_capDonViHanhChinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CapDonViHanhChinh getWrappedCapDonViHanhChinh() {
		return _capDonViHanhChinh;
	}

	public CapDonViHanhChinh getWrappedModel() {
		return _capDonViHanhChinh;
	}

	public void resetOriginalValues() {
		_capDonViHanhChinh.resetOriginalValues();
	}

	private CapDonViHanhChinh _capDonViHanhChinh;
}