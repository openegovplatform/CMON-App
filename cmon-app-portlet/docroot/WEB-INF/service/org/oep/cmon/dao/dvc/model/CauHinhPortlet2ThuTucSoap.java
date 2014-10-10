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

package org.oep.cmon.dao.dvc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    liemnn
 * @generated
 */
public class CauHinhPortlet2ThuTucSoap implements Serializable {
	public static CauHinhPortlet2ThuTucSoap toSoapModel(
		CauHinhPortlet2ThuTuc model) {
		CauHinhPortlet2ThuTucSoap soapModel = new CauHinhPortlet2ThuTucSoap();

		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setPortletName(model.getPortletName());

		return soapModel;
	}

	public static CauHinhPortlet2ThuTucSoap[] toSoapModels(
		CauHinhPortlet2ThuTuc[] models) {
		CauHinhPortlet2ThuTucSoap[] soapModels = new CauHinhPortlet2ThuTucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CauHinhPortlet2ThuTucSoap[][] toSoapModels(
		CauHinhPortlet2ThuTuc[][] models) {
		CauHinhPortlet2ThuTucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CauHinhPortlet2ThuTucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CauHinhPortlet2ThuTucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CauHinhPortlet2ThuTucSoap[] toSoapModels(
		List<CauHinhPortlet2ThuTuc> models) {
		List<CauHinhPortlet2ThuTucSoap> soapModels = new ArrayList<CauHinhPortlet2ThuTucSoap>(models.size());

		for (CauHinhPortlet2ThuTuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CauHinhPortlet2ThuTucSoap[soapModels.size()]);
	}

	public CauHinhPortlet2ThuTucSoap() {
	}

	public long getPrimaryKey() {
		return _thuTucHanhChinhId;
	}

	public void setPrimaryKey(long pk) {
		setThuTucHanhChinhId(pk);
	}

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public long getPortletId() {
		return _portletId;
	}

	public void setPortletId(long portletId) {
		_portletId = portletId;
	}

	public String getPortletName() {
		return _portletName;
	}

	public void setPortletName(String portletName) {
		_portletName = portletName;
	}

	private long _thuTucHanhChinhId;
	private long _portletId;
	private String _portletName;
}