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

import org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    VIENPN
 * @generated
 */
public class Lephi_tonghopSoap implements Serializable {
	public static Lephi_tonghopSoap toSoapModel(Lephi_tonghop model) {
		Lephi_tonghopSoap soapModel = new Lephi_tonghopSoap();

		soapModel.setNHOMTHUTUCHANHCHINHID(model.getNHOMTHUTUCHANHCHINHID());
		soapModel.setTONGHOSO(model.getTONGHOSO());
		soapModel.setLEPHI(model.getLEPHI());
		soapModel.setPHIHOSO(model.getPHIHOSO());
		soapModel.setTONGLEPHI(model.getTONGLEPHI());
		soapModel.setTHANGNHAN(model.getTHANGNHAN());

		return soapModel;
	}

	public static Lephi_tonghopSoap[] toSoapModels(Lephi_tonghop[] models) {
		Lephi_tonghopSoap[] soapModels = new Lephi_tonghopSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lephi_tonghopSoap[][] toSoapModels(Lephi_tonghop[][] models) {
		Lephi_tonghopSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lephi_tonghopSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lephi_tonghopSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lephi_tonghopSoap[] toSoapModels(List<Lephi_tonghop> models) {
		List<Lephi_tonghopSoap> soapModels = new ArrayList<Lephi_tonghopSoap>(models.size());

		for (Lephi_tonghop model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lephi_tonghopSoap[soapModels.size()]);
	}

	public Lephi_tonghopSoap() {
	}

	public Lephi_tonghopPK getPrimaryKey() {
		return new Lephi_tonghopPK(_NHOMTHUTUCHANHCHINHID, _THANGNHAN);
	}

	public void setPrimaryKey(Lephi_tonghopPK pk) {
		setNHOMTHUTUCHANHCHINHID(pk.NHOMTHUTUCHANHCHINHID);
		setTHANGNHAN(pk.THANGNHAN);
	}

	public int getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(int NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public String getTONGHOSO() {
		return _TONGHOSO;
	}

	public void setTONGHOSO(String TONGHOSO) {
		_TONGHOSO = TONGHOSO;
	}

	public String getLEPHI() {
		return _LEPHI;
	}

	public void setLEPHI(String LEPHI) {
		_LEPHI = LEPHI;
	}

	public String getPHIHOSO() {
		return _PHIHOSO;
	}

	public void setPHIHOSO(String PHIHOSO) {
		_PHIHOSO = PHIHOSO;
	}

	public String getTONGLEPHI() {
		return _TONGLEPHI;
	}

	public void setTONGLEPHI(String TONGLEPHI) {
		_TONGLEPHI = TONGLEPHI;
	}

	public String getTHANGNHAN() {
		return _THANGNHAN;
	}

	public void setTHANGNHAN(String THANGNHAN) {
		_THANGNHAN = THANGNHAN;
	}

	private int _NHOMTHUTUCHANHCHINHID;
	private String _TONGHOSO;
	private String _LEPHI;
	private String _PHIHOSO;
	private String _TONGLEPHI;
	private String _THANGNHAN;
}