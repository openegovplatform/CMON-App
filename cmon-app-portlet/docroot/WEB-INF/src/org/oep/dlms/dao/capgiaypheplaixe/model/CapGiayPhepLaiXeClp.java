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

package org.oep.dlms.dao.capgiaypheplaixe.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;


import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

import org.oep.dlms.dao.capgiaypheplaixe.service.CapGiayPhepLaiXeLocalServiceUtil;

/**
 * @author AnhNT
 */
public class CapGiayPhepLaiXeClp extends BaseModelImpl<CapGiayPhepLaiXe>
	implements CapGiayPhepLaiXe {
	public CapGiayPhepLaiXeClp() {
	}

	public Class<?> getModelClass() {
		return CapGiayPhepLaiXe.class;
	}

	public String getModelClassName() {
		return CapGiayPhepLaiXe.class.getName();
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

	public long getIdCoQuanQuanLy() {
		return _idCoQuanQuanLy;
	}

	public void setIdCoQuanQuanLy(long idCoQuanQuanLy) {
		_idCoQuanQuanLy = idCoQuanQuanLy;
	}

	public long getIdCongDan() {
		return _idCongDan;
	}

	public void setIdCongDan(long idCongDan) {
		_idCongDan = idCongDan;
	}

	public long getIdLoaiHoSo() {
		return _idLoaiHoSo;
	}

	public void setIdLoaiHoSo(long idLoaiHoSo) {
		_idLoaiHoSo = idLoaiHoSo;
	}

	public long getSoHoSo() {
		return _soHoSo;
	}

	public void setSoHoSo(long soHoSo) {
		_soHoSo = soHoSo;
	}

	public String getHoVaTen() {
		return _hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		_hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public long getIdGioiTinh() {
		return _idGioiTinh;
	}

	public void setIdGioiTinh(long idGioiTinh) {
		_idGioiTinh = idGioiTinh;
	}

	public long getIdQuocTich() {
		return _idQuocTich;
	}

	public void setIdQuocTich(long idQuocTich) {
		_idQuocTich = idQuocTich;
	}

	public String getSoCMND() {
		return _soCMND;
	}

	public void setSoCMND(String soCMND) {
		_soCMND = soCMND;
	}

	public Date getNgayCapCMND() {
		return _ngayCapCMND;
	}

	public void setNgayCapCMND(Date ngayCapCMND) {
		_ngayCapCMND = ngayCapCMND;
	}

	public long getIdNoiCapCMND() {
		return _idNoiCapCMND;
	}

	public void setIdNoiCapCMND(long idNoiCapCMND) {
		_idNoiCapCMND = idNoiCapCMND;
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

	public long getNoiCapHoChieu() {
		return _noiCapHoChieu;
	}

	public void setNoiCapHoChieu(long noiCapHoChieu) {
		_noiCapHoChieu = noiCapHoChieu;
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public long getIdTinhThuongTru() {
		return _idTinhThuongTru;
	}

	public void setIdTinhThuongTru(long idTinhThuongTru) {
		_idTinhThuongTru = idTinhThuongTru;
	}

	public long getIdHuyenThuongTru() {
		return _idHuyenThuongTru;
	}

	public void setIdHuyenThuongTru(long idHuyenThuongTru) {
		_idHuyenThuongTru = idHuyenThuongTru;
	}

	public long getIdXaThuongTru() {
		return _idXaThuongTru;
	}

	public void setIdXaThuongTru(long idXaThuongTru) {
		_idXaThuongTru = idXaThuongTru;
	}

	public String getDiaChiThuongTru() {
		return _diaChiThuongTru;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		_diaChiThuongTru = diaChiThuongTru;
	}

	public long getIdTinhCuTru() {
		return _idTinhCuTru;
	}

	public void setIdTinhCuTru(long idTinhCuTru) {
		_idTinhCuTru = idTinhCuTru;
	}

	public long getIdHuyenCuTru() {
		return _idHuyenCuTru;
	}

	public void setIdHuyenCuTru(long idHuyenCuTru) {
		_idHuyenCuTru = idHuyenCuTru;
	}

	public long getIdXaCuTru() {
		return _idXaCuTru;
	}

	public void setIdXaCuTru(long idXaCuTru) {
		_idXaCuTru = idXaCuTru;
	}

	public String getDiaChiCuTru() {
		return _diaChiCuTru;
	}

	public void setDiaChiCuTru(String diaChiCuTru) {
		_diaChiCuTru = diaChiCuTru;
	}

	public String getSoGiayPhepLaiXe() {
		return _soGiayPhepLaiXe;
	}

	public void setSoGiayPhepLaiXe(String soGiayPhepLaiXe) {
		_soGiayPhepLaiXe = soGiayPhepLaiXe;
	}

	public long getIdHangGiayPhepLaiXe() {
		return _idHangGiayPhepLaiXe;
	}

	public void setIdHangGiayPhepLaiXe(long idHangGiayPhepLaiXe) {
		_idHangGiayPhepLaiXe = idHangGiayPhepLaiXe;
	}

	public long getIdDonViCapGPLX() {
		return _idDonViCapGPLX;
	}

	public void setIdDonViCapGPLX(long idDonViCapGPLX) {
		_idDonViCapGPLX = idDonViCapGPLX;
	}

	public Date getNgayCapGPLX() {
		return _ngayCapGPLX;
	}

	public void setNgayCapGPLX(Date ngayCapGPLX) {
		_ngayCapGPLX = ngayCapGPLX;
	}

	public long getIdNoiCapGPLX() {
		return _idNoiCapGPLX;
	}

	public void setIdNoiCapGPLX(long idNoiCapGPLX) {
		_idNoiCapGPLX = idNoiCapGPLX;
	}

	public Date getNgayDauSatHach() {
		return _ngayDauSatHach;
	}

	public void setNgayDauSatHach(Date ngayDauSatHach) {
		_ngayDauSatHach = ngayDauSatHach;
	}

	public long getIdNoiHocLaiXe() {
		return _idNoiHocLaiXe;
	}

	public void setIdNoiHocLaiXe(long idNoiHocLaiXe) {
		_idNoiHocLaiXe = idNoiHocLaiXe;
	}

	public int getNamHocLaiXe() {
		return _namHocLaiXe;
	}

	public void setNamHocLaiXe(int namHocLaiXe) {
		_namHocLaiXe = namHocLaiXe;
	}

	public int getNamTrungTuyenHangCaoNhat() {
		return _namTrungTuyenHangCaoNhat;
	}

	public void setNamTrungTuyenHangCaoNhat(int namTrungTuyenHangCaoNhat) {
		_namTrungTuyenHangCaoNhat = namTrungTuyenHangCaoNhat;
	}

	public String getLyDoHoc() {
		return _lyDoHoc;
	}

	public void setLyDoHoc(String lyDoHoc) {
		_lyDoHoc = lyDoHoc;
	}

	public String getMucDichHoc() {
		return _mucDichHoc;
	}

	public void setMucDichHoc(String mucDichHoc) {
		_mucDichHoc = mucDichHoc;
	}

	public double getSoNamLaiXe() {
		return _soNamLaiXe;
	}

	public void setSoNamLaiXe(double soNamLaiXe) {
		_soNamLaiXe = soNamLaiXe;
	}

	public double getSoKmLaiXe() {
		return _soKmLaiXe;
	}

	public void setSoKmLaiXe(double soKmLaiXe) {
		_soKmLaiXe = soKmLaiXe;
	}

	public Date getNgayTraGPLX() {
		return _ngayTraGPLX;
	}

	public void setNgayTraGPLX(Date ngayTraGPLX) {
		_ngayTraGPLX = ngayTraGPLX;
	}

	public long getIdLyDoCapDoiLaiGPLX() {
		return _idLyDoCapDoiLaiGPLX;
	}

	public void setIdLyDoCapDoiLaiGPLX(long idLyDoCapDoiLaiGPLX) {
		_idLyDoCapDoiLaiGPLX = idLyDoCapDoiLaiGPLX;
	}

	public String getLyDo() {
		return _lyDo;
	}

	public void setLyDo(String lyDo) {
		_lyDo = lyDo;
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

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CapGiayPhepLaiXeLocalServiceUtil.addCapGiayPhepLaiXe(this);
		}
		else {
			CapGiayPhepLaiXeLocalServiceUtil.updateCapGiayPhepLaiXe(this);
		}
	}

	@Override
	public CapGiayPhepLaiXe toEscapedModel() {
		return (CapGiayPhepLaiXe)Proxy.newProxyInstance(CapGiayPhepLaiXe.class.getClassLoader(),
			new Class[] { CapGiayPhepLaiXe.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CapGiayPhepLaiXeClp clone = new CapGiayPhepLaiXeClp();

		clone.setId(getId());
		clone.setIdCoQuanQuanLy(getIdCoQuanQuanLy());
		clone.setIdCongDan(getIdCongDan());
		clone.setIdLoaiHoSo(getIdLoaiHoSo());
		clone.setSoHoSo(getSoHoSo());
		clone.setHoVaTen(getHoVaTen());
		clone.setNgaySinh(getNgaySinh());
		clone.setIdGioiTinh(getIdGioiTinh());
		clone.setIdQuocTich(getIdQuocTich());
		clone.setSoCMND(getSoCMND());
		clone.setNgayCapCMND(getNgayCapCMND());
		clone.setIdNoiCapCMND(getIdNoiCapCMND());
		clone.setSoHoChieu(getSoHoChieu());
		clone.setNgayCapHoChieu(getNgayCapHoChieu());
		clone.setNoiCapHoChieu(getNoiCapHoChieu());
		clone.setDienThoai(getDienThoai());
		clone.setEmail(getEmail());
		clone.setGhiChu(getGhiChu());
		clone.setIdTinhThuongTru(getIdTinhThuongTru());
		clone.setIdHuyenThuongTru(getIdHuyenThuongTru());
		clone.setIdXaThuongTru(getIdXaThuongTru());
		clone.setDiaChiThuongTru(getDiaChiThuongTru());
		clone.setIdTinhCuTru(getIdTinhCuTru());
		clone.setIdHuyenCuTru(getIdHuyenCuTru());
		clone.setIdXaCuTru(getIdXaCuTru());
		clone.setDiaChiCuTru(getDiaChiCuTru());
		clone.setSoGiayPhepLaiXe(getSoGiayPhepLaiXe());
		clone.setIdHangGiayPhepLaiXe(getIdHangGiayPhepLaiXe());
		clone.setIdDonViCapGPLX(getIdDonViCapGPLX());
		clone.setNgayCapGPLX(getNgayCapGPLX());
		clone.setIdNoiCapGPLX(getIdNoiCapGPLX());
		clone.setNgayDauSatHach(getNgayDauSatHach());
		clone.setIdNoiHocLaiXe(getIdNoiHocLaiXe());
		clone.setNamHocLaiXe(getNamHocLaiXe());
		clone.setNamTrungTuyenHangCaoNhat(getNamTrungTuyenHangCaoNhat());
		clone.setLyDoHoc(getLyDoHoc());
		clone.setMucDichHoc(getMucDichHoc());
		clone.setSoNamLaiXe(getSoNamLaiXe());
		clone.setSoKmLaiXe(getSoKmLaiXe());
		clone.setNgayTraGPLX(getNgayTraGPLX());
		clone.setIdLyDoCapDoiLaiGPLX(getIdLyDoCapDoiLaiGPLX());
		clone.setLyDo(getLyDo());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setXoa(getXoa());

		return clone;
	}

	public int compareTo(CapGiayPhepLaiXe capGiayPhepLaiXe) {
		int value = 0;

		if (getId() < capGiayPhepLaiXe.getId()) {
			value = -1;
		}
		else if (getId() > capGiayPhepLaiXe.getId()) {
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

		CapGiayPhepLaiXeClp capGiayPhepLaiXe = null;

		try {
			capGiayPhepLaiXe = (CapGiayPhepLaiXeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = capGiayPhepLaiXe.getPrimaryKey();

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
		StringBundler sb = new StringBundler(95);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", idCoQuanQuanLy=");
		sb.append(getIdCoQuanQuanLy());
		sb.append(", idCongDan=");
		sb.append(getIdCongDan());
		sb.append(", idLoaiHoSo=");
		sb.append(getIdLoaiHoSo());
		sb.append(", soHoSo=");
		sb.append(getSoHoSo());
		sb.append(", hoVaTen=");
		sb.append(getHoVaTen());
		sb.append(", ngaySinh=");
		sb.append(getNgaySinh());
		sb.append(", idGioiTinh=");
		sb.append(getIdGioiTinh());
		sb.append(", idQuocTich=");
		sb.append(getIdQuocTich());
		sb.append(", soCMND=");
		sb.append(getSoCMND());
		sb.append(", ngayCapCMND=");
		sb.append(getNgayCapCMND());
		sb.append(", idNoiCapCMND=");
		sb.append(getIdNoiCapCMND());
		sb.append(", soHoChieu=");
		sb.append(getSoHoChieu());
		sb.append(", ngayCapHoChieu=");
		sb.append(getNgayCapHoChieu());
		sb.append(", noiCapHoChieu=");
		sb.append(getNoiCapHoChieu());
		sb.append(", dienThoai=");
		sb.append(getDienThoai());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", idTinhThuongTru=");
		sb.append(getIdTinhThuongTru());
		sb.append(", idHuyenThuongTru=");
		sb.append(getIdHuyenThuongTru());
		sb.append(", idXaThuongTru=");
		sb.append(getIdXaThuongTru());
		sb.append(", diaChiThuongTru=");
		sb.append(getDiaChiThuongTru());
		sb.append(", idTinhCuTru=");
		sb.append(getIdTinhCuTru());
		sb.append(", idHuyenCuTru=");
		sb.append(getIdHuyenCuTru());
		sb.append(", idXaCuTru=");
		sb.append(getIdXaCuTru());
		sb.append(", diaChiCuTru=");
		sb.append(getDiaChiCuTru());
		sb.append(", soGiayPhepLaiXe=");
		sb.append(getSoGiayPhepLaiXe());
		sb.append(", idHangGiayPhepLaiXe=");
		sb.append(getIdHangGiayPhepLaiXe());
		sb.append(", idDonViCapGPLX=");
		sb.append(getIdDonViCapGPLX());
		sb.append(", ngayCapGPLX=");
		sb.append(getNgayCapGPLX());
		sb.append(", idNoiCapGPLX=");
		sb.append(getIdNoiCapGPLX());
		sb.append(", ngayDauSatHach=");
		sb.append(getNgayDauSatHach());
		sb.append(", idNoiHocLaiXe=");
		sb.append(getIdNoiHocLaiXe());
		sb.append(", namHocLaiXe=");
		sb.append(getNamHocLaiXe());
		sb.append(", namTrungTuyenHangCaoNhat=");
		sb.append(getNamTrungTuyenHangCaoNhat());
		sb.append(", lyDoHoc=");
		sb.append(getLyDoHoc());
		sb.append(", mucDichHoc=");
		sb.append(getMucDichHoc());
		sb.append(", soNamLaiXe=");
		sb.append(getSoNamLaiXe());
		sb.append(", soKmLaiXe=");
		sb.append(getSoKmLaiXe());
		sb.append(", ngayTraGPLX=");
		sb.append(getNgayTraGPLX());
		sb.append(", idLyDoCapDoiLaiGPLX=");
		sb.append(getIdLyDoCapDoiLaiGPLX());
		sb.append(", lyDo=");
		sb.append(getLyDo());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", xoa=");
		sb.append(getXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(145);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCoQuanQuanLy</column-name><column-value><![CDATA[");
		sb.append(getIdCoQuanQuanLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCongDan</column-name><column-value><![CDATA[");
		sb.append(getIdCongDan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idLoaiHoSo</column-name><column-value><![CDATA[");
		sb.append(getIdLoaiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soHoSo</column-name><column-value><![CDATA[");
		sb.append(getSoHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoVaTen</column-name><column-value><![CDATA[");
		sb.append(getHoVaTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySinh</column-name><column-value><![CDATA[");
		sb.append(getNgaySinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idGioiTinh</column-name><column-value><![CDATA[");
		sb.append(getIdGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idQuocTich</column-name><column-value><![CDATA[");
		sb.append(getIdQuocTich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soCMND</column-name><column-value><![CDATA[");
		sb.append(getSoCMND());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapCMND</column-name><column-value><![CDATA[");
		sb.append(getNgayCapCMND());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiCapCMND</column-name><column-value><![CDATA[");
		sb.append(getIdNoiCapCMND());
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
			"<column><column-name>noiCapHoChieu</column-name><column-value><![CDATA[");
		sb.append(getNoiCapHoChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoai</column-name><column-value><![CDATA[");
		sb.append(getDienThoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idTinhThuongTru</column-name><column-value><![CDATA[");
		sb.append(getIdTinhThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idHuyenThuongTru</column-name><column-value><![CDATA[");
		sb.append(getIdHuyenThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idXaThuongTru</column-name><column-value><![CDATA[");
		sb.append(getIdXaThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTru</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idTinhCuTru</column-name><column-value><![CDATA[");
		sb.append(getIdTinhCuTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idHuyenCuTru</column-name><column-value><![CDATA[");
		sb.append(getIdHuyenCuTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idXaCuTru</column-name><column-value><![CDATA[");
		sb.append(getIdXaCuTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiCuTru</column-name><column-value><![CDATA[");
		sb.append(getDiaChiCuTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soGiayPhepLaiXe</column-name><column-value><![CDATA[");
		sb.append(getSoGiayPhepLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idHangGiayPhepLaiXe</column-name><column-value><![CDATA[");
		sb.append(getIdHangGiayPhepLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDonViCapGPLX</column-name><column-value><![CDATA[");
		sb.append(getIdDonViCapGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapGPLX</column-name><column-value><![CDATA[");
		sb.append(getNgayCapGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiCapGPLX</column-name><column-value><![CDATA[");
		sb.append(getIdNoiCapGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDauSatHach</column-name><column-value><![CDATA[");
		sb.append(getNgayDauSatHach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiHocLaiXe</column-name><column-value><![CDATA[");
		sb.append(getIdNoiHocLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>namHocLaiXe</column-name><column-value><![CDATA[");
		sb.append(getNamHocLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>namTrungTuyenHangCaoNhat</column-name><column-value><![CDATA[");
		sb.append(getNamTrungTuyenHangCaoNhat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lyDoHoc</column-name><column-value><![CDATA[");
		sb.append(getLyDoHoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mucDichHoc</column-name><column-value><![CDATA[");
		sb.append(getMucDichHoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNamLaiXe</column-name><column-value><![CDATA[");
		sb.append(getSoNamLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soKmLaiXe</column-name><column-value><![CDATA[");
		sb.append(getSoKmLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTraGPLX</column-name><column-value><![CDATA[");
		sb.append(getNgayTraGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idLyDoCapDoiLaiGPLX</column-name><column-value><![CDATA[");
		sb.append(getIdLyDoCapDoiLaiGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lyDo</column-name><column-value><![CDATA[");
		sb.append(getLyDo());
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
			"<column><column-name>xoa</column-name><column-value><![CDATA[");
		sb.append(getXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _idCoQuanQuanLy;
	private long _idCongDan;
	private long _idLoaiHoSo;
	private long _soHoSo;
	private String _hoVaTen;
	private Date _ngaySinh;
	private long _idGioiTinh;
	private long _idQuocTich;
	private String _soCMND;
	private Date _ngayCapCMND;
	private long _idNoiCapCMND;
	private String _soHoChieu;
	private Date _ngayCapHoChieu;
	private long _noiCapHoChieu;
	private String _dienThoai;
	private String _email;
	private String _ghiChu;
	private long _idTinhThuongTru;
	private long _idHuyenThuongTru;
	private long _idXaThuongTru;
	private String _diaChiThuongTru;
	private long _idTinhCuTru;
	private long _idHuyenCuTru;
	private long _idXaCuTru;
	private String _diaChiCuTru;
	private String _soGiayPhepLaiXe;
	private long _idHangGiayPhepLaiXe;
	private long _idDonViCapGPLX;
	private Date _ngayCapGPLX;
	private long _idNoiCapGPLX;
	private Date _ngayDauSatHach;
	private long _idNoiHocLaiXe;
	private int _namHocLaiXe;
	private int _namTrungTuyenHangCaoNhat;
	private String _lyDoHoc;
	private String _mucDichHoc;
	private double _soNamLaiXe;
	private double _soKmLaiXe;
	private Date _ngayTraGPLX;
	private long _idLyDoCapDoiLaiGPLX;
	private String _lyDo;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
}