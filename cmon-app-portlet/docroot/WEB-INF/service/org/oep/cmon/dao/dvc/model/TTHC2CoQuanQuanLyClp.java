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

import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class TTHC2CoQuanQuanLyClp extends BaseModelImpl<TTHC2CoQuanQuanLy>
	implements TTHC2CoQuanQuanLy {
	public TTHC2CoQuanQuanLyClp() {
	}

	public Class<?> getModelClass() {
		return TTHC2CoQuanQuanLy.class;
	}

	public String getModelClassName() {
		return TTHC2CoQuanQuanLy.class.getName();
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

	public int getSoNgayXyLy() {
		return _soNgayXyLy;
	}

	public void setSoNgayXyLy(int soNgayXyLy) {
		_soNgayXyLy = soNgayXyLy;
	}

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public long getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(long coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getPhi() {
		return _phi;
	}

	public void setPhi(int phi) {
		_phi = phi;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TTHC2CoQuanQuanLyLocalServiceUtil.addTTHC2CoQuanQuanLy(this);
		}
		else {
			TTHC2CoQuanQuanLyLocalServiceUtil.updateTTHC2CoQuanQuanLy(this);
		}
	}

	@Override
	public TTHC2CoQuanQuanLy toEscapedModel() {
		return (TTHC2CoQuanQuanLy)Proxy.newProxyInstance(TTHC2CoQuanQuanLy.class.getClassLoader(),
			new Class[] { TTHC2CoQuanQuanLy.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TTHC2CoQuanQuanLyClp clone = new TTHC2CoQuanQuanLyClp();

		clone.setId(getId());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setSoNgayXyLy(getSoNgayXyLy());
		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());
		clone.setCoQuanQuanLyId(getCoQuanQuanLyId());
		clone.setTrangThai(getTrangThai());
		clone.setPhi(getPhi());
		clone.setLePhi(getLePhi());

		return clone;
	}

	public int compareTo(TTHC2CoQuanQuanLy tthc2CoQuanQuanLy) {
		int value = 0;

		if (getId() < tthc2CoQuanQuanLy.getId()) {
			value = -1;
		}
		else if (getId() > tthc2CoQuanQuanLy.getId()) {
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

		TTHC2CoQuanQuanLyClp tthc2CoQuanQuanLy = null;

		try {
			tthc2CoQuanQuanLy = (TTHC2CoQuanQuanLyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tthc2CoQuanQuanLy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

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
		sb.append(", soNgayXyLy=");
		sb.append(getSoNgayXyLy());
		sb.append(", thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append(", coQuanQuanLyId=");
		sb.append(getCoQuanQuanLyId());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", phi=");
		sb.append(getPhi());
		sb.append(", lePhi=");
		sb.append(getLePhi());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy");
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
			"<column><column-name>soNgayXyLy</column-name><column-value><![CDATA[");
		sb.append(getSoNgayXyLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanQuanLyId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanQuanLyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phi</column-name><column-value><![CDATA[");
		sb.append(getPhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lePhi</column-name><column-value><![CDATA[");
		sb.append(getLePhi());
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
	private int _soNgayXyLy;
	private long _thuTucHanhChinhId;
	private long _coQuanQuanLyId;
	private int _trangThai;
	private int _phi;
	private int _lePhi;
}