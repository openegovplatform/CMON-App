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

import org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class TinhTrangHonNhanClp extends BaseModelImpl<TinhTrangHonNhan>
	implements TinhTrangHonNhan {
	public TinhTrangHonNhanClp() {
	}

	public Class<?> getModelClass() {
		return TinhTrangHonNhan.class;
	}

	public String getModelClassName() {
		return TinhTrangHonNhan.class.getName();
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TinhTrangHonNhanLocalServiceUtil.addTinhTrangHonNhan(this);
		}
		else {
			TinhTrangHonNhanLocalServiceUtil.updateTinhTrangHonNhan(this);
		}
	}

	@Override
	public TinhTrangHonNhan toEscapedModel() {
		return (TinhTrangHonNhan)Proxy.newProxyInstance(TinhTrangHonNhan.class.getClassLoader(),
			new Class[] { TinhTrangHonNhan.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TinhTrangHonNhanClp clone = new TinhTrangHonNhanClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiSua(getNguoiSua());

		return clone;
	}

	public int compareTo(TinhTrangHonNhan tinhTrangHonNhan) {
		int value = 0;

		if (getId() < tinhTrangHonNhan.getId()) {
			value = -1;
		}
		else if (getId() > tinhTrangHonNhan.getId()) {
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

		TinhTrangHonNhanClp tinhTrangHonNhan = null;

		try {
			tinhTrangHonNhan = (TinhTrangHonNhanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tinhTrangHonNhan.getPrimaryKey();

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
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cd.model.TinhTrangHonNhan");
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
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private int _daXoa;
	private String _nguoiSua;
}