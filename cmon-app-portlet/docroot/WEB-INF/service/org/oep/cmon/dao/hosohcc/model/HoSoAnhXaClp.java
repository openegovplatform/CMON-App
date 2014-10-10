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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNn
 */
public class HoSoAnhXaClp extends BaseModelImpl<HoSoAnhXa> implements HoSoAnhXa {
	public HoSoAnhXaClp() {
	}

	public Class<?> getModelClass() {
		return HoSoAnhXa.class;
	}

	public String getModelClassName() {
		return HoSoAnhXa.class.getName();
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

	public long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public String getMaHoSo() {
		return _maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		_maHoSo = maHoSo;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoSoAnhXaLocalServiceUtil.addHoSoAnhXa(this);
		}
		else {
			HoSoAnhXaLocalServiceUtil.updateHoSoAnhXa(this);
		}
	}

	@Override
	public HoSoAnhXa toEscapedModel() {
		return (HoSoAnhXa)Proxy.newProxyInstance(HoSoAnhXa.class.getClassLoader(),
			new Class[] { HoSoAnhXa.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoSoAnhXaClp clone = new HoSoAnhXaClp();

		clone.setId(getId());
		clone.setHoSoTTHCCongId(getHoSoTTHCCongId());
		clone.setMaHoSo(getMaHoSo());
		clone.setTrangThai(getTrangThai());
		clone.setNgaySua(getNgaySua());
		clone.setNgayTao(getNgayTao());

		return clone;
	}

	public int compareTo(HoSoAnhXa hoSoAnhXa) {
		int value = 0;

		if (getId() < hoSoAnhXa.getId()) {
			value = -1;
		}
		else if (getId() > hoSoAnhXa.getId()) {
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

		HoSoAnhXaClp hoSoAnhXa = null;

		try {
			hoSoAnhXa = (HoSoAnhXaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoAnhXa.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", hoSoTTHCCongId=");
		sb.append(getHoSoTTHCCongId());
		sb.append(", maHoSo=");
		sb.append(getMaHoSo());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.hosohcc.model.HoSoAnhXa");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoTTHCCongId</column-name><column-value><![CDATA[");
		sb.append(getHoSoTTHCCongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maHoSo</column-name><column-value><![CDATA[");
		sb.append(getMaHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _hoSoTTHCCongId;
	private String _maHoSo;
	private int _trangThai;
	private Date _ngaySua;
	private Date _ngayTao;
}