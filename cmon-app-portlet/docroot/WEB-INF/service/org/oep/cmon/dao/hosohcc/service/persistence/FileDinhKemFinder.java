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

package org.oep.cmon.dao.hosohcc.service.persistence;

/**
 * @author LIEMNn
 */
public interface FileDinhKemFinder {
	public java.util.List findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(
		long hoSoTTHCCongId, long danhMucGiayToId);

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSo)
		throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(
		long hoSoId) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(
		long hoSoId, int giaiDoan) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId);

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(
		long hoSoTTHCCongId, long thuTuc2GiayToId, long danhMucGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemDifferent(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findFileUploadByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(
		long thutuchanhchinhid, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Long findNoiLuuTruFileTraKetQua(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(
		long hoSoTTHCCongId, java.lang.String maLoaiTaiLieuDuocThayThe)
		throws com.liferay.portal.kernel.exception.SystemException;
}