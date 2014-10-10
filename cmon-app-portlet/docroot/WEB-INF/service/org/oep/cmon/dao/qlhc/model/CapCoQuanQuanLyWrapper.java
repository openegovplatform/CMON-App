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
 * This class is a wrapper for {@link CapCoQuanQuanLy}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CapCoQuanQuanLy
 * @generated
 */
public class CapCoQuanQuanLyWrapper implements CapCoQuanQuanLy,
	ModelWrapper<CapCoQuanQuanLy> {
	public CapCoQuanQuanLyWrapper(CapCoQuanQuanLy capCoQuanQuanLy) {
		_capCoQuanQuanLy = capCoQuanQuanLy;
	}

	public Class<?> getModelClass() {
		return CapCoQuanQuanLy.class;
	}

	public String getModelClassName() {
		return CapCoQuanQuanLy.class.getName();
	}

	/**
	* Returns the primary key of this cap co quan quan ly.
	*
	* @return the primary key of this cap co quan quan ly
	*/
	public long getPrimaryKey() {
		return _capCoQuanQuanLy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cap co quan quan ly.
	*
	* @param primaryKey the primary key of this cap co quan quan ly
	*/
	public void setPrimaryKey(long primaryKey) {
		_capCoQuanQuanLy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cap co quan quan ly.
	*
	* @return the ID of this cap co quan quan ly
	*/
	public long getId() {
		return _capCoQuanQuanLy.getId();
	}

	/**
	* Sets the ID of this cap co quan quan ly.
	*
	* @param id the ID of this cap co quan quan ly
	*/
	public void setId(long id) {
		_capCoQuanQuanLy.setId(id);
	}

	/**
	* Returns the ma of this cap co quan quan ly.
	*
	* @return the ma of this cap co quan quan ly
	*/
	public java.lang.String getMa() {
		return _capCoQuanQuanLy.getMa();
	}

	/**
	* Sets the ma of this cap co quan quan ly.
	*
	* @param ma the ma of this cap co quan quan ly
	*/
	public void setMa(java.lang.String ma) {
		_capCoQuanQuanLy.setMa(ma);
	}

	/**
	* Returns the ten of this cap co quan quan ly.
	*
	* @return the ten of this cap co quan quan ly
	*/
	public java.lang.String getTen() {
		return _capCoQuanQuanLy.getTen();
	}

	/**
	* Sets the ten of this cap co quan quan ly.
	*
	* @param ten the ten of this cap co quan quan ly
	*/
	public void setTen(java.lang.String ten) {
		_capCoQuanQuanLy.setTen(ten);
	}

	/**
	* Returns the cap of this cap co quan quan ly.
	*
	* @return the cap of this cap co quan quan ly
	*/
	public long getCap() {
		return _capCoQuanQuanLy.getCap();
	}

	/**
	* Sets the cap of this cap co quan quan ly.
	*
	* @param cap the cap of this cap co quan quan ly
	*/
	public void setCap(long cap) {
		_capCoQuanQuanLy.setCap(cap);
	}

	/**
	* Returns the cha ID of this cap co quan quan ly.
	*
	* @return the cha ID of this cap co quan quan ly
	*/
	public java.lang.Long getChaId() {
		return _capCoQuanQuanLy.getChaId();
	}

	/**
	* Sets the cha ID of this cap co quan quan ly.
	*
	* @param chaId the cha ID of this cap co quan quan ly
	*/
	public void setChaId(java.lang.Long chaId) {
		_capCoQuanQuanLy.setChaId(chaId);
	}

	/**
	* Returns the ngay tao of this cap co quan quan ly.
	*
	* @return the ngay tao of this cap co quan quan ly
	*/
	public java.util.Date getNgayTao() {
		return _capCoQuanQuanLy.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cap co quan quan ly.
	*
	* @param ngayTao the ngay tao of this cap co quan quan ly
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_capCoQuanQuanLy.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this cap co quan quan ly.
	*
	* @return the ngay sua of this cap co quan quan ly
	*/
	public java.util.Date getNgaySua() {
		return _capCoQuanQuanLy.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cap co quan quan ly.
	*
	* @param ngaySua the ngay sua of this cap co quan quan ly
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_capCoQuanQuanLy.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this cap co quan quan ly.
	*
	* @return the da xoa of this cap co quan quan ly
	*/
	public int getDaXoa() {
		return _capCoQuanQuanLy.getDaXoa();
	}

	/**
	* Sets the da xoa of this cap co quan quan ly.
	*
	* @param daXoa the da xoa of this cap co quan quan ly
	*/
	public void setDaXoa(int daXoa) {
		_capCoQuanQuanLy.setDaXoa(daXoa);
	}

	/**
	* Returns the phien ban of this cap co quan quan ly.
	*
	* @return the phien ban of this cap co quan quan ly
	*/
	public int getPhienBan() {
		return _capCoQuanQuanLy.getPhienBan();
	}

	/**
	* Sets the phien ban of this cap co quan quan ly.
	*
	* @param phienBan the phien ban of this cap co quan quan ly
	*/
	public void setPhienBan(int phienBan) {
		_capCoQuanQuanLy.setPhienBan(phienBan);
	}

	/**
	* Returns the nguoi tao of this cap co quan quan ly.
	*
	* @return the nguoi tao of this cap co quan quan ly
	*/
	public java.lang.String getNguoiTao() {
		return _capCoQuanQuanLy.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cap co quan quan ly.
	*
	* @param nguoiTao the nguoi tao of this cap co quan quan ly
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_capCoQuanQuanLy.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this cap co quan quan ly.
	*
	* @return the nguoi sua of this cap co quan quan ly
	*/
	public java.lang.String getNguoiSua() {
		return _capCoQuanQuanLy.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cap co quan quan ly.
	*
	* @param nguoiSua the nguoi sua of this cap co quan quan ly
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_capCoQuanQuanLy.setNguoiSua(nguoiSua);
	}

	public boolean isNew() {
		return _capCoQuanQuanLy.isNew();
	}

	public void setNew(boolean n) {
		_capCoQuanQuanLy.setNew(n);
	}

	public boolean isCachedModel() {
		return _capCoQuanQuanLy.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_capCoQuanQuanLy.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _capCoQuanQuanLy.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _capCoQuanQuanLy.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_capCoQuanQuanLy.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _capCoQuanQuanLy.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_capCoQuanQuanLy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CapCoQuanQuanLyWrapper((CapCoQuanQuanLy)_capCoQuanQuanLy.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy) {
		return _capCoQuanQuanLy.compareTo(capCoQuanQuanLy);
	}

	@Override
	public int hashCode() {
		return _capCoQuanQuanLy.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> toCacheModel() {
		return _capCoQuanQuanLy.toCacheModel();
	}

	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy toEscapedModel() {
		return new CapCoQuanQuanLyWrapper(_capCoQuanQuanLy.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _capCoQuanQuanLy.toString();
	}

	public java.lang.String toXmlString() {
		return _capCoQuanQuanLy.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_capCoQuanQuanLy.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CapCoQuanQuanLy getWrappedCapCoQuanQuanLy() {
		return _capCoQuanQuanLy;
	}

	public CapCoQuanQuanLy getWrappedModel() {
		return _capCoQuanQuanLy;
	}

	public void resetOriginalValues() {
		_capCoQuanQuanLy.resetOriginalValues();
	}

	private CapCoQuanQuanLy _capCoQuanQuanLy;
}