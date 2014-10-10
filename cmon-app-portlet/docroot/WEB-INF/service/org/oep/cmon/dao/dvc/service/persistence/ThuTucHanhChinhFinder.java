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

package org.oep.cmon.dao.dvc.service.persistence;

/**
 * @author liemnn
 */
public interface ThuTucHanhChinhFinder {
	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucByUngDung(
		long ungDungId) throws java.lang.Exception;

	public org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(
		long thuTucId, long coQuanId) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTuc2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception;

	public long countByCQQL(long coQuanQuanLyId);

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQL(
		long coQuanQuanLyId);

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> searchByUngDungOrNhom(
		java.lang.Long ungDungId, java.lang.Long nhomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countByUngDungOrNhom(java.lang.Long ungDungId,
		java.lang.Long nhomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> searchByTTHCIdOrGDId(
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countByTTHCIdOrGDId(java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQLAndMa(
		long coQuanQuanLyId, java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> searchByTTHC2HDBM(
		java.lang.Long tthcid, java.lang.Long loaiTL, java.lang.Integer daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countByTTHC2HDBM(java.lang.Long tthcid, java.lang.Long loaiTL,
		java.lang.Integer daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}