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

package org.oep.cmon.dao.touchscreen.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TraCuuThuTucHanhChinh}.
 * </p>
 *
 * @author    VIENPN
 * @see       TraCuuThuTucHanhChinh
 * @generated
 */
public class TraCuuThuTucHanhChinhWrapper implements TraCuuThuTucHanhChinh,
	ModelWrapper<TraCuuThuTucHanhChinh> {
	public TraCuuThuTucHanhChinhWrapper(
		TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) {
		_traCuuThuTucHanhChinh = traCuuThuTucHanhChinh;
	}

	public Class<?> getModelClass() {
		return TraCuuThuTucHanhChinh.class;
	}

	public String getModelClassName() {
		return TraCuuThuTucHanhChinh.class.getName();
	}

	/**
	* Returns the primary key of this tra cuu thu tuc hanh chinh.
	*
	* @return the primary key of this tra cuu thu tuc hanh chinh
	*/
	public long getPrimaryKey() {
		return _traCuuThuTucHanhChinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tra cuu thu tuc hanh chinh.
	*
	* @param primaryKey the primary key of this tra cuu thu tuc hanh chinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_traCuuThuTucHanhChinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tra cuu thu tuc hanh chinh.
	*
	* @return the ID of this tra cuu thu tuc hanh chinh
	*/
	public long getId() {
		return _traCuuThuTucHanhChinh.getId();
	}

	/**
	* Sets the ID of this tra cuu thu tuc hanh chinh.
	*
	* @param id the ID of this tra cuu thu tuc hanh chinh
	*/
	public void setId(long id) {
		_traCuuThuTucHanhChinh.setId(id);
	}

	/**
	* Returns the ma of this tra cuu thu tuc hanh chinh.
	*
	* @return the ma of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getMa() {
		return _traCuuThuTucHanhChinh.getMa();
	}

	/**
	* Sets the ma of this tra cuu thu tuc hanh chinh.
	*
	* @param ma the ma of this tra cuu thu tuc hanh chinh
	*/
	public void setMa(java.lang.String ma) {
		_traCuuThuTucHanhChinh.setMa(ma);
	}

	/**
	* Returns the ten of this tra cuu thu tuc hanh chinh.
	*
	* @return the ten of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getTen() {
		return _traCuuThuTucHanhChinh.getTen();
	}

	/**
	* Sets the ten of this tra cuu thu tuc hanh chinh.
	*
	* @param ten the ten of this tra cuu thu tuc hanh chinh
	*/
	public void setTen(java.lang.String ten) {
		_traCuuThuTucHanhChinh.setTen(ten);
	}

	/**
	* Returns the so ngay xu ly of this tra cuu thu tuc hanh chinh.
	*
	* @return the so ngay xu ly of this tra cuu thu tuc hanh chinh
	*/
	public long getSoNgayXuLy() {
		return _traCuuThuTucHanhChinh.getSoNgayXuLy();
	}

	/**
	* Sets the so ngay xu ly of this tra cuu thu tuc hanh chinh.
	*
	* @param soNgayXuLy the so ngay xu ly of this tra cuu thu tuc hanh chinh
	*/
	public void setSoNgayXuLy(long soNgayXuLy) {
		_traCuuThuTucHanhChinh.setSoNgayXuLy(soNgayXuLy);
	}

	/**
	* Returns the ngay tao of this tra cuu thu tuc hanh chinh.
	*
	* @return the ngay tao of this tra cuu thu tuc hanh chinh
	*/
	public java.util.Date getNgayTao() {
		return _traCuuThuTucHanhChinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tra cuu thu tuc hanh chinh.
	*
	* @param ngayTao the ngay tao of this tra cuu thu tuc hanh chinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_traCuuThuTucHanhChinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this tra cuu thu tuc hanh chinh.
	*
	* @return the ngay sua of this tra cuu thu tuc hanh chinh
	*/
	public java.util.Date getNgaySua() {
		return _traCuuThuTucHanhChinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tra cuu thu tuc hanh chinh.
	*
	* @param ngaySua the ngay sua of this tra cuu thu tuc hanh chinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_traCuuThuTucHanhChinh.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this tra cuu thu tuc hanh chinh.
	*
	* @return the da xoa of this tra cuu thu tuc hanh chinh
	*/
	public int getDaXoa() {
		return _traCuuThuTucHanhChinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this tra cuu thu tuc hanh chinh.
	*
	* @param daXoa the da xoa of this tra cuu thu tuc hanh chinh
	*/
	public void setDaXoa(int daXoa) {
		_traCuuThuTucHanhChinh.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this tra cuu thu tuc hanh chinh.
	*
	* @return the nguoi tao of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getNguoiTao() {
		return _traCuuThuTucHanhChinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tra cuu thu tuc hanh chinh.
	*
	* @param nguoiTao the nguoi tao of this tra cuu thu tuc hanh chinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_traCuuThuTucHanhChinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this tra cuu thu tuc hanh chinh.
	*
	* @return the nguoi sua of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getNguoiSua() {
		return _traCuuThuTucHanhChinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tra cuu thu tuc hanh chinh.
	*
	* @param nguoiSua the nguoi sua of this tra cuu thu tuc hanh chinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_traCuuThuTucHanhChinh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the nhom thu tuc hanh chinh ID of this tra cuu thu tuc hanh chinh.
	*
	* @return the nhom thu tuc hanh chinh ID of this tra cuu thu tuc hanh chinh
	*/
	public long getNhomThuTucHanhChinhId() {
		return _traCuuThuTucHanhChinh.getNhomThuTucHanhChinhId();
	}

	/**
	* Sets the nhom thu tuc hanh chinh ID of this tra cuu thu tuc hanh chinh.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID of this tra cuu thu tuc hanh chinh
	*/
	public void setNhomThuTucHanhChinhId(long nhomThuTucHanhChinhId) {
		_traCuuThuTucHanhChinh.setNhomThuTucHanhChinhId(nhomThuTucHanhChinhId);
	}

	/**
	* Returns the nhom thu tuc hanh chinh ten of this tra cuu thu tuc hanh chinh.
	*
	* @return the nhom thu tuc hanh chinh ten of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getNhomThuTucHanhChinhTen() {
		return _traCuuThuTucHanhChinh.getNhomThuTucHanhChinhTen();
	}

	/**
	* Sets the nhom thu tuc hanh chinh ten of this tra cuu thu tuc hanh chinh.
	*
	* @param nhomThuTucHanhChinhTen the nhom thu tuc hanh chinh ten of this tra cuu thu tuc hanh chinh
	*/
	public void setNhomThuTucHanhChinhTen(
		java.lang.String nhomThuTucHanhChinhTen) {
		_traCuuThuTucHanhChinh.setNhomThuTucHanhChinhTen(nhomThuTucHanhChinhTen);
	}

	/**
	* Returns the trang thai of this tra cuu thu tuc hanh chinh.
	*
	* @return the trang thai of this tra cuu thu tuc hanh chinh
	*/
	public int getTrangThai() {
		return _traCuuThuTucHanhChinh.getTrangThai();
	}

	/**
	* Sets the trang thai of this tra cuu thu tuc hanh chinh.
	*
	* @param trangThai the trang thai of this tra cuu thu tuc hanh chinh
	*/
	public void setTrangThai(int trangThai) {
		_traCuuThuTucHanhChinh.setTrangThai(trangThai);
	}

	/**
	* Returns the phien ban of this tra cuu thu tuc hanh chinh.
	*
	* @return the phien ban of this tra cuu thu tuc hanh chinh
	*/
	public long getPhienBan() {
		return _traCuuThuTucHanhChinh.getPhienBan();
	}

	/**
	* Sets the phien ban of this tra cuu thu tuc hanh chinh.
	*
	* @param phienBan the phien ban of this tra cuu thu tuc hanh chinh
	*/
	public void setPhienBan(long phienBan) {
		_traCuuThuTucHanhChinh.setPhienBan(phienBan);
	}

	/**
	* Returns the can tich hop of this tra cuu thu tuc hanh chinh.
	*
	* @return the can tich hop of this tra cuu thu tuc hanh chinh
	*/
	public int getCanTichHop() {
		return _traCuuThuTucHanhChinh.getCanTichHop();
	}

	/**
	* Sets the can tich hop of this tra cuu thu tuc hanh chinh.
	*
	* @param canTichHop the can tich hop of this tra cuu thu tuc hanh chinh
	*/
	public void setCanTichHop(int canTichHop) {
		_traCuuThuTucHanhChinh.setCanTichHop(canTichHop);
	}

	/**
	* Returns the trinh tu thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @return the trinh tu thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getTrinhTuThucHien() {
		return _traCuuThuTucHanhChinh.getTrinhTuThucHien();
	}

	/**
	* Sets the trinh tu thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @param trinhTuThucHien the trinh tu thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public void setTrinhTuThucHien(java.lang.String trinhTuThucHien) {
		_traCuuThuTucHanhChinh.setTrinhTuThucHien(trinhTuThucHien);
	}

	/**
	* Returns the cach thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @return the cach thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getCachThucHien() {
		return _traCuuThuTucHanhChinh.getCachThucHien();
	}

	/**
	* Sets the cach thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @param cachThucHien the cach thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public void setCachThucHien(java.lang.String cachThucHien) {
		_traCuuThuTucHanhChinh.setCachThucHien(cachThucHien);
	}

	/**
	* Returns the thanh phan ho so of this tra cuu thu tuc hanh chinh.
	*
	* @return the thanh phan ho so of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getThanhPhanHoSo() {
		return _traCuuThuTucHanhChinh.getThanhPhanHoSo();
	}

	/**
	* Sets the thanh phan ho so of this tra cuu thu tuc hanh chinh.
	*
	* @param thanhPhanHoSo the thanh phan ho so of this tra cuu thu tuc hanh chinh
	*/
	public void setThanhPhanHoSo(java.lang.String thanhPhanHoSo) {
		_traCuuThuTucHanhChinh.setThanhPhanHoSo(thanhPhanHoSo);
	}

	/**
	* Returns the le phi of this tra cuu thu tuc hanh chinh.
	*
	* @return the le phi of this tra cuu thu tuc hanh chinh
	*/
	public long getLePhi() {
		return _traCuuThuTucHanhChinh.getLePhi();
	}

	/**
	* Sets the le phi of this tra cuu thu tuc hanh chinh.
	*
	* @param lePhi the le phi of this tra cuu thu tuc hanh chinh
	*/
	public void setLePhi(long lePhi) {
		_traCuuThuTucHanhChinh.setLePhi(lePhi);
	}

	/**
	* Returns the don vi le phi of this tra cuu thu tuc hanh chinh.
	*
	* @return the don vi le phi of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getDonViLePhi() {
		return _traCuuThuTucHanhChinh.getDonViLePhi();
	}

	/**
	* Sets the don vi le phi of this tra cuu thu tuc hanh chinh.
	*
	* @param donViLePhi the don vi le phi of this tra cuu thu tuc hanh chinh
	*/
	public void setDonViLePhi(java.lang.String donViLePhi) {
		_traCuuThuTucHanhChinh.setDonViLePhi(donViLePhi);
	}

	/**
	* Returns the phi of this tra cuu thu tuc hanh chinh.
	*
	* @return the phi of this tra cuu thu tuc hanh chinh
	*/
	public long getPhi() {
		return _traCuuThuTucHanhChinh.getPhi();
	}

	/**
	* Sets the phi of this tra cuu thu tuc hanh chinh.
	*
	* @param phi the phi of this tra cuu thu tuc hanh chinh
	*/
	public void setPhi(long phi) {
		_traCuuThuTucHanhChinh.setPhi(phi);
	}

	/**
	* Returns the don vi phi of this tra cuu thu tuc hanh chinh.
	*
	* @return the don vi phi of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getDonViPhi() {
		return _traCuuThuTucHanhChinh.getDonViPhi();
	}

	/**
	* Sets the don vi phi of this tra cuu thu tuc hanh chinh.
	*
	* @param donViPhi the don vi phi of this tra cuu thu tuc hanh chinh
	*/
	public void setDonViPhi(java.lang.String donViPhi) {
		_traCuuThuTucHanhChinh.setDonViPhi(donViPhi);
	}

	/**
	* Returns the ten mau don to khai of this tra cuu thu tuc hanh chinh.
	*
	* @return the ten mau don to khai of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getTenMauDonToKhai() {
		return _traCuuThuTucHanhChinh.getTenMauDonToKhai();
	}

	/**
	* Sets the ten mau don to khai of this tra cuu thu tuc hanh chinh.
	*
	* @param tenMauDonToKhai the ten mau don to khai of this tra cuu thu tuc hanh chinh
	*/
	public void setTenMauDonToKhai(java.lang.String tenMauDonToKhai) {
		_traCuuThuTucHanhChinh.setTenMauDonToKhai(tenMauDonToKhai);
	}

	/**
	* Returns the yeu cau dieu kien thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @return the yeu cau dieu kien thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getYeuCauDieuKienThucHien() {
		return _traCuuThuTucHanhChinh.getYeuCauDieuKienThucHien();
	}

	/**
	* Sets the yeu cau dieu kien thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @param yeuCauDieuKienThucHien the yeu cau dieu kien thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public void setYeuCauDieuKienThucHien(
		java.lang.String yeuCauDieuKienThucHien) {
		_traCuuThuTucHanhChinh.setYeuCauDieuKienThucHien(yeuCauDieuKienThucHien);
	}

	/**
	* Returns the can cu phap ly of this tra cuu thu tuc hanh chinh.
	*
	* @return the can cu phap ly of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getCanCuPhapLy() {
		return _traCuuThuTucHanhChinh.getCanCuPhapLy();
	}

	/**
	* Sets the can cu phap ly of this tra cuu thu tuc hanh chinh.
	*
	* @param canCuPhapLy the can cu phap ly of this tra cuu thu tuc hanh chinh
	*/
	public void setCanCuPhapLy(java.lang.String canCuPhapLy) {
		_traCuuThuTucHanhChinh.setCanCuPhapLy(canCuPhapLy);
	}

	/**
	* Returns the cap co quan quan ly ID of this tra cuu thu tuc hanh chinh.
	*
	* @return the cap co quan quan ly ID of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.Long getCapCoQuanQuanLyId() {
		return _traCuuThuTucHanhChinh.getCapCoQuanQuanLyId();
	}

	/**
	* Sets the cap co quan quan ly ID of this tra cuu thu tuc hanh chinh.
	*
	* @param capCoQuanQuanLyId the cap co quan quan ly ID of this tra cuu thu tuc hanh chinh
	*/
	public void setCapCoQuanQuanLyId(java.lang.Long capCoQuanQuanLyId) {
		_traCuuThuTucHanhChinh.setCapCoQuanQuanLyId(capCoQuanQuanLyId);
	}

	/**
	* Returns the linh vuc thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @return the linh vuc thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getLinhVucThucHien() {
		return _traCuuThuTucHanhChinh.getLinhVucThucHien();
	}

	/**
	* Sets the linh vuc thuc hien of this tra cuu thu tuc hanh chinh.
	*
	* @param linhVucThucHien the linh vuc thuc hien of this tra cuu thu tuc hanh chinh
	*/
	public void setLinhVucThucHien(java.lang.String linhVucThucHien) {
		_traCuuThuTucHanhChinh.setLinhVucThucHien(linhVucThucHien);
	}

	/**
	* Returns the ma d n g of this tra cuu thu tuc hanh chinh.
	*
	* @return the ma d n g of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getMaDNG() {
		return _traCuuThuTucHanhChinh.getMaDNG();
	}

	/**
	* Sets the ma d n g of this tra cuu thu tuc hanh chinh.
	*
	* @param maDNG the ma d n g of this tra cuu thu tuc hanh chinh
	*/
	public void setMaDNG(java.lang.String maDNG) {
		_traCuuThuTucHanhChinh.setMaDNG(maDNG);
	}

	/**
	* Returns the uengine process name of this tra cuu thu tuc hanh chinh.
	*
	* @return the uengine process name of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.String getUengineProcessName() {
		return _traCuuThuTucHanhChinh.getUengineProcessName();
	}

	/**
	* Sets the uengine process name of this tra cuu thu tuc hanh chinh.
	*
	* @param uengineProcessName the uengine process name of this tra cuu thu tuc hanh chinh
	*/
	public void setUengineProcessName(java.lang.String uengineProcessName) {
		_traCuuThuTucHanhChinh.setUengineProcessName(uengineProcessName);
	}

	/**
	* Returns the thu tuc lien thong ID of this tra cuu thu tuc hanh chinh.
	*
	* @return the thu tuc lien thong ID of this tra cuu thu tuc hanh chinh
	*/
	public java.lang.Long getThuTucLienThongId() {
		return _traCuuThuTucHanhChinh.getThuTucLienThongId();
	}

	/**
	* Sets the thu tuc lien thong ID of this tra cuu thu tuc hanh chinh.
	*
	* @param thuTucLienThongId the thu tuc lien thong ID of this tra cuu thu tuc hanh chinh
	*/
	public void setThuTucLienThongId(java.lang.Long thuTucLienThongId) {
		_traCuuThuTucHanhChinh.setThuTucLienThongId(thuTucLienThongId);
	}

	public boolean isNew() {
		return _traCuuThuTucHanhChinh.isNew();
	}

	public void setNew(boolean n) {
		_traCuuThuTucHanhChinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _traCuuThuTucHanhChinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_traCuuThuTucHanhChinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _traCuuThuTucHanhChinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _traCuuThuTucHanhChinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_traCuuThuTucHanhChinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _traCuuThuTucHanhChinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_traCuuThuTucHanhChinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TraCuuThuTucHanhChinhWrapper((TraCuuThuTucHanhChinh)_traCuuThuTucHanhChinh.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) {
		return _traCuuThuTucHanhChinh.compareTo(traCuuThuTucHanhChinh);
	}

	@Override
	public int hashCode() {
		return _traCuuThuTucHanhChinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh> toCacheModel() {
		return _traCuuThuTucHanhChinh.toCacheModel();
	}

	public org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh toEscapedModel() {
		return new TraCuuThuTucHanhChinhWrapper(_traCuuThuTucHanhChinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _traCuuThuTucHanhChinh.toString();
	}

	public java.lang.String toXmlString() {
		return _traCuuThuTucHanhChinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_traCuuThuTucHanhChinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TraCuuThuTucHanhChinh getWrappedTraCuuThuTucHanhChinh() {
		return _traCuuThuTucHanhChinh;
	}

	public TraCuuThuTucHanhChinh getWrappedModel() {
		return _traCuuThuTucHanhChinh;
	}

	public void resetOriginalValues() {
		_traCuuThuTucHanhChinh.resetOriginalValues();
	}

	private TraCuuThuTucHanhChinh _traCuuThuTucHanhChinh;
}