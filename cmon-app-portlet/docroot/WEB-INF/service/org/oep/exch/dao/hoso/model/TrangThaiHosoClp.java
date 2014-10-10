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

import org.oep.exch.dao.hoso.service.TrangThaiHosoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author NAM
 */
public class TrangThaiHosoClp extends BaseModelImpl<TrangThaiHoso>
	implements TrangThaiHoso {
	public TrangThaiHosoClp() {
	}

	public Class<?> getModelClass() {
		return TrangThaiHoso.class;
	}

	public String getModelClassName() {
		return TrangThaiHoso.class.getName();
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

	public long getOnlineId() {
		return _OnlineId;
	}

	public void setOnlineId(long OnlineId) {
		_OnlineId = OnlineId;
	}

	public String getMaSoHoSo() {
		return _MaSoHoSo;
	}

	public void setMaSoHoSo(String MaSoHoSo) {
		_MaSoHoSo = MaSoHoSo;
	}

	public String getNgayHenTra() {
		return _NgayHenTra;
	}

	public void setNgayHenTra(String NgayHenTra) {
		_NgayHenTra = NgayHenTra;
	}

	public String getMaNguoiXuLyHienTai() {
		return _MaNguoiXuLyHienTai;
	}

	public void setMaNguoiXuLyHienTai(String MaNguoiXuLyHienTai) {
		_MaNguoiXuLyHienTai = MaNguoiXuLyHienTai;
	}

	public String getTenNguoiXuLyHienTai() {
		return _TenNguoiXuLyHienTai;
	}

	public void setTenNguoiXuLyHienTai(String TenNguoiXuLyHienTai) {
		_TenNguoiXuLyHienTai = TenNguoiXuLyHienTai;
	}

	public String getTenPhongBanXuLyHienTai() {
		return _TenPhongBanXuLyHienTai;
	}

	public void setTenPhongBanXuLyHienTai(String TenPhongBanXuLyHienTai) {
		_TenPhongBanXuLyHienTai = TenPhongBanXuLyHienTai;
	}

	public String getNgayGioLuanChuyen() {
		return _NgayGioLuanChuyen;
	}

	public void setNgayGioLuanChuyen(String NgayGioLuanChuyen) {
		_NgayGioLuanChuyen = NgayGioLuanChuyen;
	}

	public int getSoGioYeuCauXuLy() {
		return _SoGioYeuCauXuLy;
	}

	public void setSoGioYeuCauXuLy(int SoGioYeuCauXuLy) {
		_SoGioYeuCauXuLy = SoGioYeuCauXuLy;
	}

	public String getNoiDungYeuCauXuLy() {
		return _NoiDungYeuCauXuLy;
	}

	public void setNoiDungYeuCauXuLy(String NoiDungYeuCauXuLy) {
		_NoiDungYeuCauXuLy = NoiDungYeuCauXuLy;
	}

	public int getSoGioThucHien() {
		return _SoGioThucHien;
	}

	public void setSoGioThucHien(int SoGioThucHien) {
		_SoGioThucHien = SoGioThucHien;
	}

	public int getTrangThaiHienTai() {
		return _TrangThaiHienTai;
	}

	public void setTrangThaiHienTai(int TrangThaiHienTai) {
		_TrangThaiHienTai = TrangThaiHienTai;
	}

	public String getMaNguoiXuLyKeTiep() {
		return _MaNguoiXuLyKeTiep;
	}

	public void setMaNguoiXuLyKeTiep(String MaNguoiXuLyKeTiep) {
		_MaNguoiXuLyKeTiep = MaNguoiXuLyKeTiep;
	}

	public String getTenNguoiXuLyKeTiep() {
		return _TenNguoiXuLyKeTiep;
	}

	public void setTenNguoiXuLyKeTiep(String TenNguoiXuLyKeTiep) {
		_TenNguoiXuLyKeTiep = TenNguoiXuLyKeTiep;
	}

	public String getTenPhongBanXuLyKeTiep() {
		return _TenPhongBanXuLyKeTiep;
	}

	public void setTenPhongBanXuLyKeTiep(String TenPhongBanXuLyKeTiep) {
		_TenPhongBanXuLyKeTiep = TenPhongBanXuLyKeTiep;
	}

	public int getTrangThaiKeTiep() {
		return _TrangThaiKeTiep;
	}

	public void setTrangThaiKeTiep(int TrangThaiKeTiep) {
		_TrangThaiKeTiep = TrangThaiKeTiep;
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
			TrangThaiHosoLocalServiceUtil.addTrangThaiHoso(this);
		}
		else {
			TrangThaiHosoLocalServiceUtil.updateTrangThaiHoso(this);
		}
	}

	@Override
	public TrangThaiHoso toEscapedModel() {
		return (TrangThaiHoso)Proxy.newProxyInstance(TrangThaiHoso.class.getClassLoader(),
			new Class[] { TrangThaiHoso.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TrangThaiHosoClp clone = new TrangThaiHosoClp();

		clone.setId(getId());
		clone.setNgayChuyen(getNgayChuyen());
		clone.setOnlineId(getOnlineId());
		clone.setMaSoHoSo(getMaSoHoSo());
		clone.setNgayHenTra(getNgayHenTra());
		clone.setMaNguoiXuLyHienTai(getMaNguoiXuLyHienTai());
		clone.setTenNguoiXuLyHienTai(getTenNguoiXuLyHienTai());
		clone.setTenPhongBanXuLyHienTai(getTenPhongBanXuLyHienTai());
		clone.setNgayGioLuanChuyen(getNgayGioLuanChuyen());
		clone.setSoGioYeuCauXuLy(getSoGioYeuCauXuLy());
		clone.setNoiDungYeuCauXuLy(getNoiDungYeuCauXuLy());
		clone.setSoGioThucHien(getSoGioThucHien());
		clone.setTrangThaiHienTai(getTrangThaiHienTai());
		clone.setMaNguoiXuLyKeTiep(getMaNguoiXuLyKeTiep());
		clone.setTenNguoiXuLyKeTiep(getTenNguoiXuLyKeTiep());
		clone.setTenPhongBanXuLyKeTiep(getTenPhongBanXuLyKeTiep());
		clone.setTrangThaiKeTiep(getTrangThaiKeTiep());
		clone.setDonViCungCap(getDonViCungCap());
		clone.setTrangThaiXuLy(getTrangThaiXuLy());
		clone.setNgayXuLy(getNgayXuLy());
		clone.setLoiKhiXuLy(getLoiKhiXuLy());

		return clone;
	}

	public int compareTo(TrangThaiHoso trangThaiHoso) {
		int value = 0;

		if (getId() < trangThaiHoso.getId()) {
			value = -1;
		}
		else if (getId() > trangThaiHoso.getId()) {
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

		TrangThaiHosoClp trangThaiHoso = null;

		try {
			trangThaiHoso = (TrangThaiHosoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = trangThaiHoso.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", NgayChuyen=");
		sb.append(getNgayChuyen());
		sb.append(", OnlineId=");
		sb.append(getOnlineId());
		sb.append(", MaSoHoSo=");
		sb.append(getMaSoHoSo());
		sb.append(", NgayHenTra=");
		sb.append(getNgayHenTra());
		sb.append(", MaNguoiXuLyHienTai=");
		sb.append(getMaNguoiXuLyHienTai());
		sb.append(", TenNguoiXuLyHienTai=");
		sb.append(getTenNguoiXuLyHienTai());
		sb.append(", TenPhongBanXuLyHienTai=");
		sb.append(getTenPhongBanXuLyHienTai());
		sb.append(", NgayGioLuanChuyen=");
		sb.append(getNgayGioLuanChuyen());
		sb.append(", SoGioYeuCauXuLy=");
		sb.append(getSoGioYeuCauXuLy());
		sb.append(", NoiDungYeuCauXuLy=");
		sb.append(getNoiDungYeuCauXuLy());
		sb.append(", SoGioThucHien=");
		sb.append(getSoGioThucHien());
		sb.append(", TrangThaiHienTai=");
		sb.append(getTrangThaiHienTai());
		sb.append(", MaNguoiXuLyKeTiep=");
		sb.append(getMaNguoiXuLyKeTiep());
		sb.append(", TenNguoiXuLyKeTiep=");
		sb.append(getTenNguoiXuLyKeTiep());
		sb.append(", TenPhongBanXuLyKeTiep=");
		sb.append(getTenPhongBanXuLyKeTiep());
		sb.append(", TrangThaiKeTiep=");
		sb.append(getTrangThaiKeTiep());
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
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("org.oep.exch.dao.hoso.model.TrangThaiHoso");
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
			"<column><column-name>OnlineId</column-name><column-value><![CDATA[");
		sb.append(getOnlineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaSoHoSo</column-name><column-value><![CDATA[");
		sb.append(getMaSoHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayHenTra</column-name><column-value><![CDATA[");
		sb.append(getNgayHenTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaNguoiXuLyHienTai</column-name><column-value><![CDATA[");
		sb.append(getMaNguoiXuLyHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenNguoiXuLyHienTai</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiXuLyHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenPhongBanXuLyHienTai</column-name><column-value><![CDATA[");
		sb.append(getTenPhongBanXuLyHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayGioLuanChuyen</column-name><column-value><![CDATA[");
		sb.append(getNgayGioLuanChuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoGioYeuCauXuLy</column-name><column-value><![CDATA[");
		sb.append(getSoGioYeuCauXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NoiDungYeuCauXuLy</column-name><column-value><![CDATA[");
		sb.append(getNoiDungYeuCauXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoGioThucHien</column-name><column-value><![CDATA[");
		sb.append(getSoGioThucHien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThaiHienTai</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiHienTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaNguoiXuLyKeTiep</column-name><column-value><![CDATA[");
		sb.append(getMaNguoiXuLyKeTiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenNguoiXuLyKeTiep</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiXuLyKeTiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenPhongBanXuLyKeTiep</column-name><column-value><![CDATA[");
		sb.append(getTenPhongBanXuLyKeTiep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThaiKeTiep</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiKeTiep());
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
	private long _OnlineId;
	private String _MaSoHoSo;
	private String _NgayHenTra;
	private String _MaNguoiXuLyHienTai;
	private String _TenNguoiXuLyHienTai;
	private String _TenPhongBanXuLyHienTai;
	private String _NgayGioLuanChuyen;
	private int _SoGioYeuCauXuLy;
	private String _NoiDungYeuCauXuLy;
	private int _SoGioThucHien;
	private int _TrangThaiHienTai;
	private String _MaNguoiXuLyKeTiep;
	private String _TenNguoiXuLyKeTiep;
	private String _TenPhongBanXuLyKeTiep;
	private int _TrangThaiKeTiep;
	private String _DonViCungCap;
	private int _TrangThaiXuLy;
	private Date _NgayXuLy;
	private String _LoiKhiXuLy;
}