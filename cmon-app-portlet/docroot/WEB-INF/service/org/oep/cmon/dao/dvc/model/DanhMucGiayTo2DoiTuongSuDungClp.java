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

import org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class DanhMucGiayTo2DoiTuongSuDungClp extends BaseModelImpl<DanhMucGiayTo2DoiTuongSuDung>
	implements DanhMucGiayTo2DoiTuongSuDung {
	public DanhMucGiayTo2DoiTuongSuDungClp() {
	}

	public Class<?> getModelClass() {
		return DanhMucGiayTo2DoiTuongSuDung.class;
	}

	public String getModelClassName() {
		return DanhMucGiayTo2DoiTuongSuDung.class.getName();
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

	public long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public long getLoaiGiayToId() {
		return _loaiGiayToId;
	}

	public void setLoaiGiayToId(long loaiGiayToId) {
		_loaiGiayToId = loaiGiayToId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.addDanhMucGiayTo2DoiTuongSuDung(this);
		}
		else {
			DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.updateDanhMucGiayTo2DoiTuongSuDung(this);
		}
	}

	@Override
	public DanhMucGiayTo2DoiTuongSuDung toEscapedModel() {
		return (DanhMucGiayTo2DoiTuongSuDung)Proxy.newProxyInstance(DanhMucGiayTo2DoiTuongSuDung.class.getClassLoader(),
			new Class[] { DanhMucGiayTo2DoiTuongSuDung.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhMucGiayTo2DoiTuongSuDungClp clone = new DanhMucGiayTo2DoiTuongSuDungClp();

		clone.setId(getId());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setLoaiDoiTuongId(getLoaiDoiTuongId());
		clone.setLoaiGiayToId(getLoaiGiayToId());
		clone.setTrangThai(getTrangThai());

		return clone;
	}

	public int compareTo(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung) {
		int value = 0;

		if (getId() < danhMucGiayTo2DoiTuongSuDung.getId()) {
			value = -1;
		}
		else if (getId() > danhMucGiayTo2DoiTuongSuDung.getId()) {
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

		DanhMucGiayTo2DoiTuongSuDungClp danhMucGiayTo2DoiTuongSuDung = null;

		try {
			danhMucGiayTo2DoiTuongSuDung = (DanhMucGiayTo2DoiTuongSuDungClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhMucGiayTo2DoiTuongSuDung.getPrimaryKey();

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
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", loaiDoiTuongId=");
		sb.append(getLoaiDoiTuongId());
		sb.append(", loaiGiayToId=");
		sb.append(getLoaiGiayToId());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
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
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiDoiTuongId</column-name><column-value><![CDATA[");
		sb.append(getLoaiDoiTuongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiGiayToId</column-name><column-value><![CDATA[");
		sb.append(getLoaiGiayToId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _loaiDoiTuongId;
	private long _loaiGiayToId;
	private int _trangThai;
}