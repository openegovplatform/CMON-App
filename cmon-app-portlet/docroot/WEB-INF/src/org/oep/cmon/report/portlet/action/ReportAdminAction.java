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

package org.oep.cmon.report.portlet.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.admin.portlet.util.SetParamUtil;
import org.oep.cmon.dao.report.model.impl.CongChuc2RoleImpl;
import org.oep.cmon.dao.report.model.impl.DanhMucBaoCaoImpl;
import org.oep.cmon.dao.report.model.impl.DanhMucRoleImpl;
import org.oep.cmon.dao.report.model.impl.Role2BaoCaoImpl;
import org.oep.cmon.dao.report.model.impl.Role2DonViBaoCaoImpl;
import org.oep.cmon.dao.report.model.impl.Role2NhomTTHCImpl;
import org.oep.cmon.dao.report.model.impl.Role2TTHCImpl;
import org.oep.cmon.report.portlet.util.ActionAdminUtil;
import org.oep.cmon.report.portlet.util.ReportValidate;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;
import org.oep.cmon.dao.report.model.CongChuc2Role;
import org.oep.cmon.dao.report.model.DanhMucBaoCao;
import org.oep.cmon.dao.report.model.DanhMucRole;
import org.oep.cmon.dao.report.model.Role2BaoCao;
import org.oep.cmon.dao.report.model.Role2DonViBaoCao;
import org.oep.cmon.dao.report.model.Role2NhomTTHC;
import org.oep.cmon.dao.report.model.Role2TTHC;
import org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil;
import org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.DanhMucBaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2BaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2DonViBaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2NhomTTHCLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2TTHCLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class ReportAdminAction  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ReportAdminAction extends MVCPortlet {
	public static String viewDanhmucbaocao = "/html/portlet/reportadmin/danhmucbaocao/view.jsp";
	public static String addDanhmucbaocao = "/html/portlet/reportadmin/danhmucbaocao/add.jsp";
	public static String viewDanhmucrole = "/html/portlet/reportadmin/role/view.jsp";
	public static String addDanhmucrole = "/html/portlet/reportadmin/role/add.jsp";
	public static String viewrole = "/html/portlet/reportadmin/role/role.jsp";
	public static String viewUserrole = "/html/portlet/reportadmin/nguoidung/view.jsp";
	public static String viewjsp = "/html/portlet/reportadmin/view.jsp";

	/**
	 * This is function add or edit Danhmucbaocao
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
	public void addOrEditDanhmucbaocao(ActionRequest request,
			ActionResponse response) throws Exception {
		String keyWord = request.getParameter("searchKeyWord");
		String reportname = ParamUtil.getString(request, "reportname");
		String url = ParamUtil.getString(request, "url");
		String order = ParamUtil.getString(request, "order");
		String status = ParamUtil.getString(request, "status");
		String publish = ParamUtil.getString(request, "publish");
		String id = ParamUtil.getString(request, "id");
		if (ReportValidate.validationInputDMBaocao(reportname, url, request)) {
			DanhMucBaoCao dmBaocao = null;
			if (id.trim().length() > 0) {
				try {
					dmBaocao = DanhMucBaoCaoLocalServiceUtil
							.getDanhMucBaoCao(Long.valueOf(id));
					dmBaocao.setTENBAOCAO(reportname);
					dmBaocao.setDUONGDAN(url);
					dmBaocao.setORDERS(!order.equals("") ? (Validator
							.isNumber(order) ? Integer.valueOf(order) : 99)
							: 99);
					dmBaocao.setSTATUS(status.equals("on") ? 1 : 0);
					dmBaocao.setPUBLISH(publish.equals("on") ? 1 : 0);
					DanhMucBaoCaoLocalServiceUtil.updateDanhMucBaoCao(dmBaocao);
					SessionMessages.add(request, "save-successfully");
					response.setRenderParameter("jspPage", viewjsp);
				} catch (Exception e) {
					e.printStackTrace();
					SetParamUtil.printError(dmBaocao.toString());
					SessionErrors.add(request, "errorUpdateDanhmucbaocao");
				}

			} else {
				try {
					dmBaocao = new DanhMucBaoCaoImpl();
					dmBaocao.setID(CounterLocalServiceUtil
							.increment(DanhMucBaoCao.class.getName()));
					dmBaocao.setTENBAOCAO(reportname);
					dmBaocao.setDUONGDAN(url);
					dmBaocao.setORDERS(!order.equals("") ? (Validator
							.isNumber(order) ? Integer.valueOf(order) : 99)
							: 99);
					dmBaocao.setSTATUS(status.equals("on") ? 1 : 0);
					dmBaocao.setPUBLISH(publish.equals("on") ? 1 : 0);
					DanhMucBaoCaoLocalServiceUtil.addDanhMucBaoCao(dmBaocao);
					SessionMessages.add(request, "save-successfully");
					response.setRenderParameter("jspPage", viewjsp);
				} catch (Exception e) {
					e.printStackTrace();
					SetParamUtil.printError(dmBaocao.toString());
					SessionErrors.add(request, "errorAddDanhmucbaocao");
				}
			}
		} else {
			response.setRenderParameter("reportname", reportname);
			response.setRenderParameter("url", url);
			response.setRenderParameter("order", order);
			response.setRenderParameter("status", status.equals("on") ? "1"
					: "0");
			response.setRenderParameter("publish", publish.equals("on") ? "1"
					: "0");
			response.setRenderParameter("id", id);
			response.setRenderParameter("jspPage", addDanhmucbaocao);
		}
		SetParamUtil.setParameter(request, response, keyWord);
	}

	/**
	 * This is function delete Danhmucbaocao
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
	public void deleteDanhmucbaocao(ActionRequest request,
			ActionResponse response) throws Exception {
		String id = ParamUtil.getString(request, "id");
		if (Validator.isNotNull(id)) {
			if(!ActionAdminUtil.checkBaocaoInRole2Baocao(Long.valueOf(id))){
				DanhMucBaoCaoLocalServiceUtil.deleteDanhMucBaoCao(Long.valueOf(id));
				SessionMessages.add(request, "delete-successfully");
			}else{
				SessionErrors.add(request, "delete-failed");
			}
			response.setRenderParameter("jspPage", viewjsp);
			SetParamUtil.setParameter(request, response, "");
		}
	}

	
	/**
	 * This is function search Danhmucbaocao
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
	@SuppressWarnings("unchecked")
	public void searchDanhmucbaocao(ActionRequest request,
			ActionResponse response) throws Exception {
		String keyword = ParamUtil.getString(request, "keyword");
		if (keyword.trim().length() > 0) {
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(DanhMucBaoCao.class);
			query.add(RestrictionsFactoryUtil.ilike("TENBAOCAO",StringPool.PERCENT + keyword + StringPool.PERCENT));
			List<DanhMucBaoCao> listdmbaocao = DanhMucBaoCaoLocalServiceUtil
					.dynamicQuery(query);
			request.setAttribute("listdmbaocao", listdmbaocao);
			response.setRenderParameter("keyword", keyword);
		}
		response.setRenderParameter("jspPage", viewjsp);
	}

	/**
	 * This is function add or edit DanhMuc role
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
	public void addOrEditDanhmucrole(ActionRequest request,
			ActionResponse response) throws Exception {
		String keyWord = request.getParameter("searchKeyWord");
		String name = ParamUtil.getString(request, "name");
		String order = ParamUtil.getString(request, "order");
		String status = ParamUtil.getString(request, "status");
		String id = ParamUtil.getString(request, "id");
		if (ReportValidate.validationInputDMRole(name, request)) {
			DanhMucRole dmRole = null;
			if (id.trim().length() > 0) {
				try {
					dmRole = DanhMucRoleLocalServiceUtil.getDanhMucRole(Long
							.valueOf(id));
					dmRole.setNAME(name);
					dmRole.setORDERS(!order.equals("") ? (Validator
							.isNumber(order) ? Integer.valueOf(order) : 99)
							: 99);
					dmRole.setSTATUS(status.equals("on") ? 1 : 0);
					DanhMucRoleLocalServiceUtil.updateDanhMucRole(dmRole);
					SessionMessages.add(request, "save-successfully");
					response.setRenderParameter("jspPage", viewjsp);
				} catch (Exception e) {
					e.printStackTrace();
					SetParamUtil.printError(dmRole.toString());
					SessionErrors.add(request, "errorUpdateDanhmucrole");
				}

			} else {
				try {
					dmRole = new DanhMucRoleImpl();
					dmRole.setID(CounterLocalServiceUtil
							.increment(DanhMucRole.class.getName()));
					dmRole.setNAME(name);
					dmRole.setORDERS(!order.equals("") ? (Validator
							.isNumber(order) ? Integer.valueOf(order) : 99)
							: 99);
					dmRole.setSTATUS(status.equals("on") ? 1 : 0);
					DanhMucRoleLocalServiceUtil.addDanhMucRole(dmRole);
					SessionMessages.add(request, "save-successfully");
					response.setRenderParameter("jspPage", viewjsp);
				} catch (Exception e) {
					e.printStackTrace();
					SetParamUtil.printError(dmRole.toString());
					SessionErrors.add(request, "errorAddDanhmucrole");
				}
			}
		} else {
			response.setRenderParameter("name", name);
			response.setRenderParameter("order", order);
			response.setRenderParameter("status", status.equals("on") ? "1"
					: "0");
			response.setRenderParameter("id", id);
			response.setRenderParameter("jspPage", addDanhmucrole);
		}
		response.setRenderParameter("tab","vaitro");
		SetParamUtil.setParameter(request, response, keyWord);
	}

	/**
	 * This is function delete DanhMuc role
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
	public void deleteDanhmucrole(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil.getString(request, "id");
		if (Validator.isNotNull(id)) {
			if(!ActionAdminUtil.checkRoleInCongchucRole(Long.valueOf(id))){
				try {
					DanhMucRoleLocalServiceUtil.deleteDanhMucRole(Long.valueOf(id));
					ActionAdminUtil.deleteRole2Baocao(Long.valueOf(id));
					ActionAdminUtil.deleteRole2DonviBaocao(Long.valueOf(id));
					ActionAdminUtil.deleteRole2NhomTTHC(Long.valueOf(id));
					ActionAdminUtil.deleteRole2TTHC(Long.valueOf(id));
				} catch (Exception e) {
					e.printStackTrace();
				}
				SessionMessages.add(request, "delete-successfully");
			}else{
				SessionErrors.add(request, "delete-failed");
			}
			response.setRenderParameter("tab","vaitro");
			response.setRenderParameter("jspPage", viewjsp);
			SetParamUtil.setParameter(request, response, "");
		}
	}

	
	/**
	 * This is function search DanhMuc role
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
	@SuppressWarnings("unchecked")
	public void searchDanhmucrole(ActionRequest request, ActionResponse response)
			throws Exception {
		String keyword = ParamUtil.getString(request, "keyword");
		if (keyword.trim().length() > 0) {
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(DanhMucRole.class);
			query.add(RestrictionsFactoryUtil.ilike("NAME",StringPool.PERCENT + keyword + StringPool.PERCENT));
			List<DanhMucRole> listdmrole = DanhMucRoleLocalServiceUtil
					.dynamicQuery(query);
			request.setAttribute("listdmrole", listdmrole);
			response.setRenderParameter("keyword", keyword);
		}
		response.setRenderParameter("tab","vaitro");
		response.setRenderParameter("jspPage", viewjsp);
	}

	/**
	 * This is function save role
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
	public void saveRole(ActionRequest request, ActionResponse response)
			throws Exception {
		String role_id = ParamUtil.getString(request, "role_id");
		String[] id_dmbaocao = ParamUtil.getParameterValues(request, "id_dmbaocao");
		String[] id_donvibaocao = null;
		String[] id_linhvuc = null;
		String[] id_loaihoso = null;
		Role2BaoCao role2BaoCao = null;
		Role2DonViBaoCao role2DonViBaoCao = null;
		Role2NhomTTHC role2NhomTTHC = null;
		Role2TTHC role2TTHC = null;
		List<CoQuanQuanLy2LinhVuc> listlinhvuc = new ArrayList<CoQuanQuanLy2LinhVuc>();
		List<ThuTucHanhChinh> listTTHC = new ArrayList<ThuTucHanhChinh>();
		//Xoa ca table du lieu theo role_id
		try {
			ActionAdminUtil.deleteRole2Baocao(Long.valueOf(role_id));
			ActionAdminUtil.deleteRole2DonviBaocao(Long.valueOf(role_id));
			ActionAdminUtil.deleteRole2NhomTTHC(Long.valueOf(role_id));
			ActionAdminUtil.deleteRole2TTHC(Long.valueOf(role_id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Lap so bao cao duoc tick chon
		for (int i = 0; i < id_dmbaocao.length; i++) {
			id_donvibaocao = ParamUtil.getParameterValues(request, "id_donvibaocao_"+id_dmbaocao[i]);
			id_linhvuc = ParamUtil.getParameterValues(request, "id_linhvuc_"+id_dmbaocao[i]);
			id_loaihoso = ParamUtil.getParameterValues(request, "id_loaihoso_"+id_dmbaocao[i]);
			//insert Role2Donvibaocao
			String str_iddonvi = "";
			for (int j = 0; j < id_donvibaocao.length; j++) {
				try {
					role2DonViBaoCao = new Role2DonViBaoCaoImpl();
					role2DonViBaoCao.setID(CounterLocalServiceUtil.increment(Role2DonViBaoCao.class.getName()));
					role2DonViBaoCao.setRPDANHMUCBAOCAOID(Long.valueOf(id_dmbaocao[i]));
					role2DonViBaoCao.setRPDANHMUCROLEID(Long.valueOf(role_id));
					role2DonViBaoCao.setCOQUANQUANLYID(Long.valueOf(id_donvibaocao[j]));
					Role2DonViBaoCaoLocalServiceUtil.addRole2DonViBaoCao(role2DonViBaoCao);
				} catch (Exception e) {
					e.printStackTrace();
					SetParamUtil.printError(role2DonViBaoCao.toString());
				}
				//Lay iddonvi
				str_iddonvi += id_donvibaocao[j];
				if(j<(id_donvibaocao.length-1)){
					str_iddonvi += ",";
				}
			}
			//Lay NhomTTHC tu iddonvi
			if(str_iddonvi.length()>0){
				listlinhvuc = CoQuanQuanLy2LinhVucLocalServiceUtil.getLinhvucByIdDonvi(str_iddonvi);
				//insert Role2NhomTTHC
				List<Long> listIdTTHC = new ArrayList<Long>();
				for (int j = 0; j < id_linhvuc.length; j++) {
					for (int j2 = 0; j2 < listlinhvuc.size(); j2++) {
						if(Long.valueOf(id_linhvuc[j])==listlinhvuc.get(j2).getNHOMTHUTUCHANHCHINHID()){
							try {
								role2NhomTTHC = new Role2NhomTTHCImpl();
								role2NhomTTHC.setID(CounterLocalServiceUtil.increment(Role2NhomTTHC.class.getName()));
								role2NhomTTHC.setRPDANHMUCROLEID(Long.valueOf(role_id));
								role2NhomTTHC.setRPDANHMUCBAOCAOID(Long.valueOf(id_dmbaocao[i]));
								role2NhomTTHC.setNHOMTHUTUCHANHCHINHID(Long.valueOf(id_linhvuc[j]));
								Role2NhomTTHCLocalServiceUtil.addRole2NhomTTHC(role2NhomTTHC);
								//Lay idnhomtthc
								listIdTTHC.add(listlinhvuc.get(j2).getNHOMTHUTUCHANHCHINHID());
							} catch (Exception e) {
								e.printStackTrace();
								SetParamUtil.printError(role2NhomTTHC.toString());
							}
						}
					}
				}
				//Lay TTHC tu idnhomtthc
				if(listIdTTHC.size()>0){
					listTTHC = ActionAdminUtil.getTTHCByIdNhomTTHC(listIdTTHC,str_iddonvi);
				}
				//insert Role2TTHC
				for (int j = 0; j < id_loaihoso.length; j++) {
					for (int j2 = 0; j2 < listTTHC.size(); j2++) {
						if(Long.valueOf(id_loaihoso[j])==listTTHC.get(j2).getId()){
							try {
								role2TTHC = new Role2TTHCImpl();
								role2TTHC.setID(CounterLocalServiceUtil.increment(Role2TTHC.class.getName()));
								role2TTHC.setRPDANHMUCBAOCAOID(Long.valueOf(id_dmbaocao[i]));
								role2TTHC.setRPDANHMUCROLEID(Long.valueOf(role_id));
								role2TTHC.setTHUTUCHANHCHINHID(Long.valueOf(id_loaihoso[j]));
								Role2TTHCLocalServiceUtil.addRole2TTHC(role2TTHC);
							} catch (Exception e) {
								e.printStackTrace();
								SetParamUtil.printError(role2TTHC.toString());
							}
						}
					}
				}
			}
			//insert Role2Baocao
			try {
				role2BaoCao = new Role2BaoCaoImpl();
				role2BaoCao.setID(CounterLocalServiceUtil.increment(Role2BaoCao.class.getName()));
				role2BaoCao.setRPDANHMUCROLEID(Long.valueOf(role_id));
				role2BaoCao.setRPDANHMUCBAOCAOID(Long.valueOf(id_dmbaocao[i]));
				Role2BaoCaoLocalServiceUtil.addRole2BaoCao(role2BaoCao);
			} catch (Exception e) {
				e.printStackTrace();
				SetParamUtil.printError(role2BaoCao.toString());
			}
		}
		response.setRenderParameter("id",role_id);
		response.setRenderParameter("tab","vaitro");
		response.setRenderParameter("jspPage",viewrole);
	}
	
	/**
	 * This is function save UserRole
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
	public void saveUserRole(ActionRequest request,ActionResponse response) 
			throws Exception {
		String tkNguoidungId = ParamUtil.getString(request, "tkNguoidungId");
		String id_donvi = ParamUtil.getString(request, "id_donvi");
		String keyword = ParamUtil.getString(request, "keyword");
		String phanquyen = ParamUtil.getString(request, "phanquyen");
		String[] role_id = ParamUtil.getParameterValues(request, "role_id");
		CongChuc2Role congChuc2Role = null;
		try {
			ActionAdminUtil.deleteUserRoleByTkNguoiDungId(Long.valueOf(tkNguoidungId));
			for (int i = 0; i < role_id.length; i++) {
				try {
					congChuc2Role = new CongChuc2RoleImpl();
					congChuc2Role.setID(CounterLocalServiceUtil.increment(CongChuc2Role.class.getName()));
					congChuc2Role.setCONGCHUCID(Long.valueOf(tkNguoidungId));
					congChuc2Role.setRPDANHMUCROLEID(Long.valueOf(role_id[i]));
					CongChuc2RoleLocalServiceUtil.addCongChuc2Role(congChuc2Role);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					SetParamUtil.printError(congChuc2Role.toString());
				}
			}
			SessionMessages.add(request, "save-successfully");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, "errorAddUserRole");
		}
		response.setRenderParameter("id_donvi",id_donvi);
		response.setRenderParameter("keyword",keyword);
		response.setRenderParameter("phanquyen",phanquyen);
		response.setRenderParameter("tab","nguoidung");
		response.setRenderParameter("jspPage",viewjsp);
	}
	
	/**
	 * This is function remove UserInRole
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
	public void removeUserInRole(ActionRequest request,ActionResponse response) 
			throws Exception {
		String roleId = ParamUtil.getString(request, "roleId");
		String[] tkNguoidungId = ParamUtil.getParameterValues(request, "tkNguoidungId[]");
		try {
			ActionAdminUtil.deleteTkNguoiDungByRoleId(Long.valueOf(roleId),tkNguoidungId);
			SessionMessages.add(request, "save-successfully");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, "errorAddUserRole");
		}
		response.setRenderParameter("tab","vaitro");
		response.setRenderParameter("jspPage",viewjsp);
	}
	
	/**
	 * This is function search TaiKhoanNguoiDung
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
	public void searchTaikhoannguoidung(ActionRequest request,ActionResponse response) 
			throws Exception {
		String keyword = ParamUtil.getString(request, "keyword");
		String id_donvi = ParamUtil.getString(request, "id_donvi");
		String phanquyen = ParamUtil.getString(request, "phanquyen");
		List<TaiKhoanNguoiDung> listresult = ActionAdminUtil.getAllTaiKhoanNguoiDung(0, keyword,Long.valueOf(id_donvi),phanquyen);
		request.setAttribute("listtknd",listresult);
		response.setRenderParameter("keyword",keyword);
		response.setRenderParameter("id_donvi",id_donvi);
		response.setRenderParameter("phanquyen",phanquyen);
		response.setRenderParameter("jspPage",viewjsp);
		response.setRenderParameter("tab","nguoidung");
	}

}
