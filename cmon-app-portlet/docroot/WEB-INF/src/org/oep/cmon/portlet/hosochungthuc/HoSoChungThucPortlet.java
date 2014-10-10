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

package org.oep.cmon.portlet.hosochungthuc;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.chungthuc.utils.ChungThucUtils;
import org.oep.cmon.dao.chungthuc.utils.ChungThucValidator;
import org.oep.cmon.portlet.cmon.CanBoPortlet;
import org.oep.cmon.portlet.hosotructiep.HoSoFields;
import org.oep.egovcore.portlet.AjaxResponse;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;
import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;
import org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil;
import org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil;
import org.oep.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.cmon.consumer.citizen.DonViHanhChinhSoap;
import vn.dtt.sharedservice.cmon.consumer.citizen.ICitizenService;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class CongChucPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoChungThucPortlet extends CanBoPortlet {
	
	/**
	 * This is function saveHoSoChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 * @throws WindowStateException
	 * @throws PortletModeException
	 */
	public void saveHoSoChungThuc(ActionRequest  actionRequest,
			ActionResponse response) throws PortalException, SystemException, 
			IOException, WindowStateException, PortletModeException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		HoSoChungThuc hsChungThuc = ChungThucUtils.fillDataHoSoChungThuc(uploadRequest);
		
		if (ChungThucValidator.hoSoChungThucValidate(uploadRequest, actionRequest)) {
			if (hsChungThuc.getHoSoChungThucId() == 0) {
				long idHoSo = CounterLocalServiceUtil.increment(HoSoChungThuc.class.getName());
				hsChungThuc.setHoSoChungThucId(idHoSo);
				HoSoChungThucLocalServiceUtil.addHoSoChungThuc(hsChungThuc);
				
			} else {
				HoSoChungThucLocalServiceUtil.updateHoSoChungThuc(hsChungThuc);
				
				// delete current thanh phan ho so
				ThanhPhanHoSoChungThucLocalServiceUtil.removeThanhPhanHoSoByHSChungThucId(
						hsChungThuc.getHoSoChungThucId());
			}
			
			ChungThucUtils.saveThanhPhanHoSoChungThuc(uploadRequest, 
					hsChungThuc.getHoSoChungThucId(), hsChungThuc.getThuTucHanhChinhId());
			
			SessionErrors.clear(actionRequest);
			actionRequest.setAttribute("savemessage","Ä�Ã£ lÆ°u há»“ sÆ¡ chá»©ng thá»±c");
			
			hsChungThuc.setTenChungThuc("");
		} 
		
//		else {
//			actionRequest.setAttribute(Constants.ChungThuc.NAME, 
//					ChungThucUtils.fillDataHoSoChungThuc(uploadRequest));
//		}
//		
		actionRequest.setAttribute(Constants.ChungThuc.NAME, hsChungThuc);
	}
	
	/**
	 * This is function saveSoDanhMuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void saveSoDanhMuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException, SystemException {
		if (ChungThucValidator.soDanhMucValidator(actionRequest)) {
			SoDanhMuc soDanhMuc = ChungThucUtils.fillDataSoDanhMuc(actionRequest);
			
			if (soDanhMuc.getId() == 0) {
				long idHoSo = CounterLocalServiceUtil.increment(SoDanhMuc.class.getName());
				soDanhMuc.setId(idHoSo);
				
				SoDanhMucLocalServiceUtil.addSoDanhMuc(soDanhMuc);
				
				//ChungThucUtils.saveThanhPhanHoSoChungThuc(uploadRequest, idHoSo);
			} else {
				SoDanhMucLocalServiceUtil.updateSoDanhMuc(soDanhMuc);
			}
			
			SessionErrors.clear(actionRequest);
			actionRequest.setAttribute("savemessage","Ä�Ã£ lÆ°u sá»• danh má»¥c");
			
		} else {
			actionResponse.setRenderParameter("jspPage", ParamUtil.getString(actionRequest,"targetPage"));
		}
		
		actionRequest.setAttribute(Constants.ChungThuc.SO_DANH_MUC_NAME, 
				ChungThucUtils.fillDataSoDanhMuc(actionRequest));
		
	}
	
	/**
	 * This is function getDonViHanhChinhById
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
	public void getDonViHanhChinhById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		try {
			ICitizenService commonService = WebserviceFactory.getCmonService();
			String id = ParamUtil.getString(resourceRequest, "id");

			// Process Jason feed
			JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
			JSONArray _name = JSONFactoryUtil.getJSONFactory()
					.createJSONArray();
			JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();

			// Danh sach don vi hanh chinh
			List<DonViHanhChinhSoap> donViHanhChinhSoaps = commonService
					.getDanhsachDVHC(Long.valueOf(id));

			for (DonViHanhChinhSoap donViHanhChinhSoap : donViHanhChinhSoaps) {
				_id.put(donViHanhChinhSoap.getId());
				_name.put(donViHanhChinhSoap.getTen());
			}
			jsonFeed.put("id", _id);
			jsonFeed.put("name", _name);

			HttpServletResponse resourceResponse = PortalUtil
					.getHttpServletResponse(httpReq);

			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("UTF-8");
			resourceResponse.getWriter().write(jsonFeed.toString());
			resourceResponse.getWriter().close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * This is function getTTHCInfo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws Exception
	 */
	public void getTTHCInfo(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception {
		long thuTucId = ParamUtil.getLong(request, HoSoFields.thuTucHanhChinhId);
		long coQuanId = ParamUtil.getLong(request, HoSoFields.coQuanQuanLyId);
		long idHoSo = ParamUtil.getLong(request, "idHoSo");
		
		TTHC2CoQuanQuanLy tthc2cq = null;
		List<TTHC2CoQuanQuanLy> list = TTHC2CoQuanQuanLyLocalServiceUtil.findByCoQuanAndThuTuc(coQuanId, thuTucId);
		if (list.size() > 0) {
			tthc2cq = list.get(0);
		}
		
		List<ThuTuc2GiayTo> listGiayTo =
			ThuTuc2GiayToLocalServiceUtil.getDSGiayToTheoThuTuc(thuTucId, Constants.ACTIVE, Constants.GIAIDOAN_GIAYTO_DAUVAO);
		
		//List<SoDanhMuc> listSoDanhMuc = SoDanhMucLocalServiceUtil.getSoDanhMucByTTHCID(thuTucId);
		List<SoDanhMuc> listSoDanhMuc = SoDanhMucLocalServiceUtil.getSoDanhMucByTTHCIDAndCQQLID(thuTucId, coQuanId);
		
		//JSONObject outThonTinThuTuc = JSONFactoryUtil.createJSONObject();
		JSONArray outGiayToQuiDinh = JSONFactoryUtil.createJSONArray();
		JSONArray outSoDanhMuc = JSONFactoryUtil.createJSONArray();
		
		if (tthc2cq != null) {
			//outThonTinThuTuc = ChungThucUtils.thuTuc(tthc2cq, idHoSo);
		}
		
		if (listGiayTo != null) {
			outGiayToQuiDinh = ChungThucUtils.dsGiayToQuyDinh(listGiayTo, idHoSo);
		}
		
		long lastSoDanhMucId = 0;
		if (listSoDanhMuc != null && !listSoDanhMuc.isEmpty()) {
			outSoDanhMuc = ChungThucUtils.dsSoDanhMuc(listSoDanhMuc, idHoSo);
			lastSoDanhMucId = listSoDanhMuc.get(listSoDanhMuc.size() - 1).getId();
		}
		
		ajaxResponse
		//.send(HoSoFields.thongTinThuTuc, outThonTinThuTuc)
		.send(HoSoFields.dsGiayToQuyDinh, outGiayToQuiDinh)
		.send("dsSoDanhMuc", outSoDanhMuc)
		.send("soChungThuc", ChungThucUtils.countHoSoChungByTTHC(thuTucId, lastSoDanhMucId, idHoSo));
	}
	
	
	/**
	 * This is function getSoChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 */
	public void getSoChungThuc(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		long thuTucId = ParamUtil.getLong(request, HoSoFields.thuTucHanhChinhId);
		long soDanhMucId = ParamUtil.getLong(request, "soDanhMucId");

		ajaxResponse
		.send("soChungThuc", ChungThucUtils.countHoSoChungByTTHC(thuTucId, soDanhMucId, 0));
	}
	
	/**
	 * This is function rutHoSoDanhMuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	public void rutHoSoDanhMuc(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		long idHoSo = ParamUtil.getLong(resourceRequest, "idHoSo");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if (idHoSo > 0) {
			try {
				SoDanhMuc soDanhMuc = SoDanhMucLocalServiceUtil.fetchSoDanhMuc(idHoSo);
				
				if (soDanhMuc != null) {
					SoDanhMucLocalServiceUtil.deleteSoDanhMuc(idHoSo);					
				}

				json.put("status", Boolean.TRUE);
				
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", Boolean.FALSE);
			}
		} else {
			json.put("status", Boolean.FALSE);
		}
		
		resourceResponse.getWriter().write(json.toString());
	}
	
	/**
	 * This is function rutHoSoChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	public void rutHoSoChungThuc(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		long idHoSo = ParamUtil.getLong(resourceRequest, "idHoSo");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if (idHoSo > 0) {
			try {
				HoSoChungThuc hoSoChungThuc = HoSoChungThucLocalServiceUtil.fetchHoSoChungThuc(idHoSo);
				
				if (hoSoChungThuc != null) {
					// delete current thanh phan ho so
					ThanhPhanHoSoChungThucLocalServiceUtil.removeThanhPhanHoSoByHSChungThucId(
							hoSoChungThuc.getHoSoChungThucId());
					
					HoSoChungThucLocalServiceUtil.deleteHoSoChungThuc(idHoSo);				
				}

				json.put("status", Boolean.TRUE);
				
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", Boolean.FALSE);
			}
		} else {
			json.put("status", Boolean.FALSE);
		}
		
		resourceResponse.getWriter().write(json.toString());
	}
	
}
