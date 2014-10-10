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

package org.oep.exch.dao.hoso.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UpdateHoSoTrucTuyenLocalService}.
 * </p>
 *
 * @author    NAM
 * @see       UpdateHoSoTrucTuyenLocalService
 * @generated
 */
public class UpdateHoSoTrucTuyenLocalServiceWrapper
	implements UpdateHoSoTrucTuyenLocalService,
		ServiceWrapper<UpdateHoSoTrucTuyenLocalService> {
	public UpdateHoSoTrucTuyenLocalServiceWrapper(
		UpdateHoSoTrucTuyenLocalService updateHoSoTrucTuyenLocalService) {
		_updateHoSoTrucTuyenLocalService = updateHoSoTrucTuyenLocalService;
	}

	/**
	* Adds the update ho so truc tuyen to the database. Also notifies the appropriate model listeners.
	*
	* @param updateHoSoTrucTuyen the update ho so truc tuyen
	* @return the update ho so truc tuyen that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen addUpdateHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.addUpdateHoSoTrucTuyen(updateHoSoTrucTuyen);
	}

	/**
	* Creates a new update ho so truc tuyen with the primary key. Does not add the update ho so truc tuyen to the database.
	*
	* @param id the primary key for the new update ho so truc tuyen
	* @return the new update ho so truc tuyen
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen createUpdateHoSoTrucTuyen(
		long id) {
		return _updateHoSoTrucTuyenLocalService.createUpdateHoSoTrucTuyen(id);
	}

	/**
	* Deletes the update ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @throws PortalException if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUpdateHoSoTrucTuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_updateHoSoTrucTuyenLocalService.deleteUpdateHoSoTrucTuyen(id);
	}

	/**
	* Deletes the update ho so truc tuyen from the database. Also notifies the appropriate model listeners.
	*
	* @param updateHoSoTrucTuyen the update ho so truc tuyen
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUpdateHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen)
		throws com.liferay.portal.kernel.exception.SystemException {
		_updateHoSoTrucTuyenLocalService.deleteUpdateHoSoTrucTuyen(updateHoSoTrucTuyen);
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
		return _updateHoSoTrucTuyenLocalService.dynamicQuery(dynamicQuery);
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
		return _updateHoSoTrucTuyenLocalService.dynamicQuery(dynamicQuery,
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
		return _updateHoSoTrucTuyenLocalService.dynamicQuery(dynamicQuery,
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
		return _updateHoSoTrucTuyenLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen fetchUpdateHoSoTrucTuyen(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.fetchUpdateHoSoTrucTuyen(id);
	}

	/**
	* Returns the update ho so truc tuyen with the primary key.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen
	* @throws PortalException if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen getUpdateHoSoTrucTuyen(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.getUpdateHoSoTrucTuyen(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the update ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update ho so truc tuyens
	* @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	* @return the range of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> getUpdateHoSoTrucTuyens(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.getUpdateHoSoTrucTuyens(start,
			end);
	}

	/**
	* Returns the number of update ho so truc tuyens.
	*
	* @return the number of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public int getUpdateHoSoTrucTuyensCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.getUpdateHoSoTrucTuyensCount();
	}

	/**
	* Updates the update ho so truc tuyen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param updateHoSoTrucTuyen the update ho so truc tuyen
	* @return the update ho so truc tuyen that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateUpdateHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.updateUpdateHoSoTrucTuyen(updateHoSoTrucTuyen);
	}

	/**
	* Updates the update ho so truc tuyen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param updateHoSoTrucTuyen the update ho so truc tuyen
	* @param merge whether to merge the update ho so truc tuyen with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the update ho so truc tuyen that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateUpdateHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _updateHoSoTrucTuyenLocalService.updateUpdateHoSoTrucTuyen(updateHoSoTrucTuyen,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _updateHoSoTrucTuyenLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_updateHoSoTrucTuyenLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UpdateHoSoTrucTuyenLocalService getWrappedUpdateHoSoTrucTuyenLocalService() {
		return _updateHoSoTrucTuyenLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUpdateHoSoTrucTuyenLocalService(
		UpdateHoSoTrucTuyenLocalService updateHoSoTrucTuyenLocalService) {
		_updateHoSoTrucTuyenLocalService = updateHoSoTrucTuyenLocalService;
	}

	public UpdateHoSoTrucTuyenLocalService getWrappedService() {
		return _updateHoSoTrucTuyenLocalService;
	}

	public void setWrappedService(
		UpdateHoSoTrucTuyenLocalService updateHoSoTrucTuyenLocalService) {
		_updateHoSoTrucTuyenLocalService = updateHoSoTrucTuyenLocalService;
	}

	private UpdateHoSoTrucTuyenLocalService _updateHoSoTrucTuyenLocalService;
}