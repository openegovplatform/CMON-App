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

import org.oep.cmon.dao.report.service.persistence.ReportThongKePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    VIENPN
 * @generated
 */
public class ReportThongKeSoap implements Serializable {
	public static ReportThongKeSoap toSoapModel(ReportThongKe model) {
		ReportThongKeSoap soapModel = new ReportThongKeSoap();

		soapModel.setCAPCOQUANQUANLYID(model.getCAPCOQUANQUANLYID());
		soapModel.setCOQUANQUANLYID(model.getCOQUANQUANLYID());
		soapModel.setTHANG(model.getTHANG());
		soapModel.setNAM(model.getNAM());
		soapModel.setTONGNHAN(model.getTONGNHAN());
		soapModel.setTIEPNHAN(model.getTIEPNHAN());
		soapModel.setTONDAU(model.getTONDAU());
		soapModel.setTONGDAGIAIQUYET(model.getTONGDAGIAIQUYET());
		soapModel.setSOM(model.getSOM());
		soapModel.setDUNG(model.getDUNG());
		soapModel.setTRE(model.getTRE());
		soapModel.setTONGDANGGIAIQUYET(model.getTONGDANGGIAIQUYET());
		soapModel.setCHUADENHAN(model.getCHUADENHAN());
		soapModel.setQUAHAN(model.getQUAHAN());
		soapModel.setRUTHOSO(model.getRUTHOSO());
		soapModel.setKHONGHOPLE(model.getKHONGHOPLE());
		soapModel.setTYLE(model.getTYLE());
		soapModel.setTONCUOI(model.getTONCUOI());

		return soapModel;
	}

	public static ReportThongKeSoap[] toSoapModels(ReportThongKe[] models) {
		ReportThongKeSoap[] soapModels = new ReportThongKeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReportThongKeSoap[][] toSoapModels(ReportThongKe[][] models) {
		ReportThongKeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReportThongKeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReportThongKeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReportThongKeSoap[] toSoapModels(List<ReportThongKe> models) {
		List<ReportThongKeSoap> soapModels = new ArrayList<ReportThongKeSoap>(models.size());

		for (ReportThongKe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReportThongKeSoap[soapModels.size()]);
	}

	public ReportThongKeSoap() {
	}

	public ReportThongKePK getPrimaryKey() {
		return new ReportThongKePK(_CAPCOQUANQUANLYID, _COQUANQUANLYID, _THANG,
			_NAM);
	}

	public void setPrimaryKey(ReportThongKePK pk) {
		setCAPCOQUANQUANLYID(pk.CAPCOQUANQUANLYID);
		setCOQUANQUANLYID(pk.COQUANQUANLYID);
		setTHANG(pk.THANG);
		setNAM(pk.NAM);
	}

	public long getCAPCOQUANQUANLYID() {
		return _CAPCOQUANQUANLYID;
	}

	public void setCAPCOQUANQUANLYID(long CAPCOQUANQUANLYID) {
		_CAPCOQUANQUANLYID = CAPCOQUANQUANLYID;
	}

	public long getCOQUANQUANLYID() {
		return _COQUANQUANLYID;
	}

	public void setCOQUANQUANLYID(long COQUANQUANLYID) {
		_COQUANQUANLYID = COQUANQUANLYID;
	}

	public int getTHANG() {
		return _THANG;
	}

	public void setTHANG(int THANG) {
		_THANG = THANG;
	}

	public int getNAM() {
		return _NAM;
	}

	public void setNAM(int NAM) {
		_NAM = NAM;
	}

	public long getTONGNHAN() {
		return _TONGNHAN;
	}

	public void setTONGNHAN(long TONGNHAN) {
		_TONGNHAN = TONGNHAN;
	}

	public long getTIEPNHAN() {
		return _TIEPNHAN;
	}

	public void setTIEPNHAN(long TIEPNHAN) {
		_TIEPNHAN = TIEPNHAN;
	}

	public long getTONDAU() {
		return _TONDAU;
	}

	public void setTONDAU(long TONDAU) {
		_TONDAU = TONDAU;
	}

	public long getTONGDAGIAIQUYET() {
		return _TONGDAGIAIQUYET;
	}

	public void setTONGDAGIAIQUYET(long TONGDAGIAIQUYET) {
		_TONGDAGIAIQUYET = TONGDAGIAIQUYET;
	}

	public long getSOM() {
		return _SOM;
	}

	public void setSOM(long SOM) {
		_SOM = SOM;
	}

	public long getDUNG() {
		return _DUNG;
	}

	public void setDUNG(long DUNG) {
		_DUNG = DUNG;
	}

	public long getTRE() {
		return _TRE;
	}

	public void setTRE(long TRE) {
		_TRE = TRE;
	}

	public long getTONGDANGGIAIQUYET() {
		return _TONGDANGGIAIQUYET;
	}

	public void setTONGDANGGIAIQUYET(long TONGDANGGIAIQUYET) {
		_TONGDANGGIAIQUYET = TONGDANGGIAIQUYET;
	}

	public long getCHUADENHAN() {
		return _CHUADENHAN;
	}

	public void setCHUADENHAN(long CHUADENHAN) {
		_CHUADENHAN = CHUADENHAN;
	}

	public long getQUAHAN() {
		return _QUAHAN;
	}

	public void setQUAHAN(long QUAHAN) {
		_QUAHAN = QUAHAN;
	}

	public long getRUTHOSO() {
		return _RUTHOSO;
	}

	public void setRUTHOSO(long RUTHOSO) {
		_RUTHOSO = RUTHOSO;
	}

	public long getKHONGHOPLE() {
		return _KHONGHOPLE;
	}

	public void setKHONGHOPLE(long KHONGHOPLE) {
		_KHONGHOPLE = KHONGHOPLE;
	}

	public double getTYLE() {
		return _TYLE;
	}

	public void setTYLE(double TYLE) {
		_TYLE = TYLE;
	}

	public long getTONCUOI() {
		return _TONCUOI;
	}

	public void setTONCUOI(long TONCUOI) {
		_TONCUOI = TONCUOI;
	}

	private long _CAPCOQUANQUANLYID;
	private long _COQUANQUANLYID;
	private int _THANG;
	private int _NAM;
	private long _TONGNHAN;
	private long _TIEPNHAN;
	private long _TONDAU;
	private long _TONGDAGIAIQUYET;
	private long _SOM;
	private long _DUNG;
	private long _TRE;
	private long _TONGDANGGIAIQUYET;
	private long _CHUADENHAN;
	private long _QUAHAN;
	private long _RUTHOSO;
	private long _KHONGHOPLE;
	private double _TYLE;
	private long _TONCUOI;
}