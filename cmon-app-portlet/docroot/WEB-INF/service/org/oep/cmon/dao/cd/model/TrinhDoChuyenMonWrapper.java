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
 * This class is a wrapper for {@link TrinhDoChuyenMon}.
 * </p>
 *
 * @author    LIEMNN
 * @see       TrinhDoChuyenMon
 * @generated
 */
public class TrinhDoChuyenMonWrapper implements TrinhDoChuyenMon,
	ModelWrapper<TrinhDoChuyenMon> {
	public TrinhDoChuyenMonWrapper(TrinhDoChuyenMon trinhDoChuyenMon) {
		_trinhDoChuyenMon = trinhDoChuyenMon;
	}

	public Class<?> getModelClass() {
		return TrinhDoChuyenMon.class;
	}

	public String getModelClassName() {
		return TrinhDoChuyenMon.class.getName();
	}

	/**
	* Returns the primary key of this trinh do chuyen mon.
	*
	* @return the primary key of this trinh do chuyen mon
	*/
	public long getPrimaryKey() {
		return _trinhDoChuyenMon.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trinh do chuyen mon.
	*
	* @param primaryKey the primary key of this trinh do chuyen mon
	*/
	public void setPrimaryKey(long primaryKey) {
		_trinhDoChuyenMon.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this trinh do chuyen mon.
	*
	* @return the ID of this trinh do chuyen mon
	*/
	public long getId() {
		return _trinhDoChuyenMon.getId();
	}

	/**
	* Sets the ID of this trinh do chuyen mon.
	*
	* @param id the ID of this trinh do chuyen mon
	*/
	public void setId(long id) {
		_trinhDoChuyenMon.setId(id);
	}

	/**
	* Returns the ma of this trinh do chuyen mon.
	*
	* @return the ma of this trinh do chuyen mon
	*/
	public java.lang.String getMa() {
		return _trinhDoChuyenMon.getMa();
	}

	/**
	* Sets the ma of this trinh do chuyen mon.
	*
	* @param ma the ma of this trinh do chuyen mon
	*/
	public void setMa(java.lang.String ma) {
		_trinhDoChuyenMon.setMa(ma);
	}

	/**
	* Returns the ten of this trinh do chuyen mon.
	*
	* @return the ten of this trinh do chuyen mon
	*/
	public java.lang.String getTen() {
		return _trinhDoChuyenMon.getTen();
	}

	/**
	* Sets the ten of this trinh do chuyen mon.
	*
	* @param ten the ten of this trinh do chuyen mon
	*/
	public void setTen(java.lang.String ten) {
		_trinhDoChuyenMon.setTen(ten);
	}

	/**
	* Returns the ngay tao of this trinh do chuyen mon.
	*
	* @return the ngay tao of this trinh do chuyen mon
	*/
	public java.util.Date getNgayTao() {
		return _trinhDoChuyenMon.getNgayTao();
	}

	/**
	* Sets the ngay tao of this trinh do chuyen mon.
	*
	* @param ngayTao the ngay tao of this trinh do chuyen mon
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_trinhDoChuyenMon.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this trinh do chuyen mon.
	*
	* @return the da xoa of this trinh do chuyen mon
	*/
	public int getDaXoa() {
		return _trinhDoChuyenMon.getDaXoa();
	}

	/**
	* Sets the da xoa of this trinh do chuyen mon.
	*
	* @param daXoa the da xoa of this trinh do chuyen mon
	*/
	public void setDaXoa(int daXoa) {
		_trinhDoChuyenMon.setDaXoa(daXoa);
	}

	/**
	* Returns the chuyen mon ID of this trinh do chuyen mon.
	*
	* @return the chuyen mon ID of this trinh do chuyen mon
	*/
	public int getChuyenMonId() {
		return _trinhDoChuyenMon.getChuyenMonId();
	}

	/**
	* Sets the chuyen mon ID of this trinh do chuyen mon.
	*
	* @param chuyenMonId the chuyen mon ID of this trinh do chuyen mon
	*/
	public void setChuyenMonId(int chuyenMonId) {
		_trinhDoChuyenMon.setChuyenMonId(chuyenMonId);
	}

	/**
	* Returns the nguoi tao of this trinh do chuyen mon.
	*
	* @return the nguoi tao of this trinh do chuyen mon
	*/
	public java.lang.String getNguoiTao() {
		return _trinhDoChuyenMon.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this trinh do chuyen mon.
	*
	* @param nguoiTao the nguoi tao of this trinh do chuyen mon
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_trinhDoChuyenMon.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this trinh do chuyen mon.
	*
	* @return the nguoi sua of this trinh do chuyen mon
	*/
	public java.lang.String getNguoiSua() {
		return _trinhDoChuyenMon.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this trinh do chuyen mon.
	*
	* @param nguoiSua the nguoi sua of this trinh do chuyen mon
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_trinhDoChuyenMon.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this trinh do chuyen mon.
	*
	* @return the ngay sua of this trinh do chuyen mon
	*/
	public java.util.Date getNgaySua() {
		return _trinhDoChuyenMon.getNgaySua();
	}

	/**
	* Sets the ngay sua of this trinh do chuyen mon.
	*
	* @param ngaySua the ngay sua of this trinh do chuyen mon
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_trinhDoChuyenMon.setNgaySua(ngaySua);
	}

	/**
	* Returns the phien ban of this trinh do chuyen mon.
	*
	* @return the phien ban of this trinh do chuyen mon
	*/
	public long getPhienBan() {
		return _trinhDoChuyenMon.getPhienBan();
	}

	/**
	* Sets the phien ban of this trinh do chuyen mon.
	*
	* @param phienBan the phien ban of this trinh do chuyen mon
	*/
	public void setPhienBan(long phienBan) {
		_trinhDoChuyenMon.setPhienBan(phienBan);
	}

	public boolean isNew() {
		return _trinhDoChuyenMon.isNew();
	}

	public void setNew(boolean n) {
		_trinhDoChuyenMon.setNew(n);
	}

	public boolean isCachedModel() {
		return _trinhDoChuyenMon.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trinhDoChuyenMon.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trinhDoChuyenMon.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trinhDoChuyenMon.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trinhDoChuyenMon.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trinhDoChuyenMon.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trinhDoChuyenMon.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrinhDoChuyenMonWrapper((TrinhDoChuyenMon)_trinhDoChuyenMon.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon) {
		return _trinhDoChuyenMon.compareTo(trinhDoChuyenMon);
	}

	@Override
	public int hashCode() {
		return _trinhDoChuyenMon.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> toCacheModel() {
		return _trinhDoChuyenMon.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon toEscapedModel() {
		return new TrinhDoChuyenMonWrapper(_trinhDoChuyenMon.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trinhDoChuyenMon.toString();
	}

	public java.lang.String toXmlString() {
		return _trinhDoChuyenMon.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trinhDoChuyenMon.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrinhDoChuyenMon getWrappedTrinhDoChuyenMon() {
		return _trinhDoChuyenMon;
	}

	public TrinhDoChuyenMon getWrappedModel() {
		return _trinhDoChuyenMon;
	}

	public void resetOriginalValues() {
		_trinhDoChuyenMon.resetOriginalValues();
	}

	private TrinhDoChuyenMon _trinhDoChuyenMon;
}