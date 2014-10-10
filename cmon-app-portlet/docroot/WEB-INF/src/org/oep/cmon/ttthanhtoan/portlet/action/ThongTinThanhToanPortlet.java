/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.ttthanhtoan.portlet.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToanClp;

import org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class ThongTinThanhToanPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ThongTinThanhToanPortlet extends MVCPortlet {
 
	private static DateFormat dateType = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * This is function xacNhanNopTien
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void xacNhanNopTien(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			Long hoSoTTHCCongId = ParamUtil.getLong(actionRequest, "hoSoTTHCCongId");
//			HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoTTHCCongId);
			
			Long thongTinThanhToanId = ParamUtil.getLong(actionRequest, "thongTinThanhToanId");
			Long typePhi = ParamUtil.getLong(actionRequest, "typePhi");
			Long loaiThanhToan = ParamUtil.getLong(actionRequest, "loaithanhtoan");
			
			ThongTinThanhToan thongTinThanhToan = null;
			boolean isNew = false;
			if (thongTinThanhToanId == null || thongTinThanhToanId == 0) {
				thongTinThanhToan = new ThongTinThanhToanClp();
				thongTinThanhToanId = CounterLocalServiceUtil.increment(ThongTinThanhToan.class.getName());
				thongTinThanhToan.setId(thongTinThanhToanId);
				thongTinThanhToan.setHoSoTTHCCongId(hoSoTTHCCongId);
				thongTinThanhToan.setLoaiPhi(typePhi);
//				thongTinThanhToan.setLoaiThanhToan(loaiThanhToan);
				thongTinThanhToan.setNguoiTao(PortalUtil.getUser(actionRequest).getFullName());
				thongTinThanhToan.setNgayTao(new Date());
				thongTinThanhToan.setNgayThuTien(new Date());
				isNew = true;
				
			} else {
				 thongTinThanhToan = 
						ThongTinThanhToanLocalServiceUtil.getThongTinThanhToan(thongTinThanhToanId);
			}
			// set loai thanh toan
			thongTinThanhToan.setLoaiThanhToan(loaiThanhToan);
			
			// Set "nguoi nop tien"
			String tenNguoiNopTien = ParamUtil.getString(actionRequest, "nguoinoptien");
			if (tenNguoiNopTien != null || ! "".equals(tenNguoiNopTien)) {
				thongTinThanhToan.setTenNguoiNopTien(tenNguoiNopTien);
			}
			
			// Set "ngay thu tien"
			Date ngayThuTien = ParamUtil.getDate(actionRequest, "ngaythutien", dateType);
			if (ngayThuTien == null) {
				thongTinThanhToan.setNgayThuTien(ngayThuTien);
			}
			
			// Set "can bo xac nhan"
			thongTinThanhToan.setTenCanBoNhanTien(ParamUtil.getString(actionRequest, "canboxacnhan"));
			
			// Set "so tien"
			if (ParamUtil.getLong(actionRequest, "sotien") > 0) {
				thongTinThanhToan.setSoTien(ParamUtil.getLong(actionRequest, "sotien"));
			}

			// Set "xac nhan"
			Integer xacNhan = ParamUtil.getInteger(actionRequest, "xacnhan");
			if (actionRequest.getParameter("xacnhan") == null) {
				// mark da xac nhan: handle for "nop tien mat"
				xacNhan = 1;
			}
			thongTinThanhToan.setXacNhan(xacNhan);
			
			// Set "ngay xac nhan"
			Date ngayXacNhan = ParamUtil.getDate(actionRequest, "ngayxacnhan", dateType);
			if (ngayXacNhan == null) {
				ngayXacNhan = new Date();
			}
			thongTinThanhToan.setNgayXacNhan(ngayXacNhan);
			
			// Set "Y kien"
			if (ParamUtil.getString(actionRequest, "ykien") != null ||
					!"".equals(ParamUtil.getString(actionRequest, "ykien"))) {
				thongTinThanhToan.setYKien(ParamUtil.getString(actionRequest, "ykien"));
			}
			
			// add new record
			if (isNew) {
				ThongTinThanhToanLocalServiceUtil.addThongTinThanhToan(thongTinThanhToan);
				
			} else {
				// update data
				ThongTinThanhToanLocalServiceUtil.updateThongTinThanhToan(thongTinThanhToan);
			}

			// response data
			actionResponse.setRenderParameter("hoSoTTHCCongId", hoSoTTHCCongId.toString());
			actionResponse.setRenderParameter("thongTinThanhToanId", thongTinThanhToanId.toString());
			actionResponse.setRenderParameter("typePhi", typePhi.toString());
			SessionMessages.add(actionRequest, "successUpdateTTTK");	
			actionResponse.setRenderParameter("parentUrl", ParamUtil.getString(actionRequest, "parentUrl"));
			
			// set status submit's ok
			actionResponse.setRenderParameter("submitStatus", "1");
			
			actionResponse.setRenderParameter("jspPage", ParamUtil.getString(actionRequest, "targetPage"));

		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorUpdateTTTK");
			actionResponse.setRenderParameter("jspPage", ParamUtil.getString(actionRequest, "targetPage"));
		}
	}
}
