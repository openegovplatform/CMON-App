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

package org.oep.cmon.dao.tlct.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhMucGiayToLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       DanhMucGiayToLocalService
 * @generated
 */
public class DanhMucGiayToLocalServiceWrapper
	implements DanhMucGiayToLocalService,
		ServiceWrapper<DanhMucGiayToLocalService> {
	public DanhMucGiayToLocalServiceWrapper(
		DanhMucGiayToLocalService danhMucGiayToLocalService) {
		_danhMucGiayToLocalService = danhMucGiayToLocalService;
	}

	/**
	* Adds the danh muc giay to to the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @return the danh muc giay to that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo addDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.addDanhMucGiayTo(danhMucGiayTo);
	}

	/**
	* Creates a new danh muc giay to with the primary key. Does not add the danh muc giay to to the database.
	*
	* @param id the primary key for the new danh muc giay to
	* @return the new danh muc giay to
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo createDanhMucGiayTo(
		long id) {
		return _danhMucGiayToLocalService.createDanhMucGiayTo(id);
	}

	/**
	* Deletes the danh muc giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to
	* @throws PortalException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_danhMucGiayToLocalService.deleteDanhMucGiayTo(id);
	}

	/**
	* Deletes the danh muc giay to from the database. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhMucGiayToLocalService.deleteDanhMucGiayTo(danhMucGiayTo);
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
		return _danhMucGiayToLocalService.dynamicQuery(dynamicQuery);
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
		return _danhMucGiayToLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _danhMucGiayToLocalService.dynamicQuery(dynamicQuery, start,
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
		return _danhMucGiayToLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.fetchDanhMucGiayTo(id);
	}

	/**
	* Returns the danh muc giay to with the primary key.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to
	* @throws PortalException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo getDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.getDanhMucGiayTo(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh muc giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @return the range of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getDanhMucGiayTos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.getDanhMucGiayTos(start, end);
	}

	/**
	* Returns the number of danh muc giay tos.
	*
	* @return the number of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int getDanhMucGiayTosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.getDanhMucGiayTosCount();
	}

	/**
	* Updates the danh muc giay to in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @return the danh muc giay to that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.updateDanhMucGiayTo(danhMucGiayTo);
	}

	/**
	* Updates the danh muc giay to in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhMucGiayTo the danh muc giay to
	* @param merge whether to merge the danh muc giay to with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the danh muc giay to that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.updateDanhMucGiayTo(danhMucGiayTo,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _danhMucGiayToLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danhMucGiayToLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion getGiayToBoiMa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return DanhMucGiayTo
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo getGiayToBoiMa(
		java.lang.String ma) {
		return _danhMucGiayToLocalService.getGiayToBoiMa(ma);
	}

	/**
	* This is fucntion searchDanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group, Long doiTuongId,int start, int end
	* @return List<DanhMucGiayTo>
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchDanhMucGiayTo(
		java.lang.String group, java.lang.Long doiTuongId, int start, int end) {
		return _danhMucGiayToLocalService.searchDanhMucGiayTo(group,
			doiTuongId, start, end);
	}

	/**
	* This is fucntion countDanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group, Long doiTuongId
	* @return long
	*/
	public long countDanhMucGiayTo(java.lang.String group,
		java.lang.Long doiTuongId) {
		return _danhMucGiayToLocalService.countDanhMucGiayTo(group, doiTuongId);
	}

	/**
	* This is fucntion searchByTTHCIdOrGDId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa, int start,int end
	* @return List<DanhMucGiayTo>
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchByTTHCIdOrGDId(
		java.lang.String group, java.lang.String doituong,
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end) {
		return _danhMucGiayToLocalService.searchByTTHCIdOrGDId(group, doituong,
			tthcid, dgId, daXoa, start, end);
	}

	/**
	* This is fucntion countByTTHCIdOrGDId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa
	* @return long
	*/
	public long countByTTHCIdOrGDId(java.lang.String group,
		java.lang.String doituong, java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa) {
		return _danhMucGiayToLocalService.countByTTHCIdOrGDId(group, doituong,
			tthcid, dgId, daXoa);
	}

	/**
	* This is fucntion findGiayToKetQua
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thutuchanhchinhId
	* @return List<DanhMucGiayTo>
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findGiayToKetQua(
		long thutuchanhchinhId) {
		return _danhMucGiayToLocalService.findGiayToKetQua(thutuchanhchinhId);
	}

	/**
	* This is fucntion finlistGiayToBCNopDon
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hosothutuchccId
	* @return List<DanhMucGiayTo>
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> finlistGiayToBCNopDon(
		long hosothutuchccId) {
		return _danhMucGiayToLocalService.finlistGiayToBCNopDon(hosothutuchccId);
	}

	/**
	* This is fucntion findTheoMa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return DanhMucGiayTo
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findTheoMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return _danhMucGiayToLocalService.findTheoMa(ma);
	}

	/**
	* This is fucntion getDanhMucGiayToList
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<DanhMucGiayTo>
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getDanhMucGiayToList(
		int daXoa) {
		return _danhMucGiayToLocalService.getDanhMucGiayToList(daXoa);
	}

	/**
	* This is fucntion listByCongDan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long doiTuongId
	* @return List<DanhMucGiayTo>
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listByCongDan(
		java.lang.Long doiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhMucGiayToLocalService.listByCongDan(doiTuongId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DanhMucGiayToLocalService getWrappedDanhMucGiayToLocalService() {
		return _danhMucGiayToLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDanhMucGiayToLocalService(
		DanhMucGiayToLocalService danhMucGiayToLocalService) {
		_danhMucGiayToLocalService = danhMucGiayToLocalService;
	}

	public DanhMucGiayToLocalService getWrappedService() {
		return _danhMucGiayToLocalService;
	}

	public void setWrappedService(
		DanhMucGiayToLocalService danhMucGiayToLocalService) {
		_danhMucGiayToLocalService = danhMucGiayToLocalService;
	}

	private DanhMucGiayToLocalService _danhMucGiayToLocalService;
}