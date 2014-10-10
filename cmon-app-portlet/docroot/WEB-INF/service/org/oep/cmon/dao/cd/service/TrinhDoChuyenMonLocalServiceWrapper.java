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

package org.oep.cmon.dao.cd.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrinhDoChuyenMonLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       TrinhDoChuyenMonLocalService
 * @generated
 */
public class TrinhDoChuyenMonLocalServiceWrapper
	implements TrinhDoChuyenMonLocalService,
		ServiceWrapper<TrinhDoChuyenMonLocalService> {
	public TrinhDoChuyenMonLocalServiceWrapper(
		TrinhDoChuyenMonLocalService trinhDoChuyenMonLocalService) {
		_trinhDoChuyenMonLocalService = trinhDoChuyenMonLocalService;
	}

	/**
	* Adds the trinh do chuyen mon to the database. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @return the trinh do chuyen mon that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon addTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.addTrinhDoChuyenMon(trinhDoChuyenMon);
	}

	/**
	* Creates a new trinh do chuyen mon with the primary key. Does not add the trinh do chuyen mon to the database.
	*
	* @param id the primary key for the new trinh do chuyen mon
	* @return the new trinh do chuyen mon
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon createTrinhDoChuyenMon(
		long id) {
		return _trinhDoChuyenMonLocalService.createTrinhDoChuyenMon(id);
	}

	/**
	* Deletes the trinh do chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @throws PortalException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrinhDoChuyenMon(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_trinhDoChuyenMonLocalService.deleteTrinhDoChuyenMon(id);
	}

	/**
	* Deletes the trinh do chuyen mon from the database. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		_trinhDoChuyenMonLocalService.deleteTrinhDoChuyenMon(trinhDoChuyenMon);
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
		return _trinhDoChuyenMonLocalService.dynamicQuery(dynamicQuery);
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
		return _trinhDoChuyenMonLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _trinhDoChuyenMonLocalService.dynamicQuery(dynamicQuery, start,
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
		return _trinhDoChuyenMonLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon fetchTrinhDoChuyenMon(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.fetchTrinhDoChuyenMon(id);
	}

	/**
	* Returns the trinh do chuyen mon with the primary key.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @return the trinh do chuyen mon
	* @throws PortalException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon getTrinhDoChuyenMon(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.getTrinhDoChuyenMon(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trinh do chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trinh do chuyen mons
	* @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	* @return the range of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> getTrinhDoChuyenMons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.getTrinhDoChuyenMons(start, end);
	}

	/**
	* Returns the number of trinh do chuyen mons.
	*
	* @return the number of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public int getTrinhDoChuyenMonsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.getTrinhDoChuyenMonsCount();
	}

	/**
	* Updates the trinh do chuyen mon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @return the trinh do chuyen mon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon updateTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.updateTrinhDoChuyenMon(trinhDoChuyenMon);
	}

	/**
	* Updates the trinh do chuyen mon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	* @param merge whether to merge the trinh do chuyen mon with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trinh do chuyen mon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon updateTrinhDoChuyenMon(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.updateTrinhDoChuyenMon(trinhDoChuyenMon,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trinhDoChuyenMonLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trinhDoChuyenMonLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion find all TrinhDoChuyenMon
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<TrinhDoChuyenMon>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.findAll();
	}

	/**
	* This is fucntion find TrinhDoChuyenMon by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<TrinhDoChuyenMon>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findByStatus(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return _trinhDoChuyenMonLocalService.findByStatus(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrinhDoChuyenMonLocalService getWrappedTrinhDoChuyenMonLocalService() {
		return _trinhDoChuyenMonLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrinhDoChuyenMonLocalService(
		TrinhDoChuyenMonLocalService trinhDoChuyenMonLocalService) {
		_trinhDoChuyenMonLocalService = trinhDoChuyenMonLocalService;
	}

	public TrinhDoChuyenMonLocalService getWrappedService() {
		return _trinhDoChuyenMonLocalService;
	}

	public void setWrappedService(
		TrinhDoChuyenMonLocalService trinhDoChuyenMonLocalService) {
		_trinhDoChuyenMonLocalService = trinhDoChuyenMonLocalService;
	}

	private TrinhDoChuyenMonLocalService _trinhDoChuyenMonLocalService;
}