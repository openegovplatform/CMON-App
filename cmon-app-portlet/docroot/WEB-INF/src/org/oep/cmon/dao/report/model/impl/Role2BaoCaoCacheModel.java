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

import org.oep.cmon.dao.report.model.Role2BaoCao;

import java.io.Serializable;

/**
 * The cache model class for representing Role2BaoCao in entity cache.
 *
 * @author VIENPN
 * @see Role2BaoCao
 * @generated
 */
public class Role2BaoCaoCacheModel implements CacheModel<Role2BaoCao>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", RPDANHMUCROLEID=");
		sb.append(RPDANHMUCROLEID);
		sb.append(", RPDANHMUCBAOCAOID=");
		sb.append(RPDANHMUCBAOCAOID);
		sb.append("}");

		return sb.toString();
	}

	public Role2BaoCao toEntityModel() {
		Role2BaoCaoImpl role2BaoCaoImpl = new Role2BaoCaoImpl();

		role2BaoCaoImpl.setID(ID);
		role2BaoCaoImpl.setRPDANHMUCROLEID(RPDANHMUCROLEID);
		role2BaoCaoImpl.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);

		role2BaoCaoImpl.resetOriginalValues();

		return role2BaoCaoImpl;
	}

	public long ID;
	public long RPDANHMUCROLEID;
	public long RPDANHMUCBAOCAOID;
}