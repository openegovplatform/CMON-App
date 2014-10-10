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

package org.oep.cmon.portlet.ipmslist.business;

import java.util.Date;

import javax.portlet.ActionRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.ipmslist.utils.ConvertUtil;
import org.oep.egovcore.util.DateTimeUtil;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class HoSoTTHCCUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoTTHCCUtil {

	/**
	 * This is function getHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 * @return HoSoTTHCCong
	 */
	public static HoSoTTHCCong getHoSo(ActionRequest request)
			throws NumberFormatException, PortalException, SystemException {

		String idHoSo = request.getParameter("IdHoSoTT");
		String nguoinhanketqua = request.getParameter("nguoinhanketqua");
		String email = request.getParameter("email");
		String ngaysinh = request.getParameter("ngaysinh");
		String dienthoaididong = request.getParameter("dienthoaididong");
		String cmnd = request.getParameter("cmnd");
		int gioitinh = ParamUtil.getInteger(request, "gioitinh");
		String dienthoaicodinh = request.getParameter("dienthoaicodinh");
		String diachi = request.getParameter("diachi");
		request.getParameter("tinhId");
		request.getParameter("huyenId");
		String xaId = request.getParameter("xaId");
		request.getParameter("ngaytra");
		request.getParameter("giotra");
		String nguoitra = ParamUtil.getString(request, "nguoitra");
		Date ngaygiotra = DateTimeUtil.getRequestDate(request, "ngaytra",
				"giotra");
		HoSoTTHCCong hoso = null;

		// Get object hoso
		try {
			hoso = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(Long
					.valueOf(idHoSo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// set value into objec hosotthccong into form post
		if (Validator.isNotNull(hoso)) {
			hoso.setHoTenNguoiNhanKetQua(nguoinhanketqua);
			hoso.setDiaChiThuongTruNguoiNhanKQ(diachi);
			hoso.setSoDienThoaiNguoiNhan(dienthoaididong);

			if (PortalUtil.getUser(request) != null) {
				hoso.setTenCanBoTraKetQua(nguoitra);
			}

			hoso.setNgayTraKetQua(ngaygiotra);
			hoso.setDiaChiThuongTruNguoiNhanKQId(Long.getLong(xaId));
			hoso.setEMailNguoiNhan(email);
			hoso.setDienThoiCoDinhNguoiNhan(dienthoaicodinh);
			hoso.setCmndNguoiNhan(cmnd);
			hoso.setGioiTinh(gioitinh);
			hoso.setNgaySinhNguoiNhan(ConvertUtil.parseStringToDate(ngaysinh));
			hoso.setTrangThaiHoSo(Constants.TRANGTHAIHOSO.STATUS_HOSO_DA_TRA_KET_QUA);
		}

		return hoso;
	}

	/**
	 * This is function getFullDiaChi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param diachi
	 * @param idTinh
	 * @param IdHuyen
	 * @param IdXa
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 * @return HoSoTTHCCong
	 */
	public static String getFullDiaChi(String diachi, String idTinh,
			String IdHuyen, String IdXa) throws NumberFormatException,
			PortalException, SystemException {

		if (Validator.isNotNull(IdXa)) {
			if (!IdXa.trim().isEmpty()) {
				diachi = diachi
						+ " "
						+ DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(Long
								.valueOf(IdXa).longValue());
			}
		}

		if (Validator.isNotNull(IdHuyen)) {
			if (!IdHuyen.trim().isEmpty()) {
				diachi = diachi
						+ ", "
						+ DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(Long
								.valueOf(IdHuyen).longValue());
			}
		}

		if (Validator.isNotNull(idTinh)) {
			if (!idTinh.trim().isEmpty()) {
				diachi = diachi
						+ ", "
						+ DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(Long
								.valueOf(idTinh).longValue());
			}
		}

		return diachi;
	}
}
