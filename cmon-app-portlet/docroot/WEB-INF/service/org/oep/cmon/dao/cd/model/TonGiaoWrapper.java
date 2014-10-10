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
 * This class is a wrapper for {@link TonGiao}.
 * </p>
 *
 * @author    LIEMNN
 * @see       TonGiao
 * @generated
 */
public class TonGiaoWrapper implements TonGiao, ModelWrapper<TonGiao> {
	public TonGiaoWrapper(TonGiao tonGiao) {
		_tonGiao = tonGiao;
	}

	public Class<?> getModelClass() {
		return TonGiao.class;
	}

	public String getModelClassName() {
		return TonGiao.class.getName();
	}

	/**
	* Returns the primary key of this ton giao.
	*
	* @return the primary key of this ton giao
	*/
	public long getPrimaryKey() {
		return _tonGiao.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ton giao.
	*
	* @param primaryKey the primary key of this ton giao
	*/
	public void setPrimaryKey(long primaryKey) {
		_tonGiao.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ton giao.
	*
	* @return the ID of this ton giao
	*/
	public long getId() {
		return _tonGiao.getId();
	}

	/**
	* Sets the ID of this ton giao.
	*
	* @param id the ID of this ton giao
	*/
	public void setId(long id) {
		_tonGiao.setId(id);
	}

	/**
	* Returns the ma of this ton giao.
	*
	* @return the ma of this ton giao
	*/
	public java.lang.String getMa() {
		return _tonGiao.getMa();
	}

	/**
	* Sets the ma of this ton giao.
	*
	* @param ma the ma of this ton giao
	*/
	public void setMa(java.lang.String ma) {
		_tonGiao.setMa(ma);
	}

	/**
	* Returns the ten of this ton giao.
	*
	* @return the ten of this ton giao
	*/
	public java.lang.String getTen() {
		return _tonGiao.getTen();
	}

	/**
	* Sets the ten of this ton giao.
	*
	* @param ten the ten of this ton giao
	*/
	public void setTen(java.lang.String ten) {
		_tonGiao.setTen(ten);
	}

	/**
	* Returns the ngay tao of this ton giao.
	*
	* @return the ngay tao of this ton giao
	*/
	public java.util.Date getNgayTao() {
		return _tonGiao.getNgayTao();
	}

	/**
	* Sets the ngay tao of this ton giao.
	*
	* @param ngayTao the ngay tao of this ton giao
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_tonGiao.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this ton giao.
	*
	* @return the da xoa of this ton giao
	*/
	public int getDaXoa() {
		return _tonGiao.getDaXoa();
	}

	/**
	* Sets the da xoa of this ton giao.
	*
	* @param daXoa the da xoa of this ton giao
	*/
	public void setDaXoa(int daXoa) {
		_tonGiao.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this ton giao.
	*
	* @return the nguoi tao of this ton giao
	*/
	public java.lang.String getNguoiTao() {
		return _tonGiao.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this ton giao.
	*
	* @param nguoiTao the nguoi tao of this ton giao
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_tonGiao.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this ton giao.
	*
	* @return the nguoi sua of this ton giao
	*/
	public java.lang.String getNguoiSua() {
		return _tonGiao.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this ton giao.
	*
	* @param nguoiSua the nguoi sua of this ton giao
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_tonGiao.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this ton giao.
	*
	* @return the ngay sua of this ton giao
	*/
	public java.util.Date getNgaySua() {
		return _tonGiao.getNgaySua();
	}

	/**
	* Sets the ngay sua of this ton giao.
	*
	* @param ngaySua the ngay sua of this ton giao
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_tonGiao.setNgaySua(ngaySua);
	}

	/**
	* Returns the phien ban of this ton giao.
	*
	* @return the phien ban of this ton giao
	*/
	public long getPhienBan() {
		return _tonGiao.getPhienBan();
	}

	/**
	* Sets the phien ban of this ton giao.
	*
	* @param phienBan the phien ban of this ton giao
	*/
	public void setPhienBan(long phienBan) {
		_tonGiao.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _tonGiao.isNew();
	}

	public void setNew(boolean n) {
		_tonGiao.setNew(n);
	}

	public boolean isCachedModel() {
		return _tonGiao.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tonGiao.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tonGiao.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tonGiao.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tonGiao.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tonGiao.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tonGiao.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TonGiaoWrapper((TonGiao)_tonGiao.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.TonGiao tonGiao) {
		return _tonGiao.compareTo(tonGiao);
	}

	@Override
	public int hashCode() {
		return _tonGiao.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.TonGiao> toCacheModel() {
		return _tonGiao.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.TonGiao toEscapedModel() {
		return new TonGiaoWrapper(_tonGiao.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tonGiao.toString();
	}

	public java.lang.String toXmlString() {
		return _tonGiao.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tonGiao.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TonGiao getWrappedTonGiao() {
		return _tonGiao;
	}

	public TonGiao getWrappedModel() {
		return _tonGiao;
	}

	public void resetOriginalValues() {
		_tonGiao.resetOriginalValues();
	}

	private TonGiao _tonGiao;
}