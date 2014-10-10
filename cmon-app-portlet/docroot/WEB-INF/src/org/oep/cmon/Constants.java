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

package org.oep.cmon;

import com.liferay.portal.kernel.util.GetterUtil;

import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

/** 
 * This is class Constants
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class Constants {

	public static final int LOAI_HO_SO_TRUC_TUYEN = 0;
	public static final int LOAI_HO_SO_TRUC_TIEP = 1;
	
	public static final String JSP_DANH_SACH_HO_SO_MOT_CUA = "/html/portlet/ipmslistportlet/danhSachHoSoMotCua.jsp";
	public static final String JSP_DANH_SACH_HO_SO_XU_LY = "/html/portlet/ipmslistportlet/danhSachHoSoXuLy.jsp";
	
	public static final String DATE_FORMAT="dd/MM/yyyy";
	public static final int ACTIVE = 0;
	public static final int INACTIVE = 1;// Da xoa
	public static final String TS_CONG_DAN = "LDT_CONGDAN";
	public static final String UPLOAD_OK ="OK";
	public static final String CONGVAN_TRALOI_KHONGDUKD ="GT_CONGVANTRALOIKHONGDUDK";
	public static final String MA_QUOC_GIA = "CMON_QUOCGIA";//default Quoc gia
	public static final String DEFAULT_PORTLET_NAME = "ipmslistportlet_WAR_cmonappportlet";
	public static final String MENU_PORTLET_NAME = "cmon_menuportlet_WAR_cmonappportlet";
	
	public static final long VIETNAM = 1;// Da xoa
	
	public static final int TINHTRANG_SONG = 1; // Cong dan con song
	public static final int TINHTRANG_MAT = 0; // Cong dan da mat
	
	public static final long DEFAULT_DVHC_ID = GetterUtil.getLong(ThamSoLocalServiceUtil.getValue("DANANG"));
	
	public static final String TEN_THAMSO_MA_UNG_DUNG_CONG_AN = "CONGAN";
	public static final String TEN_THAMSO_MA_UNG_DUNG_CHUNG_THUC = "CTMS";
	
	public static final long LDT_CONGDAN = GetterUtil.getLong(ThamSoLocalServiceUtil.getValue("LDT_CONGDAN"));
	public static final long LDT_CANBO = GetterUtil.getLong(ThamSoLocalServiceUtil.getValue("LDT_CANBO"));
	
	//DN
	public static final long LDT_DOANHNGHIEP = GetterUtil.getLong(ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP"));
	public static final long LDT_HOKDCATHE = GetterUtil.getLong(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE"));
	public static final long LDT_HOPTACXA = GetterUtil.getLong(ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA"));
	
	public static interface PHASE_PROCESS_HOSO
	{
		public static final int PHASE_MOT =1;
		public static final int PHASE_HAI =2;
		public static final int PHASE_BA =3;
	}
	
	public static interface LOAI_CAN_BO
	{
		public static final String LOAI_MOT_CUA ="1";
		public static final String LOAI_CAN_BO_XU_LY ="2";
	}
	
	public static interface QuiTrinh {
		public static final String QUITRINH_PARAMS ="quiTrinhParams";
		public static final int CHUNG_THUC = 1;
		public static final int HO_SO_CHUNG_THUC = 2;
		public static final int SO_CHUNG_THUC = 3;
	}
	
	public static interface LOAI_Y_KIEN_TRAO_DOI
	{
		public static final long LOAI_YEU_CAU_BO_XUNG_HO_SO =2;
		public static final long LOAI_DUNG_XU_LY_HO_SO =4;
		public static final long RUT_HO_SO = 1;
		public static final long TU_CHOI_HO_SO = 3;
		public static final long BINH_THUONG = 0;
	}
	
	public static interface PATH_TRA_KET_QUA
	{
		public static final String PATH_TRA_KET_QUA ="/html/portlet/ipmslistportlet/offline/traKetQua.jsp";
		public static final String PATH_AFTER_TRA_KET_QUA ="/html/portlet/ipmslistportlet/view.jsp";
		public static final String PATH_QUAY_LAI ="/html/portlet/ipmslistportlet/view.jsp";
	}
	
	public static interface SESSION_KEY
	{
		public static String KEY_TRAKETQUA ="SESSION_KEY_TRAKETQUA";
	}
	public static interface TRANGTHAIHOSO {
		public static String  TT_DATRAKETQUA ="TT_DATRAKETQUA" ;
		public static int STATUS_HOSO_DA_TRA_KET_QUA =5;
		public static int DA_TRA_KET_QUA =1;
		public static int BANG_CHINH =1;
		public static long LA_BANG_CHINH =1L;
		//Store status hồ sơ
		public static int HO_SO_KHONG_XU_LY_DUOC = 8;
		public static int HO_SO_MOI_DANG_KY_TRUC_TUYEN =0;
		public static int HO_SO_DA_TIEP_NHAN =1;//Status : Ho so chuyen phong chuyen mon
		public static int HO_SO_CHO_BO_XUNG =3;
		public static int HO_SO_DA_TRA_KET_QUA =5;
		public static int HO_SO_DA_XU_LY_XONG =6;
		public static int HO_SO_DANG_XU_LY =15;
		public static int HO_SO_KHONG_TIEP_NHAN =16;
		public static int HO_SO_DA_BO_XUNG_CHO_TN =17;
		public static int HO_SO_DA_RUT =18;
		public static int CHO_THUC_HIEN_LIEN_THONG = 12;
		public static int DA_NHAN_KQ_LIEN_THONG = GetterUtil.getInteger(ThamSoLocalServiceUtil.getValue("TT_DANHANKQLIENTHONG"));
	}
	public static interface NUMBER_CONSTANT
	{
		public static String VALUE_KHONG ="0";
		public static String VALUE_MOT ="1";
	}
	
	
	public static interface FileDinhKem {
		public static final int chuaDoiChieu=0;
		public static final int doiChieuKhop=1;
		public static final int doiChieuKhongKhop=2;
	}
	
	public static interface Paging {
		public static int DELTA = 10;
		
	}
	public static interface TaiNguyen {
		public static final int TrangThai_Khoa = 0;
		public static final int TrangThai_HoatDong = 1;
		public static final String TT_Khoa = "0";
		public static final String TT_HoatDong = "1";
		public static final int Loai_Page = 1;//Trang cua liferay
		public static final int Loai_Portlet = 2;//Portlet cua liferay
		public static final int Loai_Function = 3;//Chuc nang cua liferay
		public static final String L_Page = "1";//Trang cua liferay
		public static final String L_Portlet = "2";//Portlet cua liferay
		public static final String L_Function = "3";//Chuc nang cua liferay
	}
	public static interface Citizen {
		public static final int TrangThai_Moi=0;
		public static final int TrangThai_ChungThuc=1;
		public static final int TrangThai_TuChoi=-1;
		public static final int TrangThai_XoaTam=-2;
		public static final int TrangThai_KQDVC=2;
		
	}
	public static interface VaiTro {
		public static final int TrangThai_Khoa = 0;
		public static final int TrangThai_HoatDong = 1;
	}
	
	public static final String CONG_DAN ="1";
	public static final String CAN_BO ="2";
	
	public static final long CONG_DAN_NOP_HS =1;
	public static final long CAN_BO_XU_LY_HS =2;
	
	// Trang thai ho so
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW = 0;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED = 1;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_HUY = 16;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_RUT_HS = 18;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_TU_CHOI = 16;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG = 3;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_DA_XU_LY_XONG = 6;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_DA_BS_CHO_XU_LY = 17;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_DA_TRA_KET_QUA = 5;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY = 15;
		public static final int YEU_CAU_HUY_HO_SO = 1;
		public static final int HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN = 19;
		
		public static final String TIEPNHAN = "TIEPNHAN";
		public static final String ACTION = "action";
		public static final String HO_SO_HANH_CHINH_CONG_ID = "HO_SO_HANH_CHINH_CONG_ID";
		public static final int GIAIDOAN_GIAYTO_DAUVAO = 1;
		public static final int GIAIDOAN_DANGXULY = 2;

	public static class ThongTinThanhToan {
		public static final int PHI = 1;
		public static final int LE_PHI = 2;
		public static final int HINHTHUC_TIENMAT = 1;
		public static final int HINHTHUC_CHUYENKHOAN = 2;
		public static final int HINHTHUC_TRUCTUYEN = 3;
		public static final String THONG_TIN_THANH_TOAN_PREF_PARAM = "thongTinThanhToanPref";
	}

	public static class QuanLiHoSo {
		public static final String HSTTHCC_CURRENT_STATUS_PREF_PARAM = "currentStatusPref";
		public static final byte TYPE_HOSO_ONLINE = 0;
		public static final byte TYPE_HOSO_OFFLINE = 1;
		public static final String YEU_CAU_RUT = "yeuCauRut";
	}
	
	public static class XuLyHoSo {
		public static final String PROCESSING_PROFILE_PREF_PARAM = "processingProfilePref";
		public static final String OTHER_VALUE = "other";
		public static final String PROCESSING_PROFILE_VALUE = "processingProfile";
	}
	public static class CanBoXuLy {
		public static final String PROCESSING_CAN_BO_PREF_PARAM = "processingCanBoPref";
		public static final String PROCESSING_LANH_DAO = "1";
		public static final String PROCESSING_CAN_BO_VALUE = "2";
		public static final String LANH_DAO = "1";
		public static final String NHAN_VIEN = "2";
	}
	public static interface ThamSo{
		public static final String CMON_DOCUMENT_FOLDER_ID="CMON_DOCUMENT_FOLDER_ID";
		public static final String CMON_DOCUMENT_USER_ADMIN_ID="CMON_DOCUMENT_USER_ADMIN_ID";
		public static final String DOMAIN="DOMAIN";
	}
	
	public static interface ChungThuc {
		public static final String NAME = "hosochungthuc";
		public static final String SO_DANH_MUC_NAME = "sodanhmuc";
	}
	
	public static interface TaoCongDan {
		public static final int CO_TAI_KHOAN = 1;
		public static final int CHUA_CO_TAI_KHOAN = 0;//null
	}
	public static interface TaoDoanhNghiep {
		int TEN_LENGTH = 200;
		int MA_MINLENGTH = 6;
		int MA_MAXLENGTH = 12;
		int SOGP_MINLENGTH = 6;
		int SOGP_MAXLENGTH = 12;
		int CMND_MINLENGTH = 8;
		int CMND_MAXLENGTH = 12;
	}
}
