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
 * The utility for the lephi_chitiet local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.Lephi_chitietLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see Lephi_chitietLocalService
 * @see org.oep.cmon.dao.report.service.base.Lephi_chitietLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.Lephi_chitietLocalServiceImpl
 * @generated
 */
public class Lephi_chitietLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.Lephi_chitietLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lephi_chitiet to the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_chitiet the lephi_chitiet
	* @return the lephi_chitiet that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet addLephi_chitiet(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLephi_chitiet(lephi_chitiet);
	}

	/**
	* Creates a new lephi_chitiet with the primary key. Does not add the lephi_chitiet to the database.
	*
	* @param ID the primary key for the new lephi_chitiet
	* @return the new lephi_chitiet
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet createLephi_chitiet(
		long ID) {
		return getService().createLephi_chitiet(ID);
	}

	/**
	* Deletes the lephi_chitiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the lephi_chitiet
	* @throws PortalException if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLephi_chitiet(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLephi_chitiet(ID);
	}

	/**
	* Deletes the lephi_chitiet from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_chitiet the lephi_chitiet
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLephi_chitiet(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLephi_chitiet(lephi_chitiet);
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

	public static org.oep.cmon.dao.report.model.Lephi_chitiet fetchLephi_chitiet(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLephi_chitiet(ID);
	}

	/**
	* Returns the lephi_chitiet with the primary key.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet
	* @throws PortalException if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet getLephi_chitiet(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_chitiet(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lephi_chitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_chitiets
	* @param end the upper bound of the range of lephi_chitiets (not inclusive)
	* @return the range of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> getLephi_chitiets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_chitiets(start, end);
	}

	/**
	* Returns the number of lephi_chitiets.
	*
	* @return the number of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public static int getLephi_chitietsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLephi_chitietsCount();
	}

	/**
	* Updates the lephi_chitiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_chitiet the lephi_chitiet
	* @return the lephi_chitiet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet updateLephi_chitiet(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLephi_chitiet(lephi_chitiet);
	}

	/**
	* Updates the lephi_chitiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_chitiet the lephi_chitiet
	* @param merge whether to merge the lephi_chitiet with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lephi_chitiet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet updateLephi_chitiet(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLephi_chitiet(lephi_chitiet, merge);
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
	* This is fucntion lephichitiet
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String id_loaihoso,String ngaynhan_tungay, String ngaynhan_denngay
	* @return List<Lephi_chitiet>
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> lephichitiet(
		java.lang.String id_loaihoso, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return getService()
				   .lephichitiet(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}

	public static void clearService() {
		_service = null;
	}

	public static Lephi_chitietLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Lephi_chitietLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					Lephi_chitietLocalService.class.getName(),
					portletClassLoader);

			_service = new Lephi_chitietLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(Lephi_chitietLocalServiceUtil.class,
				"_service");
			MethodCache.remove(Lephi_chitietLocalService.class);
		}

		return _service;
	}

	public void setService(Lephi_chitietLocalService service) {
		MethodCache.remove(Lephi_chitietLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(Lephi_chitietLocalServiceUtil.class,
			"_service");
		MethodCache.remove(Lephi_chitietLocalService.class);
	}

	private static Lephi_chitietLocalService _service;
}