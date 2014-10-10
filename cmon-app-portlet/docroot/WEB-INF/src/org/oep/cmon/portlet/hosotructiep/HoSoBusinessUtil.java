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

package org.oep.cmon.portlet.hosotructiep;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.oep.cmon.Constants;
import org.oep.cmon.portlet.menu.util.MenuConstraint;
import org.oep.egovcore.util.Helper;
import org.oep.egovcore.util.LiferayURL;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.bpm.consumer.uengine.Exception_Exception;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.ProcessInstance;
import vn.dtt.sharedservice.bpm.consumer.uengine.WorkList;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutReference;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * This is class HoSoBusinessUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoBusinessUtil {
	
	public static final String PORTLET_NAME = "HoSoTrucTiepPortlet_WAR_cmonappportlet";
	
	/**
	 * This is function fillThongTinThanhToan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 */
	public static void fillThongTinThanhToan(HoSoTTHCCong hoSo) throws SystemException {
		int phi = 0, lePhi = 0;
		List<ThongTinThanhToan> listThanhToan = ThongTinThanhToanLocalServiceUtil.findByHoSoId(hoSo.getId());
		for (ThongTinThanhToan thanhToan : listThanhToan) {
			if (thanhToan.getLoaiPhi() == Constants.ThongTinThanhToan.LE_PHI) {
				lePhi = (int) thanhToan.getSoTien();
			} else {
				phi = (int) thanhToan.getSoTien();
			}
		}
		hoSo.setLePhi(lePhi);
		hoSo.setPhiHoSo(phi);
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
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLInBienNhan(HttpServletRequest request)
		throws Exception
	{
		return LiferayURL
			.createRenderURL(request, PORTLET_NAME, "/html/portlet/hosotructiep/inGiayBienNhan.jsp")
			.setWindowState(LiferayWindowState.MAXIMIZED)
		;
	}
	
	/**
	 * This is function getURLDanhSachHoSoMoiTiepNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws Exception
	 * @return LiferayURL
	 */
	public static LiferayURL getURLDanhSachHoSoMoiTiepNhan(HttpServletRequest request) 
		throws Exception
	{
		LiferayURL out = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		LayoutReference[] pageRefs = LayoutLocalServiceUtil.getLayouts(
			themeDisplay.getCompanyId(),
			Constants.DEFAULT_PORTLET_NAME,
			Constants.QuanLiHoSo.HSTTHCC_CURRENT_STATUS_PREF_PARAM,
			Integer.toString(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN)
		);
		
		if (pageRefs.length > 0) {
			
			out = LiferayURL
				.createActionURL(request, Constants.MENU_PORTLET_NAME, LiferayURL.DEFAULT_ACTION)
				.setParameter(
					MenuConstraint.SESSION_MENU_SELECTED,
					MenuConstraint.getURL(
						LayoutLocalServiceUtil.getLayout(
							pageRefs[0].getLayoutSoap().getPlid()
						)
					)
				);
			
		} else {
			out = LiferayURL.createRenderURL(
				request,
				Constants.DEFAULT_PORTLET_NAME,
				LiferayURL.DEFAULT_JSP
			);
		}
		
		return out;
	}
	
	/**
	 * This is function laCanBoDangDuocPhanCongXuLyHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param emalCanBo
	 * @param hoSo
	 * @return boolean
	 */
	public static boolean laCanBoDangDuocPhanCongXuLyHoSo(String emalCanBo, HoSoTTHCCong hoSo) {
		String[] dsEmail = getDSEmailCanBoDangDuocPhanCongXuLyHoSo(hoSo);
		
		// Phong truong hop WS UE die thi van lam viec duoc
		if (dsEmail.length == 0) {
			return true;
		} else {
			return Helper.inArray(dsEmail, emalCanBo);
		}
	}
	
	/**
	 * This is function getDSThuTuc2CanBo
	 * Lay danh sach thu tuc cua can bo khac cac thu tuc chung thuc/cong chung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param canBo
	 * @throws Exception
	 * @return List<ThongTinThuTuc>
	 */
	public static List<ThongTinThuTuc> getDSThuTuc2CanBo(CongChuc canBo) throws Exception {
		return ThuTucHanhChinhLocalServiceUtil.getDSThongTinThuTuc2CanBo(canBo);
	}
	
	/**
	 * This is function getCanBoDangDuocPhanCongXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws Exception
	 * @return CongChuc
	 * 		Truong hop chua tiep nhan thi return null
	 * 		Truong hop goi WS Uengine bi loi~ thi return null
	 * 		Nguoc lai return CanBo dang duoc UE phan cong xu ly
	 */
	public static CongChuc getCanBoDangDuocPhanCongXuLy(HoSoTTHCCong hoSo) throws SystemException {
		
		CongChuc out = null;
		
		String emailCanBo = getEmailCanBoDangDuocPhanCongXuLy(hoSo);
		
		List<TaiKhoanNguoiDung> list = 
			TaiKhoanNguoiDungLocalServiceUtil.findByEmail(emailCanBo);
		
		if (list != null && !list.isEmpty()) {
			out = CongChucLocalServiceUtil.fetchByTaiKhoanNguoiDung(list.get(0).getId());
		}
		
		return out;
	}
	
	/**
	 * This is function getCanBoVuaThaoTacVoiHoSo
	 * Lay can bo vua thuc hien thao tac tiep nhan/xu ly ho so
	 * Truong hop chua tiep nhan tra ve null
	 * Truong hop moi tiep nhan thi tra ve can bo tiep nhan
	 * Cac truong hop con lai thi goi WS Uengine de lay can bo vua thuc hien xu ly
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return CongChuc
	 */
	public static CongChuc getCanBoVuaThaoTacVoiHoSo(HoSoTTHCCong hoSo) throws SystemException {
		CongChuc out = null;
		int trangThai = hoSo.getTrangThaiHoSo();
		
		if (hoSo != null && (trangThai != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW) ) {
			
			if (trangThai == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN) {
				out = CongChucLocalServiceUtil.fetchCongChuc(hoSo.getCanBoTiepNhanId());
			} else {
				
				List<WorkList> flow = null;
				
				try {
					IBrms wsUE = WebserviceFactory.getUengineService();
					flow = wsUE.getWorkListByMaHoSo(hoSo.getMaSoHoSo());
				} catch (Exception e) {
					_log.warn("LOI KHI GOI WS UENGINE LAY DANH SACH EMAIL CAN BO DANG DUOC PHAN CONG XU LY: maHoSo@" + hoSo.getMaSoHoSo());
				}
				
				if (flow != null && !flow.isEmpty()) {
					
					// Vua chuyen vao phong chuyen mon, chua duoc xu ly
					if (flow.size() == 1) {
						out = CongChucLocalServiceUtil.fetchCongChuc(hoSo.getCanBoTiepNhanId());
					} else {
						String emailCanBo = flow.get(flow.size() - 2).getEndpoint();
						List<TaiKhoanNguoiDung> list = 
							TaiKhoanNguoiDungLocalServiceUtil.findByEmail(emailCanBo);
							
						if (list != null && !list.isEmpty()) {
							out = CongChucLocalServiceUtil.fetchByTaiKhoanNguoiDung(list.get(0).getId());
						}
					}
				}
			}
		}
		
		return out;
	}
	
	/**
	 * This is function getHoTenCanBoVuaThaoTacVoiHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return String
	 */
	public static String getHoTenCanBoVuaThaoTacVoiHoSo(HoSoTTHCCong hoSo) throws SystemException {
		CongChuc congChuc = getCanBoVuaThaoTacVoiHoSo(hoSo);
		if (congChuc != null) {
			return congChuc.getHoVaTen();
		} else {
			return StringPool.BLANK;
		}
	}
	
	/**
	 * This is function getDSEmailCanBoDangDuocPhanCongXuLyHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @return String[]
	 */
	public static String[] getDSEmailCanBoDangDuocPhanCongXuLyHoSo(HoSoTTHCCong hoSo) {
		
		String[] out = new String[0];
		
		if (hoSo != null 
			&& hoSo.getTrangThaiHoSo() != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW
			&& hoSo.getTrangThaiHoSo() != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
		) {
			try {
				String sql = new StringBuilder("SELECT * FROM bpm_procinst WHERE name='")
					.append(hoSo.getMaSoHoSo())
					.append("'").toString();
				List<ProcessInstance> list = WebserviceFactory.getUengineService().getFromDBBySelectStatement(sql);
				if (list != null && !list.isEmpty()) {
					String dsEmail = list.get(0).getCurrep();
					out = dsEmail.split(StringPool.SEMICOLON);
				}
			} catch (Exception e) {
				_log.warn("LOI KHI GOI WS UENGINE LAY DANH SACH EMAIL CAN BO DANG DUOC PHAN CONG XU LY: maHoSo@" + hoSo.getMaSoHoSo());
			}
		}
		
		return out;
	}
	
	/**
	 * This is function getEmailCanBoDangDuocPhanCongXuLy
	 * Goi WS UE Lay ve email can bo dang duoc phan cong xu ly
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @param resourceResponse
	 * @return String
	 */
	public static String getEmailCanBoDangDuocPhanCongXuLy(HoSoTTHCCong hoSo) {
		
		String out = StringPool.BLANK;
		
		if (hoSo != null 
			&& hoSo.getTrangThaiHoSo() != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW
			&& hoSo.getTrangThaiHoSo() != Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
		) {
			try {
				
				IBrms wsUE = WebserviceFactory.getUengineService();
				
				List<WorkList> flow = wsUE.getWorkListByMaHoSo(hoSo.getMaSoHoSo());

				if (flow != null && !flow.isEmpty()) {
					out = flow.get(flow.size() - 1).getEndpoint();
				}
			} catch (Exception e) {
				_log.warn("LOI KHI GOI WS UENGINE LAY CAN BO DANG DUOC PHAN CONG XU LY: maHoSo@" + hoSo.getMaSoHoSo());
			}
		}
		
		return out;
	}
	
	/**
	 * This is function dungXuLyHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @param emailCanBoThucHien
	 * @throws SystemException
	 */
	public static void dungXuLyHoSo(HoSoTTHCCong hoSo, String emailCanBoThucHien) throws SystemException {
		
		boolean b = true;
		String rootExceptionMessage = StringPool.BLANK;
		
		try {
			
			IBrms wsUE = WebserviceFactory.getUengineService();
			b = wsUE.stopProcessInstance(emailCanBoThucHien, hoSo.getMaSoHoSo());
			
		} catch (Exception e) {
			rootExceptionMessage = "<br>Root Exception Message:" + ExceptionUtils.getRootCauseMessage(e);
			b = false;
			_log.error(e);
		}
		
		if ( !b ) {

			throw new SystemException(
				"LOI KHI GOI WEBSERVICE UENGINE DUNG XU LY HO SO" +
				"<br>WebserviceFactory.getUengineService().stopProcessInstance()" +
				"<br>maHoSo:"+ hoSo.getMaSoHoSo() +
				"<br>emailCanBo:"+ emailCanBoThucHien +
				rootExceptionMessage
			);
		}
	}
	
	/**
	 * This is function getCongDanNopHoSo
	 * get thong tin cong tu CSMS_CONGDAN, 
	 * sau do overwrite bang thong tin cong dan get tu CMON_HOSOTTHCCONG
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return CongDan
	 */
	public static org.oep.cmon.dao.beans.congdan.CongDan getCongDanNopHoSo(HoSoTTHCCong hoSo) throws SystemException {
		
		org.oep.cmon.dao.beans.congdan.CongDan out =
			new org.oep.cmon.dao.beans.congdan.CongDanImpl(CongDanLocalServiceUtil.fetchCongDan(hoSo.getCongDanNopId()));
		
		DonViHanhChinh dvhc;
		Long xaDiaChiId = null, huyenDiaChiId = null, tinhDiaChiId = null;
		String dienThoaiCoDinh, dienThoaiDiDong, dienThoai, email,
		tenXaDiaChi = StringPool.BLANK, tenHuyenDiaChi = StringPool.BLANK, tenTinhDiaChi = StringPool.BLANK;
		
		xaDiaChiId = hoSo.getDiaChiThuongTruNguoiNopId();
		
		if (xaDiaChiId != null) {

			dvhc = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(xaDiaChiId);
			tenXaDiaChi = dvhc.getTen().trim();
			huyenDiaChiId = dvhc.getChaId();
			
			if (huyenDiaChiId != null) {
				
				dvhc = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(huyenDiaChiId);
				tenHuyenDiaChi = dvhc.getTen().trim();
				tinhDiaChiId = dvhc.getChaId();
				
				if (tinhDiaChiId != null) {
					tenTinhDiaChi =
						DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(tinhDiaChiId).getTen().trim();
				
				// Truong hop khong co xa
				} else {
					tinhDiaChiId = huyenDiaChiId;
					huyenDiaChiId = xaDiaChiId;
					tenTinhDiaChi = tenHuyenDiaChi;
					tenHuyenDiaChi = tenXaDiaChi;
				}
				
			// Truong hop khong co huyen va xa
			} else {
				tinhDiaChiId = xaDiaChiId;
				tenTinhDiaChi = tenXaDiaChi;
			}
		}
		
		if (tenXaDiaChi.isEmpty()) {
			tenXaDiaChi = out.getTenXaDiaChi();
		}
		
		if (tenHuyenDiaChi.isEmpty()) {
			tenHuyenDiaChi = out.getTenHuyenDiaChi();
		}
		
		if (tenTinhDiaChi.isEmpty()) {
			tenTinhDiaChi = out.getTenTinhDiaChi();
		}
 		
		dienThoaiCoDinh = hoSo.getSoDienThoaiCoDinhNguoiNop();
		if (dienThoaiCoDinh == null || dienThoaiCoDinh.trim().isEmpty()) {
			dienThoaiCoDinh = out.getDienThoaiCoDinh();
		}
		
		dienThoaiDiDong = hoSo.getSoDienThoaiDiDongNguoiNop();
		if (dienThoaiDiDong == null || dienThoaiDiDong.trim().isEmpty()) {
			dienThoaiDiDong = out.getDienThoaiDiDong();
		}
		
		dienThoai = (dienThoaiDiDong.isEmpty()) ? dienThoaiCoDinh : dienThoaiDiDong;
		
		email = hoSo.getEmailNguoiNop();
		if (email == null || email.isEmpty()) {
			email = out.getEmail();
		}
		
		out.setHoTenDayDu(hoSo.getHoTenNguoiNopHoSo());
		out.setTinhDiaChiId(tinhDiaChiId);
		out.setTenTinhDiaChi(tenTinhDiaChi);
		out.setHuyenDiaChiId(huyenDiaChiId);
		out.setTenHuyenDiaChi(tenHuyenDiaChi);
		out.setXaDiaChiId(xaDiaChiId);
		out.setTenXaDiaChi(tenXaDiaChi);
		out.setDiaChiChiTiet(hoSo.getDiaChiThuongTruNguoiNop());
		out.setDienThoaiCoDinh(dienThoaiCoDinh);
		out.setDienThoaiDiDong(dienThoaiDiDong);
		out.setDienThoai(dienThoai);
		out.setEmail(email);
		
		return out;
	}
	
	/**
	 * This is function getDiaChiDayDuCongDanNopHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return String
	 */
	public static String getDiaChiDayDuCongDanNopHoSo(HoSoTTHCCong hoSo) throws SystemException {
		return getCongDanNopHoSo(hoSo).getDiaChiDayDu();
	}
	
	protected static Log _log = LogFactoryUtil.getLog(HoSoBusinessUtil.class);
}
