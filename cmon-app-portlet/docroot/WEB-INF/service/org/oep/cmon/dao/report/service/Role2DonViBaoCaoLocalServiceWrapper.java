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
 * This class is a wrapper for {@link Role2DonViBaoCaoLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       Role2DonViBaoCaoLocalService
 * @generated
 */
public class Role2DonViBaoCaoLocalServiceWrapper
	implements Role2DonViBaoCaoLocalService,
		ServiceWrapper<Role2DonViBaoCaoLocalService> {
	public Role2DonViBaoCaoLocalServiceWrapper(
		Role2DonViBaoCaoLocalService role2DonViBaoCaoLocalService) {
		_role2DonViBaoCaoLocalService = role2DonViBaoCaoLocalService;
	}

	/**
	* Adds the role2 don vi bao cao to the database. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @return the role2 don vi bao cao that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao addRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.addRole2DonViBaoCao(role2DonViBaoCao);
	}

	/**
	* Creates a new role2 don vi bao cao with the primary key. Does not add the role2 don vi bao cao to the database.
	*
	* @param ID the primary key for the new role2 don vi bao cao
	* @return the new role2 don vi bao cao
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao createRole2DonViBaoCao(
		long ID) {
		return _role2DonViBaoCaoLocalService.createRole2DonViBaoCao(ID);
	}

	/**
	* Deletes the role2 don vi bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @throws PortalException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2DonViBaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_role2DonViBaoCaoLocalService.deleteRole2DonViBaoCao(ID);
	}

	/**
	* Deletes the role2 don vi bao cao from the database. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		_role2DonViBaoCaoLocalService.deleteRole2DonViBaoCao(role2DonViBaoCao);
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
		return _role2DonViBaoCaoLocalService.dynamicQuery(dynamicQuery);
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
		return _role2DonViBaoCaoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _role2DonViBaoCaoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _role2DonViBaoCaoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.Role2DonViBaoCao fetchRole2DonViBaoCao(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.fetchRole2DonViBaoCao(ID);
	}

	/**
	* Returns the role2 don vi bao cao with the primary key.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao
	* @throws PortalException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao getRole2DonViBaoCao(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.getRole2DonViBaoCao(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the role2 don vi bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 don vi bao caos
	* @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	* @return the range of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> getRole2DonViBaoCaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.getRole2DonViBaoCaos(start, end);
	}

	/**
	* Returns the number of role2 don vi bao caos.
	*
	* @return the number of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public int getRole2DonViBaoCaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.getRole2DonViBaoCaosCount();
	}

	/**
	* Updates the role2 don vi bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @return the role2 don vi bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao updateRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.updateRole2DonViBaoCao(role2DonViBaoCao);
	}

	/**
	* Updates the role2 don vi bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @param merge whether to merge the role2 don vi bao cao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the role2 don vi bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao updateRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role2DonViBaoCaoLocalService.updateRole2DonViBaoCao(role2DonViBaoCao,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _role2DonViBaoCaoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_role2DonViBaoCaoLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Role2DonViBaoCaoLocalService getWrappedRole2DonViBaoCaoLocalService() {
		return _role2DonViBaoCaoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRole2DonViBaoCaoLocalService(
		Role2DonViBaoCaoLocalService role2DonViBaoCaoLocalService) {
		_role2DonViBaoCaoLocalService = role2DonViBaoCaoLocalService;
	}

	public Role2DonViBaoCaoLocalService getWrappedService() {
		return _role2DonViBaoCaoLocalService;
	}

	public void setWrappedService(
		Role2DonViBaoCaoLocalService role2DonViBaoCaoLocalService) {
		_role2DonViBaoCaoLocalService = role2DonViBaoCaoLocalService;
	}

	private Role2DonViBaoCaoLocalService _role2DonViBaoCaoLocalService;
}