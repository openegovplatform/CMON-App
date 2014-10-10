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
 * The utility for the danh muc giay to2 doi tuong su dung local service. This utility wraps {@link org.oep.cmon.dao.dvc.service.impl.DanhMucGiayTo2DoiTuongSuDungLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see DanhMucGiayTo2DoiTuongSuDungLocalService
 * @see org.oep.cmon.dao.dvc.service.base.DanhMucGiayTo2DoiTuongSuDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.DanhMucGiayTo2DoiTuongSuDungLocalServiceImpl
 * @generated
 */
public class DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.DanhMucGiayTo2DoiTuongSuDungLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the danh muc giay to2 doi tuong su dung to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung addDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung);
	}

	/**
	* Creates a new danh muc giay to2 doi tuong su dung with the primary key. Does not add the danh muc giay to2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new danh muc giay to2 doi tuong su dung
	* @return the new danh muc giay to2 doi tuong su dung
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung createDanhMucGiayTo2DoiTuongSuDung(
		long id) {
		return getService().createDanhMucGiayTo2DoiTuongSuDung(id);
	}

	/**
	* Deletes the danh muc giay to2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @throws PortalException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucGiayTo2DoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucGiayTo2DoiTuongSuDung(id);
	}

	/**
	* Deletes the danh muc giay to2 doi tuong su dung from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung);
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

	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung fetchDanhMucGiayTo2DoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDanhMucGiayTo2DoiTuongSuDung(id);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dung with the primary key.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung
	* @throws PortalException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung getDanhMucGiayTo2DoiTuongSuDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucGiayTo2DoiTuongSuDung(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc giay to2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @return the range of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getDanhMucGiayTo2DoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucGiayTo2DoiTuongSuDungs(start, end);
	}

	/**
	* Returns the number of danh muc giay to2 doi tuong su dungs.
	*
	* @return the number of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int getDanhMucGiayTo2DoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucGiayTo2DoiTuongSuDungsCount();
	}

	/**
	* Updates the danh muc giay to2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung);
	}

	/**
	* Updates the danh muc giay to2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @param merge whether to merge the danh muc giay to2 doi tuong su dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc giay to2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung,
			merge);
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
	* This is fucntion get DanhMucGiayTo2DoiTuongSuDung by loaiGiayToId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long loaiGiayToId
	* @return List<DanhMucGiayTo2DoiTuongSuDung>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiGT_DSDMGT2DTSD(
		java.lang.Long loaiGiayToId) {
		return getService().getTheoLoaiGT_DSDMGT2DTSD(loaiGiayToId);
	}

	/**
	* This is fucntion get DanhMucGiayTo2DoiTuongSuDung by loaiDoiTuongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long loaiDoiTuongId
	* @return List<DanhMucGiayTo2DoiTuongSuDung>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiDT_DSDMGT2DTSD(
		java.lang.Long loaiDoiTuongId) {
		return getService().getTheoLoaiDT_DSDMGT2DTSD(loaiDoiTuongId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DanhMucGiayTo2DoiTuongSuDungLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DanhMucGiayTo2DoiTuongSuDungLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DanhMucGiayTo2DoiTuongSuDungLocalService.class.getName(),
					portletClassLoader);

			_service = new DanhMucGiayTo2DoiTuongSuDungLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DanhMucGiayTo2DoiTuongSuDungLocalService.class);
		}

		return _service;
	}

	public void setService(DanhMucGiayTo2DoiTuongSuDungLocalService service) {
		MethodCache.remove(DanhMucGiayTo2DoiTuongSuDungLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DanhMucGiayTo2DoiTuongSuDungLocalService.class);
	}

	private static DanhMucGiayTo2DoiTuongSuDungLocalService _service;
}