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

package org.oep.cmon.dao.qlhc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CoQuanQuanLyLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CoQuanQuanLyLocalService
 * @generated
 */
public class CoQuanQuanLyLocalServiceWrapper implements CoQuanQuanLyLocalService,
	ServiceWrapper<CoQuanQuanLyLocalService> {
	public CoQuanQuanLyLocalServiceWrapper(
		CoQuanQuanLyLocalService coQuanQuanLyLocalService) {
		_coQuanQuanLyLocalService = coQuanQuanLyLocalService;
	}

	/**
	* Adds the co quan quan ly to the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @return the co quan quan ly that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy addCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.addCoQuanQuanLy(coQuanQuanLy);
	}

	/**
	* Creates a new co quan quan ly with the primary key. Does not add the co quan quan ly to the database.
	*
	* @param id the primary key for the new co quan quan ly
	* @return the new co quan quan ly
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy createCoQuanQuanLy(long id) {
		return _coQuanQuanLyLocalService.createCoQuanQuanLy(id);
	}

	/**
	* Deletes the co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan quan ly
	* @throws PortalException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_coQuanQuanLyLocalService.deleteCoQuanQuanLy(id);
	}

	/**
	* Deletes the co quan quan ly from the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		_coQuanQuanLyLocalService.deleteCoQuanQuanLy(coQuanQuanLy);
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
		return _coQuanQuanLyLocalService.dynamicQuery(dynamicQuery);
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
		return _coQuanQuanLyLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _coQuanQuanLyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _coQuanQuanLyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy fetchCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.fetchCoQuanQuanLy(id);
	}

	/**
	* Returns the co quan quan ly with the primary key.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly
	* @throws PortalException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy getCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.getCoQuanQuanLy(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.getCoQuanQuanLies(start, end);
	}

	/**
	* Returns the number of co quan quan lies.
	*
	* @return the number of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int getCoQuanQuanLiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.getCoQuanQuanLiesCount();
	}

	/**
	* Updates the co quan quan ly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @return the co quan quan ly that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.updateCoQuanQuanLy(coQuanQuanLy);
	}

	/**
	* Updates the co quan quan ly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanQuanLy the co quan quan ly
	* @param merge whether to merge the co quan quan ly with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the co quan quan ly that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.updateCoQuanQuanLy(coQuanQuanLy, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _coQuanQuanLyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_coQuanQuanLyLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findByMa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String ma
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return _coQuanQuanLyLocalService.findByMa(ma);
	}

	/**
	* This is fucntion getDSPhongBanNoiBo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long chaId
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSPhongBanNoiBo(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanQuanLyLocalService.getDSPhongBanNoiBo(chaId);
	}

	/**
	* This is fucntion findByParentId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long chaId, int daXoa
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByParentId(
		java.lang.Long chaId, int daXoa) {
		return _coQuanQuanLyLocalService.findByParentId(chaId, daXoa);
	}

	/**
	* This is fucntion findByCapCoQuanQuanLyId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long capCoQuanQuanlyId,int daXoa
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLyId(
		java.lang.Long capCoQuanQuanlyId, int daXoa) {
		return _coQuanQuanLyLocalService.findByCapCoQuanQuanLyId(capCoQuanQuanlyId,
			daXoa);
	}

	/**
	* This is fucntion getDSCoQuanQuanlyByMaOrTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maOrTen,int start, int end
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSCoQuanQuanlyByMaOrTen(
		java.lang.String maOrTen, int start, int end) {
		return _coQuanQuanLyLocalService.getDSCoQuanQuanlyByMaOrTen(maOrTen,
			start, end);
	}

	/**
	* This is fucntion countDSCoQuanQuanlyByMaOrTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maOrTen
	* @return int
	*/
	public int countDSCoQuanQuanlyByMaOrTen(java.lang.String maOrTen) {
		return _coQuanQuanLyLocalService.countDSCoQuanQuanlyByMaOrTen(maOrTen);
	}

	/**
	* This is fucntion findByAllDonViHanhChinhId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long donviHanhChinhId,int typeSelect, int daXoa
	* @return List<CoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByAllDonViHanhChinhId(
		java.lang.Long donviHanhChinhId, int typeSelect, int daXoa) {
		return _coQuanQuanLyLocalService.findByAllDonViHanhChinhId(donviHanhChinhId,
			typeSelect, daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CoQuanQuanLyLocalService getWrappedCoQuanQuanLyLocalService() {
		return _coQuanQuanLyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCoQuanQuanLyLocalService(
		CoQuanQuanLyLocalService coQuanQuanLyLocalService) {
		_coQuanQuanLyLocalService = coQuanQuanLyLocalService;
	}

	public CoQuanQuanLyLocalService getWrappedService() {
		return _coQuanQuanLyLocalService;
	}

	public void setWrappedService(
		CoQuanQuanLyLocalService coQuanQuanLyLocalService) {
		_coQuanQuanLyLocalService = coQuanQuanLyLocalService;
	}

	private CoQuanQuanLyLocalService _coQuanQuanLyLocalService;
}