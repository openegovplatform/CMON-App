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

import org.oep.cmon.dao.dvc.service.CapNhatKetQuaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class CapNhatKetQuaClp extends BaseModelImpl<CapNhatKetQua>
	implements CapNhatKetQua {
	public CapNhatKetQuaClp() {
	}

	public Class<?> getModelClass() {
		return CapNhatKetQua.class;
	}

	public String getModelClassName() {
		return CapNhatKetQua.class.getName();
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

	public String getTenBang() {
		return _tenBang;
	}

	public void setTenBang(String tenBang) {
		_tenBang = tenBang;
	}

	public long getBanGhiId() {
		return _banGhiId;
	}

	public void setBanGhiId(long banGhiId) {
		_banGhiId = banGhiId;
	}

	public int getHanhDong() {
		return _hanhDong;
	}

	public void setHanhDong(int hanhDong) {
		_hanhDong = hanhDong;
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

	public long getHosoTTHCCId() {
		return _hosoTTHCCId;
	}

	public void setHosoTTHCCId(long hosoTTHCCId) {
		_hosoTTHCCId = hosoTTHCCId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CapNhatKetQuaLocalServiceUtil.addCapNhatKetQua(this);
		}
		else {
			CapNhatKetQuaLocalServiceUtil.updateCapNhatKetQua(this);
		}
	}

	@Override
	public CapNhatKetQua toEscapedModel() {
		return (CapNhatKetQua)Proxy.newProxyInstance(CapNhatKetQua.class.getClassLoader(),
			new Class[] { CapNhatKetQua.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CapNhatKetQuaClp clone = new CapNhatKetQuaClp();

		clone.setId(getId());
		clone.setTenBang(getTenBang());
		clone.setBanGhiId(getBanGhiId());
		clone.setHanhDong(getHanhDong());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());
		clone.setHosoTTHCCId(getHosoTTHCCId());

		return clone;
	}

	public int compareTo(CapNhatKetQua capNhatKetQua) {
		int value = 0;

		if (getId() < capNhatKetQua.getId()) {
			value = -1;
		}
		else if (getId() > capNhatKetQua.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		CapNhatKetQuaClp capNhatKetQua = null;

		try {
			capNhatKetQua = (CapNhatKetQuaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = capNhatKetQua.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tenBang=");
		sb.append(getTenBang());
		sb.append(", banGhiId=");
		sb.append(getBanGhiId());
		sb.append(", hanhDong=");
		sb.append(getHanhDong());
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
		sb.append(", hosoTTHCCId=");
		sb.append(getHosoTTHCCId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.CapNhatKetQua");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenBang</column-name><column-value><![CDATA[");
		sb.append(getTenBang());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>banGhiId</column-name><column-value><![CDATA[");
		sb.append(getBanGhiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hanhDong</column-name><column-value><![CDATA[");
		sb.append(getHanhDong());
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
			"<column><column-name>hosoTTHCCId</column-name><column-value><![CDATA[");
		sb.append(getHosoTTHCCId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _tenBang;
	private long _banGhiId;
	private int _hanhDong;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
	private long _hosoTTHCCId;
}