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
<%@page import="org.oep.cmon.portlet.document.util.TabUtils"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
	String tab = ParamUtil.getString(request, DocumentConstants.Tab.TAB,null);
	String jspPage = ParamUtil.getString(request, "jspPage",null);
	if(tab == null){
		
		tab = (String)session.getAttribute(DocumentConstants.Tab.TAB);	
		if(tab == null) tab = DocumentConstants.Tab.APPLICATION;
	}else{
		session.setAttribute(DocumentConstants.Tab.TAB,tab);	
	}
	
	if(jspPage == null){
		tab = DocumentConstants.Tab.APPLICATION;
	}
	
%>

<portlet:renderURL var="appURL">
	<portlet:param name="<%=DocumentConstants.Tab.TAB%>"
				   value="<%=DocumentConstants.Tab.APPLICATION%>"/>
	<portlet:param name="jspPage"
				   value="/html/portlet/document/setting/ung_dung_list.jsp"/>
	
</portlet:renderURL>
<portlet:renderURL var="groupURL">
	<portlet:param name="<%=DocumentConstants.Tab.TAB%>"
		value="<%=DocumentConstants.Tab.GROUP%>"/>
	<portlet:param name="jspPage"
				   value="/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_list.jsp"/>
	
</portlet:renderURL>
<portlet:renderURL var="tthcURL">
	<portlet:param name="<%=DocumentConstants.Tab.TAB%>"
		value="<%=DocumentConstants.Tab.TTHC%>"/>
	
	<portlet:param name="jspPage"
				   value="/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp"/>
	
</portlet:renderURL>



<ul id="egov-tab">		
	<li><a href="<%=appURL%>"
		<%=TabUtils.getSelected(tab,
				DocumentConstants.Tab.APPLICATION, "active")%>>
			<liferay-ui:message key="vn.dtt.cmon.document.tab.ungdung.title"/> </a></li>
	<li><a href="<%=groupURL%>"
		<%=TabUtils.getSelected(tab, DocumentConstants.Tab.GROUP,
				"active")%>>
			<liferay-ui:message key="vn.dtt.cmon.document.tab.nhomtthc.title"/> </a></li>
	<li><a href="<%=tthcURL%>"
		<%=TabUtils.getSelected(tab, DocumentConstants.Tab.TTHC,
				"active")%>>
			<liferay-ui:message key="vn.dtt.cmon.document.tab.tthc.title"/> </a></li>
</ul>



