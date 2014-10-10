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
 * This class is a wrapper for {@link ChucVu2VaiTro}.
 * </p>
 *
 * @author    LIEMNN
 * @see       ChucVu2VaiTro
 * @generated
 */
public class ChucVu2VaiTroWrapper implements ChucVu2VaiTro,
	ModelWrapper<ChucVu2VaiTro> {
	public ChucVu2VaiTroWrapper(ChucVu2VaiTro chucVu2VaiTro) {
		_chucVu2VaiTro = chucVu2VaiTro;
	}

	public Class<?> getModelClass() {
		return ChucVu2VaiTro.class;
	}

	public String getModelClassName() {
		return ChucVu2VaiTro.class.getName();
	}

	/**
	* Returns the primary key of this chuc vu2 vai tro.
	*
	* @return the primary key of this chuc vu2 vai tro
	*/
	public long getPrimaryKey() {
		return _chucVu2VaiTro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chuc vu2 vai tro.
	*
	* @param primaryKey the primary key of this chuc vu2 vai tro
	*/
	public void setPrimaryKey(long primaryKey) {
		_chucVu2VaiTro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this chuc vu2 vai tro.
	*
	* @return the ID of this chuc vu2 vai tro
	*/
	public long getId() {
		return _chucVu2VaiTro.getId();
	}

	/**
	* Sets the ID of this chuc vu2 vai tro.
	*
	* @param id the ID of this chuc vu2 vai tro
	*/
	public void setId(long id) {
		_chucVu2VaiTro.setId(id);
	}

	/**
	* Returns the ngay tao of this chuc vu2 vai tro.
	*
	* @return the ngay tao of this chuc vu2 vai tro
	*/
	public java.util.Date getNgayTao() {
		return _chucVu2VaiTro.getNgayTao();
	}

	/**
	* Sets the ngay tao of this chuc vu2 vai tro.
	*
	* @param ngayTao the ngay tao of this chuc vu2 vai tro
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_chucVu2VaiTro.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this chuc vu2 vai tro.
	*
	* @return the ngay sua of this chuc vu2 vai tro
	*/
	public java.util.Date getNgaySua() {
		return _chucVu2VaiTro.getNgaySua();
	}

	/**
	* Sets the ngay sua of this chuc vu2 vai tro.
	*
	* @param ngaySua the ngay sua of this chuc vu2 vai tro
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_chucVu2VaiTro.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this chuc vu2 vai tro.
	*
	* @return the da xoa of this chuc vu2 vai tro
	*/
	public int getDaXoa() {
		return _chucVu2VaiTro.getDaXoa();
	}

	/**
	* Sets the da xoa of this chuc vu2 vai tro.
	*
	* @param daXoa the da xoa of this chuc vu2 vai tro
	*/
	public void setDaXoa(int daXoa) {
		_chucVu2VaiTro.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this chuc vu2 vai tro.
	*
	* @return the nguoi tao of this chuc vu2 vai tro
	*/
	public java.lang.String getNguoiTao() {
		return _chucVu2VaiTro.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this chuc vu2 vai tro.
	*
	* @param nguoiTao the nguoi tao of this chuc vu2 vai tro
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_chucVu2VaiTro.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this chuc vu2 vai tro.
	*
	* @return the nguoi sua of this chuc vu2 vai tro
	*/
	public java.lang.String getNguoiSua() {
		return _chucVu2VaiTro.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this chuc vu2 vai tro.
	*
	* @param nguoiSua the nguoi sua of this chuc vu2 vai tro
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_chucVu2VaiTro.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the vai tro ID of this chuc vu2 vai tro.
	*
	* @return the vai tro ID of this chuc vu2 vai tro
	*/
	public java.lang.Long getVaiTroId() {
		return _chucVu2VaiTro.getVaiTroId();
	}

	/**
	* Sets the vai tro ID of this chuc vu2 vai tro.
	*
	* @param vaiTroId the vai tro ID of this chuc vu2 vai tro
	*/
	public void setVaiTroId(java.lang.Long vaiTroId) {
		_chucVu2VaiTro.setVaiTroId(vaiTroId);
	}

	/**
	* Returns the co quan quan ly ID of this chuc vu2 vai tro.
	*
	* @return the co quan quan ly ID of this chuc vu2 vai tro
	*/
	public java.lang.Long getCoQuanQuanLyId() {
		return _chucVu2VaiTro.getCoQuanQuanLyId();
	}

	/**
	* Sets the co quan quan ly ID of this chuc vu2 vai tro.
	*
	* @param coQuanQuanLyId the co quan quan ly ID of this chuc vu2 vai tro
	*/
	public void setCoQuanQuanLyId(java.lang.Long coQuanQuanLyId) {
		_chucVu2VaiTro.setCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns the chuc vu ID of this chuc vu2 vai tro.
	*
	* @return the chuc vu ID of this chuc vu2 vai tro
	*/
	public java.lang.Long getChucVuId() {
		return _chucVu2VaiTro.getChucVuId();
	}

	/**
	* Sets the chuc vu ID of this chuc vu2 vai tro.
	*
	* @param chucVuId the chuc vu ID of this chuc vu2 vai tro
	*/
	public void setChucVuId(java.lang.Long chucVuId) {
		_chucVu2VaiTro.setChucVuId(chucVuId);
	}

	public boolean isNew() {
		return _chucVu2VaiTro.isNew();
	}

	public void setNew(boolean n) {
		_chucVu2VaiTro.setNew(n);
	}

	public boolean isCachedModel() {
		return _chucVu2VaiTro.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_chucVu2VaiTro.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _chucVu2VaiTro.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _chucVu2VaiTro.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chucVu2VaiTro.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chucVu2VaiTro.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chucVu2VaiTro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChucVu2VaiTroWrapper((ChucVu2VaiTro)_chucVu2VaiTro.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro) {
		return _chucVu2VaiTro.compareTo(chucVu2VaiTro);
	}

	@Override
	public int hashCode() {
		return _chucVu2VaiTro.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> toCacheModel() {
		return _chucVu2VaiTro.toCacheModel();
	}

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro toEscapedModel() {
		return new ChucVu2VaiTroWrapper(_chucVu2VaiTro.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chucVu2VaiTro.toString();
	}

	public java.lang.String toXmlString() {
		return _chucVu2VaiTro.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chucVu2VaiTro.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ChucVu2VaiTro getWrappedChucVu2VaiTro() {
		return _chucVu2VaiTro;
	}

	public ChucVu2VaiTro getWrappedModel() {
		return _chucVu2VaiTro;
	}

	public void resetOriginalValues() {
		_chucVu2VaiTro.resetOriginalValues();
	}

	private ChucVu2VaiTro _chucVu2VaiTro;
}