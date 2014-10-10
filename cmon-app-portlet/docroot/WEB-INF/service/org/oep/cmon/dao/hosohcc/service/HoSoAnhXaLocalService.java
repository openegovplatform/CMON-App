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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the ho so anh xa local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see HoSoAnhXaLocalServiceUtil
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoAnhXaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.HoSoAnhXaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface HoSoAnhXaLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoAnhXaLocalServiceUtil} to access the ho so anh xa local service. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoAnhXaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the ho so anh xa to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @return the ho so anh xa that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa addHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new ho so anh xa with the primary key. Does not add the ho so anh xa to the database.
	*
	* @param id the primary key for the new ho so anh xa
	* @return the new ho so anh xa
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa createHoSoAnhXa(long id);

	/**
	* Deletes the ho so anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so anh xa
	* @throws PortalException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoAnhXa(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the ho so anh xa from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchHoSoAnhXa(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so anh xa with the primary key.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa
	* @throws PortalException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa getHoSoAnhXa(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @return the range of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> getHoSoAnhXas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so anh xas.
	*
	* @return the number of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getHoSoAnhXasCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the ho so anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @return the ho so anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa updateHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the ho so anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoAnhXa the ho so anh xa
	* @param merge whether to merge the ho so anh xa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa updateHoSoAnhXa(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	/**
	* This is fucntion findById
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long id
	* @return HoSoAnhXa
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findById(long id);

	/**
	* This is fucntion findByHoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return HoSoAnhXa
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByHoSoTTHCCongId(
		long hoSoTTHCCongId);

	/**
	* This is fucntion findByMaHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maHoSo
	* @return List<HoSoAnhXa>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo);
}