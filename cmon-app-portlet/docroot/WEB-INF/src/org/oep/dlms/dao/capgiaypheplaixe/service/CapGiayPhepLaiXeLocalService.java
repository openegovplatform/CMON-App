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

package org.oep.dlms.dao.capgiaypheplaixe.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the cap giay phep lai xe local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhNT
 * @see CapGiayPhepLaiXeLocalServiceUtil
 * @see org.oep.dlms.dao.capgiaypheplaixe.service.base.CapGiayPhepLaiXeLocalServiceBaseImpl
 * @see org.oep.dlms.dao.capgiaypheplaixe.service.impl.CapGiayPhepLaiXeLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CapGiayPhepLaiXeLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CapGiayPhepLaiXeLocalServiceUtil} to access the cap giay phep lai xe local service. Add custom service methods to {@link vn.dtt.dlms.dao.capgiaypheplaixe.service.impl.CapGiayPhepLaiXeLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the cap giay phep lai xe to the database. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @return the cap giay phep lai xe that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe addCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new cap giay phep lai xe with the primary key. Does not add the cap giay phep lai xe to the database.
	*
	* @param id the primary key for the new cap giay phep lai xe
	* @return the new cap giay phep lai xe
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe createCapGiayPhepLaiXe(
		long id);

	/**
	* Deletes the cap giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @throws PortalException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCapGiayPhepLaiXe(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the cap giay phep lai xe from the database. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
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
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe fetchCapGiayPhepLaiXe(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cap giay phep lai xe with the primary key.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @return the cap giay phep lai xe
	* @throws PortalException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe getCapGiayPhepLaiXe(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap giay phep lai xes
	* @param end the upper bound of the range of cap giay phep lai xes (not inclusive)
	* @return the range of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> getCapGiayPhepLaiXes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap giay phep lai xes.
	*
	* @return the number of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCapGiayPhepLaiXesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cap giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @return the cap giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cap giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @param merge whether to merge the cap giay phep lai xe with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cap giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe,
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
}