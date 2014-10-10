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

package org.oep.cmon.dao.ttthanhtoan.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Thanhdd
 */
public class ThongTinThanhToanClp extends BaseModelImpl<ThongTinThanhToan>
	implements ThongTinThanhToan {
	public ThongTinThanhToanClp() {
	}

	public Class<?> getModelClass() {
		return ThongTinThanhToan.class;
	}

	public String getModelClassName() {
		return ThongTinThanhToan.class.getName();
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

	public long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Long getTaiKhoanNguoiDungNopId() {
		return _taiKhoanNguoiDungNopId;
	}

	public void setTaiKhoanNguoiDungNopId(Long taiKhoanNguoiDungNopId) {
		_taiKhoanNguoiDungNopId = taiKhoanNguoiDungNopId;
	}

	public Long getTaiKhoanNguoiDungNhanId() {
		return _taiKhoanNguoiDungNhanId;
	}

	public void setTaiKhoanNguoiDungNhanId(Long taiKhoanNguoiDungNhanId) {
		_taiKhoanNguoiDungNhanId = taiKhoanNguoiDungNhanId;
	}

	public long getLoaiThanhToan() {
		return _loaiThanhToan;
	}

	public void setLoaiThanhToan(long loaiThanhToan) {
		_loaiThanhToan = loaiThanhToan;
	}

	public String getTenNguoiNopTien() {
		return _tenNguoiNopTien;
	}

	public void setTenNguoiNopTien(String tenNguoiNopTien) {
		_tenNguoiNopTien = tenNguoiNopTien;
	}

	public String getTenCanBoNhanTien() {
		return _tenCanBoNhanTien;
	}

	public void setTenCanBoNhanTien(String tenCanBoNhanTien) {
		_tenCanBoNhanTien = tenCanBoNhanTien;
	}

	public long getXacNhan() {
		return _xacNhan;
	}

	public void setXacNhan(long xacNhan) {
		_xacNhan = xacNhan;
	}

	public long getLoaiPhi() {
		return _loaiPhi;
	}

	public void setLoaiPhi(long loaiPhi) {
		_loaiPhi = loaiPhi;
	}

	public long getSoTien() {
		return _soTien;
	}

	public void setSoTien(long soTien) {
		_soTien = soTien;
	}

	public Date getNgayThuTien() {
		return _ngayThuTien;
	}

	public void setNgayThuTien(Date ngayThuTien) {
		_ngayThuTien = ngayThuTien;
	}

	public Date getNgayXacNhan() {
		return _ngayXacNhan;
	}

	public void setNgayXacNhan(Date ngayXacNhan) {
		_ngayXacNhan = ngayXacNhan;
	}

	public Date getNgayChuyenTien() {
		return _ngayChuyenTien;
	}

	public void setNgayChuyenTien(Date ngayChuyenTien) {
		_ngayChuyenTien = ngayChuyenTien;
	}

	public String getYKien() {
		return _yKien;
	}

	public void setYKien(String yKien) {
		_yKien = yKien;
	}

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ThongTinThanhToanLocalServiceUtil.addThongTinThanhToan(this);
		}
		else {
			ThongTinThanhToanLocalServiceUtil.updateThongTinThanhToan(this);
		}
	}

	@Override
	public ThongTinThanhToan toEscapedModel() {
		return (ThongTinThanhToan)Proxy.newProxyInstance(ThongTinThanhToan.class.getClassLoader(),
			new Class[] { ThongTinThanhToan.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ThongTinThanhToanClp clone = new ThongTinThanhToanClp();

		clone.setId(getId());
		clone.setHoSoTTHCCongId(getHoSoTTHCCongId());
		clone.setTaiKhoanNguoiDungNopId(getTaiKhoanNguoiDungNopId());
		clone.setTaiKhoanNguoiDungNhanId(getTaiKhoanNguoiDungNhanId());
		clone.setLoaiThanhToan(getLoaiThanhToan());
		clone.setTenNguoiNopTien(getTenNguoiNopTien());
		clone.setTenCanBoNhanTien(getTenCanBoNhanTien());
		clone.setXacNhan(getXacNhan());
		clone.setLoaiPhi(getLoaiPhi());
		clone.setSoTien(getSoTien());
		clone.setNgayThuTien(getNgayThuTien());
		clone.setNgayXacNhan(getNgayXacNhan());
		clone.setNgayChuyenTien(getNgayChuyenTien());
		clone.setYKien(getYKien());
		clone.setNoiLuuTruId(getNoiLuuTruId());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());

		return clone;
	}

	public int compareTo(ThongTinThanhToan thongTinThanhToan) {
		int value = 0;

		if (getId() < thongTinThanhToan.getId()) {
			value = -1;
		}
		else if (getId() > thongTinThanhToan.getId()) {
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

		ThongTinThanhToanClp thongTinThanhToan = null;

		try {
			thongTinThanhToan = (ThongTinThanhToanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = thongTinThanhToan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", hoSoTTHCCongId=");
		sb.append(getHoSoTTHCCongId());
		sb.append(", taiKhoanNguoiDungNopId=");
		sb.append(getTaiKhoanNguoiDungNopId());
		sb.append(", taiKhoanNguoiDungNhanId=");
		sb.append(getTaiKhoanNguoiDungNhanId());
		sb.append(", loaiThanhToan=");
		sb.append(getLoaiThanhToan());
		sb.append(", tenNguoiNopTien=");
		sb.append(getTenNguoiNopTien());
		sb.append(", tenCanBoNhanTien=");
		sb.append(getTenCanBoNhanTien());
		sb.append(", xacNhan=");
		sb.append(getXacNhan());
		sb.append(", loaiPhi=");
		sb.append(getLoaiPhi());
		sb.append(", soTien=");
		sb.append(getSoTien());
		sb.append(", ngayThuTien=");
		sb.append(getNgayThuTien());
		sb.append(", ngayXacNhan=");
		sb.append(getNgayXacNhan());
		sb.append(", ngayChuyenTien=");
		sb.append(getNgayChuyenTien());
		sb.append(", yKien=");
		sb.append(getYKien());
		sb.append(", noiLuuTruId=");
		sb.append(getNoiLuuTruId());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoTTHCCongId</column-name><column-value><![CDATA[");
		sb.append(getHoSoTTHCCongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiKhoanNguoiDungNopId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungNopId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiKhoanNguoiDungNhanId</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoanNguoiDungNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiThanhToan</column-name><column-value><![CDATA[");
		sb.append(getLoaiThanhToan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenNguoiNopTien</column-name><column-value><![CDATA[");
		sb.append(getTenNguoiNopTien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCanBoNhanTien</column-name><column-value><![CDATA[");
		sb.append(getTenCanBoNhanTien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xacNhan</column-name><column-value><![CDATA[");
		sb.append(getXacNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiPhi</column-name><column-value><![CDATA[");
		sb.append(getLoaiPhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soTien</column-name><column-value><![CDATA[");
		sb.append(getSoTien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayThuTien</column-name><column-value><![CDATA[");
		sb.append(getNgayThuTien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayXacNhan</column-name><column-value><![CDATA[");
		sb.append(getNgayXacNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayChuyenTien</column-name><column-value><![CDATA[");
		sb.append(getNgayChuyenTien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yKien</column-name><column-value><![CDATA[");
		sb.append(getYKien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruId());
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
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _hoSoTTHCCongId;
	private Long _taiKhoanNguoiDungNopId;
	private Long _taiKhoanNguoiDungNhanId;
	private long _loaiThanhToan;
	private String _tenNguoiNopTien;
	private String _tenCanBoNhanTien;
	private long _xacNhan;
	private long _loaiPhi;
	private long _soTien;
	private Date _ngayThuTien;
	private Date _ngayXacNhan;
	private Date _ngayChuyenTien;
	private String _yKien;
	private long _noiLuuTruId;
	private String _nguoiTao;
	private String _nguoiSua;
	private Date _ngayTao;
	private Date _ngaySua;
}