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
 * This class is a wrapper for {@link DanhMucGiayTo2DoiTuongSuDungLocalService}.
 * </p>
 *
 * @author    liemnn
 * @see       DanhMucGiayTo2DoiTuongSuDungLocalService
 * @generated
 */
public class DanhMucGiayTo2DoiTuongSuDungLocalServiceWrapper
	implements DanhMucGiayTo2DoiTuongSuDungLocalService,
		ServiceWrapper<DanhMucGiayTo2DoiTuongSuDungLocalService> {
	public DanhMucGiayTo2DoiTuongSuDungLocalServiceWrapper(
		DanhMucGiayTo2DoiTuongSuDungLocalService danhMucGiayTo2DoiTuongSuDungLocalService) {
		_danhMucGiayTo2DoiTuongSuDungLocalService = danhMucGiayTo2DoiTuongSuDungLocalService;
	}

	/**
	* Adds the danh muc giay to2 doi tuong su dung to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung addDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.addDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung);
	}

	/**
	* Creates a new danh muc giay to2 doi tuong su dung with the primary key. Does not add the danh muc giay to2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new danh muc giay to2 doi tuong su dung
	* @return the new danh muc giay to2 doi tuong su dung
	*/
	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung createDanhMucGiayTo2DoiTuongSuDung(
		long id) {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.createDanhMucGiayTo2DoiTuongSuDung(id);
	}

	/**
	* Deletes the danh muc giay to2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @throws PortalException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucGiayTo2DoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_danhMucGiayTo2DoiTuongSuDungLocalService.deleteDanhMucGiayTo2DoiTuongSuDung(id);
	}

	/**
	* Deletes the danh muc giay to2 doi tuong su dung from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucGiayTo2DoiTuongSuDungLocalService.deleteDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung);
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
		return _danhMucGiayTo2DoiTuongSuDungLocalService.dynamicQuery(dynamicQuery);
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
		return _danhMucGiayTo2DoiTuongSuDungLocalService.dynamicQuery(dynamicQuery,
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
		return _danhMucGiayTo2DoiTuongSuDungLocalService.dynamicQuery(dynamicQuery,
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
		return _danhMucGiayTo2DoiTuongSuDungLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung fetchDanhMucGiayTo2DoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.fetchDanhMucGiayTo2DoiTuongSuDung(id);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dung with the primary key.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung
	* @throws PortalException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung getDanhMucGiayTo2DoiTuongSuDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getDanhMucGiayTo2DoiTuongSuDung(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc giay to2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @return the range of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getDanhMucGiayTo2DoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getDanhMucGiayTo2DoiTuongSuDungs(start,
			end);
	}

	/**
	* Returns the number of danh muc giay to2 doi tuong su dungs.
	*
	* @return the number of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int getDanhMucGiayTo2DoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getDanhMucGiayTo2DoiTuongSuDungsCount();
	}

	/**
	* Updates the danh muc giay to2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.updateDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung);
	}

	/**
	* Updates the danh muc giay to2 doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	* @param merge whether to merge the danh muc giay to2 doi tuong su dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc giay to2 doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.updateDanhMucGiayTo2DoiTuongSuDung(danhMucGiayTo2DoiTuongSuDung,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danhMucGiayTo2DoiTuongSuDungLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion get DanhMucGiayTo2DoiTuongSuDung by loaiGiayToId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long loaiGiayToId
	* @return List<DanhMucGiayTo2DoiTuongSuDung>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiGT_DSDMGT2DTSD(
		java.lang.Long loaiGiayToId) {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getTheoLoaiGT_DSDMGT2DTSD(loaiGiayToId);
	}

	/**
	* This is fucntion get DanhMucGiayTo2DoiTuongSuDung by loaiDoiTuongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long loaiDoiTuongId
	* @return List<DanhMucGiayTo2DoiTuongSuDung>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiDT_DSDMGT2DTSD(
		java.lang.Long loaiDoiTuongId) {
		return _danhMucGiayTo2DoiTuongSuDungLocalService.getTheoLoaiDT_DSDMGT2DTSD(loaiDoiTuongId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DanhMucGiayTo2DoiTuongSuDungLocalService getWrappedDanhMucGiayTo2DoiTuongSuDungLocalService() {
		return _danhMucGiayTo2DoiTuongSuDungLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDanhMucGiayTo2DoiTuongSuDungLocalService(
		DanhMucGiayTo2DoiTuongSuDungLocalService danhMucGiayTo2DoiTuongSuDungLocalService) {
		_danhMucGiayTo2DoiTuongSuDungLocalService = danhMucGiayTo2DoiTuongSuDungLocalService;
	}

	public DanhMucGiayTo2DoiTuongSuDungLocalService getWrappedService() {
		return _danhMucGiayTo2DoiTuongSuDungLocalService;
	}

	public void setWrappedService(
		DanhMucGiayTo2DoiTuongSuDungLocalService danhMucGiayTo2DoiTuongSuDungLocalService) {
		_danhMucGiayTo2DoiTuongSuDungLocalService = danhMucGiayTo2DoiTuongSuDungLocalService;
	}

	private DanhMucGiayTo2DoiTuongSuDungLocalService _danhMucGiayTo2DoiTuongSuDungLocalService;
}