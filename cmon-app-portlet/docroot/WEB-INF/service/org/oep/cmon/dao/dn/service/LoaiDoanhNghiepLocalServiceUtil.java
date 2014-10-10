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

package org.oep.cmon.dao.dn.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the loai doanh nghiep local service. This utility wraps {@link org.oep.cmon.dao.dn.service.impl.LoaiDoanhNghiepLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see LoaiDoanhNghiepLocalService
 * @see org.oep.cmon.dao.dn.service.base.LoaiDoanhNghiepLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dn.service.impl.LoaiDoanhNghiepLocalServiceImpl
 * @generated
 */
public class LoaiDoanhNghiepLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dn.service.impl.LoaiDoanhNghiepLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the loai doanh nghiep to the database. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @return the loai doanh nghiep that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep addLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLoaiDoanhNghiep(loaiDoanhNghiep);
	}

	/**
	* Creates a new loai doanh nghiep with the primary key. Does not add the loai doanh nghiep to the database.
	*
	* @param id the primary key for the new loai doanh nghiep
	* @return the new loai doanh nghiep
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep createLoaiDoanhNghiep(
		long id) {
		return getService().createLoaiDoanhNghiep(id);
	}

	/**
	* Deletes the loai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loai doanh nghiep
	* @throws PortalException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLoaiDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLoaiDoanhNghiep(id);
	}

	/**
	* Deletes the loai doanh nghiep from the database. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLoaiDoanhNghiep(loaiDoanhNghiep);
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

	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchLoaiDoanhNghiep(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLoaiDoanhNghiep(id);
	}

	/**
	* Returns the loai doanh nghiep with the primary key.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep
	* @throws PortalException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep getLoaiDoanhNghiep(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoaiDoanhNghiep(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the loai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @return the range of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> getLoaiDoanhNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoaiDoanhNghieps(start, end);
	}

	/**
	* Returns the number of loai doanh nghieps.
	*
	* @return the number of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int getLoaiDoanhNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoaiDoanhNghiepsCount();
	}

	/**
	* Updates the loai doanh nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @return the loai doanh nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep updateLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLoaiDoanhNghiep(loaiDoanhNghiep);
	}

	/**
	* Updates the loai doanh nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	* @param merge whether to merge the loai doanh nghiep with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the loai doanh nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep updateLoaiDoanhNghiep(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLoaiDoanhNghiep(loaiDoanhNghiep, merge);
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

	public static LoaiDoanhNghiepLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LoaiDoanhNghiepLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LoaiDoanhNghiepLocalService.class.getName(),
					portletClassLoader);

			_service = new LoaiDoanhNghiepLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LoaiDoanhNghiepLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LoaiDoanhNghiepLocalService.class);
		}

		return _service;
	}

	public void setService(LoaiDoanhNghiepLocalService service) {
		MethodCache.remove(LoaiDoanhNghiepLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LoaiDoanhNghiepLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LoaiDoanhNghiepLocalService.class);
	}

	private static LoaiDoanhNghiepLocalService _service;
}