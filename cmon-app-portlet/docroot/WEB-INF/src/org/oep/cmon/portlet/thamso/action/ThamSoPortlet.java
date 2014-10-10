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

package org.oep.cmon.portlet.thamso.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.oep.cmon.portlet.thamso.util.FormatUtil;
import org.oep.sharedservice.cmon.provider.thamso.ThamSoUtils;

import org.oep.cmon.dao.cd.model.HeThong;
import org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.model.ThamSoClp;

import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
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
*
* ThamSoPortlet class
*   
* This class is used to render ThamSoPortlet
* 
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class ThamSoPortlet extends MVCPortlet {
 
	
	/**
	  * This is fucntion findByTenThamSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyWord, Long ungDungId, Long heThongId, int start, int end
	  * @return List<ThamSo>
	  */
		@SuppressWarnings("unchecked")
		public List<ThamSo> findByTenThamSo(String keyWord, Long ungDungId, Long heThongId, int start, int end) {
			List<ThamSo> results = null;
	
			if (keyWord.trim().length() > 0|ungDungId!=null|heThongId!=null) {
				// Query code request using keyword
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(ThamSo.class);
				query.addOrder(OrderFactoryUtil.asc("Ten"));
				query.setLimit(start, end);
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTen = RestrictionsFactoryUtil.ilike("Ten",  StringPool.PERCENT + keyWord + StringPool.PERCENT);
				
				Criterion criteriaUngDung=null;
				Criterion criteriaHeThong=null;
				if(ungDungId!=null)
				{
					criteriaUngDung = RestrictionsFactoryUtil.eq("UngDungId", ungDungId);
				}
				else
				{
					criteriaUngDung = RestrictionsFactoryUtil.isNull("UngDungId");
				}
				if(heThongId!=null)
				{
					criteriaHeThong =  RestrictionsFactoryUtil.eq("HeThongId", heThongId);
				}
				else
				{
					criteriaHeThong = RestrictionsFactoryUtil.isNull("HeThongId");
				}
				
				Criterion criteria = RestrictionsFactoryUtil.and(criteriaUngDung, criteriaHeThong);				
				query = query.add(RestrictionsFactoryUtil.and(criteriaTen, criteria));
	
				try {
					results = ThamSoLocalServiceUtil.dynamicQuery(query);
				} catch (SystemException e) {
				}
			} else {
				try {
	
					DynamicQuery query = DynamicQueryFactoryUtil.forClass(ThamSo.class);
					query.addOrder(OrderFactoryUtil.asc("Ten"));
					query.setLimit(start, end);
					results = ThamSoLocalServiceUtil.dynamicQuery(query);
				} catch (SystemException e) {
				}
			}
	
			if (results == null) {
				results = new ArrayList<ThamSo>();
			}
			return results;
		}
		
		/**
		  * This is fucntion getUngDungList
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param 
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
		  * This is fucntion getHeThongList
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param 
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
		  * This is fucntion searchThamSoRequest
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param ActionRequest actionRequest, ActionResponse actionResponse
		  * @return void
		  */
		public void searchThamSoRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
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
			
			PortletPreferences prefs = actionRequest.getPreferences();		
			
			int cur = ParamUtil.getInteger(actionRequest, "curTS", 1);
			int delta = ParamUtil.getInteger(actionRequest, "deltaTS", 10);
			prefs.setValue("curTS", String.valueOf(cur));
			prefs.setValue("deltaTS", String.valueOf(delta));
			prefs.store();
			actionResponse.setRenderParameter("searchKeyWord", keyWord);
			actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
			actionResponse.setRenderParameter("ungDungId", ungDung);
			actionRequest.getPortletSession().setAttribute("ungDungId", ungDung);
			actionResponse.setRenderParameter("heThongId", heThong);
			actionRequest.getPortletSession().setAttribute("heThongId", heThong);
			actionResponse.setRenderParameter("jspPage", "/html/portlet/thamso/tham_so_view.jsp");
			
		}
		
		
		/**
		  * This is fucntion editOrAddThamSoRequest
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param ActionRequest actionRequest, ActionResponse actionResponse
		  * @return void
		  */
		public void editOrAddThamSoRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
			// Get params
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String keyWord = actionRequest.getParameter("searchKeyWord");
			String actionType = ParamUtil.getString(actionRequest, "actionType");
			long thamSoId = ParamUtil.getLong(actionRequest, "thamSoId");
			String tenThamSo = ParamUtil.getString(actionRequest, "tenThamSo", null);
			String giaTri = ParamUtil.getString(actionRequest, "giaTri",null);
			int kieuDuLieu=ParamUtil.getInteger(actionRequest, "kieuDuLieu");
			int trangThai=ParamUtil.getInteger(actionRequest, "trangThaiThamSo");
			Long ungDungId=ParamUtil.getLong(actionRequest, "ungDungId");
			Long heThongId=ParamUtil.getLong(actionRequest, "heThongId");
			String moTa = ParamUtil.getString(actionRequest, "moTaThamSo",null);
			ungDungId=ungDungId==0L?null:ungDungId;
			heThongId=heThongId==0L?null:heThongId;
			if (validationInput(tenThamSo, thamSoId, actionRequest)) {
				ThamSo thamSo = null;
				if (thamSoId > 0) {
					try {
						thamSo = ThamSoLocalServiceUtil.fetchThamSo(thamSoId);
						thamSo.setTen(tenThamSo);
						thamSo.setGiaTri(giaTri);
						thamSo.setKieuDuLieu(kieuDuLieu);
						thamSo.setNgaySua(new Date());
						thamSo.setNguoiSua(themeDisplay.getUser().getEmailAddress());
						thamSo.setDaXoa(trangThai);
						thamSo.setUngDungId(ungDungId);
						thamSo.setHeThongId(heThongId);
						thamSo.setMota(moTa);
						ThamSo thamso = ThamSoLocalServiceUtil.updateThamSo(thamSo);
						if(thamso==null)
						{
							SessionErrors.add(actionRequest, "errorAddThamSo");
						}
						else
						{
							ThamSoUtils.loading();
							actionResponse.setRenderParameter("CompletedUpdateThamSo", "CompletedUpdateThamSo");
							actionResponse.setRenderParameter("completed", "completed");
							SessionMessages.add(actionRequest, "successUpdateThamSo");
						}
					} catch (Exception es) {
						FormatUtil.printException(es);
						FormatUtil.printError(thamSo.toString());
						SessionErrors.add(actionRequest, "errorUpdateThamSo");
					}
				} else {
					try {
						thamSo = new ThamSoClp();
						thamSo.setId(CounterLocalServiceUtil.increment(ThamSo.class.getName()));
						thamSo.setTen(tenThamSo);
						thamSo.setGiaTri(giaTri);
						thamSo.setKieuDuLieu(kieuDuLieu);
						thamSo.setNgaySua(new Date());
						thamSo.setNguoiSua(themeDisplay.getUser().getEmailAddress());
						thamSo.setNgayTao(new Date());
						thamSo.setNguoiTao(themeDisplay.getUser().getEmailAddress());
						thamSo.setDaXoa(trangThai);
						thamSo.setUngDungId(ungDungId);
						thamSo.setHeThongId(heThongId);
						thamSo.setMota(moTa);
						ThamSo thamso = ThamSoLocalServiceUtil.addThamSo(thamSo);
						if(thamso==null)
						{
							SessionErrors.add(actionRequest, "errorAddThamSo");
						}
						else
						{
							ThamSoUtils.loading();
							actionResponse.setRenderParameter("CompletedAddThamSo", "CompletedAddThamSo");
							actionResponse.setRenderParameter("completed", "completed");
							SessionMessages.add(actionRequest, "successAddThamSo");
							tenThamSo = "";
							giaTri = "";
							kieuDuLieu=0;
							trangThai=0;
							moTa="";
							ungDungId=0L;
							heThongId=0L;
						}
					} catch (Exception es) {
						FormatUtil.printException(es);
						FormatUtil.printError(thamSo.toString());
						SessionErrors.add(actionRequest, "errorAddThamSo");
					}
				}
			}

			actionResponse.setRenderParameter("ActionType", actionType);
			actionResponse.setRenderParameter("thamSoId", String.valueOf(thamSoId));
			actionResponse.setRenderParameter("tenThamSo", tenThamSo);
			actionResponse.setRenderParameter("giaTri", giaTri);
			actionResponse.setRenderParameter("kieuDuLieu",  String.valueOf(kieuDuLieu));
			actionResponse.setRenderParameter("trangThaiThamSo", String.valueOf(trangThai));
			actionResponse.setRenderParameter("ungDungId", String.valueOf(ungDungId));
			actionResponse.setRenderParameter("heThongId", String.valueOf(heThongId));
			actionResponse.setRenderParameter("moTaThamSo", moTa);
			actionResponse.setRenderParameter("jspPage", "/html/portlet/thamso/tham_so_add.jsp");

			FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
		}
		
		/**
		  * This is fucntion deleteThamSoRequest
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param ActionRequest actionRequest,	ActionResponse actionResponse
		  * @return void
		  */
		public void deleteThamSoRequest(ActionRequest actionRequest,
				ActionResponse actionResponse) throws Exception {
			// Get search keyword, the keyword can either be Ten
			String keyWord = actionRequest.getParameter("searchKeyWord");

			// Get search keyword, the keyword is code
			long thamSoId = ParamUtil.getLong(actionRequest, "thamSoId");
			try
			{		
				ThamSoLocalServiceUtil.deleteThamSo(thamSoId);
				ThamSoUtils.loading();
				actionRequest.setAttribute("delete_success", "delete_success");
				SessionMessages.add(actionRequest, "successDeleteThamSo");	
		
			} catch (Exception es) {
					
				FormatUtil.printException(es);
				SessionErrors.add(actionRequest, "errorDeleteThamSo");				
			}
			FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
			actionResponse.setRenderParameter("jspPage",
					"/html/portlet/thamso/tham_so_view.jsp");

		}
		
		/**
		  * This is fucntion validationInput
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param String tenThamSo, long thamSoId, ActionRequest actionRequest
		  * @return boolean
		  */
		private boolean validationInput(String tenThamSo, long thamSoId, ActionRequest actionRequest) {
			
			if (tenThamSo.trim().length() == 0) {
				SessionErrors.add(actionRequest, "emptyTenThamSo");
			}			
			if (SessionErrors.isEmpty(actionRequest)) {
				ThamSo thamSo = null;
				try {
					try {
						thamSo = null;
						thamSo = ThamSoLocalServiceUtil.findByTen(tenThamSo);
					} catch (Exception es) {
					}
					if (thamSo != null) {
						if (thamSo.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE) {
							return true;
						}
						if (thamSoId > 0) {
							if (thamSoId != thamSo.getId()) {
								SessionErrors.add(actionRequest, "existTenThamSo");
							}
						} else {
							SessionErrors.add(actionRequest, "existTenThamSo");
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

}
