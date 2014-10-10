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
public class Lephi_chitietSoap implements Serializable {
	public static Lephi_chitietSoap toSoapModel(Lephi_chitiet model) {
		Lephi_chitietSoap soapModel = new Lephi_chitietSoap();

		soapModel.setID(model.getID());
		soapModel.setTENHOSO(model.getTENHOSO());
		soapModel.setNGUOINOP(model.getNGUOINOP());
		soapModel.setCHUHOSO(model.getCHUHOSO());
		soapModel.setDIACHI(model.getDIACHI());
		soapModel.setSOBOHOSO(model.getSOBOHOSO());
		soapModel.setLEPHI(model.getLEPHI());
		soapModel.setPHIHOSO(model.getPHIHOSO());
		soapModel.setTONGLEPHI(model.getTONGLEPHI());
		soapModel.setGHICHU(model.getGHICHU());
		soapModel.setNHOMTHUTUCHANHCHINHID(model.getNHOMTHUTUCHANHCHINHID());

		return soapModel;
	}

	public static Lephi_chitietSoap[] toSoapModels(Lephi_chitiet[] models) {
		Lephi_chitietSoap[] soapModels = new Lephi_chitietSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lephi_chitietSoap[][] toSoapModels(Lephi_chitiet[][] models) {
		Lephi_chitietSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lephi_chitietSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lephi_chitietSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lephi_chitietSoap[] toSoapModels(List<Lephi_chitiet> models) {
		List<Lephi_chitietSoap> soapModels = new ArrayList<Lephi_chitietSoap>(models.size());

		for (Lephi_chitiet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lephi_chitietSoap[soapModels.size()]);
	}

	public Lephi_chitietSoap() {
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

	public String getTENHOSO() {
		return _TENHOSO;
	}

	public void setTENHOSO(String TENHOSO) {
		_TENHOSO = TENHOSO;
	}

	public String getNGUOINOP() {
		return _NGUOINOP;
	}

	public void setNGUOINOP(String NGUOINOP) {
		_NGUOINOP = NGUOINOP;
	}

	public String getCHUHOSO() {
		return _CHUHOSO;
	}

	public void setCHUHOSO(String CHUHOSO) {
		_CHUHOSO = CHUHOSO;
	}

	public String getDIACHI() {
		return _DIACHI;
	}

	public void setDIACHI(String DIACHI) {
		_DIACHI = DIACHI;
	}

	public String getSOBOHOSO() {
		return _SOBOHOSO;
	}

	public void setSOBOHOSO(String SOBOHOSO) {
		_SOBOHOSO = SOBOHOSO;
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

	public String getGHICHU() {
		return _GHICHU;
	}

	public void setGHICHU(String GHICHU) {
		_GHICHU = GHICHU;
	}

	public int getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(int NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	private long _ID;
	private String _TENHOSO;
	private String _NGUOINOP;
	private String _CHUHOSO;
	private String _DIACHI;
	private String _SOBOHOSO;
	private String _LEPHI;
	private String _PHIHOSO;
	private String _TONGLEPHI;
	private String _GHICHU;
	private int _NHOMTHUTUCHANHCHINHID;
}