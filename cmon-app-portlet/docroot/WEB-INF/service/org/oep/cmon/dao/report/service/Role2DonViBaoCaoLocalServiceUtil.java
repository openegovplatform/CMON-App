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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the role2 don vi bao cao local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.Role2DonViBaoCaoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see Role2DonViBaoCaoLocalService
 * @see org.oep.cmon.dao.report.service.base.Role2DonViBaoCaoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.Role2DonViBaoCaoLocalServiceImpl
 * @generated
 */
public class Role2DonViBaoCaoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.Role2DonViBaoCaoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the role2 don vi bao cao to the database. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @return the role2 don vi bao cao that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao addRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRole2DonViBaoCao(role2DonViBaoCao);
	}

	/**
	* Creates a new role2 don vi bao cao with the primary key. Does not add the role2 don vi bao cao to the database.
	*
	* @param ID the primary key for the new role2 don vi bao cao
	* @return the new role2 don vi bao cao
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao createRole2DonViBaoCao(
		long ID) {
		return getService().createRole2DonViBaoCao(ID);
	}

	/**
	* Deletes the role2 don vi bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @throws PortalException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteRole2DonViBaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRole2DonViBaoCao(ID);
	}

	/**
	* Deletes the role2 don vi bao cao from the database. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRole2DonViBaoCao(role2DonViBaoCao);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao fetchRole2DonViBaoCao(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRole2DonViBaoCao(ID);
	}

	/**
	* Returns the role2 don vi bao cao with the primary key.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao
	* @throws PortalException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao getRole2DonViBaoCao(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRole2DonViBaoCao(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> getRole2DonViBaoCaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRole2DonViBaoCaos(start, end);
	}

	/**
	* Returns the number of role2 don vi bao caos.
	*
	* @return the number of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static int getRole2DonViBaoCaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRole2DonViBaoCaosCount();
	}

	/**
	* Updates the role2 don vi bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @return the role2 don vi bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao updateRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRole2DonViBaoCao(role2DonViBaoCao);
	}

	/**
	* Updates the role2 don vi bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	* @param merge whether to merge the role2 don vi bao cao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the role2 don vi bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao updateRole2DonViBaoCao(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRole2DonViBaoCao(role2DonViBaoCao, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static Role2DonViBaoCaoLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Role2DonViBaoCaoLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					Role2DonViBaoCaoLocalService.class.getName(),
					portletClassLoader);

			_service = new Role2DonViBaoCaoLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(Role2DonViBaoCaoLocalServiceUtil.class,
				"_service");
			MethodCache.remove(Role2DonViBaoCaoLocalService.class);
		}

		return _service;
	}

	public void setService(Role2DonViBaoCaoLocalService service) {
		MethodCache.remove(Role2DonViBaoCaoLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(Role2DonViBaoCaoLocalServiceUtil.class,
			"_service");
		MethodCache.remove(Role2DonViBaoCaoLocalService.class);
	}

	private static Role2DonViBaoCaoLocalService _service;
}