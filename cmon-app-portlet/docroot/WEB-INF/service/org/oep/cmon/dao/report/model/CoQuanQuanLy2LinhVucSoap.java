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
public class CoQuanQuanLy2LinhVucSoap implements Serializable {
	public static CoQuanQuanLy2LinhVucSoap toSoapModel(
		CoQuanQuanLy2LinhVuc model) {
		CoQuanQuanLy2LinhVucSoap soapModel = new CoQuanQuanLy2LinhVucSoap();

		soapModel.setNHOMTHUTUCHANHCHINHID(model.getNHOMTHUTUCHANHCHINHID());
		soapModel.setTENNHOMTTHC(model.getTENNHOMTTHC());

		return soapModel;
	}

	public static CoQuanQuanLy2LinhVucSoap[] toSoapModels(
		CoQuanQuanLy2LinhVuc[] models) {
		CoQuanQuanLy2LinhVucSoap[] soapModels = new CoQuanQuanLy2LinhVucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CoQuanQuanLy2LinhVucSoap[][] toSoapModels(
		CoQuanQuanLy2LinhVuc[][] models) {
		CoQuanQuanLy2LinhVucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CoQuanQuanLy2LinhVucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CoQuanQuanLy2LinhVucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CoQuanQuanLy2LinhVucSoap[] toSoapModels(
		List<CoQuanQuanLy2LinhVuc> models) {
		List<CoQuanQuanLy2LinhVucSoap> soapModels = new ArrayList<CoQuanQuanLy2LinhVucSoap>(models.size());

		for (CoQuanQuanLy2LinhVuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CoQuanQuanLy2LinhVucSoap[soapModels.size()]);
	}

	public CoQuanQuanLy2LinhVucSoap() {
	}

	public long getPrimaryKey() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setPrimaryKey(long pk) {
		setNHOMTHUTUCHANHCHINHID(pk);
	}

	public long getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public String getTENNHOMTTHC() {
		return _TENNHOMTTHC;
	}

	public void setTENNHOMTTHC(String TENNHOMTTHC) {
		_TENNHOMTTHC = TENNHOMTTHC;
	}

	private long _NHOMTHUTUCHANHCHINHID;
	private String _TENNHOMTTHC;
}