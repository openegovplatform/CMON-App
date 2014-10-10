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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the tai khoan nguoi dung local service. This utility wraps {@link org.oep.cmon.dao.nsd.service.impl.TaiKhoanNguoiDungLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see TaiKhoanNguoiDungLocalService
 * @see org.oep.cmon.dao.nsd.service.base.TaiKhoanNguoiDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.nsd.service.impl.TaiKhoanNguoiDungLocalServiceImpl
 * @generated
 */
public class TaiKhoanNguoiDungLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.nsd.service.impl.TaiKhoanNguoiDungLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tai khoan nguoi dung to the database. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung addTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTaiKhoanNguoiDung(taiKhoanNguoiDung);
	}

	/**
	* Creates a new tai khoan nguoi dung with the primary key. Does not add the tai khoan nguoi dung to the database.
	*
	* @param id the primary key for the new tai khoan nguoi dung
	* @return the new tai khoan nguoi dung
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung createTaiKhoanNguoiDung(
		long id) {
		return getService().createTaiKhoanNguoiDung(id);
	}

	/**
	* Deletes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @throws PortalException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTaiKhoanNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTaiKhoanNguoiDung(id);
	}

	/**
	* Deletes the tai khoan nguoi dung from the database. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTaiKhoanNguoiDung(taiKhoanNguoiDung);
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

	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchTaiKhoanNguoiDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTaiKhoanNguoiDung(id);
	}

	/**
	* Returns the tai khoan nguoi dung with the primary key.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung
	* @throws PortalException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung getTaiKhoanNguoiDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiKhoanNguoiDung(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> getTaiKhoanNguoiDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiKhoanNguoiDungs(start, end);
	}

	/**
	* Returns the number of tai khoan nguoi dungs.
	*
	* @return the number of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int getTaiKhoanNguoiDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiKhoanNguoiDungsCount();
	}

	/**
	* Updates the tai khoan nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaiKhoanNguoiDung(taiKhoanNguoiDung);
	}

	/**
	* Updates the tai khoan nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @param merge whether to merge the tai khoan nguoi dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tai khoan nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaiKhoanNguoiDung(taiKhoanNguoiDung, merge);
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
	* This is fucntion findByTenDangNhap
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String tenDangNhap
	* @return TaiKhoanNguoiDung
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenDangNhap(
		java.lang.String tenDangNhap) {
		return getService().findByTenDangNhap(tenDangNhap);
	}

	/**
	* This is fucntion findByTaiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long taiKhoanNguoiDungId
	* @return TaiKhoanNguoiDung
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDungId(
		long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getService().findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* This is fucntion findByEmail
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String email
	* @return List<TaiKhoanNguoiDung>
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email) {
		return getService().findByEmail(email);
	}

	/**
	* This is fucntion fetchByLiferayUserId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long liferayUserId
	* @return TaiKhoanNguoiDung
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByLiferayUserId(
		long liferayUserId) {
		return getService().fetchByLiferayUserId(liferayUserId);
	}

	/**
	* This is fucntion findByTaiKhoanNguoiDung
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long taiKhoanId,int daXoa
	* @return List<TaiKhoanNguoiDung>
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanId, int daXoa) {
		return getService().findByTaiKhoanNguoiDung(taiKhoanId, daXoa);
	}

	/**
	* This is fucntion v
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String keyWord, String option
	* @return List<TaiKhoanNguoiDung>
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDungPopup(
		java.lang.String keyWord, java.lang.String option) {
		return getService().findTaiKhoanNguoiDungPopup(keyWord, option);
	}

	/**
	* This is fucntion findTaiKhoanNguoiDung
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String keyWord, String option
	* @return List<TaiKhoanNguoiDung>
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDung(
		java.lang.String keyWord, java.lang.String option) {
		return getService().findTaiKhoanNguoiDung(keyWord, option);
	}

	public static void clearService() {
		_service = null;
	}

	public static TaiKhoanNguoiDungLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TaiKhoanNguoiDungLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TaiKhoanNguoiDungLocalService.class.getName(),
					portletClassLoader);

			_service = new TaiKhoanNguoiDungLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TaiKhoanNguoiDungLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TaiKhoanNguoiDungLocalService.class);
		}

		return _service;
	}

	public void setService(TaiKhoanNguoiDungLocalService service) {
		MethodCache.remove(TaiKhoanNguoiDungLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TaiKhoanNguoiDungLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TaiKhoanNguoiDungLocalService.class);
	}

	private static TaiKhoanNguoiDungLocalService _service;
}