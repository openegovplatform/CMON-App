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

import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class NhomThuTucHanhChinhClp extends BaseModelImpl<NhomThuTucHanhChinh>
	implements NhomThuTucHanhChinh {
	public NhomThuTucHanhChinhClp() {
	}

	public Class<?> getModelClass() {
		return NhomThuTucHanhChinh.class;
	}

	public String getModelClassName() {
		return NhomThuTucHanhChinh.class.getName();
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

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public long getDanhMucUngDungId() {
		return _danhMucUngDungId;
	}

	public void setDanhMucUngDungId(long danhMucUngDungId) {
		_danhMucUngDungId = danhMucUngDungId;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			NhomThuTucHanhChinhLocalServiceUtil.addNhomThuTucHanhChinh(this);
		}
		else {
			NhomThuTucHanhChinhLocalServiceUtil.updateNhomThuTucHanhChinh(this);
		}
	}

	@Override
	public NhomThuTucHanhChinh toEscapedModel() {
		return (NhomThuTucHanhChinh)Proxy.newProxyInstance(NhomThuTucHanhChinh.class.getClassLoader(),
			new Class[] { NhomThuTucHanhChinh.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NhomThuTucHanhChinhClp clone = new NhomThuTucHanhChinhClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiSua(getNguoiSua());
		clone.setNguoiTao(getNguoiTao());
		clone.setDanhMucUngDungId(getDanhMucUngDungId());
		clone.setPhienBan(getPhienBan());

		return clone;
	}

	public int compareTo(NhomThuTucHanhChinh nhomThuTucHanhChinh) {
		int value = 0;

		value = getTen().compareTo(nhomThuTucHanhChinh.getTen());

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

		NhomThuTucHanhChinhClp nhomThuTucHanhChinh = null;

		try {
			nhomThuTucHanhChinh = (NhomThuTucHanhChinhClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = nhomThuTucHanhChinh.getPrimaryKey();

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
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", danhMucUngDungId=");
		sb.append(getDanhMucUngDungId());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh");
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
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>danhMucUngDungId</column-name><column-value><![CDATA[");
		sb.append(getDanhMucUngDungId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienBan</column-name><column-value><![CDATA[");
		sb.append(getPhienBan());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiSua;
	private String _nguoiTao;
	private long _danhMucUngDungId;
	private long _phienBan;
}