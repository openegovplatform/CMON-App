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

import org.oep.cmon.dao.report.service.ReportThongKeLocalServiceUtil;
import org.oep.cmon.dao.report.service.persistence.ReportThongKePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class ReportThongKeClp extends BaseModelImpl<ReportThongKe>
	implements ReportThongKe {
	public ReportThongKeClp() {
	}

	public Class<?> getModelClass() {
		return ReportThongKe.class;
	}

	public String getModelClassName() {
		return ReportThongKe.class.getName();
	}

	public ReportThongKePK getPrimaryKey() {
		return new ReportThongKePK(_CAPCOQUANQUANLYID, _COQUANQUANLYID, _THANG,
			_NAM);
	}

	public void setPrimaryKey(ReportThongKePK primaryKey) {
		setCAPCOQUANQUANLYID(primaryKey.CAPCOQUANQUANLYID);
		setCOQUANQUANLYID(primaryKey.COQUANQUANLYID);
		setTHANG(primaryKey.THANG);
		setNAM(primaryKey.NAM);
	}

	public Serializable getPrimaryKeyObj() {
		return new ReportThongKePK(_CAPCOQUANQUANLYID, _COQUANQUANLYID, _THANG,
			_NAM);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ReportThongKePK)primaryKeyObj);
	}

	public long getCAPCOQUANQUANLYID() {
		return _CAPCOQUANQUANLYID;
	}

	public void setCAPCOQUANQUANLYID(long CAPCOQUANQUANLYID) {
		_CAPCOQUANQUANLYID = CAPCOQUANQUANLYID;
	}

	public long getCOQUANQUANLYID() {
		return _COQUANQUANLYID;
	}

	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_COQUANQUANLYID = COQUANQUANLYID;
	}

	public int getTHANG() {
		return _THANG;
	}

	public void setTHANG(int THANG) {
		_THANG = THANG;
	}

	public int getNAM() {
		return _NAM;
	}

	public void setNAM(int NAM) {
		_NAM = NAM;
	}

	public long getTONGNHAN() {
		return _TONGNHAN;
	}

	public void setTONGNHAN(long TONGNHAN) {
		_TONGNHAN = TONGNHAN;
	}

	public long getTIEPNHAN() {
		return _TIEPNHAN;
	}

	public void setTIEPNHAN(long TIEPNHAN) {
		_TIEPNHAN = TIEPNHAN;
	}

	public long getTONDAU() {
		return _TONDAU;
	}

	public void setTONDAU(long TONDAU) {
		_TONDAU = TONDAU;
	}

	public long getTONGDAGIAIQUYET() {
		return _TONGDAGIAIQUYET;
	}

	public void setTONGDAGIAIQUYET(long TONGDAGIAIQUYET) {
		_TONGDAGIAIQUYET = TONGDAGIAIQUYET;
	}

	public long getSOM() {
		return _SOM;
	}

	public void setSOM(long SOM) {
		_SOM = SOM;
	}

	public long getDUNG() {
		return _DUNG;
	}

	public void setDUNG(long DUNG) {
		_DUNG = DUNG;
	}

	public long getTRE() {
		return _TRE;
	}

	public void setTRE(long TRE) {
		_TRE = TRE;
	}

	public long getTONGDANGGIAIQUYET() {
		return _TONGDANGGIAIQUYET;
	}

	public void setTONGDANGGIAIQUYET(long TONGDANGGIAIQUYET) {
		_TONGDANGGIAIQUYET = TONGDANGGIAIQUYET;
	}

	public long getCHUADENHAN() {
		return _CHUADENHAN;
	}

	public void setCHUADENHAN(long CHUADENHAN) {
		_CHUADENHAN = CHUADENHAN;
	}

	public long getQUAHAN() {
		return _QUAHAN;
	}

	public void setQUAHAN(long QUAHAN) {
		_QUAHAN = QUAHAN;
	}

	public long getRUTHOSO() {
		return _RUTHOSO;
	}

	public void setRUTHOSO(long RUTHOSO) {
		_RUTHOSO = RUTHOSO;
	}

	public long getKHONGHOPLE() {
		return _KHONGHOPLE;
	}

	public void setKHONGHOPLE(long KHONGHOPLE) {
		_KHONGHOPLE = KHONGHOPLE;
	}

	public double getTYLE() {
		return _TYLE;
	}

	public void setTYLE(double TYLE) {
		_TYLE = TYLE;
	}

	public long getTONCUOI() {
		return _TONCUOI;
	}

	public void setTONCUOI(long TONCUOI) {
		_TONCUOI = TONCUOI;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ReportThongKeLocalServiceUtil.addReportThongKe(this);
		}
		else {
			ReportThongKeLocalServiceUtil.updateReportThongKe(this);
		}
	}

	@Override
	public ReportThongKe toEscapedModel() {
		return (ReportThongKe)Proxy.newProxyInstance(ReportThongKe.class.getClassLoader(),
			new Class[] { ReportThongKe.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReportThongKeClp clone = new ReportThongKeClp();

		clone.setCAPCOQUANQUANLYID(getCAPCOQUANQUANLYID());
		clone.setCOQUANQUANLYID(getCOQUANQUANLYID());
		clone.setTHANG(getTHANG());
		clone.setNAM(getNAM());
		clone.setTONGNHAN(getTONGNHAN());
		clone.setTIEPNHAN(getTIEPNHAN());
		clone.setTONDAU(getTONDAU());
		clone.setTONGDAGIAIQUYET(getTONGDAGIAIQUYET());
		clone.setSOM(getSOM());
		clone.setDUNG(getDUNG());
		clone.setTRE(getTRE());
		clone.setTONGDANGGIAIQUYET(getTONGDANGGIAIQUYET());
		clone.setCHUADENHAN(getCHUADENHAN());
		clone.setQUAHAN(getQUAHAN());
		clone.setRUTHOSO(getRUTHOSO());
		clone.setKHONGHOPLE(getKHONGHOPLE());
		clone.setTYLE(getTYLE());
		clone.setTONCUOI(getTONCUOI());

		return clone;
	}

	public int compareTo(ReportThongKe reportThongKe) {
		int value = 0;

		if (getCAPCOQUANQUANLYID() < reportThongKe.getCAPCOQUANQUANLYID()) {
			value = -1;
		}
		else if (getCAPCOQUANQUANLYID() > reportThongKe.getCAPCOQUANQUANLYID()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getCOQUANQUANLYID() < reportThongKe.getCOQUANQUANLYID()) {
			value = -1;
		}
		else if (getCOQUANQUANLYID() > reportThongKe.getCOQUANQUANLYID()) {
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

		ReportThongKeClp reportThongKe = null;

		try {
			reportThongKe = (ReportThongKeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		ReportThongKePK primaryKey = reportThongKe.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{CAPCOQUANQUANLYID=");
		sb.append(getCAPCOQUANQUANLYID());
		sb.append(", COQUANQUANLYID=");
		sb.append(getCOQUANQUANLYID());
		sb.append(", THANG=");
		sb.append(getTHANG());
		sb.append(", NAM=");
		sb.append(getNAM());
		sb.append(", TONGNHAN=");
		sb.append(getTONGNHAN());
		sb.append(", TIEPNHAN=");
		sb.append(getTIEPNHAN());
		sb.append(", TONDAU=");
		sb.append(getTONDAU());
		sb.append(", TONGDAGIAIQUYET=");
		sb.append(getTONGDAGIAIQUYET());
		sb.append(", SOM=");
		sb.append(getSOM());
		sb.append(", DUNG=");
		sb.append(getDUNG());
		sb.append(", TRE=");
		sb.append(getTRE());
		sb.append(", TONGDANGGIAIQUYET=");
		sb.append(getTONGDANGGIAIQUYET());
		sb.append(", CHUADENHAN=");
		sb.append(getCHUADENHAN());
		sb.append(", QUAHAN=");
		sb.append(getQUAHAN());
		sb.append(", RUTHOSO=");
		sb.append(getRUTHOSO());
		sb.append(", KHONGHOPLE=");
		sb.append(getKHONGHOPLE());
		sb.append(", TYLE=");
		sb.append(getTYLE());
		sb.append(", TONCUOI=");
		sb.append(getTONCUOI());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.ReportThongKe");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CAPCOQUANQUANLYID</column-name><column-value><![CDATA[");
		sb.append(getCAPCOQUANQUANLYID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>COQUANQUANLYID</column-name><column-value><![CDATA[");
		sb.append(getCOQUANQUANLYID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>THANG</column-name><column-value><![CDATA[");
		sb.append(getTHANG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NAM</column-name><column-value><![CDATA[");
		sb.append(getNAM());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONGNHAN</column-name><column-value><![CDATA[");
		sb.append(getTONGNHAN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TIEPNHAN</column-name><column-value><![CDATA[");
		sb.append(getTIEPNHAN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONDAU</column-name><column-value><![CDATA[");
		sb.append(getTONDAU());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONGDAGIAIQUYET</column-name><column-value><![CDATA[");
		sb.append(getTONGDAGIAIQUYET());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SOM</column-name><column-value><![CDATA[");
		sb.append(getSOM());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DUNG</column-name><column-value><![CDATA[");
		sb.append(getDUNG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TRE</column-name><column-value><![CDATA[");
		sb.append(getTRE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONGDANGGIAIQUYET</column-name><column-value><![CDATA[");
		sb.append(getTONGDANGGIAIQUYET());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CHUADENHAN</column-name><column-value><![CDATA[");
		sb.append(getCHUADENHAN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>QUAHAN</column-name><column-value><![CDATA[");
		sb.append(getQUAHAN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RUTHOSO</column-name><column-value><![CDATA[");
		sb.append(getRUTHOSO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>KHONGHOPLE</column-name><column-value><![CDATA[");
		sb.append(getKHONGHOPLE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TYLE</column-name><column-value><![CDATA[");
		sb.append(getTYLE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TONCUOI</column-name><column-value><![CDATA[");
		sb.append(getTONCUOI());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _CAPCOQUANQUANLYID;
	private long _COQUANQUANLYID;
	private int _THANG;
	private int _NAM;
	private long _TONGNHAN;
	private long _TIEPNHAN;
	private long _TONDAU;
	private long _TONGDAGIAIQUYET;
	private long _SOM;
	private long _DUNG;
	private long _TRE;
	private long _TONGDANGGIAIQUYET;
	private long _CHUADENHAN;
	private long _QUAHAN;
	private long _RUTHOSO;
	private long _KHONGHOPLE;
	private double _TYLE;
	private long _TONCUOI;
}