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

package org.oep.cmon.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.document.util.FormatUtil;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;
import org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.KeyedParameter;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/** 
 * This is class ComUtils
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class ComUtils {
	
	
	// private static final QName SERVICE_NAME = new QName(
	// "http://hoso.provider.exch.sharedservice.dtt.vn/",
	// "ExchDocumentServiceImplService");
	/** 
	 * This is function checkTichHopMotCua
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @return boolean
	 */
	public static boolean checkTichHopMotCua(long thuTucHanhChinhId) {
		boolean retVal = false;
		ThuTucHanhChinh thuTucHanhChinh;
		try {
			if (thuTucHanhChinhId > 0) {
				thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil
						.fetchThuTucHanhChinh(thuTucHanhChinhId);
				if (thuTucHanhChinh != null
						&& thuTucHanhChinh.getCanTichHop() == 1) {
					retVal = true;
					
				}
			}
		} catch (Exception e) {

		}
		return retVal;
	}

	/** 
	 * This is function initUengineProcess
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param uengineProcessName
	 * @param accountCanBo
	 * @param idHoSo
	 * @param maSoHoSo
	 * @param tenDoiTuongHoSo
	 * @param ngayHenTra
	 * @return boolean
	 */
	public static boolean initUengineProcess(String uengineProcessName,
			String accountCanBo, long idHoSo, String maSoHoSo,
			String tenDoiTuongHoSo, Date ngayHenTra) {

		boolean retVal = false;
		Date currentDate = new Date();

		IBrms brms = WebserviceFactory.getUengineService();

		// for test
		// tthcMa = "CNDT_New";

		
		
		String instid = brms.initInstanceMaTTHC(accountCanBo, uengineProcessName);
		
		if (instid != null) {
			List<KeyedParameter> processVariable = new ArrayList<KeyedParameter>();

			KeyedParameter key0 = new KeyedParameter();
			// id ho so
			key0.setKey("id_hoso");
			key0.setValue(idHoSo + "");

			KeyedParameter key1 = new KeyedParameter();
			// ma so ho so
			key1.setKey("maHoSo");
			key1.setValue(maSoHoSo);

			KeyedParameter key2 = new KeyedParameter();
			// ten doi tuong ho so
			key2.setKey("tenDoiTuongHoSo");
			key2.setValue(tenDoiTuongHoSo);

			KeyedParameter key3 = new KeyedParameter();
			// ngay tiep nhan
			key3.setKey("ngayTiepNhan");
			key3.setValue(ConvertUtil.parseDateToTring(currentDate));

			KeyedParameter key4 = new KeyedParameter();
			// ngay hen tra
			key4.setKey("ngayHenTra");
			key4.setValue(ConvertUtil.parseDateToTring(ngayHenTra));

			processVariable.add(key0);
			processVariable.add(key1);
			processVariable.add(key2);
			processVariable.add(key3);
			processVariable.add(key4);

			retVal = brms.registerService(instid, processVariable);
		}

		return retVal;
	}

	/** 
	 * This is function initUengineProcess4SoXayDung
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param tthcMa
	 * @param accountCanBo
	 * @param idHoSo
	 * @param maSoHoSo
	 * @param tenDoiTuongHoSo
	 * @param ngayHenTra
	 * @param soTo
	 * @param soThua
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean initUengineProcess4SoXayDung(String tthcMa,
			String accountCanBo, long idHoSo, String maSoHoSo,
			String tenDoiTuongHoSo, Date ngayHenTra,String soTo, String soThua) throws SystemException {

		boolean retVal = false;
		Date currentDate = new Date();
		return retVal;
	}

	/** 
	 * This is function initUengineProcess4Rpms
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param tthcMa
	 * @param accountCanBo
	 * @param idHoSo
	 * @param maSoHoSo
	 * @param tenDoiTuongHoSo
	 * @param ngayHenTra
	 * @param noiNopHoSo
	 * @return boolean
	 */
	public static boolean initUengineProcess4Rpms(String tthcMa,
			String accountCanBo, long idHoSo, String maSoHoSo,
			String tenDoiTuongHoSo, Date ngayHenTra, String noiNopHoSo)
	{

		boolean retVal = false;
		Date currentDate = new Date();

		IBrms brms = WebserviceFactory.getUengineService();

		// for test
		// tthcMa = "CNDT_New";

		String instid = brms.initInstanceMaTTHC(accountCanBo, tthcMa);

		if (instid != null) {
			List<KeyedParameter> processVariable = new ArrayList<KeyedParameter>();

			KeyedParameter key0 = new KeyedParameter();
			// id ho so
			key0.setKey("id_hoso");
			key0.setValue(idHoSo + "");

			KeyedParameter key1 = new KeyedParameter();
			// ma so ho so
			key1.setKey("maHoSo");
			key1.setValue(maSoHoSo);

			KeyedParameter key2 = new KeyedParameter();
			// ten doi tuong ho so
			key2.setKey("tenDoiTuongHoSo");
			key2.setValue(tenDoiTuongHoSo);

			KeyedParameter key3 = new KeyedParameter();
			// ngay tiep nhan
			key3.setKey("ngayTiepNhan");
			key3.setValue(ConvertUtil.parseDateToTring(currentDate));

			KeyedParameter key4 = new KeyedParameter();
			// ngay hen tra
			key4.setKey("ngayHenTra");
			key4.setValue(ConvertUtil.parseDateToTring(ngayHenTra));

			KeyedParameter key5 = new KeyedParameter();
			// ngay hen tra
			key5.setKey("noiNopHoSo");
			key5.setValue(noiNopHoSo);

			processVariable.add(key0);
			processVariable.add(key1);
			processVariable.add(key2);
			processVariable.add(key3);
			processVariable.add(key4);
			processVariable.add(key5);

			retVal = brms.registerService(instid, processVariable);
		}

		return retVal;
	}
	
	/** 
	 * This is function initUengineProcess4EWDMS
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param tthcMa
	 * @param accountCanBo
	 * @param idHoSo
	 * @param maSoHoSo
	 * @param tenDoiTuongHoSo
	 * @param ngayHenTra
	 * @param noiNopHoSo
	 * @return boolean
	 */
	public static boolean initUengineProcess4EWDMS(String tthcMa,
			String accountCanBo, long idHoSo, String maSoHoSo,
			String tenDoiTuongHoSo, Date ngayHenTra, String noiNopHoSo)
	{
			
		boolean retVal = false;
		Date currentDate = new Date();

		IBrms brms = WebserviceFactory.getUengineService();

		// for test
		// tthcMa = "CNDT_New";

		String instid = brms.initInstanceMaTTHC(accountCanBo, tthcMa);

		if (instid != null) {
			List<KeyedParameter> processVariable = new ArrayList<KeyedParameter>();

			KeyedParameter key0 = new KeyedParameter();
			// id ho so
			key0.setKey("id_hoso");
			key0.setValue(idHoSo + "");

			KeyedParameter key1 = new KeyedParameter();
			// ma so ho so
			key1.setKey("maHoSo");
			key1.setValue(maSoHoSo);

			KeyedParameter key2 = new KeyedParameter();
			// ten doi tuong ho so
			key2.setKey("tenDoiTuongHoSo");
			key2.setValue(tenDoiTuongHoSo);

			KeyedParameter key3 = new KeyedParameter();
			// ngay tiep nhan
			key3.setKey("ngayTiepNhan");
			key3.setValue(ConvertUtil.parseDateToTring(currentDate));

			KeyedParameter key4 = new KeyedParameter();
			// ngay hen tra
			key4.setKey("ngayHenTra");
			key4.setValue(ConvertUtil.parseDateToTring(ngayHenTra));

			KeyedParameter key5 = new KeyedParameter();
			// ngay hen tra
			key5.setKey("noiNopHoSo");
			key5.setValue(noiNopHoSo);

			processVariable.add(key0);
			processVariable.add(key1);
			processVariable.add(key2);
			processVariable.add(key3);
			processVariable.add(key4);
			processVariable.add(key5);

			retVal = brms.registerService(instid, processVariable);
		}

		return retVal;
	}
	
	// Save trao doi y kien cong dan
	//trao doi giua congdan va can bo, va save vao table Ykientraodoi
	/** 
	 * This is function saveTraoDoi
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
		public static void saveTraoDoi(ActionRequest resourceRequest,
				ActionResponse httpReq) throws NumberFormatException, Exception {
			// hoso - String
			long idHoSo = FormatUtil.convertToLong(ParamUtil.getString(resourceRequest, "hoSoTTHCCongId"));
			String tieuDe = ParamUtil.getString(resourceRequest, "tieuDe").trim();
			String noiDung = ParamUtil.getString(resourceRequest, "noiDung").trim();
			String type = ParamUtil.getString(resourceRequest, "type").trim();
			String quayLaiLink = ParamUtil.getString(resourceRequest, "quayLaiLink").trim();
			String loaiCanBo =ParamUtil.getString(resourceRequest, "loaiCanBo");
			 System.err.println("loaiCanBo action:" +loaiCanBo);
			if (validatorsYKienTraoDoi(resourceRequest)) {
				//saveYKienTraoDoiToDB(resourceRequest, httpReq);
				
				saveYKienTraoDoiVaoDatabase(resourceRequest, httpReq);
				httpReq.setRenderParameter("type", String.valueOf(type) );
				httpReq.setRenderParameter("hoSoTTHCCongId", String.valueOf(idHoSo) );
				httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo) );
				httpReq.setRenderParameter("jspPage", "/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");

			} else {
				httpReq.setRenderParameter("tieuDe", String.valueOf(tieuDe));
				httpReq.setRenderParameter("noiDung", String.valueOf(noiDung));
				httpReq.setRenderParameter("hoSoTTHCCongId", String.valueOf(idHoSo) );
				httpReq.setRenderParameter("type", String.valueOf(type) );
				httpReq.setRenderParameter("quayLaiLink", String.valueOf(quayLaiLink));
				httpReq.setRenderParameter("jspPage", "/html/cmon/ykientraodoi/canbo_traodoi_form.jsp");
			}
			PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(resourceRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		
			// Save Y kien Doanh Nghiep - Gui -- Can Bo Tiep nhan
			
		/** 
		 * This is function saveYKienTraoDoiToDB
		 * 
		 * Version: 1.0
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  10-April-2013  Nam Dinh    Create new
		 * @param resourceRequest
		 * @param httpReq
		 * @param nguoiNhanId
		 * @throws NumberFormatException
		 * @throws Exception
		 * @return YKienTraoDoi
		 */
			public static YKienTraoDoi saveYKienTraoDoiToDB(ActionRequest resourceRequest,
					ActionResponse httpReq,long nguoiNhanId) throws NumberFormatException, Exception {

				long idYKienTraoDoi = ParamUtil.getLong(resourceRequest, "yKienTraoDoiId");
				long idHoSo = ConvertUtil.convertToLong(ParamUtil.getString(resourceRequest, "hoSoTTHCCongId"));
				long listCanBoTiepNhanId=0;
				HoSoTTHCCong hoSoTTHCCong = null;
				YKienTraoDoi yKienTraoDoi =null;
				
				if (idHoSo > 0){
					hoSoTTHCCong= HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(idHoSo);
				}
				
				if (idYKienTraoDoi > 0) {
					yKienTraoDoi = YKienTraoDoiLocalServiceUtil.fetchYKienTraoDoi(idYKienTraoDoi);
				} else {
					yKienTraoDoi = new YKienTraoDoiClp();
					yKienTraoDoi.setId(CounterLocalServiceUtil.increment("vn.dtt.cmon.dao.hosohcc.model.YKienTraoDoi"));
				}

				yKienTraoDoi.setNguoiNhanId(nguoiNhanId);
				
				// tieuDe - String
				String tieuDe = ParamUtil.getString(resourceRequest, "tieuDe").trim();
				yKienTraoDoi.setTieuDe(tieuDe);

				// noiDung - String
				String noiDung = ParamUtil.getString(resourceRequest, "noiDung").trim();
				yKienTraoDoi.setNoiDungYKien(noiDung);

				// nguoiGuiId
				String nguoiGuiId = ParamUtil.getString(resourceRequest, "nguoiGuiId");
				
				yKienTraoDoi.setNguoiGuiId(FormatUtil.convertToLong(nguoiGuiId));
				
				Date now = new Date		();
				yKienTraoDoi.setThoiGianGuiYKien(now);
				yKienTraoDoi.setTrangThai(1);
				yKienTraoDoi.setHoSoTTHCCongId(idHoSo);

				yKienTraoDoi.setLoai(0);
				yKienTraoDoi.setNoiLuuTruId(null);
				

				
				long chaId = FormatUtil.convertToLong(ParamUtil.getString(resourceRequest, "chaId"));

				if ( chaId >0 ){
					yKienTraoDoi.setChaiId(chaId);
				} else {
					yKienTraoDoi.setChaiId(null);
				}

				if (idYKienTraoDoi > 0) {
						yKienTraoDoi = YKienTraoDoiLocalServiceUtil.updateYKienTraoDoi(yKienTraoDoi);
				} else {
					yKienTraoDoi = YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);
				}
				return yKienTraoDoi;
			}
			
			/** 
			 * This is function saveYKienTraoDoiVaoDatabase
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param resourceRequest
			 * @param httpReq
			 * @throws NumberFormatException
			 * @throws Exception
			 * @return boolean
			 */
			private static boolean saveYKienTraoDoiVaoDatabase(ActionRequest resourceRequest,
					ActionResponse httpReq) throws NumberFormatException, Exception {
				
				long idHoSo = ConvertUtil.convertToLong(ParamUtil.getString(resourceRequest, "hoSoTTHCCongId"));
				
				HoSoTTHCCong hoSoTTHCCong = null;
				
				if (idHoSo > 0){
					hoSoTTHCCong= HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(idHoSo);
				}
				
				long yKienTraoDoiId = ConvertUtil.convertToLong(ParamUtil.getString(resourceRequest, "yKienTraoDoiId"));
					
					if (hoSoTTHCCong.getCanBoTiepNhanId() != null && hoSoTTHCCong.getCanBoTiepNhanId() >0){
						CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(hoSoTTHCCong.getCanBoTiepNhanId());
						if (congChuc !=null && congChuc.getTaiKhoanNguoiDungId() >0){
							TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
							if (taiKhoanNguoiDung != null && taiKhoanNguoiDung.getId() >0){
								saveYKienTraoDoiToDB(resourceRequest, httpReq,taiKhoanNguoiDung.getId());
							} 
						}
						
						
					} else {
						
						List<CongChuc> tiepNhanlist = null;
						
						if (hoSoTTHCCong.getCoQuanTiepNhanId() >0){
							tiepNhanlist = CongChucLocalServiceUtil.listCanBoTiepNhan(hoSoTTHCCong.getCoQuanTiepNhanId(), 0, 500);
						}
						
						if (tiepNhanlist.size() >0){
							for (int i=0; i< tiepNhanlist.size(); i++){
								CongChuc congChuc = tiepNhanlist.get(i);
								if (congChuc !=null && congChuc.getTaiKhoanNguoiDungId() >0){
									//TaiKhoanNguoiDung taiKhoanNguoiDung1 = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(congChuc.getTaiKhoanNguoiDungId());
									TaiKhoanNguoiDung taiKhoanNguoiDung1 = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
									if (taiKhoanNguoiDung1 != null && taiKhoanNguoiDung1.getId() >0){
										saveYKienTraoDoiToDB(resourceRequest, httpReq, taiKhoanNguoiDung1.getId());
									} 
								}
							}
						} 
						
					}
				
				return true;
			}
			
			/** 
			 * This is function validatorsYKienTraoDoi
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param actionrequest
			 * @throws SystemException
			 * @return boolean
			 */
			private static boolean validatorsYKienTraoDoi(ActionRequest actionrequest) throws SystemException {
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
			
//			HoSoTTHCCong hoSoTTHCCong = null;
//			long hoSoTTHCCongId = ConvertUtil.convertToLong(ParamUtil.getString(actionrequest, "hoSoTTHCCongId"));
//			
//			if(hoSoTTHCCongId >0){
//				hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoTTHCCongId);
//			}
//			List<CongChuc> tiepNhanlist = null;
//			if (hoSoTTHCCong.getCoQuanTiepNhanId() >0){
//				tiepNhanlist = CongChucLocalServiceUtil.listCanBoTiepNhan(hoSoTTHCCong.getCoQuanTiepNhanId(), 0, 500);
//			}
//			
//			if (hoSoTTHCCong.getCanBoTiepNhanId() == null && tiepNhanlist.size() ==0){
//				SessionErrors.add(actionrequest, "err.nguoiNhan");
//				valid = false;
//			} 
			
			if (!valid) {
				FormatUtil.setParams(actionrequest);
				Iterator<String> error = SessionErrors.iterator(actionrequest);
			}
			return valid;
		}
	
			
			/** 
			 * This is function saveTraoDoiCanBo
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param resourceRequest
			 * @param httpReq
			 * @throws NumberFormatException
			 * @throws Exception
			 */
			public static void saveTraoDoiCanBo(ActionRequest resourceRequest,
					ActionResponse httpReq) throws NumberFormatException, Exception {
				// hoso - String
				long idHoSo = FormatUtil.convertToLong(ParamUtil.getString(resourceRequest, "hoSoTTHCCongId"));
				String tieuDe = ParamUtil.getString(resourceRequest, "tieuDe").trim();
				String noiDung = ParamUtil.getString(resourceRequest, "noiDung").trim();
				String type = ParamUtil.getString(resourceRequest, "type").trim();
				
				long nguoiNhanId = ParamUtil.getLong(resourceRequest, "nguoiNhanId");
				String quayLaiLink = ParamUtil.getString(resourceRequest, "quayLaiLink").trim();
				
				String loaiCanBo =ParamUtil.getString(resourceRequest, "loaiCanBo");
				
				if (validatorsYKienTraoDoiCanBo(resourceRequest)) {
					saveYKienTraoDoiCanBoToDB(resourceRequest, httpReq);
					httpReq.setRenderParameter("hoSoTTHCCongId", String.valueOf(idHoSo) );
					httpReq.setRenderParameter("type", type );
					httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo));
					httpReq.setRenderParameter("jspPage", "/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");

				} else {
					httpReq.setRenderParameter("tieuDe", tieuDe );
					httpReq.setRenderParameter("noiDung", noiDung );
					httpReq.setRenderParameter("type", type );
					httpReq.setRenderParameter("nguoiNhanId", String.valueOf(nguoiNhanId ));
					httpReq.setRenderParameter("hoSoTTHCCongId", String.valueOf(idHoSo ));
					httpReq.setRenderParameter("quayLaiLink", String.valueOf(quayLaiLink ));
					httpReq.setRenderParameter("loaiCanBo", String.valueOf(loaiCanBo));
					httpReq.setRenderParameter("jspPage", "/html/cmon/ykientraodoi/canbo_traodoi_form.jsp");
				}
				
				PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				SessionMessages.add(resourceRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}

			/** 
			 * This is function saveYKienTraoDoiCanBoToDB
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param resourceRequest
			 * @param httpReq
			 * @throws NumberFormatException
			 * @throws Exception
			 * @return YKienTraoDoi
			 */	    
			public static YKienTraoDoi saveYKienTraoDoiCanBoToDB(ActionRequest resourceRequest,
					ActionResponse httpReq) throws NumberFormatException, Exception {

				long idYKienTraoDoi = ParamUtil.getLong(resourceRequest, "yKienTraoDoiId");
				long idHoSo = ConvertUtil.convertToLong(ParamUtil.getString(resourceRequest, "hoSoTTHCCongId"));
				
				//long listCanBoTiepNhanId=0;
				HoSoTTHCCong hoSoTTHCCong = null;
				YKienTraoDoi yKienTraoDoi = null;
				
				if (idHoSo > 0){
					hoSoTTHCCong= HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(idHoSo);
				}
				
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
				String nguoiGuiId = ParamUtil.getString(resourceRequest, "nguoiGuiId");
				yKienTraoDoi.setNguoiGuiId(FormatUtil.convertToLong(nguoiGuiId));
				Date now = new Date		();
				yKienTraoDoi.setThoiGianGuiYKien(now);
				yKienTraoDoi.setTrangThai(1);
				yKienTraoDoi.setHoSoTTHCCongId(idHoSo);

				yKienTraoDoi.setLoai(0);
				yKienTraoDoi.setNoiLuuTruId(null);
				
				long nguoiNhanId = ParamUtil.getLong(resourceRequest, "nguoiNhanId");

				//TaiKhoanNguoiDung taiKhoanNguoiDung =null;
				if (nguoiNhanId == Constants.CAN_BO_XU_LY_HS) {
					if (hoSoTTHCCong.getCanBoXuLyHienThoiId() != null && hoSoTTHCCong.getCanBoXuLyHienThoiId() > 0 ) {
						CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(hoSoTTHCCong.getCanBoXuLyHienThoiId());
								
						if (congChuc != null ) {
							TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.
									fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
							
							if((taiKhoanNguoiDung != null  && taiKhoanNguoiDung.getId() >0)){
								yKienTraoDoi.setNguoiNhanId(taiKhoanNguoiDung.getId());
							}
						}
					}
					
				} else if (nguoiNhanId == Constants.CONG_DAN_NOP_HS) {
					if (hoSoTTHCCong.getCongDanNopId() != null && hoSoTTHCCong.getCongDanNopId() > 0) {
						CongDan congDan= CongDanLocalServiceUtil.fetchCongDan(hoSoTTHCCong.getCongDanNopId());
						//CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(hoSoTTHCCong.getCongDanNopId());

						if (congDan != null && congDan.getTaiKhoanNguoiDungId() != null) {
							TaiKhoanNguoiDung taiKhoanNguoiDungCD = TaiKhoanNguoiDungLocalServiceUtil.
									fetchTaiKhoanNguoiDung(congDan.getTaiKhoanNguoiDungId());
							
							if (taiKhoanNguoiDungCD != null) {
								yKienTraoDoi.setNguoiNhanId(taiKhoanNguoiDungCD.getId());
							}
						}
					} 
				} 
/*				else {
					if (hoSoTTHCCong.getCanBoXuLyHienThoiId() != null) {
						CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(hoSoTTHCCong.getCanBoXuLyHienThoiId());
						
						if (congChuc != null && congChuc.getTaiKhoanNguoiDungId() != null) {
							TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
							 
							if (taiKhoanNguoiDung != null)
								yKienTraoDoi.setNguoiNhanId(taiKhoanNguoiDung.getId());
						}
					}
				}*/
				
				if (yKienTraoDoi.getNguoiNhanId() == null || yKienTraoDoi.getNguoiNhanId() == 0) {
					long uid = PortalUtil.getUserId(resourceRequest);
					TaiKhoanNguoiDung currentUser = TaiKhoanNguoiDungLocalServiceUtil.
							findByTaiKhoanNguoiDungId(uid);
					
					yKienTraoDoi.setNguoiNhanId(currentUser.getId());
				}
				
				Long chaId = FormatUtil.convertToLong(ParamUtil.getString(resourceRequest, "chaId"));
				
				if ( chaId >0 ) {
					yKienTraoDoi.setChaiId(chaId);
					
				} else {
					yKienTraoDoi.setChaiId(null);
				}

				if (idYKienTraoDoi > 0) {
					yKienTraoDoi = YKienTraoDoiLocalServiceUtil.updateYKienTraoDoi(yKienTraoDoi);
					
				} else {
					yKienTraoDoi = YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);
				}
				
				return yKienTraoDoi;
			}
			
			/** 
			 * This is function validatorsYKienTraoDoiCanBo
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param actionrequest
			 * @throws SystemException
			 * @throws NoSuchTaiKhoanNguoiDungException
			 */	    
			private static boolean validatorsYKienTraoDoiCanBo(ActionRequest actionrequest) throws SystemException, NoSuchTaiKhoanNguoiDungException {
				boolean valid = true;
				HoSoTTHCCong hoSoTTHCCong = null;
				long hoSoTTHCCongId = ConvertUtil.convertToLong(ParamUtil.getString(actionrequest, "hoSoTTHCCongId"));

				if(hoSoTTHCCongId >0){
					hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoTTHCCongId);
				}
				
				// nguoiNhanId - String
				long nguoiNhanId = ParamUtil.getLong(actionrequest, "nguoiNhanId");
