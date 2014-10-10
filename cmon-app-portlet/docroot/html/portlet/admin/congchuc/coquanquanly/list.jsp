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
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.oep.cmon.portlet.admin.congchuc.utils.CongChucUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
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
<%
PortletURL searchCQQLURL = renderResponse.createActionURL();
searchCQQLURL.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
//define variables
String searchInputText = ""; 
String parentId = "";
//get request atts
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
if(Validator.isNotNull(request.getAttribute("parentId"))){
	parentId = request.getAttribute("parentId").toString();
}
//get render params
if ( Validator.isNotNull(renderRequest.getParameter("searchInputText")) ) {
	searchInputText = URLDecoder.decode(renderRequest.getParameter("searchInputText"),StringPool.UTF8);
}
if ( Validator.isNotNull(renderRequest.getParameter("parentId")) ) {
	parentId = renderRequest.getParameter("parentId");
}
//end get params
List<CoQuanQuanLy> listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
if(Validator.isNotNull(request.getAttribute("listCoQuanQuanLy"))){
	listCoQuanQuanLy = (List<CoQuanQuanLy>)request.getAttribute("listCoQuanQuanLy");
}else{
	Long chaId = null;
	if(!parentId.equals("")){
		chaId = Long.valueOf(parentId);
	}
	if(searchInputText.equals("")){
		listCoQuanQuanLy = CoQuanQuanLyLocalServiceUtil.findByParentId(chaId,0);
	}else{
		listCoQuanQuanLy = CongChucUtils.searchCoQuanQuanLyByMaOrTen(searchInputText, 0);
	}
}
PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("searchInputText", URLEncoder.encode(searchInputText,StringPool.UTF8));
iteratorUrl.setParameter("parentId", parentId);
SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
if(listCoQuanQuanLy==null){
	listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
}
List<CoQuanQuanLy> results = ListUtil.subList(listCoQuanQuanLy, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setTotal(listCoQuanQuanLy.size());
searchContainer.setResults(results);
%>
<div>
	<liferay-ui:error key="coquanquanly.err.congChucExists" message = "org.oep.cmon.admin.portlet.cqql.err.delete.congchucexists"/>
	<liferay-ui:error key="coquanquanly.err.childExists" message = "org.oep.cmon.admin.portlet.cqql.err.delete.childexists"/>
	<liferay-ui:error key="coquanquanly.err.unKnown" message = "org.oep.cmon.admin.portlet.cqql.err.delete"/>
	<liferay-ui:success  key="coquanquanly.success.create" message="org.oep.cmon.admin.portlet.cqql.success.create" />
	<liferay-ui:success  key="coquanquanly.success.update" message="org.oep.cmon.admin.portlet.cqql.success.update" />
	<liferay-ui:success  key="coquanquanly.success.delete" message="org.oep.cmon.admin.portlet.cqql.success.delete" />
</div>
<%
if(searchInputText.equals("")){
%>
<div style="padding-top: 10px;padding-bottom: 10px;font-weight: bold;">
<%
if(!parentId.equals("")){
	Long chaId = Long.valueOf(parentId);
%>
	>> <a href="<%=searchCQQLURL.toString()%>">Cấp cao nhất</a>
<%
	List<CoQuanQuanLy> listParent = new ArrayList<CoQuanQuanLy>();
	CoQuanQuanLy cqql = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(chaId);
	listParent.add(cqql);
	while(cqql != null){
		chaId = cqql.getChaId();
		if(chaId == null){
			chaId = 0l;		
		}
		cqql = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(chaId);
		if(cqql!=null){
			listParent.add(cqql);
		}
	}
	for(int i = (listParent.size()-1);i>0;i--){
		//search sub CQQL URL
		PortletURL searchSubCQQLURL = renderResponse.createActionURL();
		searchSubCQQLURL.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
		searchSubCQQLURL.setParameter("parentId",String.valueOf(listParent.get(i).getId()));
%>
	>> <a href="<%=searchSubCQQLURL.toString()%>"><%=listParent.get(i).getTen() %></a>
<%
	}
%>
	>> <%=listParent.get(0).getTen() %>
<%
}else{
%>
>> Cấp cao nhất
<%} %>
</div>
<%} %>
<form action="<%=searchCQQLURL.toString()%>" method="post" name="frmSearchCoQuanQuanLy" id="frmSearchCoQuanQuanLy">
	<table cellspacing="5" cellpadding="5" width="100%" border="0" class="egov-table-form">
		<tr>
			<td>
				<input id="searchInputText" style="width:70%;" name="searchInputText" type="text" value="<%=searchInputText %>" class="egov-inputfield" placeholder="Tên, mã cơ quan quản lý" />
				<input type="submit" value="Tìm kiếm" class="egov-button-search">
			</td>
			<%
			PortletURL createNewCQQLUrl = renderResponse.createActionURL();
			createNewCQQLUrl.setParameter(ActionRequest.ACTION_NAME, "createCoQuanQuanLy");
			createNewCQQLUrl.setParameter("parentId", parentId);
			createNewCQQLUrl.setParameter("searchInputText", URLEncoder.encode(searchInputText,StringPool.UTF8));
		 	%>
			 <td style="text-align: right;">
				<a href = "<%=createNewCQQLUrl%>"><input type="button" value="+ THÊM MỚI"  class="egov-button-normal" /></a>
			</td>
		</tr>
	</table><br/>
</form>
<%
if(results.size()>0){
	int stt = 0;
	int rowStyle = 1;
%>
<table class="egov-table">
	<thead>
		<tr>
			<th style="width: 15px;text-align: center;">STT</th>
			<th style="text-align: center;">Mã cơ quan quản lý</th>
			<th style="text-align: center;">Tên cơ quan quản lý</th>
			<th style="text-align: center;">Cấp cơ quan quản lý</th>
			<th style="text-align: center;">Hành động</th>
		</tr>
	</thead>
	<tbody>
	<%
	for(CoQuanQuanLy coQuan : results){
		stt++;
		boolean testHasChild = false;
		boolean testHasCongChuc = false;
		CapCoQuanQuanLy capCoQuan = CapCoQuanQuanLyLocalServiceUtil.getCapCoQuanQuanLy(coQuan.getCapCoQuanQuanlyId());
		List<CoQuanQuanLy> listChildren = CoQuanQuanLyLocalServiceUtil.findByParentId(coQuan.getId(),0);
		List<CongChuc> listCongChuc = CongChucLocalServiceUtil.listCongChuc(coQuan.getId(),"",0,1);
		if(listChildren.size()>0){
			testHasChild = true;
		}
		if(listCongChuc.size()>0){
			testHasCongChuc = true;
		}
		//details CQQL URL
		PortletURL detailCQQLURL = renderResponse.createActionURL();
		detailCQQLURL.setParameter(ActionRequest.ACTION_NAME, "detailCoQuanQuanLy");
		detailCQQLURL.setParameter("coQuanQuanLyId",String.valueOf(coQuan.getId()));
		detailCQQLURL.setParameter("parentId",parentId);
		detailCQQLURL.setParameter("searchInputText",URLEncoder.encode(searchInputText,StringPool.UTF8));
		//edit CQQL URL
		PortletURL editCQQLURL = renderResponse.createActionURL();
		editCQQLURL.setParameter(ActionRequest.ACTION_NAME, "editCoQuanQuanLy");
		editCQQLURL.setParameter("coQuanQuanLyId",String.valueOf(coQuan.getId()));
		editCQQLURL.setParameter("parentId",parentId);
		editCQQLURL.setParameter("searchInputText",URLEncoder.encode(searchInputText,StringPool.UTF8));
		//delete CQQL URL
		PortletURL deleteCQQLURL = renderResponse.createActionURL();
		deleteCQQLURL.setParameter(ActionRequest.ACTION_NAME, "deleteCoQuanQuanLy");
		deleteCQQLURL.setParameter("coQuanQuanLyId",String.valueOf(coQuan.getId()));
		deleteCQQLURL.setParameter("parentId",parentId);
		deleteCQQLURL.setParameter("searchInputText",URLEncoder.encode(searchInputText,StringPool.UTF8));
		//search sub CQQL URL
		PortletURL searchSubCQQLURL = renderResponse.createActionURL();
		searchSubCQQLURL.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
		searchSubCQQLURL.setParameter("parentId",String.valueOf(coQuan.getId()));
		//list chuc vu CQQL URL
		PortletURL chucVuCQQLURL = renderResponse.createActionURL();
		chucVuCQQLURL.setParameter(ActionRequest.ACTION_NAME, "listChucVuCoQuanQuanLy");
		chucVuCQQLURL.setParameter("coQuanQuanLyId",String.valueOf(coQuan.getId()));
		chucVuCQQLURL.setParameter("parentId",parentId);
		chucVuCQQLURL.setParameter("searchInputText",URLEncoder.encode(searchInputText,StringPool.UTF8));
		//list cong chuc CQQL URL
		PortletURL congChucCQQLURL = renderResponse.createRenderURL();
		congChucCQQLURL.setParameter("tab","CC");
		congChucCQQLURL.setParameter("coQuanQuanLyId",String.valueOf(coQuan.getId()));
	%>
	<tr class="bgcolor-<%=rowStyle%>">
		<td style="text-align: center;"><%=searchContainer.getStart()+stt %></td>
		<td style="text-align: center;"><%=coQuan.getMa()%></td>
		<td><%=coQuan.getTen() %></td>
		<td><%=capCoQuan.getTen() %></td>
		<td style="text-align: center;">
			<a href="<%=detailCQQLURL.toString()%>"><button class="egov-func-detail" title="Chi tiết" ></button></a>
			<a href="<%=editCQQLURL.toString()%>"><button class="egov-func-edit" title="Chỉnh sửa" ></button></a>
			<%
			if(!(testHasChild||testHasCongChuc)){
			%>
			<a href="<%=deleteCQQLURL.toString()%>"  onclick = "return confirmDelete()"><button class="egov-func-delete" title="Xóa" ></button></a>
			<%} %>
			<a href="<%=searchSubCQQLURL.toString()%>"><button class="egov-func-find" title="Xem cấp con" ></button></a>
			
			<a href="<%=chucVuCQQLURL.toString()%>"><button class="egov-func-comment" title="Chức vụ" ></button></a>
			<a href="<%=congChucCQQLURL.toString()%>"><button class="egov-func-copy" title="Công chức" ></button></a>
		</td>
	</tr>
	<%
		rowStyle = rowStyle==1?2:1;
	}
	%>
	</tbody>
</table>
<div style="width: 100%;padding: 10px 10px">
	<liferay-ui:search-paginator searchContainer="<%=searchContainer%>"/>
</div>
<%
}else{
%>
<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
<%} %>
<script type = "text/javascript">
	function confirmDelete(){
		return confirm("Bạn thực sự muốn xóa cơ quan này?");
	}
</script>
