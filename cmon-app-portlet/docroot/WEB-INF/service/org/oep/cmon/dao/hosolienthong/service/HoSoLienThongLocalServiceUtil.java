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

package org.oep.cmon.dao.hosolienthong.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the ho so lien thong local service. This utility wraps {@link org.oep.cmon.dao.hosolienthong.service.impl.HoSoLienThongLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hoangtrung.nguyen
 * @see HoSoLienThongLocalService
 * @see org.oep.cmon.dao.hosolienthong.service.base.HoSoLienThongLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosolienthong.service.impl.HoSoLienThongLocalServiceImpl
 * @generated
 */
public class HoSoLienThongLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosolienthong.service.impl.HoSoLienThongLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ho so lien thong to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @return the ho so lien thong that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong addHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHoSoLienThong(hoSoLienThong);
	}

	/**
	* Creates a new ho so lien thong with the primary key. Does not add the ho so lien thong to the database.
	*
	* @param id the primary key for the new ho so lien thong
	* @return the new ho so lien thong
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong createHoSoLienThong(
		long id) {
		return getService().createHoSoLienThong(id);
	}

	/**
	* Deletes the ho so lien thong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so lien thong
	* @throws PortalException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHoSoLienThong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHoSoLienThong(id);
	}

	/**
	* Deletes the ho so lien thong from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHoSoLienThong(hoSoLienThong);
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

	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchHoSoLienThong(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHoSoLienThong(id);
	}

	/**
	* Returns the ho so lien thong with the primary key.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong
	* @throws PortalException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong getHoSoLienThong(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoLienThong(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ho so lien thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @return the range of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> getHoSoLienThongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoLienThongs(start, end);
	}

	/**
	* Returns the number of ho so lien thongs.
	*
	* @return the number of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static int getHoSoLienThongsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoLienThongsCount();
	}

	/**
	* Updates the ho so lien thong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @return the ho so lien thong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoSoLienThong(hoSoLienThong);
	}

	/**
	* Updates the ho so lien thong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @param merge whether to merge the ho so lien thong with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so lien thong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoSoLienThong(hoSoLienThong, merge);
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
	* This is fucntion countByMaSoBienNhanLucGui
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoBienNhanLucGui
	* @return int
	*/
	public static int countByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* This is fucntion fetchByMaSoBienNhanLucGui
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoBienNhanLucGui
	* @return HoSoLienThong
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* This is fucntion countByHoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId
	* @return int
	*/
	public static int countByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByHoSoId(hoSoId);
	}

	/**
	* This is fucntion fetchByHoSoIdAndThuTuLienThong
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId, int thuTu
	* @return HoSoLienThong
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByHoSoIdAndThuTuLienThong(
		long hoSoId, int thuTu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByHoSoIdAndThuTuLienThong(hoSoId, thuTu);
	}

	/**
	* This is fucntion findByHoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId
	* @return List<HoSoLienThong>
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoId(hoSoId);
	}

	/**
	* This is fucntion searchHoSoNoiNhan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param PortletRequest request, CongChuc canBoNoiNhan, long[] thuTucNhanIds
	* @return QueryResult<HoSoLienThong>
	*/
	public static org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiNhan(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiNhan, long[] thuTucNhanIds) {
		return getService()
				   .searchHoSoNoiNhan(request, canBoNoiNhan, thuTucNhanIds);
	}

	/**
	* This is fucntion searchHoSoNoiGui
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param PortletRequest request, CongChuc canBoNoiGui, long[] thuTucGuiIds
	* @return QueryResult<HoSoLienThong>
	*/
	public static org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiGui(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiGui, long[] thuTucGuiIds) {
		return getService().searchHoSoNoiGui(request, canBoNoiGui, thuTucGuiIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static HoSoLienThongLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HoSoLienThongLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HoSoLienThongLocalService.class.getName(),
					portletClassLoader);

			_service = new HoSoLienThongLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HoSoLienThongLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HoSoLienThongLocalService.class);
		}

		return _service;
	}

	public void setService(HoSoLienThongLocalService service) {
		MethodCache.remove(HoSoLienThongLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HoSoLienThongLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HoSoLienThongLocalService.class);
	}

	private static HoSoLienThongLocalService _service;
}