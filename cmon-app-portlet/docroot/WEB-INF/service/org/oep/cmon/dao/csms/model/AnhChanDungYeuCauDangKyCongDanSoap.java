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

package org.oep.cmon.dao.csms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    NAM
 * @generated
 */
public class AnhChanDungYeuCauDangKyCongDanSoap implements Serializable {
	public static AnhChanDungYeuCauDangKyCongDanSoap toSoapModel(
		AnhChanDungYeuCauDangKyCongDan model) {
		AnhChanDungYeuCauDangKyCongDanSoap soapModel = new AnhChanDungYeuCauDangKyCongDanSoap();

		soapModel.setId(model.getId());
		soapModel.setAnhChanDung(model.getAnhChanDung());

		return soapModel;
	}

	public static AnhChanDungYeuCauDangKyCongDanSoap[] toSoapModels(
		AnhChanDungYeuCauDangKyCongDan[] models) {
		AnhChanDungYeuCauDangKyCongDanSoap[] soapModels = new AnhChanDungYeuCauDangKyCongDanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnhChanDungYeuCauDangKyCongDanSoap[][] toSoapModels(
		AnhChanDungYeuCauDangKyCongDan[][] models) {
		AnhChanDungYeuCauDangKyCongDanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnhChanDungYeuCauDangKyCongDanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnhChanDungYeuCauDangKyCongDanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnhChanDungYeuCauDangKyCongDanSoap[] toSoapModels(
		List<AnhChanDungYeuCauDangKyCongDan> models) {
		List<AnhChanDungYeuCauDangKyCongDanSoap> soapModels = new ArrayList<AnhChanDungYeuCauDangKyCongDanSoap>(models.size());

		for (AnhChanDungYeuCauDangKyCongDan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnhChanDungYeuCauDangKyCongDanSoap[soapModels.size()]);
	}

	public AnhChanDungYeuCauDangKyCongDanSoap() {
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

	public String getAnhChanDung() {
		return _AnhChanDung;
	}

	public void setAnhChanDung(String AnhChanDung) {
		_AnhChanDung = AnhChanDung;
	}

	private long _id;
	private String _AnhChanDung;
}