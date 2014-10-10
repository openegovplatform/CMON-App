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

package org.oep.cmon.dao.tlct.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TaiLieuChungThuc}.
 * </p>
 *
 * @author    Liemnn
 * @see       TaiLieuChungThuc
 * @generated
 */
public class TaiLieuChungThucWrapper implements TaiLieuChungThuc,
	ModelWrapper<TaiLieuChungThuc> {
	public TaiLieuChungThucWrapper(TaiLieuChungThuc taiLieuChungThuc) {
		_taiLieuChungThuc = taiLieuChungThuc;
	}

	public Class<?> getModelClass() {
		return TaiLieuChungThuc.class;
	}

	public String getModelClassName() {
		return TaiLieuChungThuc.class.getName();
	}

	/**
	* Returns the primary key of this tai lieu chung thuc.
	*
	* @return the primary key of this tai lieu chung thuc
	*/
	public long getPrimaryKey() {
		return _taiLieuChungThuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tai lieu chung thuc.
	*
	* @param primaryKey the primary key of this tai lieu chung thuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_taiLieuChungThuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tai lieu chung thuc.
	*
	* @return the ID of this tai lieu chung thuc
	*/
	public long getId() {
		return _taiLieuChungThuc.getId();
	}

	/**
	* Sets the ID of this tai lieu chung thuc.
	*
	* @param id the ID of this tai lieu chung thuc
	*/
	public void setId(long id) {
		_taiLieuChungThuc.setId(id);
	}

	/**
	* Returns the ten of this tai lieu chung thuc.
	*
	* @return the ten of this tai lieu chung thuc
	*/
	public java.lang.String getTen() {
		return _taiLieuChungThuc.getTen();
	}

	/**
	* Sets the ten of this tai lieu chung thuc.
	*
	* @param ten the ten of this tai lieu chung thuc
	*/
	public void setTen(java.lang.String ten) {
		_taiLieuChungThuc.setTen(ten);
	}

	/**
	* Returns the ghi chu of this tai lieu chung thuc.
	*
	* @return the ghi chu of this tai lieu chung thuc
	*/
	public java.lang.String getGhiChu() {
		return _taiLieuChungThuc.getGhiChu();
	}

	/**
	* Sets the ghi chu of this tai lieu chung thuc.
	*
	* @param ghiChu the ghi chu of this tai lieu chung thuc
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_taiLieuChungThuc.setGhiChu(ghiChu);
	}

	/**
	* Returns the noi luu tru ID of this tai lieu chung thuc.
	*
	* @return the noi luu tru ID of this tai lieu chung thuc
	*/
	public long getNoiLuuTruId() {
		return _taiLieuChungThuc.getNoiLuuTruId();
	}

	/**
	* Sets the noi luu tru ID of this tai lieu chung thuc.
	*
	* @param noiLuuTruId the noi luu tru ID of this tai lieu chung thuc
	*/
	public void setNoiLuuTruId(long noiLuuTruId) {
		_taiLieuChungThuc.setNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the ngay upload of this tai lieu chung thuc.
	*
	* @return the ngay upload of this tai lieu chung thuc
	*/
	public java.util.Date getNgayUpload() {
		return _taiLieuChungThuc.getNgayUpload();
	}

	/**
	* Sets the ngay upload of this tai lieu chung thuc.
	*
	* @param ngayUpload the ngay upload of this tai lieu chung thuc
	*/
	public void setNgayUpload(java.util.Date ngayUpload) {
		_taiLieuChungThuc.setNgayUpload(ngayUpload);
	}

	/**
	* Returns the phien ban of this tai lieu chung thuc.
	*
	* @return the phien ban of this tai lieu chung thuc
	*/
	public int getPhienBan() {
		return _taiLieuChungThuc.getPhienBan();
	}

	/**
	* Sets the phien ban of this tai lieu chung thuc.
	*
	* @param phienBan the phien ban of this tai lieu chung thuc
	*/
	public void setPhienBan(int phienBan) {
		_taiLieuChungThuc.setPhienBan(phienBan);
	}

	/**
	* Returns the ngay duyet of this tai lieu chung thuc.
	*
	* @return the ngay duyet of this tai lieu chung thuc
	*/
	public java.util.Date getNgayDuyet() {
		return _taiLieuChungThuc.getNgayDuyet();
	}

	/**
	* Sets the ngay duyet of this tai lieu chung thuc.
	*
	* @param ngayDuyet the ngay duyet of this tai lieu chung thuc
	*/
	public void setNgayDuyet(java.util.Date ngayDuyet) {
		_taiLieuChungThuc.setNgayDuyet(ngayDuyet);
	}

	/**
	* Returns the hieu luc tu ngay of this tai lieu chung thuc.
	*
	* @return the hieu luc tu ngay of this tai lieu chung thuc
	*/
	public java.util.Date getHieuLucTuNgay() {
		return _taiLieuChungThuc.getHieuLucTuNgay();
	}

	/**
	* Sets the hieu luc tu ngay of this tai lieu chung thuc.
	*
	* @param hieuLucTuNgay the hieu luc tu ngay of this tai lieu chung thuc
	*/
	public void setHieuLucTuNgay(java.util.Date hieuLucTuNgay) {
		_taiLieuChungThuc.setHieuLucTuNgay(hieuLucTuNgay);
	}

	/**
	* Returns the hieu luc den ngay of this tai lieu chung thuc.
	*
	* @return the hieu luc den ngay of this tai lieu chung thuc
	*/
	public java.util.Date getHieuLucDenNgay() {
		return _taiLieuChungThuc.getHieuLucDenNgay();
	}

	/**
	* Sets the hieu luc den ngay of this tai lieu chung thuc.
	*
	* @param hieuLucDenNgay the hieu luc den ngay of this tai lieu chung thuc
	*/
	public void setHieuLucDenNgay(java.util.Date hieuLucDenNgay) {
		_taiLieuChungThuc.setHieuLucDenNgay(hieuLucDenNgay);
	}

	/**
	* Returns the ngay sua of this tai lieu chung thuc.
	*
	* @return the ngay sua of this tai lieu chung thuc
	*/
	public java.util.Date getNgaySua() {
		return _taiLieuChungThuc.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tai lieu chung thuc.
	*
	* @param ngaySua the ngay sua of this tai lieu chung thuc
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_taiLieuChungThuc.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this tai lieu chung thuc.
	*
	* @return the nguoi sua of this tai lieu chung thuc
	*/
	public java.lang.String getNguoiSua() {
		return _taiLieuChungThuc.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tai lieu chung thuc.
	*
	* @param nguoiSua the nguoi sua of this tai lieu chung thuc
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_taiLieuChungThuc.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the danh muc giay to ID of this tai lieu chung thuc.
	*
	* @return the danh muc giay to ID of this tai lieu chung thuc
	*/
	public java.lang.Long getDanhMucGiayToId() {
		return _taiLieuChungThuc.getDanhMucGiayToId();
	}

	/**
	* Sets the danh muc giay to ID of this tai lieu chung thuc.
	*
	* @param danhMucGiayToId the danh muc giay to ID of this tai lieu chung thuc
	*/
	public void setDanhMucGiayToId(java.lang.Long danhMucGiayToId) {
		_taiLieuChungThuc.setDanhMucGiayToId(danhMucGiayToId);
	}

	/**
	* Returns the trang thai of this tai lieu chung thuc.
	*
	* @return the trang thai of this tai lieu chung thuc
	*/
	public int getTrangThai() {
		return _taiLieuChungThuc.getTrangThai();
	}

	/**
	* Sets the trang thai of this tai lieu chung thuc.
	*
	* @param trangThai the trang thai of this tai lieu chung thuc
	*/
	public void setTrangThai(int trangThai) {
		_taiLieuChungThuc.setTrangThai(trangThai);
	}

	/**
	* Returns the chu sohuu ID of this tai lieu chung thuc.
	*
	* @return the chu sohuu ID of this tai lieu chung thuc
	*/
	public java.lang.Long getChuSohuuId() {
		return _taiLieuChungThuc.getChuSohuuId();
	}

	/**
	* Sets the chu sohuu ID of this tai lieu chung thuc.
	*
	* @param chuSohuuId the chu sohuu ID of this tai lieu chung thuc
	*/
	public void setChuSohuuId(java.lang.Long chuSohuuId) {
		_taiLieuChungThuc.setChuSohuuId(chuSohuuId);
	}

	/**
	* Returns the nguoi upload ID of this tai lieu chung thuc.
	*
	* @return the nguoi upload ID of this tai lieu chung thuc
	*/
	public java.lang.Long getNguoiUploadId() {
		return _taiLieuChungThuc.getNguoiUploadId();
	}

	/**
	* Sets the nguoi upload ID of this tai lieu chung thuc.
	*
	* @param nguoiUploadId the nguoi upload ID of this tai lieu chung thuc
	*/
	public void setNguoiUploadId(java.lang.Long nguoiUploadId) {
		_taiLieuChungThuc.setNguoiUploadId(nguoiUploadId);
	}

	/**
	* Returns the nguoiduyet ID of this tai lieu chung thuc.
	*
	* @return the nguoiduyet ID of this tai lieu chung thuc
	*/
	public java.lang.Long getNguoiduyetId() {
		return _taiLieuChungThuc.getNguoiduyetId();
	}

	/**
	* Sets the nguoiduyet ID of this tai lieu chung thuc.
	*
	* @param nguoiduyetId the nguoiduyet ID of this tai lieu chung thuc
	*/
	public void setNguoiduyetId(java.lang.Long nguoiduyetId) {
		_taiLieuChungThuc.setNguoiduyetId(nguoiduyetId);
	}

	/**
	* Returns the ho so t t h c c ID of this tai lieu chung thuc.
	*
	* @return the ho so t t h c c ID of this tai lieu chung thuc
	*/
	public java.lang.Long getHoSoTTHCCId() {
		return _taiLieuChungThuc.getHoSoTTHCCId();
	}

	/**
	* Sets the ho so t t h c c ID of this tai lieu chung thuc.
	*
	* @param hoSoTTHCCId the ho so t t h c c ID of this tai lieu chung thuc
	*/
	public void setHoSoTTHCCId(java.lang.Long hoSoTTHCCId) {
		_taiLieuChungThuc.setHoSoTTHCCId(hoSoTTHCCId);
	}

	/**
	* Returns the ma ung dung of this tai lieu chung thuc.
	*
	* @return the ma ung dung of this tai lieu chung thuc
	*/
	public java.lang.String getMaUngDung() {
		return _taiLieuChungThuc.getMaUngDung();
	}

	/**
	* Sets the ma ung dung of this tai lieu chung thuc.
	*
	* @param maUngDung the ma ung dung of this tai lieu chung thuc
	*/
	public void setMaUngDung(java.lang.String maUngDung) {
		_taiLieuChungThuc.setMaUngDung(maUngDung);
	}

	/**
	* Returns the loai of this tai lieu chung thuc.
	*
	* @return the loai of this tai lieu chung thuc
	*/
	public int getLoai() {
		return _taiLieuChungThuc.getLoai();
	}

	/**
	* Sets the loai of this tai lieu chung thuc.
	*
	* @param loai the loai of this tai lieu chung thuc
	*/
	public void setLoai(int loai) {
		_taiLieuChungThuc.setLoai(loai);
	}

	public boolean isNew() {
		return _taiLieuChungThuc.isNew();
	}

	public void setNew(boolean n) {
		_taiLieuChungThuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _taiLieuChungThuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_taiLieuChungThuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _taiLieuChungThuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _taiLieuChungThuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taiLieuChungThuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taiLieuChungThuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taiLieuChungThuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaiLieuChungThucWrapper((TaiLieuChungThuc)_taiLieuChungThuc.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc) {
		return _taiLieuChungThuc.compareTo(taiLieuChungThuc);
	}

	@Override
	public int hashCode() {
		return _taiLieuChungThuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> toCacheModel() {
		return _taiLieuChungThuc.toCacheModel();
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc toEscapedModel() {
		return new TaiLieuChungThucWrapper(_taiLieuChungThuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taiLieuChungThuc.toString();
	}

	public java.lang.String toXmlString() {
		return _taiLieuChungThuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taiLieuChungThuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TaiLieuChungThuc getWrappedTaiLieuChungThuc() {
		return _taiLieuChungThuc;
	}

	public TaiLieuChungThuc getWrappedModel() {
		return _taiLieuChungThuc;
	}

	public void resetOriginalValues() {
		_taiLieuChungThuc.resetOriginalValues();
	}

	private TaiLieuChungThuc _taiLieuChungThuc;
}