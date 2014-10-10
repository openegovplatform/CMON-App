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

package org.oep.cmon.dao.cd.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.cd.service.ChuyenMonLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class ChuyenMonClp extends BaseModelImpl<ChuyenMon> implements ChuyenMon {
	public ChuyenMonClp() {
	}

	public Class<?> getModelClass() {
		return ChuyenMon.class;
	}

	public String getModelClassName() {
		return ChuyenMon.class.getName();
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

	public long getPhienban() {
		return _phienban;
	}

	public void setPhienban(long phienban) {
		_phienban = phienban;
	}

	public Date getNgaytao() {
		return _ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		_ngaytao = ngaytao;
	}

	public String getNguoitao() {
		return _nguoitao;
	}

	public void setNguoitao(String nguoitao) {
		_nguoitao = nguoitao;
	}

	public Date getNgaysua() {
		return _ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		_ngaysua = ngaysua;
	}

	public String getNguoisua() {
		return _nguoisua;
	}

	public void setNguoisua(String nguoisua) {
		_nguoisua = nguoisua;
	}

	public long getDaxoa() {
		return _daxoa;
	}

	public void setDaxoa(long daxoa) {
		_daxoa = daxoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ChuyenMonLocalServiceUtil.addChuyenMon(this);
		}
		else {
			ChuyenMonLocalServiceUtil.updateChuyenMon(this);
		}
	}

	@Override
	public ChuyenMon toEscapedModel() {
		return (ChuyenMon)Proxy.newProxyInstance(ChuyenMon.class.getClassLoader(),
			new Class[] { ChuyenMon.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChuyenMonClp clone = new ChuyenMonClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setPhienban(getPhienban());
		clone.setNgaytao(getNgaytao());
		clone.setNguoitao(getNguoitao());
		clone.setNgaysua(getNgaysua());
		clone.setNguoisua(getNguoisua());
		clone.setDaxoa(getDaxoa());

		return clone;
	}

	public int compareTo(ChuyenMon chuyenMon) {
		int value = 0;

		if (getId() < chuyenMon.getId()) {
			value = -1;
		}
		else if (getId() > chuyenMon.getId()) {
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

		ChuyenMonClp chuyenMon = null;

		try {
			chuyenMon = (ChuyenMonClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = chuyenMon.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", phienban=");
		sb.append(getPhienban());
		sb.append(", ngaytao=");
		sb.append(getNgaytao());
		sb.append(", nguoitao=");
		sb.append(getNguoitao());
		sb.append(", ngaysua=");
		sb.append(getNgaysua());
		sb.append(", nguoisua=");
		sb.append(getNguoisua());
		sb.append(", daxoa=");
		sb.append(getDaxoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cd.model.ChuyenMon");
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
			"<column><column-name>phienban</column-name><column-value><![CDATA[");
		sb.append(getPhienban());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaytao</column-name><column-value><![CDATA[");
		sb.append(getNgaytao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoitao</column-name><column-value><![CDATA[");
		sb.append(getNguoitao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaysua</column-name><column-value><![CDATA[");
		sb.append(getNgaysua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoisua</column-name><column-value><![CDATA[");
		sb.append(getNguoisua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daxoa</column-name><column-value><![CDATA[");
		sb.append(getDaxoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _phienban;
	private Date _ngaytao;
	private String _nguoitao;
	private Date _ngaysua;
	private String _nguoisua;
	private long _daxoa;
}