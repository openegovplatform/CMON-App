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

package org.oep.cmon.dao.cd.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.oep.cmon.dao.cd.service.ChuyenMonLocalServiceUtil;
import org.oep.cmon.dao.cd.service.ClpSerializer;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil;
import org.oep.cmon.dao.cd.service.HoChieuCMNDLocalServiceUtil;
import org.oep.cmon.dao.cd.service.NgheNghiepLocalServiceUtil;
import org.oep.cmon.dao.cd.service.QuanHeGiaDinhLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TonGiaoLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TrinhDoChuyenMonLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TrinhDoHocVanLocalServiceUtil;

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
			ChuyenMonLocalServiceUtil.clearService();

			CongDanLocalServiceUtil.clearService();

			DanTocLocalServiceUtil.clearService();

			GioiTinhLocalServiceUtil.clearService();

			HeThongLocalServiceUtil.clearService();

			HoChieuCMNDLocalServiceUtil.clearService();

			NgheNghiepLocalServiceUtil.clearService();

			QuanHeGiaDinhLocalServiceUtil.clearService();

			TinhTrangHonNhanLocalServiceUtil.clearService();

			TonGiaoLocalServiceUtil.clearService();

			TrinhDoChuyenMonLocalServiceUtil.clearService();

			TrinhDoHocVanLocalServiceUtil.clearService();
		}
	}
}