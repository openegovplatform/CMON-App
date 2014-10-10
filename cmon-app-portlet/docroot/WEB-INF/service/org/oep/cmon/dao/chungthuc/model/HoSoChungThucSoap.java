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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    vietho
 * @generated
 */
public class HoSoChungThucSoap implements Serializable {
	public static HoSoChungThucSoap toSoapModel(HoSoChungThuc model) {
		HoSoChungThucSoap soapModel = new HoSoChungThucSoap();

		soapModel.setHoSoChungThucId(model.getHoSoChungThucId());
		soapModel.setTenChungThuc(model.getTenChungThuc());
		soapModel.setSoChungThuc(model.getSoChungThuc());
		soapModel.setNgayNopHoSo(model.getNgayNopHoSo());
		soapModel.setNgayTraKetQua(model.getNgayTraKetQua());
		soapModel.setHoTenNguoiNopHoSo(model.getHoTenNguoiNopHoSo());
		soapModel.setDiaChiThuongTruNguoiNop(model.getDiaChiThuongTruNguoiNop());
		soapModel.setSoDienThoaiCoDinhNguoiNop(model.getSoDienThoaiCoDinhNguoiNop());
		soapModel.setTrangThaiHoSo(model.getTrangThaiHoSo());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());
		soapModel.setCanBoTiepNhanId(model.getCanBoTiepNhanId());
		soapModel.setSoDienThoaiDiDongNguoiNop(model.getSoDienThoaiDiDongNguoiNop());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setMucDichChungThuc(model.getMucDichChungThuc());
		soapModel.setMaSoBienNhan(model.getMaSoBienNhan());
		soapModel.setChuSoHuu(model.getChuSoHuu());
		soapModel.setSoBoHoSo(model.getSoBoHoSo());
		soapModel.setSoTo(model.getSoTo());
		soapModel.setTruongHop(model.getTruongHop());
		soapModel.setLePhi(model.getLePhi());
		soapModel.setPhiHoSo(model.getPhiHoSo());
		soapModel.setEmailNguoiNop(model.getEmailNguoiNop());
		soapModel.setNgaySinhNguoiNop(model.getNgaySinhNguoiNop());
		soapModel.setSoCMNDNguoiNop(model.getSoCMNDNguoiNop());
		soapModel.setGioiTinhNguoiNop(model.getGioiTinhNguoiNop());
		soapModel.setTenCanBoKy(model.getTenCanBoKy());
		soapModel.setChucVuCanBoKyId(model.getChucVuCanBoKyId());
		soapModel.setSoDanhMucId(model.getSoDanhMucId());
		soapModel.setThuongTruTinhId(model.getThuongTruTinhId());
		soapModel.setThuongTruHuyenId(model.getThuongTruHuyenId());
		soapModel.setThuongTruXaId(model.getThuongTruXaId());

