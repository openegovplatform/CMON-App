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

package org.oep.cmon.user.portlet.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.mapping.utils.Constaints;
import org.oep.cmon.user.portlet.business.EndorsementBs;
import org.oep.cmon.user.portlet.util.AuthenticateCodeUtil;
import org.oep.cmon.user.portlet.util.ScaleImageUtil;
import org.oep.cmon.user.portlet.util.StringUtil;
import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;
import org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/** 
 * This is class UserEndorsePortlet
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class UserEndorsePortlet extends MVCPortlet {
	/** Birth date format */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	/** Search type */
	private enum SEARCH { ID, NAME, EMAIL } 
	
	/**
	 * This is function serveResource
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
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException, PortletException {
		// Get resource id
		String resourceId = resourceRequest.getResourceID();

		// Process Jason feed
		JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
		if ( "fetchDonViHanhChinh".equals(resourceId) ) {		
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			// Create Jason array o bject
			JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory().createJSONArray();	
			
			// Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = null;

			donviHanhChinhList = DonViHanhChinhLocalServiceUtil.findByChaId(parentId,Constants.ACTIVATED);			

			// Store all data to jSon object
			for (DonViHanhChinh donViHanhChinh : donviHanhChinhList) {
				donViHanhChinhArray.put( donViHanhChinh.getId() + ":"  + donViHanhChinh.getTen());
			}
		
			jsonFeed.put("donViHanhChinhArray", donViHanhChinhArray );	
		}		
				
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
	}

	/**
	 * This is function Search user request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @param reqStatus
	 * @throws Exception
	 * @return List<YeuCauDangKyCongDan>
	 */
	public static List<YeuCauDangKyCongDan> searchUserRequest(String keyWord, int reqStatus) throws Exception {
		
		//String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		//int reqStatus = ParamUtil.getInteger(actionRequest, "reqStatus");

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(YeuCauDangKyCongDan.class);
		
		Criterion criteriaCmnd = RestrictionsFactoryUtil.ilike("SoCmnd", "%" + keyWord + "%");
		Criterion criteriaEmail = RestrictionsFactoryUtil.ilike("Email", "%" + keyWord + "%");
		Criterion criteriaTenCongDan = RestrictionsFactoryUtil.ilike("HoVaTen", "%" + keyWord + "%");
		Criterion criteriaMaCongDan = RestrictionsFactoryUtil.ilike("MaCongDan", "%" + keyWord + "%");
		
		Criterion criteria1 = RestrictionsFactoryUtil.or(criteriaCmnd, criteriaEmail);
		Criterion criteria4 = RestrictionsFactoryUtil.or(criteria1, criteriaTenCongDan);
		Criterion criteria5 = RestrictionsFactoryUtil.or(criteria4, criteriaMaCongDan);
		
		query = query.add(criteria5);
		if (reqStatus > -1 ) {
			query = query.add(PropertyFactoryUtil.forName("TrangThaiYeuCau").eq(reqStatus));
		}
		query = query.add(PropertyFactoryUtil.forName("Xoa").eq(0));
		
		List<YeuCauDangKyCongDan> results = null;
		try {
			results = YeuCauDangKyCongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	/**
	 * This is function viewUserRequest
	 * Handle when user click a link in view.jsp
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
	public void viewUserRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the request id from URL parameter
		long reqId = ParamUtil.getLong(actionRequest, "reqId");
		
		// Get record from DB
		YeuCauDangKyCongDan yeuCau = YeuCauDangKyCongDanLocalServiceUtil.getYeuCauDangKyCongDan(reqId);
		
		// Put to buff object in case user want to modify the request
		Map<String, String> userRequest = new HashMap<String, String>();
		
		userRequest.put("ID", yeuCau.getId() + "");
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		if ( yeuCau.getNgayYeuCau() != null ) {
			userRequest.put("NGAYYEUCAU", sdf.format(yeuCau.getNgayYeuCau()));
		}
		
		userRequest.put("SOCMND", yeuCau.getSoCmnd());
		
		// Ngay cap CMND
		if ( yeuCau.getNgayCapCmnd() != null ) {		
			userRequest.put("NGAYCAPCMND", sdf.format(yeuCau.getNgayCapCmnd()));
		} else {
			userRequest.put("NGAYCAPCMND", StringPool.SPACE);
		}		
		
		userRequest.put("IDNOICAPCMND", yeuCau.getIDNoiCapCmnd() + "");
		userRequest.put("GHICHUCMND", yeuCau.getGhiChuCmnd());
		userRequest.put("EMAIL", yeuCau.getEmail());
		userRequest.put("HOCONGDAN", yeuCau.getHoCongDan());
		userRequest.put("TENDEM", yeuCau.getTenDem());
		userRequest.put("TENCONGDAN", yeuCau.getTenCongDan());
		
		// Ngay sinh
		if ( yeuCau.getNgaySinh() != null ) {		
			userRequest.put("NGAYSINH", sdf.format(yeuCau.getNgaySinh()));
		} else {
			userRequest.put("NGAYSINH", StringPool.SPACE);
		}
		
		userRequest.put("IDGIOITINH", yeuCau.getGioiTinh() + "" );
		userRequest.put("IDDANTOC", yeuCau.getIDDanToc() + "" );
		userRequest.put("IDQUOCTICH", yeuCau.getIDQuocTich() + "" );
		userRequest.put("IDTONGIAO", yeuCau.getIDTonGiao() + "");
		userRequest.put("DIENTHOAICODINH", yeuCau.getDienThoaiCoDinh());
		userRequest.put("DIENTHOAIDIDONG", yeuCau.getDienThoaiDiDong());
		userRequest.put("IDTRINHDOHOCVAN", yeuCau.getIDTrinhDoHocVan() + "");
		userRequest.put("SOHOCHIEU", yeuCau.getSoHoChieu());
		
		// Ngay cap ho chieu
		if ( yeuCau.getNgayCapHoChieu() != null ) {		
			userRequest.put("NGAYCAPHOCHIEU", sdf.format(yeuCau.getNgayCapHoChieu()));
		} else {
			userRequest.put("NGAYCAPHOCHIEU", StringPool.SPACE);
		}
		
		userRequest.put("IDNOICAPHOCHIEU", yeuCau.getIDNoiCapHoChieu() + "" );
		
		// Ngay het han ho chieu
		if ( yeuCau.getNgayHetHanHoChieu() != null ) {		
			userRequest.put("NGAYHETHANHOCHIEU", sdf.format(yeuCau.getNgayHetHanHoChieu()));
		} else {
			userRequest.put("NGAYHETHANHOCHIEU", StringPool.SPACE);
		}
		
		userRequest.put("GHICHUHOCHIEU", yeuCau.getGhiChuHoChieu());
		userRequest.put("SOBAOHIEMYTE", yeuCau.getSoBaoHiemYte());
		userRequest.put("MASOTHUECANHAN", yeuCau.getMaSoThueCaNhan());
		userRequest.put("IDNGHENGHIEP", yeuCau.getIDNgheNghiep() + "");
		userRequest.put("IDTRINHDOCHUYENMON", yeuCau.getIDTrinhDoChuyenMon() + "");
		userRequest.put("IDTINHTRANGHONNHAN", yeuCau.getTinhTrangHonNhan() + "");
		userRequest.put("HOVATENCHA", yeuCau.getHoVaTenCha());
		userRequest.put("HOVATENME", yeuCau.getHoVaTenMe());
		userRequest.put("HOVATENVOCHONG", yeuCau.getHoVaTenVoChong());
		userRequest.put("SOHOKHAU", yeuCau.getSoHoKhau());
		userRequest.put("CHUHO", yeuCau.getChuHo() + "");
		userRequest.put("IDQUANHE", yeuCau.getIDQuanHe() + "");
		userRequest.put("IDTINHTHANHNOISINH", yeuCau.getIDTinhThanhNoiSinh() + "");
		userRequest.put("IDQUANHUYENNOISINH", yeuCau.getIDQuanHuyenNoiSinh() + "");
		userRequest.put("IDPHUONGXANOISINH", yeuCau.getIDPhuongXaNoiSinh() + "");
		userRequest.put("MOTADIACHINOISINH", yeuCau.getMoTaDiaChiNoiSinh());
		userRequest.put("IDTINHTHANHTHUONGTRU", yeuCau.getIDTinhThanhThuongTru() + "");
		userRequest.put("IDQUANHUYENTHUONGTRU", yeuCau.getIDQuanHuyenThuongTru() + "");
		userRequest.put("IDPHUONGXATHUONGTRU", yeuCau.getIDPhuongXaThuongTru() + "");
		userRequest.put("MOTADIACHITHUONGTRU", yeuCau.getMoTaDiaChiThuongTru());
		userRequest.put("IDTINHTHANHHIENTAI", yeuCau.getIDTinhThanhHienTai() + "");
		userRequest.put("IDQUANHUYENHIENTAI", yeuCau.getIDQuanHuyenHienTai() + "");
		userRequest.put("IDPHUONGXAHIENTAI", yeuCau.getIDPhuongXaHienTai() + "" );
		userRequest.put("MOTADIACHIHIENTAI", yeuCau.getMoTaDiaChiHienTai());
		userRequest.put("TRANGTHAIYEUCAU", yeuCau.getTrangThaiYeuCau() + "");		
		
		// Store the information to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);		
		
		// Redirect to edit/endorse user page
		actionResponse.setRenderParameter("jspPage", "/html/portlet/endorse/endorse.jsp");		
	}
	
	/**
	 * This is function upload Avatar
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
	public void uploadAvatar(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        File file = uploadRequest.getFile("file");
        
        byte[]  imgBytes = ScaleImageUtil.scaleImage(file, 160, 160);
        
        // Store to session
        actionRequest.getPortletSession().setAttribute("PROFILE_PIC", imgBytes);
       
        actionResponse.setRenderParameter("jspPage", "/html/portlet/endorse/upload_avatar.jsp");
	}
	
	/**
	 * This is function get avatar
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
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void getAvatar(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		// Get image from session
       byte[] imgBytes = (byte[])actionRequest.getPortletSession().getAttribute("PROFILE_PIC");   
     
       HttpServletResponse resp = PortalUtil.getHttpServletResponse(actionResponse);
       resp.setContentType("application/jpg");
       
       ServletResponseUtil.write(resp, imgBytes);       
	}
	
	/**
	 * This is function Citizen endorsement
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
	public void endorse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the object from session
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
		
		// Get all parameters from request
		String hoCongDan = "";
		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "ho"))) {
			hoCongDan = ParamUtil.getString(actionRequest, "ho").trim().toUpperCase();
			userRequest.put("HOCONGDAN", hoCongDan);
		}

		String tenDem = "";
		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "dem"))) {
			tenDem = ParamUtil.getString(actionRequest, "dem").trim().toUpperCase();
			userRequest.put("TENDEM", tenDem);		
		}

		String tenCongDan = "";
		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "ten"))) {
			tenCongDan = ParamUtil.getString(actionRequest, "ten").trim().toUpperCase();
			userRequest.put("TENCONGDAN", tenCongDan);
		}
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		userRequest.put("SOCMND", soCmnd);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd");
		userRequest.put("NGAYCAPCMND", ngayCapCmnd);
		
		String noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd");
		if ( Validator.isNotNull(noiCapCmnd)) {
			userRequest.put("IDNOICAPCMND", noiCapCmnd);
		}
		
		String ghiChuCmnd = ParamUtil.getString(actionRequest, "ghiChuCmnd").trim();
		userRequest.put("GHICHUCMND", ghiChuCmnd);
		
		String email = ParamUtil.getString(actionRequest, "email").trim();
		userRequest.put("EMAIL", email);
		
		String soHoChieu = ParamUtil.getString(actionRequest, "soHoChieu").trim();
		userRequest.put("SOHOCHIEU", soHoChieu);
		
		String ngayCapHoChieu = ParamUtil.getString(actionRequest, "ngayCapHoChieu");
		userRequest.put("NGAYCAPHOCHIEU", ngayCapHoChieu);
		
		String noiCapHoChieu = ParamUtil.getString(actionRequest, "noiCapHoChieu");
		// If the data is not submitted from client, keep the original value from the object in session
		if ( Validator.isNotNull(noiCapHoChieu)) {
			userRequest.put("IDNOICAPHOCHIEU", noiCapHoChieu);
		}
		
		String ngayHetHanHoChieu = ParamUtil.getString(actionRequest, "ngayHetHanHoChieu");
		userRequest.put("NGAYHETHANHOCHIEU", ngayHetHanHoChieu);
		
		String ghiChuHoChieu = ParamUtil.getString(actionRequest, "ghiChuHoChieu").trim();
		userRequest.put("GHICHUHOCHIEU", ghiChuHoChieu);
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("IDGIOITINH", gioiTinh);
		}
		
		String danToc = ParamUtil.getString(actionRequest, "danToc");
		if ( Validator.isNotNull(danToc)) {
			userRequest.put("IDDANTOC", danToc);
		}
		
		String tonGiao = ParamUtil.getString(actionRequest, "tonGiao");
		if ( Validator.isNotNull(tonGiao)) {
			userRequest.put("IDTONGIAO", tonGiao);
		}
		
		String quocTich = ParamUtil.getString(actionRequest, "quocTich");
		if ( Validator.isNotNull(quocTich)) {
			userRequest.put("IDQUOCTICH", quocTich);
		}
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");
		userRequest.put("NGAYSINH", ngaySinh);
		
		String dtCoDinh = ParamUtil.getString(actionRequest, "dtCoDinh").trim();
		userRequest.put("DIENTHOAICODINH", dtCoDinh);
		
		String dtDiDong = ParamUtil.getString(actionRequest, "dtDiDong").trim();
		userRequest.put("DIENTHOAIDIDONG", dtDiDong);
		
		String trinhDoHocVan = ParamUtil.getString(actionRequest, "trinhDoHocVan");
		if ( Validator.isNotNull(trinhDoHocVan)) {
			userRequest.put("IDTRINHDOHOCVAN", trinhDoHocVan);
		}
		
		String soBhyt = ParamUtil.getString(actionRequest, "soBhyt").trim();
		userRequest.put("SOBAOHIEMYTE", soBhyt);
		
		String ngheNghiep = ParamUtil.getString(actionRequest, "ngheNghiep");
		if ( Validator.isNotNull(ngheNghiep)) {
			userRequest.put("IDNGHENGHIEP", ngheNghiep);
		}
		
		String trinhDoChuyenMon = ParamUtil.getString(actionRequest, "trinhDoChuyenMon");
		if ( Validator.isNotNull(trinhDoChuyenMon)) {
			userRequest.put("IDTRINHDOCHUYENMON", trinhDoChuyenMon);
		}
		
		String tinhTrangHonNhan = ParamUtil.getString(actionRequest, "tinhTrangHonNhan");
		if ( Validator.isNotNull(tinhTrangHonNhan)) {
			userRequest.put("IDTINHTRANGHONNHAN", tinhTrangHonNhan);
		}
		
		String tinhNoiSinh = ParamUtil.getString(actionRequest, "tinhNoiSinh");
		if ( Validator.isNotNull(tinhNoiSinh)) {
			userRequest.put("IDTINHTHANHNOISINH", tinhNoiSinh);
		}
		
		String huyenNoiSinh = ParamUtil.getString(actionRequest, "huyenNoiSinh");
		if ( Validator.isNotNull(huyenNoiSinh)) {
			userRequest.put("IDQUANHUYENNOISINH", huyenNoiSinh);
		}
		
		String xaNoiSinh = ParamUtil.getString(actionRequest, "xaNoiSinh");
		if ( Validator.isNotNull(xaNoiSinh)) {
			userRequest.put("IDPHUONGXANOISINH", xaNoiSinh);
		}
		
		String motaNoisinh = ParamUtil.getString(actionRequest, "motaNoisinh").trim();
		userRequest.put("MOTADIACHINOISINH", motaNoisinh);
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		if ( Validator.isNotNull(tinhThuongTru)) {
			userRequest.put("IDTINHTHANHTHUONGTRU", tinhThuongTru);
		}
		
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		if ( Validator.isNotNull(huyenThuongTru)) {
			userRequest.put("IDQUANHUYENTHUONGTRU", huyenThuongTru);
		}
		
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		if ( Validator.isNotNull(xaThuongTru)) {
			userRequest.put("IDPHUONGXATHUONGTRU", xaThuongTru);
		}
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		userRequest.put("MOTADIACHITHUONGTRU", motaThuongTru);
		
		String tinhHienTai = ParamUtil.getString(actionRequest, "tinhHienTai");
		if ( Validator.isNotNull(tinhHienTai)) {
			userRequest.put("IDTINHTHANHHIENTAI", tinhHienTai);
		}
		
		String huyenHienTai = ParamUtil.getString(actionRequest, "huyenHienTai");
		if ( Validator.isNotNull(huyenHienTai)) {
			userRequest.put("IDQUANHUYENHIENTAI", huyenHienTai);
		}
		
		String xaHienTai = ParamUtil.getString(actionRequest, "xaHienTai");
		if ( Validator.isNotNull(xaHienTai)) {
			userRequest.put("IDPHUONGXAHIENTAI", xaHienTai);
		}
		
		String motaDiachiHienTai = ParamUtil.getString(actionRequest, "motaDiachiHienTai").trim();
		userRequest.put("MOTADIACHIHIENTAI", motaDiachiHienTai);
		
		String soHoKhau = ParamUtil.getString(actionRequest, "soHoKhau").trim();
		userRequest.put("SOHOKHAU", soHoKhau);
		
		String chuHo = ParamUtil.getString(actionRequest, "chuHo");
		userRequest.put("CHUHO", chuHo);
		
		String mstCaNhan =  ParamUtil.getString(actionRequest, "mstCaNhan").trim();
		userRequest.put("MASOTHUECANHAN", mstCaNhan);	
		
		String quanHeChuHo = ParamUtil.getString(actionRequest, "quanHeChuHo");
		if ( Validator.isNotNull(quanHeChuHo)) {
			userRequest.put("IDQUANHE", quanHeChuHo);	
		}

		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
		
		// Check Ho cong dan
		if (Validator.isNull(hoCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.hoCongDan");
		}
		
		// Check ten cong dan
		if (Validator.isNull(tenCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.tenCongDan");
		}
		
		// Check so cmnd
		if (!Constaints.isValidCMND(soCmnd)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.soCmnd");
		}
		
		// Check email
		if (Validator.isNull(email) || !email.contains("@")) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.email");
		} else {
			TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTenDangNhap(email);
			if (taiKhoan != null) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.emailDuplicate");
			}
		}
		
		// Check gioi tinh
		if (Validator.isNull(gioiTinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.gioiTinh");
		}
		
		// Check ngay sinh
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.ngaySinh");
		} else {
			// Validate birth date
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			Date birthDate = null;
			df.setLenient(false);
			try {
				birthDate = df.parse(ngaySinh);
			} catch (Exception e) {
				// Error never happen so this exception will be swallow
			}
			
			if ( birthDate.compareTo(new Date()) > 0) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.ngaySinh.greaterThanCurrent");
			}
		}
		
		// ngay cap
		if (Validator.isNull(ngayCapCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.ngayCapCmnd");
		} else {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			Date birthDate = null;
			df.setLenient(false);
			try {
				birthDate = df.parse(ngayCapCmnd);
			} catch (Exception e) {
				// Error never happen so this exception will be swallow
			}
			if ( birthDate.compareTo(new Date()) > 0) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.ngayCap.greaterThanCurrent");
			}
		}
		
		// Check dan toc
		if (Validator.isNull(danToc)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.danToc");
		}
		
		// Check ton giao
		if (Validator.isNull(tonGiao)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.tonGiao");
		}
		
		// Check tinh thuong tru
		if (Validator.isNull(tinhThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.tinhThuongTru");
		}
		
		// Check huyen thuong tru
		if (Validator.isNull(huyenThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.huyenThuongTru");
		}
		
		// Check xa thuong tru
		if (Validator.isNull(xaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.user.form.endorse.err.xaThuongTru");
		}
				
		
		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}		
		
		// Generate random password for user
		String password = AuthenticateCodeUtil.generateAuthCode().toLowerCase().trim();
		
		EndorsementBs endorse = new EndorsementBs(actionRequest);
		
		String fullName = hoCongDan + StringPool.SPACE + tenDem +StringPool.SPACE + tenCongDan;
		
		try {
			// Update yeu cau dang ky to DB		
			YeuCauDangKyCongDan yeuCau = endorse.updateUserRequest(userRequest);

			// Create portal user
			long userId = endorse.createPortalCitizenUser(yeuCau, password);
			
			String maCongDan = endorse.citizenExists(hoCongDan, tenDem, tenCongDan, soCmnd, ngaySinh);

			// Create data on cmon_taikhoan nguoidung
			long taiKhoanNguoiDungId = endorse.createTaiKhoan(userId, fullName, email, password);
					
			// Create citizen
			endorse.createCitizen(yeuCau, taiKhoanNguoiDungId, maCongDan);
			
			String portalUrl = PortalUtil.getPortalURL(actionRequest);
			endorse.sendEmail(fullName, email, password, portalUrl, actionRequest);
			
			// Remove sessioj items
			actionRequest.getPortletSession().removeAttribute("PROFILE_PIC");
			
			actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");
			
			// Redirect to success URL
			//String successUrl = ParamUtil.getString(actionRequest, "successUrl");
			
			actionRequest.setAttribute("endorseSuccess", "endorseSuccess");
			SessionMessages.add(actionRequest, "endorseSuccess");
			
		} catch (Exception e) {
			actionRequest.setAttribute("endorseError", "endorseError");
			SessionMessages.add(actionRequest, "endorseError");
			
			e.printStackTrace();
		}
	}
	
	/**
	 * This is function huyDangKy
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
	public void huyDangKy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			// Update yeu cau dang ky to DB
			Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
			long reqId = 0;
			if (userRequest != null && !userRequest.isEmpty()) {
				reqId = Long.parseLong(userRequest.get("ID"));
			}
			if (reqId == 0) {
				reqId = ParamUtil.getLong(actionRequest, "yeuCauId");
			}
			YeuCauDangKyCongDan yeuCau = YeuCauDangKyCongDanLocalServiceUtil.fetchYeuCauDangKyCongDan(reqId);
			yeuCau.setXoa(1);
			yeuCau = YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);

			EndorsementBs endorse = new EndorsementBs(actionRequest);
			String portalUrl = PortalUtil.getPortalURL(actionRequest);
			endorse.sendEmailHuyDK(yeuCau.getHoVaTen(), yeuCau.getEmail(), portalUrl, actionRequest);
			
			actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");
			
			actionRequest.setAttribute("huySuccess", "huySuccess");
			SessionMessages.add(actionRequest, "huySuccess");
			
		} catch (Exception e) {
			actionRequest.setAttribute("endorseError", "endorseError");
			SessionMessages.add(actionRequest, "endorseError");
			
			e.printStackTrace();
		}
	}
	
	/**
	 * This is function endorseInList
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
	public void endorseInList(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long yeuCauId = ParamUtil.getLong(actionRequest, "yeuCauId");
		
		YeuCauDangKyCongDan yeuCau = YeuCauDangKyCongDanLocalServiceUtil.fetchYeuCauDangKyCongDan(yeuCauId);
		try {
			// Generate random password for user
			String password = AuthenticateCodeUtil.generateAuthCode().toLowerCase().trim();
			EndorsementBs endorse = new EndorsementBs(actionRequest);

			// update yeucau
			yeuCau.setTrangThaiYeuCau(StringUtil.TRANG_THAI_YEU_CAU_DK_CONG_DAN_DA_CHUNG_THUC); // Endorsed
			YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);
			
			String ho = yeuCau.getHoCongDan();
			String dem = yeuCau.getTenDem();
			String ten = yeuCau.getTenCongDan();
			String email = yeuCau.getEmail();
			String fullName = ho + StringPool.SPACE + dem +StringPool.SPACE + ten;
			
			TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTenDangNhap(email);
			if (taiKhoan != null) {
				SessionMessages.add(actionRequest, "emailDuplicate");
				return ;
			}
			
			// Create portal user
			long userId = endorse.createPortalCitizenUser(yeuCau, password);
			
			String maCongDan = endorse.citizenExists(ho, dem, ten, 
					yeuCau.getSoCmnd(), ConvertUtil.parseDateToTring(yeuCau.getNgaySinh()));

			// Create data on cmon_taikhoan nguoidung
			long taiKhoanNguoiDungId = endorse.createTaiKhoan(userId, fullName, email, password);
			
			// Create citizen
			endorse.createCitizen(yeuCau, taiKhoanNguoiDungId, maCongDan);
			String portalUrl = PortalUtil.getPortalURL(actionRequest);
			endorse.sendEmail(fullName, email, password, portalUrl, actionRequest);
			
			actionRequest.setAttribute("endorseSuccess", "endorseSuccess");
			SessionMessages.add(actionRequest, "endorseSuccess");
		} catch (Exception ex) {
			actionRequest.setAttribute("endorseError", "endorseError");
			SessionMessages.add(actionRequest, "endorseError");
			
			ex.printStackTrace();
		}
		
	}
	
}
