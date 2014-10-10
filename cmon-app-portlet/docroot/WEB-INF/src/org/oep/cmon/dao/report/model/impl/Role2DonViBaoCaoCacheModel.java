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

import org.oep.cmon.dao.report.model.Role2DonViBaoCao;

import java.io.Serializable;

/**
 * The cache model class for representing Role2DonViBaoCao in entity cache.
 *
 * @author VIENPN
 * @see Role2DonViBaoCao
 * @generated
 */
public class Role2DonViBaoCaoCacheModel implements CacheModel<Role2DonViBaoCao>,
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
		sb.append(", COQUANQUANLYID=");
		sb.append(COQUANQUANLYID);
		sb.append("}");

		return sb.toString();
	}

	public Role2DonViBaoCao toEntityModel() {
		Role2DonViBaoCaoImpl role2DonViBaoCaoImpl = new Role2DonViBaoCaoImpl();

		role2DonViBaoCaoImpl.setID(ID);
		role2DonViBaoCaoImpl.setRPDANHMUCROLEID(RPDANHMUCROLEID);
		role2DonViBaoCaoImpl.setRPDANHMUCBAOCAOID(RPDANHMUCBAOCAOID);
		role2DonViBaoCaoImpl.setCOQUANQUANLYID(COQUANQUANLYID);

		role2DonViBaoCaoImpl.resetOriginalValues();

		return role2DonViBaoCaoImpl;
	}

	public long ID;
	public long RPDANHMUCROLEID;
	public long RPDANHMUCBAOCAOID;
	public long COQUANQUANLYID;
}