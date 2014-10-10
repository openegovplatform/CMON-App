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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class DoiTuongSuDungClp extends BaseModelImpl<DoiTuongSuDung>
	implements DoiTuongSuDung {
	public DoiTuongSuDungClp() {
	}

	public Class<?> getModelClass() {
		return DoiTuongSuDung.class;
	}

	public String getModelClassName() {
		return DoiTuongSuDung.class.getName();
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getMota() {
		return _mota;
	}

	public void setMota(String mota) {
		_mota = mota;
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DoiTuongSuDungLocalServiceUtil.addDoiTuongSuDung(this);
		}
		else {
			DoiTuongSuDungLocalServiceUtil.updateDoiTuongSuDung(this);
		}
	}

	@Override
	public DoiTuongSuDung toEscapedModel() {
		return (DoiTuongSuDung)Proxy.newProxyInstance(DoiTuongSuDung.class.getClassLoader(),
			new Class[] { DoiTuongSuDung.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DoiTuongSuDungClp clone = new DoiTuongSuDungClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setMa(getMa());
		clone.setMota(getMota());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setTrangThai(getTrangThai());
		clone.setDaXoa(getDaXoa());

		return clone;
	}

	public int compareTo(DoiTuongSuDung doiTuongSuDung) {
		int value = 0;

		if (getId() < doiTuongSuDung.getId()) {
			value = -1;
		}
		else if (getId() > doiTuongSuDung.getId()) {
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

		DoiTuongSuDungClp doiTuongSuDung = null;

		try {
			doiTuongSuDung = (DoiTuongSuDungClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = doiTuongSuDung.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", mota=");
		sb.append(getMota());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.DoiTuongSuDung");
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
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mota</column-name><column-value><![CDATA[");
		sb.append(getMota());
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
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private String _ma;
	private String _mota;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _trangThai;
	private int _daXoa;
}