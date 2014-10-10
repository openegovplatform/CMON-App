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
 * This class is a wrapper for {@link DonViHanhChinh}.
 * </p>
 *
 * @author    LIEMNN
 * @see       DonViHanhChinh
 * @generated
 */
public class DonViHanhChinhWrapper implements DonViHanhChinh,
	ModelWrapper<DonViHanhChinh> {
	public DonViHanhChinhWrapper(DonViHanhChinh donViHanhChinh) {
		_donViHanhChinh = donViHanhChinh;
	}

	public Class<?> getModelClass() {
		return DonViHanhChinh.class;
	}

	public String getModelClassName() {
		return DonViHanhChinh.class.getName();
	}

	/**
	* Returns the primary key of this don vi hanh chinh.
	*
	* @return the primary key of this don vi hanh chinh
	*/
	public long getPrimaryKey() {
		return _donViHanhChinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this don vi hanh chinh.
	*
	* @param primaryKey the primary key of this don vi hanh chinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_donViHanhChinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this don vi hanh chinh.
	*
	* @return the ID of this don vi hanh chinh
	*/
	public long getId() {
		return _donViHanhChinh.getId();
	}

	/**
	* Sets the ID of this don vi hanh chinh.
	*
	* @param id the ID of this don vi hanh chinh
	*/
	public void setId(long id) {
		_donViHanhChinh.setId(id);
	}

	/**
	* Returns the ma of this don vi hanh chinh.
	*
	* @return the ma of this don vi hanh chinh
	*/
	public java.lang.String getMa() {
		return _donViHanhChinh.getMa();
	}

	/**
	* Sets the ma of this don vi hanh chinh.
	*
	* @param ma the ma of this don vi hanh chinh
	*/
	public void setMa(java.lang.String ma) {
		_donViHanhChinh.setMa(ma);
	}

	/**
	* Returns the ten of this don vi hanh chinh.
	*
	* @return the ten of this don vi hanh chinh
	*/
	public java.lang.String getTen() {
		return _donViHanhChinh.getTen();
	}

	/**
	* Sets the ten of this don vi hanh chinh.
	*
	* @param ten the ten of this don vi hanh chinh
	*/
	public void setTen(java.lang.String ten) {
		_donViHanhChinh.setTen(ten);
	}

	/**
	* Returns the ngay tao of this don vi hanh chinh.
	*
	* @return the ngay tao of this don vi hanh chinh
	*/
	public java.util.Date getNgayTao() {
		return _donViHanhChinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this don vi hanh chinh.
	*
	* @param ngayTao the ngay tao of this don vi hanh chinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_donViHanhChinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the phien ban of this don vi hanh chinh.
	*
	* @return the phien ban of this don vi hanh chinh
	*/
	public long getPhienBan() {
		return _donViHanhChinh.getPhienBan();
	}

	/**
	* Sets the phien ban of this don vi hanh chinh.
	*
	* @param phienBan the phien ban of this don vi hanh chinh
	*/
	public void setPhienBan(long phienBan) {
		_donViHanhChinh.setPhienBan(phienBan);
	}

	/**
	* Returns the da xoa of this don vi hanh chinh.
	*
	* @return the da xoa of this don vi hanh chinh
	*/
	public int getDaXoa() {
		return _donViHanhChinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this don vi hanh chinh.
	*
	* @param daXoa the da xoa of this don vi hanh chinh
	*/
	public void setDaXoa(int daXoa) {
		_donViHanhChinh.setDaXoa(daXoa);
	}

	/**
	* Returns the ngay sua of this don vi hanh chinh.
	*
	* @return the ngay sua of this don vi hanh chinh
	*/
	public java.util.Date getNgaySua() {
		return _donViHanhChinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this don vi hanh chinh.
	*
	* @param ngaySua the ngay sua of this don vi hanh chinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_donViHanhChinh.setNgaySua(ngaySua);
	}

	/**
	* Returns the cap don vi hanh chinh ID of this don vi hanh chinh.
	*
	* @return the cap don vi hanh chinh ID of this don vi hanh chinh
	*/
	public long getCapDonViHanhChinhId() {
		return _donViHanhChinh.getCapDonViHanhChinhId();
	}

	/**
	* Sets the cap don vi hanh chinh ID of this don vi hanh chinh.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID of this don vi hanh chinh
	*/
	public void setCapDonViHanhChinhId(long capDonViHanhChinhId) {
		_donViHanhChinh.setCapDonViHanhChinhId(capDonViHanhChinhId);
	}

	/**
	* Returns the cha ID of this don vi hanh chinh.
	*
	* @return the cha ID of this don vi hanh chinh
	*/
	public java.lang.Long getChaId() {
		return _donViHanhChinh.getChaId();
	}

	/**
	* Sets the cha ID of this don vi hanh chinh.
	*
	* @param chaId the cha ID of this don vi hanh chinh
	*/
	public void setChaId(java.lang.Long chaId) {
		_donViHanhChinh.setChaId(chaId);
	}

	/**
	* Returns the nguoi tao of this don vi hanh chinh.
	*
	* @return the nguoi tao of this don vi hanh chinh
	*/
	public java.lang.String getNguoiTao() {
		return _donViHanhChinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this don vi hanh chinh.
	*
	* @param nguoiTao the nguoi tao of this don vi hanh chinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_donViHanhChinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the quoc gia ID of this don vi hanh chinh.
	*
	* @return the quoc gia ID of this don vi hanh chinh
	*/
	public long getQuocGiaId() {
		return _donViHanhChinh.getQuocGiaId();
	}

	/**
	* Sets the quoc gia ID of this don vi hanh chinh.
	*
	* @param quocGiaId the quoc gia ID of this don vi hanh chinh
	*/
	public void setQuocGiaId(long quocGiaId) {
		_donViHanhChinh.setQuocGiaId(quocGiaId);
	}

	/**
	* Returns the nguoi sua of this don vi hanh chinh.
	*
	* @return the nguoi sua of this don vi hanh chinh
	*/
	public java.lang.String getNguoiSua() {
		return _donViHanhChinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this don vi hanh chinh.
	*
	* @param nguoiSua the nguoi sua of this don vi hanh chinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_donViHanhChinh.setNguoiSua(nguoiSua);
	}

	public boolean isNew() {
		return _donViHanhChinh.isNew();
	}

	public void setNew(boolean n) {
		_donViHanhChinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _donViHanhChinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_donViHanhChinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _donViHanhChinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _donViHanhChinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_donViHanhChinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _donViHanhChinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_donViHanhChinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DonViHanhChinhWrapper((DonViHanhChinh)_donViHanhChinh.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh) {
		return _donViHanhChinh.compareTo(donViHanhChinh);
	}

	@Override
	public int hashCode() {
		return _donViHanhChinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> toCacheModel() {
		return _donViHanhChinh.toCacheModel();
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh toEscapedModel() {
		return new DonViHanhChinhWrapper(_donViHanhChinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _donViHanhChinh.toString();
	}

	public java.lang.String toXmlString() {
		return _donViHanhChinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_donViHanhChinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DonViHanhChinh getWrappedDonViHanhChinh() {
		return _donViHanhChinh;
	}

	public DonViHanhChinh getWrappedModel() {
		return _donViHanhChinh;
	}

	public void resetOriginalValues() {
		_donViHanhChinh.resetOriginalValues();
	}

	private DonViHanhChinh _donViHanhChinh;
}