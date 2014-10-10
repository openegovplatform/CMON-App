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

package org.oep.cmon.portlet.taocongdan.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.dao.cd.model.impl.CongDanImpl;
import org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl;
import org.oep.cmon.portlet.taocongdan.util.FormatUtil;
import org.oep.cmon.user.portlet.business.EndorsementBs;
import org.oep.cmon.user.portlet.util.ElectricCodeGeneratorUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
/**
*
* TaoCongDanBusiness class
*   
* This class is used to process  TaoCongDan
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
public class TaoCongDanBusiness {
	
	public static final String VIEW_CONGDAN= "viewCongDan";
	public static final String ADD_CONGDAN= "addCongDan";
	public static final String UPDATE_CONGDAN= "updateCongDan";
	
	/** Tai khoan nguoi dung sequence */
	public static final String TAIKHOANNGUOIDUNG_SEQUENCE = "cmon_taikhoannguoidung";
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	private Log _log = LogFactoryUtil.getLog(TaoCongDanBusiness.class);
	
	
	
	/**
	  * This is fucntion findByCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten, String taiKhoanNguoiDungId, int start, int end
	  * @return List<CongDan>
	  */
	@SuppressWarnings("unchecked")
	public static List<CongDan> findByCongDan(String ten, String taiKhoanNguoiDungId, int start, int end)
	{
		List<CongDan> results=null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
		query.addOrder(OrderFactoryUtil.asc("ten"));
		query.setLimit(start, end);
		// This is a test line for display all request if there's no search criteria
		Criterion criterion = null;		
		
		ten = ten.toUpperCase();
		
		criterion = RestrictionsFactoryUtil.ilike("ten",  StringPool.PERCENT + ten + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("ho", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("dem", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("tenDayDu", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("soCmnd", StringPool.PERCENT + ten + StringPool.PERCENT));
		
		
		if(taiKhoanNguoiDungId!="")
		{
			if(taiKhoanNguoiDungId.equals(String.valueOf(Constants.TaoCongDan.CO_TAI_KHOAN)))
			{
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.isNotNull("taiKhoanNguoiDungId"));
			}
			else
			{
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.isNull("taiKhoanNguoiDungId"));
			}
		}
		
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
		// Define search criteria			
		query = query.add(criterion);

		try {
			results = CongDanLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
		}

		if (results == null) {
			results = new ArrayList<CongDan>();
		}
		return results;
		
	}
	
	
	/**
	  * This is fucntion countByCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten, String taiKhoanNguoiDungId
	  * @return long
	  */
	@SuppressWarnings("unchecked")
	public static long countByCongDan(String ten, String taiKhoanNguoiDungId)
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);		
		Criterion criterion = null;
		ten = ten.toUpperCase();
		
		criterion = RestrictionsFactoryUtil.ilike("ten",  StringPool.PERCENT + ten + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("ho", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("dem", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("tenDayDu", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT + ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("soCmnd", StringPool.PERCENT + ten + StringPool.PERCENT));
		
		if(taiKhoanNguoiDungId!="")
		{
			if(taiKhoanNguoiDungId.equals(String.valueOf(Constants.TaoCongDan.CO_TAI_KHOAN)))
			{
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.isNotNull("taiKhoanNguoiDungId"));
			}
			else
			{
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.isNull("taiKhoanNguoiDungId"));
			}
		}
		
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
		
		query = query.add(criterion);
		
		query.setProjection(ProjectionFactoryUtil.rowCount());
		

		long count = 0;

		try {
			Iterator<Long>  resultsItr = 
					CongDanLocalServiceUtil.dynamicQuery(query).iterator();

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
	  * This is fucntion insertCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Map<String, String> userRequest, long taiKhoanCongDanId,String tenDayDu, ActionRequest request
	  * @return boolean
	  */
	
	public boolean insertCongDan(Map<String, String> userRequest, long taiKhoanCongDanId,String tenDayDu, ActionRequest request) throws PortalException, SystemException {
		

		CongDan congDan = new CongDanImpl();
		
		try{
			long id = CounterLocalServiceUtil.increment(EndorsementBs.CITIZEN_SEQUENCE);
			_log.info("congDan Info truoc:"+ id);
			
			_log.info("idTk"+id);	
			congDan.setId(id);
			congDan.setHo(userRequest.get("ho"));		
			congDan.setDem(userRequest.get("dem"));
			congDan.setTen(userRequest.get("ten"));
			congDan.setEmail(userRequest.get("email"));
			congDan.setTenDayDu(tenDayDu);
			congDan.setTaiKhoanNguoiDungId(taiKhoanCongDanId);
			
			
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			Date birthDate = null;
			df.setLenient(false);
			try {
				birthDate = df.parse(userRequest.get("ngaySinh"));
			} catch (Exception e) {
				// Error never happen so this exception will be swallow
			}
			congDan.setNgaySinh(birthDate);					
			congDan.setQuocTichId(Long.parseLong(userRequest.get("quocTichId")));
			congDan.setSoCmnd(userRequest.get("soCmnd"));	
			congDan.setNoiCapCmndId(Long.parseLong(userRequest.get("noiCapCmndId")));
			
			if (Validator.isNotNull(userRequest.get("ngayCapCmnd"))) {
				Date ngayCapCmnd = null;
				try {
					ngayCapCmnd = df.parse(userRequest.get("ngayCapCmnd"));
				} catch (Exception e) {
					// Error 
				}
				
				congDan.setNgayCapCmnd(ngayCapCmnd);
			}
			
			congDan.setGioiTinh(Integer.parseInt(userRequest.get("gioiTinh")));
			congDan.setDanTocId(Long.parseLong(userRequest.get("danTocId")));
			congDan.setTonGiaoId(Long.parseLong(userRequest.get("tonGiaoId")));			
			congDan.setDiaChiThuongTruTinhId(Long.parseLong(userRequest.get("diaChiThuongTruTinhId")));
			congDan.setDiaChiThuongTruHuyenId(Long.parseLong(userRequest.get("diaChiThuongTruHuyenId")));
			congDan.setDiaChiThuongTruXaId(Long.parseLong(userRequest.get("diaChiThuongTruXaId")));
			congDan.setDiaChiThuongTru(userRequest.get("diaChiThuongTru"));	
			
			congDan.setMa(ElectricCodeGeneratorUtil.generateCode(congDan.getDiaChiThuongTruTinhId(),birthDate));
		
			Date currentDate1 = new Date();
			
			congDan.setNgayTao(currentDate1);
			
			congDan.setNgaySua(currentDate1);
			
			User currentUser1 = PortalUtil.getUser(request);
					
			congDan.setNguoiTao(currentUser1.getEmailAddress());
			congDan.setNguoiSua(currentUser1.getEmailAddress());		
			
			congDan.setDaXoa(FormatUtil.DA_XOA_ACTIVATE);	
			
			_log.info("congDan Info sau:"+ congDan.toString());
			CongDanLocalServiceUtil.addCongDan(congDan);	
			return true;
			
			}catch (Exception e) {
				e.printStackTrace();
				_log.error("--------------------------insert-----------------"+e.toString());
				
				// TODO: handle exception
			}
		return false;
	}
			
	
	/**
	  * This is fucntion insertTaiKhoanNguoiDung
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param User liferayUser,String matKhau,String email,String tenDayDu, ActionRequest request
	  * @return TaiKhoanNguoiDung
	  */
	public TaiKhoanNguoiDung insertTaiKhoanNguoiDung( User liferayUser,String matKhau,String email,String tenDayDu, ActionRequest request) throws PortalException, SystemException {		
			 
		TaiKhoanNguoiDung taiKhoanNguoiDung = new TaiKhoanNguoiDungImpl();
		User userLogin  = PortalUtil.getUser(request);
		try{
			
			long id = CounterLocalServiceUtil.increment(TAIKHOANNGUOIDUNG_SEQUENCE);
			taiKhoanNguoiDung.setId(id);
			taiKhoanNguoiDung.setLoaiDoiTuongId(Long.valueOf(Constants.CONG_DAN));
			taiKhoanNguoiDung.setTenDangNhap(email);
			taiKhoanNguoiDung.setMatKhau( MD5( matKhau));
			taiKhoanNguoiDung.setTenNguoiDung(tenDayDu);
			taiKhoanNguoiDung.setEmail(email);
			taiKhoanNguoiDung.setTaiKhoanNguoiDungId(liferayUser.getUserId());	
			taiKhoanNguoiDung.setNguoiTao(userLogin.getEmailAddress());
			taiKhoanNguoiDung.setNguoiSua(userLogin.getEmailAddress());			
			taiKhoanNguoiDung.setNgayTao(new Date());
			taiKhoanNguoiDung.setNgaySua(new Date());				
			taiKhoanNguoiDung.setDaXoa(FormatUtil.DA_XOA_ACTIVATE);
	
			TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(taiKhoanNguoiDung);
			
			return taiKhoanNguoiDung;
	
			} catch (Exception e) {				
				_log.error("TaiKhoanNguoiDung:"+ e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
		
		return null;
	
	}
	
	
	/**
	  * This is fucntion encrypt MD5
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return String
	  */
	public String MD5(String md5) {
	   try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}

	
	/**
	  * This is fucntion editCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Map<String, String> userRequest, String congDanId,String taiKhoanNguoiDungId,String tenDayDu, ActionRequest request
	  * @return void
	  */
	public void editCongDan(Map<String, String> userRequest, String congDanId,String taiKhoanNguoiDungId,String tenDayDu, ActionRequest request) throws PortalException, SystemException {
		// Get ma co quan quan ly		
		try{
			
			CongDan congDan = CongDanLocalServiceUtil.getCongDan(FormatUtil.convertToLong(userRequest.get("congDanId")));		
			congDan.setId(FormatUtil.convertToLong(userRequest.get("congDanId")));
			congDan.setEmail(userRequest.get("email"));
			congDan.setHo(userRequest.get("ho"));		
			congDan.setDem(userRequest.get("dem"));
			congDan.setTen(userRequest.get("ten"));		
			congDan.setTenDayDu(tenDayDu);		
			congDan.setNgaySinh(FormatUtil.parseStringToDate(userRequest.get("ngaySinh")));
			congDan.setSoCmnd(userRequest.get("soCmnd"));
			congDan.setNgayCapCmnd(FormatUtil.parseStringToDate(userRequest.get("ngayCapCmnd")));
			congDan.setNoiCapCmndId(Long.parseLong(userRequest.get("noiCapCmndId")));
			congDan.setQuocTichId(Long.parseLong(userRequest.get("quocTichId")));
			congDan.setGioiTinh(FormatUtil.convertToInt(userRequest.get("gioiTinh")));
			congDan.setDanTocId(FormatUtil.convertToLong(userRequest.get("danTocId")));
			congDan.setTonGiaoId(FormatUtil.convertToLong(userRequest.get("tonGiaoId")));
		
			congDan.setDiaChiThuongTruTinhId(Long.parseLong(userRequest.get("diaChiThuongTruTinhId")));
			congDan.setDiaChiThuongTruHuyenId(Long.parseLong(userRequest.get("diaChiThuongTruHuyenId")));
			congDan.setDiaChiThuongTruXaId(Long.parseLong(userRequest.get("diaChiThuongTruXaId")));
			congDan.setDiaChiThuongTru(userRequest.get("diaChiThuongTru"));
			congDan.setTaiKhoanNguoiDungId(FormatUtil.convertToLong(taiKhoanNguoiDungId));
			
			//truyen ma id cong dan va tai khoan cong dan chua lam
			Date currentDate = new Date();
			
			congDan.setNgaySua(currentDate);
			
			User currentUser = PortalUtil.getUser(request);
			
			if ( currentUser != null) {		
				congDan.setNguoiSua(currentUser.getEmailAddress());			
			}
			CongDanLocalServiceUtil.updateCongDan(congDan, true);	
			
		}catch (Exception e) {
			// TODO: handle exception
			_log.error("editcongdan,,,,,,,,,,,,,,,"+ e.toString());
		}
	}
	
	/**
	  * This is fucntion editTaiKhoanNguoiDung
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Map<String, String> userRequest, String taiKhoanNguoiDungId, String tenDayDu, ActionRequest request
	  * @return void
	  */
	public void editTaiKhoanNguoiDung(Map<String, String> userRequest, String taiKhoanNguoiDungId, String tenDayDu, ActionRequest request)
			throws PortalException, SystemException {
		
		try{
			_log.info("taiKhoangCongDanId :"+ taiKhoanNguoiDungId);
			TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(FormatUtil.convertToLong(taiKhoanNguoiDungId));		
			_log.info("TaiKhoanNguoiDung Info truoc:"+ taiKhoanNguoiDung);
				taiKhoanNguoiDung.setId(Long.parseLong(taiKhoanNguoiDungId));	
				taiKhoanNguoiDung.setEmail(userRequest.get("email"));
				taiKhoanNguoiDung.setTenDangNhap(userRequest.get("email"));			
				taiKhoanNguoiDung.setTenNguoiDung(tenDayDu);
				
				if (userRequest.get("matKhau").trim().length() >0){
					taiKhoanNguoiDung.setMatKhau(MD5( userRequest.get("matKhau")));
				}
				
				taiKhoanNguoiDung.setTaiKhoanNguoiDungId(FormatUtil.convertToLong(taiKhoanNguoiDungId));
				//truyen ma id cong dan va tai khoan cong dan chua lam
				Date currentDate1 = new Date();
				
				taiKhoanNguoiDung.setNgaySua(currentDate1);
				
				User currentUser1 = PortalUtil.getUser(request);
				
				if ( currentUser1 != null) {		
					taiKhoanNguoiDung.setNguoiSua(currentUser1.getFullName());			
				}
				_log.info("TaiKhoanNguoiDung Info sau:"+ taiKhoanNguoiDung);
				TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(taiKhoanNguoiDung, true);	
			}catch (Exception e) {
				// TODO: handle exception
				_log.error("editTaiKhoanNguoiDung,,,,,,,,,,,,,,,"+ e.toString());
			}
		}
	
	
	
	
	/**
	  * This is fucntion congdanExists
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String soCmnd, String ngaySinh
	  * @return String
	  */
	public  String congdanExists(String soCmnd, String ngaySinh) throws ParseException{
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		Date birthDay = ConvertUtil.parseStringToDate(ngaySinh);
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results == null ||  results.size() < 1) {
			return StringPool.BLANK;
		}
		
		// Return the id
		return (results.get(0)).getMa();
	}
	
	/**
	  * This is fucntion checkSelectedValue
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String value1, String value2
	  * @return String
	  */	
	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	
}

