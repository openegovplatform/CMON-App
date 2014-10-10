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

package org.oep.cmon.dao.job.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the trang thai job local service. This utility wraps {@link org.oep.cmon.dao.job.service.impl.TrangThaiJobLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BinhNT
 * @see TrangThaiJobLocalService
 * @see org.oep.cmon.dao.job.service.base.TrangThaiJobLocalServiceBaseImpl
 * @see org.oep.cmon.dao.job.service.impl.TrangThaiJobLocalServiceImpl
 * @generated
 */
public class TrangThaiJobLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.job.service.impl.TrangThaiJobLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the trang thai job to the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @return the trang thai job that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob addTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTrangThaiJob(trangThaiJob);
	}

	/**
	* Creates a new trang thai job with the primary key. Does not add the trang thai job to the database.
	*
	* @param ID the primary key for the new trang thai job
	* @return the new trang thai job
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob createTrangThaiJob(
		long ID) {
		return getService().createTrangThaiJob(ID);
	}

	/**
	* Deletes the trang thai job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the trang thai job
	* @throws PortalException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTrangThaiJob(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTrangThaiJob(ID);
	}

	/**
	* Deletes the trang thai job from the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTrangThaiJob(trangThaiJob);
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

	public static org.oep.cmon.dao.job.model.TrangThaiJob fetchTrangThaiJob(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTrangThaiJob(ID);
	}

	/**
	* Returns the trang thai job with the primary key.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job
	* @throws PortalException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob getTrangThaiJob(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrangThaiJob(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trang thai jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai jobs
	* @param end the upper bound of the range of trang thai jobs (not inclusive)
	* @return the range of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> getTrangThaiJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrangThaiJobs(start, end);
	}

	/**
	* Returns the number of trang thai jobs.
	*
	* @return the number of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int getTrangThaiJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrangThaiJobsCount();
	}

	/**
	* Updates the trang thai job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @return the trang thai job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob updateTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTrangThaiJob(trangThaiJob);
	}

	/**
	* Updates the trang thai job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @param merge whether to merge the trang thai job with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trang thai job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob updateTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTrangThaiJob(trangThaiJob, merge);
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
	* This is fucntion findByJobId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int jobId
	* @return List<TrangThaiJob>
	*/
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int jobId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByJobId(jobId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TrangThaiJobLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TrangThaiJobLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TrangThaiJobLocalService.class.getName(), portletClassLoader);

			_service = new TrangThaiJobLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TrangThaiJobLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TrangThaiJobLocalService.class);
		}

		return _service;
	}

	public void setService(TrangThaiJobLocalService service) {
		MethodCache.remove(TrangThaiJobLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TrangThaiJobLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TrangThaiJobLocalService.class);
	}

	private static TrangThaiJobLocalService _service;
}