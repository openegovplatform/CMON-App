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
 * The utility for the doi tuong su dung local service. This utility wraps {@link org.oep.cmon.dao.dvc.service.impl.DoiTuongSuDungLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see DoiTuongSuDungLocalService
 * @see org.oep.cmon.dao.dvc.service.base.DoiTuongSuDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.DoiTuongSuDungLocalServiceImpl
 * @generated
 */
public class DoiTuongSuDungLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.DoiTuongSuDungLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the doi tuong su dung to the database. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @return the doi tuong su dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung addDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	* Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	*
	* @param id the primary key for the new doi tuong su dung
	* @return the new doi tuong su dung
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung createDoiTuongSuDung(
		long id) {
		return getService().createDoiTuongSuDung(id);
	}

	/**
	* Deletes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doi tuong su dung
	* @throws PortalException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDoiTuongSuDung(id);
	}

	/**
	* Deletes the doi tuong su dung from the database. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDoiTuongSuDung(doiTuongSuDung);
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

	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchDoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDoiTuongSuDung(id);
	}

	/**
	* Returns the doi tuong su dung with the primary key.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung
	* @throws PortalException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung getDoiTuongSuDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDoiTuongSuDung(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @return the range of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getDoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDoiTuongSuDungs(start, end);
	}

	/**
	* Returns the number of doi tuong su dungs.
	*
	* @return the number of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int getDoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDoiTuongSuDungsCount();
	}

	/**
	* Updates the doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @return the doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung updateDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	* Updates the doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @param merge whether to merge the doi tuong su dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung updateDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDoiTuongSuDung(doiTuongSuDung, merge);
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
	* This is fucntion find DoiTuongSuDung by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return DoiTuongSuDung
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMa(ma);
	}

	/**
	* This is fucntion find DoiTuongSuDung by ten
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ten
	* @return DoiTuongSuDung
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTen(ten);
	}

	/**
	* This is fucntion find DoiTuongSuDung by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<DoiTuongSuDung>
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getDSDoiTuongSuDung(
		int daXoa) {
		return getService().getDSDoiTuongSuDung(daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static DoiTuongSuDungLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DoiTuongSuDungLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DoiTuongSuDungLocalService.class.getName(),
					portletClassLoader);

			_service = new DoiTuongSuDungLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DoiTuongSuDungLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DoiTuongSuDungLocalService.class);
		}

		return _service;
	}

	public void setService(DoiTuongSuDungLocalService service) {
		MethodCache.remove(DoiTuongSuDungLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DoiTuongSuDungLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DoiTuongSuDungLocalService.class);
	}

	private static DoiTuongSuDungLocalService _service;
}