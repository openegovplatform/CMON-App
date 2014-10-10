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

package org.oep.dlms.dao.chitietgplx.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;


import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

import org.oep.dlms.dao.chitietgplx.service.ChiTietGPLXLocalServiceUtil;

/**
 * @author hunghq
 */
public class ChiTietGPLXClp extends BaseModelImpl<ChiTietGPLX>
	implements ChiTietGPLX {
	public ChiTietGPLXClp() {
	}

	public Class<?> getModelClass() {
		return ChiTietGPLX.class;
	}

	public String getModelClassName() {
		return ChiTietGPLX.class.getName();
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

	public long getIdGPLX() {
		return _idGPLX;
	}

	public void setIdGPLX(long idGPLX) {
		_idGPLX = idGPLX;
	}

	public String getSoGPLX() {
		return _soGPLX;
	}

	public void setSoGPLX(String soGPLX) {
		_soGPLX = soGPLX;
	}

	public long getIdHangGPLX() {
		return _idHangGPLX;
	}

	public void setIdHangGPLX(long idHangGPLX) {
		_idHangGPLX = idHangGPLX;
	}

	public long getIdNoiCapGPLX() {
		return _idNoiCapGPLX;
	}

	public void setIdNoiCapGPLX(long idNoiCapGPLX) {
		_idNoiCapGPLX = idNoiCapGPLX;
	}

	public long getIdNoiCapGPLXNuocNgoai() {
		return _idNoiCapGPLXNuocNgoai;
	}

	public void setIdNoiCapGPLXNuocNgoai(long idNoiCapGPLXNuocNgoai) {
		_idNoiCapGPLXNuocNgoai = idNoiCapGPLXNuocNgoai;
	}

	public Date getNgayCapGPLX() {
		return _ngayCapGPLX;
	}

	public void setNgayCapGPLX(Date ngayCapGPLX) {
		_ngayCapGPLX = ngayCapGPLX;
	}

	public Date getNgayTrungTuyen() {
		return _ngayTrungTuyen;
	}

	public void setNgayTrungTuyen(Date ngayTrungTuyen) {
		_ngayTrungTuyen = ngayTrungTuyen;
	}

	public Date getNgayHetHan() {
		return _ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		_ngayHetHan = ngayHetHan;
	}

	public long getIdNoiHocLaiXe() {
		return _idNoiHocLaiXe;
	}

	public void setIdNoiHocLaiXe(long idNoiHocLaiXe) {
		_idNoiHocLaiXe = idNoiHocLaiXe;
	}

	public long getIdNoiHocLaiXeNuocNgoai() {
		return _idNoiHocLaiXeNuocNgoai;
	}

	public void setIdNoiHocLaiXeNuocNgoai(long idNoiHocLaiXeNuocNgoai) {
		_idNoiHocLaiXeNuocNgoai = idNoiHocLaiXeNuocNgoai;
	}

	public long getNamHocLaiXe() {
		return _namHocLaiXe;
	}

	public void setNamHocLaiXe(long namHocLaiXe) {
		_namHocLaiXe = namHocLaiXe;
	}

	public String getNoiHocLaiXeNuocNgoai() {
		return _noiHocLaiXeNuocNgoai;
	}

	public void setNoiHocLaiXeNuocNgoai(String noiHocLaiXeNuocNgoai) {
		_noiHocLaiXeNuocNgoai = noiHocLaiXeNuocNgoai;
	}

	public String getNoiHocLaiXe() {
		return _noiHocLaiXe;
	}

	public void setNoiHocLaiXe(String noiHocLaiXe) {
		_noiHocLaiXe = noiHocLaiXe;
	}

	public String getNoiCapGPLXNuocNgoai() {
		return _noiCapGPLXNuocNgoai;
	}

	public void setNoiCapGPLXNuocNgoai(String noiCapGPLXNuocNgoai) {
		_noiCapGPLXNuocNgoai = noiCapGPLXNuocNgoai;
	}

	public String getNoiCapGPLX() {
		return _noiCapGPLX;
	}

	public void setNoiCapGPLX(String noiCapGPLX) {
		_noiCapGPLX = noiCapGPLX;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ChiTietGPLXLocalServiceUtil.addChiTietGPLX(this);
		}
		else {
			ChiTietGPLXLocalServiceUtil.updateChiTietGPLX(this);
		}
	}

	@Override
	public ChiTietGPLX toEscapedModel() {
		return (ChiTietGPLX)Proxy.newProxyInstance(ChiTietGPLX.class.getClassLoader(),
			new Class[] { ChiTietGPLX.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChiTietGPLXClp clone = new ChiTietGPLXClp();

		clone.setId(getId());
		clone.setIdGPLX(getIdGPLX());
		clone.setSoGPLX(getSoGPLX());
		clone.setIdHangGPLX(getIdHangGPLX());
		clone.setIdNoiCapGPLX(getIdNoiCapGPLX());
		clone.setIdNoiCapGPLXNuocNgoai(getIdNoiCapGPLXNuocNgoai());
		clone.setNgayCapGPLX(getNgayCapGPLX());
		clone.setNgayTrungTuyen(getNgayTrungTuyen());
		clone.setNgayHetHan(getNgayHetHan());
		clone.setIdNoiHocLaiXe(getIdNoiHocLaiXe());
		clone.setIdNoiHocLaiXeNuocNgoai(getIdNoiHocLaiXeNuocNgoai());
		clone.setNamHocLaiXe(getNamHocLaiXe());
		clone.setNoiHocLaiXeNuocNgoai(getNoiHocLaiXeNuocNgoai());
		clone.setNoiHocLaiXe(getNoiHocLaiXe());
		clone.setNoiCapGPLXNuocNgoai(getNoiCapGPLXNuocNgoai());
		clone.setNoiCapGPLX(getNoiCapGPLX());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());

		return clone;
	}

	public int compareTo(ChiTietGPLX chiTietGPLX) {
		long primaryKey = chiTietGPLX.getPrimaryKey();

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

		ChiTietGPLXClp chiTietGPLX = null;

		try {
			chiTietGPLX = (ChiTietGPLXClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = chiTietGPLX.getPrimaryKey();

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
		sb.append(", idGPLX=");
		sb.append(getIdGPLX());
		sb.append(", soGPLX=");
		sb.append(getSoGPLX());
		sb.append(", idHangGPLX=");
		sb.append(getIdHangGPLX());
		sb.append(", idNoiCapGPLX=");
		sb.append(getIdNoiCapGPLX());
		sb.append(", idNoiCapGPLXNuocNgoai=");
		sb.append(getIdNoiCapGPLXNuocNgoai());
		sb.append(", ngayCapGPLX=");
		sb.append(getNgayCapGPLX());
		sb.append(", ngayTrungTuyen=");
		sb.append(getNgayTrungTuyen());
		sb.append(", ngayHetHan=");
		sb.append(getNgayHetHan());
		sb.append(", idNoiHocLaiXe=");
		sb.append(getIdNoiHocLaiXe());
		sb.append(", idNoiHocLaiXeNuocNgoai=");
		sb.append(getIdNoiHocLaiXeNuocNgoai());
		sb.append(", namHocLaiXe=");
		sb.append(getNamHocLaiXe());
		sb.append(", noiHocLaiXeNuocNgoai=");
		sb.append(getNoiHocLaiXeNuocNgoai());
		sb.append(", noiHocLaiXe=");
		sb.append(getNoiHocLaiXe());
		sb.append(", noiCapGPLXNuocNgoai=");
		sb.append(getNoiCapGPLXNuocNgoai());
		sb.append(", noiCapGPLX=");
		sb.append(getNoiCapGPLX());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.dlms.dao.chitietgplx.model.ChiTietGPLX");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idGPLX</column-name><column-value><![CDATA[");
		sb.append(getIdGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soGPLX</column-name><column-value><![CDATA[");
		sb.append(getSoGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idHangGPLX</column-name><column-value><![CDATA[");
		sb.append(getIdHangGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiCapGPLX</column-name><column-value><![CDATA[");
		sb.append(getIdNoiCapGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiCapGPLXNuocNgoai</column-name><column-value><![CDATA[");
		sb.append(getIdNoiCapGPLXNuocNgoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCapGPLX</column-name><column-value><![CDATA[");
		sb.append(getNgayCapGPLX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTrungTuyen</column-name><column-value><![CDATA[");
		sb.append(getNgayTrungTuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHetHan</column-name><column-value><![CDATA[");
		sb.append(getNgayHetHan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiHocLaiXe</column-name><column-value><![CDATA[");
		sb.append(getIdNoiHocLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNoiHocLaiXeNuocNgoai</column-name><column-value><![CDATA[");
		sb.append(getIdNoiHocLaiXeNuocNgoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>namHocLaiXe</column-name><column-value><![CDATA[");
		sb.append(getNamHocLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiHocLaiXeNuocNgoai</column-name><column-value><![CDATA[");
		sb.append(getNoiHocLaiXeNuocNgoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiHocLaiXe</column-name><column-value><![CDATA[");
		sb.append(getNoiHocLaiXe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapGPLXNuocNgoai</column-name><column-value><![CDATA[");
		sb.append(getNoiCapGPLXNuocNgoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiCapGPLX</column-name><column-value><![CDATA[");
		sb.append(getNoiCapGPLX());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _idGPLX;
	private String _soGPLX;
	private long _idHangGPLX;
	private long _idNoiCapGPLX;
	private long _idNoiCapGPLXNuocNgoai;
	private Date _ngayCapGPLX;
	private Date _ngayTrungTuyen;
	private Date _ngayHetHan;
	private long _idNoiHocLaiXe;
	private long _idNoiHocLaiXeNuocNgoai;
	private long _namHocLaiXe;
	private String _noiHocLaiXeNuocNgoai;
	private String _noiHocLaiXe;
	private String _noiCapGPLXNuocNgoai;
	private String _noiCapGPLX;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
}