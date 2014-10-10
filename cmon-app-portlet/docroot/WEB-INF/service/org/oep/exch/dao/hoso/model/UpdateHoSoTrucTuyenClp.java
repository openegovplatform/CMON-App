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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.exch.dao.hoso.service.UpdateHoSoTrucTuyenLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author NAM
 */
public class UpdateHoSoTrucTuyenClp extends BaseModelImpl<UpdateHoSoTrucTuyen>
	implements UpdateHoSoTrucTuyen {
	public UpdateHoSoTrucTuyenClp() {
	}

	public Class<?> getModelClass() {
		return UpdateHoSoTrucTuyen.class;
	}

	public String getModelClassName() {
		return UpdateHoSoTrucTuyen.class.getName();
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

	public int getTrangThaiXuLy() {
		return _TrangThaiXuLy;
	}

	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_TrangThaiXuLy = TrangThaiXuLy;
	}

	public Date getNgayChuyen() {
		return _NgayChuyen;
	}

	public void setNgayChuyen(Date NgayChuyen) {
		_NgayChuyen = NgayChuyen;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UpdateHoSoTrucTuyenLocalServiceUtil.addUpdateHoSoTrucTuyen(this);
		}
		else {
			UpdateHoSoTrucTuyenLocalServiceUtil.updateUpdateHoSoTrucTuyen(this);
		}
	}

	@Override
	public UpdateHoSoTrucTuyen toEscapedModel() {
		return (UpdateHoSoTrucTuyen)Proxy.newProxyInstance(UpdateHoSoTrucTuyen.class.getClassLoader(),
			new Class[] { UpdateHoSoTrucTuyen.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UpdateHoSoTrucTuyenClp clone = new UpdateHoSoTrucTuyenClp();

		clone.setId(getId());
		clone.setTrangThaiXuLy(getTrangThaiXuLy());
		clone.setNgayChuyen(getNgayChuyen());

		return clone;
	}

	public int compareTo(UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		long primaryKey = updateHoSoTrucTuyen.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UpdateHoSoTrucTuyenClp updateHoSoTrucTuyen = null;

		try {
			updateHoSoTrucTuyen = (UpdateHoSoTrucTuyenClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = updateHoSoTrucTuyen.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", TrangThaiXuLy=");
		sb.append(getTrangThaiXuLy());
		sb.append(", NgayChuyen=");
		sb.append(getNgayChuyen());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThaiXuLy</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayChuyen</column-name><column-value><![CDATA[");
		sb.append(getNgayChuyen());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private int _TrangThaiXuLy;
	private Date _NgayChuyen;
}