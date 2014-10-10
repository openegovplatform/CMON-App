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
 * The utility for the trinh do chuyen mon local service. This utility wraps {@link org.oep.cmon.dao.cd.service.impl.TrinhDoChuyenMonLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see TrinhDoChuyenMonLocalService
 * @see org.oep.cmon.dao.cd.service.base.TrinhDoChuyenMonLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.impl.TrinhDoChuyenMonLocalServiceImpl
 * @generated
 */
public class TrinhDoChuyenMonLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.cd.service.impl.TrinhDoChuyenMonLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the trinh do chuyen mon to the database. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @return the trinh do chuyen mon that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TrinhDoChuyenMon addTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTrinhDoChuyenMon(trinhDoChuyenMon);
	}

	/**
	* Creates a new trinh do chuyen mon with the primary key. Does not add the trinh do chuyen mon to the database.
	*
	* @param id the primary key for the new trinh do chuyen mon
	* @return the new trinh do chuyen mon
	*/
	public static org.oep.cmon.dao.cd.model.TrinhDoChuyenMon createTrinhDoChuyenMon(
		long id) {
		return getService().createTrinhDoChuyenMon(id);
	}

	/**
	* Deletes the trinh do chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @throws PortalException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTrinhDoChuyenMon(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTrinhDoChuyenMon(id);
	}

	/**
	* Deletes the trinh do chuyen mon from the database. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTrinhDoChuyenMon(trinhDoChuyenMon);
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

	public static org.oep.cmon.dao.cd.model.TrinhDoChuyenMon fetchTrinhDoChuyenMon(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTrinhDoChuyenMon(id);
	}

	/**
	* Returns the trinh do chuyen mon with the primary key.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @return the trinh do chuyen mon
	* @throws PortalException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TrinhDoChuyenMon getTrinhDoChuyenMon(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrinhDoChuyenMon(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trinh do chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trinh do chuyen mons
	* @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	* @return the range of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> getTrinhDoChuyenMons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrinhDoChuyenMons(start, end);
	}

	/**
	* Returns the number of trinh do chuyen mons.
	*
	* @return the number of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public static int getTrinhDoChuyenMonsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrinhDoChuyenMonsCount();
	}

	/**
	* Updates the trinh do chuyen mon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @return the trinh do chuyen mon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TrinhDoChuyenMon updateTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTrinhDoChuyenMon(trinhDoChuyenMon);
	}

	/**
	* Updates the trinh do chuyen mon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @param merge whether to merge the trinh do chuyen mon with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trinh do chuyen mon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TrinhDoChuyenMon updateTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTrinhDoChuyenMon(trinhDoChuyenMon, merge);
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
	* This is fucntion find all TrinhDoChuyenMon
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<TrinhDoChuyenMon>
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	/**
	* This is fucntion find TrinhDoChuyenMon by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<TrinhDoChuyenMon>
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findByStatus(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus(daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static TrinhDoChuyenMonLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TrinhDoChuyenMonLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TrinhDoChuyenMonLocalService.class.getName(),
					portletClassLoader);

			_service = new TrinhDoChuyenMonLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TrinhDoChuyenMonLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TrinhDoChuyenMonLocalService.class);
		}

		return _service;
	}

	public void setService(TrinhDoChuyenMonLocalService service) {
		MethodCache.remove(TrinhDoChuyenMonLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TrinhDoChuyenMonLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TrinhDoChuyenMonLocalService.class);
	}

	private static TrinhDoChuyenMonLocalService _service;
}