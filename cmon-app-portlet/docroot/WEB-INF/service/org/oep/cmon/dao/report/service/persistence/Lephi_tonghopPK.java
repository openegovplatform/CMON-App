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
public class Lephi_tonghopPK implements Comparable<Lephi_tonghopPK>,
	Serializable {
	public int NHOMTHUTUCHANHCHINHID;
	public String THANGNHAN;

	public Lephi_tonghopPK() {
	}

	public Lephi_tonghopPK(int NHOMTHUTUCHANHCHINHID, String THANGNHAN) {
		this.NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
		this.THANGNHAN = THANGNHAN;
	}

	public int getNHOMTHUTUCHANHCHINHID() {
		return NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(int NHOMTHUTUCHANHCHINHID) {
		this.NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public String getTHANGNHAN() {
		return THANGNHAN;
	}

	public void setTHANGNHAN(String THANGNHAN) {
		this.THANGNHAN = THANGNHAN;
	}

	public int compareTo(Lephi_tonghopPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		value = THANGNHAN.compareTo(pk.THANGNHAN);

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

		Lephi_tonghopPK pk = null;

		try {
			pk = (Lephi_tonghopPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((NHOMTHUTUCHANHCHINHID == pk.NHOMTHUTUCHANHCHINHID) &&
				(THANGNHAN.equals(pk.THANGNHAN))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(NHOMTHUTUCHANHCHINHID) +
		String.valueOf(THANGNHAN)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("NHOMTHUTUCHANHCHINHID");
		sb.append(StringPool.EQUAL);
		sb.append(NHOMTHUTUCHANHCHINHID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("THANGNHAN");
		sb.append(StringPool.EQUAL);
		sb.append(THANGNHAN);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}