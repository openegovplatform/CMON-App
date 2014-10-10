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

package org.oep.cmon.dao.chungthuc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author vietho
 */
public class SoDanhMucClp extends BaseModelImpl<SoDanhMuc> implements SoDanhMuc {
	public SoDanhMucClp() {
	}

	public Class<?> getModelClass() {
		return SoDanhMuc.class;
	}

	public String getModelClassName() {
		return SoDanhMuc.class.getName();
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

	public String getTenSo() {
		return _tenSo;
	}

	public void setTenSo(String tenSo) {
		_tenSo = tenSo;
	}

	public String getSoSo() {
		return _soSo;
	}

	public void setSoSo(String soSo) {
		_soSo = soSo;
	}

	public Long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(Long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public Long getNam() {
		return _nam;
	}

	public void setNam(Long nam) {
		_nam = nam;
	}

	public String getTheoQuyetDinh() {
		return _theoQuyetDinh;
	}

	public void setTheoQuyetDinh(String theoQuyetDinh) {
		_theoQuyetDinh = theoQuyetDinh;
	}

	public Long getCoQuanQuanLiId() {
		return _coQuanQuanLiId;
	}

	public void setCoQuanQuanLiId(Long coQuanQuanLiId) {
		_coQuanQuanLiId = coQuanQuanLiId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SoDanhMucLocalServiceUtil.addSoDanhMuc(this);
		}
		else {
			SoDanhMucLocalServiceUtil.updateSoDanhMuc(this);
		}
	}

	@Override
	public SoDanhMuc toEscapedModel() {
		return (SoDanhMuc)Proxy.newProxyInstance(SoDanhMuc.class.getClassLoader(),
			new Class[] { SoDanhMuc.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SoDanhMucClp clone = new SoDanhMucClp();

		clone.setId(getId());
		clone.setTenSo(getTenSo());
		clone.setSoSo(getSoSo());
		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());
		clone.setNam(getNam());
		clone.setTheoQuyetDinh(getTheoQuyetDinh());
		clone.setCoQuanQuanLiId(getCoQuanQuanLiId());

		return clone;
	}

	public int compareTo(SoDanhMuc soDanhMuc) {
		int value = 0;

		if (getId() < soDanhMuc.getId()) {
			value = -1;
		}
		else if (getId() > soDanhMuc.getId()) {
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

		SoDanhMucClp soDanhMuc = null;

		try {
			soDanhMuc = (SoDanhMucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = soDanhMuc.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tenSo=");
		sb.append(getTenSo());
		sb.append(", soSo=");
		sb.append(getSoSo());
		sb.append(", thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append(", nam=");
		sb.append(getNam());
		sb.append(", theoQuyetDinh=");
		sb.append(getTheoQuyetDinh());
		sb.append(", coQuanQuanLiId=");
		sb.append(getCoQuanQuanLiId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.chungthuc.model.SoDanhMuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenSo</column-name><column-value><![CDATA[");
		sb.append(getTenSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soSo</column-name><column-value><![CDATA[");
		sb.append(getSoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nam</column-name><column-value><![CDATA[");
		sb.append(getNam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>theoQuyetDinh</column-name><column-value><![CDATA[");
		sb.append(getTheoQuyetDinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanQuanLiId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanQuanLiId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _tenSo;
	private String _soSo;
	private Long _thuTucHanhChinhId;
	private Long _nam;
	private String _theoQuyetDinh;
	private Long _coQuanQuanLiId;
}