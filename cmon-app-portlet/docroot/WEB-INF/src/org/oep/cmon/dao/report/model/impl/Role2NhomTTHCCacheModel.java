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

import org.oep.cmon.dao.report.model.Role2NhomTTHC;

import java.io.Serializable;

/**
 * The cache model class for representing Role2NhomTTHC in entity cache.
 *
 * @author VIENPN
 * @see Role2NhomTTHC
 * @generated
 */
public class Role2NhomTTHCCacheModel implements CacheModel<Role2NhomTTHC>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", RPDANHMUCROLEID=");
		sb.append(RPDANHMUCROLEID);
		sb.append(", RPDANHMUCBAOCAOID=");
		sb.append(RPDANHMUCBAOCAOID);
		sb.append(", NHOMTHUTUCHANHCHINHID=");
		sb.append(NHOMTHUTUCHANHCHINHID);
		sb.append("}");

		return sb.toString();
	}

	public Role2NhomTTHC toEntityModel() {
		Role2NhomTTHCImpl role2NhomTTHCImpl = new Role2NhomTTHCImpl();

		role2NhomTTHCImpl.setID(ID);
		role2NhomTTHCImpl.setRPDANHMUCROLEID(RPDANHMUCROLEID);
		role2NhomTTHCImpl.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
		role2NhomTTHCImpl.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);

		role2NhomTTHCImpl.resetOriginalValues();

		return role2NhomTTHCImpl;
	}

	public long ID;
	public long RPDANHMUCROLEID;
	public long RPDANHMUCBAOCAOID;
	public long NHOMTHUTUCHANHCHINHID;
}