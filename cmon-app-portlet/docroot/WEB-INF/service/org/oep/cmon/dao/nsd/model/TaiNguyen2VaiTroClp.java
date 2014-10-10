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

import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class TaiNguyen2VaiTroClp extends BaseModelImpl<TaiNguyen2VaiTro>
	implements TaiNguyen2VaiTro {
	public TaiNguyen2VaiTroClp() {
	}

	public Class<?> getModelClass() {
		return TaiNguyen2VaiTro.class;
	}

	public String getModelClassName() {
		return TaiNguyen2VaiTro.class.getName();
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

	public Long getTaiNguyenId() {
		return _taiNguyenId;
	}

	public void setTaiNguyenId(Long taiNguyenId) {
		_taiNguyenId = taiNguyenId;
	}

	public Long getVaiTroId() {
		return _vaiTroId;
	}

	public void setVaiTroId(Long vaiTroId) {
		_vaiTroId = vaiTroId;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaiNguyen2VaiTroLocalServiceUtil.addTaiNguyen2VaiTro(this);
		}
		else {
			TaiNguyen2VaiTroLocalServiceUtil.updateTaiNguyen2VaiTro(this);
		}
	}

	@Override
	public TaiNguyen2VaiTro toEscapedModel() {
		return (TaiNguyen2VaiTro)Proxy.newProxyInstance(TaiNguyen2VaiTro.class.getClassLoader(),
			new Class[] { TaiNguyen2VaiTro.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaiNguyen2VaiTroClp clone = new TaiNguyen2VaiTroClp();

		clone.setId(getId());
		clone.setTaiNguyenId(getTaiNguyenId());
		clone.setVaiTroId(getVaiTroId());
		clone.setHanhDong(getHanhDong());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDaXoa(getDaXoa());

		return clone;
	}

	public int compareTo(TaiNguyen2VaiTro taiNguyen2VaiTro) {
		long primaryKey = taiNguyen2VaiTro.getPrimaryKey();

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

		TaiNguyen2VaiTroClp taiNguyen2VaiTro = null;

		try {
			taiNguyen2VaiTro = (TaiNguyen2VaiTroClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taiNguyen2VaiTro.getPrimaryKey();

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
		sb.append(", taiNguyenId=");
		sb.append(getTaiNguyenId());
		sb.append(", vaiTroId=");
		sb.append(getVaiTroId());
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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiNguyenId</column-name><column-value><![CDATA[");
		sb.append(getTaiNguyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vaiTroId</column-name><column-value><![CDATA[");
		sb.append(getVaiTroId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Long _taiNguyenId;
	private Long _vaiTroId;
	private int _hanhDong;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
}