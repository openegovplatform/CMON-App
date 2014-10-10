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

package org.oep.cmon.dao.nsd.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class NguoiDung2VaiTroClp extends BaseModelImpl<NguoiDung2VaiTro>
	implements NguoiDung2VaiTro {
	public NguoiDung2VaiTroClp() {
	}

	public Class<?> getModelClass() {
		return NguoiDung2VaiTro.class;
	}

	public String getModelClassName() {
		return NguoiDung2VaiTro.class.getName();
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

	public Long getVaiTroId() {
		return _vaiTroId;
	}

	public void setVaiTroId(Long vaiTroId) {
		_vaiTroId = vaiTroId;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			NguoiDung2VaiTroLocalServiceUtil.addNguoiDung2VaiTro(this);
		}
		else {
			NguoiDung2VaiTroLocalServiceUtil.updateNguoiDung2VaiTro(this);
		}
	}

	@Override
	public NguoiDung2VaiTro toEscapedModel() {
		return (NguoiDung2VaiTro)Proxy.newProxyInstance(NguoiDung2VaiTro.class.getClassLoader(),
			new Class[] { NguoiDung2VaiTro.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NguoiDung2VaiTroClp clone = new NguoiDung2VaiTroClp();

		clone.setId(getId());
		clone.setVaiTroId(getVaiTroId());
		clone.setTaiKhoanNguoiDungId(getTaiKhoanNguoiDungId());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setDaXoa(getDaXoa());

		return clone;
	}

	public int compareTo(NguoiDung2VaiTro nguoiDung2VaiTro) {
		long primaryKey = nguoiDung2VaiTro.getPrimaryKey();

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

		NguoiDung2VaiTroClp nguoiDung2VaiTro = null;

		try {
			nguoiDung2VaiTro = (NguoiDung2VaiTroClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = nguoiDung2VaiTro.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", vaiTroId=");
		sb.append(getVaiTroId());
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vaiTroId</column-name><column-value><![CDATA[");
		sb.append(getVaiTroId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiKhoanNguoiDungId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungId());
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
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Long _vaiTroId;
	private Long _taiKhoanNguoiDungId;
	private Date _ngayTao;
	private String _nguoiTao;
	private int _daXoa;
}