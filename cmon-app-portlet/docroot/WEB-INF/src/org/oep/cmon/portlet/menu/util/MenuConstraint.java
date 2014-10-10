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

package org.oep.cmon.portlet.menu.util;

import java.util.List;



import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;

import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;

/**
 * This is class MenuConstraint
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class MenuConstraint {
	
	public static final String SESSION_MENU_SELECTED="SESSION_MENU_SELECTED";
	public static final String MENU_SELECTED="selected";
	
	/**
	 * This is function getFirstURL
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param roles
	 * @param rolesOfGroup
	 * @param layouts
	 * @param isAdmin
	 * @param isRoot
	 * @return String
	 */
	public static String getFirstURL(List<Role> roles,List<Role> rolesOfGroup,List<Layout> layouts,boolean isAdmin,boolean isRoot){
		
		if(layouts != null && roles != null){
			for (Layout layout : layouts) {
				boolean isView =isViewPage(roles,rolesOfGroup, layout, isAdmin);
				if(isRoot && (layout.getParentLayoutId() >0 || !isView)){
					continue;
				}else{					
					try {
						if(!isRoot){
							if(isView){
								return getURL(layout);
							}
						}else	if(layout.getChildren() == null){
							if(isView){
								return getURL(layout);
							}
						}else{
							String cURL = getFirstURL(roles, rolesOfGroup, layout.getAllChildren(), isAdmin,false);
							if(cURL != null) return cURL;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						return getURL(layout);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * This is function getURL
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param layout
	 * @return String
	 */
	public static String getURL(Layout layout){
		try {
			return "/group" + layout.getGroup().getFriendlyURL() + layout.getFriendlyURL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		}
		return "";
	}
	
	/**
	 * This is function isViewPage
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param roles
	 * @param rolesOfGroup
	 * @param layout
	 * @param isAdmin
	 * @return boolean
	 */
	public static boolean isViewPage(List<Role> roles,List<Role> rolesOfGroup,Layout layout,boolean isAdmin){
		if(roles == null || layout == null) return false;
		if(isAdmin){
			return true;
		}else if(!layout.isHidden()){
			if(roles != null){
				for (Role role : roles) {
					if(isViewPage(role, layout)){
						return true;
					}
				}
			}
			if(rolesOfGroup != null){
				for (Role role : rolesOfGroup) {
					if(isViewPage(role, layout)){
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	/**
	 * This is function isViewPage
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role
	 * @param layout
	 * @return boolean
	 */
	public static boolean isViewPage(Role role,Layout layout){
		try {
			
			boolean hasRolePermission = ResourcePermissionLocalServiceUtil
					.hasResourcePermission(role.getCompanyId(), Layout.class.getName()
							,ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf( layout.getPrimaryKey())
							,role.getRoleId(), ActionKeys.VIEW); 
					
			if(hasRolePermission){
				return true;
			}else if(layout.getChildren() != null 
					&& layout.getChildren().size()>0){
				//check if permission child view . view parent 
				List<Layout> lList = layout.getAllChildren();
				for (Layout child : lList) {
					boolean isView = isViewPage(role, child);
					if(isView){
						return true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
	
	/**
	 * This is function getSelected
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @param selected
	 * @param css
	 * @return String
	 */
	public static final String getSelected(String value,String selected,String css){
		if(value.equals(selected)){
			return "class=\""+css+"\"";
		}
		return "";
	}

}
