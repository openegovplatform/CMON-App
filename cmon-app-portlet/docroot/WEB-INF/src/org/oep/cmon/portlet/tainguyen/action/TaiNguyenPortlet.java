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

package org.oep.cmon.portlet.tainguyen.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.tainguyen.util.FormatUtil;
import org.oep.cmon.util.Helpers;

import org.oep.cmon.dao.cd.model.HeThong;
import org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class TaiNguyenPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TaiNguyenPortlet extends MVCPortlet {
	
	/**
	 * This is function findByTaiNguyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param ungDungId
	 * @param heThongId
	 * @param start
	 * @param end
	 * @throws Exception
	 * @return List<TaiNguyen>
	 */
	@SuppressWarnings("unchecked")
	public List<TaiNguyen> findByTaiNguyen(String ten, Long ungDungId, Long heThongId, int start, int end)
	{
		List<TaiNguyen> results=null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiNguyen.class);
		query.addOrder(OrderFactoryUtil.asc("ten"));
		query.setLimit(start, end);
		// This is a test line for display all request if there's no search criteria
		Criterion criterion = null;
		
		criterion = RestrictionsFactoryUtil.ilike("ten",  StringPool.PERCENT + ten + StringPool.PERCENT);
		if(ungDungId!=null)
		{
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("ungDungId",  ungDungId));
		}
		if(heThongId!=null)
		{
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("heThongId", heThongId));	
		}
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
		// Define search criteria			
		query = query.add(criterion);

		try {
			results = TaiNguyenLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
		}

		if (results == null) {
			results = new ArrayList<TaiNguyen>();
		}
		return results;
		
	}
	
	/**
	 * This is function countByTaiNguyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param ungDungId
	 * @param heThongId
	 * @return long
	 */
	@SuppressWarnings("unchecked")
	public long countByTaiNguyen(String ten, Long ungDungId, Long heThongId)
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiNguyen.class);		

		Criterion criterion = null;
		
		criterion = RestrictionsFactoryUtil.ilike("ten",  StringPool.PERCENT + ten + StringPool.PERCENT);
		if(ungDungId!=null)
		{
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("ungDungId",  ungDungId));
		}
		if(heThongId!=null)
		{
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("heThongId", heThongId));	
		}
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
		
		query = query.add(criterion);
		//query.setProjection(ProjectionFactoryUtil.max("thuTuHienThi"));
		query.setProjection(ProjectionFactoryUtil.rowCount());
		//query.setProjection(ProjectionFactoryUtil.sum("counter"));
		//DynamicQueryInitializ dqi = new DynamicQueryInitializerImpl(query);

		long count = 0;

		try {
			Iterator<Long>  resultsItr = 
					TaiNguyenLocalServiceUtil.dynamicQuery(query).iterator();

			if (resultsItr.hasNext()) {
				count = ((Long)resultsItr.next()).longValue();
			}
		}
		catch (SystemException se) {
			// _log.error(se.getMessage(), se);
		}

		return count;
		
	}
	/**
	 * This is function getUngDungList
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<DanhMucUngDung>
	 */
	@SuppressWarnings("unchecked")
	public List<DanhMucUngDung> getUngDungList() {
		List<DanhMucUngDung> results = null;
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DanhMucUngDung.class);
		query.addOrder(OrderFactoryUtil.asc("ten"));
		// This is a test line for display all request if there's no search criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", FormatUtil.DA_XOA_ACTIVATE);	
		
		// Define search criteria			
		query = query.add(criteriaTrangThai);

		try {
			results = DanhMucUngDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
		}


		if (results == null) {
			results = new ArrayList<DanhMucUngDung>();
		}
		return results;
	}
	
	/**
	 * This is function getHeThongList
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<HeThong>
	 */
	@SuppressWarnings("unchecked")
	public List<HeThong> getHeThongList() {
		List<HeThong> results = null;
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(HeThong.class);
		query.addOrder(OrderFactoryUtil.asc("ten"));
		// This is a test line for display all request if there's no search criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", FormatUtil.DA_XOA_ACTIVATE);	
		
		// Define search criteria			
		query = query.add(criteriaTrangThai);

		try {
			results = HeThongLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
		}


		if (results == null) {
			results = new ArrayList<HeThong>();
		}
		return results;
	}
	
	/**
	 * This is function searchTaiNguyenRequest
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
	public void searchTaiNguyenRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
	{
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		
		Long ungDungId=ParamUtil.getLong(actionRequest, "ungDungId");
		String ungDung="";
		String heThong="";
		Long heThongId=ParamUtil.getLong(actionRequest, "heThongId");
		if(ungDungId==0L) 
		{
			ungDungId=null;
		}
		else
		{
			ungDung=ungDungId.toString();
		}
		if(heThongId==0L)
		{
			heThongId=null;
		}
		else
		{
			heThong=heThongId.toString();
		}
		
		setSearchParameter(actionRequest, actionResponse);
	
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("ungDungId", ungDung);
		actionRequest.getPortletSession().setAttribute("ungDungId", ungDung);
		actionResponse.setRenderParameter("heThongId", heThong);
		actionRequest.getPortletSession().setAttribute("heThongId", heThong);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_list.jsp");
		
	}
	
	/**
	 * This is function deleteTaiNguyenRequest
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
	public void deleteTaiNguyenRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		long taiNguyenId = ParamUtil.getLong(actionRequest, "taiNguyenId");
		try
		{
			//update if used
			TaiNguyen taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyenId);
			taiNguyen.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			TaiNguyenLocalServiceUtil.updateTaiNguyen(taiNguyen);
			//delete if not used			
			//TaiNguyenLocalServiceUtil.deleteTaiNguyen(taiNguyenId);
			//TaiNguyenUtils.loading();
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteTaiNguyen");	
	
		} catch (Exception es) {
				
			// TODO: handle exception
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteTaiNguyen");				
		}
		// Hidden default error message
		setSearchParameter(actionRequest, actionResponse);
		FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
		// Redirect to document list jsp
		actionResponse.setRenderParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_list.jsp");

	}

	/**
	 * This is function addTaiNguyenRequest
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
	public void addTaiNguyenRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		setSearchParameter(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_add.jsp");
	}
	
	/**
	 * This is function editOrAddTaiNguyenRequest
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
	public void editOrAddTaiNguyenRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		long taiNguyenId = ParamUtil.getLong(actionRequest, "taiNguyenId");
		String tenTaiNguyen = ParamUtil.getString(actionRequest, "tenTaiNguyen", null);
		String giaTri = ParamUtil.getString(actionRequest, "giaTri",null);
		int loai = ParamUtil.getInteger(actionRequest, "loaiTaiNguyen");
		int trangThai=ParamUtil.getInteger(actionRequest, "trangThaiTaiNguyen");
		Long ungDungId=ParamUtil.getLong(actionRequest, "ungDungId");
		Long heThongId=ParamUtil.getLong(actionRequest, "heThongId");
		String moTa = ParamUtil.getString(actionRequest, "moTaTaiNguyen",null);
		ungDungId=ungDungId==0L?null:ungDungId;
		heThongId=heThongId==0L?null:heThongId;
		if (validationInput(tenTaiNguyen, giaTri, loai, ungDungId, heThongId, taiNguyenId, actionRequest)) {
			TaiNguyen taiNguyen = null;
			if (taiNguyenId > 0) {
				try {
					taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyenId);
					taiNguyen.setTen(tenTaiNguyen);
					taiNguyen.setGiaTri(giaTri);
					taiNguyen.setLoai(loai);
					taiNguyen.setNgaySua(new Date());
					taiNguyen.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					taiNguyen.setTrangThai(trangThai);
					taiNguyen.setUngDungId(ungDungId);
					taiNguyen.setHeThongId(heThongId);
					taiNguyen.setMoTa(moTa);
					TaiNguyen taiNguyen2 = TaiNguyenLocalServiceUtil.updateTaiNguyen(taiNguyen);
					if(taiNguyen2==null)
					{
						SessionErrors.add(actionRequest, "errorAddTaiNguyen");
					}
					else
					{
						actionResponse.setRenderParameter("CompletedUpdateTaiNguyen", "CompletedUpdateTaiNguyen");
						actionResponse.setRenderParameter("completed", "completed");
						SessionMessages.add(actionRequest, "successUpdateTaiNguyen");
					}
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(taiNguyen.toString());
					SessionErrors.add(actionRequest, "errorUpdateTaiNguyen");
				}
			} else {
				try {
					long primaryKey=CounterLocalServiceUtil.increment(TaiNguyen.class.getName());
					taiNguyen=TaiNguyenLocalServiceUtil.createTaiNguyen(primaryKey);
					taiNguyen.setId(primaryKey);
					taiNguyen.setTen(tenTaiNguyen);
					taiNguyen.setGiaTri(giaTri);
					taiNguyen.setLoai(loai);
					taiNguyen.setNgaySua(new Date());
					taiNguyen.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					taiNguyen.setNgayTao(new Date());
					taiNguyen.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					taiNguyen.setTrangThai(trangThai);
					taiNguyen.setUngDungId(ungDungId);
					taiNguyen.setHeThongId(heThongId);
					taiNguyen.setMoTa(moTa);
					TaiNguyen taiNguyen2 = TaiNguyenLocalServiceUtil.updateTaiNguyen(taiNguyen, true);
					if(taiNguyen2==null)
					{
						SessionErrors.add(actionRequest, "errorAddTaiNguyen");
					}
					else
					{
						actionResponse.setRenderParameter("CompletedAddTaiNguyen", "CompletedAddTaiNguyen");
						actionResponse.setRenderParameter("completed", "completed");
						SessionMessages.add(actionRequest, "successAddTaiNguyen");
						tenTaiNguyen = "";
						giaTri = "";
						loai=0;
						trangThai=0;
						moTa="";
						ungDungId=0L;
						heThongId=0L;
					}
				} catch (Exception es) {
					FormatUtil.printException(es);
					FormatUtil.printError(taiNguyen.toString());
					SessionErrors.add(actionRequest, "errorAddTaiNguyen");
				}
			}
		}

		// Set the result back to session
		setSearchParameter(actionRequest, actionResponse);
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("taiNguyenId", String.valueOf(taiNguyenId));
		actionResponse.setRenderParameter("tenTaiNguyen", tenTaiNguyen);
		actionResponse.setRenderParameter("giaTri", giaTri);
		actionResponse.setRenderParameter("loai",  String.valueOf(loai));
		actionResponse.setRenderParameter("trangThaiTaiNguyen", String.valueOf(trangThai));
		actionResponse.setRenderParameter("ungDungId", String.valueOf(ungDungId));
		actionResponse.setRenderParameter("heThongId", String.valueOf(heThongId));
		actionResponse.setRenderParameter("moTaTaiNguyen", moTa);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_add.jsp");

		FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
	}
	
	/**
	 * This is function validationInput
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenTaiNguyen
	 * @param giaTri
	 * @param loai
	 * @param ungDungId
	 * @param heThongId
	 * @param taiNguyenId
	 * @param actionRequest
	 * @return boolean
	 */	
	private boolean validationInput(String tenTaiNguyen, String giaTri, int loai, Long ungDungId, Long heThongId, long taiNguyenId, ActionRequest actionRequest) {
		
		if (tenTaiNguyen.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenTaiNguyen");
		}
		if (giaTri.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyGiaTri");
		}	
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			TaiNguyen taiNguyen = null;
			try {

				// Kiem tra theo Ten
				try {
					taiNguyen = null;
					taiNguyen = TaiNguyenLocalServiceUtil.findByTen(tenTaiNguyen, loai, giaTri, ungDungId, heThongId, FormatUtil.DA_XOA_ACTIVATE);
				} catch (Exception es) {
				}
				if (taiNguyen != null) {					
					if (taiNguyenId > 0) {
						if (taiNguyenId != taiNguyen.getId()) {
							SessionErrors.add(actionRequest, "existTenTaiNguyen");
						}
					} else {
						SessionErrors.add(actionRequest, "existTenTaiNguyen");
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
 
	/**
	 * This is function setSearchParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void setSearchParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String cur = ParamUtil.getString(actionRequest, "cur");
		if (!Helpers.isEmpty(cur)) {
			actionResponse.setRenderParameter("cur",
					ParamUtil.getString(actionRequest, "cur"));
		}
		String delta = ParamUtil.getString(actionRequest, "delta");
		if (!Helpers.isEmpty(delta)) {
			actionResponse.setRenderParameter("delta",
					ParamUtil.getString(actionRequest, "delta"));
		}

	}

	/**
	 * This is function setSearchParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param portletURL
	 * @param renderRequest
	 */
	public void setSearchParameter(PortletURL portletURL, RenderRequest renderRequest) {
	
		String cur = ParamUtil.getString(renderRequest, "cur");
		String delta = ParamUtil.getString(renderRequest, "delta");
		
		PortletPreferences prefs = null;

		if (renderRequest != null) {
			prefs = renderRequest.getPreferences();
			if (prefs != null) {
				cur = prefs.getValue("curTN", cur);
				delta = prefs.getValue("deltaTN", delta);
			}
		}
		portletURL.setParameter("cur", cur);
		portletURL.setParameter("delta", delta);
	}

}
