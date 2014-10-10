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

package org.oep.cmon.dao.report.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.report.model.ReportThongKe;

import java.io.Serializable;

/**
 * The cache model class for representing ReportThongKe in entity cache.
 *
 * @author VIENPN
 * @see ReportThongKe
 * @generated
 */
public class ReportThongKeCacheModel implements CacheModel<ReportThongKe>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{CAPCOQUANQUANLYID=");
		sb.append(CAPCOQUANQUANLYID);
		sb.append(", COQUANQUANLYID=");
		sb.append(COQUANQUANLYID);
		sb.append(", THANG=");
		sb.append(THANG);
		sb.append(", NAM=");
		sb.append(NAM);
		sb.append(", TONGNHAN=");
		sb.append(TONGNHAN);
		sb.append(", TIEPNHAN=");
		sb.append(TIEPNHAN);
		sb.append(", TONDAU=");
		sb.append(TONDAU);
		sb.append(", TONGDAGIAIQUYET=");
		sb.append(TONGDAGIAIQUYET);
		sb.append(", SOM=");
		sb.append(SOM);
		sb.append(", DUNG=");
		sb.append(DUNG);
		sb.append(", TRE=");
		sb.append(TRE);
		sb.append(", TONGDANGGIAIQUYET=");
		sb.append(TONGDANGGIAIQUYET);
		sb.append(", CHUADENHAN=");
		sb.append(CHUADENHAN);
		sb.append(", QUAHAN=");
		sb.append(QUAHAN);
		sb.append(", RUTHOSO=");
		sb.append(RUTHOSO);
		sb.append(", KHONGHOPLE=");
		sb.append(KHONGHOPLE);
		sb.append(", TYLE=");
		sb.append(TYLE);
		sb.append(", TONCUOI=");
		sb.append(TONCUOI);
		sb.append("}");

		return sb.toString();
	}

	public ReportThongKe toEntityModel() {
		ReportThongKeImpl reportThongKeImpl = new ReportThongKeImpl();

		reportThongKeImpl.setCAPCOQUANQUANLYID(CAPCOQUANQUANLYID);
		reportThongKeImpl.setCOQUANQUANLYID(COQUANQUANLYID);
		reportThongKeImpl.setTHANG(THANG);
		reportThongKeImpl.setNAM(NAM);
		reportThongKeImpl.setTONGNHAN(TONGNHAN);
		reportThongKeImpl.setTIEPNHAN(TIEPNHAN);
		reportThongKeImpl.setTONDAU(TONDAU);
		reportThongKeImpl.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
		reportThongKeImpl.setSOM(SOM);
		reportThongKeImpl.setDUNG(DUNG);
		reportThongKeImpl.setTRE(TRE);
		reportThongKeImpl.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
		reportThongKeImpl.setCHUADENHAN(CHUADENHAN);
		reportThongKeImpl.setQUAHAN(QUAHAN);
		reportThongKeImpl.setRUTHOSO(RUTHOSO);
		reportThongKeImpl.setKHONGHOPLE(KHONGHOPLE);
		reportThongKeImpl.setTYLE(TYLE);
		reportThongKeImpl.setTONCUOI(TONCUOI);

		reportThongKeImpl.resetOriginalValues();

		return reportThongKeImpl;
	}

	public long CAPCOQUANQUANLYID;
	public long COQUANQUANLYID;
	public int THANG;
	public int NAM;
	public long TONGNHAN;
	public long TIEPNHAN;
	public long TONDAU;
	public long TONGDAGIAIQUYET;
	public long SOM;
	public long DUNG;
	public long TRE;
	public long TONGDANGGIAIQUYET;
	public long CHUADENHAN;
	public long QUAHAN;
	public long RUTHOSO;
	public long KHONGHOPLE;
	public double TYLE;
	public long TONCUOI;
}