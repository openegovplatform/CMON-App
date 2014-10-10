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
public class Lephi_linhvucSoap implements Serializable {
	public static Lephi_linhvucSoap toSoapModel(Lephi_linhvuc model) {
		Lephi_linhvucSoap soapModel = new Lephi_linhvucSoap();

		soapModel.setNHOMTHUTUCHANHCHINHID(model.getNHOMTHUTUCHANHCHINHID());
		soapModel.setTONGHOSO(model.getTONGHOSO());
		soapModel.setLEPHIHOSO(model.getLEPHIHOSO());
		soapModel.setPHIHOSO(model.getPHIHOSO());
		soapModel.setTONGLEPHI(model.getTONGLEPHI());

		return soapModel;
	}

	public static Lephi_linhvucSoap[] toSoapModels(Lephi_linhvuc[] models) {
		Lephi_linhvucSoap[] soapModels = new Lephi_linhvucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lephi_linhvucSoap[][] toSoapModels(Lephi_linhvuc[][] models) {
		Lephi_linhvucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lephi_linhvucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lephi_linhvucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lephi_linhvucSoap[] toSoapModels(List<Lephi_linhvuc> models) {
		List<Lephi_linhvucSoap> soapModels = new ArrayList<Lephi_linhvucSoap>(models.size());

		for (Lephi_linhvuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lephi_linhvucSoap[soapModels.size()]);
	}

	public Lephi_linhvucSoap() {
	}

	public int getPrimaryKey() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setPrimaryKey(int pk) {
		setNHOMTHUTUCHANHCHINHID(pk);
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

	public String getLEPHIHOSO() {
		return _LEPHIHOSO;
	}

	public void setLEPHIHOSO(String LEPHIHOSO) {
		_LEPHIHOSO = LEPHIHOSO;
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

	private int _NHOMTHUTUCHANHCHINHID;
	private String _TONGHOSO;
	private String _LEPHIHOSO;
	private String _PHIHOSO;
	private String _TONGLEPHI;
}