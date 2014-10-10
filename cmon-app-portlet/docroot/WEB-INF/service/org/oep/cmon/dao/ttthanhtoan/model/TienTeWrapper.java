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

package org.oep.cmon.dao.ttthanhtoan.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TienTe}.
 * </p>
 *
 * @author    Thanhdd
 * @see       TienTe
 * @generated
 */
public class TienTeWrapper implements TienTe, ModelWrapper<TienTe> {
	public TienTeWrapper(TienTe tienTe) {
		_tienTe = tienTe;
	}

	public Class<?> getModelClass() {
		return TienTe.class;
	}

	public String getModelClassName() {
		return TienTe.class.getName();
	}

	/**
	* Returns the primary key of this tien te.
	*
	* @return the primary key of this tien te
	*/
	public long getPrimaryKey() {
		return _tienTe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tien te.
	*
	* @param primaryKey the primary key of this tien te
	*/
	public void setPrimaryKey(long primaryKey) {
		_tienTe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tien te.
	*
	* @return the ID of this tien te
	*/
	public long getId() {
		return _tienTe.getId();
	}

	/**
	* Sets the ID of this tien te.
	*
	* @param id the ID of this tien te
	*/
	public void setId(long id) {
		_tienTe.setId(id);
	}

	/**
	* Returns the ma of this tien te.
	*
	* @return the ma of this tien te
	*/
	public java.lang.String getMa() {
		return _tienTe.getMa();
	}

	/**
	* Sets the ma of this tien te.
	*
	* @param ma the ma of this tien te
	*/
	public void setMa(java.lang.String ma) {
		_tienTe.setMa(ma);
	}

	/**
	* Returns the ten of this tien te.
	*
	* @return the ten of this tien te
	*/
	public java.lang.String getTen() {
		return _tienTe.getTen();
	}

	/**
	* Sets the ten of this tien te.
	*
	* @param ten the ten of this tien te
	*/
	public void setTen(java.lang.String ten) {
		_tienTe.setTen(ten);
	}

	/**
	* Returns the ty gia of this tien te.
	*
	* @return the ty gia of this tien te
	*/
	public long getTyGia() {
		return _tienTe.getTyGia();
	}

	/**
	* Sets the ty gia of this tien te.
	*
	* @param tyGia the ty gia of this tien te
	*/
	public void setTyGia(long tyGia) {
		_tienTe.setTyGia(tyGia);
	}

	/**
	* Returns the ngay tao of this tien te.
	*
	* @return the ngay tao of this tien te
	*/
	public java.util.Date getNgayTao() {
		return _tienTe.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tien te.
	*
	* @param ngayTao the ngay tao of this tien te
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_tienTe.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this tien te.
	*
	* @return the nguoi tao of this tien te
	*/
	public java.lang.String getNguoiTao() {
		return _tienTe.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tien te.
	*
	* @param nguoiTao the nguoi tao of this tien te
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_tienTe.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this tien te.
	*
	* @return the ngay sua of this tien te
	*/
	public java.util.Date getNgaySua() {
		return _tienTe.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tien te.
	*
	* @param ngaySua the ngay sua of this tien te
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_tienTe.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this tien te.
	*
	* @return the nguoi sua of this tien te
	*/
	public java.lang.String getNguoiSua() {
		return _tienTe.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tien te.
	*
	* @param nguoiSua the nguoi sua of this tien te
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_tienTe.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the trang thai of this tien te.
	*
	* @return the trang thai of this tien te
	*/
	public int getTrangThai() {
		return _tienTe.getTrangThai();
	}

	/**
	* Sets the trang thai of this tien te.
	*
	* @param trangThai the trang thai of this tien te
	*/
	public void setTrangThai(int trangThai) {
		_tienTe.setTrangThai(trangThai);
	}

	/**
	* Returns the phien ban of this tien te.
	*
	* @return the phien ban of this tien te
	*/
	public int getPhienBan() {
		return _tienTe.getPhienBan();
	}

	/**
	* Sets the phien ban of this tien te.
	*
	* @param phienBan the phien ban of this tien te
	*/
	public void setPhienBan(int phienBan) {
		_tienTe.setPhienBan(phienBan);
	}

	/**
	* Returns the da xoa of this tien te.
	*
	* @return the da xoa of this tien te
	*/
	public int getDaXoa() {
		return _tienTe.getDaXoa();
	}

	/**
	* Sets the da xoa of this tien te.
	*
	* @param daXoa the da xoa of this tien te
	*/
	public void setDaXoa(int daXoa) {
		_tienTe.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _tienTe.isNew();
	}

	public void setNew(boolean n) {
		_tienTe.setNew(n);
	}

	public boolean isCachedModel() {
		return _tienTe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tienTe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tienTe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tienTe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tienTe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tienTe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tienTe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TienTeWrapper((TienTe)_tienTe.clone());
	}

	public int compareTo(org.oep.cmon.dao.ttthanhtoan.model.TienTe tienTe) {
		return _tienTe.compareTo(tienTe);
	}

	@Override
	public int hashCode() {
		return _tienTe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.ttthanhtoan.model.TienTe> toCacheModel() {
		return _tienTe.toCacheModel();
	}

	public org.oep.cmon.dao.ttthanhtoan.model.TienTe toEscapedModel() {
		return new TienTeWrapper(_tienTe.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tienTe.toString();
	}

	public java.lang.String toXmlString() {
		return _tienTe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tienTe.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TienTe getWrappedTienTe() {
		return _tienTe;
	}

	public TienTe getWrappedModel() {
		return _tienTe;
	}

	public void resetOriginalValues() {
		_tienTe.resetOriginalValues();
	}

	private TienTe _tienTe;
}