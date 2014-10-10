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
public class LogMailSoap implements Serializable {
	public static LogMailSoap toSoapModel(LogMail model) {
		LogMailSoap soapModel = new LogMailSoap();

		soapModel.setId(model.getId());
		soapModel.setType(model.getType());
		soapModel.setHoSoTTHCCongId(model.getHoSoTTHCCongId());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static LogMailSoap[] toSoapModels(LogMail[] models) {
		LogMailSoap[] soapModels = new LogMailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogMailSoap[][] toSoapModels(LogMail[][] models) {
		LogMailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogMailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogMailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogMailSoap[] toSoapModels(List<LogMail> models) {
		List<LogMailSoap> soapModels = new ArrayList<LogMailSoap>(models.size());

		for (LogMail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogMailSoap[soapModels.size()]);
	}

	public LogMailSoap() {
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Date getCreateTime() {
		return _createTime;
	}

	public void setCreateTime(Date createTime) {
		_createTime = createTime;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _id;
	private String _type;
	private long _hoSoTTHCCongId;
	private Date _createTime;
	private int _status;
	private String _description;
}