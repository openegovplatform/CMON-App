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

import org.oep.cmon.dao.dn.service.YeuCauDangKyDoanhNghiepLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class YeuCauDangKyDoanhNghiepClp extends BaseModelImpl<YeuCauDangKyDoanhNghiep>
	implements YeuCauDangKyDoanhNghiep {
	public YeuCauDangKyDoanhNghiepClp() {
	}

	public Class<?> getModelClass() {
		return YeuCauDangKyDoanhNghiep.class;
	}

	public String getModelClassName() {
		return YeuCauDangKyDoanhNghiep.class.getName();
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

	public long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
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

	public String getMaGiayPhep() {
		return _maGiayPhep;
	}

	public void setMaGiayPhep(String maGiayPhep) {
		_maGiayPhep = maGiayPhep;
	}

	public Date getNgayCap() {
		return _ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		_ngayCap = ngayCap;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getHoNguoiDaiDien() {
		return _hoNguoiDaiDien;
	}

	public void setHoNguoiDaiDien(String hoNguoiDaiDien) {
		_hoNguoiDaiDien = hoNguoiDaiDien;
	}

	public String getTenDemNguoiDaiDien() {
		return _tenDemNguoiDaiDien;
	}

	public void setTenDemNguoiDaiDien(String tenDemNguoiDaiDien) {
		_tenDemNguoiDaiDien = tenDemNguoiDaiDien;
	}

	public String getTenNguoiDaiDien() {
		return _tenNguoiDaiDien;
	}

	public void setTenNguoiDaiDien(String tenNguoiDaiDien) {
		_tenNguoiDaiDien = tenNguoiDaiDien;
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

	public String getNoiCapCMND() {
		return _noiCapCMND;
	}

	public void setNoiCapCMND(String noiCapCMND) {
		_noiCapCMND = noiCapCMND;
	}

	public String getMoTaNganhNgheKinhDoanh() {
		return _moTaNganhNgheKinhDoanh;
	}

	public void setMoTaNganhNgheKinhDoanh(String moTaNganhNgheKinhDoanh) {
		_moTaNganhNgheKinhDoanh = moTaNganhNgheKinhDoanh;
	}

	public String getLoaiHinhDoanhNghiep() {
		return _loaiHinhDoanhNghiep;
	}

	public void setLoaiHinhDoanhNghiep(String loaiHinhDoanhNghiep) {
		_loaiHinhDoanhNghiep = loaiHinhDoanhNghiep;
	}

	public String getTruSo() {
		return _truSo;
	}

	public void setTruSo(String truSo) {
		_truSo = truSo;
	}

	public long getTruSoXaId() {
		return _truSoXaId;
	}

	public void setTruSoXaId(long truSoXaId) {
		_truSoXaId = truSoXaId;
	}

	public long getTruSoHuyenId() {
		return _truSoHuyenId;
	}

	public void setTruSoHuyenId(long truSoHuyenId) {
		_truSoHuyenId = truSoHuyenId;
	}

	public long getTruSoTinhId() {
		return _truSoTinhId;
	}

	public void setTruSoTinhId(long truSoTinhId) {
		_truSoTinhId = truSoTinhId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			YeuCauDangKyDoanhNghiepLocalServiceUtil.addYeuCauDangKyDoanhNghiep(this);
		}
		else {
			YeuCauDangKyDoanhNghiepLocalServiceUtil.updateYeuCauDangKyDoanhNghiep(this);
		}
	}

	@Override
	public YeuCauDangKyDoanhNghiep toEscapedModel() {
		return (YeuCauDangKyDoanhNghiep)Proxy.newProxyInstance(YeuCauDangKyDoanhNghiep.class.getClassLoader(),
			new Class[] { YeuCauDangKyDoanhNghiep.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		YeuCauDangKyDoanhNghiepClp clone = new YeuCauDangKyDoanhNghiepClp();

		clone.setId(getId());
		clone.setLoaiDoiTuongId(getLoaiDoiTuongId());
		clone.setTen(getTen());
		clone.setMaSoThue(getMaSoThue());
		clone.setMaGiayPhep(getMaGiayPhep());
		clone.setNgayCap(getNgayCap());
		clone.setEmail(getEmail());
		clone.setHoNguoiDaiDien(getHoNguoiDaiDien());
		clone.setTenDemNguoiDaiDien(getTenDemNguoiDaiDien());
		clone.setTenNguoiDaiDien(getTenNguoiDaiDien());
		clone.setSoCMND(getSoCMND());
		clone.setNgayCapCMND(getNgayCapCMND());
		clone.setNoiCapCMND(getNoiCapCMND());
		clone.setMoTaNganhNgheKinhDoanh(getMoTaNganhNgheKinhDoanh());
		clone.setLoaiHinhDoanhNghiep(getLoaiHinhDoanhNghiep());
		clone.setTruSo(getTruSo());
		clone.setTruSoXaId(getTruSoXaId());
		clone.setTruSoHuyenId(getTruSoHuyenId());
		clone.setTruSoTinhId(getTruSoTinhId());
		clone.setTrangThai(getTrangThai());

		return clone;
	}

	public int compareTo(YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		long primaryKey = yeuCauDangKyDoanhNghiep.getPrimaryKey();

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

		YeuCauDangKyDoanhNghiepClp yeuCauDangKyDoanhNghiep = null;

		try {
			yeuCauDangKyDoanhNghiep = (YeuCauDangKyDoanhNghiepClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = yeuCauDangKyDoanhNghiep.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", loaiDoiTuongId=");
		sb.append(getLoaiDoiTuongId());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", maSoThue=");
		sb.append(getMaSoThue());
		sb.append(", maGiayPhep=");
		sb.append(getMaGiayPhep());
		sb.append(", ngayCap=");
		sb.append(getNgayCap());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", hoNguoiDaiDien=");
		sb.append(getHoNguoiDaiDien());
		sb.append(", tenDemNguoiDaiDien=");
		sb.append(getTenDemNguoiDaiDien());
		sb.append(", tenNguoiDaiDien=");
		sb.append(getTenNguoiDaiDien());
		sb.append(", soCMND=");
		sb.append(getSoCMND());
		sb.append(", ngayCapCMND=");
		sb.append(getNgayCapCMND());
		sb.append(", noiCapCMND=");
		sb.append(getNoiCapCMND());
		sb.append(", moTaNganhNgheKinhDoanh=");
		sb.append(getMoTaNganhNgheKinhDoanh());
		sb.append(", loaiHinhDoanhNghiep=");
		sb.append(getLoaiHinhDoanhNghiep());
		sb.append(", truSo=");
		sb.append(getTruSo());
		sb.append(", truSoXaId=");
		sb.append(getTruSoXaId());
		sb.append(", truSoHuyenId=");
		sb.append(getTruSoHuyenId());
		sb.append(", truSoTinhId=");
		sb.append(getTruSoTinhId());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiDoiTuongId</column-name><column-value><![CDATA[");
		sb.append(getLoaiDoiTuongId());
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
			"<column><column-name>maGiayPhep</column-name><column-value><![CDATA[");
		sb.append(getMaGiayPhep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCap</column-name><column-value><![CDATA[");
		sb.append(getNgayCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoNguoiDaiDien</column-name><column-value><![CDATA[");
		sb.append(getHoNguoiDaiDien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenDemNguoiDaiDien</column-name><column-value><![CDATA[");
		sb.append(getTenDemNguoiDaiDien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenNguoiDaiDien</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiDaiDien());
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
			"<column><column-name>noiCapCMND</column-name><column-value><![CDATA[");
		sb.append(getNoiCapCMND());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTaNganhNgheKinhDoanh</column-name><column-value><![CDATA[");
		sb.append(getMoTaNganhNgheKinhDoanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiHinhDoanhNghiep</column-name><column-value><![CDATA[");
		sb.append(getLoaiHinhDoanhNghiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSo</column-name><column-value><![CDATA[");
		sb.append(getTruSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSoXaId</column-name><column-value><![CDATA[");
		sb.append(getTruSoXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSoHuyenId</column-name><column-value><![CDATA[");
		sb.append(getTruSoHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSoTinhId</column-name><column-value><![CDATA[");
		sb.append(getTruSoTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _loaiDoiTuongId;
	private String _ten;
	private String _maSoThue;
	private String _maGiayPhep;
	private Date _ngayCap;
	private String _email;
	private String _hoNguoiDaiDien;
	private String _tenDemNguoiDaiDien;
	private String _tenNguoiDaiDien;
	private String _soCMND;
	private Date _ngayCapCMND;
	private String _noiCapCMND;
	private String _moTaNganhNgheKinhDoanh;
	private String _loaiHinhDoanhNghiep;
	private String _truSo;
	private long _truSoXaId;
	private long _truSoHuyenId;
	private long _truSoTinhId;
	private int _trangThai;
}