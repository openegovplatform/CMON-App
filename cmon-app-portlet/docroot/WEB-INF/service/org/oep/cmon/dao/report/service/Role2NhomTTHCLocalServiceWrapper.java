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
 * This class is a wrapper for {@link Role2NhomTTHCLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2NhomTTHCLocalService
 * @generated
 */
public class Role2NhomTTHCLocalServiceWrapper
	implements Role2NhomTTHCLocalService,
		ServiceWrapper<Role2NhomTTHCLocalService> {
	public Role2NhomTTHCLocalServiceWrapper(
		Role2NhomTTHCLocalService role2NhomTTHCLocalService) {
		_role2NhomTTHCLocalService = role2NhomTTHCLocalService;
	}

	/**
	* Adds the role2 nhom t t h c to the database. Also notifies the appropriate model listeners.
	*
	* @param role2NhomTTHC the role2 nhom t t h c
	* @return the role2 nhom t t h c that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC addRole2NhomTTHC(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.addRole2NhomTTHC(role2NhomTTHC);
	}

	/**
	* Creates a new role2 nhom t t h c with the primary key. Does not add the role2 nhom t t h c to the database.
	*
	* @param ID the primary key for the new role2 nhom t t h c
	* @return the new role2 nhom t t h c
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC createRole2NhomTTHC(
		long ID) {
		return _role2NhomTTHCLocalService.createRole2NhomTTHC(ID);
	}

	/**
	* Deletes the role2 nhom t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 nhom t t h c
	* @throws PortalException if a role2 nhom t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2NhomTTHC(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_role2NhomTTHCLocalService.deleteRole2NhomTTHC(ID);
	}

	/**
	* Deletes the role2 nhom t t h c from the database. Also notifies the appropriate model listeners.
	*
	* @param role2NhomTTHC the role2 nhom t t h c
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2NhomTTHC(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC)
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2NhomTTHCLocalService.deleteRole2NhomTTHC(role2NhomTTHC);
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
		return _role2NhomTTHCLocalService.dynamicQuery(dynamicQuery);
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
		return _role2NhomTTHCLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _role2NhomTTHCLocalService.dynamicQuery(dynamicQuery, start,
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
		return _role2NhomTTHCLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.Role2NhomTTHC fetchRole2NhomTTHC(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.fetchRole2NhomTTHC(ID);
	}

	/**
	* Returns the role2 nhom t t h c with the primary key.
	*
	* @param ID the primary key of the role2 nhom t t h c
	* @return the role2 nhom t t h c
	* @throws PortalException if a role2 nhom t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC getRole2NhomTTHC(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.getRole2NhomTTHC(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the role2 nhom t t h cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 nhom t t h cs
	* @param end the upper bound of the range of role2 nhom t t h cs (not inclusive)
	* @return the range of role2 nhom t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2NhomTTHC> getRole2NhomTTHCs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.getRole2NhomTTHCs(start, end);
	}

	/**
	* Returns the number of role2 nhom t t h cs.
	*
	* @return the number of role2 nhom t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public int getRole2NhomTTHCsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.getRole2NhomTTHCsCount();
	}

	/**
	* Updates the role2 nhom t t h c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2NhomTTHC the role2 nhom t t h c
	* @return the role2 nhom t t h c that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC updateRole2NhomTTHC(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.updateRole2NhomTTHC(role2NhomTTHC);
	}

	/**
	* Updates the role2 nhom t t h c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2NhomTTHC the role2 nhom t t h c
	* @param merge whether to merge the role2 nhom t t h c with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the role2 nhom t t h c that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC updateRole2NhomTTHC(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2NhomTTHCLocalService.updateRole2NhomTTHC(role2NhomTTHC,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _role2NhomTTHCLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_role2NhomTTHCLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Role2NhomTTHCLocalService getWrappedRole2NhomTTHCLocalService() {
		return _role2NhomTTHCLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRole2NhomTTHCLocalService(
		Role2NhomTTHCLocalService role2NhomTTHCLocalService) {
		_role2NhomTTHCLocalService = role2NhomTTHCLocalService;
	}

	public Role2NhomTTHCLocalService getWrappedService() {
		return _role2NhomTTHCLocalService;
	}

	public void setWrappedService(
		Role2NhomTTHCLocalService role2NhomTTHCLocalService) {
		_role2NhomTTHCLocalService = role2NhomTTHCLocalService;
	}

	private Role2NhomTTHCLocalService _role2NhomTTHCLocalService;
}