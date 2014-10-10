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
 * This class is a wrapper for {@link DanToc}.
 * </p>
 *
 * @author    LIEMNN
 * @see       DanToc
 * @generated
 */
public class DanTocWrapper implements DanToc, ModelWrapper<DanToc> {
	public DanTocWrapper(DanToc danToc) {
		_danToc = danToc;
	}

	public Class<?> getModelClass() {
		return DanToc.class;
	}

	public String getModelClassName() {
		return DanToc.class.getName();
	}

	/**
	* Returns the primary key of this dan toc.
	*
	* @return the primary key of this dan toc
	*/
	public long getPrimaryKey() {
		return _danToc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dan toc.
	*
	* @param primaryKey the primary key of this dan toc
	*/
	public void setPrimaryKey(long primaryKey) {
		_danToc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this dan toc.
	*
	* @return the ID of this dan toc
	*/
	public long getId() {
		return _danToc.getId();
	}

	/**
	* Sets the ID of this dan toc.
	*
	* @param id the ID of this dan toc
	*/
	public void setId(long id) {
		_danToc.setId(id);
	}

	/**
	* Returns the ma of this dan toc.
	*
	* @return the ma of this dan toc
	*/
	public java.lang.String getMa() {
		return _danToc.getMa();
	}

	/**
	* Sets the ma of this dan toc.
	*
	* @param ma the ma of this dan toc
	*/
	public void setMa(java.lang.String ma) {
		_danToc.setMa(ma);
	}

	/**
	* Returns the ten of this dan toc.
	*
	* @return the ten of this dan toc
	*/
	public java.lang.String getTen() {
		return _danToc.getTen();
	}

	/**
	* Sets the ten of this dan toc.
	*
	* @param ten the ten of this dan toc
	*/
	public void setTen(java.lang.String ten) {
		_danToc.setTen(ten);
	}

	/**
	* Returns the phien ban of this dan toc.
	*
	* @return the phien ban of this dan toc
	*/
	public long getPhienBan() {
		return _danToc.getPhienBan();
	}

	/**
	* Sets the phien ban of this dan toc.
	*
	* @param phienBan the phien ban of this dan toc
	*/
	public void setPhienBan(long phienBan) {
		_danToc.setPhienBan(phienBan);
	}

	/**
	* Returns the la thieu so of this dan toc.
	*
	* @return the la thieu so of this dan toc
	*/
	public long getLaThieuSo() {
		return _danToc.getLaThieuSo();
	}

	/**
	* Sets the la thieu so of this dan toc.
	*
	* @param laThieuSo the la thieu so of this dan toc
	*/
	public void setLaThieuSo(long laThieuSo) {
		_danToc.setLaThieuSo(laThieuSo);
	}

	/**
	* Returns the ngay tao of this dan toc.
	*
	* @return the ngay tao of this dan toc
	*/
	public java.util.Date getNgayTao() {
		return _danToc.getNgayTao();
	}

	/**
	* Sets the ngay tao of this dan toc.
	*
	* @param ngayTao the ngay tao of this dan toc
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_danToc.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this dan toc.
	*
	* @return the da xoa of this dan toc
	*/
	public int getDaXoa() {
		return _danToc.getDaXoa();
	}

	/**
	* Sets the da xoa of this dan toc.
	*
	* @param daXoa the da xoa of this dan toc
	*/
	public void setDaXoa(int daXoa) {
		_danToc.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this dan toc.
	*
	* @return the nguoi tao of this dan toc
	*/
	public java.lang.String getNguoiTao() {
		return _danToc.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this dan toc.
	*
	* @param nguoiTao the nguoi tao of this dan toc
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_danToc.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this dan toc.
	*
	* @return the nguoi sua of this dan toc
	*/
	public java.lang.String getNguoiSua() {
		return _danToc.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this dan toc.
	*
	* @param nguoiSua the nguoi sua of this dan toc
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_danToc.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ten khac of this dan toc.
	*
	* @return the ten khac of this dan toc
	*/
	public java.lang.String getTenKhac() {
		return _danToc.getTenKhac();
	}

	/**
	* Sets the ten khac of this dan toc.
	*
	* @param tenKhac the ten khac of this dan toc
	*/
	public void setTenKhac(java.lang.String tenKhac) {
		_danToc.setTenKhac(tenKhac);
	}

	/**
	* Returns the ngay sua of this dan toc.
	*
	* @return the ngay sua of this dan toc
	*/
	public java.util.Date getNgaySua() {
		return _danToc.getNgaySua();
	}

	/**
	* Sets the ngay sua of this dan toc.
	*
	* @param ngaySua the ngay sua of this dan toc
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_danToc.setNgaySua(ngaySua);
	}

	public boolean isNew() {
		return _danToc.isNew();
	}

	public void setNew(boolean n) {
		_danToc.setNew(n);
	}

	public boolean isCachedModel() {
		return _danToc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danToc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danToc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danToc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danToc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danToc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danToc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanTocWrapper((DanToc)_danToc.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.DanToc danToc) {
		return _danToc.compareTo(danToc);
	}

	@Override
	public int hashCode() {
		return _danToc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.DanToc> toCacheModel() {
		return _danToc.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.DanToc toEscapedModel() {
		return new DanTocWrapper(_danToc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danToc.toString();
	}

	public java.lang.String toXmlString() {
		return _danToc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danToc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanToc getWrappedDanToc() {
		return _danToc;
	}

	public DanToc getWrappedModel() {
		return _danToc;
	}

	public void resetOriginalValues() {
		_danToc.resetOriginalValues();
	}

	private DanToc _danToc;
}