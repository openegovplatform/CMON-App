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

package org.oep.cmon.dao.chungthuc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the thanh phan ho so chung thuc local service. This utility wraps {@link org.oep.cmon.dao.chungthuc.service.impl.ThanhPhanHoSoChungThucLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vietho
 * @see ThanhPhanHoSoChungThucLocalService
 * @see org.oep.cmon.dao.chungthuc.service.base.ThanhPhanHoSoChungThucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.chungthuc.service.impl.ThanhPhanHoSoChungThucLocalServiceImpl
 * @generated
 */
public class ThanhPhanHoSoChungThucLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.chungthuc.service.impl.ThanhPhanHoSoChungThucLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the thanh phan ho so chung thuc to the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc addThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc);
	}

	/**
	* Creates a new thanh phan ho so chung thuc with the primary key. Does not add the thanh phan ho so chung thuc to the database.
	*
	* @param thanhPhanHoSoId the primary key for the new thanh phan ho so chung thuc
	* @return the new thanh phan ho so chung thuc
	*/
	public static org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc createThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId) {
		return getService().createThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	/**
	* Deletes the thanh phan ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @throws PortalException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThanhPhanHoSoChungThuc(long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	/**
	* Deletes the thanh phan ho so chung thuc from the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc);
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

	public static org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc fetchThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	/**
	* Returns the thanh phan ho so chung thuc with the primary key.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc
	* @throws PortalException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc getThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the thanh phan ho so chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thanh phan ho so chung thucs
	* @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	* @return the range of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThanhPhanHoSoChungThucs(start, end);
	}

	/**
	* Returns the number of thanh phan ho so chung thucs.
	*
	* @return the number of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int getThanhPhanHoSoChungThucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThanhPhanHoSoChungThucsCount();
	}

	/**
	* Updates the thanh phan ho so chung thuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc);
	}

	/**
	* Updates the thanh phan ho so chung thuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @param merge whether to merge the thanh phan ho so chung thuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the thanh phan ho so chung thuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc, merge);
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
	* This is fucntion get ThanhPhanHoSoChungThuc by hoSoChungThucId and paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoChungThucId, int start, int end
	* @return List<ThanhPhanHoSoChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucListBy(
		long hoSoChungThucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getThanhPhanHoSoChungThucListBy(hoSoChungThucId, start, end);
	}

	/**
	* This is fucntion remove ThanhPhanHoSoChungThuc by hsctId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hsctId
	* @return void
	*/
	public static void removeThanhPhanHoSoByHSChungThucId(long hsctId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeThanhPhanHoSoByHSChungThucId(hsctId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ThanhPhanHoSoChungThucLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ThanhPhanHoSoChungThucLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ThanhPhanHoSoChungThucLocalService.class.getName(),
					portletClassLoader);

			_service = new ThanhPhanHoSoChungThucLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ThanhPhanHoSoChungThucLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ThanhPhanHoSoChungThucLocalService.class);
		}

		return _service;
	}

	public void setService(ThanhPhanHoSoChungThucLocalService service) {
		MethodCache.remove(ThanhPhanHoSoChungThucLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ThanhPhanHoSoChungThucLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ThanhPhanHoSoChungThucLocalService.class);
	}

	private static ThanhPhanHoSoChungThucLocalService _service;
}