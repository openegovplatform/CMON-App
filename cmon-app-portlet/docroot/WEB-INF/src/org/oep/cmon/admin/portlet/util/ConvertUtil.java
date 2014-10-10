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

package org.oep.cmon.admin.portlet.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.servlet.jsp.PageContext;

import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.ChucVuClp;
import org.oep.cmon.dao.cc.model.CongChuc;

import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLyClp;

import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * This is class ConvertUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ConvertUtil {

	static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	static IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
	
	/**
	 * This is function get list all TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param pageContext
	 * @param trangThaiHoSo
	 * @return List<TrangThaiHoSo>
	 */
	public static List<TrangThaiHoSo> getListTrangThaiAll(PageContext pageContext, List<Long> trangThaiHoSo) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TrangThaiHoSo.class);
			if (trangThaiHoSo.size() > 0) {
				Criterion criteriaNotIn = RestrictionsFactoryUtil.in("id", trangThaiHoSo.toArray());
				Criterion criteria = RestrictionsFactoryUtil.not(criteriaNotIn);
				query = query.add(criteria);
			}
				
			return TrangThaiHoSoLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return new ArrayList<TrangThaiHoSo>();
	}
	
	/**
	 * This is function parse date to string 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */
	public static String parseDateToTring(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	/**
	 * This is function check selected value
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return String
	 */
	public static String checkSelectedValue(String value1, long value2) {
		if ((ConvertUtil.convertToLong(value1) == value2) && (value1 != null)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	/**
	 * This is function parse string to date
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param data
	 * @return Date
	 */
	public static Date parseStringToDate(String data) {
		try {
			return formatDateShort.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	
	/**
	 * This is function get value from render request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param key
	 * @param renderRequest
	 * @return String
	 */
	public static String getValueFromRenderRequest(String key,RenderRequest renderRequest) {
		try {
			return renderRequest.getParameter(key).trim();
		} catch (Exception es) {
		}
		return "";
	}

	/**
	 * This is function get value from render request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param key
	 * @param renderRequest
	 * @return String
	 */
	public static String getTenDonViHanhChinh(long id) {
		try {
			return DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(id).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TaiLieuChungThuc from NoiLuuTruTaiLieuId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fileDinhKem
	 * @return TaiLieuChungThuc
	 */
	public static TaiLieuChungThuc getTaiLieuChungThucFromNoiLuuTruTaiLieuId(FileDinhKem fileDinhKem) {
		try {
			return TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(fileDinhKem.getNoiLuuTruTaiLieuId());
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * This is function get URL from NoiLuuTruId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param noiLuuTruId
	 * @return String
	 */
	public static String getURLFromNoiLuuTruId(long noiLuuTruId) {
		try {
			return iDocumentStorage.getURLById(noiLuuTruId);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * This is function get TenCanBo by HoSoTTHCCong
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param instance
	 * @return String
	 */
	public static String getTenCanBo(HoSoTTHCCong instance) {
		try {
			return CongChucLocalServiceUtil.fetchCongChuc(instance.getCanBoXuLyHienThoiId()).getHoVaTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TenCanBo by TaiKhoanNguoiDungId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param taiKhoanNguoiDungId
	 * @return String
	 */
	public static String getTenCanBo(long taiKhoanNguoiDungId) {
		try {
			return CongChucLocalServiceUtil.fetchCongChuc(taiKhoanNguoiDungId).getHoVaTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TenThuTucHanhChinh by ThuTucHanhChinhId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @return String
	 */
	public static String getTenThuTucHanhChinh(String thuTucHanhChinhId) {
		try {
			return ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(convertToLong(thuTucHanhChinhId)).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TenCoQuanQuanLy by CoQuanQuanLyId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param cqqlId
	 * @return String
	 */
	public static String getTenCoQuanQuanLy(long cqqlId) {
		try {
			return CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(cqqlId).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TenCongDan by Id
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return String
	 */
	public static String getTenCongDan(CongDan congDan) {
		try {
			return congDan.getTenDayDu();
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * This is function get TenCongDan by Id
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return String
	 */
	public static String getTenCongDan(long id) {
		try {
			return CongDanLocalServiceUtil.fetchCongDan(id).getTenDayDu();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get CMNDCongDan by CongDan
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDan
	 * @return String
	 */
	public static String getCMNDCongDan(CongDan congDan) {
		try {
			return congDan.getSoCmnd();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TelephoneCongDan
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congdan
	 * @param telephone
	 * @return String
	 */
	public static String getTelphoneCongDan(CongDan congDan, String telephone) {
		try {
			if (telephone == null) {
				return congDan.getDienThoaiDiDong();
			}
			return telephone;
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get CapCoQuanQuanLy by capCoQuanQuanLyId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param capCoQuanQuanLyID
	 * @return CapCoQuanQuanLy
	 */

	public static CapCoQuanQuanLy getCapCoQuanQuanLy(long capCoQuanQuanLyID) {
		try {
			return CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(capCoQuanQuanLyID);
		} catch (Exception e) {
			try {
				return CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(capCoQuanQuanLyID);
			} catch (Exception e1) {
			}
		}
		return new CapCoQuanQuanLyClp();
	}
	
	/**
	 * This is function get TaiKhoanNguoiDung by UserId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userID
	 * @return TaiKhoanNguoiDung
	 */
	public static TaiKhoanNguoiDung findTaiKhoanNguoiDungByUserID(long userID) {
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		if (userID > 0 ){
			
			//congChucs=CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
			List<TaiKhoanNguoiDung> taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDung(userID, 0);
		 	if(taiKhoanNguoiDungs.size() > 0 ){
		 		taiKhoanNguoiDung = taiKhoanNguoiDungs.get(0);
		   	}
		}

		return taiKhoanNguoiDung;
	}
	
	/**
	 * This is function get ChucVu by TaiKhoanNguoiDungId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param taiKhoanNguoiDungId
	 * @param cqqlId
	 * @return ChucVu
	 */
	public static ChucVu findChucVuByTaiKhoanNguoiDungID(long taiKhoanNguoiDungId, long cqqlId) {
		ChucVu chucVu = null;
		if (taiKhoanNguoiDungId > 0 ){
			try {
				List<CongChuc> liChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId); 
				CongChuc congChuc = null;
				for (CongChuc _congChuc : liChucs) {
					if (_congChuc.getCoQuanQuanLyId() == cqqlId) {
						congChuc = _congChuc;
						break;
					}
				}
			 	if(liChucs.size() > 0 && congChuc == null){
			 		congChuc = liChucs.get(0);
			   	}
			 	chucVu = ChucVuLocalServiceUtil.fetchChucVu(congChuc.getChucVuId());
			} catch (Exception es) {
				es.printStackTrace();
			}
		}

		return chucVu;
	}
	
	/**
	 * This is function get ChucVu by ChucVuId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ChucVuId
	 * @return ChucVu
	 */
	public static ChucVu findChucVuByID(long chucVuId) {
		if (chucVuId > 0 ){
			try {
			 	return ChucVuLocalServiceUtil.fetchChucVu(chucVuId);
			} catch (Exception es) {
			}
		}

		return new ChucVuClp();
	}

	/**
	 * This is function get NgayHenTraHoSo by ThuTucHanhChinhId
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @return Date
	 */
	public static String getNgayHenTraHoSo(String thuTucHanhChinhId) {
		try {
			ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(convertToLong(thuTucHanhChinhId));
			return parseDateToTring(getNgayHenTraHoSo(new Date(), thuTucHanhChinh.getSoNgayXuLy()));
		} catch (Exception e) {
		}
		return parseDateToTring(new Date());
	}
	
	/**
	 * This is function get NgayHenTraHoSo by date or number of day
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param baseDate
	 * @param numberOfDays
	 * @return Date
	 */
	private static Date getNgayHenTraHoSo(Date baseDate, long numberOfDays) {
		if(baseDate == null){
	        baseDate = new Date();
	    }

	    Calendar baseDateCal = Calendar.getInstance();
	    baseDateCal.setTime(baseDate);

	    for(int i = 0; i < numberOfDays; i++){

	        baseDateCal.add(Calendar.DATE,1);
	        if(baseDateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
	           baseDateCal.add(Calendar.DATE,2);
	        }
	        if(baseDateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
		           baseDateCal.add(Calendar.DATE,1);
		    }
	    }
	    return baseDateCal.getTime();
	}
	
	/**
	 * This is function get NgaySinhCongDan
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDan
	 * @return String
	 */
	public static String getNgaySinhCongDan(CongDan congDan) {
		try {
			return parseDateToTring(congDan.getNgaySinh());
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get DiaChiThuongTruCongDan
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDan
	 * @return String
	 */
	public static String getDiaChiThuongTruCongDan(CongDan congDan) {
		StringBuilder result = new StringBuilder();
		try {
			result.append(congDan.getDiaChiThuongTru()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(congDan.getDiaChiThuongTruXaId()).getTen()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(congDan.getDiaChiThuongTruHuyenId()).getTen()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(congDan.getDiaChiThuongTruTinhId()).getTen());
			
		} catch (Exception e) {
		}
		return result.toString();
	}
	
	/**
	 * This is function get TrangThaiHoSo
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return String
	 */
	public static String getTrangThaiHoSo(long id) {
		try {
			return TrangThaiHoSoLocalServiceUtil.findById(id).getTrangThai();
//			for (TrangThaiHoSo trangThaiHoSo : listTrangThaiHoSo) {
//				if (trangThaiHoSo.getId() == id) {
//					return trangThaiHoSo.getTrangThai();
//				}
//			}
		} catch (Exception e) {
		}
		return "";
	}
//	
//	public static List<FileUpload> getTaiLieuDinhKem(long hoSoTTHCCongId) {
//		List<FileUpload> result = new ArrayList<FileUpload>();
//		try {
//			// Bien cho truong hop tai lieu chung thuc.
//			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
//		    BigDecimal taiLieuChungThucId = null;
//		    String url = "";
//		    FileUpload fileUpload = null;
//			List listDinhKems = FileDinhKemLocalServiceUtil.findByHoSoTTHCCongId(hoSoTTHCCongId);
//			for (int i = 0; i < listDinhKems.size(); i++) {
//				taiLieuChungThucId = (BigDecimal)listDinhKems.get(i);
//				TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(taiLieuChungThucId.longValue());
//				if (taiLieuChungThuc != null) {
//					url = iDocumentStorage.getURLById(taiLieuChungThuc.getNoiLuuTruId());
//					fileUpload = new FileUploadImpl();
//					fileUpload.setFileId(taiLieuChungThuc.getNoiLuuTruId());
//					fileUpload.setUrl(url);
//					fileUpload.setTenFileUpload(taiLieuChungThuc.getTen());	
//					
//					result.add(fileUpload);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
//	public static List<FileUpload> getTaiLieuDinhKemByGiaiDoan(long hoSoTTHCCongId, int giaiDoan) {
//		List<FileUpload> result = new ArrayList<FileUpload>();
//		try {
//			// Bien cho truong hop tai lieu chung thuc.
//			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
//		    BigDecimal taiLieuChungThucId = null;
//		    String url = "";
//		    FileUpload fileUpload = null;
//			List listDinhKems = FileDinhKemLocalServiceUtil.findFileUploadByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId, giaiDoan);
//			for (int i = 0; i < listDinhKems.size(); i++) {
//				taiLieuChungThucId = (BigDecimal)listDinhKems.get(i);
//				TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(taiLieuChungThucId.longValue());
//				if (taiLieuChungThuc != null) {
//					url = iDocumentStorage.getURLById(taiLieuChungThuc.getNoiLuuTruId());
//					fileUpload = new FileUploadImpl();
//					fileUpload.setFileId(taiLieuChungThuc.getNoiLuuTruId());
//					fileUpload.setUrl(url);
//					fileUpload.setTenFileUpload(taiLieuChungThuc.getTen());	
//					fileUpload.setHosotthcCongId(hoSoTTHCCongId);
//					fileUpload.setId(taiLieuChungThucId.longValue());
//					
//					result.add(fileUpload);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	/**
	 * This is function convert from String to Long
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return
	 */
	public static long convertToLong(String value) {
		try {
			return Long.parseLong(value.trim());
		} catch (Exception es) {
		}

		return 0;
	}
	
	/**
	 * This is function convert from String to Int
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return
	 */
	public static int convertToInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception es) {
		}

		return 0;
	}
	
	public static VaiTro getVaiTroById(long vaiTroId) {
		try {
			return VaiTroLocalServiceUtil.fetchVaiTro(vaiTroId);
		} catch (Exception e) {
			try {
				return VaiTroLocalServiceUtil.fetchVaiTro(vaiTroId);
			} catch (Exception e1) {
			}
		}
		return null;
	}
	
	/**
	 * This is function check Two Array
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dataInsert
	 * @param dataThemMoi
	 * @return String[]
	 */
	public static String[] checkTwoArray(String[] dataInsert, String[] dataThemMoi) {
		List<String> reList = new ArrayList<String>();
		if (dataInsert.length == 0) {
			return dataThemMoi;
		}
		boolean flag = true;
		for (String data : dataThemMoi) {
			for (String _data : dataInsert) {
				if (data.compareTo(_data) == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				reList.add(data);
			}
			flag = true;
		}
		String[] dataReturn = new String[reList.size()];
		for (int i = 0; i< reList.size(); i++) {
			String _data = reList.get(i);
			if (_data.trim().length() > 0) {
				dataReturn[i] = _data;
			}
		}
		return dataReturn;
	}
}
