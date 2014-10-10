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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrangThaiHoSoLocalService}.
 * </p>
 *
 * @author    LIEMNn
 * @see       TrangThaiHoSoLocalService
 * @generated
 */
public class TrangThaiHoSoLocalServiceWrapper
	implements TrangThaiHoSoLocalService,
		ServiceWrapper<TrangThaiHoSoLocalService> {
	public TrangThaiHoSoLocalServiceWrapper(
		TrangThaiHoSoLocalService trangThaiHoSoLocalService) {
		_trangThaiHoSoLocalService = trangThaiHoSoLocalService;
	}

	/**
	* Adds the trang thai ho so to the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @return the trang thai ho so that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo addTrangThaiHoSo(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.addTrangThaiHoSo(trangThaiHoSo);
	}

	/**
	* Creates a new trang thai ho so with the primary key. Does not add the trang thai ho so to the database.
	*
	* @param id the primary key for the new trang thai ho so
	* @return the new trang thai ho so
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo createTrangThaiHoSo(
		long id) {
		return _trangThaiHoSoLocalService.createTrangThaiHoSo(id);
	}

	/**
	* Deletes the trang thai ho so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai ho so
	* @throws PortalException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiHoSo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_trangThaiHoSoLocalService.deleteTrangThaiHoSo(id);
	}

	/**
	* Deletes the trang thai ho so from the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiHoSo(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiHoSoLocalService.deleteTrangThaiHoSo(trangThaiHoSo);
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
		return _trangThaiHoSoLocalService.dynamicQuery(dynamicQuery);
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
		return _trangThaiHoSoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _trangThaiHoSoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _trangThaiHoSoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchTrangThaiHoSo(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.fetchTrangThaiHoSo(id);
	}

	/**
	* Returns the trang thai ho so with the primary key.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so
	* @throws PortalException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo getTrangThaiHoSo(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.getTrangThaiHoSo(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trang thai ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @return the range of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> getTrangThaiHoSos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.getTrangThaiHoSos(start, end);
	}

	/**
	* Returns the number of trang thai ho sos.
	*
	* @return the number of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public int getTrangThaiHoSosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.getTrangThaiHoSosCount();
	}

	/**
	* Updates the trang thai ho so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @return the trang thai ho so that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo updateTrangThaiHoSo(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.updateTrangThaiHoSo(trangThaiHoSo);
	}

	/**
	* Updates the trang thai ho so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param merge whether to merge the trang thai ho so with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trang thai ho so that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo updateTrangThaiHoSo(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.updateTrangThaiHoSo(trangThaiHoSo,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trangThaiHoSoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trangThaiHoSoLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findAll
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<TrangThaiHoSo>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.findAll();
	}

	/**
	* This is fucntion findAll
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int start, int end
	* @return List<TrangThaiHoSo>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.findAll(start, end);
	}

	/**
	* This is fucntion findById
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long id
	* @return TrangThaiHoSo
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.findById(id);
	}

	/**
	* This is fucntion getListTrangThaiHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<TrangThaiHoSo>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> getListTrangThaiHoSo(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiHoSoLocalService.getListTrangThaiHoSo(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrangThaiHoSoLocalService getWrappedTrangThaiHoSoLocalService() {
		return _trangThaiHoSoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrangThaiHoSoLocalService(
		TrangThaiHoSoLocalService trangThaiHoSoLocalService) {
		_trangThaiHoSoLocalService = trangThaiHoSoLocalService;
	}

	public TrangThaiHoSoLocalService getWrappedService() {
		return _trangThaiHoSoLocalService;
	}

	public void setWrappedService(
		TrangThaiHoSoLocalService trangThaiHoSoLocalService) {
		_trangThaiHoSoLocalService = trangThaiHoSoLocalService;
	}

	private TrangThaiHoSoLocalService _trangThaiHoSoLocalService;
}