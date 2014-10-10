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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the cap co quan quan ly local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see CapCoQuanQuanLyLocalServiceUtil
 * @see org.oep.cmon.dao.qlhc.service.base.CapCoQuanQuanLyLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.impl.CapCoQuanQuanLyLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CapCoQuanQuanLyLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CapCoQuanQuanLyLocalServiceUtil} to access the cap co quan quan ly local service. Add custom service methods to {@link org.oep.cmon.dao.qlhc.service.impl.CapCoQuanQuanLyLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the cap co quan quan ly to the database. Also notifies the appropriate model listeners.
	*
	* @param capCoQuanQuanLy the cap co quan quan ly
	* @return the cap co quan quan ly that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy addCapCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new cap co quan quan ly with the primary key. Does not add the cap co quan quan ly to the database.
	*
	* @param id the primary key for the new cap co quan quan ly
	* @return the new cap co quan quan ly
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy createCapCoQuanQuanLy(
		long id);

	/**
	* Deletes the cap co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap co quan quan ly
	* @throws PortalException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCapCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the cap co quan quan ly from the database. Also notifies the appropriate model listeners.
	*
	* @param capCoQuanQuanLy the cap co quan quan ly
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCapCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy)
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
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy fetchCapCoQuanQuanLy(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cap co quan quan ly with the primary key.
	*
	* @param id the primary key of the cap co quan quan ly
	* @return the cap co quan quan ly
	* @throws PortalException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy getCapCoQuanQuanLy(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @return the range of cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getCapCoQuanQuanLies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap co quan quan lies.
	*
	* @return the number of cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCapCoQuanQuanLiesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cap co quan quan ly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capCoQuanQuanLy the cap co quan quan ly
	* @return the cap co quan quan ly that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy updateCapCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cap co quan quan ly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capCoQuanQuanLy the cap co quan quan ly
	* @param merge whether to merge the cap co quan quan ly with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cap co quan quan ly that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy updateCapCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy,
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
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;

	/**
	* This is fucntion findByTrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<CapCoQuanQuanLy>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;
}