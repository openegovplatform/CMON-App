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

package org.oep.cmon.dao.chungthuc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ThanhPhanHoSoChungThucLocalService}.
 * </p>
 *
 * @author    vietho
 * @see       ThanhPhanHoSoChungThucLocalService
 * @generated
 */
public class ThanhPhanHoSoChungThucLocalServiceWrapper
	implements ThanhPhanHoSoChungThucLocalService,
		ServiceWrapper<ThanhPhanHoSoChungThucLocalService> {
	public ThanhPhanHoSoChungThucLocalServiceWrapper(
		ThanhPhanHoSoChungThucLocalService thanhPhanHoSoChungThucLocalService) {
		_thanhPhanHoSoChungThucLocalService = thanhPhanHoSoChungThucLocalService;
	}

	/**
	* Adds the thanh phan ho so chung thuc to the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc addThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.addThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc);
	}

	/**
	* Creates a new thanh phan ho so chung thuc with the primary key. Does not add the thanh phan ho so chung thuc to the database.
	*
	* @param thanhPhanHoSoId the primary key for the new thanh phan ho so chung thuc
	* @return the new thanh phan ho so chung thuc
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc createThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId) {
		return _thanhPhanHoSoChungThucLocalService.createThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	/**
	* Deletes the thanh phan ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @throws PortalException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThanhPhanHoSoChungThuc(long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_thanhPhanHoSoChungThucLocalService.deleteThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	/**
	* Deletes the thanh phan ho so chung thuc from the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		_thanhPhanHoSoChungThucLocalService.deleteThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc);
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
		return _thanhPhanHoSoChungThucLocalService.dynamicQuery(dynamicQuery);
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
		return _thanhPhanHoSoChungThucLocalService.dynamicQuery(dynamicQuery,
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
		return _thanhPhanHoSoChungThucLocalService.dynamicQuery(dynamicQuery,
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
		return _thanhPhanHoSoChungThucLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc fetchThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.fetchThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	/**
	* Returns the thanh phan ho so chung thuc with the primary key.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc
	* @throws PortalException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc getThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.getThanhPhanHoSoChungThuc(thanhPhanHoSoId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the thanh phan ho so chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thanh phan ho so chung thucs
	* @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	* @return the range of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.getThanhPhanHoSoChungThucs(start,
			end);
	}

	/**
	* Returns the number of thanh phan ho so chung thucs.
	*
	* @return the number of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public int getThanhPhanHoSoChungThucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.getThanhPhanHoSoChungThucsCount();
	}

	/**
	* Updates the thanh phan ho so chung thuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.updateThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc);
	}

	/**
	* Updates the thanh phan ho so chung thuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	* @param merge whether to merge the thanh phan ho so chung thuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the thanh phan ho so chung thuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.updateThanhPhanHoSoChungThuc(thanhPhanHoSoChungThuc,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _thanhPhanHoSoChungThucLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_thanhPhanHoSoChungThucLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion get ThanhPhanHoSoChungThuc by hoSoChungThucId and paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoChungThucId, int start, int end
	* @return List<ThanhPhanHoSoChungThuc>
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucListBy(
		long hoSoChungThucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thanhPhanHoSoChungThucLocalService.getThanhPhanHoSoChungThucListBy(hoSoChungThucId,
			start, end);
	}

	/**
	* This is fucntion remove ThanhPhanHoSoChungThuc by hsctId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hsctId
	* @return void
	*/
	public void removeThanhPhanHoSoByHSChungThucId(long hsctId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_thanhPhanHoSoChungThucLocalService.removeThanhPhanHoSoByHSChungThucId(hsctId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ThanhPhanHoSoChungThucLocalService getWrappedThanhPhanHoSoChungThucLocalService() {
		return _thanhPhanHoSoChungThucLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedThanhPhanHoSoChungThucLocalService(
		ThanhPhanHoSoChungThucLocalService thanhPhanHoSoChungThucLocalService) {
		_thanhPhanHoSoChungThucLocalService = thanhPhanHoSoChungThucLocalService;
	}

	public ThanhPhanHoSoChungThucLocalService getWrappedService() {
		return _thanhPhanHoSoChungThucLocalService;
	}

	public void setWrappedService(
		ThanhPhanHoSoChungThucLocalService thanhPhanHoSoChungThucLocalService) {
		_thanhPhanHoSoChungThucLocalService = thanhPhanHoSoChungThucLocalService;
	}

	private ThanhPhanHoSoChungThucLocalService _thanhPhanHoSoChungThucLocalService;
}