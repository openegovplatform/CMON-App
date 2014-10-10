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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author LIEMNn
 */
public class FileDinhKemFinderUtil {
	public static java.util.List findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(
		long hoSoTTHCCongId, long danhMucGiayToId) {
		return getFinder()
				   .findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(hoSoTTHCCongId,
			danhMucGiayToId);
	}

	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSo)
		throws java.lang.Exception {
		return getFinder().getDSGiayToKhiBoSungHoSo(hoSo);
	}

	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(
		long hoSoId) throws java.lang.Exception {
		return getFinder().getDSGiayToPhienBanMoiNhatByHoSo(hoSoId);
	}

	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(
		long hoSoId, int giaiDoan) throws java.lang.Exception {
		return getFinder()
				   .getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(hoSoId, giaiDoan);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId,
			giaiDoan);
	}

	public static java.util.List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId) {
		return getFinder().findTaiLieuDinhKemTichHop(hoSoTTHCCongId);
	}

	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(
		long hoSoTTHCCongId, long thuTuc2GiayToId, long danhMucGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(hoSoTTHCCongId,
			thuTuc2GiayToId, danhMucGiayToId);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(hoSoTTHCCongId,
			giaiDoan);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemDifferent(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findFileDinhKemDifferent(hoSoTTHCCongId);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCongId);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findFileDinhKemByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCongId);
	}

	public static java.util.List findByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	public static java.util.List findFileUploadByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findFileUploadByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId,
			giaiDoan);
	}

	public static java.util.List findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(
		long thutuchanhchinhid, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(thutuchanhchinhid,
			giaiDoan);
	}

	public static java.lang.Long findNoiLuuTruFileTraKetQua(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findNoiLuuTruFileTraKetQua(hoSoTTHCCongId);
	}

	public static java.util.List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(
		long hoSoTTHCCongId, java.lang.String maLoaiTaiLieuDuocThayThe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(hoSoTTHCCongId,
			maLoaiTaiLieuDuocThayThe);
	}

	public static FileDinhKemFinder getFinder() {
		if (_finder == null) {
			_finder = (FileDinhKemFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					FileDinhKemFinder.class.getName());

			ReferenceRegistry.registerReference(FileDinhKemFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FileDinhKemFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FileDinhKemFinderUtil.class,
			"_finder");
	}

	private static FileDinhKemFinder _finder;
}