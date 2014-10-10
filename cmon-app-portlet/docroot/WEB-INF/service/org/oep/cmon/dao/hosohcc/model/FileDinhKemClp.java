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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNn
 */
public class FileDinhKemClp extends BaseModelImpl<FileDinhKem>
	implements FileDinhKem {
	public FileDinhKemClp() {
	}

	public Class<?> getModelClass() {
		return FileDinhKem.class;
	}

	public String getModelClassName() {
		return FileDinhKem.class.getName();
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

	public long getSoBanGiay() {
		return _soBanGiay;
	}

	public void setSoBanGiay(long soBanGiay) {
		_soBanGiay = soBanGiay;
	}

	public int getDaDoiChieu() {
		return _daDoiChieu;
	}

	public void setDaDoiChieu(int daDoiChieu) {
		_daDoiChieu = daDoiChieu;
	}

	public int getTrangThaiHoSoTaiThoiDiemDinhKem() {
		return _trangThaiHoSoTaiThoiDiemDinhKem;
	}

	public void setTrangThaiHoSoTaiThoiDiemDinhKem(
		int trangThaiHoSoTaiThoiDiemDinhKem) {
		_trangThaiHoSoTaiThoiDiemDinhKem = trangThaiHoSoTaiThoiDiemDinhKem;
	}

	public Long getNoiLuuTruTaiLieuId() {
		return _noiLuuTruTaiLieuId;
	}

	public void setNoiLuuTruTaiLieuId(Long noiLuuTruTaiLieuId) {
		_noiLuuTruTaiLieuId = noiLuuTruTaiLieuId;
	}

	public Long getCanBoId() {
		return _canBoId;
	}

	public void setCanBoId(Long canBoId) {
		_canBoId = canBoId;
	}

	public Long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(Long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Long getThuTuc2GiayToId() {
		return _thuTuc2GiayToId;
	}

	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		_thuTuc2GiayToId = thuTuc2GiayToId;
	}

	public Long getDanhMucGiayToId() {
		return _danhMucGiayToId;
	}

	public void setDanhMucGiayToId(Long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public Date getNgayUpload() {
		return _ngayUpload;
	}

	public void setNgayUpload(Date ngayUpload) {
		_ngayUpload = ngayUpload;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiUpload() {
		return _nguoiUpload;
	}

	public void setNguoiUpload(String nguoiUpload) {
		_nguoiUpload = nguoiUpload;
	}

	public String getMaLoaiTaiLieuDuocThayThe() {
		return _maLoaiTaiLieuDuocThayThe;
	}

	public void setMaLoaiTaiLieuDuocThayThe(String maLoaiTaiLieuDuocThayThe) {
		_maLoaiTaiLieuDuocThayThe = maLoaiTaiLieuDuocThayThe;
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

	public int getDaTra() {
		return _daTra;
	}

	public void setDaTra(int daTra) {
		_daTra = daTra;
	}

	public long getBanChinh() {
		return _banChinh;
	}

	public void setBanChinh(long banChinh) {
		_banChinh = banChinh;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FileDinhKemLocalServiceUtil.addFileDinhKem(this);
		}
		else {
			FileDinhKemLocalServiceUtil.updateFileDinhKem(this);
		}
	}

	@Override
	public FileDinhKem toEscapedModel() {
		return (FileDinhKem)Proxy.newProxyInstance(FileDinhKem.class.getClassLoader(),
			new Class[] { FileDinhKem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FileDinhKemClp clone = new FileDinhKemClp();

		clone.setId(getId());
		clone.setSoBanGiay(getSoBanGiay());
		clone.setDaDoiChieu(getDaDoiChieu());
		clone.setTrangThaiHoSoTaiThoiDiemDinhKem(getTrangThaiHoSoTaiThoiDiemDinhKem());
		clone.setNoiLuuTruTaiLieuId(getNoiLuuTruTaiLieuId());
		clone.setCanBoId(getCanBoId());
		clone.setHoSoTTHCCongId(getHoSoTTHCCongId());
		clone.setThuTuc2GiayToId(getThuTuc2GiayToId());
		clone.setDanhMucGiayToId(getDanhMucGiayToId());
		clone.setNgayUpload(getNgayUpload());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiUpload(getNguoiUpload());
		clone.setMaLoaiTaiLieuDuocThayThe(getMaLoaiTaiLieuDuocThayThe());
		clone.setNguoiSua(getNguoiSua());
		clone.setXoa(getXoa());
		clone.setDaTra(getDaTra());
		clone.setBanChinh(getBanChinh());
		clone.setGhiChu(getGhiChu());

		return clone;
	}

	public int compareTo(FileDinhKem fileDinhKem) {
		int value = 0;

		if (getId() < fileDinhKem.getId()) {
			value = -1;
		}
		else if (getId() > fileDinhKem.getId()) {
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

		FileDinhKemClp fileDinhKem = null;

		try {
			fileDinhKem = (FileDinhKemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = fileDinhKem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", soBanGiay=");
		sb.append(getSoBanGiay());
		sb.append(", daDoiChieu=");
		sb.append(getDaDoiChieu());
		sb.append(", trangThaiHoSoTaiThoiDiemDinhKem=");
		sb.append(getTrangThaiHoSoTaiThoiDiemDinhKem());
		sb.append(", noiLuuTruTaiLieuId=");
		sb.append(getNoiLuuTruTaiLieuId());
		sb.append(", canBoId=");
		sb.append(getCanBoId());
		sb.append(", hoSoTTHCCongId=");
		sb.append(getHoSoTTHCCongId());
		sb.append(", thuTuc2GiayToId=");
		sb.append(getThuTuc2GiayToId());
		sb.append(", danhMucGiayToId=");
		sb.append(getDanhMucGiayToId());
		sb.append(", ngayUpload=");
		sb.append(getNgayUpload());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiUpload=");
		sb.append(getNguoiUpload());
		sb.append(", maLoaiTaiLieuDuocThayThe=");
		sb.append(getMaLoaiTaiLieuDuocThayThe());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", xoa=");
		sb.append(getXoa());
		sb.append(", daTra=");
		sb.append(getDaTra());
		sb.append(", banChinh=");
		sb.append(getBanChinh());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.hosohcc.model.FileDinhKem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soBanGiay</column-name><column-value><![CDATA[");
		sb.append(getSoBanGiay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daDoiChieu</column-name><column-value><![CDATA[");
		sb.append(getDaDoiChieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiHoSoTaiThoiDiemDinhKem</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiHoSoTaiThoiDiemDinhKem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruTaiLieuId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruTaiLieuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoId</column-name><column-value><![CDATA[");
		sb.append(getCanBoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoTTHCCongId</column-name><column-value><![CDATA[");
		sb.append(getHoSoTTHCCongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTuc2GiayToId</column-name><column-value><![CDATA[");
		sb.append(getThuTuc2GiayToId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>danhMucGiayToId</column-name><column-value><![CDATA[");
		sb.append(getDanhMucGiayToId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayUpload</column-name><column-value><![CDATA[");
		sb.append(getNgayUpload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiUpload</column-name><column-value><![CDATA[");
		sb.append(getNguoiUpload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maLoaiTaiLieuDuocThayThe</column-name><column-value><![CDATA[");
		sb.append(getMaLoaiTaiLieuDuocThayThe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xoa</column-name><column-value><![CDATA[");
		sb.append(getXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daTra</column-name><column-value><![CDATA[");
		sb.append(getDaTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>banChinh</column-name><column-value><![CDATA[");
		sb.append(getBanChinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _soBanGiay;
	private int _daDoiChieu;
	private int _trangThaiHoSoTaiThoiDiemDinhKem;
	private Long _noiLuuTruTaiLieuId;
	private Long _canBoId;
	private Long _hoSoTTHCCongId;
	private Long _thuTuc2GiayToId;
	private Long _danhMucGiayToId;
	private Date _ngayUpload;
	private Date _ngaySua;
	private String _nguoiUpload;
	private String _maLoaiTaiLieuDuocThayThe;
	private String _nguoiSua;
	private int _xoa;
	private int _daTra;
	private long _banChinh;
	private String _ghiChu;
}