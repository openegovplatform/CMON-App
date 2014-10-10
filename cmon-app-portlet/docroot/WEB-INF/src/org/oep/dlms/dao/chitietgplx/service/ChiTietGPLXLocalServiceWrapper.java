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

package org.oep.dlms.dao.chitietgplx.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChiTietGPLXLocalService}.
 * </p>
 *
 * @author    hunghq
 * @see       ChiTietGPLXLocalService
 * @generated
 */
public class ChiTietGPLXLocalServiceWrapper implements ChiTietGPLXLocalService,
	ServiceWrapper<ChiTietGPLXLocalService> {
	public ChiTietGPLXLocalServiceWrapper(
		ChiTietGPLXLocalService chiTietGPLXLocalService) {
		_chiTietGPLXLocalService = chiTietGPLXLocalService;
	}

	/**
	* Adds the chi tiet g p l x to the database. Also notifies the appropriate model listeners.
	*
	* @param chiTietGPLX the chi tiet g p l x
	* @return the chi tiet g p l x that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX addChiTietGPLX(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.addChiTietGPLX(chiTietGPLX);
	}

	/**
	* Creates a new chi tiet g p l x with the primary key. Does not add the chi tiet g p l x to the database.
	*
	* @param id the primary key for the new chi tiet g p l x
	* @return the new chi tiet g p l x
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX createChiTietGPLX(
		long id) {
		return _chiTietGPLXLocalService.createChiTietGPLX(id);
	}

	/**
	* Deletes the chi tiet g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chi tiet g p l x
	* @throws PortalException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChiTietGPLX(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_chiTietGPLXLocalService.deleteChiTietGPLX(id);
	}

	/**
	* Deletes the chi tiet g p l x from the database. Also notifies the appropriate model listeners.
	*
	* @param chiTietGPLX the chi tiet g p l x
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChiTietGPLX(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		_chiTietGPLXLocalService.deleteChiTietGPLX(chiTietGPLX);
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
		return _chiTietGPLXLocalService.dynamicQuery(dynamicQuery);
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
		return _chiTietGPLXLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _chiTietGPLXLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _chiTietGPLXLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX fetchChiTietGPLX(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.fetchChiTietGPLX(id);
	}

	/**
	* Returns the chi tiet g p l x with the primary key.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x
	* @throws PortalException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX getChiTietGPLX(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.getChiTietGPLX(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chi tiet g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @return the range of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> getChiTietGPLXs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.getChiTietGPLXs(start, end);
	}

	/**
	* Returns the number of chi tiet g p l xs.
	*
	* @return the number of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public int getChiTietGPLXsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.getChiTietGPLXsCount();
	}

	/**
	* Updates the chi tiet g p l x in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chiTietGPLX the chi tiet g p l x
	* @return the chi tiet g p l x that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX updateChiTietGPLX(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.updateChiTietGPLX(chiTietGPLX);
	}

	/**
	* Updates the chi tiet g p l x in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chiTietGPLX the chi tiet g p l x
	* @param merge whether to merge the chi tiet g p l x with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chi tiet g p l x that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX updateChiTietGPLX(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.updateChiTietGPLX(chiTietGPLX, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _chiTietGPLXLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_chiTietGPLXLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX) throws com.liferay.portal.kernel.exception.SystemException {
		return _chiTietGPLXLocalService.findByGPLX(idGPLX);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ChiTietGPLXLocalService getWrappedChiTietGPLXLocalService() {
		return _chiTietGPLXLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedChiTietGPLXLocalService(
		ChiTietGPLXLocalService chiTietGPLXLocalService) {
		_chiTietGPLXLocalService = chiTietGPLXLocalService;
	}

	public ChiTietGPLXLocalService getWrappedService() {
		return _chiTietGPLXLocalService;
	}

	public void setWrappedService(
		ChiTietGPLXLocalService chiTietGPLXLocalService) {
		_chiTietGPLXLocalService = chiTietGPLXLocalService;
	}

	private ChiTietGPLXLocalService _chiTietGPLXLocalService;
}