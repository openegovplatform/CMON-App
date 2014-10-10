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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;


import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

import org.oep.dlms.dao.danhmucgiaypheplaixe.service.DonViGtvtLocalServiceUtil;

/**
 * @author AnhNT
 */
public class DonViGtvtClp extends BaseModelImpl<DonViGtvt> implements DonViGtvt {
	public DonViGtvtClp() {
	}

	public Class<?> getModelClass() {
		return DonViGtvt.class;
	}

	public String getModelClassName() {
		return DonViGtvt.class.getName();
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getCoQuanQl() {
		return _coQuanQl;
	}

	public void setCoQuanQl(String coQuanQl) {
		_coQuanQl = coQuanQl;
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public String getLanhDao() {
		return _lanhDao;
	}

	public void setLanhDao(String lanhDao) {
		_lanhDao = lanhDao;
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

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DonViGtvtLocalServiceUtil.addDonViGtvt(this);
		}
		else {
			DonViGtvtLocalServiceUtil.updateDonViGtvt(this);
		}
	}

	@Override
	public DonViGtvt toEscapedModel() {
		return (DonViGtvt)Proxy.newProxyInstance(DonViGtvt.class.getClassLoader(),
			new Class[] { DonViGtvt.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DonViGtvtClp clone = new DonViGtvtClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setCoQuanQl(getCoQuanQl());
		clone.setDienThoai(getDienThoai());
		clone.setFax(getFax());
		clone.setDiaChi(getDiaChi());
		clone.setLanhDao(getLanhDao());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setXoa(getXoa());

		return clone;
	}

	public int compareTo(DonViGtvt donViGtvt) {
		int value = 0;

		if (getId() < donViGtvt.getId()) {
			value = -1;
		}
		else if (getId() > donViGtvt.getId()) {
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

		DonViGtvtClp donViGtvt = null;

		try {
			donViGtvt = (DonViGtvtClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = donViGtvt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", coQuanQl=");
		sb.append(getCoQuanQl());
		sb.append(", dienThoai=");
		sb.append(getDienThoai());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", diaChi=");
		sb.append(getDiaChi());
		sb.append(", lanhDao=");
		sb.append(getLanhDao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", xoa=");
		sb.append(getXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanQl</column-name><column-value><![CDATA[");
		sb.append(getCoQuanQl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoai</column-name><column-value><![CDATA[");
		sb.append(getDienThoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChi</column-name><column-value><![CDATA[");
		sb.append(getDiaChi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lanhDao</column-name><column-value><![CDATA[");
		sb.append(getLanhDao());
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
			"<column><column-name>xoa</column-name><column-value><![CDATA[");
		sb.append(getXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _coQuanQl;
	private String _dienThoai;
	private String _fax;
	private String _diaChi;
	private String _lanhDao;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
}