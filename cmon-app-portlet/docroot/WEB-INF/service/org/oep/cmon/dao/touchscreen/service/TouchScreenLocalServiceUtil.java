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

package org.oep.cmon.dao.touchscreen.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the touch screen local service. This utility wraps {@link org.oep.cmon.dao.touchscreen.service.impl.TouchScreenLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see TouchScreenLocalService
 * @see org.oep.cmon.dao.touchscreen.service.base.TouchScreenLocalServiceBaseImpl
 * @see org.oep.cmon.dao.touchscreen.service.impl.TouchScreenLocalServiceImpl
 * @generated
 */
public class TouchScreenLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.touchscreen.service.impl.TouchScreenLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the touch screen to the database. Also notifies the appropriate model listeners.
	*
	* @param touchScreen the touch screen
	* @return the touch screen that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen addTouchScreen(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTouchScreen(touchScreen);
	}

	/**
	* Creates a new touch screen with the primary key. Does not add the touch screen to the database.
	*
	* @param ID the primary key for the new touch screen
	* @return the new touch screen
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen createTouchScreen(
		long ID) {
		return getService().createTouchScreen(ID);
	}

	/**
	* Deletes the touch screen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the touch screen
	* @throws PortalException if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTouchScreen(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTouchScreen(ID);
	}

	/**
	* Deletes the touch screen from the database. Also notifies the appropriate model listeners.
	*
	* @param touchScreen the touch screen
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTouchScreen(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTouchScreen(touchScreen);
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

	public static org.oep.cmon.dao.touchscreen.model.TouchScreen fetchTouchScreen(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTouchScreen(ID);
	}

	/**
	* Returns the touch screen with the primary key.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen
	* @throws PortalException if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen getTouchScreen(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTouchScreen(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the touch screens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of touch screens
	* @param end the upper bound of the range of touch screens (not inclusive)
	* @return the range of touch screens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> getTouchScreens(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTouchScreens(start, end);
	}

	/**
	* Returns the number of touch screens.
	*
	* @return the number of touch screens
	* @throws SystemException if a system exception occurred
	*/
	public static int getTouchScreensCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTouchScreensCount();
	}

	/**
	* Updates the touch screen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param touchScreen the touch screen
	* @return the touch screen that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen updateTouchScreen(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTouchScreen(touchScreen);
	}

	/**
	* Updates the touch screen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param touchScreen the touch screen
	* @param merge whether to merge the touch screen with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the touch screen that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen updateTouchScreen(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTouchScreen(touchScreen, merge);
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
	* This is fucntion countHoSoTrucTiep
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int loaihoso, String nam
	* @return long
	*/
	public static long countHoSoTrucTiep(int loaihoso, java.lang.String nam)
		throws java.lang.Exception {
		return getService().countHoSoTrucTiep(loaihoso, nam);
	}

	/**
	* This is fucntion countHoSoByTrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String arrTrangThai, String nam,String type
	* @return long
	*/
	public static long countHoSoByTrangThai(java.lang.String arrTrangThai,
		java.lang.String nam, java.lang.String type) throws java.lang.Exception {
		return getService().countHoSoByTrangThai(arrTrangThai, nam, type);
	}

	public static void clearService() {
		_service = null;
	}

	public static TouchScreenLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TouchScreenLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TouchScreenLocalService.class.getName(), portletClassLoader);

			_service = new TouchScreenLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TouchScreenLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TouchScreenLocalService.class);
		}

		return _service;
	}

	public void setService(TouchScreenLocalService service) {
		MethodCache.remove(TouchScreenLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TouchScreenLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TouchScreenLocalService.class);
	}

	private static TouchScreenLocalService _service;
}