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
public interface ReportTongHopChiTietFinder {
	public java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> getListReportTongHopChiTietGroupByIDThuTuc(
		java.lang.String IDDonVi, java.lang.String arrIDThuTuc,
		java.lang.String arrThang, java.lang.String nam)
		throws java.lang.Exception;
}