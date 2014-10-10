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

package org.oep.cmon.dao.qlhc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class CapCoQuanQuanLyClp extends BaseModelImpl<CapCoQuanQuanLy>
	implements CapCoQuanQuanLy {
	public CapCoQuanQuanLyClp() {
	}

	public Class<?> getModelClass() {
		return CapCoQuanQuanLy.class;
	}

	public String getModelClassName() {
		return CapCoQuanQuanLy.class.getName();
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

	public long getCap() {
		return _cap;
	}

	public void setCap(long cap) {
		_cap = cap;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
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

	public int getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(int phienBan) {
		_phienBan = phienBan;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CapCoQuanQuanLyLocalServiceUtil.addCapCoQuanQuanLy(this);
		}
		else {
			CapCoQuanQuanLyLocalServiceUtil.updateCapCoQuanQuanLy(this);
		}
	}

	@Override
	public CapCoQuanQuanLy toEscapedModel() {
		return (CapCoQuanQuanLy)Proxy.newProxyInstance(CapCoQuanQuanLy.class.getClassLoader(),
			new Class[] { CapCoQuanQuanLy.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CapCoQuanQuanLyClp clone = new CapCoQuanQuanLyClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setCap(getCap());
		clone.setChaId(getChaId());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setPhienBan(getPhienBan());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());

		return clone;
	}

	public int compareTo(CapCoQuanQuanLy capCoQuanQuanLy) {
		int value = 0;

		value = getTen().compareTo(capCoQuanQuanLy.getTen());

		if (value != 0) {
			return value;
		}

		if (getId() < capCoQuanQuanLy.getId()) {
			value = -1;
		}
		else if (getId() > capCoQuanQuanLy.getId()) {
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

		CapCoQuanQuanLyClp capCoQuanQuanLy = null;

		try {
			capCoQuanQuanLy = (CapCoQuanQuanLyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = capCoQuanQuanLy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", cap=");
		sb.append(getCap());
		sb.append(", chaId=");
		sb.append(getChaId());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy");
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
			"<column><column-name>cap</column-name><column-value><![CDATA[");
		sb.append(getCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chaId</column-name><column-value><![CDATA[");
		sb.append(getChaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
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
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _cap;
	private Long _chaId;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private int _phienBan;
	private String _nguoiTao;
	private String _nguoiSua;
}