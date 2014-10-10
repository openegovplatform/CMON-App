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
 * The utility for the danh muc bao cao local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.DanhMucBaoCaoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see DanhMucBaoCaoLocalService
 * @see org.oep.cmon.dao.report.service.base.DanhMucBaoCaoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.DanhMucBaoCaoLocalServiceImpl
 * @generated
 */
public class DanhMucBaoCaoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.DanhMucBaoCaoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the danh muc bao cao to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @return the danh muc bao cao that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucBaoCao addDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDanhMucBaoCao(danhMucBaoCao);
	}

	/**
	* Creates a new danh muc bao cao with the primary key. Does not add the danh muc bao cao to the database.
	*
	* @param ID the primary key for the new danh muc bao cao
	* @return the new danh muc bao cao
	*/
	public static org.oep.cmon.dao.report.model.DanhMucBaoCao createDanhMucBaoCao(
		long ID) {
		return getService().createDanhMucBaoCao(ID);
	}

	/**
	* Deletes the danh muc bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc bao cao
	* @throws PortalException if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucBaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucBaoCao(ID);
	}

	/**
	* Deletes the danh muc bao cao from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucBaoCao(danhMucBaoCao);
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

	public static org.oep.cmon.dao.report.model.DanhMucBaoCao fetchDanhMucBaoCao(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDanhMucBaoCao(ID);
	}

	/**
	* Returns the danh muc bao cao with the primary key.
	*
	* @param ID the primary key of the danh muc bao cao
	* @return the danh muc bao cao
	* @throws PortalException if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucBaoCao getDanhMucBaoCao(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucBaoCao(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc bao caos
	* @param end the upper bound of the range of danh muc bao caos (not inclusive)
	* @return the range of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> getDanhMucBaoCaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucBaoCaos(start, end);
	}

	/**
	* Returns the number of danh muc bao caos.
	*
	* @return the number of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static int getDanhMucBaoCaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucBaoCaosCount();
	}

	/**
	* Updates the danh muc bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @return the danh muc bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucBaoCao updateDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhMucBaoCao(danhMucBaoCao);
	}

	/**
	* Updates the danh muc bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @param merge whether to merge the danh muc bao cao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucBaoCao updateDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhMucBaoCao(danhMucBaoCao, merge);
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

	public static DanhMucBaoCaoLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DanhMucBaoCaoLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DanhMucBaoCaoLocalService.class.getName(),
					portletClassLoader);

			_service = new DanhMucBaoCaoLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DanhMucBaoCaoLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DanhMucBaoCaoLocalService.class);
		}

		return _service;
	}

	public void setService(DanhMucBaoCaoLocalService service) {
		MethodCache.remove(DanhMucBaoCaoLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DanhMucBaoCaoLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DanhMucBaoCaoLocalService.class);
	}

	private static DanhMucBaoCaoLocalService _service;
}