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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NhomNguoiDungLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       NhomNguoiDungLocalService
 * @generated
 */
public class NhomNguoiDungLocalServiceWrapper
	implements NhomNguoiDungLocalService,
		ServiceWrapper<NhomNguoiDungLocalService> {
	public NhomNguoiDungLocalServiceWrapper(
		NhomNguoiDungLocalService nhomNguoiDungLocalService) {
		_nhomNguoiDungLocalService = nhomNguoiDungLocalService;
	}

	/**
	* Adds the nhom nguoi dung to the database. Also notifies the appropriate model listeners.
	*
	* @param nhomNguoiDung the nhom nguoi dung
	* @return the nhom nguoi dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung addNhomNguoiDung(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.addNhomNguoiDung(nhomNguoiDung);
	}

	/**
	* Creates a new nhom nguoi dung with the primary key. Does not add the nhom nguoi dung to the database.
	*
	* @param id the primary key for the new nhom nguoi dung
	* @return the new nhom nguoi dung
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung createNhomNguoiDung(long id) {
		return _nhomNguoiDungLocalService.createNhomNguoiDung(id);
	}

	/**
	* Deletes the nhom nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom nguoi dung
	* @throws PortalException if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNhomNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_nhomNguoiDungLocalService.deleteNhomNguoiDung(id);
	}

	/**
	* Deletes the nhom nguoi dung from the database. Also notifies the appropriate model listeners.
	*
	* @param nhomNguoiDung the nhom nguoi dung
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNhomNguoiDung(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		_nhomNguoiDungLocalService.deleteNhomNguoiDung(nhomNguoiDung);
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
		return _nhomNguoiDungLocalService.dynamicQuery(dynamicQuery);
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
		return _nhomNguoiDungLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _nhomNguoiDungLocalService.dynamicQuery(dynamicQuery, start,
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
		return _nhomNguoiDungLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.nsd.model.NhomNguoiDung fetchNhomNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.fetchNhomNguoiDung(id);
	}

	/**
	* Returns the nhom nguoi dung with the primary key.
	*
	* @param id the primary key of the nhom nguoi dung
	* @return the nhom nguoi dung
	* @throws PortalException if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung getNhomNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.getNhomNguoiDung(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the nhom nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @return the range of nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> getNhomNguoiDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.getNhomNguoiDungs(start, end);
	}

	/**
	* Returns the number of nhom nguoi dungs.
	*
	* @return the number of nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int getNhomNguoiDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.getNhomNguoiDungsCount();
	}

	/**
	* Updates the nhom nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nhomNguoiDung the nhom nguoi dung
	* @return the nhom nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung updateNhomNguoiDung(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.updateNhomNguoiDung(nhomNguoiDung);
	}

	/**
	* Updates the nhom nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nhomNguoiDung the nhom nguoi dung
	* @param merge whether to merge the nhom nguoi dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the nhom nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung updateNhomNguoiDung(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nhomNguoiDungLocalService.updateNhomNguoiDung(nhomNguoiDung,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _nhomNguoiDungLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nhomNguoiDungLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NhomNguoiDungLocalService getWrappedNhomNguoiDungLocalService() {
		return _nhomNguoiDungLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNhomNguoiDungLocalService(
		NhomNguoiDungLocalService nhomNguoiDungLocalService) {
		_nhomNguoiDungLocalService = nhomNguoiDungLocalService;
	}

	public NhomNguoiDungLocalService getWrappedService() {
		return _nhomNguoiDungLocalService;
	}

	public void setWrappedService(
		NhomNguoiDungLocalService nhomNguoiDungLocalService) {
		_nhomNguoiDungLocalService = nhomNguoiDungLocalService;
	}

	private NhomNguoiDungLocalService _nhomNguoiDungLocalService;
}