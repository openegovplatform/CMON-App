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

package org.oep.cmon.dao.report.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.report.model.ReportTongHopChiTiet;

import java.util.List;

/**
 * The persistence utility for the report tong hop chi tiet service. This utility wraps {@link ReportTongHopChiTietPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see ReportTongHopChiTietPersistence
 * @see ReportTongHopChiTietPersistenceImpl
 * @generated
 */
public class ReportTongHopChiTietUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ReportTongHopChiTiet reportTongHopChiTiet) {
		getPersistence().clearCache(reportTongHopChiTiet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ReportTongHopChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReportTongHopChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReportTongHopChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ReportTongHopChiTiet update(
		ReportTongHopChiTiet reportTongHopChiTiet, boolean merge)
		throws SystemException {
		return getPersistence().update(reportTongHopChiTiet, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ReportTongHopChiTiet update(
		ReportTongHopChiTiet reportTongHopChiTiet, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(reportTongHopChiTiet, merge, serviceContext);
	}

	/**
	* Caches the report tong hop chi tiet in the entity cache if it is enabled.
	*
	* @param reportTongHopChiTiet the report tong hop chi tiet
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet) {
		getPersistence().cacheResult(reportTongHopChiTiet);
	}

	/**
	* Caches the report tong hop chi tiets in the entity cache if it is enabled.
	*
	* @param reportTongHopChiTiets the report tong hop chi tiets
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> reportTongHopChiTiets) {
		getPersistence().cacheResult(reportTongHopChiTiets);
	}

	/**
	* Creates a new report tong hop chi tiet with the primary key. Does not add the report tong hop chi tiet to the database.
	*
	* @param reportTongHopChiTietPK the primary key for the new report tong hop chi tiet
	* @return the new report tong hop chi tiet
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHopChiTiet create(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK) {
		return getPersistence().create(reportTongHopChiTietPK);
	}

	/**
	* Removes the report tong hop chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	* @return the report tong hop chi tiet that was removed
	* @throws org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException if a report tong hop chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHopChiTiet remove(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException {
		return getPersistence().remove(reportTongHopChiTietPK);
	}

	public static org.oep.cmon.dao.report.model.ReportTongHopChiTiet updateImpl(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(reportTongHopChiTiet, merge);
	}

	/**
	* Returns the report tong hop chi tiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException} if it could not be found.
	*
	* @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	* @return the report tong hop chi tiet
	* @throws org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException if a report tong hop chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHopChiTiet findByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException {
		return getPersistence().findByPrimaryKey(reportTongHopChiTietPK);
	}

	/**
	* Returns the report tong hop chi tiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	* @return the report tong hop chi tiet, or <code>null</code> if a report tong hop chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHopChiTiet fetchByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reportTongHopChiTietPK);
	}

	/**
	* Returns all the report tong hop chi tiets.
	*
	* @return the report tong hop chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the report tong hop chi tiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of report tong hop chi tiets
	* @param end the upper bound of the range of report tong hop chi tiets (not inclusive)
	* @return the range of report tong hop chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the report tong hop chi tiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of report tong hop chi tiets
	* @param end the upper bound of the range of report tong hop chi tiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of report tong hop chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the report tong hop chi tiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of report tong hop chi tiets.
	*
	* @return the number of report tong hop chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReportTongHopChiTietPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReportTongHopChiTietPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					ReportTongHopChiTietPersistence.class.getName());

			ReferenceRegistry.registerReference(ReportTongHopChiTietUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ReportTongHopChiTietPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ReportTongHopChiTietUtil.class,
			"_persistence");
	}

	private static ReportTongHopChiTietPersistence _persistence;
}