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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@ include file="/html/portlet/init.jsp" %>
<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	<div class="wd-list-transaction wd-list-citizen">
	<fieldset class="wd-list-transaction-form">
		<table class="wd-list-transaction-table">
			<thead>
				<tr>
					<td><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.stt" /></td>
					<td><liferay-ui:message key="vn.dtt.brms.registry.config.tenUngDung" /></td>
					<td><liferay-ui:message key="vn.dtt.brms.registry.config.tenPortlet" /></td>
					<td><liferay-ui:message key="vn.dtt.brms.registry.config.portletId" /></td>
				</tr>
			</thead>
			<tbody>
			<%
				String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
				PortletPreferences resourcePrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
				List<DanhMucUngDung> ungDungs = DanhMucUngDungLocalServiceUtil.getDSUngDung(0);// ACTIVED
				for (int i=0; i < ungDungs.size(); i++) {
					DanhMucUngDung instance = (DanhMucUngDung) ungDungs.get(i);
					String maUngDung = instance.getMa().trim().toLowerCase();
					String paramName = maUngDung+"Name";
					String paramId = maUngDung+"Id";
					String instancePortletName = resourcePrefs.getValue(paramName,"");
					String instancePortletId = resourcePrefs.getValue(paramId,"");
			%>
				<tr>
					<td><%=(i+1)%></td>
					<td><b><%=instance.getTen()%></b></td>
					<td>
						<input type="text" title="<%=instancePortletName%>" value="<%=instancePortletName%>" name="<portlet:namespace /><%=paramName%>" />
					</td>
					<td>
						<input type="text" title="<%=instancePortletId%>" value="<%=instancePortletId%>" name="<portlet:namespace /><%=paramId%>" />
					</td>
				</tr>	
				<% } %>
			</tbody>
		</table>
	</fieldset>
	</div>

	<br/>
	<p>Cấu hình xử lý hồ sơ</p>
	<div class="wd-list-transaction wd-list-citizen">
		<fieldset class="wd-list-transaction-form">
			<%
				portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
					resourcePrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
					String processingProfilePrefParam = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;
					String processingProfilePrefValue = resourcePrefs.getValue(processingProfilePrefParam,"");
			%>
				<select name="<%=processingProfilePrefParam%>">
					<aui:option value="other" selected="<%= processingProfilePrefValue.equals(\"other\")%>">Cán bộ một cửa</aui:option>
					<aui:option value="processingProfile" selected="<%= processingProfilePrefValue.equals(\"processingProfile\")%>">Cán bộ xử lý</aui:option>
				</select>
		</fieldset>
	</div>
	<br/>
	<input type="button" value="<%=LanguageUtil.get(pageContext, "vn.dtt.brms.registry.viewTransaction.config.save")%>"
		onClick="submitForm(document.<portlet:namespace />fm);" /> 
</form>