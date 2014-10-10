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

import org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinhClp;

import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

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
 * This is class DanhMucDonViHanhChinhAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class DanhMucDonViHanhChinhAction {

	/**
	 * This is function search DanhMucDonViHanhChinh
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
	public void searchDanhMucDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten or Ma
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<DonViHanhChinh> results = findByTenDonViHanhChinh(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmdvhc_list.jsp");
	}
	
	/**
	 * This is function find DonViHanhChinh by TenDonViHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @throws Exception
	 * @return List<DonViHanhChinh>
	 */
	@SuppressWarnings("unchecked")
	public List<DonViHanhChinh> findByTenDonViHanhChinh(String keyWord) {
		List<DonViHanhChinh> results = null;
		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DonViHanhChinh.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
			
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
					
			// Define search criteria
			query = query.add( RestrictionsFactoryUtil.and(criteria, criteriaTrangThai) );
					
			try {
				results = DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DonViHanhChinh.class);		
								
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
			// Define search criteria
			query = query.add(criteriaTrangThai);
								
			try {
				results = DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}
		
		if (results == null) {
			results = new ArrayList<DonViHanhChinh>();
		}
		return results;
	}

	/**
	 * This is function DonViHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private long countDonViHanhChinhRequest(String keyWord) throws Exception {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DonViHanhChinh.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");			
		
		// Define search criteria
		query = query.add( criteria );
		
		try {
			return DonViHanhChinhLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * Delete DanhMucDonViHanhChinh request
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteDanhMucDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String CapDonViHanhChinhId = ParamUtil.getString(actionRequest, "DonViHanhChinhId");
		
		// Process Jason feed
		try {
//			DonViHanhChinh capDonViHanhChinh = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(ConvertUtil.convertToLong(CapDonViHanhChinhId));
//			capDonViHanhChinh.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			DonViHanhChinhLocalServiceUtil.updateDonViHanhChinh(capDonViHanhChinh);
			DonViHanhChinhLocalServiceUtil.deleteDonViHanhChinh(ConvertUtil.convertToLong(CapDonViHanhChinhId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			if (es instanceof NullPointerException) {
						actionRequest.setAttribute("delete_success", "delete_success");
			} else {
				SessionErrors.add(actionRequest, "errorDeleteDanhMucDonViHanhChinh");
			}
			SetParamUtil.printException(es);
			
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmdvhc_list.jsp");
	}

	/**
	 * This is function edit or add  DanhMucDonViHanhChinh
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
	public void editOrAddDanhMucDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String DonViHanhChinhId = ParamUtil.getString(actionRequest, "DonViHanhChinhId");
		String maDonViHanhChinh = ParamUtil.getString(actionRequest, "maDonViHanhChinh").trim();
		String tenDonViHanhChinh = ParamUtil.getString(actionRequest, "tenDonViHanhChinh").trim();
		String quocGiaId = ParamUtil.getString(actionRequest, "quocGiaId");
		String capDonViHanhChinhId = ParamUtil.getString(actionRequest, "capDonViHanhChinhId");
		String chaId = ParamUtil.getString(actionRequest, "chaId");

		if (validationInput(maDonViHanhChinh, tenDonViHanhChinh, DonViHanhChinhId, actionRequest)) {
			DonViHanhChinh capDonViHanhChinh = null;
			if (DonViHanhChinhId.trim().length() > 0) {
				try {
					capDonViHanhChinh = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(ConvertUtil.convertToLong(DonViHanhChinhId));
					capDonViHanhChinh.setMa(maDonViHanhChinh);
					capDonViHanhChinh.setTen(tenDonViHanhChinh);
					capDonViHanhChinh.setNgaySua(new Date());
					if (ConvertUtil.convertToLong(chaId) > 0) {
						capDonViHanhChinh.setChaId(ConvertUtil.convertToLong(chaId));
					}
					if (ConvertUtil.convertToLong(quocGiaId) > 0) {
						capDonViHanhChinh.setQuocGiaId(ConvertUtil.convertToLong(quocGiaId));
					}
					if (ConvertUtil.convertToLong(capDonViHanhChinhId) > 0) {
						capDonViHanhChinh.setCapDonViHanhChinhId(ConvertUtil.convertToLong(capDonViHanhChinhId));
					}
					capDonViHanhChinh.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					DonViHanhChinhLocalServiceUtil.updateDonViHanhChinh(capDonViHanhChinh);
					actionResponse.setRenderParameter("CompletedUpdateDanhMucDonViHanhChinh", "CompletedUpdateDanhMucDonViHanhChinh");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = DanhMucDonViHanhChinhBusiness.VIEW_DANH_MUC_DON_VI_HANH_CHINH;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(capDonViHanhChinh.toString());
					SessionErrors.add(actionRequest, "errorUpdateDanhMucDonViHanhChinh");
				}
			} else {
				try {
					capDonViHanhChinh = new DonViHanhChinhClp();
					capDonViHanhChinh.setId(CounterLocalServiceUtil.increment(DonViHanhChinh.class.getName()));
					capDonViHanhChinh.setMa(maDonViHanhChinh);
					capDonViHanhChinh.setTen(tenDonViHanhChinh);
					capDonViHanhChinh.setNgaySua(new Date());
					capDonViHanhChinh.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					capDonViHanhChinh.setNgayTao(new Date());
					capDonViHanhChinh.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					capDonViHanhChinh.setPhienBan(1);
					if (ConvertUtil.convertToLong(chaId) > 0) {
						capDonViHanhChinh.setChaId(ConvertUtil.convertToLong(chaId));
					}
					if (ConvertUtil.convertToLong(quocGiaId) > 0) {
						capDonViHanhChinh.setQuocGiaId(ConvertUtil.convertToLong(quocGiaId));
					}
					if (ConvertUtil.convertToLong(capDonViHanhChinhId) > 0) {
						capDonViHanhChinh.setCapDonViHanhChinhId(ConvertUtil.convertToLong(capDonViHanhChinhId));
					}
					DonViHanhChinhLocalServiceUtil.addDonViHanhChinh(capDonViHanhChinh);
					actionResponse.setRenderParameter("CompletedAddDanhMucDonViHanhChinh", "CompletedAddDanhMucDonViHanhChinh");
					actionResponse.setRenderParameter("completed", "completed");
					//DonViHanhChinhId = String.valueOf(capDonViHanhChinh.getId());
					//actionType = DanhMucDonViHanhChinhBusiness.VIEW_DANH_MUC_DON_VI_HANH_CHINH;
					maDonViHanhChinh = "";
					tenDonViHanhChinh = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(capDonViHanhChinh.toString());
					SessionErrors.add(actionRequest, "errorAddDanhMucDonViHanhChinh");
				}
			}
		} else {
			actionResponse.setRenderParameter("validation_error", "validation_error");
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("DonViHanhChinhId", DonViHanhChinhId);
		actionResponse.setRenderParameter("maDonViHanhChinh", maDonViHanhChinh);
		actionResponse.setRenderParameter("tenDonViHanhChinh", tenDonViHanhChinh);
		actionResponse.setRenderParameter("quocGiaId", quocGiaId);
		actionResponse.setRenderParameter("capDonViHanhChinhId", capDonViHanhChinhId);
		actionResponse.setRenderParameter("chaId", chaId);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmdvhc_add.jsp");

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
	}

	/**
	 * This is function validate input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maDonViHanhChinh
	 * @param tenDonViHanhChinh
	 * @param DonViHanhChinhId
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String maDonViHanhChinh, String tenDonViHanhChinh, String DonViHanhChinhId, ActionRequest actionRequest) {
		if (maDonViHanhChinh.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaDanhMucDonViHanhChinh");
		}
		if (tenDonViHanhChinh.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenDanhMucDonViHanhChinh");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			DonViHanhChinh capDonViHanhChinh = null;
			try {
				// Kieam tra theo Ma
				try {
					capDonViHanhChinh = DonViHanhChinhLocalServiceUtil.findByMaDVHC(maDonViHanhChinh);
				} catch (NoSuchDonViHanhChinhException es) {
				}
				if (capDonViHanhChinh != null) {
					if (capDonViHanhChinh.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}

					if (DonViHanhChinhId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(DonViHanhChinhId) != capDonViHanhChinh.getId()) {
							SessionErrors.add(actionRequest, "exitMaDanhMucDonViHanhChinh");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaDanhMucDonViHanhChinh");
					}
				}

				// Kiem tra theo Ten
//				try {
//					capDonViHanhChinh = null;
//					capDonViHanhChinh = DonViHanhChinhLocalServiceUtil.findByTenDVHC(tenDonViHanhChinh);
//				} catch (NoSuchDonViHanhChinhException es) {
//				}
//				if (capDonViHanhChinh != null) {
//					if (DonViHanhChinhId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(DonViHanhChinhId) != capDonViHanhChinh.getId()) {
//							SessionErrors.add(actionRequest, "exitTenDanhMucDonViHanhChinh");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenDanhMucDonViHanhChinh");
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
