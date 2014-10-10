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
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.SoDanhMuc"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.HoSoChungThuc"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>

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
PortletURL portletUrl = renderResponse.createRenderURL();
int currentTransPage = ParamUtil.getInteger(request, "currentTransPage");

// phan trang seach
SearchContainer searchContainer = null;
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null, null
			,SearchContainer.DEFAULT_CUR_PARAM, currentTransPage, 10, portletUrl, null, null);	
} else {
	searchContainer = new SearchContainer(renderRequest, null, null
			, SearchContainer.DEFAULT_CUR_PARAM, 10, portletUrl, null, null);
} 
int start = searchContainer.getStart();
int end = searchContainer.getEnd();

//List<SoDanhMuc> listHsChungThuc = SoDanhMucLocalServiceUtil.getSoDanhMucs(start, end);
//long listSoDanhMucCount = SoDanhMucLocalServiceUtil.getSoDanhMucsCount();

long uid = PortalUtil.getUserId(request);
CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);

List<SoDanhMuc> listHsChungThuc = SoDanhMucLocalServiceUtil.getSoDanhMucByCoQuanQuanLyId(congChuc.getCoQuanQuanLyId(), start, end);
long listSoDanhMucCount = SoDanhMucLocalServiceUtil.countSoDanhMucByCoQuanQuanLyId(congChuc.getCoQuanQuanLyId());


int total = Integer.parseInt(String.valueOf(listSoDanhMucCount));
searchContainer.setTotal(total);
searchContainer.setResults(listHsChungThuc);
searchContainer.setTotal(total);

%>
<portlet:renderURL var="addSoChungThuc">
 	<portlet:param name="jspPage" value="/html/portlet/hosochungthuc/formSoChungThuc.jsp" />
 </portlet:renderURL>
 
<portlet:resourceURL var="rutHoSoDanhMuc" id="rutHoSoDanhMuc" >
</portlet:resourceURL>

<div class="egov-container">					
<%
	if (request.getAttribute("savemessage") != null) {
%>
<div class="portlet-msg-success" style="padding-left: 20px;">Đã lưu hồ sơ</div>
<%
	}
%> 
<form>
	<div>
		<button class="egov-button right" onclick="location.href='<%= addSoChungThuc.toString() %>'" type="button">+ Thêm mới</button>
	</div>
	
	<table class="egov-table result-grid clear">
		<tr>
			<th>TT</th>
			<th style="width: 40%;">Loại giấy tờ</th>
			<th>Số sổ</th>
		<!-- 	<th>Tên sổ</th> -->
			<th>Năm</th>
			<th>Theo quyết định</th>
			<th style="width: 6%;">Thao tác</th>
		</tr>
		<% 
			int index = 1;
			for (SoDanhMuc soDanhMuc: listHsChungThuc) {
				ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(soDanhMuc.getThuTucHanhChinhId());
				
				PortletURL viewDetail = renderResponse.createRenderURL();
				viewDetail.setParameter("jspPage", "/html/portlet/hosochungthuc/soChungThucPreview.jsp");
				viewDetail.setParameter("idHoSo", String.valueOf(soDanhMuc.getId()));
				
				PortletURL editHoSo = renderResponse.createRenderURL();
				editHoSo.setParameter("jspPage", "/html/portlet/hosochungthuc/formSoChungThuc.jsp");
				editHoSo.setParameter("idHoSo", String.valueOf(soDanhMuc.getId()));
				

		%>
		<tr>
			<td><%= searchContainer.getStart() + index%></td>
			<td><%= tthc.getTen() != null ? tthc.getTen() : ""%></td>
			<td><%= soDanhMuc.getSoSo() != null ? soDanhMuc.getSoSo() : ""%></td>
			<%-- <td><%= soDanhMuc.getTenSo() %></td> --%>
			<td><%= soDanhMuc.getNam() != null ? soDanhMuc.getNam() : "" %></td>
			<td><%= soDanhMuc.getTheoQuyetDinh() != null ? soDanhMuc.getTheoQuyetDinh() : "" %></td>
			<td style="text-align: center; width: 12%;"><a href="<%= viewDetail%>" title="Xem chi tiết" ><span class="icon-7" style="margin-top: 5px;"></span></a>
			<button onclick="location.href='<%=editHoSo.toString()%>'" class="egov-func-edit" title="Chỉnh sửa hồ sơ"  type="button"></button>
			<button onclick="rutHoSo('<%=rutHoSoDanhMuc%>','<%=soDanhMuc.getId()%>');" class="egov-func-delete" title="Xóa hồ sơ"  type="button" style="width: 15px; height: 15px;"></button>
			</td>
		</tr>
		<%
				index ++;
			}
		%>
	</table>
	
	<div id = "paginationTrans">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</form>
</div>

<div id="loading" title="Đang chuyển hồ sơ"> 
</div>

<script>
$(document).ready(function(){
	// hidden save message
  	$('.portlet-msg-success').fadeOut("slow");

});

function rutHoSo(url, idHoSo) {           
	if (confirm('Bạn chắc chắn muốn xóa hồ sơ?')) {
	  	var title = 'Đang xóa hồ sơ ...';
		postDataToServer(url, idHoSo, title);
	}
}

$("#loading").dialog({
    hide: 'close',
	show: 'slide',
	autoOpen: false,
    height: 30,
    width: 250,
    resizable: false,
    title: "Đang chuyển hồ sơ ..."
});

function postDataToServer(url, idHoSo, title) {	
	$.ajax({
		  url : url,
		  data : 'idHoSo=' + idHoSo,
		  type: 'POST',
		  dataType : "json",
		  beforeSend: function(){
			  $("#loading").dialog({
				    title: title
				});
	           $("#loading").dialog('open');
	        },
		  success : function(data) {
			 $("#loading").dialog('close');
			 var  status = jQuery.parseJSON(data.status);			  
			 
			 if (status) {
				  location.reload();
				  
			 } else {
				 alert("Không thể xóa");
			 }
		  }
		});
}
</script>