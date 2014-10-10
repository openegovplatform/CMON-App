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

package org.oep.cmon.portlet.taocongdan.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.taocongdan.business.TaoCongDanBusiness;
import org.oep.cmon.portlet.taocongdan.util.FormatUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
*
* TaoCongDanAction class
*   
* This class is used to process TaoCongDan
* 
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class TaoCongDanAction {
		
	/** Date format */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
		
	private Log _log = LogFactoryUtil.getLog(TaoCongDanAction.class);
	
	
	/**
	  * This is fucntion sendEmailToCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ho, String dem, String ten, String matKhau, String url, String email, String uri 
	  * @return void
	  */
	private void sendEmailToCongDan( String ho, String dem, String ten, String matKhau, String url, String email, String uri ) throws IOException {
		
		org.oep.cmon.portlet.taocongdan.mail.AccountCreationRequestMail mail = new org.oep.cmon.portlet.taocongdan.mail.AccountCreationRequestMail();
		
		mail.setEmail(email);
		mail.setMatKhau(matKhau);
		
		mail.setUrl(url);
		mail.setUri(uri);
		
		mail.setFullName(ho + " " + dem + " " + ten);
		
		// Send the email
		mail.send();
	}
	
	/**
	  * This is fucntion sendEmailToCongDan_ChangPass
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ho, String dem, String ten, String matKhau, String url, String email, String uri, ActionRequest request
	  * @return void
	  */
	private void sendEmailToCongDan_ChangPass( String ho, String dem, String ten, String matKhau, String url, String email, String uri, ActionRequest request ) throws IOException {
		
		org.oep.cmon.portlet.taocongdan.mail.ChangePassRequestMail mail = new org.oep.cmon.portlet.taocongdan.mail.ChangePassRequestMail();
		
		mail.setEmail(email);
		mail.setMatKhau(matKhau);
		
		mail.setUrl(url);
		mail.setUri(uri);
		
		mail.setFullName(ho + " " + dem + " " + ten);
		
		// Send the email
		mail.send(request);
	}
	
	
	/**
	  * This is fucntion emailExists
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return boolean
	  */
	private boolean emailExists( String email){
		try{
		if (Validator.isNull(email)) {
			return false;
		}
		
		List<TaiKhoanNguoiDung> taiKhoanLst = TaiKhoanNguoiDungLocalServiceUtil.findByEmail(email);
		
		if ( taiKhoanLst.size() < 1) {
			return false;
		}		
		
		TaiKhoanNguoiDung taiKhoanNguoiDung = taiKhoanLst.get(0);		
		
		if ( email.equals(taiKhoanNguoiDung.getEmail()) || (taiKhoanNguoiDung.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE)) {		
					
				return true;			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;		
	}
	
	
	/**
	  * This is fucntion userLiferayExists
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long taiKhoanLiferayId
	  * @return boolean
	  */
	private boolean userLiferayExists( long taiKhoanLiferayId){
		if (Validator.isNull(taiKhoanLiferayId)) {
			return false;
		}		
		
		
		TaiKhoanNguoiDung taiKhoanNguoiDung =null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanLiferayId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(taiKhoanNguoiDung==null)
		{
			return false;
		}
		
		_log.info("taikhoangnguoidung-------------:"+taiKhoanNguoiDung);
		if ( taiKhoanLiferayId == taiKhoanNguoiDung.getTaiKhoanNguoiDungId() 
				&& (taiKhoanNguoiDung.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE)) {				
				return true;			
		}
		
		return false;		
	}
	
	/**
	  * This is fucntion requestExists
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return boolean
	  */
	private boolean requestExists(String soCmnd) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
	
		query = query.add(  PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));

		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results != null && results.size() > 0){
			return true;
		}
		
		return false;
	}


	/**
	  * This is fucntion getLongArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest, String
	  * @return long[]
	  */
	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}
	
	
	/**
	  * This is fucntion addEditTaoCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest, ActionResponse actionResponse
	  * @return void
	  */
	public void addEditTaoCongDan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String  mode = ParamUtil.getString(actionRequest, "mode");
		String  isLoaded = ParamUtil.getString(actionRequest, "isLoaded", null);	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String taiKhoanCongDanId = ParamUtil.getString(actionRequest, "taiKhoanCongDanId");
		String congDanId = ParamUtil.getString(actionRequest, "congDanId");	
		
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_TK_CONG_DAN_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
		userRequest.put("mode", mode);
		
		userRequest.put("isLoaded", isLoaded);
		
		userRequest.put("congDanId", congDanId);
		
		userRequest.put("taiKhoanCongDanId", taiKhoanCongDanId);
		
				
		String email = ParamUtil.getString(actionRequest, "email");
		userRequest.put("email", email);
		
		String matKhau = ParamUtil.getString(actionRequest, "matKhau");
		userRequest.put("matKhau", matKhau);
		
		String reMatKhau = ParamUtil.getString(actionRequest, "reMatKhau");
		userRequest.put("reMatKhau", reMatKhau);
		
		String ma = ParamUtil.getString(actionRequest, "ma");
		userRequest.put("ma", ma);
		
		String ho = ParamUtil.getString(actionRequest, "ho", "");
		userRequest.put("ho", ho);
		String dem = ParamUtil.getString(actionRequest, "dem", "");
		userRequest.put("dem", dem);
		String ten = ParamUtil.getString(actionRequest, "ten");
		userRequest.put("ten", ten);
		
		String tenDayDu = ho + " " + dem + " " + ten;
	
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");
		userRequest.put("ngaySinh", ngaySinh);
		
		String quocTichId = ParamUtil.getString(actionRequest, "quocTichId");
		userRequest.put("quocTichId", quocTichId);		
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd");
		userRequest.put("soCmnd", soCmnd);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd");
		userRequest.put("ngayCapCmnd", ngayCapCmnd);
		
		String noiCapCmndId = ParamUtil.getString(actionRequest, "noiCapCmndId");
		userRequest.put("noiCapCmndId", noiCapCmndId);
		
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		userRequest.put("gioiTinh", gioiTinh);
		
		String tonGiaoId = ParamUtil.getString(actionRequest, "tonGiaoId");
		userRequest.put("tonGiaoId", tonGiaoId);
		
		String danTocId = ParamUtil.getString(actionRequest, "danTocId");
		userRequest.put("danTocId", danTocId);
		
		String diaChiThuongTruTinhId = ParamUtil.getString(actionRequest, "diaChiThuongTruTinhId");
		userRequest.put("diaChiThuongTruTinhId", diaChiThuongTruTinhId);
		
		String diaChiThuongTruHuyenId = ParamUtil.getString(actionRequest, "diaChiThuongTruHuyenId");
		userRequest.put("diaChiThuongTruHuyenId", diaChiThuongTruHuyenId);
		
		String diaChiThuongTruXaId = ParamUtil.getString(actionRequest, "diaChiThuongTruXaId");
		userRequest.put("diaChiThuongTruXaId", diaChiThuongTruXaId);
		
		String diaChiThuongTru = ParamUtil.getString(actionRequest, "diaChiThuongTru");
		userRequest.put("diaChiThuongTru", diaChiThuongTru);		
		
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_TK_CONG_DAN_OBJECT", userRequest);
		
		// Validate parameteter
		if(validate(userRequest, actionRequest, actionResponse)){	
			_log.info("1. validate info ok");
				
				TaoCongDanBusiness taoCongDanBusiness = new TaoCongDanBusiness();				
				if (mode.equals(TaoCongDanBusiness.ADD_CONGDAN)) {
					
					User userLiferay = addUserLiferay(userRequest, actionRequest, actionResponse);					
					   
					try {
						
						if(userLiferay != null) {
							
							// Update organization
							String citizenOrg = getOrganizationForCitizen();
							_log.info("citizenOrgCodeLoaiDoiTuong:"+citizenOrg);
							Organization organization = OrganizationLocalServiceUtil.getOrganization(userLiferay.getCompanyId(), citizenOrg );
							   
							long[] orgIds= {organization.getOrganizationId()};
							   
						    UserLocalServiceUtil.updateOrganizations(userLiferay.getUserId(), orgIds, new ServiceContext());	
							
							long userLiferayId = userLiferay.getUserId();
							
							if(!this.userLiferayExists(userLiferayId) && !this.emailExists(email)){
								
								TaiKhoanNguoiDung taiKhoanNguoiDung = taoCongDanBusiness.insertTaiKhoanNguoiDung(userLiferay, matKhau, email, tenDayDu, actionRequest);
								
								if(taiKhoanNguoiDung != null){
									String maCongDan = taoCongDanBusiness.congdanExists(soCmnd, ngaySinh);
									_log.info("maCongDan"+maCongDan);		
									if ( Validator.isNull(maCongDan)) {
										CongDan congDan1 = CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId( taiKhoanNguoiDung.getId());
										_log.info("congDan1: "+congDan1);	
										boolean result = false;
										if (congDan1 == null){
											_log.info("vao day : "+congDan1);	
											result = taoCongDanBusiness.insertCongDan(userRequest, taiKhoanNguoiDung.getId(), tenDayDu, actionRequest);
										} else {
											SessionMessages.add(actionRequest, "TaiKhoanDaTonTai");
										} 
										
										if(result){
											SessionMessages.add(actionRequest, "successAddTKCD");
										}else{
											
											TaiKhoanNguoiDungLocalServiceUtil.deleteTaiKhoanNguoiDung(taiKhoanNguoiDung.getId());
											UserLocalServiceUtil.deleteUser(userLiferayId);
											SessionMessages.add(actionRequest, "successAddTKCD");
										}
										
									} else {
										_log.info("update tai khoang trong csms_congdan"+taiKhoanNguoiDung.getId());
										taoCongDanBusiness.editCongDan(userRequest, congDanId, String.valueOf(taiKhoanNguoiDung.getId()), tenDayDu, actionRequest);
										SessionMessages.add(actionRequest, "successEditTKCD");
										
									}
			
									String uri =  actionRequest.getScheme() + "://" +   actionRequest.getServerName() ;
									String urlTaiKhoanNguoiDung = ParamUtil.getString(actionRequest, "urlTaiKhoanNguoiDung");
									urlTaiKhoanNguoiDung = urlTaiKhoanNguoiDung.replace("DUMMY_AUTH_CODE", taiKhoanCongDanId);
									this.sendEmailToCongDan(ho, dem, ten, matKhau, urlTaiKhoanNguoiDung, email, uri);
									
								} else {
									UserLocalServiceUtil.deleteUser(userLiferayId);
									SessionErrors.add(actionRequest, "org.oep.taocongdan.forms.err.isNotCreatedUserLiferay");		
								
								}
						
							} else{
								SessionErrors.add(actionRequest, "org.oep.taocongdan.forms.err.Error.TTKND");	
							}
						
						} else {
							SessionErrors.add(actionRequest, "org.oep.taocongdan.forms.err.isNotCreatedUserLiferay");	
						}

							
					} catch (Exception e) {
						
						e.printStackTrace();					
						SessionErrors.add(actionRequest, "org.oep.taocongdan.forms.err.unKnown");					
								
						actionResponse.setRenderParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
						
					}
					
					
				} else if(mode.equals(TaoCongDanBusiness.UPDATE_CONGDAN )) {
					
					CongDan congDan=CongDanLocalServiceUtil.fetchCongDan(FormatUtil.convertToLong(congDanId));
	
					try{
						
						User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getCompanyId(actionRequest), userRequest.get("email"));
						_log.info("email user "+user.getEmailAddress());	
						
						if( user != null){
								user=updateUserLiferay(userRequest, actionRequest, actionResponse);
						}
						if(taiKhoanCongDanId != null){								
							_log.info("idthong tin tai khoan nguoi dung "+taiKhoanCongDanId);	
							taoCongDanBusiness.editTaiKhoanNguoiDung(userRequest, String.valueOf(congDan.getTaiKhoanNguoiDungId()), tenDayDu, actionRequest);
							SessionMessages.add(actionRequest, "successEditTKND");
						
						}
						
						if(congDanId !=null){
							_log.info("idthong tin cong dan "+congDanId);	
							taoCongDanBusiness.editCongDan(userRequest, congDanId, taiKhoanCongDanId,tenDayDu,actionRequest);
							SessionMessages.add(actionRequest, "successEditTKCD");
						
						}
						
					} catch (Exception e) {
						
						e.printStackTrace();	
						_log.error("[addEditTaoCongDan] error: "+e.toString());
						SessionErrors.add(actionRequest, "org.oep.taocongdan.forms.err.unKnown");					
										
						actionResponse.setRenderParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
						
					}
				}
				
			
			String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
			
			if ( !SessionErrors.isEmpty(actionRequest)) {			
				actionResponse.sendRedirect(redirectUrl);
				return;
			}
			
				
			actionRequest.getPortletSession().removeAttribute("USER_REQUEST_TK_CONG_DAN_OBJECT");
			
			
			if (userRequest.get("mode").equals(TaoCongDanBusiness.ADD_CONGDAN)) {
			
				SessionMessages.add(actionRequest, "success");
				
				actionResponse.sendRedirect(redirectUrl);
			}else if (userRequest.get("mode").equals(TaoCongDanBusiness.UPDATE_CONGDAN)) {
				
				SessionMessages.add(actionRequest, "success");
				
				actionResponse.sendRedirect(redirectUrl);
			}
			
		} else { 
			
			if(userRequest.get("mode").equals(TaoCongDanBusiness.ADD_CONGDAN )){
				
				actionResponse.setRenderParameter("mode", TaoCongDanBusiness.ADD_CONGDAN);
				actionResponse.setRenderParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
			} else {
				
				actionResponse.setRenderParameter("mode", TaoCongDanBusiness.UPDATE_CONGDAN);
				actionResponse.setRenderParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
			}
		}
		
	}

	/**
	  * This is fucntion validate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Map <String, String> userRequest,ActionRequest actionRequest, ActionResponse actionResponse
	  * @return boolean
	  */
	private boolean validate(Map <String, String> userRequest,
			ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{		

			TaoCongDanBusiness taoCongDanBusiness = new TaoCongDanBusiness();	
		
			if(userRequest.get("mode").equals(TaoCongDanBusiness.ADD_CONGDAN )){
				String maCongDan = null;
				try {
					
					try {
						User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getCompanyId(actionRequest), userRequest.get("email"));
						if (user.getEmailAddress().equals(userRequest.get("email")) ){
							SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.emailTontai");
						}
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(userRequest.get("isLoaded").equals("load")){
							if ( this.emailExists( userRequest.get("email"))) {
							SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.email.daCo");
							}	
								
							
							if (FormatUtil.isEmpty(userRequest.get("email"))) {
								
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.email");
							}
							
							if (FormatUtil.isEmpty(userRequest.get("matKhau"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.matKhau");
							}	
							
							
							if (!userRequest.get("matKhau").equals(userRequest.get("reMatKhau"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.matKhau.KhongGiong");
							}
							
							if (Validator.isNull(userRequest.get("ho"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ho");
							}
							
							
							if (Validator.isNull(userRequest.get("ten"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ten");
							}
							
							
							if (Validator.isNull(userRequest.get("ngaySinh"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ngaySinh");
							}
							
							
							long quocTichId = ConvertUtil.convertToLong( userRequest.get("quocTichId"));
							if (quocTichId ==0) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.quocTichId");
							}
							
							
							if (Validator.isNull(userRequest.get("noiCapCmndId"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.noiCapCmndId");
							}
							
							
							if (Validator.isNull(userRequest.get("soCmnd"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
							}
							
							
							if (Validator.isNull(userRequest.get("ngayCapCmnd"))) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ngayCapCmnd");
							}
							
							long tinhid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruTinhId"));
							
							if (tinhid ==0) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruTinhId");
							}	
							
							long huyenid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruHuyenId"));
							
							if (huyenid==0) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruHuyenId");
							}
								
							
							long xaid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruXaId"));
							if (xaid ==0) {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruXaId");
							}	
							
							if (userRequest.get("soCmnd").trim().length() > 0) {
								if (ConvertUtil.convertToLong(userRequest.get("soCmnd")) <= 0) {
									SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
								} else if (userRequest.get("soCmnd").length() != 9 && userRequest.get("soCmnd").length() != 12) {
									SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd.9or12");
								}
							} else {
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
							}
					
				
							if (!Validator.isEmailAddress(userRequest.get("email"))) {
								
								SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.email.khongDungDinhDang");
							}	
						
						
							if (SessionErrors.isEmpty(actionRequest)) {
								return true;
							}
							return false;
					}
					
					maCongDan = taoCongDanBusiness.congdanExists(userRequest.get("soCmnd"), userRequest.get("ngaySinh"));
					 _log.error("maCongDan: "+maCongDan);
					if (maCongDan.length() >0) {
						
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd.daCo");
					} 

					
					if ( this.emailExists( userRequest.get("email"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.email.daCo");
					}	
					
					if (FormatUtil.isEmpty(userRequest.get("email"))) {
						
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.email");
					}
					
					if (FormatUtil.isEmpty(userRequest.get("matKhau"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.matKhau");
					}	
					
					
					if (!userRequest.get("matKhau").equals(userRequest.get("reMatKhau"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.matKhau.KhongGiong");
					}
					
					if (Validator.isNull(userRequest.get("ho"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ho");
					}
					
					
					if (Validator.isNull(userRequest.get("ten"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ten");
					}
					
					
					if (Validator.isNull(userRequest.get("ngaySinh"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ngaySinh");
					}
					
					
					long quocTichId = ConvertUtil.convertToLong( userRequest.get("quocTichId"));
					if (quocTichId ==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.quocTichId");
					}
					
					
					if (Validator.isNull(userRequest.get("noiCapCmndId"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.noiCapCmndId");
					}
					
					
					if (Validator.isNull(userRequest.get("soCmnd"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
					}
					
				
					if (Validator.isNull(userRequest.get("ngayCapCmnd"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ngayCapCmnd");
					}
					
					long tinhid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruTinhId"));
					
					if (tinhid ==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruTinhId");
					}	
					
					long huyenid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruHuyenId"));
				
					if (huyenid==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruHuyenId");
					}
						
					
					long xaid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruXaId"));
					if (xaid ==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruXaId");
					}	
					
			
					
					if (userRequest.get("soCmnd").trim().length() > 0) {
						if (ConvertUtil.convertToLong(userRequest.get("soCmnd")) <= 0) {
							SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
						} else if (userRequest.get("soCmnd").length() != 9 && userRequest.get("soCmnd").length() != 12) {
							SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd.9or12");
						}
					} else {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
					}
			
					
					if (!Validator.isEmailAddress(userRequest.get("email"))) {
						
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.email.khongDungDinhDang");
					}	
				
				
					if (SessionErrors.isEmpty(actionRequest)) {
						return true;
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if(userRequest.get("mode").equals(TaoCongDanBusiness.UPDATE_CONGDAN )) {
				
				String maCongDan = null;
				try {
					
					if (!userRequest.get("matKhau").equals(userRequest.get("reMatKhau"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.matKhau.KhongGiong");
					} 
				
					if (Validator.isNull(userRequest.get("ho"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ho");
					}
					
		
					if (Validator.isNull(userRequest.get("ten"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ten");
					}
					
			
					if (Validator.isNull(userRequest.get("ngaySinh"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ngaySinh");
					}
					
				
					if (Validator.isNull(userRequest.get("quocTichId"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.quocTichId");
					}
				
					if (Validator.isNull(userRequest.get("soCmnd"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
					}
				
					if (Validator.isNull(userRequest.get("ngayCapCmnd"))) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.ngayCapCmnd");
					}
					
					maCongDan = taoCongDanBusiness.congdanExists(userRequest.get("soCmnd"), userRequest.get("ngaySinh"));
					 
					long tinhid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruTinhId"));
					
					if (tinhid ==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruTinhId");
					}	
					
					long huyenid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruHuyenId"));
				
					if (huyenid==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruHuyenId");
					}
						
				
					long xaid = ConvertUtil.convertToLong( userRequest.get("diaChiThuongTruXaId"));
					if (xaid ==0) {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.diaChiThuongTruXaId");
					}	
						
					if (userRequest.get("soCmnd").trim().length() > 0) {
						if (ConvertUtil.convertToLong(userRequest.get("soCmnd")) <= 0) {
							SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
						} else if (userRequest.get("soCmnd").length() != 9 && userRequest.get("soCmnd").length() != 12) {
							SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd.9or12");
						}
					} else {
						SessionErrors.add(actionRequest, "org.oep.taocongdan.form.err.soCmnd");
					}
			

//				
					if (SessionErrors.isEmpty(actionRequest)) {
						return true;
					}
					 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return false;
	}
	
	/**
	  * This is fucntion addUserLiferay
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Map <String, String> userRequest, ActionRequest actionRequest, ActionResponse actionResponse
	  * @return User
	  */
	private User addUserLiferay(Map <String, String> userRequest, ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException{
				
	
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		User user =null; 
			try {
				
			
				long userId = CounterLocalServiceUtil.increment(User.class.getName());
				long createrUserId = PortalUtil.getUserId(actionRequest);
				String screenName = "cd"+userId;
				_log.info("SR: "+ screenName+", createrUserId:"+String.valueOf(userId)+"Email :"+ userRequest.get("email"));
				 
				String firstName =  userRequest.get("ho");
				if(userRequest.get("dem") != null){
					firstName = firstName+" "+userRequest.get("dem");
				}
				
				if(userRequest.get("ten") != null){
					firstName = firstName+" "+userRequest.get("ten");
				}
				
				user = UserLocalServiceUtil.addUser(createrUserId,themeDisplay.getCompanyId(), false, userRequest.get("matKhau"), 
						userRequest.get("reMatKhau"), false,
						screenName, userRequest.get("email"), 0L, "",
						LocaleUtil.getDefault(), firstName, userRequest.get("dem"), userRequest.get("ho"), 1,
						1, false, Calendar.JANUARY, 1, 1979, null,
						null, null, null, null,
						false, serviceContext);
				
				
				_log.info("SR: "+user );
				return user;
	
			} catch (Exception e) {
				e.printStackTrace();		
				_log.error("[addUserLiferay] error: "+e.toString());
				
			}
		
		return null;
		
	}
	
	
	/**
	  * This is fucntion updateUserLiferay
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Map <String, String> userRequest, ActionRequest actionRequest, ActionResponse actionResponse
	  * @return User
	  */
	private User updateUserLiferay(Map <String, String> userRequest, ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		
		
		if (userRequest.get("mode").equals(TaoCongDanBusiness.UPDATE_CONGDAN)) {
		
			try {
				
				User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getCompanyId(actionRequest), userRequest.get("email"));
				
				String matkhau = ParamUtil.getString(actionRequest, "matKhau");
				_log.info("matkhau="+matkhau);
				
				String reMatKhau = ParamUtil.getString(actionRequest, "reMatKhau");
				_log.info("reMatKhau="+reMatKhau);
				
				String email = ParamUtil.getString(actionRequest, "email");
				
				String taiKhoanCongDanId = ParamUtil.getString(actionRequest, "taiKhoanCongDanId");
				
				String urlTaiKhoanNguoiDung = ParamUtil.getString(actionRequest, "urlTaiKhoanNguoiDung");
				urlTaiKhoanNguoiDung = urlTaiKhoanNguoiDung.replace("DUMMY_AUTH_CODE", taiKhoanCongDanId);
				String uri =  actionRequest.getScheme() + "://" +   actionRequest.getServerName() ;
				
				String ho = ParamUtil.getString(actionRequest, "ho");
				String dem = ParamUtil.getString(actionRequest, "dem");
				String ten = ParamUtil.getString(actionRequest, "ten");
					if (matkhau.trim().length() >0){
						UserLocalServiceUtil.updatePassword(user.getUserId(), matkhau, matkhau, false);
						_log.info("update co pass="+user);
						user = UserLocalServiceUtil.updateUser(user);
						
						this.sendEmailToCongDan_ChangPass(ho, dem, ten, matkhau, urlTaiKhoanNguoiDung, email, uri, actionRequest);
						
					} else {
						user.setEmailAddress(email);
						_log.info("update ko pass="+user);
						user = UserLocalServiceUtil.updateUser(user);
					}
				
				return user;

			} catch (Exception e) {
				e.printStackTrace();		
				_log.error("[updateUserLiferay] error: "+e.toString());		
			}
		}
		
		return null;
	}
	
	
	/**
	  * This is fucntion getOrganizationForCitizen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return String
	  */
	private String getOrganizationForCitizen() throws IOException, SystemException {
		  String maOrg = WebserviceFactory.getThamSoService().getValue("CMON_CONG_DAN_ORGANIZATION_ID");
		  if (maOrg == null || maOrg.length() == 0) {
		   maOrg = "CD";
		  }

		  try{
			  DoiTuongSuDung doiTuong = DoiTuongSuDungLocalServiceUtil.findByMa(maOrg);

			  return doiTuong.getTen();
		  }catch (Exception e) {
			// TODO: handle exception
		  }
		  return "CD";
	}
		
}
