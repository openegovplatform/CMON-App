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

import org.oep.cmon.dao.report.service.Lephi_linhvucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class Lephi_linhvucClp extends BaseModelImpl<Lephi_linhvuc>
	implements Lephi_linhvuc {
	public Lephi_linhvucClp() {
	}

	public Class<?> getModelClass() {
		return Lephi_linhvuc.class;
	}

	public String getModelClassName() {
		return Lephi_linhvuc.class.getName();
	}

	public int getPrimaryKey() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setPrimaryKey(int primaryKey) {
		setNHOMTHUTUCHANHCHINHID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_NHOMTHUTUCHANHCHINHID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	public int getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(int NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public String getTONGHOSO() {
		return _TONGHOSO;
	}

	public void setTONGHOSO(String TONGHOSO) {
		_TONGHOSO = TONGHOSO;
	}

	public String getLEPHIHOSO() {
		return _LEPHIHOSO;
	}

	public void setLEPHIHOSO(String LEPHIHOSO) {
		_LEPHIHOSO = LEPHIHOSO;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			Lephi_linhvucLocalServiceUtil.addLephi_linhvuc(this);
		}
		else {
			Lephi_linhvucLocalServiceUtil.updateLephi_linhvuc(this);
		}
	}

	@Override
	public Lephi_linhvuc toEscapedModel() {
		return (Lephi_linhvuc)Proxy.newProxyInstance(Lephi_linhvuc.class.getClassLoader(),
			new Class[] { Lephi_linhvuc.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lephi_linhvucClp clone = new Lephi_linhvucClp();

		clone.setNHOMTHUTUCHANHCHINHID(getNHOMTHUTUCHANHCHINHID());
		clone.setTONGHOSO(getTONGHOSO());
		clone.setLEPHIHOSO(getLEPHIHOSO());
		clone.setPHIHOSO(getPHIHOSO());
		clone.setTONGLEPHI(getTONGLEPHI());

		return clone;
	}

	public int compareTo(Lephi_linhvuc lephi_linhvuc) {
		int value = 0;

		if (getNHOMTHUTUCHANHCHINHID() < lephi_linhvuc.getNHOMTHUTUCHANHCHINHID()) {
			value = -1;
		}
		else if (getNHOMTHUTUCHANHCHINHID() > lephi_linhvuc.getNHOMTHUTUCHANHCHINHID()) {
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

		Lephi_linhvucClp lephi_linhvuc = null;

		try {
			lephi_linhvuc = (Lephi_linhvucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = lephi_linhvuc.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append(", TONGHOSO=");
		sb.append(getTONGHOSO());
		sb.append(", LEPHIHOSO=");
		sb.append(getLEPHIHOSO());
		sb.append(", PHIHOSO=");
		sb.append(getPHIHOSO());
		sb.append(", TONGLEPHI=");
		sb.append(getTONGLEPHI());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.Lephi_linhvuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>NHOMTHUTUCHANHCHINHID</column-name><column-value><![CDATA[");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONGHOSO</column-name><column-value><![CDATA[");
		sb.append(getTONGHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LEPHIHOSO</column-name><column-value><![CDATA[");
		sb.append(getLEPHIHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PHIHOSO</column-name><column-value><![CDATA[");
		sb.append(getPHIHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONGLEPHI</column-name><column-value><![CDATA[");
		sb.append(getTONGLEPHI());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _NHOMTHUTUCHANHCHINHID;
	private String _TONGHOSO;
	private String _LEPHIHOSO;
	private String _PHIHOSO;
	private String _TONGLEPHI;
}