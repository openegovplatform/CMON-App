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

import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class AnhXaClp extends BaseModelImpl<AnhXa> implements AnhXa {
	public AnhXaClp() {
	}

	public Class<?> getModelClass() {
		return AnhXa.class;
	}

	public String getModelClassName() {
		return AnhXa.class.getName();
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

	public String getMaDNG() {
		return _maDNG;
	}

	public void setMaDNG(String maDNG) {
		_maDNG = maDNG;
	}

	public String getTenDNG() {
		return _tenDNG;
	}

	public void setTenDNG(String tenDNG) {
		_tenDNG = tenDNG;
	}

	public String getMaKhac() {
		return _maKhac;
	}

	public void setMaKhac(String maKhac) {
		_maKhac = maKhac;
	}

	public String getTenKhac() {
		return _tenKhac;
	}

	public void setTenKhac(String tenKhac) {
		_tenKhac = tenKhac;
	}

	public String getTenBang() {
		return _tenBang;
	}

	public void setTenBang(String tenBang) {
		_tenBang = tenBang;
	}

	public long getUngDungId() {
		return _UngDungId;
	}

	public void setUngDungId(long UngDungId) {
		_UngDungId = UngDungId;
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
			AnhXaLocalServiceUtil.addAnhXa(this);
		}
		else {
			AnhXaLocalServiceUtil.updateAnhXa(this);
		}
	}

	@Override
	public AnhXa toEscapedModel() {
		return (AnhXa)Proxy.newProxyInstance(AnhXa.class.getClassLoader(),
			new Class[] { AnhXa.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnhXaClp clone = new AnhXaClp();

		clone.setId(getId());
		clone.setMaDNG(getMaDNG());
		clone.setTenDNG(getTenDNG());
		clone.setMaKhac(getMaKhac());
		clone.setTenKhac(getTenKhac());
		clone.setTenBang(getTenBang());
		clone.setUngDungId(getUngDungId());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());

		return clone;
	}

	public int compareTo(AnhXa anhXa) {
		int value = 0;

		if (getId() < anhXa.getId()) {
			value = -1;
		}
		else if (getId() > anhXa.getId()) {
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

		AnhXaClp anhXa = null;

		try {
			anhXa = (AnhXaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = anhXa.getPrimaryKey();

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
		sb.append(", maDNG=");
		sb.append(getMaDNG());
		sb.append(", tenDNG=");
		sb.append(getTenDNG());
		sb.append(", maKhac=");
		sb.append(getMaKhac());
		sb.append(", tenKhac=");
		sb.append(getTenKhac());
		sb.append(", tenBang=");
		sb.append(getTenBang());
		sb.append(", UngDungId=");
		sb.append(getUngDungId());
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
		sb.append("org.oep.cmon.dao.thamso.model.AnhXa");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maDNG</column-name><column-value><![CDATA[");
		sb.append(getMaDNG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenDNG</column-name><column-value><![CDATA[");
		sb.append(getTenDNG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maKhac</column-name><column-value><![CDATA[");
		sb.append(getMaKhac());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenKhac</column-name><column-value><![CDATA[");
		sb.append(getTenKhac());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenBang</column-name><column-value><![CDATA[");
		sb.append(getTenBang());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UngDungId</column-name><column-value><![CDATA[");
		sb.append(getUngDungId());
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
	private String _maDNG;
	private String _tenDNG;
	private String _maKhac;
	private String _tenKhac;
	private String _tenBang;
	private long _UngDungId;
	private Date _NgayTao;
	private String _NguoiTao;
	private Date _NgaySua;
	private String _NguoiSua;
	private int _DaXoa;
}