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

package org.oep.exch.dao.hoso.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the exch file dinh kem local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NAM
 * @see ExchFileDinhKemLocalServiceUtil
 * @see org.oep.exch.dao.hoso.service.base.ExchFileDinhKemLocalServiceBaseImpl
 * @see org.oep.exch.dao.hoso.service.impl.ExchFileDinhKemLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ExchFileDinhKemLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExchFileDinhKemLocalServiceUtil} to access the exch file dinh kem local service. Add custom service methods to {@link org.oep.exch.dao.hoso.service.impl.ExchFileDinhKemLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the exch file dinh kem to the database. Also notifies the appropriate model listeners.
	*
	* @param exchFileDinhKem the exch file dinh kem
	* @return the exch file dinh kem that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem addExchFileDinhKem(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new exch file dinh kem with the primary key. Does not add the exch file dinh kem to the database.
	*
	* @param id the primary key for the new exch file dinh kem
	* @return the new exch file dinh kem
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem createExchFileDinhKem(
		long id);

	/**
	* Deletes the exch file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the exch file dinh kem
	* @throws PortalException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteExchFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the exch file dinh kem from the database. Also notifies the appropriate model listeners.
	*
	* @param exchFileDinhKem the exch file dinh kem
	* @throws SystemException if a system exception occurred
	*/
	public void deleteExchFileDinhKem(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem)
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
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem fetchExchFileDinhKem(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the exch file dinh kem with the primary key.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem
	* @throws PortalException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem getExchFileDinhKem(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the exch file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @return the range of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> getExchFileDinhKems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of exch file dinh kems.
	*
	* @return the number of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExchFileDinhKemsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the exch file dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param exchFileDinhKem the exch file dinh kem
	* @return the exch file dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem updateExchFileDinhKem(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the exch file dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param exchFileDinhKem the exch file dinh kem
	* @param merge whether to merge the exch file dinh kem with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the exch file dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem updateExchFileDinhKem(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem,
		boolean merge)
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
	* This is fucntion findByOnlineId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long onlineId
	* @return List<ExchFileDinhKem>
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long onlineId)
		throws com.liferay.portal.kernel.exception.SystemException;
}