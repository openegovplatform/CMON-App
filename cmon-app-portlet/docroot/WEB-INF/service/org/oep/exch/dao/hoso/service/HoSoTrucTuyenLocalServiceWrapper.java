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
 * This class is a wrapper for {@link HoSoTrucTuyenLocalService}.
 * </p>
 *
 * @author    NAM
 * @see       HoSoTrucTuyenLocalService
 * @generated
 */
public class HoSoTrucTuyenLocalServiceWrapper
	implements HoSoTrucTuyenLocalService,
		ServiceWrapper<HoSoTrucTuyenLocalService> {
	public HoSoTrucTuyenLocalServiceWrapper(
		HoSoTrucTuyenLocalService hoSoTrucTuyenLocalService) {
		_hoSoTrucTuyenLocalService = hoSoTrucTuyenLocalService;
	}

	/**
	* Adds the ho so truc tuyen to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoTrucTuyen the ho so truc tuyen
	* @return the ho so truc tuyen that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen addHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.addHoSoTrucTuyen(hoSoTrucTuyen);
	}

	/**
	* Creates a new ho so truc tuyen with the primary key. Does not add the ho so truc tuyen to the database.
	*
	* @param id the primary key for the new ho so truc tuyen
	* @return the new ho so truc tuyen
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen createHoSoTrucTuyen(
		long id) {
		return _hoSoTrucTuyenLocalService.createHoSoTrucTuyen(id);
	}

	/**
	* Deletes the ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so truc tuyen
	* @throws PortalException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoTrucTuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_hoSoTrucTuyenLocalService.deleteHoSoTrucTuyen(id);
	}

	/**
	* Deletes the ho so truc tuyen from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoTrucTuyen the ho so truc tuyen
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen)
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoTrucTuyenLocalService.deleteHoSoTrucTuyen(hoSoTrucTuyen);
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
		return _hoSoTrucTuyenLocalService.dynamicQuery(dynamicQuery);
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
		return _hoSoTrucTuyenLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _hoSoTrucTuyenLocalService.dynamicQuery(dynamicQuery, start,
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
		return _hoSoTrucTuyenLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen fetchHoSoTrucTuyen(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.fetchHoSoTrucTuyen(id);
	}

	/**
	* Returns the ho so truc tuyen with the primary key.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen
	* @throws PortalException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen getHoSoTrucTuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.getHoSoTrucTuyen(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @return the range of ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> getHoSoTrucTuyens(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.getHoSoTrucTuyens(start, end);
	}

	/**
	* Returns the number of ho so truc tuyens.
	*
	* @return the number of ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public int getHoSoTrucTuyensCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.getHoSoTrucTuyensCount();
	}

	/**
	* Updates the ho so truc tuyen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoTrucTuyen the ho so truc tuyen
	* @return the ho so truc tuyen that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen updateHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.updateHoSoTrucTuyen(hoSoTrucTuyen);
	}

	/**
	* Updates the ho so truc tuyen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoTrucTuyen the ho so truc tuyen
	* @param merge whether to merge the ho so truc tuyen with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so truc tuyen that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen updateHoSoTrucTuyen(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.updateHoSoTrucTuyen(hoSoTrucTuyen,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _hoSoTrucTuyenLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hoSoTrucTuyenLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findByNoiChuyenHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String dest, int trangThai
	* @return List<HoSoTrucTuyen>
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String dest, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.findByNoiChuyenHoSo(dest, trangThai);
	}

	/**
	* This is fucntion findByMaDonViTiepNhan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maDonViTiepNhan, int trangThai
	* @return List<HoSoTrucTuyen>
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String maDonViTiepNhan, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoTrucTuyenLocalService.findByMaDonViTiepNhan(maDonViTiepNhan,
			trangThai);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public HoSoTrucTuyenLocalService getWrappedHoSoTrucTuyenLocalService() {
		return _hoSoTrucTuyenLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedHoSoTrucTuyenLocalService(
		HoSoTrucTuyenLocalService hoSoTrucTuyenLocalService) {
		_hoSoTrucTuyenLocalService = hoSoTrucTuyenLocalService;
	}

	public HoSoTrucTuyenLocalService getWrappedService() {
		return _hoSoTrucTuyenLocalService;
	}

	public void setWrappedService(
		HoSoTrucTuyenLocalService hoSoTrucTuyenLocalService) {
		_hoSoTrucTuyenLocalService = hoSoTrucTuyenLocalService;
	}

	private HoSoTrucTuyenLocalService _hoSoTrucTuyenLocalService;
}