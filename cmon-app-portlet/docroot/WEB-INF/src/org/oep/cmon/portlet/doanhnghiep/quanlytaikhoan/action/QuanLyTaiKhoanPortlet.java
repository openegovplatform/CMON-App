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

package org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.business.CongDanBusiness;
import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.business.DoanhNghiepBusiness;
import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.FormatUtils;
import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.HoCaTheFormModel;
import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.Validators;
import org.oep.cmon.portlet.doanhnghiep.xacthuc.utils.XacThucDoanhNghiepUtils;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;
import org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class QuanLyTaiKhoanPortlet extends MVCPortlet {
	private static String popupPageError = "/html/portlet/doanhnghiep/quanlytaikhoan/popuppageerror.jsp";
	
	/**
	 * This is  function search list request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void searchListYeuCau(ActionRequest request,
			ActionResponse response) throws Exception {
		String maOrTenOrEmail = ParamUtil.getString(request,
				"maOrTenOrEmail", "");
		String doiTuongType = ParamUtil.getString(request,
				"doiTuongType", "");
		String trangThaiType = ParamUtil.getString(request,
				"trangThaiType", "");
		response.setRenderParameter("maOrTenOrEmail", maOrTenOrEmail);
		response.setRenderParameter("doiTuongType", doiTuongType);
		response.setRenderParameter("trangThaiType", trangThaiType);
	}
	
	/**
	 * This is  function search list CongDan popup
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws NumberFormatException
	 * @throws PortalException
	 */
	public void popUpListCongDan(ActionRequest request,
			ActionResponse response) throws IOException,
			PortletException, SystemException, NumberFormatException,
			PortalException {
		String maOrTenOrEmail = ParamUtil.getString(request,
				"maOrTenOrEmail", "");
		response.setRenderParameter("maOrTenOrEmail", maOrTenOrEmail);
		
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_congDanSearch.jsp");
		
		
		
		
		
		
		
		
		/*response.setRenderParameter("inputSearch",
				request.getParameter("inputSearch"));
		
		response.setRenderParameter("dt",
				request.getParameter("dt"));
		//Using Portlet Session
		request.getPortletSession().setAttribute("inputSearch", request.getParameter("inputSearch"));
		
		request.getPortletSession().setAttribute("dt", request.getParameter("dt"));
		
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_congDanSearch.jsp");*/
		
	}
	
	/**
	 * This is  function search list DoanhNghiep popup
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void popupListDoanhNghiep(ActionRequest request,
			ActionResponse response) throws Exception {
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		response.setRenderParameter("searchInputText", searchInputText);
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_doanhNghiepSearch.jsp");
	}
	
	/**
	 * This is  function get data HoCaThe
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
	
	/**
	 * This is  function get data CongDan
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
		obj.put("nddNoiCapCMND", congDan.getNoiCapCmndId()!=null?String.valueOf(congDan.getNoiCapCmndId()):"");
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
	
	/*public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
				// Get resource id
				String resourceId = resourceRequest.getResourceID();
				// Process Jason feed
				JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
				// Create Jason array o bject
				JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory()
						.createJSONArray();

				if ("getDVHCNDD".equals(resourceId)) {
					// Get country code from URL
					long parentId = ParamUtil.getInteger(resourceRequest, "parentId");

					// Query all sub don vi hanh chinh using parent id
					List<DonViHanhChinh> donviHanhChinhList = null;

					try {
						donviHanhChinhList = DonViHanhChinhLocalServiceUtil
								.findByChaId(parentId,0);
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
	}*/
	
	/**
	 * This is  function get DonViHanhChinh by Id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httlReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void getDonViHanhChinhById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		
		//String id = ParamUtil.getString(resourceRequest, "id");
		long id = ParamUtil.getInteger(resourceRequest, "id");
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();

		// Danh sach don vi hanh chinh
		List<DonViHanhChinh> dsDVHC =  DonViHanhChinhLocalServiceUtil.findByChaId(id,0);

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
	 * This is  function get CongDan by Id 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httlReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void getCongDanByID(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		
		//String id = ParamUtil.getString(resourceRequest, "id");
		long idCD = ParamUtil.getLong(resourceRequest, "idCD");
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();

		// Danh sach don vi hanh chinh
		CongDan congDan =  CongDanLocalServiceUtil.fetchCongDan(idCD);

		String fullName = congDan.getHo() + " " + congDan.getDem() + " "
				+ congDan.getTen();
		/*_id.put(congDan.getId());
		_name.put(congDan.getTen());*/
		//jsonFeed.put("id", congDan.getId());
		jsonFeed.put("name", fullName);
		jsonFeed.put("ngaysinh", FormatUtils.getFormatDate(congDan.getNgaySinh()));
		jsonFeed.put("gioitinh", congDan.getGioiTinh());
		jsonFeed.put("quocgiaid", congDan.getQuocTichId());
		jsonFeed.put("dantocid", congDan.getDanTocId());
		
		jsonFeed.put("diachihiennay", congDan.getDiaChiHienNay());
		jsonFeed.put("hiennaytinhid", congDan.getDiaChiHienNayTinhId());
		jsonFeed.put("hiennayhuyenid",congDan.getDiaChiHienNayHuyenId());
		jsonFeed.put("hiennayxaid", congDan.getDiaChiHienNayXaId());
		
		
		jsonFeed.put("diachithuongtru", congDan.getDiaChiThuongTru());
		jsonFeed.put("thuongtrutinhid", congDan.getDiaChiThuongTruTinhId());
		jsonFeed.put("thuongtruhuyenid", congDan.getDiaChiThuongTruHuyenId());
		jsonFeed.put("thuongtruxaid", congDan.getDiaChiThuongTruXaId());		
		
		jsonFeed.put("socmnd", congDan.getSoCmnd());
		jsonFeed.put("ngaycapcmnd", congDan.getNgayCapCmnd());
		
		String temp = "";
		if(congDan.getNoiCapCmndId()!=null)
			temp = String.valueOf(congDan.getNoiCapCmndId());
		jsonFeed.put("noicapcmndid", temp);
		
		
		
		jsonFeed.put("fax", congDan.getFax());
		jsonFeed.put("website", congDan.getWebsite());
		jsonFeed.put("email", congDan.getEmail());
		jsonFeed.put("dtdd", congDan.getDienThoaiDiDong());
		
				
		
		

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(httpReq);
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}
	
	/**
	 * This is  function save ThanhVienSangLap
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveThanhVienSangLap(ActionRequest request, ActionResponse response)
			throws Exception {
		
		CongDan congDan = CongDanBusiness.getCongDanFromRequest(request);
		if (Validators.validThanhVienSangLap(request)) {
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
					congDan.setId(CounterLocalServiceUtil.increment("csms_congdan"));
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
				"/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/addthanhviensanglap.jsp");
		}
	
	
	/**
	 * This is  function add HoCaThe
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addHoCaThe(ActionRequest request, ActionResponse response)
			throws Exception {
		int mode = ParamUtil.getInteger(request,"mode");
		HoCaTheFormModel model= DoanhNghiepBusiness.getHoCaTheModelFromRequest(request,mode);
		if (Validators.validationInput(request,mode)) {
			//Luu
			
		}
		
		request.setAttribute("myForm",model);
		response.setRenderParameter("jspPage",
				"/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathe.jsp");
		
		
	}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	


