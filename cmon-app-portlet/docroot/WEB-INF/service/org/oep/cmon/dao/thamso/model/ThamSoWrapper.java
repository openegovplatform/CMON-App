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

package org.oep.cmon.dao.thamso.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ThamSo}.
 * </p>
 *
 * @author    LIEMNN
 * @see       ThamSo
 * @generated
 */
public class ThamSoWrapper implements ThamSo, ModelWrapper<ThamSo> {
	public ThamSoWrapper(ThamSo thamSo) {
		_thamSo = thamSo;
	}

	public Class<?> getModelClass() {
		return ThamSo.class;
	}

	public String getModelClassName() {
		return ThamSo.class.getName();
	}

	/**
	* Returns the primary key of this tham so.
	*
	* @return the primary key of this tham so
	*/
	public long getPrimaryKey() {
		return _thamSo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tham so.
	*
	* @param primaryKey the primary key of this tham so
	*/
	public void setPrimaryKey(long primaryKey) {
		_thamSo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tham so.
	*
	* @return the ID of this tham so
	*/
	public long getId() {
		return _thamSo.getId();
	}

	/**
	* Sets the ID of this tham so.
	*
	* @param Id the ID of this tham so
	*/
	public void setId(long Id) {
		_thamSo.setId(Id);
	}

	/**
	* Returns the ten of this tham so.
	*
	* @return the ten of this tham so
	*/
	public java.lang.String getTen() {
		return _thamSo.getTen();
	}

	/**
	* Sets the ten of this tham so.
	*
	* @param Ten the ten of this tham so
	*/
	public void setTen(java.lang.String Ten) {
		_thamSo.setTen(Ten);
	}

	/**
	* Returns the gia tri of this tham so.
	*
	* @return the gia tri of this tham so
	*/
	public java.lang.String getGiaTri() {
		return _thamSo.getGiaTri();
	}

	/**
	* Sets the gia tri of this tham so.
	*
	* @param giaTri the gia tri of this tham so
	*/
	public void setGiaTri(java.lang.String giaTri) {
		_thamSo.setGiaTri(giaTri);
	}

	/**
	* Returns the kieu du lieu of this tham so.
	*
	* @return the kieu du lieu of this tham so
	*/
	public int getKieuDuLieu() {
		return _thamSo.getKieuDuLieu();
	}

	/**
	* Sets the kieu du lieu of this tham so.
	*
	* @param kieuDuLieu the kieu du lieu of this tham so
	*/
	public void setKieuDuLieu(int kieuDuLieu) {
		_thamSo.setKieuDuLieu(kieuDuLieu);
	}

	/**
	* Returns the mota of this tham so.
	*
	* @return the mota of this tham so
	*/
	public java.lang.String getMota() {
		return _thamSo.getMota();
	}

	/**
	* Sets the mota of this tham so.
	*
	* @param Mota the mota of this tham so
	*/
	public void setMota(java.lang.String Mota) {
		_thamSo.setMota(Mota);
	}

	/**
	* Returns the ung dung ID of this tham so.
	*
	* @return the ung dung ID of this tham so
	*/
	public java.lang.Long getUngDungId() {
		return _thamSo.getUngDungId();
	}

	/**
	* Sets the ung dung ID of this tham so.
	*
	* @param UngDungId the ung dung ID of this tham so
	*/
	public void setUngDungId(java.lang.Long UngDungId) {
		_thamSo.setUngDungId(UngDungId);
	}

	/**
	* Returns the he thong ID of this tham so.
	*
	* @return the he thong ID of this tham so
	*/
	public java.lang.Long getHeThongId() {
		return _thamSo.getHeThongId();
	}

	/**
	* Sets the he thong ID of this tham so.
	*
	* @param HeThongId the he thong ID of this tham so
	*/
	public void setHeThongId(java.lang.Long HeThongId) {
		_thamSo.setHeThongId(HeThongId);
	}

	/**
	* Returns the ngay tao of this tham so.
	*
	* @return the ngay tao of this tham so
	*/
	public java.util.Date getNgayTao() {
		return _thamSo.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tham so.
	*
	* @param NgayTao the ngay tao of this tham so
	*/
	public void setNgayTao(java.util.Date NgayTao) {
		_thamSo.setNgayTao(NgayTao);
	}

	/**
	* Returns the nguoi tao of this tham so.
	*
	* @return the nguoi tao of this tham so
	*/
	public java.lang.String getNguoiTao() {
		return _thamSo.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tham so.
	*
	* @param NguoiTao the nguoi tao of this tham so
	*/
	public void setNguoiTao(java.lang.String NguoiTao) {
		_thamSo.setNguoiTao(NguoiTao);
	}

	/**
	* Returns the ngay sua of this tham so.
	*
	* @return the ngay sua of this tham so
	*/
	public java.util.Date getNgaySua() {
		return _thamSo.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tham so.
	*
	* @param NgaySua the ngay sua of this tham so
	*/
	public void setNgaySua(java.util.Date NgaySua) {
		_thamSo.setNgaySua(NgaySua);
	}

	/**
	* Returns the nguoi sua of this tham so.
	*
	* @return the nguoi sua of this tham so
	*/
	public java.lang.String getNguoiSua() {
		return _thamSo.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tham so.
	*
	* @param NguoiSua the nguoi sua of this tham so
	*/
	public void setNguoiSua(java.lang.String NguoiSua) {
		_thamSo.setNguoiSua(NguoiSua);
	}

	/**
	* Returns the da xoa of this tham so.
	*
	* @return the da xoa of this tham so
	*/
	public int getDaXoa() {
		return _thamSo.getDaXoa();
	}

	/**
	* Sets the da xoa of this tham so.
	*
	* @param DaXoa the da xoa of this tham so
	*/
	public void setDaXoa(int DaXoa) {
		_thamSo.setDaXoa(DaXoa);
	}

	public boolean isNew() {
		return _thamSo.isNew();
	}

	public void setNew(boolean n) {
		_thamSo.setNew(n);
	}

	public boolean isCachedModel() {
		return _thamSo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_thamSo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _thamSo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _thamSo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_thamSo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _thamSo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_thamSo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ThamSoWrapper((ThamSo)_thamSo.clone());
	}

	public int compareTo(org.oep.cmon.dao.thamso.model.ThamSo thamSo) {
		return _thamSo.compareTo(thamSo);
	}

	@Override
	public int hashCode() {
		return _thamSo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.thamso.model.ThamSo> toCacheModel() {
		return _thamSo.toCacheModel();
	}

	public org.oep.cmon.dao.thamso.model.ThamSo toEscapedModel() {
		return new ThamSoWrapper(_thamSo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _thamSo.toString();
	}

	public java.lang.String toXmlString() {
		return _thamSo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_thamSo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ThamSo getWrappedThamSo() {
		return _thamSo;
	}

	public ThamSo getWrappedModel() {
		return _thamSo;
	}

	public void resetOriginalValues() {
		_thamSo.resetOriginalValues();
	}

	private ThamSo _thamSo;
}