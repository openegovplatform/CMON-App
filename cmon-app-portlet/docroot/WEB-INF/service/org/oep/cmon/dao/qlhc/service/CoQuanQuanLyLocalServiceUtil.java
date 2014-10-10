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
 * The utility for the co quan quan ly local service. This utility wraps {@link org.oep.cmon.dao.qlhc.service.impl.CoQuanQuanLyLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see CoQuanQuanLyLocalService
 * @see org.oep.cmon.dao.qlhc.service.base.CoQuanQuanLyLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.impl.CoQuanQuanLyLocalServiceImpl
 * @generated
 */
public class CoQuanQuanLyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.qlhc.service.impl.CoQuanQuanLyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the co quan quan ly to the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @return the co quan quan ly that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy addCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCoQuanQuanLy(coQuanQuanLy);
	}

	/**
	* Creates a new co quan quan ly with the primary key. Does not add the co quan quan ly to the database.
	*
	* @param id the primary key for the new co quan quan ly
	* @return the new co quan quan ly
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy createCoQuanQuanLy(
		long id) {
		return getService().createCoQuanQuanLy(id);
	}

	/**
	* Deletes the co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan quan ly
	* @throws PortalException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCoQuanQuanLy(id);
	}

	/**
	* Deletes the co quan quan ly from the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCoQuanQuanLy(coQuanQuanLy);
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

	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy fetchCoQuanQuanLy(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCoQuanQuanLy(id);
	}

	/**
	* Returns the co quan quan ly with the primary key.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly
	* @throws PortalException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy getCoQuanQuanLy(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoQuanQuanLy(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoQuanQuanLies(start, end);
	}

	/**
	* Returns the number of co quan quan lies.
	*
	* @return the number of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int getCoQuanQuanLiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoQuanQuanLiesCount();
	}

	/**
	* Updates the co quan quan ly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @return the co quan quan ly that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCoQuanQuanLy(coQuanQuanLy);
	}

	/**
	* Updates the co quan quan ly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @param merge whether to merge the co quan quan ly with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the co quan quan ly that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCoQuanQuanLy(coQuanQuanLy, merge);
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
	* This is fucntion findByMa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getService().findByMa(ma);
	}

	/**
	* This is fucntion getDSPhongBanNoiBo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long chaId
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSPhongBanNoiBo(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDSPhongBanNoiBo(chaId);
	}

	/**
	* This is fucntion findByParentId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long chaId, int daXoa
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByParentId(
		java.lang.Long chaId, int daXoa) {
		return getService().findByParentId(chaId, daXoa);
	}

	/**
	* This is fucntion findByCapCoQuanQuanLyId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long capCoQuanQuanlyId,int daXoa
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLyId(
		java.lang.Long capCoQuanQuanlyId, int daXoa) {
		return getService().findByCapCoQuanQuanLyId(capCoQuanQuanlyId, daXoa);
	}

	/**
	* This is fucntion getDSCoQuanQuanlyByMaOrTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maOrTen,int start, int end
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSCoQuanQuanlyByMaOrTen(
		java.lang.String maOrTen, int start, int end) {
		return getService().getDSCoQuanQuanlyByMaOrTen(maOrTen, start, end);
	}

	/**
	* This is fucntion countDSCoQuanQuanlyByMaOrTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maOrTen
	* @return int
	*/
	public static int countDSCoQuanQuanlyByMaOrTen(java.lang.String maOrTen) {
		return getService().countDSCoQuanQuanlyByMaOrTen(maOrTen);
	}

	/**
	* This is fucntion findByAllDonViHanhChinhId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long donviHanhChinhId,int typeSelect, int daXoa
	* @return List<CoQuanQuanLy>
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByAllDonViHanhChinhId(
		java.lang.Long donviHanhChinhId, int typeSelect, int daXoa) {
		return getService()
				   .findByAllDonViHanhChinhId(donviHanhChinhId, typeSelect,
			daXoa);
	}

	public static void clearService() {
		_service = null;
	}

	public static CoQuanQuanLyLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CoQuanQuanLyLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CoQuanQuanLyLocalService.class.getName(), portletClassLoader);

			_service = new CoQuanQuanLyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CoQuanQuanLyLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CoQuanQuanLyLocalService.class);
		}

		return _service;
	}

	public void setService(CoQuanQuanLyLocalService service) {
		MethodCache.remove(CoQuanQuanLyLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CoQuanQuanLyLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CoQuanQuanLyLocalService.class);
	}

	private static CoQuanQuanLyLocalService _service;
}