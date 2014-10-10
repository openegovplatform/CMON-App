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

package org.oep.cmon.portlet.transaction;

import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp;
import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
/**
 * @author HungvQ
 */

/**
*
* TransactionUtils class
*   
* This class is used to process Transaction
* from database
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
@SuppressWarnings("unchecked")
public class TransactionUtils {

	public static final String PARAM_VIEW_TYPE = "viewType";
	public static final String VIEW_TRANSACTION_LIST = "transactionList";
	public static final String VIEW_TRANSACTION_DETAILS = "transactionDetails";

	public static final String START_PAGINATION = "startPagination";
	public static final String TRANSACTION_ID = "transactionId";

	// params send to other Portlet
	public static final String PARAM_PORTLET_NAME = "portletName";
	public static final String PARAM_ID = "id";
	public static final String PARAM_ID_QUY_TRINH = "idQuyTrinh";

	public static final String CONFIG_TRANS_TO_BRMS = "vn.dtt.cmon.transToBRMS";
	public static final String CONFIG_SCHEMA_BRMS = "vn.dtt.cmon.schema.BRMS";

	public static final String PROCESS_STATUS_CANCELLED = "Cancelled";
	public static final String PROCESS_STATUS_STOP = "Stopped";
	public static final String PROCESS_STATUS_FAILED = "Failed";
	public static final String PROCESS_STATUS_RUNNING = "Running";
	public static final String PROCESS_STATUS_COMPLETED = "Completed";

	public static final String PROCESS_OFFLINEDOCUMENT_DEFAULT = "-1";
	public static final String PROCESS_OFFLINEDOCUMENT_CODITION = "0";
	public static final String PROCESS_OFFLINEDOCUMENT_CODITION_INVALID = "2";


	   /**
     * Given an ActionRequest, grabs the field values from the form and
     * populates an Slogan object with them. This object can then be validated
     * and then stored.
     *
     * @param request
     * @return
     */
	
	/**
	  * This is fucntion yKienTraoDoiFromRequest
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest request
	  * @return YKienTraoDoi
	  */
    public static YKienTraoDoi yKienTraoDoiFromRequest(ActionRequest request) {


    	YKienTraoDoi yKienTraoDoi = new YKienTraoDoiClp();

        ThemeDisplay themeDisplay =   (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
 		String title = ParamUtil.getString(request, "tieude") ;
	 	yKienTraoDoi.setTieuDe(title + " " +ParamUtil.getString(request, "maHoSo"));
	 	yKienTraoDoi.setNoiDungYKien(ParamUtil.getString(request, "noiDung"));
	 	// TODO
	 	yKienTraoDoi.setHoSoTTHCCongId(Long.parseLong(ParamUtil.getString(request, "idPhanHoi")));
	 	yKienTraoDoi.setThoiGianGuiYKien(Calendar.getInstance().getTime());
	 	yKienTraoDoi.setTrangThai((long)1); //Yeu cau Huy Ho So

	 	// TODO
	 	yKienTraoDoi.setNguoiNhanId(ParamUtil.getLong(request, "nguoiNhan"));//canboxulyhienthoiid

	 	try {
	 		CongChuc congChucs =  CongChucLocalServiceUtil.fetchCongChuc(Long.parseLong(ParamUtil.getString(request, "nguoiNhan")));
	 		if(congChucs != null){
	 			yKienTraoDoi.setNguoiNhanId(congChucs.getTaiKhoanNguoiDungId());
	 		}
	 		TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(themeDisplay.getUserId());
	 		if (taiKhoanNguoiDung!=null) {
		 		CongDan congDan =CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
		 		if(congDan != null){
		 			yKienTraoDoi.setNguoiGuiId(congDan.getTaiKhoanNguoiDungId());
		 		}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


        return yKienTraoDoi;
    }

    /**
	  * This is fucntion traoDoHoSoiFromRequest
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest request
	  * @return YKienTraoDoi
	  */
    public static YKienTraoDoi traoDoHoSoiFromRequest(ActionRequest request) {


    	YKienTraoDoi yKienTraoDoi = new YKienTraoDoiClp();

        ThemeDisplay themeDisplay =   (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
 		String title = ParamUtil.getString(request, "tieude") ;
 		yKienTraoDoi.setTieuDe(title);
	 	yKienTraoDoi.setNoiDungYKien(ParamUtil.getString(request, "noiDung"));

	 	yKienTraoDoi.setHoSoTTHCCongId(Long.parseLong(ParamUtil.getString(request, "ipmsId")));
	 	yKienTraoDoi.setThoiGianGuiYKien(Calendar.getInstance().getTime());
	 	yKienTraoDoi.setTrangThai((long)1); //Yeu cau Huy Ho So

	 	try {
	 		
	 		TaiKhoanNguoiDung  taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(themeDisplay.getUserId());
	 		
	 		if(taiKhoanNguoiDung != null){

	 			yKienTraoDoi.setNguoiGuiId(taiKhoanNguoiDung.getId());
	 		}
//	 
	 			yKienTraoDoi.setNguoiNhanId(Long.parseLong(ParamUtil.getString(request, "nguoiNhan")));
//	 		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return yKienTraoDoi;
    }

    /**
	  * This is fucntion gettebNguoiDUng
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long id
	  * @return String
	  */
    public static String gettebNguoiDUng(long id){
    	String tenNguoiDung ="";
	 	try {
	 		TaiKhoanNguoiDung  taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(id);

	 		if(taiKhoanNguoiDung != null){

	 			tenNguoiDung = taiKhoanNguoiDung.getTenNguoiDung();
	 		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 	return tenNguoiDung;
    }
    
    /**
	  * This is fucntion getNguoiDungbyEmail
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String email
	  * @return String
	  */
    public static String getNguoiDungbyEmail(String email){
    	String tenNguoiDung ="";
 	 	try {

			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiKhoanNguoiDung.class);
			Criterion criterion = RestrictionsFactoryUtil.eq("email", email);
			query = query.add(criterion);
			List<TaiKhoanNguoiDung> taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.dynamicQuery(query);
			if (taiKhoanNguoiDungs.size() > 0 ) {
				tenNguoiDung= taiKhoanNguoiDungs.get(0).getTenNguoiDung();
			}else 
				tenNguoiDung= email;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 	return tenNguoiDung;
    }  
    
    /**
	  * This is fucntion getPhongbanEmail
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String email
	  * @return String
	  */
    public static String getPhongbanEmail(String email){
    	String tenPhongBan ="";
 	 	try {

			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiKhoanNguoiDung.class);
			Criterion criterion = RestrictionsFactoryUtil.eq("email", email);
			query = query.add(criterion);
			List<TaiKhoanNguoiDung> taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.dynamicQuery(query);
			if (taiKhoanNguoiDungs.size() > 0 ) {
				long tknguoidungid= taiKhoanNguoiDungs.get(0).getId();
				List<CongChuc> congChucs =  CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(tknguoidungid);
				if (congChucs.size() > 0) {
					tenPhongBan = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChucs.get(0).getCoQuanQuanLyId()).getTen();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 	return tenPhongBan;
    }  
    
    /**
	  * This is fucntion isNotNullNotEmptyNotWhiteSpace
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return boolean
	  */
    public static boolean isNotNullNotEmptyNotWhiteSpace(  
    		   final String string)  
    		{  
    		   return string != null && !string.isEmpty() && !string.trim().isEmpty();  
    		}
    
    /**
	  * This is fucntion hasPermissionThisTask
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String curUser, String userList
	  * @return boolean
	  */
    public static boolean hasPermissionThisTask(String curUser, String userList){

 			String[] endpoints = userList.split(";");
 			
 			for (int i=0; i<endpoints.length; i++) {
 				
 				if (endpoints[i].equalsIgnoreCase(curUser)) {
 					return true;
 				}
 			}
 	    	return false;
 	    }	
    
    /**
	  * This is fucntion getTrangThai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long id
	  * @return String
	  */
    public static String getTrangThai(Long id) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TrangThaiHoSo.class);
				Criterion criteriaNotIn = RestrictionsFactoryUtil.eq("id", id);
				query = query.add(criteriaNotIn);
				
				
				List<TrangThaiHoSo> list = (List<TrangThaiHoSo>)TrangThaiHoSoLocalServiceUtil.dynamicQuery(query);
				return list.get(0).getTrangThai();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}	   
 
    /**
	  * This is fucntion getHoSoTTHCCong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long id
	  * @return HoSoTTHCCong
	  */
    public static HoSoTTHCCong getHoSoTTHCCong(Long id) {
 		try {
 			DynamicQuery query = DynamicQueryFactoryUtil.forClass(HoSoTTHCCong.class);
			Criterion idc = RestrictionsFactoryUtil.eq("id", id);
			query = query.add(idc);
			
			List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)HoSoTTHCCongLocalServiceUtil.dynamicQuery(query);
			return list.get(0);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 		return   new HoSoTTHCCongClp();
 	}	       
}
