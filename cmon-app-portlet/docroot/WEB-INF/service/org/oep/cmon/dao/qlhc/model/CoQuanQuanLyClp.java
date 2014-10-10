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

package org.oep.cmon.dao.qlhc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class CoQuanQuanLyClp extends BaseModelImpl<CoQuanQuanLy>
	implements CoQuanQuanLy {
	public CoQuanQuanLyClp() {
	}

	public Class<?> getModelClass() {
		return CoQuanQuanLy.class;
	}

	public String getModelClassName() {
		return CoQuanQuanLy.class.getName();
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

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public int getNoiBo() {
		return _noiBo;
	}

	public void setNoiBo(int noiBo) {
		_noiBo = noiBo;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Long getDonViHanhChinhId() {
		return _donViHanhChinhId;
	}

	public void setDonViHanhChinhId(Long donViHanhChinhId) {
		_donViHanhChinhId = donViHanhChinhId;
	}

	public Long getCapCoQuanQuanlyId() {
		return _capCoQuanQuanlyId;
	}

	public void setCapCoQuanQuanlyId(Long capCoQuanQuanlyId) {
		_capCoQuanQuanlyId = capCoQuanQuanlyId;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getMerchant() {
		return _merchant;
	}

	public void setMerchant(String merchant) {
		_merchant = merchant;
	}

	public String getAccessCode() {
		return _accessCode;
	}

	public void setAccessCode(String accessCode) {
		_accessCode = accessCode;
	}

	public String getSecureSecret() {
		return _secureSecret;
	}

	public void setSecureSecret(String secureSecret) {
		_secureSecret = secureSecret;
	}

	public String getMaCapSoBienNhan() {
		return _maCapSoBienNhan;
	}

	public void setMaCapSoBienNhan(String maCapSoBienNhan) {
		_maCapSoBienNhan = maCapSoBienNhan;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CoQuanQuanLyLocalServiceUtil.addCoQuanQuanLy(this);
		}
		else {
			CoQuanQuanLyLocalServiceUtil.updateCoQuanQuanLy(this);
		}
	}

	@Override
	public CoQuanQuanLy toEscapedModel() {
		return (CoQuanQuanLy)Proxy.newProxyInstance(CoQuanQuanLy.class.getClassLoader(),
			new Class[] { CoQuanQuanLy.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CoQuanQuanLyClp clone = new CoQuanQuanLyClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setDiaChi(getDiaChi());
		clone.setDienThoai(getDienThoai());
		clone.setEmail(getEmail());
		clone.setFax(getFax());
		clone.setWebsite(getWebsite());
		clone.setNoiBo(getNoiBo());
		clone.setPhienBan(getPhienBan());
		clone.setDaXoa(getDaXoa());
		clone.setDonViHanhChinhId(getDonViHanhChinhId());
		clone.setCapCoQuanQuanlyId(getCapCoQuanQuanlyId());
		clone.setChaId(getChaId());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setMerchant(getMerchant());
		clone.setAccessCode(getAccessCode());
		clone.setSecureSecret(getSecureSecret());
		clone.setMaCapSoBienNhan(getMaCapSoBienNhan());

		return clone;
	}

	public int compareTo(CoQuanQuanLy coQuanQuanLy) {
		int value = 0;

		if (getId() < coQuanQuanLy.getId()) {
			value = -1;
		}
		else if (getId() > coQuanQuanLy.getId()) {
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

		CoQuanQuanLyClp coQuanQuanLy = null;

		try {
			coQuanQuanLy = (CoQuanQuanLyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = coQuanQuanLy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", diaChi=");
		sb.append(getDiaChi());
		sb.append(", dienThoai=");
		sb.append(getDienThoai());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", noiBo=");
		sb.append(getNoiBo());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", donViHanhChinhId=");
		sb.append(getDonViHanhChinhId());
		sb.append(", capCoQuanQuanlyId=");
		sb.append(getCapCoQuanQuanlyId());
		sb.append(", chaId=");
		sb.append(getChaId());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", merchant=");
		sb.append(getMerchant());
		sb.append(", accessCode=");
		sb.append(getAccessCode());
		sb.append(", secureSecret=");
		sb.append(getSecureSecret());
		sb.append(", maCapSoBienNhan=");
		sb.append(getMaCapSoBienNhan());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.qlhc.model.CoQuanQuanLy");
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
			"<column><column-name>diaChi</column-name><column-value><![CDATA[");
		sb.append(getDiaChi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoai</column-name><column-value><![CDATA[");
		sb.append(getDienThoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiBo</column-name><column-value><![CDATA[");
		sb.append(getNoiBo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienBan</column-name><column-value><![CDATA[");
		sb.append(getPhienBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>donViHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getDonViHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capCoQuanQuanlyId</column-name><column-value><![CDATA[");
		sb.append(getCapCoQuanQuanlyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chaId</column-name><column-value><![CDATA[");
		sb.append(getChaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>merchant</column-name><column-value><![CDATA[");
		sb.append(getMerchant());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessCode</column-name><column-value><![CDATA[");
		sb.append(getAccessCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secureSecret</column-name><column-value><![CDATA[");
		sb.append(getSecureSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maCapSoBienNhan</column-name><column-value><![CDATA[");
		sb.append(getMaCapSoBienNhan());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _diaChi;
	private String _dienThoai;
	private String _email;
	private String _fax;
	private String _website;
	private int _noiBo;
	private long _phienBan;
	private int _daXoa;
	private Long _donViHanhChinhId;
	private Long _capCoQuanQuanlyId;
	private Long _chaId;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private String _merchant;
	private String _accessCode;
	private String _secureSecret;
	private String _maCapSoBienNhan;
}