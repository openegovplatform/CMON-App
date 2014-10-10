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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ThuTucHanhChinh}.
 * </p>
 *
 * @author    liemnn
 * @see       ThuTucHanhChinh
 * @generated
 */
public class ThuTucHanhChinhWrapper implements ThuTucHanhChinh,
	ModelWrapper<ThuTucHanhChinh> {
	public ThuTucHanhChinhWrapper(ThuTucHanhChinh thuTucHanhChinh) {
		_thuTucHanhChinh = thuTucHanhChinh;
	}

	public Class<?> getModelClass() {
		return ThuTucHanhChinh.class;
	}

	public String getModelClassName() {
		return ThuTucHanhChinh.class.getName();
	}

	/**
	* Returns the primary key of this thu tuc hanh chinh.
	*
	* @return the primary key of this thu tuc hanh chinh
	*/
	public long getPrimaryKey() {
		return _thuTucHanhChinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this thu tuc hanh chinh.
	*
	* @param primaryKey the primary key of this thu tuc hanh chinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_thuTucHanhChinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this thu tuc hanh chinh.
	*
	* @return the ID of this thu tuc hanh chinh
	*/
	public long getId() {
		return _thuTucHanhChinh.getId();
	}

	/**
	* Sets the ID of this thu tuc hanh chinh.
	*
	* @param id the ID of this thu tuc hanh chinh
	*/
	public void setId(long id) {
		_thuTucHanhChinh.setId(id);
	}

	/**
	* Returns the ma of this thu tuc hanh chinh.
	*
	* @return the ma of this thu tuc hanh chinh
	*/
	public java.lang.String getMa() {
		return _thuTucHanhChinh.getMa();
	}

	/**
	* Sets the ma of this thu tuc hanh chinh.
	*
	* @param ma the ma of this thu tuc hanh chinh
	*/
	public void setMa(java.lang.String ma) {
		_thuTucHanhChinh.setMa(ma);
	}

	/**
	* Returns the ten of this thu tuc hanh chinh.
	*
	* @return the ten of this thu tuc hanh chinh
	*/
	public java.lang.String getTen() {
		return _thuTucHanhChinh.getTen();
	}

	/**
	* Sets the ten of this thu tuc hanh chinh.
	*
	* @param ten the ten of this thu tuc hanh chinh
	*/
	public void setTen(java.lang.String ten) {
		_thuTucHanhChinh.setTen(ten);
	}

	/**
	* Returns the so ngay xu ly of this thu tuc hanh chinh.
	*
	* @return the so ngay xu ly of this thu tuc hanh chinh
	*/
	public long getSoNgayXuLy() {
		return _thuTucHanhChinh.getSoNgayXuLy();
	}

	/**
	* Sets the so ngay xu ly of this thu tuc hanh chinh.
	*
	* @param soNgayXuLy the so ngay xu ly of this thu tuc hanh chinh
	*/
	public void setSoNgayXuLy(long soNgayXuLy) {
		_thuTucHanhChinh.setSoNgayXuLy(soNgayXuLy);
	}

	/**
	* Returns the ngay tao of this thu tuc hanh chinh.
	*
	* @return the ngay tao of this thu tuc hanh chinh
	*/
	public java.util.Date getNgayTao() {
		return _thuTucHanhChinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this thu tuc hanh chinh.
	*
	* @param ngayTao the ngay tao of this thu tuc hanh chinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_thuTucHanhChinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this thu tuc hanh chinh.
	*
	* @return the ngay sua of this thu tuc hanh chinh
	*/
	public java.util.Date getNgaySua() {
		return _thuTucHanhChinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this thu tuc hanh chinh.
	*
	* @param ngaySua the ngay sua of this thu tuc hanh chinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_thuTucHanhChinh.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this thu tuc hanh chinh.
	*
	* @return the da xoa of this thu tuc hanh chinh
	*/
	public int getDaXoa() {
		return _thuTucHanhChinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this thu tuc hanh chinh.
	*
	* @param daXoa the da xoa of this thu tuc hanh chinh
	*/
	public void setDaXoa(int daXoa) {
		_thuTucHanhChinh.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this thu tuc hanh chinh.
	*
	* @return the nguoi tao of this thu tuc hanh chinh
	*/
	public java.lang.String getNguoiTao() {
		return _thuTucHanhChinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this thu tuc hanh chinh.
	*
	* @param nguoiTao the nguoi tao of this thu tuc hanh chinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_thuTucHanhChinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this thu tuc hanh chinh.
	*
	* @return the nguoi sua of this thu tuc hanh chinh
	*/
	public java.lang.String getNguoiSua() {
		return _thuTucHanhChinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this thu tuc hanh chinh.
	*
	* @param nguoiSua the nguoi sua of this thu tuc hanh chinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_thuTucHanhChinh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the nhom thu tuc hanh chinh ID of this thu tuc hanh chinh.
	*
	* @return the nhom thu tuc hanh chinh ID of this thu tuc hanh chinh
	*/
	public long getNhomThuTucHanhChinhId() {
		return _thuTucHanhChinh.getNhomThuTucHanhChinhId();
	}

	/**
	* Sets the nhom thu tuc hanh chinh ID of this thu tuc hanh chinh.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID of this thu tuc hanh chinh
	*/
	public void setNhomThuTucHanhChinhId(long nhomThuTucHanhChinhId) {
		_thuTucHanhChinh.setNhomThuTucHanhChinhId(nhomThuTucHanhChinhId);
	}

	/**
	* Returns the trang thai of this thu tuc hanh chinh.
	*
	* @return the trang thai of this thu tuc hanh chinh
	*/
	public int getTrangThai() {
		return _thuTucHanhChinh.getTrangThai();
	}

	/**
	* Sets the trang thai of this thu tuc hanh chinh.
	*
	* @param trangThai the trang thai of this thu tuc hanh chinh
	*/
	public void setTrangThai(int trangThai) {
		_thuTucHanhChinh.setTrangThai(trangThai);
	}

	/**
	* Returns the phien ban of this thu tuc hanh chinh.
	*
	* @return the phien ban of this thu tuc hanh chinh
	*/
	public long getPhienBan() {
		return _thuTucHanhChinh.getPhienBan();
	}

	/**
	* Sets the phien ban of this thu tuc hanh chinh.
	*
	* @param phienBan the phien ban of this thu tuc hanh chinh
	*/
	public void setPhienBan(long phienBan) {
		_thuTucHanhChinh.setPhienBan(phienBan);
	}

	/**
	* Returns the can tich hop of this thu tuc hanh chinh.
	*
	* @return the can tich hop of this thu tuc hanh chinh
	*/
	public int getCanTichHop() {
		return _thuTucHanhChinh.getCanTichHop();
	}

	/**
	* Sets the can tich hop of this thu tuc hanh chinh.
	*
	* @param canTichHop the can tich hop of this thu tuc hanh chinh
	*/
	public void setCanTichHop(int canTichHop) {
		_thuTucHanhChinh.setCanTichHop(canTichHop);
	}

	/**
	* Returns the trinh tu thuc hien of this thu tuc hanh chinh.
	*
	* @return the trinh tu thuc hien of this thu tuc hanh chinh
	*/
	public java.lang.String getTrinhTuThucHien() {
		return _thuTucHanhChinh.getTrinhTuThucHien();
	}

	/**
	* Sets the trinh tu thuc hien of this thu tuc hanh chinh.
	*
	* @param trinhTuThucHien the trinh tu thuc hien of this thu tuc hanh chinh
	*/
	public void setTrinhTuThucHien(java.lang.String trinhTuThucHien) {
		_thuTucHanhChinh.setTrinhTuThucHien(trinhTuThucHien);
	}

	/**
	* Returns the cach thuc hien of this thu tuc hanh chinh.
	*
	* @return the cach thuc hien of this thu tuc hanh chinh
	*/
	public java.lang.String getCachThucHien() {
		return _thuTucHanhChinh.getCachThucHien();
	}

	/**
	* Sets the cach thuc hien of this thu tuc hanh chinh.
	*
	* @param cachThucHien the cach thuc hien of this thu tuc hanh chinh
	*/
	public void setCachThucHien(java.lang.String cachThucHien) {
		_thuTucHanhChinh.setCachThucHien(cachThucHien);
	}

	/**
	* Returns the thanh phan ho so of this thu tuc hanh chinh.
	*
	* @return the thanh phan ho so of this thu tuc hanh chinh
	*/
	public java.lang.String getThanhPhanHoSo() {
		return _thuTucHanhChinh.getThanhPhanHoSo();
	}

	/**
	* Sets the thanh phan ho so of this thu tuc hanh chinh.
	*
	* @param thanhPhanHoSo the thanh phan ho so of this thu tuc hanh chinh
	*/
	public void setThanhPhanHoSo(java.lang.String thanhPhanHoSo) {
		_thuTucHanhChinh.setThanhPhanHoSo(thanhPhanHoSo);
	}

	/**
	* Returns the le phi of this thu tuc hanh chinh.
	*
	* @return the le phi of this thu tuc hanh chinh
	*/
	public long getLePhi() {
		return _thuTucHanhChinh.getLePhi();
	}

	/**
	* Sets the le phi of this thu tuc hanh chinh.
	*
	* @param lePhi the le phi of this thu tuc hanh chinh
	*/
	public void setLePhi(long lePhi) {
		_thuTucHanhChinh.setLePhi(lePhi);
	}

	/**
	* Returns the don vi le phi of this thu tuc hanh chinh.
	*
	* @return the don vi le phi of this thu tuc hanh chinh
	*/
	public java.lang.String getDonViLePhi() {
		return _thuTucHanhChinh.getDonViLePhi();
	}

	/**
	* Sets the don vi le phi of this thu tuc hanh chinh.
	*
	* @param donViLePhi the don vi le phi of this thu tuc hanh chinh
	*/
	public void setDonViLePhi(java.lang.String donViLePhi) {
		_thuTucHanhChinh.setDonViLePhi(donViLePhi);
	}

	/**
	* Returns the phi of this thu tuc hanh chinh.
	*
	* @return the phi of this thu tuc hanh chinh
	*/
	public long getPhi() {
		return _thuTucHanhChinh.getPhi();
	}

	/**
	* Sets the phi of this thu tuc hanh chinh.
	*
	* @param phi the phi of this thu tuc hanh chinh
	*/
	public void setPhi(long phi) {
		_thuTucHanhChinh.setPhi(phi);
	}

	/**
	* Returns the don vi phi of this thu tuc hanh chinh.
	*
	* @return the don vi phi of this thu tuc hanh chinh
	*/
	public java.lang.String getDonViPhi() {
		return _thuTucHanhChinh.getDonViPhi();
	}

	/**
	* Sets the don vi phi of this thu tuc hanh chinh.
	*
	* @param donViPhi the don vi phi of this thu tuc hanh chinh
	*/
	public void setDonViPhi(java.lang.String donViPhi) {
		_thuTucHanhChinh.setDonViPhi(donViPhi);
	}

	/**
	* Returns the ten mau don to khai of this thu tuc hanh chinh.
	*
	* @return the ten mau don to khai of this thu tuc hanh chinh
	*/
	public java.lang.String getTenMauDonToKhai() {
		return _thuTucHanhChinh.getTenMauDonToKhai();
	}

	/**
	* Sets the ten mau don to khai of this thu tuc hanh chinh.
	*
	* @param tenMauDonToKhai the ten mau don to khai of this thu tuc hanh chinh
	*/
	public void setTenMauDonToKhai(java.lang.String tenMauDonToKhai) {
		_thuTucHanhChinh.setTenMauDonToKhai(tenMauDonToKhai);
	}

	/**
	* Returns the yeu cau dieu kien thuc hien of this thu tuc hanh chinh.
	*
	* @return the yeu cau dieu kien thuc hien of this thu tuc hanh chinh
	*/
	public java.lang.String getYeuCauDieuKienThucHien() {
		return _thuTucHanhChinh.getYeuCauDieuKienThucHien();
	}

	/**
	* Sets the yeu cau dieu kien thuc hien of this thu tuc hanh chinh.
	*
	* @param yeuCauDieuKienThucHien the yeu cau dieu kien thuc hien of this thu tuc hanh chinh
	*/
	public void setYeuCauDieuKienThucHien(
		java.lang.String yeuCauDieuKienThucHien) {
		_thuTucHanhChinh.setYeuCauDieuKienThucHien(yeuCauDieuKienThucHien);
	}

	/**
	* Returns the can cu phap ly of this thu tuc hanh chinh.
	*
	* @return the can cu phap ly of this thu tuc hanh chinh
	*/
	public java.lang.String getCanCuPhapLy() {
		return _thuTucHanhChinh.getCanCuPhapLy();
	}

	/**
	* Sets the can cu phap ly of this thu tuc hanh chinh.
	*
	* @param canCuPhapLy the can cu phap ly of this thu tuc hanh chinh
	*/
	public void setCanCuPhapLy(java.lang.String canCuPhapLy) {
		_thuTucHanhChinh.setCanCuPhapLy(canCuPhapLy);
	}

	/**
	* Returns the cap co quan quan ly ID of this thu tuc hanh chinh.
	*
	* @return the cap co quan quan ly ID of this thu tuc hanh chinh
	*/
	public java.lang.Long getCapCoQuanQuanLyId() {
		return _thuTucHanhChinh.getCapCoQuanQuanLyId();
	}

	/**
	* Sets the cap co quan quan ly ID of this thu tuc hanh chinh.
	*
	* @param capCoQuanQuanLyId the cap co quan quan ly ID of this thu tuc hanh chinh
	*/
	public void setCapCoQuanQuanLyId(java.lang.Long capCoQuanQuanLyId) {
		_thuTucHanhChinh.setCapCoQuanQuanLyId(capCoQuanQuanLyId);
	}

	/**
	* Returns the linh vuc thuc hien of this thu tuc hanh chinh.
	*
	* @return the linh vuc thuc hien of this thu tuc hanh chinh
	*/
	public java.lang.String getLinhVucThucHien() {
		return _thuTucHanhChinh.getLinhVucThucHien();
	}

	/**
	* Sets the linh vuc thuc hien of this thu tuc hanh chinh.
	*
	* @param linhVucThucHien the linh vuc thuc hien of this thu tuc hanh chinh
	*/
	public void setLinhVucThucHien(java.lang.String linhVucThucHien) {
		_thuTucHanhChinh.setLinhVucThucHien(linhVucThucHien);
	}

	/**
	* Returns the ma d n g of this thu tuc hanh chinh.
	*
	* @return the ma d n g of this thu tuc hanh chinh
	*/
	public java.lang.String getMaDNG() {
		return _thuTucHanhChinh.getMaDNG();
	}

	/**
	* Sets the ma d n g of this thu tuc hanh chinh.
	*
	* @param maDNG the ma d n g of this thu tuc hanh chinh
	*/
	public void setMaDNG(java.lang.String maDNG) {
		_thuTucHanhChinh.setMaDNG(maDNG);
	}

	/**
	* Returns the uengine process name of this thu tuc hanh chinh.
	*
	* @return the uengine process name of this thu tuc hanh chinh
	*/
	public java.lang.String getUengineProcessName() {
		return _thuTucHanhChinh.getUengineProcessName();
	}

	/**
	* Sets the uengine process name of this thu tuc hanh chinh.
	*
	* @param uengineProcessName the uengine process name of this thu tuc hanh chinh
	*/
	public void setUengineProcessName(java.lang.String uengineProcessName) {
		_thuTucHanhChinh.setUengineProcessName(uengineProcessName);
	}

	/**
	* Returns the thu tuc lien thong ID of this thu tuc hanh chinh.
	*
	* @return the thu tuc lien thong ID of this thu tuc hanh chinh
	*/
	public java.lang.Long getThuTucLienThongId() {
		return _thuTucHanhChinh.getThuTucLienThongId();
	}

	/**
	* Sets the thu tuc lien thong ID of this thu tuc hanh chinh.
	*
	* @param thuTucLienThongId the thu tuc lien thong ID of this thu tuc hanh chinh
	*/
	public void setThuTucLienThongId(java.lang.Long thuTucLienThongId) {
		_thuTucHanhChinh.setThuTucLienThongId(thuTucLienThongId);
	}

	public boolean isNew() {
		return _thuTucHanhChinh.isNew();
	}

	public void setNew(boolean n) {
		_thuTucHanhChinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _thuTucHanhChinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_thuTucHanhChinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _thuTucHanhChinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _thuTucHanhChinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_thuTucHanhChinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _thuTucHanhChinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_thuTucHanhChinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ThuTucHanhChinhWrapper((ThuTucHanhChinh)_thuTucHanhChinh.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh) {
		return _thuTucHanhChinh.compareTo(thuTucHanhChinh);
	}

	@Override
	public int hashCode() {
		return _thuTucHanhChinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> toCacheModel() {
		return _thuTucHanhChinh.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh toEscapedModel() {
		return new ThuTucHanhChinhWrapper(_thuTucHanhChinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _thuTucHanhChinh.toString();
	}

	public java.lang.String toXmlString() {
		return _thuTucHanhChinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_thuTucHanhChinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ThuTucHanhChinh getWrappedThuTucHanhChinh() {
		return _thuTucHanhChinh;
	}

	public ThuTucHanhChinh getWrappedModel() {
		return _thuTucHanhChinh;
	}

	public void resetOriginalValues() {
		_thuTucHanhChinh.resetOriginalValues();
	}

	private ThuTucHanhChinh _thuTucHanhChinh;
}