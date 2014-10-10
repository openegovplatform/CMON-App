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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the ho so t t h c cong local service. This utility wraps {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongLocalService
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongLocalServiceImpl
 * @generated
 */
public class HoSoTTHCCongLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ho so t t h c cong to the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @return the ho so t t h c cong that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong addHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHoSoTTHCCong(hoSoTTHCCong);
	}

	/**
	* Creates a new ho so t t h c cong with the primary key. Does not add the ho so t t h c cong to the database.
	*
	* @param id the primary key for the new ho so t t h c cong
	* @return the new ho so t t h c cong
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong createHoSoTTHCCong(
		long id) {
		return getService().createHoSoTTHCCong(id);
	}

	/**
	* Deletes the ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so t t h c cong
	* @throws PortalException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHoSoTTHCCong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHoSoTTHCCong(id);
	}

	/**
	* Deletes the ho so t t h c cong from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHoSoTTHCCong(hoSoTTHCCong);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchHoSoTTHCCong(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHoSoTTHCCong(id);
	}

	/**
	* Returns the ho so t t h c cong with the primary key.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong
	* @throws PortalException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong getHoSoTTHCCong(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoTTHCCong(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> getHoSoTTHCCongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoTTHCCongs(start, end);
	}

	/**
	* Returns the number of ho so t t h c congs.
	*
	* @return the number of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int getHoSoTTHCCongsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoSoTTHCCongsCount();
	}

	/**
	* Updates the ho so t t h c cong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @return the ho so t t h c cong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoSoTTHCCong(hoSoTTHCCong);
	}

	/**
	* Updates the ho so t t h c cong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	* @param merge whether to merge the ho so t t h c cong with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ho so t t h c cong that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoSoTTHCCong(hoSoTTHCCong, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchByMaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByMaSoBienNhan(maSoBienNhan);
	}

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
	public static long countByMaCongDanHoSo_QT(long congDanNopId,
		java.lang.String maSoHoSo, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByMaCongDanHoSo_QT(congDanNopId, maSoHoSo,
			thuTucHanhChinhId);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchByMaCongDanHoSo_QT(
		long congDanNopId, java.lang.String maSoHoSo, long thuTucHanhChinhId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchByMaCongDanHoSo_QT(congDanNopId, maSoHoSo,
			thuTucHanhChinhId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCQQL(
		java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCQQL(maSoHoSo, thuTucHanhChinhId, maUngDung, cqqlId,
			trangThai, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMutilStatusAndTTHC(
		java.lang.String tthcsIds, java.lang.String maSoHoSo, long idCanBo,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, java.lang.String tuNgay, java.lang.String denNgay,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByMutilStatusAndTTHC(tthcsIds, maSoHoSo, idCanBo,
			maUngDung, cqqlId, trangThais, yeuCauRut, tuNgay, denNgay, start,
			end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCBXLMutilStatusAndTTHC(
		java.lang.String maSoHoSo, java.lang.String thuTucHanhChinhIds,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCBXLMutilStatusAndTTHC(maSoHoSo, thuTucHanhChinhIds,
			maUngDung, cqqlId, trangThais, yeuCauRut, start, end);
	}

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
	public static int countByCQQL(java.lang.String maSoHoSo,
		long thuTucHanhChinhId, java.lang.String maUngDung, long cqqlId,
		int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCQQL(maSoHoSo, thuTucHanhChinhId, maUngDung, cqqlId,
			trangThai);
	}

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
	public static long countHoSoTTHCCongByCoQuanQuanLy(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId) {
		return getService()
				   .countHoSoTTHCCongByCoQuanQuanLy(maSoHoSo, trangThaiHoSo,
			cqqlId);
	}

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
	public static int countByMutilStatusAndTTHC(java.lang.String tthcsIds,
		java.lang.String maSoHoSo, long idCanBo, java.lang.String maUngDung,
		long cqqlId, java.lang.String trangThais, int yeuCauRut,
		java.lang.String tuNgay, java.lang.String denNgay, int start, int end) {
		return getService()
				   .countByMutilStatusAndTTHC(tthcsIds, maSoHoSo, idCanBo,
			maUngDung, cqqlId, trangThais, yeuCauRut, tuNgay, denNgay, start,
			end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findHoSoTTHCCong(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId, int start,
		int end) {
		return getService()
				   .findHoSoTTHCCong(maSoHoSo, trangThaiHoSo, cqqlId, start, end);
	}

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
	public static int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHOSOTTHCCONGById(hoSoTTHCCongId, status);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaSoHoSo(
		java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMaSoHoSo(maSoHoSo);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMaSoBienNhan(maSoBienNhan);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLoaiHoSo(loaiHoSo);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLoaiHoSo(loaiHoSo, start, end);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong capNhatTrangThai(
		java.lang.Long id, int status) {
		return getService().capNhatTrangThai(id, status);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLy(
		java.lang.String maSoHoSo, long thuTucHanhChinhId, int status,
		java.lang.String emailCanBo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchHSDangXuLy(maSoHoSo, thuTucHanhChinhId, status,
			emailCanBo, start, end);
	}

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
	public static int countHSDangXuLy(java.lang.String maSoHoSo,
		long thuTucHanhChinhId, int status, java.lang.String emailCanBo,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countHSDangXuLy(maSoHoSo, thuTucHanhChinhId, status,
			emailCanBo, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}

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
	public static int countHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchAllHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}

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
	public static int countAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countAllHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, java.lang.Long coQuanTiepNhanId) {
		return getService().findByTrangThaiHoSo(trangThaiHoSo, coQuanTiepNhanId);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThutucId_CongDanId(
		java.lang.Long thutucId, java.lang.Long congdanId) {
		return getService().findByThutucId_CongDanId(thutucId, congdanId);
	}

	public static void clearService() {
		_service = null;
	}

	public static HoSoTTHCCongLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HoSoTTHCCongLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HoSoTTHCCongLocalService.class.getName(), portletClassLoader);

			_service = new HoSoTTHCCongLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HoSoTTHCCongLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HoSoTTHCCongLocalService.class);
		}

		return _service;
	}

	public void setService(HoSoTTHCCongLocalService service) {
		MethodCache.remove(HoSoTTHCCongLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HoSoTTHCCongLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HoSoTTHCCongLocalService.class);
	}

	private static HoSoTTHCCongLocalService _service;
}