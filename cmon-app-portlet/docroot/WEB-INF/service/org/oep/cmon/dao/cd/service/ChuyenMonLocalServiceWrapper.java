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
 * This class is a wrapper for {@link ChuyenMonLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       ChuyenMonLocalService
 * @generated
 */
public class ChuyenMonLocalServiceWrapper implements ChuyenMonLocalService,
	ServiceWrapper<ChuyenMonLocalService> {
	public ChuyenMonLocalServiceWrapper(
		ChuyenMonLocalService chuyenMonLocalService) {
		_chuyenMonLocalService = chuyenMonLocalService;
	}

	/**
	* Adds the chuyen mon to the database. Also notifies the appropriate model listeners.
	*
	* @param chuyenMon the chuyen mon
	* @return the chuyen mon that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon addChuyenMon(
		org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.addChuyenMon(chuyenMon);
	}

	/**
	* Creates a new chuyen mon with the primary key. Does not add the chuyen mon to the database.
	*
	* @param id the primary key for the new chuyen mon
	* @return the new chuyen mon
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon createChuyenMon(long id) {
		return _chuyenMonLocalService.createChuyenMon(id);
	}

	/**
	* Deletes the chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuyen mon
	* @throws PortalException if a chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChuyenMon(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_chuyenMonLocalService.deleteChuyenMon(id);
	}

	/**
	* Deletes the chuyen mon from the database. Also notifies the appropriate model listeners.
	*
	* @param chuyenMon the chuyen mon
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChuyenMon(org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		_chuyenMonLocalService.deleteChuyenMon(chuyenMon);
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
		return _chuyenMonLocalService.dynamicQuery(dynamicQuery);
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
		return _chuyenMonLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _chuyenMonLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _chuyenMonLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cd.model.ChuyenMon fetchChuyenMon(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.fetchChuyenMon(id);
	}

	/**
	* Returns the chuyen mon with the primary key.
	*
	* @param id the primary key of the chuyen mon
	* @return the chuyen mon
	* @throws PortalException if a chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon getChuyenMon(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.getChuyenMon(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuyen mons
	* @param end the upper bound of the range of chuyen mons (not inclusive)
	* @return the range of chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> getChuyenMons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.getChuyenMons(start, end);
	}

	/**
	* Returns the number of chuyen mons.
	*
	* @return the number of chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public int getChuyenMonsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.getChuyenMonsCount();
	}

	/**
	* Updates the chuyen mon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chuyenMon the chuyen mon
	* @return the chuyen mon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon updateChuyenMon(
		org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.updateChuyenMon(chuyenMon);
	}

	/**
	* Updates the chuyen mon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chuyenMon the chuyen mon
	* @param merge whether to merge the chuyen mon with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chuyen mon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon updateChuyenMon(
		org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chuyenMonLocalService.updateChuyenMon(chuyenMon, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _chuyenMonLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_chuyenMonLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion fetch ChuyenMon by congDan2CCGPId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of congDan2CCGPId
	* @return List<ChuyenMon>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> fetchListByCongDan2CCGPId(
		long congDan2CCGPId) {
		return _chuyenMonLocalService.fetchListByCongDan2CCGPId(congDan2CCGPId);
	}

	/**
	* This is fucntion get ChuyenMon by idUngdung and  idCha
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of idUngdung; String idCha
	* @return List<ChuyenMon>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> getChuyenMonByChaId(
		java.lang.String idUngdung, java.lang.String idCha) {
		return _chuyenMonLocalService.getChuyenMonByChaId(idUngdung, idCha);
	}

	/**
	* This is fucntion get ChuyenMon by idUngdung
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of idUngdung
	* @return List<ChuyenMon>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> getChuyenMonByChaIdNull(
		java.lang.String idUngdung) {
		return _chuyenMonLocalService.getChuyenMonByChaIdNull(idUngdung);
	}

	/**
	* This is fucntion find ChuyenMon by maDanhMucUngDung
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of maDanhMucUngDung
	* @return List<ChuyenMon>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> findByMaDanhMucUngDung(
		java.lang.String maDanhMucUngDung) {
		return _chuyenMonLocalService.findByMaDanhMucUngDung(maDanhMucUngDung);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ChuyenMonLocalService getWrappedChuyenMonLocalService() {
		return _chuyenMonLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedChuyenMonLocalService(
		ChuyenMonLocalService chuyenMonLocalService) {
		_chuyenMonLocalService = chuyenMonLocalService;
	}

	public ChuyenMonLocalService getWrappedService() {
		return _chuyenMonLocalService;
	}

	public void setWrappedService(ChuyenMonLocalService chuyenMonLocalService) {
		_chuyenMonLocalService = chuyenMonLocalService;
	}

	private ChuyenMonLocalService _chuyenMonLocalService;
}