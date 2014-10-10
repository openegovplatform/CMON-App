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

package org.oep.cmon.dao.chungthuc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoChungThuc}.
 * </p>
 *
 * @author    vietho
 * @see       HoSoChungThuc
 * @generated
 */
public class HoSoChungThucWrapper implements HoSoChungThuc,
	ModelWrapper<HoSoChungThuc> {
	public HoSoChungThucWrapper(HoSoChungThuc hoSoChungThuc) {
		_hoSoChungThuc = hoSoChungThuc;
	}

	public Class<?> getModelClass() {
		return HoSoChungThuc.class;
	}

	public String getModelClassName() {
		return HoSoChungThuc.class.getName();
	}

	/**
	* Returns the primary key of this ho so chung thuc.
	*
	* @return the primary key of this ho so chung thuc
	*/
	public long getPrimaryKey() {
		return _hoSoChungThuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho so chung thuc.
	*
	* @param primaryKey the primary key of this ho so chung thuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoSoChungThuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ho so chung thuc ID of this ho so chung thuc.
	*
	* @return the ho so chung thuc ID of this ho so chung thuc
	*/
	public long getHoSoChungThucId() {
		return _hoSoChungThuc.getHoSoChungThucId();
	}

	/**
	* Sets the ho so chung thuc ID of this ho so chung thuc.
	*
	* @param hoSoChungThucId the ho so chung thuc ID of this ho so chung thuc
	*/
	public void setHoSoChungThucId(long hoSoChungThucId) {
		_hoSoChungThuc.setHoSoChungThucId(hoSoChungThucId);
	}

	/**
	* Returns the ten chung thuc of this ho so chung thuc.
	*
	* @return the ten chung thuc of this ho so chung thuc
	*/
	public java.lang.String getTenChungThuc() {
		return _hoSoChungThuc.getTenChungThuc();
	}

	/**
	* Sets the ten chung thuc of this ho so chung thuc.
	*
	* @param tenChungThuc the ten chung thuc of this ho so chung thuc
	*/
	public void setTenChungThuc(java.lang.String tenChungThuc) {
		_hoSoChungThuc.setTenChungThuc(tenChungThuc);
	}

	/**
	* Returns the so chung thuc of this ho so chung thuc.
	*
	* @return the so chung thuc of this ho so chung thuc
	*/
	public java.lang.String getSoChungThuc() {
		return _hoSoChungThuc.getSoChungThuc();
	}

	/**
	* Sets the so chung thuc of this ho so chung thuc.
	*
	* @param soChungThuc the so chung thuc of this ho so chung thuc
	*/
	public void setSoChungThuc(java.lang.String soChungThuc) {
		_hoSoChungThuc.setSoChungThuc(soChungThuc);
	}

	/**
	* Returns the ngay nop ho so of this ho so chung thuc.
	*
	* @return the ngay nop ho so of this ho so chung thuc
	*/
	public java.util.Date getNgayNopHoSo() {
		return _hoSoChungThuc.getNgayNopHoSo();
	}

	/**
	* Sets the ngay nop ho so of this ho so chung thuc.
	*
	* @param ngayNopHoSo the ngay nop ho so of this ho so chung thuc
	*/
	public void setNgayNopHoSo(java.util.Date ngayNopHoSo) {
		_hoSoChungThuc.setNgayNopHoSo(ngayNopHoSo);
	}

	/**
	* Returns the ngay tra ket qua of this ho so chung thuc.
	*
	* @return the ngay tra ket qua of this ho so chung thuc
	*/
	public java.util.Date getNgayTraKetQua() {
		return _hoSoChungThuc.getNgayTraKetQua();
	}

	/**
	* Sets the ngay tra ket qua of this ho so chung thuc.
	*
	* @param ngayTraKetQua the ngay tra ket qua of this ho so chung thuc
	*/
	public void setNgayTraKetQua(java.util.Date ngayTraKetQua) {
		_hoSoChungThuc.setNgayTraKetQua(ngayTraKetQua);
	}

	/**
	* Returns the ho ten nguoi nop ho so of this ho so chung thuc.
	*
	* @return the ho ten nguoi nop ho so of this ho so chung thuc
	*/
	public java.lang.String getHoTenNguoiNopHoSo() {
		return _hoSoChungThuc.getHoTenNguoiNopHoSo();
	}

	/**
	* Sets the ho ten nguoi nop ho so of this ho so chung thuc.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so of this ho so chung thuc
	*/
	public void setHoTenNguoiNopHoSo(java.lang.String hoTenNguoiNopHoSo) {
		_hoSoChungThuc.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
	}

	/**
	* Returns the dia chi thuong tru nguoi nop of this ho so chung thuc.
	*
	* @return the dia chi thuong tru nguoi nop of this ho so chung thuc
	*/
	public java.lang.String getDiaChiThuongTruNguoiNop() {
		return _hoSoChungThuc.getDiaChiThuongTruNguoiNop();
	}

	/**
	* Sets the dia chi thuong tru nguoi nop of this ho so chung thuc.
	*
	* @param diaChiThuongTruNguoiNop the dia chi thuong tru nguoi nop of this ho so chung thuc
	*/
	public void setDiaChiThuongTruNguoiNop(
		java.lang.String diaChiThuongTruNguoiNop) {
		_hoSoChungThuc.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
	}

	/**
	* Returns the so dien thoai co dinh nguoi nop of this ho so chung thuc.
	*
	* @return the so dien thoai co dinh nguoi nop of this ho so chung thuc
	*/
	public java.lang.String getSoDienThoaiCoDinhNguoiNop() {
		return _hoSoChungThuc.getSoDienThoaiCoDinhNguoiNop();
	}

	/**
	* Sets the so dien thoai co dinh nguoi nop of this ho so chung thuc.
	*
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop of this ho so chung thuc
	*/
	public void setSoDienThoaiCoDinhNguoiNop(
		java.lang.String soDienThoaiCoDinhNguoiNop) {
		_hoSoChungThuc.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
	}

	/**
	* Returns the trang thai ho so of this ho so chung thuc.
	*
	* @return the trang thai ho so of this ho so chung thuc
	*/
	public int getTrangThaiHoSo() {
		return _hoSoChungThuc.getTrangThaiHoSo();
	}

	/**
	* Sets the trang thai ho so of this ho so chung thuc.
	*
	* @param trangThaiHoSo the trang thai ho so of this ho so chung thuc
	*/
	public void setTrangThaiHoSo(int trangThaiHoSo) {
		_hoSoChungThuc.setTrangThaiHoSo(trangThaiHoSo);
	}

	/**
	* Returns the da xoa of this ho so chung thuc.
	*
	* @return the da xoa of this ho so chung thuc
	*/
	public int getDaXoa() {
		return _hoSoChungThuc.getDaXoa();
	}

	/**
	* Sets the da xoa of this ho so chung thuc.
	*
	* @param daXoa the da xoa of this ho so chung thuc
	*/
	public void setDaXoa(int daXoa) {
		_hoSoChungThuc.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this ho so chung thuc.
	*
	* @return the nguoi tao of this ho so chung thuc
	*/
	public java.lang.String getNguoiTao() {
		return _hoSoChungThuc.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this ho so chung thuc.
	*
	* @param nguoiTao the nguoi tao of this ho so chung thuc
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_hoSoChungThuc.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this ho so chung thuc.
	*
	* @return the ngay tao of this ho so chung thuc
	*/
	public java.util.Date getNgayTao() {
		return _hoSoChungThuc.getNgayTao();
	}

	/**
	* Sets the ngay tao of this ho so chung thuc.
	*
	* @param ngayTao the ngay tao of this ho so chung thuc
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_hoSoChungThuc.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this ho so chung thuc.
	*
	* @return the nguoi sua of this ho so chung thuc
	*/
	public java.lang.String getNguoiSua() {
		return _hoSoChungThuc.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this ho so chung thuc.
	*
	* @param nguoiSua the nguoi sua of this ho so chung thuc
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_hoSoChungThuc.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this ho so chung thuc.
	*
	* @return the ngay sua of this ho so chung thuc
	*/
	public java.util.Date getNgaySua() {
		return _hoSoChungThuc.getNgaySua();
	}

	/**
	* Sets the ngay sua of this ho so chung thuc.
	*
	* @param ngaySua the ngay sua of this ho so chung thuc
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_hoSoChungThuc.setNgaySua(ngaySua);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this ho so chung thuc.
	*
	* @return the thu tuc hanh chinh ID of this ho so chung thuc
	*/
	public java.lang.Long getThuTucHanhChinhId() {
		return _hoSoChungThuc.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this ho so chung thuc.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this ho so chung thuc
	*/
	public void setThuTucHanhChinhId(java.lang.Long thuTucHanhChinhId) {
		_hoSoChungThuc.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the can bo tiep nhan ID of this ho so chung thuc.
	*
	* @return the can bo tiep nhan ID of this ho so chung thuc
	*/
	public java.lang.Long getCanBoTiepNhanId() {
		return _hoSoChungThuc.getCanBoTiepNhanId();
	}

	/**
	* Sets the can bo tiep nhan ID of this ho so chung thuc.
	*
	* @param canBoTiepNhanId the can bo tiep nhan ID of this ho so chung thuc
	*/
	public void setCanBoTiepNhanId(java.lang.Long canBoTiepNhanId) {
		_hoSoChungThuc.setCanBoTiepNhanId(canBoTiepNhanId);
	}

	/**
	* Returns the so dien thoai di dong nguoi nop of this ho so chung thuc.
	*
	* @return the so dien thoai di dong nguoi nop of this ho so chung thuc
	*/
	public java.lang.String getSoDienThoaiDiDongNguoiNop() {
		return _hoSoChungThuc.getSoDienThoaiDiDongNguoiNop();
	}

	/**
	* Sets the so dien thoai di dong nguoi nop of this ho so chung thuc.
	*
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop of this ho so chung thuc
	*/
	public void setSoDienThoaiDiDongNguoiNop(
		java.lang.String soDienThoaiDiDongNguoiNop) {
		_hoSoChungThuc.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
	}

	/**
	* Returns the ghi chu of this ho so chung thuc.
	*
	* @return the ghi chu of this ho so chung thuc
	*/
	public java.lang.String getGhiChu() {
		return _hoSoChungThuc.getGhiChu();
	}

	/**
	* Sets the ghi chu of this ho so chung thuc.
	*
	* @param ghiChu the ghi chu of this ho so chung thuc
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_hoSoChungThuc.setGhiChu(ghiChu);
	}

	/**
	* Returns the muc dich chung thuc of this ho so chung thuc.
	*
	* @return the muc dich chung thuc of this ho so chung thuc
	*/
	public java.lang.String getMucDichChungThuc() {
		return _hoSoChungThuc.getMucDichChungThuc();
	}

	/**
	* Sets the muc dich chung thuc of this ho so chung thuc.
	*
	* @param mucDichChungThuc the muc dich chung thuc of this ho so chung thuc
	*/
	public void setMucDichChungThuc(java.lang.String mucDichChungThuc) {
		_hoSoChungThuc.setMucDichChungThuc(mucDichChungThuc);
	}

	/**
	* Returns the ma so bien nhan of this ho so chung thuc.
	*
	* @return the ma so bien nhan of this ho so chung thuc
	*/
	public java.lang.String getMaSoBienNhan() {
		return _hoSoChungThuc.getMaSoBienNhan();
	}

	/**
	* Sets the ma so bien nhan of this ho so chung thuc.
	*
	* @param maSoBienNhan the ma so bien nhan of this ho so chung thuc
	*/
	public void setMaSoBienNhan(java.lang.String maSoBienNhan) {
		_hoSoChungThuc.setMaSoBienNhan(maSoBienNhan);
	}

	/**
	* Returns the chu so huu of this ho so chung thuc.
	*
	* @return the chu so huu of this ho so chung thuc
	*/
	public java.lang.String getChuSoHuu() {
		return _hoSoChungThuc.getChuSoHuu();
	}

	/**
	* Sets the chu so huu of this ho so chung thuc.
	*
	* @param chuSoHuu the chu so huu of this ho so chung thuc
	*/
	public void setChuSoHuu(java.lang.String chuSoHuu) {
		_hoSoChungThuc.setChuSoHuu(chuSoHuu);
	}

	/**
	* Returns the so bo ho so of this ho so chung thuc.
	*
	* @return the so bo ho so of this ho so chung thuc
	*/
	public int getSoBoHoSo() {
		return _hoSoChungThuc.getSoBoHoSo();
	}

	/**
	* Sets the so bo ho so of this ho so chung thuc.
	*
	* @param soBoHoSo the so bo ho so of this ho so chung thuc
	*/
	public void setSoBoHoSo(int soBoHoSo) {
		_hoSoChungThuc.setSoBoHoSo(soBoHoSo);
	}

	/**
	* Returns the so to of this ho so chung thuc.
	*
	* @return the so to of this ho so chung thuc
	*/
	public int getSoTo() {
		return _hoSoChungThuc.getSoTo();
	}

	/**
	* Sets the so to of this ho so chung thuc.
	*
	* @param soTo the so to of this ho so chung thuc
	*/
	public void setSoTo(int soTo) {
		_hoSoChungThuc.setSoTo(soTo);
	}

	/**
	* Returns the truong hop of this ho so chung thuc.
	*
	* @return the truong hop of this ho so chung thuc
	*/
	public java.lang.String getTruongHop() {
		return _hoSoChungThuc.getTruongHop();
	}

	/**
	* Sets the truong hop of this ho so chung thuc.
	*
	* @param truongHop the truong hop of this ho so chung thuc
	*/
	public void setTruongHop(java.lang.String truongHop) {
		_hoSoChungThuc.setTruongHop(truongHop);
	}

	/**
	* Returns the le phi of this ho so chung thuc.
	*
	* @return the le phi of this ho so chung thuc
	*/
	public int getLePhi() {
		return _hoSoChungThuc.getLePhi();
	}

	/**
	* Sets the le phi of this ho so chung thuc.
	*
	* @param lePhi the le phi of this ho so chung thuc
	*/
	public void setLePhi(int lePhi) {
		_hoSoChungThuc.setLePhi(lePhi);
	}

	/**
	* Returns the phi ho so of this ho so chung thuc.
	*
	* @return the phi ho so of this ho so chung thuc
	*/
	public int getPhiHoSo() {
		return _hoSoChungThuc.getPhiHoSo();
	}

	/**
	* Sets the phi ho so of this ho so chung thuc.
	*
	* @param phiHoSo the phi ho so of this ho so chung thuc
	*/
	public void setPhiHoSo(int phiHoSo) {
		_hoSoChungThuc.setPhiHoSo(phiHoSo);
	}

	/**
	* Returns the email nguoi nop of this ho so chung thuc.
	*
	* @return the email nguoi nop of this ho so chung thuc
	*/
	public java.lang.String getEmailNguoiNop() {
		return _hoSoChungThuc.getEmailNguoiNop();
	}

	/**
	* Sets the email nguoi nop of this ho so chung thuc.
	*
	* @param emailNguoiNop the email nguoi nop of this ho so chung thuc
	*/
	public void setEmailNguoiNop(java.lang.String emailNguoiNop) {
		_hoSoChungThuc.setEmailNguoiNop(emailNguoiNop);
	}

	/**
	* Returns the ngay sinh nguoi nop of this ho so chung thuc.
	*
	* @return the ngay sinh nguoi nop of this ho so chung thuc
	*/
	public java.util.Date getNgaySinhNguoiNop() {
		return _hoSoChungThuc.getNgaySinhNguoiNop();
	}

	/**
	* Sets the ngay sinh nguoi nop of this ho so chung thuc.
	*
	* @param ngaySinhNguoiNop the ngay sinh nguoi nop of this ho so chung thuc
	*/
	public void setNgaySinhNguoiNop(java.util.Date ngaySinhNguoiNop) {
		_hoSoChungThuc.setNgaySinhNguoiNop(ngaySinhNguoiNop);
	}

	/**
	* Returns the so c m n d nguoi nop of this ho so chung thuc.
	*
	* @return the so c m n d nguoi nop of this ho so chung thuc
	*/
	public java.lang.String getSoCMNDNguoiNop() {
		return _hoSoChungThuc.getSoCMNDNguoiNop();
	}

	/**
	* Sets the so c m n d nguoi nop of this ho so chung thuc.
	*
	* @param soCMNDNguoiNop the so c m n d nguoi nop of this ho so chung thuc
	*/
	public void setSoCMNDNguoiNop(java.lang.String soCMNDNguoiNop) {
		_hoSoChungThuc.setSoCMNDNguoiNop(soCMNDNguoiNop);
	}

	/**
	* Returns the gioi tinh nguoi nop of this ho so chung thuc.
	*
	* @return the gioi tinh nguoi nop of this ho so chung thuc
	*/
	public int getGioiTinhNguoiNop() {
		return _hoSoChungThuc.getGioiTinhNguoiNop();
	}

	/**
	* Sets the gioi tinh nguoi nop of this ho so chung thuc.
	*
	* @param gioiTinhNguoiNop the gioi tinh nguoi nop of this ho so chung thuc
	*/
	public void setGioiTinhNguoiNop(int gioiTinhNguoiNop) {
		_hoSoChungThuc.setGioiTinhNguoiNop(gioiTinhNguoiNop);
	}

	/**
	* Returns the ten can bo ky of this ho so chung thuc.
	*
	* @return the ten can bo ky of this ho so chung thuc
	*/
	public java.lang.String getTenCanBoKy() {
		return _hoSoChungThuc.getTenCanBoKy();
	}

	/**
	* Sets the ten can bo ky of this ho so chung thuc.
	*
	* @param tenCanBoKy the ten can bo ky of this ho so chung thuc
	*/
	public void setTenCanBoKy(java.lang.String tenCanBoKy) {
		_hoSoChungThuc.setTenCanBoKy(tenCanBoKy);
	}

	/**
	* Returns the chuc vu can bo ky ID of this ho so chung thuc.
	*
	* @return the chuc vu can bo ky ID of this ho so chung thuc
	*/
	public java.lang.Long getChucVuCanBoKyId() {
		return _hoSoChungThuc.getChucVuCanBoKyId();
	}

	/**
	* Sets the chuc vu can bo ky ID of this ho so chung thuc.
	*
	* @param chucVuCanBoKyId the chuc vu can bo ky ID of this ho so chung thuc
	*/
	public void setChucVuCanBoKyId(java.lang.Long chucVuCanBoKyId) {
		_hoSoChungThuc.setChucVuCanBoKyId(chucVuCanBoKyId);
	}

	/**
	* Returns the so danh muc ID of this ho so chung thuc.
	*
	* @return the so danh muc ID of this ho so chung thuc
	*/
	public java.lang.Long getSoDanhMucId() {
		return _hoSoChungThuc.getSoDanhMucId();
	}

	/**
	* Sets the so danh muc ID of this ho so chung thuc.
	*
	* @param soDanhMucId the so danh muc ID of this ho so chung thuc
	*/
	public void setSoDanhMucId(java.lang.Long soDanhMucId) {
		_hoSoChungThuc.setSoDanhMucId(soDanhMucId);
	}

	/**
	* Returns the thuong tru tinh ID of this ho so chung thuc.
	*
	* @return the thuong tru tinh ID of this ho so chung thuc
	*/
	public java.lang.Long getThuongTruTinhId() {
		return _hoSoChungThuc.getThuongTruTinhId();
	}

	/**
	* Sets the thuong tru tinh ID of this ho so chung thuc.
	*
	* @param thuongTruTinhId the thuong tru tinh ID of this ho so chung thuc
	*/
	public void setThuongTruTinhId(java.lang.Long thuongTruTinhId) {
		_hoSoChungThuc.setThuongTruTinhId(thuongTruTinhId);
	}

	/**
	* Returns the thuong tru huyen ID of this ho so chung thuc.
	*
	* @return the thuong tru huyen ID of this ho so chung thuc
	*/
	public java.lang.Long getThuongTruHuyenId() {
		return _hoSoChungThuc.getThuongTruHuyenId();
	}

	/**
	* Sets the thuong tru huyen ID of this ho so chung thuc.
	*
	* @param thuongTruHuyenId the thuong tru huyen ID of this ho so chung thuc
	*/
	public void setThuongTruHuyenId(java.lang.Long thuongTruHuyenId) {
		_hoSoChungThuc.setThuongTruHuyenId(thuongTruHuyenId);
	}

	/**
	* Returns the thuong tru xa ID of this ho so chung thuc.
	*
	* @return the thuong tru xa ID of this ho so chung thuc
	*/
	public java.lang.Long getThuongTruXaId() {
		return _hoSoChungThuc.getThuongTruXaId();
	}

	/**
	* Sets the thuong tru xa ID of this ho so chung thuc.
	*
	* @param thuongTruXaId the thuong tru xa ID of this ho so chung thuc
	*/
	public void setThuongTruXaId(java.lang.Long thuongTruXaId) {
		_hoSoChungThuc.setThuongTruXaId(thuongTruXaId);
	}

	public boolean isNew() {
		return _hoSoChungThuc.isNew();
	}

	public void setNew(boolean n) {
		_hoSoChungThuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoSoChungThuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoSoChungThuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoSoChungThuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoSoChungThuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoSoChungThuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoSoChungThuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoSoChungThuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoSoChungThucWrapper((HoSoChungThuc)_hoSoChungThuc.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.chungthuc.model.HoSoChungThuc hoSoChungThuc) {
		return _hoSoChungThuc.compareTo(hoSoChungThuc);
	}

	@Override
	public int hashCode() {
		return _hoSoChungThuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> toCacheModel() {
		return _hoSoChungThuc.toCacheModel();
	}

	public org.oep.cmon.dao.chungthuc.model.HoSoChungThuc toEscapedModel() {
		return new HoSoChungThucWrapper(_hoSoChungThuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoSoChungThuc.toString();
	}

	public java.lang.String toXmlString() {
		return _hoSoChungThuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoChungThuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoSoChungThuc getWrappedHoSoChungThuc() {
		return _hoSoChungThuc;
	}

	public HoSoChungThuc getWrappedModel() {
		return _hoSoChungThuc;
	}

	public void resetOriginalValues() {
		_hoSoChungThuc.resetOriginalValues();
	}

	private HoSoChungThuc _hoSoChungThuc;
}