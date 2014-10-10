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

package org.oep.cmon.dao.hosolienthong.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoLienThong}.
 * </p>
 *
 * @author    hoangtrung.nguyen
 * @see       HoSoLienThong
 * @generated
 */
public class HoSoLienThongWrapper implements HoSoLienThong,
	ModelWrapper<HoSoLienThong> {
	public HoSoLienThongWrapper(HoSoLienThong hoSoLienThong) {
		_hoSoLienThong = hoSoLienThong;
	}

	public Class<?> getModelClass() {
		return HoSoLienThong.class;
	}

	public String getModelClassName() {
		return HoSoLienThong.class.getName();
	}

	/**
	* Returns the primary key of this ho so lien thong.
	*
	* @return the primary key of this ho so lien thong
	*/
	public long getPrimaryKey() {
		return _hoSoLienThong.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho so lien thong.
	*
	* @param primaryKey the primary key of this ho so lien thong
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoSoLienThong.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ho so lien thong.
	*
	* @return the ID of this ho so lien thong
	*/
	public long getId() {
		return _hoSoLienThong.getId();
	}

	/**
	* Sets the ID of this ho so lien thong.
	*
	* @param id the ID of this ho so lien thong
	*/
	public void setId(long id) {
		_hoSoLienThong.setId(id);
	}

	/**
	* Returns the ho so ID of this ho so lien thong.
	*
	* @return the ho so ID of this ho so lien thong
	*/
	public long getHoSoId() {
		return _hoSoLienThong.getHoSoId();
	}

	/**
	* Sets the ho so ID of this ho so lien thong.
	*
	* @param hoSoId the ho so ID of this ho so lien thong
	*/
	public void setHoSoId(long hoSoId) {
		_hoSoLienThong.setHoSoId(hoSoId);
	}

	/**
	* Returns the co quan gui ID of this ho so lien thong.
	*
	* @return the co quan gui ID of this ho so lien thong
	*/
	public long getCoQuanGuiId() {
		return _hoSoLienThong.getCoQuanGuiId();
	}

	/**
	* Sets the co quan gui ID of this ho so lien thong.
	*
	* @param coQuanGuiId the co quan gui ID of this ho so lien thong
	*/
	public void setCoQuanGuiId(long coQuanGuiId) {
		_hoSoLienThong.setCoQuanGuiId(coQuanGuiId);
	}

	/**
	* Returns the co quan nhan ID of this ho so lien thong.
	*
	* @return the co quan nhan ID of this ho so lien thong
	*/
	public long getCoQuanNhanId() {
		return _hoSoLienThong.getCoQuanNhanId();
	}

	/**
	* Sets the co quan nhan ID of this ho so lien thong.
	*
	* @param coQuanNhanId the co quan nhan ID of this ho so lien thong
	*/
	public void setCoQuanNhanId(long coQuanNhanId) {
		_hoSoLienThong.setCoQuanNhanId(coQuanNhanId);
	}

	/**
	* Returns the thu tuc gui ID of this ho so lien thong.
	*
	* @return the thu tuc gui ID of this ho so lien thong
	*/
	public long getThuTucGuiId() {
		return _hoSoLienThong.getThuTucGuiId();
	}

	/**
	* Sets the thu tuc gui ID of this ho so lien thong.
	*
	* @param thuTucGuiId the thu tuc gui ID of this ho so lien thong
	*/
	public void setThuTucGuiId(long thuTucGuiId) {
		_hoSoLienThong.setThuTucGuiId(thuTucGuiId);
	}

	/**
	* Returns the thu tuc nhan ID of this ho so lien thong.
	*
	* @return the thu tuc nhan ID of this ho so lien thong
	*/
	public long getThuTucNhanId() {
		return _hoSoLienThong.getThuTucNhanId();
	}

	/**
	* Sets the thu tuc nhan ID of this ho so lien thong.
	*
	* @param thuTucNhanId the thu tuc nhan ID of this ho so lien thong
	*/
	public void setThuTucNhanId(long thuTucNhanId) {
		_hoSoLienThong.setThuTucNhanId(thuTucNhanId);
	}

	/**
	* Returns the ma so bien nhan luc gui of this ho so lien thong.
	*
	* @return the ma so bien nhan luc gui of this ho so lien thong
	*/
	public java.lang.String getMaSoBienNhanLucGui() {
		return _hoSoLienThong.getMaSoBienNhanLucGui();
	}

	/**
	* Sets the ma so bien nhan luc gui of this ho so lien thong.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui of this ho so lien thong
	*/
	public void setMaSoBienNhanLucGui(java.lang.String maSoBienNhanLucGui) {
		_hoSoLienThong.setMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* Returns the ma so bien nhan luc nhan of this ho so lien thong.
	*
	* @return the ma so bien nhan luc nhan of this ho so lien thong
	*/
	public java.lang.String getMaSoBienNhanLucNhan() {
		return _hoSoLienThong.getMaSoBienNhanLucNhan();
	}

	/**
	* Sets the ma so bien nhan luc nhan of this ho so lien thong.
	*
	* @param maSoBienNhanLucNhan the ma so bien nhan luc nhan of this ho so lien thong
	*/
	public void setMaSoBienNhanLucNhan(java.lang.String maSoBienNhanLucNhan) {
		_hoSoLienThong.setMaSoBienNhanLucNhan(maSoBienNhanLucNhan);
	}

	/**
	* Returns the can bo gui ID of this ho so lien thong.
	*
	* @return the can bo gui ID of this ho so lien thong
	*/
	public long getCanBoGuiId() {
		return _hoSoLienThong.getCanBoGuiId();
	}

	/**
	* Sets the can bo gui ID of this ho so lien thong.
	*
	* @param canBoGuiId the can bo gui ID of this ho so lien thong
	*/
	public void setCanBoGuiId(long canBoGuiId) {
		_hoSoLienThong.setCanBoGuiId(canBoGuiId);
	}

	/**
	* Returns the can bo nhan ID of this ho so lien thong.
	*
	* @return the can bo nhan ID of this ho so lien thong
	*/
	public java.lang.Long getCanBoNhanId() {
		return _hoSoLienThong.getCanBoNhanId();
	}

	/**
	* Sets the can bo nhan ID of this ho so lien thong.
	*
	* @param canBoNhanId the can bo nhan ID of this ho so lien thong
	*/
	public void setCanBoNhanId(java.lang.Long canBoNhanId) {
		_hoSoLienThong.setCanBoNhanId(canBoNhanId);
	}

	/**
	* Returns the ngay gui of this ho so lien thong.
	*
	* @return the ngay gui of this ho so lien thong
	*/
	public java.util.Date getNgayGui() {
		return _hoSoLienThong.getNgayGui();
	}

	/**
	* Sets the ngay gui of this ho so lien thong.
	*
	* @param ngayGui the ngay gui of this ho so lien thong
	*/
	public void setNgayGui(java.util.Date ngayGui) {
		_hoSoLienThong.setNgayGui(ngayGui);
	}

	/**
	* Returns the ngay nhan of this ho so lien thong.
	*
	* @return the ngay nhan of this ho so lien thong
	*/
	public java.util.Date getNgayNhan() {
		return _hoSoLienThong.getNgayNhan();
	}

	/**
	* Sets the ngay nhan of this ho so lien thong.
	*
	* @param ngayNhan the ngay nhan of this ho so lien thong
	*/
	public void setNgayNhan(java.util.Date ngayNhan) {
		_hoSoLienThong.setNgayNhan(ngayNhan);
	}

	/**
	* Returns the ho ten can bo gui of this ho so lien thong.
	*
	* @return the ho ten can bo gui of this ho so lien thong
	*/
	public java.lang.String getHoTenCanBoGui() {
		return _hoSoLienThong.getHoTenCanBoGui();
	}

	/**
	* Sets the ho ten can bo gui of this ho so lien thong.
	*
	* @param hoTenCanBoGui the ho ten can bo gui of this ho so lien thong
	*/
	public void setHoTenCanBoGui(java.lang.String hoTenCanBoGui) {
		_hoSoLienThong.setHoTenCanBoGui(hoTenCanBoGui);
	}

	/**
	* Returns the ho ten can bo nhan of this ho so lien thong.
	*
	* @return the ho ten can bo nhan of this ho so lien thong
	*/
	public java.lang.String getHoTenCanBoNhan() {
		return _hoSoLienThong.getHoTenCanBoNhan();
	}

	/**
	* Sets the ho ten can bo nhan of this ho so lien thong.
	*
	* @param hoTenCanBoNhan the ho ten can bo nhan of this ho so lien thong
	*/
	public void setHoTenCanBoNhan(java.lang.String hoTenCanBoNhan) {
		_hoSoLienThong.setHoTenCanBoNhan(hoTenCanBoNhan);
	}

	/**
	* Returns the can bo nop ho so giay ID of this ho so lien thong.
	*
	* @return the can bo nop ho so giay ID of this ho so lien thong
	*/
	public java.lang.Long getCanBoNopHoSoGiayId() {
		return _hoSoLienThong.getCanBoNopHoSoGiayId();
	}

	/**
	* Sets the can bo nop ho so giay ID of this ho so lien thong.
	*
	* @param canBoNopHoSoGiayId the can bo nop ho so giay ID of this ho so lien thong
	*/
	public void setCanBoNopHoSoGiayId(java.lang.Long canBoNopHoSoGiayId) {
		_hoSoLienThong.setCanBoNopHoSoGiayId(canBoNopHoSoGiayId);
	}

	/**
	* Returns the ho ten can bo nop ho so giay of this ho so lien thong.
	*
	* @return the ho ten can bo nop ho so giay of this ho so lien thong
	*/
	public java.lang.String getHoTenCanBoNopHoSoGiay() {
		return _hoSoLienThong.getHoTenCanBoNopHoSoGiay();
	}

	/**
	* Sets the ho ten can bo nop ho so giay of this ho so lien thong.
	*
	* @param hoTenCanBoNopHoSoGiay the ho ten can bo nop ho so giay of this ho so lien thong
	*/
	public void setHoTenCanBoNopHoSoGiay(java.lang.String hoTenCanBoNopHoSoGiay) {
		_hoSoLienThong.setHoTenCanBoNopHoSoGiay(hoTenCanBoNopHoSoGiay);
	}

	/**
	* Returns the trang thai lien thong of this ho so lien thong.
	*
	* @return the trang thai lien thong of this ho so lien thong
	*/
	public int getTrangThaiLienThong() {
		return _hoSoLienThong.getTrangThaiLienThong();
	}

	/**
	* Sets the trang thai lien thong of this ho so lien thong.
	*
	* @param trangThaiLienThong the trang thai lien thong of this ho so lien thong
	*/
	public void setTrangThaiLienThong(int trangThaiLienThong) {
		_hoSoLienThong.setTrangThaiLienThong(trangThaiLienThong);
	}

	/**
	* Returns the ghi chu gui lien thong of this ho so lien thong.
	*
	* @return the ghi chu gui lien thong of this ho so lien thong
	*/
	public java.lang.String getGhiChuGuiLienThong() {
		return _hoSoLienThong.getGhiChuGuiLienThong();
	}

	/**
	* Sets the ghi chu gui lien thong of this ho so lien thong.
	*
	* @param ghiChuGuiLienThong the ghi chu gui lien thong of this ho so lien thong
	*/
	public void setGhiChuGuiLienThong(java.lang.String ghiChuGuiLienThong) {
		_hoSoLienThong.setGhiChuGuiLienThong(ghiChuGuiLienThong);
	}

	/**
	* Returns the ho ten cong dan nop of this ho so lien thong.
	*
	* @return the ho ten cong dan nop of this ho so lien thong
	*/
	public java.lang.String getHoTenCongDanNop() {
		return _hoSoLienThong.getHoTenCongDanNop();
	}

	/**
	* Sets the ho ten cong dan nop of this ho so lien thong.
	*
	* @param hoTenCongDanNop the ho ten cong dan nop of this ho so lien thong
	*/
	public void setHoTenCongDanNop(java.lang.String hoTenCongDanNop) {
		_hoSoLienThong.setHoTenCongDanNop(hoTenCongDanNop);
	}

	/**
	* Returns the dia chi day du cong dan nop of this ho so lien thong.
	*
	* @return the dia chi day du cong dan nop of this ho so lien thong
	*/
	public java.lang.String getDiaChiDayDuCongDanNop() {
		return _hoSoLienThong.getDiaChiDayDuCongDanNop();
	}

	/**
	* Sets the dia chi day du cong dan nop of this ho so lien thong.
	*
	* @param diaChiDayDuCongDanNop the dia chi day du cong dan nop of this ho so lien thong
	*/
	public void setDiaChiDayDuCongDanNop(java.lang.String diaChiDayDuCongDanNop) {
		_hoSoLienThong.setDiaChiDayDuCongDanNop(diaChiDayDuCongDanNop);
	}

	/**
	* Returns the ngay tu choi of this ho so lien thong.
	*
	* @return the ngay tu choi of this ho so lien thong
	*/
	public java.util.Date getNgayTuChoi() {
		return _hoSoLienThong.getNgayTuChoi();
	}

	/**
	* Sets the ngay tu choi of this ho so lien thong.
	*
	* @param ngayTuChoi the ngay tu choi of this ho so lien thong
	*/
	public void setNgayTuChoi(java.util.Date ngayTuChoi) {
		_hoSoLienThong.setNgayTuChoi(ngayTuChoi);
	}

	/**
	* Returns the ngay noi nhan tra ket qua of this ho so lien thong.
	*
	* @return the ngay noi nhan tra ket qua of this ho so lien thong
	*/
	public java.util.Date getNgayNoiNhanTraKetQua() {
		return _hoSoLienThong.getNgayNoiNhanTraKetQua();
	}

	/**
	* Sets the ngay noi nhan tra ket qua of this ho so lien thong.
	*
	* @param ngayNoiNhanTraKetQua the ngay noi nhan tra ket qua of this ho so lien thong
	*/
	public void setNgayNoiNhanTraKetQua(java.util.Date ngayNoiNhanTraKetQua) {
		_hoSoLienThong.setNgayNoiNhanTraKetQua(ngayNoiNhanTraKetQua);
	}

	/**
	* Returns the ngay noi gui nhan ket qua of this ho so lien thong.
	*
	* @return the ngay noi gui nhan ket qua of this ho so lien thong
	*/
	public java.util.Date getNgayNoiGuiNhanKetQua() {
		return _hoSoLienThong.getNgayNoiGuiNhanKetQua();
	}

	/**
	* Sets the ngay noi gui nhan ket qua of this ho so lien thong.
	*
	* @param ngayNoiGuiNhanKetQua the ngay noi gui nhan ket qua of this ho so lien thong
	*/
	public void setNgayNoiGuiNhanKetQua(java.util.Date ngayNoiGuiNhanKetQua) {
		_hoSoLienThong.setNgayNoiGuiNhanKetQua(ngayNoiGuiNhanKetQua);
	}

	/**
	* Returns the can bo tiep nhan noi gui ID of this ho so lien thong.
	*
	* @return the can bo tiep nhan noi gui ID of this ho so lien thong
	*/
	public long getCanBoTiepNhanNoiGuiId() {
		return _hoSoLienThong.getCanBoTiepNhanNoiGuiId();
	}

	/**
	* Sets the can bo tiep nhan noi gui ID of this ho so lien thong.
	*
	* @param canBoTiepNhanNoiGuiId the can bo tiep nhan noi gui ID of this ho so lien thong
	*/
	public void setCanBoTiepNhanNoiGuiId(long canBoTiepNhanNoiGuiId) {
		_hoSoLienThong.setCanBoTiepNhanNoiGuiId(canBoTiepNhanNoiGuiId);
	}

	/**
	* Returns the ho ten can bo tiep nhan noi gui of this ho so lien thong.
	*
	* @return the ho ten can bo tiep nhan noi gui of this ho so lien thong
	*/
	public java.lang.String getHoTenCanBoTiepNhanNoiGui() {
		return _hoSoLienThong.getHoTenCanBoTiepNhanNoiGui();
	}

	/**
	* Sets the ho ten can bo tiep nhan noi gui of this ho so lien thong.
	*
	* @param hoTenCanBoTiepNhanNoiGui the ho ten can bo tiep nhan noi gui of this ho so lien thong
	*/
	public void setHoTenCanBoTiepNhanNoiGui(
		java.lang.String hoTenCanBoTiepNhanNoiGui) {
		_hoSoLienThong.setHoTenCanBoTiepNhanNoiGui(hoTenCanBoTiepNhanNoiGui);
	}

	/**
	* Returns the ten co quan gui of this ho so lien thong.
	*
	* @return the ten co quan gui of this ho so lien thong
	*/
	public java.lang.String getTenCoQuanGui() {
		return _hoSoLienThong.getTenCoQuanGui();
	}

	/**
	* Sets the ten co quan gui of this ho so lien thong.
	*
	* @param tenCoQuanGui the ten co quan gui of this ho so lien thong
	*/
	public void setTenCoQuanGui(java.lang.String tenCoQuanGui) {
		_hoSoLienThong.setTenCoQuanGui(tenCoQuanGui);
	}

	/**
	* Returns the ten thu tuc gui of this ho so lien thong.
	*
	* @return the ten thu tuc gui of this ho so lien thong
	*/
	public java.lang.String getTenThuTucGui() {
		return _hoSoLienThong.getTenThuTucGui();
	}

	/**
	* Sets the ten thu tuc gui of this ho so lien thong.
	*
	* @param tenThuTucGui the ten thu tuc gui of this ho so lien thong
	*/
	public void setTenThuTucGui(java.lang.String tenThuTucGui) {
		_hoSoLienThong.setTenThuTucGui(tenThuTucGui);
	}

	/**
	* Returns the ten co quan nhan of this ho so lien thong.
	*
	* @return the ten co quan nhan of this ho so lien thong
	*/
	public java.lang.String getTenCoQuanNhan() {
		return _hoSoLienThong.getTenCoQuanNhan();
	}

	/**
	* Sets the ten co quan nhan of this ho so lien thong.
	*
	* @param tenCoQuanNhan the ten co quan nhan of this ho so lien thong
	*/
	public void setTenCoQuanNhan(java.lang.String tenCoQuanNhan) {
		_hoSoLienThong.setTenCoQuanNhan(tenCoQuanNhan);
	}

	/**
	* Returns the ten thu tuc nhan of this ho so lien thong.
	*
	* @return the ten thu tuc nhan of this ho so lien thong
	*/
	public java.lang.String getTenThuTucNhan() {
		return _hoSoLienThong.getTenThuTucNhan();
	}

	/**
	* Sets the ten thu tuc nhan of this ho so lien thong.
	*
	* @param tenThuTucNhan the ten thu tuc nhan of this ho so lien thong
	*/
	public void setTenThuTucNhan(java.lang.String tenThuTucNhan) {
		_hoSoLienThong.setTenThuTucNhan(tenThuTucNhan);
	}

	/**
	* Returns the thu tu lien thong of this ho so lien thong.
	*
	* @return the thu tu lien thong of this ho so lien thong
	*/
	public int getThuTuLienThong() {
		return _hoSoLienThong.getThuTuLienThong();
	}

	/**
	* Sets the thu tu lien thong of this ho so lien thong.
	*
	* @param thuTuLienThong the thu tu lien thong of this ho so lien thong
	*/
	public void setThuTuLienThong(int thuTuLienThong) {
		_hoSoLienThong.setThuTuLienThong(thuTuLienThong);
	}

	/**
	* Returns the ngay noi nhan hen tra of this ho so lien thong.
	*
	* @return the ngay noi nhan hen tra of this ho so lien thong
	*/
	public java.util.Date getNgayNoiNhanHenTra() {
		return _hoSoLienThong.getNgayNoiNhanHenTra();
	}

	/**
	* Sets the ngay noi nhan hen tra of this ho so lien thong.
	*
	* @param ngayNoiNhanHenTra the ngay noi nhan hen tra of this ho so lien thong
	*/
	public void setNgayNoiNhanHenTra(java.util.Date ngayNoiNhanHenTra) {
		_hoSoLienThong.setNgayNoiNhanHenTra(ngayNoiNhanHenTra);
	}

	/**
	* Returns the so ngay noi nhan xu ly du kien of this ho so lien thong.
	*
	* @return the so ngay noi nhan xu ly du kien of this ho so lien thong
	*/
	public int getSoNgayNoiNhanXuLyDuKien() {
		return _hoSoLienThong.getSoNgayNoiNhanXuLyDuKien();
	}

	/**
	* Sets the so ngay noi nhan xu ly du kien of this ho so lien thong.
	*
	* @param soNgayNoiNhanXuLyDuKien the so ngay noi nhan xu ly du kien of this ho so lien thong
	*/
	public void setSoNgayNoiNhanXuLyDuKien(int soNgayNoiNhanXuLyDuKien) {
		_hoSoLienThong.setSoNgayNoiNhanXuLyDuKien(soNgayNoiNhanXuLyDuKien);
	}

	/**
	* Returns the nguoi tao of this ho so lien thong.
	*
	* @return the nguoi tao of this ho so lien thong
	*/
	public java.lang.String getNguoiTao() {
		return _hoSoLienThong.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this ho so lien thong.
	*
	* @param nguoiTao the nguoi tao of this ho so lien thong
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_hoSoLienThong.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this ho so lien thong.
	*
	* @return the ngay tao of this ho so lien thong
	*/
	public java.util.Date getNgayTao() {
		return _hoSoLienThong.getNgayTao();
	}

	/**
	* Sets the ngay tao of this ho so lien thong.
	*
	* @param ngayTao the ngay tao of this ho so lien thong
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_hoSoLienThong.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this ho so lien thong.
	*
	* @return the nguoi sua of this ho so lien thong
	*/
	public java.lang.String getNguoiSua() {
		return _hoSoLienThong.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this ho so lien thong.
	*
	* @param nguoiSua the nguoi sua of this ho so lien thong
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_hoSoLienThong.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this ho so lien thong.
	*
	* @return the ngay sua of this ho so lien thong
	*/
	public java.util.Date getNgaySua() {
		return _hoSoLienThong.getNgaySua();
	}

	/**
	* Sets the ngay sua of this ho so lien thong.
	*
	* @param ngaySua the ngay sua of this ho so lien thong
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_hoSoLienThong.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this ho so lien thong.
	*
	* @return the da xoa of this ho so lien thong
	*/
	public int getDaXoa() {
		return _hoSoLienThong.getDaXoa();
	}

	/**
	* Sets the da xoa of this ho so lien thong.
	*
	* @param daXoa the da xoa of this ho so lien thong
	*/
	public void setDaXoa(int daXoa) {
		_hoSoLienThong.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _hoSoLienThong.isNew();
	}

	public void setNew(boolean n) {
		_hoSoLienThong.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoSoLienThong.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoSoLienThong.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoSoLienThong.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoSoLienThong.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoSoLienThong.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoSoLienThong.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoSoLienThong.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoSoLienThongWrapper((HoSoLienThong)_hoSoLienThong.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong) {
		return _hoSoLienThong.compareTo(hoSoLienThong);
	}

	@Override
	public int hashCode() {
		return _hoSoLienThong.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> toCacheModel() {
		return _hoSoLienThong.toCacheModel();
	}

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong toEscapedModel() {
		return new HoSoLienThongWrapper(_hoSoLienThong.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoSoLienThong.toString();
	}

	public java.lang.String toXmlString() {
		return _hoSoLienThong.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoLienThong.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoSoLienThong getWrappedHoSoLienThong() {
		return _hoSoLienThong;
	}

	public HoSoLienThong getWrappedModel() {
		return _hoSoLienThong;
	}

	public void resetOriginalValues() {
		_hoSoLienThong.resetOriginalValues();
	}

	private HoSoLienThong _hoSoLienThong;
}