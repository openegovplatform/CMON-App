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

package org.oep.cmon.dao.kios.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhSachCoQuanLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhSachCoQuanLocalService
 * @generated
 */
public class DanhSachCoQuanLocalServiceWrapper
	implements DanhSachCoQuanLocalService,
		ServiceWrapper<DanhSachCoQuanLocalService> {
	public DanhSachCoQuanLocalServiceWrapper(
		DanhSachCoQuanLocalService danhSachCoQuanLocalService) {
		_danhSachCoQuanLocalService = danhSachCoQuanLocalService;
	}

	/**
	* Adds the danh sach co quan to the database. Also notifies the appropriate model listeners.
	*
	* @param danhSachCoQuan the danh sach co quan
	* @return the danh sach co quan that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachCoQuan addDanhSachCoQuan(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.addDanhSachCoQuan(danhSachCoQuan);
	}

	/**
	* Creates a new danh sach co quan with the primary key. Does not add the danh sach co quan to the database.
	*
	* @param id the primary key for the new danh sach co quan
	* @return the new danh sach co quan
	*/
	public org.oep.cmon.dao.kios.model.DanhSachCoQuan createDanhSachCoQuan(
		long id) {
		return _danhSachCoQuanLocalService.createDanhSachCoQuan(id);
	}

	/**
	* Deletes the danh sach co quan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh sach co quan
	* @throws PortalException if a danh sach co quan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhSachCoQuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_danhSachCoQuanLocalService.deleteDanhSachCoQuan(id);
	}

	/**
	* Deletes the danh sach co quan from the database. Also notifies the appropriate model listeners.
	*
	* @param danhSachCoQuan the danh sach co quan
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhSachCoQuan(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan)
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhSachCoQuanLocalService.deleteDanhSachCoQuan(danhSachCoQuan);
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
		return _danhSachCoQuanLocalService.dynamicQuery(dynamicQuery);
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
		return _danhSachCoQuanLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _danhSachCoQuanLocalService.dynamicQuery(dynamicQuery, start,
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
		return _danhSachCoQuanLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.kios.model.DanhSachCoQuan fetchDanhSachCoQuan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.fetchDanhSachCoQuan(id);
	}

	/**
	* Returns the danh sach co quan with the primary key.
	*
	* @param id the primary key of the danh sach co quan
	* @return the danh sach co quan
	* @throws PortalException if a danh sach co quan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachCoQuan getDanhSachCoQuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.getDanhSachCoQuan(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh sach co quans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach co quans
	* @param end the upper bound of the range of danh sach co quans (not inclusive)
	* @return the range of danh sach co quans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> getDanhSachCoQuans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.getDanhSachCoQuans(start, end);
	}

	/**
	* Returns the number of danh sach co quans.
	*
	* @return the number of danh sach co quans
	* @throws SystemException if a system exception occurred
	*/
	public int getDanhSachCoQuansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.getDanhSachCoQuansCount();
	}

	/**
	* Updates the danh sach co quan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhSachCoQuan the danh sach co quan
	* @return the danh sach co quan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachCoQuan updateDanhSachCoQuan(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.updateDanhSachCoQuan(danhSachCoQuan);
	}

	/**
	* Updates the danh sach co quan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhSachCoQuan the danh sach co quan
	* @param merge whether to merge the danh sach co quan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh sach co quan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachCoQuan updateDanhSachCoQuan(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhSachCoQuanLocalService.updateDanhSachCoQuan(danhSachCoQuan,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _danhSachCoQuanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danhSachCoQuanLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DanhSachCoQuanLocalService getWrappedDanhSachCoQuanLocalService() {
		return _danhSachCoQuanLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDanhSachCoQuanLocalService(
		DanhSachCoQuanLocalService danhSachCoQuanLocalService) {
		_danhSachCoQuanLocalService = danhSachCoQuanLocalService;
	}

	public DanhSachCoQuanLocalService getWrappedService() {
		return _danhSachCoQuanLocalService;
	}

	public void setWrappedService(
		DanhSachCoQuanLocalService danhSachCoQuanLocalService) {
		_danhSachCoQuanLocalService = danhSachCoQuanLocalService;
	}

	private DanhSachCoQuanLocalService _danhSachCoQuanLocalService;
}