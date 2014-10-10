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

package org.oep.cmon.dao.thamso.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the tham so local service. This utility wraps {@link org.oep.cmon.dao.thamso.service.impl.ThamSoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see ThamSoLocalService
 * @see org.oep.cmon.dao.thamso.service.base.ThamSoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.thamso.service.impl.ThamSoLocalServiceImpl
 * @generated
 */
public class ThamSoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.thamso.service.impl.ThamSoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tham so to the database. Also notifies the appropriate model listeners.
	*
	* @param thamSo the tham so
	* @return the tham so that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo addThamSo(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThamSo(thamSo);
	}

	/**
	* Creates a new tham so with the primary key. Does not add the tham so to the database.
	*
	* @param Id the primary key for the new tham so
	* @return the new tham so
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo createThamSo(long Id) {
		return getService().createThamSo(Id);
	}

	/**
	* Deletes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the tham so
	* @throws PortalException if a tham so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThamSo(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThamSo(Id);
	}

	/**
	* Deletes the tham so from the database. Also notifies the appropriate model listeners.
	*
	* @param thamSo the tham so
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThamSo(org.oep.cmon.dao.thamso.model.ThamSo thamSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThamSo(thamSo);
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

	public static org.oep.cmon.dao.thamso.model.ThamSo fetchThamSo(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchThamSo(Id);
	}

	/**
	* Returns the tham so with the primary key.
	*
	* @param Id the primary key of the tham so
	* @return the tham so
	* @throws PortalException if a tham so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo getThamSo(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThamSo(Id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tham sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tham sos
	* @param end the upper bound of the range of tham sos (not inclusive)
	* @return the range of tham sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> getThamSos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThamSos(start, end);
	}

	/**
	* Returns the number of tham sos.
	*
	* @return the number of tham sos
	* @throws SystemException if a system exception occurred
	*/
	public static int getThamSosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThamSosCount();
	}

	/**
	* Updates the tham so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thamSo the tham so
	* @return the tham so that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo updateThamSo(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThamSo(thamSo);
	}

	/**
	* Updates the tham so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thamSo the tham so
	* @param merge whether to merge the tham so with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tham so that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo updateThamSo(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThamSo(thamSo, merge);
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
	* This is fucntion getValue
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String tenThamSo
	* @return String
	*/
	public static java.lang.String getValue(java.lang.String tenThamSo) {
		return getService().getValue(tenThamSo);
	}

	/**
	* This is fucntion getValues
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param List<String> listTenThamSo
	* @return List<String>
	*/
	public static java.util.List<java.lang.String> getValues(
		java.util.List<java.lang.String> listTenThamSo) {
		return getService().getValues(listTenThamSo);
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
	* @return ThamSo
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException {
		return getService().findByTen(ten);
	}

	/**
	* This is fucntion add
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param ThamSo thamSo
	* @return ThamSo
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo add(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo) {
		return getService().add(thamSo);
	}

	/**
	* This is fucntion searchByTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ten,int start,int end
	* @return List<ThamSo>
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTen(
		java.lang.String ten, int start, int end) {
		return getService().searchByTen(ten, start, end);
	}

	/**
	* This is fucntion countByDaXoa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ten
	* @return long
	*/
	public static long countByDaXoa(java.lang.String ten) {
		return getService().countByDaXoa(ten);
	}

	/**
	* This is fucntion searchByTenUDHT
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ten, Long ungDungId, Long heThongId, int start,int end
	* @return List<ThamSo>
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTenUDHT(
		java.lang.String ten, java.lang.Long ungDungId,
		java.lang.Long heThongId, int start, int end) {
		return getService()
				   .searchByTenUDHT(ten, ungDungId, heThongId, start, end);
	}

	/**
	* This is fucntion countByTenUDHT
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ten,  Long ungDungId, Long heThongId
	* @return long
	*/
	public static long countByTenUDHT(java.lang.String ten,
		java.lang.Long ungDungId, java.lang.Long heThongId) {
		return getService().countByTenUDHT(ten, ungDungId, heThongId);
	}

	/**
	* This is fucntion getAll
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<ThamSo>
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> getAll() {
		return getService().getAll();
	}

	/**
	* This is fucntion getThamSoByGiaTri
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String giaTri
	* @return ThamSo
	*/
	public static org.oep.cmon.dao.thamso.model.ThamSo getThamSoByGiaTri(
		java.lang.String giaTri) {
		return getService().getThamSoByGiaTri(giaTri);
	}

	public static void clearService() {
		_service = null;
	}

	public static ThamSoLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ThamSoLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ThamSoLocalService.class.getName(), portletClassLoader);

			_service = new ThamSoLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ThamSoLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ThamSoLocalService.class);
		}

		return _service;
	}

	public void setService(ThamSoLocalService service) {
		MethodCache.remove(ThamSoLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ThamSoLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ThamSoLocalService.class);
	}

	private static ThamSoLocalService _service;
}