//				if (nguoiNhanId == 0 ) {
//					SessionErrors.add(actionrequest, "err.nguoiNhanId");
//					valid = false;
//				} 
//				else if (nguoiNhanId==1){
//					if (hoSoTTHCCong.getCongDanNopId() == null){
//						SessionErrors.add(actionrequest, "err.congDanNopId");
//						valid = false;
//					}
//					else {
//						TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(hoSoTTHCCong.getCongDanNopId());
//						//TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(hoSoTTHCCong.getCongDanNopId());
//						if (taiKhoanNguoiDung == null  ){
//							SessionErrors.add(actionrequest, "err.congDanNopId");
//							valid = false;
//						}
//					}
//				} 
//				else if (nguoiNhanId==2){
//					if (hoSoTTHCCong.getCanBoXuLyHienThoiId() == null){
//						SessionErrors.add(actionrequest, "err.canBoXuLyHienThoiId");
//						valid = false;
//					} 
//					else {
//						TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(hoSoTTHCCong.getCanBoXuLyHienThoiId());
//						if (taiKhoanNguoiDung == null ){
//							SessionErrors.add(actionrequest, "err.canBoXuLyHienThoiId");
//							valid = false;
//						}
//					}
//				}
				
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
			
			/** 
			 * This is function rutHoSo
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param actionRequest
			 * @param httpReq
			 * @throws NumberFormatException
			 * @throws Exception
			 */	    
			public static void rutHoSo (ActionRequest actionRequest,
					ActionResponse httpReq) throws NumberFormatException, Exception{
				
				long hoSoTTHCCongId = ParamUtil.getLong(actionRequest, "hoSoTTHCCongId");
				
				if ( !isTrue(actionRequest, "captcha") ) {
					httpReq.setWindowState(LiferayWindowState.POP_UP);
					httpReq.setRenderParameter("jspPage", "/html/cmon/capcha/ruthoso_popup.jsp");
					
				} 
				else {
					HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoTTHCCongId);
					hoSoTTHCCong.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RUT_HS);
					hoSoTTHCCong.setYeuCauHuyHoSo(Constants.YEU_CAU_HUY_HO_SO);
					hoSoTTHCCong.setNgaySua(new Date());
					HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);
					actionRequest.setAttribute("success", true);
					httpReq.setWindowState(LiferayWindowState.POP_UP);
					httpReq.setRenderParameter("jspPage", "/html/cmon/capcha/ruthoso_popup.jsp");
				} 
			}
			
			/** 
			 * This is function isTrue
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param request
			 * @param captchaField
			 * @return boolean
			 */	    
			public static boolean isTrue( ActionRequest request, String captchaField) {
		        String enteredCaptchaText = ParamUtil.getString(request, captchaField);

		        PortletSession session = request.getPortletSession();
		        
		        String captchaText = getCaptchaValueFromSession(session);
		        
		        if (Validator.isNull(captchaText)) {
		        	SessionErrors.add(request, "input.err.captchanull");
		            return false;
		        }
		        
		        if (!enteredCaptchaText.equals(captchaText)) {
		        	SessionErrors.add(request, "input.err.captchafail");
		            return false;
		        }
		        
		        return true;
		    }

			/** 
			 * This is function getCaptchaValueFromSession
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param session
			 * @param key
			 * @return String
			 */	    
		    private static String getCaptchaValueFromSession(PortletSession session) {
		        Enumeration<String> atNames = session.getAttributeNames();
		        
		        while (atNames.hasMoreElements()) {
		            String name = atNames.nextElement();
		            if (name.contains("CAPTCHA_TEXT")) {
		                return (String) session.getAttribute(name);
		            }
		        }
		        
		        return null;
		    }
			
			/** 
			 * This is function getValueString
			 * 
			 * Version: 1.0
			 *  
			 * History: 
			 *   DATE        AUTHOR      DESCRIPTION 
			 *  ------------------------------------------------- 
			 *  10-April-2013  Nam Dinh    Create new
			 * @param resHttpServletRequest
			 * @param key
			 * @return String
			 */	    
		    public static String getValueString(
					HttpServletRequest resHttpServletRequest, String key) {
				try {
					if (resHttpServletRequest.getAttribute(key) != null) {
						return resHttpServletRequest.getAttribute(key).toString()
								.trim();
					}
				} catch (Exception es) {
				}

				return "";
			}
			

	/** 
	 * This is function filterHoSoTTHCC
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param listHoSoTTHCCongs
	 * @param listHtChinhs
	 * @return List<HoSoTTHCCong>
	 */	    
	public static List<HoSoTTHCCong> filterHoSoTTHCC(
			List<HoSoTTHCCong> listHoSoTTHCCongs, 
			List<ThuTucHanhChinh> listHtChinhs) {
		Map<Long, Object> container = new HashMap<Long, Object>();
		
		if (listHtChinhs != null && !listHtChinhs.isEmpty())
			for (ThuTucHanhChinh thuTucHanhChinh : listHtChinhs) {
				container.put(thuTucHanhChinh.getId(), thuTucHanhChinh);
			}
		
		List<HoSoTTHCCong> results = new LinkedList<HoSoTTHCCong>();
		
		if (listHoSoTTHCCongs != null && !listHoSoTTHCCongs.isEmpty())
			for (HoSoTTHCCong hoSoTTHCCong : listHoSoTTHCCongs) {
				if (container.containsKey(hoSoTTHCCong.getThuTucHanhChinhId())) {
					results.add(hoSoTTHCCong);
				}
			}
		
		return results;
	}
	
	/** 
	 * This is function getListTTHCID
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param tthcs
	 * @return String
	 */
	public static String getListTTHCID(List<ThongTinThuTuc> tthcs) {
		if (tthcs == null)
			return "";
		
		StringBuffer buffer = new StringBuffer("");
		for (ThongTinThuTuc thuTucHanhChinh : tthcs) {
			buffer.append(thuTucHanhChinh.getThuTucId() + ","); 
		}
		
		String result = buffer.toString();
		if (result.length()>0) {
			return result.substring(0, result.length() -1);
		}
		
		return result;
	}
	
	/** 
	 * This is function checkValueInArray
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param container
	 * @param status
	 * @return boolean
	 */
	public static boolean checkValueInArray(String[] container, long status) {
		if (container != null && container.length > 0)
			for (String string : container) {
				if (string.equals(status + ""))
					return true;
			}
		return false;
	}
}
