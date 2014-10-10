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
import org.oep.egovcore.util.LiferayURL;

import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc;
import org.oep.cmon.dao.dvc.service.CauHinhPortlet2ThuTucLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * This is class HoSoXuLyURLUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoXuLyURLUtil extends HoSoURLUtil {
	
	/**
	 * This is function laHoSoCanLuanChuyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCanLuanChuyen(HoSoTTHCCong hoSo) {
		return _laHoSoDangXuLyVaKhongCoYeuCauBoSung(hoSo)
			&& hoSo.getYeuCauHuyHoSo() == 0
		;
	}
	
	/**
	 * This is function getURLLuanChuyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @param backURL
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLLuanChuyen(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL) 
		throws Exception
	{
		return LiferayURL.createRenderURL(request, 
			"/html/portlet/ipmslistportlet/offline/luanChuyen.jsp")
			.setParameter("HosotthcCongId", hoSo.getId())
			.setParameter("backJspPage", backURL);
	}
	
	/**
	 * This is function laHoSoCoTheYeuCauBoSung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheYeuCauBoSung(HoSoTTHCCong hoSo) {
		return (
				_laHoSoDangXuLyVaKhongCoYeuCauBoSung(hoSo)

				// Khi bi. tu` choi' lien thong
		 		|| (hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_KHONG_XU_LY_DUOC)
	 		)
	 		
	 		&& hoSo.getYeuCauHuyHoSo() == 0
		;
	}
	
	/**
	 * This is function getURLYeuCauBoSung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @param backURL
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLYeuCauBoSung(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL) 
		throws Exception
	{
		return LiferayURL.createRenderURL(request, 
			"/html/cmon/yeucaubosung/bosunghoso_form.jsp")
			.setParameter("idHoSo", hoSo.getId())
			.setParameter("ulrRoleBack", backURL)
			.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_CAN_BO_XU_LY);
	}
	
	/**
	 * This is function laHoSoCoTheLuuTaiLieu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheLuuTaiLieu(HoSoTTHCCong hoSo) {
		return _laHoSoDangXuLyVaKhongCoYeuCauBoSung(hoSo)
			&& hoSo.getYeuCauHuyHoSo() == 0
		;
	}
	
	/**
	 * This is function getURLLuuTaiLieu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @param backURL
	 * @throws Exception
	 * return LiferayURL
	 */
	public static LiferayURL getURLLuuTaiLieu(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL) 
		throws Exception
	{
		return LiferayURL.createRenderURL(request, 
			"/html/cmon/upload/dangxuly_upload_form.jsp")
			.setParameter("HosotthcCongId", hoSo.getId())
			.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_CAN_BO_XU_LY)
			.setParameter("backUrl", backURL);
	}
	
	/**
	 * This is function laHoSoCoTheCapChungChiGiayPhep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws PortalException
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean laHoSoCoTheCapChungChiGiayPhep(HoSoTTHCCong hoSo) 
		throws PortalException, SystemException
	{
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		return (
				trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY
			|| trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN
			)
			&& hoSo.getYeuCauHuyHoSo() == 0
		;
	}
	
	/**
	 * This is function getURLCapChungChiGiayPhep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @param backURL
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLCapChungChiGiayPhep(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL) 
		throws Exception
	{
		CauHinhPortlet2ThuTuc cauHinh = CauHinhPortlet2ThuTucLocalServiceUtil
			.fetchCauHinhPortlet2ThuTuc(hoSo.getThuTucHanhChinhId());
		
		LiferayURL out = null;
		if ( (cauHinh != null) && (LiferayURL.isPortletAddedToPage(request, cauHinh.getPortletName())) ) {
			out = LiferayURL
				.createRenderURL(request, cauHinh.getPortletName(), LiferayURL.DEFAULT_JSP)
				.setParameter("hosoId", hoSo.getId())
				.setParameter("backUrl", backURL);
		}
		return out;
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
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLTraoDoiThongTin(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return HoSoURLUtil.getURLTraoDoiThongTin(request, hoSo, backURL)
			.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_CAN_BO_XU_LY)
		;
	}
	
	/**
	 * This is function laHoSoCoTheDungXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheDungXuLy(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		return (
				(trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG) 
				|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN) 
		 		|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY)
		 		
		 		// Khi bi. tu` choi' lien thong
		 		|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_KHONG_XU_LY_DUOC)
		 	)
	 		&& hoSo.getYeuCauHuyHoSo() == 0
		;
	}
	
	/**
	 * This is function getURLDungXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @param backURL
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLDungXuLy(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception 
	{
		return LiferayURL.createRenderURL(request, 
			"/html/portlet/ipmslistportlet/detailsHoSo/Hosodungxuly.jsp")
			.setParameter("idHoSo", hoSo.getId())
			.setParameter("ulrRollBack", backURL);
	}
	
	/**
	 * This is function _laHoSoDangXuLyVaKhongCoYeuCauBoSung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	private static boolean _laHoSoDangXuLyVaKhongCoYeuCauBoSung(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		return (trangThaiHoSo != Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG)
			&& ((trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN)
			|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY)
			|| (trangThaiHoSo == Constants.TRANGTHAIHOSO.CHO_THUC_HIEN_LIEN_THONG)
		)
		;
	}
}
