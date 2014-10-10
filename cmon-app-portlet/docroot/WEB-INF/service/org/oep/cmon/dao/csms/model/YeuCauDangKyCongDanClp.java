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

package org.oep.cmon.dao.csms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author NAM
 */
public class YeuCauDangKyCongDanClp extends BaseModelImpl<YeuCauDangKyCongDan>
	implements YeuCauDangKyCongDan {
	public YeuCauDangKyCongDanClp() {
	}

	public Class<?> getModelClass() {
		return YeuCauDangKyCongDan.class;
	}

	public String getModelClassName() {
		return YeuCauDangKyCongDan.class.getName();
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

	public Date getNgayYeuCau() {
		return _NgayYeuCau;
	}

	public void setNgayYeuCau(Date NgayYeuCau) {
		_NgayYeuCau = NgayYeuCau;
	}

	public String getSoCmnd() {
		return _SoCmnd;
	}

	public void setSoCmnd(String SoCmnd) {
		_SoCmnd = SoCmnd;
	}

	public Date getNgayCapCmnd() {
		return _NgayCapCmnd;
	}

	public void setNgayCapCmnd(Date NgayCapCmnd) {
		_NgayCapCmnd = NgayCapCmnd;
	}

	public Long getIDNoiCapCmnd() {
		return _IDNoiCapCmnd;
	}

	public void setIDNoiCapCmnd(Long IDNoiCapCmnd) {
		_IDNoiCapCmnd = IDNoiCapCmnd;
	}

	public String getGhiChuCmnd() {
		return _GhiChuCmnd;
	}

	public void setGhiChuCmnd(String GhiChuCmnd) {
		_GhiChuCmnd = GhiChuCmnd;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getHoCongDan() {
		return _HoCongDan;
	}

	public void setHoCongDan(String HoCongDan) {
		_HoCongDan = HoCongDan;
	}

	public String getHoVaTen() {
		return _HoVaTen;
	}

	public void setHoVaTen(String HoVaTen) {
		_HoVaTen = HoVaTen;
	}

	public String getTenDem() {
		return _TenDem;
	}

	public void setTenDem(String TenDem) {
		_TenDem = TenDem;
	}

	public String getTenCongDan() {
		return _TenCongDan;
	}

	public void setTenCongDan(String TenCongDan) {
		_TenCongDan = TenCongDan;
	}

	public Date getNgaySinh() {
		return _NgaySinh;
	}

	public void setNgaySinh(Date NgaySinh) {
		_NgaySinh = NgaySinh;
	}

	public int getGioiTinh() {
		return _GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		_GioiTinh = GioiTinh;
	}

	public Long getIDDanToc() {
		return _IDDanToc;
	}

	public void setIDDanToc(Long IDDanToc) {
		_IDDanToc = IDDanToc;
	}

	public Long getIDQuocTich() {
		return _IDQuocTich;
	}

	public void setIDQuocTich(Long IDQuocTich) {
		_IDQuocTich = IDQuocTich;
	}

	public Long getIDTonGiao() {
		return _IDTonGiao;
	}

	public void setIDTonGiao(Long IDTonGiao) {
		_IDTonGiao = IDTonGiao;
	}

	public String getDienThoaiCoDinh() {
		return _DienThoaiCoDinh;
	}

	public void setDienThoaiCoDinh(String DienThoaiCoDinh) {
		_DienThoaiCoDinh = DienThoaiCoDinh;
	}

	public String getDienThoaiDiDong() {
		return _DienThoaiDiDong;
	}

	public void setDienThoaiDiDong(String DienThoaiDiDong) {
		_DienThoaiDiDong = DienThoaiDiDong;
	}

	public Long getIDTrinhDoHocVan() {
		return _IDTrinhDoHocVan;
	}

	public void setIDTrinhDoHocVan(Long IDTrinhDoHocVan) {
		_IDTrinhDoHocVan = IDTrinhDoHocVan;
	}

	public String getSoHoChieu() {
		return _SoHoChieu;
	}

	public void setSoHoChieu(String SoHoChieu) {
		_SoHoChieu = SoHoChieu;
	}

	public Date getNgayCapHoChieu() {
		return _NgayCapHoChieu;
	}

	public void setNgayCapHoChieu(Date NgayCapHoChieu) {
		_NgayCapHoChieu = NgayCapHoChieu;
	}

	public Long getIDNoiCapHoChieu() {
		return _IDNoiCapHoChieu;
	}

	public void setIDNoiCapHoChieu(Long IDNoiCapHoChieu) {
		_IDNoiCapHoChieu = IDNoiCapHoChieu;
	}

	public Date getNgayHetHanHoChieu() {
		return _NgayHetHanHoChieu;
	}

	public void setNgayHetHanHoChieu(Date NgayHetHanHoChieu) {
		_NgayHetHanHoChieu = NgayHetHanHoChieu;
	}

	public String getGhiChuHoChieu() {
		return _GhiChuHoChieu;
	}

	public void setGhiChuHoChieu(String GhiChuHoChieu) {
		_GhiChuHoChieu = GhiChuHoChieu;
	}

	public String getSoBaoHiemYte() {
		return _SoBaoHiemYte;
	}

	public void setSoBaoHiemYte(String SoBaoHiemYte) {
		_SoBaoHiemYte = SoBaoHiemYte;
	}

	public String getMaSoThueCaNhan() {
		return _MaSoThueCaNhan;
	}

	public void setMaSoThueCaNhan(String MaSoThueCaNhan) {
		_MaSoThueCaNhan = MaSoThueCaNhan;
	}

	public Long getIDNgheNghiep() {
		return _IDNgheNghiep;
	}

	public void setIDNgheNghiep(Long IDNgheNghiep) {
		_IDNgheNghiep = IDNgheNghiep;
	}

	public Long getIDTrinhDoChuyenMon() {
		return _IDTrinhDoChuyenMon;
	}

	public void setIDTrinhDoChuyenMon(Long IDTrinhDoChuyenMon) {
		_IDTrinhDoChuyenMon = IDTrinhDoChuyenMon;
	}

	public Long getTinhTrangHonNhan() {
		return _TinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(Long TinhTrangHonNhan) {
		_TinhTrangHonNhan = TinhTrangHonNhan;
	}

	public String getHoVaTenCha() {
		return _HoVaTenCha;
	}

	public void setHoVaTenCha(String HoVaTenCha) {
		_HoVaTenCha = HoVaTenCha;
	}

	public String getHoVaTenMe() {
		return _HoVaTenMe;
	}

	public void setHoVaTenMe(String HoVaTenMe) {
		_HoVaTenMe = HoVaTenMe;
	}

	public String getHoVaTenVoChong() {
		return _HoVaTenVoChong;
	}

	public void setHoVaTenVoChong(String HoVaTenVoChong) {
		_HoVaTenVoChong = HoVaTenVoChong;
	}

	public String getSoHoKhau() {
		return _SoHoKhau;
	}

	public void setSoHoKhau(String SoHoKhau) {
		_SoHoKhau = SoHoKhau;
	}

	public int getChuHo() {
		return _ChuHo;
	}

	public void setChuHo(int ChuHo) {
		_ChuHo = ChuHo;
	}

	public Long getIDQuanHe() {
		return _IDQuanHe;
	}

	public void setIDQuanHe(Long IDQuanHe) {
		_IDQuanHe = IDQuanHe;
	}

	public Long getIDTinhThanhNoiSinh() {
		return _IDTinhThanhNoiSinh;
	}

	public void setIDTinhThanhNoiSinh(Long IDTinhThanhNoiSinh) {
		_IDTinhThanhNoiSinh = IDTinhThanhNoiSinh;
	}

	public Long getIDQuanHuyenNoiSinh() {
		return _IDQuanHuyenNoiSinh;
	}

	public void setIDQuanHuyenNoiSinh(Long IDQuanHuyenNoiSinh) {
		_IDQuanHuyenNoiSinh = IDQuanHuyenNoiSinh;
	}

	public Long getIDPhuongXaNoiSinh() {
		return _IDPhuongXaNoiSinh;
	}

	public void setIDPhuongXaNoiSinh(Long IDPhuongXaNoiSinh) {
		_IDPhuongXaNoiSinh = IDPhuongXaNoiSinh;
	}

	public String getMoTaDiaChiNoiSinh() {
		return _MoTaDiaChiNoiSinh;
	}

	public void setMoTaDiaChiNoiSinh(String MoTaDiaChiNoiSinh) {
		_MoTaDiaChiNoiSinh = MoTaDiaChiNoiSinh;
	}

	public Long getIDTinhThanhThuongTru() {
		return _IDTinhThanhThuongTru;
	}

	public void setIDTinhThanhThuongTru(Long IDTinhThanhThuongTru) {
		_IDTinhThanhThuongTru = IDTinhThanhThuongTru;
	}

	public Long getIDQuanHuyenThuongTru() {
		return _IDQuanHuyenThuongTru;
	}

	public void setIDQuanHuyenThuongTru(Long IDQuanHuyenThuongTru) {
		_IDQuanHuyenThuongTru = IDQuanHuyenThuongTru;
	}

	public Long getIDPhuongXaThuongTru() {
		return _IDPhuongXaThuongTru;
	}

	public void setIDPhuongXaThuongTru(Long IDPhuongXaThuongTru) {
		_IDPhuongXaThuongTru = IDPhuongXaThuongTru;
	}

	public String getMoTaDiaChiThuongTru() {
		return _MoTaDiaChiThuongTru;
	}

	public void setMoTaDiaChiThuongTru(String MoTaDiaChiThuongTru) {
		_MoTaDiaChiThuongTru = MoTaDiaChiThuongTru;
	}

	public Long getIDTinhThanhHienTai() {
		return _IDTinhThanhHienTai;
	}

	public void setIDTinhThanhHienTai(Long IDTinhThanhHienTai) {
		_IDTinhThanhHienTai = IDTinhThanhHienTai;
	}

	public Long getIDQuanHuyenHienTai() {
		return _IDQuanHuyenHienTai;
	}

	public void setIDQuanHuyenHienTai(Long IDQuanHuyenHienTai) {
		_IDQuanHuyenHienTai = IDQuanHuyenHienTai;
	}

	public Long getIDPhuongXaHienTai() {
		return _IDPhuongXaHienTai;
	}

	public void setIDPhuongXaHienTai(Long IDPhuongXaHienTai) {
		_IDPhuongXaHienTai = IDPhuongXaHienTai;
	}

	public String getMoTaDiaChiHienTai() {
		return _MoTaDiaChiHienTai;
	}

	public void setMoTaDiaChiHienTai(String MoTaDiaChiHienTai) {
		_MoTaDiaChiHienTai = MoTaDiaChiHienTai;
	}

	public String getMaXacNhan() {
		return _MaXacNhan;
	}

	public void setMaXacNhan(String MaXacNhan) {
		_MaXacNhan = MaXacNhan;
	}

	public Date getNgayChungThuc() {
		return _NgayChungThuc;
	}

	public void setNgayChungThuc(Date NgayChungThuc) {
		_NgayChungThuc = NgayChungThuc;
	}

	public String getNguoiChungThuc() {
		return _NguoiChungThuc;
	}

	public void setNguoiChungThuc(String NguoiChungThuc) {
		_NguoiChungThuc = NguoiChungThuc;
	}

	public String getMaCongDanCha() {
		return _MaCongDanCha;
	}

	public void setMaCongDanCha(String MaCongDanCha) {
		_MaCongDanCha = MaCongDanCha;
	}

	public String getMaCongDanMe() {
		return _MaCongDanMe;
	}

	public void setMaCongDanMe(String MaCongDanMe) {
		_MaCongDanMe = MaCongDanMe;
	}

	public String getMaCongDanVoChong() {
		return _MaCongDanVoChong;
	}

	public void setMaCongDanVoChong(String MaCongDanVoChong) {
		_MaCongDanVoChong = MaCongDanVoChong;
	}

	public String getMaCongDan() {
		return _MaCongDan;
	}

	public void setMaCongDan(String MaCongDan) {
		_MaCongDan = MaCongDan;
	}

	public int getLoaiYeuCau() {
		return _LoaiYeuCau;
	}

	public void setLoaiYeuCau(int LoaiYeuCau) {
		_LoaiYeuCau = LoaiYeuCau;
	}

	public int getTrangThaiYeuCau() {
		return _TrangThaiYeuCau;
	}

	public void setTrangThaiYeuCau(int TrangThaiYeuCau) {
		_TrangThaiYeuCau = TrangThaiYeuCau;
	}

	public Date getNgayTao() {
		return _NgayTao;
	}

	public void setNgayTao(Date NgayTao) {
		_NgayTao = NgayTao;
	}

	public Date getNgaySua() {
		return _NgaySua;
	}

	public void setNgaySua(Date NgaySua) {
		_NgaySua = NgaySua;
	}

	public String getNguoiTao() {
		return _NguoiTao;
	}

	public void setNguoiTao(String NguoiTao) {
		_NguoiTao = NguoiTao;
	}

	public String getNguoiSua() {
		return _NguoiSua;
	}

	public void setNguoiSua(String NguoiSua) {
		_NguoiSua = NguoiSua;
	}

	public int getXoa() {
		return _Xoa;
	}

	public void setXoa(int Xoa) {
		_Xoa = Xoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(this);
		}
		else {
			YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(this);
		}
	}

	@Override
	public YeuCauDangKyCongDan toEscapedModel() {
		return (YeuCauDangKyCongDan)Proxy.newProxyInstance(YeuCauDangKyCongDan.class.getClassLoader(),
			new Class[] { YeuCauDangKyCongDan.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		YeuCauDangKyCongDanClp clone = new YeuCauDangKyCongDanClp();

		clone.setId(getId());
		clone.setNgayYeuCau(getNgayYeuCau());
		clone.setSoCmnd(getSoCmnd());
		clone.setNgayCapCmnd(getNgayCapCmnd());
		clone.setIDNoiCapCmnd(getIDNoiCapCmnd());
		clone.setGhiChuCmnd(getGhiChuCmnd());
		clone.setEmail(getEmail());
		clone.setHoCongDan(getHoCongDan());
		clone.setHoVaTen(getHoVaTen());
		clone.setTenDem(getTenDem());
		clone.setTenCongDan(getTenCongDan());
		clone.setNgaySinh(getNgaySinh());
		clone.setGioiTinh(getGioiTinh());
		clone.setIDDanToc(getIDDanToc());
		clone.setIDQuocTich(getIDQuocTich());
		clone.setIDTonGiao(getIDTonGiao());
		clone.setDienThoaiCoDinh(getDienThoaiCoDinh());
		clone.setDienThoaiDiDong(getDienThoaiDiDong());
		clone.setIDTrinhDoHocVan(getIDTrinhDoHocVan());
		clone.setSoHoChieu(getSoHoChieu());
		clone.setNgayCapHoChieu(getNgayCapHoChieu());
		clone.setIDNoiCapHoChieu(getIDNoiCapHoChieu());
		clone.setNgayHetHanHoChieu(getNgayHetHanHoChieu());
		clone.setGhiChuHoChieu(getGhiChuHoChieu());
		clone.setSoBaoHiemYte(getSoBaoHiemYte());
		clone.setMaSoThueCaNhan(getMaSoThueCaNhan());
		clone.setIDNgheNghiep(getIDNgheNghiep());
		clone.setIDTrinhDoChuyenMon(getIDTrinhDoChuyenMon());
		clone.setTinhTrangHonNhan(getTinhTrangHonNhan());
		clone.setHoVaTenCha(getHoVaTenCha());
		clone.setHoVaTenMe(getHoVaTenMe());
		clone.setHoVaTenVoChong(getHoVaTenVoChong());
		clone.setSoHoKhau(getSoHoKhau());
		clone.setChuHo(getChuHo());
		clone.setIDQuanHe(getIDQuanHe());
		clone.setIDTinhThanhNoiSinh(getIDTinhThanhNoiSinh());
		clone.setIDQuanHuyenNoiSinh(getIDQuanHuyenNoiSinh());
		clone.setIDPhuongXaNoiSinh(getIDPhuongXaNoiSinh());
		clone.setMoTaDiaChiNoiSinh(getMoTaDiaChiNoiSinh());
		clone.setIDTinhThanhThuongTru(getIDTinhThanhThuongTru());
		clone.setIDQuanHuyenThuongTru(getIDQuanHuyenThuongTru());
		clone.setIDPhuongXaThuongTru(getIDPhuongXaThuongTru());
		clone.setMoTaDiaChiThuongTru(getMoTaDiaChiThuongTru());
		clone.setIDTinhThanhHienTai(getIDTinhThanhHienTai());
		clone.setIDQuanHuyenHienTai(getIDQuanHuyenHienTai());
		clone.setIDPhuongXaHienTai(getIDPhuongXaHienTai());
		clone.setMoTaDiaChiHienTai(getMoTaDiaChiHienTai());
		clone.setMaXacNhan(getMaXacNhan());
		clone.setNgayChungThuc(getNgayChungThuc());
		clone.setNguoiChungThuc(getNguoiChungThuc());
		clone.setMaCongDanCha(getMaCongDanCha());
		clone.setMaCongDanMe(getMaCongDanMe());
		clone.setMaCongDanVoChong(getMaCongDanVoChong());
		clone.setMaCongDan(getMaCongDan());
		clone.setLoaiYeuCau(getLoaiYeuCau());
		clone.setTrangThaiYeuCau(getTrangThaiYeuCau());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setXoa(getXoa());

		return clone;
	}

	public int compareTo(YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		long primaryKey = yeuCauDangKyCongDan.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		YeuCauDangKyCongDanClp yeuCauDangKyCongDan = null;

		try {
			yeuCauDangKyCongDan = (YeuCauDangKyCongDanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = yeuCauDangKyCongDan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(123);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", NgayYeuCau=");
		sb.append(getNgayYeuCau());
		sb.append(", SoCmnd=");
		sb.append(getSoCmnd());
		sb.append(", NgayCapCmnd=");
		sb.append(getNgayCapCmnd());
		sb.append(", IDNoiCapCmnd=");
		sb.append(getIDNoiCapCmnd());
		sb.append(", GhiChuCmnd=");
		sb.append(getGhiChuCmnd());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", HoCongDan=");
		sb.append(getHoCongDan());
		sb.append(", HoVaTen=");
		sb.append(getHoVaTen());
		sb.append(", TenDem=");
		sb.append(getTenDem());
		sb.append(", TenCongDan=");
		sb.append(getTenCongDan());
		sb.append(", NgaySinh=");
		sb.append(getNgaySinh());
		sb.append(", GioiTinh=");
		sb.append(getGioiTinh());
		sb.append(", IDDanToc=");
		sb.append(getIDDanToc());
		sb.append(", IDQuocTich=");
		sb.append(getIDQuocTich());
		sb.append(", IDTonGiao=");
		sb.append(getIDTonGiao());
		sb.append(", DienThoaiCoDinh=");
		sb.append(getDienThoaiCoDinh());
		sb.append(", DienThoaiDiDong=");
		sb.append(getDienThoaiDiDong());
		sb.append(", IDTrinhDoHocVan=");
		sb.append(getIDTrinhDoHocVan());
		sb.append(", SoHoChieu=");
		sb.append(getSoHoChieu());
		sb.append(", NgayCapHoChieu=");
		sb.append(getNgayCapHoChieu());
		sb.append(", IDNoiCapHoChieu=");
		sb.append(getIDNoiCapHoChieu());
		sb.append(", NgayHetHanHoChieu=");
		sb.append(getNgayHetHanHoChieu());
		sb.append(", GhiChuHoChieu=");
		sb.append(getGhiChuHoChieu());
		sb.append(", SoBaoHiemYte=");
		sb.append(getSoBaoHiemYte());
		sb.append(", MaSoThueCaNhan=");
		sb.append(getMaSoThueCaNhan());
		sb.append(", IDNgheNghiep=");
		sb.append(getIDNgheNghiep());
		sb.append(", IDTrinhDoChuyenMon=");
		sb.append(getIDTrinhDoChuyenMon());
		sb.append(", TinhTrangHonNhan=");
		sb.append(getTinhTrangHonNhan());
		sb.append(", HoVaTenCha=");
		sb.append(getHoVaTenCha());
		sb.append(", HoVaTenMe=");
		sb.append(getHoVaTenMe());
		sb.append(", HoVaTenVoChong=");
		sb.append(getHoVaTenVoChong());
		sb.append(", SoHoKhau=");
		sb.append(getSoHoKhau());
		sb.append(", ChuHo=");
		sb.append(getChuHo());
		sb.append(", IDQuanHe=");
		sb.append(getIDQuanHe());
		sb.append(", IDTinhThanhNoiSinh=");
		sb.append(getIDTinhThanhNoiSinh());
		sb.append(", IDQuanHuyenNoiSinh=");
		sb.append(getIDQuanHuyenNoiSinh());
		sb.append(", IDPhuongXaNoiSinh=");
		sb.append(getIDPhuongXaNoiSinh());
		sb.append(", MoTaDiaChiNoiSinh=");
		sb.append(getMoTaDiaChiNoiSinh());
		sb.append(", IDTinhThanhThuongTru=");
		sb.append(getIDTinhThanhThuongTru());
		sb.append(", IDQuanHuyenThuongTru=");
		sb.append(getIDQuanHuyenThuongTru());
		sb.append(", IDPhuongXaThuongTru=");
		sb.append(getIDPhuongXaThuongTru());
		sb.append(", MoTaDiaChiThuongTru=");
		sb.append(getMoTaDiaChiThuongTru());
		sb.append(", IDTinhThanhHienTai=");
		sb.append(getIDTinhThanhHienTai());
		sb.append(", IDQuanHuyenHienTai=");
		sb.append(getIDQuanHuyenHienTai());
		sb.append(", IDPhuongXaHienTai=");
		sb.append(getIDPhuongXaHienTai());
		sb.append(", MoTaDiaChiHienTai=");
		sb.append(getMoTaDiaChiHienTai());
		sb.append(", MaXacNhan=");
		sb.append(getMaXacNhan());
		sb.append(", NgayChungThuc=");
		sb.append(getNgayChungThuc());
		sb.append(", NguoiChungThuc=");
		sb.append(getNguoiChungThuc());
		sb.append(", MaCongDanCha=");
		sb.append(getMaCongDanCha());
		sb.append(", MaCongDanMe=");
		sb.append(getMaCongDanMe());
		sb.append(", MaCongDanVoChong=");
		sb.append(getMaCongDanVoChong());
		sb.append(", MaCongDan=");
		sb.append(getMaCongDan());
		sb.append(", LoaiYeuCau=");
		sb.append(getLoaiYeuCau());
		sb.append(", TrangThaiYeuCau=");
		sb.append(getTrangThaiYeuCau());
		sb.append(", NgayTao=");
		sb.append(getNgayTao());
		sb.append(", NgaySua=");
		sb.append(getNgaySua());
		sb.append(", NguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", NguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", Xoa=");
		sb.append(getXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(187);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayYeuCau</column-name><column-value><![CDATA[");
		sb.append(getNgayYeuCau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoCmnd</column-name><column-value><![CDATA[");
		sb.append(getSoCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayCapCmnd</column-name><column-value><![CDATA[");
		sb.append(getNgayCapCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDNoiCapCmnd</column-name><column-value><![CDATA[");
		sb.append(getIDNoiCapCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GhiChuCmnd</column-name><column-value><![CDATA[");
		sb.append(getGhiChuCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoCongDan</column-name><column-value><![CDATA[");
		sb.append(getHoCongDan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoVaTen</column-name><column-value><![CDATA[");
		sb.append(getHoVaTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenDem</column-name><column-value><![CDATA[");
		sb.append(getTenDem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenCongDan</column-name><column-value><![CDATA[");
		sb.append(getTenCongDan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgaySinh</column-name><column-value><![CDATA[");
		sb.append(getNgaySinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GioiTinh</column-name><column-value><![CDATA[");
		sb.append(getGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDDanToc</column-name><column-value><![CDATA[");
		sb.append(getIDDanToc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDQuocTich</column-name><column-value><![CDATA[");
		sb.append(getIDQuocTich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDTonGiao</column-name><column-value><![CDATA[");
		sb.append(getIDTonGiao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DienThoaiCoDinh</column-name><column-value><![CDATA[");
		sb.append(getDienThoaiCoDinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DienThoaiDiDong</column-name><column-value><![CDATA[");
		sb.append(getDienThoaiDiDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDTrinhDoHocVan</column-name><column-value><![CDATA[");
		sb.append(getIDTrinhDoHocVan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoHoChieu</column-name><column-value><![CDATA[");
		sb.append(getSoHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayCapHoChieu</column-name><column-value><![CDATA[");
		sb.append(getNgayCapHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDNoiCapHoChieu</column-name><column-value><![CDATA[");
		sb.append(getIDNoiCapHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayHetHanHoChieu</column-name><column-value><![CDATA[");
		sb.append(getNgayHetHanHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GhiChuHoChieu</column-name><column-value><![CDATA[");
		sb.append(getGhiChuHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoBaoHiemYte</column-name><column-value><![CDATA[");
		sb.append(getSoBaoHiemYte());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaSoThueCaNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoThueCaNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDNgheNghiep</column-name><column-value><![CDATA[");
		sb.append(getIDNgheNghiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDTrinhDoChuyenMon</column-name><column-value><![CDATA[");
		sb.append(getIDTrinhDoChuyenMon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TinhTrangHonNhan</column-name><column-value><![CDATA[");
		sb.append(getTinhTrangHonNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoVaTenCha</column-name><column-value><![CDATA[");
		sb.append(getHoVaTenCha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoVaTenMe</column-name><column-value><![CDATA[");
		sb.append(getHoVaTenMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoVaTenVoChong</column-name><column-value><![CDATA[");
		sb.append(getHoVaTenVoChong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoHoKhau</column-name><column-value><![CDATA[");
		sb.append(getSoHoKhau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ChuHo</column-name><column-value><![CDATA[");
		sb.append(getChuHo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDQuanHe</column-name><column-value><![CDATA[");
		sb.append(getIDQuanHe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDTinhThanhNoiSinh</column-name><column-value><![CDATA[");
		sb.append(getIDTinhThanhNoiSinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDQuanHuyenNoiSinh</column-name><column-value><![CDATA[");
		sb.append(getIDQuanHuyenNoiSinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDPhuongXaNoiSinh</column-name><column-value><![CDATA[");
		sb.append(getIDPhuongXaNoiSinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MoTaDiaChiNoiSinh</column-name><column-value><![CDATA[");
		sb.append(getMoTaDiaChiNoiSinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDTinhThanhThuongTru</column-name><column-value><![CDATA[");
		sb.append(getIDTinhThanhThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDQuanHuyenThuongTru</column-name><column-value><![CDATA[");
		sb.append(getIDQuanHuyenThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDPhuongXaThuongTru</column-name><column-value><![CDATA[");
		sb.append(getIDPhuongXaThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MoTaDiaChiThuongTru</column-name><column-value><![CDATA[");
		sb.append(getMoTaDiaChiThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDTinhThanhHienTai</column-name><column-value><![CDATA[");
		sb.append(getIDTinhThanhHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDQuanHuyenHienTai</column-name><column-value><![CDATA[");
		sb.append(getIDQuanHuyenHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IDPhuongXaHienTai</column-name><column-value><![CDATA[");
		sb.append(getIDPhuongXaHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MoTaDiaChiHienTai</column-name><column-value><![CDATA[");
		sb.append(getMoTaDiaChiHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaXacNhan</column-name><column-value><![CDATA[");
		sb.append(getMaXacNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayChungThuc</column-name><column-value><![CDATA[");
		sb.append(getNgayChungThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NguoiChungThuc</column-name><column-value><![CDATA[");
		sb.append(getNguoiChungThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaCongDanCha</column-name><column-value><![CDATA[");
		sb.append(getMaCongDanCha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaCongDanMe</column-name><column-value><![CDATA[");
		sb.append(getMaCongDanMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaCongDanVoChong</column-name><column-value><![CDATA[");
		sb.append(getMaCongDanVoChong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaCongDan</column-name><column-value><![CDATA[");
		sb.append(getMaCongDan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LoaiYeuCau</column-name><column-value><![CDATA[");
		sb.append(getLoaiYeuCau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThaiYeuCau</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiYeuCau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Xoa</column-name><column-value><![CDATA[");
		sb.append(getXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _NgayYeuCau;
	private String _SoCmnd;
	private Date _NgayCapCmnd;
	private Long _IDNoiCapCmnd;
	private String _GhiChuCmnd;
	private String _Email;
	private String _HoCongDan;
	private String _HoVaTen;
	private String _TenDem;
	private String _TenCongDan;
	private Date _NgaySinh;
	private int _GioiTinh;
	private Long _IDDanToc;
	private Long _IDQuocTich;
	private Long _IDTonGiao;
	private String _DienThoaiCoDinh;
	private String _DienThoaiDiDong;
	private Long _IDTrinhDoHocVan;
	private String _SoHoChieu;
	private Date _NgayCapHoChieu;
	private Long _IDNoiCapHoChieu;
	private Date _NgayHetHanHoChieu;
	private String _GhiChuHoChieu;
	private String _SoBaoHiemYte;
	private String _MaSoThueCaNhan;
	private Long _IDNgheNghiep;
	private Long _IDTrinhDoChuyenMon;
	private Long _TinhTrangHonNhan;
	private String _HoVaTenCha;
	private String _HoVaTenMe;
	private String _HoVaTenVoChong;
	private String _SoHoKhau;
	private int _ChuHo;
	private Long _IDQuanHe;
	private Long _IDTinhThanhNoiSinh;
	private Long _IDQuanHuyenNoiSinh;
	private Long _IDPhuongXaNoiSinh;
	private String _MoTaDiaChiNoiSinh;
	private Long _IDTinhThanhThuongTru;
	private Long _IDQuanHuyenThuongTru;
	private Long _IDPhuongXaThuongTru;
	private String _MoTaDiaChiThuongTru;
	private Long _IDTinhThanhHienTai;
	private Long _IDQuanHuyenHienTai;
	private Long _IDPhuongXaHienTai;
	private String _MoTaDiaChiHienTai;
	private String _MaXacNhan;
	private Date _NgayChungThuc;
	private String _NguoiChungThuc;
	private String _MaCongDanCha;
	private String _MaCongDanMe;
	private String _MaCongDanVoChong;
	private String _MaCongDan;
	private int _LoaiYeuCau;
	private int _TrangThaiYeuCau;
	private Date _NgayTao;
	private Date _NgaySua;
	private String _NguoiTao;
	private String _NguoiSua;
	private int _Xoa;
}