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

import org.oep.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author vietho
 */
public class ThanhPhanHoSoChungThucClp extends BaseModelImpl<ThanhPhanHoSoChungThuc>
	implements ThanhPhanHoSoChungThuc {
	public ThanhPhanHoSoChungThucClp() {
	}

	public Class<?> getModelClass() {
		return ThanhPhanHoSoChungThuc.class;
	}

	public String getModelClassName() {
		return ThanhPhanHoSoChungThuc.class.getName();
	}

	public long getPrimaryKey() {
		return _thanhPhanHoSoId;
	}

	public void setPrimaryKey(long primaryKey) {
		setThanhPhanHoSoId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_thanhPhanHoSoId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getThanhPhanHoSoId() {
		return _thanhPhanHoSoId;
	}

	public void setThanhPhanHoSoId(long thanhPhanHoSoId) {
		_thanhPhanHoSoId = thanhPhanHoSoId;
	}

	public String getTieuDe() {
		return _tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public Long getHoSoChungThucId() {
		return _hoSoChungThucId;
	}

	public void setHoSoChungThucId(Long hoSoChungThucId) {
		_hoSoChungThucId = hoSoChungThucId;
	}

	public Long getThuTuc2GiayToId() {
		return _thuTuc2GiayToId;
	}

	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		_thuTuc2GiayToId = thuTuc2GiayToId;
	}

	public Long getNoiLuuTruHoSoDinhKemId() {
		return _noiLuuTruHoSoDinhKemId;
	}

	public void setNoiLuuTruHoSoDinhKemId(Long noiLuuTruHoSoDinhKemId) {
		_noiLuuTruHoSoDinhKemId = noiLuuTruHoSoDinhKemId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ThanhPhanHoSoChungThucLocalServiceUtil.addThanhPhanHoSoChungThuc(this);
		}
		else {
			ThanhPhanHoSoChungThucLocalServiceUtil.updateThanhPhanHoSoChungThuc(this);
		}
	}

	@Override
	public ThanhPhanHoSoChungThuc toEscapedModel() {
		return (ThanhPhanHoSoChungThuc)Proxy.newProxyInstance(ThanhPhanHoSoChungThuc.class.getClassLoader(),
			new Class[] { ThanhPhanHoSoChungThuc.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ThanhPhanHoSoChungThucClp clone = new ThanhPhanHoSoChungThucClp();

		clone.setThanhPhanHoSoId(getThanhPhanHoSoId());
		clone.setTieuDe(getTieuDe());
		clone.setMoTa(getMoTa());
		clone.setHoSoChungThucId(getHoSoChungThucId());
		clone.setThuTuc2GiayToId(getThuTuc2GiayToId());
		clone.setNoiLuuTruHoSoDinhKemId(getNoiLuuTruHoSoDinhKemId());

		return clone;
	}

	public int compareTo(ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc) {
		int value = 0;

		if (getThanhPhanHoSoId() < thanhPhanHoSoChungThuc.getThanhPhanHoSoId()) {
			value = -1;
		}
		else if (getThanhPhanHoSoId() > thanhPhanHoSoChungThuc.getThanhPhanHoSoId()) {
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

		ThanhPhanHoSoChungThucClp thanhPhanHoSoChungThuc = null;

		try {
			thanhPhanHoSoChungThuc = (ThanhPhanHoSoChungThucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = thanhPhanHoSoChungThuc.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{thanhPhanHoSoId=");
		sb.append(getThanhPhanHoSoId());
		sb.append(", tieuDe=");
		sb.append(getTieuDe());
		sb.append(", moTa=");
		sb.append(getMoTa());
		sb.append(", hoSoChungThucId=");
		sb.append(getHoSoChungThucId());
		sb.append(", thuTuc2GiayToId=");
		sb.append(getThuTuc2GiayToId());
		sb.append(", noiLuuTruHoSoDinhKemId=");
		sb.append(getNoiLuuTruHoSoDinhKemId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>thanhPhanHoSoId</column-name><column-value><![CDATA[");
		sb.append(getThanhPhanHoSoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tieuDe</column-name><column-value><![CDATA[");
		sb.append(getTieuDe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTa</column-name><column-value><![CDATA[");
		sb.append(getMoTa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoChungThucId</column-name><column-value><![CDATA[");
		sb.append(getHoSoChungThucId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTuc2GiayToId</column-name><column-value><![CDATA[");
		sb.append(getThuTuc2GiayToId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruHoSoDinhKemId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruHoSoDinhKemId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _thanhPhanHoSoId;
	private String _tieuDe;
	private String _moTa;
	private Long _hoSoChungThucId;
	private Long _thuTuc2GiayToId;
	private Long _noiLuuTruHoSoDinhKemId;
}