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
 * This class is a wrapper for {@link DoiTuongSuDung}.
 * </p>
 *
 * @author    liemnn
 * @see       DoiTuongSuDung
 * @generated
 */
public class DoiTuongSuDungWrapper implements DoiTuongSuDung,
	ModelWrapper<DoiTuongSuDung> {
	public DoiTuongSuDungWrapper(DoiTuongSuDung doiTuongSuDung) {
		_doiTuongSuDung = doiTuongSuDung;
	}

	public Class<?> getModelClass() {
		return DoiTuongSuDung.class;
	}

	public String getModelClassName() {
		return DoiTuongSuDung.class.getName();
	}

	/**
	* Returns the primary key of this doi tuong su dung.
	*
	* @return the primary key of this doi tuong su dung
	*/
	public long getPrimaryKey() {
		return _doiTuongSuDung.getPrimaryKey();
	}

	/**
	* Sets the primary key of this doi tuong su dung.
	*
	* @param primaryKey the primary key of this doi tuong su dung
	*/
	public void setPrimaryKey(long primaryKey) {
		_doiTuongSuDung.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this doi tuong su dung.
	*
	* @return the ID of this doi tuong su dung
	*/
	public long getId() {
		return _doiTuongSuDung.getId();
	}

	/**
	* Sets the ID of this doi tuong su dung.
	*
	* @param id the ID of this doi tuong su dung
	*/
	public void setId(long id) {
		_doiTuongSuDung.setId(id);
	}

	/**
	* Returns the ten of this doi tuong su dung.
	*
	* @return the ten of this doi tuong su dung
	*/
	public java.lang.String getTen() {
		return _doiTuongSuDung.getTen();
	}

	/**
	* Sets the ten of this doi tuong su dung.
	*
	* @param ten the ten of this doi tuong su dung
	*/
	public void setTen(java.lang.String ten) {
		_doiTuongSuDung.setTen(ten);
	}

	/**
	* Returns the ma of this doi tuong su dung.
	*
	* @return the ma of this doi tuong su dung
	*/
	public java.lang.String getMa() {
		return _doiTuongSuDung.getMa();
	}

	/**
	* Sets the ma of this doi tuong su dung.
	*
	* @param ma the ma of this doi tuong su dung
	*/
	public void setMa(java.lang.String ma) {
		_doiTuongSuDung.setMa(ma);
	}

	/**
	* Returns the mota of this doi tuong su dung.
	*
	* @return the mota of this doi tuong su dung
	*/
	public java.lang.String getMota() {
		return _doiTuongSuDung.getMota();
	}

	/**
	* Sets the mota of this doi tuong su dung.
	*
	* @param mota the mota of this doi tuong su dung
	*/
	public void setMota(java.lang.String mota) {
		_doiTuongSuDung.setMota(mota);
	}

	/**
	* Returns the nguoi tao of this doi tuong su dung.
	*
	* @return the nguoi tao of this doi tuong su dung
	*/
	public java.lang.String getNguoiTao() {
		return _doiTuongSuDung.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this doi tuong su dung.
	*
	* @param nguoiTao the nguoi tao of this doi tuong su dung
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_doiTuongSuDung.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this doi tuong su dung.
	*
	* @return the ngay tao of this doi tuong su dung
	*/
	public java.util.Date getNgayTao() {
		return _doiTuongSuDung.getNgayTao();
	}

	/**
	* Sets the ngay tao of this doi tuong su dung.
	*
	* @param ngayTao the ngay tao of this doi tuong su dung
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_doiTuongSuDung.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this doi tuong su dung.
	*
	* @return the nguoi sua of this doi tuong su dung
	*/
	public java.lang.String getNguoiSua() {
		return _doiTuongSuDung.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this doi tuong su dung.
	*
	* @param nguoiSua the nguoi sua of this doi tuong su dung
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_doiTuongSuDung.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this doi tuong su dung.
	*
	* @return the ngay sua of this doi tuong su dung
	*/
	public java.util.Date getNgaySua() {
		return _doiTuongSuDung.getNgaySua();
	}

	/**
	* Sets the ngay sua of this doi tuong su dung.
	*
	* @param ngaySua the ngay sua of this doi tuong su dung
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_doiTuongSuDung.setNgaySua(ngaySua);
	}

	/**
	* Returns the trang thai of this doi tuong su dung.
	*
	* @return the trang thai of this doi tuong su dung
	*/
	public int getTrangThai() {
		return _doiTuongSuDung.getTrangThai();
	}

	/**
	* Sets the trang thai of this doi tuong su dung.
	*
	* @param trangThai the trang thai of this doi tuong su dung
	*/
	public void setTrangThai(int trangThai) {
		_doiTuongSuDung.setTrangThai(trangThai);
	}

	/**
	* Returns the da xoa of this doi tuong su dung.
	*
	* @return the da xoa of this doi tuong su dung
	*/
	public int getDaXoa() {
		return _doiTuongSuDung.getDaXoa();
	}

	/**
	* Sets the da xoa of this doi tuong su dung.
	*
	* @param daXoa the da xoa of this doi tuong su dung
	*/
	public void setDaXoa(int daXoa) {
		_doiTuongSuDung.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _doiTuongSuDung.isNew();
	}

	public void setNew(boolean n) {
		_doiTuongSuDung.setNew(n);
	}

	public boolean isCachedModel() {
		return _doiTuongSuDung.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_doiTuongSuDung.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _doiTuongSuDung.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _doiTuongSuDung.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_doiTuongSuDung.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _doiTuongSuDung.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_doiTuongSuDung.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DoiTuongSuDungWrapper((DoiTuongSuDung)_doiTuongSuDung.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung) {
		return _doiTuongSuDung.compareTo(doiTuongSuDung);
	}

	@Override
	public int hashCode() {
		return _doiTuongSuDung.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> toCacheModel() {
		return _doiTuongSuDung.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung toEscapedModel() {
		return new DoiTuongSuDungWrapper(_doiTuongSuDung.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _doiTuongSuDung.toString();
	}

	public java.lang.String toXmlString() {
		return _doiTuongSuDung.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_doiTuongSuDung.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DoiTuongSuDung getWrappedDoiTuongSuDung() {
		return _doiTuongSuDung;
	}

	public DoiTuongSuDung getWrappedModel() {
		return _doiTuongSuDung;
	}

	public void resetOriginalValues() {
		_doiTuongSuDung.resetOriginalValues();
	}

	private DoiTuongSuDung _doiTuongSuDung;
}