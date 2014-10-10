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

package org.oep.system.portlet.resource.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyenClp;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalService;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import vn.dtt.sharedservice.Constaints;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/** 
 * This is class SystemResourcePortlet
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class SystemResourcePortlet extends MVCPortlet {
	private static Log _log  = LogFactoryUtil.getLog(SystemResourcePortlet.class.getName());
	
	/** 
	 * This is function rolePage
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void rolePage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		long heThongId=3;
		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		
		try {
			User user =PortalUtil.getUser(actionRequest);
			List<Layout> rootLayouts = LayoutLocalServiceUtil.getLayouts(groupId,true);
			
			if(rootLayouts != null){
				for (Layout layout : rootLayouts) {
					try{
					if(layout.getChildren() != null && layout.getChildren().size()>0){
						continue;
					}
					if(!layout.getHidden()){						
						_log.info("create role :"+layout.getNameCurrentValue());
						
						Role role =RoleLocalServiceUtil.addRole(user.getUserId(), user.getCompanyId(), layout.getNameCurrentValue()
								, null, null, RoleConstants.TYPE_REGULAR);
						//set permisstion
						_log.info("1. role OK");
						
						ResourcePermissionLocalServiceUtil.addResourcePermission(user.getCompanyId(), Layout.class.getName(), 
								ResourceConstants.SCOPE_COMPANY, String.valueOf(layout.getLayoutId()), role.getRoleId(), ActionKeys.VIEW);
						_log.info("2. Permission ok");
						
						
						long tainguyenId =CounterLocalServiceUtil.increment(TaiNguyen.class.getName());
						TaiNguyen taiNguyen = new TaiNguyenClp();
						taiNguyen.setId(tainguyenId);
						taiNguyen.setDaXoa(0);
						taiNguyen.setTrangThai(1);
						taiNguyen.setTen(layout.getNameCurrentValue());
						taiNguyen.setGiaTri(String.valueOf(role.getRoleId()));
						taiNguyen.setHeThongId(heThongId);			
						taiNguyen.setNguoiTao("liemnn");
						taiNguyen.setNgayTao(new Date());
						taiNguyen.setLoai(1);
						
						TaiNguyenLocalServiceUtil.addTaiNguyen(taiNguyen);
						_log.info("3. tai nguyen ok");
						
					
					}
					}catch (Exception e) {
						// TODO: handle exception
				
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
	}
 

}
