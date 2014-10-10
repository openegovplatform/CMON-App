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
 * This class is a wrapper for {@link TinhTrangHonNhanLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       TinhTrangHonNhanLocalService
 * @generated
 */
public class TinhTrangHonNhanLocalServiceWrapper
	implements TinhTrangHonNhanLocalService,
		ServiceWrapper<TinhTrangHonNhanLocalService> {
	public TinhTrangHonNhanLocalServiceWrapper(
		TinhTrangHonNhanLocalService tinhTrangHonNhanLocalService) {
		_tinhTrangHonNhanLocalService = tinhTrangHonNhanLocalService;
	}

	/**
	* Adds the tinh trang hon nhan to the database. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @return the tinh trang hon nhan that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan addTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.addTinhTrangHonNhan(tinhTrangHonNhan);
	}

	/**
	* Creates a new tinh trang hon nhan with the primary key. Does not add the tinh trang hon nhan to the database.
	*
	* @param id the primary key for the new tinh trang hon nhan
	* @return the new tinh trang hon nhan
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan createTinhTrangHonNhan(
		long id) {
		return _tinhTrangHonNhanLocalService.createTinhTrangHonNhan(id);
	}

	/**
	* Deletes the tinh trang hon nhan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @throws PortalException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTinhTrangHonNhan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tinhTrangHonNhanLocalService.deleteTinhTrangHonNhan(id);
	}

	/**
	* Deletes the tinh trang hon nhan from the database. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tinhTrangHonNhanLocalService.deleteTinhTrangHonNhan(tinhTrangHonNhan);
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
		return _tinhTrangHonNhanLocalService.dynamicQuery(dynamicQuery);
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
		return _tinhTrangHonNhanLocalService.dynamicQuery(dynamicQuery, start,
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
		return _tinhTrangHonNhanLocalService.dynamicQuery(dynamicQuery, start,
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
		return _tinhTrangHonNhanLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan fetchTinhTrangHonNhan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.fetchTinhTrangHonNhan(id);
	}

	/**
	* Returns the tinh trang hon nhan with the primary key.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan
	* @throws PortalException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan getTinhTrangHonNhan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.getTinhTrangHonNhan(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tinh trang hon nhans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @return the range of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> getTinhTrangHonNhans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.getTinhTrangHonNhans(start, end);
	}

	/**
	* Returns the number of tinh trang hon nhans.
	*
	* @return the number of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public int getTinhTrangHonNhansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.getTinhTrangHonNhansCount();
	}

	/**
	* Updates the tinh trang hon nhan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @return the tinh trang hon nhan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan updateTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.updateTinhTrangHonNhan(tinhTrangHonNhan);
	}

	/**
	* Updates the tinh trang hon nhan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @param merge whether to merge the tinh trang hon nhan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tinh trang hon nhan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan updateTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinhTrangHonNhanLocalService.updateTinhTrangHonNhan(tinhTrangHonNhan,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tinhTrangHonNhanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tinhTrangHonNhanLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion getAll TinhTrangHonNhan by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<TinhTrangHonNhan>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> getAll(
		int daXoa) {
		return _tinhTrangHonNhanLocalService.getAll(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TinhTrangHonNhanLocalService getWrappedTinhTrangHonNhanLocalService() {
		return _tinhTrangHonNhanLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTinhTrangHonNhanLocalService(
		TinhTrangHonNhanLocalService tinhTrangHonNhanLocalService) {
		_tinhTrangHonNhanLocalService = tinhTrangHonNhanLocalService;
	}

	public TinhTrangHonNhanLocalService getWrappedService() {
		return _tinhTrangHonNhanLocalService;
	}

	public void setWrappedService(
		TinhTrangHonNhanLocalService tinhTrangHonNhanLocalService) {
		_tinhTrangHonNhanLocalService = tinhTrangHonNhanLocalService;
	}

	private TinhTrangHonNhanLocalService _tinhTrangHonNhanLocalService;
}