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

package org.oep.cmon.portlet.ipmslist.utils;

import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.transaction.TransactionUtils;
import org.oep.cmon.util.CmonFields;
import org.oep.egovcore.util.HSRParamUtil;
import org.oep.egovcore.util.LiferayURL;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

public class HoSoURLUtil {
	
	/**
	 * This is function laHoSoCoTheXemTienTrinhXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheXemTienTrinhXuLy(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		
		return trangThaiHoSo != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW
			&& trangThaiHoSo != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
		;
	}
	
	/**
	 * This is function laHoSoTrucTuyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoTrucTuyen(HoSoTTHCCong hoSo) {
		return hoSo.getLoaiHoSo() == Constants.LOAI_HO_SO_TRUC_TUYEN;
	}
	
	/**
	 * This is function getURLXemChiTietHoSoTrucTuyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request 
	 * @param hoSo
	 * @param backURL
	 * @return LiferayURL
	 */
	public static LiferayURL getURLXemChiTietHoSoTrucTuyen(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
		String
			schemaName = hoSo.getMaUngDung().trim().toLowerCase()
		,	plName = PortalUtil.getPreferences(request).getValue(schemaName + "Name", StringPool.BLANK)
		;
		return LiferayURL
			.createRenderURL(request, plName, null)
			.setParameter(TransactionUtils.PARAM_PORTLET_NAME, schemaName)
			.setParameter(TransactionUtils.PARAM_ID, hoSo.getId())
			.setParameter(TransactionUtils.PARAM_ID_QUY_TRINH, thuTuc.getId())
			.setParameter("maQuyTrinh", thuTuc.getMa())
			.setParameter("backURL", backURL)
		;
	}
	
	/**
	 * This is function getURLTraoDoiThongTin
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request 
	 * @param hoSo
	 * @param backURL
	 * @return LiferayURL
	 */
	public static LiferayURL getURLTraoDoiThongTin(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request, 
			"/html/cmon/ykientraodoi/danh_sach_y_kien.jsp")
			.setParameter("hoSoTTHCCongId", hoSo.getId())
			.setParameter("coQuanTiepNhanId", hoSo.getCoQuanTiepNhanId())
			.setParameter("type", Constants.CAN_BO)
			.setParameter(CmonFields.backURL, backURL)
		;
	}
	
	/**
	 * This is function laHoSoCoTheTraoDoiThongTin
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheTraoDoiThongTin(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		return (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN)
			|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY)
			|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.CHO_THUC_HIEN_LIEN_THONG)
			
			// Khi bi. tu` choi' lien thong
	 		|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_KHONG_XU_LY_DUOC)
		;
	}
	
	
	private static final String DANH_SACH_URL_KEY = "danhSachHoSoURL"; 
	
	/**
	 * This is function getBackURLTaiTrangChiTiet
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @return String
	 */
	public static String getBackURLTaiTrangChiTiet(HttpServletRequest request) {
		String out = HSRParamUtil.getString(request, CmonFields.backURL);
		if (out.isEmpty()) {
			out = (String) request.getSession().getAttribute(DANH_SACH_URL_KEY);
		}
		return out;
	}
	
	/**
	 * This is function storeDanhSachURL
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param url
	 */
	public static void storeDanhSachURL(HttpServletRequest request, String url) {
		request.getSession().setAttribute(DANH_SACH_URL_KEY, url);
	}
}
