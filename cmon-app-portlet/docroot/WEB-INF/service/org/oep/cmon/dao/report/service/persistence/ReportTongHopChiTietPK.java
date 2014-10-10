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

package org.oep.cmon.dao.report.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author VIENPN
 */
public class ReportTongHopChiTietPK implements Comparable<ReportTongHopChiTietPK>,
	Serializable {
	public long COQUANQUANLYID;
	public long NHOMTHUTUCHANHCHINHID;
	public long THUTUCHANHCHINHID;
	public int THANG;
	public int NAM;

	public ReportTongHopChiTietPK() {
	}

	public ReportTongHopChiTietPK(long COQUANQUANLYID,
		long NHOMTHUTUCHANHCHINHID, long THUTUCHANHCHINHID, int THANG, int NAM) {
		this.COQUANQUANLYID = COQUANQUANLYID;
		this.NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
		this.THUTUCHANHCHINHID = THUTUCHANHCHINHID;
		this.THANG = THANG;
		this.NAM = NAM;
	}

	public long getCOQUANQUANLYID() {
		return COQUANQUANLYID;
	}

	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		this.COQUANQUANLYID = COQUANQUANLYID;
	}

	public long getNHOMTHUTUCHANHCHINHID() {
		return NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		this.NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public long getTHUTUCHANHCHINHID() {
		return THUTUCHANHCHINHID;
	}

	public void setTHUTUCHANHCHINHID(long THUTUCHANHCHINHID) {
		this.THUTUCHANHCHINHID = THUTUCHANHCHINHID;
	}

	public int getTHANG() {
		return THANG;
	}

	public void setTHANG(int THANG) {
		this.THANG = THANG;
	}

	public int getNAM() {
		return NAM;
	}

	public void setNAM(int NAM) {
		this.NAM = NAM;
	}

	public int compareTo(ReportTongHopChiTietPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (COQUANQUANLYID < pk.COQUANQUANLYID) {
			value = -1;
		}
		else if (COQUANQUANLYID > pk.COQUANQUANLYID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (NHOMTHUTUCHANHCHINHID < pk.NHOMTHUTUCHANHCHINHID) {
			value = -1;
		}
		else if (NHOMTHUTUCHANHCHINHID > pk.NHOMTHUTUCHANHCHINHID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (THUTUCHANHCHINHID < pk.THUTUCHANHCHINHID) {
			value = -1;
		}
		else if (THUTUCHANHCHINHID > pk.THUTUCHANHCHINHID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (THANG < pk.THANG) {
			value = -1;
		}
		else if (THANG > pk.THANG) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (NAM < pk.NAM) {
			value = -1;
		}
		else if (NAM > pk.NAM) {
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

		ReportTongHopChiTietPK pk = null;

		try {
			pk = (ReportTongHopChiTietPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((COQUANQUANLYID == pk.COQUANQUANLYID) &&
				(NHOMTHUTUCHANHCHINHID == pk.NHOMTHUTUCHANHCHINHID) &&
				(THUTUCHANHCHINHID == pk.THUTUCHANHCHINHID) &&
				(THANG == pk.THANG) && (NAM == pk.NAM)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(COQUANQUANLYID) +
		String.valueOf(NHOMTHUTUCHANHCHINHID) +
		String.valueOf(THUTUCHANHCHINHID) + String.valueOf(THANG) +
		String.valueOf(NAM)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("COQUANQUANLYID");
		sb.append(StringPool.EQUAL);
		sb.append(COQUANQUANLYID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("NHOMTHUTUCHANHCHINHID");
		sb.append(StringPool.EQUAL);
		sb.append(NHOMTHUTUCHANHCHINHID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("THUTUCHANHCHINHID");
		sb.append(StringPool.EQUAL);
		sb.append(THUTUCHANHCHINHID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("THANG");
		sb.append(StringPool.EQUAL);
		sb.append(THANG);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("NAM");
		sb.append(StringPool.EQUAL);
		sb.append(NAM);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}