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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the nghe nghiep local service. This utility wraps {@link org.oep.cmon.dao.cd.service.impl.NgheNghiepLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see NgheNghiepLocalService
 * @see org.oep.cmon.dao.cd.service.base.NgheNghiepLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.impl.NgheNghiepLocalServiceImpl
 * @generated
 */
public class NgheNghiepLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.cd.service.impl.NgheNghiepLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the nghe nghiep to the database. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @return the nghe nghiep that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.NgheNghiep addNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNgheNghiep(ngheNghiep);
	}

	/**
	* Creates a new nghe nghiep with the primary key. Does not add the nghe nghiep to the database.
	*
	* @param id the primary key for the new nghe nghiep
	* @return the new nghe nghiep
	*/
	public static org.oep.cmon.dao.cd.model.NgheNghiep createNgheNghiep(long id) {
		return getService().createNgheNghiep(id);
	}

	/**
	* Deletes the nghe nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nghe nghiep
	* @throws PortalException if a nghe nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNgheNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNgheNghiep(id);
	}

	/**
	* Deletes the nghe nghiep from the database. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNgheNghiep(ngheNghiep);
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

	public static org.oep.cmon.dao.cd.model.NgheNghiep fetchNgheNghiep(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNgheNghiep(id);
	}

	/**
	* Returns the nghe nghiep with the primary key.
	*
	* @param id the primary key of the nghe nghiep
	* @return the nghe nghiep
	* @throws PortalException if a nghe nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.NgheNghiep getNgheNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNgheNghiep(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the nghe nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nghe nghieps
	* @param end the upper bound of the range of nghe nghieps (not inclusive)
	* @return the range of nghe nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.NgheNghiep> getNgheNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNgheNghieps(start, end);
	}

	/**
	* Returns the number of nghe nghieps.
	*
	* @return the number of nghe nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int getNgheNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNgheNghiepsCount();
	}

	/**
	* Updates the nghe nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @return the nghe nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.NgheNghiep updateNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNgheNghiep(ngheNghiep);
	}

	/**
	* Updates the nghe nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ngheNghiep the nghe nghiep
	* @param merge whether to merge the nghe nghiep with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the nghe nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.NgheNghiep updateNgheNghiep(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNgheNghiep(ngheNghiep, merge);
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

	/**
	* This is fucntion findAll NgheNghiep by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<NgheNghiep>
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.NgheNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static NgheNghiepLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NgheNghiepLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					NgheNghiepLocalService.class.getName(), portletClassLoader);

			_service = new NgheNghiepLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(NgheNghiepLocalServiceUtil.class,
				"_service");
			MethodCache.remove(NgheNghiepLocalService.class);
		}

		return _service;
	}

	public void setService(NgheNghiepLocalService service) {
		MethodCache.remove(NgheNghiepLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(NgheNghiepLocalServiceUtil.class,
			"_service");
		MethodCache.remove(NgheNghiepLocalService.class);
	}

	private static NgheNghiepLocalService _service;
}