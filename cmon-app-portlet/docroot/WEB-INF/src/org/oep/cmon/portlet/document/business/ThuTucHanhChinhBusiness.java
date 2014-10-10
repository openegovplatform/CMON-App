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

package org.oep.cmon.portlet.document.business;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.portlet.document.action.ThuTucHanhChinhPortlet;
import org.oep.cmon.portlet.document.util.DocumentConstants;
import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.util.Helpers;
import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.provider.model.ResultUpload;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.VanBanHuongDan;
import org.oep.cmon.dao.dvc.model.VanBanHuongDanClp;

import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil;

/**
 * @author duong.pham
 *
 */
public class ThuTucHanhChinhBusiness {
	
	private static Log _log = LogFactoryUtil
			.getLog(ThuTucHanhChinhBusiness.class);
	
	public static final String VIEW_UNG_DUNG = "viewUngDung";
	public static final String VIEW_NHOM_TTHC = "viewNhomTTHC";
	public static final String VIEW_TTHC = "viewTTHC";
	public static final String VIEW_CAPCQQL = "viewCAPCQQL";
	
	public final static String DATA_UPLOAD_FILE = "data_upload";
	public final static String TEN_FILE_UPLOAD = "ten_file_upload";

	public static String checkSelectedValue(String value1, long value2) {
		if (FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	public static String checkSelectedValue(Long value1, Long value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	public static String checkTrueValue(Integer value1, Integer value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "checked";
		}
		return "";
	}
	public static String checkBoxValue(Integer value1, Integer value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "true";
		}
		return "false";
	}
	
	//UNGDUNG		
	/**
	 * @param UngDung
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkDataReturn(DanhMucUngDung ungDung, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (ungDung != null) {
			if (type == 3) {
				return ungDung.getMa();
			} else {
				return ungDung.getTen();
			}
		}

		return "";
	}
	public static List<DanhMucUngDung> findByTenUngDung(String keyWord) {
		ThuTucHanhChinhPortlet action = new ThuTucHanhChinhPortlet();
		return action.findByTenUngDung(keyWord);
	}
	
	/**
	 * @param ungDung
	 * @param select
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkUDSelectedValue(String value1, long value2) {
		if (FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	public static String checkSelected(DanhMucUngDung intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getDaXoa()).compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}
	public static String checkUDSelected(DanhMucUngDung intValue, String outValue, String defaultValue) {
		if (intValue != null) {
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}

	/**
	 * @param ungDung
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkUDReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_UNG_DUNG) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
	
	//Nhom TTHC
	public static List<NhomThuTucHanhChinh> findByUngDungId(long groupId) {
		ThuTucHanhChinhPortlet action = new ThuTucHanhChinhPortlet();
		return action.findByUngDungId(groupId);
	}
	
	public static String checkNTTHCDataReturn(NhomThuTucHanhChinh nTTHC, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (nTTHC != null) {
			if (type == 3) {
				return nTTHC.getMa();
			} else {
				return nTTHC.getTen();
			}
		}

		return "";
	}
	
	public static String checkNTTHCSelected(NhomThuTucHanhChinh intValue, String outValue, String defaultValue) {
		if (intValue != null) {
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}
	public static String checkNTTHCStatuSelected(NhomThuTucHanhChinh intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getDaXoa()).compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}

	/**
	 * @param Nhom TTHC
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkNTTHCReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_NHOM_TTHC) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
	
	//Thu tuc hanh chinh
	public static String checkTTHCDataReturn(ThuTucHanhChinh tthc, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (tthc != null) {
			if (type == 3) {
				return tthc.getMa();
			}
			else if (type == 2) {
				return String.valueOf(tthc.getSoNgayXuLy());
			} 
			else if (type == 1) {
				return tthc.getTen();
			}
			else if (type == 4) {
				return tthc.getTrinhTuThucHien();
			}
			else if (type == 5) {
				return tthc.getCachThucHien();
			}
			else if (type == 6) {
				return tthc.getThanhPhanHoSo();
			}
			else if (type == 7) {
				return tthc.getTen();
			}
			else if (type == 8) {
				return tthc.getLinhVucThucHien();
			}
			else if (type == 9) {
				return String.valueOf(tthc.getLePhi());
			}
			else if (type == 10) {
				return String.valueOf(tthc.getDonViLePhi());
			}
			else if (type == 11) {
				return String.valueOf(tthc.getPhi());
			}
			else if (type == 12) {
				return String.valueOf(tthc.getDonViPhi());
			}
			else if (type == 13) {
				return String.valueOf(tthc.getTenMauDonToKhai());
			}
			else if (type == 14) {
				return String.valueOf(tthc.getYeuCauDieuKienThucHien());
			}
			else if (type == 15) {
				return tthc.getCanCuPhapLy();
			}
			
		}

		return "";
	}
	
	public static String checkTTHCSelected(ThuTucHanhChinh intValue, String outValue, String defaultValue) {
		if (intValue != null) {
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}
	public static String checkTTSelected(ThuTucHanhChinh intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getTrangThai()).compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}
	public static String checkTHSelected(ThuTucHanhChinh intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getCanTichHop()).compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}

	/**
	 * @param Thu tuc hanh chinh
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkTTHCReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_TTHC) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
	
	/**
	 * @param Thu tuc hanh chinh
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkDisabled(String value1,String value2) {
		if (value1.equals(value2)) {
			return "disabled=\"disabled\"";
		}

		return "";
	}
	public static String checkExits(String dataInput, String[] arr) {
		 String flag="0"; 
	     for(int i=0;i<arr.length;i++){
	      if(arr[i].equals(dataInput))
	      return flag="1";
	          
	     }
	     
	    return flag;
		}
	//Upload File
	public JSONObject deleteFileUploadById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		long vbhdId = ParamUtil.getLong(resourceRequest, "vbhdId");
		
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		try {
			VanBanHuongDan fileUpload = VanBanHuongDanLocalServiceUtil.fetchVanBanHuongDan(vbhdId);
			VanBanHuongDanLocalServiceUtil.deleteVanBanHuongDan(vbhdId);
			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
			iDocumentStorage.deleteFile(fileUpload.getNoiLuuTruId());
			jsonFeed.put("deleteComplete", "completed");
			
		} catch (Exception es) {
			jsonFeed.put("deleteComplete", "error");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
	}
	public JSONObject getFileUploadById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		long vbhdId = ParamUtil.getLong(resourceRequest, "vbhdId");
		
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		try {
			VanBanHuongDan fileUpload = VanBanHuongDanLocalServiceUtil.fetchVanBanHuongDan(vbhdId);		
			IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
			iDocumentStorage.getURLById(fileUpload.getNoiLuuTruId());
			jsonFeed.put("getComplete", "completed");
			
		} catch (Exception es) {
			jsonFeed.put("getComplete", "error");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
	}

	public JSONObject checkFileUpload(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		
		//String tenFileUpload =uploadRequest.getParameter("tenTaiLieu");
		//long idQuyTrinh = ParamUtil.getLong(uploadRequest, "tthcId");
		long loaiTaiLieu = ParamUtil.getLong(resourceRequest, "idLoaiTL");
		String checkName = ParamUtil.getString(resourceRequest, "checkName");
		String tenFileUpload = ParamUtil.getString(resourceRequest, "tenFileUpload").trim();
		long idQuyTrinh = ParamUtil.getLong(resourceRequest, "idQuyTrinh");
		
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
							jsonFeed.put("existFile", "existFile");
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
					List<VanBanHuongDan> listResultBefore = (ArrayList<VanBanHuongDan>)resourceRequest.getPortletSession().getAttribute(DATA_UPLOAD_FILE);
					for (VanBanHuongDan fileUpload : listResultBefore) {
						if (fileUpload.getTenTaiLieu().toLowerCase().compareTo(tenFileUpload.toLowerCase()) == 0) {
							jsonFeed.put("existFile", "existFile");
							flag = false;
							break;
						}
					}
				}
			}
			if (flag) {
						
				VanBanHuongDan fileUpload=null;
				List<VanBanHuongDan> list = this.findByExistTenTaiLieu(tenFileUpload, idQuyTrinh, loaiTaiLieu, DocumentConstants.ACTIVE);
					if (list != null && list.size() > 0) {
						fileUpload = list.get(0);
					}
				
				if (fileUpload != null) {
					jsonFeed.put("existFile", "existFile");
				} else {
					jsonFeed.put("existFile", "notExistFile");
				}
			}
		} catch (Exception es) {
			jsonFeed.put("existFile", "notExistFile");
		}
		jsonFeed.put("name", _name);

		return jsonFeed;
	}

	public void addFileUpload(ActionRequest resourceRequest, ActionResponse actionResponse) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		IDocumentStorage iDocumentStorage = new DocumentStorageImpl();		
		
		VanBanHuongDan vbbm = null;
		InputStream inputStream = null;
		String tenTaiLieu= uploadRequest.getParameter("tenTaiLieu");
		
		String mota= uploadRequest.getParameter("motaTaiLieu");
		String loaiTaiLieuId= uploadRequest.getParameter("loaiTaiLieuId");
		String tthcId = uploadRequest.getParameter("tthcId");
		File fileUpload=uploadRequest.getFile("taiLieuDinhKem");
		String sourceFileName =uploadRequest.getFileName("taiLieuDinhKem");
		
		if(validationTaiLieuUploadInput(tenTaiLieu, fileUpload, FormatUtil.convertToLong(tthcId), FormatUtil.convertToLong(loaiTaiLieuId), resourceRequest))
		{
			try {
				inputStream=new FileInputStream(fileUpload);				
					if (inputStream != null) {
						BufferedInputStream byteArrayInputStream = new BufferedInputStream(
								inputStream);
						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						int data = byteArrayInputStream.read();
						while (data != -1) {
							byteArrayOutputStream.write(data);
							data = byteArrayInputStream.read();
						}
						//String tthcCode=ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(FormatUtil.convertToLong(tthcId)).getMa();
						ResultUpload upload = iDocumentStorage.uploadCauHinhTTHC(FormatUtil.convertToLong(tthcId), PortalUtil.getUser(resourceRequest).getUserId(), byteArrayOutputStream.toByteArray(), sourceFileName);
						if (upload.getCode().compareTo(Constants.UPLOAD_OK) == 0 && upload!=null) {
							//listResult.add(upload);
							vbbm = new VanBanHuongDanClp();
							vbbm.setId(CounterLocalServiceUtil.increment(VanBanHuongDan.class.getName()));
							vbbm.setThuTucHanhChinhId(FormatUtil.convertToLong(tthcId));						
							//vbbm.setTenTaiLieu(uploadRequest.getFileName(tenFileUpload));	
							vbbm.setTenTaiLieu(tenTaiLieu);
							vbbm.setNoiLuuTruId(upload.getFileId());
							//fileUpload.setTenFileUpload(uploadRequest.getParameter(tenFileUpload.replace("taiLieuDinhKem", "tenLieuDinhKem")));
							vbbm.setMoTa(mota);
							vbbm.setDaXoa(DocumentConstants.ACTIVE);
							vbbm.setLoaiTaiLieu(FormatUtil.convertToLong(loaiTaiLieuId));
							
							vbbm.setNgaySua(new Date());
							vbbm.setNgayTao(new Date());
							vbbm.setNguoiSua(PortalUtil.getUser(resourceRequest).getEmailAddress());
							vbbm.setNguoiTao(PortalUtil.getUser(resourceRequest).getEmailAddress());
						
							try {
								VanBanHuongDanLocalServiceUtil.addVanBanHuongDan(vbbm);	
								resourceRequest.setAttribute("update_success", "update_success");
								SessionMessages.add(resourceRequest, "successUpdateHDVB");
								
							} 
							catch (Exception es) {
								es.printStackTrace();
							}
							finally {
						        try {
						            if (byteArrayInputStream != null) {
						            	byteArrayInputStream.close();
						            }
						            if (byteArrayOutputStream != null) {
						            	byteArrayOutputStream.close();
						            }
						            if (inputStream != null) {
						            	inputStream.close();
						            }
						        } catch (IOException e) {
						            e.printStackTrace();
						        }
						    }
						}
						//upload if error 
						else
						{
							SessionErrors.add(resourceRequest, "errorUpLoadHDVB");
						}
						
					}
				
			} 
			catch (Exception es){
				es.printStackTrace();
				SessionErrors.add(resourceRequest, "errorUpdateHDVB");
			}
		}
		resourceRequest.setAttribute("action", "save");
		actionResponse.setRenderParameter("tthcId", uploadRequest.getParameter("tthcId"));
		actionResponse.setRenderParameter("tthcID", tthcId);
		resourceRequest.getPortletSession().setAttribute("tthcID", tthcId);
		actionResponse.setRenderParameter("loaiTaiLieuId", uploadRequest.getParameter("loaiTaiLieuId"));
		resourceRequest.getPortletSession().setAttribute("loaiTaiLieuId", loaiTaiLieuId);
		//actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/popup_tai_lieu.jsp");
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
			
	}
	public List<VanBanHuongDan> findByExistTenTaiLieu(String tenTaiLieu, long tthcId, long loaiTaiLieu, int daXoa) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(VanBanHuongDan.class);		
		// This is a test line for display all request if there's no search criteria
		Criterion criterionDaXoa= RestrictionsFactoryUtil.eq("daXoa", daXoa);
		Criterion criterionTTHCId = RestrictionsFactoryUtil.eq("thuTucHanhChinhId", tthcId);
		Criterion criterionLoaiTaiLieu = RestrictionsFactoryUtil.eq("loaiTaiLieu", loaiTaiLieu);
		
		Order order = OrderFactoryUtil.desc("id");
		Order orderDate = OrderFactoryUtil.desc("ngayTao");
				
		// Define search criteria
		if (tenTaiLieu.trim().length() > 0) {
			query = query.add(RestrictionsFactoryUtil.ilike("tenTaiLieu", "" + tenTaiLieu + ""));
		}
		query = query.add(criterionDaXoa);
		query = query.add(RestrictionsFactoryUtil.and(criterionTTHCId, criterionLoaiTaiLieu)).addOrder(orderDate).addOrder(order);
				
		try {
			return VanBanHuongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return new ArrayList<VanBanHuongDan>();
	}
	private boolean validationTaiLieuUploadInput(String tenTaiLieu,  File fileUpload, long tthcId, long loaiTaiLieuId, ActionRequest actionRequest) {
		if (tenTaiLieu.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenFileUpLoad");
		}
		if (Validator.isNull(fileUpload)) {
			SessionErrors.add(actionRequest, "emptyFileUpload");
		}
		
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			VanBanHuongDan vbhd = null;
			try {

				// Kiem tra theo Ma
				try {
					List<VanBanHuongDan> list  = this.findByExistTenTaiLieu(tenTaiLieu, tthcId, loaiTaiLieuId, DocumentConstants.ACTIVE);
					
					if (list != null && list.size() > 0) {
						vbhd = list.get(0);
					}
				} catch (Exception es) {
				}
				if (vbhd != null) {
					if (vbhd.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (tthcId > 0) {
						if (tthcId != vbhd.getThuTucHanhChinhId()) {
							SessionErrors.add(actionRequest, "existTenFileUpLoad");
						}
					} else {
						SessionErrors.add(actionRequest, "existTenFileUpLoad");
					}
				}


			} catch (Exception es) {
			}
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	
	public static List<List<DoiTuongSuDung>> findAllDoiTuongnByTTHC(String tthcId) throws Exception {
		List<List<DoiTuongSuDung>> results = new ArrayList<List<DoiTuongSuDung>>();
		try {			
				// Get dot DoiTuongSuDung
								
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoiTuongSuDung.class);
				query.addOrder(OrderFactoryUtil.asc("ten"));
				// This is a test line for display all request if there's no search criteria
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("daXoa", org.oep.cmon.Constants.ACTIVE);
				//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("loai",  vai));

				// Define search criteria			
				query = query.add(criterion);	
				List<DoiTuongSuDung> doiTuongList = DoiTuongSuDungLocalServiceUtil.dynamicQuery(query);
	
				// Get config
				List<TTHC2DoiTuongSuDung> configList = null;
				if (!Helpers.isEmpty(tthcId)) {
					configList = findAllConfigByTTHC(tthcId);
				}
				
				List<DoiTuongSuDung> doiTuong1 = new ArrayList<DoiTuongSuDung>();
				List<DoiTuongSuDung> doiTuong2 = new ArrayList<DoiTuongSuDung>();
				DoiTuongSuDung doiTuong = null;
				TTHC2DoiTuongSuDung doiTuong2TTHC = null;
				if (doiTuongList != null && doiTuongList.size() > 0) {
					for (int i = 0; i < doiTuongList.size(); i++) {
						doiTuong = doiTuongList.get(i);
						boolean flag = true;
						if (configList != null && configList.size() > 0) {
							for (int j = 0; j < configList.size(); j++) {
								doiTuong2TTHC = configList.get(j);
								if (doiTuong.getId() == doiTuong2TTHC.getLoaiDoiTuongId()) {
									flag = false;
									break;
								}
							}
						}
						if (flag) {
							doiTuong1.add(doiTuong);
						} else {
							doiTuong2.add(doiTuong);
						}
					}
				}
				results.add(doiTuong1);
				results.add(doiTuong2);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}
		return results;
	}
	
	public static List<List<DoiTuongSuDung>> findAllDoiTuongByTTHC(String[] doiTuongDest) throws Exception {
		List<List<DoiTuongSuDung>> results = new ArrayList<List<DoiTuongSuDung>>();
		try {			
				// Get dot DoiTuongSuDung
								
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoiTuongSuDung.class);
				query.addOrder(OrderFactoryUtil.asc("ten"));
				// This is a test line for display all request if there's no search criteria
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("daXoa", org.oep.cmon.Constants.ACTIVE);
				//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("loai",  vai));

				// Define search criteria			
				query = query.add(criterion);	
				List<DoiTuongSuDung> doiTuongList = DoiTuongSuDungLocalServiceUtil.dynamicQuery(query);
				
				List<DoiTuongSuDung> doiTuong1 = new ArrayList<DoiTuongSuDung>();
				List<DoiTuongSuDung> doiTuong2 = new ArrayList<DoiTuongSuDung>();
				DoiTuongSuDung doiTuong = null;
				if (doiTuongList != null && doiTuongList.size() > 0) {
					for (int i = 0; i < doiTuongList.size(); i++) {
						doiTuong = doiTuongList.get(i);
						boolean flag = true;
						if (doiTuongDest != null && doiTuongDest.length > 0) {
							for (int j = 0; j < doiTuongDest.length; j++) {
								if (doiTuong.getId() == Long.valueOf(doiTuongDest[j]).longValue()) {
									flag = false;
									break;
								}
							}
						}
						if (flag) {
							doiTuong1.add(doiTuong);
						} else {
							doiTuong2.add(doiTuong);
						}
					}
				}
				results.add(doiTuong1);
				results.add(doiTuong2);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}
		return results;
	}
	
	public static List<TTHC2DoiTuongSuDung> findAllConfigByTTHC(String tthcId) throws Exception {
		List<TTHC2DoiTuongSuDung> results = null;
		try {

			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TTHC2DoiTuongSuDung.class);
			// query.addOrder(OrderFactoryUtil.asc("ten"));
			// This is a test line for display all request if there's no search criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("daXoa", org.oep.cmon.Constants.ACTIVE);
		
			if (!Helpers.isEmpty(tthcId)) {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("thuTucHanhChinhId",  Long.valueOf(tthcId)));
			}
			// Define search criteria			
			query = query.add(criterion);
	
			results = TTHC2DoiTuongSuDungLocalServiceUtil.dynamicQuery(query);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}
		return results;
	}
	
	public static void deleteDoiTuong2TTHC(String tthcId) throws Exception {

		try {
			if (!Helpers.isEmpty(tthcId)) {
				List<TTHC2DoiTuongSuDung> list = findAllConfigByTTHC(tthcId);
				for (TTHC2DoiTuongSuDung doiTuong2TTHC : list) {
					TTHC2DoiTuongSuDungLocalServiceUtil.deleteTTHC2DoiTuongSuDung(doiTuong2TTHC.getId());
				}				
			}
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return;
	}
	
	public static void saveDoiTuong2TTHC(TTHC2DoiTuongSuDung doiTuong2TTHC) throws Exception {

		try {
			if (doiTuong2TTHC != null) {
				doiTuong2TTHC.setId(CounterLocalServiceUtil.increment(TTHC2DoiTuongSuDung.class.getName()));
				TTHC2DoiTuongSuDungLocalServiceUtil.addTTHC2DoiTuongSuDung(doiTuong2TTHC);
			}
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return;
	}
	
}
