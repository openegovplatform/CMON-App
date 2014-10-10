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
 * The utility for the lephi_linhvuc local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.Lephi_linhvucLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see Lephi_linhvucLocalService
 * @see org.oep.cmon.dao.report.service.base.Lephi_linhvucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.Lephi_linhvucLocalServiceImpl
 * @generated
 */
public class Lephi_linhvucLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.Lephi_linhvucLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lephi_linhvuc to the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @return the lephi_linhvuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc addLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLephi_linhvuc(lephi_linhvuc);
	}

	/**
	* Creates a new lephi_linhvuc with the primary key. Does not add the lephi_linhvuc to the database.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key for the new lephi_linhvuc
	* @return the new lephi_linhvuc
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc createLephi_linhvuc(
		int NHOMTHUTUCHANHCHINHID) {
		return getService().createLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Deletes the lephi_linhvuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @throws PortalException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLephi_linhvuc(int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Deletes the lephi_linhvuc from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLephi_linhvuc(lephi_linhvuc);
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

	public static org.oep.cmon.dao.report.model.Lephi_linhvuc fetchLephi_linhvuc(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the lephi_linhvuc with the primary key.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc
	* @throws PortalException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc getLephi_linhvuc(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lephi_linhvucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_linhvucs
	* @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	* @return the range of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> getLephi_linhvucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_linhvucs(start, end);
	}

	/**
	* Returns the number of lephi_linhvucs.
	*
	* @return the number of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public static int getLephi_linhvucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_linhvucsCount();
	}

	/**
	* Updates the lephi_linhvuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @return the lephi_linhvuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc updateLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLephi_linhvuc(lephi_linhvuc);
	}

	/**
	* Updates the lephi_linhvuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @param merge whether to merge the lephi_linhvuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lephi_linhvuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc updateLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLephi_linhvuc(lephi_linhvuc, merge);
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
	* This is fucntion lephilinhvuc
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String id_linhvuc,String ngaynhan_tungay, String ngaynhan_denngay
	* @return List<Lephi_linhvuc>
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> lephilinhvuc(
		java.lang.String id_linhvuc, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return getService()
				   .lephilinhvuc(id_linhvuc, ngaynhan_tungay, ngaynhan_denngay);
	}

	public static void clearService() {
		_service = null;
	}

	public static Lephi_linhvucLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Lephi_linhvucLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					Lephi_linhvucLocalService.class.getName(),
					portletClassLoader);

			_service = new Lephi_linhvucLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(Lephi_linhvucLocalServiceUtil.class,
				"_service");
			MethodCache.remove(Lephi_linhvucLocalService.class);
		}

		return _service;
	}

	public void setService(Lephi_linhvucLocalService service) {
		MethodCache.remove(Lephi_linhvucLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(Lephi_linhvucLocalServiceUtil.class,
			"_service");
		MethodCache.remove(Lephi_linhvucLocalService.class);
	}

	private static Lephi_linhvucLocalService _service;
}