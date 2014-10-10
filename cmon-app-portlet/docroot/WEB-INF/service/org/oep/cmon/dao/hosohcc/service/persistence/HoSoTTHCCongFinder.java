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
public interface HoSoTTHCCongFinder {
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaCongDanHoSo(
		long congDanNopId, java.lang.String maSoHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByMaCongDanHoSo(long congDanNopId, java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCQQL(
		java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findHoSoTTHCCong(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId, int start,
		int end);

	public long countHoSoTTHCCongByCoQuanQuanLy(java.lang.String maSoHoSo,
		int trangThaiHoSo, long cqqlId);

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaCongDanHoSo_QT(
		long congDanNopId, java.lang.String maSoHoSo, long thuTucHanhChinhId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByMaCongDanHoSo_QT(long congDanNopId,
		java.lang.String maSoHoSo, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCQQL(java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLy(
		java.lang.String maSoOrTenNguoiNopHoSo, long thuTucHanhChinhId,
		int status, java.lang.String emailCanBo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countHSDangXuLy(java.lang.String maSoOrTenNguoiNopHoSo,
		long thuTucHanhChinhId, int status, java.lang.String emailCanBo,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getDSMaSoHS(
		java.util.List<java.lang.String> lsMail, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end);

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> lsMaHoSo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> lsMaHoSo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMutilStatusAndTTHC(
		java.lang.String tthcIds, java.lang.String maSoHoSo, long idCanBo,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, java.lang.String tuNgay, java.lang.String denNgay,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> getDSCongChuc2ThuTuc(
		java.lang.String maSoHoSo, java.lang.String thuTucHanhChinhIds,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByMutilStatusAndTTHC(java.lang.String tthcIds,
		java.lang.String maSoHoSo, long idCanBo, java.lang.String maUngDung,
		long cqqlId, java.lang.String trangThais, int yeuCauRut,
		java.lang.String tuNgay, java.lang.String denNgay, int start, int end);
}