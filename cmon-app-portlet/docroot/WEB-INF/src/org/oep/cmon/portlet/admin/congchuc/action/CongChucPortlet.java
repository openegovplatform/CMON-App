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

package org.oep.cmon.portlet.admin.congchuc.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.portlet.admin.congchuc.utils.CongChucUtils;
import org.oep.cmon.portlet.admin.congchuc.utils.LiferayUtils;
import org.oep.cmon.portlet.taocongdan.business.TaoCongDanBusiness;
import org.oep.cmon.util.Helpers;
import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChucClp;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro;
import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTroClp;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class CongChucPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CongChucPortlet extends MVCPortlet {
	private String createCoQuanQuanLyJSP = "/html/portlet/admin/congchuc/coquanquanly/add.jsp";
	private String detailCoQuanQuanLyJSP = "/html/portlet/admin/congchuc/coquanquanly/details.jsp";
	// cong chuc view
	private static String PageEditCongChuc = "/html/portlet/admin/congchuc/congchuc/add.jsp";
	private static String PageDetailCongChuc = "/html/portlet/admin/congchuc/congchuc/details.jsp";
	private static String PagePopupCoQuanQuanLy = "/html/portlet/admin/congchuc/congchuc/popupcoquanquanly.jsp";
	private static String PageResetPassword = "/html/portlet/admin/congchuc/congchuc/resetpassword.jsp";
	private static String pageQuyenCongChuc = "/html/portlet/admin/congchuc/congchuc/listvaitro.jsp";
	// error view
	private static String PageError = "/html/portlet/admin/congchuc/pageerror.jsp";

	/**
	 * This is function search CoQuanQuanLy
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
	public void searchCoQuanQuanLy(ActionRequest request,
			ActionResponse response) throws Exception {
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String parentId = ParamUtil.getString(request, "parentId", "");
		Long chaId = null;
		if (!parentId.equals("")) {
			chaId = Long.valueOf(parentId);
		}
		List<CoQuanQuanLy> listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
		if (searchInputText.equals("")) {
			listCoQuanQuanLy = CoQuanQuanLyLocalServiceUtil.findByParentId(
					chaId, 0);
		} else {
			listCoQuanQuanLy = CongChucUtils.searchCoQuanQuanLyByMaOrTen(
					searchInputText, 0);
		}
		request.setAttribute("listCoQuanQuanLy", listCoQuanQuanLy);
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("parentId", parentId);
	}

	/**
	 * This is  function search CoQuanQuanLy popup
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
	public void searchCoQuanQuanLyPopup(ActionRequest request,
			ActionResponse response) throws Exception {
		String chucVuId = ParamUtil.getString(request, "chucVuId", "");
		String coQuanQuanLyId = ParamUtil.getString(request, "coQuanQuanLyId",
				"");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String[] strcqqlids = request.getParameterValues("strcqqlids[]");
		if (strcqqlids != null) {
			boolean insertOk = true;
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			ChucVu chucVu = ChucVuLocalServiceUtil.fetchChucVu(Long
					.valueOf(chucVuId));
			List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdChucVuAndIdCoQuanQuanLy(Long.valueOf(chucVuId),
							Long.valueOf(coQuanQuanLyId), 0);
			long[] vaitroids = new long[listChucVu2VaiTro.size()];
			for (int i = 0; i < listChucVu2VaiTro.size(); i++) {
				vaitroids[i] = listChucVu2VaiTro.get(i).getVaiTroId();
			}
			for (int i = 0; i < strcqqlids.length; i++) {
				CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
						.fetchCoQuanQuanLy(Long.valueOf(strcqqlids[i]));
				if (chucVu != null && coQuanQuanLy != null && user != null) {
					boolean subInsert = CongChucUtils.ganChucVuToCoQuanQuanLy(
							chucVu, vaitroids, coQuanQuanLy, user);
					if (!subInsert) {
						insertOk = false;
					}
				}
			}
			if (insertOk) {
				SessionMessages.add(request, "createChucVuSuccess");
			} else {
				SessionErrors.add(request, "addChucVuError");
			}

		}
		List<CoQuanQuanLy> listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
		listCoQuanQuanLy = CongChucUtils.searchCoQuanQuanLyByMaOrTen(
				searchInputText, 0);

		request.setAttribute("chucVuId", chucVuId);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("listCoQuanQuanLy", listCoQuanQuanLy);
		request.setAttribute("searchInputText", searchInputText);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/coquanquanly/addchucvutocqql.jsp");
	}

	/**
	 * This is  function create CoQuanQuanLy
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
	public void createCoQuanQuanLy(ActionRequest request,
			ActionResponse response) throws Exception {
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String parentId = ParamUtil.getString(request, "parentId", "");
		List<CoQuanQuanLy> listCoQuanQuanLy = CongChucUtils
				.searchCoQuanQuanLyByMaOrTen("", 0);
		List<CapCoQuanQuanLy> listCapCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil
				.findByTrangThai(0);
		String idTinh = ThamSoLocalServiceUtil.getValue("DANANG");
		Map<String, String> userRequest = new HashMap<String, String>();
		userRequest.put("idTinh", idTinh);

		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("parentId", parentId);
		request.setAttribute("listCoQuanQuanLy", listCoQuanQuanLy);
		request.setAttribute("listCapCoQuanQuanLy", listCapCoQuanQuanLy);
		request.setAttribute("CQQL_OBJECT", userRequest);
		request.setAttribute("type", "add");
		response.setRenderParameter("jspPage", createCoQuanQuanLyJSP);
	}

	/**
	 * This is  function edit CoQuanQuanLy
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
	public void editCoQuanQuanLy(ActionRequest request, ActionResponse response)
			throws Exception {
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String parentId = ParamUtil.getString(request, "parentId", "");
		long coQuanQuanLyId = ParamUtil.getLong(request, "coQuanQuanLyId", 0l);
		List<CoQuanQuanLy> listCoQuanQuanLy = CongChucUtils
				.searchCoQuanQuanLyByMaOrTen("", 0);
		List<CapCoQuanQuanLy> listCapCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil
				.findByTrangThai(0);
		if (coQuanQuanLyId > 0) {
			CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
					.fetchCoQuanQuanLy(coQuanQuanLyId);
			Map<String, String> userRequest = new HashMap<String, String>();
			if (coQuanQuanLy != null) {
				userRequest = CongChucUtils.getMapCQQLFromCQQL(coQuanQuanLy);
			}
			request.setAttribute("CQQL_OBJECT", userRequest);
		}
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("parentId", parentId);
		request.setAttribute("listCoQuanQuanLy", listCoQuanQuanLy);
		request.setAttribute("listCapCoQuanQuanLy", listCapCoQuanQuanLy);
		request.setAttribute("type", "edit");
		response.setRenderParameter("jspPage", createCoQuanQuanLyJSP);
	}

	/**
	 * This is  function save CoQuanQuanLy
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
	public void saveCoQuanQuanLy(ActionRequest request, ActionResponse response)
			throws Exception {
		String type = ParamUtil.getString(request, "type", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String parentId = ParamUtil.getString(request, "parentId", "");
		List<String> errors = CongChucUtils.validCoQuanQuanLy(request);
		Map<String, String> userRequest = CongChucUtils
				.getMapCQQLFromRequest(request);
		if (errors.isEmpty()) {
			request.setAttribute("searchInputText", URLDecoder.decode(searchInputText,StringPool.UTF8));
			if (type.equals("add")) {
				try {
					CongChucUtils.insertCoQuanQuanLy(userRequest, request);
					SessionMessages.add(request, "coquanquanly.success.create");
				} catch (Exception e) {
					response.setRenderParameter("jspPage", PageError);
				}

			} else {
				try {
					CongChucUtils.updateCoQuanQuanLy(userRequest, request);
					SessionMessages.add(request, "coquanquanly.success.update");
				} catch (Exception e) {
					response.setRenderParameter("jspPage", PageError);
				}
			}
		} else {
			for (int i = 0; i < errors.size(); i++) {
				SessionErrors.add(request, errors.get(i));
			}
			List<CapCoQuanQuanLy> listCapCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil
					.findByTrangThai(0);
			request.setAttribute("CQQL_OBJECT", userRequest);
			request.setAttribute("listCapCoQuanQuanLy", listCapCoQuanQuanLy);
			request.setAttribute("searchInputText", searchInputText);
			response.setRenderParameter("jspPage", createCoQuanQuanLyJSP);
		}
		request.setAttribute("type", type);
		request.setAttribute("parentId", parentId);
	}

	/**
	 * This is  function delete CoQuanQuanLy
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
	public void deleteCoQuanQuanLy(ActionRequest request,
			ActionResponse response) throws Exception {
		long id = ParamUtil.getLong(request, "coQuanQuanLyId");
		String searchInputText =URLDecoder.decode(ParamUtil.getString(request,
				"searchInputText", ""),StringPool.UTF8);
		String parentId = ParamUtil.getString(request, "parentId", "");

		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("parentId", parentId);
		List<CoQuanQuanLy> lst = CoQuanQuanLyLocalServiceUtil.findByParentId(
				id, 0);
		List<CongChuc> lcc = CongChucLocalServiceUtil.listCongChuc(id,"",0,1);
		if (lst.size() > 0) {
			SessionErrors.add(request, "coquanquanly.err.childExists");
			return;
		}
		if (lcc.size() > 0) {
			SessionErrors.add(request, "coquanquanly.err.congChucExists");
			return;
		}

		try {
			List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdCoQuanQuanLy(id);
			for (int i = 0; i < listChucVu2VaiTro.size(); i++) {
				ChucVu2VaiTroLocalServiceUtil
						.deleteChucVu2VaiTro(listChucVu2VaiTro.get(i));
			}
			CongChucUtils.delete(id);
			SessionMessages.add(request, "coquanquanly.success.delete");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, "coquanquanly.err.unKnown");
			return;
		}
	}

	/**
	 * This is  function CoQuanQuanLy detail
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws Exception
	 * @throws PortletException
	 */
	public void detailCoQuanQuanLy(ActionRequest request,
			ActionResponse response) throws Exception {
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String parentId = ParamUtil.getString(request, "parentId", "");
		long coQuanQuanLyId = ParamUtil.getLong(request, "coQuanQuanLyId", 0);
		if (coQuanQuanLyId > 0) {
			CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
					.fetchCoQuanQuanLy(coQuanQuanLyId);
			request.setAttribute("coQuanQuanLy", coQuanQuanLy);
		}
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("parentId", parentId);
		response.setRenderParameter("jspPage", detailCoQuanQuanLyJSP);
	}

	/**
	 * This is  function list ChucVuCoQuanQuanLy
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
	public void listChucVuCoQuanQuanLy(ActionRequest request,
			ActionResponse response) throws Exception {
		String coQuanQuanLyId = ParamUtil.getString(request, "coQuanQuanLyId",
				"");
		String parentId = ParamUtil.getString(request, "parentId", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		if (!coQuanQuanLyId.equals("")) {
			Set<Long> setChucVuId = new HashSet<Long>();
			List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdCoQuanQuanLyAndDaXoa(Long.valueOf(coQuanQuanLyId),
							0);
			for (int i = 0; i < listChucVu2VaiTro.size(); i++) {
				setChucVuId.add(listChucVu2VaiTro.get(i).getChucVuId());
			}
			request.setAttribute("setChucVuId", setChucVuId);
			request.setAttribute("listChucVu2VaiTro", listChucVu2VaiTro);
		}
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("parentId", parentId);
		request.setAttribute("searchInputText", searchInputText);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/coquanquanly/listchucvu.jsp");
	}

	/**
	 * This is  function create ChucVu
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
	public void createChucVu(ActionRequest request, ActionResponse response)
			throws Exception {
		String coQuanQuanLyId = ParamUtil.getString(request, "coQuanQuanLyId",
				"");
		String parentId = ParamUtil.getString(request, "parentId", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		List<ChucVu> listChucVu = ChucVuLocalServiceUtil.findTrangThai(0);
		List<VaiTro> listVaiTro = VaiTroLocalServiceUtil.findByTrangThai(0);
		request.setAttribute("parentId", parentId);
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("listChucVu", listChucVu);
		request.setAttribute("listVaiTro", listVaiTro);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/coquanquanly/addchucvu.jsp");
	}

	/**
	 * This is  function edit ChucVu
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
	public void editChucVu(ActionRequest request, ActionResponse response)
			throws Exception {
		long coQuanQuanLyId = ParamUtil.getLong(request, "coQuanQuanLyId", 0l);
		long chucVuId = ParamUtil.getLong(request, "chucVuId", 0l);
		String parentId = ParamUtil.getString(request, "parentId", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
				.findByIdChucVuAndIdCoQuanQuanLy(chucVuId, coQuanQuanLyId, 0);
		List<ChucVu> listChucVu = ChucVuLocalServiceUtil.findTrangThai(0);
		List<VaiTro> listVaiTro = VaiTroLocalServiceUtil.findByTrangThai(0);
		request.setAttribute("parentId", parentId);
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("chucVuId", chucVuId);
		request.setAttribute("listChucVu2VaiTro", listChucVu2VaiTro);
		request.setAttribute("listChucVu", listChucVu);
		request.setAttribute("listVaiTro", listVaiTro);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/coquanquanly/addchucvu.jsp");
	}

	/**
	 * This is  function save ChucVu
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
	public void saveChucVu(ActionRequest request, ActionResponse response)
			throws Exception {
		boolean insertOk = false;
		long coQuanQuanLyId = ParamUtil.getLong(request, "coquanquanlyid", 0l);
		long chucVuId = ParamUtil.getLong(request, "chucvuid", 0l);
		String parentId = ParamUtil.getString(request, "parentId", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String[] strVaiTroIds = request.getParameterValues("vaitroids");
		long[] vaiTroIds = new long[strVaiTroIds.length];
		User user = PortalUtil.getUser(request);
		ChucVu chucVu = ChucVuLocalServiceUtil.fetchChucVu(chucVuId);
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
				.fetchCoQuanQuanLy(coQuanQuanLyId);
		for (int i = 0; i < strVaiTroIds.length; i++) {
			vaiTroIds[i] = Long.parseLong(strVaiTroIds[i]);
		}
		if (user != null && chucVu != null && coQuanQuanLy != null) {
			insertOk = CongChucUtils.ganChucVuToCoQuanQuanLy(chucVu, vaiTroIds,
					coQuanQuanLy, user);
		}
		if (user == null) {
			SessionErrors.add(request, "not.login.error");
		}
		if (insertOk) {
			SessionMessages.add(request, "createChucVuSuccess");
		} else {
			SessionErrors.add(request, "addChucVuError");
		}
		if (coQuanQuanLyId != 0l) {
			Set<Long> setChucVuId = new HashSet<Long>();
			List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdCoQuanQuanLyAndDaXoa(coQuanQuanLyId, 0);
			for (int i = 0; i < listChucVu2VaiTro.size(); i++) {
				setChucVuId.add(listChucVu2VaiTro.get(i).getChucVuId());
			}
			request.setAttribute("setChucVuId", setChucVuId);
			request.setAttribute("listChucVu2VaiTro", listChucVu2VaiTro);
		}
		request.setAttribute("parentId", parentId);
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/coquanquanly/listchucvu.jsp");
	}

	/**
	 * This is  function delete ChucVu
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
	public void deleteChucVu(ActionRequest request, ActionResponse response)
			throws Exception {
		boolean deleteOk = false;
		long coQuanQuanLyId = ParamUtil.getLong(request, "coQuanQuanLyId", 0l);
		long chucVuId = ParamUtil.getLong(request, "chucVuId", 0l);
		String parentId = ParamUtil.getString(request, "parentId", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		ChucVu chucVu = ChucVuLocalServiceUtil.fetchChucVu(chucVuId);
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
				.fetchCoQuanQuanLy(coQuanQuanLyId);
		if (user != null && chucVu != null && coQuanQuanLy != null) {
			deleteOk = CongChucUtils.xoaChucVuToCoQuanQuanLy(chucVu,
					coQuanQuanLy, user);
		}
		if (deleteOk) {
			SessionMessages.add(request, "deleteChucVuSuccess");
		} else {
			SessionErrors.add(request, "deleteChucVuError");
		}
		if (coQuanQuanLyId != 0l) {
			Set<Long> setChucVuId = new HashSet<Long>();
			List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdCoQuanQuanLyAndDaXoa(coQuanQuanLyId, 0);
			for (int i = 0; i < listChucVu2VaiTro.size(); i++) {
				setChucVuId.add(listChucVu2VaiTro.get(i).getChucVuId());
			}
			request.setAttribute("setChucVuId", setChucVuId);
			request.setAttribute("listChucVu2VaiTro", listChucVu2VaiTro);
		}
		request.setAttribute("parentId", parentId);
		request.setAttribute("searchInputText", searchInputText);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/coquanquanly/listchucvu.jsp");
	}

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
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	public void getDonViHanhChinhById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		String id = ParamUtil.getString(resourceRequest, "id");

		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();

		// Danh sach don vi hanh chinh
		List<DonViHanhChinh> dsDVHC = findDonViHanhChinhByChaId(Long
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

	/**
	 * This is  function find DonViHanhChinh by ChaId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chaId
	 * @return List<DonViHanhChinh>
	 */ 
	@SuppressWarnings("unchecked")
	private List<DonViHanhChinh> findDonViHanhChinhByChaId(long chaId) {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DonViHanhChinh.class);

		// This is a test line for display all request if there's no search
		// criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
		Criterion criteriaChaId = RestrictionsFactoryUtil.eq("chaId", chaId);

		// Define search criteria
		query = query.add(criteriaChaId).add(criteriaTrangThai);

		try {
			return DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<DonViHanhChinh>();
	}

	// cong chuc module actions
	/**
	 * This is  function search list CongChuc
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
	public void searchListCongChuc(ActionRequest request,
			ActionResponse response) throws Exception {
		long coQuanQuanLyId = ParamUtil.getLong(request, "coQuanQuanLyId", 0);
		String maOrTenOrEmail = ParamUtil.getString(request, "maOrTenOrEmail",
				"");
		String tab = ParamUtil.getString(request, "tab", "CC");
		List<CongChuc> listCongChuc = CongChucLocalServiceUtil.listCongChuc(
				coQuanQuanLyId, maOrTenOrEmail, 0, 10);
		int total = CongChucLocalServiceUtil.countListCongChuc(coQuanQuanLyId,
				maOrTenOrEmail);
		request.setAttribute("listCongChuc", listCongChuc);
		request.setAttribute("total", total);
		request.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("tab", tab);
	}

	/**
	 * This is  function CongChuc detail
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
	 * @throws NumberFormatException
	 * @throws SystemException 
	 */ 
	public void detailCongChuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, SystemException {
		String congChucId = ParamUtil.getString(actionRequest, "congChucId");
		String coQuanQuanLyId = ParamUtil.getString(actionRequest,
				"coQuanQuanLyId", "");
		String maOrTenOrEmail = ParamUtil.getString(actionRequest,
				"maOrTenOrEmail", "");
		CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(Long
				.valueOf(congChucId));
		if (congChuc != null) {
			TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil
					.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
			CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
					.fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
			actionRequest.setAttribute("taiKhoan", taiKhoan);
			actionRequest.setAttribute("coQuanQuanLy", coQuanQuanLy);
		}
		actionRequest.setAttribute("coQuanQuanLyId",
				String.valueOf(coQuanQuanLyId));
		actionRequest.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		actionRequest.setAttribute("congChuc", congChuc);
		actionResponse.setRenderParameter("jspPage", PageDetailCongChuc);
	}

	/**
	 * This is  function create CongChuc
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
	public void createCongChuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long coQuanQuanLyId = ParamUtil.getLong(actionRequest,
				"coQuanQuanLyId", 0);
		String maOrTenOrEmail = ParamUtil.getString(actionRequest,
				"maOrTenOrEmail", "");
		CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyClp();
		if (coQuanQuanLyId > 0) {
			coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
					.fetchCoQuanQuanLy(coQuanQuanLyId);
		}
		actionRequest.setAttribute("coQuanQuanLyId",
				String.valueOf(coQuanQuanLyId));
		actionRequest.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		actionRequest.setAttribute("coQuanQuanLy", coQuanQuanLy);
		actionResponse.setRenderParameter("jspPage", PageEditCongChuc);
	}

	/**
	 * This is  function edit CongChuc
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
	 * @throws NumberFormatException
	 * @throws SystemException
	 */
	public void editCongChuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, SystemException {
		String congChucId = ParamUtil.getString(actionRequest, "congChucId");
		long coQuanQuanLyId = ParamUtil.getLong(actionRequest,
				"coQuanQuanLyId", 0);
		String maOrTenOrEmail = ParamUtil.getString(actionRequest,
				"maOrTenOrEmail", "");
		CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(Long
				.valueOf(congChucId));
		if (congChuc != null) {
			TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil
					.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
			CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
					.fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
			actionRequest.setAttribute("taiKhoan", taiKhoan);
			actionRequest.setAttribute("coQuanQuanLy", coQuanQuanLy);
		}
		actionRequest.setAttribute("coQuanQuanLyId",
				String.valueOf(coQuanQuanLyId));
		actionRequest.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		actionRequest.setAttribute("congChuc", congChuc);
		actionResponse.setRenderParameter("jspPage", PageEditCongChuc);
	}
	
	/**
	 * This is  function save CongChuc
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
	public void saveCongChuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String coQuanQuanLyId = ParamUtil.getString(actionRequest,
				"coQuanQuanLyId", "");
		String maOrTenOrEmail = ParamUtil.getString(actionRequest,
				"maOrTenOrEmail", "");
		String emailForm = ParamUtil.getString(actionRequest,
				"email", "");
		String tab = ParamUtil.getString(actionRequest, "tab", "CC");

		long id = ParamUtil.getLong(actionRequest, "id", 0);
		User currentUser = PortalUtil.getUser(actionRequest);
		if (currentUser == null) {
			SessionErrors.add(actionRequest, "not.login.error");
		}
		CongChuc congChuc = null;
		if (id > 0) {
			congChuc = CongChucLocalServiceUtil.fetchCongChuc(id);
		} else {
			congChuc = new CongChucClp();
		}
		try {
			congChuc = this.getCongChucFormHtml(congChuc, actionRequest);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		TaiKhoanNguoiDung taiKhoan = new TaiKhoanNguoiDungClp();

		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
				.fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
		ChucVu chucVu = null;
		if (congChuc.getChucVuId() > 0) {
			chucVu = ChucVuLocalServiceUtil.getChucVu(congChuc.getChucVuId());
		}
		List<String> errors = CongChucUtils.validCongChuc(actionRequest);
		if (errors.isEmpty() && currentUser != null) {
			String password = (ParamUtil.getString(actionRequest, "password",
					""));
			String rePassword = ParamUtil.getString(actionRequest,
					"rePassword", "");
			String email = (ParamUtil.getString(actionRequest, "email", ""));
			boolean flag = true;
			if (id == 0) {
				//truong hop them moi
				flag = LiferayUtils.addUser(congChuc.getHoVaTen(), email,
						password, rePassword, currentUser.getUserId(),
						currentUser.getCompanyId());

				if (flag) {
					User user = UserLocalServiceUtil.getUserByEmailAddress(
							currentUser.getCompanyId(), email);
					try {
						String loaiDoiTuongId = ThamSoLocalServiceUtil
								.getValue("LDT_CANBO");
						taiKhoan.setId(CounterLocalServiceUtil.increment(TaoCongDanBusiness.TAIKHOANNGUOIDUNG_SEQUENCE));
						taiKhoan.setTaiKhoanNguoiDungId(user.getUserId());
						taiKhoan.setNgayTao(new Date());
						taiKhoan.setNguoiTao(currentUser.getFullName());
						taiKhoan.setTenNguoiDung(congChuc.getHoVaTen());
						taiKhoan.setTenDangNhap(email);
						taiKhoan.setLoaiDoiTuongId(Long.valueOf(loaiDoiTuongId));
						taiKhoan.setEmail(email);
						taiKhoan.setMatKhau(CongChucUtils.md5(password));
						taiKhoan.setTrangThai(1);
						TaiKhoanNguoiDung taiKhoanResult = TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(taiKhoan);
						if (taiKhoanResult != null) {
							try {
								congChuc.setId(CounterLocalServiceUtil.increment("cmon_congchuc"));
								congChuc.setNgayTao(new Date());
								congChuc.setTaiKhoanNguoiDungId(taiKhoanResult
										.getId());
								congChuc.setNguoiTao(currentUser.getFullName());
								CongChuc congChucReturn = CongChucLocalServiceUtil
										.addCongChuc(congChuc);
								if (chucVu != null) {
									CongChucUtils.ganChucVuToCanBo(
											congChucReturn, coQuanQuanLy,
											chucVu);
								}
								SessionMessages.add(actionRequest,
										"insert.success");
								actionRequest.setAttribute("coQuanQuanLyId",
										String.valueOf(coQuanQuanLyId));
								actionRequest.setAttribute("maOrTenOrEmail",
										URLDecoder.decode(maOrTenOrEmail,StringPool.UTF8));
								actionRequest.setAttribute("tab", tab);
							} catch (Exception e) {
								TaiKhoanNguoiDungLocalServiceUtil
										.deleteTaiKhoanNguoiDung(taiKhoanResult);
								UserLocalServiceUtil.deleteUser(user);
								actionResponse.setRenderParameter("jspPage",
										PageError);
								return;
							}

						}
					} catch (Exception e) {
						UserLocalServiceUtil.deleteUser(user);
						actionResponse.setRenderParameter("jspPage", PageError);
						return;
					}
				} else {
					actionResponse.setRenderParameter("jspPage", PageError);
					return;
				}
			} else {
				//Truong hop chinh sua
				try {
					taiKhoan = TaiKhoanNguoiDungLocalServiceUtil
							.fetchTaiKhoanNguoiDung(congChuc
									.getTaiKhoanNguoiDungId());
					User user = UserLocalServiceUtil.fetchUser(taiKhoan
							.getTaiKhoanNguoiDungId());
					if (user == null) {
						LiferayUtils.addUser(congChuc.getHoVaTen(), email,
								"huynq", "huynq", currentUser.getUserId(),
								currentUser.getCompanyId());
						user = UserLocalServiceUtil
								.getUserByEmailAddress(
										currentUser.getCompanyId(),
										taiKhoan.getEmail());
					} else {
						user.setFirstName(congChuc.getHoVaTen());
						user.setEmailAddress(email);
						user.setModifiedDate(new Date());
						UserLocalServiceUtil.updateUser(user);
					}
					CongChuc currentCongChuc = CongChucLocalServiceUtil
							.fetchCongChuc(id);
					if (chucVu != null) {
						CongChucUtils.xoaChucVuToCanBo(currentCongChuc,
								CoQuanQuanLyLocalServiceUtil
										.fetchCoQuanQuanLy(currentCongChuc
												.getCoQuanQuanLyId()));
						CongChucUtils.ganChucVuToCanBo(congChuc, coQuanQuanLy,
								chucVu);
					} else {
						CongChucUtils.xoaChucVuToCanBo(currentCongChuc,
								CoQuanQuanLyLocalServiceUtil
										.fetchCoQuanQuanLy(currentCongChuc
												.getCoQuanQuanLyId()));
					}
					taiKhoan.setNgaySua(new Date());
					taiKhoan.setNguoiSua(currentUser.getFullName());
					taiKhoan.setTenNguoiDung(congChuc.getHoVaTen());
					taiKhoan.setTenDangNhap(email);
					taiKhoan.setEmail(email);
					taiKhoan.setTaiKhoanNguoiDungId(user.getUserId());
					TaiKhoanNguoiDung taiKhoanResult = TaiKhoanNguoiDungLocalServiceUtil
							.updateTaiKhoanNguoiDung(taiKhoan);
					congChuc.setNgaySua(new Date());
					congChuc.setTaiKhoanNguoiDungId(taiKhoanResult.getId());
					congChuc.setNguoiSua(currentUser.getFullName());
					CongChucLocalServiceUtil.updateCongChuc(congChuc);
					SessionMessages.add(actionRequest, "update.success");
					actionRequest.setAttribute("coQuanQuanLyId",
							String.valueOf(coQuanQuanLyId));
					actionRequest
							.setAttribute("maOrTenOrEmail",URLDecoder.decode(maOrTenOrEmail,StringPool.UTF8));
					actionRequest.setAttribute("tab", tab);
				} catch (Exception e) {
					actionResponse.setRenderParameter("jspPage", PageError);
					return;
				}

			}
		} else {
			for (int i = 0; i < errors.size(); i++) {
				SessionErrors.add(actionRequest, errors.get(i));
			}
			actionRequest.setAttribute("coQuanQuanLyId",
					String.valueOf(coQuanQuanLyId));
			actionRequest.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
			actionRequest.setAttribute("emailForm", emailForm);
			actionRequest.setAttribute("congChuc", congChuc);
			actionRequest.setAttribute("taiKhoan", taiKhoan);
			actionRequest.setAttribute("coQuanQuanLy", coQuanQuanLy);
			actionResponse.setRenderParameter("jspPage", PageEditCongChuc);
		}
	}

	/**
	 * This is  function delete CongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws UnsupportedEncodingException
	 */
	public void deleteCongChuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws UnsupportedEncodingException {
		String congChucId = ParamUtil.getString(actionRequest, "congChucId");
		String tab = ParamUtil.getString(actionRequest, "tab", "CC");
		String coQuanQuanLyId = ParamUtil.getString(actionRequest,
				"coQuanQuanLyId", "");
		String maOrTenOrEmail = URLDecoder.decode(ParamUtil.getString(actionRequest,
				"maOrTenOrEmail", ""),StringPool.UTF8);
		try {
			CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(Long
					.valueOf(congChucId));
			if (congChuc != null) {
				TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil
						.fetchTaiKhoanNguoiDung(congChuc
								.getTaiKhoanNguoiDungId());
				if (taiKhoan != null) {
					User user = UserLocalServiceUtil.fetchUser(taiKhoan
							.getTaiKhoanNguoiDungId());
					if (user != null) {
						CongChucLocalServiceUtil.deleteCongChuc(congChuc);
						List<NguoiDung2VaiTro> listNguoiDung2VaiTro = NguoiDung2VaiTroLocalServiceUtil
								.findByTaiKhoanNguoiDungID(taiKhoan.getId(), 0);
						for (int i = 0; i < listNguoiDung2VaiTro.size(); i++) {
							NguoiDung2VaiTroLocalServiceUtil
									.deleteNguoiDung2VaiTro(listNguoiDung2VaiTro
											.get(i));
						}
						TaiKhoanNguoiDungLocalServiceUtil
								.deleteTaiKhoanNguoiDung(taiKhoan);
						UserLocalServiceUtil.deleteUser(user);
						SessionMessages.add(actionRequest, "delete.success");
					} else {
						SessionErrors.add(actionRequest, "delete.error");
					}
				} else {
					SessionErrors.add(actionRequest, "delete.error");
				}
			} else {
				SessionErrors.add(actionRequest, "delete.error");
			}
		} catch (Exception e) {
			actionResponse.setRenderParameter("jspPage", PageError);
			return;
		}
		actionRequest.setAttribute("coQuanQuanLyId",
				String.valueOf(coQuanQuanLyId));
		actionRequest.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		actionRequest.setAttribute("tab", tab);
	}

	/**
	 * This is  function Popup CoQuanQuanLy
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
	public void popupCoQuanQuanLy(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String coQuanQuanLyId = ParamUtil.getString(actionRequest,
				"coQuanQuanLyId", "");
		String maOrTen = ParamUtil.getString(actionRequest, "maOrTen", "");
		int currentTransPage = ParamUtil.getInteger(actionRequest,
				"currentTransPage", 0);

		actionRequest.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		actionResponse.setRenderParameter("jspPage", PagePopupCoQuanQuanLy);
		actionResponse.setRenderParameter("maOrTen", maOrTen);
		actionResponse.setRenderParameter("currentTransPage",
				String.valueOf(currentTransPage));
	}

	/**
	 * This is  function get data ChucVu
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
	 * @throws NumberFormatException
	 * @throws SystemException
	 */
	public void getDataChucVu(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, SystemException {
		String coQuanQuanLyId = ParamUtil.getString(actionRequest,
				"coQuanQuanLyId");
		JSONArray rows = JSONFactoryUtil.getJSONFactory().createJSONArray();
		List<ChucVu> listChucVu = new ArrayList<ChucVu>();
		if (!Helpers.isEmpty(coQuanQuanLyId)) {
			listChucVu = ChucVuLocalServiceUtil.findByCoQuanQuanLy(
					Long.valueOf(coQuanQuanLyId), 0);
		}

		for (ChucVu item : listChucVu) {
			JSONObject obj = JSONFactoryUtil.getJSONFactory()
					.createJSONObject();
			obj.put("id", item.getId());
			obj.put("name", item.getTen());
			rows.put(obj);
		}

		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(actionResponse);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding(StringPool.UTF8);
		resourceResponse.getWriter().write(rows.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is  function reset password
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
	public void resetPassword(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String congChucId = ParamUtil
				.getString(actionRequest, "congChucId", "");
		CongChuc congChuc = null;
		if (!Helpers.isEmpty(congChucId)) {
			congChuc = CongChucLocalServiceUtil.fetchCongChuc(Long
					.valueOf(congChucId));
		} else {
			actionResponse.setRenderParameter("jspPage", PageError);
		}
		actionRequest.setAttribute("congChuc", congChuc);
		actionResponse.setRenderParameter("jspPage", PageResetPassword);
	}

	/**
	 * This is  function save password
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
	public void saveResetPassword(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String password = ParamUtil.getString(actionRequest, "password", "");
		String rePassword = ParamUtil
				.getString(actionRequest, "rePassword", "");
		long taiKhoanId = ParamUtil.getLong(actionRequest, "taiKhoanId", 0);
		CongChuc congChuc = CongChucLocalServiceUtil
				.fetchByTaiKhoanNguoiDung(taiKhoanId);
		boolean valid = true;
		if (Validator.isNull(ParamUtil.getString(actionRequest, "password"))) {
			SessionErrors.add(actionRequest, "empty.password");
			valid = false;
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "rePassword"))) {
			SessionErrors.add(actionRequest, "empty.repassword");
			valid = false;
		}
		if (Validator.isNotNull(ParamUtil
				.getString(actionRequest, "rePassword"))
				&& Validator.isNotNull(ParamUtil.getString(actionRequest,
						"password"))) {
			if (!ParamUtil.getString(actionRequest, "rePassword").equals(
					ParamUtil.getString(actionRequest, "password"))) {
				SessionErrors.add(actionRequest, "missmatch.password");
				valid = false;
			}
		}
		if (valid) {
			TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil
					.fetchTaiKhoanNguoiDung(taiKhoanId);
			taiKhoan.setMatKhau(CongChucUtils.md5(password));
			TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(taiKhoan);
			boolean changeOk = LiferayUtils.changePassword(
					taiKhoan.getTaiKhoanNguoiDungId(), password, rePassword);
			if (changeOk) {
				SessionMessages.add(actionRequest, "change.success");
			} else {
				SessionErrors.add(actionRequest, "change.error");
			}
		}
		actionRequest.setAttribute("congChuc", congChuc);
		actionResponse.setRenderParameter("jspPage", PageResetPassword);
	}

	/**
	 * This is  function get CongChuc from Html
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param actionRequest
	 * @throws Exception
	 */
	private CongChuc getCongChucFormHtml(CongChuc congChuc,
			ActionRequest actionRequest) throws Exception {
		congChuc.setHoVaTen(ParamUtil.getString(actionRequest, "hoVaTen", ""));
		congChuc.setMa(ParamUtil.getString(actionRequest, "ma", ""));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest,"ngaySinh"))){
			congChuc.setNgaySinh(ParamUtil.getDate(actionRequest, "ngaySinh",
					new SimpleDateFormat("dd/MM/yyyy")));
		}else{
			congChuc.setNgaySinh(null);
		}
		congChuc.setGioiTinhId(ParamUtil.getLong(actionRequest, "gioiTinh", 0));
		congChuc.setCoQuanQuanLyId(ParamUtil
				.getLong(actionRequest, "cqqlId", 0));
		congChuc.setChucVuId(ParamUtil.getLong(actionRequest, "chucVuId", 0));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest,"ngayCapCmnd"))){
			congChuc.setNgayCapCmnd(ParamUtil.getDate(actionRequest, "ngayCapCmnd",
					new SimpleDateFormat("dd/MM/yyyy")));
		}else{
			congChuc.setNgayCapCmnd(null);
		}
		congChuc.setSoCmnd(ParamUtil.getString(actionRequest, "soCmnd", ""));
		congChuc.setNoiCapCmnd(ParamUtil.getString(actionRequest, "noiCapCmnd",
				""));
		return congChuc;
	}

	/**
	 * This is  function role of CongChuc
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
	public void quyenCongChuc(ActionRequest request, ActionResponse response)
			throws Exception {
		long congChucId = ParamUtil.get(request, "congChucId", 0l);
		String coQuanQuanLyId = ParamUtil.getString(request, "coQuanQuanLyId",
				"");
		String maOrTenOrEmail = ParamUtil.getString(request, "maOrTenOrEmail",
				"");
		CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(congChucId);
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
		}
		List<ChucVu2VaiTro> listChucVu2VaiTro = null;
		if (congChuc.getChucVuId() != 0) {
			listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdChucVuAndIdCoQuanQuanLy(congChuc.getChucVuId(),
							congChuc.getCoQuanQuanLyId(), 0);
		}
		List<NguoiDung2VaiTro> listNguoiDung2VaiTro = NguoiDung2VaiTroLocalServiceUtil
				.findByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(),
						Constants.ACTIVATED);
		request.setAttribute("congChucId", congChucId);
		request.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("listChucVu2VaiTro", listChucVu2VaiTro);
		request.setAttribute("listNguoiDung2VaiTro", listNguoiDung2VaiTro);
		response.setRenderParameter("jspPage", pageQuyenCongChuc);
	}

	/**
	 * This is  function save role popup
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
	public void searchVaiTroPopup(ActionRequest request, ActionResponse response)
			throws Exception {
		String congChucId = ParamUtil.getString(request, "congChucId", "");
		String searchInputText = ParamUtil.getString(request,
				"searchInputText", "");
		String[] strVaiTroIds = request.getParameterValues("strVaiTroIds[]");
		if (strVaiTroIds != null) {
			boolean insertOk = true;
			User user = PortalUtil.getUser(request);
			CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(Long
					.valueOf(congChucId));
			TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
			long[] vaitroids = new long[strVaiTroIds.length];
			for (int i = 0; i < strVaiTroIds.length; i++) {
				vaitroids[i] = Long.valueOf(strVaiTroIds[i]);
			}
			for (int i = 0; i < vaitroids.length; i++) {
				NguoiDung2VaiTro nguoiDung2VaiTro = new NguoiDung2VaiTroClp();
				nguoiDung2VaiTro.setId(CounterLocalServiceUtil
						.increment(NguoiDung2VaiTro.class.getName()));
				nguoiDung2VaiTro.setNgayTao(new Date());
				if (user != null) {
					nguoiDung2VaiTro.setNguoiTao(user.getFullName());
				} else {
					nguoiDung2VaiTro.setNguoiTao("ADMIN");
				}
				nguoiDung2VaiTro.setDaXoa(0);
				nguoiDung2VaiTro.setVaiTroId(vaitroids[i]);
				nguoiDung2VaiTro.setTaiKhoanNguoiDungId(taiKhoanNguoiDung
						.getId());
				NguoiDung2VaiTroLocalServiceUtil
						.addNguoiDung2VaiTro(nguoiDung2VaiTro);
			}
			insertOk = CongChucUtils.ganQuyenToCanBo(congChuc, vaitroids);
			if (insertOk) {
				SessionMessages.add(request, "addVaiTroSuccess");
				request.setAttribute("submited", 1);
			} else {
				for (int i = 0; i < vaitroids.length; i++) {
					NguoiDung2VaiTro nguoiDung2VaiTro = NguoiDung2VaiTroLocalServiceUtil
							.findByVaiTroIDAndTaiKhoanNguoiDungId(vaitroids[i],
									taiKhoanNguoiDung.getId(), 0);
					NguoiDung2VaiTroLocalServiceUtil
							.deleteNguoiDung2VaiTro(nguoiDung2VaiTro);
				}
				SessionErrors.add(request, "addVaiTroError");
			}

		}
		List<VaiTro> listVaiTro = new ArrayList<VaiTro>();
		listVaiTro = CongChucUtils.searchVaiTroByTen(searchInputText, 0);
		request.setAttribute("congChucId", congChucId);
		request.setAttribute("listVaiTro", listVaiTro);
		request.setAttribute("searchInputText", searchInputText);
		response.setRenderParameter("jspPage",
				"/html/portlet/admin/congchuc/congchuc/addvaitrotocanbo.jsp");
	}

	/**
	 * This is  function delete VaiTro to CanBo
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
	public void deleteVaiTroToCanBo(ActionRequest request,
			ActionResponse response) throws Exception {
		String coQuanQuanLyId = ParamUtil.getString(request, "coQuanQuanLyId",
				"");
		String maOrTenOrEmail = ParamUtil.getString(request, "maOrTenOrEmail",
				"");
		boolean deleteOk = false;
		long congChucId = ParamUtil.getLong(request, "congChucId", 0);
		long vaiTroId = ParamUtil.getLong(request, "vaiTroId", 0);

		CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(congChucId);
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
		}
		NguoiDung2VaiTro nguoiDung2VaiTro = NguoiDung2VaiTroLocalServiceUtil
				.findByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
						taiKhoanNguoiDung.getId(), 0);
		if (nguoiDung2VaiTro != null) {
			deleteOk = CongChucUtils.xoaQuyenToCanBo(congChuc, vaiTroId);
			if (deleteOk) {
				NguoiDung2VaiTroLocalServiceUtil
						.deleteNguoiDung2VaiTro(nguoiDung2VaiTro);
			}
		}
		List<ChucVu2VaiTro> listChucVu2VaiTro = null;
		if (congChuc.getChucVuId() != 0) {
			listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil
					.findByIdChucVuAndIdCoQuanQuanLy(congChuc.getChucVuId(),
							congChuc.getCoQuanQuanLyId(), 0);
		}
		List<NguoiDung2VaiTro> listNguoiDung2VaiTro = NguoiDung2VaiTroLocalServiceUtil
				.findByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(),
						Constants.ACTIVATED);

		if (deleteOk) {
			SessionMessages.add(request, "deleteVaiTroSuccess");
		} else {
			SessionErrors.add(request, "deleteVaiTroError");
		}
		request.setAttribute("congChucId", congChucId);
		request.setAttribute("maOrTenOrEmail", maOrTenOrEmail);
		request.setAttribute("coQuanQuanLyId", coQuanQuanLyId);
		request.setAttribute("listChucVu2VaiTro", listChucVu2VaiTro);
		request.setAttribute("listNguoiDung2VaiTro", listNguoiDung2VaiTro);
		response.setRenderParameter("jspPage", pageQuyenCongChuc);
	}
}