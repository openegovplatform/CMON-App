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
public class DanhMucRoleSoap implements Serializable {
	public static DanhMucRoleSoap toSoapModel(DanhMucRole model) {
		DanhMucRoleSoap soapModel = new DanhMucRoleSoap();

		soapModel.setID(model.getID());
		soapModel.setNAME(model.getNAME());
		soapModel.setORDERS(model.getORDERS());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static DanhMucRoleSoap[] toSoapModels(DanhMucRole[] models) {
		DanhMucRoleSoap[] soapModels = new DanhMucRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhMucRoleSoap[][] toSoapModels(DanhMucRole[][] models) {
		DanhMucRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhMucRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhMucRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhMucRoleSoap[] toSoapModels(List<DanhMucRole> models) {
		List<DanhMucRoleSoap> soapModels = new ArrayList<DanhMucRoleSoap>(models.size());

		for (DanhMucRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhMucRoleSoap[soapModels.size()]);
	}

	public DanhMucRoleSoap() {
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

	public String getNAME() {
		return _NAME;
	}

	public void setNAME(String NAME) {
		_NAME = NAME;
	}

	public int getORDERS() {
		return _ORDERS;
	}

	public void setORDERS(int ORDERS) {
		_ORDERS = ORDERS;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private long _ID;
	private String _NAME;
	private int _ORDERS;
	private int _STATUS;
}