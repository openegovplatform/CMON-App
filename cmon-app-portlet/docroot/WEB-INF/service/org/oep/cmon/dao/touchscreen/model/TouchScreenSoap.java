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

package org.oep.cmon.dao.touchscreen.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    VIENPN
 * @generated
 */
public class TouchScreenSoap implements Serializable {
	public static TouchScreenSoap toSoapModel(TouchScreen model) {
		TouchScreenSoap soapModel = new TouchScreenSoap();

		soapModel.setID(model.getID());
		soapModel.setNAME(model.getNAME());

		return soapModel;
	}

	public static TouchScreenSoap[] toSoapModels(TouchScreen[] models) {
		TouchScreenSoap[] soapModels = new TouchScreenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TouchScreenSoap[][] toSoapModels(TouchScreen[][] models) {
		TouchScreenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TouchScreenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TouchScreenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TouchScreenSoap[] toSoapModels(List<TouchScreen> models) {
		List<TouchScreenSoap> soapModels = new ArrayList<TouchScreenSoap>(models.size());

		for (TouchScreen model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TouchScreenSoap[soapModels.size()]);
	}

	public TouchScreenSoap() {
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

	private long _ID;
	private String _NAME;
}