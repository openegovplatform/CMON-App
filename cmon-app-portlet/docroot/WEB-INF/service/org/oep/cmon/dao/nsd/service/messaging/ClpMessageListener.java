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

package org.oep.cmon.dao.nsd.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.oep.cmon.dao.nsd.service.ClpSerializer;
import org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.NhomNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;

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
			NguoiDung2VaiTroLocalServiceUtil.clearService();

			NhomNguoiDungLocalServiceUtil.clearService();

			TaiKhoanNguoiDungLocalServiceUtil.clearService();

			TaiNguyenLocalServiceUtil.clearService();

			TaiNguyen2VaiTroLocalServiceUtil.clearService();

			VaiTroLocalServiceUtil.clearService();
		}
	}
}