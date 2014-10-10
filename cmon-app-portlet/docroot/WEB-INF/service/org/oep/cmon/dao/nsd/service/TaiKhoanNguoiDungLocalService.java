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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the tai khoan nguoi dung local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see TaiKhoanNguoiDungLocalServiceUtil
 * @see org.oep.cmon.dao.nsd.service.base.TaiKhoanNguoiDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.nsd.service.impl.TaiKhoanNguoiDungLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TaiKhoanNguoiDungLocalService
	extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiKhoanNguoiDungLocalServiceUtil} to access the tai khoan nguoi dung local service. Add custom service methods to {@link org.oep.cmon.dao.nsd.service.impl.TaiKhoanNguoiDungLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the tai khoan nguoi dung to the database. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung addTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new tai khoan nguoi dung with the primary key. Does not add the tai khoan nguoi dung to the database.
	*
	* @param id the primary key for the new tai khoan nguoi dung
	* @return the new tai khoan nguoi dung
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung createTaiKhoanNguoiDung(
		long id);

	/**
	* Deletes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @throws PortalException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTaiKhoanNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the tai khoan nguoi dung from the database. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
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
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchTaiKhoanNguoiDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai khoan nguoi dung with the primary key.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung
	* @throws PortalException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung getTaiKhoanNguoiDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> getTaiKhoanNguoiDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs.
	*
	* @return the number of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTaiKhoanNguoiDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the tai khoan nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the tai khoan nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @param merge whether to merge the tai khoan nguoi dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tai khoan nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
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
	* This is fucntion findByTenDangNhap
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String tenDangNhap
	* @return TaiKhoanNguoiDung
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenDangNhap(
		java.lang.String tenDangNhap);

	/**
	* This is fucntion findByTaiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long taiKhoanNguoiDungId
	* @return TaiKhoanNguoiDung
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDungId(
		long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* This is fucntion findByEmail
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String email
	* @return List<TaiKhoanNguoiDung>
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email);

	/**
	* This is fucntion fetchByLiferayUserId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long liferayUserId
	* @return TaiKhoanNguoiDung
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByLiferayUserId(
		long liferayUserId);

	/**
	* This is fucntion findByTaiKhoanNguoiDung
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long taiKhoanId,int daXoa
	* @return List<TaiKhoanNguoiDung>
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanId, int daXoa);

	/**
	* This is fucntion v
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String keyWord, String option
	* @return List<TaiKhoanNguoiDung>
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDungPopup(
		java.lang.String keyWord, java.lang.String option);

	/**
	* This is fucntion findTaiKhoanNguoiDung
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String keyWord, String option
	* @return List<TaiKhoanNguoiDung>
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDung(
		java.lang.String keyWord, java.lang.String option);
}