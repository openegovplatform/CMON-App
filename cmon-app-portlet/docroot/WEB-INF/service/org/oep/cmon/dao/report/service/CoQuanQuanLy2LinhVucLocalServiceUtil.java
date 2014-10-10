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
 * The utility for the co quan quan ly2 linh vuc local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.CoQuanQuanLy2LinhVucLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see CoQuanQuanLy2LinhVucLocalService
 * @see org.oep.cmon.dao.report.service.base.CoQuanQuanLy2LinhVucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.CoQuanQuanLy2LinhVucLocalServiceImpl
 * @generated
 */
public class CoQuanQuanLy2LinhVucLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.CoQuanQuanLy2LinhVucLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the co quan quan ly2 linh vuc to the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy2LinhVuc the co quan quan ly2 linh vuc
	* @return the co quan quan ly2 linh vuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc addCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCoQuanQuanLy2LinhVuc(coQuanQuanLy2LinhVuc);
	}

	/**
	* Creates a new co quan quan ly2 linh vuc with the primary key. Does not add the co quan quan ly2 linh vuc to the database.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key for the new co quan quan ly2 linh vuc
	* @return the new co quan quan ly2 linh vuc
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc createCoQuanQuanLy2LinhVuc(
		long NHOMTHUTUCHANHCHINHID) {
		return getService().createCoQuanQuanLy2LinhVuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Deletes the co quan quan ly2 linh vuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	* @throws PortalException if a co quan quan ly2 linh vuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCoQuanQuanLy2LinhVuc(long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCoQuanQuanLy2LinhVuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Deletes the co quan quan ly2 linh vuc from the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy2LinhVuc the co quan quan ly2 linh vuc
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCoQuanQuanLy2LinhVuc(coQuanQuanLy2LinhVuc);
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

	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc fetchCoQuanQuanLy2LinhVuc(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCoQuanQuanLy2LinhVuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the co quan quan ly2 linh vuc with the primary key.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	* @return the co quan quan ly2 linh vuc
	* @throws PortalException if a co quan quan ly2 linh vuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc getCoQuanQuanLy2LinhVuc(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoQuanQuanLy2LinhVuc(NHOMTHUTUCHANHCHINHID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the co quan quan ly2 linh vucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan ly2 linh vucs
	* @param end the upper bound of the range of co quan quan ly2 linh vucs (not inclusive)
	* @return the range of co quan quan ly2 linh vucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> getCoQuanQuanLy2LinhVucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoQuanQuanLy2LinhVucs(start, end);
	}

	/**
	* Returns the number of co quan quan ly2 linh vucs.
	*
	* @return the number of co quan quan ly2 linh vucs
	* @throws SystemException if a system exception occurred
	*/
	public static int getCoQuanQuanLy2LinhVucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoQuanQuanLy2LinhVucsCount();
	}

	/**
	* Updates the co quan quan ly2 linh vuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy2LinhVuc the co quan quan ly2 linh vuc
	* @return the co quan quan ly2 linh vuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc updateCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCoQuanQuanLy2LinhVuc(coQuanQuanLy2LinhVuc);
	}

	/**
	* Updates the co quan quan ly2 linh vuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy2LinhVuc the co quan quan ly2 linh vuc
	* @param merge whether to merge the co quan quan ly2 linh vuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the co quan quan ly2 linh vuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc updateCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCoQuanQuanLy2LinhVuc(coQuanQuanLy2LinhVuc, merge);
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
	* This is fucntion getLinhvucByIdDonvi
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String id_donvibaocao
	* @return List<CoQuanQuanLy2LinhVuc>
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> getLinhvucByIdDonvi(
		java.lang.String id_donvibaocao) throws java.lang.Exception {
		return getService().getLinhvucByIdDonvi(id_donvibaocao);
	}

	/**
	* This is fucntion getTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String nhomtthc_id,String donvi_id
	* @return List<ThuTucHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getTTHC(
		java.lang.String nhomtthc_id, java.lang.String donvi_id)
		throws java.lang.Exception {
		return getService().getTTHC(nhomtthc_id, donvi_id);
	}

	public static void clearService() {
		_service = null;
	}

	public static CoQuanQuanLy2LinhVucLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CoQuanQuanLy2LinhVucLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CoQuanQuanLy2LinhVucLocalService.class.getName(),
					portletClassLoader);

			_service = new CoQuanQuanLy2LinhVucLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CoQuanQuanLy2LinhVucLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CoQuanQuanLy2LinhVucLocalService.class);
		}

		return _service;
	}

	public void setService(CoQuanQuanLy2LinhVucLocalService service) {
		MethodCache.remove(CoQuanQuanLy2LinhVucLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CoQuanQuanLy2LinhVucLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CoQuanQuanLy2LinhVucLocalService.class);
	}

	private static CoQuanQuanLy2LinhVucLocalService _service;
}