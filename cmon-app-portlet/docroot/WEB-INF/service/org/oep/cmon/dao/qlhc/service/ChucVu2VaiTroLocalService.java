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
 * The interface for the chuc vu2 vai tro local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see ChucVu2VaiTroLocalServiceUtil
 * @see org.oep.cmon.dao.qlhc.service.base.ChucVu2VaiTroLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.impl.ChucVu2VaiTroLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ChucVu2VaiTroLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChucVu2VaiTroLocalServiceUtil} to access the chuc vu2 vai tro local service. Add custom service methods to {@link org.oep.cmon.dao.qlhc.service.impl.ChucVu2VaiTroLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the chuc vu2 vai tro to the database. Also notifies the appropriate model listeners.
	*
	* @param chucVu2VaiTro the chuc vu2 vai tro
	* @return the chuc vu2 vai tro that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro addChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new chuc vu2 vai tro with the primary key. Does not add the chuc vu2 vai tro to the database.
	*
	* @param id the primary key for the new chuc vu2 vai tro
	* @return the new chuc vu2 vai tro
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro createChucVu2VaiTro(
		long id);

	/**
	* Deletes the chuc vu2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @throws PortalException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChucVu2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the chuc vu2 vai tro from the database. Also notifies the appropriate model listeners.
	*
	* @param chucVu2VaiTro the chuc vu2 vai tro
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro)
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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchChucVu2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chuc vu2 vai tro with the primary key.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro
	* @throws PortalException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro getChucVu2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chuc vu2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> getChucVu2VaiTros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros.
	*
	* @return the number of chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getChucVu2VaiTrosCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the chuc vu2 vai tro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chucVu2VaiTro the chuc vu2 vai tro
	* @return the chuc vu2 vai tro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro updateChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the chuc vu2 vai tro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chucVu2VaiTro the chuc vu2 vai tro
	* @param merge whether to merge the chuc vu2 vai tro with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chuc vu2 vai tro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro updateChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro, boolean merge)
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
	* This is fucntion findByIdVaiTro
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long vaiTroId
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdVaiTro(
		long vaiTroId);

	/**
	* This is fucntion findByIdCoQuanQuanLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdCoQuanQuanLy(
		long coQuanQuanLyId);

	/**
	* This is fucntion findByIdChucVu
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long chucVuId
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdChucVu(
		long chucVuId);

	/**
	* This is fucntion findByIdVaiTroAndDaXoa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long vaiTroId, int daXoa
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdVaiTroAndDaXoa(
		long vaiTroId, int daXoa);

	/**
	* This is fucntion deleteByChucVuID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long chucVuId
	* @return void
	*/
	public void deleteByChucVuID(long chucVuId);

	/**
	* This is fucntion deleteByVaiTroID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long vaiTroId
	* @return void
	*/
	public void deleteByVaiTroID(long vaiTroId);

	/**
	* This is fucntion findChucVu2VaiTro
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long vaiTroId, long coQuanQuanLyId, long chucVuId
	* @return ChucVu2VaiTro
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findChucVu2VaiTro(
		long vaiTroId, long coQuanQuanLyId, long chucVuId);

	/**
	* This is fucntion findByIdCoQuanQuanLyAndDaXoa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId, int daXoa
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdCoQuanQuanLyAndDaXoa(
		long coQuanQuanLyId, int daXoa);

	/**
	* This is fucntion findByIdChucVuAndDaXoa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long chucVuId, int daXoa
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdChucVuAndDaXoa(
		long chucVuId, int daXoa);

	/**
	* This is fucntion findTrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findTrangThai(
		int daXoa);

	/**
	* This is fucntion findByIdChucVuAndIdCoQuanQuanLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long chucVuId, long coQuanQuanLyId, int daXoa
	* @return List<ChucVu2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdChucVuAndIdCoQuanQuanLy(
		long chucVuId, long coQuanQuanLyId, int daXoa);
}