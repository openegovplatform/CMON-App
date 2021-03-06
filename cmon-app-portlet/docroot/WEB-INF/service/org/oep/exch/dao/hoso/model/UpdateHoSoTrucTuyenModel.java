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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UpdateHoSoTrucTuyen service. Represents a row in the &quot;exch_hosotructuyen&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenImpl}.
 * </p>
 *
 * @author NAM
 * @see UpdateHoSoTrucTuyen
 * @see org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenImpl
 * @see org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenModelImpl
 * @generated
 */
public interface UpdateHoSoTrucTuyenModel extends BaseModel<UpdateHoSoTrucTuyen> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a update ho so truc tuyen model instance should use the {@link UpdateHoSoTrucTuyen} interface instead.
	 */

	/**
	 * Returns the primary key of this update ho so truc tuyen.
	 *
	 * @return the primary key of this update ho so truc tuyen
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this update ho so truc tuyen.
	 *
	 * @param primaryKey the primary key of this update ho so truc tuyen
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this update ho so truc tuyen.
	 *
	 * @return the ID of this update ho so truc tuyen
	 */
	public long getId();

	/**
	 * Sets the ID of this update ho so truc tuyen.
	 *
	 * @param id the ID of this update ho so truc tuyen
	 */
	public void setId(long id);

	/**
	 * Returns the trang thai xu ly of this update ho so truc tuyen.
	 *
	 * @return the trang thai xu ly of this update ho so truc tuyen
	 */
	public int getTrangThaiXuLy();

	/**
	 * Sets the trang thai xu ly of this update ho so truc tuyen.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly of this update ho so truc tuyen
	 */
	public void setTrangThaiXuLy(int TrangThaiXuLy);

	/**
	 * Returns the ngay chuyen of this update ho so truc tuyen.
	 *
	 * @return the ngay chuyen of this update ho so truc tuyen
	 */
	public Date getNgayChuyen();

	/**
	 * Sets the ngay chuyen of this update ho so truc tuyen.
	 *
	 * @param NgayChuyen the ngay chuyen of this update ho so truc tuyen
	 */
	public void setNgayChuyen(Date NgayChuyen);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UpdateHoSoTrucTuyen updateHoSoTrucTuyen);

	public int hashCode();

	public CacheModel<UpdateHoSoTrucTuyen> toCacheModel();

	public UpdateHoSoTrucTuyen toEscapedModel();

	public String toString();

	public String toXmlString();
}