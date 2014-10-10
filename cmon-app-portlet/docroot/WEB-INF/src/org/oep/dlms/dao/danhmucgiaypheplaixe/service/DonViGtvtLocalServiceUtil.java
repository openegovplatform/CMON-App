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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the don vi gtvt local service. This utility wraps {@link org.oep.dlms.dao.danhmucgiaypheplaixe.service.impl.DonViGtvtLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhNT
 * @see DonViGtvtLocalService
 * @see org.oep.dlms.dao.danhmucgiaypheplaixe.service.base.DonViGtvtLocalServiceBaseImpl
 * @see org.oep.dlms.dao.danhmucgiaypheplaixe.service.impl.DonViGtvtLocalServiceImpl
 * @generated
 */
public class DonViGtvtLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.dlms.dao.danhmucgiaypheplaixe.service.impl.DonViGtvtLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the don vi gtvt to the database. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @return the don vi gtvt that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt addDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDonViGtvt(donViGtvt);
	}

	/**
	* Creates a new don vi gtvt with the primary key. Does not add the don vi gtvt to the database.
	*
	* @param id the primary key for the new don vi gtvt
	* @return the new don vi gtvt
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt createDonViGtvt(
		long id) {
		return getService().createDonViGtvt(id);
	}

	/**
	* Deletes the don vi gtvt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi gtvt
	* @throws PortalException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDonViGtvt(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDonViGtvt(id);
	}

	/**
	* Deletes the don vi gtvt from the database. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDonViGtvt(donViGtvt);
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

	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt fetchDonViGtvt(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDonViGtvt(id);
	}

	/**
	* Returns the don vi gtvt with the primary key.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt
	* @throws PortalException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt getDonViGtvt(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDonViGtvt(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the don vi gtvts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi gtvts
	* @param end the upper bound of the range of don vi gtvts (not inclusive)
	* @return the range of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> getDonViGtvts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDonViGtvts(start, end);
	}

	/**
	* Returns the number of don vi gtvts.
	*
	* @return the number of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public static int getDonViGtvtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDonViGtvtsCount();
	}

	/**
	* Updates the don vi gtvt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @return the don vi gtvt that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt updateDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDonViGtvt(donViGtvt);
	}

	/**
	* Updates the don vi gtvt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donViGtvt the don vi gtvt
	* @param merge whether to merge the don vi gtvt with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the don vi gtvt that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt updateDonViGtvt(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDonViGtvt(donViGtvt, merge);
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

	public static DonViGtvtLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DonViGtvtLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DonViGtvtLocalService.class.getName(), portletClassLoader);

			_service = new DonViGtvtLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DonViGtvtLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DonViGtvtLocalService.class);
		}

		return _service;
	}

	public void setService(DonViGtvtLocalService service) {
		MethodCache.remove(DonViGtvtLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DonViGtvtLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DonViGtvtLocalService.class);
	}

	private static DonViGtvtLocalService _service;
}