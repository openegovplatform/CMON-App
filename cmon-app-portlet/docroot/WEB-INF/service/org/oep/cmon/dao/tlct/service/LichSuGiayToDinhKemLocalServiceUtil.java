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

package org.oep.cmon.dao.tlct.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the lich su giay to dinh kem local service. This utility wraps {@link org.oep.cmon.dao.tlct.service.impl.LichSuGiayToDinhKemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see LichSuGiayToDinhKemLocalService
 * @see org.oep.cmon.dao.tlct.service.base.LichSuGiayToDinhKemLocalServiceBaseImpl
 * @see org.oep.cmon.dao.tlct.service.impl.LichSuGiayToDinhKemLocalServiceImpl
 * @generated
 */
public class LichSuGiayToDinhKemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.tlct.service.impl.LichSuGiayToDinhKemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lich su giay to dinh kem to the database. Also notifies the appropriate model listeners.
	*
	* @param lichSuGiayToDinhKem the lich su giay to dinh kem
	* @return the lich su giay to dinh kem that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem addLichSuGiayToDinhKem(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLichSuGiayToDinhKem(lichSuGiayToDinhKem);
	}

	/**
	* Creates a new lich su giay to dinh kem with the primary key. Does not add the lich su giay to dinh kem to the database.
	*
	* @param id the primary key for the new lich su giay to dinh kem
	* @return the new lich su giay to dinh kem
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem createLichSuGiayToDinhKem(
		long id) {
		return getService().createLichSuGiayToDinhKem(id);
	}

	/**
	* Deletes the lich su giay to dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the lich su giay to dinh kem
	* @throws PortalException if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLichSuGiayToDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLichSuGiayToDinhKem(id);
	}

	/**
	* Deletes the lich su giay to dinh kem from the database. Also notifies the appropriate model listeners.
	*
	* @param lichSuGiayToDinhKem the lich su giay to dinh kem
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLichSuGiayToDinhKem(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLichSuGiayToDinhKem(lichSuGiayToDinhKem);
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

	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem fetchLichSuGiayToDinhKem(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLichSuGiayToDinhKem(id);
	}

	/**
	* Returns the lich su giay to dinh kem with the primary key.
	*
	* @param id the primary key of the lich su giay to dinh kem
	* @return the lich su giay to dinh kem
	* @throws PortalException if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem getLichSuGiayToDinhKem(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLichSuGiayToDinhKem(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lich su giay to dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @return the range of lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> getLichSuGiayToDinhKems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLichSuGiayToDinhKems(start, end);
	}

	/**
	* Returns the number of lich su giay to dinh kems.
	*
	* @return the number of lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int getLichSuGiayToDinhKemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLichSuGiayToDinhKemsCount();
	}

	/**
	* Updates the lich su giay to dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lichSuGiayToDinhKem the lich su giay to dinh kem
	* @return the lich su giay to dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem updateLichSuGiayToDinhKem(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLichSuGiayToDinhKem(lichSuGiayToDinhKem);
	}

	/**
	* Updates the lich su giay to dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lichSuGiayToDinhKem the lich su giay to dinh kem
	* @param merge whether to merge the lich su giay to dinh kem with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lich su giay to dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem updateLichSuGiayToDinhKem(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLichSuGiayToDinhKem(lichSuGiayToDinhKem, merge);
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
	* This is fucntion getGiayToDKHSId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long hosoId
	* @return List<LichSuGiayToDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> getGiayToDKHSId(
		java.lang.Long hosoId) {
		return getService().getGiayToDKHSId(hosoId);
	}

	/**
	* This is fucntion getNoiLuuTruId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long noiLuuTruId
	* @return List<LichSuGiayToDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> getNoiLuuTruId(
		java.lang.Long noiLuuTruId) {
		return getService().getNoiLuuTruId(noiLuuTruId);
	}

	/**
	* This is fucntion add
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param LichSuGiayToDinhKem model
	* @return LichSuGiayToDinhKem
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem add(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem model) {
		return getService().add(model);
	}

	public static void clearService() {
		_service = null;
	}

	public static LichSuGiayToDinhKemLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LichSuGiayToDinhKemLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LichSuGiayToDinhKemLocalService.class.getName(),
					portletClassLoader);

			_service = new LichSuGiayToDinhKemLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LichSuGiayToDinhKemLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LichSuGiayToDinhKemLocalService.class);
		}

		return _service;
	}

	public void setService(LichSuGiayToDinhKemLocalService service) {
		MethodCache.remove(LichSuGiayToDinhKemLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LichSuGiayToDinhKemLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LichSuGiayToDinhKemLocalService.class);
	}

	private static LichSuGiayToDinhKemLocalService _service;
}