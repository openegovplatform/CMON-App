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
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="org.oep.egovcore.language.BusinessMessagerUtil"%>
<%@page import="org.oep.cmon.dichvucongmanhinhtrunggian.portlet.util.DichVuCongManHinhTrungGianUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="org.oep.cmon.portlet.menu.util.MenuConstraint"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	String headerThuTucTitle = BusinessMessagerUtil.get(request,"vn.dtt.cmon.dichvucongdashboard.tblhosoheader.thutuc");
	String headerNguoiNopTitle = BusinessMessagerUtil.get(request,"vn.dtt.cmon.dichvucongdashboard.tblhosoheader.nguoinop");
	String headerNgayNopTitle = BusinessMessagerUtil.get(request,"vn.dtt.cmon.dichvucongdashboard.tblhosoheader.ngaynop");
	String headerThaoTacTitle = BusinessMessagerUtil.get(request,"vn.dtt.cmon.dichvucongdashboard.tblhosoheader.thaotac");
	
	// clear the session for current selecting of menu
	portletSession.setAttribute(MenuConstraint.SESSION_MENU_SELECTED, "#", PortletSession.APPLICATION_SCOPE);
			
	Layout currentLayout  = (Layout) request.getAttribute(WebKeys.LAYOUT);
	String title = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(currentLayout.getPlid(),"args");
	
	List<Layout> rootLayouts = LayoutLocalServiceUtil.getLayouts(
			themeDisplay.getLayout().getGroup().getGroupId(), true);
	
	String defaultURL = "#";
	if (rootLayouts != null && rootLayouts.size() > 0) {
		defaultURL = MenuConstraint.getURL(rootLayouts.get(0));
	}

%>
<input type="hidden" id="ipThuTucTitle" value="<%=headerThuTucTitle %>" />
<input type="hidden" id="ipNguoiNopTitle" value="<%=headerNguoiNopTitle %>" />
<input type="hidden" id="ipNgayNopTitle" value="<%=headerNgayNopTitle %>" />
<input type="hidden" id="ipThaoTacTitle" value="<%=headerThaoTacTitle %>" />
<div class="wd-content-container">
<h2 class="wd-title-lg wd-no-bdt"><a href="<%= defaultURL%>"><%= title %></a></h2>
<div id="tab-side-container">
<div class="wd-sidebar">
	<%
		boolean isAdmin = PortalUtil.isGroupAdmin(user, themeDisplay
				.getLayout().getGroup().getGroupId());
		String idUser =String.valueOf(PortalUtil.getUserId(request));
		List<Role> rList = null;
		List<Role> rGList = null;
		if (PortalUtil.getUser(request) != null) {
			rList = PortalUtil.getUser(request).getRoles();
			try {
				List<UserGroup> ugList = UserGroupLocalServiceUtil
						.getUserUserGroups(user.getUserId());
				if (ugList != null) {
					for (UserGroup ur : ugList) {
						rGList = RoleLocalServiceUtil.getGroupRoles(ur
								.getGroup().getGroupId());
						
						if (rGList != null) {
							break;
							
						} else {
						}

					}
				}
			} catch (Exception e) {

			}
		}
	%>
	<ul class="wd-list-menu " id="menu_dvc">
		<%
			String divContent = "";

			//for show menu 
			String styleClazz = "";
			for (int i = 0;i<rootLayouts.size();i++) {
				String activeClazz = "";
				if(i==0){
					activeClazz = "wd-active";
				}
				Layout obj1 = rootLayouts.get(i);
				if (obj1.getParentLayoutId() > 0|| !MenuConstraint.isViewPage(rList, rGList, obj1,isAdmin)||!DichVuCongManHinhTrungGianUtil.isDisplayInDashboard(obj1)) {
					continue;
				}
				List<Layout> childrens = obj1.getAllChildren();
				if (childrens != null && childrens.size() > 0) {
			%> 
			<li class="wd-has-sub <%=activeClazz%>"><a href="#"><%=obj1.getNameCurrentValue()%><i class="icon-ib ico_icon-arrow-right"></i></a>
				<ul class="wd-list-menu wd-style-02 wd-submenu">
			<%
				for (int j = 0;j<childrens.size();j++) {
					activeClazz = "";
					if(i==0&&j==0){
						activeClazz = "wd-active";
					}
					Layout child = childrens.get(j);
					if (!MenuConstraint.isViewPage(rList, rGList, child,isAdmin)||!DichVuCongManHinhTrungGianUtil.isDisplayInDashboard(child)) {
						continue;
					}
					String args = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(child.getPlid(),"args");
					if(!DichVuCongManHinhTrungGianUtil.getArgsOfLayout(child.getPlid(),"divCountClass").equals("")){
						styleClazz = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(child.getPlid(),"divCountClass");
					}else{
						styleClazz = "blue";
					}
					String result = "";
					if(!args.equals("")){
						result = "<div class='wd-label wd-label-bg-"+styleClazz+"'>"+DichVuCongManHinhTrungGianUtil.validInputAndInvokeMethod(String.valueOf(child.getPlid()),idUser,"count",args)+"</div>";
						divContent+=DichVuCongManHinhTrungGianUtil.validInputAndInvokeMethod(String.valueOf(child.getPlid()),idUser,"list",args);
					}else{
						divContent += "<div id='side-tab"+child.getPlid()+"' class='side-content'>Dữ liệu tạm thời chưa có!</div>";	
					}							
			%>
			<li class="<%=activeClazz%>">
				<a href='#side-tab<%=child.getPlid()%>'> <%=child.getNameCurrentValue()+result%></a>
			</li>
			<%
				}
			%>
				</ul>
			</li>
			<%
 			} else {
 				String args = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(obj1.getPlid(),"args");
				String result = "";
				if(!DichVuCongManHinhTrungGianUtil.getArgsOfLayout(obj1.getPlid(),"divCountClass").equals("")){
					styleClazz = DichVuCongManHinhTrungGianUtil.getArgsOfLayout(obj1.getPlid(),"divCountClass");
				}else{
					styleClazz = "blue";
				}
				if(!args.equals("")){
					result = "<div class='wd-label wd-label-bg-"+styleClazz+"'>"+DichVuCongManHinhTrungGianUtil.validInputAndInvokeMethod(String.valueOf(obj1.getPlid()),idUser,"count",args)+"</div>";
					divContent+=DichVuCongManHinhTrungGianUtil.validInputAndInvokeMethod(String.valueOf(obj1.getPlid()),idUser,"list",args);
				}else{
					divContent += "<div id='side-tab"+obj1.getPlid()+"' class='side-content'>Dữ liệu tạm thời chưa có!</div>";	
				}
 			%>
 			<li class="<%=activeClazz%>"><a href='#side-tab<%=obj1.getPlid()%>'><span><%=obj1.getNameCurrentValue()+result%></span></a></li>
 			<%}%>
		<%
			}
		%>
	</ul>	
</div>
<div class="wd-main-content wd-page-staff">
	<%=divContent %>
</div>
</div>
</div>