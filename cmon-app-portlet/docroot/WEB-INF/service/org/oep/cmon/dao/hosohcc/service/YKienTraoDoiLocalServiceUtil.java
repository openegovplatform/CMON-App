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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the y kien trao doi local service. This utility wraps {@link org.oep.cmon.dao.hosohcc.service.impl.YKienTraoDoiLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see YKienTraoDoiLocalService
 * @see org.oep.cmon.dao.hosohcc.service.base.YKienTraoDoiLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.YKienTraoDoiLocalServiceImpl
 * @generated
 */
public class YKienTraoDoiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.YKienTraoDoiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the y kien trao doi to the database. Also notifies the appropriate model listeners.
	*
	* @param yKienTraoDoi the y kien trao doi
	* @return the y kien trao doi that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi addYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addYKienTraoDoi(yKienTraoDoi);
	}

	/**
	* Creates a new y kien trao doi with the primary key. Does not add the y kien trao doi to the database.
	*
	* @param id the primary key for the new y kien trao doi
	* @return the new y kien trao doi
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi createYKienTraoDoi(
		long id) {
		return getService().createYKienTraoDoi(id);
	}

	/**
	* Deletes the y kien trao doi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the y kien trao doi
	* @throws PortalException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteYKienTraoDoi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteYKienTraoDoi(id);
	}

	/**
	* Deletes the y kien trao doi from the database. Also notifies the appropriate model listeners.
	*
	* @param yKienTraoDoi the y kien trao doi
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteYKienTraoDoi(yKienTraoDoi);
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

	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi fetchYKienTraoDoi(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchYKienTraoDoi(id);
	}

	/**
	* Returns the y kien trao doi with the primary key.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi
	* @throws PortalException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi getYKienTraoDoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKienTraoDoi(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the y kien trao dois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> getYKienTraoDois(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKienTraoDois(start, end);
	}

	/**
	* Returns the number of y kien trao dois.
	*
	* @return the number of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static int getYKienTraoDoisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKienTraoDoisCount();
	}

	/**
	* Updates the y kien trao doi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param yKienTraoDoi the y kien trao doi
	* @return the y kien trao doi that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYKienTraoDoi(yKienTraoDoi);
	}

	/**
	* Updates the y kien trao doi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param yKienTraoDoi the y kien trao doi
	* @param merge whether to merge the y kien trao doi with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the y kien trao doi that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYKienTraoDoi(yKienTraoDoi, merge);
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
	* This is fucntion findYKienByHoSoTTHCCongIdAndLoai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long idHoSo,long idLoai
	* @return List<YKienTraoDoi>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findYKienByHoSoTTHCCongIdAndLoai(
		long idHoSo, long idLoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findYKienByHoSoTTHCCongIdAndLoai(idHoSo, idLoai);
	}

	/**
	* This is fucntion getYkienTraoDoi
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long yKienId
	* @return List<YKienTraoDoi>
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi getYkienTraoDoi(
		long yKienId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYkienTraoDoi(yKienId);
	}

	/**
	* This is fucntion updateStatus
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long resourcePrimKey, long status
	* @return YKienTraoDoi
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateStatus(
		long resourcePrimKey, long status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatus(resourcePrimKey, status);
	}

	/**
	* This is fucntion findByHoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, int start, int end
	* @return List<YKienTraoDoi>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoTTHCCongId(hoSoTTHCCongId, start, end);
	}

	/**
	* This is fucntion findByHoSoTTHCCongIdAndLoai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId,long loai
	* @return List<YKienTraoDoi>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByHoSoTTHCCongIdAndLoai(
		long hoSoTTHCCongId, long loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoTTHCCongIdAndLoai(hoSoTTHCCongId, loai);
	}

	/**
	* This is fucntion countByHoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return int
	*/
	public static int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* This is fucntion addYkien_Traodoi
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param YKienTraoDoi newYKienTraoDoi
	* @return YKienTraoDoi
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi addYkien_Traodoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi newYKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addYkien_Traodoi(newYKienTraoDoi);
	}

	/**
	* This is fucntion updateYkien_Traodoi
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param YKienTraoDoi
	* @return List<YKienTraoDoi>
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateYkien_Traodoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi newYKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYkien_Traodoi(newYKienTraoDoi);
	}

	/**
	* This is fucntion listYKienTraoDoi
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long tkNguoiDungId, String tieuDe, int start, int end
	* @return List<YKienTraoDoi>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoi(
		long hoSoTTHCCongId, long tkNguoiDungId, java.lang.String tieuDe,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .listYKienTraoDoi(hoSoTTHCCongId, tkNguoiDungId, tieuDe,
			start, end);
	}

	/**
	* This is fucntion listCanBoTiepNhan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId, int start, int end
	* @return List<CongChuc>
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCanBoTiepNhan(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().listCanBoTiepNhan(coQuanQuanLyId, start, end);
	}

	/**
	* This is fucntion listYKienTraoDoiAndLoai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long tkNguoiDungId, String loai, String tieuDe, int start, int end
	* @return List<YKienTraoDoi>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoiAndLoai(
		long hoSoTTHCCongId, long tkNguoiDungId, java.lang.String loai,
		java.lang.String tieuDe, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .listYKienTraoDoiAndLoai(hoSoTTHCCongId, tkNguoiDungId,
			loai, tieuDe, start, end);
	}

	/**
	* This is fucntion countYKienTraoDoiAndLoai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long tkNguoiDungId, String loai, String tieuDe
	* @return int
	*/
	public static int countYKienTraoDoiAndLoai(long hoSoTTHCCongId,
		long tkNguoiDungId, java.lang.String loai, java.lang.String tieuDe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countYKienTraoDoiAndLoai(hoSoTTHCCongId, tkNguoiDungId,
			loai, tieuDe);
	}

	/**
	* This is fucntion findByHoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<YKienTraoDoi>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	public static void clearService() {
		_service = null;
	}

	public static YKienTraoDoiLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					YKienTraoDoiLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					YKienTraoDoiLocalService.class.getName(), portletClassLoader);

			_service = new YKienTraoDoiLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(YKienTraoDoiLocalServiceUtil.class,
				"_service");
			MethodCache.remove(YKienTraoDoiLocalService.class);
		}

		return _service;
	}

	public void setService(YKienTraoDoiLocalService service) {
		MethodCache.remove(YKienTraoDoiLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(YKienTraoDoiLocalServiceUtil.class,
			"_service");
		MethodCache.remove(YKienTraoDoiLocalService.class);
	}

	private static YKienTraoDoiLocalService _service;
}