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

package org.oep.cmon.dao.dn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NganhNgheKinhDoanhLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       NganhNgheKinhDoanhLocalService
 * @generated
 */
public class NganhNgheKinhDoanhLocalServiceWrapper
	implements NganhNgheKinhDoanhLocalService,
		ServiceWrapper<NganhNgheKinhDoanhLocalService> {
	public NganhNgheKinhDoanhLocalServiceWrapper(
		NganhNgheKinhDoanhLocalService nganhNgheKinhDoanhLocalService) {
		_nganhNgheKinhDoanhLocalService = nganhNgheKinhDoanhLocalService;
	}

	/**
	* Adds the nganh nghe kinh doanh to the database. Also notifies the appropriate model listeners.
	*
	* @param nganhNgheKinhDoanh the nganh nghe kinh doanh
	* @return the nganh nghe kinh doanh that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh addNganhNgheKinhDoanh(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.addNganhNgheKinhDoanh(nganhNgheKinhDoanh);
	}

	/**
	* Creates a new nganh nghe kinh doanh with the primary key. Does not add the nganh nghe kinh doanh to the database.
	*
	* @param id the primary key for the new nganh nghe kinh doanh
	* @return the new nganh nghe kinh doanh
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh createNganhNgheKinhDoanh(
		long id) {
		return _nganhNgheKinhDoanhLocalService.createNganhNgheKinhDoanh(id);
	}

	/**
	* Deletes the nganh nghe kinh doanh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nganh nghe kinh doanh
	* @throws PortalException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNganhNgheKinhDoanh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_nganhNgheKinhDoanhLocalService.deleteNganhNgheKinhDoanh(id);
	}

	/**
	* Deletes the nganh nghe kinh doanh from the database. Also notifies the appropriate model listeners.
	*
	* @param nganhNgheKinhDoanh the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNganhNgheKinhDoanh(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh)
		throws com.liferay.portal.kernel.exception.SystemException {
		_nganhNgheKinhDoanhLocalService.deleteNganhNgheKinhDoanh(nganhNgheKinhDoanh);
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
		return _nganhNgheKinhDoanhLocalService.dynamicQuery(dynamicQuery);
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
		return _nganhNgheKinhDoanhLocalService.dynamicQuery(dynamicQuery,
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
		return _nganhNgheKinhDoanhLocalService.dynamicQuery(dynamicQuery,
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
		return _nganhNgheKinhDoanhLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh fetchNganhNgheKinhDoanh(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.fetchNganhNgheKinhDoanh(id);
	}

	/**
	* Returns the nganh nghe kinh doanh with the primary key.
	*
	* @param id the primary key of the nganh nghe kinh doanh
	* @return the nganh nghe kinh doanh
	* @throws PortalException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh getNganhNgheKinhDoanh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.getNganhNgheKinhDoanh(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the nganh nghe kinh doanhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @return the range of nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> getNganhNgheKinhDoanhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.getNganhNgheKinhDoanhs(start, end);
	}

	/**
	* Returns the number of nganh nghe kinh doanhs.
	*
	* @return the number of nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public int getNganhNgheKinhDoanhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.getNganhNgheKinhDoanhsCount();
	}

	/**
	* Updates the nganh nghe kinh doanh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nganhNgheKinhDoanh the nganh nghe kinh doanh
	* @return the nganh nghe kinh doanh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh updateNganhNgheKinhDoanh(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.updateNganhNgheKinhDoanh(nganhNgheKinhDoanh);
	}

	/**
	* Updates the nganh nghe kinh doanh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nganhNgheKinhDoanh the nganh nghe kinh doanh
	* @param merge whether to merge the nganh nghe kinh doanh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the nganh nghe kinh doanh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh updateNganhNgheKinhDoanh(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.updateNganhNgheKinhDoanh(nganhNgheKinhDoanh,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _nganhNgheKinhDoanhLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nganhNgheKinhDoanhLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion find NganhNgheKinhDoanh by Cap va trang thai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long cap, int daXoa
	* @return List<NganhNgheKinhDoanh>
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByCap(
		long cap, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nganhNgheKinhDoanhLocalService.findByCap(cap, daXoa);
	}

	/**
	* This is fucntion find NganhNgheKinhDoanh by code
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String code,int daxoa
	* @return NganhNgheKinhDoanh
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByCode(
		java.lang.String code, int daxoa) {
		return _nganhNgheKinhDoanhLocalService.findByCode(code, daxoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NganhNgheKinhDoanhLocalService getWrappedNganhNgheKinhDoanhLocalService() {
		return _nganhNgheKinhDoanhLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNganhNgheKinhDoanhLocalService(
		NganhNgheKinhDoanhLocalService nganhNgheKinhDoanhLocalService) {
		_nganhNgheKinhDoanhLocalService = nganhNgheKinhDoanhLocalService;
	}

	public NganhNgheKinhDoanhLocalService getWrappedService() {
		return _nganhNgheKinhDoanhLocalService;
	}

	public void setWrappedService(
		NganhNgheKinhDoanhLocalService nganhNgheKinhDoanhLocalService) {
		_nganhNgheKinhDoanhLocalService = nganhNgheKinhDoanhLocalService;
	}

	private NganhNgheKinhDoanhLocalService _nganhNgheKinhDoanhLocalService;
}