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

package org.oep.cmon.dao.touchscreen.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TouchScreen}.
 * </p>
 *
 * @author    VIENPN
 * @see       TouchScreen
 * @generated
 */
public class TouchScreenWrapper implements TouchScreen,
	ModelWrapper<TouchScreen> {
	public TouchScreenWrapper(TouchScreen touchScreen) {
		_touchScreen = touchScreen;
	}

	public Class<?> getModelClass() {
		return TouchScreen.class;
	}

	public String getModelClassName() {
		return TouchScreen.class.getName();
	}

	/**
	* Returns the primary key of this touch screen.
	*
	* @return the primary key of this touch screen
	*/
	public long getPrimaryKey() {
		return _touchScreen.getPrimaryKey();
	}

	/**
	* Sets the primary key of this touch screen.
	*
	* @param primaryKey the primary key of this touch screen
	*/
	public void setPrimaryKey(long primaryKey) {
		_touchScreen.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this touch screen.
	*
	* @return the i d of this touch screen
	*/
	public long getID() {
		return _touchScreen.getID();
	}

	/**
	* Sets the i d of this touch screen.
	*
	* @param ID the i d of this touch screen
	*/
	public void setID(long ID) {
		_touchScreen.setID(ID);
	}

	/**
	* Returns the n a m e of this touch screen.
	*
	* @return the n a m e of this touch screen
	*/
	public java.lang.String getNAME() {
		return _touchScreen.getNAME();
	}

	/**
	* Sets the n a m e of this touch screen.
	*
	* @param NAME the n a m e of this touch screen
	*/
	public void setNAME(java.lang.String NAME) {
		_touchScreen.setNAME(NAME);
	}

	public boolean isNew() {
		return _touchScreen.isNew();
	}

	public void setNew(boolean n) {
		_touchScreen.setNew(n);
	}

	public boolean isCachedModel() {
		return _touchScreen.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_touchScreen.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _touchScreen.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _touchScreen.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_touchScreen.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _touchScreen.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_touchScreen.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TouchScreenWrapper((TouchScreen)_touchScreen.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen) {
		return _touchScreen.compareTo(touchScreen);
	}

	@Override
	public int hashCode() {
		return _touchScreen.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.touchscreen.model.TouchScreen> toCacheModel() {
		return _touchScreen.toCacheModel();
	}

	public org.oep.cmon.dao.touchscreen.model.TouchScreen toEscapedModel() {
		return new TouchScreenWrapper(_touchScreen.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _touchScreen.toString();
	}

	public java.lang.String toXmlString() {
		return _touchScreen.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_touchScreen.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TouchScreen getWrappedTouchScreen() {
		return _touchScreen;
	}

	public TouchScreen getWrappedModel() {
		return _touchScreen;
	}

	public void resetOriginalValues() {
		_touchScreen.resetOriginalValues();
	}

	private TouchScreen _touchScreen;
}