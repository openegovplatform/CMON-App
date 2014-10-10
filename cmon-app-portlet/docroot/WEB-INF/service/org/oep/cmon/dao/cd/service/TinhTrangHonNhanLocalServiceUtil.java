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
 * The utility for the tinh trang hon nhan local service. This utility wraps {@link org.oep.cmon.dao.cd.service.impl.TinhTrangHonNhanLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see TinhTrangHonNhanLocalService
 * @see org.oep.cmon.dao.cd.service.base.TinhTrangHonNhanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.impl.TinhTrangHonNhanLocalServiceImpl
 * @generated
 */
public class TinhTrangHonNhanLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.cd.service.impl.TinhTrangHonNhanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tinh trang hon nhan to the database. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @return the tinh trang hon nhan that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan addTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTinhTrangHonNhan(tinhTrangHonNhan);
	}

	/**
	* Creates a new tinh trang hon nhan with the primary key. Does not add the tinh trang hon nhan to the database.
	*
	* @param id the primary key for the new tinh trang hon nhan
	* @return the new tinh trang hon nhan
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan createTinhTrangHonNhan(
		long id) {
		return getService().createTinhTrangHonNhan(id);
	}

	/**
	* Deletes the tinh trang hon nhan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @throws PortalException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTinhTrangHonNhan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTinhTrangHonNhan(id);
	}

	/**
	* Deletes the tinh trang hon nhan from the database. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTinhTrangHonNhan(tinhTrangHonNhan);
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

	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan fetchTinhTrangHonNhan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTinhTrangHonNhan(id);
	}

	/**
	* Returns the tinh trang hon nhan with the primary key.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan
	* @throws PortalException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan getTinhTrangHonNhan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTinhTrangHonNhan(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tinh trang hon nhans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @return the range of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> getTinhTrangHonNhans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTinhTrangHonNhans(start, end);
	}

	/**
	* Returns the number of tinh trang hon nhans.
	*
	* @return the number of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static int getTinhTrangHonNhansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTinhTrangHonNhansCount();
	}

	/**
	* Updates the tinh trang hon nhan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @return the tinh trang hon nhan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan updateTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTinhTrangHonNhan(tinhTrangHonNhan);
	}

	/**
	* Updates the tinh trang hon nhan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	* @param merge whether to merge the tinh trang hon nhan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tinh trang hon nhan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan updateTinhTrangHonNhan(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTinhTrangHonNhan(tinhTrangHonNhan, merge);
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
	* This is fucntion getAll TinhTrangHonNhan by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<TinhTrangHonNhan>
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> getAll(
		int daXoa) {
		return getService().getAll(daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static TinhTrangHonNhanLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TinhTrangHonNhanLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TinhTrangHonNhanLocalService.class.getName(),
					portletClassLoader);

			_service = new TinhTrangHonNhanLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TinhTrangHonNhanLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TinhTrangHonNhanLocalService.class);
		}

		return _service;
	}

	public void setService(TinhTrangHonNhanLocalService service) {
		MethodCache.remove(TinhTrangHonNhanLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TinhTrangHonNhanLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TinhTrangHonNhanLocalService.class);
	}

	private static TinhTrangHonNhanLocalService _service;
}