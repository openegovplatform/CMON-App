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

package org.oep.cmon.portlet.ipmslist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.Constants;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiImpl;
import org.oep.cmon.portlet.cmon.EgovPortlet;
import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.portlet.hosolienthong.HSLTFields;
import org.oep.cmon.portlet.hosolienthong.HoSoLienThongPortlet;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;
import org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness;
import org.oep.cmon.portlet.ipmslist.business.TraKetQuaXuLy;
import org.oep.cmon.portlet.ipmslist.utils.TichHopLaiXeUtil;
import org.oep.cmon.portlet.ruthoso.RutHoSoPortlet;
import org.oep.cmon.portlet.transaction.TransactionUtils;
import org.oep.cmon.util.ComUtils;
import org.oep.cmon.util.EgovUtil;
import org.oep.cmon.util.MaSoBienNhanUtil;
import org.oep.config.ConfigUtils;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucClp;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.bpm.consumer.uengine.Exception_Exception;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrmsService;
import vn.dtt.sharedservice.bpm.consumer.uengine.WorkList;
import vn.dtt.sharedservice.cmon.consumer.officer.GiayToDinhKem;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class IPMSListPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IPMSListPortlet extends EgovPortlet {
	
	/**
	 * This is function getDonViHanhChinhById
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void getDonViHanhChinhById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		String id = ParamUtil.getString(resourceRequest, "id");

		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();

		// Danh sach don vi hanh chinh
		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		List<DonViHanhChinh> dsDVHC = formOfflineBusiness
				.findDonViHanhChinhByChaId(Long.parseLong(id));

		for (DonViHanhChinh item : dsDVHC) {
			_id.put(item.getId());
			_name.put(item.getTen());
		}
		jsonFeed.put("id", _id);
		jsonFeed.put("name", _name);

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(httpReq);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function rollBackList
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
	public void rollBackList(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

	}

	/**
	 * This is function dungXuLyHoSo
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
	public void dungXuLyHoSo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String ykiencanbo = "";
		String idHoSo = "";
		HoSoTTHCCong hoso = null;
		String fileName = "";
		
		UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
		idHoSo = uploadRequest.getParameter("idHoSoTTHCC");
		fileName = uploadRequest.getFileName("upLoadDungXuLy");

		if (!idHoSo.isEmpty()) {
			hoso = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(Long
					.valueOf(idHoSo).intValue());

			if (hoso != null) {
				hoso.setDungXuLy(true);
				hoso.setTrangThaiHoSo(Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG);
				hoso.setNgaySua(new Date());
				HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoso);
				
				// dung xu ly UE
				HoSoBusinessUtil.dungXuLyHoSo(hoso, PortalUtil.getUser(actionRequest).getEmailAddress());
			}
		}

		// urlQuaylai = ParamUtil.getString(actionRequest, "urlQuayLai");
		ykiencanbo = uploadRequest.getParameter("ykiencanbo");
		String contentType = actionRequest.getContentType();
		GiayToDinhKem resulUpload = null;
		byte dataBytes[] = null;

		if ((contentType != null) && 
				(contentType.indexOf("multipart/form-data") >= 0)) {
		
			dataBytes = FileUtil.getBytes(uploadRequest
					.getFileAsStream("upLoadDungXuLy"));

			if (dataBytes != null) {
				resulUpload = WebserviceFactory.getOfficerService().upload(
						getMaUngDung(hoso.getThuTucHanhChinhId()), 1, null,
						PortalUtil.getUserId(uploadRequest), fileName,
						"Hoan tat dung xu ly", dataBytes, fileName);
			}
		}
		
		// Get y kien trao doi
		YKienTraoDoi yKienTraoDoi = new YKienTraoDoiClp();
		yKienTraoDoi.setId(CounterLocalServiceUtil
				.increment(YKienTraoDoi.class.getName()));
		yKienTraoDoi.setHoSoTTHCCongId(hoso.getId());
		yKienTraoDoi.setNoiDungYKien(ykiencanbo);
		yKienTraoDoi.setThoiGianGuiYKien(new Date());
		yKienTraoDoi.setTieuDe("Dung xu ly ho so");

		if (resulUpload != null)
			yKienTraoDoi.setNoiLuuTruId(resulUpload.getId());

		yKienTraoDoi
				.setLoai(Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_DUNG_XU_LY_HO_SO);

		// get tai khoan cong dan nop ho so
		if (PortalUtil.getUser(actionRequest) != null) {
			TaiKhoanNguoiDung taikhoan = TaiKhoanNguoiDungLocalServiceUtil.
					findByTaiKhoanNguoiDungId(PortalUtil.getUser(actionRequest).getUserId());
			
			if (taikhoan != null) {
				yKienTraoDoi.setNguoiGuiId(taikhoan.getId());
				
			}
		}
		
		CongChuc congChuc = CongChucLocalServiceUtil.getCongChuc(hoso.getCanBoTiepNhanId());
		TaiKhoanNguoiDung taiKhoanNguoiDungCD = TaiKhoanNguoiDungLocalServiceUtil
				.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
				
		yKienTraoDoi.setNguoiNhanId(taiKhoanNguoiDungCD.getId());

		yKienTraoDoi.setChaiId(null);

		//yKienTraoDoi.setNguoiNhanId(hoso.getCongDanNopId());//Dung trong du lieu that
		// yKienTraoDoi.setChaiId(null);
		// y kien chua doc
		yKienTraoDoi.setTrangThai(0);

		// Add y kien dung xu li
		YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);

		// Add giay to dinh kem ho so
/*			FileDinhKem giayToDinhKem = new FileDinhKemClp();
			// vn.dtt.cmon.dao.hosohcc.FileDinhKem
			giayToDinhKem.setId(CounterLocalServiceUtil
					.increment(FileDinhKem.class.getName()));
			giayToDinhKem.setHoSoTTHCCongId(Long.valueOf(idHoSo));
			giayToDinhKem.setSoBanGiay(1L);

			if (PortalUtil.getUser(actionRequest) != null)
				giayToDinhKem.setCanBoId(Long.valueOf(PortalUtil
						.getUserId(actionRequest)));

			giayToDinhKem
					.setTrangThaiHoSoTaiThoiDiemDinhKem(Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG);

			if (resulUpload.getNoiLuuTruId() != 0)
				giayToDinhKem.setNoiLuuTruTaiLieuId(Long.valueOf(resulUpload
						.getId()));

			if (PortalUtil.getUser(actionRequest) != null)
				giayToDinhKem.setNguoiUpload(String.valueOf(PortalUtil
						.getUserId(actionRequest)));

			giayToDinhKem.setNgayUpload(new Date());
			FileDinhKemLocalServiceUtil.addFileDinhKem(giayToDinhKem);*/
		
		// }

	}

	/**
	 * This is function uploadLoadFileKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void uploadLoadFileKetQua(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.uploadLoadFileKetQua(resourceRequest, httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function uploadLoadFileKetQuaDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void uploadLoadFileKetQuaDoanhNghiep(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.uploadLoadFileKetQuaDoanhNghiep(resourceRequest,
				httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function doiChieuHoSoRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void doiChieuHoSoRequest(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.doiChieuHoSoRequest(resourceRequest, httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function doiChieuHoSoDoanhNghiepRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void doiChieuHoSoDoanhNghiepRequest(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.doiChieuHoSoDoanhNghiepRequest(resourceRequest,
				httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function addTaiLieuUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void addTaiLieuUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.addFileUpload(resourceRequest, httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function addTaiLieuDoanhNghiepUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void addTaiLieuDoanhNghiepUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.addFileDoanhNghiepUpload(resourceRequest, httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function traHoSoRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void traHoSoRequest(ActionRequest resourceRequest,
			ActionResponse reponse) throws NumberFormatException, Exception {

		TraKetQuaXuLy traketqua = new TraKetQuaXuLy(resourceRequest, true);

		if (!traketqua.validTraKetQua(resourceRequest)) {
			// resourceRequest.getPortletSession().setAttribute(Constants.SESSION_KEY.KEY_TRAKETQUA,
			// traketqua);
			resourceRequest.setAttribute(
					Constants.SESSION_KEY.KEY_TRAKETQUA, traketqua);
			reponse.setRenderParameter("jspPage",
					Constants.PATH_TRA_KET_QUA.PATH_TRA_KET_QUA);
		} else {
			
			HoSoTTHCCong hosoTTHCC = traketqua.getHoSo();
			boolean laChucNangRutHoSo = (hosoTTHCC.getYeuCauHuyHoSo() == Constants.YEU_CAU_HUY_HO_SO); 
			boolean laHoSoCanTraKQLienThong = ParamUtil.getBoolean(resourceRequest, HSLTFields.laHoSoCanTraKQLienThong);
			
			if (laHoSoCanTraKQLienThong) {
				HoSoLienThongPortlet.processTraKetQuaLienThong(resourceRequest, hosoTTHCC);
			} else {
				if (laChucNangRutHoSo) {
					RutHoSoPortlet.processCanBoRutHoSo(resourceRequest, hosoTTHCC);
				} else {
					traketqua.saveTraKetQua();
				}
			}
			
			reponse.setRenderParameter("jspPage",
					Constants.PATH_TRA_KET_QUA.PATH_AFTER_TRA_KET_QUA);
		}
	}
	/**
	 * This is function traHoSoDoanhNghiepRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void traHoSoDoanhNghiepRequest(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.traHoSoDoanhNghiepRequest(resourceRequest, httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function searchMaDichVuCongRequest
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
	public void searchMaDichVuCongRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String searchKeyWord = ParamUtil.getString(actionRequest,
				"searchKeyWord").trim();
		String transactionKeyword = ParamUtil.getString(actionRequest,
				"transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType")
				.trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();

		actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/ipmslistportlet/offline/nopHoSoOffline.jsp");
		actionResponse.setRenderParameter("transactionKeyword",
				transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("statusHS", statusHS);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function searchCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().searchCongDanRequest(actionRequest,
				actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function searchCongDanNop
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
	public void searchCongDanNop(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().searchCongDanNopRequest(actionRequest,
				actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function searchCongTy
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
	public void searchCongTy(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().searchDoanhNghiepRequest(actionRequest,
				actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function addHoSoRequest
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
	public void addHoSoRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().addHoSoRequest(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function addHoSoDoanhNghiepRequest
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

	public void addHoSoDoanhNghiepRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().addHoSoDoanhNghiepRequest(actionRequest,
				actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function addCongDanRequest
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

	public void addCongDanRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().addCongDanRequest(actionRequest,
				actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function addDoanhNghiepRequest
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

	public void addDoanhNghiepRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		new FormOfflineBusiness().addDoanhNghiepRequest(actionRequest,
				actionResponse);
		PortletConfig portletConfig = (PortletConfig) actionRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function uploadTaiLieu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */

	public void uploadTaiLieu(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.singleFileUpload(resourceRequest, httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is function uploadTaiLieuDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void uploadTaiLieuDoanhNghiep(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		formOfflineBusiness.singleFileUploadDoanhNghiep(resourceRequest,
				httpReq);
		PortletConfig portletConfig = (PortletConfig) resourceRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is function checkFileUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void checkFileUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		JSONObject jsonFeed = formOfflineBusiness.checkFileUpload(
				resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(httpReq);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function deleteFileUploadKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void deleteFileUploadKetQua(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		JSONObject jsonFeed = formOfflineBusiness.deleteFileUploadKetQua(
				resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(httpReq);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function deleteFileUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void deleteFileUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		JSONObject jsonFeed = formOfflineBusiness.deleteFileUpload(
				resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(httpReq);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function deleteFileUploadById
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void deleteFileUploadById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
		JSONObject jsonFeed = formOfflineBusiness.deleteFileUploadById(
				resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(httpReq);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function getPhanHoiDetails
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void getPhanHoiDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String idPhanHoi = ParamUtil.getString(actionRequest, "idPhanHoi");
		ArrayList<String> errors = new ArrayList<String>();
		Long ykienTraodoiId = Long.parseLong(idPhanHoi);
		// LanguageUtil.get(pageContext,
		// "vn.dtt.brms.registry.viewTransaction.details.huy");
		if (ykienTraodoiId > 0) {
			// Updating

			try {
				YKienTraoDoi fromDB = YKienTraoDoiLocalServiceUtil
						.getYkienTraoDoi(ykienTraodoiId);

				if (fromDB != null) {

					fromDB = YKienTraoDoiLocalServiceUtil.updateStatus(
							ykienTraodoiId, 0);
					HttpServletResponse httpResp = PortalUtil
							.getHttpServletResponse(actionResponse);
					httpResp.setContentType("application/json");
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("tieuDe", fromDB.getTieuDe());
					obj.put("noiDung", fromDB.getNoiDungYKien());
					httpResp.getWriter().print(obj.toString());
					httpResp.flushBuffer();

				}
			} catch (PortalException e) {
				errors.add("failed-to-update");
			} catch (SystemException e) {
				errors.add("failed-to-update");
			}
		}

	}

	/**
	 * This is function search
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
	public void search(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		String keyword = ParamUtil.getString(actionRequest, "keyword");
		String type = ParamUtil.getString(actionRequest, "type");
		String hoSoTTHCCongId = ParamUtil.getString(actionRequest,
				"hoSoTTHCCongId");
		FormatUtil.setParams(actionRequest);
		actionRequest.getPortletSession().setAttribute("keyword", keyword);
		actionRequest.getPortletSession().setAttribute("hoSoTTHCCongId",
				hoSoTTHCCongId);
		actionRequest.getPortletSession().setAttribute("type", type);
		actionResponse.setRenderParameter("jspPage",
				"/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");
	}

	/**
	 * This is function saveTraoDoiCanBo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void saveTraoDoiCanBo(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		ComUtils.saveTraoDoiCanBo(resourceRequest, httpReq);
	}

	/**
	 * This is function delYKienTraoDoi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void delYKienTraoDoi(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		long yKienTraoDoiId = ParamUtil.getLong(resourceRequest,
				"yKienTraoDoiId");
		long hoSoTTHCCongId = ParamUtil.getLong(resourceRequest,
				"hoSoTTHCCongId");
		String type = ParamUtil.getString(resourceRequest, "type");
		String loaiCanBo =ParamUtil.getString(resourceRequest, "loaiCanBo");
		
		try {
			YKienTraoDoiLocalServiceUtil.deleteYKienTraoDoi(yKienTraoDoiId);
			
			resourceRequest.setAttribute("delete", "successed");
			httpReq.setRenderParameter("hoSoTTHCCongId",
					String.valueOf(hoSoTTHCCongId));
			httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo));
			httpReq.setRenderParameter("type", String.valueOf(type));
			httpReq.setRenderParameter("jspPage",
					"/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");
			
		} catch (Exception e) {
			resourceRequest.setAttribute("delete", "failed");
			httpReq.setRenderParameter("hoSoTTHCCongId",
					String.valueOf(hoSoTTHCCongId));
			httpReq.setRenderParameter("type", String.valueOf(type));
			httpReq.setRenderParameter("jspPage",
					"/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");
			
			e.printStackTrace();
		}

	}

	/**
	 * This is function tuChoiHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void tuChoiHoSo(ActionRequest resourceRequest, ActionResponse httpReq)
			throws NumberFormatException, Exception {

		long hoSoTTHCCongId = ConvertUtil.convertToLong(ParamUtil.getString(
				resourceRequest, "hoSoTTHCCongId"));
		String loaiCanBo = ParamUtil.getString(resourceRequest, "loaiCanBo");
		// if (!validationTuChoiInput(yKien, vanbantuchoi, resourceRequest)) {
		tuChoiHoSoSaveToDB(resourceRequest, httpReq);

		long uid = PortalUtil.getUserId(resourceRequest);
		CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);	
		
		HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil
				.fetchHoSoTTHCCong(hoSoTTHCCongId);
		hoSoTTHCCong
				.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_TU_CHOI);
		
		hoSoTTHCCong.setCanBoTiepNhanId(congChuc.getId());
		hoSoTTHCCong.setNgaySua(new Date());
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);

		httpReq.setRenderParameter("idHoSo", String.valueOf(hoSoTTHCCongId));
		httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo));
		httpReq.setRenderParameter("jspPage",
				"/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp");
		// } else {
		// httpReq.setRenderParameter("hoSoTTHCCongId", yKien);
		// httpReq.setRenderParameter("yKien", yKien);
		// httpReq.setRenderParameter("jspPage",
		// "/html/cmon/tuchoi/tuchoihoso_form.jsp");
		// }
	}

	/**
	 * This is function boSungHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void boSungHoSo(ActionRequest resourceRequest, ActionResponse httpReq)
			throws NumberFormatException, Exception {
		long hoSoTTHCCongId = ParamUtil.getLong(resourceRequest, "hoSoTTHCCongId");
		
		String loaiCanBo = ParamUtil.getString(resourceRequest, "loaiCanBo");
		
		// if (validatorsTuChoi(resourceRequest)) {
		boSungHoSoSaveToDB(resourceRequest, httpReq);

		HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil
				.fetchHoSoTTHCCong(hoSoTTHCCongId);
		hoSoTTHCCong
				.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG);
		hoSoTTHCCong.setNgaySua(new Date());
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);
		String processingProfilePrefParam = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;

		httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo));
		httpReq.setRenderParameter("idHoSo", String.valueOf(hoSoTTHCCongId));
		httpReq.setRenderParameter(processingProfilePrefParam, "other");
		httpReq.setRenderParameter("jspPage",
				"/html/portlet/ipmslistportlet/view.jsp");
	}

	/**
	 * This is function fetchDonViHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void fetchDonViHanhChinh(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// Get resource id
		String resourceId = resourceRequest.getResourceID();

		// // Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		// Create Jason array o bject
		JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory()
				.createJSONArray();
		if ("fetchDonViHanhChinh".equals(resourceId)) {
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			// // Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = null;
			//
			try {
				donviHanhChinhList = org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil
						.findByChaId(parentId, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Store all data to jSon object
			for (DonViHanhChinh donViHanhChinh : donviHanhChinhList) {
				donViHanhChinhArray.put(donViHanhChinh.getId() + ":"
						+ donViHanhChinh.getTen());
			}
			jsonFeed.put("donViHanhChinhArray", donViHanhChinhArray);
		}

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
	}

	/**
	 * This is function tuChoiHoSoSaveToDB
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void tuChoiHoSoSaveToDB(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {

			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			long hoSoTTHCCongId = ConvertUtil.convertToLong(ParamUtil
					.getString(uploadRequest, "hoSoTTHCCongId"));
			String yKien = ParamUtil.getString(uploadRequest, "yKien");
			String filename = uploadRequest.getFileName("vanbantuchoi");
			HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil
					.getHoSoTTHCCong(hoSoTTHCCongId);

			String nguoiGuiId = ParamUtil
					.getString(actionRequest, "nguoiGuiId");

			// get binary data
			String contentType = actionRequest.getContentType();
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				byte dataBytes[] = FileUtil.getBytes(uploadRequest
						.getFileAsStream("vanbantuchoi"));

				GiayToDinhKem resulUpload = WebserviceFactory
						.getOfficerService().upload(
								getMaUngDung(hoSoTTHCC.getThuTucHanhChinhId()),
								1, null, PortalUtil.getUserId(uploadRequest),
								filename, "upload van ban tu choi", dataBytes,
								filename);

				// add new record to the table "ThongTinThanhToan"
				YKienTraoDoi yKienTraoDoi = new YKienTraoDoiClp();
				yKienTraoDoi
						.setId(CounterLocalServiceUtil
								.increment("vn.dtt.cmon.dao.hosohcc.model.YKienTraoDoi"));
				yKienTraoDoi.setHoSoTTHCCongId(hoSoTTHCCongId);
				yKienTraoDoi.setTieuDe("Tu choi ho so");
				yKienTraoDoi.setNoiDungYKien(yKien);
				yKienTraoDoi.setThoiGianGuiYKien(new Date());

				long noiLuuTruId = resulUpload.getNoiLuuTruId();
				if (noiLuuTruId == 0) {
					yKienTraoDoi.setNoiLuuTruId(null);
					
				} else {
					yKienTraoDoi.setNoiLuuTruId(resulUpload.getNoiLuuTruId());
				}

				yKienTraoDoi.setNoiLuuTruId(resulUpload.getNoiLuuTruId());
				yKienTraoDoi.setLoai(3);
				yKienTraoDoi
						.setNguoiGuiId(FormatUtil.convertToLong(nguoiGuiId));
				if (hoSoTTHCC.getCongDanNopId() != null
						&& hoSoTTHCC.getCongDanNopId() > 0) {
					CongDan congDan = CongDanLocalServiceUtil
							.fetchCongDan(hoSoTTHCC.getCongDanNopId());
					TaiKhoanNguoiDung taiKhoanNguoiDungCD = TaiKhoanNguoiDungLocalServiceUtil
							.fetchTaiKhoanNguoiDung(congDan
									.getTaiKhoanNguoiDungId());
					// +taiKhoanNguoiDung.toString() );
					if (taiKhoanNguoiDungCD != null) {
						yKienTraoDoi
								.setNguoiNhanId(taiKhoanNguoiDungCD.getId());
					}
				}
				yKienTraoDoi.setChaiId(null);
				yKienTraoDoi.setTrangThai(1);
				YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);

				// response data

			} else {
				SessionErrors.add(actionRequest, "errorUpdateTTTK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// SessionErrors.add(actionRequest, "errorUpdateTTTK");
		}
	}

	/**
	 * This is function boSungHoSoSaveToDB
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @param PortalException
	 * @param SystemException
	 * @param IOException
	 */
	public void boSungHoSoSaveToDB(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException, 
			SystemException, IOException {

			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			long hoSoTTHCCongId = ParamUtil.getLong(actionRequest, "hoSoTTHCCongId");
			String yKien = ParamUtil.getString(uploadRequest, "yKien1");
			String nguoiGuiId = ParamUtil
					.getString(actionRequest, "nguoiGuiId");

			String filename = uploadRequest.getFileName("vanbanbosung");
			HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil
					.getHoSoTTHCCong(hoSoTTHCCongId);
			// get binary data
			String contentType = actionRequest.getContentType();
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				byte dataBytes[] = FileUtil.getBytes(uploadRequest
						.getFileAsStream("vanbanbosung"));

				GiayToDinhKem resulUpload = null;
				if (dataBytes != null) {
					resulUpload = WebserviceFactory
							.getOfficerService().upload(
									getMaUngDung(hoSoTTHCC.getThuTucHanhChinhId()),
									1, null, PortalUtil.getUserId(uploadRequest),
									filename, "upload van ban yeu cau bo sung",
									dataBytes, filename);
				}


				// add new record to the table "ThongTinThanhToan"
				YKienTraoDoi yKienTraoDoi = new YKienTraoDoiClp();
				yKienTraoDoi
						.setId(CounterLocalServiceUtil
								.increment(YKienTraoDoiImpl.class.getName()));
				
				yKienTraoDoi.setHoSoTTHCCongId(hoSoTTHCCongId);
				yKienTraoDoi.setTieuDe("Yêu cầu bổ sung");
				yKienTraoDoi.setNoiDungYKien(yKien);
				yKienTraoDoi.setThoiGianGuiYKien(new Date());

				long noiLuuTruId = 0;
				if (resulUpload != null) {
					noiLuuTruId = resulUpload.getNoiLuuTruId();
				}

				if (noiLuuTruId == 0) {
					yKienTraoDoi.setNoiLuuTruId(null);

				} else {
					yKienTraoDoi.setNoiLuuTruId(resulUpload.getNoiLuuTruId());
				}
				// loai bo sung ho so
				yKienTraoDoi.setLoai(2);
				yKienTraoDoi
						.setNguoiGuiId(FormatUtil.convertToLong(nguoiGuiId));

//				if (hoSoTTHCC.getCongDanNopId() != null
//						&& hoSoTTHCC.getCongDanNopId() > 0) {
//
//					CongDan congDan = CongDanLocalServiceUtil
//							.fetchCongDan(hoSoTTHCC.getCongDanNopId());
//					
//					TaiKhoanNguoiDung taiKhoanNguoiDungCD = null;
//					if (congDan != null && congDan.getTaiKhoanNguoiDungId() != null) {
//						taiKhoanNguoiDungCD = TaiKhoanNguoiDungLocalServiceUtil
//								.fetchTaiKhoanNguoiDung(congDan
//										.getTaiKhoanNguoiDungId());
//					}
//
//					if (taiKhoanNguoiDungCD != null) {
//						yKienTraoDoi
//								.setNguoiNhanId(taiKhoanNguoiDungCD.getId());
						
//					} else {
						CongChuc congChuc = CongChucLocalServiceUtil.getCongChuc(hoSoTTHCC.getCanBoTiepNhanId());
						
						TaiKhoanNguoiDung taiKhoanNguoiDungCD = TaiKhoanNguoiDungLocalServiceUtil
								.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
								
						yKienTraoDoi.setNguoiNhanId(taiKhoanNguoiDungCD.getId());
//					}
//				}

				yKienTraoDoi.setChaiId(null);
				// not read yet
				yKienTraoDoi.setTrangThai(0);
				YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);
				// response data

			} else {
				SessionErrors.add(actionRequest, "errorUpdateTTTK");
			}
	}

	/**
	 * This is function upLoadFileDangXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @param NumberFormatException
	 * @param Exception
	 */
	public void upLoadFileDangXuLy(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		long hoSoTTHCCongId = ParamUtil.getLong(
				resourceRequest, "HosotthcCongId");
		
		String backUrl = ParamUtil.getString(resourceRequest, "backUrl");
		
		String loaiCanBo = ParamUtil.getString(resourceRequest, "loaiCanBo");

		upLoadFileHoSoDangXuLy(resourceRequest, httpReq);

		String processingProfilePrefParam = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;

		if (backUrl.equals(Constants.JSP_DANH_SACH_HO_SO_XU_LY)) {
			httpReq.setRenderParameter("idHoSo", String.valueOf(hoSoTTHCCongId));
			httpReq.setRenderParameter(processingProfilePrefParam,
					"otherUpload");
			httpReq.setRenderParameter("jspPage",
					"/html/portlet/ipmslistportlet/view.jsp");
			
		} else {

			httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo));
			httpReq.setRenderParameter("idHoSo", String.valueOf(hoSoTTHCCongId));
			httpReq.setRenderParameter("jspPage",
					"/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp");
		}

	}

	/**
	 * This is function upLoadFileHoSoDangXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void upLoadFileHoSoDangXuLy(ActionRequest actionRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		try {
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			long hoSoTTHCCongId = ParamUtil
					.getLong(actionRequest, "HosotthcCongId");
					
			String tenTaiLieu = ParamUtil.getString(uploadRequest, "tenTaiLieu");
			
			String filename = uploadRequest.getFileName("vanbandangxuly");
			
			HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil
					.getHoSoTTHCCong(hoSoTTHCCongId);
			
			// get binary data
			String contentType = actionRequest.getContentType();
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				byte dataBytes[] = FileUtil.getBytes(uploadRequest
						.getFileAsStream("vanbandangxuly"));

				GiayToDinhKem resulUpload = WebserviceFactory
						.getOfficerService().upload(
								getMaUngDung(hoSoTTHCC.getThuTucHanhChinhId()),
								1, null, PortalUtil.getUserId(uploadRequest),
								tenTaiLieu, "van ban dang xu ly", dataBytes,
								filename);

				// add to CMON_NOILUUTRUTAILIEU
				TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil
						.findByTaiKhoanNguoiDungId(PortalUtil.getUser(
								uploadRequest).getUserId());
			
				if (resulUpload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {

					TaiLieuChungThuc taiLieuChungThuc = new TaiLieuChungThucClp();
					taiLieuChungThuc.setChuSohuuId(nguoiDung.getId());

					taiLieuChungThuc.setNguoiUploadId(nguoiDung.getId());

					// taiLieuChungThuc.setDanhMucGiayToId(da
					// ConvertUtil.convertToLong(tenFileUpload));
					taiLieuChungThuc.setGhiChu("");
					taiLieuChungThuc.setHoSoTTHCCId(hoSoTTHCCongId);
					taiLieuChungThuc.setNoiLuuTruId(resulUpload
							.getNoiLuuTruId());
					// taiLieuChungThuc.setTrangThai(Constants.DOCUMENT_NEW);
					taiLieuChungThuc.setTen(tenTaiLieu);
					taiLieuChungThuc.setNgayUpload(new Date());
					taiLieuChungThuc.setNgaySua(new Date());
					taiLieuChungThuc.setLoai(1);
					taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil
							.add(taiLieuChungThuc);

				}


			} else {
				SessionErrors.add(actionRequest, "errorUpdateTTTK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorUpdateTTTK");
		}
	}

	/**
	 * This is function getMaUngDung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @throws PortalException
	 * @throws SystemException
	 */
	private String getMaUngDung(long thuTucHanhChinhId) throws PortalException,
			SystemException {
		ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil
				.getThuTucHanhChinh(thuTucHanhChinhId);

		if (thuTucHanhChinh != null) {
			long nhomThuTucHanhChinhId = thuTucHanhChinh
					.getNhomThuTucHanhChinhId();
			NhomThuTucHanhChinh nhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil
					.getNhomThuTucHanhChinh(nhomThuTucHanhChinhId);

			if (nhomThuTucHanhChinh != null) {
				long danhMucUngDungId = nhomThuTucHanhChinh
						.getDanhMucUngDungId();
				DanhMucUngDung danhMucUngDung = DanhMucUngDungLocalServiceUtil
						.getDanhMucUngDung(danhMucUngDungId);

				if (danhMucUngDung != null) {
					return danhMucUngDung.getMa();
				}
			}
		}

		// return no data
		return null;
	}

	/**
	 * This is function render
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		super.render(request, response);
	}

	/**
	 * This is function doView
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param renderRequest
	 * @param renderResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String pagingYkXl = ParamUtil.getString(renderRequest, "pagingYkXl");
		if ("YES".equals(pagingYkXl)) {
			renderRequest.setAttribute("pagingYkXl", "YES");

		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * This is function getProcessingProcess
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws Exception_Exception
	 * @throws IOException
	 */
	public void getProcessingProcess(ResourceRequest request,
			ResourceResponse response) throws SystemException,
			Exception_Exception, IOException {
		String profileCode = ParamUtil.getString(request, "profileCode");
		IBrms service = new IBrmsService().getIBrmsPort();
		List<WorkList> workLists = service.getWorkListByMaHoSo(profileCode);
		JSONArray workListJSONList = JSONFactoryUtil.createJSONArray();
		for (WorkList workList : workLists) {
			workListJSONList.put(JSONFactoryUtil
				.createJSONObject()
				.put("endDate", workList.getEndDate())
				.put("endPoint", workList.getEndpoint())
				.put("info", workList.getInfo())
				.put("instId", workList.getInstid())
				.put("taskId", workList.getTaskid())
				.put("startDate", workList.getStartDate())
				.put("taskId", workList.getTaskid())
				.put("title", workList.getTitle())
				.put("trcTag", workList.getTrctag())
				.put("canBoXuLy",
						TransactionUtils.getNguoiDungbyEmail(workList
								.getEndpoint()))
				.put("phongBanThucHien",
						TransactionUtils.getPhongbanEmail(workList
								.getEndpoint())));
		}
		/*
		 * if (workLists.size() == 0) {
		 * workListJSONList.put(JSONFactoryUtil.createJSONObject
		 * ().put("endDate", ConvertUtil.parseDateToTring(new
		 * Date())).put("endPoint", "endpoint") .put("info",
		 * "info").put("instId", "789").put("taskId", "456").put("startDate",
		 * ConvertUtil.parseDateToTring(new Date())) .put("taskId",
		 * "123").put("title", "test").put("trcTag", "trcTag").put("canBoXuLy",
		 * "canBoXuLy") .put("phongBanThucHien", "phongBanThucHien")); }
		 */
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("workLists", workListJSONList);
		HttpServletResponse servletResponse = PortalUtil
				.getHttpServletResponse(response);
		servletResponse.setContentType("application/json");
		servletResponse.setCharacterEncoding("UTF-8");
		servletResponse.getWriter().write(json.toString());
		servletResponse.getWriter().close();
	}
	
	
	/**
	 * This is function moveListHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	public void moveListHoSo(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String listHoSoId = (String) ParamUtil.getString(resourceRequest, "idHoSo");
		if (listHoSoId != null && listHoSoId.length() > 0) {
				String[] ids = listHoSoId.split(",") ;
				try {									
					long userId = PortalUtil.getUserId(resourceRequest);
					TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
					
					CongChuc congChuc = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId()).get(0);
					
					// get account can bo
					String accountCanBo = PortalUtil.getUser(resourceRequest).getEmailAddress(); 
				
					// Chi chuyen ho so sang uengine 
					boolean result = false;
					for (String id : ids) {
						boolean ok = handleMovingUengine(Long.valueOf(id), accountCanBo, congChuc);			
						
						if (ok && !result) 
							result = ok;
					}

					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("status", result);
				    resourceResponse.getWriter().write(json.toString());
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
		
	/**
	 * This is function tiepNhanHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void tiepNhanHoSo(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		long idHoSo = ParamUtil.getLong(actionRequest, "idHoSo");

		if (idHoSo > 0) {
			// get account can bo
			try {
				//String accountCanBo = PortalUtil.getUser(actionRequest).getEmailAddress();
				long userId = PortalUtil.getUserId(actionRequest);
				TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
				CongChuc congChuc = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId()).get(0);

				
				//boolean ok = handleMovingUengine(idHoSo, accountCanBo, congChuc);
				
/*				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("status", ok);
			    resourceResponse.getWriter().write(json.toString());*/
				HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(idHoSo);
				ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil
						.fetchThuTucHanhChinh(hoSoTTHCC.getThuTucHanhChinhId());
				
				// Get kieu ung dung cua thu tuc hanh chinh
				String code = ConfigUtils.getValue("vn.dtt.dlms.code");
				String appCode = WebserviceFactory.getThamSoService().getValue(code);
				DanhMucUngDung ungDung = DanhMucUngDungLocalServiceUtil.getUngDungTheoMa(appCode);
				
				NhomThuTucHanhChinh nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(tthc.getNhomThuTucHanhChinhId());
				if (ungDung.getId() == nhomTTHC.getDanhMucUngDungId()) { //in case thu tuc hanh chinh thuoc ve app lai xe
					
					TichHopLaiXeUtil tichHopLaiXe = new TichHopLaiXeUtil();
					
					boolean ketquaTichHopLaiXe = tichHopLaiXe.tichHopVoiSoGiaoThong(idHoSo);
					
					if (!ketquaTichHopLaiXe) {
						PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
						SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						
						actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/LoiTichHopLaiXe.jsp");						
						return;
					}
				}
				
				
				Date currentDate = new Date();
				TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = TTHC2CoQuanQuanLyLocalServiceUtil.findByCoQuanAndThuTuc(
						hoSoTTHCC.getCoQuanTiepNhanId(), hoSoTTHCC.getThuTucHanhChinhId()).get(0);

				long tthcSoNgayXuLy = tthc2CoQuanQuanLy.getSoNgayXyLy();

				CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(hoSoTTHCC.getCoQuanTiepNhanId());
				
				// Tinh toan ngay hen tra
				Calendar c = Calendar.getInstance();
				c.setTime(currentDate);
				c.add(Calendar.DATE, (int) tthcSoNgayXuLy);
				Date ngayHenTra = c.getTime();

				hoSoTTHCC.setSoNgayXuLy(tthcSoNgayXuLy);

				hoSoTTHCC.setNgayNhanHoSo(currentDate);
				hoSoTTHCC.setNgayHenTraKetQua(ngayHenTra);
				
				if (hoSoTTHCC.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_MOI_DANG_KY_TRUC_TUYEN) {
					hoSoTTHCC.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN);
				} else {
					hoSoTTHCC.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY);
				}
				
				hoSoTTHCC.setCanBoTiepNhanId(congChuc.getId());

				if (hoSoTTHCC.getMaSoBienNhan() == null || hoSoTTHCC.getMaSoBienNhan().length() == 0) {
					hoSoTTHCC.setMaSoBienNhan(MaSoBienNhanUtil.get(coQuanQuanLy.getMaCapSoBienNhan(),
						tthc.getMaDNG(), true));
				}
				
				// save the data
				HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCC);
				
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}			
		}
		
		actionResponse.setRenderParameter("id", ParamUtil.getString(actionRequest, "idHoSo"));
		actionResponse.setRenderParameter("idHoSo", ParamUtil.getString(actionRequest, "idHoSo"));
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp");
	}
	
	/**
	 * This is function handleMovingUengine
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param idHoSo
	 * @param accountCanBo
	 * @param congChuc
	 * @throws PortalException
	 * @throws SystemException
	 */
	private boolean handleMovingUengine( long idHoSo, String accountCanBo, CongChuc congChuc)
			throws PortalException, 
			SystemException {	
			boolean ok = false;
			HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(idHoSo);
		
			if (hoSoTTHCC != null && hoSoTTHCC.getTrangThaiHoSo() != 
					Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN) {
				return true;
			}
			
			if (hoSoTTHCC != null) {					
				ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil
						.fetchThuTucHanhChinh(hoSoTTHCC.getThuTucHanhChinhId());
				String uengineProcessName = tthc.getUengineProcessName();
				CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
						.fetchCoQuanQuanLy(hoSoTTHCC.getCoQuanTiepNhanId());
				
				if (uengineProcessName != null && !uengineProcessName.isEmpty()) {			
					ok = org.oep.cmon.portlet.ipmslist.utils.ComUtils.forward2Uengine(
							uengineProcessName,
							hoSoTTHCC,
							accountCanBo,
							coQuanQuanLy.getMa());
					
				// thu tuc khong co qui trinh
				} else {
					hoSoTTHCC.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_XU_LY_XONG);
					hoSoTTHCC.setNgaySua(new Date());
					HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCC);
					
					return true;
				}
				
				if (ok) {
					hoSoTTHCC.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED);
					hoSoTTHCC.setNgaySua(new Date());
					HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCC);
