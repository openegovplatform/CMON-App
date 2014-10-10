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

import org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author NAM
 */
public class HoSoMotCuaClp extends BaseModelImpl<HoSoMotCua>
	implements HoSoMotCua {
	public HoSoMotCuaClp() {
	}

	public Class<?> getModelClass() {
		return HoSoMotCua.class;
	}

	public String getModelClassName() {
		return HoSoMotCua.class.getName();
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

	public Date getNgayChuyen() {
		return _NgayChuyen;
	}

	public void setNgayChuyen(Date NgayChuyen) {
		_NgayChuyen = NgayChuyen;
	}

	public String getMaSoHoSo() {
		return _MaSoHoSo;
	}

	public void setMaSoHoSo(String MaSoHoSo) {
		_MaSoHoSo = MaSoHoSo;
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

	public String getNgayNopHoSo() {
		return _NgayNopHoSo;
	}

	public void setNgayNopHoSo(String NgayNopHoSo) {
		_NgayNopHoSo = NgayNopHoSo;
	}

	public String getNgayHenTra() {
		return _NgayHenTra;
	}

	public void setNgayHenTra(String NgayHenTra) {
		_NgayHenTra = NgayHenTra;
	}

	public String getHoTenNguoiNop() {
		return _HoTenNguoiNop;
	}

	public void setHoTenNguoiNop(String HoTenNguoiNop) {
		_HoTenNguoiNop = HoTenNguoiNop;
	}

	public String getSoCmnd() {
		return _SoCmnd;
	}

	public void setSoCmnd(String SoCmnd) {
		_SoCmnd = SoCmnd;
	}

	public String getNgaySinh() {
		return _NgaySinh;
	}

	public void setNgaySinh(String NgaySinh) {
		_NgaySinh = NgaySinh;
	}

	public String getMaTinhThuongTru() {
		return _MaTinhThuongTru;
	}

	public void setMaTinhThuongTru(String MaTinhThuongTru) {
		_MaTinhThuongTru = MaTinhThuongTru;
	}

	public String getMoTaDiaChiThuongTru() {
		return _MoTaDiaChiThuongTru;
	}

	public void setMoTaDiaChiThuongTru(String MoTaDiaChiThuongTru) {
		_MoTaDiaChiThuongTru = MoTaDiaChiThuongTru;
	}

	public int getGioiTinh() {
		return _GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		_GioiTinh = GioiTinh;
	}

	public String getMaNguoiTiepNhan() {
		return _MaNguoiTiepNhan;
	}

	public void setMaNguoiTiepNhan(String MaNguoiTiepNhan) {
		_MaNguoiTiepNhan = MaNguoiTiepNhan;
	}

	public String getTenNguoiTiepNhan() {
		return _TenNguoiTiepNhan;
	}

	public void setTenNguoiTiepNhan(String TenNguoiTiepNhan) {
		_TenNguoiTiepNhan = TenNguoiTiepNhan;
	}

	public String getDonViCungCap() {
		return _DonViCungCap;
	}

	public void setDonViCungCap(String DonViCungCap) {
		_DonViCungCap = DonViCungCap;
	}

	public int getTrangThaiXuLy() {
		return _TrangThaiXuLy;
	}

	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_TrangThaiXuLy = TrangThaiXuLy;
	}

	public Date getNgayXuLy() {
		return _NgayXuLy;
	}

	public void setNgayXuLy(Date NgayXuLy) {
		_NgayXuLy = NgayXuLy;
	}

	public String getLoiKhiXuLy() {
		return _LoiKhiXuLy;
	}

	public void setLoiKhiXuLy(String LoiKhiXuLy) {
		_LoiKhiXuLy = LoiKhiXuLy;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoSoMotCuaLocalServiceUtil.addHoSoMotCua(this);
		}
		else {
			HoSoMotCuaLocalServiceUtil.updateHoSoMotCua(this);
		}
	}

	@Override
	public HoSoMotCua toEscapedModel() {
		return (HoSoMotCua)Proxy.newProxyInstance(HoSoMotCua.class.getClassLoader(),
			new Class[] { HoSoMotCua.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoSoMotCuaClp clone = new HoSoMotCuaClp();

		clone.setId(getId());
		clone.setNgayChuyen(getNgayChuyen());
		clone.setMaSoHoSo(getMaSoHoSo());
		clone.setMaLoaiHoSo(getMaLoaiHoSo());
		clone.setMaDonViTiepNhan(getMaDonViTiepNhan());
		clone.setNgayNopHoSo(getNgayNopHoSo());
		clone.setNgayHenTra(getNgayHenTra());
		clone.setHoTenNguoiNop(getHoTenNguoiNop());
		clone.setSoCmnd(getSoCmnd());
		clone.setNgaySinh(getNgaySinh());
		clone.setMaTinhThuongTru(getMaTinhThuongTru());
		clone.setMoTaDiaChiThuongTru(getMoTaDiaChiThuongTru());
		clone.setGioiTinh(getGioiTinh());
		clone.setMaNguoiTiepNhan(getMaNguoiTiepNhan());
		clone.setTenNguoiTiepNhan(getTenNguoiTiepNhan());
		clone.setDonViCungCap(getDonViCungCap());
		clone.setTrangThaiXuLy(getTrangThaiXuLy());
		clone.setNgayXuLy(getNgayXuLy());
		clone.setLoiKhiXuLy(getLoiKhiXuLy());

		return clone;
	}

	public int compareTo(HoSoMotCua hoSoMotCua) {
		int value = 0;

		if (getId() < hoSoMotCua.getId()) {
			value = -1;
		}
		else if (getId() > hoSoMotCua.getId()) {
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

		HoSoMotCuaClp hoSoMotCua = null;

		try {
			hoSoMotCua = (HoSoMotCuaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoMotCua.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", NgayChuyen=");
		sb.append(getNgayChuyen());
		sb.append(", MaSoHoSo=");
		sb.append(getMaSoHoSo());
		sb.append(", MaLoaiHoSo=");
		sb.append(getMaLoaiHoSo());
		sb.append(", MaDonViTiepNhan=");
		sb.append(getMaDonViTiepNhan());
		sb.append(", NgayNopHoSo=");
		sb.append(getNgayNopHoSo());
		sb.append(", NgayHenTra=");
		sb.append(getNgayHenTra());
		sb.append(", HoTenNguoiNop=");
		sb.append(getHoTenNguoiNop());
		sb.append(", SoCmnd=");
		sb.append(getSoCmnd());
		sb.append(", NgaySinh=");
		sb.append(getNgaySinh());
		sb.append(", MaTinhThuongTru=");
		sb.append(getMaTinhThuongTru());
		sb.append(", MoTaDiaChiThuongTru=");
		sb.append(getMoTaDiaChiThuongTru());
		sb.append(", GioiTinh=");
		sb.append(getGioiTinh());
		sb.append(", MaNguoiTiepNhan=");
		sb.append(getMaNguoiTiepNhan());
		sb.append(", TenNguoiTiepNhan=");
		sb.append(getTenNguoiTiepNhan());
		sb.append(", DonViCungCap=");
		sb.append(getDonViCungCap());
		sb.append(", TrangThaiXuLy=");
		sb.append(getTrangThaiXuLy());
		sb.append(", NgayXuLy=");
		sb.append(getNgayXuLy());
		sb.append(", LoiKhiXuLy=");
		sb.append(getLoiKhiXuLy());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.oep.exch.dao.hoso.model.HoSoMotCua");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayChuyen</column-name><column-value><![CDATA[");
		sb.append(getNgayChuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaSoHoSo</column-name><column-value><![CDATA[");
		sb.append(getMaSoHoSo());
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
			"<column><column-name>NgayNopHoSo</column-name><column-value><![CDATA[");
		sb.append(getNgayNopHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayHenTra</column-name><column-value><![CDATA[");
		sb.append(getNgayHenTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoTenNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getHoTenNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoCmnd</column-name><column-value><![CDATA[");
		sb.append(getSoCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgaySinh</column-name><column-value><![CDATA[");
		sb.append(getNgaySinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaTinhThuongTru</column-name><column-value><![CDATA[");
		sb.append(getMaTinhThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MoTaDiaChiThuongTru</column-name><column-value><![CDATA[");
		sb.append(getMoTaDiaChiThuongTru());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GioiTinh</column-name><column-value><![CDATA[");
		sb.append(getGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaNguoiTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getMaNguoiTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenNguoiTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DonViCungCap</column-name><column-value><![CDATA[");
		sb.append(getDonViCungCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThaiXuLy</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayXuLy</column-name><column-value><![CDATA[");
		sb.append(getNgayXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LoiKhiXuLy</column-name><column-value><![CDATA[");
		sb.append(getLoiKhiXuLy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _NgayChuyen;
	private String _MaSoHoSo;
	private String _MaLoaiHoSo;
	private String _MaDonViTiepNhan;
	private String _NgayNopHoSo;
	private String _NgayHenTra;
	private String _HoTenNguoiNop;
	private String _SoCmnd;
	private String _NgaySinh;
	private String _MaTinhThuongTru;
	private String _MoTaDiaChiThuongTru;
	private int _GioiTinh;
	private String _MaNguoiTiepNhan;
	private String _TenNguoiTiepNhan;
	private String _DonViCungCap;
	private int _TrangThaiXuLy;
	private Date _NgayXuLy;
	private String _LoiKhiXuLy;
}