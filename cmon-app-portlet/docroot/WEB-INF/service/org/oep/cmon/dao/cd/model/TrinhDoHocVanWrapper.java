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
 * This class is a wrapper for {@link TrinhDoHocVan}.
 * </p>
 *
 * @author    LIEMNN
 * @see       TrinhDoHocVan
 * @generated
 */
public class TrinhDoHocVanWrapper implements TrinhDoHocVan,
	ModelWrapper<TrinhDoHocVan> {
	public TrinhDoHocVanWrapper(TrinhDoHocVan trinhDoHocVan) {
		_trinhDoHocVan = trinhDoHocVan;
	}

	public Class<?> getModelClass() {
		return TrinhDoHocVan.class;
	}

	public String getModelClassName() {
		return TrinhDoHocVan.class.getName();
	}

	/**
	* Returns the primary key of this trinh do hoc van.
	*
	* @return the primary key of this trinh do hoc van
	*/
	public long getPrimaryKey() {
		return _trinhDoHocVan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trinh do hoc van.
	*
	* @param primaryKey the primary key of this trinh do hoc van
	*/
	public void setPrimaryKey(long primaryKey) {
		_trinhDoHocVan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this trinh do hoc van.
	*
	* @return the ID of this trinh do hoc van
	*/
	public long getId() {
		return _trinhDoHocVan.getId();
	}

	/**
	* Sets the ID of this trinh do hoc van.
	*
	* @param id the ID of this trinh do hoc van
	*/
	public void setId(long id) {
		_trinhDoHocVan.setId(id);
	}

	/**
	* Returns the ma of this trinh do hoc van.
	*
	* @return the ma of this trinh do hoc van
	*/
	public java.lang.String getMa() {
		return _trinhDoHocVan.getMa();
	}

	/**
	* Sets the ma of this trinh do hoc van.
	*
	* @param ma the ma of this trinh do hoc van
	*/
	public void setMa(java.lang.String ma) {
		_trinhDoHocVan.setMa(ma);
	}

	/**
	* Returns the ten of this trinh do hoc van.
	*
	* @return the ten of this trinh do hoc van
	*/
	public java.lang.String getTen() {
		return _trinhDoHocVan.getTen();
	}

	/**
	* Sets the ten of this trinh do hoc van.
	*
	* @param ten the ten of this trinh do hoc van
	*/
	public void setTen(java.lang.String ten) {
		_trinhDoHocVan.setTen(ten);
	}

	/**
	* Returns the ngay tao of this trinh do hoc van.
	*
	* @return the ngay tao of this trinh do hoc van
	*/
	public java.util.Date getNgayTao() {
		return _trinhDoHocVan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this trinh do hoc van.
	*
	* @param ngayTao the ngay tao of this trinh do hoc van
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_trinhDoHocVan.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this trinh do hoc van.
	*
	* @return the da xoa of this trinh do hoc van
	*/
	public int getDaXoa() {
		return _trinhDoHocVan.getDaXoa();
	}

	/**
	* Sets the da xoa of this trinh do hoc van.
	*
	* @param daXoa the da xoa of this trinh do hoc van
	*/
	public void setDaXoa(int daXoa) {
		_trinhDoHocVan.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this trinh do hoc van.
	*
	* @return the nguoi tao of this trinh do hoc van
	*/
	public java.lang.String getNguoiTao() {
		return _trinhDoHocVan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this trinh do hoc van.
	*
	* @param nguoiTao the nguoi tao of this trinh do hoc van
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_trinhDoHocVan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this trinh do hoc van.
	*
	* @return the nguoi sua of this trinh do hoc van
	*/
	public java.lang.String getNguoiSua() {
		return _trinhDoHocVan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this trinh do hoc van.
	*
	* @param nguoiSua the nguoi sua of this trinh do hoc van
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_trinhDoHocVan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this trinh do hoc van.
	*
	* @return the ngay sua of this trinh do hoc van
	*/
	public java.util.Date getNgaySua() {
		return _trinhDoHocVan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this trinh do hoc van.
	*
	* @param ngaySua the ngay sua of this trinh do hoc van
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_trinhDoHocVan.setNgaySua(ngaySua);
	}

	/**
	* Returns the phien ban of this trinh do hoc van.
	*
	* @return the phien ban of this trinh do hoc van
	*/
	public long getPhienBan() {
		return _trinhDoHocVan.getPhienBan();
	}

	/**
	* Sets the phien ban of this trinh do hoc van.
	*
	* @param phienBan the phien ban of this trinh do hoc van
	*/
	public void setPhienBan(long phienBan) {
		_trinhDoHocVan.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _trinhDoHocVan.isNew();
	}

	public void setNew(boolean n) {
		_trinhDoHocVan.setNew(n);
	}

	public boolean isCachedModel() {
		return _trinhDoHocVan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trinhDoHocVan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trinhDoHocVan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trinhDoHocVan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trinhDoHocVan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trinhDoHocVan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trinhDoHocVan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrinhDoHocVanWrapper((TrinhDoHocVan)_trinhDoHocVan.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.TrinhDoHocVan trinhDoHocVan) {
		return _trinhDoHocVan.compareTo(trinhDoHocVan);
	}

	@Override
	public int hashCode() {
		return _trinhDoHocVan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.TrinhDoHocVan> toCacheModel() {
		return _trinhDoHocVan.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.TrinhDoHocVan toEscapedModel() {
		return new TrinhDoHocVanWrapper(_trinhDoHocVan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trinhDoHocVan.toString();
	}

	public java.lang.String toXmlString() {
		return _trinhDoHocVan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trinhDoHocVan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrinhDoHocVan getWrappedTrinhDoHocVan() {
		return _trinhDoHocVan;
	}

	public TrinhDoHocVan getWrappedModel() {
		return _trinhDoHocVan;
	}

	public void resetOriginalValues() {
		_trinhDoHocVan.resetOriginalValues();
	}

	private TrinhDoHocVan _trinhDoHocVan;
}