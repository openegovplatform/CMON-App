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

package org.oep.cmon.dao.kios.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.kios.model.DanhSachThongKe;

import java.io.Serializable;

/**
 * The cache model class for representing DanhSachThongKe in entity cache.
 *
 * @author VIENPN
 * @see DanhSachThongKe
 * @generated
 */
public class DanhSachThongKeCacheModel implements CacheModel<DanhSachThongKe>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

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
		sb.append(", TENCAPCOQUANQUANLY=");
		sb.append(TENCAPCOQUANQUANLY);
		sb.append(", TENCOQUANQUANLY=");
		sb.append(TENCOQUANQUANLY);
		sb.append("}");

		return sb.toString();
	}

	public DanhSachThongKe toEntityModel() {
		DanhSachThongKeImpl danhSachThongKeImpl = new DanhSachThongKeImpl();

		danhSachThongKeImpl.setCAPCOQUANQUANLYID(CAPCOQUANQUANLYID);
		danhSachThongKeImpl.setCOQUANQUANLYID(COQUANQUANLYID);
		danhSachThongKeImpl.setTHANG(THANG);
		danhSachThongKeImpl.setNAM(NAM);
		danhSachThongKeImpl.setTONGNHAN(TONGNHAN);
		danhSachThongKeImpl.setTIEPNHAN(TIEPNHAN);
		danhSachThongKeImpl.setTONDAU(TONDAU);
		danhSachThongKeImpl.setTONGDAGIAIQUYET(TONGDAGIAIQUYET);
		danhSachThongKeImpl.setSOM(SOM);
		danhSachThongKeImpl.setDUNG(DUNG);
		danhSachThongKeImpl.setTRE(TRE);
		danhSachThongKeImpl.setTONGDANGGIAIQUYET(TONGDANGGIAIQUYET);
		danhSachThongKeImpl.setCHUADENHAN(CHUADENHAN);
		danhSachThongKeImpl.setQUAHAN(QUAHAN);
		danhSachThongKeImpl.setRUTHOSO(RUTHOSO);
		danhSachThongKeImpl.setKHONGHOPLE(KHONGHOPLE);
		danhSachThongKeImpl.setTYLE(TYLE);
		danhSachThongKeImpl.setTONCUOI(TONCUOI);

		if (TENCAPCOQUANQUANLY == null) {
			danhSachThongKeImpl.setTENCAPCOQUANQUANLY(StringPool.BLANK);
		}
		else {
			danhSachThongKeImpl.setTENCAPCOQUANQUANLY(TENCAPCOQUANQUANLY);
		}

		if (TENCOQUANQUANLY == null) {
			danhSachThongKeImpl.setTENCOQUANQUANLY(StringPool.BLANK);
		}
		else {
			danhSachThongKeImpl.setTENCOQUANQUANLY(TENCOQUANQUANLY);
		}

		danhSachThongKeImpl.resetOriginalValues();

		return danhSachThongKeImpl;
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
	public String TENCAPCOQUANQUANLY;
	public String TENCOQUANQUANLY;
}