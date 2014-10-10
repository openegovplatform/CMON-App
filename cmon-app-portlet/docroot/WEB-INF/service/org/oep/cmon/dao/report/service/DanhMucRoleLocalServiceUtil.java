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
 * The utility for the danh muc role local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.DanhMucRoleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see DanhMucRoleLocalService
 * @see org.oep.cmon.dao.report.service.base.DanhMucRoleLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.DanhMucRoleLocalServiceImpl
 * @generated
 */
public class DanhMucRoleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.DanhMucRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the danh muc role to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @return the danh muc role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole addDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDanhMucRole(danhMucRole);
	}

	/**
	* Creates a new danh muc role with the primary key. Does not add the danh muc role to the database.
	*
	* @param ID the primary key for the new danh muc role
	* @return the new danh muc role
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole createDanhMucRole(
		long ID) {
		return getService().createDanhMucRole(ID);
	}

	/**
	* Deletes the danh muc role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc role
	* @throws PortalException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucRole(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucRole(ID);
	}

	/**
	* Deletes the danh muc role from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucRole(danhMucRole);
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

	public static org.oep.cmon.dao.report.model.DanhMucRole fetchDanhMucRole(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDanhMucRole(ID);
	}

	/**
	* Returns the danh muc role with the primary key.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role
	* @throws PortalException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole getDanhMucRole(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucRole(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> getDanhMucRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucRoles(start, end);
	}

	/**
	* Returns the number of danh muc roles.
	*
	* @return the number of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getDanhMucRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucRolesCount();
	}

	/**
	* Updates the danh muc role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @return the danh muc role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole updateDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhMucRole(danhMucRole);
	}

	/**
	* Updates the danh muc role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucRole the danh muc role
	* @param merge whether to merge the danh muc role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole updateDanhMucRole(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhMucRole(danhMucRole, merge);
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

	public static DanhMucRoleLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DanhMucRoleLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DanhMucRoleLocalService.class.getName(), portletClassLoader);

			_service = new DanhMucRoleLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DanhMucRoleLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DanhMucRoleLocalService.class);
		}

		return _service;
	}

	public void setService(DanhMucRoleLocalService service) {
		MethodCache.remove(DanhMucRoleLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DanhMucRoleLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DanhMucRoleLocalService.class);
	}

	private static DanhMucRoleLocalService _service;
}