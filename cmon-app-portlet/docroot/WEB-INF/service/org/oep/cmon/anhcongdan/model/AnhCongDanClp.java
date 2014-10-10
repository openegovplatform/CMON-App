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

package org.oep.cmon.anhcongdan.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.anhcongdan.service.AnhCongDanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author BinhNT
 */
public class AnhCongDanClp extends BaseModelImpl<AnhCongDan>
	implements AnhCongDan {
	public AnhCongDanClp() {
	}

	public Class<?> getModelClass() {
		return AnhCongDan.class;
	}

	public String getModelClassName() {
		return AnhCongDan.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAnh() {
		return _anh;
	}

	public void setAnh(String anh) {
		_anh = anh;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AnhCongDanLocalServiceUtil.addAnhCongDan(this);
		}
		else {
			AnhCongDanLocalServiceUtil.updateAnhCongDan(this);
		}
	}

	@Override
	public AnhCongDan toEscapedModel() {
		return (AnhCongDan)Proxy.newProxyInstance(AnhCongDan.class.getClassLoader(),
			new Class[] { AnhCongDan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnhCongDanClp clone = new AnhCongDanClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setEmail(getEmail());
		clone.setAnh(getAnh());

		return clone;
	}

	public int compareTo(AnhCongDan anhCongDan) {
		int value = 0;

		if (getId() < anhCongDan.getId()) {
			value = -1;
		}
		else if (getId() > anhCongDan.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		AnhCongDanClp anhCongDan = null;

		try {
			anhCongDan = (AnhCongDanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = anhCongDan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", anh=");
		sb.append(getAnh());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.anhcongdan.model.AnhCongDan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anh</column-name><column-value><![CDATA[");
		sb.append(getAnh());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _email;
	private String _anh;
}