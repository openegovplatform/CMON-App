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
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChucClp"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
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
String maOrTenOrEmail = ""; 
String coQuanQuanLyId = "";
CongChuc congChuc = new CongChucClp();
TaiKhoanNguoiDung taiKhoan = new TaiKhoanNguoiDungClp();
CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyClp();
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
if(Validator.isNotNull(request.getAttribute("congChuc"))){
	congChuc = (CongChuc)request.getAttribute("congChuc");
}
if(Validator.isNotNull(request.getAttribute("taiKhoan"))){
	taiKhoan = (TaiKhoanNguoiDung)request.getAttribute("taiKhoan");
}
if(Validator.isNotNull(request.getAttribute("coQuanQuanLy"))){
	coQuanQuanLy = (CoQuanQuanLy)request.getAttribute("coQuanQuanLy");
}
if(Validator.isNotNull(request.getAttribute("maOrTenOrEmail"))){
	maOrTenOrEmail = request.getAttribute("maOrTenOrEmail").toString();
}
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = request.getAttribute("coQuanQuanLyId").toString();
}
PortletURL backToListCongChucURL = renderResponse.createRenderURL();
backToListCongChucURL.setParameter("coQuanQuanLyId", coQuanQuanLyId);
backToListCongChucURL.setParameter("maOrTenOrEmail", maOrTenOrEmail);
backToListCongChucURL.setParameter("tab", "CC");

%>
<div class="egov-container">
	<table class="egov-table" width="100%" border="0">
		<thead>
			<tr>
				<td style="border: 0px" colspan="2">
					<h3>Thông tin cán bộ</h3>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="key" style="width: 20%">Họ và tên</td>
				<td>
					<%=congChuc.getHoVaTen() %>
				</td>
			</tr>
			<tr>
				<td class="key" style="width: 20%">Mã cán bộ</td>
				<td>
					<%=congChuc.getMa() %>
				</td>
			</tr>
			<tr>
				<td class="key">Email</td>
				<td>
					<%=taiKhoan.getEmail() %>
				</td>
			</tr>
			<tr>
				<td class="key">Ngày sinh</td>
				<td>
					<%=df.format(congChuc.getNgaySinh()) %>
				</td>
			</tr>
			<tr>
				<td class="key">Giới tính</td>
				<td>
					<%=GioiTinhLocalServiceUtil.fetchGioiTinh(congChuc.getGioiTinhId()).getTen() %>
				</td>
			</tr>
			<tr>
				<td class="key">CMND</td>
				<td>
					<%=congChuc.getSoCmnd() %>
				</td>
			</tr>
			<tr>
				<td class="key">Cơ quan quản lý</td>
				<td>
					<%=coQuanQuanLy.getTen() %>
				</td>
			</tr>
			<tr>
				<td class="key">Chức vụ</td>
				<td>
					<%=ChucVuLocalServiceUtil.fetchChucVu(congChuc.getChucVuId()).getTen() %>
				</td>
			</tr>
		</tbody>
	</table>
	<div style="padding: 10px;width: 100%">
		<a href="<%=backToListCongChucURL%>"><input type="button" class="egov-button-normal" value="Quay lại danh sách" /></a>
	</div>
</div>