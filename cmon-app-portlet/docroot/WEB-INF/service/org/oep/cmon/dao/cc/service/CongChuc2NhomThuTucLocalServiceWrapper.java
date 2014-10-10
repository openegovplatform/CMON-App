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

package org.oep.cmon.dao.cc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CongChuc2NhomThuTucLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       CongChuc2NhomThuTucLocalService
 * @generated
 */
public class CongChuc2NhomThuTucLocalServiceWrapper
	implements CongChuc2NhomThuTucLocalService,
		ServiceWrapper<CongChuc2NhomThuTucLocalService> {
	public CongChuc2NhomThuTucLocalServiceWrapper(
		CongChuc2NhomThuTucLocalService congChuc2NhomThuTucLocalService) {
		_congChuc2NhomThuTucLocalService = congChuc2NhomThuTucLocalService;
	}

	/**
	* Adds the cong chuc2 nhom thu tuc to the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc addCongChuc2NhomThuTuc(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.addCongChuc2NhomThuTuc(congChuc2NhomThuTuc);
	}

	/**
	* Creates a new cong chuc2 nhom thu tuc with the primary key. Does not add the cong chuc2 nhom thu tuc to the database.
	*
	* @param id the primary key for the new cong chuc2 nhom thu tuc
	* @return the new cong chuc2 nhom thu tuc
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc createCongChuc2NhomThuTuc(
		long id) {
		return _congChuc2NhomThuTucLocalService.createCongChuc2NhomThuTuc(id);
	}

	/**
	* Deletes the cong chuc2 nhom thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @throws PortalException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongChuc2NhomThuTuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_congChuc2NhomThuTucLocalService.deleteCongChuc2NhomThuTuc(id);
	}

	/**
	* Deletes the cong chuc2 nhom thu tuc from the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongChuc2NhomThuTuc(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		_congChuc2NhomThuTucLocalService.deleteCongChuc2NhomThuTuc(congChuc2NhomThuTuc);
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
		return _congChuc2NhomThuTucLocalService.dynamicQuery(dynamicQuery);
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
		return _congChuc2NhomThuTucLocalService.dynamicQuery(dynamicQuery,
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
		return _congChuc2NhomThuTucLocalService.dynamicQuery(dynamicQuery,
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
		return _congChuc2NhomThuTucLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchCongChuc2NhomThuTuc(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.fetchCongChuc2NhomThuTuc(id);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc with the primary key.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc
	* @throws PortalException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc getCongChuc2NhomThuTuc(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.getCongChuc2NhomThuTuc(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cong chuc2 nhom thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @return the range of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> getCongChuc2NhomThuTucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.getCongChuc2NhomThuTucs(start,
			end);
	}

	/**
	* Returns the number of cong chuc2 nhom thu tucs.
	*
	* @return the number of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int getCongChuc2NhomThuTucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.getCongChuc2NhomThuTucsCount();
	}

	/**
	* Updates the cong chuc2 nhom thu tuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc updateCongChuc2NhomThuTuc(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.updateCongChuc2NhomThuTuc(congChuc2NhomThuTuc);
	}

	/**
	* Updates the cong chuc2 nhom thu tuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	* @param merge whether to merge the cong chuc2 nhom thu tuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong chuc2 nhom thu tuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc updateCongChuc2NhomThuTuc(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.updateCongChuc2NhomThuTuc(congChuc2NhomThuTuc,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _congChuc2NhomThuTucLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_congChuc2NhomThuTucLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion fetch CongChuc2NhomThuTuc by ID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of ID
	* @return CongChuc2NhomThuTuc infomation
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.fetchById(id);
	}

	/**
	* This is fucntion find CongChuc2NhomThuTuc by congchucID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of congchucID
	* @return List<CongChuc2NhomThuTuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.findByCongChuc(congChucId);
	}

	/**
	* This is fucntion delete CongChuc2NhomThuTuc by congchucID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of congchucID
	* @return void
	*/
	public void deleteByCongChuc(long congChucId) {
		_congChuc2NhomThuTucLocalService.deleteByCongChuc(congChucId);
	}

	/**
	* This is fucntion fetch CongChuc2NhomThuTuc by congchucID and nhomThuTucId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of congchucID; long: value nhomThuTucId
	* @return CongChuc2NhomThuTuc
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2NhomThuTucLocalService.fetchByCongChucAndNhomThuTuc(congChucId,
			nhomThuTucId);
	}

	/**
	* This is fucntion delete CongChuc2NhomThuTuc by congchucID and nhomThuTucId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of congchucID; long: value nhomThuTucId
	* @return void
	*/
	public void deleteByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId) {
		_congChuc2NhomThuTucLocalService.deleteByCongChucAndNhomThuTuc(congChucId,
			nhomThuTucId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CongChuc2NhomThuTucLocalService getWrappedCongChuc2NhomThuTucLocalService() {
		return _congChuc2NhomThuTucLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCongChuc2NhomThuTucLocalService(
		CongChuc2NhomThuTucLocalService congChuc2NhomThuTucLocalService) {
		_congChuc2NhomThuTucLocalService = congChuc2NhomThuTucLocalService;
	}

	public CongChuc2NhomThuTucLocalService getWrappedService() {
		return _congChuc2NhomThuTucLocalService;
	}

	public void setWrappedService(
		CongChuc2NhomThuTucLocalService congChuc2NhomThuTucLocalService) {
		_congChuc2NhomThuTucLocalService = congChuc2NhomThuTucLocalService;
	}

	private CongChuc2NhomThuTucLocalService _congChuc2NhomThuTucLocalService;
}