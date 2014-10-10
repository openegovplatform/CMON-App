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

package org.oep.cmon.dao.cd.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the cong dan local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see CongDanLocalServiceUtil
 * @see org.oep.cmon.dao.cd.service.base.CongDanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.impl.CongDanLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CongDanLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongDanLocalServiceUtil} to access the cong dan local service. Add custom service methods to {@link org.oep.cmon.dao.cd.service.impl.CongDanLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the cong dan to the database. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @return the cong dan that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan addCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new cong dan with the primary key. Does not add the cong dan to the database.
	*
	* @param id the primary key for the new cong dan
	* @return the new cong dan
	*/
	public org.oep.cmon.dao.cd.model.CongDan createCongDan(long id);

	/**
	* Deletes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong dan
	* @throws PortalException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the cong dan from the database. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongDan(org.oep.cmon.dao.cd.model.CongDan congDan)
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
	public org.oep.cmon.dao.cd.model.CongDan fetchCongDan(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan with the primary key.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan
	* @throws PortalException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.cd.model.CongDan getCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of cong dans
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> getCongDans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans.
	*
	* @return the number of cong dans
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCongDansCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @return the cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan updateCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @param merge whether to merge the cong dan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan updateCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan, boolean merge)
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
	* This is fucntion get CongDan by liferayUserId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long : Value of liferayUserId
	* @return CongDan
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.cd.model.CongDan getCongDanByLiferayUserId(
		java.lang.Long liferayUserId);

	/**
	* This is fucntion search CongDan by request
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param PortletRequest : request
	* @return List<CongDan>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.beans.congdan.CongDan> search(
		javax.portlet.PortletRequest request) throws java.lang.Exception;

	/**
	* This is fucntion find CongDan by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return List<CongDan>
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByMa(java.lang.String ma);

	/**
	* This is fucntion find CongDan by taiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of taiKhoanNguoiDungId
	* @return CongDan
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByTaiKhoanNguoiDungId(
		long taiKhoanNguoiDungId);

	/**
	* This is fucntion find CongDan by soCmnd
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of soCmnd
	* @return List<CongDan>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByCMND(
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find CongDan by email
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of email
	* @return List<CongDan>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find CongDan by soCmnd
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of soCmnd
	* @return List<CongDan>
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion save CongDan infomation
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param CongDan : CongDan object
	* @return CongDan
	*/
	public org.oep.cmon.dao.cd.model.CongDan saveCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find ChucVu by email and soCmnd
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of email ; String soCmnd;
	* @return CongDan
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* This is fucntion find CongDan by NgaySinh And CMND
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of soCmnd ;Date ngaySinh
	* @return CongDan
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndCMND(
		java.sql.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* This is fucntion find CongDan by NgaySinh And SoCMND
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of soCmnd ;Date: ngaysinh
	* @return CongDan
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndSoCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* This is fucntion find CongDan by NgaySinh And TinhThuongTruId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long : Value of tinhThuongTruId ; Date : ngaysinh
	* @return CongDan
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndTinhThuongTruId(
		java.util.Date ngaySinh, long tinhThuongTruId)
		throws com.liferay.portal.kernel.exception.SystemException;
}