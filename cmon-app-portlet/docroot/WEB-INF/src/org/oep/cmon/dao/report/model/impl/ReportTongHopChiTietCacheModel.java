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

import org.oep.cmon.dao.report.model.ReportTongHopChiTiet;

import java.io.Serializable;

/**
 * The cache model class for representing ReportTongHopChiTiet in entity cache.
 *
 * @author VIENPN
 * @see ReportTongHopChiTiet
 * @generated
 */
public class ReportTongHopChiTietCacheModel implements CacheModel<ReportTongHopChiTiet>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{COQUANQUANLYID=");
		sb.append(COQUANQUANLYID);
		sb.append(", NHOMTHUTUCHANHCHINHID=");
		sb.append(NHOMTHUTUCHANHCHINHID);
		sb.append(", THUTUCHANHCHINHID=");
		sb.append(THUTUCHANHCHINHID);
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

	public ReportTongHopChiTiet toEntityModel() {
		ReportTongHopChiTietImpl reportTongHopChiTietImpl = new ReportTongHopChiTietImpl();

		reportTongHopChiTietImpl.setCOQUANQUANLYID(COQUANQUANLYID);
		reportTongHopChiTietImpl.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);
		reportTongHopChiTietImpl.setTHUTUCHANHCHINHID(THUTUCHANHCHINHID);
		reportTongHopChiTietImpl.setTHANG(THANG);
		reportTongHopChiTietImpl.setNAM(NAM);
		reportTongHopChiTietImpl.setTONGNHAN(TONGNHAN);
		reportTongHopChiTietImpl.setTIEPNHAN(TIEPNHAN);
		reportTongHopChiTietImpl.setTONDAU(TONDAU);
		reportTongHopChiTietImpl.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
		reportTongHopChiTietImpl.setSOM(SOM);
		reportTongHopChiTietImpl.setDUNG(DUNG);
		reportTongHopChiTietImpl.setTRE(TRE);
		reportTongHopChiTietImpl.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
		reportTongHopChiTietImpl.setCHUADENHAN(CHUADENHAN);
		reportTongHopChiTietImpl.setQUAHAN(QUAHAN);
		reportTongHopChiTietImpl.setRUTHOSO(RUTHOSO);
		reportTongHopChiTietImpl.setKHONGHOPLE(KHONGHOPLE);
		reportTongHopChiTietImpl.setTYLE(TYLE);
		reportTongHopChiTietImpl.setTONCUOI(TONCUOI);

		reportTongHopChiTietImpl.resetOriginalValues();

		return reportTongHopChiTietImpl;
	}

	public long COQUANQUANLYID;
	public long NHOMTHUTUCHANHCHINHID;
	public long THUTUCHANHCHINHID;
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