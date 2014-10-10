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

import org.oep.exch.dao.hoso.service.KetQuaHosoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author NAM
 */
public class KetQuaHosoClp extends BaseModelImpl<KetQuaHoso>
	implements KetQuaHoso {
	public KetQuaHosoClp() {
	}

	public Class<?> getModelClass() {
		return KetQuaHoso.class;
	}

	public String getModelClassName() {
		return KetQuaHoso.class.getName();
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

	public String getTenNguoiNhanKetQua() {
		return _TenNguoiNhanKetQua;
	}

	public void setTenNguoiNhanKetQua(String TenNguoiNhanKetQua) {
		_TenNguoiNhanKetQua = TenNguoiNhanKetQua;
	}

	public String getNgayNhanKetQua() {
		return _NgayNhanKetQua;
	}

	public void setNgayNhanKetQua(String NgayNhanKetQua) {
		_NgayNhanKetQua = NgayNhanKetQua;
	}

	public int getLePhiHoSo() {
		return _LePhiHoSo;
	}

	public void setLePhiHoSo(int LePhiHoSo) {
		_LePhiHoSo = LePhiHoSo;
	}

	public int getPhiXuLyHoSo() {
		return _PhiXuLyHoSo;
	}

	public void setPhiXuLyHoSo(int PhiXuLyHoSo) {
		_PhiXuLyHoSo = PhiXuLyHoSo;
	}

	public String getNgayHoanThanh() {
		return _NgayHoanThanh;
	}

	public void setNgayHoanThanh(String NgayHoanThanh) {
		_NgayHoanThanh = NgayHoanThanh;
	}

	public String getMaCanBoTraKetQua() {
		return _MaCanBoTraKetQua;
	}

	public void setMaCanBoTraKetQua(String MaCanBoTraKetQua) {
		_MaCanBoTraKetQua = MaCanBoTraKetQua;
	}

	public String getTenCanBoTraKetQua() {
		return _TenCanBoTraKetQua;
	}

	public void setTenCanBoTraKetQua(String TenCanBoTraKetQua) {
		_TenCanBoTraKetQua = TenCanBoTraKetQua;
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
			KetQuaHosoLocalServiceUtil.addKetQuaHoso(this);
		}
		else {
			KetQuaHosoLocalServiceUtil.updateKetQuaHoso(this);
		}
	}

	@Override
	public KetQuaHoso toEscapedModel() {
		return (KetQuaHoso)Proxy.newProxyInstance(KetQuaHoso.class.getClassLoader(),
			new Class[] { KetQuaHoso.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KetQuaHosoClp clone = new KetQuaHosoClp();

		clone.setId(getId());
		clone.setNgayChuyen(getNgayChuyen());
		clone.setMaSoHoSo(getMaSoHoSo());
		clone.setTenNguoiNhanKetQua(getTenNguoiNhanKetQua());
		clone.setNgayNhanKetQua(getNgayNhanKetQua());
		clone.setLePhiHoSo(getLePhiHoSo());
		clone.setPhiXuLyHoSo(getPhiXuLyHoSo());
		clone.setNgayHoanThanh(getNgayHoanThanh());
		clone.setMaCanBoTraKetQua(getMaCanBoTraKetQua());
		clone.setTenCanBoTraKetQua(getTenCanBoTraKetQua());
		clone.setDonViCungCap(getDonViCungCap());
		clone.setTrangThaiXuLy(getTrangThaiXuLy());
		clone.setNgayXuLy(getNgayXuLy());
		clone.setLoiKhiXuLy(getLoiKhiXuLy());

		return clone;
	}

	public int compareTo(KetQuaHoso ketQuaHoso) {
		int value = 0;

		if (getId() < ketQuaHoso.getId()) {
			value = -1;
		}
		else if (getId() > ketQuaHoso.getId()) {
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

		KetQuaHosoClp ketQuaHoso = null;

		try {
			ketQuaHoso = (KetQuaHosoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ketQuaHoso.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", NgayChuyen=");
		sb.append(getNgayChuyen());
		sb.append(", MaSoHoSo=");
		sb.append(getMaSoHoSo());
		sb.append(", TenNguoiNhanKetQua=");
		sb.append(getTenNguoiNhanKetQua());
		sb.append(", NgayNhanKetQua=");
		sb.append(getNgayNhanKetQua());
		sb.append(", LePhiHoSo=");
		sb.append(getLePhiHoSo());
		sb.append(", PhiXuLyHoSo=");
		sb.append(getPhiXuLyHoSo());
		sb.append(", NgayHoanThanh=");
		sb.append(getNgayHoanThanh());
		sb.append(", MaCanBoTraKetQua=");
		sb.append(getMaCanBoTraKetQua());
		sb.append(", TenCanBoTraKetQua=");
		sb.append(getTenCanBoTraKetQua());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("org.oep.exch.dao.hoso.model.KetQuaHoso");
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
			"<column><column-name>TenNguoiNhanKetQua</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiNhanKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayNhanKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayNhanKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LePhiHoSo</column-name><column-value><![CDATA[");
		sb.append(getLePhiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PhiXuLyHoSo</column-name><column-value><![CDATA[");
		sb.append(getPhiXuLyHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayHoanThanh</column-name><column-value><![CDATA[");
		sb.append(getNgayHoanThanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaCanBoTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getMaCanBoTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenCanBoTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getTenCanBoTraKetQua());
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
	private String _TenNguoiNhanKetQua;
	private String _NgayNhanKetQua;
	private int _LePhiHoSo;
	private int _PhiXuLyHoSo;
	private String _NgayHoanThanh;
	private String _MaCanBoTraKetQua;
	private String _TenCanBoTraKetQua;
	private String _DonViCungCap;
	private int _TrangThaiXuLy;
	private Date _NgayXuLy;
	private String _LoiKhiXuLy;
}