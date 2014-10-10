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
public class HoSoTTHCCongFinderUtil {
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaCongDanHoSo(
		long congDanNopId, java.lang.String maSoHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByMaCongDanHoSo(congDanNopId, maSoHoSo, start, end);
	}

	public static int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().updateHOSOTTHCCONGById(hoSoTTHCCongId, status);
	}

	public static int countByMaCongDanHoSo(long congDanNopId,
		java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByMaCongDanHoSo(congDanNopId, maSoHoSo);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCQQL(
		java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByCQQL(maSoHoSo, thuTucHanhChinhId, maUngDung, cqqlId,
			trangThai, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findHoSoTTHCCong(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId, int start,
		int end) {
		return getFinder()
				   .findHoSoTTHCCong(maSoHoSo, trangThaiHoSo, cqqlId, start, end);
	}

	public static long countHoSoTTHCCongByCoQuanQuanLy(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId) {
		return getFinder()
				   .countHoSoTTHCCongByCoQuanQuanLy(maSoHoSo, trangThaiHoSo,
			cqqlId);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaCongDanHoSo_QT(
		long congDanNopId, java.lang.String maSoHoSo, long thuTucHanhChinhId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByMaCongDanHoSo_QT(congDanNopId, maSoHoSo,
			thuTucHanhChinhId, start, end);
	}

	public static int countByMaCongDanHoSo_QT(long congDanNopId,
		java.lang.String maSoHoSo, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByMaCongDanHoSo_QT(congDanNopId, maSoHoSo,
			thuTucHanhChinhId);
	}

	public static int countByCQQL(java.lang.String maSoHoSo,
		long thuTucHanhChinhId, java.lang.String maUngDung, long cqqlId,
		int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByCQQL(maSoHoSo, thuTucHanhChinhId, maUngDung, cqqlId,
			trangThai);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLy(
		java.lang.String maSoOrTenNguoiNopHoSo, long thuTucHanhChinhId,
		int status, java.lang.String emailCanBo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchHSDangXuLy(maSoOrTenNguoiNopHoSo, thuTucHanhChinhId,
			status, emailCanBo, start, end);
	}

	public static int countHSDangXuLy(java.lang.String maSoOrTenNguoiNopHoSo,
		long thuTucHanhChinhId, int status, java.lang.String emailCanBo,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countHSDangXuLy(maSoOrTenNguoiNopHoSo, thuTucHanhChinhId,
			status, emailCanBo, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}

	public static java.lang.String getDSMaSoHS(
		java.util.List<java.lang.String> lsMail, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end) {
		return getFinder().getDSMaSoHS(lsMail, tuNgay, denNgay, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> lsMaHoSo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchAllHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, lsMaHoSo, tuNgay, denNgay, start, end);
	}

	public static int countHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}

	public static int countAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> lsMaHoSo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countAllHSDangXuLyMutilStatusAndTTHC(maSoOrTenNguoiNopHoSo,
			thuTucHanhChinhIds, status, lsMaHoSo, tuNgay, denNgay, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMutilStatusAndTTHC(
		java.lang.String tthcIds, java.lang.String maSoHoSo, long idCanBo,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, java.lang.String tuNgay, java.lang.String denNgay,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByMutilStatusAndTTHC(tthcIds, maSoHoSo, idCanBo,
			maUngDung, cqqlId, trangThais, yeuCauRut, tuNgay, denNgay, start,
			end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> getDSCongChuc2ThuTuc(
		java.lang.String maSoHoSo, java.lang.String thuTucHanhChinhIds,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getDSCongChuc2ThuTuc(maSoHoSo, thuTucHanhChinhIds,
			maUngDung, cqqlId, trangThais, yeuCauRut, start, end);
	}

	public static int countByMutilStatusAndTTHC(java.lang.String tthcIds,
		java.lang.String maSoHoSo, long idCanBo, java.lang.String maUngDung,
		long cqqlId, java.lang.String trangThais, int yeuCauRut,
		java.lang.String tuNgay, java.lang.String denNgay, int start, int end) {
		return getFinder()
				   .countByMutilStatusAndTTHC(tthcIds, maSoHoSo, idCanBo,
			maUngDung, cqqlId, trangThais, yeuCauRut, tuNgay, denNgay, start,
			end);
	}

	public static HoSoTTHCCongFinder getFinder() {
		if (_finder == null) {
			_finder = (HoSoTTHCCongFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					HoSoTTHCCongFinder.class.getName());

			ReferenceRegistry.registerReference(HoSoTTHCCongFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(HoSoTTHCCongFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HoSoTTHCCongFinderUtil.class,
			"_finder");
	}

	private static HoSoTTHCCongFinder _finder;
}