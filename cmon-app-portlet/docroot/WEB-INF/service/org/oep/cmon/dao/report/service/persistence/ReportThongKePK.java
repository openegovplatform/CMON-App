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
public class ReportThongKePK implements Comparable<ReportThongKePK>,
	Serializable {
	public long CAPCOQUANQUANLYID;
	public long COQUANQUANLYID;
	public int THANG;
	public int NAM;

	public ReportThongKePK() {
	}

	public ReportThongKePK(long CAPCOQUANQUANLYID, long COQUANQUANLYID,
		int THANG, int NAM) {
		this.CAPCOQUANQUANLYID = CAPCOQUANQUANLYID;
		this.COQUANQUANLYID = COQUANQUANLYID;
		this.THANG = THANG;
		this.NAM = NAM;
	}

	public long getCAPCOQUANQUANLYID() {
		return CAPCOQUANQUANLYID;
	}

	public void setCAPCOQUANQUANLYID(long CAPCOQUANQUANLYID) {
		this.CAPCOQUANQUANLYID = CAPCOQUANQUANLYID;
	}

	public long getCOQUANQUANLYID() {
		return COQUANQUANLYID;
	}

	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		this.COQUANQUANLYID = COQUANQUANLYID;
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

	public int compareTo(ReportThongKePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (CAPCOQUANQUANLYID < pk.CAPCOQUANQUANLYID) {
			value = -1;
		}
		else if (CAPCOQUANQUANLYID > pk.CAPCOQUANQUANLYID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

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

		ReportThongKePK pk = null;

		try {
			pk = (ReportThongKePK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((CAPCOQUANQUANLYID == pk.CAPCOQUANQUANLYID) &&
				(COQUANQUANLYID == pk.COQUANQUANLYID) && (THANG == pk.THANG) &&
				(NAM == pk.NAM)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(CAPCOQUANQUANLYID) +
		String.valueOf(COQUANQUANLYID) + String.valueOf(THANG) +
		String.valueOf(NAM)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("CAPCOQUANQUANLYID");
		sb.append(StringPool.EQUAL);
		sb.append(CAPCOQUANQUANLYID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("COQUANQUANLYID");
		sb.append(StringPool.EQUAL);
		sb.append(COQUANQUANLYID);

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