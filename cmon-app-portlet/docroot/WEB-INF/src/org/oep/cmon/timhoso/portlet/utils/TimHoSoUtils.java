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

package org.oep.cmon.timhoso.portlet.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.FileDinhKemClp;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;

import org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.dlms.consumer.ServiceSoap;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

/**
 * This is class TimHoSoUtils  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TimHoSoUtils {

	/**
	 * This is function convert from String to Long
	 * Version: 1.0
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
	 * This is function getURL
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fileEntry
	 * @return String
	 */
	private static String getURL(FileEntry fileEntry){
		try{
	
			String url =    "/documents/" 
					        + fileEntry.getGroupId() 
					        + StringPool.SLASH 
					        + fileEntry.getFolderId() 
					        + StringPool.SLASH 
					        + fileEntry.getTitle()
					        + "?version="+fileEntry.getVersion();
			return url;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	
	return "";
	}
	
	
	/**
	 * This is function get URL by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fileId
	 * @return String
	 */
	public static String getURLById(Long fileId){
		try {
			return getURL(DLAppLocalServiceUtil.getFileEntry(fileId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "";
	}
	
	static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * This is function parse Date to String
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
	 * This is function convert from Object to FileDinhKem
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
			try {
				return TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(fileDinhKem.getNoiLuuTruTaiLieuId());
			} catch (Exception e1) {
			}
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
			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
			return iDocumentStorage.getURLById(noiLuuTruId);
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get TrangThaiHoSo
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
	 * This is function get TrangThaiHoSoAnhXa
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoThuTucHanhChinhCongId
	 * @param trangThaiOld
	 * @return long
	 */
	public static long getTrangThaiHoSoAnhXa(long hoSoThuTucHanhChinhCongId, int trangThaiOld) {
		try {
			 HoSoAnhXa hoSoAnhXa = HoSoAnhXaLocalServiceUtil.findByHoSoTTHCCongId(hoSoThuTucHanhChinhCongId);
			 if (hoSoAnhXa == null) {
				 // Khong tich hop ben 1 cua.
				 return HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoThuTucHanhChinhCongId).getTrangThaiHoSo();
			 } else {
				 // Tich hop ben 1 cua sang.
				 try {
					 ServiceSoap serviceSoap = WebserviceFactory.getDlmsService();
					 String trangThai = serviceSoap.getTrangThaiHoSo(hoSoAnhXa.getMaHoSo());
					 if (trangThai != null && trangThai.trim().length() > 0 && ConvertUtil.convertToInt(trangThai) > 0) {
						 hoSoAnhXa.setTrangThai(ConvertUtil.convertToInt(trangThai));
						 HoSoAnhXaLocalServiceUtil.updateHoSoAnhXa(hoSoAnhXa);
					 } else {
						 trangThai = String.valueOf(hoSoAnhXa.getTrangThai());
					 }
					 trangThai = ConvertUtil.convertToInt(trangThai) + "";
					
					 if ("7,16,9,10,11,12,13,3,4,5,".contains(trangThai.trim() + ",")) {
						 return 15;
					 } else if (trangThai.compareTo("0") == 0) {
						 return 5;
					 } else if ("15,2,".contains(trangThai.trim() + ",")) {
						 return 3;
					 } else if ("6,14,17,18,35,".contains(trangThai.trim() + ",")) {
						 return 8;
					 } else if (trangThai.compareTo("19") == 0) {
						 return 6;
					 } else if (trangThai.compareTo("1") == 0) {
						 return 1;
					 }
				 } catch (Exception ess) {
				 }
			 }
		} catch (Exception es) {
		}
		return trangThaiOld;
	}
}
