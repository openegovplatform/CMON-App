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

import org.oep.cmon.dao.report.model.Role2TTHC;

import java.io.Serializable;

/**
 * The cache model class for representing Role2TTHC in entity cache.
 *
 * @author VIENPN
 * @see Role2TTHC
 * @generated
 */
public class Role2TTHCCacheModel implements CacheModel<Role2TTHC>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", RPDANHMUCROLEID=");
		sb.append(RPDANHMUCROLEID);
		sb.append(", RPDANHMUCBAOCAOID=");
		sb.append(RPDANHMUCBAOCAOID);
		sb.append(", THUTUCHANHCHINHID=");
		sb.append(THUTUCHANHCHINHID);
		sb.append("}");

		return sb.toString();
	}

	public Role2TTHC toEntityModel() {
		Role2TTHCImpl role2TTHCImpl = new Role2TTHCImpl();

		role2TTHCImpl.setID(ID);
		role2TTHCImpl.setRPDANHMUCROLEID(RPDANHMUCROLEID);
		role2TTHCImpl.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
		role2TTHCImpl.setTHUTUCHANHCHINHID(THUTUCHANHCHINHID);

		role2TTHCImpl.resetOriginalValues();

		return role2TTHCImpl;
	}

	public long ID;
	public long RPDANHMUCROLEID;
	public long RPDANHMUCBAOCAOID;
	public long THUTUCHANHCHINHID;
}