		return soapModel;
	}

	public static HoSoChungThucSoap[] toSoapModels(HoSoChungThuc[] models) {
		HoSoChungThucSoap[] soapModels = new HoSoChungThucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoSoChungThucSoap[][] toSoapModels(HoSoChungThuc[][] models) {
		HoSoChungThucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoSoChungThucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoSoChungThucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoSoChungThucSoap[] toSoapModels(List<HoSoChungThuc> models) {
		List<HoSoChungThucSoap> soapModels = new ArrayList<HoSoChungThucSoap>(models.size());

		for (HoSoChungThuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoSoChungThucSoap[soapModels.size()]);
	}

	public HoSoChungThucSoap() {
	}

	public long getPrimaryKey() {
		return _hoSoChungThucId;
	}

	public void setPrimaryKey(long pk) {
		setHoSoChungThucId(pk);
	}

	public long getHoSoChungThucId() {
		return _hoSoChungThucId;
	}

	public void setHoSoChungThucId(long hoSoChungThucId) {
		_hoSoChungThucId = hoSoChungThucId;
	}

	public String getTenChungThuc() {
		return _tenChungThuc;
	}

	public void setTenChungThuc(String tenChungThuc) {
		_tenChungThuc = tenChungThuc;
	}

	public String getSoChungThuc() {
		return _soChungThuc;
	}

	public void setSoChungThuc(String soChungThuc) {
		_soChungThuc = soChungThuc;
	}

	public Date getNgayNopHoSo() {
		return _ngayNopHoSo;
	}

	public void setNgayNopHoSo(Date ngayNopHoSo) {
		_ngayNopHoSo = ngayNopHoSo;
	}

	public Date getNgayTraKetQua() {
		return _ngayTraKetQua;
	}

	public void setNgayTraKetQua(Date ngayTraKetQua) {
		_ngayTraKetQua = ngayTraKetQua;
	}

	public String getHoTenNguoiNopHoSo() {
		return _hoTenNguoiNopHoSo;
	}

	public void setHoTenNguoiNopHoSo(String hoTenNguoiNopHoSo) {
		_hoTenNguoiNopHoSo = hoTenNguoiNopHoSo;
	}

	public String getDiaChiThuongTruNguoiNop() {
		return _diaChiThuongTruNguoiNop;
	}

	public void setDiaChiThuongTruNguoiNop(String diaChiThuongTruNguoiNop) {
		_diaChiThuongTruNguoiNop = diaChiThuongTruNguoiNop;
	}

	public String getSoDienThoaiCoDinhNguoiNop() {
		return _soDienThoaiCoDinhNguoiNop;
	}

	public void setSoDienThoaiCoDinhNguoiNop(String soDienThoaiCoDinhNguoiNop) {
		_soDienThoaiCoDinhNguoiNop = soDienThoaiCoDinhNguoiNop;
	}

	public int getTrangThaiHoSo() {
		return _trangThaiHoSo;
	}

	public void setTrangThaiHoSo(int trangThaiHoSo) {
		_trangThaiHoSo = trangThaiHoSo;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public Long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(Long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public Long getCanBoTiepNhanId() {
		return _canBoTiepNhanId;
	}

	public void setCanBoTiepNhanId(Long canBoTiepNhanId) {
		_canBoTiepNhanId = canBoTiepNhanId;
	}

	public String getSoDienThoaiDiDongNguoiNop() {
		return _soDienThoaiDiDongNguoiNop;
	}

	public void setSoDienThoaiDiDongNguoiNop(String soDienThoaiDiDongNguoiNop) {
		_soDienThoaiDiDongNguoiNop = soDienThoaiDiDongNguoiNop;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public String getMucDichChungThuc() {
		return _mucDichChungThuc;
	}

	public void setMucDichChungThuc(String mucDichChungThuc) {
		_mucDichChungThuc = mucDichChungThuc;
	}

	public String getMaSoBienNhan() {
		return _maSoBienNhan;
	}

	public void setMaSoBienNhan(String maSoBienNhan) {
		_maSoBienNhan = maSoBienNhan;
	}

	public String getChuSoHuu() {
		return _chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) {
		_chuSoHuu = chuSoHuu;
	}

	public int getSoBoHoSo() {
		return _soBoHoSo;
	}

	public void setSoBoHoSo(int soBoHoSo) {
		_soBoHoSo = soBoHoSo;
	}

	public int getSoTo() {
		return _soTo;
	}

	public void setSoTo(int soTo) {
		_soTo = soTo;
	}

	public String getTruongHop() {
		return _truongHop;
	}

	public void setTruongHop(String truongHop) {
		_truongHop = truongHop;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public int getPhiHoSo() {
		return _phiHoSo;
	}

	public void setPhiHoSo(int phiHoSo) {
		_phiHoSo = phiHoSo;
	}

	public String getEmailNguoiNop() {
		return _emailNguoiNop;
	}

	public void setEmailNguoiNop(String emailNguoiNop) {
		_emailNguoiNop = emailNguoiNop;
	}

	public Date getNgaySinhNguoiNop() {
		return _ngaySinhNguoiNop;
	}

	public void setNgaySinhNguoiNop(Date ngaySinhNguoiNop) {
		_ngaySinhNguoiNop = ngaySinhNguoiNop;
	}

	public String getSoCMNDNguoiNop() {
		return _soCMNDNguoiNop;
	}

	public void setSoCMNDNguoiNop(String soCMNDNguoiNop) {
		_soCMNDNguoiNop = soCMNDNguoiNop;
	}

	public int getGioiTinhNguoiNop() {
		return _gioiTinhNguoiNop;
	}

	public void setGioiTinhNguoiNop(int gioiTinhNguoiNop) {
		_gioiTinhNguoiNop = gioiTinhNguoiNop;
	}

	public String getTenCanBoKy() {
		return _tenCanBoKy;
	}

	public void setTenCanBoKy(String tenCanBoKy) {
		_tenCanBoKy = tenCanBoKy;
	}

	public Long getChucVuCanBoKyId() {
		return _chucVuCanBoKyId;
	}

	public void setChucVuCanBoKyId(Long chucVuCanBoKyId) {
		_chucVuCanBoKyId = chucVuCanBoKyId;
	}

	public Long getSoDanhMucId() {
		return _soDanhMucId;
	}

	public void setSoDanhMucId(Long soDanhMucId) {
		_soDanhMucId = soDanhMucId;
	}

	public Long getThuongTruTinhId() {
		return _thuongTruTinhId;
	}

	public void setThuongTruTinhId(Long thuongTruTinhId) {
		_thuongTruTinhId = thuongTruTinhId;
	}

	public Long getThuongTruHuyenId() {
		return _thuongTruHuyenId;
	}

	public void setThuongTruHuyenId(Long thuongTruHuyenId) {
		_thuongTruHuyenId = thuongTruHuyenId;
	}

	public Long getThuongTruXaId() {
		return _thuongTruXaId;
	}

	public void setThuongTruXaId(Long thuongTruXaId) {
		_thuongTruXaId = thuongTruXaId;
	}

	private long _hoSoChungThucId;
	private String _tenChungThuc;
	private String _soChungThuc;
	private Date _ngayNopHoSo;
	private Date _ngayTraKetQua;
	private String _hoTenNguoiNopHoSo;
	private String _diaChiThuongTruNguoiNop;
	private String _soDienThoaiCoDinhNguoiNop;
	private int _trangThaiHoSo;
	private int _daXoa;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private Long _thuTucHanhChinhId;
	private Long _canBoTiepNhanId;
	private String _soDienThoaiDiDongNguoiNop;
	private String _ghiChu;
	private String _mucDichChungThuc;
	private String _maSoBienNhan;
	private String _chuSoHuu;
	private int _soBoHoSo;
	private int _soTo;
	private String _truongHop;
	private int _lePhi;
	private int _phiHoSo;
	private String _emailNguoiNop;
	private Date _ngaySinhNguoiNop;
	private String _soCMNDNguoiNop;
	private int _gioiTinhNguoiNop;
	private String _tenCanBoKy;
	private Long _chucVuCanBoKyId;
	private Long _soDanhMucId;
	private Long _thuongTruTinhId;
	private Long _thuongTruHuyenId;
	private Long _thuongTruXaId;
}