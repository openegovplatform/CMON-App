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

import java.util.Date;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.cmon.EgovPortlet;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;
import org.oep.cmon.userreg.portlet.util.CheckCaptchaUtil;
import org.oep.cmon.util.EgovUtil;
import org.oep.egovcore.language.BusinessMessagerUtil;
import org.oep.egovcore.language.CmonMessagerUtil;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class RutHoSoPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class RutHoSoPortlet extends EgovPortlet {
	
	/**
	 * This is function processCanBoRutHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void processCanBoRutHoSo(PortletRequest request, HoSoTTHCCong hoSo) 
		throws PortalException, SystemException
	{
		String emailCanBo = PortalUtil.getUser(request).getEmailAddress();
		
		// Goi Uengine dung` xu? ly'
		HoSoBusinessUtil.dungXuLyHoSo(hoSo, emailCanBo);
		
		hoSo.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RUT_HS);
		hoSo.setYeuCauHuyHoSo(0);
		
		hoSo.setNgaySua(DateTimeUtil.getDateTimeNow());
		hoSo.setNguoiSua(emailCanBo);
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
	}
	
	/**
	 * This is function processCongDanRutHoSoMoiNop
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 */
	public void processCongDanRutHoSoMoiNop(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		if (CheckCaptchaUtil.isTrue(request, RutHoSoFields.captcha)) {
			
			HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(
				ParamUtil.getLong(request, RutHoSoFields.hoSoId));
			
			if (hoSo != null && hoSo.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW) {
				hoSo.setDaXoa(Constants.INACTIVE);
				HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
				ajaxResponse.sendSuccessMessage(BusinessMessagerUtil.get(request, "message.rut_ho_so_thanh_cong"));
			} else {
				ajaxResponse.sendMessage(BusinessMessagerUtil.get(request, "message.rut_ho_so_that_bai"));
			}
			
			ajaxResponse.redirect(ParamUtil.getString(request, RutHoSoFields.redirectURL));
			
		} else {
			ajaxResponse.sendSingleValidateMessage(
				RutHoSoFields.captcha,
				CmonMessagerUtil.get("message.captcha_fail")
			);
		}
	}
	
	/**
	 * This is function processYeuCauRutHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void processYeuCauRutHoSo(ResourceRequest request, AjaxResponse ajaxResponse)
		throws SystemException, PortalException
	{
		if (EgovUtil.laCongChucDangNhap(PortalUtil.getUserId(request))) {
			_xyLyCanBoYeuCauRutHoSo(request, ajaxResponse);
		} else {
			_xuLyCongDanYeuCauRutHoSo(request, ajaxResponse);
		}
	}

	/**
	 * This is function _xyLyCanBoYeuCauRutHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 * @throws PortalException
	 */
	private void _xyLyCanBoYeuCauRutHoSo(ResourceRequest request, AjaxResponse ajaxResponse)
		throws SystemException, PortalException
	{
		if (_luuYeuCauRutHoSo(request)) {
			ajaxResponse.sendSuccessMessage(BusinessMessagerUtil.get(request, "message.gui_yeu_cau_thanh_cong"));
			ajaxResponse.redirect(ParamUtil.getString(request, RutHoSoFields.redirectURL));
		} else {
			handleNonExistResourceRequest(request, ajaxResponse);
		}
	}

	/**
	 * This is function _xuLyCongDanYeuCauRutHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 * @throws PortalException
	 */
	private void _xuLyCongDanYeuCauRutHoSo(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException, PortalException {
		if (CheckCaptchaUtil.isTrue(request, RutHoSoFields.captcha)) {
			if (_luuYeuCauRutHoSo(request)) {
				ajaxResponse.sendSuccessMessage(BusinessMessagerUtil.get(request, "message.gui_yeu_cau_thanh_cong"));
				ajaxResponse.redirect(ParamUtil.getString(request, RutHoSoFields.redirectURL));
			} else {
				handleNonExistResourceRequest(request, ajaxResponse);
			}
		} else {
			ajaxResponse.sendSingleValidateMessage(
				RutHoSoFields.captcha,
				CmonMessagerUtil.get("message.captcha_fail")
			);
		}
	}
	
	/**
	 * This is function _luuYeuCauRutHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @return boolean
	 */
	private boolean _luuYeuCauRutHoSo(ResourceRequest request) throws SystemException, PortalException {
		User liferayUser = PortalUtil.getUser(request);
		HoSoTTHCCong hoSo = 
			HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ParamUtil.getLong(request, RutHoSoFields.hoSoId));
		if (hoSo != null) {
			Date now = DateTimeUtil.getDateTimeNow();
			String email = liferayUser.getEmailAddress();
			
			hoSo.setYeuCauHuyHoSo(Constants.YEU_CAU_HUY_HO_SO);
			hoSo.setNgaySua(now);
			hoSo.setNguoiSua(email);
			HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
			
			String noiDungYKien = ParamUtil.getString(request, RutHoSoFields.yKienYeuCauRut).trim();
			
			if (!noiDungYKien.isEmpty()) {
				YKienTraoDoi yKien = new YKienTraoDoiClp();
				yKien.setId(CounterLocalServiceUtil.increment(YKienTraoDoi.class.getName()));
				yKien.setNoiDungYKien(noiDungYKien);
				yKien.setHoSoTTHCCongId(hoSo.getId());
				
				Long nguoiGuiId = null, nguoiNhanId = null;
				TaiKhoanNguoiDung tknd = 
					TaiKhoanNguoiDungLocalServiceUtil.fetchByLiferayUserId(liferayUser.getUserId());
				boolean nguoiGuiLaCanBoTiepNhan = false;
				
				if (tknd == null) {
					
					nguoiGuiId = 
						CongChucLocalServiceUtil.fetchCongChuc(hoSo.getCanBoTiepNhanId())
							.getTaiKhoanNguoiDungId();
					
					nguoiGuiLaCanBoTiepNhan = true;
					
				} else {
					nguoiGuiId = tknd.getId();
				}
				
				CongChuc canBoNhan = HoSoBusinessUtil.getCanBoDangDuocPhanCongXuLy(hoSo);
				
				if (canBoNhan == null) {
					
					if (nguoiGuiLaCanBoTiepNhan) {
						nguoiNhanId = nguoiGuiId;
					} else {
						canBoNhan = CongChucLocalServiceUtil.fetchCongChuc(hoSo.getCanBoTiepNhanId());
						nguoiNhanId = canBoNhan.getTaiKhoanNguoiDungId();
					}
				} else {
					nguoiNhanId = canBoNhan.getTaiKhoanNguoiDungId();
				}
				
				yKien.setNguoiGuiId(nguoiGuiId);
				yKien.setNguoiNhanId(nguoiNhanId);
				yKien.setLoai(Constants.LOAI_Y_KIEN_TRAO_DOI.RUT_HO_SO);
				yKien.setTieuDe(StringPool.SPACE);
				yKien.setThoiGianGuiYKien(now);
				yKien.setTrangThai(0);
				YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKien);
			}
			
			return true;
		}
		
		return false;
	}
}
