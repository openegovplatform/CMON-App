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

package org.oep.cmon.portlet.doanhnghiep.xacthuc.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.portlet.doanhnghiep.xacthuc.utils.XacThucDoanhNghiepUtils;
import org.oep.cmon.portlet.taocongdan.util.ElectricCodeGeneratorUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;
import org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class XacThucDoanhNghiepPortlet extends MVCPortlet {
	
	private static String PageError = "/html/portlet/doanhnghiep/xacthuc/pageerror.jsp";
	private static String popupPageError = "/html/portlet/doanhnghiep/xacthuc/popuppageerror.jsp";
	public void xacThucHoCaThe(ActionRequest request,
			ActionResponse response) throws Exception {
		long idYeuCau = ParamUtil.getLong(request,
				"idYeuCau");
		String maOrTenOrEmail = ParamUtil.getString(request,
				"maOrTenOrEmail", "");
		String loaiDoiTuongId = ParamUtil.getString(request,
				"loaiDoiTuongId", "");
		String trangThai = ParamUtil.getString(request,
				"trangThai", "");
		Map<String, String> HCT_OBJECT = new HashMap<String, String>();
		HCT_OBJECT = XacThucDoanhNghiepUtils.getMapHctFromYcdk(idYeuCau);
		request.setAttribute("HCT_OBJECT", HCT_OBJECT);
		response.setRenderParameter("maOrTenOrEmail", maOrTenOrEmail);
		response.setRenderParameter("loaiDoiTuongId", loaiDoiTuongId);
		response.setRenderParameter("trangThai", trangThai);
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/xacthuc/hocathe/hocathe.jsp");
	}
	public void saveXacThucHoCaThe(ActionRequest request,
			ActionResponse response) throws Exception {
		String maOrTenOrEmail = ParamUtil.getString(request,
				"maOrTenOrEmail", "");
		String loaiDoiTuongId = ParamUtil.getString(request,
				"loaiDoiTuongId", "");
		String trangThai = ParamUtil.getString(request,
				"trangThai", "");
		response.setRenderParameter("maOrTenOrEmail", maOrTenOrEmail);
		response.setRenderParameter("loaiDoiTuongId", loaiDoiTuongId);
		response.setRenderParameter("trangThai", trangThai);
		
		User currentUser = PortalUtil.getUser(request);
		if(currentUser == null){
			SessionErrors.add(request,"not.login.error");
		}
		String[] abc = request.getParameterValues("abc");
		
		Map<String, String> HCT_OBJECT = new HashMap<String, String>();
		HCT_OBJECT = XacThucDoanhNghiepUtils.getMapHctFromRequest(request);
		if (XacThucDoanhNghiepUtils.validHoCaThe(request)&&currentUser != null) {
//		if (currentUser != null) {
			long nddId = ParamUtil.getLong(request,"nddId");
			long id = ParamUtil.getLong(request,"id");
			//insert or update cong dan
			try {
				if (Validator.isNotNull(ParamUtil.getString(request,"nddId"))&&ParamUtil.getLong(request,"nddId")!=0) {
					//update cong dan code
				}else{
					//insert cong dan code
					nddId = CounterLocalServiceUtil.increment("csms_congdan");
				}
			} catch (Exception e) {
				response.setRenderParameter("jspPage", popupPageError);
				return;
			}
			//insert or update ho ca the
			try {
				if (Validator.isNotNull(ParamUtil.getString(request,"id"))&&ParamUtil.getLong(request,"id")!=0) {
					//update cong dan code
				}else{
					//insert cong dan code
					id = CounterLocalServiceUtil.increment("brms_doanhnghiep");
				}
			} catch (Exception e) {
				// delete cong dan neu la them moi
				if (Validator.isNull(ParamUtil.getString(request,"nddId"))||ParamUtil.getLong(request,"nddId")==0) {
					//delete cong dan code
				}
				response.setRenderParameter("jspPage", popupPageError);
				return;
			}
			// tao tai khoan nguoi dung cho doanh nghiep
			try{
				// tao tai khoan nguoi dung doanh nghiep code
			}catch (Exception e) {
				// xoa ho ca the/ cong dan neu la them moi
				if (Validator.isNull(ParamUtil.getString(request,"id"))||ParamUtil.getLong(request,"id")==0) {
					//delete ho ca the code
				}
				// xoa cong dan neu la them moi
				if (Validator.isNull(ParamUtil.getString(request,"nddId"))||ParamUtil.getLong(request,"nddId")==0) {
					//delete cong dan code
				}
				response.setRenderParameter("jspPage", popupPageError);
				return;
			}
			// doi trang thai yeu cau dang ky
			try{
				
			}catch (Exception e) {
				response.setRenderParameter("jspPage", popupPageError);
				return;
			}
		}else{
			request.setAttribute("HCT_OBJECT", HCT_OBJECT);
			response.setRenderParameter("jspPage",
					"/html/portlet/doanhnghiep/xacthuc/hocathe/hocathe.jsp");
		}
		
	}
	public void saveThanhVienSangLap(ActionRequest request, ActionResponse response)
			throws Exception {
		CongDan congDan = XacThucDoanhNghiepUtils.getCongDanFromRequest(request);
		User currentUser = PortalUtil.getUser(request);
		if(currentUser == null){
			SessionErrors.add(request,"not.login.error");
		}
		if (XacThucDoanhNghiepUtils.validThanhVienSangLap(request)&&currentUser != null) {
			if (Validator.isNotNull(ParamUtil.getString(request,"tvslId"))&&ParamUtil.getLong(request,"tvslId")!=0) {
				try {
					congDan.setId(ParamUtil.getLong(request,"tvslId"));
					CongDanLocalServiceUtil.updateCongDan(congDan);
				} catch (Exception e) {
					response.setRenderParameter("jspPage", popupPageError);
					return;
				}
			} else {
				try {
					String hoCongDan = "";
					String tenCongDan = "";
					int firstSpaceIndex =congDan.getTenDayDu().trim().indexOf(" "); 
					int lastSpaceIndex =congDan.getTenDayDu().trim().lastIndexOf(" "); 
					if(firstSpaceIndex==-1){
						hoCongDan = congDan.getTenDayDu().trim();
						tenCongDan = congDan.getTenDayDu().trim();
					}else{
						hoCongDan = congDan.getTenDayDu().substring(0,firstSpaceIndex).trim();
						tenCongDan = congDan.getTenDayDu().substring(lastSpaceIndex,congDan.getTenDayDu().length()).trim();
					}
					String maCongDan = ElectricCodeGeneratorUtil.generateCode(congDan.getDiaChiThuongTruTinhId(),congDan.getNgaySinh());
					congDan.setId(CounterLocalServiceUtil.increment("csms_congdan"));
					congDan.setHo(hoCongDan);
					congDan.setTen(tenCongDan);
					congDan.setTinhtrang(1);
					congDan.setDaXoa(0);
					congDan.setMa(maCongDan);
					congDan.setNgayTao(new Date());
					congDan.setNguoiTao(currentUser.getFullName());
					CongDanLocalServiceUtil.addCongDan(congDan);
				} catch (Exception e) {
					response.setRenderParameter("jspPage", popupPageError);
					return;
				}
			}
			response.setRenderParameter("saveOk","OK");
		}
		request.setAttribute("congDan",congDan);
		response.setRenderParameter("tvslGiaTri", ParamUtil.getString(request, "tvslGiaTri"));
		response.setRenderParameter("tvslTyLe", ParamUtil.getString(request, "tvslTyLe"));
		response.setRenderParameter("tvslLoaiTaiSan", ParamUtil.getString(request, "tvslLoaiTaiSan"));
		response.setRenderParameter("tvslNgayGopVon", ParamUtil.getString(request, "tvslNgayGopVon"));
		response.setRenderParameter("tvslGhiChu", ParamUtil.getString(request, "tvslGhiChu"));
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/xacthuc/hocathe/addthanhviensanglap.jsp");
	}
	public void searchListYeuCau(ActionRequest request,
			ActionResponse response) throws Exception {
		String maOrTenOrEmail = ParamUtil.getString(request,
				"maOrTenOrEmail", "");
		String loaiDoiTuongId = ParamUtil.getString(request,
				"loaiDoiTuongId", "");
		String trangThai = ParamUtil.getString(request,
				"trangThai", "");
		response.setRenderParameter("maOrTenOrEmail", maOrTenOrEmail);
		response.setRenderParameter("loaiDoiTuongId", loaiDoiTuongId);
		response.setRenderParameter("trangThai", trangThai);
	}
	public void popupListDoanhNghiep(ActionRequest request,
			ActionResponse response) throws Exception {
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		response.setRenderParameter("searchInputText", searchInputText);
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistdoanhnghiep.jsp");
	}
	public void popUpListCongDan(ActionRequest request,
			ActionResponse response) throws Exception {
		String maOrTenOrEmail = ParamUtil.getString(request,
				"maOrTenOrEmail", "");
		response.setRenderParameter("maOrTenOrEmail", maOrTenOrEmail);
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistcongdan.jsp");
	}
	public void getDataHoCaThe(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long hoCaTheId = ParamUtil.getLong(actionRequest,
				"hoCaTheId",0l);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DoanhNghiep hoCaThe = DoanhNghiepLocalServiceUtil.fetchDoanhNghiep(hoCaTheId);
		
		JSONObject obj = JSONFactoryUtil.getJSONFactory()
				.createJSONObject();
		obj.put("id",hoCaThe.getId());
		obj.put("ten",hoCaThe.getTen());
		obj.put("maGiayPhep", hoCaThe.getSoGCNDKKD());
		
		obj.put("tinhId", hoCaThe.getDiaChiDoanhNghiepTinhId());
		obj.put("huyenId", hoCaThe.getDiaChiDoanhNghiepHuyenId());
		obj.put("xaId", hoCaThe.getDiaChiDoanhNghiepXaId());
		
		obj.put("chiTietDiaDiem", hoCaThe.getDiaChiDoanhNghiep());
		obj.put("maSoThue", hoCaThe.getMaSoThue());
		obj.put("ngayDangKy", df.format(hoCaThe.getNgayCapGCNDKKD()));
		obj.put("vonKinhDoanh", hoCaThe.getVonDieuLe());
		obj.put("dienThoai", hoCaThe.getDienThoaiDoanhNghiep());
		obj.put("fax", hoCaThe.getFax());
		obj.put("email", hoCaThe.getEmailDoanhNghiep());
		obj.put("website", hoCaThe.getWebsite());
		obj.put("moTaNgheNghiep", hoCaThe.getMoTaNganhNgheKinhDoanh());
		
		obj.put("nddId", hoCaThe.getNguoiDaiDienId());
		List<NganhNgheKinhDoanh> listNganhNghe = XacThucDoanhNghiepUtils.getNganhNgheByIdDoanhNghiep(hoCaTheId);
		JSONArray lnn = JSONFactoryUtil.getJSONFactory().createJSONArray();
		for (int i = 0; i < listNganhNghe.size(); i++) {
			JSONObject row = JSONFactoryUtil.getJSONFactory()
					.createJSONObject();
			row.put("id", listNganhNghe.get(i).getId());
			row.put("name", listNganhNghe.get(i).getTen());
			lnn.put(row);
		}
		obj.put("listNganhNghe",lnn);
		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(actionResponse);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding(StringPool.UTF8);
		resourceResponse.getWriter().write(obj.toString());
		resourceResponse.getWriter().close();
	}
	public void getDataCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long congDanId = ParamUtil.getLong(actionRequest,
				"congDanId",0l);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		CongDan congDan = CongDanLocalServiceUtil.fetchCongDan(congDanId);
		
		JSONObject obj = JSONFactoryUtil.getJSONFactory()
				.createJSONObject();
		
		obj.put("nddId", congDan.getId());
		obj.put("nddTen", congDan.getTenDayDu());
		obj.put("nddNgaySinh", df.format(congDan.getNgaySinh()));
		obj.put("nddGioiTinh", congDan.getGioiTinh());
		obj.put("nddQuocTich", congDan.getQuocTichId());
		obj.put("nddDanToc", congDan.getDanTocId());
		obj.put("nddSoCMND", congDan.getSoCmnd());
		obj.put("nddNgayCapCMND",congDan.getNgayCapCmnd()!=null?df.format(congDan.getNgayCapCmnd()):"");
		obj.put("nddNoiCapCMND", congDan.getNoiCapCmndId()!=null?congDan.getNoiCapCmndId():0);
		obj.put("nddTtTinhId", congDan.getDiaChiThuongTruTinhId());
		obj.put("nddTtHuyenId", congDan.getDiaChiThuongTruHuyenId());
		obj.put("nddTtXaId", congDan.getDiaChiThuongTruXaId());
		obj.put("nddTtMoTaDiaChi", congDan.getDiaChiThuongTru());
		obj.put("nddCohtTinhId", congDan.getDiaChiHienNayTinhId());
		obj.put("nddCohtHuyenId", congDan.getDiaChiHienNayHuyenId());
		obj.put("nddCohtXaId", congDan.getDiaChiHienNayXaId());
		obj.put("nddCohtMoTaChoO", congDan.getDiaChiHienNay());
		obj.put("nddDienThoai", congDan.getDienThoaiCoDinh());
		obj.put("nddFax", congDan.getFax());
		obj.put("nddEmail", congDan.getEmail());
		obj.put("nddWebsite", congDan.getWebsite());
		
		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(actionResponse);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding(StringPool.UTF8);
		resourceResponse.getWriter().write(obj.toString());
		resourceResponse.getWriter().close();
	}
	public void getDonViHanhChinhById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		String id = ParamUtil.getString(resourceRequest, "id");

		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();

		// Danh sach don vi hanh chinh
		List<DonViHanhChinh> dsDVHC = XacThucDoanhNghiepUtils.findDonViHanhChinhByChaId(Long
				.parseLong(id));

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
}