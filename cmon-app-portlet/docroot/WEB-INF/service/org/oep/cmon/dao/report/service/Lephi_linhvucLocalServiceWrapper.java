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
 * This class is a wrapper for {@link Lephi_linhvucLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       Lephi_linhvucLocalService
 * @generated
 */
public class Lephi_linhvucLocalServiceWrapper
	implements Lephi_linhvucLocalService,
		ServiceWrapper<Lephi_linhvucLocalService> {
	public Lephi_linhvucLocalServiceWrapper(
		Lephi_linhvucLocalService lephi_linhvucLocalService) {
		_lephi_linhvucLocalService = lephi_linhvucLocalService;
	}

	/**
	* Adds the lephi_linhvuc to the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @return the lephi_linhvuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc addLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.addLephi_linhvuc(lephi_linhvuc);
	}

	/**
	* Creates a new lephi_linhvuc with the primary key. Does not add the lephi_linhvuc to the database.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key for the new lephi_linhvuc
	* @return the new lephi_linhvuc
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc createLephi_linhvuc(
		int NHOMTHUTUCHANHCHINHID) {
		return _lephi_linhvucLocalService.createLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Deletes the lephi_linhvuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @throws PortalException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLephi_linhvuc(int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lephi_linhvucLocalService.deleteLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Deletes the lephi_linhvuc from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lephi_linhvucLocalService.deleteLephi_linhvuc(lephi_linhvuc);
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
		return _lephi_linhvucLocalService.dynamicQuery(dynamicQuery);
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
		return _lephi_linhvucLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _lephi_linhvucLocalService.dynamicQuery(dynamicQuery, start,
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
		return _lephi_linhvucLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.Lephi_linhvuc fetchLephi_linhvuc(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.fetchLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the lephi_linhvuc with the primary key.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc
	* @throws PortalException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc getLephi_linhvuc(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.getLephi_linhvuc(NHOMTHUTUCHANHCHINHID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lephi_linhvucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_linhvucs
	* @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	* @return the range of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> getLephi_linhvucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.getLephi_linhvucs(start, end);
	}

	/**
	* Returns the number of lephi_linhvucs.
	*
	* @return the number of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public int getLephi_linhvucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.getLephi_linhvucsCount();
	}

	/**
	* Updates the lephi_linhvuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @return the lephi_linhvuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc updateLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.updateLephi_linhvuc(lephi_linhvuc);
	}

	/**
	* Updates the lephi_linhvuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	* @param merge whether to merge the lephi_linhvuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lephi_linhvuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc updateLephi_linhvuc(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lephi_linhvucLocalService.updateLephi_linhvuc(lephi_linhvuc,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lephi_linhvucLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lephi_linhvucLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion lephilinhvuc
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String id_linhvuc,String ngaynhan_tungay, String ngaynhan_denngay
	* @return List<Lephi_linhvuc>
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> lephilinhvuc(
		java.lang.String id_linhvuc, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return _lephi_linhvucLocalService.lephilinhvuc(id_linhvuc,
			ngaynhan_tungay, ngaynhan_denngay);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Lephi_linhvucLocalService getWrappedLephi_linhvucLocalService() {
		return _lephi_linhvucLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLephi_linhvucLocalService(
		Lephi_linhvucLocalService lephi_linhvucLocalService) {
		_lephi_linhvucLocalService = lephi_linhvucLocalService;
	}

	public Lephi_linhvucLocalService getWrappedService() {
		return _lephi_linhvucLocalService;
	}

	public void setWrappedService(
		Lephi_linhvucLocalService lephi_linhvucLocalService) {
		_lephi_linhvucLocalService = lephi_linhvucLocalService;
	}

	private Lephi_linhvucLocalService _lephi_linhvucLocalService;
}