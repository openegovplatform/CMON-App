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
 * The utility for the thu tuc2 giay to local service. This utility wraps {@link org.oep.cmon.dao.dvc.service.impl.ThuTuc2GiayToLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see ThuTuc2GiayToLocalService
 * @see org.oep.cmon.dao.dvc.service.base.ThuTuc2GiayToLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.ThuTuc2GiayToLocalServiceImpl
 * @generated
 */
public class ThuTuc2GiayToLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.ThuTuc2GiayToLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the thu tuc2 giay to to the database. Also notifies the appropriate model listeners.
	*
	* @param thuTuc2GiayTo the thu tuc2 giay to
	* @return the thu tuc2 giay to that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo addThuTuc2GiayTo(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThuTuc2GiayTo(thuTuc2GiayTo);
	}

	/**
	* Creates a new thu tuc2 giay to with the primary key. Does not add the thu tuc2 giay to to the database.
	*
	* @param id the primary key for the new thu tuc2 giay to
	* @return the new thu tuc2 giay to
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo createThuTuc2GiayTo(
		long id) {
		return getService().createThuTuc2GiayTo(id);
	}

	/**
	* Deletes the thu tuc2 giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @throws PortalException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThuTuc2GiayTo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThuTuc2GiayTo(id);
	}

	/**
	* Deletes the thu tuc2 giay to from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTuc2GiayTo the thu tuc2 giay to
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThuTuc2GiayTo(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThuTuc2GiayTo(thuTuc2GiayTo);
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

	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo fetchThuTuc2GiayTo(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchThuTuc2GiayTo(id);
	}

	/**
	* Returns the thu tuc2 giay to with the primary key.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to
	* @throws PortalException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo getThuTuc2GiayTo(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThuTuc2GiayTo(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the thu tuc2 giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> getThuTuc2GiayTos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThuTuc2GiayTos(start, end);
	}

	/**
	* Returns the number of thu tuc2 giay tos.
	*
	* @return the number of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int getThuTuc2GiayTosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThuTuc2GiayTosCount();
	}

	/**
	* Updates the thu tuc2 giay to in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thuTuc2GiayTo the thu tuc2 giay to
	* @return the thu tuc2 giay to that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo updateThuTuc2GiayTo(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThuTuc2GiayTo(thuTuc2GiayTo);
	}

	/**
	* Updates the thu tuc2 giay to in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thuTuc2GiayTo the thu tuc2 giay to
	* @param merge whether to merge the thu tuc2 giay to with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the thu tuc2 giay to that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo updateThuTuc2GiayTo(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThuTuc2GiayTo(thuTuc2GiayTo, merge);
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
	* This is fucntion get ThuTuc2GiayTo by thuTucId, giaiDoan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucId, int giaiDoan
	* @return List<ThuTuc2GiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem> getDSGiayToByThuTucVaGiaiDoan(
		long thuTucId, int giaiDoan) throws java.lang.Exception {
		return getService().getDSGiayToByThuTucVaGiaiDoan(thuTucId, giaiDoan);
	}

	/**
	* This is fucntion get ThuTuc2GiayTo by thutucId, status,step
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long thutucId,int status,int step
	* @return List<ThuTuc2GiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> getDSGiayToTheoThuTuc(
		java.lang.Long thutucId, int status, int step) {
		return getService().getDSGiayToTheoThuTuc(thutucId, status, step);
	}

	/**
	* This is fucntion get ThuTuc2GiayTo by thutucId, giaytoId,step
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long thutucId,Long giaytoId,int step
	* @return List<ThuTuc2GiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> getDSTT2GiayTo(
		java.lang.Long thutucId, java.lang.Long giaytoId, int step) {
		return getService().getDSTT2GiayTo(thutucId, giaytoId, step);
	}

	public static void clearService() {
		_service = null;
	}

	public static ThuTuc2GiayToLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ThuTuc2GiayToLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ThuTuc2GiayToLocalService.class.getName(),
					portletClassLoader);

			_service = new ThuTuc2GiayToLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ThuTuc2GiayToLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ThuTuc2GiayToLocalService.class);
		}

		return _service;
	}

	public void setService(ThuTuc2GiayToLocalService service) {
		MethodCache.remove(ThuTuc2GiayToLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ThuTuc2GiayToLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ThuTuc2GiayToLocalService.class);
	}

	private static ThuTuc2GiayToLocalService _service;
}