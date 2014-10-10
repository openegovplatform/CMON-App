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
 * This class is a wrapper for {@link GioiTinhLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       GioiTinhLocalService
 * @generated
 */
public class GioiTinhLocalServiceWrapper implements GioiTinhLocalService,
	ServiceWrapper<GioiTinhLocalService> {
	public GioiTinhLocalServiceWrapper(
		GioiTinhLocalService gioiTinhLocalService) {
		_gioiTinhLocalService = gioiTinhLocalService;
	}

	/**
	* Adds the gioi tinh to the database. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @return the gioi tinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh addGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.addGioiTinh(gioiTinh);
	}

	/**
	* Creates a new gioi tinh with the primary key. Does not add the gioi tinh to the database.
	*
	* @param id the primary key for the new gioi tinh
	* @return the new gioi tinh
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh createGioiTinh(long id) {
		return _gioiTinhLocalService.createGioiTinh(id);
	}

	/**
	* Deletes the gioi tinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the gioi tinh
	* @throws PortalException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteGioiTinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_gioiTinhLocalService.deleteGioiTinh(id);
	}

	/**
	* Deletes the gioi tinh from the database. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @throws SystemException if a system exception occurred
	*/
	public void deleteGioiTinh(org.oep.cmon.dao.cd.model.GioiTinh gioiTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		_gioiTinhLocalService.deleteGioiTinh(gioiTinh);
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
		return _gioiTinhLocalService.dynamicQuery(dynamicQuery);
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
		return _gioiTinhLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _gioiTinhLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _gioiTinhLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cd.model.GioiTinh fetchGioiTinh(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.fetchGioiTinh(id);
	}

	/**
	* Returns the gioi tinh with the primary key.
	*
	* @param id the primary key of the gioi tinh
	* @return the gioi tinh
	* @throws PortalException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh getGioiTinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.getGioiTinh(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the gioi tinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of gioi tinhs
	* @param end the upper bound of the range of gioi tinhs (not inclusive)
	* @return the range of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.GioiTinh> getGioiTinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.getGioiTinhs(start, end);
	}

	/**
	* Returns the number of gioi tinhs.
	*
	* @return the number of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public int getGioiTinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.getGioiTinhsCount();
	}

	/**
	* Updates the gioi tinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @return the gioi tinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh updateGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.updateGioiTinh(gioiTinh);
	}

	/**
	* Updates the gioi tinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @param merge whether to merge the gioi tinh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the gioi tinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh updateGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.updateGioiTinh(gioiTinh, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _gioiTinhLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gioiTinhLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion get GioiTinh by TrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<GioiTinh>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.GioiTinh> getDSGioiTinh() {
		return _gioiTinhLocalService.getDSGioiTinh();
	}

	/**
	* This is fucntion findAll GioiTinh
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<GioiTinh>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.GioiTinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gioiTinhLocalService.findAll();
	}

	/**
	* This is fucntion find GioiTinh by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return List<GioiTinh>
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh findByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchGioiTinhException {
		return _gioiTinhLocalService.findByMa(ma);
	}

	/**
	* This is fucntion find GioiTinh by ten
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ten
	* @return GioiTinh
	*/
	public org.oep.cmon.dao.cd.model.GioiTinh findByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchGioiTinhException {
		return _gioiTinhLocalService.findByTen(ten);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public GioiTinhLocalService getWrappedGioiTinhLocalService() {
		return _gioiTinhLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedGioiTinhLocalService(
		GioiTinhLocalService gioiTinhLocalService) {
		_gioiTinhLocalService = gioiTinhLocalService;
	}

	public GioiTinhLocalService getWrappedService() {
		return _gioiTinhLocalService;
	}

	public void setWrappedService(GioiTinhLocalService gioiTinhLocalService) {
		_gioiTinhLocalService = gioiTinhLocalService;
	}

	private GioiTinhLocalService _gioiTinhLocalService;
}