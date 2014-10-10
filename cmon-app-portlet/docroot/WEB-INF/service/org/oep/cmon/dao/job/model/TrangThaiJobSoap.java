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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    BinhNT
 * @generated
 */
public class TrangThaiJobSoap implements Serializable {
	public static TrangThaiJobSoap toSoapModel(TrangThaiJob model) {
		TrangThaiJobSoap soapModel = new TrangThaiJobSoap();

		soapModel.setID(model.getID());
		soapModel.setJobId(model.getJobId());
		soapModel.setJobName(model.getJobName());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setStatus(model.getStatus());
		soapModel.setRunMode(model.getRunMode());
		soapModel.setMessage(model.getMessage());

		return soapModel;
	}

	public static TrangThaiJobSoap[] toSoapModels(TrangThaiJob[] models) {
		TrangThaiJobSoap[] soapModels = new TrangThaiJobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiJobSoap[][] toSoapModels(TrangThaiJob[][] models) {
		TrangThaiJobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrangThaiJobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrangThaiJobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiJobSoap[] toSoapModels(List<TrangThaiJob> models) {
		List<TrangThaiJobSoap> soapModels = new ArrayList<TrangThaiJobSoap>(models.size());

		for (TrangThaiJob model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrangThaiJobSoap[soapModels.size()]);
	}

	public TrangThaiJobSoap() {
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

	public Date getStartTime() {
		return _StartTime;
	}

	public void setStartTime(Date StartTime) {
		_StartTime = StartTime;
	}

	public Date getEndTime() {
		return _EndTime;
	}

	public void setEndTime(Date EndTime) {
		_EndTime = EndTime;
	}

	public int getStatus() {
		return _Status;
	}

	public void setStatus(int Status) {
		_Status = Status;
	}

	public int getRunMode() {
		return _RunMode;
	}

	public void setRunMode(int RunMode) {
		_RunMode = RunMode;
	}

	public String getMessage() {
		return _Message;
	}

	public void setMessage(String Message) {
		_Message = Message;
	}

	private long _ID;
	private int _JobId;
	private String _JobName;
	private Date _StartTime;
	private Date _EndTime;
	private int _Status;
	private int _RunMode;
	private String _Message;
}