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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;
import org.oep.cmon.portlet.hosotructiep.HoSoFields;
import org.oep.egovcore.util.LiferayURL;

import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * This is class HoSoMotCuaURLUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoMotCuaURLUtil extends HoSoURLUtil {
	
	/**
	 * This is function laHoSoCanTiepNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCanTiepNhan(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		
		return trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_MOI_DANG_KY_TRUC_TUYEN
			|| trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_BO_XUNG_CHO_TN
		;
	}
	
	/**
	 * This is function laHoSoCanChuyenPhongChuyenMon
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCanChuyenPhongChuyenMon(HoSoTTHCCong hoSo) {
		return (hoSo.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN);
	}
	
	/**
	 * This is function laHoSoCanTraKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean laHoSoCanTraKetQua(HoSoTTHCCong hoSo) throws SystemException {
		boolean daXuLyXong = (hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG);
		
		if (daXuLyXong) {
			return true;
		} else {
			ThuTucHanhChinh thuTuc = 
				ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
			return thuTuc.getUengineProcessName().trim().isEmpty();
		}
	}
	
	/**
	 * This is function getURLTraKetQua
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
	public static LiferayURL getURLTraKetQua(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request,
			"/html/portlet/ipmslistportlet/offline/traKetQua.jsp")
			.setParameter("HosotthcCongId", hoSo.getId())
			.setParameter("ulrRollBack", backURL);
	}
	
	/**
	 * This is function laHoSoCoTheTuChoi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheTuChoi(HoSoTTHCCong hoSo) {
		return laHoSoCanTiepNhan(hoSo);
	}
	
	/**
	 * This is function getURLTuChoi
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
	public static LiferayURL getURLTuChoi(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request,
			"/html/cmon/tuchoi/tuchoihoso_form.jsp")
			.setParameter("idHoSo", hoSo.getId())
			.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_MOT_CUA)
			.setParameter("ulrRoleBack", backURL);
	}
	
	/**
	 * This is function laHoSoCoTheXemYKienTuChoi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheXemYKienTuChoi(HoSoTTHCCong hoSo) {
		return hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_KHONG_TIEP_NHAN;
	}
	
	/**
	 * This is function getURLXemYKienTuChoi
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
	public static LiferayURL getURLXemYKienTuChoi(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request,
			"/html/cmon/tuchoi/xem_tuchoihoso.jsp")
			.setParameter("idHoSo", hoSo.getId())
			.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_MOT_CUA)
			.setParameter("ulrRoleBack", backURL);
	}
	
	/**
	 * This is function laHoSoCanTiepNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheInBienNhan(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		
		return 
			hoSo.getLoaiHoSo() == Constants.LOAI_HO_SO_TRUC_TIEP 
			 && (trangThaiHoSo == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY
			 	|| trangThaiHoSo == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
			 	|| trangThaiHoSo == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED
			 )
		;
	}
	
	/**
	 * This is function getURLInBienNhan
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
	public static LiferayURL getURLInBienNhan(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return HoSoBusinessUtil.getURLInBienNhan(request)
			.setParameter(HoSoFields.hoSoId, hoSo.getId())
			.setParameter("backURL", backURL);
	}
	
	/**
	 * This is function laHoSoCanTiepNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws Exception
	 * @return boolean
	 */
	public static boolean laHoSoCoTheXemYeuCauBoSung(HoSoTTHCCong hoSo) {
		return hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG;
	}
	
	/**
	 * This is function getURLXemYeuCauBoSung
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
	public static LiferayURL getURLXemYeuCauBoSung(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request,
			"/html/cmon/yeucaubosung/xem_bosunghoso.jsp")
			.setParameter("idHoSo", hoSo.getId())
			.setParameter("ulrRoleBack", backURL);
	}
	
	/**
	 * This is function laHoSoCoTheInPhieuLuuChuyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheInPhieuLuuChuyen(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		return trangThaiHoSo == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
			|| trangThaiHoSo == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED
		;
	}
	
	/**
	 * This is function getURLInPhieuLuuChuyen
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
	public static LiferayURL getURLInPhieuLuuChuyen(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request, 
			"/html/portlet/ipmslistportlet/inPhieuLuuChuyen.jsp")
			.setParameter("hoSoId", hoSo.getId())
			.setParameter("loaiCanBo", Constants.CAN_BO)
			.setParameter("backUrl", backURL);
	}
	
	/**
	 * This is function laHoSoCoTheDoiChieu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laHoSoCoTheDoiChieu(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		
		return trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_MOI_DANG_KY_TRUC_TUYEN
			|| trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN
			|| trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY 
		;
	}
	
	/**
	 * This is function getURLDoiChieu
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
	public static LiferayURL getURLDoiChieu(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		LiferayURL doiChieuHoSoURL = null;
		if (ConvertUtil.checkLoaiDoiTuongCongDan(hoSo.getThuTucHanhChinhId(), "003")
			&& hoSo.getDoiTuongCanXuLyId() != null
			&& hoSo.getDoiTuongCanXuLyId() > 0
		) {
			doiChieuHoSoURL = LiferayURL.createRenderURL(request, "/html/portlet/ipmslistportlet/company/doiChieuHoSoChiTiet.jsp");
		} else {
			doiChieuHoSoURL = LiferayURL.createRenderURL(request, "/html/portlet/ipmslistportlet/offline/doiChieuHoSoChiTiet.jsp");
		}
		doiChieuHoSoURL.setParameter("HosotthcCongId", hoSo.getId());
		doiChieuHoSoURL.setParameter("backUrl", backURL);
		
		return doiChieuHoSoURL;
	}
	
	public static boolean laHoSoCoTheTaiKetQuaSo(HoSoTTHCCong hoSo) {
		return _laHoSoDaXuLyXong(hoSo);
	}
	
	/**
	 * This is function getURLTaiKetQuaSo
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
	public static LiferayURL getURLTaiKetQuaSo(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		LiferayURL taiKetQuaSoURL = null;
		if (ConvertUtil.checkLoaiDoiTuongCongDan( hoSo.getThuTucHanhChinhId(), "003")
			&& hoSo.getDoiTuongCanXuLyId() != null
			&& hoSo.getDoiTuongCanXuLyId() > 0
		) {
			taiKetQuaSoURL = LiferayURL.createRenderURL(request, "/html/portlet/ipmslistportlet/company/taiFileKetQua.jsp");
		} else {
			taiKetQuaSoURL = LiferayURL.createRenderURL(request, "/html/portlet/ipmslistportlet/offline/taiFileKetQua.jsp");
		}		
		taiKetQuaSoURL.setParameter("HosotthcCongId", hoSo.getId());
		
		return taiKetQuaSoURL;
	}
	
	/**
	 * This is function laHoSoCoTheThuTien
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean laHoSoCoTheThuTien(HoSoTTHCCong hoSo) throws SystemException {
		if ( !_laHoSoDaXuLyXong(hoSo) ) {
			return false;
		}
		
		List<TTHC2CoQuanQuanLy> dsThuTuc2CoQuan = 
			TTHC2CoQuanQuanLyLocalServiceUtil.findByCoQuanAndThuTuc(
				hoSo.getThuTucHanhChinhId().longValue(),
				hoSo.getCoQuanTiepNhanId().longValue()
		);

		return dsThuTuc2CoQuan != null 
			&& !dsThuTuc2CoQuan.isEmpty() 
			&& dsThuTuc2CoQuan.get(0).getPhi() > 0
		;
	}
	
	/**
	 * This is function getURLThuTien
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
	public static LiferayURL getURLThuTien(HttpServletRequest request, HoSoTTHCCong hoSo, String backURL)
		throws Exception
	{
		return LiferayURL.createRenderURL(request, 
			"/html/portlet/thongtinthanhtoan/xacnhanphitienmat.jsp")
			.setParameter("hoSoTTHCCongId", hoSo.getId())
			.setParameter("typePhi", 1)
			.setParameter("parentUrl", backURL);
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
			.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_MOT_CUA)
		;
	}
	
	/**
	 * This is function _laHoSoDaXuLyXong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return boolean
	 */
	private static boolean _laHoSoDaXuLyXong(HoSoTTHCCong hoSo) {
		int trangThaiHoSo = hoSo.getTrangThaiHoSo();
		
		return trangThaiHoSo == Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG 
			&& !hoSo.getDungXuLy()
		;
	}
}
