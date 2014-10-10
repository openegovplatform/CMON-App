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
 * This class is a wrapper for {@link DanhMucBaoCaoLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhMucBaoCaoLocalService
 * @generated
 */
public class DanhMucBaoCaoLocalServiceWrapper
	implements DanhMucBaoCaoLocalService,
		ServiceWrapper<DanhMucBaoCaoLocalService> {
	public DanhMucBaoCaoLocalServiceWrapper(
		DanhMucBaoCaoLocalService danhMucBaoCaoLocalService) {
		_danhMucBaoCaoLocalService = danhMucBaoCaoLocalService;
	}

	/**
	* Adds the danh muc bao cao to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @return the danh muc bao cao that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao addDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.addDanhMucBaoCao(danhMucBaoCao);
	}

	/**
	* Creates a new danh muc bao cao with the primary key. Does not add the danh muc bao cao to the database.
	*
	* @param ID the primary key for the new danh muc bao cao
	* @return the new danh muc bao cao
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao createDanhMucBaoCao(
		long ID) {
		return _danhMucBaoCaoLocalService.createDanhMucBaoCao(ID);
	}

	/**
	* Deletes the danh muc bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc bao cao
	* @throws PortalException if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucBaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_danhMucBaoCaoLocalService.deleteDanhMucBaoCao(ID);
	}

	/**
	* Deletes the danh muc bao cao from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucBaoCaoLocalService.deleteDanhMucBaoCao(danhMucBaoCao);
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
		return _danhMucBaoCaoLocalService.dynamicQuery(dynamicQuery);
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
		return _danhMucBaoCaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _danhMucBaoCaoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _danhMucBaoCaoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.DanhMucBaoCao fetchDanhMucBaoCao(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.fetchDanhMucBaoCao(ID);
	}

	/**
	* Returns the danh muc bao cao with the primary key.
	*
	* @param ID the primary key of the danh muc bao cao
	* @return the danh muc bao cao
	* @throws PortalException if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao getDanhMucBaoCao(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.getDanhMucBaoCao(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc bao caos
	* @param end the upper bound of the range of danh muc bao caos (not inclusive)
	* @return the range of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> getDanhMucBaoCaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.getDanhMucBaoCaos(start, end);
	}

	/**
	* Returns the number of danh muc bao caos.
	*
	* @return the number of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public int getDanhMucBaoCaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.getDanhMucBaoCaosCount();
	}

	/**
	* Updates the danh muc bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @return the danh muc bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao updateDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.updateDanhMucBaoCao(danhMucBaoCao);
	}

	/**
	* Updates the danh muc bao cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucBaoCao the danh muc bao cao
	* @param merge whether to merge the danh muc bao cao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc bao cao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao updateDanhMucBaoCao(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucBaoCaoLocalService.updateDanhMucBaoCao(danhMucBaoCao,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _danhMucBaoCaoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danhMucBaoCaoLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DanhMucBaoCaoLocalService getWrappedDanhMucBaoCaoLocalService() {
		return _danhMucBaoCaoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDanhMucBaoCaoLocalService(
		DanhMucBaoCaoLocalService danhMucBaoCaoLocalService) {
		_danhMucBaoCaoLocalService = danhMucBaoCaoLocalService;
	}

	public DanhMucBaoCaoLocalService getWrappedService() {
		return _danhMucBaoCaoLocalService;
	}

	public void setWrappedService(
		DanhMucBaoCaoLocalService danhMucBaoCaoLocalService) {
		_danhMucBaoCaoLocalService = danhMucBaoCaoLocalService;
	}

	private DanhMucBaoCaoLocalService _danhMucBaoCaoLocalService;
}