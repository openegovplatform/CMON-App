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

package org.oep.cmon.portlet.mapping.action;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.portlet.mapping.utils.Constaints;
import org.oep.cmon.portlet.mapping.utils.DeleteThread;
import org.oep.cmon.portlet.mapping.utils.SynchThread;


import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.model.AnhXaClp;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class MappingPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class MappingPortlet extends MVCPortlet {
	

	/**
	 * This is function deleteSynch
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
	public void deleteSynch(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		Long appid = ParamUtil.getLong(actionRequest, "appid",0L);
		String table = ParamUtil.getString(actionRequest, "table","");		
		Boolean overwrite = ParamUtil.getBoolean(actionRequest, "overwrite",false);
		boolean error = false;
		if(Validator.isNull(table)){
			SessionErrors.add(actionRequest, Constaints.Errors.BANG_DNG_ISNULL);
			error = true;
		}
		if(appid.intValue()<=0){
			SessionErrors.add(actionRequest, Constaints.Errors.UNGDUNG_DNG_ISNULL);
			error = true;
		}
		if(!error){
			if(SynchThread.running){
				SessionMessages.add(actionRequest, Constaints.SYNCH_RUNNING);
			}else{
				DeleteThread thread = new DeleteThread(appid, table, overwrite);
				thread.start();
			}
		}else{
			actionResponse.setRenderParameter("table",table);
			actionResponse.setRenderParameter("appid",appid.toString());
		}	
		
		actionResponse.setRenderParameter("jspPage","/html/portlet/mapping/synch.jsp");
	}	
	
	/**
	 * This is function synchronizes
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
	public void synchronize(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		Long appid = ParamUtil.getLong(actionRequest, "appid",0L);
		String table = ParamUtil.getString(actionRequest, "table","");
		Boolean overwrite = ParamUtil.getBoolean(actionRequest, "overwrite",false);
		boolean error = false;
		if(Validator.isNull(table)){
			SessionErrors.add(actionRequest, Constaints.Errors.BANG_DNG_ISNULL);
			
			error = true;
		}
		if(appid.intValue()<=0){
			SessionErrors.add(actionRequest, Constaints.Errors.UNGDUNG_DNG_ISNULL);
			
			error = true;
		}
		
		if(!error){
			
			
			if(SynchThread.running){
				SessionMessages.add(actionRequest, Constaints.SYNCH_RUNNING);
			}else{
				SynchThread thread = new SynchThread(appid, table, overwrite);
				thread.start();
			}
		}else{
			actionResponse.setRenderParameter("table",table);
			actionResponse.setRenderParameter("appid",appid.toString());
		}	
		
		actionResponse.setRenderParameter("jspPage","/html/portlet/mapping/synch.jsp");
	}
	
	
	
	/**
	 * This is function save
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
	public void save(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		AnhXa anhXa = getAnhXaByPost(PortalUtil.getHttpServletRequest(actionRequest));
		boolean success = false;
		try{
			
			
			if(!validator(actionRequest, anhXa)){
				if(anhXa.getId() <=0 ){
					anhXa.setId(CounterLocalServiceUtil.increment(AnhXa.class.getName()));
					AnhXaLocalServiceUtil.addAnhXa(anhXa);
					success =true;
					
				}else{
					success =true;
					AnhXaLocalServiceUtil.updateAnhXa(anhXa, true);
					
				}
				actionRequest.removeAttribute(AnhXa.class.getName());
				SessionMessages.add(actionRequest, Constaints.ACTION_SUCCESS);
				
			}else{
				actionResponse.setRenderParameter(Constaints.ACTION_ERRORS,Constaints.ACTION_ERRORS);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			SessionErrors.add(actionRequest, Constaints.Errors.SYSTEM);
		}
		actionResponse.setRenderParameter("jspPage","/html/portlet/mapping/add.jsp");
		if(success && anhXa.getId() >0){
			actionResponse.setRenderParameter("jspPage","/html/portlet/mapping/view.jsp");
		}
		actionResponse.setRenderParameter(Constaints.ACTION_SAVE,Constaints.ACTION_SAVE);
		
		
		
	}
	
	
	/**
	 * This is function delete
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
	public void delete(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long anhxaid=ParamUtil.get(actionRequest, "anhxaid",0L);
		if(anhxaid >0){
			AnhXaLocalServiceUtil.deleteAnhXa(anhxaid);
			SessionMessages.add(actionRequest, Constaints.ACTION_SUCCESS);
		}
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/mapping/view.jsp");
		
		
	}
	
	
	/**
	 * This is function search
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
	public void search(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		
		PortletSession session = actionRequest.getPortletSession();
		
		String keyword = ParamUtil.getString(actionRequest, "keyword","");
		String table = ParamUtil.getString(actionRequest, "table","");
		Long appId = ParamUtil.getLong(actionRequest, "appId",0L);
		
		int cur = ParamUtil.getInteger(actionRequest, "cur", 1);
		int delta = ParamUtil.getInteger(actionRequest, "delta", 10);
		session.setAttribute("keyword", keyword);
		session.setAttribute("table", table);
		session.setAttribute("appId", appId.toString());
		
		session.setAttribute("cur", String.valueOf(cur));
		session.setAttribute("delta", String.valueOf(delta));
		
		
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/mapping/view.jsp");
	}
	
	/**
	 * This is function validator
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param anhXa
	 * @return boolean
	 */
	private boolean validator(ActionRequest actionRequest,AnhXa anhXa){
		boolean error = false;
		if(Validator.isNull(anhXa.getMaDNG())){
			SessionErrors.add(actionRequest, Constaints.Errors.MA_DNG_ISNULL);
			error = true;
		}
		if(Validator.isNull(anhXa.getTenDNG())){
			SessionErrors.add(actionRequest, Constaints.Errors.TEN_DNG_ISNULL);
			error = true;
		}
		if(Validator.isNull(anhXa.getMaKhac())){
			SessionErrors.add(actionRequest, Constaints.Errors.MA_KHAC_ISNULL);
			error = true;
		}
		if(Validator.isNull(anhXa.getTenKhac())){
			SessionErrors.add(actionRequest, Constaints.Errors.TEN_KHAC_ISNULL);
			error = true;
		}
		if(Validator.isNull(anhXa.getTenBang())){
			SessionErrors.add(actionRequest, Constaints.Errors.BANG_DNG_ISNULL);
			error = true;
		}
		if(anhXa.getUngDungId()<=0){
			SessionErrors.add(actionRequest, Constaints.Errors.UNGDUNG_DNG_ISNULL);
			error = true;
		}
		if(error){
			actionRequest.setAttribute(AnhXa.class.getName(),anhXa);
		}
		return error;
	}

	/**
	 * This is function getAnhXaByPost
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 * @return AnhXa
	 */
	public static AnhXa getAnhXaByPost(HttpServletRequest request) throws PortalException, SystemException{
		AnhXa anhXa = new AnhXaClp();
		anhXa.setId(ParamUtil.get(request, "anhxaid",0L));
		
		if(anhXa.getId()>0){
			//edit;
			anhXa = AnhXaLocalServiceUtil.fetchAnhXa(anhXa.getId());
			anhXa.setNgaySua(new Date());
			anhXa.setNguoiSua(PortalUtil.getUser(request).getEmailAddress());
		}else{
			//add new
			anhXa.setNgayTao(new Date());
			anhXa.setNguoiTao(PortalUtil.getUser(request).getEmailAddress());
			
		}
		
		anhXa.setMaDNG(ParamUtil.get(request, "madng",null));
		anhXa.setTenDNG(ParamUtil.get(request, "tendng",null));
		anhXa.setMaKhac(ParamUtil.get(request, "makhac",null));
		anhXa.setTenKhac(ParamUtil.get(request, "tenkhac",null));
		anhXa.setTenBang(ParamUtil.get(request, "table",null));
		anhXa.setUngDungId(ParamUtil.get(request, "appid",0L));
		
		
		return anhXa;
		
	}
 

}
