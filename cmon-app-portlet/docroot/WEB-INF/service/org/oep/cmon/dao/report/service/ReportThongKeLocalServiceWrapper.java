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

package org.oep.cmon.dao.report.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ReportThongKeLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       ReportThongKeLocalService
 * @generated
 */
public class ReportThongKeLocalServiceWrapper
	implements ReportThongKeLocalService,
		ServiceWrapper<ReportThongKeLocalService> {
	public ReportThongKeLocalServiceWrapper(
		ReportThongKeLocalService reportThongKeLocalService) {
		_reportThongKeLocalService = reportThongKeLocalService;
	}

	/**
	* Adds the report thong ke to the database. Also notifies the appropriate model listeners.
	*
	* @param reportThongKe the report thong ke
	* @return the report thong ke that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportThongKe addReportThongKe(
		org.oep.cmon.dao.report.model.ReportThongKe reportThongKe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.addReportThongKe(reportThongKe);
	}

	/**
	* Creates a new report thong ke with the primary key. Does not add the report thong ke to the database.
	*
	* @param reportThongKePK the primary key for the new report thong ke
	* @return the new report thong ke
	*/
	public org.oep.cmon.dao.report.model.ReportThongKe createReportThongKe(
		org.oep.cmon.dao.report.service.persistence.ReportThongKePK reportThongKePK) {
		return _reportThongKeLocalService.createReportThongKe(reportThongKePK);
	}

	/**
	* Deletes the report thong ke with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportThongKePK the primary key of the report thong ke
	* @throws PortalException if a report thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteReportThongKe(
		org.oep.cmon.dao.report.service.persistence.ReportThongKePK reportThongKePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_reportThongKeLocalService.deleteReportThongKe(reportThongKePK);
	}

	/**
	* Deletes the report thong ke from the database. Also notifies the appropriate model listeners.
	*
	* @param reportThongKe the report thong ke
	* @throws SystemException if a system exception occurred
	*/
	public void deleteReportThongKe(
		org.oep.cmon.dao.report.model.ReportThongKe reportThongKe)
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportThongKeLocalService.deleteReportThongKe(reportThongKe);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.ReportThongKe fetchReportThongKe(
		org.oep.cmon.dao.report.service.persistence.ReportThongKePK reportThongKePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.fetchReportThongKe(reportThongKePK);
	}

	/**
	* Returns the report thong ke with the primary key.
	*
	* @param reportThongKePK the primary key of the report thong ke
	* @return the report thong ke
	* @throws PortalException if a report thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportThongKe getReportThongKe(
		org.oep.cmon.dao.report.service.persistence.ReportThongKePK reportThongKePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.getReportThongKe(reportThongKePK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the report thong kes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of report thong kes
	* @param end the upper bound of the range of report thong kes (not inclusive)
	* @return the range of report thong kes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.ReportThongKe> getReportThongKes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.getReportThongKes(start, end);
	}

	/**
	* Returns the number of report thong kes.
	*
	* @return the number of report thong kes
	* @throws SystemException if a system exception occurred
	*/
	public int getReportThongKesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.getReportThongKesCount();
	}

	/**
	* Updates the report thong ke in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reportThongKe the report thong ke
	* @return the report thong ke that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportThongKe updateReportThongKe(
		org.oep.cmon.dao.report.model.ReportThongKe reportThongKe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.updateReportThongKe(reportThongKe);
	}

	/**
	* Updates the report thong ke in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reportThongKe the report thong ke
	* @param merge whether to merge the report thong ke with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the report thong ke that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportThongKe updateReportThongKe(
		org.oep.cmon.dao.report.model.ReportThongKe reportThongKe, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportThongKeLocalService.updateReportThongKe(reportThongKe,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _reportThongKeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reportThongKeLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion getListReportThongKeGroupByIDCoQuan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String IDDonViQuanLy,String arrThang,String nam
	* @return List<ReportThongKe>
	*/
	public java.util.List<org.oep.cmon.dao.report.model.ReportThongKe> getListReportThongKeGroupByIDCoQuan(
		java.lang.String IDDonViQuanLy, java.lang.String arrThang,
		java.lang.String nam) throws java.lang.Exception {
		return _reportThongKeLocalService.getListReportThongKeGroupByIDCoQuan(IDDonViQuanLy,
			arrThang, nam);
	}

	/**
	* This is fucntion reportScheduler
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return void
	*/
	public void reportScheduler() {
		_reportThongKeLocalService.reportScheduler();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ReportThongKeLocalService getWrappedReportThongKeLocalService() {
		return _reportThongKeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedReportThongKeLocalService(
		ReportThongKeLocalService reportThongKeLocalService) {
		_reportThongKeLocalService = reportThongKeLocalService;
	}

	public ReportThongKeLocalService getWrappedService() {
		return _reportThongKeLocalService;
	}

	public void setWrappedService(
		ReportThongKeLocalService reportThongKeLocalService) {
		_reportThongKeLocalService = reportThongKeLocalService;
	}

	private ReportThongKeLocalService _reportThongKeLocalService;
}