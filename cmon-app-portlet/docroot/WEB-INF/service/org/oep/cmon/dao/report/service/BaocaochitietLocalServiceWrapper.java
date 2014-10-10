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
 * This class is a wrapper for {@link BaocaochitietLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       BaocaochitietLocalService
 * @generated
 */
public class BaocaochitietLocalServiceWrapper
	implements BaocaochitietLocalService,
		ServiceWrapper<BaocaochitietLocalService> {
	public BaocaochitietLocalServiceWrapper(
		BaocaochitietLocalService baocaochitietLocalService) {
		_baocaochitietLocalService = baocaochitietLocalService;
	}

	/**
	* Adds the baocaochitiet to the database. Also notifies the appropriate model listeners.
	*
	* @param baocaochitiet the baocaochitiet
	* @return the baocaochitiet that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet addBaocaochitiet(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.addBaocaochitiet(baocaochitiet);
	}

	/**
	* Creates a new baocaochitiet with the primary key. Does not add the baocaochitiet to the database.
	*
	* @param MASOHOSO the primary key for the new baocaochitiet
	* @return the new baocaochitiet
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet createBaocaochitiet(
		java.lang.String MASOHOSO) {
		return _baocaochitietLocalService.createBaocaochitiet(MASOHOSO);
	}

	/**
	* Deletes the baocaochitiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @throws PortalException if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBaocaochitiet(java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_baocaochitietLocalService.deleteBaocaochitiet(MASOHOSO);
	}

	/**
	* Deletes the baocaochitiet from the database. Also notifies the appropriate model listeners.
	*
	* @param baocaochitiet the baocaochitiet
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBaocaochitiet(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		_baocaochitietLocalService.deleteBaocaochitiet(baocaochitiet);
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
		return _baocaochitietLocalService.dynamicQuery(dynamicQuery);
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
		return _baocaochitietLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _baocaochitietLocalService.dynamicQuery(dynamicQuery, start,
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
		return _baocaochitietLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.Baocaochitiet fetchBaocaochitiet(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.fetchBaocaochitiet(MASOHOSO);
	}

	/**
	* Returns the baocaochitiet with the primary key.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet
	* @throws PortalException if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet getBaocaochitiet(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.getBaocaochitiet(MASOHOSO);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the baocaochitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of baocaochitiets
	* @param end the upper bound of the range of baocaochitiets (not inclusive)
	* @return the range of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> getBaocaochitiets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.getBaocaochitiets(start, end);
	}

	/**
	* Returns the number of baocaochitiets.
	*
	* @return the number of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public int getBaocaochitietsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.getBaocaochitietsCount();
	}

	/**
	* Updates the baocaochitiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param baocaochitiet the baocaochitiet
	* @return the baocaochitiet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet updateBaocaochitiet(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.updateBaocaochitiet(baocaochitiet);
	}

	/**
	* Updates the baocaochitiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param baocaochitiet the baocaochitiet
	* @param merge whether to merge the baocaochitiet with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the baocaochitiet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet updateBaocaochitiet(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baocaochitietLocalService.updateBaocaochitiet(baocaochitiet,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _baocaochitietLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_baocaochitietLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion hienthiDanhsachBaocao
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String[] listloaihoso, String ngaynhan_tungay, String ngaynhan_denngay, String trangthai, String tinhtrang, String loaidangky, int start, int end
	* @return List<Baocaochitiet>
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> hienthiDanhsachBaocao(
		java.lang.String[] listloaihoso, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay, java.lang.String trangthai,
		java.lang.String tinhtrang, java.lang.String loaidangky, int start,
		int end) {
		return _baocaochitietLocalService.hienthiDanhsachBaocao(listloaihoso,
			ngaynhan_tungay, ngaynhan_denngay, trangthai, tinhtrang,
			loaidangky, start, end);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BaocaochitietLocalService getWrappedBaocaochitietLocalService() {
		return _baocaochitietLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBaocaochitietLocalService(
		BaocaochitietLocalService baocaochitietLocalService) {
		_baocaochitietLocalService = baocaochitietLocalService;
	}

	public BaocaochitietLocalService getWrappedService() {
		return _baocaochitietLocalService;
	}

	public void setWrappedService(
		BaocaochitietLocalService baocaochitietLocalService) {
		_baocaochitietLocalService = baocaochitietLocalService;
	}

	private BaocaochitietLocalService _baocaochitietLocalService;
}