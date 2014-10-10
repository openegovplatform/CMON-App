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

package org.oep.cmon.dao.report.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhMucRoleLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhMucRoleLocalService
 * @generated
 */
public class DanhMucRoleLocalServiceWrapper implements DanhMucRoleLocalService,
	ServiceWrapper<DanhMucRoleLocalService> {
	public DanhMucRoleLocalServiceWrapper(
		DanhMucRoleLocalService danhMucRoleLocalService) {
		_danhMucRoleLocalService = danhMucRoleLocalService;
	}

	/**
	* Adds the danh muc role to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @return the danh muc role that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole addDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.addDanhMucRole(danhMucRole);
	}

	/**
	* Creates a new danh muc role with the primary key. Does not add the danh muc role to the database.
	*
	* @param ID the primary key for the new danh muc role
	* @return the new danh muc role
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole createDanhMucRole(long ID) {
		return _danhMucRoleLocalService.createDanhMucRole(ID);
	}

	/**
	* Deletes the danh muc role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc role
	* @throws PortalException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucRole(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_danhMucRoleLocalService.deleteDanhMucRole(ID);
	}

	/**
	* Deletes the danh muc role from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucRoleLocalService.deleteDanhMucRole(danhMucRole);
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
		return _danhMucRoleLocalService.dynamicQuery(dynamicQuery);
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
		return _danhMucRoleLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _danhMucRoleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _danhMucRoleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.DanhMucRole fetchDanhMucRole(long ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.fetchDanhMucRole(ID);
	}

	/**
	* Returns the danh muc role with the primary key.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role
	* @throws PortalException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole getDanhMucRole(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.getDanhMucRole(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc roles
	* @param end the upper bound of the range of danh muc roles (not inclusive)
	* @return the range of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> getDanhMucRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.getDanhMucRoles(start, end);
	}

	/**
	* Returns the number of danh muc roles.
	*
	* @return the number of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public int getDanhMucRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.getDanhMucRolesCount();
	}

	/**
	* Updates the danh muc role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @return the danh muc role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole updateDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.updateDanhMucRole(danhMucRole);
	}

	/**
	* Updates the danh muc role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @param merge whether to merge the danh muc role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole updateDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucRoleLocalService.updateDanhMucRole(danhMucRole, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _danhMucRoleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danhMucRoleLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DanhMucRoleLocalService getWrappedDanhMucRoleLocalService() {
		return _danhMucRoleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDanhMucRoleLocalService(
		DanhMucRoleLocalService danhMucRoleLocalService) {
		_danhMucRoleLocalService = danhMucRoleLocalService;
	}

	public DanhMucRoleLocalService getWrappedService() {
		return _danhMucRoleLocalService;
	}

	public void setWrappedService(
		DanhMucRoleLocalService danhMucRoleLocalService) {
		_danhMucRoleLocalService = danhMucRoleLocalService;
	}

	private DanhMucRoleLocalService _danhMucRoleLocalService;
}