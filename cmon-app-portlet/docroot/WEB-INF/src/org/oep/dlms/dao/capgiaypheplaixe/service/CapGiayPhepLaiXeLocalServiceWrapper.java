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

package org.oep.dlms.dao.capgiaypheplaixe.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CapGiayPhepLaiXeLocalService}.
 * </p>
 *
 * @author    AnhNT
 * @see       CapGiayPhepLaiXeLocalService
 * @generated
 */
public class CapGiayPhepLaiXeLocalServiceWrapper
	implements CapGiayPhepLaiXeLocalService,
		ServiceWrapper<CapGiayPhepLaiXeLocalService> {
	public CapGiayPhepLaiXeLocalServiceWrapper(
		CapGiayPhepLaiXeLocalService capGiayPhepLaiXeLocalService) {
		_capGiayPhepLaiXeLocalService = capGiayPhepLaiXeLocalService;
	}

	/**
	* Adds the cap giay phep lai xe to the database. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @return the cap giay phep lai xe that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe addCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.addCapGiayPhepLaiXe(capGiayPhepLaiXe);
	}

	/**
	* Creates a new cap giay phep lai xe with the primary key. Does not add the cap giay phep lai xe to the database.
	*
	* @param id the primary key for the new cap giay phep lai xe
	* @return the new cap giay phep lai xe
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe createCapGiayPhepLaiXe(
		long id) {
		return _capGiayPhepLaiXeLocalService.createCapGiayPhepLaiXe(id);
	}

	/**
	* Deletes the cap giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @throws PortalException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCapGiayPhepLaiXe(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_capGiayPhepLaiXeLocalService.deleteCapGiayPhepLaiXe(id);
	}

	/**
	* Deletes the cap giay phep lai xe from the database. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		_capGiayPhepLaiXeLocalService.deleteCapGiayPhepLaiXe(capGiayPhepLaiXe);
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
		return _capGiayPhepLaiXeLocalService.dynamicQuery(dynamicQuery);
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
		return _capGiayPhepLaiXeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _capGiayPhepLaiXeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _capGiayPhepLaiXeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe fetchCapGiayPhepLaiXe(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.fetchCapGiayPhepLaiXe(id);
	}

	/**
	* Returns the cap giay phep lai xe with the primary key.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @return the cap giay phep lai xe
	* @throws PortalException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe getCapGiayPhepLaiXe(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.getCapGiayPhepLaiXe(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cap giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap giay phep lai xes
	* @param end the upper bound of the range of cap giay phep lai xes (not inclusive)
	* @return the range of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> getCapGiayPhepLaiXes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.getCapGiayPhepLaiXes(start, end);
	}

	/**
	* Returns the number of cap giay phep lai xes.
	*
	* @return the number of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public int getCapGiayPhepLaiXesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.getCapGiayPhepLaiXesCount();
	}

	/**
	* Updates the cap giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @return the cap giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.updateCapGiayPhepLaiXe(capGiayPhepLaiXe);
	}

	/**
	* Updates the cap giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @param merge whether to merge the cap giay phep lai xe with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cap giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _capGiayPhepLaiXeLocalService.updateCapGiayPhepLaiXe(capGiayPhepLaiXe,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _capGiayPhepLaiXeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_capGiayPhepLaiXeLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CapGiayPhepLaiXeLocalService getWrappedCapGiayPhepLaiXeLocalService() {
		return _capGiayPhepLaiXeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCapGiayPhepLaiXeLocalService(
		CapGiayPhepLaiXeLocalService capGiayPhepLaiXeLocalService) {
		_capGiayPhepLaiXeLocalService = capGiayPhepLaiXeLocalService;
	}

	public CapGiayPhepLaiXeLocalService getWrappedService() {
		return _capGiayPhepLaiXeLocalService;
	}

	public void setWrappedService(
		CapGiayPhepLaiXeLocalService capGiayPhepLaiXeLocalService) {
		_capGiayPhepLaiXeLocalService = capGiayPhepLaiXeLocalService;
	}

	private CapGiayPhepLaiXeLocalService _capGiayPhepLaiXeLocalService;
}