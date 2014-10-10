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
 * This class is a wrapper for {@link ReportTongHopChiTietLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       ReportTongHopChiTietLocalService
 * @generated
 */
public class ReportTongHopChiTietLocalServiceWrapper
	implements ReportTongHopChiTietLocalService,
		ServiceWrapper<ReportTongHopChiTietLocalService> {
	public ReportTongHopChiTietLocalServiceWrapper(
		ReportTongHopChiTietLocalService reportTongHopChiTietLocalService) {
		_reportTongHopChiTietLocalService = reportTongHopChiTietLocalService;
	}

	/**
	* Adds the report tong hop chi tiet to the database. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopChiTiet the report tong hop chi tiet
	* @return the report tong hop chi tiet that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet addReportTongHopChiTiet(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.addReportTongHopChiTiet(reportTongHopChiTiet);
	}

	/**
	* Creates a new report tong hop chi tiet with the primary key. Does not add the report tong hop chi tiet to the database.
	*
	* @param reportTongHopChiTietPK the primary key for the new report tong hop chi tiet
	* @return the new report tong hop chi tiet
	*/
	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet createReportTongHopChiTiet(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK) {
		return _reportTongHopChiTietLocalService.createReportTongHopChiTiet(reportTongHopChiTietPK);
	}

	/**
	* Deletes the report tong hop chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	* @throws PortalException if a report tong hop chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteReportTongHopChiTiet(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_reportTongHopChiTietLocalService.deleteReportTongHopChiTiet(reportTongHopChiTietPK);
	}

	/**
	* Deletes the report tong hop chi tiet from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopChiTiet the report tong hop chi tiet
	* @throws SystemException if a system exception occurred
	*/
	public void deleteReportTongHopChiTiet(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportTongHopChiTietLocalService.deleteReportTongHopChiTiet(reportTongHopChiTiet);
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
		return _reportTongHopChiTietLocalService.dynamicQuery(dynamicQuery);
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
		return _reportTongHopChiTietLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _reportTongHopChiTietLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _reportTongHopChiTietLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet fetchReportTongHopChiTiet(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.fetchReportTongHopChiTiet(reportTongHopChiTietPK);
	}

	/**
	* Returns the report tong hop chi tiet with the primary key.
	*
	* @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	* @return the report tong hop chi tiet
	* @throws PortalException if a report tong hop chi tiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet getReportTongHopChiTiet(
		org.oep.cmon.dao.report.service.persistence.ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.getReportTongHopChiTiet(reportTongHopChiTietPK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> getReportTongHopChiTiets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.getReportTongHopChiTiets(start,
			end);
	}

	/**
	* Returns the number of report tong hop chi tiets.
	*
	* @return the number of report tong hop chi tiets
	* @throws SystemException if a system exception occurred
	*/
	public int getReportTongHopChiTietsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.getReportTongHopChiTietsCount();
	}

	/**
	* Updates the report tong hop chi tiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopChiTiet the report tong hop chi tiet
	* @return the report tong hop chi tiet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet updateReportTongHopChiTiet(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.updateReportTongHopChiTiet(reportTongHopChiTiet);
	}

	/**
	* Updates the report tong hop chi tiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reportTongHopChiTiet the report tong hop chi tiet
	* @param merge whether to merge the report tong hop chi tiet with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the report tong hop chi tiet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.ReportTongHopChiTiet updateReportTongHopChiTiet(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportTongHopChiTietLocalService.updateReportTongHopChiTiet(reportTongHopChiTiet,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _reportTongHopChiTietLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reportTongHopChiTietLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion getListReportTongHopChiTietGroupByIDThuTuc
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String IDDonVi,String arrIDThuTuc,String arrThang,String nam
	* @return List<ReportTongHopChiTiet>
	*/
	public java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> getListReportTongHopChiTietGroupByIDThuTuc(
		java.lang.String IDDonVi, java.lang.String arrIDThuTuc,
		java.lang.String arrThang, java.lang.String nam)
		throws java.lang.Exception {
		return _reportTongHopChiTietLocalService.getListReportTongHopChiTietGroupByIDThuTuc(IDDonVi,
			arrIDThuTuc, arrThang, nam);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ReportTongHopChiTietLocalService getWrappedReportTongHopChiTietLocalService() {
		return _reportTongHopChiTietLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedReportTongHopChiTietLocalService(
		ReportTongHopChiTietLocalService reportTongHopChiTietLocalService) {
		_reportTongHopChiTietLocalService = reportTongHopChiTietLocalService;
	}

	public ReportTongHopChiTietLocalService getWrappedService() {
		return _reportTongHopChiTietLocalService;
	}

	public void setWrappedService(
		ReportTongHopChiTietLocalService reportTongHopChiTietLocalService) {
		_reportTongHopChiTietLocalService = reportTongHopChiTietLocalService;
	}

	private ReportTongHopChiTietLocalService _reportTongHopChiTietLocalService;
}