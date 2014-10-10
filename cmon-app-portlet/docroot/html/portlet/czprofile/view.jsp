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
<%@page import="vn.dtt.sharedservice.cmon.consumer.citizen.Citizen"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.oep.cmon.czprofile.portlet.util.TransactionUtils"%>
<%@page import="javax.portlet.WindowState"%>
<%@ include file="/html/portlet/czprofile/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "tab.czprofile.detail");

if (renderRequest.getPortletSession().getAttribute("change_pass") != null) {
	tabs1 = renderRequest.getPortletSession().getAttribute("change_pass").toString();
	
	renderRequest.getPortletSession().removeAttribute("change_pass");
}

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("jspPage", "/html/portlet/czprofile/view.jsp");
portletURL.setParameter("tabs1", tabs1);
String tabNames = "tab.czprofile.detail,tab.czprofile.changepass";


%>
<liferay-ui:tabs names="<%= tabNames %>"  url="<%= portletURL.toString() %>"/>

<c:if test='<%= tabs1.equals("tab.czprofile.detail") %>'>
	 <%
	Citizen citizen=null;
	citizen = WebserviceFactory.getCmonService().getCitizenByUser(user.getUserId());
	if(citizen!=null)//Thong tin con dan
	{
	%>
 		<%@include file="/html/portlet/czprofile/viewCzProfileDetail.jsp"%>
	<%
	}
	else//Thong tin can bo
	{%>
	
	 	<%@include file="/html/portlet/czprofile/viewOfficialProfileDetail.jsp"%>
	<%
	}
	 %>
</c:if>
<c:if test='<%= tabs1.equals("tab.czprofile.changepass") %>'>
  <%@include file="/html/portlet/czprofile/changePassword.jsp"%>
</c:if>
