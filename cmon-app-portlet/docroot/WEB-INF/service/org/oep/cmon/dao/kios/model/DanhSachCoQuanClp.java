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

package org.oep.cmon.dao.kios.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.kios.service.DanhSachCoQuanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class DanhSachCoQuanClp extends BaseModelImpl<DanhSachCoQuan>
	implements DanhSachCoQuan {
	public DanhSachCoQuanClp() {
	}

	public Class<?> getModelClass() {
		return DanhSachCoQuan.class;
	}

	public String getModelClassName() {
		return DanhSachCoQuan.class.getName();
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

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public String getTenCapCoQuanQuanly() {
		return _tenCapCoQuanQuanly;
	}

	public void setTenCapCoQuanQuanly(String tenCapCoQuanQuanly) {
		_tenCapCoQuanQuanly = tenCapCoQuanQuanly;
	}

	public Long getCapCoQuanQuanLyId() {
		return _capCoQuanQuanLyId;
	}

	public void setCapCoQuanQuanLyId(Long capCoQuanQuanLyId) {
		_capCoQuanQuanLyId = capCoQuanQuanLyId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhSachCoQuanLocalServiceUtil.addDanhSachCoQuan(this);
		}
		else {
			DanhSachCoQuanLocalServiceUtil.updateDanhSachCoQuan(this);
		}
	}

	@Override
	public DanhSachCoQuan toEscapedModel() {
		return (DanhSachCoQuan)Proxy.newProxyInstance(DanhSachCoQuan.class.getClassLoader(),
			new Class[] { DanhSachCoQuan.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhSachCoQuanClp clone = new DanhSachCoQuanClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setChaId(getChaId());
		clone.setTenCapCoQuanQuanly(getTenCapCoQuanQuanly());
		clone.setCapCoQuanQuanLyId(getCapCoQuanQuanLyId());

		return clone;
	}

	public int compareTo(DanhSachCoQuan danhSachCoQuan) {
		long primaryKey = danhSachCoQuan.getPrimaryKey();

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

		DanhSachCoQuanClp danhSachCoQuan = null;

		try {
			danhSachCoQuan = (DanhSachCoQuanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhSachCoQuan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", chaId=");
		sb.append(getChaId());
		sb.append(", tenCapCoQuanQuanly=");
		sb.append(getTenCapCoQuanQuanly());
		sb.append(", capCoQuanQuanLyId=");
		sb.append(getCapCoQuanQuanLyId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.kios.model.DanhSachCoQuan");
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
			"<column><column-name>chaId</column-name><column-value><![CDATA[");
		sb.append(getChaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCapCoQuanQuanly</column-name><column-value><![CDATA[");
		sb.append(getTenCapCoQuanQuanly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capCoQuanQuanLyId</column-name><column-value><![CDATA[");
		sb.append(getCapCoQuanQuanLyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private Long _chaId;
	private String _tenCapCoQuanQuanly;
	private Long _capCoQuanQuanLyId;
}