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

package org.oep.cmon.dao.dvc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the cau hinh portlet2 thu tuc local service. This utility wraps {@link org.oep.cmon.dao.dvc.service.impl.CauHinhPortlet2ThuTucLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see CauHinhPortlet2ThuTucLocalService
 * @see org.oep.cmon.dao.dvc.service.base.CauHinhPortlet2ThuTucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.CauHinhPortlet2ThuTucLocalServiceImpl
 * @generated
 */
public class CauHinhPortlet2ThuTucLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.CauHinhPortlet2ThuTucLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cau hinh portlet2 thu tuc to the database. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc addCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);
	}

	/**
	* Creates a new cau hinh portlet2 thu tuc with the primary key. Does not add the cau hinh portlet2 thu tuc to the database.
	*
	* @param thuTucHanhChinhId the primary key for the new cau hinh portlet2 thu tuc
	* @return the new cau hinh portlet2 thu tuc
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc createCauHinhPortlet2ThuTuc(
		long thuTucHanhChinhId) {
		return getService().createCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	/**
	* Deletes the cau hinh portlet2 thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @throws PortalException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCauHinhPortlet2ThuTuc(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	/**
	* Deletes the cau hinh portlet2 thu tuc from the database. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);
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

	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchCauHinhPortlet2ThuTuc(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc with the primary key.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc
	* @throws PortalException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc getCauHinhPortlet2ThuTuc(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCauHinhPortlet2ThuTuc(thuTucHanhChinhId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cau hinh portlet2 thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cau hinh portlet2 thu tucs
	* @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	* @return the range of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> getCauHinhPortlet2ThuTucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCauHinhPortlet2ThuTucs(start, end);
	}

	/**
	* Returns the number of cau hinh portlet2 thu tucs.
	*
	* @return the number of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int getCauHinhPortlet2ThuTucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCauHinhPortlet2ThuTucsCount();
	}

	/**
	* Updates the cau hinh portlet2 thu tuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc updateCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);
	}

	/**
	* Updates the cau hinh portlet2 thu tuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	* @param merge whether to merge the cau hinh portlet2 thu tuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cau hinh portlet2 thu tuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc updateCauHinhPortlet2ThuTuc(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc, merge);
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

	public static CauHinhPortlet2ThuTucLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CauHinhPortlet2ThuTucLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CauHinhPortlet2ThuTucLocalService.class.getName(),
					portletClassLoader);

			_service = new CauHinhPortlet2ThuTucLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CauHinhPortlet2ThuTucLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CauHinhPortlet2ThuTucLocalService.class);
		}

		return _service;
	}

	public void setService(CauHinhPortlet2ThuTucLocalService service) {
		MethodCache.remove(CauHinhPortlet2ThuTucLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CauHinhPortlet2ThuTucLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CauHinhPortlet2ThuTucLocalService.class);
	}

	private static CauHinhPortlet2ThuTucLocalService _service;
}