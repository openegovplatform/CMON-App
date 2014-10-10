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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.oep.cmon.report.portlet.util.ActionUtil;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;
import org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil;
import org.oep.cmon.dao.report.model.Baocaochitiet;
import org.oep.cmon.dao.report.model.Lephi_chitiet;
import org.oep.cmon.dao.report.model.Lephi_linhvuc;
import org.oep.cmon.dao.report.model.Lephi_tonghop;
import org.oep.cmon.dao.report.model.ReportThongKe;
import org.oep.cmon.dao.report.model.ReportTongHop;
import org.oep.cmon.dao.report.model.ReportTongHopChiTiet;
import org.oep.cmon.dao.report.service.BaocaochitietLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_linhvucLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_tonghopLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportThongKeLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportTongHopChiTietLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class ReportAction  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ReportAction extends MVCPortlet {
	
	/**
	 * This is function baoCaoThongKe
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
	public void baoCaoThongKe(ActionRequest request, ActionResponse response)
			throws Exception {
		String idBaoCao = ParamUtil.getString(request, "idBaoCao");
		String viewPage = ParamUtil.getString(request, "viewPage");
		String id_coquanquanly = ParamUtil
				.getString(request, "id_coquanquanly");
		String report_tieuchi = ParamUtil.getString(request, "report_tieuchi");
		String thang = ParamUtil.getString(request, "thang");
		String nam = ParamUtil.getString(request, "nam");
		String selectedthang = ParamUtil.getString(request, "selectedthang");
		String selectedquy = ParamUtil.getString(request, "selectedquy");
		List<ReportThongKe> listReportThongKe = ReportThongKeLocalServiceUtil
				.getListReportThongKeGroupByIDCoQuan(id_coquanquanly, thang,
						nam);
		request.setAttribute("listReportThongKe", listReportThongKe);
		request.setAttribute("id_coquanquanly", id_coquanquanly);
		request.setAttribute("report_tieuchi", report_tieuchi);
		request.setAttribute("selectedthang", selectedthang);
		request.setAttribute("selectedquy", selectedquy);
		request.setAttribute("thang", thang);
		request.setAttribute("nam", nam);
		response.setRenderParameter("viewPage", viewPage);
		response.setRenderParameter("idBaoCao", idBaoCao);
		SessionMessages.add(request, "");
	}

	/**
	 * This is function baoCaoTongHop
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
	public void baoCaoTongHop(ActionRequest request, ActionResponse response)
			throws Exception {
		boolean isDisplay = ParamUtil.getBoolean(request, "isDisplay");
		String idBaoCao = ParamUtil.getString(request, "idBaoCao");
		String viewPage = ParamUtil.getString(request, "viewPage");
		String report_type = ParamUtil.getString(request, "report_type");
		int id_donvi = ParamUtil.getInteger(request, "id_donvi");
		String[] id_linhvuc = ParamUtil.getParameterValues(request,
				"id_linhvuc");
		long[] id_loaihoso = ParamUtil.getLongValues(request, "id_loaihoso");
		String thang = ParamUtil.getString(request, "thang");
		String selectedtime = ParamUtil.getString(request, "selectedtime");
		String nam = ParamUtil.getString(request, "nam");
		String str_loaihoso = "";
		String str_linhvuc = "";
		for (int i = 0; i < id_loaihoso.length; i++) {
			str_loaihoso += id_loaihoso[i];
			if (i < (id_loaihoso.length - 1)) {
				str_loaihoso += ",";
			}
		}
		for (int i = 0; i < id_linhvuc.length; i++) {
			str_linhvuc += id_linhvuc[i];
			if (i < (id_linhvuc.length - 1)) {
				str_linhvuc += ",";
			}
		}
		if (isDisplay) {
			if (report_type.equals("tongquat")) {
				if (!str_linhvuc.equals("")) {
					List<ReportTongHop> listTongHop = new ArrayList<ReportTongHop>();
					listTongHop = ActionUtil
							.getListReportTongHopGroupByIDNhomThuTuc(
									String.valueOf(id_donvi), str_linhvuc,
									thang, nam);
					request.setAttribute("listResult", listTongHop);
				} else {
					request.setAttribute("message",
							"Vui lÃ²ng chá»�n nhÃ³m thá»§ tá»¥c hÃ nh chÃ­nh");
				}
			}
			if (report_type.equals("nam")) {
				if (!str_linhvuc.equals("")) {
					Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
					List<ReportTongHop> listTongHop = new ArrayList<ReportTongHop>();
					listTongHop = ActionUtil.getListReportTongHop(
							String.valueOf(id_donvi), str_linhvuc, nam);
					for (int i = 0; i < listTongHop.size(); i++) {
						setIDNhomThuTuc.add(listTongHop.get(i)
								.getNHOMTHUTUCHANHCHINHID());
					}
					request.setAttribute("setIDNhomThuTuc", setIDNhomThuTuc);
					request.setAttribute("listResult", listTongHop);
				} else {
					request.setAttribute("message",
							"Vui lÃ²ng chá»�n nhÃ³m thá»§ tá»¥c hÃ nh chÃ­nh");
				}
			}
			if (report_type.equals("chitiet")) {
				if (!str_loaihoso.equals("")) {
					Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
					List<ReportTongHopChiTiet> listTongHopChiTiet = new ArrayList<ReportTongHopChiTiet>();
					listTongHopChiTiet = ReportTongHopChiTietLocalServiceUtil
							.getListReportTongHopChiTietGroupByIDThuTuc(
									String.valueOf(id_donvi), str_loaihoso,
									thang, nam);
					for (int i = 0; i < listTongHopChiTiet.size(); i++) {
						setIDNhomThuTuc.add(listTongHopChiTiet.get(i)
								.getNHOMTHUTUCHANHCHINHID());
					}
					request.setAttribute("setIDNhomThuTuc", setIDNhomThuTuc);
					request.setAttribute("listResult", listTongHopChiTiet);
				} else {
					request.setAttribute("message",
							"Vui lÃ²ng chá»�n thá»§ tá»¥c hÃ nh chÃ­nh");
				}
			}
		}
		List<Long> listid_lhs = new ArrayList<Long>();
		List<Long> listid_lv = new ArrayList<Long>();
		for (int i = 0; i < id_linhvuc.length; i++) {
			listid_lv.add(Long.valueOf(id_linhvuc[i]));
		}
		for (int i = 0; i < id_loaihoso.length; i++) {
			listid_lhs.add(id_loaihoso[i]);
		}
		request.setAttribute("report_type", report_type);
		request.setAttribute("id_donvi", id_donvi);
		request.setAttribute("id_loaihoso", listid_lhs);
		request.setAttribute("id_linhvuc", listid_lv);
		request.setAttribute("thang", thang);
		request.setAttribute("selectedtime", selectedtime);
		request.setAttribute("nam", nam);
		request.setAttribute("isDisplay",isDisplay==true?"1":"0");
		response.setRenderParameter("viewPage", viewPage);
		response.setRenderParameter("idBaoCao", idBaoCao);
		SessionMessages.add(request, "");
	}

	/**
	 * This is function baocaoLePhi
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
	public void baocaoLePhi(ActionRequest request, ActionResponse response)
			throws Exception {
		String idBaoCao = ParamUtil.getString(request, "idBaoCao");
		String viewPage = ParamUtil.getString(request, "viewPage");
		String report_type = ParamUtil.getString(request, "report_type");
		String id_donvi = ParamUtil.getString(request, "id_donvi");
		String display_result = ParamUtil.getString(request, "display_result");
		long[] id_loaihoso = ParamUtil.getLongValues(request, "id_loaihoso");
		long[] id_linhvuc = ParamUtil.getLongValues(request, "id_linhvuc");
		String str_loaihoso = "";
		String str_linhvuc = "";
		for (int i = 0; i < id_loaihoso.length; i++) {
			str_loaihoso += id_loaihoso[i];
			if (i < (id_loaihoso.length - 1)) {
				str_loaihoso += ",";
			}
		}
		for (int i = 0; i < id_linhvuc.length; i++) {
			str_linhvuc += id_linhvuc[i];
			if (i < (id_linhvuc.length - 1)) {
				str_linhvuc += ",";
			}
		}
		String ngaynhan_tungay = ParamUtil.getString(request, "tungay");
		String ngaynhan_denngay = ParamUtil.getString(request, "denngay");
		String selectedtime = ParamUtil.getString(request, "selectedtime");
		String nam = ParamUtil.getString(request, "nam");
		List<Lephi_chitiet> listlephichitiet = new ArrayList<Lephi_chitiet>();
		List<Lephi_linhvuc> listlephilinhvuc = new ArrayList<Lephi_linhvuc>();
		List<Lephi_tonghop> listlephitonghop = new ArrayList<Lephi_tonghop>();
		if (report_type.equals("lephichitiet") && display_result.equals("1")) {
			if (!str_loaihoso.equals("")) {
				listlephichitiet = Lephi_chitietLocalServiceUtil.lephichitiet(
						str_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
			}
		} else if (report_type.equals("lephilinhvuc") && display_result.equals("1")) {
			if (!str_linhvuc.equals("")) {
				listlephilinhvuc = Lephi_linhvucLocalServiceUtil.lephilinhvuc(
						str_linhvuc, ngaynhan_tungay, ngaynhan_denngay);
			}
		} else if (report_type.equals("lephitonghop") && display_result.equals("1")) {
			if (!str_loaihoso.equals("")) {
				listlephitonghop = Lephi_tonghopLocalServiceUtil.lephitonghop(
						str_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
			}
		}
		request.setAttribute("listlephichitiet", listlephichitiet);
		request.setAttribute("listlephilinhvuc", listlephilinhvuc);
		request.setAttribute("listlephitonghop", listlephitonghop);
		response.setRenderParameter("report_type", report_type);
		response.setRenderParameter("id_loaihoso", str_loaihoso);
		response.setRenderParameter("id_linhvuc", str_linhvuc);
		response.setRenderParameter("id_donvi", id_donvi);
		response.setRenderParameter("ngaynhan_tungay", ngaynhan_tungay);
		response.setRenderParameter("ngaynhan_denngay", ngaynhan_denngay);
		response.setRenderParameter("selectedtime", selectedtime);
		response.setRenderParameter("nam", nam);
		response.setRenderParameter("display_result", display_result);
		response.setRenderParameter("viewPage", viewPage);
		response.setRenderParameter("idBaoCao", idBaoCao);
		SessionMessages.add(request, "");
	}
	
	/**
	 * This is function baocaoChungThuc
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
	public void baocaoChungThuc(ActionRequest request, ActionResponse response)
			throws Exception {
		String idBaoCao = ParamUtil.getString(request, "idBaoCao");
		String viewPage = ParamUtil.getString(request, "viewPage");
		String id_donvi = ParamUtil.getString(request, "id_donvi");
		String display_result = ParamUtil.getString(request, "display_result");
		long[] id_loaihoso = ParamUtil.getLongValues(request, "id_loaihoso");
		String str_loaihoso = "";
		for (int i = 0; i < id_loaihoso.length; i++) {
			str_loaihoso += id_loaihoso[i];
			if (i < (id_loaihoso.length - 1)) {
				str_loaihoso += ",";
			}
		}
		String tungay = ParamUtil.getString(request, "tungay");
		String denngay = ParamUtil.getString(request, "denngay");
		String selectedtime = ParamUtil.getString(request, "selectedtime");
		String nam = ParamUtil.getString(request, "nam");
		List<HoSoChungThuc> listhosochungthuc = new ArrayList<HoSoChungThuc>();
		if (display_result.equals("1")) {
			listhosochungthuc = ActionUtil.listhsct(str_loaihoso, tungay, denngay);
		}
		request.setAttribute("listhosochungthuc", listhosochungthuc);
		response.setRenderParameter("id_loaihoso", str_loaihoso);
		response.setRenderParameter("id_donvi", id_donvi);
		response.setRenderParameter("ngaynhan_tungay",tungay);
		response.setRenderParameter("ngaynhan_denngay",denngay);
		response.setRenderParameter("selectedtime", selectedtime);
		response.setRenderParameter("nam", nam);
		response.setRenderParameter("display_result", display_result);
		response.setRenderParameter("viewPage", viewPage);
		response.setRenderParameter("idBaoCao", idBaoCao);
		SessionMessages.add(request, "");
	}

	/**
	 * This is function baocaoChiTiet
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
	public void baocaoChiTiet(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		// lay du lieu tu form
		String idBaoCao = ParamUtil.getString(actionRequest, "idBaoCao");
		String viewPage = ParamUtil.getString(actionRequest, "viewPage");

		String[] loaihoso = null;
		String ngaynhan_tungay = "";
		String ngaynhan_denngay = "";
		String trangthai = "";
		String time = "";// cac radio button
		String year = "";// select nam
		String CoquanId = "";
		String tinh_trang = "";
		String loaidangky = "";
		String id_donvi = ParamUtil.getString(actionRequest, "chon_donvi");
		String display_result = ParamUtil.getString(actionRequest,
				"display_result");

		if (Validator.isNotNull(actionRequest.getParameterValues("loai-hoso"))) {
			loaihoso = actionRequest.getParameterValues("loai-hoso");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest,
				"ngaynhan_tungay"))) {
			ngaynhan_tungay = ParamUtil.getString(actionRequest,
					"ngaynhan_tungay");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest,
				"ngaynhan_denngay"))) {
			ngaynhan_denngay = ParamUtil.getString(actionRequest,
					"ngaynhan_denngay");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest,
				"trangthai_hoso"))) {
			trangthai = ParamUtil.getString(actionRequest, "trangthai_hoso");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "time"))) {
			time = ParamUtil.getString(actionRequest, "time");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "nam"))) {
			year = ParamUtil.getString(actionRequest, "nam");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest,
				"tinhtrang_hoso"))) {
			tinh_trang = ParamUtil.getString(actionRequest, "tinhtrang_hoso");
		}

		if (Validator.isNotNull(ParamUtil.getString(actionRequest,
				"loaidangky_hoso"))) {
			loaidangky = ParamUtil.getString(actionRequest, "loaidangky_hoso");
		}

		actionRequest.setAttribute("loaihoso", loaihoso);
		actionRequest.setAttribute("ngaynhan_tungay", ngaynhan_tungay);
		actionRequest.setAttribute("ngaynhan_denngay", ngaynhan_denngay);
		actionRequest.setAttribute("trangthai", trangthai);
		actionRequest.setAttribute("time", time);
		actionRequest.setAttribute("year", year);
		actionRequest.setAttribute("id_donvi", id_donvi);
		actionRequest.setAttribute("tinhtrang", tinh_trang);
		actionRequest.setAttribute("loaidangky", loaidangky);
		actionRequest.setAttribute("CoquanId", CoquanId);
		actionResponse.setRenderParameter("viewPage", viewPage);
		actionResponse.setRenderParameter("idBaoCao", idBaoCao);
		List<Baocaochitiet> result = new ArrayList<Baocaochitiet>();
		if (loaihoso != null && display_result.equals("1")) {

			result = BaocaochitietLocalServiceUtil.hienthiDanhsachBaocao(
					loaihoso, ngaynhan_tungay, ngaynhan_denngay, trangthai,
					tinh_trang, loaidangky, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			actionResponse.setRenderParameter("viewPage", viewPage);
			actionResponse.setRenderParameter("idBaoCao", idBaoCao);

			actionRequest.setAttribute("listBaocao", result);
			SessionMessages.add(actionRequest, "");
		}

	}

	/**
	 * This is function serveResource
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 * @throws PortletException
	 * @throws IOException
	 */
	public void serveResource(ResourceRequest req, ResourceResponse res)
			throws PortletException, IOException {
		String report_type = ParamUtil.getString(req, "report_type");
		if (report_type != "" && report_type.equals("lephichitiet")) {
			ActionUtil.excelLephichitiet(req, res);
		} else if (report_type != "" && report_type.equals("lephilinhvuc")) {
			ActionUtil.excelLephilinhvuc(req, res);
		} else if (report_type != "" && report_type.equals("lephitonghop")) {
			ActionUtil.excelLephitonghop(req, res);
		}else if(report_type != "" && report_type.equals("thongke")) {
			ActionUtil.excelThongke(req, res);
		}else if(report_type != "" && report_type.equals("tonghoptongquat")) {
			ActionUtil.excelTonghopTongquat(req, res);
		}else if(report_type != "" && report_type.equals("tonghopchitiet")) {
			ActionUtil.excelTongHopChiTiet(req, res);
		}else if(report_type != "" && report_type.equals("tonghopnam")) {
			ActionUtil.excelTongHopNam(req, res);
		}else if(report_type != "" && report_type.equals("chitiet")) {
			ActionUtil.excelbaocaochitiet(req, res);
		}else if(report_type != "" && report_type.equals("chungthuc")) {
			ActionUtil.excelBaocaochungthuc(req, res);
		}
	}
}
