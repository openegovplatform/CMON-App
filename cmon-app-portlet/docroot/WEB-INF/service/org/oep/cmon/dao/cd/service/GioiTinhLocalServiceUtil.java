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
 * The utility for the gioi tinh local service. This utility wraps {@link org.oep.cmon.dao.cd.service.impl.GioiTinhLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see GioiTinhLocalService
 * @see org.oep.cmon.dao.cd.service.base.GioiTinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.impl.GioiTinhLocalServiceImpl
 * @generated
 */
public class GioiTinhLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.cd.service.impl.GioiTinhLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the gioi tinh to the database. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @return the gioi tinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh addGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGioiTinh(gioiTinh);
	}

	/**
	* Creates a new gioi tinh with the primary key. Does not add the gioi tinh to the database.
	*
	* @param id the primary key for the new gioi tinh
	* @return the new gioi tinh
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh createGioiTinh(long id) {
		return getService().createGioiTinh(id);
	}

	/**
	* Deletes the gioi tinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the gioi tinh
	* @throws PortalException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteGioiTinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteGioiTinh(id);
	}

	/**
	* Deletes the gioi tinh from the database. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteGioiTinh(gioiTinh);
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

	public static org.oep.cmon.dao.cd.model.GioiTinh fetchGioiTinh(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGioiTinh(id);
	}

	/**
	* Returns the gioi tinh with the primary key.
	*
	* @param id the primary key of the gioi tinh
	* @return the gioi tinh
	* @throws PortalException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh getGioiTinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGioiTinh(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the gioi tinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of gioi tinhs
	* @param end the upper bound of the range of gioi tinhs (not inclusive)
	* @return the range of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.GioiTinh> getGioiTinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGioiTinhs(start, end);
	}

	/**
	* Returns the number of gioi tinhs.
	*
	* @return the number of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int getGioiTinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGioiTinhsCount();
	}

	/**
	* Updates the gioi tinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @return the gioi tinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh updateGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGioiTinh(gioiTinh);
	}

	/**
	* Updates the gioi tinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gioiTinh the gioi tinh
	* @param merge whether to merge the gioi tinh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the gioi tinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh updateGioiTinh(
		org.oep.cmon.dao.cd.model.GioiTinh gioiTinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGioiTinh(gioiTinh, merge);
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
	* This is fucntion get GioiTinh by TrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<GioiTinh>
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.GioiTinh> getDSGioiTinh() {
		return getService().getDSGioiTinh();
	}

	/**
	* This is fucntion findAll GioiTinh
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<GioiTinh>
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.GioiTinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	/**
	* This is fucntion find GioiTinh by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return List<GioiTinh>
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchGioiTinhException {
		return getService().findByMa(ma);
	}

	/**
	* This is fucntion find GioiTinh by ten
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ten
	* @return GioiTinh
	*/
	public static org.oep.cmon.dao.cd.model.GioiTinh findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchGioiTinhException {
		return getService().findByTen(ten);
	}

	public static void clearService() {
		_service = null;
	}

	public static GioiTinhLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GioiTinhLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					GioiTinhLocalService.class.getName(), portletClassLoader);

			_service = new GioiTinhLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(GioiTinhLocalServiceUtil.class,
				"_service");
			MethodCache.remove(GioiTinhLocalService.class);
		}

		return _service;
	}

	public void setService(GioiTinhLocalService service) {
		MethodCache.remove(GioiTinhLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(GioiTinhLocalServiceUtil.class,
			"_service");
		MethodCache.remove(GioiTinhLocalService.class);
	}

	private static GioiTinhLocalService _service;
}