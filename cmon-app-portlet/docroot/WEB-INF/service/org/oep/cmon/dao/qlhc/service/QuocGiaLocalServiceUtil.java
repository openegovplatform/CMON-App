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
 * The utility for the quoc gia local service. This utility wraps {@link org.oep.cmon.dao.qlhc.service.impl.QuocGiaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see QuocGiaLocalService
 * @see org.oep.cmon.dao.qlhc.service.base.QuocGiaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.impl.QuocGiaLocalServiceImpl
 * @generated
 */
public class QuocGiaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.qlhc.service.impl.QuocGiaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the quoc gia to the database. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @return the quoc gia that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia addQuocGia(
		org.oep.cmon.dao.qlhc.model.QuocGia quocGia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addQuocGia(quocGia);
	}

	/**
	* Creates a new quoc gia with the primary key. Does not add the quoc gia to the database.
	*
	* @param id the primary key for the new quoc gia
	* @return the new quoc gia
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia createQuocGia(long id) {
		return getService().createQuocGia(id);
	}

	/**
	* Deletes the quoc gia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the quoc gia
	* @throws PortalException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteQuocGia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuocGia(id);
	}

	/**
	* Deletes the quoc gia from the database. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteQuocGia(
		org.oep.cmon.dao.qlhc.model.QuocGia quocGia)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuocGia(quocGia);
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

	public static org.oep.cmon.dao.qlhc.model.QuocGia fetchQuocGia(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchQuocGia(id);
	}

	/**
	* Returns the quoc gia with the primary key.
	*
	* @param id the primary key of the quoc gia
	* @return the quoc gia
	* @throws PortalException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia getQuocGia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuocGia(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the quoc gias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @return the range of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> getQuocGias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuocGias(start, end);
	}

	/**
	* Returns the number of quoc gias.
	*
	* @return the number of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static int getQuocGiasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuocGiasCount();
	}

	/**
	* Updates the quoc gia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @return the quoc gia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia updateQuocGia(
		org.oep.cmon.dao.qlhc.model.QuocGia quocGia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateQuocGia(quocGia);
	}

	/**
	* Updates the quoc gia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @param merge whether to merge the quoc gia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the quoc gia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia updateQuocGia(
		org.oep.cmon.dao.qlhc.model.QuocGia quocGia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateQuocGia(quocGia, merge);
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
	* This is fucntion findAll
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return List<QuocGia>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	/**
	* This is fucntion findByMaQuocGia
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return QuocGia
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByMaQuocGia(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getService().findByMaQuocGia(ma);
	}

	/**
	* This is fucntion findByTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ten
	* @return QuocGia
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getService().findByTen(ten);
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
	* @return List<QuocGia>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByDaXoa(
		int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getService().findByDaXoa(daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static QuocGiaLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					QuocGiaLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					QuocGiaLocalService.class.getName(), portletClassLoader);

			_service = new QuocGiaLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(QuocGiaLocalServiceUtil.class,
				"_service");
			MethodCache.remove(QuocGiaLocalService.class);
		}

		return _service;
	}

	public void setService(QuocGiaLocalService service) {
		MethodCache.remove(QuocGiaLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(QuocGiaLocalServiceUtil.class,
			"_service");
		MethodCache.remove(QuocGiaLocalService.class);
	}

	private static QuocGiaLocalService _service;
}