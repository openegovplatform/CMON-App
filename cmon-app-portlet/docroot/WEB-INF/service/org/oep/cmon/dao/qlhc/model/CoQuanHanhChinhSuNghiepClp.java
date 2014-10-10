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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.qlhc.service.CoQuanHanhChinhSuNghiepLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class CoQuanHanhChinhSuNghiepClp extends BaseModelImpl<CoQuanHanhChinhSuNghiep>
	implements CoQuanHanhChinhSuNghiep {
	public CoQuanHanhChinhSuNghiepClp() {
	}

	public Class<?> getModelClass() {
		return CoQuanHanhChinhSuNghiep.class;
	}

	public String getModelClassName() {
		return CoQuanHanhChinhSuNghiep.class.getName();
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

	public String getSoDTDuongDayNong() {
		return _soDTDuongDayNong;
	}

	public void setSoDTDuongDayNong(String soDTDuongDayNong) {
		_soDTDuongDayNong = soDTDuongDayNong;
	}

	public long getNoiBo() {
		return _noiBo;
	}

	public void setNoiBo(long noiBo) {
		_noiBo = noiBo;
	}

	public String getChucNang() {
		return _chucNang;
	}

	public void setChucNang(String chucNang) {
		_chucNang = chucNang;
	}

	public long getTongSoCBNV() {
		return _tongSoCBNV;
	}

	public void setTongSoCBNV(long tongSoCBNV) {
		_tongSoCBNV = tongSoCBNV;
	}

	public String getSoDT() {
		return _soDT;
	}

	public void setSoDT(String soDT) {
		_soDT = soDT;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getTongSoGiuongBenh() {
		return _tongSoGiuongBenh;
	}

	public void setTongSoGiuongBenh(long tongSoGiuongBenh) {
		_tongSoGiuongBenh = tongSoGiuongBenh;
	}

	public String getViDo() {
		return _viDo;
	}

	public void setViDo(String viDo) {
		_viDo = viDo;
	}

	public String getKinhDo() {
		return _kinhDo;
	}

	public void setKinhDo(String kinhDo) {
		_kinhDo = kinhDo;
	}

	public long getDiaChiCoQuanHCSNXaId() {
		return _diaChiCoQuanHCSNXaId;
	}

	public void setDiaChiCoQuanHCSNXaId(long diaChiCoQuanHCSNXaId) {
		_diaChiCoQuanHCSNXaId = diaChiCoQuanHCSNXaId;
	}

	public long getTuyenId() {
		return _tuyenId;
	}

	public void setTuyenId(long tuyenId) {
		_tuyenId = tuyenId;
	}

	public long getDiaChiCoQuanHCSNTinhId() {
		return _diaChiCoQuanHCSNTinhId;
	}

	public void setDiaChiCoQuanHCSNTinhId(long diaChiCoQuanHCSNTinhId) {
		_diaChiCoQuanHCSNTinhId = diaChiCoQuanHCSNTinhId;
	}

	public long getNguoiDaiDienId() {
		return _nguoiDaiDienId;
	}

	public void setNguoiDaiDienId(long nguoiDaiDienId) {
		_nguoiDaiDienId = nguoiDaiDienId;
	}

	public long getDiaChiCoQuanHCSNHuyenId() {
		return _diaChiCoQuanHCSNHuyenId;
	}

	public void setDiaChiCoQuanHCSNHuyenId(long diaChiCoQuanHCSNHuyenId) {
		_diaChiCoQuanHCSNHuyenId = diaChiCoQuanHCSNHuyenId;
	}

	public long getHangId() {
		return _hangId;
	}

	public void setHangId(long hangId) {
		_hangId = hangId;
	}

	public String getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(String coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public String getLoaiId() {
		return _loaiId;
	}

	public void setLoaiId(String loaiId) {
		_loaiId = loaiId;
	}

	public String getSoQdThanhLap() {
		return _soQdThanhLap;
	}

	public void setSoQdThanhLap(String soQdThanhLap) {
		_soQdThanhLap = soQdThanhLap;
	}

	public String getMoTaDiaChi() {
		return _moTaDiaChi;
	}

	public void setMoTaDiaChi(String moTaDiaChi) {
		_moTaDiaChi = moTaDiaChi;
	}

	public String getTenNguoiDaiDien() {
		return _tenNguoiDaiDien;
	}

	public void setTenNguoiDaiDien(String tenNguoiDaiDien) {
		_tenNguoiDaiDien = tenNguoiDaiDien;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			CoQuanHanhChinhSuNghiepLocalServiceUtil.addCoQuanHanhChinhSuNghiep(this);
		}
		else {
			CoQuanHanhChinhSuNghiepLocalServiceUtil.updateCoQuanHanhChinhSuNghiep(this);
		}
	}

	@Override
	public CoQuanHanhChinhSuNghiep toEscapedModel() {
		return (CoQuanHanhChinhSuNghiep)Proxy.newProxyInstance(CoQuanHanhChinhSuNghiep.class.getClassLoader(),
			new Class[] { CoQuanHanhChinhSuNghiep.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CoQuanHanhChinhSuNghiepClp clone = new CoQuanHanhChinhSuNghiepClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setSoDTDuongDayNong(getSoDTDuongDayNong());
		clone.setNoiBo(getNoiBo());
		clone.setChucNang(getChucNang());
		clone.setTongSoCBNV(getTongSoCBNV());
		clone.setSoDT(getSoDT());
		clone.setFax(getFax());
		clone.setEmail(getEmail());
		clone.setTongSoGiuongBenh(getTongSoGiuongBenh());
		clone.setViDo(getViDo());
		clone.setKinhDo(getKinhDo());
		clone.setDiaChiCoQuanHCSNXaId(getDiaChiCoQuanHCSNXaId());
		clone.setTuyenId(getTuyenId());
		clone.setDiaChiCoQuanHCSNTinhId(getDiaChiCoQuanHCSNTinhId());
		clone.setNguoiDaiDienId(getNguoiDaiDienId());
		clone.setDiaChiCoQuanHCSNHuyenId(getDiaChiCoQuanHCSNHuyenId());
		clone.setHangId(getHangId());
		clone.setCoQuanQuanLyId(getCoQuanQuanLyId());
		clone.setLoaiId(getLoaiId());
		clone.setSoQdThanhLap(getSoQdThanhLap());
		clone.setMoTaDiaChi(getMoTaDiaChi());
		clone.setTenNguoiDaiDien(getTenNguoiDaiDien());
		clone.setNgayTao(getNgayTao());
		clone.setDaXoa(getDaXoa());
		clone.setNgaySua(getNgaySua());
		clone.setChaId(getChaId());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());

		return clone;
	}

	public int compareTo(CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep) {
		int value = 0;

		if (getId() < coQuanHanhChinhSuNghiep.getId()) {
			value = -1;
		}
		else if (getId() > coQuanHanhChinhSuNghiep.getId()) {
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

		CoQuanHanhChinhSuNghiepClp coQuanHanhChinhSuNghiep = null;

		try {
			coQuanHanhChinhSuNghiep = (CoQuanHanhChinhSuNghiepClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = coQuanHanhChinhSuNghiep.getPrimaryKey();

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
		StringBundler sb = new StringBundler(61);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", soDTDuongDayNong=");
		sb.append(getSoDTDuongDayNong());
		sb.append(", noiBo=");
		sb.append(getNoiBo());
		sb.append(", chucNang=");
		sb.append(getChucNang());
		sb.append(", tongSoCBNV=");
		sb.append(getTongSoCBNV());
		sb.append(", soDT=");
		sb.append(getSoDT());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", tongSoGiuongBenh=");
		sb.append(getTongSoGiuongBenh());
		sb.append(", viDo=");
		sb.append(getViDo());
		sb.append(", kinhDo=");
		sb.append(getKinhDo());
		sb.append(", diaChiCoQuanHCSNXaId=");
		sb.append(getDiaChiCoQuanHCSNXaId());
		sb.append(", tuyenId=");
		sb.append(getTuyenId());
		sb.append(", diaChiCoQuanHCSNTinhId=");
		sb.append(getDiaChiCoQuanHCSNTinhId());
		sb.append(", nguoiDaiDienId=");
		sb.append(getNguoiDaiDienId());
		sb.append(", diaChiCoQuanHCSNHuyenId=");
		sb.append(getDiaChiCoQuanHCSNHuyenId());
		sb.append(", hangId=");
		sb.append(getHangId());
		sb.append(", coQuanQuanLyId=");
		sb.append(getCoQuanQuanLyId());
		sb.append(", loaiId=");
		sb.append(getLoaiId());
		sb.append(", soQdThanhLap=");
		sb.append(getSoQdThanhLap());
		sb.append(", moTaDiaChi=");
		sb.append(getMoTaDiaChi());
		sb.append(", tenNguoiDaiDien=");
		sb.append(getTenNguoiDaiDien());
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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep");
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
			"<column><column-name>soDTDuongDayNong</column-name><column-value><![CDATA[");
		sb.append(getSoDTDuongDayNong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiBo</column-name><column-value><![CDATA[");
		sb.append(getNoiBo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucNang</column-name><column-value><![CDATA[");
		sb.append(getChucNang());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongSoCBNV</column-name><column-value><![CDATA[");
		sb.append(getTongSoCBNV());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDT</column-name><column-value><![CDATA[");
		sb.append(getSoDT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongSoGiuongBenh</column-name><column-value><![CDATA[");
		sb.append(getTongSoGiuongBenh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viDo</column-name><column-value><![CDATA[");
		sb.append(getViDo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kinhDo</column-name><column-value><![CDATA[");
		sb.append(getKinhDo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiCoQuanHCSNXaId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiCoQuanHCSNXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tuyenId</column-name><column-value><![CDATA[");
		sb.append(getTuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiCoQuanHCSNTinhId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiCoQuanHCSNTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiDaiDienId</column-name><column-value><![CDATA[");
		sb.append(getNguoiDaiDienId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiCoQuanHCSNHuyenId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiCoQuanHCSNHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hangId</column-name><column-value><![CDATA[");
		sb.append(getHangId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanQuanLyId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanQuanLyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiId</column-name><column-value><![CDATA[");
		sb.append(getLoaiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soQdThanhLap</column-name><column-value><![CDATA[");
		sb.append(getSoQdThanhLap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTaDiaChi</column-name><column-value><![CDATA[");
		sb.append(getMoTaDiaChi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenNguoiDaiDien</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiDaiDien());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _soDTDuongDayNong;
	private long _noiBo;
	private String _chucNang;
	private long _tongSoCBNV;
	private String _soDT;
	private String _fax;
	private String _email;
	private long _tongSoGiuongBenh;
	private String _viDo;
	private String _kinhDo;
	private long _diaChiCoQuanHCSNXaId;
	private long _tuyenId;
	private long _diaChiCoQuanHCSNTinhId;
	private long _nguoiDaiDienId;
	private long _diaChiCoQuanHCSNHuyenId;
	private long _hangId;
	private String _coQuanQuanLyId;
	private String _loaiId;
	private String _soQdThanhLap;
	private String _moTaDiaChi;
	private String _tenNguoiDaiDien;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private Long _chaId;
	private String _nguoiTao;
	private String _nguoiSua;
}