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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.report.model.DanhMucRole;

import java.io.Serializable;

/**
 * The cache model class for representing DanhMucRole in entity cache.
 *
 * @author VIENPN
 * @see DanhMucRole
 * @generated
 */
public class DanhMucRoleCacheModel implements CacheModel<DanhMucRole>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", NAME=");
		sb.append(NAME);
		sb.append(", ORDERS=");
		sb.append(ORDERS);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	public DanhMucRole toEntityModel() {
		DanhMucRoleImpl danhMucRoleImpl = new DanhMucRoleImpl();

		danhMucRoleImpl.setID(ID);

		if (NAME == null) {
			danhMucRoleImpl.setNAME(StringPool.BLANK);
		}
		else {
			danhMucRoleImpl.setNAME(NAME);
		}

		danhMucRoleImpl.setORDERS(ORDERS);
		danhMucRoleImpl.setSTATUS(STATUS);

		danhMucRoleImpl.resetOriginalValues();

		return danhMucRoleImpl;
	}

	public long ID;
	public String NAME;
	public int ORDERS;
	public int STATUS;
}