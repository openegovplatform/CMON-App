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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TTHC2DoiTuongSuDungLocalService}.
 * </p>
 *
 * @author    liemnn
 * @see       TTHC2DoiTuongSuDungLocalService
 * @generated
 */
public class TTHC2DoiTuongSuDungLocalServiceWrapper
	implements TTHC2DoiTuongSuDungLocalService,
		ServiceWrapper<TTHC2DoiTuongSuDungLocalService> {
	public TTHC2DoiTuongSuDungLocalServiceWrapper(
		TTHC2DoiTuongSuDungLocalService tthc2DoiTuongSuDungLocalService) {
		_tthc2DoiTuongSuDungLocalService = tthc2DoiTuongSuDungLocalService;
	}

	/**
	* Adds the t t h c2 doi tuong su dung to the database. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung addTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.addTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung);
	}

	/**
	* Creates a new t t h c2 doi tuong su dung with the primary key. Does not add the t t h c2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new t t h c2 doi tuong su dung
	* @return the new t t h c2 doi tuong su dung
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung createTTHC2DoiTuongSuDung(
		long id) {
		return _tthc2DoiTuongSuDungLocalService.createTTHC2DoiTuongSuDung(id);
	}

	/**
	* Deletes the t t h c2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @throws PortalException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTTHC2DoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tthc2DoiTuongSuDungLocalService.deleteTTHC2DoiTuongSuDung(id);
	}

	/**
	* Deletes the t t h c2 doi tuong su dung from the database. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tthc2DoiTuongSuDungLocalService.deleteTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung);
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
		return _tthc2DoiTuongSuDungLocalService.dynamicQuery(dynamicQuery);
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
		return _tthc2DoiTuongSuDungLocalService.dynamicQuery(dynamicQuery,
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
		return _tthc2DoiTuongSuDungLocalService.dynamicQuery(dynamicQuery,
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
		return _tthc2DoiTuongSuDungLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung fetchTTHC2DoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.fetchTTHC2DoiTuongSuDung(id);
	}

	/**
	* Returns the t t h c2 doi tuong su dung with the primary key.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung
	* @throws PortalException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung getTTHC2DoiTuongSuDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.getTTHC2DoiTuongSuDung(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> getTTHC2DoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.getTTHC2DoiTuongSuDungs(start,
			end);
	}

	/**
	* Returns the number of t t h c2 doi tuong su dungs.
	*
	* @return the number of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int getTTHC2DoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.getTTHC2DoiTuongSuDungsCount();
	}

	/**
	* Updates the t t h c2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung updateTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.updateTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung);
	}

	/**
	* Updates the t t h c2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	* @param merge whether to merge the t t h c2 doi tuong su dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the t t h c2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung updateTTHC2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.updateTTHC2DoiTuongSuDung(tthc2DoiTuongSuDung,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc2DoiTuongSuDungLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc2DoiTuongSuDungLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion get TTHC2DoiTuongSuDung by tthcId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long tthcId
	* @return List<TTHC2DoiTuongSuDung>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> getDSTTHC2DoiTuongSuDungBoiTTHC(
		java.lang.Long tthcId) {
		return _tthc2DoiTuongSuDungLocalService.getDSTTHC2DoiTuongSuDungBoiTTHC(tthcId);
	}

	/**
	* This is fucntion count ThuTucHanhChinh by thutucId, doiTuongSuDungId,trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long thutucId,Long doiTuongSuDungId,int daXoa
	* @return long
	*/
	public long countTTHCTheoDoiTuongSuDung(java.lang.Long thutucId,
		java.lang.Long doiTuongSuDungId, int daXoa) {
		return _tthc2DoiTuongSuDungLocalService.countTTHCTheoDoiTuongSuDung(thutucId,
			doiTuongSuDungId, daXoa);
	}

	/**
	* This is fucntion find TTHC2DoiTuongSuDung by thuTucHanhChinhId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucHanhChinhId
	* @return List<TTHC2DoiTuongSuDung>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc2DoiTuongSuDungLocalService.findByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC2DoiTuongSuDungLocalService getWrappedTTHC2DoiTuongSuDungLocalService() {
		return _tthc2DoiTuongSuDungLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC2DoiTuongSuDungLocalService(
		TTHC2DoiTuongSuDungLocalService tthc2DoiTuongSuDungLocalService) {
		_tthc2DoiTuongSuDungLocalService = tthc2DoiTuongSuDungLocalService;
	}

	public TTHC2DoiTuongSuDungLocalService getWrappedService() {
		return _tthc2DoiTuongSuDungLocalService;
	}

	public void setWrappedService(
		TTHC2DoiTuongSuDungLocalService tthc2DoiTuongSuDungLocalService) {
		_tthc2DoiTuongSuDungLocalService = tthc2DoiTuongSuDungLocalService;
	}

	private TTHC2DoiTuongSuDungLocalService _tthc2DoiTuongSuDungLocalService;
}