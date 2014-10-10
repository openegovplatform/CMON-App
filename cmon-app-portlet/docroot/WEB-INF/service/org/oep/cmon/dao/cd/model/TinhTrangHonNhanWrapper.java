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

package org.oep.cmon.dao.cd.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TinhTrangHonNhan}.
 * </p>
 *
 * @author    LIEMNN
 * @see       TinhTrangHonNhan
 * @generated
 */
public class TinhTrangHonNhanWrapper implements TinhTrangHonNhan,
	ModelWrapper<TinhTrangHonNhan> {
	public TinhTrangHonNhanWrapper(TinhTrangHonNhan tinhTrangHonNhan) {
		_tinhTrangHonNhan = tinhTrangHonNhan;
	}

	public Class<?> getModelClass() {
		return TinhTrangHonNhan.class;
	}

	public String getModelClassName() {
		return TinhTrangHonNhan.class.getName();
	}

	/**
	* Returns the primary key of this tinh trang hon nhan.
	*
	* @return the primary key of this tinh trang hon nhan
	*/
	public long getPrimaryKey() {
		return _tinhTrangHonNhan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tinh trang hon nhan.
	*
	* @param primaryKey the primary key of this tinh trang hon nhan
	*/
	public void setPrimaryKey(long primaryKey) {
		_tinhTrangHonNhan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tinh trang hon nhan.
	*
	* @return the ID of this tinh trang hon nhan
	*/
	public long getId() {
		return _tinhTrangHonNhan.getId();
	}

	/**
	* Sets the ID of this tinh trang hon nhan.
	*
	* @param id the ID of this tinh trang hon nhan
	*/
	public void setId(long id) {
		_tinhTrangHonNhan.setId(id);
	}

	/**
	* Returns the ten of this tinh trang hon nhan.
	*
	* @return the ten of this tinh trang hon nhan
	*/
	public java.lang.String getTen() {
		return _tinhTrangHonNhan.getTen();
	}

	/**
	* Sets the ten of this tinh trang hon nhan.
	*
	* @param ten the ten of this tinh trang hon nhan
	*/
	public void setTen(java.lang.String ten) {
		_tinhTrangHonNhan.setTen(ten);
	}

	/**
	* Returns the ngay tao of this tinh trang hon nhan.
	*
	* @return the ngay tao of this tinh trang hon nhan
	*/
	public java.util.Date getNgayTao() {
		return _tinhTrangHonNhan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tinh trang hon nhan.
	*
	* @param ngayTao the ngay tao of this tinh trang hon nhan
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_tinhTrangHonNhan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this tinh trang hon nhan.
	*
	* @return the ngay sua of this tinh trang hon nhan
	*/
	public java.util.Date getNgaySua() {
		return _tinhTrangHonNhan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tinh trang hon nhan.
	*
	* @param ngaySua the ngay sua of this tinh trang hon nhan
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_tinhTrangHonNhan.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this tinh trang hon nhan.
	*
	* @return the nguoi tao of this tinh trang hon nhan
	*/
	public java.lang.String getNguoiTao() {
		return _tinhTrangHonNhan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tinh trang hon nhan.
	*
	* @param nguoiTao the nguoi tao of this tinh trang hon nhan
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_tinhTrangHonNhan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the da xoa of this tinh trang hon nhan.
	*
	* @return the da xoa of this tinh trang hon nhan
	*/
	public int getDaXoa() {
		return _tinhTrangHonNhan.getDaXoa();
	}

	/**
	* Sets the da xoa of this tinh trang hon nhan.
	*
	* @param daXoa the da xoa of this tinh trang hon nhan
	*/
	public void setDaXoa(int daXoa) {
		_tinhTrangHonNhan.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi sua of this tinh trang hon nhan.
	*
	* @return the nguoi sua of this tinh trang hon nhan
	*/
	public java.lang.String getNguoiSua() {
		return _tinhTrangHonNhan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tinh trang hon nhan.
	*
	* @param nguoiSua the nguoi sua of this tinh trang hon nhan
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_tinhTrangHonNhan.setNguoiSua(nguoiSua);
	}

	public boolean isNew() {
		return _tinhTrangHonNhan.isNew();
	}

	public void setNew(boolean n) {
		_tinhTrangHonNhan.setNew(n);
	}

	public boolean isCachedModel() {
		return _tinhTrangHonNhan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tinhTrangHonNhan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tinhTrangHonNhan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tinhTrangHonNhan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tinhTrangHonNhan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tinhTrangHonNhan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tinhTrangHonNhan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TinhTrangHonNhanWrapper((TinhTrangHonNhan)_tinhTrangHonNhan.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan) {
		return _tinhTrangHonNhan.compareTo(tinhTrangHonNhan);
	}

	@Override
	public int hashCode() {
		return _tinhTrangHonNhan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> toCacheModel() {
		return _tinhTrangHonNhan.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan toEscapedModel() {
		return new TinhTrangHonNhanWrapper(_tinhTrangHonNhan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tinhTrangHonNhan.toString();
	}

	public java.lang.String toXmlString() {
		return _tinhTrangHonNhan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tinhTrangHonNhan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TinhTrangHonNhan getWrappedTinhTrangHonNhan() {
		return _tinhTrangHonNhan;
	}

	public TinhTrangHonNhan getWrappedModel() {
		return _tinhTrangHonNhan;
	}

	public void resetOriginalValues() {
		_tinhTrangHonNhan.resetOriginalValues();
	}

	private TinhTrangHonNhan _tinhTrangHonNhan;
}