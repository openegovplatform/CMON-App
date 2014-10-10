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
 * This class is a wrapper for {@link Role2BaoCaoLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2BaoCaoLocalService
 * @generated
 */
public class Role2BaoCaoLocalServiceWrapper implements Role2BaoCaoLocalService,
	ServiceWrapper<Role2BaoCaoLocalService> {
	public Role2BaoCaoLocalServiceWrapper(
		Role2BaoCaoLocalService role2BaoCaoLocalService) {
		_role2BaoCaoLocalService = role2BaoCaoLocalService;
	}

	/**
	* Adds the role2 bao cao to the database. Also notifies the appropriate model listeners.
	*
	* @param role2BaoCao the role2 bao cao
	* @return the role2 bao cao that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao addRole2BaoCao(
		org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.addRole2BaoCao(role2BaoCao);
	}

	/**
	* Creates a new role2 bao cao with the primary key. Does not add the role2 bao cao to the database.
	*
	* @param ID the primary key for the new role2 bao cao
	* @return the new role2 bao cao
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao createRole2BaoCao(long ID) {
		return _role2BaoCaoLocalService.createRole2BaoCao(ID);
	}

	/**
	* Deletes the role2 bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 bao cao
	* @throws PortalException if a role2 bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2BaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_role2BaoCaoLocalService.deleteRole2BaoCao(ID);
	}

	/**
	* Deletes the role2 bao cao from the database. Also notifies the appropriate model listeners.
	*
	* @param role2BaoCao the role2 bao cao
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2BaoCao(
		org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2BaoCaoLocalService.deleteRole2BaoCao(role2BaoCao);
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
		return _role2BaoCaoLocalService.dynamicQuery(dynamicQuery);
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
		return _role2BaoCaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _role2BaoCaoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _role2BaoCaoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.Role2BaoCao fetchRole2BaoCao(long ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.fetchRole2BaoCao(ID);
	}

	/**
	* Returns the role2 bao cao with the primary key.
	*
	* @param ID the primary key of the role2 bao cao
	* @return the role2 bao cao
	* @throws PortalException if a role2 bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao getRole2BaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.getRole2BaoCao(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the role2 bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 bao caos
	* @param end the upper bound of the range of role2 bao caos (not inclusive)
	* @return the range of role2 bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2BaoCao> getRole2BaoCaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.getRole2BaoCaos(start, end);
	}

	/**
	* Returns the number of role2 bao caos.
	*
	* @return the number of role2 bao caos
	* @throws SystemException if a system exception occurred
	*/
	public int getRole2BaoCaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.getRole2BaoCaosCount();
	}

	/**
	* Updates the role2 bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2BaoCao the role2 bao cao
	* @return the role2 bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao updateRole2BaoCao(
		org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.updateRole2BaoCao(role2BaoCao);
	}

	/**
	* Updates the role2 bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2BaoCao the role2 bao cao
	* @param merge whether to merge the role2 bao cao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the role2 bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao updateRole2BaoCao(
		org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2BaoCaoLocalService.updateRole2BaoCao(role2BaoCao, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _role2BaoCaoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_role2BaoCaoLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Role2BaoCaoLocalService getWrappedRole2BaoCaoLocalService() {
		return _role2BaoCaoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRole2BaoCaoLocalService(
		Role2BaoCaoLocalService role2BaoCaoLocalService) {
		_role2BaoCaoLocalService = role2BaoCaoLocalService;
	}

	public Role2BaoCaoLocalService getWrappedService() {
		return _role2BaoCaoLocalService;
	}

	public void setWrappedService(
		Role2BaoCaoLocalService role2BaoCaoLocalService) {
		_role2BaoCaoLocalService = role2BaoCaoLocalService;
	}

	private Role2BaoCaoLocalService _role2BaoCaoLocalService;
}