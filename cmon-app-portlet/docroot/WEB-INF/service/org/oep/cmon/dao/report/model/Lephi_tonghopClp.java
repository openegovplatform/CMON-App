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

import org.oep.cmon.dao.report.service.Lephi_tonghopLocalServiceUtil;
import org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class Lephi_tonghopClp extends BaseModelImpl<Lephi_tonghop>
	implements Lephi_tonghop {
	public Lephi_tonghopClp() {
	}

	public Class<?> getModelClass() {
		return Lephi_tonghop.class;
	}

	public String getModelClassName() {
		return Lephi_tonghop.class.getName();
	}

	public Lephi_tonghopPK getPrimaryKey() {
		return new Lephi_tonghopPK(_NHOMTHUTUCHANHCHINHID, _THANGNHAN);
	}

	public void setPrimaryKey(Lephi_tonghopPK primaryKey) {
		setNHOMTHUTUCHANHCHINHID(primaryKey.NHOMTHUTUCHANHCHINHID);
		setTHANGNHAN(primaryKey.THANGNHAN);
	}

	public Serializable getPrimaryKeyObj() {
		return new Lephi_tonghopPK(_NHOMTHUTUCHANHCHINHID, _THANGNHAN);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Lephi_tonghopPK)primaryKeyObj);
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

	public String getTHANGNHAN() {
		return _THANGNHAN;
	}

	public void setTHANGNHAN(String THANGNHAN) {
		_THANGNHAN = THANGNHAN;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Lephi_tonghopLocalServiceUtil.addLephi_tonghop(this);
		}
		else {
			Lephi_tonghopLocalServiceUtil.updateLephi_tonghop(this);
		}
	}

	@Override
	public Lephi_tonghop toEscapedModel() {
		return (Lephi_tonghop)Proxy.newProxyInstance(Lephi_tonghop.class.getClassLoader(),
			new Class[] { Lephi_tonghop.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lephi_tonghopClp clone = new Lephi_tonghopClp();

		clone.setNHOMTHUTUCHANHCHINHID(getNHOMTHUTUCHANHCHINHID());
		clone.setTONGHOSO(getTONGHOSO());
		clone.setLEPHI(getLEPHI());
		clone.setPHIHOSO(getPHIHOSO());
		clone.setTONGLEPHI(getTONGLEPHI());
		clone.setTHANGNHAN(getTHANGNHAN());

		return clone;
	}

	public int compareTo(Lephi_tonghop lephi_tonghop) {
		int value = 0;

		if (getNHOMTHUTUCHANHCHINHID() < lephi_tonghop.getNHOMTHUTUCHANHCHINHID()) {
			value = -1;
		}
		else if (getNHOMTHUTUCHANHCHINHID() > lephi_tonghop.getNHOMTHUTUCHANHCHINHID()) {
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

		Lephi_tonghopClp lephi_tonghop = null;

		try {
			lephi_tonghop = (Lephi_tonghopClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Lephi_tonghopPK primaryKey = lephi_tonghop.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append(", TONGHOSO=");
		sb.append(getTONGHOSO());
		sb.append(", LEPHI=");
		sb.append(getLEPHI());
		sb.append(", PHIHOSO=");
		sb.append(getPHIHOSO());
		sb.append(", TONGLEPHI=");
		sb.append(getTONGLEPHI());
		sb.append(", THANGNHAN=");
		sb.append(getTHANGNHAN());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.Lephi_tonghop");
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
			"<column><column-name>THANGNHAN</column-name><column-value><![CDATA[");
		sb.append(getTHANGNHAN());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _NHOMTHUTUCHANHCHINHID;
	private String _TONGHOSO;
	private String _LEPHI;
	private String _PHIHOSO;
	private String _TONGLEPHI;
	private String _THANGNHAN;
}