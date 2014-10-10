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

import java.util.Date;
import java.util.Iterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.document.util.FormatUtil;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;

import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class YKienTraoDoiAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class YKienTraoDoiAction extends MVCPortlet{
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
	 * @throws Exception
	 */    
public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String keyword = ParamUtil.getString(actionRequest, "keyword");
		FormatUtil.setParams(actionRequest);
		actionRequest.getPortletSession().setAttribute("keyword", keyword);
	}
	
//trao doi giua doanh nghiep va can bo, va save vao table Ykientraodoi

	/**
	 * This is  function saveTraoDoi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws Exception
	 */  
		public void saveTraoDoi(ActionRequest resourceRequest,
				ActionResponse httpReq) throws NumberFormatException, Exception {


			// hoso - String
			long idHoSo = FormatUtil.convertToLong(ParamUtil.getString(resourceRequest, "yKienTraoDoiId"));

			String tieuDe = ParamUtil.getString(resourceRequest, "tieuDe").trim();
			String noiDung = ParamUtil.getString(resourceRequest, "noiDung").trim();
			String back_Current_Url = ParamUtil.getString(resourceRequest, "/html/portlet/ykientraodoi/danh_sach_y_kien.jsp").trim();

			if (validatorsYKienTraoDoi(resourceRequest)) {
				saveYKienTraoDoiToDB(resourceRequest, httpReq, "");

//				String emailNguoiGui= ConfigurationManager.getStrProp("vn.dtt.moh.mail.default.system", "noreply1@dtt.vn");
//				LogFactoryMOC.getLog().debug("doanhNghiep.getEmailDoanhNghiep()doanhNghiep.getEmailDoanhNghiep()===" + doanhNghiep.getEmailDoanhNghiep());
//				LogFactoryMOC.getLog().debug("congChuc.getHoVaTen()congChuc.getHoVaTen()===" + congChuc.getHoVaTen());
//				try {
//					BusinessUtils.sendEmail(doanhNghiep.getEmailDoanhNghiep(), emailNguoiGui, congChuc.getHoVaTen(), tieuDe, noiDung);
//				} catch (Exception e) {
//					LogFactoryMOC.getLog().error(e.toString());
//				}

//				if (listMail != null && listMail.length() > 0) {
//					String[] list = listMail.split(";");
//					for (String item : list) {
//						BusinessUtils.sendEmail(item,emailNguoiGui, congChuc.getHoVaTen(), tieuDe, noiDung);
//					}
//				}

//				String BUOC_XU_LY = ConfigurationManager.getStrProp("vn.dtt.moh.sentemail.content.buocxuly", "");
//				DocumentUtils.addHistory(BusinessUtils.createLichSuHoSoObject(BUOC_XU_LY,
//						congChuc.getHoVaTen(), idHoSo, noiDung, 0));

				httpReq.setRenderParameter("jspPage", "/html/portlet/ykientraodoi/congdan_traodoi_canbo_form.jsp");
				httpReq.setRenderParameter("sent_success", "true");

			} else {
				httpReq.setRenderParameter("jspPage", "/html/portlet/ykientraodoi/congdan_traodoi_canbo_form.jsp");
			}

			httpReq.setRenderParameter("tieuDe", tieuDe);
			httpReq.setRenderParameter("noiDung", noiDung);
			httpReq.setRenderParameter("back_Current_Url", back_Current_Url);

			httpReq.setRenderParameter("hoSoTTHCCongId", String.valueOf(idHoSo) );

			PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(resourceRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		}
	
		// Save Y kien Doanh Nghiep - Gui -- Can Bo Tiep nhan
		/**
		 * This is  function saveYKienTraoDoiToDB
		 * Version: 1.0
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  3-March-2013  Nam Dinh    Create new
		 * @param resourceRequest
		 * @param httpReq
		 * @param nguoiNhanOther
		 * @throws NumberFormatException
		 * @throws Exception
		 */ 
		private YKienTraoDoi saveYKienTraoDoiToDB(ActionRequest resourceRequest,
				ActionResponse httpReq, String nguoiNhanOther) throws NumberFormatException, Exception {

			long idYKienTraoDoi = ParamUtil.getLong(resourceRequest, "yKienTraoDoiId");
			long idHoSo = ConvertUtil.convertToLong(ParamUtil.getString(resourceRequest, "hoSoTTHCCongId"));
			String tenDoanhNghiep="";
			String listCanBoTiepNhan="";
			HoSoTTHCCong hoSoTTHCCong = null;
			if (idHoSo>0){
				 hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(idHoSo);
				tenDoanhNghiep=hoSoTTHCCong.getHoTenNguoiNopHoSo();
//				List<CongChuc> tiepNhanlist = BusinessUtils.getListCongChucCapDuoiByCongChucId(hoSoTTHCCong.getCoQuanTiepNhanId(), ConvertUtil.convertToInt(Constants.CAN_BO_TIEP_NHAN));
//				for (CongChuc congChuc: tiepNhanlist){
//					TaiKhoanNguoiDung taiKhoanNguoiDung=TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
//					listCanBoTiepNhan=listCanBoTiepNhan+taiKhoanNguoiDung.getEmail()+" ; ";
//				}
			}

			YKienTraoDoi yKienTraoDoi =null;

			if (idYKienTraoDoi > 0) {
				yKienTraoDoi = YKienTraoDoiLocalServiceUtil.fetchYKienTraoDoi(idYKienTraoDoi);
			} else {
				yKienTraoDoi = new YKienTraoDoiClp();
				yKienTraoDoi.setId(CounterLocalServiceUtil.increment("vn.dtt.cmon.dao.hosohcc.model.YKienTraoDoi"));
			}

			// tieuDe - String
			String tieuDe = ParamUtil.getString(resourceRequest, "tieuDe").trim();
			yKienTraoDoi.setTieuDe(tieuDe);

			// noiDung - String
			String noiDung = ParamUtil.getString(resourceRequest, "noiDung").trim();
			yKienTraoDoi.setNoiDungYKien(noiDung);

			// nguoiGuiId
			long nguoiGuiId = ParamUtil.getLong(resourceRequest, "nguoiGuiId");
			yKienTraoDoi.setNguoiGuiId(nguoiGuiId);
			Date now = new Date		();
			yKienTraoDoi.setThoiGianGuiYKien(now);
			yKienTraoDoi.setTrangThai(1);
			yKienTraoDoi.setHoSoTTHCCongId(idHoSo);

			yKienTraoDoi.setLoai(0);
			yKienTraoDoi.setNoiLuuTruId(0L);
			
			if (hoSoTTHCCong.getCanBoTiepNhanId() != null && hoSoTTHCCong.getCanBoTiepNhanId() >0){
				yKienTraoDoi.setNguoiNhanId(hoSoTTHCCong.getCanBoTiepNhanId());
			} else {
				
			}
			
			
			//yKienTraoDoi.setTenNguoiGui(tenDoanhNghiep);
			//yKienTraoDoi.setEmailCanBoTiepNhan(listCanBoTiepNhan);

			if (idYKienTraoDoi > 0) {
				yKienTraoDoi = YKienTraoDoiLocalServiceUtil.updateYKienTraoDoi(yKienTraoDoi);
			} else {
				yKienTraoDoi = YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);
			}
			return yKienTraoDoi;
		}


		/**
		 * This is  function delYKienTraoDoi
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
	public void delYKienTraoDoi(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		
				
		long yKienTraoDoiId = ParamUtil.getLong(resourceRequest, "yKienTraoDoiId");
		YKienTraoDoiLocalServiceUtil.deleteYKienTraoDoi(yKienTraoDoiId);
	}
	
	/**
	 * This is  function validatorsYKienTraoDoi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionrequest
	 * @return boolean
	 */ 
	private boolean validatorsYKienTraoDoi(ActionRequest actionrequest) {
		boolean valid = true;

		// tieuDe - String
		String tieuDe = ParamUtil.getString(actionrequest, "tieuDe").trim();
		if (tieuDe.length() == 0 || tieuDe.length() > 200) {
			SessionErrors.add(actionrequest, "err.tieuDe");
			valid = false;
		}

		// noiDung - String
		String noiDung = ParamUtil.getString(actionrequest, "noiDung").trim();
		if (noiDung.length() == 0 ) {
			SessionErrors.add(actionrequest, "err.noiDung");
			valid = false;
		}

		if (!valid) {
			FormatUtil.setParams(actionrequest);
			Iterator<String> error = SessionErrors.iterator(actionrequest);
		}
		return valid;
	}

}
