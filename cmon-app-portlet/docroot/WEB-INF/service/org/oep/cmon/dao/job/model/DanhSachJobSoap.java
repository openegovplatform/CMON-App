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

package org.oep.cmon.dao.job.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    BinhNT
 * @generated
 */
public class DanhSachJobSoap implements Serializable {
	public static DanhSachJobSoap toSoapModel(DanhSachJob model) {
		DanhSachJobSoap soapModel = new DanhSachJobSoap();

		soapModel.setID(model.getID());
		soapModel.setJobClass(model.getJobClass());
		soapModel.setJobId(model.getJobId());
		soapModel.setJobName(model.getJobName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static DanhSachJobSoap[] toSoapModels(DanhSachJob[] models) {
		DanhSachJobSoap[] soapModels = new DanhSachJobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhSachJobSoap[][] toSoapModels(DanhSachJob[][] models) {
		DanhSachJobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhSachJobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhSachJobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhSachJobSoap[] toSoapModels(List<DanhSachJob> models) {
		List<DanhSachJobSoap> soapModels = new ArrayList<DanhSachJobSoap>(models.size());

		for (DanhSachJob model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhSachJobSoap[soapModels.size()]);
	}

	public DanhSachJobSoap() {
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

	public String getJobClass() {
		return _JobClass;
	}

	public void setJobClass(String JobClass) {
		_JobClass = JobClass;
	}

	public int getJobId() {
		return _JobId;
	}

	public void setJobId(int JobId) {
		_JobId = JobId;
	}

	public String getJobName() {
		return _JobName;
	}

	public void setJobName(String JobName) {
		_JobName = JobName;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	private long _ID;
	private String _JobClass;
	private int _JobId;
	private String _JobName;
	private String _Description;
}