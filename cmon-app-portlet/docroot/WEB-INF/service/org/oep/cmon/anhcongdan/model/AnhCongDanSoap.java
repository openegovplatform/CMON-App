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

package org.oep.cmon.anhcongdan.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    BinhNT
 * @generated
 */
public class AnhCongDanSoap implements Serializable {
	public static AnhCongDanSoap toSoapModel(AnhCongDan model) {
		AnhCongDanSoap soapModel = new AnhCongDanSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setEmail(model.getEmail());
		soapModel.setAnh(model.getAnh());

		return soapModel;
	}

	public static AnhCongDanSoap[] toSoapModels(AnhCongDan[] models) {
		AnhCongDanSoap[] soapModels = new AnhCongDanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnhCongDanSoap[][] toSoapModels(AnhCongDan[][] models) {
		AnhCongDanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnhCongDanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnhCongDanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnhCongDanSoap[] toSoapModels(List<AnhCongDan> models) {
		List<AnhCongDanSoap> soapModels = new ArrayList<AnhCongDanSoap>(models.size());

		for (AnhCongDan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnhCongDanSoap[soapModels.size()]);
	}

	public AnhCongDanSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAnh() {
		return _anh;
	}

	public void setAnh(String anh) {
		_anh = anh;
	}

	private long _id;
	private String _ma;
	private String _email;
	private String _anh;
}