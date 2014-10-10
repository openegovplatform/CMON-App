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

import org.oep.cmon.dao.dn.service.YeuCauDangKyDNLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class YeuCauDangKyDNClp extends BaseModelImpl<YeuCauDangKyDN>
	implements YeuCauDangKyDN {
	public YeuCauDangKyDNClp() {
	}

	public Class<?> getModelClass() {
		return YeuCauDangKyDN.class;
	}

	public String getModelClassName() {
		return YeuCauDangKyDN.class.getName();
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

	public Long getNoiCapCmndId() {
		return _noiCapCmndId;
	}

	public void setNoiCapCmndId(Long noiCapCmndId) {
		_noiCapCmndId = noiCapCmndId;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public Long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(Long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public Long getTruSoTinhId() {
		return _truSoTinhId;
	}

	public void setTruSoTinhId(Long truSoTinhId) {
		_truSoTinhId = truSoTinhId;
	}

	public Long getTruSoHuyenId() {
		return _truSoHuyenId;
	}

	public void setTruSoHuyenId(Long truSoHuyenId) {
		_truSoHuyenId = truSoHuyenId;
	}

	public Long getTruSoXaId() {
		return _truSoXaId;
	}

	public void setTruSoXaId(Long truSoXaId) {
		_truSoXaId = truSoXaId;
	}

	public String getTruSo() {
		return _truSo;
	}

	public void setTruSo(String truSo) {
		_truSo = truSo;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getLoaiHinhDoanhNghiepId() {
		return _loaiHinhDoanhNghiepId;
	}

	public void setLoaiHinhDoanhNghiepId(Long loaiHinhDoanhNghiepId) {
		_loaiHinhDoanhNghiepId = loaiHinhDoanhNghiepId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			YeuCauDangKyDNLocalServiceUtil.addYeuCauDangKyDN(this);
		}
		else {
			YeuCauDangKyDNLocalServiceUtil.updateYeuCauDangKyDN(this);
		}
	}

	@Override
	public YeuCauDangKyDN toEscapedModel() {
		return (YeuCauDangKyDN)Proxy.newProxyInstance(YeuCauDangKyDN.class.getClassLoader(),
			new Class[] { YeuCauDangKyDN.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		YeuCauDangKyDNClp clone = new YeuCauDangKyDNClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setMaSoThue(getMaSoThue());
		clone.setMaGiayPhep(getMaGiayPhep());
		clone.setNgayCap(getNgayCap());
		clone.setEmail(getEmail());
		clone.setHoNguoiDaiDien(getHoNguoiDaiDien());
		clone.setTenDemNguoiDaiDien(getTenDemNguoiDaiDien());
		clone.setTenNguoiDaiDien(getTenNguoiDaiDien());
		clone.setSoCmnd(getSoCmnd());
		clone.setNgayCapCmnd(getNgayCapCmnd());
		clone.setNoiCapCmndId(getNoiCapCmndId());
		clone.setMoTa(getMoTa());
		clone.setLoaiDoiTuongId(getLoaiDoiTuongId());
		clone.setTruSoTinhId(getTruSoTinhId());
		clone.setTruSoHuyenId(getTruSoHuyenId());
		clone.setTruSoXaId(getTruSoXaId());
		clone.setTruSo(getTruSo());
		clone.setDaXoa(getDaXoa());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setTrangThai(getTrangThai());
		clone.setLoaiHinhDoanhNghiepId(getLoaiHinhDoanhNghiepId());

		return clone;
	}

	public int compareTo(YeuCauDangKyDN yeuCauDangKyDN) {
		long primaryKey = yeuCauDangKyDN.getPrimaryKey();

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

		YeuCauDangKyDNClp yeuCauDangKyDN = null;

		try {
			yeuCauDangKyDN = (YeuCauDangKyDNClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = yeuCauDangKyDN.getPrimaryKey();

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
		StringBundler sb = new StringBundler(51);

		sb.append("{id=");
		sb.append(getId());
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
		sb.append(", soCmnd=");
		sb.append(getSoCmnd());
		sb.append(", ngayCapCmnd=");
		sb.append(getNgayCapCmnd());
		sb.append(", noiCapCmndId=");
		sb.append(getNoiCapCmndId());
		sb.append(", moTa=");
		sb.append(getMoTa());
		sb.append(", loaiDoiTuongId=");
		sb.append(getLoaiDoiTuongId());
		sb.append(", truSoTinhId=");
		sb.append(getTruSoTinhId());
		sb.append(", truSoHuyenId=");
		sb.append(getTruSoHuyenId());
		sb.append(", truSoXaId=");
		sb.append(getTruSoXaId());
		sb.append(", truSo=");
		sb.append(getTruSo());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", loaiHinhDoanhNghiepId=");
		sb.append(getLoaiHinhDoanhNghiepId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dn.model.YeuCauDangKyDN");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
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
			"<column><column-name>soCmnd</column-name><column-value><![CDATA[");
		sb.append(getSoCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapCmnd</column-name><column-value><![CDATA[");
		sb.append(getNgayCapCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapCmndId</column-name><column-value><![CDATA[");
		sb.append(getNoiCapCmndId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTa</column-name><column-value><![CDATA[");
		sb.append(getMoTa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiDoiTuongId</column-name><column-value><![CDATA[");
		sb.append(getLoaiDoiTuongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSoTinhId</column-name><column-value><![CDATA[");
		sb.append(getTruSoTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSoHuyenId</column-name><column-value><![CDATA[");
		sb.append(getTruSoHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSoXaId</column-name><column-value><![CDATA[");
		sb.append(getTruSoXaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truSo</column-name><column-value><![CDATA[");
		sb.append(getTruSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiHinhDoanhNghiepId</column-name><column-value><![CDATA[");
		sb.append(getLoaiHinhDoanhNghiepId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private String _maSoThue;
	private String _maGiayPhep;
	private Date _ngayCap;
	private String _email;
	private String _hoNguoiDaiDien;
	private String _tenDemNguoiDaiDien;
	private String _tenNguoiDaiDien;
	private String _soCmnd;
	private Date _ngayCapCmnd;
	private Long _noiCapCmndId;
	private String _moTa;
	private Long _loaiDoiTuongId;
	private Long _truSoTinhId;
	private Long _truSoHuyenId;
	private Long _truSoXaId;
	private String _truSo;
	private int _daXoa;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _trangThai;
	private Long _loaiHinhDoanhNghiepId;
}