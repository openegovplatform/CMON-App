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

import org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinhClp;

import org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil;

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
 * This is class CapDonViHanhChinhAction  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CapDonViHanhChinhAction {

	/**
	 * This is  function search CapDonViHanhChinhRequest
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
	public void searchCapDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten or Ma
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<CapDonViHanhChinh> results = findByTenCapDonViHanhChinh(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cdvhc_list.jsp");
	}
	
	/**
	 * This is  function find CapDonViHanhChinh by TenCapDonViHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return <CapDonViHanhChinh>
	 */
	@SuppressWarnings("unchecked")
	public List<CapDonViHanhChinh> findByTenCapDonViHanhChinh(String keyWord) {
		List<CapDonViHanhChinh> results = null;
		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CapDonViHanhChinh.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
			
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
					
			// Define search criteria
			query = query.add( RestrictionsFactoryUtil.and(criteria, criteriaTrangThai) );
					
			try {
				results = CapDonViHanhChinhLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CapDonViHanhChinh.class);		
								
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
			// Define search criteria
			query = query.add(criteriaTrangThai);
								
			try {
				results = CapDonViHanhChinhLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}
		
		if (results == null) {
			results = new ArrayList<CapDonViHanhChinh>();
		}
		return results;
	}

	/**
	 * This is  function count CapDonViHanhChinhRequest
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
	@SuppressWarnings("unused")
	private long countCapDonViHanhChinhRequest(String keyWord) throws Exception {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CapDonViHanhChinh.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");			
		
		// Define search criteria
		query = query.add( criteria );
		
		try {
			return CapDonViHanhChinhLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * This is  function delete CapDonViHanhChinhRequest
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
	public void deleteCapDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String CapDonViHanhChinhId = ParamUtil.getString(actionRequest, "CapDonViHanhChinhId");
		
		// Process Jason feed
		try {
//			CapDonViHanhChinh capDonViHanhChinh = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(ConvertUtil.convertToLong(CapDonViHanhChinhId));
//			capDonViHanhChinh.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			CapDonViHanhChinhLocalServiceUtil.updateCapDonViHanhChinh(capDonViHanhChinh);
			CapDonViHanhChinhLocalServiceUtil.deleteCapDonViHanhChinh(ConvertUtil.convertToLong(CapDonViHanhChinhId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteCapDonViHanhChinh");
		}

		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);

		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cdvhc_list.jsp");
	}

	/**
	 * This is  function edit or add CapDonViHanhChinhRequest
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
	public void editOrAddCapDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String DonViHanhChinhId = ParamUtil.getString(actionRequest, "CapDonViHanhChinhId");
		String maDonViHanhChinh = ParamUtil.getString(actionRequest, "maCapDonViHanhChinh").trim();
		String tenDonViHanhChinh = ParamUtil.getString(actionRequest, "tenCapDonViHanhChinh").trim();
		String moTaCapDonViHanhChinh = ParamUtil.getString(actionRequest, "moTaCapDonViHanhChinh").trim();
		String _capDonViHanhChinh = ParamUtil.getString(actionRequest, "capDonViHanhChinh").trim();

		if (validationInput(maDonViHanhChinh, tenDonViHanhChinh, DonViHanhChinhId, _capDonViHanhChinh, actionRequest, moTaCapDonViHanhChinh)) {
			CapDonViHanhChinh capDonViHanhChinh = null;
			if (DonViHanhChinhId.trim().length() > 0) {
				try {
					capDonViHanhChinh = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(ConvertUtil.convertToLong(DonViHanhChinhId));
					capDonViHanhChinh.setMa(maDonViHanhChinh);
					capDonViHanhChinh.setTen(tenDonViHanhChinh);
					capDonViHanhChinh.setNgaySua(new Date());
					capDonViHanhChinh.setMota(moTaCapDonViHanhChinh);
					capDonViHanhChinh.setCap(ConvertUtil.convertToLong(_capDonViHanhChinh));
					capDonViHanhChinh.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					CapDonViHanhChinhLocalServiceUtil.updateCapDonViHanhChinh(capDonViHanhChinh);
					actionResponse.setRenderParameter("CompletedUpdateCapDonViHanhChinh", "CompletedUpdateCapDonViHanhChinh");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = CapDonViHanhChinhBusiness.VIEW_DON_VI_HANH_CHINH;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(capDonViHanhChinh.toString());
					SessionErrors.add(actionRequest, "errorUpdateCapDonViHanhChinh");
				}
			} else {
				try {
					capDonViHanhChinh = new CapDonViHanhChinhClp();
					capDonViHanhChinh.setId(CounterLocalServiceUtil.increment(CapDonViHanhChinh.class.getName()));
					capDonViHanhChinh.setMa(maDonViHanhChinh);
					capDonViHanhChinh.setTen(tenDonViHanhChinh);
					capDonViHanhChinh.setNgaySua(new Date());
					capDonViHanhChinh.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					capDonViHanhChinh.setNgayTao(new Date());
					capDonViHanhChinh.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					capDonViHanhChinh.setPhienBan(1);
					capDonViHanhChinh.setMota(moTaCapDonViHanhChinh);
					capDonViHanhChinh.setCap(ConvertUtil.convertToLong(_capDonViHanhChinh));
					CapDonViHanhChinhLocalServiceUtil.addCapDonViHanhChinh(capDonViHanhChinh);
					actionResponse.setRenderParameter("CompletedAddCapDonViHanhChinh", "CompletedAddCapDonViHanhChinh");
					actionResponse.setRenderParameter("completed", "completed");
					//DonViHanhChinhId = String.valueOf(capDonViHanhChinh.getId());
					//actionType = CapDonViHanhChinhBusiness.VIEW_DON_VI_HANH_CHINH;
					maDonViHanhChinh = "";
					tenDonViHanhChinh = "";
					moTaCapDonViHanhChinh = "";
					_capDonViHanhChinh = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(capDonViHanhChinh.toString());
					SessionErrors.add(actionRequest, "errorAddCapDonViHanhChinh");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("CapDonViHanhChinhId", DonViHanhChinhId);
		actionResponse.setRenderParameter("maCapDonViHanhChinh", maDonViHanhChinh);
		actionResponse.setRenderParameter("tenCapDonViHanhChinh", tenDonViHanhChinh);
		actionResponse.setRenderParameter("moTaCapDonViHanhChinh", moTaCapDonViHanhChinh);
		actionResponse.setRenderParameter("capDonViHanhChinh", _capDonViHanhChinh);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cdvhc_add.jsp");

		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
	}

	/**
	 * This is  function check validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maDonViHanhChinh
	 * @param tenDonViHanhChinh
	 * @param DonViHanhChinhId
	 * @param _capDonViHanhChinh
	 * @param actionRequest
	 * @param moTaCapDonViHanhChinh
	 * @return boolean
	 */
	private boolean validationInput(String maDonViHanhChinh, String tenDonViHanhChinh, String DonViHanhChinhId, String _capDonViHanhChinh, ActionRequest actionRequest, String moTaCapDonViHanhChinh) {
		if (maDonViHanhChinh.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaCapDonViHanhChinh");
		}
		if (_capDonViHanhChinh.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyCapDonViHanhChinh");
		}
		if (_capDonViHanhChinh.trim().length() > 0) {
			if (ConvertUtil.convertToLong(_capDonViHanhChinh) == 0) {
				SessionErrors.add(actionRequest, "numberCapDonViHanhChinh");
			}
		}
		if (tenDonViHanhChinh.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenCapDonViHanhChinh");
		}
		if (moTaCapDonViHanhChinh.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMoTaCapDonViHanhChinh");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			CapDonViHanhChinh capDonViHanhChinh = null;
			try {
				// Kieam tra theo Ma
				try {
					capDonViHanhChinh = CapDonViHanhChinhLocalServiceUtil.findByMaCapDonViHanhChinh(maDonViHanhChinh);
				} catch (NoSuchCapDonViHanhChinhException es) {
				}
				if (capDonViHanhChinh != null) {
					if (capDonViHanhChinh.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					
					if (DonViHanhChinhId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(DonViHanhChinhId) != capDonViHanhChinh.getId()) {
							SessionErrors.add(actionRequest, "exitMaCapDonViHanhChinh");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaCapDonViHanhChinh");
					}
				}

//				// Kiem tra theo Ten
//				try {
//					capDonViHanhChinh = null;
//					capDonViHanhChinh = CapDonViHanhChinhLocalServiceUtil.findByTenCapDonViHanhChinh(tenDonViHanhChinh);
//				} catch (NoSuchCapDonViHanhChinhException es) {
//				}
//				if (capDonViHanhChinh != null) {
//					if (DonViHanhChinhId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(DonViHanhChinhId) != capDonViHanhChinh.getId()) {
//							SessionErrors.add(actionRequest, "exitTenCapDonViHanhChinh");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenCapDonViHanhChinh");
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
