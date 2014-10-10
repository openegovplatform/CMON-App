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
 * This class is a wrapper for {@link Role2TTHCLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2TTHCLocalService
 * @generated
 */
public class Role2TTHCLocalServiceWrapper implements Role2TTHCLocalService,
	ServiceWrapper<Role2TTHCLocalService> {
	public Role2TTHCLocalServiceWrapper(
		Role2TTHCLocalService role2TTHCLocalService) {
		_role2TTHCLocalService = role2TTHCLocalService;
	}

	/**
	* Adds the role2 t t h c to the database. Also notifies the appropriate model listeners.
	*
	* @param role2TTHC the role2 t t h c
	* @return the role2 t t h c that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2TTHC addRole2TTHC(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.addRole2TTHC(role2TTHC);
	}

	/**
	* Creates a new role2 t t h c with the primary key. Does not add the role2 t t h c to the database.
	*
	* @param ID the primary key for the new role2 t t h c
	* @return the new role2 t t h c
	*/
	public org.oep.cmon.dao.report.model.Role2TTHC createRole2TTHC(long ID) {
		return _role2TTHCLocalService.createRole2TTHC(ID);
	}

	/**
	* Deletes the role2 t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 t t h c
	* @throws PortalException if a role2 t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2TTHC(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_role2TTHCLocalService.deleteRole2TTHC(ID);
	}

	/**
	* Deletes the role2 t t h c from the database. Also notifies the appropriate model listeners.
	*
	* @param role2TTHC the role2 t t h c
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2TTHC(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC)
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2TTHCLocalService.deleteRole2TTHC(role2TTHC);
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
		return _role2TTHCLocalService.dynamicQuery(dynamicQuery);
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
		return _role2TTHCLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _role2TTHCLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _role2TTHCLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.Role2TTHC fetchRole2TTHC(long ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.fetchRole2TTHC(ID);
	}

	/**
	* Returns the role2 t t h c with the primary key.
	*
	* @param ID the primary key of the role2 t t h c
	* @return the role2 t t h c
	* @throws PortalException if a role2 t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2TTHC getRole2TTHC(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.getRole2TTHC(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the role2 t t h cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 t t h cs
	* @param end the upper bound of the range of role2 t t h cs (not inclusive)
	* @return the range of role2 t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2TTHC> getRole2TTHCs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.getRole2TTHCs(start, end);
	}

	/**
	* Returns the number of role2 t t h cs.
	*
	* @return the number of role2 t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public int getRole2TTHCsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.getRole2TTHCsCount();
	}

	/**
	* Updates the role2 t t h c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2TTHC the role2 t t h c
	* @return the role2 t t h c that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2TTHC updateRole2TTHC(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.updateRole2TTHC(role2TTHC);
	}

	/**
	* Updates the role2 t t h c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2TTHC the role2 t t h c
	* @param merge whether to merge the role2 t t h c with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the role2 t t h c that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2TTHC updateRole2TTHC(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2TTHCLocalService.updateRole2TTHC(role2TTHC, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _role2TTHCLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_role2TTHCLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Role2TTHCLocalService getWrappedRole2TTHCLocalService() {
		return _role2TTHCLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRole2TTHCLocalService(
		Role2TTHCLocalService role2TTHCLocalService) {
		_role2TTHCLocalService = role2TTHCLocalService;
	}

	public Role2TTHCLocalService getWrappedService() {
		return _role2TTHCLocalService;
	}

	public void setWrappedService(Role2TTHCLocalService role2TTHCLocalService) {
		_role2TTHCLocalService = role2TTHCLocalService;
	}

	private Role2TTHCLocalService _role2TTHCLocalService;
}