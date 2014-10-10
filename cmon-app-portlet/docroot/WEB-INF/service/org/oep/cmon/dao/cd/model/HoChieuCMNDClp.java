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

import org.oep.cmon.dao.cd.service.HoChieuCMNDLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class HoChieuCMNDClp extends BaseModelImpl<HoChieuCMND>
	implements HoChieuCMND {
	public HoChieuCMNDClp() {
	}

	public Class<?> getModelClass() {
		return HoChieuCMND.class;
	}

	public String getModelClassName() {
		return HoChieuCMND.class.getName();
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

	public String getSo() {
		return _so;
	}

	public void setSo(String so) {
		_so = so;
	}

	public Date getNgayCap() {
		return _ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		_ngayCap = ngayCap;
	}

	public Date getNgayHetHan() {
		return _ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		_ngayHetHan = ngayHetHan;
	}

	public Long getNoiCapId() {
		return _noiCapId;
	}

	public void setNoiCapId(Long noiCapId) {
		_noiCapId = noiCapId;
	}

	public String getNoiCap() {
		return _noiCap;
	}

	public void setNoiCap(String noiCap) {
		_noiCap = noiCap;
	}

	public String getGiChu() {
		return _giChu;
	}

	public void setGiChu(String giChu) {
		_giChu = giChu;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
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

	public Long getCongDanID() {
		return _congDanID;
	}

	public void setCongDanID(Long congDanID) {
		_congDanID = congDanID;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoChieuCMNDLocalServiceUtil.addHoChieuCMND(this);
		}
		else {
			HoChieuCMNDLocalServiceUtil.updateHoChieuCMND(this);
		}
	}

	@Override
	public HoChieuCMND toEscapedModel() {
		return (HoChieuCMND)Proxy.newProxyInstance(HoChieuCMND.class.getClassLoader(),
			new Class[] { HoChieuCMND.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoChieuCMNDClp clone = new HoChieuCMNDClp();

		clone.setId(getId());
		clone.setSo(getSo());
		clone.setNgayCap(getNgayCap());
		clone.setNgayHetHan(getNgayHetHan());
		clone.setNoiCapId(getNoiCapId());
		clone.setNoiCap(getNoiCap());
		clone.setGiChu(getGiChu());
		clone.setLoai(getLoai());
		clone.setTrangThai(getTrangThai());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setCongDanID(getCongDanID());

		return clone;
	}

	public int compareTo(HoChieuCMND hoChieuCMND) {
		int value = 0;

		if (getId() < hoChieuCMND.getId()) {
			value = -1;
		}
		else if (getId() > hoChieuCMND.getId()) {
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

		HoChieuCMNDClp hoChieuCMND = null;

		try {
			hoChieuCMND = (HoChieuCMNDClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoChieuCMND.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", so=");
		sb.append(getSo());
		sb.append(", ngayCap=");
		sb.append(getNgayCap());
		sb.append(", ngayHetHan=");
		sb.append(getNgayHetHan());
		sb.append(", noiCapId=");
		sb.append(getNoiCapId());
		sb.append(", noiCap=");
		sb.append(getNoiCap());
		sb.append(", giChu=");
		sb.append(getGiChu());
		sb.append(", loai=");
		sb.append(getLoai());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", congDanID=");
		sb.append(getCongDanID());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cd.model.HoChieuCMND");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>so</column-name><column-value><![CDATA[");
		sb.append(getSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCap</column-name><column-value><![CDATA[");
		sb.append(getNgayCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHetHan</column-name><column-value><![CDATA[");
		sb.append(getNgayHetHan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapId</column-name><column-value><![CDATA[");
		sb.append(getNoiCapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCap</column-name><column-value><![CDATA[");
		sb.append(getNoiCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giChu</column-name><column-value><![CDATA[");
		sb.append(getGiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loai</column-name><column-value><![CDATA[");
		sb.append(getLoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
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
			"<column><column-name>congDanID</column-name><column-value><![CDATA[");
		sb.append(getCongDanID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _so;
	private Date _ngayCap;
	private Date _ngayHetHan;
	private Long _noiCapId;
	private String _noiCap;
	private String _giChu;
	private int _loai;
	private int _trangThai;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private Long _congDanID;
}