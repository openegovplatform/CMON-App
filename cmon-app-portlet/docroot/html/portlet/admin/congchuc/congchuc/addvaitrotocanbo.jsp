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
<%@page import="org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.admin.congchuc.utils.CongChucUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
<script type = "text/javascript">
	function dongCuaSoPoup() {
	    window.close();
	}
	function ganQuyenToCanBo(){
		var checkboxs = $('input[name="strVaiTroIds[]"]:checked');
	    if (checkboxs.length == 0) {
			alert ("Bạn cần phải chọn ít nhất 1 vai trò");
			return false;
		}else{
			document.frmSearchVaiTroPopup.submit();
		}
	}
</script>
<%
int submited = 0;
if(Validator.isNotNull(request.getAttribute("submited"))){
	submited =Integer.valueOf(request.getAttribute("submited").toString()); 
}
if(submited == 1){
	%>
	<script>
	window.opener.funcTest();
	</script>
	<%
}
PortletURL searchVaiTroURL = renderResponse.createActionURL();
searchVaiTroURL.setParameter(ActionRequest.ACTION_NAME, "searchVaiTroPopup");
//define variables
String congChucId ="";
String searchInputText = ""; 
//get request atts
if(Validator.isNotNull(request.getAttribute("congChucId"))){
	congChucId = request.getAttribute("congChucId").toString();
}
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
//get render params
if ( Validator.isNotNull(renderRequest.getParameter("congChucId")) ) {
	congChucId = renderRequest.getParameter("congChucId");
}
//end get params
List<VaiTro> listVaiTro = new ArrayList<VaiTro>();
if(Validator.isNotNull(request.getAttribute("listVaiTro"))){
	listVaiTro = (List<VaiTro>)request.getAttribute("listVaiTro");
}else{
	listVaiTro = VaiTroLocalServiceUtil.findByTrangThai(0);
}
List<NguoiDung2VaiTro> listNguoiDung2VaiTro = new ArrayList<NguoiDung2VaiTro>();
CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(Long.valueOf(congChucId));
TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
if(taiKhoanNguoiDung!=null){
	listNguoiDung2VaiTro = NguoiDung2VaiTroLocalServiceUtil.findByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(),0);
}
%>
<div>
	<liferay-ui:error key="addVaiTroError" message = "Lỗi gán quyền cho cán bộ!"/>
	<liferay-ui:success key="addVaiTroSuccess" message = "Gán quyền cho cán bộ thành công!"/>
</div>
<form action="<%=searchVaiTroURL.toString()%>" method="post" name="frmSearchVaiTroPopup" id="frmSearchVaiTroPopup">
	<input type="hidden" name="congChucId" id="congChucId" value="<%=congChucId%>" />
	<table width="100%" border="0">
		<tr>
			<td>
				<input id="searchInputText" name="searchInputText" type="text" value="<%=searchInputText %>" class="egov-inputfield custom" size="30" placeholder="Tên quyền hạn" />
				<input type="submit" value="Tìm kiếm" class="egov-button-search">
			</td>
		</tr>
	</table><br/>
<%
if(listVaiTro.size()>0){
	int stt = 0;
	int rowStyle = 1;
%>
<table class="egov-table">
	<thead>
		<tr>
			<td style="border: 0px" colspan="3">
				<h3>Cán bộ: <%=congChuc.getHoVaTen()%></h3>
			</td>
		</tr>
		<tr>
			<th style="width: 15px;text-align: center;">STT</th>
			<th style="text-align: center;">Tên quyền hạn</th>
			<th style="text-align: center;">Chọn</th>
		</tr>
	</thead>
	<tbody>
	<%
	for(VaiTro vaiTro : listVaiTro){
		boolean exits = false;
		for(NguoiDung2VaiTro nd2vt : listNguoiDung2VaiTro){
			if(nd2vt.getVaiTroId()==vaiTro.getId()){
				exits = true;
				break;
			}
		}
		if(!exits){
			stt++;
	%>
	<tr class="bgcolor-<%=rowStyle%>">
		<td style="text-align: center;"><%=stt %></td>
		<td><%=vaiTro.getTen() %></td>
		<td style="text-align: center;"><input type="checkbox" name="strVaiTroIds[]" value="<%=vaiTro.getId() %>" /></td>
	</tr>
	<%
			rowStyle = rowStyle==1?2:1;
		}
	}
	%>
	</tbody>
</table>
<%
}else{
%>
<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
<%} %>
<div style="width: 100%;padding-top: 10px;padding-bottom: 10px;text-align: left;">
	<a href= "#" onclick="ganQuyenToCanBo();return false;"><input type="button" value="Áp dụng"  class="egov-button-normal" /></a>
	<a href= "#" onclick="dongCuaSoPoup()"><input type="button" value="Đóng"  class="egov-button-normal" /></a>
</div>
</form>
