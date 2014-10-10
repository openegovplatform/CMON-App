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

package org.oep.cmon.portlet.ipmslist.business;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;

import org.oep.cmon.portlet.ipmslist.utils.ComUtils;
import org.oep.cmon.portlet.ipmslist.utils.ConvertUtil;
import org.oep.cmon.user.portlet.util.ElectricCodeGeneratorUtil;
import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.provider.model.ResultUpload;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.model.GioiTinh;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.model.DoanhNghiepClp;
import org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.FileDinhKemClp;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;

import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucClp;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import vn.dtt.sharedservice.Constaints;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.cmon.consumer.citizen.ICitizenService;
import vn.dtt.sharedservice.masobiennhan.KetQua;
import vn.dtt.sharedservice.masobiennhan.MaBienNhanImplPortType;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class FormOfflineBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class FormOfflineBusiness {
	/** List of dich vu cong of Unitech OSS */
	private final String CITIZEN_SEQUENCE = "csms_congdan";
	public static final String FILE_UPLOAD_SEQUENCE = "CMON_GIAYTODINHKEMHOSO_ID";
	public final static String DATA_UPLOAD_FILE = "data_upload";
	public final static String HOSOTTHCCONGID = "HOSOTTHCCONG_ID";
	public final static String TEN_FILE_UPLOAD = "ten_file_upload";
	public static final String CMON_HOSOTTHCCONG_SEQUENCE = "CMON_HOSOTTHCCONG_AUTO_INCREMENT";
	
	private static Log _log = LogFactoryUtil.getLog(FormOfflineBusiness.class);

	/**
	 * This is function searchHoSoTTHCCongRequest
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
	public void searchHoSoTTHCCongRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String searchKeyWord = ParamUtil.getString(actionRequest, "searchKeyWord").trim();
		String trangThaiHoSo = ParamUtil.getString(actionRequest, "trangThaiHoSo").trim();
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();

		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
		actionResponse.setRenderParameter("trangThaiHoSo", trangThaiHoSo);

		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/quyTrinhDangXuLy.jsp");
	}
	
	/**
	 * This is function doiChieuHoSoRequest
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
	public void doiChieuHoSoRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String HosotthcCongId = ParamUtil.getString(actionRequest, "HosotthcCongId");
		try {
			boolean isSuccess = true;
			List<FileDinhKem> liFileUploadsIserviceAllGiaiDoan1 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(ConvertUtil.convertToLong(HosotthcCongId)));
			for (FileDinhKem fileUpload : liFileUploadsIserviceAllGiaiDoan1) {
				try {
					TaiLieuChungThuc taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
					if (taiLieuChungThuc != null) {
						long taiLieuChungThucId = taiLieuChungThuc.getId();
						int doiChieu = ParamUtil.getInteger(actionRequest, "doiChieu_" + taiLieuChungThucId);
						
						if (doiChieu == org.oep.cmon.portlet.mapping.utils.Constaints.Document.chuaDoiChieu) {
							taiLieuChungThuc.setHieuLucTuNgay(null);
							taiLieuChungThuc.setHieuLucDenNgay(null);
						} else {
							String tuNgay = ParamUtil.getString(actionRequest, "tuNgay_"+ taiLieuChungThucId);
							String denNgay = ParamUtil.getString(actionRequest,"denNgay_"+ taiLieuChungThucId);
							Date tuNgayDate = null;
							Date denNgayDate = null;
							if (Validator.isNotNull(tuNgay)) {
								tuNgayDate = org.oep.cmon.admin.portlet.util.ConvertUtil.parseStringToDate(tuNgay);
							}
							if (Validator.isNotNull(denNgay)) {
								denNgayDate = org.oep.cmon.admin.portlet.util.ConvertUtil.parseStringToDate(denNgay);
								
								if (tuNgayDate.compareTo(denNgayDate) > 0) {
									SessionErrors.add(actionRequest, "errorHieuLuc");
									isSuccess = false;
									break;
								}
							}
							taiLieuChungThuc.setHieuLucTuNgay(tuNgayDate);
							taiLieuChungThuc.setHieuLucDenNgay(denNgayDate);
						}
						taiLieuChungThuc.setTrangThai(doiChieu);
						TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(taiLieuChungThuc);
					}
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
			if (isSuccess) {
				actionRequest.setAttribute("doi_chieu_completed", "doi_chieu_completed");
				SessionMessages.add(actionRequest, "doi_chieu_completed");
			}
		} catch (Exception es) {
			SessionErrors.add(actionRequest, "errorDoiChieuHoSo");
		}
		
		actionResponse.setRenderParameter("transactionKeyword", ParamUtil.getString(actionRequest, "transactionKeyword"));
		actionResponse.setRenderParameter("statusHS", ParamUtil.getString(actionRequest, "statusHS"));
		actionResponse.setRenderParameter("backUrl", ParamUtil.getString(actionRequest, "backUrl"));
		actionResponse.setRenderParameter("transType", ParamUtil.getString(actionRequest, "transType"));
		actionResponse.setRenderParameter("HosotthcCongId", HosotthcCongId);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/doiChieuHoSoChiTiet.jsp");
	}
	
	/**
	 * This is function doiChieuHoSoDoanhNghiepRequest
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
	public void doiChieuHoSoDoanhNghiepRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String HosotthcCongId = ParamUtil.getString(actionRequest, "HosotthcCongId");
		try {
			List<FileDinhKem> liFileUploadsIserviceAllGiaiDoan1 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(ConvertUtil.convertToLong(HosotthcCongId)));
			String fileDinhKemId = "";
			FileDinhKem fileDinhKem = null;
			for (FileDinhKem fileUpload : liFileUploadsIserviceAllGiaiDoan1) {
				fileDinhKemId = ParamUtil.getString(actionRequest, String.valueOf(fileUpload.getId()));
				try {
					fileDinhKem = FileDinhKemLocalServiceUtil.fetchFileDinhKem(fileUpload.getId());
					if (fileDinhKem != null) {
						if (fileDinhKemId.trim().length() > 0) {
							fileDinhKem.setDaDoiChieu(1);// File nay da doi chieu.
						} else {
							fileDinhKem.setDaDoiChieu(0);// File nay da doi chieu.
						}
						FileDinhKemLocalServiceUtil.updateFileDinhKem(fileDinhKem);
					}
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
			SessionMessages.add(actionRequest, "doi_chieu_completed");
			actionRequest.setAttribute("doi_chieu_completed", "doi_chieu_completed");
		} catch (Exception es) {
			SessionErrors.add(actionRequest, "erorDoiChieuHoSo");
		}
		
		actionResponse.setRenderParameter("transactionKeyword", ParamUtil.getString(actionRequest, "transactionKeyword"));
		actionResponse.setRenderParameter("statusHS", ParamUtil.getString(actionRequest, "statusHS"));
		actionResponse.setRenderParameter("transType", ParamUtil.getString(actionRequest, "transType"));
		actionResponse.setRenderParameter("HosotthcCongId", HosotthcCongId);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/doiChieuHoSoChiTiet.jsp");
	}
	
	/**
	 * This is function traHoSoRequest
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
	public void traHoSoRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		User user = PortalUtil.getUser(actionRequest);
		String searchKeyWord = ParamUtil.getString(actionRequest, "transactionKeyword");
		String HosotthcCongId = ParamUtil.getString(actionRequest, "HosotthcCongId");
		String trangThaiHoSo = ParamUtil.getString(actionRequest, "trangThaiHoSo");
		String ghiChu = ParamUtil.getString(actionRequest, "ghiChu");
		String statusHS = ParamUtil.getString(actionRequest, "statusHS");
		String cqqlId = ParamUtil.getString(actionRequest, "cqqlId");
		
		try {
			if (HosotthcCongId.trim().length() > 0) {
				HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
				TaiKhoanNguoiDung taiKhoanNguoiDung = ConvertUtil.findTaiKhoanNguoiDungByUserID(user.getUserId());
				List<CongChuc> liChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
				if (liChucs.size() > 0) {
					CongChuc congChuc = liChucs.get(0);
					ChucVu chucVu = ConvertUtil.findChucVuByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(), ConvertUtil.convertToLong(cqqlId));
					hoSoTTHCCong.setCanBoTraKetQuaId(congChuc.getId());
					hoSoTTHCCong.setChucVuCanBoTraKetQua(chucVu.getTen());
				}
				
				hoSoTTHCCong.setTrangThaiHoSo(5); // Day la trang thai da tra ho so.
				hoSoTTHCCong.setGhiChu(ghiChu);
				hoSoTTHCCong.setNgaySua(new Date());
				hoSoTTHCCong.setNgayTraKetQua(new Date());
				hoSoTTHCCong.setNguoiSua(user.getEmailAddress());
				
				HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);
				List<FileDinhKem> liFileUploads = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));
				String traKetQuaId = "";
				FileDinhKem fileDinhKem = null;
				for (FileDinhKem fileUpload : liFileUploads) {
					traKetQuaId = ParamUtil.getString(actionRequest, fileUpload.getId() + "_trachocongdan");
					if (traKetQuaId.trim().length() > 0) {
						try {
							fileDinhKem = FileDinhKemLocalServiceUtil.fetchFileDinhKem(ConvertUtil.convertToLong(traKetQuaId));
							fileDinhKem.setDaTra(1);// File nay tra lai cho cong dan.
							FileDinhKemLocalServiceUtil.updateFileDinhKem(fileDinhKem);
						} catch (Exception es) {
							es.printStackTrace();
						}
					}
				}
				SessionMessages.add(actionRequest, "update_ho_so_completed");
			}
		} catch (Exception es) {
			SessionErrors.add(actionRequest, "erorUpdateFormForm");
		}
		
		actionResponse.setRenderParameter("transactionKeyword", searchKeyWord);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("transType", trangThaiHoSo);
		actionResponse.setRenderParameter("HosotthcCongId", HosotthcCongId);
		actionResponse.setRenderParameter("ghiChu", ghiChu);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/traKetQua.jsp");
	}
	
	/**
	 * This is function traHoSoDoanhNghiepRequest
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
	public void traHoSoDoanhNghiepRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		User user = PortalUtil.getUser(actionRequest);
		String searchKeyWord = ParamUtil.getString(actionRequest, "transactionKeyword");
		String HosotthcCongId = ParamUtil.getString(actionRequest, "HosotthcCongId");
		String trangThaiHoSo = ParamUtil.getString(actionRequest, "trangThaiHoSo");
		String ghiChu = ParamUtil.getString(actionRequest, "ghiChu");
		String statusHS = ParamUtil.getString(actionRequest, "statusHS");
		String cqqlId = ParamUtil.getString(actionRequest, "cqqlId");
		
		try {
			if (HosotthcCongId.trim().length() > 0) {
				HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
				TaiKhoanNguoiDung taiKhoanNguoiDung = ConvertUtil.findTaiKhoanNguoiDungByUserID(user.getUserId());
				List<CongChuc> liChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
				if (liChucs.size() > 0) {
					CongChuc congChuc = liChucs.get(0);
					ChucVu chucVu = ConvertUtil.findChucVuByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(), ConvertUtil.convertToLong(cqqlId));
					hoSoTTHCCong.setCanBoTraKetQuaId(congChuc.getId());
					hoSoTTHCCong.setChucVuCanBoTraKetQua(chucVu.getTen());
				}
				
				hoSoTTHCCong.setTrangThaiHoSo(5); // Day la trang thai da tra ho so.
				hoSoTTHCCong.setGhiChu(ghiChu);
				hoSoTTHCCong.setNgaySua(new Date());
				hoSoTTHCCong.setNgayTraKetQua(new Date());
				hoSoTTHCCong.setNguoiSua(user.getEmailAddress());
				
				HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);
				List<FileDinhKem> liFileUploads = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));
				String traKetQuaId = "";
				FileDinhKem fileDinhKem = null;
				for (FileDinhKem fileUpload : liFileUploads) {
					traKetQuaId = ParamUtil.getString(actionRequest, fileUpload.getId() + "_trachocongdan");
					if (traKetQuaId.trim().length() > 0) {
						try {
							fileDinhKem = FileDinhKemLocalServiceUtil.fetchFileDinhKem(ConvertUtil.convertToLong(traKetQuaId));
							fileDinhKem.setDaTra(1);// File nay tra lai cho cong dan.
							FileDinhKemLocalServiceUtil.updateFileDinhKem(fileDinhKem);
						} catch (Exception es) {
							es.printStackTrace();
						}
					}
				}
				SessionMessages.add(actionRequest, "update_ho_so_completed");
			}
		} catch (Exception es) {
			SessionErrors.add(actionRequest, "erorUpdateFormForm");
		}
		
		actionResponse.setRenderParameter("transactionKeyword", searchKeyWord);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("transType", trangThaiHoSo);
		actionResponse.setRenderParameter("HosotthcCongId", HosotthcCongId);
		actionResponse.setRenderParameter("ghiChu", ghiChu);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/traKetQua.jsp");
	}
	
	/**
	 * This is function searchCongDanRequest
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
	public void searchCongDanRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String _keyWord = ParamUtil.getString(actionRequest, "_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();

		List<CongDan> results = findByCMNDLike(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("_searchKeyWord", _keyWord);
		actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/timCongDan.jsp");
	}
	
	/**
	 * This is function searchCongDanNopRequest
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
	public void searchCongDanNopRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordOld = ParamUtil.getString(actionRequest, "searchKeyWordOld");
		String _keyWord = ParamUtil.getString(actionRequest, "_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String idCongDanNop = ParamUtil.getString(actionRequest, "idCongDanNop");
		String idCongDan = ParamUtil.getString(actionRequest, "idCongDan");
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();

		List<CongDan> results = findByCMNDLike(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("searchKeyWordOld", keyWordOld);
		actionResponse.setRenderParameter("_searchKeyWord", _keyWord);
		actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
		actionResponse.setRenderParameter("idCongDan", idCongDan);
		actionResponse.setRenderParameter("idCongDanNop", idCongDanNop);
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCongDan.jsp");
	}
	
	/**
	 * This is function searchDoanhNghiepRequest
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
	public void searchDoanhNghiepRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String _keyWord = ParamUtil.getString(actionRequest, "_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();

		List<DoanhNghiep> results = findByMaSoThueOrMaSoDoanhNghiep(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("_searchKeyWord", _keyWord);
		actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCompany.jsp");
	}

	/**
	 * This is function addHoSoRequest
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
	public void addHoSoRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();

		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/inputHoSo.jsp");
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("statusHS", statusHS);
		
		long hoSoThuTucHanhChinhCongId = 0;
		User user = PortalUtil.getUser(actionRequest);
		String searchKeyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String _searchKeyWord = ParamUtil.getString(actionRequest, "_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String idCongDan = ParamUtil.getString(actionRequest, "idCongDan");
		String coQuanTiepNhanTen = ParamUtil.getString(actionRequest, "coQuanTiepNhanTen");
		String coQuanTiepNhanId = ParamUtil.getString(actionRequest, "coQuanTiepNhanId");
		String tenQuyTrinh = ParamUtil.getString(actionRequest, "tenQuyTrinh");
		String tenCongDan = ParamUtil.getString(actionRequest, "tenCongDan");
		String diaChiThuongTruCongDan = ParamUtil.getString(actionRequest, "diaChiThuongTruCongDan");
		String cmndCongDan = ParamUtil.getString(actionRequest, "cmndCongDan");
		String ngaySinhCongDan = ParamUtil.getString(actionRequest, "ngaySinhCongDan");
		String ngayNopHoSo = ParamUtil.getString(actionRequest, "ngayNopHoSo");
		String ngayTraHoSo = ParamUtil.getString(actionRequest, "ngayTraHoSo");
		String soDienThoaiCongDan = ParamUtil.getString(actionRequest, "soDienThoaiCongDan").replace("soDienThoaiCongDan", "").trim();
		
		if (validationData(soDienThoaiCongDan, actionRequest)) {
			try {
				hoSoThuTucHanhChinhCongId = CounterLocalServiceUtil.increment(CMON_HOSOTTHCCONG_SEQUENCE);
				HoSoTTHCCong hoSoTTHCCong = new HoSoTTHCCongClp();
				hoSoTTHCCong.setId(hoSoThuTucHanhChinhCongId);
				String maSoHoSo = getMaHoSoSo(getMaQuyTrinh(ConvertUtil.convertToLong(idQuyTrinh)), false);
				hoSoTTHCCong.setMaSoHoSo(maSoHoSo);//"MAHOSOODAY"
				hoSoTTHCCong.setNgayNopHoSo(new Date());
				hoSoTTHCCong.setTenCoQuanTiepNhan(coQuanTiepNhanTen);
				hoSoTTHCCong.setTenThuTucHanhChinh(tenQuyTrinh);
				
				TaiKhoanNguoiDung taiKhoanNguoiDung = ConvertUtil.findTaiKhoanNguoiDungByUserID(user.getUserId());
				List<CongChuc> liChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
				if (liChucs.size() > 0) {
					CongChuc congChuc = liChucs.get(0);
					ChucVu chucVu = ConvertUtil.findChucVuByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(), ConvertUtil.convertToLong(coQuanTiepNhanId));

					hoSoTTHCCong.setCanBoTiepNhanId(congChuc.getId());
					hoSoTTHCCong.setTenCanBoTiepNhan(congChuc.getHoVaTen());
					hoSoTTHCCong.setCanBoXuLyHienThoiId(congChuc.getId());
					hoSoTTHCCong.setTenCanBoXuLyHienThoi(congChuc.getHoVaTen());
					hoSoTTHCCong.setChucVuCanBoTiepNhan(chucVu.getTen());
				}

				if (tenCongDan.trim().length() == 0) {
					hoSoTTHCCong.setHoTenNguoiNopHoSo(" ");
				} else {
					hoSoTTHCCong.setHoTenNguoiNopHoSo(tenCongDan);
				}
				
				hoSoTTHCCong.setDiaChiThuongTruNguoiNop(diaChiThuongTruCongDan);                                                      
				hoSoTTHCCong.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCongDan);
				hoSoTTHCCong.setSoDienThoaiDiDongNguoiNop(soDienThoaiCongDan);

				hoSoTTHCCong.setTrangThaiHoSo(1);
				hoSoTTHCCong.setDaXoa(0);                                                                       
				hoSoTTHCCong.setNguoiTao(user.getEmailAddress());
				hoSoTTHCCong.setNgayTao(new Date());
				hoSoTTHCCong.setNguoiSua(user.getEmailAddress());  
				
//				hoSoTTHCCong.setNgayNopHoSo(ConvertUtil.parseStringToDate(ngayNopHoSo));
				hoSoTTHCCong.setNgayNopHoSo(new Date());
				hoSoTTHCCong.setNgayNhanHoSo(ConvertUtil.parseStringToDate(ngayNopHoSo));
				hoSoTTHCCong.setNgayHenNopHoSoGoc(ConvertUtil.parseStringToDate(ngayNopHoSo));
				hoSoTTHCCong.setNgayHenTraKetQua(ConvertUtil.parseStringToDate(ngayTraHoSo));
				
				hoSoTTHCCong.setNgaySua(new Date());                                                                      
				hoSoTTHCCong.setThuTucHanhChinhId(ConvertUtil.convertToLong(idQuyTrinh));                                                           
				hoSoTTHCCong.setCongDanNopId(ConvertUtil.convertToLong(idCongDan));                                                                 
				hoSoTTHCCong.setCoQuanTiepNhanId(ConvertUtil.convertToLong(coQuanTiepNhanId));                                                             
				//hoSoTTHCCong.setDiaChiThuongTruNguoiNopId(0);                                                    
				hoSoTTHCCong.setSoDienThoaiDiDongNguoiNop(soDienThoaiCongDan);                                                  
				hoSoTTHCCong.setLoaiHoSo(1); // 0: online;    1: off
				hoSoTTHCCong.setMaSoBienNhan("");
				hoSoTTHCCong.setTenBangChuaHoSo("CMON_HOSOTTHCCONG");
				hoSoTTHCCong.setChuSoHuu(tenCongDan);
				
				// Get gropu dich vu cong id
				ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(Long.parseLong(idQuyTrinh));
				
				long dvcGroupId = thuTuc.getNhomThuTucHanhChinhId();
				
				NhomThuTucHanhChinh nhomDvc = NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(dvcGroupId);
				long appId = nhomDvc.getDanhMucUngDungId();
				
				// Get applcation code
				DanhMucUngDung app = DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(appId);
				
				String maUngDung = app.getMa();
				hoSoTTHCCong.setMaUngDung(maUngDung);
				
				HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(hoSoTTHCCong);
				
				// Create empty array
				List<FileDinhKem> fileUpLoadLst = new ArrayList<FileDinhKem>();
				
				if (actionRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE) != null) {
					List<FileDinhKem> listResultBefore = (ArrayList<FileDinhKem>)actionRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
					TaiLieuChungThuc taiLieuChungThuc = null;
					for (FileDinhKem fileUpload : listResultBefore) {
						fileUpload.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
						fileUpload.setHoSoTTHCCongId(hoSoTTHCCong.getId());
						try {
							FileDinhKemLocalServiceUtil.addFileDinhKem(fileUpload);
						} catch (Exception es) {
							es.printStackTrace();
						}
						try {
							taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(fileUpload.getNoiLuuTruTaiLieuId());
							taiLieuChungThuc.setHoSoTTHCCId(hoSoTTHCCong.getId());
							TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(taiLieuChungThuc);
						} catch (Exception es) {
						}
					}
					
					// Added by Nam
					fileUpLoadLst = listResultBefore;
					//actionRequest.getPortletSession().removeAttribute(DATA_UPLOAD_FILE);
				}
				
				// Goi khoi tao quy trinh trong uengine.
				ComUtils comUtils = new ComUtils();
				comUtils.tiepNhanHoSo(actionRequest, hoSoTTHCCong);
				
				// Add by BinhNT End
				
				actionResponse.setRenderParameter("maSoHoSo", hoSoTTHCCong.getMaSoHoSo());
				actionResponse.setRenderParameter("HosotthcCongId", String.valueOf(hoSoTTHCCong.getId()));
				SessionMessages.add(actionRequest, "add_ho_so_completed");
			} catch (Exception es) {
				SessionErrors.add(actionRequest, "erorAddForm");
				try {
					HoSoTTHCCongLocalServiceUtil.deleteHoSoTTHCCong(hoSoThuTucHanhChinhCongId);
					FileDinhKemLocalServiceUtil.deleteByHoSoThuTucHanhChinhId(hoSoThuTucHanhChinhCongId);
				} catch (Exception es1) {
					es1.printStackTrace();
				}
				es.printStackTrace();
			}
		}
			actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
			actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
			actionResponse.setRenderParameter("idCongDan", idCongDan);
			actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
			actionResponse.setRenderParameter("_searchKeyWord", _searchKeyWord);
			actionResponse.setRenderParameter("ngayTraHoSo", ngayTraHoSo);
			if (soDienThoaiCongDan.trim().length() > 0) {
				actionResponse.setRenderParameter("soDienThoaiCongDan", soDienThoaiCongDan);
			}
	}
	
	/**
	 * This is function addHoSoDoanhNghiepRequest
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
	public void addHoSoDoanhNghiepRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();

		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/inputHoSo.jsp");
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("statusHS", statusHS);
		
		long hoSoThuTucHanhChinhCongId = 0;
		User user = PortalUtil.getUser(actionRequest);
		String searchKeyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String _searchKeyWord = ParamUtil.getString(actionRequest, "_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String idCongDan = ParamUtil.getString(actionRequest, "idCongDan");
		String idCongDanNop = ParamUtil.getString(actionRequest, "idCongDanNop");
		String coQuanTiepNhanTen = ParamUtil.getString(actionRequest, "coQuanTiepNhanTen");
		String coQuanTiepNhanId = ParamUtil.getString(actionRequest, "coQuanTiepNhanId");
		String tenQuyTrinh = ParamUtil.getString(actionRequest, "tenQuyTrinh");
		String tenCongDanCty = ParamUtil.getString(actionRequest, "tenCongDan");
		String tenCongDan = ParamUtil.getString(actionRequest, "tenCongDanNop");
		String diaChiThuongTruCongDan = ParamUtil.getString(actionRequest, "diaChiThuongTruCongDan");
		String diaChiThuongTruCongDanNop = ParamUtil.getString(actionRequest, "diaChiThuongTruCongDanNop");
		String maSoDoanhNghiep = ParamUtil.getString(actionRequest, "maSoDoanhNghiep");
		String maSoThueDoanhNghiep = ParamUtil.getString(actionRequest, "maSoThueDoanhNghiep");
		String ngayNopHoSo = ParamUtil.getString(actionRequest, "ngayNopHoSo");
		String ngayTraHoSo = ParamUtil.getString(actionRequest, "ngayTraHoSo");
		String soDienThoaiCongDan = ParamUtil.getString(actionRequest, "soDienThoaiCongDan").replace("soDienThoaiCongDan", "").trim();
		
		if (validationData(soDienThoaiCongDan, actionRequest)) {
			try {
				hoSoThuTucHanhChinhCongId = CounterLocalServiceUtil.increment(CMON_HOSOTTHCCONG_SEQUENCE);
				HoSoTTHCCong hoSoTTHCCong = new HoSoTTHCCongClp();
				hoSoTTHCCong.setId(hoSoThuTucHanhChinhCongId);
				
				String maSoHoSo = getMaHoSoSo(getMaQuyTrinh(ConvertUtil.convertToLong(idQuyTrinh)), false);
				hoSoTTHCCong.setMaSoHoSo(maSoHoSo);//"MAHOSOODAY"
				
				hoSoTTHCCong.setNgayNopHoSo(new Date());
				hoSoTTHCCong.setTenCoQuanTiepNhan(coQuanTiepNhanTen);
				hoSoTTHCCong.setTenThuTucHanhChinh(tenQuyTrinh);
				
				TaiKhoanNguoiDung taiKhoanNguoiDung = ConvertUtil.findTaiKhoanNguoiDungByUserID(user.getUserId());
				List<CongChuc> liChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
				if (liChucs.size() > 0) {
					CongChuc congChuc = liChucs.get(0);
					ChucVu chucVu = ConvertUtil.findChucVuByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(), ConvertUtil.convertToLong(coQuanTiepNhanId));

					hoSoTTHCCong.setCanBoTiepNhanId(congChuc.getId());
					hoSoTTHCCong.setTenCanBoTiepNhan(congChuc.getHoVaTen());
					hoSoTTHCCong.setCanBoXuLyHienThoiId(congChuc.getId());
					hoSoTTHCCong.setTenCanBoXuLyHienThoi(congChuc.getHoVaTen());
					hoSoTTHCCong.setChucVuCanBoTiepNhan(chucVu.getTen());
				}

				// Lay ma doanh nghiep.
				DoanhNghiep doanhNghiep = DoanhNghiepLocalServiceUtil.findByMaDoanhNghiep(maSoDoanhNghiep);
				if (doanhNghiep != null) {
					hoSoTTHCCong.setDoiTuongCanXuLyId(doanhNghiep.getId());
				}
				
				hoSoTTHCCong.setHoTenNguoiNopHoSo(tenCongDan);                                                           
				hoSoTTHCCong.setDiaChiThuongTruNguoiNop(diaChiThuongTruCongDanNop);                                                      
				hoSoTTHCCong.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCongDan);
				hoSoTTHCCong.setSoDienThoaiDiDongNguoiNop(soDienThoaiCongDan);
				                                                             
				hoSoTTHCCong.setTrangThaiHoSo(1);                                                              
				hoSoTTHCCong.setDaXoa(0);                                                                       
				hoSoTTHCCong.setNguoiTao(user.getEmailAddress());                                         
				hoSoTTHCCong.setNgayTao(new Date());                                                                    
				hoSoTTHCCong.setNguoiSua(user.getEmailAddress());  
				
//				hoSoTTHCCong.setNgayNopHoSo(ConvertUtil.parseStringToDate(ngayNopHoSo));
				hoSoTTHCCong.setNgayNopHoSo(new Date());
				hoSoTTHCCong.setNgayNhanHoSo(ConvertUtil.parseStringToDate(ngayNopHoSo));
				hoSoTTHCCong.setNgayHenNopHoSoGoc(ConvertUtil.parseStringToDate(ngayNopHoSo));
				hoSoTTHCCong.setNgayHenTraKetQua(ConvertUtil.parseStringToDate(ngayTraHoSo));
				
				hoSoTTHCCong.setNgaySua(new Date());                                                                      
				hoSoTTHCCong.setThuTucHanhChinhId(ConvertUtil.convertToLong(idQuyTrinh));                                                           
				hoSoTTHCCong.setCongDanNopId(ConvertUtil.convertToLong(idCongDanNop));                                                                 
				hoSoTTHCCong.setCoQuanTiepNhanId(ConvertUtil.convertToLong(coQuanTiepNhanId));                                                             
				hoSoTTHCCong.setSoDienThoaiDiDongNguoiNop(soDienThoaiCongDan);                                                  
				hoSoTTHCCong.setLoaiHoSo(1); // 0: online;    1: off
				hoSoTTHCCong.setMaSoBienNhan("");
				hoSoTTHCCong.setTenBangChuaHoSo("CMON_HOSOTTHCCONG");
				hoSoTTHCCong.setChuSoHuu(tenCongDanCty);
				
				// Get gropu dich vu cong id
				ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(Long.parseLong(idQuyTrinh));
				
				long dvcGroupId = thuTuc.getNhomThuTucHanhChinhId();
				
				NhomThuTucHanhChinh nhomDvc = NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(dvcGroupId);
				long appId = nhomDvc.getDanhMucUngDungId();
				
				// Get applcation code
				DanhMucUngDung app = DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(appId);
				
				String maUngDung = app.getMa();
				hoSoTTHCCong.setMaUngDung(maUngDung);
				
				HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(hoSoTTHCCong);
				
				// Create empty array
				List<FileDinhKem> fileUpLoadLst = new ArrayList<FileDinhKem>();
				
				if (actionRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE) != null) {
					List<FileDinhKem> listResultBefore = (ArrayList<FileDinhKem>)actionRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
					TaiLieuChungThuc taiLieuChungThuc = null;
					for (FileDinhKem fileUpload : listResultBefore) {
						fileUpload.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
						fileUpload.setHoSoTTHCCongId(hoSoTTHCCong.getId());
						try {
							FileDinhKemLocalServiceUtil.addFileDinhKem(fileUpload);
						} catch (Exception es) {
							es.printStackTrace();
						}
						try {
							taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(fileUpload.getNoiLuuTruTaiLieuId());
							taiLieuChungThuc.setHoSoTTHCCId(hoSoTTHCCong.getId());
							TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(taiLieuChungThuc);
						} catch (Exception es) {
							es.printStackTrace();
						}
					}
					
					// Added by Nam
					fileUpLoadLst = listResultBefore;
					//actionRequest.getPortletSession().removeAttribute(DATA_UPLOAD_FILE);
				}
				
				// Goi khoi tao quy trinh trong uengine.
				ComUtils comUtils = new ComUtils();
				comUtils.tiepNhanHoSo(actionRequest, hoSoTTHCCong);
				
				// Add by BinhNT End
				
				actionResponse.setRenderParameter("maSoHoSo", hoSoTTHCCong.getMaSoHoSo());
				actionResponse.setRenderParameter("HosotthcCongId", String.valueOf(hoSoTTHCCong.getId()));
				SessionMessages.add(actionRequest, "add_ho_so_completed");
			} catch (Exception es) {
				SessionErrors.add(actionRequest, "erorAddForm");
				try {
					HoSoTTHCCongLocalServiceUtil.deleteHoSoTTHCCong(hoSoThuTucHanhChinhCongId);
					FileDinhKemLocalServiceUtil.deleteByHoSoThuTucHanhChinhId(hoSoThuTucHanhChinhCongId);
				} catch (Exception es1) {
					es1.printStackTrace();
				}
				es.printStackTrace();
			}
		}
		actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
		actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
		actionResponse.setRenderParameter("idCongDan", idCongDan);
		actionResponse.setRenderParameter("idCongDanNop", idCongDanNop);
		actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
		actionResponse.setRenderParameter("ngayTraHoSo", ngayTraHoSo);
		actionResponse.setRenderParameter("_searchKeyWord", _searchKeyWord);
		if (soDienThoaiCongDan.trim().length() > 0) {
			actionResponse.setRenderParameter("soDienThoaiCongDan", soDienThoaiCongDan);
		}
	}


	/**
	 * This is function validationData
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 */
	private boolean validationData(String cmnd, ActionRequest actionRequest) {
//		if (cmnd.trim().length() > 0) {
//			if (ConvertUtil.convertToLong(cmnd) <= 0) {
//				SessionErrors.add(actionRequest, "erorTelephone");
//			} else if (cmnd.length() != 10 && cmnd.length() != 11) {
//				SessionErrors.add(actionRequest, "erorTelephone");
//			}
//		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	
	/**
	 * This is function findByCMNDLike
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<CongDan>
	 */
	@SuppressWarnings("unchecked")
	public List<CongDan> findByCMNDLike(String keyWord) {
		List<CongDan> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(CongDan.class);

			// This is a test line for display all request if there's no search
			// criteria
			Criterion criteria = RestrictionsFactoryUtil.like("soCmnd", "%" + keyWord + "%");

			// Define search criteria
			query = query.add(criteria);

			try {
				results = CongDanLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
			}
		}
		if (results == null) {
			results = new ArrayList<CongDan>();
		}
		return results;
	}
	
	/**
	 * This is function findByMaSoThueOrMaSoDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<DoanhNghiep>
	 */
	@SuppressWarnings("unchecked")
	public List<DoanhNghiep> findByMaSoThueOrMaSoDoanhNghiep(String keyWord) {
		List<DoanhNghiep> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(DoanhNghiep.class);

			// This is a test line for display all request if there's no search
			// criteria
			Criterion criteriaMa = RestrictionsFactoryUtil.like("ma", "%" + keyWord + "%");
			Criterion criteriaMaSoThue = RestrictionsFactoryUtil.like("maSoThue", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaMa, criteriaMaSoThue);

			// Define search criteria
			query = query.add(criteria);

			try {
				results = DoanhNghiepLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
			}
		}
		if (results == null) {
			results = new ArrayList<DoanhNghiep>();
		}
		return results;
	}
	
	/**
	 * This is function findByCMND
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @param actionResponse
	 * @throws List<CongDan>
	 */
	@SuppressWarnings("unchecked")
	public List<CongDan> findByCMND(String keyWord) {
		List<CongDan> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(CongDan.class);

			// This is a test line for display all request if there's no search
			// criteria
			Criterion criteria = RestrictionsFactoryUtil.eq("soCmnd", keyWord);

			// Define search criteria
			query = query.add(criteria);

			try {
				results = CongDanLocalServiceUtil.dynamicQuery(query);
			} catch (Exception e) {
			}
		}
		if (results == null) {
			results = new ArrayList<CongDan>();
		}
		return results;
	}

	/**
	 * This is function addCongDanRequest
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
	public void addCongDanRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/themCongDan.jsp");

		String searchKeyWord = ParamUtil.getString(actionRequest,
				"searchKeyWord");
		String _searchKeyWord = ParamUtil.getString(actionRequest,
				"_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String firstName = ParamUtil.getString(actionRequest, "firstName")
				.trim().toUpperCase();
		String middleName = ParamUtil.getString(actionRequest, "middleName")
				.trim().toUpperCase();
		String lastName = ParamUtil.getString(actionRequest, "lastName").trim()
				.toUpperCase();
		String cmnd = ParamUtil.getString(actionRequest, "cmnd").trim();
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		String idGioiTinh = ParamUtil.getString(actionRequest, "idGioiTinh")
				.trim();
		String numberHome = ParamUtil.getString(actionRequest, "numberHome")
				.trim();
		String idTinhHienTai = ParamUtil.getString(actionRequest,"idTinhHienTai").trim();
		String idHuyenHienTai = ParamUtil.getString(actionRequest, "idHuyenHienTai").trim();
		String idXaHienTai = ParamUtil.getString(actionRequest, "idXaHienTai").trim();
		String quocGiaId = ParamUtil.getString(actionRequest, "quocGiaId").trim();
		String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber").trim();

		if (validationData(firstName, middleName, lastName, cmnd, ngaySinh,
				idGioiTinh, numberHome, idTinhHienTai, idHuyenHienTai,
				idXaHienTai, actionRequest)) {
			CongDan congDan = new CongDanClp();
			congDan.setId(CounterLocalServiceUtil.increment(CITIZEN_SEQUENCE));
			congDan.setMa(ElectricCodeGeneratorUtil.generateCode(
					ConvertUtil.convertToLong(idTinhHienTai),
					ConvertUtil.parseStringToDate(ngaySinh)));
			congDan.setHo(firstName);
			congDan.setDem(middleName);
			congDan.setTen(lastName);
			congDan.setNgaySinh(ConvertUtil.parseStringToDate(ngaySinh));
			congDan.setSoCmnd(cmnd);
			
			// Thiet lap dia chi thuong tru.
			congDan.setDiaChiThuongTru(numberHome);
			congDan.setDiaChiThuongTruTinhId(ConvertUtil.convertToLong(idTinhHienTai));
			congDan.setDiaChiThuongTruHuyenId(ConvertUtil.convertToLong(idHuyenHienTai));
			congDan.setDiaChiThuongTruXaId(ConvertUtil.convertToLong(idXaHienTai));
			
			// Thiet lap dia chi hien tai.
			congDan.setDiaChiHienNay(numberHome);
			congDan.setDiaChiHienNayTinhId(ConvertUtil.convertToLong(idTinhHienTai));
			congDan.setDiaChiHienNayHuyenId(ConvertUtil.convertToLong(idHuyenHienTai));
			congDan.setDiaChiHienNayXaId(ConvertUtil.convertToLong(idXaHienTai));
			
			congDan.setGioiTinh(ConvertUtil.convertToInt(idGioiTinh));
			
			// Added by Nam ( fullName)
			congDan.setTenDayDu(firstName + StringPool.SPACE + middleName + StringPool.SPACE + lastName);
			if (phoneNumber != null) {
				congDan.setDienThoaiCoDinh(phoneNumber);
				congDan.setDienThoaiDiDong(phoneNumber);
			}
			
			congDan.setNgayTao(new Date());
			congDan.setNgaySua(new Date());
			congDan.setQuocTichId(ConvertUtil.convertToLong(quocGiaId));
			User currentUser = PortalUtil.getUser(actionRequest);

			if (currentUser != null) {
				// Nguoi chung thuc
				congDan.setNguoiTao(currentUser.getEmailAddress());
				congDan.setNguoiSua(currentUser.getEmailAddress());
			} else {
				congDan.setNguoiTao("DUMMY");
				congDan.setNguoiSua("DUMMY");
			}
			congDan.setDaXoa(0);
			try {
				try {
					CongDanLocalServiceUtil.addCongDan(congDan);
				} catch (Exception es) {
				}
				CongDan congDan2 = CongDanLocalServiceUtil.fetchCongDan(congDan.getId());
				if (congDan2 != null) {
					SessionMessages.add(actionRequest, "add_cong_dan_completed");
				}
			} catch (Exception es) {
				SessionErrors.add(actionRequest, "error_add_cong_dan");
				es.printStackTrace();
			}
		}

		if (!SessionErrors.isEmpty(actionRequest)) {
			actionResponse.setRenderParameter("firstName", firstName);
			actionResponse.setRenderParameter("middleName", middleName);
			actionResponse.setRenderParameter("lastName", lastName);
			actionResponse.setRenderParameter("cmnd", cmnd);
			actionResponse.setRenderParameter("ngaySinh", ngaySinh);
			actionResponse.setRenderParameter("idGioiTinh", idGioiTinh);
			actionResponse.setRenderParameter("numberHome", numberHome);
			actionResponse.setRenderParameter("idTinhHienTai", idTinhHienTai);
			actionResponse.setRenderParameter("idHuyenHienTai", idHuyenHienTai);
			actionResponse.setRenderParameter("idXaHienTai", idXaHienTai);
		}
		actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
		actionResponse.setRenderParameter("_searchKeyWord", _searchKeyWord);
		actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
	}
	
	/**
	 * This is function addDoanhNghiepRequest
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
	public void addDoanhNghiepRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String transactionKeyword = ParamUtil.getString(actionRequest, "transactionKeyword").trim();
		String transType = ParamUtil.getString(actionRequest, "transType").trim();
		String statusHS = ParamUtil.getString(actionRequest, "statusHS").trim();
		actionResponse.setRenderParameter("transactionKeyword", transactionKeyword);
		actionResponse.setRenderParameter("statusHS", statusHS);
		actionResponse.setRenderParameter("transType", transType);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/themCompany.jsp");

		String searchKeyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String _searchKeyWord = ParamUtil.getString(actionRequest, "_searchKeyWord");
		String idQuyTrinh = ParamUtil.getString(actionRequest, "idQuyTrinh");
		String maSoDoanhNghiep = ParamUtil.getString(actionRequest, "maSoDoanhNghiep").trim().toUpperCase();
		String maSothueDoanhNghiep = ParamUtil.getString(actionRequest, "maSothueDoanhNghiep").trim();
		String tenDoanhNghiep = ParamUtil.getString(actionRequest, "tenDoanhNghiep").trim();
		String soGiayPhepDangKyDoanhNghiep = ParamUtil.getString(actionRequest, "soGiayPhepDangKyDoanhNghiep").trim();
		String ngayCapGiayPhepDangKyDoanhNghiep = ParamUtil.getString(actionRequest, "ngayCapGiayPhepDangKyDoanhNghiep").trim();
		String tongSoVon = ParamUtil.getString(actionRequest, "tongSoVon").trim();
		String idLoaiDoiTuong = ParamUtil.getString(actionRequest, "idLoaiDoiTuong").trim();
		String numberHome = ParamUtil.getString(actionRequest, "numberHome").trim();
		String idTinhHienTai = ParamUtil.getString(actionRequest,"idTinhHienTai").trim();
		String idHuyenHienTai = ParamUtil.getString(actionRequest,"idHuyenHienTai").trim();
		String idXaHienTai = ParamUtil.getString(actionRequest, "idXaHienTai").trim();
		String quocGiaId = ParamUtil.getString(actionRequest, "quocGiaId").trim();
		String idTrangThai = ParamUtil.getString(actionRequest, "idTrangThai").trim();
		String moTaNganhNgheKinhDoanh = ParamUtil.getString(actionRequest, "moTaNganhNgheKinhDoanh").trim();

		if (validationDataDoanhNghiep(maSoDoanhNghiep, maSothueDoanhNghiep, tenDoanhNghiep, soGiayPhepDangKyDoanhNghiep, 
				ngayCapGiayPhepDangKyDoanhNghiep, tongSoVon, idLoaiDoiTuong, numberHome, idTinhHienTai, 
				idHuyenHienTai, idXaHienTai, moTaNganhNgheKinhDoanh, quocGiaId, idTrangThai, actionRequest)) {
			ICitizenService service = WebserviceFactory.getCmonService();
			DoanhNghiep doanhNghiep = new DoanhNghiepClp();
			doanhNghiep.setId(service.getAutoIncrement());
			doanhNghiep.setMa(maSoDoanhNghiep);
			doanhNghiep.setMaSoThue(maSothueDoanhNghiep);
			doanhNghiep.setTen(tenDoanhNghiep);
			doanhNghiep.setSoGCNDKKD(soGiayPhepDangKyDoanhNghiep);
			doanhNghiep.setNgayCapGCNDKKD(ConvertUtil.parseStringToDate(ngayCapGiayPhepDangKyDoanhNghiep));
			doanhNghiep.setTongSoVon(ConvertUtil.convertToLong(tongSoVon));
			doanhNghiep.setLoaiDoiTuongId(ConvertUtil.convertToLong(idLoaiDoiTuong));
			doanhNghiep.setDiaChiDoanhNghiep(numberHome);
			doanhNghiep.setDiaChiDoanhNghiepTinhId(ConvertUtil.convertToLong(idTinhHienTai));
			doanhNghiep.setDiaChiDoanhNghiepHuyenId(ConvertUtil.convertToLong(idHuyenHienTai));
			doanhNghiep.setDiaChiDoanhNghiepXaId(ConvertUtil.convertToLong(idXaHienTai));
			doanhNghiep.setTrangThaiDoanhNghiepId(ConvertUtil.convertToLong(idTrangThai));
			doanhNghiep.setMoTaNganhNgheKinhDoanh(moTaNganhNgheKinhDoanh);
			
			doanhNghiep.setNgayTao(new Date());
			doanhNghiep.setNgaySua(new Date());
			doanhNghiep.setQuocGiaId(ConvertUtil.convertToLong(quocGiaId));
			User currentUser = PortalUtil.getUser(actionRequest);

			if (currentUser != null) {
				// Nguoi chung thuc
				doanhNghiep.setNguoiTao(currentUser.getFullName());
				doanhNghiep.setNguoiSua(currentUser.getFullName());
			} else {
				doanhNghiep.setNguoiTao("DUMMY");
				doanhNghiep.setNguoiSua("DUMMY");
			}
			doanhNghiep.setDaXoa(0);
			try {
				try {
					DoanhNghiepLocalServiceUtil.addDoanhNghiep(doanhNghiep);
				} catch (Exception es) {
				}
				DoanhNghiep congDan2 = DoanhNghiepLocalServiceUtil.fetchDoanhNghiep(doanhNghiep.getId());
				if (congDan2 != null) {
					SessionMessages.add(actionRequest, "add_doanh_nghiep_completed");
				}
			} catch (Exception es) {
				SessionErrors.add(actionRequest, "add_doanh_nghiep_error");
				es.printStackTrace();
			}
		}

		if (!SessionErrors.isEmpty(actionRequest)) {
			actionResponse.setRenderParameter("maSoDoanhNghiep", maSoDoanhNghiep);
			actionResponse.setRenderParameter("maSothueDoanhNghiep", maSothueDoanhNghiep);
			actionResponse.setRenderParameter("tenDoanhNghiep", tenDoanhNghiep);
			actionResponse.setRenderParameter("soGiayPhepDangKyDoanhNghiep", soGiayPhepDangKyDoanhNghiep);
			actionResponse.setRenderParameter("ngayCapGiayPhepDangKyDoanhNghiep", ngayCapGiayPhepDangKyDoanhNghiep);
			actionResponse.setRenderParameter("tongSoVon", tongSoVon);
			actionResponse.setRenderParameter("idLoaiDoiTuong", idLoaiDoiTuong);
			actionResponse.setRenderParameter("numberHome", numberHome);
			actionResponse.setRenderParameter("moTaNganhNgheKinhDoanh", moTaNganhNgheKinhDoanh);
			actionResponse.setRenderParameter("idTinhHienTai", idTinhHienTai);
			actionResponse.setRenderParameter("idHuyenHienTai", idHuyenHienTai);
			actionResponse.setRenderParameter("idXaHienTai", idXaHienTai);
			actionResponse.setRenderParameter("quocGiaId", quocGiaId);
			actionResponse.setRenderParameter("idTrangThai", quocGiaId);
		}
		actionResponse.setRenderParameter("searchKeyWord", searchKeyWord);
		actionResponse.setRenderParameter("_searchKeyWord", _searchKeyWord);
		actionResponse.setRenderParameter("idQuyTrinh", idQuyTrinh);
	}

	/**
	 * This is function validationData
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param cmnd
	 * @param ngaySinh
	 * @param idGioiTinh
	 * @param idXaHienTai
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationData(String firstName, String middleName,
			String lastName, String cmnd, String ngaySinh, String idGioiTinh,
			String numberHome, String idTinhHienTai, String idHuyenHienTai,
			String idXaHienTai, ActionRequest actionRequest) {
		SessionErrors.clear(actionRequest);
		if (firstName.length() == 0) {
			SessionErrors.add(actionRequest, "requireFirstName");
		}
//		if (middleName.trim().length() == 0) {
//			SessionErrors.add(actionRequest, "requireMiddleName");
//		}
		if (lastName.length() == 0) {
			SessionErrors.add(actionRequest, "requireLastName");
		}
		if (cmnd.length() == 0) {
			SessionErrors.add(actionRequest, "requireCMND");
		} else {
			if (ConvertUtil.convertToLong(cmnd) <= 0) {
				SessionErrors.add(actionRequest, "numberCMND");
			} else if (cmnd.length() != 9 && cmnd.length() != 12) {
				SessionErrors.add(actionRequest, "arrangeCMND");
			} else {
				List<CongDan> listCongDan = findByCMND(cmnd);
				if (listCongDan.size() > 0) {
					SessionErrors.add(actionRequest, "exitCMND");
				}
			}
		}
		if (ngaySinh.length() == 0) {
			SessionErrors.add(actionRequest, "requireNgaySinh");
		} else {
			Date currentDate = new Date();
			if (ngaySinh.trim().length() > 0 && ConvertUtil.parseStringToDate(ngaySinh.trim()).compareTo(currentDate) > 0) {
			//if (ConvertUtil.parseStringToDate(ngaySinh.trim()).compareTo(new Date()) > 0 || ngaySinh.trim().equals(ConvertUtil.parseDateToTring(new Date()))) {
				SessionErrors.add(actionRequest, "invalidNgaySinh");
			}
		}
		if (ConvertUtil.convertToInt(idGioiTinh) == 0) {
			SessionErrors.add(actionRequest, "requireGioiTinh");
		}
		if (numberHome.length() == 0) {
			SessionErrors.add(actionRequest, "requireNumberhome");
		}
		if (ConvertUtil.convertToInt(idTinhHienTai) == 0) {
			SessionErrors.add(actionRequest, "requireTinh");
		}
		if (ConvertUtil.convertToInt(idHuyenHienTai) == 0) {
			SessionErrors.add(actionRequest, "requireHuyen");
		}
		if (ConvertUtil.convertToInt(idXaHienTai) == 0) {
			SessionErrors.add(actionRequest, "requireXa");
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	
	/**
	 * This is function validationDataDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maSoDoanhNghiep
	 * @param maSothueDoanhNghiep
	 * @param tenDoanhNghiep
	 * @param soGiayPhepDangKyDoanhNghiep
	 * @param ngayCapGiayPhepDangKyDoanhNghiep
	 * @param tongSoVon
	 * @param idLoaiDoiTuong
	 * @param numberHome
	 * @param idTinhHienTai
	 * @param idHuyenHienTai
	 * @param idXaHienTai
	 * @param moTaNganhNgheKinhDoanh
	 * @param quocGiaId
	 * @param idTrangThai
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationDataDoanhNghiep(String maSoDoanhNghiep, String maSothueDoanhNghiep, String tenDoanhNghiep, String soGiayPhepDangKyDoanhNghiep, 
	String ngayCapGiayPhepDangKyDoanhNghiep, String tongSoVon, String idLoaiDoiTuong, String numberHome, String idTinhHienTai, 
	String idHuyenHienTai, String idXaHienTai, String moTaNganhNgheKinhDoanh, String quocGiaId, String idTrangThai, ActionRequest actionRequest) {
		SessionErrors.clear(actionRequest);
		if (tenDoanhNghiep.length() == 0) {
			SessionErrors.add(actionRequest, "requireTenDoanhNghiep");
		} else {
			DoanhNghiep doanhNghiep = DoanhNghiepLocalServiceUtil.findByTen(tenDoanhNghiep);
			if (doanhNghiep != null) {
				SessionErrors.add(actionRequest, "exitTenDoanhNghiep");
			}
		}
		if (ngayCapGiayPhepDangKyDoanhNghiep.trim().length() == 0) {
			SessionErrors.add(actionRequest, "requireNgayCapGiayPhepDangKyDoanhNghiep");
		} else {
			if (ConvertUtil.parseStringToDate(ngayCapGiayPhepDangKyDoanhNghiep).after(new Date())) {
				SessionErrors.add(actionRequest, "afterNgayCapGiayPhepDangKyDoanhNghiep");
			}
		}
		if (moTaNganhNgheKinhDoanh.length() == 0) {
			SessionErrors.add(actionRequest, "requireMoTaNganhNgheKinhDoanh");
		}
		
		if (maSoDoanhNghiep.trim().length() == 0) {
			SessionErrors.add(actionRequest, "requireMaSoDoanhNghiep");
		} else if (ConvertUtil.convertToLong(maSoDoanhNghiep) <= 0) {
			SessionErrors.add(actionRequest, "numberMaSoDoanhNghiep");
		} else {
			DoanhNghiep doanhNghiep = DoanhNghiepLocalServiceUtil.findByMaDoanhNghiep(maSoDoanhNghiep);
			if (doanhNghiep != null) {
				SessionErrors.add(actionRequest, "exitMaSoDoanhNghiep");
			}
		}
		if (maSothueDoanhNghiep.trim().length() == 0) {
			SessionErrors.add(actionRequest, "requireMaSothueDoanhNghiep");
		} else if (ConvertUtil.convertToLong(maSothueDoanhNghiep) <= 0) {
			SessionErrors.add(actionRequest, "numberMaSothueDoanhNghiep");
		} else {
			DoanhNghiep doanhNghiep = DoanhNghiepLocalServiceUtil.findByMaSoThue(maSothueDoanhNghiep);
			if (doanhNghiep != null) {
				SessionErrors.add(actionRequest, "exitMaSothueDoanhNghiep");
			}
		}
		if (soGiayPhepDangKyDoanhNghiep.trim().length() == 0) {
			SessionErrors.add(actionRequest, "requireSoGiayPhepDangKyDoanhNghiep");
		} else if (ConvertUtil.convertToLong(soGiayPhepDangKyDoanhNghiep) <= 0) {
			SessionErrors.add(actionRequest, "numberSoGiayPhepDangKyDoanhNghiep");
		} else {
			DoanhNghiep doanhNghiep = DoanhNghiepLocalServiceUtil.findBySoGCNDKKD(soGiayPhepDangKyDoanhNghiep);
			if (doanhNghiep != null) {
				SessionErrors.add(actionRequest, "exitSoGiayPhepDangKyDoanhNghiep");
			}
		}
		if (tongSoVon.trim().length() == 0) {
			SessionErrors.add(actionRequest, "requireTongSoVon");
		} else if (ConvertUtil.convertToLong(tongSoVon) <= 0) {
			SessionErrors.add(actionRequest, "numberTongSoVon");
		}
		if (ConvertUtil.convertToLong(quocGiaId) <= 0) {
			SessionErrors.add(actionRequest, "numberQuocGia");
		}
		if (ConvertUtil.convertToLong(idLoaiDoiTuong) <= 0) {
			SessionErrors.add(actionRequest, "numberLoaiDoiTuong");
		}
		if (numberHome.length() == 0) {
			SessionErrors.add(actionRequest, "requireNumberhome");
		}
		if (ConvertUtil.convertToInt(idTinhHienTai) == 0) {
			SessionErrors.add(actionRequest, "requireTinh");
		}
		if (ConvertUtil.convertToInt(idHuyenHienTai) == 0) {
			SessionErrors.add(actionRequest, "requireHuyen");
		}
		if (ConvertUtil.convertToInt(idXaHienTai) == 0) {
			SessionErrors.add(actionRequest, "requireXa");
		}
		if (ConvertUtil.convertToLong(idTrangThai) <= 0) {
			SessionErrors.add(actionRequest, "numberIdTrangThai");
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * This is function findDonViHanhChinhCapTinhThanhPho
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<DonViHanhChinh>
	 */
	public List<DonViHanhChinh> findDonViHanhChinhCapTinhThanhPho() {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DonViHanhChinh.class);

		// This is a test line for display all request if there's no search
		// criteria
		Collection<Object> values = new ArrayList<Object>();
		values.add(1L);
		values.add(4L);
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
		Criterion criteriaCap = RestrictionsFactoryUtil.in(
				"capDonViHanhChinhId", values);

		// Define search criteria
		query = query.add(criteriaCap).add(criteriaTrangThai);

		try {
			return DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<DonViHanhChinh>();
	}

	/**
	 * This is function findDonViHanhChinhByChaId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chaId
	 * @return List<DonViHanhChinh>
	 */
	public List<DonViHanhChinh> findDonViHanhChinhByChaId(long chaId) {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DonViHanhChinh.class);

		// This is a test line for display all request if there's no search
		// criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
		Criterion criteriaChaId = RestrictionsFactoryUtil.eq("chaId", chaId);

		// Define search criteria
		query = query.add(criteriaChaId).add(criteriaTrangThai);

		try {
			return DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<DonViHanhChinh>();
	}

	/**
	 * This is function findAllGioiTinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<GioiTinh>
	 */
	public List<GioiTinh> findAllGioiTinh() {
		List<GioiTinh> results = null;

		try {
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(GioiTinh.class);

			// This is a test line for display all request if there's no search
			// criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil
					.eq("daXoa", 0);

			// Define search criteria
			query = query.add(criteriaTrangThai);

			results = GioiTinhLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		if (results == null) {
			results = new ArrayList<GioiTinh>();
		}

		return results;
	}
	
	/**
	 * This is function findLoaiDoiTuong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param listWithout
	 * @return List<DoiTuongSuDung>
	 */
	public List<DoiTuongSuDung> findLoaiDoiTuong(List<String> listWithout) {
		List<DoiTuongSuDung> results = new ArrayList<DoiTuongSuDung>();

		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoiTuongSuDung.class);

			// This is a test line for display all request if there's no search
			// criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);

			// Define search criteria
			query = query.add(criteriaTrangThai);

			List<DoiTuongSuDung> listBefore = DoiTuongSuDungLocalServiceUtil.dynamicQuery(query);
			for (DoiTuongSuDung doiTuongSuDung : listBefore) {
				if (!listWithout.contains(doiTuongSuDung.getMa().trim().toLowerCase())) {
					results.add(doiTuongSuDung);
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}

		if (results == null) {
			results = new ArrayList<DoiTuongSuDung>();
		}

		return results;
	}

	/**
	 * This is function deleteFileUploadById
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws Exception
	 * @return JSONObject
	 */
	public JSONObject deleteFileUploadById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		String fileDinhKemId = ParamUtil.getString(resourceRequest, "fileDinhKemId");
		String taiLieuChungThucId = ParamUtil.getString(resourceRequest, "taiLieuChungThucId");
		String noiLuuTruId = ParamUtil.getString(resourceRequest, "noiLuuTruId");
		
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		try {
			try {
				IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
				iDocumentStorage.deleteFile(ConvertUtil.convertToLong(noiLuuTruId));
				FileDinhKemLocalServiceUtil.deleteFileDinhKem(ConvertUtil.convertToLong(fileDinhKemId));
				TaiLieuChungThucLocalServiceUtil.deleteTaiLieuChungThuc(ConvertUtil.convertToLong(taiLieuChungThucId));
			} catch (Exception es) {
				es.printStackTrace();
			}
			jsonFeed.put("deleteComplete", "completed");
		} catch (Exception es) {
			es.printStackTrace();
			jsonFeed.put("deleteComplete", "error");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
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
	 * @throws Exception
	 * @return JSONObject
	 */
	public JSONObject checkFileUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		String tenFileUpload = ParamUtil.getString(resourceRequest, "tenFileUpload").trim();
		String idQuyTrinh = ParamUtil.getString(resourceRequest, "idQuyTrinh");
		String checkName = ParamUtil.getString(resourceRequest, "checkName");
		
		// Process Jason feed
		boolean flag = true;
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		try {
			if (resourceRequest.getPortletSession().getAttribute(TEN_FILE_UPLOAD) != null) {
				Hashtable<String, String> listTenFile = (Hashtable<String, String>)resourceRequest.getPortletSession().getAttribute(TEN_FILE_UPLOAD);
				Enumeration enumeration = listTenFile.keys();
				String fileUpload = "";
				String keyUpload = "";
				while (enumeration.hasMoreElements()) {
					keyUpload = enumeration.nextElement().toString();
					fileUpload = listTenFile.get(keyUpload);
					if (fileUpload.toLowerCase().compareTo(tenFileUpload.toLowerCase()) == 0) {
						if (keyUpload.compareTo(checkName) != 0) {
							jsonFeed.put("exitFile", "exitFile");
							flag = false;
							break;
						}
					}
				}
				if (flag) {
					listTenFile.put(checkName, tenFileUpload);
					resourceRequest.getPortletSession().setAttribute(TEN_FILE_UPLOAD, listTenFile);
				}
			} else {
				Hashtable<String, String> listTenFile  = new Hashtable<String, String>();
				listTenFile.put(checkName, tenFileUpload);
				resourceRequest.getPortletSession().setAttribute(TEN_FILE_UPLOAD, listTenFile);
			}

			if (flag) {
				if (resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE) != null) {
					List<FileDinhKem> listResultBefore = (ArrayList<FileDinhKem>)resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
					for (FileDinhKem fileUpload : listResultBefore) {
						TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(fileUpload.getNoiLuuTruTaiLieuId());
						if (taiLieuChungThuc.getTen().toLowerCase().compareTo(tenFileUpload.toLowerCase()) == 0) {
							jsonFeed.put("exitFile", "exitFile");
							flag = false;
							break;
						}
					}
				}
			}
			if (flag) {
				List<TaiLieuChungThuc> lieuChungThucs = findByHosotthcCongIdAndTen(ConvertUtil.convertToLong(idQuyTrinh), tenFileUpload);
				if (lieuChungThucs.size() > 0) {
					jsonFeed.put("exitFile", "exitFile");
				} else {
					jsonFeed.put("exitFile", "notExitFile");
				}
			}
		} catch (Exception es) {
			jsonFeed.put("exitFile", "notExitFile");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
	}

	
	/**
	 * This is function deleteFileUploadKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws Exception
	 * @return JSONObject
	 */
	public JSONObject deleteFileUploadKetQua(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		String taiLieuChungThucId = ParamUtil.getString(resourceRequest, "taiLieuChungThucId");
		String hoSoTTHCCongId = ParamUtil.getString(resourceRequest, "hoSoTTHCCongId");
		
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		try {
			List<FileDinhKem> listFile = FileDinhKemLocalServiceUtil.findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(ConvertUtil.convertToLong(hoSoTTHCCongId), ConvertUtil.convertToLong(taiLieuChungThucId));
			if (listFile.size() > 0) {
				FileDinhKemLocalServiceUtil.deleteFileDinhKem(listFile.get(0));
			}
			try {
				TaiLieuChungThucLocalServiceUtil.deleteTaiLieuChungThuc(ConvertUtil.convertToLong(taiLieuChungThucId));
			} catch (Exception es) {
			}
			jsonFeed.put("deleteComplete", "completed");
			
		} catch (Exception es) {
			jsonFeed.put("deleteComplete", "error");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
	}

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
	 * @throws Exception
	 * @return JSONObject
	 */
	public JSONObject deleteFileUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		String fileEntryId = ParamUtil.getString(resourceRequest, "fileId");
		
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		try {
			TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(ConvertUtil.convertToLong(fileEntryId));
			try {
				TaiLieuChungThucLocalServiceUtil.deleteTaiLieuChungThuc(ConvertUtil.convertToLong(fileEntryId));
			} catch (Exception es) {
			}
			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
			iDocumentStorage.deleteFile(taiLieuChungThuc.getNoiLuuTruId());
			jsonFeed.put("deleteComplete", "completed");
			
			if (resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE) != null) {
				List<FileDinhKem> listResultBefore = (ArrayList<FileDinhKem>)resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
				List<FileDinhKem> listResult = new ArrayList<FileDinhKem>();
				Hashtable<String, String> listTenFile = null;
				for (FileDinhKem fileUpload : listResultBefore) {
					if (fileUpload.getNoiLuuTruTaiLieuId() != ConvertUtil.convertToLong(fileEntryId)) {
						listResult.add(fileUpload);
						listTenFile = removeObject((Hashtable<String, String>)resourceRequest.getPortletSession().getAttribute(TEN_FILE_UPLOAD), taiLieuChungThuc.getTen());
						if (listTenFile != null) {
							resourceRequest.getPortletSession().setAttribute(TEN_FILE_UPLOAD, listTenFile);
						}
					}
				}
				if (listResult.size() > 0) {
					resourceRequest.getPortletSession().setAttribute(DATA_UPLOAD_FILE, listResult);
				} else {
					resourceRequest.getPortletSession().removeAttribute(DATA_UPLOAD_FILE);
					resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
				}
			}
		} catch (Exception es) {
			jsonFeed.put("deleteComplete", "error");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
	}

	/**
	 * This is function removeObject
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param listTable
	 * @param tenFile
	 * @return Hashtable<String, String>
	 */
	private Hashtable<String, String> removeObject(Hashtable<String, String> listTable, String tenFile) {
		if (listTable != null) {
			Hashtable<String, String> listTenFile  = new Hashtable<String, String>();
			Enumeration enumeration = listTable.keys();
			String tenFileUpload = "";
			String keyUpload = "";
			while (enumeration.hasMoreElements()) {
				keyUpload = enumeration.nextElement().toString();
				tenFileUpload = listTenFile.get(keyUpload);
				if (tenFileUpload.toLowerCase().compareTo(tenFile.toLowerCase()) != 0) {
					listTenFile.put(keyUpload, tenFileUpload);
				}
			}
			return listTenFile;
		}
		return null;
	}
	
	/**
	 * This is function singleFileUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void singleFileUpload(ActionRequest resourceRequest, ActionResponse actionResponse) {
		List<FileDinhKem> listResult = new ArrayList<FileDinhKem>();
		if (resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE) != null) {
			listResult = (ArrayList<FileDinhKem>)resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
		}
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		long folderId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		InputStream inputStream = null;
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					
					ResultUpload upload = iDocumentStorage.upload(PortalUtil.getUser(resourceRequest).getUserId(), folderId, byteArrayOutputStream.toByteArray(), "Offile_" + System.currentTimeMillis(), 999999999);
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						TaiLieuChungThuc taiLieuChungThuc = addTaiLieuChungThuc(upload, uploadRequest, resourceRequest, uploadRequest.getParameter(tenFileUpload.replace("taiLieuDinhKem", "tenLieuDinhKem")), 0);
						if (taiLieuChungThuc != null) {
							FileDinhKem fileDinhKem = createDinhKem(upload, taiLieuChungThuc, resourceRequest, getCanBoId(resourceRequest));
							if (fileDinhKem != null) {
								listResult.add(fileDinhKem);
							}
						}
					}
				}
			}
		} catch (Exception es){
			es.printStackTrace();
		}
		try {
			actionResponse.setWindowState(LiferayWindowState.NORMAL);
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
		}
		actionResponse.setRenderParameter("searchKeyWord", uploadRequest.getParameter("searchKeyWord"));
		actionResponse.setRenderParameter("_searchKeyWord", uploadRequest.getParameter("_searchKeyWord"));
		actionResponse.setRenderParameter("idQuyTrinh", uploadRequest.getParameter("idQuyTrinh"));
		actionResponse.setRenderParameter("idCongDan", uploadRequest.getParameter("idCongDan"));
		actionResponse.setRenderParameter("soDienThoaiCongDan", uploadRequest.getParameter("_soDienThoaiCongDan"));
		actionResponse.setRenderParameter("transactionKeyword", uploadRequest.getParameter("transactionKeyword"));
		actionResponse.setRenderParameter("transType", uploadRequest.getParameter("transType"));
		actionResponse.setRenderParameter("statusHS", uploadRequest.getParameter("statusHS"));
		resourceRequest.getPortletSession().setAttribute(DATA_UPLOAD_FILE, listResult);
		resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/inputHoSo.jsp");
	}
	
	/**
	 * This is function singleFileUploadDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void singleFileUploadDoanhNghiep(ActionRequest resourceRequest, ActionResponse actionResponse) {
		List<FileDinhKem> listResult = new ArrayList<FileDinhKem>();
		if (resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE) != null) {
			listResult = (ArrayList<FileDinhKem>)resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
		}
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		long folderId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		InputStream inputStream = null;
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					
					ResultUpload upload = iDocumentStorage.upload(PortalUtil.getUser(resourceRequest).getUserId(), folderId, byteArrayOutputStream.toByteArray(), "Offile_" + System.currentTimeMillis(), 999999999);
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						TaiLieuChungThuc taiLieuChungThuc = addTaiLieuChungThuc(upload, uploadRequest, resourceRequest, uploadRequest.getParameter(tenFileUpload.replace("taiLieuDinhKem", "tenLieuDinhKem")), 0);
						if (taiLieuChungThuc != null) {
							FileDinhKem fileDinhKem = createDinhKem(upload, taiLieuChungThuc, resourceRequest, getCanBoId(resourceRequest));
							if (fileDinhKem != null) {
								listResult.add(fileDinhKem);
							}
						}
					}
				}
			}
		} catch (Exception es){
			es.printStackTrace();
		}
		try {
			actionResponse.setWindowState(LiferayWindowState.NORMAL);
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
		}
		actionResponse.setRenderParameter("searchKeyWord", uploadRequest.getParameter("searchKeyWord"));
		actionResponse.setRenderParameter("_searchKeyWord", uploadRequest.getParameter("_searchKeyWord"));
		actionResponse.setRenderParameter("idQuyTrinh", uploadRequest.getParameter("idQuyTrinh"));
		actionResponse.setRenderParameter("idCongDanNop", uploadRequest.getParameter("idCongDanNop"));
		actionResponse.setRenderParameter("idCongDan", uploadRequest.getParameter("idCongDan"));
		actionResponse.setRenderParameter("soDienThoaiCongDan", uploadRequest.getParameter("_soDienThoaiCongDan"));
		actionResponse.setRenderParameter("transactionKeyword", uploadRequest.getParameter("transactionKeyword"));
		actionResponse.setRenderParameter("transType", uploadRequest.getParameter("transType"));
		actionResponse.setRenderParameter("statusHS", uploadRequest.getParameter("statusHS"));
		resourceRequest.getPortletSession().setAttribute(DATA_UPLOAD_FILE, listResult);
		resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/inputHoSo.jsp");
	}
	
	/**
	 * This is function uploadLoadFileKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void uploadLoadFileKetQua(ActionRequest resourceRequest, ActionResponse actionResponse) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		FileDinhKem fileDinhKem = null;
		InputStream inputStream = null;
		long canBoId = getCanBoId(resourceRequest);
		String HosotthcCongId = uploadRequest.getParameter("HosotthcCongId");
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				long danhmucGiayToId = ConvertUtil.convertToLong(tenFileUpload);
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					ResultUpload upload = iDocumentStorage.uploadTraKetQua(Long.valueOf(HosotthcCongId), PortalUtil.getUser(resourceRequest).getUserId(), byteArrayOutputStream.toByteArray(), uploadRequest.getFileName(tenFileUpload));
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						try {
							TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUser(resourceRequest).getUserId());
							List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId());
							TaiLieuChungThuc taiLieuChungThuc = new TaiLieuChungThucClp();
							
							long congDanNopId = ParamUtil.getLong(uploadRequest, "congDanNopId");
							_log.info("\n=== cong dan:" + congDanNopId);
							CongDan congDan = CongDanLocalServiceUtil.fetchCongDan(congDanNopId);
							
							_log.info("\n=== congDan.getTaiKhoanNguoiDungId():" + congDan.getTaiKhoanNguoiDungId());
							TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(congDan.getTaiKhoanNguoiDungId());
							if (taiKhoanNguoiDung != null) {
								taiLieuChungThuc.setChuSohuuId(taiKhoanNguoiDung.getId()); 
							}
							
							taiLieuChungThuc.setDanhMucGiayToId(danhmucGiayToId);
							taiLieuChungThuc.setGhiChu("");
							taiLieuChungThuc.setHoSoTTHCCId(ConvertUtil.convertToLong(HosotthcCongId));
							taiLieuChungThuc.setNoiLuuTruId(upload.getFileId());
							taiLieuChungThuc.setTrangThai(Constaints.Document.FROM_OTHER_DVC);
							taiLieuChungThuc.setTen(uploadRequest.getParameter(tenFileUpload + "_ten"));
							taiLieuChungThuc.setNgayUpload(new Date());
							taiLieuChungThuc.setNgaySua(new Date());
							taiLieuChungThuc.setNguoiUploadId(nguoiDung.getId());
							String tuNgay = uploadRequest.getParameter("tuNgay_"+danhmucGiayToId);
							String denNgay = uploadRequest.getParameter("denNgay_"+danhmucGiayToId);
							Date tuNgayDate = null;
							Date denNgayDate = null;
							if (Validator.isNotNull(tuNgay)) {
								tuNgayDate = org.oep.cmon.admin.portlet.util.ConvertUtil.parseStringToDate(tuNgay);
							}
							if (Validator.isNotNull(denNgay)) {
								denNgayDate = org.oep.cmon.admin.portlet.util.ConvertUtil.parseStringToDate(denNgay);
							}
							int version = TaiLieuChungThucLocalServiceUtil.getMaxVersion(taiKhoanNguoiDung.getId(), danhmucGiayToId);
							taiLieuChungThuc.setPhienBan(version+1);
							taiLieuChungThuc.setHieuLucTuNgay(tuNgayDate);
							taiLieuChungThuc.setHieuLucDenNgay(denNgayDate);
							taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.add(taiLieuChungThuc);
							fileDinhKem = new FileDinhKemClp();
							fileDinhKem.setSoBanGiay(1);
							fileDinhKem.setDaDoiChieu(0);
							fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(1);
							fileDinhKem.setNoiLuuTruTaiLieuId(taiLieuChungThuc.getId());
							fileDinhKem.setNguoiUpload(PortalUtil.getUser(resourceRequest).getEmailAddress());
							fileDinhKem.setNgayUpload(new Date());
							fileDinhKem.setDanhMucGiayToId(ConvertUtil.convertToLong(tenFileUpload));
							fileDinhKem.setNgaySua(new Date());
							fileDinhKem.setNguoiSua(PortalUtil.getUser(resourceRequest).getEmailAddress());
							fileDinhKem.setHoSoTTHCCongId(ConvertUtil.convertToLong(HosotthcCongId));
							fileDinhKem.setThuTuc2GiayToId(ConvertUtil.convertToLong(uploadRequest.getParameter(tenFileUpload + "_thutuc2giayto")));//Them sau....
							fileDinhKem.setXoa(0);// (0: Khong xoa, 1: Xoa)
							if (canBoId > 0) {
								fileDinhKem.setCanBoId(canBoId);
							}
							
							if(congChucs.size() > 0 ){
								fileDinhKem.setCanBoId(congChucs.get(0).getId());
						   	}
							fileDinhKem.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
							FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
						} catch (Exception es) {
							es.printStackTrace();
						}
					} else { // update
						List<FileDinhKem> liFileUploadsIservice3 = ConvertUtil.convertFromObjectToFileDinhKem(
								FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(Long.parseLong(HosotthcCongId), 3));
						for (FileDinhKem fileUpload : liFileUploadsIservice3) {
							TaiLieuChungThuc taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null && fileUpload.getDanhMucGiayToId()== Long.parseLong(tenFileUpload)) {
								String tuNgay = uploadRequest.getParameter("tuNgay_"+taiLieuChungThuc.getDanhMucGiayToId());
								String denNgay = uploadRequest.getParameter("denNgay_"+taiLieuChungThuc.getDanhMucGiayToId());
								Date tuNgayDate = null;
								Date denNgayDate = null;
								if (Validator.isNotNull(tuNgay)) {
									tuNgayDate = org.oep.cmon.admin.portlet.util.ConvertUtil.parseStringToDate(tuNgay);
								}
								if (Validator.isNotNull(denNgay)) {
									denNgayDate = org.oep.cmon.admin.portlet.util.ConvertUtil.parseStringToDate(denNgay);
								}
								taiLieuChungThuc.setHieuLucTuNgay(tuNgayDate);
								taiLieuChungThuc.setHieuLucDenNgay(denNgayDate);
								taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(taiLieuChungThuc);
								
								break;
							}
						}
						
						
						
					}
				}
			}
			resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		} catch (Exception es){
			es.printStackTrace();
		}
		actionResponse.setRenderParameter("transactionKeyword", uploadRequest.getParameter("searchKeyWord"));
		actionResponse.setRenderParameter("HosotthcCongId", uploadRequest.getParameter("HosotthcCongId"));
		actionResponse.setRenderParameter("transType", uploadRequest.getParameter("trangThaiHoSo"));
		actionResponse.setRenderParameter("statusHS", uploadRequest.getParameter("statusHS"));
		actionResponse.setRenderParameter("ThuTucHanhChinhId", uploadRequest.getParameter("ThuTucHanhChinhId"));
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/taiFileKetQua.jsp");
	}
	
	/**
	 * This is function uploadLoadFileKetQuaDoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void uploadLoadFileKetQuaDoanhNghiep(ActionRequest resourceRequest, ActionResponse actionResponse) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		FileDinhKem fileDinhKem = null;
		InputStream inputStream = null;
		long canBoId = getCanBoId(resourceRequest);
		String HosotthcCongId = uploadRequest.getParameter("HosotthcCongId");
		String ThuTucHanhChinhId = uploadRequest.getParameter("ThuTucHanhChinhId");
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					
					ResultUpload upload = iDocumentStorage.uploadTraKetQua(Long.valueOf(HosotthcCongId), PortalUtil.getUser(resourceRequest).getUserId(), byteArrayOutputStream.toByteArray(), uploadRequest.getFileName(tenFileUpload));
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUser(resourceRequest).getUserId());
						List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId());
						TaiLieuChungThuc taiLieuChungThuc = new TaiLieuChungThucClp();
						taiLieuChungThuc.setChuSohuuId(nguoiDung.getId());
						taiLieuChungThuc.setDanhMucGiayToId(ConvertUtil.convertToLong(tenFileUpload));
						taiLieuChungThuc.setGhiChu("");
						taiLieuChungThuc.setHoSoTTHCCId(ConvertUtil.convertToLong(HosotthcCongId));
						taiLieuChungThuc.setNoiLuuTruId(upload.getFileId());
						taiLieuChungThuc.setTrangThai(Constants.DOCUMENT_NEW);
						taiLieuChungThuc.setTen(uploadRequest.getParameter(tenFileUpload + "_ten"));
						taiLieuChungThuc.setNgayUpload(new Date());
						taiLieuChungThuc.setNgaySua(new Date());
						taiLieuChungThuc.setNguoiUploadId(nguoiDung.getId());
						try {
							TaiLieuChungThuc taiLieuChungThuc2 = TaiLieuChungThucLocalServiceUtil.add(taiLieuChungThuc);

							fileDinhKem = new FileDinhKemClp();
							fileDinhKem.setSoBanGiay(1);
							fileDinhKem.setDaDoiChieu(0);
							fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(1);
							fileDinhKem.setNoiLuuTruTaiLieuId(taiLieuChungThuc2.getId());
							fileDinhKem.setNguoiUpload(PortalUtil.getUser(resourceRequest).getEmailAddress());
							fileDinhKem.setNgayUpload(new Date());
							fileDinhKem.setDanhMucGiayToId(ConvertUtil.convertToLong(tenFileUpload));
							fileDinhKem.setNgaySua(new Date());
							fileDinhKem.setNguoiSua(PortalUtil.getUser(resourceRequest).getEmailAddress());
							fileDinhKem.setHoSoTTHCCongId(ConvertUtil.convertToLong(HosotthcCongId));
							fileDinhKem.setThuTuc2GiayToId(ConvertUtil.convertToLong(uploadRequest.getParameter(tenFileUpload + "_thutuc2giayto")));//Them sau....
							fileDinhKem.setXoa(0);// (0: Khong xoa, 1: Xoa)
							if (canBoId > 0) {
								fileDinhKem.setCanBoId(canBoId);
							}
							
							if(congChucs.size() > 0 ){
								fileDinhKem.setCanBoId(congChucs.get(0).getId());
						   	}
							fileDinhKem.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
							FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
						} catch (Exception es) {
							es.printStackTrace();
						}
					}
				}
			}
			resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		} catch (Exception es){
			es.printStackTrace();
		}
		actionResponse.setRenderParameter("transactionKeyword", uploadRequest.getParameter("searchKeyWord"));
		actionResponse.setRenderParameter("HosotthcCongId", uploadRequest.getParameter("HosotthcCongId"));
		actionResponse.setRenderParameter("transType", uploadRequest.getParameter("trangThaiHoSo"));
		actionResponse.setRenderParameter("statusHS", uploadRequest.getParameter("statusHS"));
		actionResponse.setRenderParameter("ThuTucHanhChinhId", uploadRequest.getParameter("ThuTucHanhChinhId"));
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/taiFileKetQua.jsp");
	}
	
	/**
	 * This is function upLoadFileDangXuLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void upLoadFileDangXuLy(ActionRequest resourceRequest, ActionResponse actionResponse) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		long folderId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		long canBoId = getCanBoId(resourceRequest);
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		FileDinhKem fileDinhKem = null;
		InputStream inputStream = null;
		String HosotthcCongId = uploadRequest.getParameter("HosotthcCongId");
		String backUrl = uploadRequest.getParameter("backUrl");
		System.err.println("HosotthcCongId: "+HosotthcCongId);
		System.err.println("backUrl: "+backUrl);
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				System.err.println("tenFileUpload: "+tenFileUpload);
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				System.err.println("inputStream: "+inputStream);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					ResultUpload upload = iDocumentStorage.upload(PortalUtil.getUser(resourceRequest).getUserId(), folderId, byteArrayOutputStream.toByteArray(), "Offile_" + System.currentTimeMillis(), 10000);
					System.err.println("noi luu tru id: "+upload.getDocument().getNoiLuuTruId());
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUser(resourceRequest).getUserId());
						List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId());
						TaiLieuChungThuc taiLieuChungThuc = new TaiLieuChungThucClp();
						taiLieuChungThuc.setChuSohuuId(nguoiDung.getId());
						taiLieuChungThuc.setDanhMucGiayToId(ConvertUtil.convertToLong(tenFileUpload));
						taiLieuChungThuc.setGhiChu("");
						taiLieuChungThuc.setHoSoTTHCCId(ConvertUtil.convertToLong(HosotthcCongId));
						taiLieuChungThuc.setNoiLuuTruId(upload.getFileId());
						taiLieuChungThuc.setTrangThai(Constants.DOCUMENT_NEW);
						taiLieuChungThuc.setTen(uploadRequest.getParameter(tenFileUpload + "_ten"));
						taiLieuChungThuc.setNgayUpload(new Date());
						taiLieuChungThuc.setNgaySua(new Date());
						taiLieuChungThuc.setNguoiUploadId(nguoiDung.getId());
						try {
							TaiLieuChungThuc taiLieuChungThuc2 = TaiLieuChungThucLocalServiceUtil.add(taiLieuChungThuc);

							fileDinhKem = new FileDinhKemClp();
							fileDinhKem.setSoBanGiay(1);
							fileDinhKem.setDaDoiChieu(0);
							fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(1);
							fileDinhKem.setNoiLuuTruTaiLieuId(taiLieuChungThuc2.getId());
							fileDinhKem.setNguoiUpload(PortalUtil.getUser(resourceRequest).getEmailAddress());
							fileDinhKem.setNgayUpload(new Date());
							fileDinhKem.setDanhMucGiayToId(ConvertUtil.convertToLong(tenFileUpload));
							fileDinhKem.setNgaySua(new Date());
							fileDinhKem.setNguoiSua(PortalUtil.getUser(resourceRequest).getEmailAddress());
							fileDinhKem.setHoSoTTHCCongId(ConvertUtil.convertToLong(HosotthcCongId));
							fileDinhKem.setThuTuc2GiayToId(ConvertUtil.convertToLong(uploadRequest.getParameter(tenFileUpload + "_thutuc2giayto")));//Them sau....
							fileDinhKem.setXoa(0);// (0: Khong xoa, 1: Xoa)
							if (canBoId > 0) {
								fileDinhKem.setCanBoId(canBoId);
							}
							
							if(congChucs.size() > 0 ){
								fileDinhKem.setCanBoId(congChucs.get(0).getId());
						   	}
							fileDinhKem.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
							FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
						} catch (Exception es) {
							es.printStackTrace();
						}
					}
				}
			}
			resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		} catch (Exception es){
			es.printStackTrace();
		}
		if (backUrl.equals(org.oep.cmon.Constants.JSP_DANH_SACH_HO_SO_XU_LY)) {
			actionResponse.setRenderParameter("HosotthcCongId", uploadRequest.getParameter("HosotthcCongId"));
			actionResponse.setRenderParameter("jspPage", org.oep.cmon.Constants.JSP_DANH_SACH_HO_SO_XU_LY);
		}
		else {
			actionResponse.setRenderParameter("idHoSo", uploadRequest.getParameter("HosotthcCongId"));
			actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp");
		}
	}
	
	
	/**
	 * This is function addFileUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void addFileUpload(ActionRequest resourceRequest, ActionResponse actionResponse) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		long folderId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		long canBoId = getCanBoId(resourceRequest);
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		InputStream inputStream = null;
		String HosotthcCongId = uploadRequest.getParameter("HosotthcCongId");
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					
					ResultUpload upload = iDocumentStorage.upload(PortalUtil.getUser(resourceRequest).getUserId(), folderId, byteArrayOutputStream.toByteArray(), "Offile_" + System.currentTimeMillis(), 10000);
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						TaiLieuChungThuc taiLieuChungThuc = addTaiLieuChungThuc(upload, uploadRequest, resourceRequest, uploadRequest.getParameter(tenFileUpload.replace("taiLieuDinhKem", "tenLieuDinhKem")), ConvertUtil.convertToLong(HosotthcCongId));
						if (taiLieuChungThuc != null) {
							FileDinhKem fileDinhKem = createDinhKem(upload, taiLieuChungThuc, resourceRequest, getCanBoId(resourceRequest));
							if (fileDinhKem != null) {
								fileDinhKem.setHoSoTTHCCongId(ConvertUtil.convertToLong(HosotthcCongId));
								fileDinhKem.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
								FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
							}
						}
					}
				}
			}
			resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		} catch (Exception es){
			es.printStackTrace();
		}
		actionResponse.setRenderParameter("transactionKeyword", uploadRequest.getParameter("searchKeyWord"));
		actionResponse.setRenderParameter("HosotthcCongId", uploadRequest.getParameter("HosotthcCongId"));
		actionResponse.setRenderParameter("transType", uploadRequest.getParameter("trangThaiHoSo"));
		actionResponse.setRenderParameter("statusHS", uploadRequest.getParameter("statusHS"));
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/offline/taiThemTaiLieu.jsp");
	}
	
	/**
	 * This is function addFileDoanhNghiepUpload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param actionResponse
	 */
	public void addFileDoanhNghiepUpload(ActionRequest resourceRequest, ActionResponse actionResponse) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
		long folderId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		long canBoId = getCanBoId(resourceRequest);
		Enumeration<String> listName = uploadRequest.getParameterNames();
		String tenFileUpload = "";
		InputStream inputStream = null;
		String HosotthcCongId = uploadRequest.getParameter("HosotthcCongId");
		try {
			while (listName.hasMoreElements()) {
				tenFileUpload = listName.nextElement();
				inputStream = uploadRequest.getFileAsStream(tenFileUpload);
				if (inputStream != null) {
					BufferedInputStream byteArrayInputStream = new BufferedInputStream(
							inputStream);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int data = byteArrayInputStream.read();
					while (data != -1) {
						byteArrayOutputStream.write(data);
						data = byteArrayInputStream.read();
					}
					
					ResultUpload upload = iDocumentStorage.upload(PortalUtil.getUser(resourceRequest).getUserId(), folderId, byteArrayOutputStream.toByteArray(), "Offile_" + System.currentTimeMillis(), 10000);
					if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0) {
						TaiLieuChungThuc taiLieuChungThuc = addTaiLieuChungThuc(upload, uploadRequest, resourceRequest, uploadRequest.getParameter(tenFileUpload.replace("taiLieuDinhKem", "tenLieuDinhKem")), ConvertUtil.convertToLong(HosotthcCongId));
						if (taiLieuChungThuc != null) {
							FileDinhKem fileDinhKem = createDinhKem(upload, taiLieuChungThuc, resourceRequest, getCanBoId(resourceRequest));
							if (fileDinhKem != null) {
								fileDinhKem.setHoSoTTHCCongId(ConvertUtil.convertToLong(HosotthcCongId));
								fileDinhKem.setId(CounterLocalServiceUtil.increment(FILE_UPLOAD_SEQUENCE));
								FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
							}
						}
					}
				}
			}
			resourceRequest.getPortletSession().removeAttribute(TEN_FILE_UPLOAD);
		} catch (Exception es){
			es.printStackTrace();
		}
		actionResponse.setRenderParameter("transactionKeyword", uploadRequest.getParameter("searchKeyWord"));
		actionResponse.setRenderParameter("HosotthcCongId", uploadRequest.getParameter("HosotthcCongId"));
		actionResponse.setRenderParameter("transType", uploadRequest.getParameter("trangThaiHoSo"));
		actionResponse.setRenderParameter("statusHS", uploadRequest.getParameter("statusHS"));
		actionResponse.setRenderParameter("jspPage", "/html/portlet/ipmslistportlet/company/taiThemTaiLieu.jsp");
	}
	
	/**
	 * This is function getCanBoId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @return long
	 */
	private long getCanBoId(ActionRequest resourceRequest) {
		try {
			TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUser(resourceRequest).getUserId());
			if (taiKhoanNguoiDung != null) {
				List<CongChuc> liChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
				if (liChucs != null && liChucs.size() > 0) {
					return liChucs.get(0).getId();
				}
			}
		} catch (Exception es) {
		}
		return 0;
	}
	
	/**
	 * This is function findHoSoTTHCCong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maSoHoSo
	 * @param trangThaiHoSo
	 * @param cqqlId
	 * @param start
	 * @param end
	 * @return List<HoSoTTHCCong>
	 */
	public static List<HoSoTTHCCong> findHoSoTTHCCong(String maSoHoSo, int trangThaiHoSo, long cqqlId, int start, int end) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(HoSoTTHCCong.class);		
		// This is a test line for display all request if there's no search criteria
		Criterion criterionTrangThaiHoSo = RestrictionsFactoryUtil.eq("trangThaiHoSo", trangThaiHoSo);
		Criterion criterionCqqlId = RestrictionsFactoryUtil.eq("coQuanTiepNhanId", cqqlId);
		Order order = OrderFactoryUtil.desc("id");
		Order orderDate = OrderFactoryUtil.desc("ngayNopHoSo");
				
		// Define search criteria
		if (maSoHoSo.trim().length() > 0) {
			query = query.add(RestrictionsFactoryUtil.ilike("maSoHoSo", "%" + maSoHoSo + "%"));
		}
		query = query.add(RestrictionsFactoryUtil.and(criterionTrangThaiHoSo, criterionCqqlId)).addOrder(orderDate).addOrder(order);
				
		try {
			return HoSoTTHCCongLocalServiceUtil.dynamicQuery(query, start, end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return new ArrayList<HoSoTTHCCong>();
	}
	
	/**
	 * This is function countHoSoTTHCCongByCoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maSoHoSo
	 * @param trangThaiHoSo
	 * @param cqqlId
	 * @return long
	 */
	public static long countHoSoTTHCCongByCoQuanQuanLy(String maSoHoSo, int trangThaiHoSo, long cqqlId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(HoSoTTHCCong.class);		
		// This is a test line for display all request if there's no search criteria
		Criterion criterionTrangThaiHoSo = RestrictionsFactoryUtil.eq("trangThaiHoSo", trangThaiHoSo);
		Criterion criterionCqqlId = RestrictionsFactoryUtil.eq("coQuanTiepNhanId", cqqlId);
				
		// Define search criteria
		if (maSoHoSo.trim().length() > 0) {
			query = query.add(RestrictionsFactoryUtil.ilike("maSoHoSo", "%" + maSoHoSo + "%"));
		}
		query = query.add(criterionTrangThaiHoSo).add(criterionCqqlId);
				
		try {
			return HoSoTTHCCongLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * This is function createDinhKem
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param upload
	 * @param taiLieuChungThuc
	 * @param resourceRequest
	 * @param canBoId
	 * @return FileDinhKem
	 */
	private FileDinhKem createDinhKem(ResultUpload upload, TaiLieuChungThuc taiLieuChungThuc,ActionRequest resourceRequest, long canBoId) {
		FileDinhKem fileDinhKem = null;
		try {
			// create new object FileDinhKemImpl.
			fileDinhKem = new FileDinhKemClp();
			fileDinhKem.setSoBanGiay(1);
			fileDinhKem.setDaDoiChieu(0);
			fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(1);
			fileDinhKem.setNoiLuuTruTaiLieuId(taiLieuChungThuc.getId());
			fileDinhKem.setNguoiUpload(PortalUtil.getUser(resourceRequest).getEmailAddress());
			fileDinhKem.setNgayUpload(new Date());
			fileDinhKem.setNgaySua(new Date());
			fileDinhKem.setNguoiSua(PortalUtil.getUser(resourceRequest).getEmailAddress());
			fileDinhKem.setXoa(0);// (0: Khong xoa, 1: Xoa)
			if (canBoId > 0) {
				fileDinhKem.setCanBoId(canBoId);
			}
			
			return fileDinhKem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This is function addTaiLieuChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param upload
	 * @param uploadRequest
	 * @param resourceRequest
	 * @param tenFileUpload
	 * @param HosotthcCongId
	 * @return JSONObject
	 */
	private TaiLieuChungThuc addTaiLieuChungThuc(ResultUpload upload, UploadPortletRequest uploadRequest,
			ActionRequest resourceRequest, String tenFileUpload, long HosotthcCongId) {
		try {
			TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUser(resourceRequest).getUserId());
			TaiLieuChungThuc taiLieuChungThuc = new TaiLieuChungThucClp();
			taiLieuChungThuc.setChuSohuuId(nguoiDung.getId());
			taiLieuChungThuc.setGhiChu("");
			taiLieuChungThuc.setNoiLuuTruId(upload.getFileId());
			taiLieuChungThuc.setTrangThai(Constants.DOCUMENT_NEW);
			taiLieuChungThuc.setTen(tenFileUpload);
			taiLieuChungThuc.setNgayUpload(new Date());
			taiLieuChungThuc.setNgaySua(new Date());
			taiLieuChungThuc.setNgayDuyet(new Date());
			taiLieuChungThuc.setHieuLucTuNgay(new Date());
			if (HosotthcCongId > 0) {
				taiLieuChungThuc.setHoSoTTHCCId(HosotthcCongId);
			}
			taiLieuChungThuc.setHieuLucDenNgay(new Date());
			taiLieuChungThuc.setNguoiSua(nguoiDung.getEmail());
			taiLieuChungThuc.setNguoiUploadId(nguoiDung.getId());
			taiLieuChungThuc.setNguoiduyetId(nguoiDung.getId());
			
			TaiLieuChungThuc taiLieuChungThuc2 = TaiLieuChungThucLocalServiceUtil.add(taiLieuChungThuc);
			return taiLieuChungThuc2;
		} catch (Exception es) {
			es.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This is function findByHosotthcCongIdAndTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param HosotthcCongId
	 * @param name
	 * @return List<TaiLieuChungThuc>
	 */
	private List<TaiLieuChungThuc> findByHosotthcCongIdAndTen(long HosotthcCongId, String name) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiLieuChungThuc.class);		
		Criterion criterionHosotthcCongId = RestrictionsFactoryUtil.eq("hoSoTTHCCId", HosotthcCongId);
		Criterion criterionTen = RestrictionsFactoryUtil.eq("ten", name);
		query = query.add(RestrictionsFactoryUtil.and(criterionHosotthcCongId, criterionTen));
				
		try {
			return TaiLieuChungThucLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return new ArrayList<TaiLieuChungThuc>();
	}
	
	/**
	 * This is function getMaHoSoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maQuyTrinh
	 * @param online
	 * @return String
	 */
	public static String getMaHoSoSo(String maQuyTrinh, boolean online) {

		  String result = null;
		  try {
		   MaBienNhanImplPortType port = WebserviceFactory.getCapMaSoBienNhanService();
		   // String tokenReturn = port.getToken("soxaydung",
		   // "eb7efe9997711c24be9e625092a6adf0", "00017");
		   String tokenReturn = port.getToken("soxaydung", "eb7efe9997711c24be9e625092a6adf0", "00017");

		   KetQua ketqua = port.getMaBienNhan(tokenReturn, "00017",  maQuyTrinh, online);
		   result = ketqua.getMabiennhan();
		  } catch (Exception e) {
			  result = String.valueOf(System.currentTimeMillis());
		  }
		  if(result==null||result.length()==0){
			  result = String.valueOf(System.currentTimeMillis());
		  }
		  return result;
	 }
	
	/**
	 * This is function getMaQuyTrinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoThuTucHanhChinhId
	 * @return String
	 */
	private String getMaQuyTrinh(long hoSoThuTucHanhChinhId) {
		try {
			return ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSoThuTucHanhChinhId).getMa();
		} catch (Exception es) {
			try {
				return ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSoThuTucHanhChinhId).getMa();
			} catch (Exception es1) {
				
			}
		}
		return "";
	}
}
