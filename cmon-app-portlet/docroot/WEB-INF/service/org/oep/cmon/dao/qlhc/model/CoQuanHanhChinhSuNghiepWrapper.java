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
 * This class is a wrapper for {@link CoQuanHanhChinhSuNghiep}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CoQuanHanhChinhSuNghiep
 * @generated
 */
public class CoQuanHanhChinhSuNghiepWrapper implements CoQuanHanhChinhSuNghiep,
	ModelWrapper<CoQuanHanhChinhSuNghiep> {
	public CoQuanHanhChinhSuNghiepWrapper(
		CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep) {
		_coQuanHanhChinhSuNghiep = coQuanHanhChinhSuNghiep;
	}

	public Class<?> getModelClass() {
		return CoQuanHanhChinhSuNghiep.class;
	}

	public String getModelClassName() {
		return CoQuanHanhChinhSuNghiep.class.getName();
	}

	/**
	* Returns the primary key of this co quan hanh chinh su nghiep.
	*
	* @return the primary key of this co quan hanh chinh su nghiep
	*/
	public long getPrimaryKey() {
		return _coQuanHanhChinhSuNghiep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this co quan hanh chinh su nghiep.
	*
	* @param primaryKey the primary key of this co quan hanh chinh su nghiep
	*/
	public void setPrimaryKey(long primaryKey) {
		_coQuanHanhChinhSuNghiep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this co quan hanh chinh su nghiep.
	*
	* @return the ID of this co quan hanh chinh su nghiep
	*/
	public long getId() {
		return _coQuanHanhChinhSuNghiep.getId();
	}

	/**
	* Sets the ID of this co quan hanh chinh su nghiep.
	*
	* @param id the ID of this co quan hanh chinh su nghiep
	*/
	public void setId(long id) {
		_coQuanHanhChinhSuNghiep.setId(id);
	}

	/**
	* Returns the ma of this co quan hanh chinh su nghiep.
	*
	* @return the ma of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getMa() {
		return _coQuanHanhChinhSuNghiep.getMa();
	}

	/**
	* Sets the ma of this co quan hanh chinh su nghiep.
	*
	* @param ma the ma of this co quan hanh chinh su nghiep
	*/
	public void setMa(java.lang.String ma) {
		_coQuanHanhChinhSuNghiep.setMa(ma);
	}

	/**
	* Returns the ten of this co quan hanh chinh su nghiep.
	*
	* @return the ten of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getTen() {
		return _coQuanHanhChinhSuNghiep.getTen();
	}

	/**
	* Sets the ten of this co quan hanh chinh su nghiep.
	*
	* @param ten the ten of this co quan hanh chinh su nghiep
	*/
	public void setTen(java.lang.String ten) {
		_coQuanHanhChinhSuNghiep.setTen(ten);
	}

	/**
	* Returns the so d t duong day nong of this co quan hanh chinh su nghiep.
	*
	* @return the so d t duong day nong of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getSoDTDuongDayNong() {
		return _coQuanHanhChinhSuNghiep.getSoDTDuongDayNong();
	}

	/**
	* Sets the so d t duong day nong of this co quan hanh chinh su nghiep.
	*
	* @param soDTDuongDayNong the so d t duong day nong of this co quan hanh chinh su nghiep
	*/
	public void setSoDTDuongDayNong(java.lang.String soDTDuongDayNong) {
		_coQuanHanhChinhSuNghiep.setSoDTDuongDayNong(soDTDuongDayNong);
	}

	/**
	* Returns the noi bo of this co quan hanh chinh su nghiep.
	*
	* @return the noi bo of this co quan hanh chinh su nghiep
	*/
	public long getNoiBo() {
		return _coQuanHanhChinhSuNghiep.getNoiBo();
	}

	/**
	* Sets the noi bo of this co quan hanh chinh su nghiep.
	*
	* @param noiBo the noi bo of this co quan hanh chinh su nghiep
	*/
	public void setNoiBo(long noiBo) {
		_coQuanHanhChinhSuNghiep.setNoiBo(noiBo);
	}

	/**
	* Returns the chuc nang of this co quan hanh chinh su nghiep.
	*
	* @return the chuc nang of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getChucNang() {
		return _coQuanHanhChinhSuNghiep.getChucNang();
	}

	/**
	* Sets the chuc nang of this co quan hanh chinh su nghiep.
	*
	* @param chucNang the chuc nang of this co quan hanh chinh su nghiep
	*/
	public void setChucNang(java.lang.String chucNang) {
		_coQuanHanhChinhSuNghiep.setChucNang(chucNang);
	}

	/**
	* Returns the tong so c b n v of this co quan hanh chinh su nghiep.
	*
	* @return the tong so c b n v of this co quan hanh chinh su nghiep
	*/
	public long getTongSoCBNV() {
		return _coQuanHanhChinhSuNghiep.getTongSoCBNV();
	}

	/**
	* Sets the tong so c b n v of this co quan hanh chinh su nghiep.
	*
	* @param tongSoCBNV the tong so c b n v of this co quan hanh chinh su nghiep
	*/
	public void setTongSoCBNV(long tongSoCBNV) {
		_coQuanHanhChinhSuNghiep.setTongSoCBNV(tongSoCBNV);
	}

	/**
	* Returns the so d t of this co quan hanh chinh su nghiep.
	*
	* @return the so d t of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getSoDT() {
		return _coQuanHanhChinhSuNghiep.getSoDT();
	}

	/**
	* Sets the so d t of this co quan hanh chinh su nghiep.
	*
	* @param soDT the so d t of this co quan hanh chinh su nghiep
	*/
	public void setSoDT(java.lang.String soDT) {
		_coQuanHanhChinhSuNghiep.setSoDT(soDT);
	}

	/**
	* Returns the fax of this co quan hanh chinh su nghiep.
	*
	* @return the fax of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getFax() {
		return _coQuanHanhChinhSuNghiep.getFax();
	}

	/**
	* Sets the fax of this co quan hanh chinh su nghiep.
	*
	* @param fax the fax of this co quan hanh chinh su nghiep
	*/
	public void setFax(java.lang.String fax) {
		_coQuanHanhChinhSuNghiep.setFax(fax);
	}

	/**
	* Returns the email of this co quan hanh chinh su nghiep.
	*
	* @return the email of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getEmail() {
		return _coQuanHanhChinhSuNghiep.getEmail();
	}

	/**
	* Sets the email of this co quan hanh chinh su nghiep.
	*
	* @param email the email of this co quan hanh chinh su nghiep
	*/
	public void setEmail(java.lang.String email) {
		_coQuanHanhChinhSuNghiep.setEmail(email);
	}

	/**
	* Returns the tong so giuong benh of this co quan hanh chinh su nghiep.
	*
	* @return the tong so giuong benh of this co quan hanh chinh su nghiep
	*/
	public long getTongSoGiuongBenh() {
		return _coQuanHanhChinhSuNghiep.getTongSoGiuongBenh();
	}

	/**
	* Sets the tong so giuong benh of this co quan hanh chinh su nghiep.
	*
	* @param tongSoGiuongBenh the tong so giuong benh of this co quan hanh chinh su nghiep
	*/
	public void setTongSoGiuongBenh(long tongSoGiuongBenh) {
		_coQuanHanhChinhSuNghiep.setTongSoGiuongBenh(tongSoGiuongBenh);
	}

	/**
	* Returns the vi do of this co quan hanh chinh su nghiep.
	*
	* @return the vi do of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getViDo() {
		return _coQuanHanhChinhSuNghiep.getViDo();
	}

	/**
	* Sets the vi do of this co quan hanh chinh su nghiep.
	*
	* @param viDo the vi do of this co quan hanh chinh su nghiep
	*/
	public void setViDo(java.lang.String viDo) {
		_coQuanHanhChinhSuNghiep.setViDo(viDo);
	}

	/**
	* Returns the kinh do of this co quan hanh chinh su nghiep.
	*
	* @return the kinh do of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getKinhDo() {
		return _coQuanHanhChinhSuNghiep.getKinhDo();
	}

	/**
	* Sets the kinh do of this co quan hanh chinh su nghiep.
	*
	* @param kinhDo the kinh do of this co quan hanh chinh su nghiep
	*/
	public void setKinhDo(java.lang.String kinhDo) {
		_coQuanHanhChinhSuNghiep.setKinhDo(kinhDo);
	}

	/**
	* Returns the dia chi co quan h c s n xa ID of this co quan hanh chinh su nghiep.
	*
	* @return the dia chi co quan h c s n xa ID of this co quan hanh chinh su nghiep
	*/
	public long getDiaChiCoQuanHCSNXaId() {
		return _coQuanHanhChinhSuNghiep.getDiaChiCoQuanHCSNXaId();
	}

	/**
	* Sets the dia chi co quan h c s n xa ID of this co quan hanh chinh su nghiep.
	*
	* @param diaChiCoQuanHCSNXaId the dia chi co quan h c s n xa ID of this co quan hanh chinh su nghiep
	*/
	public void setDiaChiCoQuanHCSNXaId(long diaChiCoQuanHCSNXaId) {
		_coQuanHanhChinhSuNghiep.setDiaChiCoQuanHCSNXaId(diaChiCoQuanHCSNXaId);
	}

	/**
	* Returns the tuyen ID of this co quan hanh chinh su nghiep.
	*
	* @return the tuyen ID of this co quan hanh chinh su nghiep
	*/
	public long getTuyenId() {
		return _coQuanHanhChinhSuNghiep.getTuyenId();
	}

	/**
	* Sets the tuyen ID of this co quan hanh chinh su nghiep.
	*
	* @param tuyenId the tuyen ID of this co quan hanh chinh su nghiep
	*/
	public void setTuyenId(long tuyenId) {
		_coQuanHanhChinhSuNghiep.setTuyenId(tuyenId);
	}

	/**
	* Returns the dia chi co quan h c s n tinh ID of this co quan hanh chinh su nghiep.
	*
	* @return the dia chi co quan h c s n tinh ID of this co quan hanh chinh su nghiep
	*/
	public long getDiaChiCoQuanHCSNTinhId() {
		return _coQuanHanhChinhSuNghiep.getDiaChiCoQuanHCSNTinhId();
	}

	/**
	* Sets the dia chi co quan h c s n tinh ID of this co quan hanh chinh su nghiep.
	*
	* @param diaChiCoQuanHCSNTinhId the dia chi co quan h c s n tinh ID of this co quan hanh chinh su nghiep
	*/
	public void setDiaChiCoQuanHCSNTinhId(long diaChiCoQuanHCSNTinhId) {
		_coQuanHanhChinhSuNghiep.setDiaChiCoQuanHCSNTinhId(diaChiCoQuanHCSNTinhId);
	}

	/**
	* Returns the nguoi dai dien ID of this co quan hanh chinh su nghiep.
	*
	* @return the nguoi dai dien ID of this co quan hanh chinh su nghiep
	*/
	public long getNguoiDaiDienId() {
		return _coQuanHanhChinhSuNghiep.getNguoiDaiDienId();
	}

	/**
	* Sets the nguoi dai dien ID of this co quan hanh chinh su nghiep.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID of this co quan hanh chinh su nghiep
	*/
	public void setNguoiDaiDienId(long nguoiDaiDienId) {
		_coQuanHanhChinhSuNghiep.setNguoiDaiDienId(nguoiDaiDienId);
	}

	/**
	* Returns the dia chi co quan h c s n huyen ID of this co quan hanh chinh su nghiep.
	*
	* @return the dia chi co quan h c s n huyen ID of this co quan hanh chinh su nghiep
	*/
	public long getDiaChiCoQuanHCSNHuyenId() {
		return _coQuanHanhChinhSuNghiep.getDiaChiCoQuanHCSNHuyenId();
	}

	/**
	* Sets the dia chi co quan h c s n huyen ID of this co quan hanh chinh su nghiep.
	*
	* @param diaChiCoQuanHCSNHuyenId the dia chi co quan h c s n huyen ID of this co quan hanh chinh su nghiep
	*/
	public void setDiaChiCoQuanHCSNHuyenId(long diaChiCoQuanHCSNHuyenId) {
		_coQuanHanhChinhSuNghiep.setDiaChiCoQuanHCSNHuyenId(diaChiCoQuanHCSNHuyenId);
	}

	/**
	* Returns the hang ID of this co quan hanh chinh su nghiep.
	*
	* @return the hang ID of this co quan hanh chinh su nghiep
	*/
	public long getHangId() {
		return _coQuanHanhChinhSuNghiep.getHangId();
	}

	/**
	* Sets the hang ID of this co quan hanh chinh su nghiep.
	*
	* @param hangId the hang ID of this co quan hanh chinh su nghiep
	*/
	public void setHangId(long hangId) {
		_coQuanHanhChinhSuNghiep.setHangId(hangId);
	}

	/**
	* Returns the co quan quan ly ID of this co quan hanh chinh su nghiep.
	*
	* @return the co quan quan ly ID of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getCoQuanQuanLyId() {
		return _coQuanHanhChinhSuNghiep.getCoQuanQuanLyId();
	}

	/**
	* Sets the co quan quan ly ID of this co quan hanh chinh su nghiep.
	*
	* @param coQuanQuanLyId the co quan quan ly ID of this co quan hanh chinh su nghiep
	*/
	public void setCoQuanQuanLyId(java.lang.String coQuanQuanLyId) {
		_coQuanHanhChinhSuNghiep.setCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns the loai ID of this co quan hanh chinh su nghiep.
	*
	* @return the loai ID of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getLoaiId() {
		return _coQuanHanhChinhSuNghiep.getLoaiId();
	}

	/**
	* Sets the loai ID of this co quan hanh chinh su nghiep.
	*
	* @param loaiId the loai ID of this co quan hanh chinh su nghiep
	*/
	public void setLoaiId(java.lang.String loaiId) {
		_coQuanHanhChinhSuNghiep.setLoaiId(loaiId);
	}

	/**
	* Returns the so qd thanh lap of this co quan hanh chinh su nghiep.
	*
	* @return the so qd thanh lap of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getSoQdThanhLap() {
		return _coQuanHanhChinhSuNghiep.getSoQdThanhLap();
	}

	/**
	* Sets the so qd thanh lap of this co quan hanh chinh su nghiep.
	*
	* @param soQdThanhLap the so qd thanh lap of this co quan hanh chinh su nghiep
	*/
	public void setSoQdThanhLap(java.lang.String soQdThanhLap) {
		_coQuanHanhChinhSuNghiep.setSoQdThanhLap(soQdThanhLap);
	}

	/**
	* Returns the mo ta dia chi of this co quan hanh chinh su nghiep.
	*
	* @return the mo ta dia chi of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getMoTaDiaChi() {
		return _coQuanHanhChinhSuNghiep.getMoTaDiaChi();
	}

	/**
	* Sets the mo ta dia chi of this co quan hanh chinh su nghiep.
	*
	* @param moTaDiaChi the mo ta dia chi of this co quan hanh chinh su nghiep
	*/
	public void setMoTaDiaChi(java.lang.String moTaDiaChi) {
		_coQuanHanhChinhSuNghiep.setMoTaDiaChi(moTaDiaChi);
	}

	/**
	* Returns the ten nguoi dai dien of this co quan hanh chinh su nghiep.
	*
	* @return the ten nguoi dai dien of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getTenNguoiDaiDien() {
		return _coQuanHanhChinhSuNghiep.getTenNguoiDaiDien();
	}

	/**
	* Sets the ten nguoi dai dien of this co quan hanh chinh su nghiep.
	*
	* @param tenNguoiDaiDien the ten nguoi dai dien of this co quan hanh chinh su nghiep
	*/
	public void setTenNguoiDaiDien(java.lang.String tenNguoiDaiDien) {
		_coQuanHanhChinhSuNghiep.setTenNguoiDaiDien(tenNguoiDaiDien);
	}

	/**
	* Returns the ngay tao of this co quan hanh chinh su nghiep.
	*
	* @return the ngay tao of this co quan hanh chinh su nghiep
	*/
	public java.util.Date getNgayTao() {
		return _coQuanHanhChinhSuNghiep.getNgayTao();
	}

	/**
	* Sets the ngay tao of this co quan hanh chinh su nghiep.
	*
	* @param ngayTao the ngay tao of this co quan hanh chinh su nghiep
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_coQuanHanhChinhSuNghiep.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this co quan hanh chinh su nghiep.
	*
	* @return the da xoa of this co quan hanh chinh su nghiep
	*/
	public int getDaXoa() {
		return _coQuanHanhChinhSuNghiep.getDaXoa();
	}

	/**
	* Sets the da xoa of this co quan hanh chinh su nghiep.
	*
	* @param daXoa the da xoa of this co quan hanh chinh su nghiep
	*/
	public void setDaXoa(int daXoa) {
		_coQuanHanhChinhSuNghiep.setDaXoa(daXoa);
	}

	/**
	* Returns the ngay sua of this co quan hanh chinh su nghiep.
	*
	* @return the ngay sua of this co quan hanh chinh su nghiep
	*/
	public java.util.Date getNgaySua() {
		return _coQuanHanhChinhSuNghiep.getNgaySua();
	}

	/**
	* Sets the ngay sua of this co quan hanh chinh su nghiep.
	*
	* @param ngaySua the ngay sua of this co quan hanh chinh su nghiep
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_coQuanHanhChinhSuNghiep.setNgaySua(ngaySua);
	}

	/**
	* Returns the cha ID of this co quan hanh chinh su nghiep.
	*
	* @return the cha ID of this co quan hanh chinh su nghiep
	*/
	public java.lang.Long getChaId() {
		return _coQuanHanhChinhSuNghiep.getChaId();
	}

	/**
	* Sets the cha ID of this co quan hanh chinh su nghiep.
	*
	* @param chaId the cha ID of this co quan hanh chinh su nghiep
	*/
	public void setChaId(java.lang.Long chaId) {
		_coQuanHanhChinhSuNghiep.setChaId(chaId);
	}

	/**
	* Returns the nguoi tao of this co quan hanh chinh su nghiep.
	*
	* @return the nguoi tao of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getNguoiTao() {
		return _coQuanHanhChinhSuNghiep.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this co quan hanh chinh su nghiep.
	*
	* @param nguoiTao the nguoi tao of this co quan hanh chinh su nghiep
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_coQuanHanhChinhSuNghiep.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this co quan hanh chinh su nghiep.
	*
	* @return the nguoi sua of this co quan hanh chinh su nghiep
	*/
	public java.lang.String getNguoiSua() {
		return _coQuanHanhChinhSuNghiep.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this co quan hanh chinh su nghiep.
	*
	* @param nguoiSua the nguoi sua of this co quan hanh chinh su nghiep
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_coQuanHanhChinhSuNghiep.setNguoiSua(nguoiSua);
	}

	public boolean isNew() {
		return _coQuanHanhChinhSuNghiep.isNew();
	}

	public void setNew(boolean n) {
		_coQuanHanhChinhSuNghiep.setNew(n);
	}

	public boolean isCachedModel() {
		return _coQuanHanhChinhSuNghiep.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_coQuanHanhChinhSuNghiep.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _coQuanHanhChinhSuNghiep.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _coQuanHanhChinhSuNghiep.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_coQuanHanhChinhSuNghiep.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _coQuanHanhChinhSuNghiep.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_coQuanHanhChinhSuNghiep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CoQuanHanhChinhSuNghiepWrapper((CoQuanHanhChinhSuNghiep)_coQuanHanhChinhSuNghiep.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep) {
		return _coQuanHanhChinhSuNghiep.compareTo(coQuanHanhChinhSuNghiep);
	}

	@Override
	public int hashCode() {
		return _coQuanHanhChinhSuNghiep.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> toCacheModel() {
		return _coQuanHanhChinhSuNghiep.toCacheModel();
	}

	public org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep toEscapedModel() {
		return new CoQuanHanhChinhSuNghiepWrapper(_coQuanHanhChinhSuNghiep.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _coQuanHanhChinhSuNghiep.toString();
	}

	public java.lang.String toXmlString() {
		return _coQuanHanhChinhSuNghiep.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_coQuanHanhChinhSuNghiep.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CoQuanHanhChinhSuNghiep getWrappedCoQuanHanhChinhSuNghiep() {
		return _coQuanHanhChinhSuNghiep;
	}

	public CoQuanHanhChinhSuNghiep getWrappedModel() {
		return _coQuanHanhChinhSuNghiep;
	}

	public void resetOriginalValues() {
		_coQuanHanhChinhSuNghiep.resetOriginalValues();
	}

	private CoQuanHanhChinhSuNghiep _coQuanHanhChinhSuNghiep;
}