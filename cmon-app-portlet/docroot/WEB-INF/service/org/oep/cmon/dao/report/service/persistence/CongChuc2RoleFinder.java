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

package org.oep.cmon.dao.report.service.persistence;

/**
 * @author VIENPN
 */
public interface CongChuc2RoleFinder {
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> getDanhsachbaocao(
		long user_id) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLy(
		long user_id, long baocao_id) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> getNhomTTHC(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception;

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThutuchanhchinh(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception;

	public java.lang.Boolean testReportPermission(long user_id, long baocao_id)
		throws java.lang.Exception;
}