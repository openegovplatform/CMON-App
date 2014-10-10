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

package org.oep.exch.dao.hoso.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author NAM
 */
public class HoSoTrucTuyenClp extends BaseModelImpl<HoSoTrucTuyen>
	implements HoSoTrucTuyen {
	public HoSoTrucTuyenClp() {
	}

	public Class<?> getModelClass() {
		return HoSoTrucTuyen.class;
	}

	public String getModelClassName() {
		return HoSoTrucTuyen.class.getName();
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

	public Date getNgayTrichXuat() {
		return _NgayTrichXuat;
	}

	public void setNgayTrichXuat(Date NgayTrichXuat) {
		_NgayTrichXuat = NgayTrichXuat;
	}

	public long getOnlineId() {
		return _OnlineId;
	}

	public void setOnlineId(long OnlineId) {
		_OnlineId = OnlineId;
	}

	public String getMaLoaiHoSo() {
		return _MaLoaiHoSo;
	}

	public void setMaLoaiHoSo(String MaLoaiHoSo) {
		_MaLoaiHoSo = MaLoaiHoSo;
	}

	public String getMaDonViTiepNhan() {
		return _MaDonViTiepNhan;
	}

	public void setMaDonViTiepNhan(String MaDonViTiepNhan) {
		_MaDonViTiepNhan = MaDonViTiepNhan;
	}

	public String getHoTenNguoiNop() {
		return _HoTenNguoiNop;
	}

	public void setHoTenNguoiNop(String HoTenNguoiNop) {
		_HoTenNguoiNop = HoTenNguoiNop;
	}

	public String getDiaChiNguoiNop() {
		return _DiaChiNguoiNop;
	}

	public void setDiaChiNguoiNop(String DiaChiNguoiNop) {
		_DiaChiNguoiNop = DiaChiNguoiNop;
	}

	public Date getNgaySinh() {
		return _NgaySinh;
	}

	public void setNgaySinh(Date NgaySinh) {
		_NgaySinh = NgaySinh;
	}

	public String getSoCmnd() {
		return _SoCmnd;
	}

	public void setSoCmnd(String SoCmnd) {
		_SoCmnd = SoCmnd;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getSoDtDiDong() {
		return _SoDtDiDong;
	}

	public void setSoDtDiDong(String SoDtDiDong) {
		_SoDtDiDong = SoDtDiDong;
	}

	public String getSoDtCoDinh() {
		return _SoDtCoDinh;
	}

	public void setSoDtCoDinh(String SoDtCoDinh) {
		_SoDtCoDinh = SoDtCoDinh;
	}

	public Date getNgayDangKyHoSo() {
		return _NgayDangKyHoSo;
	}

	public void setNgayDangKyHoSo(Date NgayDangKyHoSo) {
		_NgayDangKyHoSo = NgayDangKyHoSo;
	}

	public String getNoiChuyenHoSo() {
		return _NoiChuyenHoSo;
	}

	public void setNoiChuyenHoSo(String NoiChuyenHoSo) {
		_NoiChuyenHoSo = NoiChuyenHoSo;
	}

	public int getTrangThaiXuLy() {
		return _TrangThaiXuLy;
	}

	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_TrangThaiXuLy = TrangThaiXuLy;
	}

	public Date getNgayChuyen() {
		return _NgayChuyen;
	}

	public void setNgayChuyen(Date NgayChuyen) {
		_NgayChuyen = NgayChuyen;
	}

	public int getGioiTinh() {
		return _GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		_GioiTinh = GioiTinh;
	}

	public String getChuSoHuuHoSo() {
		return _ChuSoHuuHoSo;
	}

	public void setChuSoHuuHoSo(String ChuSoHuuHoSo) {
		_ChuSoHuuHoSo = ChuSoHuuHoSo;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoSoTrucTuyenLocalServiceUtil.addHoSoTrucTuyen(this);
		}
		else {
			HoSoTrucTuyenLocalServiceUtil.updateHoSoTrucTuyen(this);
		}
	}

	@Override
	public HoSoTrucTuyen toEscapedModel() {
		return (HoSoTrucTuyen)Proxy.newProxyInstance(HoSoTrucTuyen.class.getClassLoader(),
			new Class[] { HoSoTrucTuyen.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoSoTrucTuyenClp clone = new HoSoTrucTuyenClp();

		clone.setId(getId());
		clone.setNgayTrichXuat(getNgayTrichXuat());
		clone.setOnlineId(getOnlineId());
		clone.setMaLoaiHoSo(getMaLoaiHoSo());
		clone.setMaDonViTiepNhan(getMaDonViTiepNhan());
		clone.setHoTenNguoiNop(getHoTenNguoiNop());
		clone.setDiaChiNguoiNop(getDiaChiNguoiNop());
		clone.setNgaySinh(getNgaySinh());
		clone.setSoCmnd(getSoCmnd());
		clone.setEmail(getEmail());
		clone.setSoDtDiDong(getSoDtDiDong());
		clone.setSoDtCoDinh(getSoDtCoDinh());
		clone.setNgayDangKyHoSo(getNgayDangKyHoSo());
		clone.setNoiChuyenHoSo(getNoiChuyenHoSo());
		clone.setTrangThaiXuLy(getTrangThaiXuLy());
		clone.setNgayChuyen(getNgayChuyen());
		clone.setGioiTinh(getGioiTinh());
		clone.setChuSoHuuHoSo(getChuSoHuuHoSo());

		return clone;
	}

	public int compareTo(HoSoTrucTuyen hoSoTrucTuyen) {
		int value = 0;

		if (getId() < hoSoTrucTuyen.getId()) {
			value = -1;
		}
		else if (getId() > hoSoTrucTuyen.getId()) {
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

		HoSoTrucTuyenClp hoSoTrucTuyen = null;

		try {
			hoSoTrucTuyen = (HoSoTrucTuyenClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoTrucTuyen.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", NgayTrichXuat=");
		sb.append(getNgayTrichXuat());
		sb.append(", OnlineId=");
		sb.append(getOnlineId());
		sb.append(", MaLoaiHoSo=");
		sb.append(getMaLoaiHoSo());
		sb.append(", MaDonViTiepNhan=");
		sb.append(getMaDonViTiepNhan());
		sb.append(", HoTenNguoiNop=");
		sb.append(getHoTenNguoiNop());
		sb.append(", DiaChiNguoiNop=");
		sb.append(getDiaChiNguoiNop());
		sb.append(", NgaySinh=");
		sb.append(getNgaySinh());
		sb.append(", SoCmnd=");
		sb.append(getSoCmnd());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", SoDtDiDong=");
		sb.append(getSoDtDiDong());
		sb.append(", SoDtCoDinh=");
		sb.append(getSoDtCoDinh());
		sb.append(", NgayDangKyHoSo=");
		sb.append(getNgayDangKyHoSo());
		sb.append(", NoiChuyenHoSo=");
		sb.append(getNoiChuyenHoSo());
		sb.append(", TrangThaiXuLy=");
		sb.append(getTrangThaiXuLy());
		sb.append(", NgayChuyen=");
		sb.append(getNgayChuyen());
		sb.append(", GioiTinh=");
		sb.append(getGioiTinh());
		sb.append(", ChuSoHuuHoSo=");
		sb.append(getChuSoHuuHoSo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.oep.exch.dao.hoso.model.HoSoTrucTuyen");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayTrichXuat</column-name><column-value><![CDATA[");
		sb.append(getNgayTrichXuat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>OnlineId</column-name><column-value><![CDATA[");
		sb.append(getOnlineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaLoaiHoSo</column-name><column-value><![CDATA[");
		sb.append(getMaLoaiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaDonViTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getMaDonViTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoTenNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getHoTenNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DiaChiNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getDiaChiNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgaySinh</column-name><column-value><![CDATA[");
		sb.append(getNgaySinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoCmnd</column-name><column-value><![CDATA[");
		sb.append(getSoCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoDtDiDong</column-name><column-value><![CDATA[");
		sb.append(getSoDtDiDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoDtCoDinh</column-name><column-value><![CDATA[");
		sb.append(getSoDtCoDinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayDangKyHoSo</column-name><column-value><![CDATA[");
		sb.append(getNgayDangKyHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NoiChuyenHoSo</column-name><column-value><![CDATA[");
		sb.append(getNoiChuyenHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThaiXuLy</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayChuyen</column-name><column-value><![CDATA[");
		sb.append(getNgayChuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GioiTinh</column-name><column-value><![CDATA[");
		sb.append(getGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ChuSoHuuHoSo</column-name><column-value><![CDATA[");
		sb.append(getChuSoHuuHoSo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _NgayTrichXuat;
	private long _OnlineId;
	private String _MaLoaiHoSo;
	private String _MaDonViTiepNhan;
	private String _HoTenNguoiNop;
	private String _DiaChiNguoiNop;
	private Date _NgaySinh;
	private String _SoCmnd;
	private String _Email;
	private String _SoDtDiDong;
	private String _SoDtCoDinh;
	private Date _NgayDangKyHoSo;
	private String _NoiChuyenHoSo;
	private int _TrangThaiXuLy;
	private Date _NgayChuyen;
	private int _GioiTinh;
	private String _ChuSoHuuHoSo;
}