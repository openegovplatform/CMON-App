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
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.oep.cmon.portlet.document.util.DocumentConstants;
import org.oep.cmon.portlet.document.util.FormatUtil;

import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDungClp;

import org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.model.DanhMucGiayToClp;

import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class SettingPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class SettingPortlet extends MVCPortlet {

	/**
	 * This is  function searchDocument
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
	public void searchDocument(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		// Get document group
		String doituongGroup = ParamUtil.getString(actionRequest,
				"doituongGroup");
	
		// Set the result back to session
		actionResponse.setRenderParameter("doituongGroup", doituongGroup);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		int cur = ParamUtil.getInteger(actionRequest, "curDMGT", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaDMGT", 10);
		prefs.setValue("curDMGT", String.valueOf(cur));
		prefs.setValue("deltaDMGT", String.valueOf(delta));
		prefs.store();
		
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/document/setting/dm_giayto_list.jsp");
	}

	/**
	 * This is  function editOrAddDMGTRequest
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
	public void editOrAddDMGTRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = ParamUtil.getString(actionRequest,"searchKeyWord", "");
		String doituongGroup= ParamUtil.getString(actionRequest,"doituongGroup","");
		
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String dMGTId = ParamUtil.getString(actionRequest, "dMGTId");
		String tenDMGT= ParamUtil.getString(actionRequest, "tenDMGT").trim();
		String maDMGT = ParamUtil.getString(actionRequest, "maDMGT").trim();
		String taiLieu = ParamUtil.getString(actionRequest, "kieuTaiLieu").trim();
		String dungLuong = ParamUtil.getString(actionRequest, "gioiHanDL").trim();
		Long taiLieuTTId = ParamUtil.getLong(actionRequest, "TaiLieuTTId");
		if(taiLieuTTId.intValue() ==-1) taiLieuTTId = null;
		int trangThaiDMGT= ParamUtil.getInteger(actionRequest, "trangThaiDMGT",DocumentConstants.ACTIVE);
		String doiTuongSDId = ParamUtil.getString(actionRequest, "giatridoituongId");
		//String gtDoiTuongSDId = ParamUtil.getString(actionRequest, "giatridoituongId");
		// String doiTuongSDId=actionRequest.getParameter("doituongId");
		String moTa = ParamUtil.getString(actionRequest, "moTaDMGT").trim();
	

		if (validationInput(tenDMGT, dMGTId, maDMGT, taiLieu, dungLuong, doiTuongSDId, actionRequest)) {
			DanhMucGiayTo dMGT = null;
			
			if (dMGTId.trim().length() > 0) {
				try {
					dMGT = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(dMGTId));
					dMGT.setTen(tenDMGT);
					dMGT.setMa(maDMGT);
					dMGT.setNgaySua(new Date());					
					dMGT.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					dMGT.setKieuTaiLieu(taiLieu);
					dMGT.setTailieuThayTheId(taiLieuTTId);
					dMGT.setGioiHanDungLuong(FormatUtil.convertToLong(dungLuong));
					dMGT.setMota(moTa);	
					
					dMGT.setDaXoa(trangThaiDMGT);
					DanhMucGiayToLocalServiceUtil.updateDanhMucGiayTo(dMGT);
					
					List<DanhMucGiayTo2DoiTuongSuDung> gt2DT= DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.getTheoLoaiGT_DSDMGT2DTSD(FormatUtil.convertToLong(dMGTId));					
					String[] dsDoiTuong =doiTuongSDId.split(",");
					//Xoa het, vi co truong hop them doi tuong, hoac xoa bot doi tuong
					if(gt2DT!=null && gt2DT.size()>0 ){
						 
						for(DanhMucGiayTo2DoiTuongSuDung doiTuongSD2GT:gt2DT){
							doiTuongSD2GT.setDaXoa(DocumentConstants.INACTIVE);
							DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.updateDanhMucGiayTo2DoiTuongSuDung(doiTuongSD2GT);
							//DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.deleteDanhMucGiayTo2DoiTuongSuDung(doiTuongSD2GT);						
							}
					}
					//Them Doi tuong
					DanhMucGiayTo2DoiTuongSuDung gt2DTBase=new DanhMucGiayTo2DoiTuongSuDungClp();
									
					if(dsDoiTuong!=null && dsDoiTuong.length>0){
						 
						  for(int i=0;i<dsDoiTuong.length;i++){							  

								 long idGT2DT = CounterLocalServiceUtil.increment(DanhMucGiayTo2DoiTuongSuDung.class.getName());
								 
								 gt2DTBase.setId(idGT2DT);								 
								 gt2DTBase.setNgayTao(new Date());								  
								 gt2DTBase.setNguoiTao(themeDisplay.getUser().getEmailAddress());
								 
								 gt2DTBase.setDaXoa(DocumentConstants.GT2DT.DaXoa);		
								 gt2DTBase.setTrangThai(DocumentConstants.GT2DT.TrangThai);
								 gt2DTBase.setNgaySua(new Date());		
								 gt2DTBase.setNguoiSua(themeDisplay.getUser().getEmailAddress());							
								
								 gt2DTBase.setLoaiDoiTuongId(FormatUtil.convertToLong(dsDoiTuong[i].toString()));
								 gt2DTBase.setLoaiGiayToId(FormatUtil.convertToLong(dMGTId));
								 
								  try{									  
									   
									  DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.addDanhMucGiayTo2DoiTuongSuDung(gt2DTBase);
									  
									  
								  }catch (Exception es) {
									  FormatUtil.printException(es);
									  FormatUtil.printError(gt2DT.toString());
									  SessionErrors.add(actionRequest, "errorAddGT2DT");
								} 
							  
						  }
					}
					actionResponse.setRenderParameter("CompletedUpdateDMGT", "CompletedUpdateDMGT");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successUpdateDMGT");
			
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(dMGT.toString());
					SessionErrors.add(actionRequest, "errorUpdateDMGT");
				}
			} else {
				try {
					dMGT = new DanhMucGiayToClp();
					long loaiGiayToId =CounterLocalServiceUtil.increment(DanhMucGiayTo.class.getName());
					dMGT.setId(loaiGiayToId);
					dMGT.setTen(tenDMGT);				
					dMGT.setMa(maDMGT);
					dMGT.setKieuTaiLieu(taiLieu);
					dMGT.setTailieuThayTheId(taiLieuTTId);
					dMGT.setGioiHanDungLuong(FormatUtil.convertToLong(dungLuong));
					dMGT.setDaXoa(trangThaiDMGT);
					dMGT.setNgaySua(new Date());
					dMGT.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					dMGT.setNgayTao(new Date());
					dMGT.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					dMGT.setPhienBan(1);
					dMGT.setMota(moTa);	
										
					DanhMucGiayToLocalServiceUtil.addDanhMucGiayTo(dMGT);
					
					//Them Doi tuong
					DanhMucGiayTo2DoiTuongSuDung gt2DT=new DanhMucGiayTo2DoiTuongSuDungClp();
					String[] dsDoiTuong =doiTuongSDId.split(",");
					
					if(dsDoiTuong!=null && dsDoiTuong.length>0){
						 
						  for(int i=0;i<dsDoiTuong.length;i++){							  

								 long idGT2DT = CounterLocalServiceUtil.increment(DanhMucGiayTo2DoiTuongSuDung.class.getName());
								 
								 gt2DT.setId(idGT2DT);								 
								 gt2DT.setNgayTao(new Date());								  
								 gt2DT.setNguoiTao(themeDisplay.getUser().getEmailAddress());
								 
								 gt2DT.setDaXoa(DocumentConstants.GT2DT.DaXoa);		
								 gt2DT.setTrangThai(DocumentConstants.GT2DT.TrangThai);
								 gt2DT.setNgaySua(new Date());		
								 gt2DT.setNguoiSua(themeDisplay.getUser().getEmailAddress());							
								
								 gt2DT.setLoaiDoiTuongId(FormatUtil.convertToLong(dsDoiTuong[i].toString()));
								 gt2DT.setLoaiGiayToId(loaiGiayToId);
								 
								  try{									  
									   
									  DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.addDanhMucGiayTo2DoiTuongSuDung(gt2DT);
									  
									  
								  }catch (Exception es) {
									  FormatUtil.printException(es);
									  FormatUtil.printError(gt2DT.toString());
									  SessionErrors.add(actionRequest, "errorAddGT2DT");
								} 
							  
						  }
					}
					
					actionResponse.setRenderParameter("CompletedAddDMGT", "CompletedAddDMGT");
					actionResponse.setRenderParameter("completed", "completed");
					SessionMessages.add(actionRequest, "successAddDMGT");
					
					tenDMGT = "";					
					maDMGT = "";
					
					doiTuongSDId = "";
					taiLieu="";
				
					dungLuong="";
					moTa="";
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(dMGT.toString());
					SessionErrors.add(actionRequest, "errorAddDMGT");
				}
			}
		}
		String strTaiLieuTTId=String.valueOf(taiLieuTTId);
		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("dMGTId", dMGTId);
		actionResponse.setRenderParameter("maDMGT", maDMGT);		
		actionResponse.setRenderParameter("tenDMGT", tenDMGT);
		
		actionResponse.setRenderParameter("doituongId", doiTuongSDId);
		actionResponse.setRenderParameter("kieuTaiLieu", taiLieu);
		actionResponse.setRenderParameter("TaiLieuTTId", strTaiLieuTTId!=null?strTaiLieuTTId:"-1");
		actionResponse.setRenderParameter("gioiHanDL", dungLuong);
		actionResponse.setRenderParameter("moTaDMGT", moTa);
		
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("doituongGroup", doituongGroup);
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/dm_giayto_add.jsp");

		FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
	}

	
	/**
	 * This is function delete document
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
	public void deleteDMGTRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest,"searchKeyWord", "");
		String doituongGroup= ParamUtil.getString(actionRequest,"doituongGroup","");

		// Get search keyword, the keyword is code
		String dmgtId = ParamUtil.getString(actionRequest, "dMGTId");

		// Process Jason feed
		try {
			//update if used
			DanhMucGiayTo dMGT = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(dmgtId));
			dMGT.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			DanhMucGiayToLocalServiceUtil.updateDanhMucGiayTo(dMGT);
			//delete if not used			
			//DanhMucGiayToLocalServiceUtil.deleteDanhMucGiayTo(FormatUtil.convertToLong(dmgtId));
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteDMGT");
		} catch (Exception es) {
			
				// TODO: handle exception
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteGMGT");
		}

		// Hidden default error message
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("doituongGroup", doituongGroup);
		//FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
		// Redirect to document list jsp
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/document/setting/dm_giayto_list.jsp");
	}

	
	/**
	 * This is  function processAction
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
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.processAction(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenDMGT
	 * @param dMGTId
	 * @param maDMGT
	 * @param taiLieu
	 * @param dungLuong
	 * @param doiTuongSuDung
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String tenDMGT, String dMGTId, String maDMGT, String taiLieu, String dungLuong, String doiTuongSuDung, ActionRequest actionRequest) {
		if (maDMGT.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaDMGT");
		}
		if (tenDMGT.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenDMGT");
		}
		if (taiLieu.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTaiLieuDMGT");
		}
		if (dungLuong.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyDungLuongDMGT");
		}
		if(FormatUtil.convertToInt(dungLuong) <=0)
		{
			SessionErrors.add(actionRequest, "emptyDungLuongDMGT");
		}
		if(Validator.isNull(doiTuongSuDung))
		{
			SessionErrors.add(actionRequest, "emptyDoiTuongSuDung");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			DanhMucGiayTo dMGT = null;
			try {

				// Kiem tra theo Ma
				try {
					dMGT = null;
					dMGT = DanhMucGiayToLocalServiceUtil.findTheoMa(maDMGT);
				} catch (Exception es) {
				}
				if (dMGT != null) {
					if (dMGT.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (dMGTId.trim().length() > 0) {
						if (FormatUtil.convertToLong(dMGTId) != dMGT.getId()) {
							SessionErrors.add(actionRequest, "existMaDMGT");
						}
					} else {
						SessionErrors.add(actionRequest, "existMaDMGT");
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
	 * This is  function search
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
	public void search(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		String ungDung = ParamUtil.getString(actionRequest,"ungDung", "");
		
		String nhomUngDung= ParamUtil.getString(actionRequest,"nhomUngDung", "");
		
		PortletPreferences prefs = actionRequest.getPreferences();
		prefs.setValue("ungDung", ungDung);
		prefs.setValue("nhomUngDung", nhomUngDung);
		
		int cur = ParamUtil.getInteger(actionRequest, "cur", 1);
		int delta = ParamUtil.getInteger(actionRequest, "delta", 10);
		prefs.setValue("cur", String.valueOf(cur));
		prefs.setValue("delta", String.valueOf(delta));
		prefs.store();
		
		
		
	}

}
