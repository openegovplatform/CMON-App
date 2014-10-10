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
 * This class is a wrapper for {@link LoaiDoanhNghiepLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       LoaiDoanhNghiepLocalService
 * @generated
 */
public class LoaiDoanhNghiepLocalServiceWrapper
	implements LoaiDoanhNghiepLocalService,
		ServiceWrapper<LoaiDoanhNghiepLocalService> {
	public LoaiDoanhNghiepLocalServiceWrapper(
		LoaiDoanhNghiepLocalService loaiDoanhNghiepLocalService) {
		_loaiDoanhNghiepLocalService = loaiDoanhNghiepLocalService;
	}

	/**
	* Adds the loai doanh nghiep to the database. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @return the loai doanh nghiep that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep addLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.addLoaiDoanhNghiep(loaiDoanhNghiep);
	}

	/**
	* Creates a new loai doanh nghiep with the primary key. Does not add the loai doanh nghiep to the database.
	*
	* @param id the primary key for the new loai doanh nghiep
	* @return the new loai doanh nghiep
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep createLoaiDoanhNghiep(
		long id) {
		return _loaiDoanhNghiepLocalService.createLoaiDoanhNghiep(id);
	}

	/**
	* Deletes the loai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loai doanh nghiep
	* @throws PortalException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLoaiDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_loaiDoanhNghiepLocalService.deleteLoaiDoanhNghiep(id);
	}

	/**
	* Deletes the loai doanh nghiep from the database. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		_loaiDoanhNghiepLocalService.deleteLoaiDoanhNghiep(loaiDoanhNghiep);
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
		return _loaiDoanhNghiepLocalService.dynamicQuery(dynamicQuery);
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
		return _loaiDoanhNghiepLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _loaiDoanhNghiepLocalService.dynamicQuery(dynamicQuery, start,
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
		return _loaiDoanhNghiepLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchLoaiDoanhNghiep(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.fetchLoaiDoanhNghiep(id);
	}

	/**
	* Returns the loai doanh nghiep with the primary key.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep
	* @throws PortalException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep getLoaiDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.getLoaiDoanhNghiep(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the loai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @return the range of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> getLoaiDoanhNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.getLoaiDoanhNghieps(start, end);
	}

	/**
	* Returns the number of loai doanh nghieps.
	*
	* @return the number of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int getLoaiDoanhNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.getLoaiDoanhNghiepsCount();
	}

	/**
	* Updates the loai doanh nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @return the loai doanh nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep updateLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.updateLoaiDoanhNghiep(loaiDoanhNghiep);
	}

	/**
	* Updates the loai doanh nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @param merge whether to merge the loai doanh nghiep with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the loai doanh nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep updateLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loaiDoanhNghiepLocalService.updateLoaiDoanhNghiep(loaiDoanhNghiep,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _loaiDoanhNghiepLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_loaiDoanhNghiepLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LoaiDoanhNghiepLocalService getWrappedLoaiDoanhNghiepLocalService() {
		return _loaiDoanhNghiepLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLoaiDoanhNghiepLocalService(
		LoaiDoanhNghiepLocalService loaiDoanhNghiepLocalService) {
		_loaiDoanhNghiepLocalService = loaiDoanhNghiepLocalService;
	}

	public LoaiDoanhNghiepLocalService getWrappedService() {
		return _loaiDoanhNghiepLocalService;
	}

	public void setWrappedService(
		LoaiDoanhNghiepLocalService loaiDoanhNghiepLocalService) {
		_loaiDoanhNghiepLocalService = loaiDoanhNghiepLocalService;
	}

	private LoaiDoanhNghiepLocalService _loaiDoanhNghiepLocalService;
}