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
 * The utility for the tai nguyen2 vai tro local service. This utility wraps {@link org.oep.cmon.dao.nsd.service.impl.TaiNguyen2VaiTroLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see TaiNguyen2VaiTroLocalService
 * @see org.oep.cmon.dao.nsd.service.base.TaiNguyen2VaiTroLocalServiceBaseImpl
 * @see org.oep.cmon.dao.nsd.service.impl.TaiNguyen2VaiTroLocalServiceImpl
 * @generated
 */
public class TaiNguyen2VaiTroLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.nsd.service.impl.TaiNguyen2VaiTroLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tai nguyen2 vai tro to the database. Also notifies the appropriate model listeners.
	*
	* @param taiNguyen2VaiTro the tai nguyen2 vai tro
	* @return the tai nguyen2 vai tro that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro addTaiNguyen2VaiTro(
		org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro taiNguyen2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTaiNguyen2VaiTro(taiNguyen2VaiTro);
	}

	/**
	* Creates a new tai nguyen2 vai tro with the primary key. Does not add the tai nguyen2 vai tro to the database.
	*
	* @param id the primary key for the new tai nguyen2 vai tro
	* @return the new tai nguyen2 vai tro
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro createTaiNguyen2VaiTro(
		long id) {
		return getService().createTaiNguyen2VaiTro(id);
	}

	/**
	* Deletes the tai nguyen2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai nguyen2 vai tro
	* @throws PortalException if a tai nguyen2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTaiNguyen2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTaiNguyen2VaiTro(id);
	}

	/**
	* Deletes the tai nguyen2 vai tro from the database. Also notifies the appropriate model listeners.
	*
	* @param taiNguyen2VaiTro the tai nguyen2 vai tro
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTaiNguyen2VaiTro(
		org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro taiNguyen2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTaiNguyen2VaiTro(taiNguyen2VaiTro);
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

	public static org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro fetchTaiNguyen2VaiTro(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTaiNguyen2VaiTro(id);
	}

	/**
	* Returns the tai nguyen2 vai tro with the primary key.
	*
	* @param id the primary key of the tai nguyen2 vai tro
	* @return the tai nguyen2 vai tro
	* @throws PortalException if a tai nguyen2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro getTaiNguyen2VaiTro(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiNguyen2VaiTro(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tai nguyen2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai nguyen2 vai tros
	* @param end the upper bound of the range of tai nguyen2 vai tros (not inclusive)
	* @return the range of tai nguyen2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro> getTaiNguyen2VaiTros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiNguyen2VaiTros(start, end);
	}

	/**
	* Returns the number of tai nguyen2 vai tros.
	*
	* @return the number of tai nguyen2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int getTaiNguyen2VaiTrosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiNguyen2VaiTrosCount();
	}

	/**
	* Updates the tai nguyen2 vai tro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiNguyen2VaiTro the tai nguyen2 vai tro
	* @return the tai nguyen2 vai tro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro updateTaiNguyen2VaiTro(
		org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro taiNguyen2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaiNguyen2VaiTro(taiNguyen2VaiTro);
	}

	/**
	* Updates the tai nguyen2 vai tro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiNguyen2VaiTro the tai nguyen2 vai tro
	* @param merge whether to merge the tai nguyen2 vai tro with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tai nguyen2 vai tro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro updateTaiNguyen2VaiTro(
		org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro taiNguyen2VaiTro,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaiNguyen2VaiTro(taiNguyen2VaiTro, merge);
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
	* This is fucntion findByVaiTroID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long vaiTroId, int daXoa
	* @return List<TaiNguyen2VaiTro>
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro> findByVaiTroID(
		java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException {
		return getService().findByVaiTroID(vaiTroId, daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static TaiNguyen2VaiTroLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TaiNguyen2VaiTroLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TaiNguyen2VaiTroLocalService.class.getName(),
					portletClassLoader);

			_service = new TaiNguyen2VaiTroLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TaiNguyen2VaiTroLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TaiNguyen2VaiTroLocalService.class);
		}

		return _service;
	}

	public void setService(TaiNguyen2VaiTroLocalService service) {
		MethodCache.remove(TaiNguyen2VaiTroLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TaiNguyen2VaiTroLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TaiNguyen2VaiTroLocalService.class);
	}

	private static TaiNguyen2VaiTroLocalService _service;
}