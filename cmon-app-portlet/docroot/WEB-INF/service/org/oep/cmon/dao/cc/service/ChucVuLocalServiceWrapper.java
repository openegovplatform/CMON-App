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
 * This class is a wrapper for {@link ChucVuLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       ChucVuLocalService
 * @generated
 */
public class ChucVuLocalServiceWrapper implements ChucVuLocalService,
	ServiceWrapper<ChucVuLocalService> {
	public ChucVuLocalServiceWrapper(ChucVuLocalService chucVuLocalService) {
		_chucVuLocalService = chucVuLocalService;
	}

	/**
	* Adds the chuc vu to the database. Also notifies the appropriate model listeners.
	*
	* @param chucVu the chuc vu
	* @return the chuc vu that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu addChucVu(
		org.oep.cmon.dao.cc.model.ChucVu chucVu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.addChucVu(chucVu);
	}

	/**
	* Creates a new chuc vu with the primary key. Does not add the chuc vu to the database.
	*
	* @param id the primary key for the new chuc vu
	* @return the new chuc vu
	*/
	public org.oep.cmon.dao.cc.model.ChucVu createChucVu(long id) {
		return _chucVuLocalService.createChucVu(id);
	}

	/**
	* Deletes the chuc vu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuc vu
	* @throws PortalException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChucVu(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_chucVuLocalService.deleteChucVu(id);
	}

	/**
	* Deletes the chuc vu from the database. Also notifies the appropriate model listeners.
	*
	* @param chucVu the chuc vu
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChucVu(org.oep.cmon.dao.cc.model.ChucVu chucVu)
		throws com.liferay.portal.kernel.exception.SystemException {
		_chucVuLocalService.deleteChucVu(chucVu);
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
		return _chucVuLocalService.dynamicQuery(dynamicQuery);
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
		return _chucVuLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _chucVuLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _chucVuLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.cc.model.ChucVu fetchChucVu(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.fetchChucVu(id);
	}

	/**
	* Returns the chuc vu with the primary key.
	*
	* @param id the primary key of the chuc vu
	* @return the chuc vu
	* @throws PortalException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu getChucVu(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.getChucVu(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chuc vus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @return the range of chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> getChucVus(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.getChucVus(start, end);
	}

	/**
	* Returns the number of chuc vus.
	*
	* @return the number of chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public int getChucVusCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.getChucVusCount();
	}

	/**
	* Updates the chuc vu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chucVu the chuc vu
	* @return the chuc vu that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu updateChucVu(
		org.oep.cmon.dao.cc.model.ChucVu chucVu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.updateChucVu(chucVu);
	}

	/**
	* Updates the chuc vu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chucVu the chuc vu
	* @param merge whether to merge the chuc vu with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chuc vu that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu updateChucVu(
		org.oep.cmon.dao.cc.model.ChucVu chucVu, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.updateChucVu(chucVu, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _chucVuLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_chucVuLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion find ChucVu by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return List<ChucVu>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.findMa(ma);
	}

	/**
	* This is fucntion find ChucVu by Ten
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ten
	* @return List<ChucVu>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.findTen(ten);
	}

	/**
	* This is fucntion find ChucVu by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int : value of TrangThai
	* @return List<ChucVu>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return _chucVuLocalService.findTrangThai(daXoa);
	}

	/**
	* This is fucntion find ChucVu by CoQuanQuanLy va TrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long: value of coQuanQuanLyId ; long : value of TrangThai
	* @return List<ChucVu>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByCoQuanQuanLy(
		long coQuanQuanLyId, long daXoa) {
		return _chucVuLocalService.findByCoQuanQuanLy(coQuanQuanLyId, daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ChucVuLocalService getWrappedChucVuLocalService() {
		return _chucVuLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedChucVuLocalService(
		ChucVuLocalService chucVuLocalService) {
		_chucVuLocalService = chucVuLocalService;
	}

	public ChucVuLocalService getWrappedService() {
		return _chucVuLocalService;
	}

	public void setWrappedService(ChucVuLocalService chucVuLocalService) {
		_chucVuLocalService = chucVuLocalService;
	}

	private ChucVuLocalService _chucVuLocalService;
}