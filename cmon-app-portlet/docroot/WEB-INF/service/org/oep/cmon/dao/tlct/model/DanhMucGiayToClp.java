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

package org.oep.cmon.dao.tlct.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class DanhMucGiayToClp extends BaseModelImpl<DanhMucGiayTo>
	implements DanhMucGiayTo {
	public DanhMucGiayToClp() {
	}

	public Class<?> getModelClass() {
		return DanhMucGiayTo.class;
	}

	public String getModelClassName() {
		return DanhMucGiayTo.class.getName();
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

	public String getMota() {
		return _mota;
	}

	public void setMota(String mota) {
		_mota = mota;
	}

	public long getGioiHanDungLuong() {
		return _gioiHanDungLuong;
	}

	public void setGioiHanDungLuong(long gioiHanDungLuong) {
		_gioiHanDungLuong = gioiHanDungLuong;
	}

	public String getKieuTaiLieu() {
		return _kieuTaiLieu;
	}

	public void setKieuTaiLieu(String kieuTaiLieu) {
		_kieuTaiLieu = kieuTaiLieu;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public Long getTailieuThayTheId() {
		return _tailieuThayTheId;
	}

	public void setTailieuThayTheId(Long tailieuThayTheId) {
		_tailieuThayTheId = tailieuThayTheId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhMucGiayToLocalServiceUtil.addDanhMucGiayTo(this);
		}
		else {
			DanhMucGiayToLocalServiceUtil.updateDanhMucGiayTo(this);
		}
	}

	@Override
	public DanhMucGiayTo toEscapedModel() {
		return (DanhMucGiayTo)Proxy.newProxyInstance(DanhMucGiayTo.class.getClassLoader(),
			new Class[] { DanhMucGiayTo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhMucGiayToClp clone = new DanhMucGiayToClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setMota(getMota());
		clone.setGioiHanDungLuong(getGioiHanDungLuong());
		clone.setKieuTaiLieu(getKieuTaiLieu());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setPhienBan(getPhienBan());
		clone.setTailieuThayTheId(getTailieuThayTheId());

		return clone;
	}

	public int compareTo(DanhMucGiayTo danhMucGiayTo) {
		int value = 0;

		if (getId() < danhMucGiayTo.getId()) {
			value = -1;
		}
		else if (getId() > danhMucGiayTo.getId()) {
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

		DanhMucGiayToClp danhMucGiayTo = null;

		try {
			danhMucGiayTo = (DanhMucGiayToClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhMucGiayTo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", mota=");
		sb.append(getMota());
		sb.append(", gioiHanDungLuong=");
		sb.append(getGioiHanDungLuong());
		sb.append(", kieuTaiLieu=");
		sb.append(getKieuTaiLieu());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append(", tailieuThayTheId=");
		sb.append(getTailieuThayTheId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.tlct.model.DanhMucGiayTo");
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
			"<column><column-name>mota</column-name><column-value><![CDATA[");
		sb.append(getMota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gioiHanDungLuong</column-name><column-value><![CDATA[");
		sb.append(getGioiHanDungLuong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kieuTaiLieu</column-name><column-value><![CDATA[");
		sb.append(getKieuTaiLieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienBan</column-name><column-value><![CDATA[");
		sb.append(getPhienBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailieuThayTheId</column-name><column-value><![CDATA[");
		sb.append(getTailieuThayTheId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _mota;
	private long _gioiHanDungLuong;
	private String _kieuTaiLieu;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _daXoa;
	private long _phienBan;
	private Long _tailieuThayTheId;
}