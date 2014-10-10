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

package org.oep.cmon.portlet.document.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness;
import org.oep.cmon.portlet.document.util.DocumentConstants;
import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.portlet.document.util.ListUtil;
import org.oep.cmon.util.Helpers;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc;
import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTucClp;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.DanhMucUngDungClp;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinhClp;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLyClp;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDungClp;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayToClp;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhClp;
import org.oep.cmon.dao.dvc.model.VanBanHuongDan;

import org.oep.cmon.dao.dvc.service.CauHinhPortlet2ThuTucLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class ThuTucHanhChinhPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ThuTucHanhChinhPortlet extends MVCPortlet {
 
	private static Log _log = LogFactoryUtil
			.getLog(ThuTucHanhChinhPortlet.class);
	
	/**
	 * This is function save CauHinhLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws IOException
	 */
	public void luuCauHinhLienThong(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long thuTucId = ParamUtil.getLong(request, "thuTucId");
		long thuTucLienThongId = ParamUtil.getLong(request, "thuTucLienThongId");
		ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucId);
		thuTuc.setThuTucLienThongId( (thuTucLienThongId == 0L) ? null : thuTucLienThongId );
		ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(thuTuc);
		SessionMessages.add(request, "luuCauHinhLienThongThanhCong");
		response.sendRedirect(ParamUtil.getString(request, "redirectURl"));
	}
	
	/**
	 * This is function serverResource
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
	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException, PortletException {
		// Get resource id
		String resourceId = resourceRequest.getResourceID();
		
		// Process Jason feed
		JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
		if ( "fetchNhomTTHC".equals(resourceId) ) {		
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			// Create Jason array o bject
			JSONArray nhomTTHCArray = JSONFactoryUtil.getJSONFactory().createJSONArray();	
			
			// Query all sub don vi hanh chinh using parent id
			List<NhomThuTucHanhChinh> nhomTTHCList = null;

		    try {
		    	nhomTTHCList = this.findByUngDungId(parentId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			

			// Store all data to jSon object
			for (NhomThuTucHanhChinh nhomTTHC : nhomTTHCList) {
				nhomTTHCArray.put( nhomTTHC.getId() + ":"  + nhomTTHC.getTen());
			}
		
			jsonFeed.put("nhomTTHCArray", nhomTTHCArray );	
		}
		
		if ("fetchDonViHanhChinh".equals(resourceId)) {
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			long tthcId = ParamUtil.getInteger(resourceRequest, "tthcId");
			
			int type = ParamUtil.getInteger(resourceRequest, "type");

			// Create Jason array o bject
			JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory()
					.createJSONArray();
			// Create Jason array o bject
			JSONArray cqQuanLyArray = JSONFactoryUtil.getJSONFactory()
								.createJSONArray();


			// Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = null;
			List<CoQuanQuanLy> coquanQuanLyList = null;
			List<TTHC2CoQuanQuanLy> docList = null;

			try {
				donviHanhChinhList = DonViHanhChinhLocalServiceUtil.findByChaId(parentId, DocumentConstants.ACTIVE);
				coquanQuanLyList= CoQuanQuanLyLocalServiceUtil.findByAllDonViHanhChinhId(parentId, type, DocumentConstants.ACTIVE);
				docList =  TTHC2CoQuanQuanLyLocalServiceUtil.getDSTTHC2CoQuanQuanLy(tthcId, DocumentConstants.ACTIVE);
						//.findByChaId(parentId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Store all data to jSon object
			for (DonViHanhChinh donViHanhChinh : donviHanhChinhList) {
				donViHanhChinhArray.put(donViHanhChinh.getId() + ":"
						+ donViHanhChinh.getTen());
			}
			// Store all data to jSon object
			for (CoQuanQuanLy cqql : coquanQuanLyList) {
				 if(!ListUtil.isTT2CQQLOrTTHCExist(docList, cqql.getId(), tthcId)){
				cqQuanLyArray.put(cqql.getId() + ":"
						+ cqql.getTen());
				 }
			}


			jsonFeed.put("donViHanhChinhArray", donViHanhChinhArray);
			jsonFeed.put("coquanQuanLyArray", cqQuanLyArray);
			
		}
		
		if ("fetchQuocGia".equals(resourceId)) {
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			long tthcId = ParamUtil.getInteger(resourceRequest, "tthcId");
			
			int type = ParamUtil.getInteger(resourceRequest, "type");

			// Create Jason array o bject
			JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory()
					.createJSONArray();
			
			// Create Jason array o bject
			//JSONArray cqQuanLyArray = JSONFactoryUtil.getJSONFactory().createJSONArray();

			// Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = new ArrayList<DonViHanhChinh>();
			//List<CoQuanQuanLy> coquanQuanLyList = null;
			//List<TTHC2CoQuanQuanLy> docList = null;

			
			
			try {
				Long tp_tw=CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(FormatUtil.convertToLong(DocumentConstants.MA_CAPDVHC.TP_TW)).getId();
				Long tinh=CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(FormatUtil.convertToLong(DocumentConstants.MA_CAPDVHC.CAP_TINH)).getId();
								
				List<DonViHanhChinh> list_tinh_4  = DonViHanhChinhLocalServiceUtil.findByQuocGiaId(parentId, tp_tw, DocumentConstants.ACTIVE);
				List<DonViHanhChinh> list_tinh_1 = DonViHanhChinhLocalServiceUtil.findByQuocGiaId(parentId, tinh, DocumentConstants.ACTIVE);
				donviHanhChinhList.addAll(list_tinh_4);
				donviHanhChinhList.addAll(list_tinh_1);
				
				//coquanQuanLyList= CoQuanQuanLyLocalServiceUtil.findByAllDonViHanhChinhId(parentId, type, DocumentConstants.ACTIVE);
				//docList =  TTHC2CoQuanQuanLyLocalServiceUtil.getDSTTHC2CoQuanQuanLy(tthcId);
						//.findByChaId(parentId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Store all data to jSon object
			for (DonViHanhChinh donViHanhChinh : donviHanhChinhList) {
				donViHanhChinhArray.put(donViHanhChinh.getId() + ":"
						+ donViHanhChinh.getTen());
			}
			/*
			for (CoQuanQuanLy cqql : coquanQuanLyList) {
				 if(!ListUtil.isTT2CQQLOrTTHCExist(docList, cqql.getId(), tthcId)){
				cqQuanLyArray.put(cqql.getId() + ":"
						+ cqql.getTen());
				 }
			}
			*/

			jsonFeed.put("quocgiaArray", donViHanhChinhArray);
			//jsonFeed.put("coquanQuanLyArray", cqQuanLyArray);
		}

		// added by phucnv 2014-03-31
		if ("getTTHC2CoQuanQuanLyUsingAjax".equals(resourceId)) {
			try {
				getTTHC2CoQuanQuanLyUsingAjax(resourceRequest, resourceResponse);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
			return;
		}
		// end adding by phucnv 2014-03-31
		
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
	}

	
	/**
	 * This is function updatePortlet2TTHC
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
	public void updatePortlet2TTHC(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String portletName = ParamUtil.getString(actionRequest, "portletName");
		String tthcId = ParamUtil.getString(actionRequest, "tthcId");
		
			CauHinhPortlet2ThuTuc	cauHinhPortlet2ThuTuc = CauHinhPortlet2ThuTucLocalServiceUtil.fetchCauHinhPortlet2ThuTuc(ConvertUtil.convertToLong(tthcId));
			//CauHinhPortlet2ThuTuc	cauHinhPortlet2ThuTuc = CauHinhPortlet2ThuTucLocalServiceUtil.getCauHinhPortlet2ThuTuc(ConvertUtil.convertToLong(tthcId));
			if (cauHinhPortlet2ThuTuc!=null){
				cauHinhPortlet2ThuTuc.setPortletName(portletName);
				CauHinhPortlet2ThuTucLocalServiceUtil.updateCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);	
			} else {
				cauHinhPortlet2ThuTuc = new CauHinhPortlet2ThuTucClp();
				cauHinhPortlet2ThuTuc.setThuTucHanhChinhId(ConvertUtil.convertToLong(tthcId));
				cauHinhPortlet2ThuTuc.setPortletName(portletName);
				CauHinhPortlet2ThuTucLocalServiceUtil.addCauHinhPortlet2ThuTuc(cauHinhPortlet2ThuTuc);	
			}
			
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
		actionResponse.setRenderParameter("CompletedUpdatePortlet2TTHC", "CompletedUpdatePortlet2TTHC");
		actionRequest.setAttribute("CompletedUpdatePortlet2TTHC", "CompletedUpdatePortlet2TTHC");
		SessionMessages.add(actionRequest, "CompletedUpdatePortlet2TTHC");
	}
	
	/**
	 * This is function searchCHDMGT
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
	public void searchCHDMGT(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long tthcId = ParamUtil.getLong(actionRequest, "tthcID", 0L);
		Integer giaiDoanId = ParamUtil.getInteger(actionRequest, "giaiDoanId",0);		
		String ghilai = ParamUtil.getString(actionRequest, "ghilai");
		String ungDung = ParamUtil.getString(actionRequest,"ungDung", "0");
		String nhomTTHC= ParamUtil.getString(actionRequest,"nhomTTHC", "0");
		
		//Update
		if (ghilai != null && ghilai.length() > 0) {
			//Update Bat Buoc
			
			List<ThuTuc2GiayTo> tt2GTList = ThuTuc2GiayToLocalServiceUtil
					.getDSGiayToTheoThuTuc(tthcId,DocumentConstants.ACTIVE , giaiDoanId);
			
			if(tt2GTList != null){
				for (ThuTuc2GiayTo tt2gt : tt2GTList) {
					try
					{
						int yeucau = ParamUtil.getInteger(actionRequest, tt2gt.getId()+"_batbuoc",0);
						long thutu= ParamUtil.getLong(actionRequest
												, tt2gt.getId()+"_thutu",tt2gt.getThuTuHienThi());
						tt2gt.setBatBuoc(yeucau);
						
						tt2gt.setNgaySua(new Date());
						tt2gt.setNguoiSua(themeDisplay.getUser().getEmailAddress());
						tt2gt.setNgayTao(new Date());
						tt2gt.setNguoiTao(themeDisplay.getUser().getEmailAddress());
						tt2gt.setThuTuHienThi(thutu);
						ThuTuc2GiayToLocalServiceUtil.updateThuTuc2GiayTo(tt2gt);
						actionRequest.setAttribute("update_success", "update_success");						
						SessionMessages.add(actionRequest, "successUpdateTT2GT"); 
					
					} catch (Exception es) {
						FormatUtil.printException(es);
						FormatUtil.printError(tt2gt.toString());
						SessionErrors.add(actionRequest, "errorUpdateTT2GT");
					}
					
					
				}
			}
			
		}
		
		actionResponse.setRenderParameter("tthcID", tthcId.toString());
		actionRequest.getPortletSession().setAttribute("tthcID", tthcId.toString());
		
		actionResponse.setRenderParameter("giaiDoanId", giaiDoanId.toString());
		actionRequest.getPortletSession().setAttribute("giaiDoanId", giaiDoanId);

		actionResponse.setRenderParameter("ungDung", ungDung);
		actionResponse.setRenderParameter("nhomTTHC", nhomTTHC);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		int cur = ParamUtil.getInteger(actionRequest, "curGT", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaGT", 10);
		prefs.setValue("curGT", String.valueOf(cur));
		prefs.setValue("deltaGT", String.valueOf(delta));
		prefs.store();
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");
	}
	
	/**
	 * This is function searchPopupDocument
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
	public void searchPopupDocument(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		
		String group = ParamUtil.getString(actionRequest, "selectedGT");
		
		String[] selectedGroup = actionRequest.getParameterValues("selectedGT");
		long gtID=0;
		
		// Get document group
		String doituongGroup = ParamUtil.getString(actionRequest,
				"doituongSuDung");		
		Long tthcId = ParamUtil.getLong(actionRequest, "tthcId");
		Integer giaiDoanId = ParamUtil.getInteger(actionRequest, "giaiDoanId");
		String selectButton=ParamUtil.getString(actionRequest,
				"selectButton", null);
		if(selectedGroup!=null)
		{
			actionRequest.setAttribute("action", "save");
		}
		else
		{
			actionRequest.setAttribute("action", null);
		}
		
		//if (selectButton != null && selectButton.length() > 0) {
			if(selectedGroup!=null)
			{
				//Insert into Thutuc2GT
				ThuTuc2GiayTo tt2gt=null;
				for (int tl = 0; tl < selectedGroup.length; tl++) {
					gtID=Long.parseLong(selectedGroup[tl]);
					
					try {
						tt2gt = new ThuTuc2GiayToClp();
						long tt2gtID=CounterLocalServiceUtil.increment(ThuTuc2GiayTo.class.getName());
						tt2gt.setId(tt2gtID);
						tt2gt.setDaXoa(DocumentConstants.TTHC2DT.DaXoa);					
						tt2gt.setTrangThai(DocumentConstants.TTHC2DT.TrangThai);
						tt2gt.setGiaidoan(giaiDoanId);
						tt2gt.setNgaySua(new Date());
						tt2gt.setNguoiSua(themeDisplay.getUser().getEmailAddress());
						tt2gt.setNgayTao(new Date());
						tt2gt.setNguoiTao(themeDisplay.getUser().getEmailAddress());
						tt2gt.setThuTucHanhChinhId(tthcId);
						tt2gt.setDanhMucGiayToId(gtID);
						tt2gt.setBatBuoc(DocumentConstants.TTHC2DT.Default_BatBuoc);
						//tt2gt.setThuTuHienThi(gtID);//mac dinh lay id
						long ttHienThi=this.getMaxTTHT(tthcId, giaiDoanId)+tl+1;
						tt2gt.setThuTuHienThi(ttHienThi);
						ThuTuc2GiayToLocalServiceUtil.addThuTuc2GiayTo(tt2gt);
						actionRequest.setAttribute("update_success", "update_success");						
						//actionResponse.setRenderParameter("update_success", "update_success");
						SessionMessages.add(actionRequest, "successUpdateTT2GT"); 
						
					} catch (Exception es) {
						FormatUtil.printException(es);
						FormatUtil.printError(tt2gt.toString());
						SessionErrors.add(actionRequest, "errorUpdateTT2GT");
					}
					
				}
				
			}
		
		//}// end if neu nhan nut them moi thi tao chung chi giay phep
		// Set the result back to session
		actionResponse.setRenderParameter("doituongSuDung", doituongGroup);
		actionResponse.setRenderParameter("tthcId", String.valueOf(tthcId));
		actionResponse.setRenderParameter("giaiDoanId", String.valueOf(giaiDoanId));
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		
		PortletPreferences prefs = actionRequest.getPreferences();	
		
		int cur = ParamUtil.getInteger(actionRequest, "cur2pop", 1);
		int delta = ParamUtil.getInteger(actionRequest, "delta2pop", 10);
		prefs.setValue("cur2pop", String.valueOf(cur));
		prefs.setValue("delta2pop", String.valueOf(delta));
		prefs.store();
		actionResponse.setWindowState(LiferayWindowState.NORMAL);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");
	}
	
	
	/**
	 * This is function searchCHVBBM
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
	public void searchCHVBBM(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
	{
		
		//Long tthcId = ParamUtil.getLong(actionRequest, "tthcID", 0L);
		//Integer loaiTaiLieuId = ParamUtil.getInteger(actionRequest, "loaiTaiLieuId",0);
		
		String tthcId = ParamUtil
				.getString(actionRequest, "tthcID", "");
		String loaiTaiLieuId = ParamUtil.getString(actionRequest, "loaiTaiLieuId","");
		
		String ungDung = ParamUtil.getString(actionRequest,"ungDung", "0");
		String nhomTTHC= ParamUtil.getString(actionRequest,"nhomTTHC", "0");
		
		actionResponse.setRenderParameter("tthcID", tthcId);
		actionRequest.getPortletSession().setAttribute("tthcID", tthcId);
		
		actionResponse.setRenderParameter("loaiTaiLieuId", loaiTaiLieuId);
		actionRequest.getPortletSession().setAttribute("loaiTaiLieuId", loaiTaiLieuId);
		
		actionResponse.setRenderParameter("ungDung", ungDung);
		actionResponse.setRenderParameter("nhomTTHC", nhomTTHC);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		int cur = ParamUtil.getInteger(actionRequest, "curBM", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaBM", 10);
		prefs.setValue("curBM", String.valueOf(cur));
		prefs.setValue("deltaBM", String.valueOf(delta));
		prefs.store();
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
	}
	
	
	/**
	 * This is function searchTTHC
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
	public void searchTTHC(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
	{
		String ungDung = ParamUtil
				.getString(actionRequest, "ungDung", "");
		String nhomTTHC = ParamUtil.getString(actionRequest, "nhomTTHC","");
		
		actionResponse.setRenderParameter("ungDung", ungDung);
		actionRequest.getPortletSession().setAttribute("ungDung", ungDung);
		
		actionResponse.setRenderParameter("nhomTTHC", nhomTTHC);
		actionRequest.getPortletSession().setAttribute("nhomTTHC", nhomTTHC);
		
		PortletPreferences prefs = actionRequest.getPreferences();
	
		int cur = ParamUtil.getInteger(actionRequest, "curTTHC", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaTTHC", 10);
		prefs.setValue("curTTHC", String.valueOf(cur));
		prefs.setValue("deltaTTHC", String.valueOf(delta));
		prefs.store();
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
		
	}

	/**
	 * This is function searchUngDungRequest
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
	public void searchUngDungRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		setSearchParameter(actionRequest, actionResponse);
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
					
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/ung_dung_list.jsp");
	}

	/**
	 * This is function searchNhomTTHCRequest
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
	public void searchNhomTTHCRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String formGroup = ParamUtil.getString(actionRequest, "formGroup", "");

		// Set the result back to session
		actionResponse.setRenderParameter("formGroup", formGroup);
		actionRequest.getPortletSession().setAttribute("formGroup", formGroup);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_list.jsp");
	}
	/**
	 * This is function findByTenUngDung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<DanhMucUngDung>
	 */
	@SuppressWarnings("unchecked")
	public List<DanhMucUngDung> findByTenUngDung(String keyWord) {
		List<DanhMucUngDung> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DanhMucUngDung.class);		
			query.addOrder(OrderFactoryUtil.asc("ten"));		
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			//Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			//query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
			query = query.add(criteria);
					
			try {
				results = DanhMucUngDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(DanhMucUngDung.class);		
				
				// This is a test line for display all request if there's no search criteria
				//Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				//query = query.add(criteriaTrangThai);
						
				results = DanhMucUngDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<DanhMucUngDung>();
		}
		return results;
	}
	
	/**
	 * This is function findByUngDungId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param groupId
	 * @return List<NhomThuTucHanhChinh>
	 */
	@SuppressWarnings("unchecked")
	public List<NhomThuTucHanhChinh> findByUngDungId(long groupId) {
		List<NhomThuTucHanhChinh> results = null;

		if (groupId > 0) {
			// Query code request using keyword			
			
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(NhomThuTucHanhChinh.class);		
			query.addOrder(OrderFactoryUtil.asc("ten"));	
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaDMUDId= RestrictionsFactoryUtil.eq("danhMucUngDungId", groupId );	
			//Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			//Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			//Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			//query = query.add(RestrictionsFactoryUtil.and(criteriaDMUDId, criteriaTrangThai));
			query = query.add(criteriaDMUDId);
					
			try {
				results = NhomThuTucHanhChinhLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(NhomThuTucHanhChinh.class);		
				
				// This is a test line for display all request if there's no search criteria
				//Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				//query = query.add(criteriaTrangThai);
						
				results = NhomThuTucHanhChinhLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<NhomThuTucHanhChinh>();
		}
		return results;
	}
	
	/**
	 * This is function getMaxTTHT
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tthcId
	 * @param giaidoanId
	 * @return long
	 */
	@SuppressWarnings("unchecked")
	public long getMaxTTHT(long tthcId, int giaidoanId) {
	      
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ThuTuc2GiayTo.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteriaTTHCId= RestrictionsFactoryUtil.eq("thuTucHanhChinhId", tthcId );
		Criterion criteriaGiaiDoanId= RestrictionsFactoryUtil.eq("giaidoan", giaidoanId );	
	
		query = query.add(RestrictionsFactoryUtil.and(criteriaTTHCId, criteriaGiaiDoanId));
		
		query.setProjection(ProjectionFactoryUtil.max("thuTuHienThi"));
		//query.setProjection(ProjectionFactoryUtil.rowCount())
		//query.setProjection(ProjectionFactoryUtil.sum("counter"));
	     //DynamicQueryInitializ dqi = new DynamicQueryInitializerImpl(query);
	      
	      long count = 0;
	      
	      try {
	        Iterator<Long>  resultsItr = 
	        		ThuTuc2GiayToLocalServiceUtil.dynamicQuery(query).iterator();
	        
	        if (resultsItr.hasNext()) {
	          count = ((Long)resultsItr.next()).longValue();
	        }
	      }
	      catch (SystemException se) {
	       // _log.error(se.getMessage(), se);
	      }
	      
	      return count;
	    }

	/**
	 * This is function deleteUngDungRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tthcId
	 * @param giaidoanId
	 * @return long
	 */
	public void deleteUngDungRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String ungDungId = ParamUtil.getString(actionRequest, "ungDungId");
		
		// Process Jason feed
		try {
			//Change status
			//DanhMucUngDung ungDung = DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(FormatUtil.convertToLong(ungDungId));
			//ungDung.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			//DanhMucUngDungLocalServiceUtil.updateDanhMucUngDung(ungDung);
			//Remove
			DanhMucUngDungLocalServiceUtil.deleteDanhMucUngDung(FormatUtil.convertToLong(ungDungId));
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteUngDung");
		} catch (Exception es) {
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteUngDung");
		}

		// Hidden default error message
		setSearchParameter(actionRequest, actionResponse);
		FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/ung_dung_list.jsp");
	}
	
	/**
	 * This is function AddUngDungRequest
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
	public void AddUngDungRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		setSearchParameter(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/ung_dung_add.jsp");
	}

	/**
	 * This is function editOrAddUngDungRequest
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
	public void editOrAddUngDungRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String ungDungId = ParamUtil.getString(actionRequest, "ungDungId");
		String tenUngDung = ParamUtil.getString(actionRequest, "tenUngDung").trim();
		String maUngDung = ParamUtil.getString(actionRequest, "maUngDung").trim();
		String trangThaiUngDung= ParamUtil.getString(actionRequest, "trangThaiUngDung").trim();
		
		if (validationUDInput(tenUngDung, ungDungId, maUngDung, actionRequest)) {
			DanhMucUngDung danhMucUngDung = null;
			if (ungDungId.trim().length() > 0) {
				try {
					danhMucUngDung = DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(FormatUtil.convertToLong(ungDungId));
					danhMucUngDung.setTen(tenUngDung);
					danhMucUngDung.setMa(maUngDung);
					danhMucUngDung.setNgaySua(new Date());
					danhMucUngDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					danhMucUngDung.setDaXoa(FormatUtil.convertToInt(trangThaiUngDung));
					DanhMucUngDungLocalServiceUtil.updateDanhMucUngDung(danhMucUngDung);
					actionResponse.setRenderParameter("CompletedUpdateUngDung", "CompletedUpdateUngDung");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successUpdateUngDung");
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(danhMucUngDung.toString());
					SessionErrors.add(actionRequest, "errorUpdateUngDung");
				}
			} else {
				try {
					danhMucUngDung = new DanhMucUngDungClp();
					danhMucUngDung.setId(CounterLocalServiceUtil.increment(DanhMucUngDung.class.getName()));
					danhMucUngDung.setTen(tenUngDung);
					danhMucUngDung.setMa(maUngDung);
					danhMucUngDung.setNgaySua(new Date());
					danhMucUngDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					danhMucUngDung.setNgayTao(new Date());
					danhMucUngDung.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					danhMucUngDung.setDaXoa(FormatUtil.convertToInt(trangThaiUngDung));
					DanhMucUngDungLocalServiceUtil.addDanhMucUngDung(danhMucUngDung);
					actionResponse.setRenderParameter("CompletedAddUngDung", "CompletedAddUngDung");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successAddUngDung");
					tenUngDung = "";
					maUngDung = "";
					trangThaiUngDung="0";
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(danhMucUngDung.toString());
					SessionErrors.add(actionRequest, "errorAddUngDung");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("ungDungId", ungDungId);
		actionResponse.setRenderParameter("maUngDung", maUngDung);
		actionResponse.setRenderParameter("tenUngDung", tenUngDung);
		actionResponse.setRenderParameter("trangThaiUngDung", trangThaiUngDung);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/ung_dung_add.jsp");
		setSearchParameter(actionRequest, actionResponse);
		FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
	}

	/**
	 * This is function validationUDInput
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenUngDung
	 * @param ungDungId
	 * @param maUngDung
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationUDInput(String tenUngDung, String ungDungId, String maUngDung, ActionRequest actionRequest) {
		if (maUngDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaUngDung");
		}
		if (tenUngDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenUngDung");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			DanhMucUngDung ungDung = null;
			try {

				// Kiem tra theo Ma
				try {
					ungDung = null;					
					ungDung = DanhMucUngDungLocalServiceUtil.getUngDungTheoMa(maUngDung);
				} catch (Exception es) {
				}
				if (ungDung != null) {
					if (ungDung.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (ungDungId.trim().length() > 0) {
						if (FormatUtil.convertToLong(ungDungId) != ungDung.getId()) {
							SessionErrors.add(actionRequest, "existMaUngDung");
						}
					} else {
						SessionErrors.add(actionRequest, "existMaUngDung");
					}
				}


			} catch (Exception es) {
			}
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	

	/**
	 * This is function deleteNTTHCRequest
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
	public void deleteNTTHCRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String formGroup = ParamUtil.getString(actionRequest, "formGroup", "");

		// Get search keyword, the keyword is code
		String nTTHCId = ParamUtil.getString(actionRequest, "nTTHCId");
		
		// Process Jason feed
		try {

			NhomThuTucHanhChinhLocalServiceUtil.deleteNhomThuTucHanhChinh(FormatUtil.convertToLong(nTTHCId));
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteNTTHC");
		} catch (Exception es) {
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteNTTHC");
		}

		// Hidden default error message
		//FormatUtil.setParameter(actionRequest, actionResponse, formGroup);
		actionResponse.setRenderParameter("formGroup", formGroup);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_list.jsp");
	}

	/**
	 * This is function editOrAddNhomTTHCRequest
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
	public void editOrAddNhomTTHCRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String formGroup = ParamUtil.getString(actionRequest, "formGroup", "");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String nTTHCId = ParamUtil.getString(actionRequest, "nTTHCId");
		String tenNTTHC= ParamUtil.getString(actionRequest, "tenNTTHC").trim();
		String maNTTHC = ParamUtil.getString(actionRequest, "maNTTHC").trim();
		String trangThaiNTTHC= ParamUtil.getString(actionRequest, "trangThaiNTTHC").trim();
		String dmUDId = ParamUtil.getString(actionRequest, "DanhMucUDId");

		if (validationNTTHCInput(tenNTTHC, nTTHCId, maNTTHC, actionRequest)) {
			NhomThuTucHanhChinh nTTHC = null;
			if (nTTHCId.trim().length() > 0) {
				try {
					nTTHC = NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(FormatUtil.convertToLong(nTTHCId));
					nTTHC.setTen(tenNTTHC);
					nTTHC.setMa(maNTTHC);
					nTTHC.setNgaySua(new Date());					
					nTTHC.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					nTTHC.setDanhMucUngDungId(FormatUtil.convertToLong(dmUDId));
					nTTHC.setDaXoa(FormatUtil.convertToInt(trangThaiNTTHC));
					NhomThuTucHanhChinhLocalServiceUtil.updateNhomThuTucHanhChinh(nTTHC);
					actionResponse.setRenderParameter("CompletedUpdateNTTHC", "CompletedUpdateNTTHC");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successUpdateNTTHC");
			
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(nTTHC.toString());
					SessionErrors.add(actionRequest, "errorUpdateNTTHC");
				}
			} else {
				try {
					nTTHC = new NhomThuTucHanhChinhClp();
					nTTHC.setId(CounterLocalServiceUtil.increment(NhomThuTucHanhChinh.class.getName()));
					nTTHC.setTen(tenNTTHC);				
					nTTHC.setMa(maNTTHC);
					nTTHC.setDanhMucUngDungId(FormatUtil.convertToLong(dmUDId));
					nTTHC.setDaXoa(FormatUtil.convertToInt(trangThaiNTTHC));
					nTTHC.setNgaySua(new Date());
					nTTHC.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					nTTHC.setNgayTao(new Date());
					nTTHC.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					NhomThuTucHanhChinhLocalServiceUtil.addNhomThuTucHanhChinh(nTTHC);
					actionResponse.setRenderParameter("CompletedAddNTTHC", "CompletedAddNTTHC");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successAddNTTHC");
					
					tenNTTHC = "";					
					maNTTHC = "";
					trangThaiNTTHC = "";
					dmUDId = "";
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(nTTHC.toString());
					SessionErrors.add(actionRequest, "errorAddNTTHC");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("nTTHCId", nTTHCId);
		actionResponse.setRenderParameter("maNTTHC", maNTTHC);		
		actionResponse.setRenderParameter("tenNTTHC", tenNTTHC);
		actionResponse.setRenderParameter("trangThaiNTTHC", trangThaiNTTHC);
		actionResponse.setRenderParameter("DanhMucUDId", dmUDId);
		
		actionResponse.setRenderParameter("formGroup", formGroup);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_add.jsp");

		FormatUtil.setParameter(actionRequest, actionResponse, formGroup);
	}

	/**
	 * This is function validationNTTHCInput
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenNTTHC
	 * @param nTTHCId
	 * @param maNTTHC
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationNTTHCInput(String tenNTTHC, String nTTHCId, String maNTTHC, ActionRequest actionRequest) {
		if (maNTTHC.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaNTTHC");
		}
		if (tenNTTHC.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenNTTHC");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			NhomThuTucHanhChinh nNTTHC = null;
			try {

				// Kiem tra theo Ma
				try {
					nNTTHC = null;
					nNTTHC = NhomThuTucHanhChinhLocalServiceUtil.findTheoMa(maNTTHC);
				} catch (Exception es) {
				}
				if (nNTTHC != null) {
					if (nNTTHC.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (nTTHCId.trim().length() > 0) {
						if (FormatUtil.convertToLong(nTTHCId) != nNTTHC.getId()) {
							SessionErrors.add(actionRequest, "existMaNTTHC");
						}
					} else {
						SessionErrors.add(actionRequest, "existMaNTTHC");
					}
				}


			} catch (Exception es) {
			}
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	

	/**
	 * This is function deleteTTHCRequest
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
	public void deleteTTHCRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String formGroup = actionRequest.getParameter("formGroup");

		// Get search keyword, the keyword is code
		long tthcdId = ParamUtil.getLong(actionRequest, "tthcId");
		
		// Process Jason feed
		try {
			//Change status
			ThuTucHanhChinh tthc= ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(tthcdId);
			tthc.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(tthc);
			//Remove	
			//ThuTucHanhChinhLocalServiceUtil.deleteThuTucHanhChinh(tthcdId);
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteTTHC");
			
		} catch (Exception es) {
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteTTHC");
		}

		// Hidden default error message
		FormatUtil.setParameter(actionRequest, actionResponse, formGroup);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
	}

	/**
	 * This is function editOrAddTTHCRequest
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
	public void editOrAddTTHCRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String formGroup = actionRequest.getParameter("formGroup");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String tthcId = ParamUtil.getString(actionRequest, "tthcId");
		String tenTTHC= ParamUtil.getString(actionRequest, "tenTTHC").trim();
		String maTTHC = ParamUtil.getString(actionRequest, "maTTHC").trim();
		String soNgayXL = ParamUtil.getString(actionRequest, "soNgayXL");
		System.err.println("soNgayXL:"+soNgayXL);
		int trangThaiTTHC= ParamUtil.getInteger(actionRequest, "trangThaiTTHC");
		int tichHop = ParamUtil.getInteger(actionRequest, "tichHop");
		long ungDungId = ParamUtil.getLong(actionRequest, "ungDungId");
		long nhomTTHCId = ParamUtil.getLong(actionRequest, "nhomTTHCId");
		String trinhTuThucHien = ParamUtil.getString(actionRequest, "trinhTuThucHien").trim();
		String cachThucHien = ParamUtil.getString(actionRequest, "cachThucHien").trim();
		String thanhPhanHoSo = ParamUtil.getString(actionRequest, "thanhPhanHoSo").trim();
		
		String linhVucThucHien = ParamUtil.getString(actionRequest, "linhVucThucHien").trim();
		String lePhi = ParamUtil.getString(actionRequest, "lePhi");
		String donViLePhi = ParamUtil.getString(actionRequest, "donViLePhi").trim();
		String phi = ParamUtil.getString(actionRequest, "phi");
		String donViPhi = ParamUtil.getString(actionRequest, "donViPhi").trim();
		String tenMauDonToKhai = ParamUtil.getString(actionRequest, "tenMauDonToKhai").trim();
		String yeuCauDieuKienThucHien = ParamUtil.getString(actionRequest, "yeuCauDieuKienThucHien").trim();
		String canCuPhapLy = ParamUtil.getString(actionRequest, "canCuPhapLy").trim();
		long  capCQQLId = ParamUtil.getLong(actionRequest, "capCoQuanQuanLyId");
		System.err.println("capCQQLId:"+capCQQLId);
		//String doiTuongSDId = ParamUtil.getString(actionRequest, "doiTuongId");
		
		String[] doiTuongDest = ParamUtil.getParameterValues(actionRequest, "doiTuongId");
		List<List<DoiTuongSuDung>> configList = ThuTucHanhChinhBusiness.findAllDoiTuongByTTHC(doiTuongDest);
		if (configList != null && configList.size() > 1) {
			actionRequest.setAttribute("doiTuongList", configList.get(0));
			actionRequest.setAttribute("doiTuongConfigList", configList.get(1));
		}
		
		if (validationTTHCInput(tenTTHC, ungDungId, nhomTTHCId, tthcId, maTTHC, FormatUtil.convertToLong( soNgayXL), capCQQLId, doiTuongDest, actionRequest)) {
			ThuTucHanhChinh tthc = null;
			if (tthcId.trim().length() > 0) {
				try {
					tthc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(FormatUtil.convertToLong(tthcId));
					tthc.setTen(tenTTHC);
					tthc.setMa(maTTHC);
					tthc.setNgaySua(new Date());					
					tthc.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					tthc.setNhomThuTucHanhChinhId(nhomTTHCId);
					tthc.setSoNgayXuLy(FormatUtil.convertToLong(soNgayXL));
					tthc.setTrangThai(trangThaiTTHC);
					tthc.setCanTichHop(tichHop);
					
					tthc.setTrinhTuThucHien(trinhTuThucHien + "<br>");
					tthc.setCachThucHien(cachThucHien);
					tthc.setThanhPhanHoSo(thanhPhanHoSo+ "<br>");
					tthc.setLinhVucThucHien(linhVucThucHien);
					tthc.setLePhi(FormatUtil.convertToLong(lePhi));
					tthc.setDonViLePhi(donViLePhi);
					tthc.setPhi(FormatUtil.convertToLong(phi));
					tthc.setDonViPhi(donViPhi);
					tthc.setTenMauDonToKhai(tenMauDonToKhai);
					tthc.setYeuCauDieuKienThucHien(yeuCauDieuKienThucHien+ "<br>");
					tthc.setCanCuPhapLy(canCuPhapLy + "<br>");
					tthc.setCapCoQuanQuanLyId(capCQQLId);
					System.err.println("tthc:"+tthc);
					ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(tthc);
					
					//Update doi tuong
					List<TTHC2DoiTuongSuDung> tthc2dt=TTHC2DoiTuongSuDungLocalServiceUtil.getDSTTHC2DoiTuongSuDungBoiTTHC(FormatUtil.convertToLong(tthcId));
					//String[] dsDoiTuong =doiTuongSDId.split(",");
					if(tthc2dt!=null && tthc2dt.size()>0 ){
						for(TTHC2DoiTuongSuDung dtsd:tthc2dt)
						{
							dtsd.setDaXoa(DocumentConstants.INACTIVE);
							TTHC2DoiTuongSuDungLocalServiceUtil.updateTTHC2DoiTuongSuDung(dtsd);
							//TTHC2DoiTuongSuDungLocalServiceUtil.deleteTTHC2DoiTuongSuDung(dtsd);
						}
					}
					TTHC2DoiTuongSuDung dt2Base= new TTHC2DoiTuongSuDungClp();
					
					if(doiTuongDest!=null && doiTuongDest.length>0){
						 
						  for(int i=0;i<doiTuongDest.length;i++){		
							  long idtthc2DT = CounterLocalServiceUtil.increment(TTHC2DoiTuongSuDung.class.getName());
								 
							  dt2Base.setId(idtthc2DT);								 
							  dt2Base.setNgayTao(new Date());								  
							  dt2Base.setNguoiTao(themeDisplay.getUser().getEmailAddress());
								 
							  dt2Base.setDaXoa(DocumentConstants.TTHC2DT.DaXoa);		
							  dt2Base.setTrangThai(DocumentConstants.TTHC2DT.TrangThai);
							  dt2Base.setNgaySua(new Date());		
							  dt2Base.setNguoiSua(themeDisplay.getUser().getEmailAddress());							
								
							  dt2Base.setLoaiDoiTuongId(FormatUtil.convertToLong(doiTuongDest[i].toString()));
							  dt2Base.setThuTucHanhChinhId(FormatUtil.convertToLong(tthcId));
								 
								  try{									  
									   
									  TTHC2DoiTuongSuDungLocalServiceUtil.addTTHC2DoiTuongSuDung(dt2Base);
									  
									  
								  }catch (Exception es) {
									  FormatUtil.printException(es);
									  FormatUtil.printError(dt2Base.toString());
									  SessionErrors.add(actionRequest, "errorAddTTHC2DT");
								} 
							  
						  }
					}
					
					
					actionResponse.setRenderParameter("CompletedUpdateTTHC", "CompletedUpdateTTHC");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successUpdateTTHC");
			
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(tthc.toString());
					SessionErrors.add(actionRequest, "errorUpdateTTHC");
				}
			} else {
				try {
					tthc = new ThuTucHanhChinhClp();
					long tthcID=CounterLocalServiceUtil.increment(ThuTucHanhChinh.class.getName());
					tthc.setId(tthcID);
					tthc.setTen(tenTTHC);				
					tthc.setMa(maTTHC);
					tthc.setNhomThuTucHanhChinhId(nhomTTHCId);
					tthc.setTrangThai(trangThaiTTHC);
					tthc.setCanTichHop(tichHop);
					tthc.setSoNgayXuLy(FormatUtil.convertToLong(soNgayXL));
					tthc.setNgaySua(new Date());
					tthc.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					tthc.setNgayTao(new Date());
					tthc.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					
					tthc.setTrinhTuThucHien(trinhTuThucHien + "<br>");
					tthc.setCachThucHien(cachThucHien);
					tthc.setThanhPhanHoSo(thanhPhanHoSo + "<br>");
					tthc.setLinhVucThucHien(linhVucThucHien);
					tthc.setLePhi(FormatUtil.convertToLong(lePhi));
					tthc.setDonViLePhi(donViLePhi);
					tthc.setPhi(FormatUtil.convertToLong(phi));
					tthc.setDonViPhi(donViPhi);
					tthc.setTenMauDonToKhai(tenMauDonToKhai);
					tthc.setYeuCauDieuKienThucHien(yeuCauDieuKienThucHien + "<br>");
					tthc.setCanCuPhapLy(canCuPhapLy + "<br>");
					tthc.setCapCoQuanQuanLyId(capCQQLId);
					ThuTucHanhChinhLocalServiceUtil.addThuTucHanhChinh(tthc);
					
					//Them doi tuong
					TTHC2DoiTuongSuDung dt2Base= new TTHC2DoiTuongSuDungClp();
					//String[] dsDoiTuong =doiTuongSDId.split(",");
					if(doiTuongDest!=null && doiTuongDest.length>0){
						 
						  for(int i=0;i<doiTuongDest.length;i++){		
							  long idtthc2DT = CounterLocalServiceUtil.increment(TTHC2DoiTuongSuDung.class.getName());
								 
							  dt2Base.setId(idtthc2DT);								 
							  dt2Base.setNgayTao(new Date());								  
							  dt2Base.setNguoiTao(themeDisplay.getUser().getEmailAddress());
								 
							  dt2Base.setDaXoa(DocumentConstants.TTHC2DT.DaXoa);		
							  dt2Base.setTrangThai(DocumentConstants.TTHC2DT.TrangThai);
							  dt2Base.setNgaySua(new Date());		
							  dt2Base.setNguoiSua(themeDisplay.getUser().getEmailAddress());							
								
							  dt2Base.setLoaiDoiTuongId(FormatUtil.convertToLong(doiTuongDest[i].toString()));
							  dt2Base.setThuTucHanhChinhId(tthcID);
								 
								  try{									  
									   
									  TTHC2DoiTuongSuDungLocalServiceUtil.addTTHC2DoiTuongSuDung(dt2Base);
									  
									  
								  }catch (Exception es) {
									  FormatUtil.printException(es);
									  FormatUtil.printError(dt2Base.toString());
									  SessionErrors.add(actionRequest, "errorAddTTHC2DT");
								} 
							  
						  }
					}
					
					actionResponse.setRenderParameter("CompletedAddTTHC", "CompletedAddTTHC");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successAddTTHC");
					
					tenTTHC = "";					
					maTTHC = "";
					soNgayXL = "";
					trangThaiTTHC = 1;
					tichHop=0;
					ungDungId = 0;
					nhomTTHCId = 0;
					trinhTuThucHien ="";
					cachThucHien = "";
					thanhPhanHoSo = "";
					linhVucThucHien ="";
					lePhi = "";
					donViLePhi = "";
					phi = "";
					donViPhi="";
					tenMauDonToKhai = "";
					canCuPhapLy="";
					yeuCauDieuKienThucHien="";
					capCQQLId= 0;
					//doiTuongSDId = "";
					actionRequest.setAttribute("doiTuongList", null);
					actionRequest.setAttribute("doiTuongConfigList", null);
					
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(tthc.toString());
					SessionErrors.add(actionRequest, "errorAddTTHC");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("tthcId", tthcId);
		actionResponse.setRenderParameter("maTTHC", maTTHC);		
		actionResponse.setRenderParameter("tenTTHC", tenTTHC);
		actionResponse.setRenderParameter("tichHop",  String.valueOf(tichHop));
		actionResponse.setRenderParameter("trangThaiTTHC", String.valueOf(trangThaiTTHC));
		actionResponse.setRenderParameter("soNgayXL", String.valueOf(soNgayXL));
		actionResponse.setRenderParameter("ungDungId", String.valueOf(ungDungId));
		actionResponse.setRenderParameter("nhomTTHCId", String.valueOf(nhomTTHCId));
		actionResponse.setRenderParameter("trinhTuThucHien", String.valueOf(trinhTuThucHien));
		actionResponse.setRenderParameter("cachThucHien", String.valueOf(cachThucHien));
		actionResponse.setRenderParameter("thanhPhanHoSo", String.valueOf(thanhPhanHoSo));
		actionResponse.setRenderParameter("linhVucThucHien", String.valueOf(linhVucThucHien));
		actionResponse.setRenderParameter("lePhi", String.valueOf(lePhi));
		actionResponse.setRenderParameter("donViLePhi", String.valueOf(donViLePhi));
		actionResponse.setRenderParameter("phi", String.valueOf(phi));
		actionResponse.setRenderParameter("donViPhi", String.valueOf(donViPhi));
		actionResponse.setRenderParameter("tenMauDonToKhai", String.valueOf(tenMauDonToKhai));
		actionResponse.setRenderParameter("yeuCauDieuKienThucHien", String.valueOf(yeuCauDieuKienThucHien));
		actionResponse.setRenderParameter("canCuPhapLy", String.valueOf(canCuPhapLy));
		actionResponse.setRenderParameter("capCoQuanQuanLyId", String.valueOf(capCQQLId));
		
		actionResponse.setRenderParameter("doiTuongList", doiTuongDest);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_add.jsp");

		FormatUtil.setParameter(actionRequest, actionResponse, formGroup);
	}

	/**
	 * This is function validationTTHCInput
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenTTHC
	 * @param ungDungId
	 * @param nhonTTHCId
	 * @param tthcId
	 * @param maTTHC
	 * @param soNgayXL
	 * @param capCQQLId
	 * @param doiTuongDest
	 * @param actionRequest
	 */
	private boolean validationTTHCInput(String tenTTHC, long ungDungId, long nhonTTHCId, String tthcId, String maTTHC, long soNgayXL, long capCQQLId, String[] doiTuongDest, ActionRequest actionRequest) {
		if (tenTTHC.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaTTHC");
		}
		if (maTTHC.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenTTHC");
		}
		if (Validator.isNull(soNgayXL)) {
			SessionErrors.add(actionRequest, "emptySoNgayXLTTHC");
		}
		if (soNgayXL <= 0) {
			SessionErrors.add(actionRequest, "emptySoNgayXLTTHC");
		}
		if (Validator.isNull(doiTuongDest)) {
			SessionErrors.add(actionRequest, "emptyDoiTuongSuDung");
		}
		if (Validator.isNull(capCQQLId)) {
			SessionErrors.add(actionRequest, "emptyCapCQQL");
		}
		
		if (ungDungId <=0) {
			SessionErrors.add(actionRequest, "emptyUngDung");
		}
		if (nhonTTHCId <=0) {
			SessionErrors.add(actionRequest, "emptyNhomTTHC");
		}
		
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			ThuTucHanhChinh tthc = null;
			try {

				// Kiem tra theo Ma
				try {
					tthc = null;
					tthc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinhBoiMa(maTTHC);
				} catch (Exception es) {
				}
				if (tthc != null) {
					if (tthc.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (tthcId.trim().length() > 0) {
						if (FormatUtil.convertToLong(tthcId) != tthc.getId()) {
							SessionErrors.add(actionRequest, "existMaTTHC");
						}
					} else {
						SessionErrors.add(actionRequest, "existMaTTHC");
					}
				}


			} catch (Exception es) {
			}
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	
	/**
	 * This is function deleteGTRequest
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
	public void deleteGTRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
				
		String tthcId = ParamUtil
				.getString(actionRequest, "tthcID", null);
		String giaiDoanId = ParamUtil.getString(actionRequest, "giaiDoanId",
				null);
		
		// Get search keyword, the keyword is code
		long tt2gtId = ParamUtil.getLong(actionRequest, "tt2gtId");
		
		// Process Jason feed
		try {
			//Change status
			ThuTuc2GiayTo tt2gt= ThuTuc2GiayToLocalServiceUtil.fetchThuTuc2GiayTo(tt2gtId);
			tt2gt.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			ThuTuc2GiayToLocalServiceUtil.updateThuTuc2GiayTo(tt2gt);
			//Remove	
			//ThuTucHanhChinhLocalServiceUtil.deleteThuTucHanhChinh(tthcdId);
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteTT2GT"); 
		} catch (Exception es) {
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteTTHC");
		}

		// Hidden default error message
		actionResponse.setRenderParameter("tthcID", tthcId.toString());
		actionRequest.getPortletSession().setAttribute("tthcID", tthcId.toString());
		
		actionResponse.setRenderParameter("giaiDoanId", giaiDoanId.toString());
		actionRequest.getPortletSession().setAttribute("giaiDoanId", giaiDoanId);

		PortletPreferences prefs = actionRequest.getPreferences();
		
		int cur = ParamUtil.getInteger(actionRequest, "curGT", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaGT", 10);
		prefs.setValue("curGT", String.valueOf(cur));
		prefs.setValue("deltaGT", String.valueOf(delta));
		prefs.store();
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");

	}
	
	/**
	 * This is function updateCQQL
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
	public void updateCQQL(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String giatriCQQLId = ParamUtil.getString(actionRequest, "giatriCQQLId");
		long tthcId = ParamUtil.getLong(actionRequest, "tthcID");
		
		String quocgiaId = ParamUtil.getString(actionRequest, "quocgiaId");
		String tinhId = ParamUtil.getString(actionRequest, "tinhId");
		String huyenId = ParamUtil.getString(actionRequest, "huyenId");
		String xaId = ParamUtil.getString(actionRequest, "xaId");
		String ungDung = ParamUtil.getString(actionRequest,"ungDung", "0");
		String nhomTTHC= ParamUtil.getString(actionRequest,"nhomTTHC", "0");
		
		if(Validator.isNull(giatriCQQLId))
		{
			SessionErrors.add(actionRequest, "emptyCoQuanQuanLy");
		}
		
//		ThuTucHanhChinh tthc = null;
		if (tthcId > 0) {
			try {
				/*tthc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(tthcId);							
				tthc.setNgaySua(new Date());					
				tthc.setNguoiSua(themeDisplay.getUser().getEmailAddress());						
				ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(tthc);*/

				//Update tthc2Coquanquanly (delete logic)
				List<TTHC2CoQuanQuanLy> tt2CQQL=TTHC2CoQuanQuanLyLocalServiceUtil.getDSTTHC2CoQuanQuanLy(tthcId, DocumentConstants.ACTIVE);
				if(tt2CQQL!=null && tt2CQQL.size()>0 ){
					for(TTHC2CoQuanQuanLy tt2cqql:tt2CQQL)
					{
						//TTHC2CoQuanQuanLy tT2CCQL= TTHC2CoQuanQuanLyLocalServiceUtil.fetchTTHC2CoQuanQuanLy(tt2cqql.getId());
						tt2cqql.setDaXoa(DocumentConstants.INACTIVE);
						TTHC2CoQuanQuanLyLocalServiceUtil.updateTTHC2CoQuanQuanLy(tt2cqql);
						//TTHC2CoQuanQuanLyLocalServiceUtil.deleteTTHC2CoQuanQuanLy(tt2cqql);
					}
				}
				
				// add new tthc2coquanquanly
				TTHC2CoQuanQuanLy tt2Base= new TTHC2CoQuanQuanLyClp();
				String[] dsCQQL =giatriCQQLId.split(",");
				if(dsCQQL!=null && dsCQQL.length>0){

					for(int i=0;i<dsCQQL.length;i++){		
						long idtthc2CQ = CounterLocalServiceUtil.increment(TTHC2CoQuanQuanLy.class.getName());

						tt2Base.setId(idtthc2CQ);								 
						tt2Base.setNgayTao(new Date());								  
						tt2Base.setNguoiTao(themeDisplay.getUser().getEmailAddress());

						tt2Base.setDaXoa(DocumentConstants.TTHC2CQQL.DaXoa);		
						tt2Base.setTrangThai(DocumentConstants.TTHC2CQQL.TrangThai);
						tt2Base.setNgaySua(new Date());		
						tt2Base.setNguoiSua(themeDisplay.getUser().getEmailAddress());							

						tt2Base.setCoQuanQuanLyId(FormatUtil.convertToLong(dsCQQL[i].toString()));
						tt2Base.setThuTucHanhChinhId(tthcId);
						
						String soNgayXuLy = ParamUtil.getString(actionRequest, "soNgayXuLy-" + dsCQQL[i], "0");
						String phi = ParamUtil.getString(actionRequest, "phi-" + dsCQQL[i], "0");
						String lePhi = ParamUtil.getString(actionRequest, "lePhi-" + dsCQQL[i], "0");
						tt2Base.setSoNgayXyLy(FormatUtil.convertToInt(soNgayXuLy));
						tt2Base.setPhi(FormatUtil.convertToInt(phi));
						tt2Base.setLePhi(FormatUtil.convertToInt(lePhi));

						try{									  

							TTHC2CoQuanQuanLyLocalServiceUtil.addTTHC2CoQuanQuanLy(tt2Base);


						}catch (Exception es) {
							FormatUtil.printException(es);
							FormatUtil.printError(tt2Base.toString());
							SessionErrors.add(actionRequest, "errorAddTTHC2CQQL");
						} 

					}
				}


				actionResponse.setRenderParameter("CompletedUpdateTTHC", "CompletedUpdateTTHC");
				actionResponse.setRenderParameter("completed", "completed");
				SessionMessages.add(actionRequest, "successUpdateTTHC");

			} catch (Exception es) {
				FormatUtil.printException(es);
//				FormatUtil.printError(tthc.toString());
				SessionErrors.add(actionRequest, "errorUpdateTTHC");
			}
		} 
		
		actionResponse.setRenderParameter("giatriCQQLId", giatriCQQLId);		
		actionResponse.setRenderParameter("tthcID", String.valueOf(tthcId));
		actionRequest.setAttribute("tthcID", String.valueOf(tthcId));
		actionResponse.setRenderParameter("ungDung", ungDung);
		actionResponse.setRenderParameter("nhomTTHC", nhomTTHC);
		
		actionResponse.setRenderParameter("quocgiaId", quocgiaId);
		actionRequest.setAttribute("quocgiaId", quocgiaId);
		actionResponse.setRenderParameter("tinhId", tinhId);
		actionRequest.setAttribute("tinhId", tinhId);
		actionResponse.setRenderParameter("huyenId", huyenId);
		actionRequest.setAttribute("huyenId", huyenId);
		actionResponse.setRenderParameter("xaId", xaId);
		actionRequest.setAttribute("xaId", xaId);
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_co_quan_quan_ly.jsp");

	}
	//Add more van ban va bieu mau
	/**
	 * This is function addMoreTaiLieu
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
	public void addMoreTaiLieu(ActionRequest actionRequest,
				ActionResponse actionResponse) throws Exception 
	{
			ThuTucHanhChinhBusiness tthcBusiness = new ThuTucHanhChinhBusiness();
			tthcBusiness.addFileUpload(actionRequest, actionResponse);
			
			//PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			//SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			
			PortletPreferences prefs = actionRequest.getPreferences();
			
			int cur = ParamUtil.getInteger(actionRequest, "curBM", 1);
			int delta = ParamUtil.getInteger(actionRequest, "deltaBM", 10);
			prefs.setValue("curBM", String.valueOf(cur));
			prefs.setValue("deltaBM", String.valueOf(delta));
			prefs.store();
		
	}
	
	/**
	 * This is function deleteVBRequest
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
	public void deleteVBRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
	{
		String tthcId = ParamUtil
				.getString(actionRequest, "tthcID", null);
		String loaiTaiLieuId = ParamUtil.getString(actionRequest, "loaiTaiLieuId",
				null);
		
		// Get search keyword, the keyword is code
		long tt2vbId = ParamUtil.getLong(actionRequest, "tt2vbId");
		
		// Process Jason feed
		try {
			//Change status
			VanBanHuongDan vbhd= VanBanHuongDanLocalServiceUtil.fetchVanBanHuongDan(tt2vbId);
			vbhd.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			VanBanHuongDanLocalServiceUtil.updateVanBanHuongDan(vbhd);
			
			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
			String urlFileUpload=iDocumentStorage.getURLById(vbhd.getNoiLuuTruId());
			if(urlFileUpload!=null)
			{
				iDocumentStorage.deleteFile(vbhd.getNoiLuuTruId());
			}
			//Remove	
			//ThuTucHanhChinhLocalServiceUtil.deleteThuTucHanhChinh(tthcdId);
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteHDVB");
		} catch (Exception es) {
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteTTHC");
		}

		actionResponse.setRenderParameter("tthcID", tthcId);
		actionRequest.getPortletSession().setAttribute("tthcID", tthcId);
		
		actionResponse.setRenderParameter("loaiTaiLieuId", loaiTaiLieuId);
		actionRequest.getPortletSession().setAttribute("loaiTaiLieuId", loaiTaiLieuId);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		int cur = ParamUtil.getInteger(actionRequest, "curBM", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaBM", 10);
		prefs.setValue("curBM", String.valueOf(cur));
		prefs.setValue("deltaBM", String.valueOf(delta));
		prefs.store();
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
	}
	
	//File 
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

		ThuTucHanhChinhBusiness tthcBusiness = new ThuTucHanhChinhBusiness();
		JSONObject jsonFeed = tthcBusiness.deleteFileUploadById(resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(httpReq);
		
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
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
		
		ThuTucHanhChinhBusiness tthcBusiness = new ThuTucHanhChinhBusiness();
		JSONObject jsonFeed = tthcBusiness.checkFileUpload(resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(httpReq);
		
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}

	/**
	 * This is function setSearchParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void setSearchParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String cur = ParamUtil.getString(actionRequest, "cur");
		if (!Helpers.isEmpty(cur)) {
			actionResponse.setRenderParameter("cur",
					ParamUtil.getString(actionRequest, "cur"));
		}
		String delta = ParamUtil.getString(actionRequest, "delta");
		if (!Helpers.isEmpty(delta)) {
			actionResponse.setRenderParameter("delta",
					ParamUtil.getString(actionRequest, "delta"));
		}

	}

	/**
	 * This is function setSearchParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param portletURL
	 * @param renderRequest
	 */
	public void setSearchParameter(PortletURL portletURL, RenderRequest renderRequest) {
	
		String cur = ParamUtil.getString(renderRequest, "cur");
		String delta = ParamUtil.getString(renderRequest, "delta");
		
		PortletPreferences prefs = null;

		if (renderRequest != null) {
			prefs = renderRequest.getPreferences();
			if (prefs != null) {
				cur = prefs.getValue("curUD", cur);
				delta = prefs.getValue("deltaUD", delta);
			}
		}
		portletURL.setParameter("cur", cur);
		portletURL.setParameter("delta", delta);
	}

	/**
	 * This is function getTTHC2CoQuanQuanLyUsingAjax
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws PortalException
	 */
	private void getTTHC2CoQuanQuanLyUsingAjax(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, NumberFormatException, PortalException {
		String tthcId = ParamUtil.getString(resourceRequest, "tthcId");
		String cqqlIdChain = ParamUtil.getString(resourceRequest, "cqqlIdChain");
		List<String> cqqlIdList = Arrays.asList(cqqlIdChain.split(","));
		List<TTHC2CoQuanQuanLy> tthc2CqqlList = new ArrayList<TTHC2CoQuanQuanLy>();
		for (String cqqlId : cqqlIdList) {
			if (tthcId == null || "".equals(tthcId) || cqqlId == null || "".equals(cqqlId)) {
				continue;
			}
			List<TTHC2CoQuanQuanLy> tthc2CoQuanQuanLiesFromDB = null;
			try {
				tthc2CoQuanQuanLiesFromDB = TTHC2CoQuanQuanLyLocalServiceUtil.findByCoQuanAndThuTuc(Long.parseLong(cqqlId), Long.parseLong(tthcId));
			} catch (SystemException e) {

			}
			if (tthc2CoQuanQuanLiesFromDB != null) {
				for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : tthc2CoQuanQuanLiesFromDB) {
					if (tthc2CoQuanQuanLy.getDaXoa() == DocumentConstants.ACTIVE) {

						// only add undeleted data
						tthc2CqqlList.add(tthc2CoQuanQuanLy);
					}
				}
			}
		}
		JSONArray tthc2CqqlJsonArray = JSONFactoryUtil.createJSONArray();
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : tthc2CqqlList) {
			tthc2CqqlJsonArray.put(JSONFactoryUtil.createJSONObject().put("cqqlId", tthc2CoQuanQuanLy.getCoQuanQuanLyId())
				.put("soNgayXuLy", tthc2CoQuanQuanLy.getSoNgayXyLy())
				.put("phi", tthc2CoQuanQuanLy.getPhi()).put("lePhi", tthc2CoQuanQuanLy.getLePhi()));
		}

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("tthc2Cqqls", tthc2CqqlJsonArray);
		HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(resourceResponse);
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("application/json");
		httpServletResponse.getWriter().write(json.toString());
		httpServletResponse.getWriter().close();
	}
	// end adding by phucnv 2014-03-31
}
