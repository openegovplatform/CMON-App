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

package org.oep.cmon.admin.portlet.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.admin.portlet.util.SetParamUtil;

import org.oep.cmon.dao.cd.NoSuchGioiTinhException;
import org.oep.cmon.dao.cd.model.GioiTinh;
import org.oep.cmon.dao.cd.model.GioiTinhClp;

import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * This is class GioiTinhAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class GioiTinhAction {
	
	/**
	 * This is function get all GioiTinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<GioiTinh>
	 */
	@SuppressWarnings("unchecked")
	public List<GioiTinh> findAll() {
		List<GioiTinh> results = null;

		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(GioiTinh.class);		
			
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
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
	 * This is function delete GioiTinh
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
	public void deleteGioiTinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword is code
		String gioiTinhId = ParamUtil.getString(actionRequest, "gioiTinhId");
		
		// Process Jason feed
		try {
//			GioiTinh gioiTinh = GioiTinhLocalServiceUtil.fetchGioiTinh(ConvertUtil.convertToLong(gioiTinhId));
//			gioiTinh.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			GioiTinhLocalServiceUtil.updateGioiTinh(gioiTinh);
			GioiTinhLocalServiceUtil.deleteGioiTinh(ConvertUtil.convertToLong(gioiTinhId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteGioiTinh");
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, null);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/gioi_tinh_list.jsp");
	}

	/**
	 * This is function edit or add GioiTinh
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
	public void editOrAddGioiTinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String gioiTinhId = ParamUtil.getString(actionRequest, "gioiTinhId");
		String maGioiTinh = ParamUtil.getString(actionRequest, "maGioiTinh").trim();
		String tenGioiTinh = ParamUtil.getString(actionRequest, "tenGioiTinh").trim();

		if (validationInput(maGioiTinh, tenGioiTinh, gioiTinhId, actionRequest)) {
			GioiTinh quocGia = null;
			if (gioiTinhId.trim().length() > 0) {
				try {
					quocGia = GioiTinhLocalServiceUtil.fetchGioiTinh(ConvertUtil.convertToLong(gioiTinhId));
					quocGia.setMa(maGioiTinh);
					quocGia.setTen(tenGioiTinh);
					quocGia.setNgaySua(new Date());
					quocGia.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					GioiTinhLocalServiceUtil.updateGioiTinh(quocGia);
					actionResponse.setRenderParameter("CompletedUpdateGioiTinh", "CompletedUpdateGioiTinh");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = GioiTinhBusiness.VIEW_GIOI_TINH;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(quocGia.toString());
					SessionErrors.add(actionRequest, "errorUpdateGioiTinh");
				}
			} else {
				try {
					quocGia = new GioiTinhClp();
					quocGia.setId(CounterLocalServiceUtil.increment(GioiTinh.class.getName()));
					quocGia.setMa(maGioiTinh);
					quocGia.setTen(tenGioiTinh);
					quocGia.setNgaySua(new Date());
					quocGia.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					quocGia.setNgayTao(new Date());
					quocGia.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					GioiTinhLocalServiceUtil.addGioiTinh(quocGia);
					actionResponse.setRenderParameter("CompletedAddGioiTinh", "CompletedAddGioiTinh");
					actionResponse.setRenderParameter("completed", "completed");
					//gioiTinhId = String.valueOf(quocGia.getId());
					//actionType = GioiTinhBusiness.VIEW_GIOI_TINH;
					maGioiTinh = "";
					tenGioiTinh = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(quocGia.toString());
					SessionErrors.add(actionRequest, "errorAddGioiTinh");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("gioiTinhId", gioiTinhId);
		actionResponse.setRenderParameter("maGioiTinh", maGioiTinh);
		actionResponse.setRenderParameter("tenGioiTinh", tenGioiTinh);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/gioi_tinh_add.jsp");

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, null);
	}

	/**
	 * This is function validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maQuocGia
	 * @param tenQuocGia
	 * @param quocGiaId
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String maQuocGia, String tenQuocGia, String quocGiaId, ActionRequest actionRequest) {
		if (maQuocGia.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaGioiTinh");
		}
		if (tenQuocGia.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenGioiTinh");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			GioiTinh quocGia = null;
			try {
				// Kieam tra theo Ma
				try {
					quocGia = GioiTinhLocalServiceUtil.findByMa(maQuocGia);
				} catch (NoSuchGioiTinhException es) {
				}
				if (quocGia != null) {
					if (quocGia.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}

					if (quocGiaId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(quocGiaId) != quocGia.getId()) {
							SessionErrors.add(actionRequest, "exitMaGioiTinh");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaGioiTinh");
					}
				}

//				// Kiem tra theo Ten
//				try {
//					quocGia = null;
//					quocGia = GioiTinhLocalServiceUtil.findByTen(tenQuocGia);
//				} catch (NoSuchGioiTinhException es) {
//				}
//				if (quocGia != null) {
//					if (quocGiaId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(quocGiaId) != quocGia.getId()) {
//							SessionErrors.add(actionRequest, "exitTenGioiTinh");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenGioiTinh");
//					}
//				}
			} catch (Exception es) {
			}
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}
		
		return false;
	}
}
