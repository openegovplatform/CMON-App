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

import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class TaiKhoanNguoiDungClp extends BaseModelImpl<TaiKhoanNguoiDung>
	implements TaiKhoanNguoiDung {
	public TaiKhoanNguoiDungClp() {
	}

	public Class<?> getModelClass() {
		return TaiKhoanNguoiDung.class;
	}

	public String getModelClassName() {
		return TaiKhoanNguoiDung.class.getName();
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

	public String getTenDangNhap() {
		return _tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		_tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return _matKhau;
	}

	public void setMatKhau(String matKhau) {
		_matKhau = matKhau;
	}

	public String getTenNguoiDung() {
		return _tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		_tenNguoiDung = tenNguoiDung;
	}

	public String getCauHoiMatKhau() {
		return _cauHoiMatKhau;
	}

	public void setCauHoiMatKhau(String cauHoiMatKhau) {
		_cauHoiMatKhau = cauHoiMatKhau;
	}

	public String getCauTraLoiMatKhau() {
		return _cauTraLoiMatKhau;
	}

	public void setCauTraLoiMatKhau(String cauTraLoiMatKhau) {
		_cauTraLoiMatKhau = cauTraLoiMatKhau;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(Long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(this);
		}
		else {
			TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(this);
		}
	}

	@Override
	public TaiKhoanNguoiDung toEscapedModel() {
		return (TaiKhoanNguoiDung)Proxy.newProxyInstance(TaiKhoanNguoiDung.class.getClassLoader(),
			new Class[] { TaiKhoanNguoiDung.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaiKhoanNguoiDungClp clone = new TaiKhoanNguoiDungClp();

		clone.setId(getId());
		clone.setTenDangNhap(getTenDangNhap());
		clone.setMatKhau(getMatKhau());
		clone.setTenNguoiDung(getTenNguoiDung());
		clone.setCauHoiMatKhau(getCauHoiMatKhau());
		clone.setCauTraLoiMatKhau(getCauTraLoiMatKhau());
		clone.setEmail(getEmail());
		clone.setNgayTao(getNgayTao());
		clone.setDaXoa(getDaXoa());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setTrangThai(getTrangThai());
		clone.setLoaiDoiTuongId(getLoaiDoiTuongId());
		clone.setTaiKhoanNguoiDungId(getTaiKhoanNguoiDungId());

		return clone;
	}

	public int compareTo(TaiKhoanNguoiDung taiKhoanNguoiDung) {
		int value = 0;

		if (getId() < taiKhoanNguoiDung.getId()) {
			value = -1;
		}
		else if (getId() > taiKhoanNguoiDung.getId()) {
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

		TaiKhoanNguoiDungClp taiKhoanNguoiDung = null;

		try {
			taiKhoanNguoiDung = (TaiKhoanNguoiDungClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taiKhoanNguoiDung.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tenDangNhap=");
		sb.append(getTenDangNhap());
		sb.append(", matKhau=");
		sb.append(getMatKhau());
		sb.append(", tenNguoiDung=");
		sb.append(getTenNguoiDung());
		sb.append(", cauHoiMatKhau=");
		sb.append(getCauHoiMatKhau());
		sb.append(", cauTraLoiMatKhau=");
		sb.append(getCauTraLoiMatKhau());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", loaiDoiTuongId=");
		sb.append(getLoaiDoiTuongId());
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenDangNhap</column-name><column-value><![CDATA[");
		sb.append(getTenDangNhap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>matKhau</column-name><column-value><![CDATA[");
		sb.append(getMatKhau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenNguoiDung</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiDung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cauHoiMatKhau</column-name><column-value><![CDATA[");
		sb.append(getCauHoiMatKhau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cauTraLoiMatKhau</column-name><column-value><![CDATA[");
		sb.append(getCauTraLoiMatKhau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
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
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiDoiTuongId</column-name><column-value><![CDATA[");
		sb.append(getLoaiDoiTuongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiKhoanNguoiDungId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _tenDangNhap;
	private String _matKhau;
	private String _tenNguoiDung;
	private String _cauHoiMatKhau;
	private String _cauTraLoiMatKhau;
	private String _email;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _trangThai;
	private Long _loaiDoiTuongId;
	private Long _taiKhoanNguoiDungId;
}