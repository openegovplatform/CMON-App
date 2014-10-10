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

package org.oep.cmon.portlet.ruthoso;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.egovcore.util.LiferayURL;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

/**
 * This is class RutHoSoBusinessUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class RutHoSoBusinessUtil {
	
	public static final String JSP_PATH_YEUCAURUT = "/html/cmon/rutHoSo/yeuCauRut.jsp";
	public static final String JSP_PATH_BUTTONS = "/html/cmon/rutHoSo/rutHoSoButtons.jsp";
	public static final String PORTLET_NAME = "RutHoSoPortlet_WAR_cmonappportlet";
	
	/**
	 * This is function laHoSoDaYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoDaYeuCauRut(HoSoTTHCCong hoSo) {
		boolean out = false;
		if (hoSo != null) {
			out = hoSo.getYeuCauHuyHoSo() == Constants.YEU_CAU_HUY_HO_SO;
		}
		return out;
	}
	
	/**
	 * This is function getURLTraHoSoDaYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSoId
	 * @param trangThaiHoSo
	 * @throws Exception
	 * @return String
	 */
	public static String getURLTraHoSoDaYeuCauRut(HttpServletRequest request, long hoSoId, int trangThaiHoSo)
		throws Exception
	{
		return LiferayURL
			.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, "/html/portlet/ipmslistportlet/offline/traKetQua.jsp")
			.setParameter("HosotthcCongId", hoSoId)
			.setParameter("statusHS", trangThaiHoSo)
			.setParameter(RutHoSoFields.laRutHoSo, 1)
			.toString()
		;
	}
	
	/**
	 * This is function getURLCongDanYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSoId
	 * @param backURL
	 * @throws Exception
	 * @return String
	 */
	public static String getURLCongDanYeuCauRut(HttpServletRequest request, long hoSoId, String backURL)
		throws Exception
	{
		return LiferayURL
			.createRenderURL(request, "transactionportlet_WAR_cmonappportlet", JSP_PATH_YEUCAURUT)
			.setParameter(RutHoSoFields.hoSoId, hoSoId)
			.setParameter(RutHoSoFields.redirectURL, backURL)
			.toString();
	}
	
	/**
	 * This is function getURLCanBoYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSoId
	 * @param backURL
	 * @throws Exception
	 * @return String
	 */
	public static String getURLCanBoYeuCauRut(HttpServletRequest request, long hoSoId, String backURL)
		throws Exception
	{
		return LiferayURL
			.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, JSP_PATH_YEUCAURUT)
			.setParameter(RutHoSoFields.hoSoId, hoSoId)
			.setParameter(RutHoSoFields.redirectURL, backURL)
			.toString();
	}
	
	/**
	 * This is function getURLCanBoYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSoId
	 * @param backURL
	 * @throws Exception
	 * @return String
	 */
	public static String getURLCanBoYeuCauRut(PortletRequest request, long hoSoId, String backURL)
		throws Exception
	{
		return LiferayURL
			.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, JSP_PATH_YEUCAURUT)
			.setParameter(RutHoSoFields.hoSoId, hoSoId)
			.setParameter(RutHoSoFields.redirectURL, backURL)
			.toString();
	}
	
	/**
	 * This is function laHoSoCongDanDuocPhepYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCongDanDuocPhepYeuCauRut(HoSoTTHCCong hoSo) {
		
		boolean out = false;
		if (hoSo != null) {
			int trangThai = hoSo.getTrangThaiHoSo();
			out = !laHoSoDaYeuCauRut(hoSo)
				&& (
					trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED
					|| trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY
					|| trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG
					|| trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN 
			);
		}
		return out;
	}
	
	/**
	 * This is function laHoSoCanBoDuocPhepYeuCauRut
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCanBoDuocPhepYeuCauRut(HoSoTTHCCong hoSo) {
		boolean out = false;
		if (hoSo != null) {
			int trangThai = hoSo.getTrangThaiHoSo();
			out = !laHoSoDaYeuCauRut(hoSo)
				&& (
					trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED
					|| trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY
					|| trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG
			);
		}
		return out;
	}
	
	/**
	 * This is function laHoSoCanBoDuocPhepRutNgay
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCanBoDuocPhepRutNgay(HoSoTTHCCong hoSo) {
		boolean out = false;
		if (hoSo != null) {
			return !laHoSoDaYeuCauRut(hoSo) 
				&& hoSo.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN;
		}
		return out;
	}
	
	/**
	 * This is function laHoSoCongDanDuocPhepRutNgay
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCongDanDuocPhepRutNgay(HoSoTTHCCong hoSo) {
		boolean out = false;
		if (hoSo != null) {
			return !laHoSoDaYeuCauRut(hoSo) 
				&& hoSo.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW;
		}
		return out;
	}
}
