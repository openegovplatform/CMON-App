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
	String thongTinThanhToanPrefParam = Constants.ThongTinThanhToan.THONG_TIN_THANH_TOAN_PREF_PARAM;
	String thongTinThanhToanPrefValue = portletPrefs.getValue(thongTinThanhToanPrefParam, "" + Constants.ThongTinThanhToan.PHI);
	int thongTinThanhToan_cfg = GetterUtil.getInteger(thongTinThanhToanPrefValue);
%>
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" type="hidden" value="<%= com.liferay.portal.kernel.util.Constants.UPDATE %>" />
	<p>Cấu hình phí, lệ phí</p>
	<div class="wd-list-transaction wd-list-citizen">
		<fieldset class="wd-list-transaction-form">
			<select name="<%=thongTinThanhToanPrefParam%>">
				<c:if test="<%= thongTinThanhToan_cfg == Constants.ThongTinThanhToan.PHI %>" >
					<aui:option value="<%= Constants.ThongTinThanhToan.PHI %>" selected="true">Phí</aui:option>
					<aui:option value="<%= Constants.ThongTinThanhToan.LE_PHI %>">Lệ Phí</aui:option>
				</c:if>
				<c:if test="<%= thongTinThanhToan_cfg == Constants.ThongTinThanhToan.LE_PHI %>" >
					<aui:option value="<%= Constants.ThongTinThanhToan.PHI %>">Phí</aui:option>
					<aui:option value="<%= Constants.ThongTinThanhToan.LE_PHI %>" selected="true">Lệ Phí</aui:option>
				</c:if>
			</select>
		</fieldset>
	</div>
	<br/>
	<aui:button-row>
		<aui:button type="submit" value="<%=LanguageUtil.get(pageContext, \"vn.dtt.brms.registry.viewTransaction.config.save\")%>" />
	</aui:button-row>
</aui:form>