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
 * The utility for the t t h c2 doi tuong su dung local service. This utility wraps {@link org.oep.cmon.dao.dvc.service.impl.TTHC2DoiTuongSuDungLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see TTHC2DoiTuongSuDungLocalService
 * @see org.oep.cmon.dao.dvc.service.base.TTHC2DoiTuongSuDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.TTHC2DoiTuongSuDungLocalServiceImpl
 * @generated
 */
public class TTHC2DoiTuongSuDungLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.TTHC2DoiTuongSuDungLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the t t h c2 doi tuong su dung to the database. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung addTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung);
	}

	/**
	* Creates a new t t h c2 doi tuong su dung with the primary key. Does not add the t t h c2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new t t h c2 doi tuong su dung
	* @return the new t t h c2 doi tuong su dung
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung createTTHC2DoiTuongSuDung(
		long id) {
		return getService().createTTHC2DoiTuongSuDung(id);
	}

	/**
	* Deletes the t t h c2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @throws PortalException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTTHC2DoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTTHC2DoiTuongSuDung(id);
	}

	/**
	* Deletes the t t h c2 doi tuong su dung from the database. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung);
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

	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung fetchTTHC2DoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTTHC2DoiTuongSuDung(id);
	}

	/**
	* Returns the t t h c2 doi tuong su dung with the primary key.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung
	* @throws PortalException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung getTTHC2DoiTuongSuDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHC2DoiTuongSuDung(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> getTTHC2DoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHC2DoiTuongSuDungs(start, end);
	}

	/**
	* Returns the number of t t h c2 doi tuong su dungs.
	*
	* @return the number of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int getTTHC2DoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHC2DoiTuongSuDungsCount();
	}

	/**
	* Updates the t t h c2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung updateTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung);
	}

	/**
	* Updates the t t h c2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @param merge whether to merge the t t h c2 doi tuong su dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the t t h c2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung updateTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung, merge);
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
	* This is fucntion get TTHC2DoiTuongSuDung by tthcId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long tthcId
	* @return List<TTHC2DoiTuongSuDung>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> getDSTTHC2DoiTuongSuDungBoiTTHC(
		java.lang.Long tthcId) {
		return getService().getDSTTHC2DoiTuongSuDungBoiTTHC(tthcId);
	}

	/**
	* This is fucntion count ThuTucHanhChinh by thutucId, doiTuongSuDungId,trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long thutucId,Long doiTuongSuDungId,int daXoa
	* @return long
	*/
	public static long countTTHCTheoDoiTuongSuDung(java.lang.Long thutucId,
		java.lang.Long doiTuongSuDungId, int daXoa) {
		return getService()
				   .countTTHCTheoDoiTuongSuDung(thutucId, doiTuongSuDungId,
			daXoa);
	}

	/**
	* This is fucntion find TTHC2DoiTuongSuDung by thuTucHanhChinhId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucHanhChinhId
	* @return List<TTHC2DoiTuongSuDung>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TTHC2DoiTuongSuDungLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TTHC2DoiTuongSuDungLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TTHC2DoiTuongSuDungLocalService.class.getName(),
					portletClassLoader);

			_service = new TTHC2DoiTuongSuDungLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TTHC2DoiTuongSuDungLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TTHC2DoiTuongSuDungLocalService.class);
		}

		return _service;
	}

	public void setService(TTHC2DoiTuongSuDungLocalService service) {
		MethodCache.remove(TTHC2DoiTuongSuDungLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TTHC2DoiTuongSuDungLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TTHC2DoiTuongSuDungLocalService.class);
	}

	private static TTHC2DoiTuongSuDungLocalService _service;
}