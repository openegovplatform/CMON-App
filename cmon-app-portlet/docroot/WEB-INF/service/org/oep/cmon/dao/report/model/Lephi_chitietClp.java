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

import org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class Lephi_chitietClp extends BaseModelImpl<Lephi_chitiet>
	implements Lephi_chitiet {
	public Lephi_chitietClp() {
	}

	public Class<?> getModelClass() {
		return Lephi_chitiet.class;
	}

	public String getModelClassName() {
		return Lephi_chitiet.class.getName();
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long primaryKey) {
		setID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public String getTENHOSO() {
		return _TENHOSO;
	}

	public void setTENHOSO(String TENHOSO) {
		_TENHOSO = TENHOSO;
	}

	public String getNGUOINOP() {
		return _NGUOINOP;
	}

	public void setNGUOINOP(String NGUOINOP) {
		_NGUOINOP = NGUOINOP;
	}

	public String getCHUHOSO() {
		return _CHUHOSO;
	}

	public void setCHUHOSO(String CHUHOSO) {
		_CHUHOSO = CHUHOSO;
	}

	public String getDIACHI() {
		return _DIACHI;
	}

	public void setDIACHI(String DIACHI) {
		_DIACHI = DIACHI;
	}

	public String getSOBOHOSO() {
		return _SOBOHOSO;
	}

	public void setSOBOHOSO(String SOBOHOSO) {
		_SOBOHOSO = SOBOHOSO;
	}

	public String getLEPHI() {
		return _LEPHI;
	}

	public void setLEPHI(String LEPHI) {
		_LEPHI = LEPHI;
	}

	public String getPHIHOSO() {
		return _PHIHOSO;
	}

	public void setPHIHOSO(String PHIHOSO) {
		_PHIHOSO = PHIHOSO;
	}

	public String getTONGLEPHI() {
		return _TONGLEPHI;
	}

	public void setTONGLEPHI(String TONGLEPHI) {
		_TONGLEPHI = TONGLEPHI;
	}

	public String getGHICHU() {
		return _GHICHU;
	}

	public void setGHICHU(String GHICHU) {
		_GHICHU = GHICHU;
	}

	public int getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(int NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Lephi_chitietLocalServiceUtil.addLephi_chitiet(this);
		}
		else {
			Lephi_chitietLocalServiceUtil.updateLephi_chitiet(this);
		}
	}

	@Override
	public Lephi_chitiet toEscapedModel() {
		return (Lephi_chitiet)Proxy.newProxyInstance(Lephi_chitiet.class.getClassLoader(),
			new Class[] { Lephi_chitiet.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lephi_chitietClp clone = new Lephi_chitietClp();

		clone.setID(getID());
		clone.setTENHOSO(getTENHOSO());
		clone.setNGUOINOP(getNGUOINOP());
		clone.setCHUHOSO(getCHUHOSO());
		clone.setDIACHI(getDIACHI());
		clone.setSOBOHOSO(getSOBOHOSO());
		clone.setLEPHI(getLEPHI());
		clone.setPHIHOSO(getPHIHOSO());
		clone.setTONGLEPHI(getTONGLEPHI());
		clone.setGHICHU(getGHICHU());
		clone.setNHOMTHUTUCHANHCHINHID(getNHOMTHUTUCHANHCHINHID());

		return clone;
	}

	public int compareTo(Lephi_chitiet lephi_chitiet) {
		int value = 0;

		if (getID() < lephi_chitiet.getID()) {
			value = -1;
		}
		else if (getID() > lephi_chitiet.getID()) {
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

		Lephi_chitietClp lephi_chitiet = null;

		try {
			lephi_chitiet = (Lephi_chitietClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = lephi_chitiet.getPrimaryKey();

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

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", TENHOSO=");
		sb.append(getTENHOSO());
		sb.append(", NGUOINOP=");
		sb.append(getNGUOINOP());
		sb.append(", CHUHOSO=");
		sb.append(getCHUHOSO());
		sb.append(", DIACHI=");
		sb.append(getDIACHI());
		sb.append(", SOBOHOSO=");
		sb.append(getSOBOHOSO());
		sb.append(", LEPHI=");
		sb.append(getLEPHI());
		sb.append(", PHIHOSO=");
		sb.append(getPHIHOSO());
		sb.append(", TONGLEPHI=");
		sb.append(getTONGLEPHI());
		sb.append(", GHICHU=");
		sb.append(getGHICHU());
		sb.append(", NHOMTHUTUCHANHCHINHID=");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.Lephi_chitiet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TENHOSO</column-name><column-value><![CDATA[");
		sb.append(getTENHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NGUOINOP</column-name><column-value><![CDATA[");
		sb.append(getNGUOINOP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CHUHOSO</column-name><column-value><![CDATA[");
		sb.append(getCHUHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DIACHI</column-name><column-value><![CDATA[");
		sb.append(getDIACHI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SOBOHOSO</column-name><column-value><![CDATA[");
		sb.append(getSOBOHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LEPHI</column-name><column-value><![CDATA[");
		sb.append(getLEPHI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PHIHOSO</column-name><column-value><![CDATA[");
		sb.append(getPHIHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONGLEPHI</column-name><column-value><![CDATA[");
		sb.append(getTONGLEPHI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GHICHU</column-name><column-value><![CDATA[");
		sb.append(getGHICHU());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NHOMTHUTUCHANHCHINHID</column-name><column-value><![CDATA[");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private String _TENHOSO;
	private String _NGUOINOP;
	private String _CHUHOSO;
	private String _DIACHI;
	private String _SOBOHOSO;
	private String _LEPHI;
	private String _PHIHOSO;
	private String _TONGLEPHI;
	private String _GHICHU;
	private int _NHOMTHUTUCHANHCHINHID;
}