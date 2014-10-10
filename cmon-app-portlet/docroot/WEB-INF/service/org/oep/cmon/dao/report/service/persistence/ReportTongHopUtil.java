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

import org.oep.cmon.dao.report.model.ReportTongHop;

import java.util.List;

/**
 * The persistence utility for the report tong hop service. This utility wraps {@link ReportTongHopPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see ReportTongHopPersistence
 * @see ReportTongHopPersistenceImpl
 * @generated
 */
public class ReportTongHopUtil {
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
	public static void clearCache(ReportTongHop reportTongHop) {
		getPersistence().clearCache(reportTongHop);
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
	public static List<ReportTongHop> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReportTongHop> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReportTongHop> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ReportTongHop update(ReportTongHop reportTongHop,
		boolean merge) throws SystemException {
		return getPersistence().update(reportTongHop, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ReportTongHop update(ReportTongHop reportTongHop,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(reportTongHop, merge, serviceContext);
	}

	/**
	* Caches the report tong hop in the entity cache if it is enabled.
	*
	* @param reportTongHop the report tong hop
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.ReportTongHop reportTongHop) {
		getPersistence().cacheResult(reportTongHop);
	}

	/**
	* Caches the report tong hops in the entity cache if it is enabled.
	*
	* @param reportTongHops the report tong hops
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> reportTongHops) {
		getPersistence().cacheResult(reportTongHops);
	}

	/**
	* Creates a new report tong hop with the primary key. Does not add the report tong hop to the database.
	*
	* @param reportTongHopPK the primary key for the new report tong hop
	* @return the new report tong hop
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHop create(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK) {
		return getPersistence().create(reportTongHopPK);
	}

	/**
	* Removes the report tong hop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopPK the primary key of the report tong hop
	* @return the report tong hop that was removed
	* @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHop remove(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchReportTongHopException {
		return getPersistence().remove(reportTongHopPK);
	}

	public static org.oep.cmon.dao.report.model.ReportTongHop updateImpl(
		org.oep.cmon.dao.report.model.ReportTongHop reportTongHop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(reportTongHop, merge);
	}

	/**
	* Returns the report tong hop with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchReportTongHopException} if it could not be found.
	*
	* @param reportTongHopPK the primary key of the report tong hop
	* @return the report tong hop
	* @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHop findByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchReportTongHopException {
		return getPersistence().findByPrimaryKey(reportTongHopPK);
	}

	/**
	* Returns the report tong hop with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportTongHopPK the primary key of the report tong hop
	* @return the report tong hop, or <code>null</code> if a report tong hop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.ReportTongHop fetchByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reportTongHopPK);
	}

	/**
	* Returns all the report tong hops.
	*
	* @return the report tong hops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the report tong hops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of report tong hops
	* @param end the upper bound of the range of report tong hops (not inclusive)
	* @return the range of report tong hops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the report tong hops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of report tong hops
	* @param end the upper bound of the range of report tong hops (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of report tong hops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the report tong hops from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of report tong hops.
	*
	* @return the number of report tong hops
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReportTongHopPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReportTongHopPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					ReportTongHopPersistence.class.getName());

			ReferenceRegistry.registerReference(ReportTongHopUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ReportTongHopPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ReportTongHopUtil.class,
			"_persistence");
	}

	private static ReportTongHopPersistence _persistence;
}