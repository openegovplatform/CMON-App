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

package org.oep.cmon.admin.portlet.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.admin.portlet.business.CongChucBs;
import org.oep.cmon.admin.portlet.util.ConvertUtil;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is  class CongChucAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CongChucAction {
	/** Search by ma option */
	private static String SEARCH_TEN_OPTION = "0";
	
	/** Action mode, 0: insert, 1: edit */
	private static int INSERT_MODE = 0;
	
	/** Action mode, 0: insert, 1: edit */
	private static int EDIT_MODE = 1;
	
	/** Date format */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	/**
	 * This is function add or edit CongChuc
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
	public void addEditCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the  required parameters
		// Action mode (0: Insert, 1: Edit);
		int mode = ParamUtil.getInteger(actionRequest, "mode");
		
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_CC_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
			
		String ma = ParamUtil.getString(actionRequest, "ma").trim();
		userRequest.put("ma", ma);
		
		String hoVaTen = ParamUtil.getString(actionRequest, "hoVaTen").trim();
		userRequest.put("hoVaTen", hoVaTen);
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");
		userRequest.put("ngaySinh", ngaySinh);
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		userRequest.put("gioiTinh", gioiTinh);
		
		String chucVu = ParamUtil.getString(actionRequest, "chucVu");
		userRequest.put("chucVu", chucVu);
		
		String coQuanQuanLy = ParamUtil.getString(actionRequest, "coQuanQuanLy");
		userRequest.put("coQuanQuanLy", coQuanQuanLy);
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		userRequest.put("soCmnd", soCmnd);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd");
		userRequest.put("ngayCapCmnd", ngayCapCmnd);
		
		String noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd").trim();
		userRequest.put("noiCapCmnd", noiCapCmnd);
		
		String taiKhoanNguoiDung = ParamUtil.getString(actionRequest, "taiKhoanNguoiDung").trim();
		userRequest.put("taiKhoanNguoiDung", taiKhoanNguoiDung);
		
		String vaiTroThem = ParamUtil.getString(actionRequest, "vaiTroThem").trim();
		userRequest.put("vaiTroThem", vaiTroThem);
		
		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_CC_OBJECT", userRequest);
				
		// Check login name
		if (Validator.isNull(ma)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.ma");
		}
		
		// Check full name
		if (Validator.isNull(hoVaTen)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.hoVaTen");
		}
		
		// Check password
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.ngaySinh");
		}
		
		// Check email
		if (Validator.isNull(chucVu)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.chucVu");
		}
		
		// Check co quan quan ly
		if (Validator.isNull(coQuanQuanLy)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.coQuanQuanLy");
		}
		
		// Check tai khoan nguoi dung
		if (Validator.isNull(taiKhoanNguoiDung.trim())) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.taiKhoanNguoiDung");
		}
		
		// Check CMND
		if (soCmnd.trim().length() > 0) {
			if (ConvertUtil.convertToLong(soCmnd) <= 0) {
				SessionErrors.add(actionRequest, "vn.dtt.form.congchuc.error.number.cmnd");
			} else if (soCmnd.length() != 9 && soCmnd.length() != 12) {
				SessionErrors.add(actionRequest, "vn.dtt.form.congchuc.error.arrange.cmnd");
			}
		} else {
			SessionErrors.add(actionRequest, "vn.dtt.form.congchuc.error.number.cmnd");
		}
		
		// Validate ngay sinh vs current date
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date birthDate = null;
		df.setLenient(false);
		try {
			birthDate = df.parse(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		Date currentDate = new Date();
		
		if (ngaySinh.trim().length() > 0 && birthDate.compareTo(currentDate) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.ngaySinh.greaterThanCurrent");
		}
		
		// Validate ngayCapCmnd vs current date
		if ( Validator.isNotNull(ngayCapCmnd)) {
			Date issueIdDate = null;
			try {
				issueIdDate = df.parse(ngayCapCmnd);
			} catch (Exception e) {
				// Error never happen so this exception will be swallow
			}
			
			if ( issueIdDate.compareTo(currentDate) > 0) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.ngayCapCmnd.greaterThanCurrent");
			}			
		}
		
		// Check duplicate information
		if ( mode == INSERT_MODE) {
		
			if ( Validator.isNotNull(ma)) {
				List <CongChuc> lst = CongChucLocalServiceUtil.findByMa(ma);
				
				if ( lst.size() > 0 ) {
					SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.duplicateMa");
				}
			}	
		} else {
			
			// Get the id
			long id = Long.parseLong( userRequest.get("id") );
			
			if ( Validator.isNotNull(ma)) {
				List <CongChuc> lst = CongChucLocalServiceUtil.findByMa(ma);
				
				if ( lst.size() > 0 ) {
					// Get the first object in the list
					CongChuc obj = lst.get(0);
					
					// Check if the login name to be updated is already owned by another
					if ( obj.getId() != id ) {
						SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_congchuc.err.duplicateMa");
					}
				}
			}
		}		
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}	
		
		// Insert/updatye record here
		if (mode == INSERT_MODE) {
			new CongChucBs().insert(userRequest, actionRequest);
		} else {
			new CongChucBs().edit(userRequest, actionRequest);
		}
		
		// Remove attribute
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_CC_OBJECT");
		
		// Redirect user
		if (mode == INSERT_MODE) {
			// Add success message
			SessionMessages.add(actionRequest, "success");
			
			actionResponse.sendRedirect(redirectUrl);
		} else {
			// Redirect to search screen
			Map<String,String> searchParam = (Map<String,String>)actionRequest.getPortletSession().getAttribute("SEARCH_CONG_CHUC_PARAMS");
			
			String searchOption = searchParam.get("searchOption");
	
			String keyWord = searchParam.get("keyWord");
			
			// Do the search
			this.searchCongChuc(searchOption,  keyWord, actionRequest, actionResponse);
		}		
	}
	
	/**
	 * This is function view CongChuc
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
	public void viewCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Get the record
		CongChuc congChuc = CongChucLocalServiceUtil.getCongChuc(id);
		
		// Initiate the object
		Map <String, String> userRequest = new HashMap<String, String>();
		
		// ID
		userRequest.put("id", congChuc.getId() + "");
		
		// Ma cong chuc
		userRequest.put("ma", congChuc.getMa());
		
		// Ho va teb
		userRequest.put("hoVaTen", congChuc.getHoVaTen());
		
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		// Ngay sinh
		userRequest.put("ngaySinh", df.format(congChuc.getNgaySinh()));
		
		// Gioi tinh
		userRequest.put("gioiTinh", congChuc.getGioiTinhId() + "");
		
		ChucVu chucVu  = ChucVuLocalServiceUtil.getChucVu(congChuc.getChucVuId());
		
		// Chuc vu
		userRequest.put("chucVu", chucVu.getId() + "-" + chucVu.getTen());
		
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
		
		// Co quan quan ly
		userRequest.put("coQuanQuanLy", coQuanQuanLy.getId() + "-" + coQuanQuanLy.getTen());
		
		Long taiKhoanNguoiDung = congChuc.getTaiKhoanNguoiDungId();
		
		if ( taiKhoanNguoiDung != null && taiKhoanNguoiDung.longValue() > 0) {
			TaiKhoanNguoiDung taiKhoan = null;
			try {
				// Get name of co quan quan ly
				taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNguoiDung);
			} catch (Exception es) {
				try {
					taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNguoiDung);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (taiKhoan != null) {
				userRequest.put("taiKhoanNguoiDung", taiKhoan.getId() + "-" + taiKhoan.getTenNguoiDung());
			}
		} else {
			userRequest.put("taiKhoanNguoiDung", "");
		}
		
		// So cmnd
		userRequest.put("soCmnd", congChuc.getSoCmnd());
		
		// Ngay cap cmnd
		if ( Validator.isNotNull(congChuc.getNgayCapCmnd())) {
			userRequest.put("ngayCapCmnd", df.format(congChuc.getNgayCapCmnd()));
		}
		
		// Noi cap cmnd
		userRequest.put("noiCapCmnd", congChuc.getNoiCapCmnd());		
		
		userRequest.put("vaiTroThem", "");
		
		// Set the data to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_CC_OBJECT", userRequest);
		
		// Redirect to add/edit screen
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cong_chuc_add_edit.jsp");
		actionResponse.setRenderParameter("mode", EDIT_MODE + "");		
	}
	
	/**
	 * This is function delete CongChuc
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
	public void deleteCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		new CongChucBs().delete(id);
		
		// Redirect to search page
		Map<String,String> searchParam = (Map<String,String>)actionRequest.getPortletSession().getAttribute("SEARCH_CONG_CHUC_PARAMS");
		
		String searchOption = searchParam.get("searchOption");
		
		String keyWord = searchParam.get("keyWord");
		
		// Do the search
		this.searchCongChuc(searchOption,  keyWord, actionRequest, actionResponse);
	}
	
	/**
	 * This is function delete role of CongChuc
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
	public void deleteRoleCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long taiKhoanNguoiDungId = ParamUtil.getLong(actionRequest, "taiKhoanNguoiDungId");
		long vaiTroId = ParamUtil.getLong(actionRequest, "vaiTroId");
		long nguoiDung2VaiTroId = ParamUtil.getLong(actionRequest, "nguoiDung2VaiTroId");
		StringBuilder result = new StringBuilder("");
		String vaiTroThem = ParamUtil.getString(actionRequest, "vaiTroThem");
		
		NguoiDung2VaiTroLocalServiceUtil.deleteNguoiDung2VaiTro(nguoiDung2VaiTroId);
		if (vaiTroThem.compareTo(String.valueOf(vaiTroId)) != 0) {
			String[] _vaiTroThem = vaiTroThem.split("-");
			for (String data : _vaiTroThem) {
				if (ConvertUtil.convertToLong(data) > 0 && ConvertUtil.convertToLong(data) != vaiTroId) {
					if (result.length() == 0) {
						result.append(data.trim());
					} else {
						result.append("-").append(data.trim());
					}
				}
			}
		}
		
		List<TaiNguyen2VaiTro> lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(vaiTroId, 0);
		TaiKhoanNguoiDung taiKhoanNguoiDung = findTaiKhoanNguoiDungById(taiKhoanNguoiDungId);
		long[] userIds = {taiKhoanNguoiDung.getTaiKhoanNguoiDungId()};
		TaiNguyen taiNguyen = null;
		if (lNguyen2VaiTros != null) {
			for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
				try {
					taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
					if (ConvertUtil.convertToLong(taiNguyen.getGiaTri()) > 0) {
						try {
							UserLocalServiceUtil.unsetRoleUsers(ConvertUtil.convertToLong(taiNguyen.getGiaTri()), userIds);
						} catch (Exception es1) {
							es1.printStackTrace();
						}
					}
				} catch (Exception ess) {
					ess.printStackTrace();
				}
			}
		}
		
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		jsonFeed.put("status_delete", "true");
		jsonFeed.put("vaiTroThem", result.toString());

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(actionResponse);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function delete role of CongChucRiengChuaAdd
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
	public void deleteRoleCongChucRiengChuaAdd(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String vaiTroId = ParamUtil.getString(actionRequest, "vaiTroId");
		StringBuilder vaiTroThem = new StringBuilder("");
		String _vaiTroThem = ParamUtil.getString(actionRequest, "vaiTroThem");		
		
		String[] vaiTroIds = _vaiTroThem.toString().split("-");		
		if (vaiTroIds.length > 0) {
		 	for (String data : vaiTroIds) {
  		 		if (ConvertUtil.convertToLong(data) > 0) {
  		 			if (data.compareTo(vaiTroId) != 0) {
  		 				if (vaiTroThem.length() == 0) {
  	  						vaiTroThem.append(data);
  	  					} else {
  	  						vaiTroThem.append("-").append(data);
  	  					}
  		 			}
  		 		}
		 	}
		}

		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		jsonFeed.put("status_delete", "true");
		jsonFeed.put("vaiTroThem", vaiTroThem.toString());

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(actionResponse);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}
	
	
	/**
	 * This is function add role of CongChucRieng
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
	public void addRoleCongChucRieng(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String vaiTroThemCheck = ParamUtil.getString(actionRequest, "vaiTroThemCheck");
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_CC_OBJECT");
		
		String _ma = ParamUtil.getString(actionRequest, "_ma").trim();
   		String _hoVaTen = ParamUtil.getString(actionRequest, "_hoVaTen").trim();
   		String _ngaySinh = ParamUtil.getString(actionRequest, "_ngaySinh").trim();
   		String _gioiTinh = ParamUtil.getString(actionRequest, "_gioiTinh").trim();
   		String _coQuanQuanLy = ParamUtil.getString(actionRequest, "_coQuanQuanLy").trim();
   		String _chucVu = ParamUtil.getString(actionRequest, "_chucVu").trim();
   		String _soCmnd = ParamUtil.getString(actionRequest, "_soCmnd").trim();
   		String _ngayCapCmnd = ParamUtil.getString(actionRequest, "_ngayCapCmnd").trim();
   		String _noiCapCmnd = ParamUtil.getString(actionRequest, "_noiCapCmnd").trim();
   		String _taiKhoanNguoiDung = ParamUtil.getString(actionRequest, "_taiKhoanNguoiDung").trim();

	   	if (userRequest == null) {
	   		userRequest = new HashMap<String, String>();
			actionResponse.setRenderParameter("mode", INSERT_MODE + "");
	   	} else {
	   		if (userRequest.get("id") != null && userRequest.get("id").toString().trim().length() > 0) {
		   		actionResponse.setRenderParameter("mode", EDIT_MODE + "");	
		   	} else {
		   		actionResponse.setRenderParameter("mode", INSERT_MODE + "");
		   	}
	   	}
	   	
	   	userRequest.put("ma", _ma);
		userRequest.put("hoVaTen", _hoVaTen);
		userRequest.put("ngaySinh", _ngaySinh);
		userRequest.put("gioiTinh", _gioiTinh);
		userRequest.put("chucVu", _chucVu);
		userRequest.put("coQuanQuanLy", _coQuanQuanLy);			
		userRequest.put("soCmnd", _soCmnd);
		userRequest.put("ngayCapCmnd", _ngayCapCmnd);
		userRequest.put("noiCapCmnd", _noiCapCmnd);
		userRequest.put("taiKhoanNguoiDung", _taiKhoanNguoiDung);
	   	userRequest.put("vaiTroThem", vaiTroThemCheck.trim());
		
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_CC_OBJECT", userRequest);
		try {
			actionResponse.setWindowState(LiferayWindowState.NORMAL);
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
		}
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cong_chuc_add_edit.jsp");
	}
	
	/**
	 * This is function search CongChuc
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
	public void searchCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the search option
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
		
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		this.searchCongChuc(searchOption, keyWord, actionRequest, actionResponse);
	}
	
	/**
	 * This is function search CongChuc by search option or keyword ..
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchOption
	 * @param keyWord
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchCongChuc(String searchOption, String keyWord, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		// Build the query		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc.class);
		
		// Always search un-deleted record
		query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
		
		// Add the criteria incase keyword search is not null
		if ( Validator.isNotNull(searchOption) && Validator.isNotNull(keyWord)) {
			Criterion criteria = null;		
			
			// Define search criteria
			if ( searchOption.equals(SEARCH_TEN_OPTION)) {
				criteria = RestrictionsFactoryUtil.ilike("hoVaTen", "%" + keyWord + "%");	
			} else {
				criteria = RestrictionsFactoryUtil.ilike("ma", keyWord + "%");
			}
			
			// Define search criteria
			query = query.add( criteria );
		}

		List<CongChuc> results = null;
		
		try {
			results = CongChucLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CONG_CHUC_RESULT", results);
		
		// Store the search option to session for coming back to search screen from edit screen
		Map<String, String> searchParam = new HashMap<String, String>();

		if (Validator.isNull(searchOption)) {
			searchOption = SEARCH_TEN_OPTION;
		}
		
		searchParam.put("searchOption", searchOption);		
		searchParam.put("keyWord", keyWord);
		
		// Set the search param back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CONG_CHUC_PARAMS", searchParam);
		
		// Redirect User
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cong_chuc_list.jsp");
		actionResponse.setRenderParameter("searchOption", searchOption);
		actionResponse.setRenderParameter("keyWord", keyWord);
	}
	
	/**
	 * This is function search popup VaiTroCanBo 
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
	public void searchPopUpVaiTroChoCanBo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the search option
		List<VaiTro> results = null;
		String chucVuID = ParamUtil.getString(actionRequest, "chucVuID").trim();
		String coQuanQuanLy = ParamUtil.getString(actionRequest, "coQuanQuanLy").trim();
		String vaiTroThem = ParamUtil.getString(actionRequest, "vaiTroThem").trim();
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		String _ma = ParamUtil.getString(actionRequest, "ma");
		String _hoVaTen = ParamUtil.getString(actionRequest, "hoVaTen");
		String _ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");
		String _gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		String _chucVu = ParamUtil.getString(actionRequest, "chucVu");
		String _soCmnd = ParamUtil.getString(actionRequest, "soCmnd");
		String _noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd");
		String _ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd");
		String _taiKhoanNguoiDung = ParamUtil.getString(actionRequest, "taiKhoanNguoiDung");
		
		if (chucVuID.length() > 0) {
			String[] _chucVuID = chucVuID.split("-");
			String[] _vaiTroThem = vaiTroThem.split("-");
			String[] _coQuanQuanLyID = coQuanQuanLy.split("-");
			List<ChucVu2VaiTro> lisChucVu2VaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdChucVuAndIdCoQuanQuanLy(ConvertUtil.convertToLong(_chucVuID[0]), ConvertUtil.convertToLong(_coQuanQuanLyID[0]), 0);
			List<Long> listIDs = new ArrayList<Long>();
			for (int i = 0; i < lisChucVu2VaiTros.size(); i++) {
				listIDs.add(lisChucVu2VaiTros.get(i).getVaiTroId());
			}
			for (int i = 0; i < _vaiTroThem.length; i++) {
				if (ConvertUtil.convertToLong(_vaiTroThem[i]) > 0) {
					listIDs.add(ConvertUtil.convertToLong(_vaiTroThem[i]));
				}
			}
			
			// Build the query		
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);
			
			// Always search un-deleted record
			query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
			query = query.add( RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("id", listIDs.toArray())));	
			
			// Add the criteria incase keyword search is not null
			if (Validator.isNotNull(keyWord)) {
				Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
				// Define search criteria
				query = query.add( criteria );
			}

			try {
				results = VaiTroLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (results == null) {
			results = new ArrayList<VaiTro>();
		}

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_VAI_TRO_CAN_BO_RESULT", results);
		
		// Redirect User
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/themVaiTroToCongChuc.jsp");
		actionResponse.setRenderParameter("chucVuID", chucVuID);
		actionResponse.setRenderParameter("keyWord", keyWord);
		actionResponse.setRenderParameter("coQuanQuanLy", coQuanQuanLy);
		actionResponse.setRenderParameter("vaiTroThem", vaiTroThem);
		actionResponse.setRenderParameter("ma", _ma);
		actionResponse.setRenderParameter("hoVaTen", _hoVaTen);
		actionResponse.setRenderParameter("ngaySinh", _ngaySinh);
		actionResponse.setRenderParameter("gioiTinh", _gioiTinh);
		actionResponse.setRenderParameter("chucVu", _chucVu);
		actionResponse.setRenderParameter("soCmnd", _soCmnd);
		actionResponse.setRenderParameter("noiCapCmnd", _noiCapCmnd);
		actionResponse.setRenderParameter("ngayCapCmnd", _ngayCapCmnd);
		actionResponse.setRenderParameter("taiKhoanNguoiDung", _taiKhoanNguoiDung);
	}
	
	/**
	 * This is function search popup VaiTroCanBo remove Ajax
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
	public void searchPopUpVaiTroChoCanBoAjax(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the search option
		List<VaiTro> results = null;
		String chucVuID = ParamUtil.getString(actionRequest, "chucVuID").trim();
		String coQuanQuanLy = ParamUtil.getString(actionRequest, "coQuanQuanLy").trim();
		String vaiTroThem = ParamUtil.getString(actionRequest, "vaiTroThem").trim();
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		if (chucVuID.length() > 0) {
			String[] _chucVuID = chucVuID.split("-");
			String[] _vaiTroThem = vaiTroThem.split("-");
			String[] _coQuanQuanLyID = coQuanQuanLy.split("-");
			List<ChucVu2VaiTro> lisChucVu2VaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdChucVuAndIdCoQuanQuanLy(ConvertUtil.convertToLong(_chucVuID[0]), ConvertUtil.convertToLong(_coQuanQuanLyID[0]), 0);
			List<Long> listIDs = new ArrayList<Long>();
			String dataPrint = "";
			for (int i = 0; i < lisChucVu2VaiTros.size(); i++) {
				listIDs.add(lisChucVu2VaiTros.get(i).getVaiTroId());
				dataPrint += lisChucVu2VaiTros.get(i).getVaiTroId() + ";";
			}
			for (int i = 0; i < _vaiTroThem.length; i++) {
				if (ConvertUtil.convertToLong(_vaiTroThem[i]) > 0) {
					listIDs.add(ConvertUtil.convertToLong(_vaiTroThem[i]));
					dataPrint += ConvertUtil.convertToLong(_vaiTroThem[i]) + ";";
				}
			}
			
			// Build the query		
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);
			
			// Always search un-deleted record
			query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
			query = query.add( RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("id", listIDs.toArray())));	

			// Add the criteria incase keyword search is not null
			if (Validator.isNotNull(keyWord)) {
				Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
				// Define search criteria
				query = query.add( criteria );
			}

			try {
				results = VaiTroLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (results == null) {
			results = new ArrayList<VaiTro>();
		}
		
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();
		

		for (VaiTro item : results) {
			_id.put(item.getId());
			_name.put(item.getTen());
		}
		jsonFeed.put("id", _id);
		jsonFeed.put("name", _name);
		
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(actionResponse);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
		
	}

	/**
	 * This is function search popup ChucVu.
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
	public void searchPopUpChucVu(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the search option
		List<ChucVu> results = null;
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
		String coQuanQuanLyID = ParamUtil.getString(actionRequest, "coQuanQuanLyID").trim();
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		if (coQuanQuanLyID.length() > 0) {
			String[] _coQuanQuanLyID = coQuanQuanLyID.split("-");
			List<ChucVu2VaiTro> lisChucVu2VaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdCoQuanQuanLy(ConvertUtil.convertToLong(_coQuanQuanLyID[0]));
			Object listIDs[] = new Object[lisChucVu2VaiTros.size()];
			for (int i = 0; i < lisChucVu2VaiTros.size(); i++) {
				listIDs[i] = lisChucVu2VaiTros.get(i).getChucVuId();
			}
			
			// Build the query		
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu.class);
			
			// Always search un-deleted record
			query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
			query = query.add( RestrictionsFactoryUtil.in("id", listIDs));	
			
			// Add the criteria incase keyword search is not null
			if ( Validator.isNotNull(searchOption) && Validator.isNotNull(keyWord)) {
				Criterion criteria = null;		
				
				// Define search criteria
				if ( searchOption.equals(SEARCH_TEN_OPTION)) {
					criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
				} else {
					criteria = RestrictionsFactoryUtil.ilike("ma", keyWord + "%");
				}
				
				// Define search criteria
				query = query.add( criteria );
			}

			try {
				results = ChucVuLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (results == null) {
			results = new ArrayList<ChucVu>();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CHUC_VU_RESULT", results);
		
		// Store the search option to session for coming back to search screen from edit screen
		Map<String, String> searchParam = new HashMap<String, String>();

		if (Validator.isNull(searchOption)) {
			searchOption = SEARCH_TEN_OPTION;
		}
		
		searchParam.put("searchOption", searchOption);		
		searchParam.put("keyWord", keyWord);
		
		// Set the search param back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CHUC_VU_PARAMS", searchParam);
		
		// Redirect User
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/chuc_vu_list_popup.jsp");
		actionResponse.setRenderParameter("searchOption", searchOption);
		actionResponse.setRenderParameter("keyWord", keyWord);
		actionResponse.setRenderParameter("coQuanQuanLyID", coQuanQuanLyID);
	}
	
	/**
	 * This is function find TaiKhoanNguoiDung by Id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param taiKhoanNguoiDungId
	 * @return TaiKhoanNguoiDung
	 */
	private TaiKhoanNguoiDung findTaiKhoanNguoiDungById(long taiKhoanNguoiDungId) {
		try {
			return TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNguoiDungId);
		} catch (Exception es) {
			try {
				return TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNguoiDungId);
			} catch (SystemException e) {
			}
		}
		return null;
	}
}
