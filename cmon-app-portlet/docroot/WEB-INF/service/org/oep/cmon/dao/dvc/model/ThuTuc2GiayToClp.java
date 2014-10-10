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

import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class ThuTuc2GiayToClp extends BaseModelImpl<ThuTuc2GiayTo>
	implements ThuTuc2GiayTo {
	public ThuTuc2GiayToClp() {
	}

	public Class<?> getModelClass() {
		return ThuTuc2GiayTo.class;
	}

	public String getModelClassName() {
		return ThuTuc2GiayTo.class.getName();
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

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public int getBatBuoc() {
		return _batBuoc;
	}

	public void setBatBuoc(int batBuoc) {
		_batBuoc = batBuoc;
	}

	public long getThuTuHienThi() {
		return _thuTuHienThi;
	}

	public void setThuTuHienThi(long thuTuHienThi) {
		_thuTuHienThi = thuTuHienThi;
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

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public long getDanhMucGiayToId() {
		return _danhMucGiayToId;
	}

	public void setDanhMucGiayToId(long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getGiaidoan() {
		return _giaidoan;
	}

	public void setGiaidoan(int giaidoan) {
		_giaidoan = giaidoan;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ThuTuc2GiayToLocalServiceUtil.addThuTuc2GiayTo(this);
		}
		else {
			ThuTuc2GiayToLocalServiceUtil.updateThuTuc2GiayTo(this);
		}
	}

	@Override
	public ThuTuc2GiayTo toEscapedModel() {
		return (ThuTuc2GiayTo)Proxy.newProxyInstance(ThuTuc2GiayTo.class.getClassLoader(),
			new Class[] { ThuTuc2GiayTo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ThuTuc2GiayToClp clone = new ThuTuc2GiayToClp();

		clone.setId(getId());
		clone.setGhiChu(getGhiChu());
		clone.setBatBuoc(getBatBuoc());
		clone.setThuTuHienThi(getThuTuHienThi());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());
		clone.setDanhMucGiayToId(getDanhMucGiayToId());
		clone.setTrangThai(getTrangThai());
		clone.setGiaidoan(getGiaidoan());

		return clone;
	}

	public int compareTo(ThuTuc2GiayTo thuTuc2GiayTo) {
		int value = 0;

		if (getThuTuHienThi() < thuTuc2GiayTo.getThuTuHienThi()) {
			value = -1;
		}
		else if (getThuTuHienThi() > thuTuc2GiayTo.getThuTuHienThi()) {
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

		ThuTuc2GiayToClp thuTuc2GiayTo = null;

		try {
			thuTuc2GiayTo = (ThuTuc2GiayToClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = thuTuc2GiayTo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", batBuoc=");
		sb.append(getBatBuoc());
		sb.append(", thuTuHienThi=");
		sb.append(getThuTuHienThi());
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
		sb.append(", thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append(", danhMucGiayToId=");
		sb.append(getDanhMucGiayToId());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", giaidoan=");
		sb.append(getGiaidoan());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>batBuoc</column-name><column-value><![CDATA[");
		sb.append(getBatBuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTuHienThi</column-name><column-value><![CDATA[");
		sb.append(getThuTuHienThi());
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
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>danhMucGiayToId</column-name><column-value><![CDATA[");
		sb.append(getDanhMucGiayToId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giaidoan</column-name><column-value><![CDATA[");
		sb.append(getGiaidoan());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ghiChu;
	private int _batBuoc;
	private long _thuTuHienThi;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _thuTucHanhChinhId;
	private long _danhMucGiayToId;
	private int _trangThai;
	private int _giaidoan;
}