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
 * The utility for the lephi_tonghop local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.Lephi_tonghopLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see Lephi_tonghopLocalService
 * @see org.oep.cmon.dao.report.service.base.Lephi_tonghopLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.Lephi_tonghopLocalServiceImpl
 * @generated
 */
public class Lephi_tonghopLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.Lephi_tonghopLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lephi_tonghop to the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghop the lephi_tonghop
	* @return the lephi_tonghop that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop addLephi_tonghop(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLephi_tonghop(lephi_tonghop);
	}

	/**
	* Creates a new lephi_tonghop with the primary key. Does not add the lephi_tonghop to the database.
	*
	* @param lephi_tonghopPK the primary key for the new lephi_tonghop
	* @return the new lephi_tonghop
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop createLephi_tonghop(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK) {
		return getService().createLephi_tonghop(lephi_tonghopPK);
	}

	/**
	* Deletes the lephi_tonghop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @throws PortalException if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLephi_tonghop(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLephi_tonghop(lephi_tonghopPK);
	}

	/**
	* Deletes the lephi_tonghop from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghop the lephi_tonghop
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLephi_tonghop(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLephi_tonghop(lephi_tonghop);
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

	public static org.oep.cmon.dao.report.model.Lephi_tonghop fetchLephi_tonghop(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLephi_tonghop(lephi_tonghopPK);
	}

	/**
	* Returns the lephi_tonghop with the primary key.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop
	* @throws PortalException if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop getLephi_tonghop(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_tonghop(lephi_tonghopPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lephi_tonghops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_tonghops
	* @param end the upper bound of the range of lephi_tonghops (not inclusive)
	* @return the range of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> getLephi_tonghops(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_tonghops(start, end);
	}

	/**
	* Returns the number of lephi_tonghops.
	*
	* @return the number of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public static int getLephi_tonghopsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_tonghopsCount();
	}

	/**
	* Updates the lephi_tonghop in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghop the lephi_tonghop
	* @return the lephi_tonghop that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop updateLephi_tonghop(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLephi_tonghop(lephi_tonghop);
	}

	/**
	* Updates the lephi_tonghop in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghop the lephi_tonghop
	* @param merge whether to merge the lephi_tonghop with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lephi_tonghop that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop updateLephi_tonghop(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLephi_tonghop(lephi_tonghop, merge);
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
	* This is fucntion lephitonghop
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String id_loaihoso,String ngaynhan_tungay, String ngaynhan_denngay
	* @return List<Lephi_tonghop>
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> lephitonghop(
		java.lang.String id_loaihoso, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return getService()
				   .lephitonghop(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}

	public static void clearService() {
		_service = null;
	}

	public static Lephi_tonghopLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Lephi_tonghopLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					Lephi_tonghopLocalService.class.getName(),
					portletClassLoader);

			_service = new Lephi_tonghopLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(Lephi_tonghopLocalServiceUtil.class,
				"_service");
			MethodCache.remove(Lephi_tonghopLocalService.class);
		}

		return _service;
	}

	public void setService(Lephi_tonghopLocalService service) {
		MethodCache.remove(Lephi_tonghopLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(Lephi_tonghopLocalServiceUtil.class,
			"_service");
		MethodCache.remove(Lephi_tonghopLocalService.class);
	}

	private static Lephi_tonghopLocalService _service;
}