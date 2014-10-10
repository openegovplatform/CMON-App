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
 * This class is a wrapper for {@link NguoiDung2VaiTro}.
 * </p>
 *
 * @author    Liemnn
 * @see       NguoiDung2VaiTro
 * @generated
 */
public class NguoiDung2VaiTroWrapper implements NguoiDung2VaiTro,
	ModelWrapper<NguoiDung2VaiTro> {
	public NguoiDung2VaiTroWrapper(NguoiDung2VaiTro nguoiDung2VaiTro) {
		_nguoiDung2VaiTro = nguoiDung2VaiTro;
	}

	public Class<?> getModelClass() {
		return NguoiDung2VaiTro.class;
	}

	public String getModelClassName() {
		return NguoiDung2VaiTro.class.getName();
	}

	/**
	* Returns the primary key of this nguoi dung2 vai tro.
	*
	* @return the primary key of this nguoi dung2 vai tro
	*/
	public long getPrimaryKey() {
		return _nguoiDung2VaiTro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nguoi dung2 vai tro.
	*
	* @param primaryKey the primary key of this nguoi dung2 vai tro
	*/
	public void setPrimaryKey(long primaryKey) {
		_nguoiDung2VaiTro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this nguoi dung2 vai tro.
	*
	* @return the ID of this nguoi dung2 vai tro
	*/
	public long getId() {
		return _nguoiDung2VaiTro.getId();
	}

	/**
	* Sets the ID of this nguoi dung2 vai tro.
	*
	* @param id the ID of this nguoi dung2 vai tro
	*/
	public void setId(long id) {
		_nguoiDung2VaiTro.setId(id);
	}

	/**
	* Returns the vai tro ID of this nguoi dung2 vai tro.
	*
	* @return the vai tro ID of this nguoi dung2 vai tro
	*/
	public java.lang.Long getVaiTroId() {
		return _nguoiDung2VaiTro.getVaiTroId();
	}

	/**
	* Sets the vai tro ID of this nguoi dung2 vai tro.
	*
	* @param vaiTroId the vai tro ID of this nguoi dung2 vai tro
	*/
	public void setVaiTroId(java.lang.Long vaiTroId) {
		_nguoiDung2VaiTro.setVaiTroId(vaiTroId);
	}

	/**
	* Returns the tai khoan nguoi dung ID of this nguoi dung2 vai tro.
	*
	* @return the tai khoan nguoi dung ID of this nguoi dung2 vai tro
	*/
	public java.lang.Long getTaiKhoanNguoiDungId() {
		return _nguoiDung2VaiTro.getTaiKhoanNguoiDungId();
	}

	/**
	* Sets the tai khoan nguoi dung ID of this nguoi dung2 vai tro.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID of this nguoi dung2 vai tro
	*/
	public void setTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId) {
		_nguoiDung2VaiTro.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Returns the ngay tao of this nguoi dung2 vai tro.
	*
	* @return the ngay tao of this nguoi dung2 vai tro
	*/
	public java.util.Date getNgayTao() {
		return _nguoiDung2VaiTro.getNgayTao();
	}

	/**
	* Sets the ngay tao of this nguoi dung2 vai tro.
	*
	* @param ngayTao the ngay tao of this nguoi dung2 vai tro
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_nguoiDung2VaiTro.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this nguoi dung2 vai tro.
	*
	* @return the nguoi tao of this nguoi dung2 vai tro
	*/
	public java.lang.String getNguoiTao() {
		return _nguoiDung2VaiTro.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this nguoi dung2 vai tro.
	*
	* @param nguoiTao the nguoi tao of this nguoi dung2 vai tro
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_nguoiDung2VaiTro.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the da xoa of this nguoi dung2 vai tro.
	*
	* @return the da xoa of this nguoi dung2 vai tro
	*/
	public int getDaXoa() {
		return _nguoiDung2VaiTro.getDaXoa();
	}

	/**
	* Sets the da xoa of this nguoi dung2 vai tro.
	*
	* @param daXoa the da xoa of this nguoi dung2 vai tro
	*/
	public void setDaXoa(int daXoa) {
		_nguoiDung2VaiTro.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _nguoiDung2VaiTro.isNew();
	}

	public void setNew(boolean n) {
		_nguoiDung2VaiTro.setNew(n);
	}

	public boolean isCachedModel() {
		return _nguoiDung2VaiTro.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_nguoiDung2VaiTro.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _nguoiDung2VaiTro.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _nguoiDung2VaiTro.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nguoiDung2VaiTro.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nguoiDung2VaiTro.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nguoiDung2VaiTro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NguoiDung2VaiTroWrapper((NguoiDung2VaiTro)_nguoiDung2VaiTro.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro) {
		return _nguoiDung2VaiTro.compareTo(nguoiDung2VaiTro);
	}

	@Override
	public int hashCode() {
		return _nguoiDung2VaiTro.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> toCacheModel() {
		return _nguoiDung2VaiTro.toCacheModel();
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro toEscapedModel() {
		return new NguoiDung2VaiTroWrapper(_nguoiDung2VaiTro.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nguoiDung2VaiTro.toString();
	}

	public java.lang.String toXmlString() {
		return _nguoiDung2VaiTro.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nguoiDung2VaiTro.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NguoiDung2VaiTro getWrappedNguoiDung2VaiTro() {
		return _nguoiDung2VaiTro;
	}

	public NguoiDung2VaiTro getWrappedModel() {
		return _nguoiDung2VaiTro;
	}

	public void resetOriginalValues() {
		_nguoiDung2VaiTro.resetOriginalValues();
	}

	private NguoiDung2VaiTro _nguoiDung2VaiTro;
}