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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author liemnn
 */
public class VanBanHuongDanClp extends BaseModelImpl<VanBanHuongDan>
	implements VanBanHuongDan {
	public VanBanHuongDanClp() {
	}

	public Class<?> getModelClass() {
		return VanBanHuongDan.class;
	}

	public String getModelClassName() {
		return VanBanHuongDan.class.getName();
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

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public String getTenTaiLieu() {
		return _tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		_tenTaiLieu = tenTaiLieu;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public long getLoaiTaiLieu() {
		return _loaiTaiLieu;
	}

	public void setLoaiTaiLieu(long loaiTaiLieu) {
		_loaiTaiLieu = loaiTaiLieu;
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

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VanBanHuongDanLocalServiceUtil.addVanBanHuongDan(this);
		}
		else {
			VanBanHuongDanLocalServiceUtil.updateVanBanHuongDan(this);
		}
	}

	@Override
	public VanBanHuongDan toEscapedModel() {
		return (VanBanHuongDan)Proxy.newProxyInstance(VanBanHuongDan.class.getClassLoader(),
			new Class[] { VanBanHuongDan.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VanBanHuongDanClp clone = new VanBanHuongDanClp();

		clone.setId(getId());
		clone.setNoiLuuTruId(getNoiLuuTruId());
		clone.setTenTaiLieu(getTenTaiLieu());
		clone.setMoTa(getMoTa());
		clone.setLoaiTaiLieu(getLoaiTaiLieu());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());

		return clone;
	}

	public int compareTo(VanBanHuongDan vanBanHuongDan) {
		int value = 0;

		if (getId() < vanBanHuongDan.getId()) {
			value = -1;
		}
		else if (getId() > vanBanHuongDan.getId()) {
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

		VanBanHuongDanClp vanBanHuongDan = null;

		try {
			vanBanHuongDan = (VanBanHuongDanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vanBanHuongDan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", noiLuuTruId=");
		sb.append(getNoiLuuTruId());
		sb.append(", tenTaiLieu=");
		sb.append(getTenTaiLieu());
		sb.append(", moTa=");
		sb.append(getMoTa());
		sb.append(", loaiTaiLieu=");
		sb.append(getLoaiTaiLieu());
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
		sb.append(", thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.VanBanHuongDan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiLuuTruId</column-name><column-value><![CDATA[");
		sb.append(getNoiLuuTruId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenTaiLieu</column-name><column-value><![CDATA[");
		sb.append(getTenTaiLieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTa</column-name><column-value><![CDATA[");
		sb.append(getMoTa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiTaiLieu</column-name><column-value><![CDATA[");
		sb.append(getLoaiTaiLieu());
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
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _noiLuuTruId;
	private String _tenTaiLieu;
	private String _moTa;
	private long _loaiTaiLieu;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _thuTucHanhChinhId;
}