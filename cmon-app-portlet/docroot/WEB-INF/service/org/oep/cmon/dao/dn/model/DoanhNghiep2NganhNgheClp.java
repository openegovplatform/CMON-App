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

package org.oep.cmon.dao.dn.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.dn.service.DoanhNghiep2NganhNgheLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class DoanhNghiep2NganhNgheClp extends BaseModelImpl<DoanhNghiep2NganhNghe>
	implements DoanhNghiep2NganhNghe {
	public DoanhNghiep2NganhNgheClp() {
	}

	public Class<?> getModelClass() {
		return DoanhNghiep2NganhNghe.class;
	}

	public String getModelClassName() {
		return DoanhNghiep2NganhNghe.class.getName();
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

	public int getLaNganhChinh() {
		return _laNganhChinh;
	}

	public void setLaNganhChinh(int laNganhChinh) {
		_laNganhChinh = laNganhChinh;
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

	public long getDoanhNghiepId() {
		return _doanhNghiepId;
	}

	public void setDoanhNghiepId(long doanhNghiepId) {
		_doanhNghiepId = doanhNghiepId;
	}

	public long getNganhNgheId() {
		return _nganhNgheId;
	}

	public void setNganhNgheId(long nganhNgheId) {
		_nganhNgheId = nganhNgheId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DoanhNghiep2NganhNgheLocalServiceUtil.addDoanhNghiep2NganhNghe(this);
		}
		else {
			DoanhNghiep2NganhNgheLocalServiceUtil.updateDoanhNghiep2NganhNghe(this);
		}
	}

	@Override
	public DoanhNghiep2NganhNghe toEscapedModel() {
		return (DoanhNghiep2NganhNghe)Proxy.newProxyInstance(DoanhNghiep2NganhNghe.class.getClassLoader(),
			new Class[] { DoanhNghiep2NganhNghe.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DoanhNghiep2NganhNgheClp clone = new DoanhNghiep2NganhNgheClp();

		clone.setId(getId());
		clone.setLaNganhChinh(getLaNganhChinh());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());
		clone.setDoanhNghiepId(getDoanhNghiepId());
		clone.setNganhNgheId(getNganhNgheId());

		return clone;
	}

	public int compareTo(DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		long primaryKey = doanhNghiep2NganhNghe.getPrimaryKey();

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

		DoanhNghiep2NganhNgheClp doanhNghiep2NganhNghe = null;

		try {
			doanhNghiep2NganhNghe = (DoanhNghiep2NganhNgheClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = doanhNghiep2NganhNghe.getPrimaryKey();

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
		sb.append(", laNganhChinh=");
		sb.append(getLaNganhChinh());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", doanhNghiepId=");
		sb.append(getDoanhNghiepId());
		sb.append(", nganhNgheId=");
		sb.append(getNganhNgheId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laNganhChinh</column-name><column-value><![CDATA[");
		sb.append(getLaNganhChinh());
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
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>doanhNghiepId</column-name><column-value><![CDATA[");
		sb.append(getDoanhNghiepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nganhNgheId</column-name><column-value><![CDATA[");
		sb.append(getNganhNgheId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private int _laNganhChinh;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _daXoa;
	private long _doanhNghiepId;
	private long _nganhNgheId;
}