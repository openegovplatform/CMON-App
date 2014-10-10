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

package org.oep.cmon.dao.qlhc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the don vi hanh chinh local service. This utility wraps {@link org.oep.cmon.dao.qlhc.service.impl.DonViHanhChinhLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see DonViHanhChinhLocalService
 * @see org.oep.cmon.dao.qlhc.service.base.DonViHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.impl.DonViHanhChinhLocalServiceImpl
 * @generated
 */
public class DonViHanhChinhLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.qlhc.service.impl.DonViHanhChinhLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the don vi hanh chinh to the database. Also notifies the appropriate model listeners.
	*
	* @param donViHanhChinh the don vi hanh chinh
	* @return the don vi hanh chinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh addDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDonViHanhChinh(donViHanhChinh);
	}

	/**
	* Creates a new don vi hanh chinh with the primary key. Does not add the don vi hanh chinh to the database.
	*
	* @param id the primary key for the new don vi hanh chinh
	* @return the new don vi hanh chinh
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh createDonViHanhChinh(
		long id) {
		return getService().createDonViHanhChinh(id);
	}

	/**
	* Deletes the don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi hanh chinh
	* @throws PortalException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDonViHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDonViHanhChinh(id);
	}

	/**
	* Deletes the don vi hanh chinh from the database. Also notifies the appropriate model listeners.
	*
	* @param donViHanhChinh the don vi hanh chinh
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDonViHanhChinh(donViHanhChinh);
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

	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchDonViHanhChinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDonViHanhChinh(id);
	}

	/**
	* Returns the don vi hanh chinh with the primary key.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh
	* @throws PortalException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh getDonViHanhChinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDonViHanhChinh(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDonViHanhChinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDonViHanhChinhs(start, end);
	}

	/**
	* Returns the number of don vi hanh chinhs.
	*
	* @return the number of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int getDonViHanhChinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDonViHanhChinhsCount();
	}

	/**
	* Updates the don vi hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donViHanhChinh the don vi hanh chinh
	* @return the don vi hanh chinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh updateDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDonViHanhChinh(donViHanhChinh);
	}

	/**
	* Updates the don vi hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donViHanhChinh the don vi hanh chinh
	* @param merge whether to merge the don vi hanh chinh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the don vi hanh chinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh updateDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDonViHanhChinh(donViHanhChinh, merge);
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
	* This is fucntion findByChaId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long chaId,int daXoa
	* @return List<DonViHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		long chaId, int daXoa) {
		return getService().findByChaId(chaId, daXoa);
	}

	/**
	* This is fucntion findByQuocGiaId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long quocGiaId, long capDonViHanhChinhId, int daXoa
	* @return List<DonViHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa) {
		return getService()
				   .findByQuocGiaId(quocGiaId, capDonViHanhChinhId, daXoa);
	}

	/**
	* This is fucntion findByDaXoa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<DonViHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByDaXoa(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDaXoa(daXoa);
	}

	/**
	* This is fucntion findByMaDVHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return DonViHanhChinh
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMaDVHC(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getService().findByMaDVHC(ma);
	}

	/**
	* This is fucntion findByTenDVHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ten
	* @return DonViHanhChinh
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTenDVHC(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getService().findByTenDVHC(ten);
	}

	/**
	* This is fucntion getDanhSachTinhThanh
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<DonViHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDanhSachTinhThanh() {
		return getService().getDanhSachTinhThanh();
	}

	/**
	* This is fucntion getDSDonViHanhChinhTheoCapId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long capId,int daXoa
	* @return List<DonViHanhChinh>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDSDonViHanhChinhTheoCapId(
		java.lang.Long capId, int daXoa) {
		return getService().getDSDonViHanhChinhTheoCapId(capId, daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static DonViHanhChinhLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DonViHanhChinhLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DonViHanhChinhLocalService.class.getName(),
					portletClassLoader);

			_service = new DonViHanhChinhLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DonViHanhChinhLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DonViHanhChinhLocalService.class);
		}

		return _service;
	}

	public void setService(DonViHanhChinhLocalService service) {
		MethodCache.remove(DonViHanhChinhLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DonViHanhChinhLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DonViHanhChinhLocalService.class);
	}

	private static DonViHanhChinhLocalService _service;
}