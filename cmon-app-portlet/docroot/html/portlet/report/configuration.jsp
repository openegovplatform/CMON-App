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
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="org.oep.cmon.Constants" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<%
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	PortletPreferences portletPrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	String[] id_capcoquan = portletPrefs.getValues("id_capcoquan",null);
	List<String> listidccq = new ArrayList<String>();
	if(id_capcoquan!=null){
		listidccq = Arrays.asList(id_capcoquan);
	}
	List<CapCoQuanQuanLy> listcapcoquan = ActionAdminUtil.getAllCapcoquanquanly(0); 
%>
<style>
table.tbconfig {
	border-top:1px solid #ccc;
	border-left:1px solid #ccc;
}
table.tbconfig tr td,table.tbconfig tr th {
	border-right:1px solid #ccc;
	border-bottom:1px solid #ccc;
}
table.tbconfig tr th {
	background: #eee;
}
</style>
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" type="hidden" value="<%= com.liferay.portal.kernel.util.Constants.UPDATE %>" />
	<p>Cấu hình báo cáo</p>
	<table class="tbconfig">
	<tr>
		<th style="width: 15px"><input type="checkbox" name="chkall" onclick="SelectAll(this,'id_capcoquan')"></th>
		<th>Tên cấp cơ quan</th>
	</tr>
	<%
	for(int i=0;i<listcapcoquan.size();i++){
	%>
	<tr>
		<td><input value="<%=listcapcoquan.get(i).getId()%>" type="checkbox" 
		<%=listidccq.contains(String.valueOf(listcapcoquan.get(i).getId()))?"checked":""%> name="id_capcoquan[]"></td>
		<td><%=listcapcoquan.get(i).getTen()%></td>
	</tr>
	<%}%>
	<tr>
		<td colspan="2" style="text-align: center;">
		<aui:button-row>
			<aui:button type="submit" value="Lưu cấu hình" />
		</aui:button-row>
	</tr>
	</table>
</aui:form>