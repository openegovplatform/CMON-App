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

package org.oep.exch.dao.hoso.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    NAM
 * @generated
 */
public class UpdateHoSoTrucTuyenSoap implements Serializable {
	public static UpdateHoSoTrucTuyenSoap toSoapModel(UpdateHoSoTrucTuyen model) {
		UpdateHoSoTrucTuyenSoap soapModel = new UpdateHoSoTrucTuyenSoap();

		soapModel.setId(model.getId());
		soapModel.setTrangThaiXuLy(model.getTrangThaiXuLy());
		soapModel.setNgayChuyen(model.getNgayChuyen());

		return soapModel;
	}

	public static UpdateHoSoTrucTuyenSoap[] toSoapModels(
		UpdateHoSoTrucTuyen[] models) {
		UpdateHoSoTrucTuyenSoap[] soapModels = new UpdateHoSoTrucTuyenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UpdateHoSoTrucTuyenSoap[][] toSoapModels(
		UpdateHoSoTrucTuyen[][] models) {
		UpdateHoSoTrucTuyenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UpdateHoSoTrucTuyenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UpdateHoSoTrucTuyenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UpdateHoSoTrucTuyenSoap[] toSoapModels(
		List<UpdateHoSoTrucTuyen> models) {
		List<UpdateHoSoTrucTuyenSoap> soapModels = new ArrayList<UpdateHoSoTrucTuyenSoap>(models.size());

		for (UpdateHoSoTrucTuyen model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UpdateHoSoTrucTuyenSoap[soapModels.size()]);
	}

	public UpdateHoSoTrucTuyenSoap() {
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

	public int getTrangThaiXuLy() {
		return _TrangThaiXuLy;
	}

	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_TrangThaiXuLy = TrangThaiXuLy;
	}

	public Date getNgayChuyen() {
		return _NgayChuyen;
	}

	public void setNgayChuyen(Date NgayChuyen) {
		_NgayChuyen = NgayChuyen;
	}

	private long _id;
	private int _TrangThaiXuLy;
	private Date _NgayChuyen;
}