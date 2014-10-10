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

package org.oep.cmon.dao.report.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    VIENPN
 * @generated
 */
public class CongChuc2RoleSoap implements Serializable {
	public static CongChuc2RoleSoap toSoapModel(CongChuc2Role model) {
		CongChuc2RoleSoap soapModel = new CongChuc2RoleSoap();

		soapModel.setID(model.getID());
		soapModel.setCONGCHUCID(model.getCONGCHUCID());
		soapModel.setRPDANHMUCROLEID(model.getRPDANHMUCROLEID());

		return soapModel;
	}

	public static CongChuc2RoleSoap[] toSoapModels(CongChuc2Role[] models) {
		CongChuc2RoleSoap[] soapModels = new CongChuc2RoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CongChuc2RoleSoap[][] toSoapModels(CongChuc2Role[][] models) {
		CongChuc2RoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CongChuc2RoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CongChuc2RoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CongChuc2RoleSoap[] toSoapModels(List<CongChuc2Role> models) {
		List<CongChuc2RoleSoap> soapModels = new ArrayList<CongChuc2RoleSoap>(models.size());

		for (CongChuc2Role model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CongChuc2RoleSoap[soapModels.size()]);
	}

	public CongChuc2RoleSoap() {
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long pk) {
		setID(pk);
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public long getCONGCHUCID() {
		return _CONGCHUCID;
	}

	public void setCONGCHUCID(long CONGCHUCID) {
		_CONGCHUCID = CONGCHUCID;
	}

	public long getRPDANHMUCROLEID() {
		return _RPDANHMUCROLEID;
	}

	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_RPDANHMUCROLEID = RPDANHMUCROLEID;
	}

	private long _ID;
	private long _CONGCHUCID;
	private long _RPDANHMUCROLEID;
}