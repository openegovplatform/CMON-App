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

package org.oep.cmon.dao.cc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class CongChucClp extends BaseModelImpl<CongChuc> implements CongChuc {
	public CongChucClp() {
	}

	public Class<?> getModelClass() {
		return CongChuc.class;
	}

	public String getModelClassName() {
		return CongChuc.class.getName();
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

	public String getHoVaTen() {
		return _hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		_hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public String getSoCmnd() {
		return _soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		_soCmnd = soCmnd;
	}

	public Date getNgayCapCmnd() {
		return _ngayCapCmnd;
	}

	public void setNgayCapCmnd(Date ngayCapCmnd) {
		_ngayCapCmnd = ngayCapCmnd;
	}

	public String getNoiCapCmnd() {
		return _noiCapCmnd;
	}

	public void setNoiCapCmnd(String noiCapCmnd) {
		_noiCapCmnd = noiCapCmnd;
	}

	public long getGioiTinhId() {
		return _gioiTinhId;
	}

	public void setGioiTinhId(long gioiTinhId) {
		_gioiTinhId = gioiTinhId;
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

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public long getChucVuId() {
		return _chucVuId;
	}

	public void setChucVuId(long chucVuId) {
		_chucVuId = chucVuId;
	}

	public long getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(long coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CongChucLocalServiceUtil.addCongChuc(this);
		}
		else {
			CongChucLocalServiceUtil.updateCongChuc(this);
		}
	}

	@Override
	public CongChuc toEscapedModel() {
		return (CongChuc)Proxy.newProxyInstance(CongChuc.class.getClassLoader(),
			new Class[] { CongChuc.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CongChucClp clone = new CongChucClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setHoVaTen(getHoVaTen());
		clone.setNgaySinh(getNgaySinh());
		clone.setSoCmnd(getSoCmnd());
		clone.setNgayCapCmnd(getNgayCapCmnd());
		clone.setNoiCapCmnd(getNoiCapCmnd());
		clone.setGioiTinhId(getGioiTinhId());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setTaiKhoanNguoiDungId(getTaiKhoanNguoiDungId());
		clone.setNguoiSua(getNguoiSua());
		clone.setChucVuId(getChucVuId());
		clone.setCoQuanQuanLyId(getCoQuanQuanLyId());
		clone.setNguoiTao(getNguoiTao());

		return clone;
	}

	public int compareTo(CongChuc congChuc) {
		int value = 0;

		if (getId() < congChuc.getId()) {
			value = -1;
		}
		else if (getId() > congChuc.getId()) {
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

		CongChucClp congChuc = null;

		try {
			congChuc = (CongChucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = congChuc.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", hoVaTen=");
		sb.append(getHoVaTen());
		sb.append(", ngaySinh=");
		sb.append(getNgaySinh());
		sb.append(", soCmnd=");
		sb.append(getSoCmnd());
		sb.append(", ngayCapCmnd=");
		sb.append(getNgayCapCmnd());
		sb.append(", noiCapCmnd=");
		sb.append(getNoiCapCmnd());
		sb.append(", gioiTinhId=");
		sb.append(getGioiTinhId());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", chucVuId=");
		sb.append(getChucVuId());
		sb.append(", coQuanQuanLyId=");
		sb.append(getCoQuanQuanLyId());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cc.model.CongChuc");
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
			"<column><column-name>hoVaTen</column-name><column-value><![CDATA[");
		sb.append(getHoVaTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySinh</column-name><column-value><![CDATA[");
		sb.append(getNgaySinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soCmnd</column-name><column-value><![CDATA[");
		sb.append(getSoCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapCmnd</column-name><column-value><![CDATA[");
		sb.append(getNgayCapCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapCmnd</column-name><column-value><![CDATA[");
		sb.append(getNoiCapCmnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gioiTinhId</column-name><column-value><![CDATA[");
		sb.append(getGioiTinhId());
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
			"<column><column-name>taiKhoanNguoiDungId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucVuId</column-name><column-value><![CDATA[");
		sb.append(getChucVuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanQuanLyId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanQuanLyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _hoVaTen;
	private Date _ngaySinh;
	private String _soCmnd;
	private Date _ngayCapCmnd;
	private String _noiCapCmnd;
	private long _gioiTinhId;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private Long _taiKhoanNguoiDungId;
	private String _nguoiSua;
	private long _chucVuId;
	private long _coQuanQuanLyId;
	private String _nguoiTao;
}