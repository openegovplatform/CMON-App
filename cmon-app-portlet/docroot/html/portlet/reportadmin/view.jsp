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
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<style>
	/*---menu admin--*/
.div_report_menu ul{margin:0; padding:0; list-style:none;padding:10px 0 15px; background:#fff !important}
.div_report_menu ul li{ display:inline; margin-right:-4px}
.div_report_menu ul li{
	background: none repeat scroll 0 0 #005e97;
    border-bottom: 3px solid #ff8400;
    border-right: 1px solid #fff;
    padding: 7px 10px;}
.div_report_menu ul li:last-child{border-right:none}
.div_report_menu a{
	color: #fff;
    font-size: 14px;
    padding: 7px 10px;
}
.div_report_menu a:hover{text-decoration:none}
.div_report_menu li:hover, .div_report_menu li.active {
    background: none repeat scroll 0 0 #ff8400;
}
</style>   
<%
String tabs = ParamUtil.getString(request, "tab", "baocao");

if(Validator.isNotNull(request.getAttribute("tab"))){
	tabs = request.getAttribute("tab").toString();
}

if(Validator.isNotNull(renderRequest.getParameter("tab"))){
	tabs = renderRequest.getParameter("tab");
}
PortletURL danhmucbaocao = renderResponse.createRenderURL();
danhmucbaocao.setWindowState(WindowState.NORMAL);
danhmucbaocao.setParameter("tab","baocao");

PortletURL danhmucrole = renderResponse.createRenderURL();
danhmucrole.setWindowState(WindowState.NORMAL);
danhmucrole.setParameter("tab","vaitro");

PortletURL nguoidung = renderResponse.createRenderURL();
nguoidung.setWindowState(WindowState.NORMAL);
nguoidung.setParameter("tab","nguoidung");
%>
<div class="div_report_menu" style="padding: 10px">
	<ul>
		<li class="<%=tabs.equals("baocao")?"active":"" %>" ><a href="<%=danhmucbaocao%>">Danh mục báo cáo</a></li>
		<li class="<%=tabs.equals("vaitro")?"active":"" %>"><a href="<%=danhmucrole%>">Danh mục vai trò</a></li>
		<li class="<%=tabs.equals("nguoidung")?"active":"" %>"><a href="<%=nguoidung%>">Danh sách người dùng</a></li>
	</ul>
</div>
<div class="egov-container">
	<c:if test='<%= tabs.equals("baocao") %>'>
		<liferay-util:include page="/html/portlet/reportadmin/danhmucbaocao/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	</c:if>
	<c:if test='<%= tabs.equals("vaitro") %>'>
		<liferay-util:include page="/html/portlet/reportadmin/role/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	</c:if>
	<c:if test='<%= tabs.equals("nguoidung") %>'>
		<liferay-util:include page="/html/portlet/reportadmin/nguoidung/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	</c:if>
</div>
