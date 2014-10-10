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

import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNn
 */
public class YKienTraoDoiClp extends BaseModelImpl<YKienTraoDoi>
	implements YKienTraoDoi {
	public YKienTraoDoiClp() {
	}

	public Class<?> getModelClass() {
		return YKienTraoDoi.class;
	}

	public String getModelClassName() {
		return YKienTraoDoi.class.getName();
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

	public String getTieuDe() {
		return _tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;
	}

	public String getNoiDungYKien() {
		return _noiDungYKien;
	}

	public void setNoiDungYKien(String noiDungYKien) {
		_noiDungYKien = noiDungYKien;
	}

	public Date getThoiGianGuiYKien() {
		return _thoiGianGuiYKien;
	}

	public void setThoiGianGuiYKien(Date thoiGianGuiYKien) {
		_thoiGianGuiYKien = thoiGianGuiYKien;
	}

	public long getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(long trangThai) {
		_trangThai = trangThai;
	}

	public Long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(Long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Long getNguoiNhanId() {
		return _nguoiNhanId;
	}

	public void setNguoiNhanId(Long nguoiNhanId) {
		_nguoiNhanId = nguoiNhanId;
	}

	public Long getNguoiGuiId() {
		return _nguoiGuiId;
	}

	public void setNguoiGuiId(Long nguoiGuiId) {
		_nguoiGuiId = nguoiGuiId;
	}

	public Long getChaiId() {
		return _chaiId;
	}

	public void setChaiId(Long chaiId) {
		_chaiId = chaiId;
	}

	public Long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(Long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public long getLoai() {
		return _loai;
	}

	public void setLoai(long loai) {
		_loai = loai;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(this);
		}
		else {
			YKienTraoDoiLocalServiceUtil.updateYKienTraoDoi(this);
		}
	}

	@Override
	public YKienTraoDoi toEscapedModel() {
		return (YKienTraoDoi)Proxy.newProxyInstance(YKienTraoDoi.class.getClassLoader(),
			new Class[] { YKienTraoDoi.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		YKienTraoDoiClp clone = new YKienTraoDoiClp();

		clone.setId(getId());
		clone.setTieuDe(getTieuDe());
		clone.setNoiDungYKien(getNoiDungYKien());
		clone.setThoiGianGuiYKien(getThoiGianGuiYKien());
		clone.setTrangThai(getTrangThai());
		clone.setHoSoTTHCCongId(getHoSoTTHCCongId());
		clone.setNguoiNhanId(getNguoiNhanId());
		clone.setNguoiGuiId(getNguoiGuiId());
		clone.setChaiId(getChaiId());
		clone.setNoiLuuTruId(getNoiLuuTruId());
		clone.setLoai(getLoai());

		return clone;
	}

	public int compareTo(YKienTraoDoi yKienTraoDoi) {
		int value = 0;

		if (getId() < yKienTraoDoi.getId()) {
			value = -1;
		}
		else if (getId() > yKienTraoDoi.getId()) {
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

		YKienTraoDoiClp yKienTraoDoi = null;

		try {
			yKienTraoDoi = (YKienTraoDoiClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = yKienTraoDoi.getPrimaryKey();

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
		sb.append(", tieuDe=");
		sb.append(getTieuDe());
		sb.append(", noiDungYKien=");
		sb.append(getNoiDungYKien());
		sb.append(", thoiGianGuiYKien=");
		sb.append(getThoiGianGuiYKien());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", hoSoTTHCCongId=");
		sb.append(getHoSoTTHCCongId());
		sb.append(", nguoiNhanId=");
		sb.append(getNguoiNhanId());
		sb.append(", nguoiGuiId=");
		sb.append(getNguoiGuiId());
		sb.append(", chaiId=");
		sb.append(getChaiId());
		sb.append(", noiLuuTruId=");
		sb.append(getNoiLuuTruId());
		sb.append(", loai=");
		sb.append(getLoai());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.hosohcc.model.YKienTraoDoi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tieuDe</column-name><column-value><![CDATA[");
		sb.append(getTieuDe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungYKien</column-name><column-value><![CDATA[");
		sb.append(getNoiDungYKien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thoiGianGuiYKien</column-name><column-value><![CDATA[");
		sb.append(getThoiGianGuiYKien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoTTHCCongId</column-name><column-value><![CDATA[");
		sb.append(getHoSoTTHCCongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiNhanId</column-name><column-value><![CDATA[");
		sb.append(getNguoiNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiGuiId</column-name><column-value><![CDATA[");
		sb.append(getNguoiGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chaiId</column-name><column-value><![CDATA[");
		sb.append(getChaiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loai</column-name><column-value><![CDATA[");
		sb.append(getLoai());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _tieuDe;
	private String _noiDungYKien;
	private Date _thoiGianGuiYKien;
	private long _trangThai;
	private Long _hoSoTTHCCongId;
	private Long _nguoiNhanId;
	private Long _nguoiGuiId;
	private Long _chaiId;
	private Long _noiLuuTruId;
	private long _loai;
}