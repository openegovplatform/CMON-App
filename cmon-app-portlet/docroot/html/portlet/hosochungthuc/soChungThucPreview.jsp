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
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucImpl"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.SoDanhMuc"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />

<%
renderResponse.setTitle("Chứng thực");
SoDanhMuc soDanhMuc = null;
long idHoSo = ParamUtil.getLong(request, "idHoSo");
if (idHoSo > 0) {
	soDanhMuc = SoDanhMucLocalServiceUtil.getSoDanhMuc(idHoSo);
}


/* String nhomTTHCChungThucId = ThamSoLocalServiceUtil.getValue("CT_NHOMTTHCID");
NhomThuTucHanhChinh ntthc =  NhomThuTucHanhChinhLocalServiceUtil.findTheoMa(nhomTTHCChungThucId);
 */
//List<ThuTucHanhChinh> listTTHC = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, (long)19, 0, 100);
 
//String urlquaylai = ParamUtil.getString(request, "parentUrl");
 
%>
<style type="text/css">
	table tr td {
		padding: 3px !important;
}
</style>


<portlet:renderURL var="backUrl">
	<portlet:param name="jspPage"
		value="/html/portlet/hosochungthuc/soChungThuc.jsp" />
</portlet:renderURL>

<div class="_outer egov-container">
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
			<h1 class="center clear septop20 sepbot20" style="padding: 15px 0">
				<label id="main_title" class="egov-label font20-bu">
					Chi tiết sổ chứng thực
				</label>
			</h1>
			
			<table style="background: none repeat scroll 0% 0% transparent; width: 90%">
				<tr>
						<td width="20%"><label class="egov-label-bold left">Loại sổ chứng thực:</label>
						
						</td>
						<td style="width: 40%; vertical-align: middle;">
						<%= ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(soDanhMuc.getThuTucHanhChinhId()).getTen() %>
					</td>
				</tr>
				
<%-- 				<tr>
					<td><label class="egov-label-bold left">Tên sổ chứng thực:</label>  </td>
						<td style="width: 60%; vertical-align: middle;"><%= soDanhMuc.getTenSo() %>
					</td>
				</tr> --%>
				
				<tr>
					<td><label class="egov-label-bold left">Số sổ chứng thực: </label> </td>
						<td  style="vertical-align: middle;"><%= soDanhMuc.getSoSo() != null ? soDanhMuc.getSoSo() : "" %>
					</td>
				</tr>

				<tr>
					<td><label class="egov-label-bold left">Năm : </label> </td>
						<td style="width: 60%; vertical-align: middle;"><%=soDanhMuc.getNam()%>
					</td>
				</tr>
				<tr>
					<td><label class="egov-label-bold left">Theo quyết định:</label>  </td>
						<td style="width: 60%; vertical-align: middle;"><%= soDanhMuc.getTheoQuyetDinh() != null ? soDanhMuc.getTheoQuyetDinh() : "" %>
					</td>
				</tr>
				<% if (soDanhMuc.getCoQuanQuanLiId() != null) { %>
				<tr>
					<td><label class="egov-label-bold left">Co quan quản lý:</label>  </td>
						<td style="width: 60%; vertical-align: middle;">
						<%= soDanhMuc.getCoQuanQuanLiId() != null ? CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(soDanhMuc.getCoQuanQuanLiId()).getTen() : "" %>
					</td>
				</tr>
				<% }  %>
			</table>
			
			<div class="button-bar left">
				<input type="button" onclick="location.href='<%= backUrl %>'" class="egov-button" value="Quay lại"/>
			</div>
	</div>
</div>