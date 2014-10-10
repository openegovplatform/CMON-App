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
 * The utility for the he thong local service. This utility wraps {@link org.oep.cmon.dao.cd.service.impl.HeThongLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see HeThongLocalService
 * @see org.oep.cmon.dao.cd.service.base.HeThongLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.impl.HeThongLocalServiceImpl
 * @generated
 */
public class HeThongLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.cd.service.impl.HeThongLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the he thong to the database. Also notifies the appropriate model listeners.
	*
	* @param heThong the he thong
	* @return the he thong that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HeThong addHeThong(
		org.oep.cmon.dao.cd.model.HeThong heThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHeThong(heThong);
	}

	/**
	* Creates a new he thong with the primary key. Does not add the he thong to the database.
	*
	* @param id the primary key for the new he thong
	* @return the new he thong
	*/
	public static org.oep.cmon.dao.cd.model.HeThong createHeThong(long id) {
		return getService().createHeThong(id);
	}

	/**
	* Deletes the he thong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the he thong
	* @throws PortalException if a he thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHeThong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHeThong(id);
	}

	/**
	* Deletes the he thong from the database. Also notifies the appropriate model listeners.
	*
	* @param heThong the he thong
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHeThong(org.oep.cmon.dao.cd.model.HeThong heThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHeThong(heThong);
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

	public static org.oep.cmon.dao.cd.model.HeThong fetchHeThong(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHeThong(id);
	}

	/**
	* Returns the he thong with the primary key.
	*
	* @param id the primary key of the he thong
	* @return the he thong
	* @throws PortalException if a he thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HeThong getHeThong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeThong(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the he thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of he thongs
	* @param end the upper bound of the range of he thongs (not inclusive)
	* @return the range of he thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.HeThong> getHeThongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeThongs(start, end);
	}

	/**
	* Returns the number of he thongs.
	*
	* @return the number of he thongs
	* @throws SystemException if a system exception occurred
	*/
	public static int getHeThongsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeThongsCount();
	}

	/**
	* Updates the he thong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param heThong the he thong
	* @return the he thong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HeThong updateHeThong(
		org.oep.cmon.dao.cd.model.HeThong heThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHeThong(heThong);
	}

	/**
	* Updates the he thong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param heThong the he thong
	* @param merge whether to merge the he thong with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the he thong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HeThong updateHeThong(
		org.oep.cmon.dao.cd.model.HeThong heThong, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHeThong(heThong, merge);
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
	* This is fucntion find HeThong by ten
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ten
	* @return HeThong
	*/
	public static org.oep.cmon.dao.cd.model.HeThong findTheoTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchHeThongException {
		return getService().findTheoTen(ten);
	}

	/**
	* This is fucntion find HeThong by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return HeThong
	*/
	public static org.oep.cmon.dao.cd.model.HeThong findTheoMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchHeThongException {
		return getService().findTheoMa(ma);
	}

	public static void clearService() {
		_service = null;
	}

	public static HeThongLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HeThongLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HeThongLocalService.class.getName(), portletClassLoader);

			_service = new HeThongLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HeThongLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HeThongLocalService.class);
		}

		return _service;
	}

	public void setService(HeThongLocalService service) {
		MethodCache.remove(HeThongLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HeThongLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HeThongLocalService.class);
	}

	private static HeThongLocalService _service;
}