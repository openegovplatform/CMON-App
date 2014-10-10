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

package org.oep.cmon.dao.hosolienthong.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoLienThongLocalService}.
 * </p>
 *
 * @author    hoangtrung.nguyen
 * @see       HoSoLienThongLocalService
 * @generated
 */
public class HoSoLienThongLocalServiceWrapper
	implements HoSoLienThongLocalService,
		ServiceWrapper<HoSoLienThongLocalService> {
	public HoSoLienThongLocalServiceWrapper(
		HoSoLienThongLocalService hoSoLienThongLocalService) {
		_hoSoLienThongLocalService = hoSoLienThongLocalService;
	}

	/**
	* Adds the ho so lien thong to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @return the ho so lien thong that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong addHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.addHoSoLienThong(hoSoLienThong);
	}

	/**
	* Creates a new ho so lien thong with the primary key. Does not add the ho so lien thong to the database.
	*
	* @param id the primary key for the new ho so lien thong
	* @return the new ho so lien thong
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong createHoSoLienThong(
		long id) {
		return _hoSoLienThongLocalService.createHoSoLienThong(id);
	}

	/**
	* Deletes the ho so lien thong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so lien thong
	* @throws PortalException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoLienThong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_hoSoLienThongLocalService.deleteHoSoLienThong(id);
	}

	/**
	* Deletes the ho so lien thong from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoLienThongLocalService.deleteHoSoLienThong(hoSoLienThong);
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
		return _hoSoLienThongLocalService.dynamicQuery(dynamicQuery);
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
		return _hoSoLienThongLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _hoSoLienThongLocalService.dynamicQuery(dynamicQuery, start,
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
		return _hoSoLienThongLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchHoSoLienThong(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.fetchHoSoLienThong(id);
	}

	/**
	* Returns the ho so lien thong with the primary key.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong
	* @throws PortalException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong getHoSoLienThong(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.getHoSoLienThong(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ho so lien thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @return the range of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> getHoSoLienThongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.getHoSoLienThongs(start, end);
	}

	/**
	* Returns the number of ho so lien thongs.
	*
	* @return the number of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public int getHoSoLienThongsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.getHoSoLienThongsCount();
	}

	/**
	* Updates the ho so lien thong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @return the ho so lien thong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.updateHoSoLienThong(hoSoLienThong);
	}

	/**
	* Updates the ho so lien thong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoLienThong the ho so lien thong
	* @param merge whether to merge the ho so lien thong with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so lien thong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.updateHoSoLienThong(hoSoLienThong,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _hoSoLienThongLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hoSoLienThongLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion countByMaSoBienNhanLucGui
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoBienNhanLucGui
	* @return int
	*/
	public int countByMaSoBienNhanLucGui(java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.countByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* This is fucntion fetchByMaSoBienNhanLucGui
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoBienNhanLucGui
	* @return HoSoLienThong
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* This is fucntion countByHoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId
	* @return int
	*/
	public int countByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.countByHoSoId(hoSoId);
	}

	/**
	* This is fucntion fetchByHoSoIdAndThuTuLienThong
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId, int thuTu
	* @return HoSoLienThong
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByHoSoIdAndThuTuLienThong(
		long hoSoId, int thuTu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.fetchByHoSoIdAndThuTuLienThong(hoSoId,
			thuTu);
	}

	/**
	* This is fucntion findByHoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId
	* @return List<HoSoLienThong>
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId) throws com.liferay.portal.kernel.exception.SystemException {
		return _hoSoLienThongLocalService.findByHoSoId(hoSoId);
	}

	/**
	* This is fucntion searchHoSoNoiNhan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param PortletRequest request, CongChuc canBoNoiNhan, long[] thuTucNhanIds
	* @return QueryResult<HoSoLienThong>
	*/
	public org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiNhan(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiNhan, long[] thuTucNhanIds) {
		return _hoSoLienThongLocalService.searchHoSoNoiNhan(request,
			canBoNoiNhan, thuTucNhanIds);
	}

	/**
	* This is fucntion searchHoSoNoiGui
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param PortletRequest request, CongChuc canBoNoiGui, long[] thuTucGuiIds
	* @return QueryResult<HoSoLienThong>
	*/
	public org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiGui(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiGui, long[] thuTucGuiIds) {
		return _hoSoLienThongLocalService.searchHoSoNoiGui(request,
			canBoNoiGui, thuTucGuiIds);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public HoSoLienThongLocalService getWrappedHoSoLienThongLocalService() {
		return _hoSoLienThongLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedHoSoLienThongLocalService(
		HoSoLienThongLocalService hoSoLienThongLocalService) {
		_hoSoLienThongLocalService = hoSoLienThongLocalService;
	}

	public HoSoLienThongLocalService getWrappedService() {
		return _hoSoLienThongLocalService;
	}

	public void setWrappedService(
		HoSoLienThongLocalService hoSoLienThongLocalService) {
		_hoSoLienThongLocalService = hoSoLienThongLocalService;
	}

	private HoSoLienThongLocalService _hoSoLienThongLocalService;
}