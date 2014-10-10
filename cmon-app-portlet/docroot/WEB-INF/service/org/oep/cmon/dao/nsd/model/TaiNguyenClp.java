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

package org.oep.cmon.dao.nsd.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class TaiNguyenClp extends BaseModelImpl<TaiNguyen> implements TaiNguyen {
	public TaiNguyenClp() {
	}

	public Class<?> getModelClass() {
		return TaiNguyen.class;
	}

	public String getModelClassName() {
		return TaiNguyen.class.getName();
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

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public String getGiaTri() {
		return _giaTri;
	}

	public void setGiaTri(String giaTri) {
		_giaTri = giaTri;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Long getUngDungId() {
		return _ungDungId;
	}

	public void setUngDungId(Long ungDungId) {
		_ungDungId = ungDungId;
	}

	public Long getHeThongId() {
		return _heThongId;
	}

	public void setHeThongId(Long heThongId) {
		_heThongId = heThongId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaiNguyenLocalServiceUtil.addTaiNguyen(this);
		}
		else {
			TaiNguyenLocalServiceUtil.updateTaiNguyen(this);
		}
	}

	@Override
	public TaiNguyen toEscapedModel() {
		return (TaiNguyen)Proxy.newProxyInstance(TaiNguyen.class.getClassLoader(),
			new Class[] { TaiNguyen.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaiNguyenClp clone = new TaiNguyenClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setMoTa(getMoTa());
		clone.setLoai(getLoai());
		clone.setGiaTri(getGiaTri());
		clone.setTrangThai(getTrangThai());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());
		clone.setUngDungId(getUngDungId());
		clone.setHeThongId(getHeThongId());

		return clone;
	}

	public int compareTo(TaiNguyen taiNguyen) {
		int value = 0;

		value = getTen().compareTo(taiNguyen.getTen());

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

		TaiNguyenClp taiNguyen = null;

		try {
			taiNguyen = (TaiNguyenClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taiNguyen.getPrimaryKey();

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
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", moTa=");
		sb.append(getMoTa());
		sb.append(", loai=");
		sb.append(getLoai());
		sb.append(", giaTri=");
		sb.append(getGiaTri());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", ungDungId=");
		sb.append(getUngDungId());
		sb.append(", heThongId=");
		sb.append(getHeThongId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.nsd.model.TaiNguyen");
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
			"<column><column-name>moTa</column-name><column-value><![CDATA[");
		sb.append(getMoTa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loai</column-name><column-value><![CDATA[");
		sb.append(getLoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giaTri</column-name><column-value><![CDATA[");
		sb.append(getGiaTri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
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
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ungDungId</column-name><column-value><![CDATA[");
		sb.append(getUngDungId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>heThongId</column-name><column-value><![CDATA[");
		sb.append(getHeThongId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private String _moTa;
	private int _loai;
	private String _giaTri;
	private int _trangThai;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
	private Long _ungDungId;
	private Long _heThongId;
}