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

import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Liemnn
 */
public class TaiLieuChungThucClp extends BaseModelImpl<TaiLieuChungThuc>
	implements TaiLieuChungThuc {
	public TaiLieuChungThucClp() {
	}

	public Class<?> getModelClass() {
		return TaiLieuChungThuc.class;
	}

	public String getModelClassName() {
		return TaiLieuChungThuc.class.getName();
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public Date getNgayUpload() {
		return _ngayUpload;
	}

	public void setNgayUpload(Date ngayUpload) {
		_ngayUpload = ngayUpload;
	}

	public int getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(int phienBan) {
		_phienBan = phienBan;
	}

	public Date getNgayDuyet() {
		return _ngayDuyet;
	}

	public void setNgayDuyet(Date ngayDuyet) {
		_ngayDuyet = ngayDuyet;
	}

	public Date getHieuLucTuNgay() {
		return _hieuLucTuNgay;
	}

	public void setHieuLucTuNgay(Date hieuLucTuNgay) {
		_hieuLucTuNgay = hieuLucTuNgay;
	}

	public Date getHieuLucDenNgay() {
		return _hieuLucDenNgay;
	}

	public void setHieuLucDenNgay(Date hieuLucDenNgay) {
		_hieuLucDenNgay = hieuLucDenNgay;
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

	public Long getDanhMucGiayToId() {
		return _danhMucGiayToId;
	}

	public void setDanhMucGiayToId(Long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getChuSohuuId() {
		return _chuSohuuId;
	}

	public void setChuSohuuId(Long chuSohuuId) {
		_chuSohuuId = chuSohuuId;
	}

	public Long getNguoiUploadId() {
		return _nguoiUploadId;
	}

	public void setNguoiUploadId(Long nguoiUploadId) {
		_nguoiUploadId = nguoiUploadId;
	}

	public Long getNguoiduyetId() {
		return _nguoiduyetId;
	}

	public void setNguoiduyetId(Long nguoiduyetId) {
		_nguoiduyetId = nguoiduyetId;
	}

	public Long getHoSoTTHCCId() {
		return _hoSoTTHCCId;
	}

	public void setHoSoTTHCCId(Long hoSoTTHCCId) {
		_hoSoTTHCCId = hoSoTTHCCId;
	}

	public String getMaUngDung() {
		return _maUngDung;
	}

	public void setMaUngDung(String maUngDung) {
		_maUngDung = maUngDung;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaiLieuChungThucLocalServiceUtil.addTaiLieuChungThuc(this);
		}
		else {
			TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(this);
		}
	}

	@Override
	public TaiLieuChungThuc toEscapedModel() {
		return (TaiLieuChungThuc)Proxy.newProxyInstance(TaiLieuChungThuc.class.getClassLoader(),
			new Class[] { TaiLieuChungThuc.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaiLieuChungThucClp clone = new TaiLieuChungThucClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setGhiChu(getGhiChu());
		clone.setNoiLuuTruId(getNoiLuuTruId());
		clone.setNgayUpload(getNgayUpload());
		clone.setPhienBan(getPhienBan());
		clone.setNgayDuyet(getNgayDuyet());
		clone.setHieuLucTuNgay(getHieuLucTuNgay());
		clone.setHieuLucDenNgay(getHieuLucDenNgay());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setDanhMucGiayToId(getDanhMucGiayToId());
		clone.setTrangThai(getTrangThai());
		clone.setChuSohuuId(getChuSohuuId());
		clone.setNguoiUploadId(getNguoiUploadId());
		clone.setNguoiduyetId(getNguoiduyetId());
		clone.setHoSoTTHCCId(getHoSoTTHCCId());
		clone.setMaUngDung(getMaUngDung());
		clone.setLoai(getLoai());

		return clone;
	}

	public int compareTo(TaiLieuChungThuc taiLieuChungThuc) {
		int value = 0;

		if (getPhienBan() < taiLieuChungThuc.getPhienBan()) {
			value = -1;
		}
		else if (getPhienBan() > taiLieuChungThuc.getPhienBan()) {
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

		TaiLieuChungThucClp taiLieuChungThuc = null;

		try {
			taiLieuChungThuc = (TaiLieuChungThucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taiLieuChungThuc.getPrimaryKey();

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
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", noiLuuTruId=");
		sb.append(getNoiLuuTruId());
		sb.append(", ngayUpload=");
		sb.append(getNgayUpload());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append(", ngayDuyet=");
		sb.append(getNgayDuyet());
		sb.append(", hieuLucTuNgay=");
		sb.append(getHieuLucTuNgay());
		sb.append(", hieuLucDenNgay=");
		sb.append(getHieuLucDenNgay());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", danhMucGiayToId=");
		sb.append(getDanhMucGiayToId());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", chuSohuuId=");
		sb.append(getChuSohuuId());
		sb.append(", nguoiUploadId=");
		sb.append(getNguoiUploadId());
		sb.append(", nguoiduyetId=");
		sb.append(getNguoiduyetId());
		sb.append(", hoSoTTHCCId=");
		sb.append(getHoSoTTHCCId());
		sb.append(", maUngDung=");
		sb.append(getMaUngDung());
		sb.append(", loai=");
		sb.append(getLoai());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.tlct.model.TaiLieuChungThuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayUpload</column-name><column-value><![CDATA[");
		sb.append(getNgayUpload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienBan</column-name><column-value><![CDATA[");
		sb.append(getPhienBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDuyet</column-name><column-value><![CDATA[");
		sb.append(getNgayDuyet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hieuLucTuNgay</column-name><column-value><![CDATA[");
		sb.append(getHieuLucTuNgay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hieuLucDenNgay</column-name><column-value><![CDATA[");
		sb.append(getHieuLucDenNgay());
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
			"<column><column-name>danhMucGiayToId</column-name><column-value><![CDATA[");
		sb.append(getDanhMucGiayToId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chuSohuuId</column-name><column-value><![CDATA[");
		sb.append(getChuSohuuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiUploadId</column-name><column-value><![CDATA[");
		sb.append(getNguoiUploadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiduyetId</column-name><column-value><![CDATA[");
		sb.append(getNguoiduyetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoTTHCCId</column-name><column-value><![CDATA[");
		sb.append(getHoSoTTHCCId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maUngDung</column-name><column-value><![CDATA[");
		sb.append(getMaUngDung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loai</column-name><column-value><![CDATA[");
		sb.append(getLoai());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private String _ghiChu;
	private long _noiLuuTruId;
	private Date _ngayUpload;
	private int _phienBan;
	private Date _ngayDuyet;
	private Date _hieuLucTuNgay;
	private Date _hieuLucDenNgay;
	private Date _ngaySua;
	private String _nguoiSua;
	private Long _danhMucGiayToId;
	private int _trangThai;
	private Long _chuSohuuId;
	private Long _nguoiUploadId;
	private Long _nguoiduyetId;
	private Long _hoSoTTHCCId;
	private String _maUngDung;
	private int _loai;
}