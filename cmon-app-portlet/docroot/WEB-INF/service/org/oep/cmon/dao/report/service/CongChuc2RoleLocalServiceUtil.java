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
 * The utility for the cong chuc2 role local service. This utility wraps {@link org.oep.cmon.dao.report.service.impl.CongChuc2RoleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author VIENPN
 * @see CongChuc2RoleLocalService
 * @see org.oep.cmon.dao.report.service.base.CongChuc2RoleLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.impl.CongChuc2RoleLocalServiceImpl
 * @generated
 */
public class CongChuc2RoleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.report.service.impl.CongChuc2RoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cong chuc2 role to the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @return the cong chuc2 role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role addCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCongChuc2Role(congChuc2Role);
	}

	/**
	* Creates a new cong chuc2 role with the primary key. Does not add the cong chuc2 role to the database.
	*
	* @param ID the primary key for the new cong chuc2 role
	* @return the new cong chuc2 role
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role createCongChuc2Role(
		long ID) {
		return getService().createCongChuc2Role(ID);
	}

	/**
	* Deletes the cong chuc2 role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the cong chuc2 role
	* @throws PortalException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCongChuc2Role(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCongChuc2Role(ID);
	}

	/**
	* Deletes the cong chuc2 role from the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCongChuc2Role(congChuc2Role);
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

	public static org.oep.cmon.dao.report.model.CongChuc2Role fetchCongChuc2Role(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCongChuc2Role(ID);
	}

	/**
	* Returns the cong chuc2 role with the primary key.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role
	* @throws PortalException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role getCongChuc2Role(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCongChuc2Role(ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cong chuc2 roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 roles
	* @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	* @return the range of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> getCongChuc2Roles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCongChuc2Roles(start, end);
	}

	/**
	* Returns the number of cong chuc2 roles.
	*
	* @return the number of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getCongChuc2RolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCongChuc2RolesCount();
	}

	/**
	* Updates the cong chuc2 role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @return the cong chuc2 role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role updateCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCongChuc2Role(congChuc2Role);
	}

	/**
	* Updates the cong chuc2 role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @param merge whether to merge the cong chuc2 role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong chuc2 role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role updateCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCongChuc2Role(congChuc2Role, merge);
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
	* This is fucntion getDanhsachbaocao
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id
	* @return List<DanhMucBaoCao>
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> getDanhsachbaocao(
		long user_id) throws java.lang.Exception {
		return getService().getDanhsachbaocao(user_id);
	}

	/**
	* This is fucntion getCoQuanQuanLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id,long baocao_id
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLy(
		long user_id, long baocao_id) throws java.lang.Exception {
		return getService().getCoQuanQuanLy(user_id, baocao_id);
	}

	/**
	* This is fucntion getNhomTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id,long baocao_id,long donvi_id
	* @return List<NhomThuTucHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> getNhomTTHC(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception {
		return getService().getNhomTTHC(user_id, baocao_id, donvi_id);
	}

	/**
	* This is fucntion testReportPermission
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id,long baocao_id
	* @return Boolean
	*/
	public static java.lang.Boolean testReportPermission(long user_id,
		long baocao_id) throws java.lang.Exception {
		return getService().testReportPermission(user_id, baocao_id);
	}

	/**
	* This is fucntion find ChucVu by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return List<ChucVu>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThutuchanhchinh(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception {
		return getService().getThutuchanhchinh(user_id, baocao_id, donvi_id);
	}

	public static void clearService() {
		_service = null;
	}

	public static CongChuc2RoleLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CongChuc2RoleLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CongChuc2RoleLocalService.class.getName(),
					portletClassLoader);

			_service = new CongChuc2RoleLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CongChuc2RoleLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CongChuc2RoleLocalService.class);
		}

		return _service;
	}

	public void setService(CongChuc2RoleLocalService service) {
		MethodCache.remove(CongChuc2RoleLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CongChuc2RoleLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CongChuc2RoleLocalService.class);
	}

	private static CongChuc2RoleLocalService _service;
}