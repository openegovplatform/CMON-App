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

package org.oep.cmon.dao.thamso.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AnhXaLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       AnhXaLocalService
 * @generated
 */
public class AnhXaLocalServiceWrapper implements AnhXaLocalService,
	ServiceWrapper<AnhXaLocalService> {
	public AnhXaLocalServiceWrapper(AnhXaLocalService anhXaLocalService) {
		_anhXaLocalService = anhXaLocalService;
	}

	/**
	* Adds the anh xa to the database. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @return the anh xa that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa addAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.addAnhXa(anhXa);
	}

	/**
	* Creates a new anh xa with the primary key. Does not add the anh xa to the database.
	*
	* @param Id the primary key for the new anh xa
	* @return the new anh xa
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa createAnhXa(long Id) {
		return _anhXaLocalService.createAnhXa(Id);
	}

	/**
	* Deletes the anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the anh xa
	* @throws PortalException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_anhXaLocalService.deleteAnhXa(Id);
	}

	/**
	* Deletes the anh xa from the database. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnhXa(org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		_anhXaLocalService.deleteAnhXa(anhXa);
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
		return _anhXaLocalService.dynamicQuery(dynamicQuery);
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
		return _anhXaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _anhXaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _anhXaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.thamso.model.AnhXa fetchAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.fetchAnhXa(Id);
	}

	/**
	* Returns the anh xa with the primary key.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa
	* @throws PortalException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa getAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.getAnhXa(Id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getAnhXas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.getAnhXas(start, end);
	}

	/**
	* Returns the number of anh xas.
	*
	* @return the number of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int getAnhXasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.getAnhXasCount();
	}

	/**
	* Updates the anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @return the anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa updateAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.updateAnhXa(anhXa);
	}

	/**
	* Updates the anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @param merge whether to merge the anh xa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa updateAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anhXaLocalService.updateAnhXa(anhXa, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _anhXaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_anhXaLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion getMaById
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String table,Long id
	* @return String
	*/
	public java.lang.String getMaById(java.lang.String table, java.lang.Long id) {
		return _anhXaLocalService.getMaById(table, id);
	}

	/**
	* This is fucntion getAnhXaByApp_Table_Code
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long appId,String table,String code
	* @return AnhXa
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa getAnhXaByApp_Table_Code(
		java.lang.Long appId, java.lang.String table, java.lang.String code) {
		return _anhXaLocalService.getAnhXaByApp_Table_Code(appId, table, code);
	}

	/**
	* This is fucntion synchronize
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long appId,String table,boolean overwriteAll
	* @return void
	*/
	public void synchronize(java.lang.Long appId, java.lang.String table,
		boolean overwriteAll)
		throws com.liferay.portal.kernel.exception.SystemException {
		_anhXaLocalService.synchronize(appId, table, overwriteAll);
	}

	/**
	* This is fucntion deleteMapping
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long appId,String table,boolean deleteMapping
	* @return boolean
	*/
	public boolean deleteMapping(java.lang.Long appId, java.lang.String table,
		boolean deleteMapping) {
		return _anhXaLocalService.deleteMapping(appId, table, deleteMapping);
	}

	/**
	* This is fucntion countSearch
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String keyword,Long appId,String table
	* @return long
	*/
	public long countSearch(java.lang.String keyword, java.lang.Long appId,
		java.lang.String table) {
		return _anhXaLocalService.countSearch(keyword, appId, table);
	}

	/**
	* This is fucntion search
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String keyword,Long appId,String table,int start,int end
	* @return List<AnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> search(
		java.lang.String keyword, java.lang.Long appId, java.lang.String table,
		int start, int end) {
		return _anhXaLocalService.search(keyword, appId, table, start, end);
	}

	/**
	* This is fucntion getDSBang
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<String>
	*/
	public java.util.List<java.lang.String> getDSBang() {
		return _anhXaLocalService.getDSBang();
	}

	/**
	* This is fucntion getMaKhacExCh
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maDNG, String tenBang
	* @return List<AnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang) {
		return _anhXaLocalService.getMaKhacExCh(maDNG, tenBang);
	}

	/**
	* This is fucntion getMaKhacExCh
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maDNG, String tenBang, long maUngDungId
	* @return List<AnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang, long maUngDungId) {
		return _anhXaLocalService.getMaKhacExCh(maDNG, tenBang, maUngDungId);
	}

	/**
	* This is fucntion getDNGFromMaKhacCQQL
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maDNG, String tenBang
	* @return List<AnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacCQQL(
		java.lang.String maDNG, java.lang.String tenBang) {
		return _anhXaLocalService.getDNGFromMaKhacCQQL(maDNG, tenBang);
	}

	/**
	* This is fucntion getDNGFromMaKhacTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maDNG, String tenBang
	* @return List<AnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacTTHC(
		java.lang.String maDNG, java.lang.String tenBang) {
		return _anhXaLocalService.getDNGFromMaKhacTTHC(maDNG, tenBang);
	}

	/**
	* This is fucntion getDNGFromMaKhacGPLX
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maDNG, String tenBang
	* @return List<AnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacGPLX(
		java.lang.String maDNG, java.lang.String tenBang) {
		return _anhXaLocalService.getDNGFromMaKhacGPLX(maDNG, tenBang);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AnhXaLocalService getWrappedAnhXaLocalService() {
		return _anhXaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAnhXaLocalService(AnhXaLocalService anhXaLocalService) {
		_anhXaLocalService = anhXaLocalService;
	}

	public AnhXaLocalService getWrappedService() {
		return _anhXaLocalService;
	}

	public void setWrappedService(AnhXaLocalService anhXaLocalService) {
		_anhXaLocalService = anhXaLocalService;
	}

	private AnhXaLocalService _anhXaLocalService;
}