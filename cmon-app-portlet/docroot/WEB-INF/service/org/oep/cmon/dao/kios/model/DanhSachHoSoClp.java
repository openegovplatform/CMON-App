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

package org.oep.cmon.dao.kios.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.kios.service.DanhSachHoSoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author VIENPN
 */
public class DanhSachHoSoClp extends BaseModelImpl<DanhSachHoSo>
	implements DanhSachHoSo {
	public DanhSachHoSoClp() {
	}

	public Class<?> getModelClass() {
		return DanhSachHoSo.class;
	}

	public String getModelClassName() {
		return DanhSachHoSo.class.getName();
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

	public Date getNgayNhanHoSo() {
		return _ngayNhanHoSo;
	}

	public void setNgayNhanHoSo(Date ngayNhanHoSo) {
		_ngayNhanHoSo = ngayNhanHoSo;
	}

	public String getTenCoQuanTiepNhan() {
		return _tenCoQuanTiepNhan;
	}

	public void setTenCoQuanTiepNhan(String tenCoQuanTiepNhan) {
		_tenCoQuanTiepNhan = tenCoQuanTiepNhan;
	}

	public String getTenThuTucHanhChinh() {
		return _tenThuTucHanhChinh;
	}

	public void setTenThuTucHanhChinh(String tenThuTucHanhChinh) {
		_tenThuTucHanhChinh = tenThuTucHanhChinh;
	}

	public Date getNgayHenTraKetQua() {
		return _ngayHenTraKetQua;
	}

	public void setNgayHenTraKetQua(Date ngayHenTraKetQua) {
		_ngayHenTraKetQua = ngayHenTraKetQua;
	}

	public Date getNgayTraKetQua() {
		return _ngayTraKetQua;
	}

	public void setNgayTraKetQua(Date ngayTraKetQua) {
		_ngayTraKetQua = ngayTraKetQua;
	}

	public String getHoTenNguoiNopHoSo() {
		return _hoTenNguoiNopHoSo;
	}

	public void setHoTenNguoiNopHoSo(String hoTenNguoiNopHoSo) {
		_hoTenNguoiNopHoSo = hoTenNguoiNopHoSo;
	}

	public String getDiaChiThuongTruNguoiNop() {
		return _diaChiThuongTruNguoiNop;
	}

	public void setDiaChiThuongTruNguoiNop(String diaChiThuongTruNguoiNop) {
		_diaChiThuongTruNguoiNop = diaChiThuongTruNguoiNop;
	}

	public String getSoDienThoaiDiDongNguoiNop() {
		return _soDienThoaiDiDongNguoiNop;
	}

	public void setSoDienThoaiDiDongNguoiNop(String soDienThoaiDiDongNguoiNop) {
		_soDienThoaiDiDongNguoiNop = soDienThoaiDiDongNguoiNop;
	}

	public Date getNgayKetThucXuLy() {
		return _ngayKetThucXuLy;
	}

	public void setNgayKetThucXuLy(Date ngayKetThucXuLy) {
		_ngayKetThucXuLy = ngayKetThucXuLy;
	}

	public int getLoaiHoSo() {
		return _loaiHoSo;
	}

	public void setLoaiHoSo(int loaiHoSo) {
		_loaiHoSo = loaiHoSo;
	}

	public String getMaSoBienNhan() {
		return _maSoBienNhan;
	}

	public void setMaSoBienNhan(String maSoBienNhan) {
		_maSoBienNhan = maSoBienNhan;
	}

	public String getChuSoHuu() {
		return _chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) {
		_chuSoHuu = chuSoHuu;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public int getPhiHoSo() {
		return _phiHoSo;
	}

	public void setPhiHoSo(int phiHoSo) {
		_phiHoSo = phiHoSo;
	}

	public String getEmailNguoiNop() {
		return _emailNguoiNop;
	}

	public void setEmailNguoiNop(String emailNguoiNop) {
		_emailNguoiNop = emailNguoiNop;
	}

	public String getSoDienThoaiCoDinhNguoiNop() {
		return _soDienThoaiCoDinhNguoiNop;
	}

	public void setSoDienThoaiCoDinhNguoiNop(String soDienThoaiCoDinhNguoiNop) {
		_soDienThoaiCoDinhNguoiNop = soDienThoaiCoDinhNguoiNop;
	}

	public String getNhomThuTucHanhChinhTen() {
		return _nhomThuTucHanhChinhTen;
	}

	public void setNhomThuTucHanhChinhTen(String nhomThuTucHanhChinhTen) {
		_nhomThuTucHanhChinhTen = nhomThuTucHanhChinhTen;
	}

	public String getTrangThaiHoSoTen() {
		return _trangThaiHoSoTen;
	}

	public void setTrangThaiHoSoTen(String trangThaiHoSoTen) {
		_trangThaiHoSoTen = trangThaiHoSoTen;
	}

	public int getRNum() {
		return _rNum;
	}

	public void setRNum(int rNum) {
		_rNum = rNum;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhSachHoSoLocalServiceUtil.addDanhSachHoSo(this);
		}
		else {
			DanhSachHoSoLocalServiceUtil.updateDanhSachHoSo(this);
		}
	}

	@Override
	public DanhSachHoSo toEscapedModel() {
		return (DanhSachHoSo)Proxy.newProxyInstance(DanhSachHoSo.class.getClassLoader(),
			new Class[] { DanhSachHoSo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhSachHoSoClp clone = new DanhSachHoSoClp();

		clone.setId(getId());
		clone.setNgayNhanHoSo(getNgayNhanHoSo());
		clone.setTenCoQuanTiepNhan(getTenCoQuanTiepNhan());
		clone.setTenThuTucHanhChinh(getTenThuTucHanhChinh());
		clone.setNgayHenTraKetQua(getNgayHenTraKetQua());
		clone.setNgayTraKetQua(getNgayTraKetQua());
		clone.setHoTenNguoiNopHoSo(getHoTenNguoiNopHoSo());
		clone.setDiaChiThuongTruNguoiNop(getDiaChiThuongTruNguoiNop());
		clone.setSoDienThoaiDiDongNguoiNop(getSoDienThoaiDiDongNguoiNop());
		clone.setNgayKetThucXuLy(getNgayKetThucXuLy());
		clone.setLoaiHoSo(getLoaiHoSo());
		clone.setMaSoBienNhan(getMaSoBienNhan());
		clone.setChuSoHuu(getChuSoHuu());
		clone.setLePhi(getLePhi());
		clone.setPhiHoSo(getPhiHoSo());
		clone.setEmailNguoiNop(getEmailNguoiNop());
		clone.setSoDienThoaiCoDinhNguoiNop(getSoDienThoaiCoDinhNguoiNop());
		clone.setNhomThuTucHanhChinhTen(getNhomThuTucHanhChinhTen());
		clone.setTrangThaiHoSoTen(getTrangThaiHoSoTen());
		clone.setRNum(getRNum());

		return clone;
	}

	public int compareTo(DanhSachHoSo danhSachHoSo) {
		long primaryKey = danhSachHoSo.getPrimaryKey();

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

		DanhSachHoSoClp danhSachHoSo = null;

		try {
			danhSachHoSo = (DanhSachHoSoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhSachHoSo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ngayNhanHoSo=");
		sb.append(getNgayNhanHoSo());
		sb.append(", tenCoQuanTiepNhan=");
		sb.append(getTenCoQuanTiepNhan());
		sb.append(", tenThuTucHanhChinh=");
		sb.append(getTenThuTucHanhChinh());
		sb.append(", ngayHenTraKetQua=");
		sb.append(getNgayHenTraKetQua());
		sb.append(", ngayTraKetQua=");
		sb.append(getNgayTraKetQua());
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(getHoTenNguoiNopHoSo());
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(getDiaChiThuongTruNguoiNop());
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(getSoDienThoaiDiDongNguoiNop());
		sb.append(", ngayKetThucXuLy=");
		sb.append(getNgayKetThucXuLy());
		sb.append(", loaiHoSo=");
		sb.append(getLoaiHoSo());
		sb.append(", maSoBienNhan=");
		sb.append(getMaSoBienNhan());
		sb.append(", chuSoHuu=");
		sb.append(getChuSoHuu());
		sb.append(", lePhi=");
		sb.append(getLePhi());
		sb.append(", phiHoSo=");
		sb.append(getPhiHoSo());
		sb.append(", emailNguoiNop=");
		sb.append(getEmailNguoiNop());
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(getSoDienThoaiCoDinhNguoiNop());
		sb.append(", nhomThuTucHanhChinhTen=");
		sb.append(getNhomThuTucHanhChinhTen());
		sb.append(", trangThaiHoSoTen=");
		sb.append(getTrangThaiHoSoTen());
		sb.append(", rNum=");
		sb.append(getRNum());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.kios.model.DanhSachHoSo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNhanHoSo</column-name><column-value><![CDATA[");
		sb.append(getNgayNhanHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenThuTucHanhChinh</column-name><column-value><![CDATA[");
		sb.append(getTenThuTucHanhChinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHenTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayHenTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenNguoiNopHoSo</column-name><column-value><![CDATA[");
		sb.append(getHoTenNguoiNopHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiDiDongNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiDiDongNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayKetThucXuLy</column-name><column-value><![CDATA[");
		sb.append(getNgayKetThucXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiHoSo</column-name><column-value><![CDATA[");
		sb.append(getLoaiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chuSoHuu</column-name><column-value><![CDATA[");
		sb.append(getChuSoHuu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lePhi</column-name><column-value><![CDATA[");
		sb.append(getLePhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phiHoSo</column-name><column-value><![CDATA[");
		sb.append(getPhiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getEmailNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiCoDinhNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiCoDinhNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nhomThuTucHanhChinhTen</column-name><column-value><![CDATA[");
		sb.append(getNhomThuTucHanhChinhTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiHoSoTen</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiHoSoTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rNum</column-name><column-value><![CDATA[");
		sb.append(getRNum());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _ngayNhanHoSo;
	private String _tenCoQuanTiepNhan;
	private String _tenThuTucHanhChinh;
	private Date _ngayHenTraKetQua;
	private Date _ngayTraKetQua;
	private String _hoTenNguoiNopHoSo;
	private String _diaChiThuongTruNguoiNop;
	private String _soDienThoaiDiDongNguoiNop;
	private Date _ngayKetThucXuLy;
	private int _loaiHoSo;
	private String _maSoBienNhan;
	private String _chuSoHuu;
	private int _lePhi;
	private int _phiHoSo;
	private String _emailNguoiNop;
	private String _soDienThoaiCoDinhNguoiNop;
	private String _nhomThuTucHanhChinhTen;
	private String _trangThaiHoSoTen;
	private int _rNum;
}