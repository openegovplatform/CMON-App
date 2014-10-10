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
 * The interface for the ho so t t h c cong local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongLocalServiceUtil
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface HoSoTTHCCongLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoTTHCCongLocalServiceUtil} to access the ho so t t h c cong local service. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the ho so t t h c cong to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @return the ho so t t h c cong that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong addHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new ho so t t h c cong with the primary key. Does not add the ho so t t h c cong to the database.
	*
	* @param id the primary key for the new ho so t t h c cong
	* @return the new ho so t t h c cong
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong createHoSoTTHCCong(
		long id);

	/**
	* Deletes the ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so t t h c cong
	* @throws PortalException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoTTHCCong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the ho so t t h c cong from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
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
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchHoSoTTHCCong(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so t t h c cong with the primary key.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong
	* @throws PortalException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong getHoSoTTHCCong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> getHoSoTTHCCongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs.
	*
	* @return the number of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getHoSoTTHCCongsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the ho so t t h c cong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @return the ho so t t h c cong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the ho so t t h c cong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @param merge whether to merge the ho so t t h c cong with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so t t h c cong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong, boolean merge)
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
	* This is fucntion fetchByMaSoBienNhan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoBienNhan
	* @return HoSoTTHCCong
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchByMaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion countByMaCongDanHoSo_QT
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long congDanNopId, String maSoHoSo, long thuTucHanhChinhId
	* @return long
	*/
	public long countByMaCongDanHoSo_QT(long congDanNopId,
		java.lang.String maSoHoSo, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion searchByMaCongDanHoSo_QT
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long congDanNopId, String maSoHoSo, long thuTucHanhChinhId, param paging (start, end)
	* @return List<HoSoTTHCCong>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchByMaCongDanHoSo_QT(
		long congDanNopId, java.lang.String maSoHoSo, long thuTucHanhChinhId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByCQQL
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo,    long thuTucHanhChinhId,    String maUngDung,long cqqlId,int trangThai,    int start,int end
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCQQL(
		java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String tthcsIds,    String maSoHoSo,long idCanBo,String maUngDung,
	long cqqlId,
	String trangThais,
	int yeuCauRut,
	String tuNgay,
	String denNgay,
	int start,
	int end
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMutilStatusAndTTHC(
		java.lang.String tthcsIds, java.lang.String maSoHoSo, long idCanBo,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, java.lang.String tuNgay, java.lang.String denNgay,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByCBXLMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo,
	String thuTucHanhChinhIds,
	String maUngDung,
	long cqqlId,
	String trangThais,
	int yeuCauRut,
	int start,
	int end
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCBXLMutilStatusAndTTHC(
		java.lang.String maSoHoSo, java.lang.String thuTucHanhChinhIds,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion countByCQQL
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo,long thuTucHanhChinhId, String maUngDung,long cqqlId, int trangThai
	* @return int
	*/
	public int countByCQQL(java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion countHoSoTTHCCongByCoQuanQuanLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo, int trangThaiHoSo, long cqqlId
	* @return long
	*/
	public long countHoSoTTHCCongByCoQuanQuanLy(java.lang.String maSoHoSo,
		int trangThaiHoSo, long cqqlId);

	/**
	* This is fucntion countByMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String tthcsIds,
	String maSoHoSo,
	long idCanBo,
	String maUngDung,
	long cqqlId,
	String trangThais,
	int yeuCauRut,
	String tuNgay,
	String denNgay,
	int start,
	int end
	* @return int
	*/
	public int countByMutilStatusAndTTHC(java.lang.String tthcsIds,
		java.lang.String maSoHoSo, long idCanBo, java.lang.String maUngDung,
		long cqqlId, java.lang.String trangThais, int yeuCauRut,
		java.lang.String tuNgay, java.lang.String denNgay, int start, int end);

	/**
	* This is fucntion findHoSoTTHCCong
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo,    int trangThaiHoSo, long cqqlId, int start, int end
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findHoSoTTHCCong(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId, int start,
		int end);

	/**
	* This is fucntion updateHOSOTTHCCONGById
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, int status
	* @return int
	*/
	public int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByMaSoHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaSoHoSo(
		java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByMaSoBienNhan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoBienNhan
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByLoaiHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int loaiHoSo
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByLoaiHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int loaiHoSo, int start, int end
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion capNhatTrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long id, int status
	* @return HoSoTTHCCong
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong capNhatTrangThai(
		java.lang.Long id, int status);

	/**
	* This is fucntion searchHSDangXuLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoHoSo,
	long thuTucHanhChinhId,
	int status,
	String emailCanBo,
	int start,
	int end
	* @return List<HoSoTTHCCong>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLy(
		java.lang.String maSoHoSo, long thuTucHanhChinhId, int status,
		java.lang.String emailCanBo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion countHSDangXuLy
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param tring maSoHoSo, long thuTucHanhChinhId, int status, String emailCanBo, int start, int end
	* @return int
	*/
	public int countHSDangXuLy(java.lang.String maSoHoSo,
		long thuTucHanhChinhId, int status, java.lang.String emailCanBo,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion searchHSDangXuLyMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoOrTenNguoiNopHoSo,
	String thuTucHanhChinhIds,
	String status,
	String emailCanBo,
	String tuNgay,
	String denNgay,
	int start,
	int end
	* @return List<HoSoTTHCCong>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion countHSDangXuLyMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoOrTenNguoiNopHoSo,
	String thuTucHanhChinhIds,
	String status,
	String emailCanBo,
	String tuNgay,
	String denNgay,
	int start,
	int end
	* @return int
	*/
	public int countHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion searchAllHSDangXuLyMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	* String maSoOrTenNguoiNopHoSo,
	* String thuTucHanhChinhIds,
	* String status,
	* List<String> emailCanBo,
	* String tuNgay,
	* String denNgay,
	* int start,
	* int end
	*
	* @return List<HoSoTTHCCong>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion countAllHSDangXuLyMutilStatusAndTTHC
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String maSoOrTenNguoiNopHoSo,
	String thuTucHanhChinhIds,
	String status,
	List<String> emailCanBo,
	String tuNgay,
	String denNgay,
	int start,
	int end
	* @return int
	*/
	public int countAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion findByTrangThaiHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int trangThaiHoSo, Long coQuanTiepNhanId
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, java.lang.Long coQuanTiepNhanId);

	/**
	* This is fucntion findByThutucId_CongDanId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long thutucId, Long congdanId
	* @return List<HoSoTTHCCong>
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThutucId_CongDanId(
		java.lang.Long thutucId, java.lang.Long congdanId);
}