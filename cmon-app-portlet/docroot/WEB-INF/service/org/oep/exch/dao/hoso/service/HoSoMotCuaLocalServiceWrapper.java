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

package org.oep.exch.dao.hoso.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoMotCuaLocalService}.
 * </p>
 *
 * @author    NAM
 * @see       HoSoMotCuaLocalService
 * @generated
 */
public class HoSoMotCuaLocalServiceWrapper implements HoSoMotCuaLocalService,
	ServiceWrapper<HoSoMotCuaLocalService> {
	public HoSoMotCuaLocalServiceWrapper(
		HoSoMotCuaLocalService hoSoMotCuaLocalService) {
		_hoSoMotCuaLocalService = hoSoMotCuaLocalService;
	}

	/**
	* Adds the ho so mot cua to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoMotCua the ho so mot cua
	* @return the ho so mot cua that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua addHoSoMotCua(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.addHoSoMotCua(hoSoMotCua);
	}

	/**
	* Creates a new ho so mot cua with the primary key. Does not add the ho so mot cua to the database.
	*
	* @param id the primary key for the new ho so mot cua
	* @return the new ho so mot cua
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua createHoSoMotCua(long id) {
		return _hoSoMotCuaLocalService.createHoSoMotCua(id);
	}

	/**
	* Deletes the ho so mot cua with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so mot cua
	* @throws PortalException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoMotCua(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_hoSoMotCuaLocalService.deleteHoSoMotCua(id);
	}

	/**
	* Deletes the ho so mot cua from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoMotCua the ho so mot cua
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoMotCua(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua)
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoMotCuaLocalService.deleteHoSoMotCua(hoSoMotCua);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.exch.dao.hoso.model.HoSoMotCua fetchHoSoMotCua(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.fetchHoSoMotCua(id);
	}

	/**
	* Returns the ho so mot cua with the primary key.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua
	* @throws PortalException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua getHoSoMotCua(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.getHoSoMotCua(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ho so mot cuas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> getHoSoMotCuas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.getHoSoMotCuas(start, end);
	}

	/**
	* Returns the number of ho so mot cuas.
	*
	* @return the number of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public int getHoSoMotCuasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.getHoSoMotCuasCount();
	}

	/**
	* Updates the ho so mot cua in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoMotCua the ho so mot cua
	* @return the ho so mot cua that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua updateHoSoMotCua(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.updateHoSoMotCua(hoSoMotCua);
	}

	/**
	* Updates the ho so mot cua in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoMotCua the ho so mot cua
	* @param merge whether to merge the ho so mot cua with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so mot cua that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua updateHoSoMotCua(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.updateHoSoMotCua(hoSoMotCua, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _hoSoMotCuaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hoSoMotCuaLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findByTrangThaiXuLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int trangThaiXuLy
	* @return List<HoSoMotCua>
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int trangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.findByTrangThaiXuLy(trangThaiXuLy);
	}

	/**
	* This is fucntion findByMaSoHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo, int trangThaiXuLy
	* @return List<HoSoMotCua>
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String maSoHoSo, int trangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoMotCuaLocalService.findByMaSoHoSo(maSoHoSo, trangThaiXuLy);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public HoSoMotCuaLocalService getWrappedHoSoMotCuaLocalService() {
		return _hoSoMotCuaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedHoSoMotCuaLocalService(
		HoSoMotCuaLocalService hoSoMotCuaLocalService) {
		_hoSoMotCuaLocalService = hoSoMotCuaLocalService;
	}

	public HoSoMotCuaLocalService getWrappedService() {
		return _hoSoMotCuaLocalService;
	}

	public void setWrappedService(HoSoMotCuaLocalService hoSoMotCuaLocalService) {
		_hoSoMotCuaLocalService = hoSoMotCuaLocalService;
	}

	private HoSoMotCuaLocalService _hoSoMotCuaLocalService;
}