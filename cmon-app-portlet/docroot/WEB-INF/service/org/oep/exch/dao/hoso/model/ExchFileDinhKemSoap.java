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

package org.oep.exch.dao.hoso.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    NAM
 * @generated
 */
public class ExchFileDinhKemSoap implements Serializable {
	public static ExchFileDinhKemSoap toSoapModel(ExchFileDinhKem model) {
		ExchFileDinhKemSoap soapModel = new ExchFileDinhKemSoap();

		soapModel.setId(model.getId());
		soapModel.setOnlineId(model.getOnlineId());
		soapModel.setTenTaiLieuDinhKem(model.getTenTaiLieuDinhKem());
		soapModel.setUrlTaiLieuDinhKem(model.getUrlTaiLieuDinhKem());
		soapModel.setTenFile(model.getTenFile());

		return soapModel;
	}

	public static ExchFileDinhKemSoap[] toSoapModels(ExchFileDinhKem[] models) {
		ExchFileDinhKemSoap[] soapModels = new ExchFileDinhKemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExchFileDinhKemSoap[][] toSoapModels(
		ExchFileDinhKem[][] models) {
		ExchFileDinhKemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExchFileDinhKemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExchFileDinhKemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExchFileDinhKemSoap[] toSoapModels(
		List<ExchFileDinhKem> models) {
		List<ExchFileDinhKemSoap> soapModels = new ArrayList<ExchFileDinhKemSoap>(models.size());

		for (ExchFileDinhKem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExchFileDinhKemSoap[soapModels.size()]);
	}

	public ExchFileDinhKemSoap() {
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

	public long getOnlineId() {
		return _OnlineId;
	}

	public void setOnlineId(long OnlineId) {
		_OnlineId = OnlineId;
	}

	public String getTenTaiLieuDinhKem() {
		return _TenTaiLieuDinhKem;
	}

	public void setTenTaiLieuDinhKem(String TenTaiLieuDinhKem) {
		_TenTaiLieuDinhKem = TenTaiLieuDinhKem;
	}

	public String getUrlTaiLieuDinhKem() {
		return _UrlTaiLieuDinhKem;
	}

	public void setUrlTaiLieuDinhKem(String UrlTaiLieuDinhKem) {
		_UrlTaiLieuDinhKem = UrlTaiLieuDinhKem;
	}

	public String getTenFile() {
		return _TenFile;
	}

	public void setTenFile(String TenFile) {
		_TenFile = TenFile;
	}

	private long _id;
	private long _OnlineId;
	private String _TenTaiLieuDinhKem;
	private String _UrlTaiLieuDinhKem;
	private String _TenFile;
}