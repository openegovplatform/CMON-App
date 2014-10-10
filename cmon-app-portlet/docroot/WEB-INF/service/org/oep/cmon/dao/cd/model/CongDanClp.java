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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class CongDanClp extends BaseModelImpl<CongDan> implements CongDan {
	public CongDanClp() {
	}

	public Class<?> getModelClass() {
		return CongDan.class;
	}

	public String getModelClassName() {
		return CongDan.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getHo() {
		return _ho;
	}

	public void setHo(String ho) {
		_ho = ho;
	}

	public String getDem() {
		return _dem;
	}

	public void setDem(String dem) {
		_dem = dem;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public String getSoCmnd() {
		return _soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		_soCmnd = soCmnd;
	}

	public Date getNgayCapCmnd() {
		return _ngayCapCmnd;
	}

	public void setNgayCapCmnd(Date ngayCapCmnd) {
		_ngayCapCmnd = ngayCapCmnd;
	}

	public String getGhiChuCmnd() {
		return _ghiChuCmnd;
	}

	public void setGhiChuCmnd(String ghiChuCmnd) {
		_ghiChuCmnd = ghiChuCmnd;
	}

	public String getSoHoChieu() {
		return _soHoChieu;
	}

	public void setSoHoChieu(String soHoChieu) {
		_soHoChieu = soHoChieu;
	}

	public Date getNgayCapHoChieu() {
		return _ngayCapHoChieu;
	}

	public void setNgayCapHoChieu(Date ngayCapHoChieu) {
		_ngayCapHoChieu = ngayCapHoChieu;
	}

	public Date getNgayHetHanHoChieu() {
		return _ngayHetHanHoChieu;
	}

	public void setNgayHetHanHoChieu(Date ngayHetHanHoChieu) {
		_ngayHetHanHoChieu = ngayHetHanHoChieu;
	}

	public Long getNoiCapHoChieuId() {
		return _noiCapHoChieuId;
	}

	public void setNoiCapHoChieuId(Long noiCapHoChieuId) {
		_noiCapHoChieuId = noiCapHoChieuId;
	}

	public String getGhiChuHoChieu() {
		return _ghiChuHoChieu;
	}

	public void setGhiChuHoChieu(String ghiChuHoChieu) {
		_ghiChuHoChieu = ghiChuHoChieu;
	}

	public String getSoBaoHiemYTe() {
		return _soBaoHiemYTe;
	}

	public void setSoBaoHiemYTe(String soBaoHiemYTe) {
		_soBaoHiemYTe = soBaoHiemYTe;
	}

	public String getMaSoThueCaNhan() {
		return _maSoThueCaNhan;
	}

	public void setMaSoThueCaNhan(String maSoThueCaNhan) {
		_maSoThueCaNhan = maSoThueCaNhan;
	}

	public String getDiaChiThuongTru() {
		return _diaChiThuongTru;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		_diaChiThuongTru = diaChiThuongTru;
	}

	public String getDiaChiHienNay() {
		return _diaChiHienNay;
	}

	public void setDiaChiHienNay(String diaChiHienNay) {
		_diaChiHienNay = diaChiHienNay;
	}

	public String getDienThoaiCoDinh() {
		return _dienThoaiCoDinh;
	}

	public void setDienThoaiCoDinh(String dienThoaiCoDinh) {
		_dienThoaiCoDinh = dienThoaiCoDinh;
	}

	public String getDienThoaiDiDong() {
		return _dienThoaiDiDong;
	}

	public void setDienThoaiDiDong(String dienThoaiDiDong) {
		_dienThoaiDiDong = dienThoaiDiDong;
	}

	public String getHoTenCha() {
		return _hoTenCha;
	}

	public void setHoTenCha(String hoTenCha) {
		_hoTenCha = hoTenCha;
	}

	public String getHoTenMe() {
		return _hoTenMe;
	}

	public void setHoTenMe(String hoTenMe) {
		_hoTenMe = hoTenMe;
	}

	public String getHoTenVoHoacChong() {
		return _hoTenVoHoacChong;
	}

	public void setHoTenVoHoacChong(String hoTenVoHoacChong) {
		_hoTenVoHoacChong = hoTenVoHoacChong;
	}

	public String getSoHoKhau() {
		return _soHoKhau;
	}

	public void setSoHoKhau(String soHoKhau) {
		_soHoKhau = soHoKhau;
	}

	public int getLaChuHo() {
		return _laChuHo;
	}

	public void setLaChuHo(int laChuHo) {
		_laChuHo = laChuHo;
	}

	public Long getTinhTrangHonNhanId() {
		return _tinhTrangHonNhanId;
	}

	public void setTinhTrangHonNhanId(Long tinhTrangHonNhanId) {
		_tinhTrangHonNhanId = tinhTrangHonNhanId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Long getTrinhDoChuyenMonId() {
		return _trinhDoChuyenMonId;
	}

	public void setTrinhDoChuyenMonId(Long trinhDoChuyenMonId) {
		_trinhDoChuyenMonId = trinhDoChuyenMonId;
	}

	public Long getSoDinhDanhChaId() {
		return _soDinhDanhChaId;
	}

	public void setSoDinhDanhChaId(Long soDinhDanhChaId) {
		_soDinhDanhChaId = soDinhDanhChaId;
	}

	public Long getSoDinhDanhVoHoacChongId() {
		return _soDinhDanhVoHoacChongId;
	}

	public void setSoDinhDanhVoHoacChongId(Long soDinhDanhVoHoacChongId) {
		_soDinhDanhVoHoacChongId = soDinhDanhVoHoacChongId;
	}

	public Long getDanTocId() {
		return _danTocId;
	}

	public void setDanTocId(Long danTocId) {
		_danTocId = danTocId;
	}

	public Long getDiaChiHienNayHuyenId() {
		return _diaChiHienNayHuyenId;
	}

	public void setDiaChiHienNayHuyenId(Long diaChiHienNayHuyenId) {
		_diaChiHienNayHuyenId = diaChiHienNayHuyenId;
	}

	public Long getDiaChiHienNayTinhId() {
		return _diaChiHienNayTinhId;
	}

	public void setDiaChiHienNayTinhId(Long diaChiHienNayTinhId) {
		_diaChiHienNayTinhId = diaChiHienNayTinhId;
	}

	public Long getDiaChiHienNayXaId() {
		return _diaChiHienNayXaId;
	}

	public void setDiaChiHienNayXaId(Long diaChiHienNayXaId) {
		_diaChiHienNayXaId = diaChiHienNayXaId;
	}

	public Long getDiaChiThuongTruHuyenId() {
		return _diaChiThuongTruHuyenId;
	}

	public void setDiaChiThuongTruHuyenId(Long diaChiThuongTruHuyenId) {
		_diaChiThuongTruHuyenId = diaChiThuongTruHuyenId;
	}

	public Long getDiaChiThuongTruTinhId() {
		return _diaChiThuongTruTinhId;
	}

	public void setDiaChiThuongTruTinhId(Long diaChiThuongTruTinhId) {
		_diaChiThuongTruTinhId = diaChiThuongTruTinhId;
	}

	public Long getDiaChiThuongTruXaId() {
		return _diaChiThuongTruXaId;
	}

	public void setDiaChiThuongTruXaId(Long diaChiThuongTruXaId) {
		_diaChiThuongTruXaId = diaChiThuongTruXaId;
	}

	public int getGioiTinh() {
		return _gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		_gioiTinh = gioiTinh;
	}

	public Long getNgheNghiepId() {
		return _ngheNghiepId;
	}

	public void setNgheNghiepId(Long ngheNghiepId) {
		_ngheNghiepId = ngheNghiepId;
	}

	public Long getNoiSinhHuyenId() {
		return _noiSinhHuyenId;
	}

	public void setNoiSinhHuyenId(Long noiSinhHuyenId) {
		_noiSinhHuyenId = noiSinhHuyenId;
	}

	public Long getNoiSinhTinhId() {
		return _noiSinhTinhId;
	}

	public void setNoiSinhTinhId(Long noiSinhTinhId) {
		_noiSinhTinhId = noiSinhTinhId;
	}

	public Long getNoiSinhXaId() {
		return _noiSinhXaId;
	}

	public void setNoiSinhXaId(Long noiSinhXaId) {
		_noiSinhXaId = noiSinhXaId;
	}

	public String getNoiSinhChiTiet() {
		return _noiSinhChiTiet;
	}

	public void setNoiSinhChiTiet(String noiSinhChiTiet) {
		_noiSinhChiTiet = noiSinhChiTiet;
	}

	public Long getNoiCapCmndId() {
		return _noiCapCmndId;
	}

	public void setNoiCapCmndId(Long noiCapCmndId) {
		_noiCapCmndId = noiCapCmndId;
	}

	public Long getTonGiaoId() {
		return _tonGiaoId;
	}

	public void setTonGiaoId(Long tonGiaoId) {
		_tonGiaoId = tonGiaoId;
	}

	public Long getSoDinhDanhMeId() {
		return _soDinhDanhMeId;
	}

	public void setSoDinhDanhMeId(Long soDinhDanhMeId) {
		_soDinhDanhMeId = soDinhDanhMeId;
	}

	public Long getTrinhDoHocVanId() {
		return _trinhDoHocVanId;
	}

	public void setTrinhDoHocVanId(Long trinhDoHocVanId) {
		_trinhDoHocVanId = trinhDoHocVanId;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public Long getQuanHeChuHoId() {
		return _quanHeChuHoId;
	}

	public void setQuanHeChuHoId(Long quanHeChuHoId) {
		_quanHeChuHoId = quanHeChuHoId;
	}

	public Long getQuocTichId() {
		return _quocTichId;
	}

	public void setQuocTichId(Long quocTichId) {
		_quocTichId = quocTichId;
	}

	public Long getDoanhNghiepId() {
		return _doanhNghiepId;
	}

	public void setDoanhNghiepId(Long doanhNghiepId) {
		_doanhNghiepId = doanhNghiepId;
	}

	public String getTenDayDu() {
		return _tenDayDu;
	}

	public void setTenDayDu(String tenDayDu) {
		_tenDayDu = tenDayDu;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public int getTinhtrang() {
		return _tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		_tinhtrang = tinhtrang;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CongDanLocalServiceUtil.addCongDan(this);
		}
		else {
			CongDanLocalServiceUtil.updateCongDan(this);
		}
	}

	@Override
	public CongDan toEscapedModel() {
		return (CongDan)Proxy.newProxyInstance(CongDan.class.getClassLoader(),
			new Class[] { CongDan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CongDanClp clone = new CongDanClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setHo(getHo());
		clone.setDem(getDem());
		clone.setTen(getTen());
		clone.setNgaySinh(getNgaySinh());
		clone.setSoCmnd(getSoCmnd());
		clone.setNgayCapCmnd(getNgayCapCmnd());
		clone.setGhiChuCmnd(getGhiChuCmnd());
		clone.setSoHoChieu(getSoHoChieu());
		clone.setNgayCapHoChieu(getNgayCapHoChieu());
		clone.setNgayHetHanHoChieu(getNgayHetHanHoChieu());
		clone.setNoiCapHoChieuId(getNoiCapHoChieuId());
		clone.setGhiChuHoChieu(getGhiChuHoChieu());
		clone.setSoBaoHiemYTe(getSoBaoHiemYTe());
		clone.setMaSoThueCaNhan(getMaSoThueCaNhan());
		clone.setDiaChiThuongTru(getDiaChiThuongTru());
		clone.setDiaChiHienNay(getDiaChiHienNay());
		clone.setDienThoaiCoDinh(getDienThoaiCoDinh());
		clone.setDienThoaiDiDong(getDienThoaiDiDong());
		clone.setHoTenCha(getHoTenCha());
		clone.setHoTenMe(getHoTenMe());
		clone.setHoTenVoHoacChong(getHoTenVoHoacChong());
		clone.setSoHoKhau(getSoHoKhau());
		clone.setLaChuHo(getLaChuHo());
		clone.setTinhTrangHonNhanId(getTinhTrangHonNhanId());
		clone.setEmail(getEmail());
		clone.setTrinhDoChuyenMonId(getTrinhDoChuyenMonId());
		clone.setSoDinhDanhChaId(getSoDinhDanhChaId());
		clone.setSoDinhDanhVoHoacChongId(getSoDinhDanhVoHoacChongId());
		clone.setDanTocId(getDanTocId());
		clone.setDiaChiHienNayHuyenId(getDiaChiHienNayHuyenId());
		clone.setDiaChiHienNayTinhId(getDiaChiHienNayTinhId());
		clone.setDiaChiHienNayXaId(getDiaChiHienNayXaId());
		clone.setDiaChiThuongTruHuyenId(getDiaChiThuongTruHuyenId());
		clone.setDiaChiThuongTruTinhId(getDiaChiThuongTruTinhId());
		clone.setDiaChiThuongTruXaId(getDiaChiThuongTruXaId());
		clone.setGioiTinh(getGioiTinh());
		clone.setNgheNghiepId(getNgheNghiepId());
		clone.setNoiSinhHuyenId(getNoiSinhHuyenId());
		clone.setNoiSinhTinhId(getNoiSinhTinhId());
		clone.setNoiSinhXaId(getNoiSinhXaId());
		clone.setNoiSinhChiTiet(getNoiSinhChiTiet());
		clone.setNoiCapCmndId(getNoiCapCmndId());
		clone.setTonGiaoId(getTonGiaoId());
		clone.setSoDinhDanhMeId(getSoDinhDanhMeId());
		clone.setTrinhDoHocVanId(getTrinhDoHocVanId());
		clone.setTaiKhoanNguoiDungId(getTaiKhoanNguoiDungId());
		clone.setQuanHeChuHoId(getQuanHeChuHoId());
		clone.setQuocTichId(getQuocTichId());
		clone.setDoanhNghiepId(getDoanhNghiepId());
		clone.setTenDayDu(getTenDayDu());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());
		clone.setFax(getFax());
		clone.setWebsite(getWebsite());
		clone.setTinhtrang(getTinhtrang());

		return clone;
	}

	public int compareTo(CongDan congDan) {
		int value = 0;

		if (getId() < congDan.getId()) {
			value = -1;
		}
		else if (getId() > congDan.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CongDanClp congDan = null;

		try {
			congDan = (CongDanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = congDan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(121);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ho=");
		sb.append(getHo());
		sb.append(", dem=");
		sb.append(getDem());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", ngaySinh=");
		sb.append(getNgaySinh());
		sb.append(", soCmnd=");
		sb.append(getSoCmnd());
		sb.append(", ngayCapCmnd=");
		sb.append(getNgayCapCmnd());
		sb.append(", ghiChuCmnd=");
		sb.append(getGhiChuCmnd());
		sb.append(", soHoChieu=");
		sb.append(getSoHoChieu());
		sb.append(", ngayCapHoChieu=");
		sb.append(getNgayCapHoChieu());
		sb.append(", ngayHetHanHoChieu=");
		sb.append(getNgayHetHanHoChieu());
		sb.append(", noiCapHoChieuId=");
		sb.append(getNoiCapHoChieuId());
		sb.append(", ghiChuHoChieu=");
		sb.append(getGhiChuHoChieu());
		sb.append(", soBaoHiemYTe=");
		sb.append(getSoBaoHiemYTe());
		sb.append(", maSoThueCaNhan=");
		sb.append(getMaSoThueCaNhan());
		sb.append(", diaChiThuongTru=");
		sb.append(getDiaChiThuongTru());
		sb.append(", diaChiHienNay=");
		sb.append(getDiaChiHienNay());
		sb.append(", dienThoaiCoDinh=");
		sb.append(getDienThoaiCoDinh());
		sb.append(", dienThoaiDiDong=");
		sb.append(getDienThoaiDiDong());
		sb.append(", hoTenCha=");
		sb.append(getHoTenCha());
		sb.append(", hoTenMe=");
		sb.append(getHoTenMe());
		sb.append(", hoTenVoHoacChong=");
		sb.append(getHoTenVoHoacChong());
		sb.append(", soHoKhau=");
		sb.append(getSoHoKhau());
		sb.append(", laChuHo=");
		sb.append(getLaChuHo());
		sb.append(", tinhTrangHonNhanId=");
		sb.append(getTinhTrangHonNhanId());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", trinhDoChuyenMonId=");
		sb.append(getTrinhDoChuyenMonId());
		sb.append(", soDinhDanhChaId=");
		sb.append(getSoDinhDanhChaId());
		sb.append(", soDinhDanhVoHoacChongId=");
		sb.append(getSoDinhDanhVoHoacChongId());
		sb.append(", danTocId=");
		sb.append(getDanTocId());
		sb.append(", diaChiHienNayHuyenId=");
		sb.append(getDiaChiHienNayHuyenId());
		sb.append(", diaChiHienNayTinhId=");
		sb.append(getDiaChiHienNayTinhId());
		sb.append(", diaChiHienNayXaId=");
		sb.append(getDiaChiHienNayXaId());
		sb.append(", diaChiThuongTruHuyenId=");
		sb.append(getDiaChiThuongTruHuyenId());
		sb.append(", diaChiThuongTruTinhId=");
		sb.append(getDiaChiThuongTruTinhId());
		sb.append(", diaChiThuongTruXaId=");
		sb.append(getDiaChiThuongTruXaId());
		sb.append(", gioiTinh=");
		sb.append(getGioiTinh());
		sb.append(", ngheNghiepId=");
		sb.append(getNgheNghiepId());
		sb.append(", noiSinhHuyenId=");
		sb.append(getNoiSinhHuyenId());
		sb.append(", noiSinhTinhId=");
		sb.append(getNoiSinhTinhId());
		sb.append(", noiSinhXaId=");
		sb.append(getNoiSinhXaId());
		sb.append(", noiSinhChiTiet=");
		sb.append(getNoiSinhChiTiet());
		sb.append(", noiCapCmndId=");
		sb.append(getNoiCapCmndId());
		sb.append(", tonGiaoId=");
		sb.append(getTonGiaoId());
		sb.append(", soDinhDanhMeId=");
		sb.append(getSoDinhDanhMeId());
		sb.append(", trinhDoHocVanId=");
		sb.append(getTrinhDoHocVanId());
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append(", quanHeChuHoId=");
		sb.append(getQuanHeChuHoId());
		sb.append(", quocTichId=");
		sb.append(getQuocTichId());
		sb.append(", doanhNghiepId=");
		sb.append(getDoanhNghiepId());
		sb.append(", tenDayDu=");
		sb.append(getTenDayDu());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", tinhtrang=");
		sb.append(getTinhtrang());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(184);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cd.model.CongDan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ho</column-name><column-value><![CDATA[");
		sb.append(getHo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dem</column-name><column-value><![CDATA[");
		sb.append(getDem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySinh</column-name><column-value><![CDATA[");
		sb.append(getNgaySinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soCmnd</column-name><column-value><![CDATA[");
		sb.append(getSoCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapCmnd</column-name><column-value><![CDATA[");
		sb.append(getNgayCapCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChuCmnd</column-name><column-value><![CDATA[");
		sb.append(getGhiChuCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soHoChieu</column-name><column-value><![CDATA[");
		sb.append(getSoHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapHoChieu</column-name><column-value><![CDATA[");
		sb.append(getNgayCapHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHetHanHoChieu</column-name><column-value><![CDATA[");
		sb.append(getNgayHetHanHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapHoChieuId</column-name><column-value><![CDATA[");
		sb.append(getNoiCapHoChieuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChuHoChieu</column-name><column-value><![CDATA[");
		sb.append(getGhiChuHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soBaoHiemYTe</column-name><column-value><![CDATA[");
		sb.append(getSoBaoHiemYTe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoThueCaNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoThueCaNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTru</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiHienNay</column-name><column-value><![CDATA[");
		sb.append(getDiaChiHienNay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoaiCoDinh</column-name><column-value><![CDATA[");
		sb.append(getDienThoaiCoDinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoaiDiDong</column-name><column-value><![CDATA[");
		sb.append(getDienThoaiDiDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCha</column-name><column-value><![CDATA[");
		sb.append(getHoTenCha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenMe</column-name><column-value><![CDATA[");
		sb.append(getHoTenMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenVoHoacChong</column-name><column-value><![CDATA[");
		sb.append(getHoTenVoHoacChong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soHoKhau</column-name><column-value><![CDATA[");
		sb.append(getSoHoKhau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laChuHo</column-name><column-value><![CDATA[");
		sb.append(getLaChuHo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tinhTrangHonNhanId</column-name><column-value><![CDATA[");
		sb.append(getTinhTrangHonNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trinhDoChuyenMonId</column-name><column-value><![CDATA[");
		sb.append(getTrinhDoChuyenMonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDinhDanhChaId</column-name><column-value><![CDATA[");
		sb.append(getSoDinhDanhChaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDinhDanhVoHoacChongId</column-name><column-value><![CDATA[");
		sb.append(getSoDinhDanhVoHoacChongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>danTocId</column-name><column-value><![CDATA[");
		sb.append(getDanTocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiHienNayHuyenId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiHienNayHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiHienNayTinhId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiHienNayTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiHienNayXaId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiHienNayXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruHuyenId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruTinhId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruXaId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gioiTinh</column-name><column-value><![CDATA[");
		sb.append(getGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngheNghiepId</column-name><column-value><![CDATA[");
		sb.append(getNgheNghiepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiSinhHuyenId</column-name><column-value><![CDATA[");
		sb.append(getNoiSinhHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiSinhTinhId</column-name><column-value><![CDATA[");
		sb.append(getNoiSinhTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiSinhXaId</column-name><column-value><![CDATA[");
		sb.append(getNoiSinhXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiSinhChiTiet</column-name><column-value><![CDATA[");
		sb.append(getNoiSinhChiTiet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapCmndId</column-name><column-value><![CDATA[");
		sb.append(getNoiCapCmndId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tonGiaoId</column-name><column-value><![CDATA[");
		sb.append(getTonGiaoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDinhDanhMeId</column-name><column-value><![CDATA[");
		sb.append(getSoDinhDanhMeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trinhDoHocVanId</column-name><column-value><![CDATA[");
		sb.append(getTrinhDoHocVanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiKhoanNguoiDungId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quanHeChuHoId</column-name><column-value><![CDATA[");
		sb.append(getQuanHeChuHoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quocTichId</column-name><column-value><![CDATA[");
		sb.append(getQuocTichId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>doanhNghiepId</column-name><column-value><![CDATA[");
		sb.append(getDoanhNghiepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenDayDu</column-name><column-value><![CDATA[");
		sb.append(getTenDayDu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tinhtrang</column-name><column-value><![CDATA[");
		sb.append(getTinhtrang());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ho;
	private String _dem;
	private String _ten;
	private Date _ngaySinh;
	private String _soCmnd;
	private Date _ngayCapCmnd;
	private String _ghiChuCmnd;
	private String _soHoChieu;
	private Date _ngayCapHoChieu;
	private Date _ngayHetHanHoChieu;
	private Long _noiCapHoChieuId;
	private String _ghiChuHoChieu;
	private String _soBaoHiemYTe;
	private String _maSoThueCaNhan;
	private String _diaChiThuongTru;
	private String _diaChiHienNay;
	private String _dienThoaiCoDinh;
	private String _dienThoaiDiDong;
	private String _hoTenCha;
	private String _hoTenMe;
	private String _hoTenVoHoacChong;
	private String _soHoKhau;
	private int _laChuHo;
	private Long _tinhTrangHonNhanId;
	private String _email;
	private Long _trinhDoChuyenMonId;
	private Long _soDinhDanhChaId;
	private Long _soDinhDanhVoHoacChongId;
	private Long _danTocId;
	private Long _diaChiHienNayHuyenId;
	private Long _diaChiHienNayTinhId;
	private Long _diaChiHienNayXaId;
	private Long _diaChiThuongTruHuyenId;
	private Long _diaChiThuongTruTinhId;
	private Long _diaChiThuongTruXaId;
	private int _gioiTinh;
	private Long _ngheNghiepId;
	private Long _noiSinhHuyenId;
	private Long _noiSinhTinhId;
	private Long _noiSinhXaId;
	private String _noiSinhChiTiet;
	private Long _noiCapCmndId;
	private Long _tonGiaoId;
	private Long _soDinhDanhMeId;
	private Long _trinhDoHocVanId;
	private Long _taiKhoanNguoiDungId;
	private Long _quanHeChuHoId;
	private Long _quocTichId;
	private Long _doanhNghiepId;
	private String _tenDayDu;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _daXoa;
	private String _fax;
	private String _website;
	private int _tinhtrang;
}