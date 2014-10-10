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
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
CongChuc congChuc = (CongChuc) request.getAttribute("congChuc");
PortletURL saveURL = renderResponse.createActionURL();
saveURL.setParameter(ActionRequest.ACTION_NAME, "saveResetPassword");
%>
<html>
<style>
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	border:none !important;
	padding: 0px 10px !important;	
}
.egov-inputfield{
	width: 100%;
}
.aui-form-validator-error-container .aui-field-element{
	display: block !important;
}
.aui-label-required{
	display: none !important;
}
</style>	
<div class="egov-container">
<div>
	<liferay-ui:error key="empty.password" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.password"/>
	<liferay-ui:error key="empty.repassword" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.repassword"/>
	<liferay-ui:error key="missmatch.password" message="vn.dtt.cmon.admin.portlet.congchuc.err.missmatch.password"/>
	<liferay-ui:error key="change.error" message="vn.dtt.cmon.admin.portlet.password.err.change"/>
	<liferay-ui:success key="change.success" message="vn.dtt.cmon.admin.portlet.password.success.change"/>
</div>
<aui:form name="frmResetPassword" id="frmResetPassword" method="post" action="<%= saveURL %>">
	<input type="hidden" name="taiKhoanId" value="<%= Helpers.toInputHtml(congChuc.getTaiKhoanNguoiDungId()) %>">
	<table class="egov-table" width="100%" border="0">
		<thead>
			<tr>
				<td colspan="2">
					<h3>Thay đổi mật khẩu</h3>		
				</td>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>
					<b>Công chức: <%= congChuc.getHoVaTen() %></b>
				</td>
			</tr>
			<tr>
				<td>
					<aui:input name="password" value="" label="Mật khẩu mới <label class='egov-label-red'>(*)</label>" type="password" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập mật khẩu mới"></aui:validator>
					</aui:input>
				</td>
			</tr>
			<tr>
				<td>
					<aui:input name="rePassword" value="" label="Nhập lại mật khẩu mới <label class='egov-label-red'>(*)</label>" type="password" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập lại mật khẩu mới"></aui:validator>
						<aui:validator name="equalTo" errorMessage="Mật khẩu không khớp">'#<portlet:namespace />password'</aui:validator>
					</aui:input>
				</td>				
			</tr>
	
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" style="text-align: left;">
					<aui:button-row>						
						<aui:button type="submit" value="Ghi lại" />					
						<a href="#" onclick="window.opener.app.congchuc.newWindow.close(); return false;"><aui:button type="cancel" value="Đóng" /></a>
					</aui:button-row>
				</td>
			</tr>
		</tfoot>
	</table>
</aui:form>
</div>
</html>