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

package org.oep.cmon.dao.chungthuc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the so danh muc local service. This utility wraps {@link org.oep.cmon.dao.chungthuc.service.impl.SoDanhMucLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vietho
 * @see SoDanhMucLocalService
 * @see org.oep.cmon.dao.chungthuc.service.base.SoDanhMucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.chungthuc.service.impl.SoDanhMucLocalServiceImpl
 * @generated
 */
public class SoDanhMucLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.chungthuc.service.impl.SoDanhMucLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the so danh muc to the database. Also notifies the appropriate model listeners.
	*
	* @param soDanhMuc the so danh muc
	* @return the so danh muc that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc addSoDanhMuc(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSoDanhMuc(soDanhMuc);
	}

	/**
	* Creates a new so danh muc with the primary key. Does not add the so danh muc to the database.
	*
	* @param id the primary key for the new so danh muc
	* @return the new so danh muc
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc createSoDanhMuc(
		long id) {
		return getService().createSoDanhMuc(id);
	}

	/**
	* Deletes the so danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the so danh muc
	* @throws PortalException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSoDanhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSoDanhMuc(id);
	}

	/**
	* Deletes the so danh muc from the database. Also notifies the appropriate model listeners.
	*
	* @param soDanhMuc the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSoDanhMuc(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSoDanhMuc(soDanhMuc);
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

	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc fetchSoDanhMuc(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSoDanhMuc(id);
	}

	/**
	* Returns the so danh muc with the primary key.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc
	* @throws PortalException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc getSoDanhMuc(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSoDanhMuc(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the so danh mucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> getSoDanhMucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSoDanhMucs(start, end);
	}

	/**
	* Returns the number of so danh mucs.
	*
	* @return the number of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static int getSoDanhMucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSoDanhMucsCount();
	}

	/**
	* Updates the so danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param soDanhMuc the so danh muc
	* @return the so danh muc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc updateSoDanhMuc(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSoDanhMuc(soDanhMuc);
	}

	/**
	* Updates the so danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param soDanhMuc the so danh muc
	* @param merge whether to merge the so danh muc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the so danh muc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc updateSoDanhMuc(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSoDanhMuc(soDanhMuc, merge);
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
	* This is fucntion get SoDanhMuc by tthcId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long tthcId
	* @return List<SoDanhMuc>
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> getSoDanhMucByTTHCID(
		long tthcId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSoDanhMucByTTHCID(tthcId);
	}

	/**
	* This is fucntion find SoDanhMuc by tthcId, coQuanId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long tthcId, long coQuanId
	* @return List<SoDanhMuc>
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> getSoDanhMucByTTHCIDAndCQQLID(
		long tthcId, long coQuanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSoDanhMucByTTHCIDAndCQQLID(tthcId, coQuanId);
	}

	/**
	* This is fucntion find SoDanhMuc by coQuanId and paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanId, int start, int end
	* @return List<SoDanhMuc>
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> getSoDanhMucByCoQuanQuanLyId(
		long coQuanId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSoDanhMucByCoQuanQuanLyId(coQuanId, start, end);
	}

	/**
	* This is fucntion count SoDanhMuc by coQuanId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanId
	* @return List<SoDanhMuc>
	*/
	public static int countSoDanhMucByCoQuanQuanLyId(long coQuanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countSoDanhMucByCoQuanQuanLyId(coQuanId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SoDanhMucLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SoDanhMucLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					SoDanhMucLocalService.class.getName(), portletClassLoader);

			_service = new SoDanhMucLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(SoDanhMucLocalServiceUtil.class,
				"_service");
			MethodCache.remove(SoDanhMucLocalService.class);
		}

		return _service;
	}

	public void setService(SoDanhMucLocalService service) {
		MethodCache.remove(SoDanhMucLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(SoDanhMucLocalServiceUtil.class,
			"_service");
		MethodCache.remove(SoDanhMucLocalService.class);
	}

	private static SoDanhMucLocalService _service;
}