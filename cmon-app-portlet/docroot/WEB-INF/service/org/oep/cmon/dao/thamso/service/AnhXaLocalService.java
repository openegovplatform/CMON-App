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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the anh xa local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see AnhXaLocalServiceUtil
 * @see org.oep.cmon.dao.thamso.service.base.AnhXaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.thamso.service.impl.AnhXaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnhXaLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnhXaLocalServiceUtil} to access the anh xa local service. Add custom service methods to {@link org.oep.cmon.dao.thamso.service.impl.AnhXaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the anh xa to the database. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @return the anh xa that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa addAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new anh xa with the primary key. Does not add the anh xa to the database.
	*
	* @param Id the primary key for the new anh xa
	* @return the new anh xa
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa createAnhXa(long Id);

	/**
	* Deletes the anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the anh xa
	* @throws PortalException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the anh xa from the database. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnhXa(org.oep.cmon.dao.thamso.model.AnhXa anhXa)
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
	public org.oep.cmon.dao.thamso.model.AnhXa fetchAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anh xa with the primary key.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa
	* @throws PortalException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.thamso.model.AnhXa getAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getAnhXas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh xas.
	*
	* @return the number of anh xas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnhXasCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the anh xa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anhXa the anh xa
	* @return the anh xa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa updateAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getMaById(java.lang.String table, java.lang.Long id);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.thamso.model.AnhXa getAnhXaByApp_Table_Code(
		java.lang.Long appId, java.lang.String table, java.lang.String code);

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		boolean deleteMapping);

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
		java.lang.String table);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> search(
		java.lang.String keyword, java.lang.Long appId, java.lang.String table,
		int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getDSBang();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang, long maUngDungId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacCQQL(
		java.lang.String maDNG, java.lang.String tenBang);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacTTHC(
		java.lang.String maDNG, java.lang.String tenBang);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacGPLX(
		java.lang.String maDNG, java.lang.String tenBang);
}