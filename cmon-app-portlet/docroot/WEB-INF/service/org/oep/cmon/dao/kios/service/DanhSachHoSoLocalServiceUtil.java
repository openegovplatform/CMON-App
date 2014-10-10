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

package org.oep.cmon.dao.kios.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the danh sach ho so local service. This utility wraps {@link org.oep.cmon.dao.kios.service.impl.DanhSachHoSoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see DanhSachHoSoLocalService
 * @see org.oep.cmon.dao.kios.service.base.DanhSachHoSoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.kios.service.impl.DanhSachHoSoLocalServiceImpl
 * @generated
 */
public class DanhSachHoSoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.kios.service.impl.DanhSachHoSoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the danh sach ho so to the database. Also notifies the appropriate model listeners.
	*
	* @param danhSachHoSo the danh sach ho so
	* @return the danh sach ho so that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo addDanhSachHoSo(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDanhSachHoSo(danhSachHoSo);
	}

	/**
	* Creates a new danh sach ho so with the primary key. Does not add the danh sach ho so to the database.
	*
	* @param id the primary key for the new danh sach ho so
	* @return the new danh sach ho so
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo createDanhSachHoSo(
		long id) {
		return getService().createDanhSachHoSo(id);
	}

	/**
	* Deletes the danh sach ho so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh sach ho so
	* @throws PortalException if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhSachHoSo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhSachHoSo(id);
	}

	/**
	* Deletes the danh sach ho so from the database. Also notifies the appropriate model listeners.
	*
	* @param danhSachHoSo the danh sach ho so
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhSachHoSo(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhSachHoSo(danhSachHoSo);
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

	public static org.oep.cmon.dao.kios.model.DanhSachHoSo fetchDanhSachHoSo(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDanhSachHoSo(id);
	}

	/**
	* Returns the danh sach ho so with the primary key.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so
	* @throws PortalException if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo getDanhSachHoSo(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhSachHoSo(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh sach ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach ho sos
	* @param end the upper bound of the range of danh sach ho sos (not inclusive)
	* @return the range of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> getDanhSachHoSos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhSachHoSos(start, end);
	}

	/**
	* Returns the number of danh sach ho sos.
	*
	* @return the number of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static int getDanhSachHoSosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhSachHoSosCount();
	}

	/**
	* Updates the danh sach ho so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhSachHoSo the danh sach ho so
	* @return the danh sach ho so that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo updateDanhSachHoSo(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhSachHoSo(danhSachHoSo);
	}

	/**
	* Updates the danh sach ho so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhSachHoSo the danh sach ho so
	* @param merge whether to merge the danh sach ho so with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh sach ho so that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo updateDanhSachHoSo(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhSachHoSo(danhSachHoSo, merge);
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
	* This is fucntion getListHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String id_coquan, int start,    int end
	* @return List<DanhSachHoSo>
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> getListHoSo(
		java.lang.String id_coquan, int start, int end)
		throws java.lang.Exception {
		return getService().getListHoSo(id_coquan, start, end);
	}

	/**
	* This is fucntion getListCoQuan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String arrayCapCoQuanId
	* @return List<DanhSachCoQuan>
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> getListCoQuan(
		java.lang.String arrayCapCoQuanId) throws java.lang.Exception {
		return getService().getListCoQuan(arrayCapCoQuanId);
	}

	/**
	* This is fucntion getListReportThongKeGroupByIDCoQuan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String arrCapCoQuanid, String arrThang, String nam
	* @return List<DanhSachThongKe>
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> getListReportThongKeGroupByIDCoQuan(
		java.lang.String arrCapCoQuanid, java.lang.String arrThang,
		java.lang.String nam) throws java.lang.Exception {
		return getService()
				   .getListReportThongKeGroupByIDCoQuan(arrCapCoQuanid,
			arrThang, nam);
	}

	public static void clearService() {
		_service = null;
	}

	public static DanhSachHoSoLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DanhSachHoSoLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DanhSachHoSoLocalService.class.getName(), portletClassLoader);

			_service = new DanhSachHoSoLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DanhSachHoSoLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DanhSachHoSoLocalService.class);
		}

		return _service;
	}

	public void setService(DanhSachHoSoLocalService service) {
		MethodCache.remove(DanhSachHoSoLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DanhSachHoSoLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DanhSachHoSoLocalService.class);
	}

	private static DanhSachHoSoLocalService _service;
}