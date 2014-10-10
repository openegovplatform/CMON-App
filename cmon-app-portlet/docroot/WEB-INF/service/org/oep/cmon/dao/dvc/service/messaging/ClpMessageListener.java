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

package org.oep.cmon.dao.dvc.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.oep.cmon.dao.dvc.service.CapNhatKetQuaLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.CauHinhPortlet2ThuTucLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ClpSerializer;
import org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil;

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
			CapNhatKetQuaLocalServiceUtil.clearService();

			CauHinhPortlet2ThuTucLocalServiceUtil.clearService();

			DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.clearService();

			DanhMucUngDungLocalServiceUtil.clearService();

			DoiTuongSuDungLocalServiceUtil.clearService();

			NhomThuTucHanhChinhLocalServiceUtil.clearService();

			ThuTuc2GiayToLocalServiceUtil.clearService();

			ThuTucHanhChinhLocalServiceUtil.clearService();

			TTHC2CoQuanQuanLyLocalServiceUtil.clearService();

			TTHC2DoiTuongSuDungLocalServiceUtil.clearService();

			VanBanHuongDanLocalServiceUtil.clearService();
		}
	}
}