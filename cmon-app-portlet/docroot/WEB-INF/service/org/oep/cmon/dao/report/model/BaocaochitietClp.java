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

package org.oep.cmon.dao.report.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.report.service.BaocaochitietLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class BaocaochitietClp extends BaseModelImpl<Baocaochitiet>
	implements Baocaochitiet {
	public BaocaochitietClp() {
	}

	public Class<?> getModelClass() {
		return Baocaochitiet.class;
	}

	public String getModelClassName() {
		return Baocaochitiet.class.getName();
	}

	public String getPrimaryKey() {
		return _MASOHOSO;
	}

	public void setPrimaryKey(String primaryKey) {
		setMASOHOSO(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _MASOHOSO;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public long getLINHVUCID() {
		return _LINHVUCID;
	}

	public void setLINHVUCID(long LINHVUCID) {
		_LINHVUCID = LINHVUCID;
	}

	public String getMASOHOSO() {
		return _MASOHOSO;
	}

	public void setMASOHOSO(String MASOHOSO) {
		_MASOHOSO = MASOHOSO;
	}

	public String getTEN() {
		return _TEN;
	}

	public void setTEN(String TEN) {
		_TEN = TEN;
	}

	public String getTRANGTHAI() {
		return _TRANGTHAI;
	}

	public void setTRANGTHAI(String TRANGTHAI) {
		_TRANGTHAI = TRANGTHAI;
	}

	public String getDIACHIHIENNAY() {
		return _DIACHIHIENNAY;
	}

	public void setDIACHIHIENNAY(String DIACHIHIENNAY) {
		_DIACHIHIENNAY = DIACHIHIENNAY;
	}

	public String getDIENTHOAIDIDONG() {
		return _DIENTHOAIDIDONG;
	}

	public void setDIENTHOAIDIDONG(String DIENTHOAIDIDONG) {
		_DIENTHOAIDIDONG = DIENTHOAIDIDONG;
	}

	public String getHOTENNGUOINOPHOSO() {
		return _HOTENNGUOINOPHOSO;
	}

	public void setHOTENNGUOINOPHOSO(String HOTENNGUOINOPHOSO) {
		_HOTENNGUOINOPHOSO = HOTENNGUOINOPHOSO;
	}

	public String getNGUOIDAIDIENPHAPLUAT() {
		return _NGUOIDAIDIENPHAPLUAT;
	}

	public void setNGUOIDAIDIENPHAPLUAT(String NGUOIDAIDIENPHAPLUAT) {
		_NGUOIDAIDIENPHAPLUAT = NGUOIDAIDIENPHAPLUAT;
	}

	public String getNGAYNHANHOSO() {
		return _NGAYNHANHOSO;
	}

	public void setNGAYNHANHOSO(String NGAYNHANHOSO) {
		_NGAYNHANHOSO = NGAYNHANHOSO;
	}

	public String getNGAYTRAKETQUA() {
		return _NGAYTRAKETQUA;
	}

	public void setNGAYTRAKETQUA(String NGAYTRAKETQUA) {
		_NGAYTRAKETQUA = NGAYTRAKETQUA;
	}

	public String getNGAYHENTRAKETQUA() {
		return _NGAYHENTRAKETQUA;
	}

	public void setNGAYHENTRAKETQUA(String NGAYHENTRAKETQUA) {
		_NGAYHENTRAKETQUA = NGAYHENTRAKETQUA;
	}

	public String getLINHVUC() {
		return _LINHVUC;
	}

	public void setLINHVUC(String LINHVUC) {
		_LINHVUC = LINHVUC;
	}

	public String getGHICHU() {
		return _GHICHU;
	}

	public void setGHICHU(String GHICHU) {
		_GHICHU = GHICHU;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BaocaochitietLocalServiceUtil.addBaocaochitiet(this);
		}
		else {
			BaocaochitietLocalServiceUtil.updateBaocaochitiet(this);
		}
	}

	@Override
	public Baocaochitiet toEscapedModel() {
		return (Baocaochitiet)Proxy.newProxyInstance(Baocaochitiet.class.getClassLoader(),
			new Class[] { Baocaochitiet.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BaocaochitietClp clone = new BaocaochitietClp();

		clone.setLINHVUCID(getLINHVUCID());
		clone.setMASOHOSO(getMASOHOSO());
		clone.setTEN(getTEN());
		clone.setTRANGTHAI(getTRANGTHAI());
		clone.setDIACHIHIENNAY(getDIACHIHIENNAY());
		clone.setDIENTHOAIDIDONG(getDIENTHOAIDIDONG());
		clone.setHOTENNGUOINOPHOSO(getHOTENNGUOINOPHOSO());
		clone.setNGUOIDAIDIENPHAPLUAT(getNGUOIDAIDIENPHAPLUAT());
		clone.setNGAYNHANHOSO(getNGAYNHANHOSO());
		clone.setNGAYTRAKETQUA(getNGAYTRAKETQUA());
		clone.setNGAYHENTRAKETQUA(getNGAYHENTRAKETQUA());
		clone.setLINHVUC(getLINHVUC());
		clone.setGHICHU(getGHICHU());

		return clone;
	}

	public int compareTo(Baocaochitiet baocaochitiet) {
		String primaryKey = baocaochitiet.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BaocaochitietClp baocaochitiet = null;

		try {
			baocaochitiet = (BaocaochitietClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = baocaochitiet.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{LINHVUCID=");
		sb.append(getLINHVUCID());
		sb.append(", MASOHOSO=");
		sb.append(getMASOHOSO());
		sb.append(", TEN=");
		sb.append(getTEN());
		sb.append(", TRANGTHAI=");
		sb.append(getTRANGTHAI());
		sb.append(", DIACHIHIENNAY=");
		sb.append(getDIACHIHIENNAY());
		sb.append(", DIENTHOAIDIDONG=");
		sb.append(getDIENTHOAIDIDONG());
		sb.append(", HOTENNGUOINOPHOSO=");
		sb.append(getHOTENNGUOINOPHOSO());
		sb.append(", NGUOIDAIDIENPHAPLUAT=");
		sb.append(getNGUOIDAIDIENPHAPLUAT());
		sb.append(", NGAYNHANHOSO=");
		sb.append(getNGAYNHANHOSO());
		sb.append(", NGAYTRAKETQUA=");
		sb.append(getNGAYTRAKETQUA());
		sb.append(", NGAYHENTRAKETQUA=");
		sb.append(getNGAYHENTRAKETQUA());
		sb.append(", LINHVUC=");
		sb.append(getLINHVUC());
		sb.append(", GHICHU=");
		sb.append(getGHICHU());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.Baocaochitiet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LINHVUCID</column-name><column-value><![CDATA[");
		sb.append(getLINHVUCID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MASOHOSO</column-name><column-value><![CDATA[");
		sb.append(getMASOHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TEN</column-name><column-value><![CDATA[");
		sb.append(getTEN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TRANGTHAI</column-name><column-value><![CDATA[");
		sb.append(getTRANGTHAI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DIACHIHIENNAY</column-name><column-value><![CDATA[");
		sb.append(getDIACHIHIENNAY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DIENTHOAIDIDONG</column-name><column-value><![CDATA[");
		sb.append(getDIENTHOAIDIDONG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HOTENNGUOINOPHOSO</column-name><column-value><![CDATA[");
		sb.append(getHOTENNGUOINOPHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NGUOIDAIDIENPHAPLUAT</column-name><column-value><![CDATA[");
		sb.append(getNGUOIDAIDIENPHAPLUAT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NGAYNHANHOSO</column-name><column-value><![CDATA[");
		sb.append(getNGAYNHANHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NGAYTRAKETQUA</column-name><column-value><![CDATA[");
		sb.append(getNGAYTRAKETQUA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NGAYHENTRAKETQUA</column-name><column-value><![CDATA[");
		sb.append(getNGAYHENTRAKETQUA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LINHVUC</column-name><column-value><![CDATA[");
		sb.append(getLINHVUC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GHICHU</column-name><column-value><![CDATA[");
		sb.append(getGHICHU());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _LINHVUCID;
	private String _MASOHOSO;
	private String _TEN;
	private String _TRANGTHAI;
	private String _DIACHIHIENNAY;
	private String _DIENTHOAIDIDONG;
	private String _HOTENNGUOINOPHOSO;
	private String _NGUOIDAIDIENPHAPLUAT;
	private String _NGAYNHANHOSO;
	private String _NGAYTRAKETQUA;
	private String _NGAYHENTRAKETQUA;
	private String _LINHVUC;
	private String _GHICHU;
}