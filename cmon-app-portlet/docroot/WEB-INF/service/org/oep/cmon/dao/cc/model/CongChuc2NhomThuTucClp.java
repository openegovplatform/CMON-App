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

import org.oep.cmon.dao.cc.service.CongChuc2NhomThuTucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class CongChuc2NhomThuTucClp extends BaseModelImpl<CongChuc2NhomThuTuc>
	implements CongChuc2NhomThuTuc {
	public CongChuc2NhomThuTucClp() {
	}

	public Class<?> getModelClass() {
		return CongChuc2NhomThuTuc.class;
	}

	public String getModelClassName() {
		return CongChuc2NhomThuTuc.class.getName();
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

	public long getCongChucId() {
		return _congChucId;
	}

	public void setCongChucId(long congChucId) {
		_congChucId = congChucId;
	}

	public long getNhomThuTucId() {
		return _nhomThuTucId;
	}

	public void setNhomThuTucId(long nhomThuTucId) {
		_nhomThuTucId = nhomThuTucId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public int getDuocPhepEditCongDan() {
		return _duocPhepEditCongDan;
	}

	public void setDuocPhepEditCongDan(int duocPhepEditCongDan) {
		_duocPhepEditCongDan = duocPhepEditCongDan;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CongChuc2NhomThuTucLocalServiceUtil.addCongChuc2NhomThuTuc(this);
		}
		else {
			CongChuc2NhomThuTucLocalServiceUtil.updateCongChuc2NhomThuTuc(this);
		}
	}

	@Override
	public CongChuc2NhomThuTuc toEscapedModel() {
		return (CongChuc2NhomThuTuc)Proxy.newProxyInstance(CongChuc2NhomThuTuc.class.getClassLoader(),
			new Class[] { CongChuc2NhomThuTuc.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CongChuc2NhomThuTucClp clone = new CongChuc2NhomThuTucClp();

		clone.setId(getId());
		clone.setCongChucId(getCongChucId());
		clone.setNhomThuTucId(getNhomThuTucId());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());
		clone.setDuocPhepEditCongDan(getDuocPhepEditCongDan());

		return clone;
	}

	public int compareTo(CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		long primaryKey = congChuc2NhomThuTuc.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CongChuc2NhomThuTucClp congChuc2NhomThuTuc = null;

		try {
			congChuc2NhomThuTuc = (CongChuc2NhomThuTucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = congChuc2NhomThuTuc.getPrimaryKey();

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
		sb.append(", congChucId=");
		sb.append(getCongChucId());
		sb.append(", nhomThuTucId=");
		sb.append(getNhomThuTucId());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", duocPhepEditCongDan=");
		sb.append(getDuocPhepEditCongDan());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>congChucId</column-name><column-value><![CDATA[");
		sb.append(getCongChucId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nhomThuTucId</column-name><column-value><![CDATA[");
		sb.append(getNhomThuTucId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duocPhepEditCongDan</column-name><column-value><![CDATA[");
		sb.append(getDuocPhepEditCongDan());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _congChucId;
	private long _nhomThuTucId;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
	private int _duocPhepEditCongDan;
}