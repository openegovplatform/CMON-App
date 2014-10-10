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
public class BaocaochitietSoap implements Serializable {
	public static BaocaochitietSoap toSoapModel(Baocaochitiet model) {
		BaocaochitietSoap soapModel = new BaocaochitietSoap();

		soapModel.setLINHVUCID(model.getLINHVUCID());
		soapModel.setMASOHOSO(model.getMASOHOSO());
		soapModel.setTEN(model.getTEN());
		soapModel.setTRANGTHAI(model.getTRANGTHAI());
		soapModel.setDIACHIHIENNAY(model.getDIACHIHIENNAY());
		soapModel.setDIENTHOAIDIDONG(model.getDIENTHOAIDIDONG());
		soapModel.setHOTENNGUOINOPHOSO(model.getHOTENNGUOINOPHOSO());
		soapModel.setNGUOIDAIDIENPHAPLUAT(model.getNGUOIDAIDIENPHAPLUAT());
		soapModel.setNGAYNHANHOSO(model.getNGAYNHANHOSO());
		soapModel.setNGAYTRAKETQUA(model.getNGAYTRAKETQUA());
		soapModel.setNGAYHENTRAKETQUA(model.getNGAYHENTRAKETQUA());
		soapModel.setLINHVUC(model.getLINHVUC());
		soapModel.setGHICHU(model.getGHICHU());

		return soapModel;
	}

	public static BaocaochitietSoap[] toSoapModels(Baocaochitiet[] models) {
		BaocaochitietSoap[] soapModels = new BaocaochitietSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BaocaochitietSoap[][] toSoapModels(Baocaochitiet[][] models) {
		BaocaochitietSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BaocaochitietSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BaocaochitietSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BaocaochitietSoap[] toSoapModels(List<Baocaochitiet> models) {
		List<BaocaochitietSoap> soapModels = new ArrayList<BaocaochitietSoap>(models.size());

		for (Baocaochitiet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BaocaochitietSoap[soapModels.size()]);
	}

	public BaocaochitietSoap() {
	}

	public String getPrimaryKey() {
		return _MASOHOSO;
	}

	public void setPrimaryKey(String pk) {
		setMASOHOSO(pk);
	}

	public long getLINHVUCID() {
		return _LINHVUCID;
	}

	public void setLINHVUCID(long LINHVUCID) {
		_LINHVUCID = LINHVUCID;
	}

	public String getMASOHOSO() {
		return _MASOHOSO;
	}

	public void setMASOHOSO(String MASOHOSO) {
		_MASOHOSO = MASOHOSO;
	}

	public String getTEN() {
		return _TEN;
	}

	public void setTEN(String TEN) {
		_TEN = TEN;
	}

	public String getTRANGTHAI() {
		return _TRANGTHAI;
	}

	public void setTRANGTHAI(String TRANGTHAI) {
		_TRANGTHAI = TRANGTHAI;
	}

	public String getDIACHIHIENNAY() {
		return _DIACHIHIENNAY;
	}

	public void setDIACHIHIENNAY(String DIACHIHIENNAY) {
		_DIACHIHIENNAY = DIACHIHIENNAY;
	}

	public String getDIENTHOAIDIDONG() {
		return _DIENTHOAIDIDONG;
	}

	public void setDIENTHOAIDIDONG(String DIENTHOAIDIDONG) {
		_DIENTHOAIDIDONG = DIENTHOAIDIDONG;
	}

	public String getHOTENNGUOINOPHOSO() {
		return _HOTENNGUOINOPHOSO;
	}

	public void setHOTENNGUOINOPHOSO(String HOTENNGUOINOPHOSO) {
		_HOTENNGUOINOPHOSO = HOTENNGUOINOPHOSO;
	}

	public String getNGUOIDAIDIENPHAPLUAT() {
		return _NGUOIDAIDIENPHAPLUAT;
	}

	public void setNGUOIDAIDIENPHAPLUAT(String NGUOIDAIDIENPHAPLUAT) {
		_NGUOIDAIDIENPHAPLUAT = NGUOIDAIDIENPHAPLUAT;
	}

	public String getNGAYNHANHOSO() {
		return _NGAYNHANHOSO;
	}

	public void setNGAYNHANHOSO(String NGAYNHANHOSO) {
		_NGAYNHANHOSO = NGAYNHANHOSO;
	}

	public String getNGAYTRAKETQUA() {
		return _NGAYTRAKETQUA;
	}

	public void setNGAYTRAKETQUA(String NGAYTRAKETQUA) {
		_NGAYTRAKETQUA = NGAYTRAKETQUA;
	}

	public String getNGAYHENTRAKETQUA() {
		return _NGAYHENTRAKETQUA;
	}

	public void setNGAYHENTRAKETQUA(String NGAYHENTRAKETQUA) {
		_NGAYHENTRAKETQUA = NGAYHENTRAKETQUA;
	}

	public String getLINHVUC() {
		return _LINHVUC;
	}

	public void setLINHVUC(String LINHVUC) {
		_LINHVUC = LINHVUC;
	}

	public String getGHICHU() {
		return _GHICHU;
	}

	public void setGHICHU(String GHICHU) {
		_GHICHU = GHICHU;
	}

	private long _LINHVUCID;
	private String _MASOHOSO;
	private String _TEN;
	private String _TRANGTHAI;
	private String _DIACHIHIENNAY;
	private String _DIENTHOAIDIDONG;
	private String _HOTENNGUOINOPHOSO;
	private String _NGUOIDAIDIENPHAPLUAT;
	private String _NGAYNHANHOSO;
	private String _NGAYTRAKETQUA;
	private String _NGAYHENTRAKETQUA;
	private String _LINHVUC;
	private String _GHICHU;
}