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
 * The utility for the danh muc giay to local service. This utility wraps {@link org.oep.cmon.dao.tlct.service.impl.DanhMucGiayToLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see DanhMucGiayToLocalService
 * @see org.oep.cmon.dao.tlct.service.base.DanhMucGiayToLocalServiceBaseImpl
 * @see org.oep.cmon.dao.tlct.service.impl.DanhMucGiayToLocalServiceImpl
 * @generated
 */
public class DanhMucGiayToLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.tlct.service.impl.DanhMucGiayToLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the danh muc giay to to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @return the danh muc giay to that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo addDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDanhMucGiayTo(danhMucGiayTo);
	}

	/**
	* Creates a new danh muc giay to with the primary key. Does not add the danh muc giay to to the database.
	*
	* @param id the primary key for the new danh muc giay to
	* @return the new danh muc giay to
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo createDanhMucGiayTo(
		long id) {
		return getService().createDanhMucGiayTo(id);
	}

	/**
	* Deletes the danh muc giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to
	* @throws PortalException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucGiayTo(id);
	}

	/**
	* Deletes the danh muc giay to from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDanhMucGiayTo(danhMucGiayTo);
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

	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchDanhMucGiayTo(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDanhMucGiayTo(id);
	}

	/**
	* Returns the danh muc giay to with the primary key.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to
	* @throws PortalException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo getDanhMucGiayTo(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucGiayTo(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @return the range of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getDanhMucGiayTos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucGiayTos(start, end);
	}

	/**
	* Returns the number of danh muc giay tos.
	*
	* @return the number of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int getDanhMucGiayTosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhMucGiayTosCount();
	}

	/**
	* Updates the danh muc giay to in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @return the danh muc giay to that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhMucGiayTo(danhMucGiayTo);
	}

	/**
	* Updates the danh muc giay to in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @param merge whether to merge the danh muc giay to with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc giay to that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhMucGiayTo(danhMucGiayTo, merge);
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
	* This is fucntion getGiayToBoiMa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return DanhMucGiayTo
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo getGiayToBoiMa(
		java.lang.String ma) {
		return getService().getGiayToBoiMa(ma);
	}

	/**
	* This is fucntion searchDanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group, Long doiTuongId,int start, int end
	* @return List<DanhMucGiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchDanhMucGiayTo(
		java.lang.String group, java.lang.Long doiTuongId, int start, int end) {
		return getService().searchDanhMucGiayTo(group, doiTuongId, start, end);
	}

	/**
	* This is fucntion countDanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group, Long doiTuongId
	* @return long
	*/
	public static long countDanhMucGiayTo(java.lang.String group,
		java.lang.Long doiTuongId) {
		return getService().countDanhMucGiayTo(group, doiTuongId);
	}

	/**
	* This is fucntion searchByTTHCIdOrGDId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa, int start,int end
	* @return List<DanhMucGiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchByTTHCIdOrGDId(
		java.lang.String group, java.lang.String doituong,
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end) {
		return getService()
				   .searchByTTHCIdOrGDId(group, doituong, tthcid, dgId, daXoa,
			start, end);
	}

	/**
	* This is fucntion countByTTHCIdOrGDId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa
	* @return long
	*/
	public static long countByTTHCIdOrGDId(java.lang.String group,
		java.lang.String doituong, java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa) {
		return getService()
				   .countByTTHCIdOrGDId(group, doituong, tthcid, dgId, daXoa);
	}

	/**
	* This is fucntion findGiayToKetQua
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thutuchanhchinhId
	* @return List<DanhMucGiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findGiayToKetQua(
		long thutuchanhchinhId) {
		return getService().findGiayToKetQua(thutuchanhchinhId);
	}

	/**
	* This is fucntion finlistGiayToBCNopDon
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hosothutuchccId
	* @return List<DanhMucGiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> finlistGiayToBCNopDon(
		long hosothutuchccId) {
		return getService().finlistGiayToBCNopDon(hosothutuchccId);
	}

	/**
	* This is fucntion findTheoMa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return DanhMucGiayTo
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo findTheoMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getService().findTheoMa(ma);
	}

	/**
	* This is fucntion getDanhMucGiayToList
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<DanhMucGiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getDanhMucGiayToList(
		int daXoa) {
		return getService().getDanhMucGiayToList(daXoa);
	}

	/**
	* This is fucntion listByCongDan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long doiTuongId
	* @return List<DanhMucGiayTo>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listByCongDan(
		java.lang.Long doiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().listByCongDan(doiTuongId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DanhMucGiayToLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DanhMucGiayToLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DanhMucGiayToLocalService.class.getName(),
					portletClassLoader);

			_service = new DanhMucGiayToLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DanhMucGiayToLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DanhMucGiayToLocalService.class);
		}

		return _service;
	}

	public void setService(DanhMucGiayToLocalService service) {
		MethodCache.remove(DanhMucGiayToLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DanhMucGiayToLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DanhMucGiayToLocalService.class);
	}

	private static DanhMucGiayToLocalService _service;
}