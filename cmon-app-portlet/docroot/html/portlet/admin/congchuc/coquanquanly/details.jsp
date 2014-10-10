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
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="javax.portlet.ActionRequest"%>
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
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	padding: 0px 10px !important;	
}
.key{
	background-color: #f3f3f3 !important;
	font-weight: bold !important;	
}
</style>
<%
String searchInputText = ""; 
String parentId = "";
CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyClp();
if(Validator.isNotNull(request.getAttribute("coQuanQuanLy"))){
	coQuanQuanLy = (CoQuanQuanLy)request.getAttribute("coQuanQuanLy");
}
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
if(Validator.isNotNull(request.getAttribute("parentId"))){
	parentId = request.getAttribute("parentId").toString();
}
PortletURL backToCQQLURL = renderResponse.createRenderURL();
backToCQQLURL.setParameter("parentId", parentId);
backToCQQLURL.setParameter("searchInputText", searchInputText);
%>
<div class="egov-container">
	<table class="egov-table" width="100%" border="0">
		<thead>
			<tr>
				<td colspan="2" style="border: 0px">
					<h3>Thông tin cơ quan quản lý</h3>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="key" style="width: 20%">Tên cơ quan</td>
				<td>
					<%=coQuanQuanLy.getTen() %>
				</td>
			</tr>
			<tr>
				<td class="key" style="width: 20%">Mã cơ quan</td>
				<td>
					<%=coQuanQuanLy.getMa() %>
				</td>
			</tr>
			<tr>
				<td class="key">Địa chỉ</td>
				<td>
					<%=coQuanQuanLy.getDiaChi() %>
				</td>
			</tr>
			<tr>
				<td class="key">Điện thoại</td>
				<td>
					<%=coQuanQuanLy.getDienThoai() %>
				</td>
			</tr>
			<tr>
				<td class="key">Fax</td>
				<td>
					<%=coQuanQuanLy.getFax() %>
				</td>
			</tr>
			<tr>
				<td class="key">Email</td>
				<td>
					<%=coQuanQuanLy.getEmail() %>
				</td>
			</tr>
			<tr>
				<td class="key">Website</td>
				<td>
					<%=coQuanQuanLy.getWebsite() %>
				</td>
			</tr>
			<tr>
				<td class="key">Cấp cơ quan</td>
				<td>
					<%=CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(coQuanQuanLy.getCapCoQuanQuanlyId()).getTen() %>
				</td>
			</tr>
		</tbody>
	</table>
	<div style="width: 100%;padding: 10px 10px">
		<a href="<%=backToCQQLURL%>"><input type="button" class="egov-button-normal" value="Quay lại danh sách" /></a>
	</div>
</div>