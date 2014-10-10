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

package org.oep.cmon.dao.dn.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class DoanhNghiepClp extends BaseModelImpl<DoanhNghiep>
	implements DoanhNghiep {
	public DoanhNghiepClp() {
	}

	public Class<?> getModelClass() {
		return DoanhNghiep.class;
	}

	public String getModelClassName() {
		return DoanhNghiep.class.getName();
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getMaSoThue() {
		return _maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		_maSoThue = maSoThue;
	}

	public String getTenTiengNuocNgoai() {
		return _tenTiengNuocNgoai;
	}

	public void setTenTiengNuocNgoai(String tenTiengNuocNgoai) {
		_tenTiengNuocNgoai = tenTiengNuocNgoai;
	}

	public String getTenVietTat() {
		return _tenVietTat;
	}

	public void setTenVietTat(String tenVietTat) {
		_tenVietTat = tenVietTat;
	}

	public String getDiaChiDoanhNghiep() {
		return _diaChiDoanhNghiep;
	}

	public void setDiaChiDoanhNghiep(String diaChiDoanhNghiep) {
		_diaChiDoanhNghiep = diaChiDoanhNghiep;
	}

	public String getDienThoaiDoanhNghiep() {
		return _dienThoaiDoanhNghiep;
	}

	public void setDienThoaiDoanhNghiep(String dienThoaiDoanhNghiep) {
		_dienThoaiDoanhNghiep = dienThoaiDoanhNghiep;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getEmailDoanhNghiep() {
		return _emailDoanhNghiep;
	}

	public void setEmailDoanhNghiep(String emailDoanhNghiep) {
		_emailDoanhNghiep = emailDoanhNghiep;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public long getTongSoVon() {
		return _tongSoVon;
	}

	public void setTongSoVon(long tongSoVon) {
		_tongSoVon = tongSoVon;
	}

	public String getMoTaNganhNgheKinhDoanh() {
		return _moTaNganhNgheKinhDoanh;
	}

	public void setMoTaNganhNgheKinhDoanh(String moTaNganhNgheKinhDoanh) {
		_moTaNganhNgheKinhDoanh = moTaNganhNgheKinhDoanh;
	}

	public String getSoGCNDKKD() {
		return _soGCNDKKD;
	}

	public void setSoGCNDKKD(String soGCNDKKD) {
		_soGCNDKKD = soGCNDKKD;
	}

	public Date getNgayCapGCNDKKD() {
		return _ngayCapGCNDKKD;
	}

	public void setNgayCapGCNDKKD(Date ngayCapGCNDKKD) {
		_ngayCapGCNDKKD = ngayCapGCNDKKD;
	}

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public Date getNgayDieuLeDuocThongQua() {
		return _ngayDieuLeDuocThongQua;
	}

	public void setNgayDieuLeDuocThongQua(Date ngayDieuLeDuocThongQua) {
		_ngayDieuLeDuocThongQua = ngayDieuLeDuocThongQua;
	}

	public String getTenChiNhanh() {
		return _tenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		_tenChiNhanh = tenChiNhanh;
	}

	public String getDiaChiChiNhanh() {
		return _diaChiChiNhanh;
	}

	public void setDiaChiChiNhanh(String diaChiChiNhanh) {
		_diaChiChiNhanh = diaChiChiNhanh;
	}

	public String getTenVanPhongDaiDien() {
		return _tenVanPhongDaiDien;
	}

	public void setTenVanPhongDaiDien(String tenVanPhongDaiDien) {
		_tenVanPhongDaiDien = tenVanPhongDaiDien;
	}

	public String getDiaChiVanPhongDaiDien() {
		return _diaChiVanPhongDaiDien;
	}

	public void setDiaChiVanPhongDaiDien(String diaChiVanPhongDaiDien) {
		_diaChiVanPhongDaiDien = diaChiVanPhongDaiDien;
	}

	public Date getNgayBatDauTamNgung() {
		return _ngayBatDauTamNgung;
	}

	public void setNgayBatDauTamNgung(Date ngayBatDauTamNgung) {
		_ngayBatDauTamNgung = ngayBatDauTamNgung;
	}

	public Date getNgayKetThucTamNgung() {
		return _ngayKetThucTamNgung;
	}

	public void setNgayKetThucTamNgung(Date ngayKetThucTamNgung) {
		_ngayKetThucTamNgung = ngayKetThucTamNgung;
	}

	public String getLyDoTamNgung() {
		return _lyDoTamNgung;
	}

	public void setLyDoTamNgung(String lyDoTamNgung) {
		_lyDoTamNgung = lyDoTamNgung;
	}

	public Date getNgayChamDutHoatDongKD() {
		return _ngayChamDutHoatDongKD;
	}

	public void setNgayChamDutHoatDongKD(Date ngayChamDutHoatDongKD) {
		_ngayChamDutHoatDongKD = ngayChamDutHoatDongKD;
	}

	public long getLoai() {
		return _loai;
	}

	public void setLoai(long loai) {
		_loai = loai;
	}

	public Long getDiaChiDoanhNghiepHuyenId() {
		return _diaChiDoanhNghiepHuyenId;
	}

	public void setDiaChiDoanhNghiepHuyenId(Long diaChiDoanhNghiepHuyenId) {
		_diaChiDoanhNghiepHuyenId = diaChiDoanhNghiepHuyenId;
	}

	public Long getDiaChiDoanhNghiepTinhId() {
		return _diaChiDoanhNghiepTinhId;
	}

	public void setDiaChiDoanhNghiepTinhId(Long diaChiDoanhNghiepTinhId) {
		_diaChiDoanhNghiepTinhId = diaChiDoanhNghiepTinhId;
	}

	public Long getDiaChiDoanhNghiepXaId() {
		return _diaChiDoanhNghiepXaId;
	}

	public void setDiaChiDoanhNghiepXaId(Long diaChiDoanhNghiepXaId) {
		_diaChiDoanhNghiepXaId = diaChiDoanhNghiepXaId;
	}

	public Long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(Long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public Long getNguoiDaiDienId() {
		return _nguoiDaiDienId;
	}

	public void setNguoiDaiDienId(Long nguoiDaiDienId) {
		_nguoiDaiDienId = nguoiDaiDienId;
	}

	public Long getTrangThaiDoanhNghiepId() {
		return _trangThaiDoanhNghiepId;
	}

	public void setTrangThaiDoanhNghiepId(Long trangThaiDoanhNghiepId) {
		_trangThaiDoanhNghiepId = trangThaiDoanhNghiepId;
	}

	public long getVonDieuLe() {
		return _vonDieuLe;
	}

	public void setVonDieuLe(long vonDieuLe) {
		_vonDieuLe = vonDieuLe;
	}

	public long getVonToiThieuMotXaVien() {
		return _vonToiThieuMotXaVien;
	}

	public void setVonToiThieuMotXaVien(long vonToiThieuMotXaVien) {
		_vonToiThieuMotXaVien = vonToiThieuMotXaVien;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public Long getQuocGiaId() {
		return _quocGiaId;
	}

	public void setQuocGiaId(Long quocGiaId) {
		_quocGiaId = quocGiaId;
	}

	public Long getCoQuanCapId() {
		return _coQuanCapId;
	}

	public void setCoQuanCapId(Long coQuanCapId) {
		_coQuanCapId = coQuanCapId;
	}

	public long getTenCoQuanCap() {
		return _tenCoQuanCap;
	}

	public void setTenCoQuanCap(long tenCoQuanCap) {
		_tenCoQuanCap = tenCoQuanCap;
	}

	public String getSoLanDieuChinh() {
		return _soLanDieuChinh;
	}

	public void setSoLanDieuChinh(String soLanDieuChinh) {
		_soLanDieuChinh = soLanDieuChinh;
	}

	public Date getNgayDieuChinh() {
		return _ngayDieuChinh;
	}

	public void setNgayDieuChinh(Date ngayDieuChinh) {
		_ngayDieuChinh = ngayDieuChinh;
	}

	public String getChucVuNguoiDaiDien() {
		return _chucVuNguoiDaiDien;
	}

	public void setChucVuNguoiDaiDien(String chucVuNguoiDaiDien) {
		_chucVuNguoiDaiDien = chucVuNguoiDaiDien;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
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

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public String getTenDiaDiemKinhDoanh() {
		return _tenDiaDiemKinhDoanh;
	}

	public void setTenDiaDiemKinhDoanh(String tenDiaDiemKinhDoanh) {
		_tenDiaDiemKinhDoanh = tenDiaDiemKinhDoanh;
	}

	public Date getNgayDangKyKinhDoanh() {
		return _ngayDangKyKinhDoanh;
	}

	public void setNgayDangKyKinhDoanh(Date ngayDangKyKinhDoanh) {
		_ngayDangKyKinhDoanh = ngayDangKyKinhDoanh;
	}

	public Long getLoaiHinhDoanhNghiepId() {
		return _loaiHinhDoanhNghiepId;
	}

	public void setLoaiHinhDoanhNghiepId(Long loaiHinhDoanhNghiepId) {
		_loaiHinhDoanhNghiepId = loaiHinhDoanhNghiepId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DoanhNghiepLocalServiceUtil.addDoanhNghiep(this);
		}
		else {
			DoanhNghiepLocalServiceUtil.updateDoanhNghiep(this);
		}
	}

	@Override
	public DoanhNghiep toEscapedModel() {
		return (DoanhNghiep)Proxy.newProxyInstance(DoanhNghiep.class.getClassLoader(),
			new Class[] { DoanhNghiep.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DoanhNghiepClp clone = new DoanhNghiepClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setMaSoThue(getMaSoThue());
		clone.setTenTiengNuocNgoai(getTenTiengNuocNgoai());
		clone.setTenVietTat(getTenVietTat());
		clone.setDiaChiDoanhNghiep(getDiaChiDoanhNghiep());
		clone.setDienThoaiDoanhNghiep(getDienThoaiDoanhNghiep());
		clone.setFax(getFax());
		clone.setEmailDoanhNghiep(getEmailDoanhNghiep());
		clone.setWebsite(getWebsite());
		clone.setTongSoVon(getTongSoVon());
		clone.setMoTaNganhNgheKinhDoanh(getMoTaNganhNgheKinhDoanh());
		clone.setSoGCNDKKD(getSoGCNDKKD());
		clone.setNgayCapGCNDKKD(getNgayCapGCNDKKD());
		clone.setNoiLuuTruId(getNoiLuuTruId());
		clone.setNgayDieuLeDuocThongQua(getNgayDieuLeDuocThongQua());
		clone.setTenChiNhanh(getTenChiNhanh());
		clone.setDiaChiChiNhanh(getDiaChiChiNhanh());
		clone.setTenVanPhongDaiDien(getTenVanPhongDaiDien());
		clone.setDiaChiVanPhongDaiDien(getDiaChiVanPhongDaiDien());
		clone.setNgayBatDauTamNgung(getNgayBatDauTamNgung());
		clone.setNgayKetThucTamNgung(getNgayKetThucTamNgung());
		clone.setLyDoTamNgung(getLyDoTamNgung());
		clone.setNgayChamDutHoatDongKD(getNgayChamDutHoatDongKD());
		clone.setLoai(getLoai());
		clone.setDiaChiDoanhNghiepHuyenId(getDiaChiDoanhNghiepHuyenId());
		clone.setDiaChiDoanhNghiepTinhId(getDiaChiDoanhNghiepTinhId());
		clone.setDiaChiDoanhNghiepXaId(getDiaChiDoanhNghiepXaId());
		clone.setLoaiDoiTuongId(getLoaiDoiTuongId());
		clone.setNguoiDaiDienId(getNguoiDaiDienId());
		clone.setTrangThaiDoanhNghiepId(getTrangThaiDoanhNghiepId());
		clone.setVonDieuLe(getVonDieuLe());
		clone.setVonToiThieuMotXaVien(getVonToiThieuMotXaVien());
		clone.setGhiChu(getGhiChu());
		clone.setQuocGiaId(getQuocGiaId());
		clone.setCoQuanCapId(getCoQuanCapId());
		clone.setTenCoQuanCap(getTenCoQuanCap());
		clone.setSoLanDieuChinh(getSoLanDieuChinh());
		clone.setNgayDieuChinh(getNgayDieuChinh());
		clone.setChucVuNguoiDaiDien(getChucVuNguoiDaiDien());
		clone.setNgayTao(getNgayTao());
		clone.setDaXoa(getDaXoa());
		clone.setNgaySua(getNgaySua());
		clone.setChaId(getChaId());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setTaiKhoanNguoiDungId(getTaiKhoanNguoiDungId());
		clone.setTenDiaDiemKinhDoanh(getTenDiaDiemKinhDoanh());
		clone.setNgayDangKyKinhDoanh(getNgayDangKyKinhDoanh());
		clone.setLoaiHinhDoanhNghiepId(getLoaiHinhDoanhNghiepId());

		return clone;
	}

	public int compareTo(DoanhNghiep doanhNghiep) {
		int value = 0;

		if (getId() < doanhNghiep.getId()) {
			value = -1;
		}
		else if (getId() > doanhNghiep.getId()) {
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

		DoanhNghiepClp doanhNghiep = null;

		try {
			doanhNghiep = (DoanhNghiepClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = doanhNghiep.getPrimaryKey();

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
		StringBundler sb = new StringBundler(103);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", maSoThue=");
		sb.append(getMaSoThue());
		sb.append(", tenTiengNuocNgoai=");
		sb.append(getTenTiengNuocNgoai());
		sb.append(", tenVietTat=");
		sb.append(getTenVietTat());
		sb.append(", diaChiDoanhNghiep=");
		sb.append(getDiaChiDoanhNghiep());
		sb.append(", dienThoaiDoanhNghiep=");
		sb.append(getDienThoaiDoanhNghiep());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", emailDoanhNghiep=");
		sb.append(getEmailDoanhNghiep());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", tongSoVon=");
		sb.append(getTongSoVon());
		sb.append(", moTaNganhNgheKinhDoanh=");
		sb.append(getMoTaNganhNgheKinhDoanh());
		sb.append(", soGCNDKKD=");
		sb.append(getSoGCNDKKD());
		sb.append(", ngayCapGCNDKKD=");
		sb.append(getNgayCapGCNDKKD());
		sb.append(", noiLuuTruId=");
		sb.append(getNoiLuuTruId());
		sb.append(", ngayDieuLeDuocThongQua=");
		sb.append(getNgayDieuLeDuocThongQua());
		sb.append(", tenChiNhanh=");
		sb.append(getTenChiNhanh());
		sb.append(", diaChiChiNhanh=");
		sb.append(getDiaChiChiNhanh());
		sb.append(", tenVanPhongDaiDien=");
		sb.append(getTenVanPhongDaiDien());
		sb.append(", diaChiVanPhongDaiDien=");
		sb.append(getDiaChiVanPhongDaiDien());
		sb.append(", ngayBatDauTamNgung=");
		sb.append(getNgayBatDauTamNgung());
		sb.append(", ngayKetThucTamNgung=");
		sb.append(getNgayKetThucTamNgung());
		sb.append(", lyDoTamNgung=");
		sb.append(getLyDoTamNgung());
		sb.append(", ngayChamDutHoatDongKD=");
		sb.append(getNgayChamDutHoatDongKD());
		sb.append(", loai=");
		sb.append(getLoai());
		sb.append(", diaChiDoanhNghiepHuyenId=");
		sb.append(getDiaChiDoanhNghiepHuyenId());
		sb.append(", diaChiDoanhNghiepTinhId=");
		sb.append(getDiaChiDoanhNghiepTinhId());
		sb.append(", diaChiDoanhNghiepXaId=");
		sb.append(getDiaChiDoanhNghiepXaId());
		sb.append(", loaiDoiTuongId=");
		sb.append(getLoaiDoiTuongId());
		sb.append(", nguoiDaiDienId=");
		sb.append(getNguoiDaiDienId());
		sb.append(", trangThaiDoanhNghiepId=");
		sb.append(getTrangThaiDoanhNghiepId());
		sb.append(", vonDieuLe=");
		sb.append(getVonDieuLe());
		sb.append(", vonToiThieuMotXaVien=");
		sb.append(getVonToiThieuMotXaVien());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", quocGiaId=");
		sb.append(getQuocGiaId());
		sb.append(", coQuanCapId=");
		sb.append(getCoQuanCapId());
		sb.append(", tenCoQuanCap=");
		sb.append(getTenCoQuanCap());
		sb.append(", soLanDieuChinh=");
		sb.append(getSoLanDieuChinh());
		sb.append(", ngayDieuChinh=");
		sb.append(getNgayDieuChinh());
		sb.append(", chucVuNguoiDaiDien=");
		sb.append(getChucVuNguoiDaiDien());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", chaId=");
		sb.append(getChaId());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append(", tenDiaDiemKinhDoanh=");
		sb.append(getTenDiaDiemKinhDoanh());
		sb.append(", ngayDangKyKinhDoanh=");
		sb.append(getNgayDangKyKinhDoanh());
		sb.append(", loaiHinhDoanhNghiepId=");
		sb.append(getLoaiHinhDoanhNghiepId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(157);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dn.model.DoanhNghiep");
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
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoThue</column-name><column-value><![CDATA[");
		sb.append(getMaSoThue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenTiengNuocNgoai</column-name><column-value><![CDATA[");
		sb.append(getTenTiengNuocNgoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenVietTat</column-name><column-value><![CDATA[");
		sb.append(getTenVietTat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiDoanhNghiep</column-name><column-value><![CDATA[");
		sb.append(getDiaChiDoanhNghiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoaiDoanhNghiep</column-name><column-value><![CDATA[");
		sb.append(getDienThoaiDoanhNghiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailDoanhNghiep</column-name><column-value><![CDATA[");
		sb.append(getEmailDoanhNghiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongSoVon</column-name><column-value><![CDATA[");
		sb.append(getTongSoVon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTaNganhNgheKinhDoanh</column-name><column-value><![CDATA[");
		sb.append(getMoTaNganhNgheKinhDoanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soGCNDKKD</column-name><column-value><![CDATA[");
		sb.append(getSoGCNDKKD());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapGCNDKKD</column-name><column-value><![CDATA[");
		sb.append(getNgayCapGCNDKKD());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDieuLeDuocThongQua</column-name><column-value><![CDATA[");
		sb.append(getNgayDieuLeDuocThongQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenChiNhanh</column-name><column-value><![CDATA[");
		sb.append(getTenChiNhanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiChiNhanh</column-name><column-value><![CDATA[");
		sb.append(getDiaChiChiNhanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenVanPhongDaiDien</column-name><column-value><![CDATA[");
		sb.append(getTenVanPhongDaiDien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiVanPhongDaiDien</column-name><column-value><![CDATA[");
		sb.append(getDiaChiVanPhongDaiDien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayBatDauTamNgung</column-name><column-value><![CDATA[");
		sb.append(getNgayBatDauTamNgung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayKetThucTamNgung</column-name><column-value><![CDATA[");
		sb.append(getNgayKetThucTamNgung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lyDoTamNgung</column-name><column-value><![CDATA[");
		sb.append(getLyDoTamNgung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayChamDutHoatDongKD</column-name><column-value><![CDATA[");
		sb.append(getNgayChamDutHoatDongKD());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loai</column-name><column-value><![CDATA[");
		sb.append(getLoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiDoanhNghiepHuyenId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiDoanhNghiepHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiDoanhNghiepTinhId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiDoanhNghiepTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiDoanhNghiepXaId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiDoanhNghiepXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiDoiTuongId</column-name><column-value><![CDATA[");
		sb.append(getLoaiDoiTuongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiDaiDienId</column-name><column-value><![CDATA[");
		sb.append(getNguoiDaiDienId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiDoanhNghiepId</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiDoanhNghiepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vonDieuLe</column-name><column-value><![CDATA[");
		sb.append(getVonDieuLe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vonToiThieuMotXaVien</column-name><column-value><![CDATA[");
		sb.append(getVonToiThieuMotXaVien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quocGiaId</column-name><column-value><![CDATA[");
		sb.append(getQuocGiaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanCapId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanCapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanCap</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soLanDieuChinh</column-name><column-value><![CDATA[");
		sb.append(getSoLanDieuChinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDieuChinh</column-name><column-value><![CDATA[");
		sb.append(getNgayDieuChinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucVuNguoiDaiDien</column-name><column-value><![CDATA[");
		sb.append(getChucVuNguoiDaiDien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chaId</column-name><column-value><![CDATA[");
		sb.append(getChaId());
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
			"<column><column-name>taiKhoanNguoiDungId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenDiaDiemKinhDoanh</column-name><column-value><![CDATA[");
		sb.append(getTenDiaDiemKinhDoanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDangKyKinhDoanh</column-name><column-value><![CDATA[");
		sb.append(getNgayDangKyKinhDoanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiHinhDoanhNghiepId</column-name><column-value><![CDATA[");
		sb.append(getLoaiHinhDoanhNghiepId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _maSoThue;
	private String _tenTiengNuocNgoai;
	private String _tenVietTat;
	private String _diaChiDoanhNghiep;
	private String _dienThoaiDoanhNghiep;
	private String _fax;
	private String _emailDoanhNghiep;
	private String _website;
	private long _tongSoVon;
	private String _moTaNganhNgheKinhDoanh;
	private String _soGCNDKKD;
	private Date _ngayCapGCNDKKD;
	private long _noiLuuTruId;
	private Date _ngayDieuLeDuocThongQua;
	private String _tenChiNhanh;
	private String _diaChiChiNhanh;
	private String _tenVanPhongDaiDien;
	private String _diaChiVanPhongDaiDien;
	private Date _ngayBatDauTamNgung;
	private Date _ngayKetThucTamNgung;
	private String _lyDoTamNgung;
	private Date _ngayChamDutHoatDongKD;
	private long _loai;
	private Long _diaChiDoanhNghiepHuyenId;
	private Long _diaChiDoanhNghiepTinhId;
	private Long _diaChiDoanhNghiepXaId;
	private Long _loaiDoiTuongId;
	private Long _nguoiDaiDienId;
	private Long _trangThaiDoanhNghiepId;
	private long _vonDieuLe;
	private long _vonToiThieuMotXaVien;
	private String _ghiChu;
	private Long _quocGiaId;
	private Long _coQuanCapId;
	private long _tenCoQuanCap;
	private String _soLanDieuChinh;
	private Date _ngayDieuChinh;
	private String _chucVuNguoiDaiDien;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private Long _chaId;
	private String _nguoiTao;
	private String _nguoiSua;
	private Long _taiKhoanNguoiDungId;
	private String _tenDiaDiemKinhDoanh;
	private Date _ngayDangKyKinhDoanh;
	private Long _loaiHinhDoanhNghiepId;
}