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

package org.oep.cmon.dao.qlhc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class ChucVu2VaiTroClp extends BaseModelImpl<ChucVu2VaiTro>
	implements ChucVu2VaiTro {
	public ChucVu2VaiTroClp() {
	}

	public Class<?> getModelClass() {
		return ChucVu2VaiTro.class;
	}

	public String getModelClassName() {
		return ChucVu2VaiTro.class.getName();
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

	public Long getVaiTroId() {
		return _vaiTroId;
	}

	public void setVaiTroId(Long vaiTroId) {
		_vaiTroId = vaiTroId;
	}

	public Long getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(Long coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public Long getChucVuId() {
		return _chucVuId;
	}

	public void setChucVuId(Long chucVuId) {
		_chucVuId = chucVuId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ChucVu2VaiTroLocalServiceUtil.addChucVu2VaiTro(this);
		}
		else {
			ChucVu2VaiTroLocalServiceUtil.updateChucVu2VaiTro(this);
		}
	}

	@Override
	public ChucVu2VaiTro toEscapedModel() {
		return (ChucVu2VaiTro)Proxy.newProxyInstance(ChucVu2VaiTro.class.getClassLoader(),
			new Class[] { ChucVu2VaiTro.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChucVu2VaiTroClp clone = new ChucVu2VaiTroClp();

		clone.setId(getId());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setVaiTroId(getVaiTroId());
		clone.setCoQuanQuanLyId(getCoQuanQuanLyId());
		clone.setChucVuId(getChucVuId());

		return clone;
	}

	public int compareTo(ChucVu2VaiTro chucVu2VaiTro) {
		int value = 0;

		if (getId() < chucVu2VaiTro.getId()) {
			value = -1;
		}
		else if (getId() > chucVu2VaiTro.getId()) {
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

		ChucVu2VaiTroClp chucVu2VaiTro = null;

		try {
			chucVu2VaiTro = (ChucVu2VaiTroClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = chucVu2VaiTro.getPrimaryKey();

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
		sb.append(", vaiTroId=");
		sb.append(getVaiTroId());
		sb.append(", coQuanQuanLyId=");
		sb.append(getCoQuanQuanLyId());
		sb.append(", chucVuId=");
		sb.append(getChucVuId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro");
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
			"<column><column-name>vaiTroId</column-name><column-value><![CDATA[");
		sb.append(getVaiTroId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanQuanLyId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanQuanLyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucVuId</column-name><column-value><![CDATA[");
		sb.append(getChucVuId());
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
	private Long _vaiTroId;
	private Long _coQuanQuanLyId;
	private Long _chucVuId;
}