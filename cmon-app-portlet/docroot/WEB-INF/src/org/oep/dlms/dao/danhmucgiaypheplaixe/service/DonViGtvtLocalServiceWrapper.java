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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DonViGtvtLocalService}.
 * </p>
 *
 * @author    AnhNT
 * @see       DonViGtvtLocalService
 * @generated
 */
public class DonViGtvtLocalServiceWrapper implements DonViGtvtLocalService,
	ServiceWrapper<DonViGtvtLocalService> {
	public DonViGtvtLocalServiceWrapper(
		DonViGtvtLocalService donViGtvtLocalService) {
		_donViGtvtLocalService = donViGtvtLocalService;
	}

	/**
	* Adds the don vi gtvt to the database. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @return the don vi gtvt that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt addDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.addDonViGtvt(donViGtvt);
	}

	/**
	* Creates a new don vi gtvt with the primary key. Does not add the don vi gtvt to the database.
	*
	* @param id the primary key for the new don vi gtvt
	* @return the new don vi gtvt
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt createDonViGtvt(
		long id) {
		return _donViGtvtLocalService.createDonViGtvt(id);
	}

	/**
	* Deletes the don vi gtvt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi gtvt
	* @throws PortalException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDonViGtvt(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_donViGtvtLocalService.deleteDonViGtvt(id);
	}

	/**
	* Deletes the don vi gtvt from the database. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt)
		throws com.liferay.portal.kernel.exception.SystemException {
		_donViGtvtLocalService.deleteDonViGtvt(donViGtvt);
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
		return _donViGtvtLocalService.dynamicQuery(dynamicQuery);
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
		return _donViGtvtLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _donViGtvtLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _donViGtvtLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt fetchDonViGtvt(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.fetchDonViGtvt(id);
	}

	/**
	* Returns the don vi gtvt with the primary key.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt
	* @throws PortalException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt getDonViGtvt(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.getDonViGtvt(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the don vi gtvts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi gtvts
	* @param end the upper bound of the range of don vi gtvts (not inclusive)
	* @return the range of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> getDonViGtvts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.getDonViGtvts(start, end);
	}

	/**
	* Returns the number of don vi gtvts.
	*
	* @return the number of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public int getDonViGtvtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.getDonViGtvtsCount();
	}

	/**
	* Updates the don vi gtvt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @return the don vi gtvt that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt updateDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.updateDonViGtvt(donViGtvt);
	}

	/**
	* Updates the don vi gtvt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @param merge whether to merge the don vi gtvt with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the don vi gtvt that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt updateDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _donViGtvtLocalService.updateDonViGtvt(donViGtvt, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _donViGtvtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_donViGtvtLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DonViGtvtLocalService getWrappedDonViGtvtLocalService() {
		return _donViGtvtLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDonViGtvtLocalService(
		DonViGtvtLocalService donViGtvtLocalService) {
		_donViGtvtLocalService = donViGtvtLocalService;
	}

	public DonViGtvtLocalService getWrappedService() {
		return _donViGtvtLocalService;
	}

	public void setWrappedService(DonViGtvtLocalService donViGtvtLocalService) {
		_donViGtvtLocalService = donViGtvtLocalService;
	}

	private DonViGtvtLocalService _donViGtvtLocalService;
}