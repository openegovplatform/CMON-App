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

package org.oep.cmon.dao.cd.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NgheNghiepLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       NgheNghiepLocalService
 * @generated
 */
public class NgheNghiepLocalServiceWrapper implements NgheNghiepLocalService,
	ServiceWrapper<NgheNghiepLocalService> {
	public NgheNghiepLocalServiceWrapper(
		NgheNghiepLocalService ngheNghiepLocalService) {
		_ngheNghiepLocalService = ngheNghiepLocalService;
	}

	/**
	* Adds the nghe nghiep to the database. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @return the nghe nghiep that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.NgheNghiep addNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.addNgheNghiep(ngheNghiep);
	}

	/**
	* Creates a new nghe nghiep with the primary key. Does not add the nghe nghiep to the database.
	*
	* @param id the primary key for the new nghe nghiep
	* @return the new nghe nghiep
	*/
	public org.oep.cmon.dao.cd.model.NgheNghiep createNgheNghiep(long id) {
		return _ngheNghiepLocalService.createNgheNghiep(id);
	}

	/**
	* Deletes the nghe nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nghe nghiep
	* @throws PortalException if a nghe nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNgheNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ngheNghiepLocalService.deleteNgheNghiep(id);
	}

	/**
	* Deletes the nghe nghiep from the database. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ngheNghiepLocalService.deleteNgheNghiep(ngheNghiep);
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
		return _ngheNghiepLocalService.dynamicQuery(dynamicQuery);
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
		return _ngheNghiepLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _ngheNghiepLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ngheNghiepLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cd.model.NgheNghiep fetchNgheNghiep(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.fetchNgheNghiep(id);
	}

	/**
	* Returns the nghe nghiep with the primary key.
	*
	* @param id the primary key of the nghe nghiep
	* @return the nghe nghiep
	* @throws PortalException if a nghe nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.NgheNghiep getNgheNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.getNgheNghiep(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the nghe nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nghe nghieps
	* @param end the upper bound of the range of nghe nghieps (not inclusive)
	* @return the range of nghe nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.NgheNghiep> getNgheNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.getNgheNghieps(start, end);
	}

	/**
	* Returns the number of nghe nghieps.
	*
	* @return the number of nghe nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int getNgheNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.getNgheNghiepsCount();
	}

	/**
	* Updates the nghe nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @return the nghe nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.NgheNghiep updateNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.updateNgheNghiep(ngheNghiep);
	}

	/**
	* Updates the nghe nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @param merge whether to merge the nghe nghiep with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the nghe nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.NgheNghiep updateNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.updateNgheNghiep(ngheNghiep, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ngheNghiepLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ngheNghiepLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findAll NgheNghiep by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<NgheNghiep>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.NgheNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ngheNghiepLocalService.findAll();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NgheNghiepLocalService getWrappedNgheNghiepLocalService() {
		return _ngheNghiepLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNgheNghiepLocalService(
		NgheNghiepLocalService ngheNghiepLocalService) {
		_ngheNghiepLocalService = ngheNghiepLocalService;
	}

	public NgheNghiepLocalService getWrappedService() {
		return _ngheNghiepLocalService;
	}

	public void setWrappedService(NgheNghiepLocalService ngheNghiepLocalService) {
		_ngheNghiepLocalService = ngheNghiepLocalService;
	}

	private NgheNghiepLocalService _ngheNghiepLocalService;
}