//					HoSoTTHCCongLocalServiceUtil.updateHOSOTTHCCONGById(
//							hoSoTTHCC.getId(), 
//							Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED);
					
					// hoso offline
/*					if (hoSoTTHCC.getLoaiHoSo() == Constants.QuanLiHoSo.TYPE_HOSO_OFFLINE) {
						HoSoTTHCCongLocalServiceUtil.updateHOSOTTHCCONGById(
								hoSoTTHCC.getId(), 
								Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED);
					
					// ho so online
					} else {			
						Date currentDate = new Date();
						TTHC2CoQuanQuanLy tthc2CoQuanQuanLy =TTHC2CoQuanQuanLyLocalServiceUtil.
								findByCoQuanAndThuTuc(hoSoTTHCC.getCoQuanTiepNhanId(),
										hoSoTTHCC.getThuTucHanhChinhId()).get(0);
						
						long tthcSoNgayXuLy = tthc2CoQuanQuanLy.getSoNgayXyLy();
										
						// Tinh toan ngay hen tra
						Calendar c = Calendar.getInstance();
						c.setTime(currentDate);
						c.add(Calendar.DATE, (int) tthcSoNgayXuLy);
						Date ngayHenTra = c.getTime();

						hoSoTTHCC.setSoNgayXuLy(tthcSoNgayXuLy);

						hoSoTTHCC.setNgayNhanHoSo(currentDate);
						hoSoTTHCC.setNgayHenTraKetQua(ngayHenTra);
						hoSoTTHCC
								.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED);
						
						hoSoTTHCC.setCanBoTiepNhanId(congChuc.getId());

						hoSoTTHCC.setMaSoBienNhan(ComUtils.getMaSoBienNhan(coQuanQuanLy.getMa(),
								hoSoTTHCC.getMaUngDung()));
						
						// save the data
						HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCC);
					}*/
				}
			}
			
			return ok;
		}
	
	/**
	 * This is function rutHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	public void rutHoSo(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		long idHoSo = ParamUtil.getLong(resourceRequest, "idHoSo");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if (idHoSo > 0l) {
			try {
				HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(idHoSo);
				
				if (hoSoTTHCC != null) {
					hoSoTTHCC.setDaXoa(1);
					HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCC);					
				}

				json.put("status", Boolean.TRUE);
				
			} catch (SystemException e) {
				e.printStackTrace();
				json.put("status", Boolean.FALSE);
			}
		} else {
			json.put("status", Boolean.FALSE);
		}
		
		resourceResponse.getWriter().write(json.toString());
	}
	
	/**
	 * This is function guiDenCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void guiDenCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException {

		long idYKien = ParamUtil.getLong(actionRequest, "idykien");
		YKienTraoDoi yKienTraoDoi = YKienTraoDoiLocalServiceUtil.getYkienTraoDoi(idYKien);
		
		//long  idTaiKhoanNguoiDung = ParamUtil.getLong(actionRequest, "idtaikhoannguoidung");
		String noiDungYKien = ParamUtil.getString(actionRequest, "noidungykien");
		
		yKienTraoDoi.setNoiDungYKien(noiDungYKien);
		//yKienTraoDoi.setNguoiNhanId(idTaiKhoanNguoiDung);
		//yKienTraoDoi.setThoiGianGuiYKien(new Date());
		// xac nhan da gui den cong dan
		yKienTraoDoi.setChaiId(idYKien);
		YKienTraoDoiLocalServiceUtil.updateYKienTraoDoi(yKienTraoDoi);
	}
}
