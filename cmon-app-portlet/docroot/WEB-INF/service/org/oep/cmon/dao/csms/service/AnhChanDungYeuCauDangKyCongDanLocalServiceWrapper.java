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

package org.oep.cmon.dao.csms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AnhChanDungYeuCauDangKyCongDanLocalService}.
 * </p>
 *
 * @author    NAM
 * @see       AnhChanDungYeuCauDangKyCongDanLocalService
 * @generated
 */
public class AnhChanDungYeuCauDangKyCongDanLocalServiceWrapper
	implements AnhChanDungYeuCauDangKyCongDanLocalService,
		ServiceWrapper<AnhChanDungYeuCauDangKyCongDanLocalService> {
	public AnhChanDungYeuCauDangKyCongDanLocalServiceWrapper(
		AnhChanDungYeuCauDangKyCongDanLocalService anhChanDungYeuCauDangKyCongDanLocalService) {
		_anhChanDungYeuCauDangKyCongDanLocalService = anhChanDungYeuCauDangKyCongDanLocalService;
	}

	/**
	* Adds the anh chan dung yeu cau dang ky cong dan to the database. Also notifies the appropriate model listeners.
	*
	* @param anhChanDungYeuCauDangKyCongDan the anh chan dung yeu cau dang ky cong dan
	* @return the anh chan dung yeu cau dang ky cong dan that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan addAnhChanDungYeuCauDangKyCongDan(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.addAnhChanDungYeuCauDangKyCongDan(anhChanDungYeuCauDangKyCongDan);
	}

	/**
	* Creates a new anh chan dung yeu cau dang ky cong dan with the primary key. Does not add the anh chan dung yeu cau dang ky cong dan to the database.
	*
	* @param id the primary key for the new anh chan dung yeu cau dang ky cong dan
	* @return the new anh chan dung yeu cau dang ky cong dan
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan createAnhChanDungYeuCauDangKyCongDan(
		long id) {
		return _anhChanDungYeuCauDangKyCongDanLocalService.createAnhChanDungYeuCauDangKyCongDan(id);
	}

	/**
	* Deletes the anh chan dung yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	* @throws PortalException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnhChanDungYeuCauDangKyCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_anhChanDungYeuCauDangKyCongDanLocalService.deleteAnhChanDungYeuCauDangKyCongDan(id);
	}

	/**
	* Deletes the anh chan dung yeu cau dang ky cong dan from the database. Also notifies the appropriate model listeners.
	*
	* @param anhChanDungYeuCauDangKyCongDan the anh chan dung yeu cau dang ky cong dan
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnhChanDungYeuCauDangKyCongDan(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		_anhChanDungYeuCauDangKyCongDanLocalService.deleteAnhChanDungYeuCauDangKyCongDan(anhChanDungYeuCauDangKyCongDan);
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
		return _anhChanDungYeuCauDangKyCongDanLocalService.dynamicQuery(dynamicQuery);
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
		return _anhChanDungYeuCauDangKyCongDanLocalService.dynamicQuery(dynamicQuery,
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
		return _anhChanDungYeuCauDangKyCongDanLocalService.dynamicQuery(dynamicQuery,
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
		return _anhChanDungYeuCauDangKyCongDanLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan fetchAnhChanDungYeuCauDangKyCongDan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.fetchAnhChanDungYeuCauDangKyCongDan(id);
	}

	/**
	* Returns the anh chan dung yeu cau dang ky cong dan with the primary key.
	*
	* @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	* @return the anh chan dung yeu cau dang ky cong dan
	* @throws PortalException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan getAnhChanDungYeuCauDangKyCongDan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.getAnhChanDungYeuCauDangKyCongDan(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the anh chan dung yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh chan dung yeu cau dang ky cong dans
	* @param end the upper bound of the range of anh chan dung yeu cau dang ky cong dans (not inclusive)
	* @return the range of anh chan dung yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan> getAnhChanDungYeuCauDangKyCongDans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.getAnhChanDungYeuCauDangKyCongDans(start,
			end);
	}

	/**
	* Returns the number of anh chan dung yeu cau dang ky cong dans.
	*
	* @return the number of anh chan dung yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int getAnhChanDungYeuCauDangKyCongDansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.getAnhChanDungYeuCauDangKyCongDansCount();
	}

	/**
	* Updates the anh chan dung yeu cau dang ky cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anhChanDungYeuCauDangKyCongDan the anh chan dung yeu cau dang ky cong dan
	* @return the anh chan dung yeu cau dang ky cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan updateAnhChanDungYeuCauDangKyCongDan(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.updateAnhChanDungYeuCauDangKyCongDan(anhChanDungYeuCauDangKyCongDan);
	}

	/**
	* Updates the anh chan dung yeu cau dang ky cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anhChanDungYeuCauDangKyCongDan the anh chan dung yeu cau dang ky cong dan
	* @param merge whether to merge the anh chan dung yeu cau dang ky cong dan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the anh chan dung yeu cau dang ky cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan updateAnhChanDungYeuCauDangKyCongDan(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhChanDungYeuCauDangKyCongDanLocalService.updateAnhChanDungYeuCauDangKyCongDan(anhChanDungYeuCauDangKyCongDan,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _anhChanDungYeuCauDangKyCongDanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_anhChanDungYeuCauDangKyCongDanLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AnhChanDungYeuCauDangKyCongDanLocalService getWrappedAnhChanDungYeuCauDangKyCongDanLocalService() {
		return _anhChanDungYeuCauDangKyCongDanLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAnhChanDungYeuCauDangKyCongDanLocalService(
		AnhChanDungYeuCauDangKyCongDanLocalService anhChanDungYeuCauDangKyCongDanLocalService) {
		_anhChanDungYeuCauDangKyCongDanLocalService = anhChanDungYeuCauDangKyCongDanLocalService;
	}

	public AnhChanDungYeuCauDangKyCongDanLocalService getWrappedService() {
		return _anhChanDungYeuCauDangKyCongDanLocalService;
	}

	public void setWrappedService(
		AnhChanDungYeuCauDangKyCongDanLocalService anhChanDungYeuCauDangKyCongDanLocalService) {
		_anhChanDungYeuCauDangKyCongDanLocalService = anhChanDungYeuCauDangKyCongDanLocalService;
	}

	private AnhChanDungYeuCauDangKyCongDanLocalService _anhChanDungYeuCauDangKyCongDanLocalService;
}