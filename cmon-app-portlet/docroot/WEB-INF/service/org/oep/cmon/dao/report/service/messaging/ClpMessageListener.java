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

package org.oep.cmon.dao.report.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.oep.cmon.dao.report.service.BaocaochitietLocalServiceUtil;
import org.oep.cmon.dao.report.service.ClpSerializer;
import org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil;
import org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.DanhMucBaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_linhvucLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_tonghopLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportThongKeLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportTongHopChiTietLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportTongHopLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2BaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2DonViBaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2NhomTTHCLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2TTHCLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			BaocaochitietLocalServiceUtil.clearService();

			CongChuc2RoleLocalServiceUtil.clearService();

			CoQuanQuanLy2LinhVucLocalServiceUtil.clearService();

			DanhMucBaoCaoLocalServiceUtil.clearService();

			DanhMucRoleLocalServiceUtil.clearService();

			Lephi_chitietLocalServiceUtil.clearService();

			Lephi_linhvucLocalServiceUtil.clearService();

			Lephi_tonghopLocalServiceUtil.clearService();

			ReportThongKeLocalServiceUtil.clearService();

			ReportTongHopLocalServiceUtil.clearService();

			ReportTongHopChiTietLocalServiceUtil.clearService();

			Role2BaoCaoLocalServiceUtil.clearService();

			Role2DonViBaoCaoLocalServiceUtil.clearService();

			Role2NhomTTHCLocalServiceUtil.clearService();

			Role2TTHCLocalServiceUtil.clearService();
		}
	}
}