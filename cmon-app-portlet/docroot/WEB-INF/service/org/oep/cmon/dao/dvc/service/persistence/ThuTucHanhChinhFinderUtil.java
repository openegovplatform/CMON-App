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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author liemnn
 */
public class ThuTucHanhChinhFinderUtil {
	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucByUngDung(
		long ungDungId) throws java.lang.Exception {
		return getFinder().getDSThongTinThuTucByUngDung(ungDungId);
	}

	public static org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(
		long thuTucId, long coQuanId) throws java.lang.Exception {
		return getFinder().fetchThongTinThuTuc2CoQuan(thuTucId, coQuanId);
	}

	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTuc2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		return getFinder().getDSThongTinThuTuc2CanBo(canBo);
	}

	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		return getFinder().getDSThongTinThuTucLienThongNoiGui2CanBo(canBo);
	}

	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		return getFinder().getDSThongTinThuTucLienThongNoiNhan2CanBo(canBo);
	}

	public static long countByCQQL(long coQuanQuanLyId) {
		return getFinder().countByCQQL(coQuanQuanLyId);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQL(
		long coQuanQuanLyId) {
		return getFinder().getListTTHCByCQQL(coQuanQuanLyId);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> searchByUngDungOrNhom(
		java.lang.Long ungDungId, java.lang.Long nhomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchByUngDungOrNhom(ungDungId, nhomId, start, end);
	}

	public static long countByUngDungOrNhom(java.lang.Long ungDungId,
		java.lang.Long nhomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByUngDungOrNhom(ungDungId, nhomId);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> searchByTTHCIdOrGDId(
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchByTTHCIdOrGDId(tthcid, dgId, daXoa, start, end);
	}

	public static long countByTTHCIdOrGDId(java.lang.Long tthcid,
		java.lang.Long dgId, java.lang.Integer daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByTTHCIdOrGDId(tthcid, dgId, daXoa);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQLAndMa(
		long coQuanQuanLyId, java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getListTTHCByCQQLAndMa(coQuanQuanLyId, ma);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> searchByTTHC2HDBM(
		java.lang.Long tthcid, java.lang.Long loaiTL, java.lang.Integer daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchByTTHC2HDBM(tthcid, loaiTL, daXoa, start, end);
	}

	public static long countByTTHC2HDBM(java.lang.Long tthcid,
		java.lang.Long loaiTL, java.lang.Integer daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByTTHC2HDBM(tthcid, loaiTL, daXoa);
	}

	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getTenCQQL(thuTucHanhChinhId, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getTenDTSD(thuTucHanhChinhId, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getTenDMGT(thuTucHanhChinhId, start, end);
	}

	public static ThuTucHanhChinhFinder getFinder() {
		if (_finder == null) {
			_finder = (ThuTucHanhChinhFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					ThuTucHanhChinhFinder.class.getName());

			ReferenceRegistry.registerReference(ThuTucHanhChinhFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThuTucHanhChinhFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThuTucHanhChinhFinderUtil.class,
			"_finder");
	}

	private static ThuTucHanhChinhFinder _finder;
}