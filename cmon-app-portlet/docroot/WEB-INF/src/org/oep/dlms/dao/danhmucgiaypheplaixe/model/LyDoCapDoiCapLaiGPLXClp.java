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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;


import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

import org.oep.dlms.dao.danhmucgiaypheplaixe.service.LyDoCapDoiCapLaiGPLXLocalServiceUtil;

/**
 * @author AnhNT
 */
public class LyDoCapDoiCapLaiGPLXClp extends BaseModelImpl<LyDoCapDoiCapLaiGPLX>
	implements LyDoCapDoiCapLaiGPLX {
	public LyDoCapDoiCapLaiGPLXClp() {
	}

	public Class<?> getModelClass() {
		return LyDoCapDoiCapLaiGPLX.class;
	}

	public String getModelClassName() {
		return LyDoCapDoiCapLaiGPLX.class.getName();
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

	public String getLyDo() {
		return _lyDo;
	}

	public void setLyDo(String lyDo) {
		_lyDo = lyDo;
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

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LyDoCapDoiCapLaiGPLXLocalServiceUtil.addLyDoCapDoiCapLaiGPLX(this);
		}
		else {
			LyDoCapDoiCapLaiGPLXLocalServiceUtil.updateLyDoCapDoiCapLaiGPLX(this);
		}
	}

	@Override
	public LyDoCapDoiCapLaiGPLX toEscapedModel() {
		return (LyDoCapDoiCapLaiGPLX)Proxy.newProxyInstance(LyDoCapDoiCapLaiGPLX.class.getClassLoader(),
			new Class[] { LyDoCapDoiCapLaiGPLX.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LyDoCapDoiCapLaiGPLXClp clone = new LyDoCapDoiCapLaiGPLXClp();

		clone.setId(getId());
		clone.setLyDo(getLyDo());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setXoa(getXoa());

		return clone;
	}

	public int compareTo(LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) {
		int value = 0;

		if (getId() < lyDoCapDoiCapLaiGPLX.getId()) {
			value = -1;
		}
		else if (getId() > lyDoCapDoiCapLaiGPLX.getId()) {
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

		LyDoCapDoiCapLaiGPLXClp lyDoCapDoiCapLaiGPLX = null;

		try {
			lyDoCapDoiCapLaiGPLX = (LyDoCapDoiCapLaiGPLXClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = lyDoCapDoiCapLaiGPLX.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", lyDo=");
		sb.append(getLyDo());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", xoa=");
		sb.append(getXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lyDo</column-name><column-value><![CDATA[");
		sb.append(getLyDo());
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
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xoa</column-name><column-value><![CDATA[");
		sb.append(getXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _lyDo;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
}