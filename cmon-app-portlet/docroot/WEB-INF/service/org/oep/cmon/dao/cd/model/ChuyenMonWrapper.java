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
 * This class is a wrapper for {@link ChuyenMon}.
 * </p>
 *
 * @author    LIEMNN
 * @see       ChuyenMon
 * @generated
 */
public class ChuyenMonWrapper implements ChuyenMon, ModelWrapper<ChuyenMon> {
	public ChuyenMonWrapper(ChuyenMon chuyenMon) {
		_chuyenMon = chuyenMon;
	}

	public Class<?> getModelClass() {
		return ChuyenMon.class;
	}

	public String getModelClassName() {
		return ChuyenMon.class.getName();
	}

	/**
	* Returns the primary key of this chuyen mon.
	*
	* @return the primary key of this chuyen mon
	*/
	public long getPrimaryKey() {
		return _chuyenMon.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chuyen mon.
	*
	* @param primaryKey the primary key of this chuyen mon
	*/
	public void setPrimaryKey(long primaryKey) {
		_chuyenMon.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this chuyen mon.
	*
	* @return the ID of this chuyen mon
	*/
	public long getId() {
		return _chuyenMon.getId();
	}

	/**
	* Sets the ID of this chuyen mon.
	*
	* @param id the ID of this chuyen mon
	*/
	public void setId(long id) {
		_chuyenMon.setId(id);
	}

	/**
	* Returns the ma of this chuyen mon.
	*
	* @return the ma of this chuyen mon
	*/
	public java.lang.String getMa() {
		return _chuyenMon.getMa();
	}

	/**
	* Sets the ma of this chuyen mon.
	*
	* @param ma the ma of this chuyen mon
	*/
	public void setMa(java.lang.String ma) {
		_chuyenMon.setMa(ma);
	}

	/**
	* Returns the ten of this chuyen mon.
	*
	* @return the ten of this chuyen mon
	*/
	public java.lang.String getTen() {
		return _chuyenMon.getTen();
	}

	/**
	* Sets the ten of this chuyen mon.
	*
	* @param ten the ten of this chuyen mon
	*/
	public void setTen(java.lang.String ten) {
		_chuyenMon.setTen(ten);
	}

	/**
	* Returns the phienban of this chuyen mon.
	*
	* @return the phienban of this chuyen mon
	*/
	public long getPhienban() {
		return _chuyenMon.getPhienban();
	}

	/**
	* Sets the phienban of this chuyen mon.
	*
	* @param phienban the phienban of this chuyen mon
	*/
	public void setPhienban(long phienban) {
		_chuyenMon.setPhienban(phienban);
	}

	/**
	* Returns the ngaytao of this chuyen mon.
	*
	* @return the ngaytao of this chuyen mon
	*/
	public java.util.Date getNgaytao() {
		return _chuyenMon.getNgaytao();
	}

	/**
	* Sets the ngaytao of this chuyen mon.
	*
	* @param ngaytao the ngaytao of this chuyen mon
	*/
	public void setNgaytao(java.util.Date ngaytao) {
		_chuyenMon.setNgaytao(ngaytao);
	}

	/**
	* Returns the nguoitao of this chuyen mon.
	*
	* @return the nguoitao of this chuyen mon
	*/
	public java.lang.String getNguoitao() {
		return _chuyenMon.getNguoitao();
	}

	/**
	* Sets the nguoitao of this chuyen mon.
	*
	* @param nguoitao the nguoitao of this chuyen mon
	*/
	public void setNguoitao(java.lang.String nguoitao) {
		_chuyenMon.setNguoitao(nguoitao);
	}

	/**
	* Returns the ngaysua of this chuyen mon.
	*
	* @return the ngaysua of this chuyen mon
	*/
	public java.util.Date getNgaysua() {
		return _chuyenMon.getNgaysua();
	}

	/**
	* Sets the ngaysua of this chuyen mon.
	*
	* @param ngaysua the ngaysua of this chuyen mon
	*/
	public void setNgaysua(java.util.Date ngaysua) {
		_chuyenMon.setNgaysua(ngaysua);
	}

	/**
	* Returns the nguoisua of this chuyen mon.
	*
	* @return the nguoisua of this chuyen mon
	*/
	public java.lang.String getNguoisua() {
		return _chuyenMon.getNguoisua();
	}

	/**
	* Sets the nguoisua of this chuyen mon.
	*
	* @param nguoisua the nguoisua of this chuyen mon
	*/
	public void setNguoisua(java.lang.String nguoisua) {
		_chuyenMon.setNguoisua(nguoisua);
	}

	/**
	* Returns the daxoa of this chuyen mon.
	*
	* @return the daxoa of this chuyen mon
	*/
	public long getDaxoa() {
		return _chuyenMon.getDaxoa();
	}

	/**
	* Sets the daxoa of this chuyen mon.
	*
	* @param daxoa the daxoa of this chuyen mon
	*/
	public void setDaxoa(long daxoa) {
		_chuyenMon.setDaxoa(daxoa);
	}

	public boolean isNew() {
		return _chuyenMon.isNew();
	}

	public void setNew(boolean n) {
		_chuyenMon.setNew(n);
	}

	public boolean isCachedModel() {
		return _chuyenMon.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_chuyenMon.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _chuyenMon.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _chuyenMon.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chuyenMon.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chuyenMon.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chuyenMon.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChuyenMonWrapper((ChuyenMon)_chuyenMon.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon) {
		return _chuyenMon.compareTo(chuyenMon);
	}

	@Override
	public int hashCode() {
		return _chuyenMon.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.ChuyenMon> toCacheModel() {
		return _chuyenMon.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.ChuyenMon toEscapedModel() {
		return new ChuyenMonWrapper(_chuyenMon.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chuyenMon.toString();
	}

	public java.lang.String toXmlString() {
		return _chuyenMon.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chuyenMon.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ChuyenMon getWrappedChuyenMon() {
		return _chuyenMon;
	}

	public ChuyenMon getWrappedModel() {
		return _chuyenMon;
	}

	public void resetOriginalValues() {
		_chuyenMon.resetOriginalValues();
	}

	private ChuyenMon _chuyenMon;
}