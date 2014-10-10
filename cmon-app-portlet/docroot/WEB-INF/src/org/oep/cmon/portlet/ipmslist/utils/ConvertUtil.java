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

package org.oep.cmon.portlet.ipmslist.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.portlet.ipmslist.business.FileKetQua;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.model.DoanhNghiepClp;
import org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.FileDinhKemClp;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

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
	 * This is function parseDateToTring
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
	 * This is function checkSelectedValue
	 * Generate "selected" or "" for marking a HTML option as selected
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
	 * This is function checkLoaiDoiTuongCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @param ma
	 * @return boolean
	 */
	public static boolean checkLoaiDoiTuongCongDan(long thuTucHanhChinhId, String ma) {
		try {
			List<TTHC2DoiTuongSuDung> list = TTHC2DoiTuongSuDungLocalServiceUtil.getDSTTHC2DoiTuongSuDungBoiTTHC(thuTucHanhChinhId);
			if (list != null && list.size() > 0) {
				DoiTuongSuDung doiTuongSuDung = DoiTuongSuDungLocalServiceUtil.getDoiTuongSuDung(list.get(0).getLoaiDoiTuongId());
				if (doiTuongSuDung.getMa().trim().toLowerCase().compareTo(ma.trim().toLowerCase()) == 0) {
					return true;
				}
			}
		} catch (Exception es) {
		}
		return false;
	}
	
	/**
	 * This is function parseStringToDate
	 * Convert String (dd/MM/yyyy) to Date
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
	 * This is function getValueFromRenderRequest
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
	 * This is function getTenDonViHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
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
	 * This is function getTenCanBo
	 * Version: 1.0
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
	 * This is function getTenCanBo
	 * Version: 1.0
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
	 * This is function getTenThuTucHanhChinh
	 * Version: 1.0
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
	 * This is function getTenCoQuanQuanLy
	 * Version: 1.0
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
	 * This is function getValueString
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resHttpServletRequest
	 * @param key
	 * @return String
	 */
	public static String getValueString(HttpServletRequest resHttpServletRequest, String key) {
		try {
			if (resHttpServletRequest.getAttribute(key) != null) {
				return resHttpServletRequest.getAttribute(key).toString().trim();
			}
		} catch (Exception es) {
		}

		return "";
	}
	
	/**
	 * This is function getTenCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDan
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
	 * This is function getTenCongDan
	 * Version: 1.0
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
			try {
				return CongDanLocalServiceUtil.fetchCongDan(id).getTenDayDu();
			} catch (Exception e1) {
			}
		}
		return "";
	}
	
	/**
	 * This is function findCongDanById
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return CongDan
	 */
	public static CongDan findCongDanById(long id) {
		try {
			return CongDanLocalServiceUtil.fetchCongDan(id);
		} catch (Exception e) {
			try {
				return CongDanLocalServiceUtil.fetchCongDan(id);
			} catch (Exception e1) {
			}
		}
		return new CongDanClp();
	}
	
	/**
	 * This is function findDoanhNghiepById
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return DoanhNghiep
	 */
	public static DoanhNghiep findDoanhNghiepById(long id) {
		try {
			return DoanhNghiepLocalServiceUtil.fetchDoanhNghiep(id);
		} catch (Exception e) {
			try {
				return DoanhNghiepLocalServiceUtil.fetchDoanhNghiep(id);
			} catch (Exception e1) {
			}
		}
		return new DoanhNghiepClp();
	}
	
	/**
	 * This is function getCMNDCongDan
	 * Version: 1.0
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
	 * This is function getTelphoneCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDan
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
	 * This is function getTelphoneDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param doangNghiep
	 * @param telephone
	 * @return String
	 */
	public static String getTelphoneDoanhNghiep(DoanhNghiep doangNghiep, String telephone) {
		try {
			if (telephone == null) {
				return doangNghiep.getDienThoaiDoanhNghiep();
			}
			return telephone;
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function findTaiKhoanNguoiDungByUserID
	 * Version: 1.0
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
			
			List<TaiKhoanNguoiDung> taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDung(userID, 0);
			
		 	if(taiKhoanNguoiDungs.size() > 0 ){
		 		taiKhoanNguoiDung = taiKhoanNguoiDungs.get(0);
		   	}
		}
		return taiKhoanNguoiDung;
	}
	
	/**
	 * This is function findChucVuByTaiKhoanNguoiDungID
	 * Version: 1.0
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
	 * This is function getNgayHenTraHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @return String
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
	 * This is function getNgayHenTraHoSo
	 * Get ngayHenTraHoS, lay ngay nhan ho so cong cho so ngay xu ly (khong tinh thu bay hoac chu nhat)
	 * Version: 1.0
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
	 * This is function getNgaySinhCongDan
	 * Version: 1.0
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
	 * This is function getTaiLieuChungThucFromNoiLuuTruTaiLieuId
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
			try {
				return TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(fileDinhKem.getNoiLuuTruTaiLieuId());
			} catch (Exception e1) {
			}
		}
		return null;
	}
	
	/**
	 * This is function getURLFromNoiLuuTruId
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
	 * This is function getDiaChiThuongTruCongDan
	 * Version: 1.0
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
	 * This is function getDiaChiDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param doanhNghiep
	 * @return String
	 */
	public static String getDiaChiDoanhNghiep(DoanhNghiep doanhNghiep) {
		StringBuilder result = new StringBuilder();
		try {
			result.append(doanhNghiep.getDiaChiDoanhNghiep()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(doanhNghiep.getDiaChiDoanhNghiepXaId()).getTen()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(doanhNghiep.getDiaChiDoanhNghiepHuyenId()).getTen()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(doanhNghiep.getDiaChiDoanhNghiepTinhId()).getTen());
		} catch (Exception e) {
		}
		return result.toString();
	}
	
	/**
	 * This is function getTrangThaiHoSo
	 * Version: 1.0
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
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function convertFromObjectToFileDinhKem
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param listdata
	 * @return List<FileDinhKem>
	 */
	public static List<FileDinhKem> convertFromObjectToFileDinhKem(List listdata) {
		List<FileDinhKem> listResult = new ArrayList<FileDinhKem>();
		try {
			
			FileDinhKem fileDinhKem = null;
			Object[] listData = null;
			if (listdata.size() == 0) {
				return listResult;
			} else {
				if (listdata.get(0) instanceof FileDinhKem) {
					return listdata;
				}
			}

			if (listdata != null) {
				for (Object obj : listdata) {
					listData = (Object[])obj; 
					fileDinhKem = new FileDinhKemClp();
					fileDinhKem.setSoBanGiay(((BigDecimal)listData[0]).longValue());
					fileDinhKem.setDaDoiChieu(((BigDecimal)listData[1]).intValue());
					fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(((BigDecimal)listData[2]).intValue());
					fileDinhKem.setNoiLuuTruTaiLieuId(((BigDecimal)listData[3]).longValue());
					fileDinhKem.setNguoiUpload((String)listData[4]);
					fileDinhKem.setNgayUpload(new Date(((Timestamp)listData[5]).getTime()));
					fileDinhKem.setNgaySua(new Date(((Timestamp)listData[6]).getTime()));
					fileDinhKem.setNguoiSua((String)listData[7]);
					fileDinhKem.setHoSoTTHCCongId(((BigDecimal)listData[8]).longValue());
					
					if (listData[9] != null) {
						fileDinhKem.setThuTuc2GiayToId(((BigDecimal)listData[9]).longValue());
					}
					
					if (listData[10] != null) {
						fileDinhKem.setCanBoId(((BigDecimal)listData[10]).longValue());
					}
					
					fileDinhKem.setId(((BigDecimal)listData[11]).longValue());
					fileDinhKem.setXoa(((BigDecimal)listData[12]).intValue());
					
					if (listData[13] != null) {
						fileDinhKem.setMaLoaiTaiLieuDuocThayThe((String)listData[13]);
						
					}
					if (listData[14] != null) {
						fileDinhKem.setDanhMucGiayToId(((BigDecimal)listData[14]).longValue());
					}
					
					fileDinhKem.setDaTra(((BigDecimal)listData[15]).intValue());
					listResult.add(fileDinhKem);
				}
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		return listResult;
	}

	/**
	 * This is function convertToLong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return long
	 */
	public static long convertToLong(String value) {
		try {
			return Long.parseLong(value.trim());
		} catch (Exception es) {
		}
		return 0;
	}
	
	/**
	 * This is function convertToInt
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return int
	 */
	public static int convertToInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception es) {
		}
		return 0;
	}
	
	/**
	 * This is function findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thutuchanhchinhid
	 * @param giaiDoan
	 * @return List<FileKetQua>
	 */
	public static List<FileKetQua> findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(long thutuchanhchinhid, int giaiDoan) {
		List<FileKetQua> listResult = new ArrayList<FileKetQua>();
		try {
			List<ThuTuc2GiayTo> liThuTuc2GiayTos = null;
			
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(ThuTuc2GiayTo.class);
				Criterion criteriaThuTucHanhChinhId = RestrictionsFactoryUtil.eq("thuTucHanhChinhId", thutuchanhchinhid);
				Criterion criteriaGiaiDoan = RestrictionsFactoryUtil.eq("giaidoan", giaiDoan);
				Criterion criteriaDaXoa = RestrictionsFactoryUtil.eq("daXoa", 0);
				query = query.add(criteriaThuTucHanhChinhId).add(criteriaGiaiDoan).add(criteriaDaXoa).addOrder(OrderFactoryUtil.asc("thuTuHienThi"));
				liThuTuc2GiayTos = (List<ThuTuc2GiayTo>)ThuTuc2GiayToLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (liThuTuc2GiayTos == null) {
				return listResult;
			}
			
			DanhMucGiayTo danhMucGiayTo = null;
			FileKetQua fileKetQua = null;
			
			for (ThuTuc2GiayTo thuTuc2GiayTo : liThuTuc2GiayTos) {
				try {
					danhMucGiayTo = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(thuTuc2GiayTo.getDanhMucGiayToId());
				} catch (Exception e) {
					try {
						danhMucGiayTo = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(thuTuc2GiayTo.getDanhMucGiayToId());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
				if (danhMucGiayTo != null) {
					fileKetQua = new FileKetQua();
					fileKetQua.setDanhMucGiayToId(danhMucGiayTo.getId());
					fileKetQua.setMaTaiLieu(danhMucGiayTo.getMa());
					fileKetQua.setTenTaiLieu(danhMucGiayTo.getTen());
					fileKetQua.setGioiHanDungLuong(danhMucGiayTo.getGioiHanDungLuong());
					fileKetQua.setKieuTaiLieu(danhMucGiayTo.getKieuTaiLieu());
					fileKetQua.setBatBuoc(thuTuc2GiayTo.getBatBuoc());
					fileKetQua.setThuTuc2GiayToId(thuTuc2GiayTo.getId());
					listResult.add(fileKetQua);
				}
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		return listResult;
	}
}
