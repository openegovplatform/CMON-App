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
 * This class is a wrapper for {@link TrangThaiHosoLocalService}.
 * </p>
 *
 * @author    NAM
 * @see       TrangThaiHosoLocalService
 * @generated
 */
public class TrangThaiHosoLocalServiceWrapper
	implements TrangThaiHosoLocalService,
		ServiceWrapper<TrangThaiHosoLocalService> {
	public TrangThaiHosoLocalServiceWrapper(
		TrangThaiHosoLocalService trangThaiHosoLocalService) {
		_trangThaiHosoLocalService = trangThaiHosoLocalService;
	}

	/**
	* Adds the trang thai hoso to the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoso the trang thai hoso
	* @return the trang thai hoso that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso addTrangThaiHoso(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.addTrangThaiHoso(trangThaiHoso);
	}

	/**
	* Creates a new trang thai hoso with the primary key. Does not add the trang thai hoso to the database.
	*
	* @param id the primary key for the new trang thai hoso
	* @return the new trang thai hoso
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso createTrangThaiHoso(
		long id) {
		return _trangThaiHosoLocalService.createTrangThaiHoso(id);
	}

	/**
	* Deletes the trang thai hoso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai hoso
	* @throws PortalException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiHoso(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_trangThaiHosoLocalService.deleteTrangThaiHoso(id);
	}

	/**
	* Deletes the trang thai hoso from the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoso the trang thai hoso
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiHoso(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso)
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiHosoLocalService.deleteTrangThaiHoso(trangThaiHoso);
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
		return _trangThaiHosoLocalService.dynamicQuery(dynamicQuery);
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
		return _trangThaiHosoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _trangThaiHosoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _trangThaiHosoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.exch.dao.hoso.model.TrangThaiHoso fetchTrangThaiHoso(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.fetchTrangThaiHoso(id);
	}

	/**
	* Returns the trang thai hoso with the primary key.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso
	* @throws PortalException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso getTrangThaiHoso(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.getTrangThaiHoso(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trang thai hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @return the range of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> getTrangThaiHosos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.getTrangThaiHosos(start, end);
	}

	/**
	* Returns the number of trang thai hosos.
	*
	* @return the number of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public int getTrangThaiHososCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.getTrangThaiHososCount();
	}

	/**
	* Updates the trang thai hoso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoso the trang thai hoso
	* @return the trang thai hoso that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso updateTrangThaiHoso(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.updateTrangThaiHoso(trangThaiHoso);
	}

	/**
	* Updates the trang thai hoso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoso the trang thai hoso
	* @param merge whether to merge the trang thai hoso with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trang thai hoso that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso updateTrangThaiHoso(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.updateTrangThaiHoso(trangThaiHoso,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trangThaiHosoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trangThaiHosoLocalService.setBeanIdentifier(beanIdentifier);
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
	* @param int trangThai
	* @return List<TrangThaiHoso>
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHosoLocalService.findByTrangThaiXuLy(trangThai);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrangThaiHosoLocalService getWrappedTrangThaiHosoLocalService() {
		return _trangThaiHosoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrangThaiHosoLocalService(
		TrangThaiHosoLocalService trangThaiHosoLocalService) {
		_trangThaiHosoLocalService = trangThaiHosoLocalService;
	}

	public TrangThaiHosoLocalService getWrappedService() {
		return _trangThaiHosoLocalService;
	}

	public void setWrappedService(
		TrangThaiHosoLocalService trangThaiHosoLocalService) {
		_trangThaiHosoLocalService = trangThaiHosoLocalService;
	}

	private TrangThaiHosoLocalService _trangThaiHosoLocalService;
}