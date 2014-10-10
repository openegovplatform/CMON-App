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

package org.oep.cmon.dao.thamso.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class ThamSoClp extends BaseModelImpl<ThamSo> implements ThamSo {
	public ThamSoClp() {
	}

	public Class<?> getModelClass() {
		return ThamSo.class;
	}

	public String getModelClassName() {
		return ThamSo.class.getName();
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_Id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public String getTen() {
		return _Ten;
	}

	public void setTen(String Ten) {
		_Ten = Ten;
	}

	public String getGiaTri() {
		return _giaTri;
	}

	public void setGiaTri(String giaTri) {
		_giaTri = giaTri;
	}

	public int getKieuDuLieu() {
		return _kieuDuLieu;
	}

	public void setKieuDuLieu(int kieuDuLieu) {
		_kieuDuLieu = kieuDuLieu;
	}

	public String getMota() {
		return _Mota;
	}

	public void setMota(String Mota) {
		_Mota = Mota;
	}

	public Long getUngDungId() {
		return _UngDungId;
	}

	public void setUngDungId(Long UngDungId) {
		_UngDungId = UngDungId;
	}

	public Long getHeThongId() {
		return _HeThongId;
	}

	public void setHeThongId(Long HeThongId) {
		_HeThongId = HeThongId;
	}

	public Date getNgayTao() {
		return _NgayTao;
	}

	public void setNgayTao(Date NgayTao) {
		_NgayTao = NgayTao;
	}

	public String getNguoiTao() {
		return _NguoiTao;
	}

	public void setNguoiTao(String NguoiTao) {
		_NguoiTao = NguoiTao;
	}

	public Date getNgaySua() {
		return _NgaySua;
	}

	public void setNgaySua(Date NgaySua) {
		_NgaySua = NgaySua;
	}

	public String getNguoiSua() {
		return _NguoiSua;
	}

	public void setNguoiSua(String NguoiSua) {
		_NguoiSua = NguoiSua;
	}

	public int getDaXoa() {
		return _DaXoa;
	}

	public void setDaXoa(int DaXoa) {
		_DaXoa = DaXoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ThamSoLocalServiceUtil.addThamSo(this);
		}
		else {
			ThamSoLocalServiceUtil.updateThamSo(this);
		}
	}

	@Override
	public ThamSo toEscapedModel() {
		return (ThamSo)Proxy.newProxyInstance(ThamSo.class.getClassLoader(),
			new Class[] { ThamSo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ThamSoClp clone = new ThamSoClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setGiaTri(getGiaTri());
		clone.setKieuDuLieu(getKieuDuLieu());
		clone.setMota(getMota());
		clone.setUngDungId(getUngDungId());
		clone.setHeThongId(getHeThongId());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());

		return clone;
	}

	public int compareTo(ThamSo thamSo) {
		int value = 0;

		value = getTen().compareTo(thamSo.getTen());

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

		ThamSoClp thamSo = null;

		try {
			thamSo = (ThamSoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = thamSo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{Id=");
		sb.append(getId());
		sb.append(", Ten=");
		sb.append(getTen());
		sb.append(", giaTri=");
		sb.append(getGiaTri());
		sb.append(", kieuDuLieu=");
		sb.append(getKieuDuLieu());
		sb.append(", Mota=");
		sb.append(getMota());
		sb.append(", UngDungId=");
		sb.append(getUngDungId());
		sb.append(", HeThongId=");
		sb.append(getHeThongId());
		sb.append(", NgayTao=");
		sb.append(getNgayTao());
		sb.append(", NguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", NgaySua=");
		sb.append(getNgaySua());
		sb.append(", NguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", DaXoa=");
		sb.append(getDaXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.thamso.model.ThamSo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giaTri</column-name><column-value><![CDATA[");
		sb.append(getGiaTri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kieuDuLieu</column-name><column-value><![CDATA[");
		sb.append(getKieuDuLieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Mota</column-name><column-value><![CDATA[");
		sb.append(getMota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UngDungId</column-name><column-value><![CDATA[");
		sb.append(getUngDungId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HeThongId</column-name><column-value><![CDATA[");
		sb.append(getHeThongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DaXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _Id;
	private String _Ten;
	private String _giaTri;
	private int _kieuDuLieu;
	private String _Mota;
	private Long _UngDungId;
	private Long _HeThongId;
	private Date _NgayTao;
	private String _NguoiTao;
	private Date _NgaySua;
	private String _NguoiSua;
	private int _DaXoa;
}