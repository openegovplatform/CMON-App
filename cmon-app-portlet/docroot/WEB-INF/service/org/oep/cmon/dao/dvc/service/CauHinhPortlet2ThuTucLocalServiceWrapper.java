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

package org.oep.cmon.dao.dvc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CauHinhPortlet2ThuTucLocalService}.
 * </p>
 *
 * @author    liemnn
 * @see       CauHinhPortlet2ThuTucLocalService
 * @generated
 */
public class CauHinhPortlet2ThuTucLocalServiceWrapper
	implements CauHinhPortlet2ThuTucLocalService,
		ServiceWrapper<CauHinhPortlet2ThuTucLocalService> {
	public CauHinhPortlet2ThuTucLocalServiceWrapper(
		CauHinhPortlet2ThuTucLocalService cauHinhPortlet2ThuTucLocalService) {
		_cauHinhPortlet2ThuTucLocalService = cauHinhPortlet2ThuTucLocalService;
	}

	/**
	* Adds the cau hinh portlet2 thu tuc to the database. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc addCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.addCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);
	}

	/**
	* Creates a new cau hinh portlet2 thu tuc with the primary key. Does not add the cau hinh portlet2 thu tuc to the database.
	*
	* @param thuTucHanhChinhId the primary key for the new cau hinh portlet2 thu tuc
	* @return the new cau hinh portlet2 thu tuc
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc createCauHinhPortlet2ThuTuc(
		long thuTucHanhChinhId) {
		return _cauHinhPortlet2ThuTucLocalService.createCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	/**
	* Deletes the cau hinh portlet2 thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @throws PortalException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCauHinhPortlet2ThuTuc(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cauHinhPortlet2ThuTucLocalService.deleteCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	/**
	* Deletes the cau hinh portlet2 thu tuc from the database. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		_cauHinhPortlet2ThuTucLocalService.deleteCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);
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
		return _cauHinhPortlet2ThuTucLocalService.dynamicQuery(dynamicQuery);
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
		return _cauHinhPortlet2ThuTucLocalService.dynamicQuery(dynamicQuery,
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
		return _cauHinhPortlet2ThuTucLocalService.dynamicQuery(dynamicQuery,
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
		return _cauHinhPortlet2ThuTucLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchCauHinhPortlet2ThuTuc(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.fetchCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc with the primary key.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc
	* @throws PortalException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc getCauHinhPortlet2ThuTuc(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.getCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cau hinh portlet2 thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cau hinh portlet2 thu tucs
	* @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	* @return the range of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> getCauHinhPortlet2ThuTucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.getCauHinhPortlet2ThuTucs(start,
			end);
	}

	/**
	* Returns the number of cau hinh portlet2 thu tucs.
	*
	* @return the number of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int getCauHinhPortlet2ThuTucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.getCauHinhPortlet2ThuTucsCount();
	}

	/**
	* Updates the cau hinh portlet2 thu tuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc updateCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.updateCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);
	}

	/**
	* Updates the cau hinh portlet2 thu tuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @param merge whether to merge the cau hinh portlet2 thu tuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cau hinh portlet2 thu tuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc updateCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cauHinhPortlet2ThuTucLocalService.updateCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cauHinhPortlet2ThuTucLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cauHinhPortlet2ThuTucLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CauHinhPortlet2ThuTucLocalService getWrappedCauHinhPortlet2ThuTucLocalService() {
		return _cauHinhPortlet2ThuTucLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCauHinhPortlet2ThuTucLocalService(
		CauHinhPortlet2ThuTucLocalService cauHinhPortlet2ThuTucLocalService) {
		_cauHinhPortlet2ThuTucLocalService = cauHinhPortlet2ThuTucLocalService;
	}

	public CauHinhPortlet2ThuTucLocalService getWrappedService() {
		return _cauHinhPortlet2ThuTucLocalService;
	}

	public void setWrappedService(
		CauHinhPortlet2ThuTucLocalService cauHinhPortlet2ThuTucLocalService) {
		_cauHinhPortlet2ThuTucLocalService = cauHinhPortlet2ThuTucLocalService;
	}

	private CauHinhPortlet2ThuTucLocalService _cauHinhPortlet2ThuTucLocalService;
}