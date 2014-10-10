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

package org.oep.cmon.dao.tlct.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.tlct.service.LichSuGiayToDinhKemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class LichSuGiayToDinhKemClp extends BaseModelImpl<LichSuGiayToDinhKem>
	implements LichSuGiayToDinhKem {
	public LichSuGiayToDinhKemClp() {
	}

	public Class<?> getModelClass() {
		return LichSuGiayToDinhKem.class;
	}

	public String getModelClassName() {
		return LichSuGiayToDinhKem.class.getName();
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

	public Long getGiayToDinhKemHoSoId() {
		return _giayToDinhKemHoSoId;
	}

	public void setGiayToDinhKemHoSoId(Long giayToDinhKemHoSoId) {
		_giayToDinhKemHoSoId = giayToDinhKemHoSoId;
	}

	public int getHanhDong() {
		return _hanhDong;
	}

	public void setHanhDong(int hanhDong) {
		_hanhDong = hanhDong;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public long getNoiLuuTruTaiLieuId() {
		return _noiLuuTruTaiLieuId;
	}

	public void setNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId) {
		_noiLuuTruTaiLieuId = noiLuuTruTaiLieuId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getTenTaiLieu() {
		return _tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		_tenTaiLieu = tenTaiLieu;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LichSuGiayToDinhKemLocalServiceUtil.addLichSuGiayToDinhKem(this);
		}
		else {
			LichSuGiayToDinhKemLocalServiceUtil.updateLichSuGiayToDinhKem(this);
		}
	}

	@Override
	public LichSuGiayToDinhKem toEscapedModel() {
		return (LichSuGiayToDinhKem)Proxy.newProxyInstance(LichSuGiayToDinhKem.class.getClassLoader(),
			new Class[] { LichSuGiayToDinhKem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LichSuGiayToDinhKemClp clone = new LichSuGiayToDinhKemClp();

		clone.setId(getId());
		clone.setGiayToDinhKemHoSoId(getGiayToDinhKemHoSoId());
		clone.setHanhDong(getHanhDong());
		clone.setNguoiTao(getNguoiTao());
		clone.setNoiLuuTruTaiLieuId(getNoiLuuTruTaiLieuId());
		clone.setNgayTao(getNgayTao());
		clone.setTenTaiLieu(getTenTaiLieu());

		return clone;
	}

	public int compareTo(LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		int value = 0;

		if (getId() < lichSuGiayToDinhKem.getId()) {
			value = -1;
		}
		else if (getId() > lichSuGiayToDinhKem.getId()) {
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

		LichSuGiayToDinhKemClp lichSuGiayToDinhKem = null;

		try {
			lichSuGiayToDinhKem = (LichSuGiayToDinhKemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = lichSuGiayToDinhKem.getPrimaryKey();

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
		sb.append(", giayToDinhKemHoSoId=");
		sb.append(getGiayToDinhKemHoSoId());
		sb.append(", hanhDong=");
		sb.append(getHanhDong());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", noiLuuTruTaiLieuId=");
		sb.append(getNoiLuuTruTaiLieuId());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", tenTaiLieu=");
		sb.append(getTenTaiLieu());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giayToDinhKemHoSoId</column-name><column-value><![CDATA[");
		sb.append(getGiayToDinhKemHoSoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hanhDong</column-name><column-value><![CDATA[");
		sb.append(getHanhDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruTaiLieuId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruTaiLieuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenTaiLieu</column-name><column-value><![CDATA[");
		sb.append(getTenTaiLieu());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Long _giayToDinhKemHoSoId;
	private int _hanhDong;
	private String _nguoiTao;
	private long _noiLuuTruTaiLieuId;
	private Date _ngayTao;
	private String _tenTaiLieu;
}