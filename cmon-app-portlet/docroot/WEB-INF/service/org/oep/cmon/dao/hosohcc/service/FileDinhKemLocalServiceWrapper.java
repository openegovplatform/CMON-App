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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FileDinhKemLocalService}.
 * </p>
 *
 * @author    LIEMNn
 * @see       FileDinhKemLocalService
 * @generated
 */
public class FileDinhKemLocalServiceWrapper implements FileDinhKemLocalService,
	ServiceWrapper<FileDinhKemLocalService> {
	public FileDinhKemLocalServiceWrapper(
		FileDinhKemLocalService fileDinhKemLocalService) {
		_fileDinhKemLocalService = fileDinhKemLocalService;
	}

	/**
	* Adds the file dinh kem to the database. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @return the file dinh kem that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem addFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.addFileDinhKem(fileDinhKem);
	}

	/**
	* Creates a new file dinh kem with the primary key. Does not add the file dinh kem to the database.
	*
	* @param id the primary key for the new file dinh kem
	* @return the new file dinh kem
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem createFileDinhKem(long id) {
		return _fileDinhKemLocalService.createFileDinhKem(id);
	}

	/**
	* Deletes the file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the file dinh kem
	* @throws PortalException if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_fileDinhKemLocalService.deleteFileDinhKem(id);
	}

	/**
	* Deletes the file dinh kem from the database. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		_fileDinhKemLocalService.deleteFileDinhKem(fileDinhKem);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem fetchFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.fetchFileDinhKem(id);
	}

	/**
	* Returns the file dinh kem with the primary key.
	*
	* @param id the primary key of the file dinh kem
	* @return the file dinh kem
	* @throws PortalException if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem getFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.getFileDinhKem(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getFileDinhKems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.getFileDinhKems(start, end);
	}

	/**
	* Returns the number of file dinh kems.
	*
	* @return the number of file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public int getFileDinhKemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.getFileDinhKemsCount();
	}

	/**
	* Updates the file dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @return the file dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem updateFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.updateFileDinhKem(fileDinhKem);
	}

	/**
	* Updates the file dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileDinhKem the file dinh kem
	* @param merge whether to merge the file dinh kem with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the file dinh kem that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem updateFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.updateFileDinhKem(fileDinhKem, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _fileDinhKemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fileDinhKemLocalService.setBeanIdentifier(beanIdentifier);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findFileDinhKemByHoSoTTHCCongId(hoSoTTHCCongId);
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
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(
		long hoSoTTHCCongId, long idThuTuc2GiayTo, long idDanhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCongId);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCongId);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findByHoSoTTHCCongId(hoSoTTHCCongId);
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
	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSo)
		throws java.lang.Exception {
		return _fileDinhKemLocalService.getDSGiayToKhiBoSungHoSo(hoSo);
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
	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiTiepNhanHoSo(
		long thuTucId) throws java.lang.Exception {
		return _fileDinhKemLocalService.getDSGiayToKhiTiepNhanHoSo(thuTucId);
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
	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(
		long hoSoId) throws java.lang.Exception {
		return _fileDinhKemLocalService.getDSGiayToPhienBanMoiNhatByHoSo(hoSoId);
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
	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(
		long hoSoId, int giaiDoan) throws java.lang.Exception {
		return _fileDinhKemLocalService.getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(hoSoId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByHoSoTTHCCongID(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findByHoSoTTHCCongID(hoSoTTHCCongId);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getDSGiayToByHoSoAndThuTuc2GiayTo(
		long hoSoId, long thuTuc2GiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.getDSGiayToByHoSoAndThuTuc2GiayTo(hoSoId,
			thuTuc2GiayToId);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(
		long hoSoTTHCCongId, long taiLieuChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileUploadByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findFileUploadByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(
		long thutuchanhchinhid, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(thutuchanhchinhid,
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
	public void deleteByHoSoThuTucHanhChinhId(long hosotthcCongId) {
		_fileDinhKemLocalService.deleteByHoSoThuTucHanhChinhId(hosotthcCongId);
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
	public java.lang.String getFileTraKetQua(java.lang.Long hosoId) {
		return _fileDinhKemLocalService.getFileTraKetQua(hosoId);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.fetchByHoSoTTHCCongId(hoSoTTHCCongId);
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getLoaiFileKhac(
		long idHoSo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException {
		return _fileDinhKemLocalService.getLoaiFileKhac(idHoSo);
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
	public java.util.List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(
		long hoSoTTHCCongId, java.lang.String maLoaiTaiLieuDuocThayThe) {
		return _fileDinhKemLocalService.findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByMaFileDinhKemAndIdDanhSachHoSoS(
		long hoSoTTHCCongId, long taiLieuChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDinhKemLocalService.findByMaFileDinhKemAndIdDanhSachHoSoS(hoSoTTHCCongId,
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
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem findByHoSoTTHCCongIdAndThuTuc2GiayToId(
		long hoSoTTHCCongId, long thuTuc2GiayToId) {
		return _fileDinhKemLocalService.findByHoSoTTHCCongIdAndThuTuc2GiayToId(hoSoTTHCCongId,
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
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(
		long hoSoTTHCCongId, long danhMucGiayToId) {
		return _fileDinhKemLocalService.findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(hoSoTTHCCongId,
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
	public java.util.List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId) {
		return _fileDinhKemLocalService.findTaiLieuDinhKemTichHop(hoSoTTHCCongId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FileDinhKemLocalService getWrappedFileDinhKemLocalService() {
		return _fileDinhKemLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFileDinhKemLocalService(
		FileDinhKemLocalService fileDinhKemLocalService) {
		_fileDinhKemLocalService = fileDinhKemLocalService;
	}

	public FileDinhKemLocalService getWrappedService() {
		return _fileDinhKemLocalService;
	}

	public void setWrappedService(
		FileDinhKemLocalService fileDinhKemLocalService) {
		_fileDinhKemLocalService = fileDinhKemLocalService;
	}

	private FileDinhKemLocalService _fileDinhKemLocalService;
}