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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FileDinhKem}.
 * </p>
 *
 * @author    LIEMNn
 * @see       FileDinhKem
 * @generated
 */
public class FileDinhKemWrapper implements FileDinhKem,
	ModelWrapper<FileDinhKem> {
	public FileDinhKemWrapper(FileDinhKem fileDinhKem) {
		_fileDinhKem = fileDinhKem;
	}

	public Class<?> getModelClass() {
		return FileDinhKem.class;
	}

	public String getModelClassName() {
		return FileDinhKem.class.getName();
	}

	/**
	* Returns the primary key of this file dinh kem.
	*
	* @return the primary key of this file dinh kem
	*/
	public long getPrimaryKey() {
		return _fileDinhKem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this file dinh kem.
	*
	* @param primaryKey the primary key of this file dinh kem
	*/
	public void setPrimaryKey(long primaryKey) {
		_fileDinhKem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this file dinh kem.
	*
	* @return the ID of this file dinh kem
	*/
	public long getId() {
		return _fileDinhKem.getId();
	}

	/**
	* Sets the ID of this file dinh kem.
	*
	* @param id the ID of this file dinh kem
	*/
	public void setId(long id) {
		_fileDinhKem.setId(id);
	}

	/**
	* Returns the so ban giay of this file dinh kem.
	*
	* @return the so ban giay of this file dinh kem
	*/
	public long getSoBanGiay() {
		return _fileDinhKem.getSoBanGiay();
	}

	/**
	* Sets the so ban giay of this file dinh kem.
	*
	* @param soBanGiay the so ban giay of this file dinh kem
	*/
	public void setSoBanGiay(long soBanGiay) {
		_fileDinhKem.setSoBanGiay(soBanGiay);
	}

	/**
	* Returns the da doi chieu of this file dinh kem.
	*
	* @return the da doi chieu of this file dinh kem
	*/
	public int getDaDoiChieu() {
		return _fileDinhKem.getDaDoiChieu();
	}

	/**
	* Sets the da doi chieu of this file dinh kem.
	*
	* @param daDoiChieu the da doi chieu of this file dinh kem
	*/
	public void setDaDoiChieu(int daDoiChieu) {
		_fileDinhKem.setDaDoiChieu(daDoiChieu);
	}

	/**
	* Returns the trang thai ho so tai thoi diem dinh kem of this file dinh kem.
	*
	* @return the trang thai ho so tai thoi diem dinh kem of this file dinh kem
	*/
	public int getTrangThaiHoSoTaiThoiDiemDinhKem() {
		return _fileDinhKem.getTrangThaiHoSoTaiThoiDiemDinhKem();
	}

	/**
	* Sets the trang thai ho so tai thoi diem dinh kem of this file dinh kem.
	*
	* @param trangThaiHoSoTaiThoiDiemDinhKem the trang thai ho so tai thoi diem dinh kem of this file dinh kem
	*/
	public void setTrangThaiHoSoTaiThoiDiemDinhKem(
		int trangThaiHoSoTaiThoiDiemDinhKem) {
		_fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(trangThaiHoSoTaiThoiDiemDinhKem);
	}

	/**
	* Returns the noi luu tru tai lieu ID of this file dinh kem.
	*
	* @return the noi luu tru tai lieu ID of this file dinh kem
	*/
	public java.lang.Long getNoiLuuTruTaiLieuId() {
		return _fileDinhKem.getNoiLuuTruTaiLieuId();
	}

	/**
	* Sets the noi luu tru tai lieu ID of this file dinh kem.
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID of this file dinh kem
	*/
	public void setNoiLuuTruTaiLieuId(java.lang.Long noiLuuTruTaiLieuId) {
		_fileDinhKem.setNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);
	}

	/**
	* Returns the can bo ID of this file dinh kem.
	*
	* @return the can bo ID of this file dinh kem
	*/
	public java.lang.Long getCanBoId() {
		return _fileDinhKem.getCanBoId();
	}

	/**
	* Sets the can bo ID of this file dinh kem.
	*
	* @param canBoId the can bo ID of this file dinh kem
	*/
	public void setCanBoId(java.lang.Long canBoId) {
		_fileDinhKem.setCanBoId(canBoId);
	}

	/**
	* Returns the ho so t t h c cong ID of this file dinh kem.
	*
	* @return the ho so t t h c cong ID of this file dinh kem
	*/
	public java.lang.Long getHoSoTTHCCongId() {
		return _fileDinhKem.getHoSoTTHCCongId();
	}

	/**
	* Sets the ho so t t h c cong ID of this file dinh kem.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID of this file dinh kem
	*/
	public void setHoSoTTHCCongId(java.lang.Long hoSoTTHCCongId) {
		_fileDinhKem.setHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the thu tuc2 giay to ID of this file dinh kem.
	*
	* @return the thu tuc2 giay to ID of this file dinh kem
	*/
	public java.lang.Long getThuTuc2GiayToId() {
		return _fileDinhKem.getThuTuc2GiayToId();
	}

	/**
	* Sets the thu tuc2 giay to ID of this file dinh kem.
	*
	* @param thuTuc2GiayToId the thu tuc2 giay to ID of this file dinh kem
	*/
	public void setThuTuc2GiayToId(java.lang.Long thuTuc2GiayToId) {
		_fileDinhKem.setThuTuc2GiayToId(thuTuc2GiayToId);
	}

	/**
	* Returns the danh muc giay to ID of this file dinh kem.
	*
	* @return the danh muc giay to ID of this file dinh kem
	*/
	public java.lang.Long getDanhMucGiayToId() {
		return _fileDinhKem.getDanhMucGiayToId();
	}

	/**
	* Sets the danh muc giay to ID of this file dinh kem.
	*
	* @param danhMucGiayToId the danh muc giay to ID of this file dinh kem
	*/
	public void setDanhMucGiayToId(java.lang.Long danhMucGiayToId) {
		_fileDinhKem.setDanhMucGiayToId(danhMucGiayToId);
	}

	/**
	* Returns the ngay upload of this file dinh kem.
	*
	* @return the ngay upload of this file dinh kem
	*/
	public java.util.Date getNgayUpload() {
		return _fileDinhKem.getNgayUpload();
	}

	/**
	* Sets the ngay upload of this file dinh kem.
	*
	* @param ngayUpload the ngay upload of this file dinh kem
	*/
	public void setNgayUpload(java.util.Date ngayUpload) {
		_fileDinhKem.setNgayUpload(ngayUpload);
	}

	/**
	* Returns the ngay sua of this file dinh kem.
	*
	* @return the ngay sua of this file dinh kem
	*/
	public java.util.Date getNgaySua() {
		return _fileDinhKem.getNgaySua();
	}

	/**
	* Sets the ngay sua of this file dinh kem.
	*
	* @param ngaySua the ngay sua of this file dinh kem
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_fileDinhKem.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi upload of this file dinh kem.
	*
	* @return the nguoi upload of this file dinh kem
	*/
	public java.lang.String getNguoiUpload() {
		return _fileDinhKem.getNguoiUpload();
	}

	/**
	* Sets the nguoi upload of this file dinh kem.
	*
	* @param nguoiUpload the nguoi upload of this file dinh kem
	*/
	public void setNguoiUpload(java.lang.String nguoiUpload) {
		_fileDinhKem.setNguoiUpload(nguoiUpload);
	}

	/**
	* Returns the ma loai tai lieu duoc thay the of this file dinh kem.
	*
	* @return the ma loai tai lieu duoc thay the of this file dinh kem
	*/
	public java.lang.String getMaLoaiTaiLieuDuocThayThe() {
		return _fileDinhKem.getMaLoaiTaiLieuDuocThayThe();
	}

	/**
	* Sets the ma loai tai lieu duoc thay the of this file dinh kem.
	*
	* @param maLoaiTaiLieuDuocThayThe the ma loai tai lieu duoc thay the of this file dinh kem
	*/
	public void setMaLoaiTaiLieuDuocThayThe(
		java.lang.String maLoaiTaiLieuDuocThayThe) {
		_fileDinhKem.setMaLoaiTaiLieuDuocThayThe(maLoaiTaiLieuDuocThayThe);
	}

	/**
	* Returns the nguoi sua of this file dinh kem.
	*
	* @return the nguoi sua of this file dinh kem
	*/
	public java.lang.String getNguoiSua() {
		return _fileDinhKem.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this file dinh kem.
	*
	* @param nguoiSua the nguoi sua of this file dinh kem
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_fileDinhKem.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the xoa of this file dinh kem.
	*
	* @return the xoa of this file dinh kem
	*/
	public int getXoa() {
		return _fileDinhKem.getXoa();
	}

	/**
	* Sets the xoa of this file dinh kem.
	*
	* @param xoa the xoa of this file dinh kem
	*/
	public void setXoa(int xoa) {
		_fileDinhKem.setXoa(xoa);
	}

	/**
	* Returns the da tra of this file dinh kem.
	*
	* @return the da tra of this file dinh kem
	*/
	public int getDaTra() {
		return _fileDinhKem.getDaTra();
	}

	/**
	* Sets the da tra of this file dinh kem.
	*
	* @param daTra the da tra of this file dinh kem
	*/
	public void setDaTra(int daTra) {
		_fileDinhKem.setDaTra(daTra);
	}

	/**
	* Returns the ban chinh of this file dinh kem.
	*
	* @return the ban chinh of this file dinh kem
	*/
	public long getBanChinh() {
		return _fileDinhKem.getBanChinh();
	}

	/**
	* Sets the ban chinh of this file dinh kem.
	*
	* @param banChinh the ban chinh of this file dinh kem
	*/
	public void setBanChinh(long banChinh) {
		_fileDinhKem.setBanChinh(banChinh);
	}

	/**
	* Returns the ghi chu of this file dinh kem.
	*
	* @return the ghi chu of this file dinh kem
	*/
	public java.lang.String getGhiChu() {
		return _fileDinhKem.getGhiChu();
	}

	/**
	* Sets the ghi chu of this file dinh kem.
	*
	* @param ghiChu the ghi chu of this file dinh kem
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_fileDinhKem.setGhiChu(ghiChu);
	}

	public boolean isNew() {
		return _fileDinhKem.isNew();
	}

	public void setNew(boolean n) {
		_fileDinhKem.setNew(n);
	}

	public boolean isCachedModel() {
		return _fileDinhKem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_fileDinhKem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _fileDinhKem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _fileDinhKem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fileDinhKem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fileDinhKem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fileDinhKem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FileDinhKemWrapper((FileDinhKem)_fileDinhKem.clone());
	}

	public int compareTo(org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem) {
		return _fileDinhKem.compareTo(fileDinhKem);
	}

	@Override
	public int hashCode() {
		return _fileDinhKem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.hosohcc.model.FileDinhKem> toCacheModel() {
		return _fileDinhKem.toCacheModel();
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem toEscapedModel() {
		return new FileDinhKemWrapper(_fileDinhKem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fileDinhKem.toString();
	}

	public java.lang.String toXmlString() {
		return _fileDinhKem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fileDinhKem.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FileDinhKem getWrappedFileDinhKem() {
		return _fileDinhKem;
	}

	public FileDinhKem getWrappedModel() {
		return _fileDinhKem;
	}

	public void resetOriginalValues() {
		_fileDinhKem.resetOriginalValues();
	}

	private FileDinhKem _fileDinhKem;
}