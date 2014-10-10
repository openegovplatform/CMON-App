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
 * The utility for the file dinh kem local service. This utility wraps {@link org.oep.cmon.dao.hosohcc.service.impl.FileDinhKemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see FileDinhKemLocalService
 * @see org.oep.cmon.dao.hosohcc.service.base.FileDinhKemLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.FileDinhKemLocalServiceImpl
 * @generated
 */
public class FileDinhKemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.FileDinhKemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the file dinh kem to the database. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @return the file dinh kem that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem addFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFileDinhKem(fileDinhKem);
	}

	/**
	* Creates a new file dinh kem with the primary key. Does not add the file dinh kem to the database.
	*
	* @param id the primary key for the new file dinh kem
	* @return the new file dinh kem
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem createFileDinhKem(
		long id) {
		return getService().createFileDinhKem(id);
	}

	/**
	* Deletes the file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the file dinh kem
	* @throws PortalException if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFileDinhKem(id);
	}

	/**
	* Deletes the file dinh kem from the database. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFileDinhKem(fileDinhKem);
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

	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem fetchFileDinhKem(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFileDinhKem(id);
	}

	/**
	* Returns the file dinh kem with the primary key.
	*
	* @param id the primary key of the file dinh kem
	* @return the file dinh kem
	* @throws PortalException if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem getFileDinhKem(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFileDinhKem(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of file dinh kems
	* @param end the upper bound of the range of file dinh kems (not inclusive)
	* @return the range of file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getFileDinhKems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFileDinhKems(start, end);
	}

	/**
	* Returns the number of file dinh kems.
	*
	* @return the number of file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int getFileDinhKemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFileDinhKemsCount();
	}

	/**
	* Updates the file dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @return the file dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem updateFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFileDinhKem(fileDinhKem);
	}

	/**
	* Updates the file dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @param merge whether to merge the file dinh kem with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the file dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem updateFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFileDinhKem(fileDinhKem, merge);
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
	* This is fucntion find FileDinhKem by hoSoTTHCCongId, giaiDoan request
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, int giaiDoan
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId,
			giaiDoan);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId, giaiDoan response
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, int giaiDoan
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(hoSoTTHCCongId,
			giaiDoan);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findFileDinhKemByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId, idThuTuc2GiayTo,idDanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId,long idThuTuc2GiayTo,long idDanhMucGiayTo
	* @return FileDinhKem
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(
		long hoSoTTHCCongId, long idThuTuc2GiayTo, long idDanhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(hoSoTTHCCongId,
			idThuTuc2GiayTo, idDanhMucGiayTo);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCongId);
	}

	/**
	* This is fucntion find FileDinhKem-OnlineRequest by hoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCongId);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* This is fucntion find GiayToDinhKemHoSo by HoSoTTHCCong
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param HoSoTTHCCong hoSo
	* @return List<GiayToDinhKemHoSo>
	*/
	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSo)
		throws java.lang.Exception {
		return getService().getDSGiayToKhiBoSungHoSo(hoSo);
	}

	/**
	* This is fucntion get GiayToDinhKemHoSo by thuTucId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucId
	* @return List<GiayToDinhKemHoSo>
	*/
	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiTiepNhanHoSo(
		long thuTucId) throws java.lang.Exception {
		return getService().getDSGiayToKhiTiepNhanHoSo(thuTucId);
	}

	/**
	* This is fucntion get GiayToDinhKemHoSo by hoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId
	* @return List<GiayToDinhKemHoSo>
	*/
	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(
		long hoSoId) throws java.lang.Exception {
		return getService().getDSGiayToPhienBanMoiNhatByHoSo(hoSoId);
	}

	/**
	* This is fucntion get GiayToDinhKemHoSo by hoSoId, giaiDoan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId, int giaiDoan
	* @return List<GiayToDinhKemHoSo>
	*/
	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(
		long hoSoId, int giaiDoan) throws java.lang.Exception {
		return getService()
				   .getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(hoSoId, giaiDoan);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByHoSoTTHCCongID(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoTTHCCongID(hoSoTTHCCongId);
	}

	/**
	* This is fucntion get FileDinhKem by hoSoId, thuTuc2GiayToId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoId, long thuTuc2GiayToId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getDSGiayToByHoSoAndThuTuc2GiayTo(
		long hoSoId, long thuTuc2GiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDSGiayToByHoSoAndThuTuc2GiayTo(hoSoId, thuTuc2GiayToId);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId, taiLieuChungThucId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long taiLieuChungThucId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(
		long hoSoTTHCCongId, long taiLieuChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(hoSoTTHCCongId,
			taiLieuChungThucId);
	}

	/**
	* This is fucntion find FileDinhKem by hoSoTTHCCongId ,giaiDoan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, int giaiDoan
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileUploadByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findFileUploadByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId,
			giaiDoan);
	}

	/**
	* This is fucntion find FileDinhKem by thutuchanhchinhid, giaiDoan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thutuchanhchinhid, int giaiDoan
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(
		long thutuchanhchinhid, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(thutuchanhchinhid,
			giaiDoan);
	}

	/**
	* This is fucntion deleteTaiLieuChungThuc  by hosotthcCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hosotthcCongId
	* @return void
	*/
	public static void deleteByHoSoThuTucHanhChinhId(long hosotthcCongId) {
		getService().deleteByHoSoThuTucHanhChinhId(hosotthcCongId);
	}

	/**
	* This is fucntion getFileTraKetQua  by hosoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long hosoId
	* @return String
	*/
	public static java.lang.String getFileTraKetQua(java.lang.Long hosoId) {
		return getService().getFileTraKetQua(hosoId);
	}

	/**
	* This is fucntion fetchByHoSoTTHCCongId by hoSoTTHCCongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* This is fucntion getLoaiFileKhac  by idHoSo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long idHoSo
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getLoaiFileKhac(
		long idHoSo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException {
		return getService().getLoaiFileKhac(idHoSo);
	}

	/**
	* This is fucntion findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, String maLoaiTaiLieuDuocThayThe
	* @return List<FileDinhKem>
	*/
	public static java.util.List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(
		long hoSoTTHCCongId, java.lang.String maLoaiTaiLieuDuocThayThe) {
		return getService()
				   .findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(hoSoTTHCCongId,
			maLoaiTaiLieuDuocThayThe);
	}

	/**
	* This is fucntion findByMaFileDinhKemAndIdDanhSachHoSoS
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long taiLieuChungThucId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByMaFileDinhKemAndIdDanhSachHoSoS(
		long hoSoTTHCCongId, long taiLieuChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByMaFileDinhKemAndIdDanhSachHoSoS(hoSoTTHCCongId,
			taiLieuChungThucId);
	}

	/**
	* This is fucntion findByHoSoTTHCCongIdAndThuTuc2GiayToId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long thuTuc2GiayToId
	* @return FileDinhKem
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem findByHoSoTTHCCongIdAndThuTuc2GiayToId(
		long hoSoTTHCCongId, long thuTuc2GiayToId) {
		return getService()
				   .findByHoSoTTHCCongIdAndThuTuc2GiayToId(hoSoTTHCCongId,
			thuTuc2GiayToId);
	}

	/**
	* This is fucntion findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId, long danhMucGiayToId
	* @return List<FileDinhKem>
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(
		long hoSoTTHCCongId, long danhMucGiayToId) {
		return getService()
				   .findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(hoSoTTHCCongId,
			danhMucGiayToId);
	}

	/**
	* This is fucntion findTaiLieuDinhKemTichHop
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCongId
	* @return List<FileDinhKem>
	*/
	public static java.util.List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId) {
		return getService().findTaiLieuDinhKemTichHop(hoSoTTHCCongId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FileDinhKemLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FileDinhKemLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					FileDinhKemLocalService.class.getName(), portletClassLoader);

			_service = new FileDinhKemLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(FileDinhKemLocalServiceUtil.class,
				"_service");
			MethodCache.remove(FileDinhKemLocalService.class);
		}

		return _service;
	}

	public void setService(FileDinhKemLocalService service) {
		MethodCache.remove(FileDinhKemLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(FileDinhKemLocalServiceUtil.class,
			"_service");
		MethodCache.remove(FileDinhKemLocalService.class);
	}

	private static FileDinhKemLocalService _service;
}