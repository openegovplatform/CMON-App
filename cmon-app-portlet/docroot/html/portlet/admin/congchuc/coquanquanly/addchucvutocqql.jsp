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
	function apDungChucVu2CQQL(){
		var checkboxs = $('input[name="strcqqlids[]"]:checked');
	    if (checkboxs.length == 0) {
			alert ("Bạn cần phải chọn ít nhất cơ quan quản lý");
			return false;
		}else{
			document.frmSearchCoQuanQuanLyPopup.submit();
		}
	}
</script>
<%
PortletURL searchCQQLURL = renderResponse.createActionURL();
searchCQQLURL.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLyPopup");
//define variables
String chucVuId ="";
String coQuanQuanLyId ="";
String searchInputText = ""; 
//get request atts
if(Validator.isNotNull(request.getAttribute("chucVuId"))){
	chucVuId = request.getAttribute("chucVuId").toString();
}
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = request.getAttribute("coQuanQuanLyId").toString();
}
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
//get render params
if ( Validator.isNotNull(renderRequest.getParameter("chucVuId")) ) {
	chucVuId = renderRequest.getParameter("chucVuId");
}
if ( Validator.isNotNull(renderRequest.getParameter("coQuanQuanLyId")) ) {
	coQuanQuanLyId = renderRequest.getParameter("coQuanQuanLyId");
}
if ( Validator.isNotNull(renderRequest.getParameter("searchInputText")) ) {
	searchInputText = renderRequest.getParameter("searchInputText");
}
//end get params
List<CoQuanQuanLy> listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
if(Validator.isNotNull(request.getAttribute("listCoQuanQuanLy"))){
	listCoQuanQuanLy = (List<CoQuanQuanLy>)request.getAttribute("listCoQuanQuanLy");
}else{
	listCoQuanQuanLy = CongChucUtils.searchCoQuanQuanLyByMaOrTen(searchInputText, 0);
}
PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("chucVuId", chucVuId);
iteratorUrl.setParameter("coQuanQuanLyId", coQuanQuanLyId);
iteratorUrl.setParameter("searchInputText", searchInputText);
iteratorUrl.setParameter("jspPage", "/html/portlet/admin/congchuc/coquanquanly/addchucvutocqql.jsp");

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
if(listCoQuanQuanLy==null){
	listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
}
List<CoQuanQuanLy> results = ListUtil.subList(listCoQuanQuanLy, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setTotal(listCoQuanQuanLy.size());
searchContainer.setResults(results);
%>
<div>
	<liferay-ui:error key="addChucVuError" message = "vn.dtt.cmon.admin.portlet.chucvu.err.add"/>
	<liferay-ui:success key="createChucVuSuccess" message = "vn.dtt.cmon.admin.portlet.chucvu.success.add"/>
</div>
<form action="<%=searchCQQLURL.toString()%>" method="post" name="frmSearchCoQuanQuanLyPopup" id="frmSearchCoQuanQuanLyPopup">
	<input type="hidden" name="chucVuId" id="chucVuId" value="<%=chucVuId%>" />
	<input type="hidden" name="coQuanQuanLyId" id="coQuanQuanLyId" value="<%=coQuanQuanLyId%>" />
	<table width="100%" border="0">
		<tr>
			<td>
				<input id="searchInputText" name="searchInputText" type="text" value="<%=searchInputText %>" class="egov-inputfield custom" size="30" placeholder="Tên, mã cơ quan quản lý" />
				<input type="submit" value="Tìm kiếm" class="egov-button-search">
				<input type="hidden" name="parentId">
			</td>
		</tr>
	</table><br/>
<%
if(results.size()>0){
	int stt = 0;
	int rowStyle = 1;
%>
<table class="egov-table">
	<thead>
		<tr>
			<td colspan="4" style="border: 0px">
				<h3>Chức vụ: <%=ChucVuLocalServiceUtil.fetchChucVu(Long.valueOf(chucVuId)).getTen() %></h3>
			</td>
		</tr>
		<tr>
			<th style="width: 15px;text-align: center;">STT</th>
			<th style="text-align: center;">Mã cơ quan quản lý</th>
			<th style="text-align: center;">Tên Cơ quan quản lý</th>
			<th style="text-align: center;">Chọn</th>
		</tr>
	</thead>
	<tbody>
	<%
	for(CoQuanQuanLy coQuan : results){
		stt++;
	%>
	<tr class="bgcolor-<%=rowStyle%>">
		<td style="text-align: center;"><%=searchContainer.getStart()+stt %></td>
		<td style="text-align: center;width: 10%"><%=coQuan.getMa() %></td>
		<td><%=coQuan.getTen() %></td>
		<td style="text-align: center;"><input type="checkbox" name="strcqqlids[]" value="<%=coQuan.getId() %>" /></td>
	</tr>
	<%
		rowStyle = rowStyle==1?2:1;
	}
	%>
	</tbody>
</table>
<div style="width: 100%" >
	<liferay-ui:search-paginator searchContainer="<%=searchContainer%>"/>
</div>
<%
}else{
%>
<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
<%} %>
<div style="width: 100%;padding-top: 10px;padding-bottom: 10px;text-align: left;">
	<a href= "#" onclick="apDungChucVu2CQQL();return false;"><input type="button" value="Áp dụng"  class="egov-button-normal" /></a>
	<a href= "#" onclick="dongCuaSoPoup()"><input type="button" value="Đóng"  class="egov-button-normal" /></a>
</div>
</form>
