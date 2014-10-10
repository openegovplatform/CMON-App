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

import org.oep.cmon.dao.report.model.CongChuc2Role;

import java.io.Serializable;

/**
 * The cache model class for representing CongChuc2Role in entity cache.
 *
 * @author VIENPN
 * @see CongChuc2Role
 * @generated
 */
public class CongChuc2RoleCacheModel implements CacheModel<CongChuc2Role>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", CONGCHUCID=");
		sb.append(CONGCHUCID);
		sb.append(", RPDANHMUCROLEID=");
		sb.append(RPDANHMUCROLEID);
		sb.append("}");

		return sb.toString();
	}

	public CongChuc2Role toEntityModel() {
		CongChuc2RoleImpl congChuc2RoleImpl = new CongChuc2RoleImpl();

		congChuc2RoleImpl.setID(ID);
		congChuc2RoleImpl.setCONGCHUCID(CONGCHUCID);
		congChuc2RoleImpl.setRPDANHMUCROLEID(RPDANHMUCROLEID);

		congChuc2RoleImpl.resetOriginalValues();

		return congChuc2RoleImpl;
	}

	public long ID;
	public long CONGCHUCID;
	public long RPDANHMUCROLEID;
}