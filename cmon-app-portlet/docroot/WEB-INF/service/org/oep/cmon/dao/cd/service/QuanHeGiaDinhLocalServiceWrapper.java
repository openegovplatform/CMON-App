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
 * This class is a wrapper for {@link QuanHeGiaDinhLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       QuanHeGiaDinhLocalService
 * @generated
 */
public class QuanHeGiaDinhLocalServiceWrapper
	implements QuanHeGiaDinhLocalService,
		ServiceWrapper<QuanHeGiaDinhLocalService> {
	public QuanHeGiaDinhLocalServiceWrapper(
		QuanHeGiaDinhLocalService quanHeGiaDinhLocalService) {
		_quanHeGiaDinhLocalService = quanHeGiaDinhLocalService;
	}

	/**
	* Adds the quan he gia dinh to the database. Also notifies the appropriate model listeners.
	*
	* @param quanHeGiaDinh the quan he gia dinh
	* @return the quan he gia dinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh addQuanHeGiaDinh(
		org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.addQuanHeGiaDinh(quanHeGiaDinh);
	}

	/**
	* Creates a new quan he gia dinh with the primary key. Does not add the quan he gia dinh to the database.
	*
	* @param id the primary key for the new quan he gia dinh
	* @return the new quan he gia dinh
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh createQuanHeGiaDinh(long id) {
		return _quanHeGiaDinhLocalService.createQuanHeGiaDinh(id);
	}

	/**
	* Deletes the quan he gia dinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the quan he gia dinh
	* @throws PortalException if a quan he gia dinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteQuanHeGiaDinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_quanHeGiaDinhLocalService.deleteQuanHeGiaDinh(id);
	}

	/**
	* Deletes the quan he gia dinh from the database. Also notifies the appropriate model listeners.
	*
	* @param quanHeGiaDinh the quan he gia dinh
	* @throws SystemException if a system exception occurred
	*/
	public void deleteQuanHeGiaDinh(
		org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		_quanHeGiaDinhLocalService.deleteQuanHeGiaDinh(quanHeGiaDinh);
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
		return _quanHeGiaDinhLocalService.dynamicQuery(dynamicQuery);
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
		return _quanHeGiaDinhLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _quanHeGiaDinhLocalService.dynamicQuery(dynamicQuery, start,
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
		return _quanHeGiaDinhLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh fetchQuanHeGiaDinh(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.fetchQuanHeGiaDinh(id);
	}

	/**
	* Returns the quan he gia dinh with the primary key.
	*
	* @param id the primary key of the quan he gia dinh
	* @return the quan he gia dinh
	* @throws PortalException if a quan he gia dinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh getQuanHeGiaDinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.getQuanHeGiaDinh(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the quan he gia dinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quan he gia dinhs
	* @param end the upper bound of the range of quan he gia dinhs (not inclusive)
	* @return the range of quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> getQuanHeGiaDinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.getQuanHeGiaDinhs(start, end);
	}

	/**
	* Returns the number of quan he gia dinhs.
	*
	* @return the number of quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public int getQuanHeGiaDinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.getQuanHeGiaDinhsCount();
	}

	/**
	* Updates the quan he gia dinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param quanHeGiaDinh the quan he gia dinh
	* @return the quan he gia dinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh updateQuanHeGiaDinh(
		org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.updateQuanHeGiaDinh(quanHeGiaDinh);
	}

	/**
	* Updates the quan he gia dinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param quanHeGiaDinh the quan he gia dinh
	* @param merge whether to merge the quan he gia dinh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the quan he gia dinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh updateQuanHeGiaDinh(
		org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.updateQuanHeGiaDinh(quanHeGiaDinh,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _quanHeGiaDinhLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_quanHeGiaDinhLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion find QuanHeGiaDinh
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<QuanHeGiaDinh>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.findAll();
	}

	/**
	* This is fucntion find QuanHeGiaDinh by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<QuanHeGiaDinh>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findByStatus(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return _quanHeGiaDinhLocalService.findByStatus(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public QuanHeGiaDinhLocalService getWrappedQuanHeGiaDinhLocalService() {
		return _quanHeGiaDinhLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedQuanHeGiaDinhLocalService(
		QuanHeGiaDinhLocalService quanHeGiaDinhLocalService) {
		_quanHeGiaDinhLocalService = quanHeGiaDinhLocalService;
	}

	public QuanHeGiaDinhLocalService getWrappedService() {
		return _quanHeGiaDinhLocalService;
	}

	public void setWrappedService(
		QuanHeGiaDinhLocalService quanHeGiaDinhLocalService) {
		_quanHeGiaDinhLocalService = quanHeGiaDinhLocalService;
	}

	private QuanHeGiaDinhLocalService _quanHeGiaDinhLocalService;
}