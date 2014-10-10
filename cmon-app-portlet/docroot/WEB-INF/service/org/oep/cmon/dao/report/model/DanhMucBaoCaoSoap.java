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
public class DanhMucBaoCaoSoap implements Serializable {
	public static DanhMucBaoCaoSoap toSoapModel(DanhMucBaoCao model) {
		DanhMucBaoCaoSoap soapModel = new DanhMucBaoCaoSoap();

		soapModel.setID(model.getID());
		soapModel.setTENBAOCAO(model.getTENBAOCAO());
		soapModel.setDUONGDAN(model.getDUONGDAN());
		soapModel.setORDERS(model.getORDERS());
		soapModel.setSTATUS(model.getSTATUS());
		soapModel.setPUBLISH(model.getPUBLISH());

		return soapModel;
	}

	public static DanhMucBaoCaoSoap[] toSoapModels(DanhMucBaoCao[] models) {
		DanhMucBaoCaoSoap[] soapModels = new DanhMucBaoCaoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhMucBaoCaoSoap[][] toSoapModels(DanhMucBaoCao[][] models) {
		DanhMucBaoCaoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhMucBaoCaoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhMucBaoCaoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhMucBaoCaoSoap[] toSoapModels(List<DanhMucBaoCao> models) {
		List<DanhMucBaoCaoSoap> soapModels = new ArrayList<DanhMucBaoCaoSoap>(models.size());

		for (DanhMucBaoCao model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhMucBaoCaoSoap[soapModels.size()]);
	}

	public DanhMucBaoCaoSoap() {
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

	public String getTENBAOCAO() {
		return _TENBAOCAO;
	}

	public void setTENBAOCAO(String TENBAOCAO) {
		_TENBAOCAO = TENBAOCAO;
	}

	public String getDUONGDAN() {
		return _DUONGDAN;
	}

	public void setDUONGDAN(String DUONGDAN) {
		_DUONGDAN = DUONGDAN;
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

	public int getPUBLISH() {
		return _PUBLISH;
	}

	public void setPUBLISH(int PUBLISH) {
		_PUBLISH = PUBLISH;
	}

	private long _ID;
	private String _TENBAOCAO;
	private String _DUONGDAN;
	private int _ORDERS;
	private int _STATUS;
	private int _PUBLISH;
}