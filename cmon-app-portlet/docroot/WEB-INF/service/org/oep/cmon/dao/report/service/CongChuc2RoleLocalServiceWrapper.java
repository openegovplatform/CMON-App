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
 * This class is a wrapper for {@link CongChuc2RoleLocalService}.
 * </p>
 *
 * @author    VIENPN
 * @see       CongChuc2RoleLocalService
 * @generated
 */
public class CongChuc2RoleLocalServiceWrapper
	implements CongChuc2RoleLocalService,
		ServiceWrapper<CongChuc2RoleLocalService> {
	public CongChuc2RoleLocalServiceWrapper(
		CongChuc2RoleLocalService congChuc2RoleLocalService) {
		_congChuc2RoleLocalService = congChuc2RoleLocalService;
	}

	/**
	* Adds the cong chuc2 role to the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @return the cong chuc2 role that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role addCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.addCongChuc2Role(congChuc2Role);
	}

	/**
	* Creates a new cong chuc2 role with the primary key. Does not add the cong chuc2 role to the database.
	*
	* @param ID the primary key for the new cong chuc2 role
	* @return the new cong chuc2 role
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role createCongChuc2Role(
		long ID) {
		return _congChuc2RoleLocalService.createCongChuc2Role(ID);
	}

	/**
	* Deletes the cong chuc2 role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the cong chuc2 role
	* @throws PortalException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongChuc2Role(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_congChuc2RoleLocalService.deleteCongChuc2Role(ID);
	}

	/**
	* Deletes the cong chuc2 role from the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role)
		throws com.liferay.portal.kernel.exception.SystemException {
		_congChuc2RoleLocalService.deleteCongChuc2Role(congChuc2Role);
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
		return _congChuc2RoleLocalService.dynamicQuery(dynamicQuery);
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
		return _congChuc2RoleLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _congChuc2RoleLocalService.dynamicQuery(dynamicQuery, start,
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
		return _congChuc2RoleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.report.model.CongChuc2Role fetchCongChuc2Role(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.fetchCongChuc2Role(ID);
	}

	/**
	* Returns the cong chuc2 role with the primary key.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role
	* @throws PortalException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role getCongChuc2Role(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.getCongChuc2Role(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cong chuc2 roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 roles
	* @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	* @return the range of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> getCongChuc2Roles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.getCongChuc2Roles(start, end);
	}

	/**
	* Returns the number of cong chuc2 roles.
	*
	* @return the number of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public int getCongChuc2RolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.getCongChuc2RolesCount();
	}

	/**
	* Updates the cong chuc2 role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @return the cong chuc2 role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role updateCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.updateCongChuc2Role(congChuc2Role);
	}

	/**
	* Updates the cong chuc2 role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc2Role the cong chuc2 role
	* @param merge whether to merge the cong chuc2 role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong chuc2 role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role updateCongChuc2Role(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congChuc2RoleLocalService.updateCongChuc2Role(congChuc2Role,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _congChuc2RoleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_congChuc2RoleLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion getDanhsachbaocao
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id
	* @return List<DanhMucBaoCao>
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> getDanhsachbaocao(
		long user_id) throws java.lang.Exception {
		return _congChuc2RoleLocalService.getDanhsachbaocao(user_id);
	}

	/**
	* This is fucntion getCoQuanQuanLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id,long baocao_id
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLy(
		long user_id, long baocao_id) throws java.lang.Exception {
		return _congChuc2RoleLocalService.getCoQuanQuanLy(user_id, baocao_id);
	}

	/**
	* This is fucntion getNhomTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id,long baocao_id,long donvi_id
	* @return List<NhomThuTucHanhChinh>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> getNhomTTHC(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception {
		return _congChuc2RoleLocalService.getNhomTTHC(user_id, baocao_id,
			donvi_id);
	}

	/**
	* This is fucntion testReportPermission
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long user_id,long baocao_id
	* @return Boolean
	*/
	public java.lang.Boolean testReportPermission(long user_id, long baocao_id)
		throws java.lang.Exception {
		return _congChuc2RoleLocalService.testReportPermission(user_id,
			baocao_id);
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
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThutuchanhchinh(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception {
		return _congChuc2RoleLocalService.getThutuchanhchinh(user_id,
			baocao_id, donvi_id);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CongChuc2RoleLocalService getWrappedCongChuc2RoleLocalService() {
		return _congChuc2RoleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCongChuc2RoleLocalService(
		CongChuc2RoleLocalService congChuc2RoleLocalService) {
		_congChuc2RoleLocalService = congChuc2RoleLocalService;
	}

	public CongChuc2RoleLocalService getWrappedService() {
		return _congChuc2RoleLocalService;
	}

	public void setWrappedService(
		CongChuc2RoleLocalService congChuc2RoleLocalService) {
		_congChuc2RoleLocalService = congChuc2RoleLocalService;
	}

	private CongChuc2RoleLocalService _congChuc2RoleLocalService;
}