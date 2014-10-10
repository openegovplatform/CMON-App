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
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
<%
String tabs = ParamUtil.getString(request, "tab", "CQQL");

if(Validator.isNotNull(request.getAttribute("tab"))){
	tabs = request.getAttribute("tab").toString();
}

if(Validator.isNotNull(renderRequest.getParameter("tab"))){
	tabs = renderRequest.getParameter("tab");
}

PortletURL cqqlURL = renderResponse.createRenderURL();
cqqlURL.setWindowState(WindowState.NORMAL);
cqqlURL.setParameter("tab","CQQL");

PortletURL congChucURL = renderResponse.createRenderURL();
congChucURL.setWindowState(WindowState.NORMAL);
congChucURL.setParameter("tab","CC");
%>
<div class="egov-container">
	<div id="egov-tab" style="padding-left: 5px">
		<ul>
			<li><a href="<%=cqqlURL.toString() %>" class="<%=tabs.equals("CQQL")?"active":"" %>"> Cơ quan quản lý</a></li>
			<li><a href="<%=congChucURL.toString() %>" class="<%=tabs.equals("CC")?"active":"" %>">Công chức</a></li>
		</ul>
	</div>
	<c:if test='<%= tabs.equals("CQQL") %>'>
	  <liferay-util:include page="/html/portlet/admin/congchuc/coquanquanly/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	</c:if>
	<c:if test='<%= tabs.equals("CC") %>'>
	  <liferay-util:include page="/html/portlet/admin/congchuc/congchuc/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	</c:if>
</div>

