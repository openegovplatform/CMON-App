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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the hang giay phep lai xe local service. This utility wraps {@link org.oep.dlms.dao.danhmucgiaypheplaixe.service.impl.HangGiayPhepLaiXeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhNT
 * @see HangGiayPhepLaiXeLocalService
 * @see org.oep.dlms.dao.danhmucgiaypheplaixe.service.base.HangGiayPhepLaiXeLocalServiceBaseImpl
 * @see org.oep.dlms.dao.danhmucgiaypheplaixe.service.impl.HangGiayPhepLaiXeLocalServiceImpl
 * @generated
 */
public class HangGiayPhepLaiXeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.dlms.dao.danhmucgiaypheplaixe.service.impl.HangGiayPhepLaiXeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the hang giay phep lai xe to the database. Also notifies the appropriate model listeners.
	*
	* @param hangGiayPhepLaiXe the hang giay phep lai xe
	* @return the hang giay phep lai xe that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe addHangGiayPhepLaiXe(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHangGiayPhepLaiXe(hangGiayPhepLaiXe);
	}

	/**
	* Creates a new hang giay phep lai xe with the primary key. Does not add the hang giay phep lai xe to the database.
	*
	* @param id the primary key for the new hang giay phep lai xe
	* @return the new hang giay phep lai xe
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe createHangGiayPhepLaiXe(
		long id) {
		return getService().createHangGiayPhepLaiXe(id);
	}

	/**
	* Deletes the hang giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the hang giay phep lai xe
	* @throws PortalException if a hang giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHangGiayPhepLaiXe(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHangGiayPhepLaiXe(id);
	}

	/**
	* Deletes the hang giay phep lai xe from the database. Also notifies the appropriate model listeners.
	*
	* @param hangGiayPhepLaiXe the hang giay phep lai xe
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHangGiayPhepLaiXe(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHangGiayPhepLaiXe(hangGiayPhepLaiXe);
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

	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe fetchHangGiayPhepLaiXe(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHangGiayPhepLaiXe(id);
	}

	/**
	* Returns the hang giay phep lai xe with the primary key.
	*
	* @param id the primary key of the hang giay phep lai xe
	* @return the hang giay phep lai xe
	* @throws PortalException if a hang giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe getHangGiayPhepLaiXe(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHangGiayPhepLaiXe(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the hang giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of hang giay phep lai xes
	* @param end the upper bound of the range of hang giay phep lai xes (not inclusive)
	* @return the range of hang giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe> getHangGiayPhepLaiXes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHangGiayPhepLaiXes(start, end);
	}

	/**
	* Returns the number of hang giay phep lai xes.
	*
	* @return the number of hang giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static int getHangGiayPhepLaiXesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHangGiayPhepLaiXesCount();
	}

	/**
	* Updates the hang giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hangGiayPhepLaiXe the hang giay phep lai xe
	* @return the hang giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe updateHangGiayPhepLaiXe(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHangGiayPhepLaiXe(hangGiayPhepLaiXe);
	}

	/**
	* Updates the hang giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hangGiayPhepLaiXe the hang giay phep lai xe
	* @param merge whether to merge the hang giay phep lai xe with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the hang giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe updateHangGiayPhepLaiXe(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHangGiayPhepLaiXe(hangGiayPhepLaiXe, merge);
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

	public static HangGiayPhepLaiXeLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HangGiayPhepLaiXeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HangGiayPhepLaiXeLocalService.class.getName(),
					portletClassLoader);

			_service = new HangGiayPhepLaiXeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HangGiayPhepLaiXeLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HangGiayPhepLaiXeLocalService.class);
		}

		return _service;
	}

	public void setService(HangGiayPhepLaiXeLocalService service) {
		MethodCache.remove(HangGiayPhepLaiXeLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HangGiayPhepLaiXeLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HangGiayPhepLaiXeLocalService.class);
	}

	private static HangGiayPhepLaiXeLocalService _service;
}