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

package org.oep.cmon.dao.ttthanhtoan.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the thong tin thanh toan local service. This utility wraps {@link org.oep.cmon.dao.ttthanhtoan.service.impl.ThongTinThanhToanLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Thanhdd
 * @see ThongTinThanhToanLocalService
 * @see org.oep.cmon.dao.ttthanhtoan.service.base.ThongTinThanhToanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.ttthanhtoan.service.impl.ThongTinThanhToanLocalServiceImpl
 * @generated
 */
public class ThongTinThanhToanLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.ttthanhtoan.service.impl.ThongTinThanhToanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the thong tin thanh toan to the database. Also notifies the appropriate model listeners.
	*
	* @param thongTinThanhToan the thong tin thanh toan
	* @return the thong tin thanh toan that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan addThongTinThanhToan(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThongTinThanhToan(thongTinThanhToan);
	}

	/**
	* Creates a new thong tin thanh toan with the primary key. Does not add the thong tin thanh toan to the database.
	*
	* @param id the primary key for the new thong tin thanh toan
	* @return the new thong tin thanh toan
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan createThongTinThanhToan(
		long id) {
		return getService().createThongTinThanhToan(id);
	}

	/**
	* Deletes the thong tin thanh toan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thong tin thanh toan
	* @throws PortalException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThongTinThanhToan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThongTinThanhToan(id);
	}

	/**
	* Deletes the thong tin thanh toan from the database. Also notifies the appropriate model listeners.
	*
	* @param thongTinThanhToan the thong tin thanh toan
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThongTinThanhToan(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThongTinThanhToan(thongTinThanhToan);
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

	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan fetchThongTinThanhToan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchThongTinThanhToan(id);
	}

	/**
	* Returns the thong tin thanh toan with the primary key.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan
	* @throws PortalException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan getThongTinThanhToan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThongTinThanhToan(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the thong tin thanh toans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @return the range of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> getThongTinThanhToans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThongTinThanhToans(start, end);
	}

	/**
	* Returns the number of thong tin thanh toans.
	*
	* @return the number of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static int getThongTinThanhToansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThongTinThanhToansCount();
	}

	/**
	* Updates the thong tin thanh toan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thongTinThanhToan the thong tin thanh toan
	* @return the thong tin thanh toan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan updateThongTinThanhToan(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThongTinThanhToan(thongTinThanhToan);
	}

	/**
	* Updates the thong tin thanh toan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thongTinThanhToan the thong tin thanh toan
	* @param merge whether to merge the thong tin thanh toan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the thong tin thanh toan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan updateThongTinThanhToan(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThongTinThanhToan(thongTinThanhToan, merge);
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
	* This is fucntion findByHoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId
	* @return List<ThongTinThanhToan>
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoId(
		long hoSoId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoId(hoSoId);
	}

	/**
	* This is fucntion searchByCoQuanQuanLyHoSo_QT
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId, String searchProfileCode, int loaiPhi, int start, int end
	* @return List<ThongTinThanhToan>
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> searchByCoQuanQuanLyHoSo_QT(
		long coQuanQuanLyId, java.lang.String searchProfileCode, int loaiPhi,
		int start, int end) {
		return getService()
				   .searchByCoQuanQuanLyHoSo_QT(coQuanQuanLyId,
			searchProfileCode, loaiPhi, start, end);
	}

	/**
	* This is fucntion countByCoQuanQuanLyHoSo_QT
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId, String searchProfileCode, int loaiPhi
	* @return int
	*/
	public static int countByCoQuanQuanLyHoSo_QT(long coQuanQuanLyId,
		java.lang.String searchProfileCode, int loaiPhi) {
		return getService()
				   .countByCoQuanQuanLyHoSo_QT(coQuanQuanLyId,
			searchProfileCode, loaiPhi);
	}

	public static void clearService() {
		_service = null;
	}

	public static ThongTinThanhToanLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ThongTinThanhToanLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ThongTinThanhToanLocalService.class.getName(),
					portletClassLoader);

			_service = new ThongTinThanhToanLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ThongTinThanhToanLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ThongTinThanhToanLocalService.class);
		}

		return _service;
	}

	public void setService(ThongTinThanhToanLocalService service) {
		MethodCache.remove(ThongTinThanhToanLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ThongTinThanhToanLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ThongTinThanhToanLocalService.class);
	}

	private static ThongTinThanhToanLocalService _service;
}