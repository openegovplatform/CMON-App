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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the ho so anh xa local service. This utility wraps {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoAnhXaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see HoSoAnhXaLocalService
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoAnhXaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.HoSoAnhXaLocalServiceImpl
 * @generated
 */
public class HoSoAnhXaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoAnhXaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ho so anh xa to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @return the ho so anh xa that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa addHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHoSoAnhXa(hoSoAnhXa);
	}

	/**
	* Creates a new ho so anh xa with the primary key. Does not add the ho so anh xa to the database.
	*
	* @param id the primary key for the new ho so anh xa
	* @return the new ho so anh xa
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa createHoSoAnhXa(
		long id) {
		return getService().createHoSoAnhXa(id);
	}

	/**
	* Deletes the ho so anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so anh xa
	* @throws PortalException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHoSoAnhXa(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHoSoAnhXa(id);
	}

	/**
	* Deletes the ho so anh xa from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHoSoAnhXa(hoSoAnhXa);
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

	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchHoSoAnhXa(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHoSoAnhXa(id);
	}

	/**
	* Returns the ho so anh xa with the primary key.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa
	* @throws PortalException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa getHoSoAnhXa(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoAnhXa(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ho so anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @return the range of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> getHoSoAnhXas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoAnhXas(start, end);
	}

	/**
	* Returns the number of ho so anh xas.
	*
	* @return the number of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int getHoSoAnhXasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoAnhXasCount();
	}

	/**
	* Updates the ho so anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @return the ho so anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa updateHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoSoAnhXa(hoSoAnhXa);
	}

	/**
	* Updates the ho so anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @param merge whether to merge the ho so anh xa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa updateHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoSoAnhXa(hoSoAnhXa, merge);
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
	* This is fucntion findById
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long id
	* @return HoSoAnhXa
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findById(long id) {
		return getService().findById(id);
	}

	/**
	* This is fucntion findByHoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return HoSoAnhXa
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByHoSoTTHCCongId(
		long hoSoTTHCCongId) {
		return getService().findByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* This is fucntion findByMaHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maHoSo
	* @return List<HoSoAnhXa>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo) {
		return getService().findByMaHoSo(maHoSo);
	}

	public static void clearService() {
		_service = null;
	}

	public static HoSoAnhXaLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HoSoAnhXaLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HoSoAnhXaLocalService.class.getName(), portletClassLoader);

			_service = new HoSoAnhXaLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HoSoAnhXaLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HoSoAnhXaLocalService.class);
		}

		return _service;
	}

	public void setService(HoSoAnhXaLocalService service) {
		MethodCache.remove(HoSoAnhXaLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HoSoAnhXaLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HoSoAnhXaLocalService.class);
	}

	private static HoSoAnhXaLocalService _service;
}