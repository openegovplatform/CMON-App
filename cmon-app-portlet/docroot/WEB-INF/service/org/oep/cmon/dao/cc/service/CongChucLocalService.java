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

package org.oep.cmon.dao.cc.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the cong chuc local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see CongChucLocalServiceUtil
 * @see org.oep.cmon.dao.cc.service.base.CongChucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cc.service.impl.CongChucLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CongChucLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongChucLocalServiceUtil} to access the cong chuc local service. Add custom service methods to {@link org.oep.cmon.dao.cc.service.impl.CongChucLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the cong chuc to the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc the cong chuc
	* @return the cong chuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc addCongChuc(
		org.oep.cmon.dao.cc.model.CongChuc congChuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new cong chuc with the primary key. Does not add the cong chuc to the database.
	*
	* @param id the primary key for the new cong chuc
	* @return the new cong chuc
	*/
	public org.oep.cmon.dao.cc.model.CongChuc createCongChuc(long id);

	/**
	* Deletes the cong chuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong chuc
	* @throws PortalException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongChuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the cong chuc from the database. Also notifies the appropriate model listeners.
	*
	* @param congChuc the cong chuc
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongChuc(org.oep.cmon.dao.cc.model.CongChuc congChuc)
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
	public org.oep.cmon.dao.cc.model.CongChuc fetchCongChuc(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc with the primary key.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc
	* @throws PortalException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.cc.model.CongChuc getCongChuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> getCongChucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs.
	*
	* @return the number of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCongChucsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cong chuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc the cong chuc
	* @return the cong chuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc updateCongChuc(
		org.oep.cmon.dao.cc.model.CongChuc congChuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cong chuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congChuc the cong chuc
	* @param merge whether to merge the cong chuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong chuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc updateCongChuc(
		org.oep.cmon.dao.cc.model.CongChuc congChuc, boolean merge)
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
	* This is fucntion find CongChuc by taiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of taiKhoanNguoiDungId
	* @return List<CongChuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion fetch CongChuc by taiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of taiKhoanNguoiDungId
	* @return CongChuc
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.cc.model.CongChuc fetchByTaiKhoanNguoiDung(
		long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find CongChuc by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int : Value of trangthai
	* @return List<CongChuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByStatus(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find CongChuc by ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param string : Value of ma
	* @return List<CongChuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion get CongChuc by coQuanQuanLyId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of coQuanQuanLyId, int : start ; int: end;
	* @return List<CongChuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCanBoTiepNhan(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion get CongChuc by coQuanQuanLyId and ma or Ten or Email
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of coQuanQuanLyId,String : keyword; int : start ; int: end;
	* @return List<CongChuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCongChuc(
		long coQuanQuanLyId, java.lang.String maOrTenOrEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion count CongChuc by coQuanQuanLyId and ma or Ten or Email
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of coQuanQuanLyId,String : keyword
	* @return int
	*/
	public int countListCongChuc(long coQuanQuanLyId,
		java.lang.String maOrTenOrEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find CongChuc by coQuanQuanLyId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of coQuanQuanLyId
	* @return List<CongChuc>
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyID(
		long idCQQL) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion get CongChuc by taiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long : Value of taiKhoanNguoiDungId
	* @return CongChuc
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.cc.model.CongChuc getCongChucByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId);
}