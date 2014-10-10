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
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="org.oep.cmon.dao.report.service.DanhMucBaoCaoLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucBaoCao"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/init.jsp"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />    
<%

PortletURL addDMBaoCao = renderResponse.createRenderURL();
addDMBaoCao.setParameter("jspPage","/html/portlet/reportadmin/danhmucbaocao/add.jsp");

PortletURL searchDMBaoCao = renderResponse.createActionURL();
searchDMBaoCao.setParameter(ActionRequest.ACTION_NAME,"searchDanhmucbaocao");

PortletURL iteratorUrl = renderResponse.createRenderURL();
if (request.getParameter("keyword") != null) {
	 iteratorUrl.setParameter("keyword", request.getParameter("keyword"));
}
SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");

List<DanhMucBaoCao> result = ActionAdminUtil.getAllDMBaocao(2);

if(Validator.isNotNull(request.getAttribute("listdmbaocao"))){
	result = (List<DanhMucBaoCao>) request.getAttribute("listdmbaocao");
}

if ( result == null ) {
	 result = new ArrayList<DanhMucBaoCao>();
}
List<DanhMucBaoCao> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setTotal(result.size());
searchContainer.setResults(newResults);

String keyword = request.getParameter("keyword")!=null?request.getParameter("keyword"):"";
%>

<div align="center">
<form action="<%=searchDMBaoCao%>" method="post">
<table width="100%">
	<tr>
		<td colspan="3">
			<liferay-ui:success key="save-successfully" message="vn.dtt.cmon.reportadmin.savesuccess"/>
			<liferay-ui:success key="delete-successfully" message="vn.dtt.cmon.reportadmin.deletesuccess"/>
			<liferay-ui:error key="delete-failed" message="vn.dtt.cmon.reportadmin.deletefailed"/>
		</td>
	</tr>
	<tr>
		<td style="width: 40%;">
			<input type="text" style="width:95%" name="keyword" value="<%=keyword%>" class="egov-inputfield">
		</td>
		<td style="width: 10%;text-align: center">
			<input type="submit" value="Tìm" class="egov-button-search">
		</td>
		<td style="width: 50%;text-align: right">
			<input type="button" name="button" value="+ THÊM MỚI"  class="egov-button-normal" onclick="javascript: window.location = '<%=addDMBaoCao.toString() %>'"/>
		</td>
	</tr>
</table>
</form>
<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
			<th style="text-align: center;width: 10px">STT</th>
		    <th style="text-align: center;">Tên báo cáo</th>
		    <th style="text-align: center;">Đường dẫn</th>
		    <th style="text-align: center;">Sắp xếp</th>
		    <th style="text-align: center;">Trạng thái</th>
		    <th style="text-align: center;">Public</th>
		    <th style="text-align: center;">Hành động</th>
		</tr>
		<%
		int i=0;
		for(DanhMucBaoCao dmbc : newResults){
			i++;
			PortletURL editDMbaocao = renderResponse.createRenderURL();
			editDMbaocao.setParameter("jspPage","/html/portlet/reportadmin/danhmucbaocao/add.jsp");
			editDMbaocao.setParameter("id",String.valueOf(dmbc.getID()));
			
			PortletURL deleteDMbaocao = renderResponse.createActionURL();
			deleteDMbaocao.setParameter(ActionRequest.ACTION_NAME,"deleteDanhmucbaocao");
			deleteDMbaocao.setParameter("id",String.valueOf(dmbc.getID()));
		%>
		<tr>
			<td style="text-align: center"><%=(searchContainer.getStart()+i)%></td>
			<td><a href="<%=editDMbaocao%>"><%=dmbc.getTENBAOCAO()%></a></td>
			<td><%=dmbc.getDUONGDAN()%></td>
			<td style="text-align: center"><%=dmbc.getORDERS()%></td>
			<td style="text-align: center;"><%=dmbc.getSTATUS()==1?"Sử dụng":"Không sử dụng"%></td>
			<td style="text-align: center;"><%=dmbc.getPUBLISH()==1?"Public":"No Public"%></td>
			<td style="text-align: center;">
			<a href="javascript:window.location ='<%=editDMbaocao.toString()%>'">Sửa</a> 
			<%if(!ActionAdminUtil.checkBaocaoInRole2Baocao(dmbc.getID())){ %>
			|<a href="javascript:if(confirm('Chắc chắn xóa !')){window.location='<%=deleteDMbaocao.toString()%>';}">Xóa</a>
			<%}%>
			</td>
		</tr>
		<%}%>
</table>
<div id = "pagination">
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
</div>
</div>