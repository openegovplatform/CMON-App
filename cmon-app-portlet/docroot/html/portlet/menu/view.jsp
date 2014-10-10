<!-- 
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
  -->

<%@page import="org.oep.cmon.dichvucongmanhinhtrunggian.portlet.util.DichVuCongManHinhTrungGianUtil"%>
<%@page import="com.liferay.portal.service.UserServiceUtil"%>
<%@page import="com.liferay.portal.model.UserGroupRole"%>
<%@page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserGroupRoleUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.menu.util.MenuConstraint"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.persistence.OrganizationFinderUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserGroupFinder"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@page contentType="text/html; charset=UTF-8" %>
	<%
		//ThemeDisplay  themeDisplay = null;
		boolean isAdmin= PortalUtil.isGroupAdmin(user,themeDisplay.getLayout().getGroup().getGroupId());
		List<Role> rList = null;
		List<Role> rGList = null;
		String idUser =String.valueOf(PortalUtil.getUserId(request));
		
		if(PortalUtil.getUser(request) != null){
			rList=PortalUtil.getUser(request).getRoles();
		
			try{
				List<UserGroup>  ugList= UserGroupLocalServiceUtil.getUserUserGroups(user.getUserId());
				if(ugList != null){
					for(UserGroup  ur : ugList){
						rGList = RoleLocalServiceUtil.getGroupRoles(ur.getGroup().getGroupId());
						if(rGList != null) {
							break;
							
						}else{
						}
						
					}
				}
			}catch(Exception e){
				
			}
		}
		
		String urlDirect =ParamUtil.getString(request, MenuConstraint.SESSION_MENU_SELECTED);
		String menuId = (String)portletSession.getAttribute(MenuConstraint.SESSION_MENU_SELECTED,PortletSession.APPLICATION_SCOPE);
		ThemeDisplay td  = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String currentPageURL = td.getURLCurrent();
	%>
	
	<script type="text/javascript">
	function closeAndOpenChildrens(obj,parentId){
			var parentObj = document.getElementById("egov-menu-parent-"+parentId);
			if(parentObj != null){
					var display = parentObj.style.display;
					if(display == 'none'){
						parentObj.style.display='';
						obj.setAttribute("class","egov-menu-left-parent-down");
						obj.className="egov-menu-left-parent-down";
					}else{
						parentObj.style.display='none';
						obj.setAttribute("class","egov-menu-left-parent-open");
						obj.className="egov-menu-left-parent-open";
						}
			}	
		}

		function openParent(parentId){
			var parentObj = document.getElementById("egov-menu-parent-"+parentId);
			if(parentObj != null){
				parentObj.style.display='';
					
			}	
		}
	</script>
	<style>
		.style-count {
			font-size: 12px; text-align: center; width: 24px; border-radius: 5px; color: white; float: right; margin-right: 8px; padding: 2px 0px 2px 2px;
		}
	</style>	
		
	
	<div class="egov-menu-left">		
		<ul>
			<%
			String url = "";
			List<Layout> rootLayouts = LayoutLocalServiceUtil.getLayouts(themeDisplay.getLayout().getGroup().getGroupId(),true);

			if (menuId != null &&  menuId.length() > 0) {
				boolean status = true;
				 String group="/group";

				 for (Layout obj2 : rootLayouts) {				
					url = MenuConstraint.getURL(obj2);
					
					if (currentPageURL.equals(url)) {
						menuId = currentPageURL;
					}
					
					if (menuId.compareTo(url) == 0) {
						status = false;
						portletSession.setAttribute(MenuConstraint.SESSION_MENU_SELECTED, menuId ,PortletSession.APPLICATION_SCOPE);
						break;
					}
				}
				 
				if (status) {
					if (rootLayouts.size() > 0) {
						menuId = url = MenuConstraint.getURL(rootLayouts.get(0));
						portletSession.setAttribute(MenuConstraint.SESSION_MENU_SELECTED, menuId ,PortletSession.APPLICATION_SCOPE);
					}
				}
			}
			
			//for show menu
			for (Layout obj1 : rootLayouts) {
				if( obj1.getParentLayoutId()>0 
						|| !MenuConstraint.isViewPage(rList,rGList, obj1,isAdmin)){
					continue;
				}
				
				url = MenuConstraint.getURL(obj1);
				
				if (currentPageURL.equals(url)) {
					menuId = currentPageURL;
				}
				
				if (menuId == null || menuId.length() == 0 ) {
					menuId = url;
					portletSession.setAttribute(MenuConstraint.SESSION_MENU_SELECTED, menuId, PortletSession.APPLICATION_SCOPE);
				}

				List<Layout> childrens = obj1.getAllChildren();
				if(obj1.isTypeURL()){
					%>
						<li>
						<a href="<%=obj1.getTypeSettingsProperties().getProperty("url")%>"><%=obj1.getNameCurrentValue() %></a>
						</li>
					<%
					continue;
				}
				
			%>
			
				<portlet:actionURL var="sendDataToRegistrationPortletURL" >
					<portlet:param name="<%=MenuConstraint.SESSION_MENU_SELECTED%>" value="<%=url %>"/>
				</portlet:actionURL>
				<li>
				<%
					
					if(childrens != null &&childrens.size() > 0){
					%>
						<a class="egov-menu-left-parent"  href="#"
						style="<%= obj1.getHidden()?"color: rgb(195,195,195);":"" %>" 
						onclick="closeAndOpenChildrens(this,<%=obj1.getLayoutId()%>);" >	
					<%	
					}else{
						%>
						<a <%=MenuConstraint.getSelected(menuId, url, "active") %> 
							style="<%= obj1.getHidden()?"color: rgb(195,195,195);":"" %>"
						 href="<%=sendDataToRegistrationPortletURL.toString() %>">	
					
						<%
					}
				%>
					
						<%=obj1.getNameCurrentValue() %>
					</a>
				</li>
			<%
			
				
				if (childrens != null) {
					%>
						<li id="egov-menu-parent-<%=obj1.getLayoutId()%>" style="display:none;" class="wd-has-sub">
							<div id="egov-menu-left-children">
								<ul>
					<%

					for (Layout child : childrens) {
						if(!MenuConstraint.isViewPage(rList,rGList, child,isAdmin)) {
							continue;
						}
						
						url = MenuConstraint.getURL(child);
						
						if (currentPageURL.equals(url)) {
							menuId = currentPageURL;
						}
						
						if (menuId == null || menuId.length() == 0 ) {
							menuId = url;
							portletSession.setAttribute(MenuConstraint.SESSION_MENU_SELECTED, menuId ,PortletSession.APPLICATION_SCOPE);
						}
					%>
					
					<portlet:actionURL var="sendDataToRegistrationPortletURL" >
						<portlet:param name="<%=MenuConstraint.SESSION_MENU_SELECTED%>" value="<%=url %>"/>
					</portlet:actionURL>
							
					<% if (DichVuCongManHinhTrungGianUtil.isDisplayInDashboard(child)) {
							String styleClazz = "";
							String divContent = "";
							String activeClazz = "";
							
							String args = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(child.getPlid(),"args");
							if (!DichVuCongManHinhTrungGianUtil.getArgsOfLayout(child.getPlid(),"divCountClass").equals("")) {
								styleClazz = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(child.getPlid(),"divCountClass");
								
							} else {
								styleClazz = "blue";
							}
							
							String result = "";
							if (!args.equals("")) {
								result = "<div class='style-count wd-label wd-label-bg-"+styleClazz+"'>"
									+DichVuCongManHinhTrungGianUtil.validInputAndInvokeMethod(String.valueOf(child.getPlid()),idUser,"count",args, renderRequest)+"</div>";
								//divContent+=DichVuCongManHinhTrungGianUtil.validInputAndInvokeMethod(String.valueOf(child.getPlid()),idUser,"list",args);
								
							} else {
								//divContent += "<div id='side-tab"+child.getPlid()+"' class='side-content'>D? li?u t?m th?i chua có!</div>";	
							}				
						
						%>
							<li>
								<a <%=MenuConstraint.getSelected(menuId, url, "active") %> 
									style="<%= child.getHidden()?"color: rgb(195,195,195);":"" %>"
									href="<%=sendDataToRegistrationPortletURL.toString() %>" > <%=child.getNameCurrentValue()+result%></a>
							</li>
					
					<% } else { %>

							<li>
								<a <%=MenuConstraint.getSelected(menuId, url, "active") %> 
									style="<%= child.getHidden()?"color: rgb(195,195,195);":"" %>"
									href="<%=sendDataToRegistrationPortletURL.toString() %>" >
										<%=child.getNameCurrentValue() %>
								</a>
							</li>
						<%
							}
						%>
						
					<%
						if (menuId.equals(url)) {
					%>
						<script type="text/javascript">
							openParent(<%=obj1.getLayoutId()%>);
						</script>
					<%
						}
					%>
							
					<%
						} 
					%>
						</ul>
					</div>
				 </li>
					<%
				}

			}
			%>
		</ul>
	</div>
	
	
