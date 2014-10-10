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

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.report.model.ReportTongHop;

/**
 * The persistence interface for the report tong hop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see ReportTongHopPersistenceImpl
 * @see ReportTongHopUtil
 * @generated
 */
public interface ReportTongHopPersistence extends BasePersistence<ReportTongHop> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportTongHopUtil} to access the report tong hop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the report tong hop in the entity cache if it is enabled.
	*
	* @param reportTongHop the report tong hop
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.ReportTongHop reportTongHop);

	/**
	* Caches the report tong hops in the entity cache if it is enabled.
	*
	* @param reportTongHops the report tong hops
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> reportTongHops);

	/**
	* Creates a new report tong hop with the primary key. Does not add the report tong hop to the database.
	*
	* @param reportTongHopPK the primary key for the new report tong hop
	* @return the new report tong hop
	*/
	public org.oep.cmon.dao.report.model.ReportTongHop create(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK);

	/**
	* Removes the report tong hop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopPK the primary key of the report tong hop
	* @return the report tong hop that was removed
	* @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHop remove(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchReportTongHopException;

	public org.oep.cmon.dao.report.model.ReportTongHop updateImpl(
		org.oep.cmon.dao.report.model.ReportTongHop reportTongHop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report tong hop with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchReportTongHopException} if it could not be found.
	*
	* @param reportTongHopPK the primary key of the report tong hop
	* @return the report tong hop
	* @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHop findByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchReportTongHopException;

	/**
	* Returns the report tong hop with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportTongHopPK the primary key of the report tong hop
	* @return the report tong hop, or <code>null</code> if a report tong hop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHop fetchByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopPK reportTongHopPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the report tong hops.
	*
	* @return the report tong hops
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the report tong hops from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report tong hops.
	*
	* @return the number of report tong hops
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}