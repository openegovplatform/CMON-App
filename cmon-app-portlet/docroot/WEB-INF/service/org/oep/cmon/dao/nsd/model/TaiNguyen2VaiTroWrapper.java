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

package org.oep.cmon.dao.nsd.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TaiNguyen2VaiTro}.
 * </p>
 *
 * @author    Liemnn
 * @see       TaiNguyen2VaiTro
 * @generated
 */
public class TaiNguyen2VaiTroWrapper implements TaiNguyen2VaiTro,
	ModelWrapper<TaiNguyen2VaiTro> {
	public TaiNguyen2VaiTroWrapper(TaiNguyen2VaiTro taiNguyen2VaiTro) {
		_taiNguyen2VaiTro = taiNguyen2VaiTro;
	}

	public Class<?> getModelClass() {
		return TaiNguyen2VaiTro.class;
	}

	public String getModelClassName() {
		return TaiNguyen2VaiTro.class.getName();
	}

	/**
	* Returns the primary key of this tai nguyen2 vai tro.
	*
	* @return the primary key of this tai nguyen2 vai tro
	*/
	public long getPrimaryKey() {
		return _taiNguyen2VaiTro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tai nguyen2 vai tro.
	*
	* @param primaryKey the primary key of this tai nguyen2 vai tro
	*/
	public void setPrimaryKey(long primaryKey) {
		_taiNguyen2VaiTro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tai nguyen2 vai tro.
	*
	* @return the ID of this tai nguyen2 vai tro
	*/
	public long getId() {
		return _taiNguyen2VaiTro.getId();
	}

	/**
	* Sets the ID of this tai nguyen2 vai tro.
	*
	* @param id the ID of this tai nguyen2 vai tro
	*/
	public void setId(long id) {
		_taiNguyen2VaiTro.setId(id);
	}

	/**
	* Returns the tai nguyen ID of this tai nguyen2 vai tro.
	*
	* @return the tai nguyen ID of this tai nguyen2 vai tro
	*/
	public java.lang.Long getTaiNguyenId() {
		return _taiNguyen2VaiTro.getTaiNguyenId();
	}

	/**
	* Sets the tai nguyen ID of this tai nguyen2 vai tro.
	*
	* @param taiNguyenId the tai nguyen ID of this tai nguyen2 vai tro
	*/
	public void setTaiNguyenId(java.lang.Long taiNguyenId) {
		_taiNguyen2VaiTro.setTaiNguyenId(taiNguyenId);
	}

	/**
	* Returns the vai tro ID of this tai nguyen2 vai tro.
	*
	* @return the vai tro ID of this tai nguyen2 vai tro
	*/
	public java.lang.Long getVaiTroId() {
		return _taiNguyen2VaiTro.getVaiTroId();
	}

	/**
	* Sets the vai tro ID of this tai nguyen2 vai tro.
	*
	* @param vaiTroId the vai tro ID of this tai nguyen2 vai tro
	*/
	public void setVaiTroId(java.lang.Long vaiTroId) {
		_taiNguyen2VaiTro.setVaiTroId(vaiTroId);
	}

	/**
	* Returns the hanh dong of this tai nguyen2 vai tro.
	*
	* @return the hanh dong of this tai nguyen2 vai tro
	*/
	public int getHanhDong() {
		return _taiNguyen2VaiTro.getHanhDong();
	}

	/**
	* Sets the hanh dong of this tai nguyen2 vai tro.
	*
	* @param hanhDong the hanh dong of this tai nguyen2 vai tro
	*/
	public void setHanhDong(int hanhDong) {
		_taiNguyen2VaiTro.setHanhDong(hanhDong);
	}

	/**
	* Returns the ngay tao of this tai nguyen2 vai tro.
	*
	* @return the ngay tao of this tai nguyen2 vai tro
	*/
	public java.util.Date getNgayTao() {
		return _taiNguyen2VaiTro.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tai nguyen2 vai tro.
	*
	* @param ngayTao the ngay tao of this tai nguyen2 vai tro
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_taiNguyen2VaiTro.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this tai nguyen2 vai tro.
	*
	* @return the nguoi tao of this tai nguyen2 vai tro
	*/
	public java.lang.String getNguoiTao() {
		return _taiNguyen2VaiTro.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tai nguyen2 vai tro.
	*
	* @param nguoiTao the nguoi tao of this tai nguyen2 vai tro
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_taiNguyen2VaiTro.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this tai nguyen2 vai tro.
	*
	* @return the ngay sua of this tai nguyen2 vai tro
	*/
	public java.util.Date getNgaySua() {
		return _taiNguyen2VaiTro.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tai nguyen2 vai tro.
	*
	* @param ngaySua the ngay sua of this tai nguyen2 vai tro
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_taiNguyen2VaiTro.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this tai nguyen2 vai tro.
	*
	* @return the nguoi sua of this tai nguyen2 vai tro
	*/
	public java.lang.String getNguoiSua() {
		return _taiNguyen2VaiTro.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tai nguyen2 vai tro.
	*
	* @param nguoiSua the nguoi sua of this tai nguyen2 vai tro
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_taiNguyen2VaiTro.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this tai nguyen2 vai tro.
	*
	* @return the da xoa of this tai nguyen2 vai tro
	*/
	public int getDaXoa() {
		return _taiNguyen2VaiTro.getDaXoa();
	}

	/**
	* Sets the da xoa of this tai nguyen2 vai tro.
	*
	* @param daXoa the da xoa of this tai nguyen2 vai tro
	*/
	public void setDaXoa(int daXoa) {
		_taiNguyen2VaiTro.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _taiNguyen2VaiTro.isNew();
	}

	public void setNew(boolean n) {
		_taiNguyen2VaiTro.setNew(n);
	}

	public boolean isCachedModel() {
		return _taiNguyen2VaiTro.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_taiNguyen2VaiTro.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _taiNguyen2VaiTro.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _taiNguyen2VaiTro.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taiNguyen2VaiTro.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taiNguyen2VaiTro.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taiNguyen2VaiTro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaiNguyen2VaiTroWrapper((TaiNguyen2VaiTro)_taiNguyen2VaiTro.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro taiNguyen2VaiTro) {
		return _taiNguyen2VaiTro.compareTo(taiNguyen2VaiTro);
	}

	@Override
	public int hashCode() {
		return _taiNguyen2VaiTro.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro> toCacheModel() {
		return _taiNguyen2VaiTro.toCacheModel();
	}

	public org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro toEscapedModel() {
		return new TaiNguyen2VaiTroWrapper(_taiNguyen2VaiTro.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taiNguyen2VaiTro.toString();
	}

	public java.lang.String toXmlString() {
		return _taiNguyen2VaiTro.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taiNguyen2VaiTro.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TaiNguyen2VaiTro getWrappedTaiNguyen2VaiTro() {
		return _taiNguyen2VaiTro;
	}

	public TaiNguyen2VaiTro getWrappedModel() {
		return _taiNguyen2VaiTro;
	}

	public void resetOriginalValues() {
		_taiNguyen2VaiTro.resetOriginalValues();
	}

	private TaiNguyen2VaiTro _taiNguyen2VaiTro;
}