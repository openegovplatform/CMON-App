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

package org.oep.cmon.dao.dn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrangThaiDoanhNghiepLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       TrangThaiDoanhNghiepLocalService
 * @generated
 */
public class TrangThaiDoanhNghiepLocalServiceWrapper
	implements TrangThaiDoanhNghiepLocalService,
		ServiceWrapper<TrangThaiDoanhNghiepLocalService> {
	public TrangThaiDoanhNghiepLocalServiceWrapper(
		TrangThaiDoanhNghiepLocalService trangThaiDoanhNghiepLocalService) {
		_trangThaiDoanhNghiepLocalService = trangThaiDoanhNghiepLocalService;
	}

	/**
	* Adds the trang thai doanh nghiep to the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiDoanhNghiep the trang thai doanh nghiep
	* @return the trang thai doanh nghiep that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep addTrangThaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.addTrangThaiDoanhNghiep(trangThaiDoanhNghiep);
	}

	/**
	* Creates a new trang thai doanh nghiep with the primary key. Does not add the trang thai doanh nghiep to the database.
	*
	* @param id the primary key for the new trang thai doanh nghiep
	* @return the new trang thai doanh nghiep
	*/
	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep createTrangThaiDoanhNghiep(
		long id) {
		return _trangThaiDoanhNghiepLocalService.createTrangThaiDoanhNghiep(id);
	}

	/**
	* Deletes the trang thai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai doanh nghiep
	* @throws PortalException if a trang thai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_trangThaiDoanhNghiepLocalService.deleteTrangThaiDoanhNghiep(id);
	}

	/**
	* Deletes the trang thai doanh nghiep from the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiDoanhNghiep the trang thai doanh nghiep
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiDoanhNghiepLocalService.deleteTrangThaiDoanhNghiep(trangThaiDoanhNghiep);
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
		return _trangThaiDoanhNghiepLocalService.dynamicQuery(dynamicQuery);
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
		return _trangThaiDoanhNghiepLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _trangThaiDoanhNghiepLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _trangThaiDoanhNghiepLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep fetchTrangThaiDoanhNghiep(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.fetchTrangThaiDoanhNghiep(id);
	}

	/**
	* Returns the trang thai doanh nghiep with the primary key.
	*
	* @param id the primary key of the trang thai doanh nghiep
	* @return the trang thai doanh nghiep
	* @throws PortalException if a trang thai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep getTrangThaiDoanhNghiep(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.getTrangThaiDoanhNghiep(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trang thai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai doanh nghieps
	* @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	* @return the range of trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> getTrangThaiDoanhNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.getTrangThaiDoanhNghieps(start,
			end);
	}

	/**
	* Returns the number of trang thai doanh nghieps.
	*
	* @return the number of trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int getTrangThaiDoanhNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.getTrangThaiDoanhNghiepsCount();
	}

	/**
	* Updates the trang thai doanh nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiDoanhNghiep the trang thai doanh nghiep
	* @return the trang thai doanh nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep updateTrangThaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.updateTrangThaiDoanhNghiep(trangThaiDoanhNghiep);
	}

	/**
	* Updates the trang thai doanh nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiDoanhNghiep the trang thai doanh nghiep
	* @param merge whether to merge the trang thai doanh nghiep with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trang thai doanh nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep updateTrangThaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiDoanhNghiepLocalService.updateTrangThaiDoanhNghiep(trangThaiDoanhNghiep,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trangThaiDoanhNghiepLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trangThaiDoanhNghiepLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion find TrangThaiDoanhNghiep by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<TrangThaiDoanhNghiep>
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findDaXoa(
		int daXoa) {
		return _trangThaiDoanhNghiepLocalService.findDaXoa(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrangThaiDoanhNghiepLocalService getWrappedTrangThaiDoanhNghiepLocalService() {
		return _trangThaiDoanhNghiepLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrangThaiDoanhNghiepLocalService(
		TrangThaiDoanhNghiepLocalService trangThaiDoanhNghiepLocalService) {
		_trangThaiDoanhNghiepLocalService = trangThaiDoanhNghiepLocalService;
	}

	public TrangThaiDoanhNghiepLocalService getWrappedService() {
		return _trangThaiDoanhNghiepLocalService;
	}

	public void setWrappedService(
		TrangThaiDoanhNghiepLocalService trangThaiDoanhNghiepLocalService) {
		_trangThaiDoanhNghiepLocalService = trangThaiDoanhNghiepLocalService;
	}

	private TrangThaiDoanhNghiepLocalService _trangThaiDoanhNghiepLocalService;
}