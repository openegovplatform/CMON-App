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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK;

import java.io.Serializable;

/**
 * The base model interface for the Lephi_tonghop service. Represents a row in the &quot;Lephi_tonghop&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.oep.cmon.dao.report.model.impl.Lephi_tonghopModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.oep.cmon.dao.report.model.impl.Lephi_tonghopImpl}.
 * </p>
 *
 * @author VIENPN
 * @see Lephi_tonghop
 * @see org.oep.cmon.dao.report.model.impl.Lephi_tonghopImpl
 * @see org.oep.cmon.dao.report.model.impl.Lephi_tonghopModelImpl
 * @generated
 */
public interface Lephi_tonghopModel extends BaseModel<Lephi_tonghop> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a lephi_tonghop model instance should use the {@link Lephi_tonghop} interface instead.
	 */

	/**
	 * Returns the primary key of this lephi_tonghop.
	 *
	 * @return the primary key of this lephi_tonghop
	 */
	public Lephi_tonghopPK getPrimaryKey();

	/**
	 * Sets the primary key of this lephi_tonghop.
	 *
	 * @param primaryKey the primary key of this lephi_tonghop
	 */
	public void setPrimaryKey(Lephi_tonghopPK primaryKey);

	/**
	 * Returns the n h o m t h u t u c h a n h c h i n h i d of this lephi_tonghop.
	 *
	 * @return the n h o m t h u t u c h a n h c h i n h i d of this lephi_tonghop
	 */
	public int getNHOMTHUTUCHANHCHINHID();

	/**
	 * Sets the n h o m t h u t u c h a n h c h i n h i d of this lephi_tonghop.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the n h o m t h u t u c h a n h c h i n h i d of this lephi_tonghop
	 */
	public void setNHOMTHUTUCHANHCHINHID(int NHOMTHUTUCHANHCHINHID);

	/**
	 * Returns the t o n g h o s o of this lephi_tonghop.
	 *
	 * @return the t o n g h o s o of this lephi_tonghop
	 */
	@AutoEscape
	public String getTONGHOSO();

	/**
	 * Sets the t o n g h o s o of this lephi_tonghop.
	 *
	 * @param TONGHOSO the t o n g h o s o of this lephi_tonghop
	 */
	public void setTONGHOSO(String TONGHOSO);

	/**
	 * Returns the l e p h i of this lephi_tonghop.
	 *
	 * @return the l e p h i of this lephi_tonghop
	 */
	@AutoEscape
	public String getLEPHI();

	/**
	 * Sets the l e p h i of this lephi_tonghop.
	 *
	 * @param LEPHI the l e p h i of this lephi_tonghop
	 */
	public void setLEPHI(String LEPHI);

	/**
	 * Returns the p h i h o s o of this lephi_tonghop.
	 *
	 * @return the p h i h o s o of this lephi_tonghop
	 */
	@AutoEscape
	public String getPHIHOSO();

	/**
	 * Sets the p h i h o s o of this lephi_tonghop.
	 *
	 * @param PHIHOSO the p h i h o s o of this lephi_tonghop
	 */
	public void setPHIHOSO(String PHIHOSO);

	/**
	 * Returns the t o n g l e p h i of this lephi_tonghop.
	 *
	 * @return the t o n g l e p h i of this lephi_tonghop
	 */
	@AutoEscape
	public String getTONGLEPHI();

	/**
	 * Sets the t o n g l e p h i of this lephi_tonghop.
	 *
	 * @param TONGLEPHI the t o n g l e p h i of this lephi_tonghop
	 */
	public void setTONGLEPHI(String TONGLEPHI);

	/**
	 * Returns the t h a n g n h a n of this lephi_tonghop.
	 *
	 * @return the t h a n g n h a n of this lephi_tonghop
	 */
	@AutoEscape
	public String getTHANGNHAN();

	/**
	 * Sets the t h a n g n h a n of this lephi_tonghop.
	 *
	 * @param THANGNHAN the t h a n g n h a n of this lephi_tonghop
	 */
	public void setTHANGNHAN(String THANGNHAN);

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

	public int compareTo(Lephi_tonghop lephi_tonghop);

	public int hashCode();

	public CacheModel<Lephi_tonghop> toCacheModel();

	public Lephi_tonghop toEscapedModel();

	public String toString();

	public String toXmlString();
}