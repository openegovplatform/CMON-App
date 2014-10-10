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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.report.service.DanhMucBaoCaoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class DanhMucBaoCaoClp extends BaseModelImpl<DanhMucBaoCao>
	implements DanhMucBaoCao {
	public DanhMucBaoCaoClp() {
	}

	public Class<?> getModelClass() {
		return DanhMucBaoCao.class;
	}

	public String getModelClassName() {
		return DanhMucBaoCao.class.getName();
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long primaryKey) {
		setID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhMucBaoCaoLocalServiceUtil.addDanhMucBaoCao(this);
		}
		else {
			DanhMucBaoCaoLocalServiceUtil.updateDanhMucBaoCao(this);
		}
	}

	@Override
	public DanhMucBaoCao toEscapedModel() {
		return (DanhMucBaoCao)Proxy.newProxyInstance(DanhMucBaoCao.class.getClassLoader(),
			new Class[] { DanhMucBaoCao.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhMucBaoCaoClp clone = new DanhMucBaoCaoClp();

		clone.setID(getID());
		clone.setTENBAOCAO(getTENBAOCAO());
		clone.setDUONGDAN(getDUONGDAN());
		clone.setORDERS(getORDERS());
		clone.setSTATUS(getSTATUS());
		clone.setPUBLISH(getPUBLISH());

		return clone;
	}

	public int compareTo(DanhMucBaoCao danhMucBaoCao) {
		int value = 0;

		if (getID() < danhMucBaoCao.getID()) {
			value = -1;
		}
		else if (getID() > danhMucBaoCao.getID()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DanhMucBaoCaoClp danhMucBaoCao = null;

		try {
			danhMucBaoCao = (DanhMucBaoCaoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhMucBaoCao.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", TENBAOCAO=");
		sb.append(getTENBAOCAO());
		sb.append(", DUONGDAN=");
		sb.append(getDUONGDAN());
		sb.append(", ORDERS=");
		sb.append(getORDERS());
		sb.append(", STATUS=");
		sb.append(getSTATUS());
		sb.append(", PUBLISH=");
		sb.append(getPUBLISH());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.DanhMucBaoCao");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TENBAOCAO</column-name><column-value><![CDATA[");
		sb.append(getTENBAOCAO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DUONGDAN</column-name><column-value><![CDATA[");
		sb.append(getDUONGDAN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ORDERS</column-name><column-value><![CDATA[");
		sb.append(getORDERS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>STATUS</column-name><column-value><![CDATA[");
		sb.append(getSTATUS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PUBLISH</column-name><column-value><![CDATA[");
		sb.append(getPUBLISH());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private String _TENBAOCAO;
	private String _DUONGDAN;
	private int _ORDERS;
	private int _STATUS;
	private int _PUBLISH;
}