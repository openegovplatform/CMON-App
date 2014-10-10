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
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.cmon.util.ComUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page import="org.oep.cmon.Constants" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<%
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	PortletPreferences portletPrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	
	// page config
	String quiTrinh = portletPrefs.getValue(Constants.QuiTrinh.QUITRINH_PARAMS, "");
	int quiTrinhInt = GetterUtil.getInteger(quiTrinh);
%>
<aui:form action="<%= configurationURL %>" method="post" name="fm" >
	<input name="<portlet:namespace /><%= com.liferay.portal.kernel.util.Constants.CMD%>" type="hidden" value="<%=com.liferay.portal.kernel.util.Constants.UPDATE%>" />

	<p>Cấu hình qui trình</p>
	<div class="wd-list-transaction wd-list-citizen">
		<fieldset class="wd-list-transaction-form">
 				<select name="<%= Constants.QuiTrinh.QUITRINH_PARAMS %>" >
					<option value="<%=Constants.QuiTrinh.CHUNG_THUC %>" <% if (Constants.QuiTrinh.CHUNG_THUC == quiTrinhInt) { %>selected<% } %>>Chứng thực</option>
					<option value="<%=Constants.QuiTrinh.HO_SO_CHUNG_THUC %>" <% if (Constants.QuiTrinh.HO_SO_CHUNG_THUC == quiTrinhInt) { %>selected<% } %>>Hồ sơ chứng thực</option>
					<option value="<%=Constants.QuiTrinh.SO_CHUNG_THUC %>" <% if (Constants.QuiTrinh.SO_CHUNG_THUC == quiTrinhInt) { %>selected<% } %>>Quản lý số chứng thực</option>
		    	</select> 
		</fieldset>
	</div>
	<br/>
	
	<aui:button-row>
		<aui:button type="submit" value="lưu" />
	</aui:button-row>
</aui:form>

