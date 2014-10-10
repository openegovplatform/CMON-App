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
<%@page import="org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucRole"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
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

PortletURL addDMRole = renderResponse.createRenderURL();
addDMRole.setParameter("jspPage","/html/portlet/reportadmin/role/add.jsp");

PortletURL searchDMRole = renderResponse.createActionURL();
searchDMRole.setParameter(ActionRequest.ACTION_NAME,"searchDanhmucrole");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("tab", "vaitro");
if (request.getParameter("keyword") != null) {
	 iteratorUrl.setParameter("keyword", request.getParameter("keyword"));
}
SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");

List<DanhMucRole> result = ActionAdminUtil.getAllDMRole(2); 

if(Validator.isNotNull(request.getAttribute("listdmrole"))){
	result = (List<DanhMucRole>) request.getAttribute("listdmrole");
}

if ( result == null ) {
	 result = new ArrayList<DanhMucRole>();
}
List<DanhMucRole> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setTotal(result.size());
searchContainer.setResults(newResults);

String keyword = request.getParameter("keyword")!=null?request.getParameter("keyword"):"";
%>

<div align="center">
<form action="<%=searchDMRole%>" method="post">
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
			<input type="button" name="button" value="+ THÊM MỚI"  class="egov-button-normal" onclick="javascript: window.location = '<%=addDMRole.toString() %>'"/>
		</td>
	</tr>
</table>
</form>
<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
			<th style="text-align: center;width: 10px">STT</th>
		    <th style="text-align: center;">Tên vai trò</th>
		   <!--  <th style="text-align: center;">Sắp xếp</th> -->
		    <th style="text-align: center;">Trạng thái</th>
		    <th style="text-align: center;">Hành động</th>
		</tr>
		<%
		int i=0;
		for(DanhMucRole dmrole : newResults){
			i++;
			PortletURL editDMRole = renderResponse.createRenderURL();
			editDMRole.setParameter("jspPage","/html/portlet/reportadmin/role/add.jsp");
			editDMRole.setParameter("id",String.valueOf(dmrole.getID()));
			
			PortletURL deleteDMRole = renderResponse.createActionURL();
			deleteDMRole.setParameter(ActionRequest.ACTION_NAME,"deleteDanhmucrole");
			deleteDMRole.setParameter("id",String.valueOf(dmrole.getID()));
			
			PortletURL permissionDMRole = renderResponse.createRenderURL();
			permissionDMRole.setParameter("jspPage","/html/portlet/reportadmin/role/role.jsp");
			permissionDMRole.setParameter("id",String.valueOf(dmrole.getID()));
			
			PortletURL userRole = renderResponse.createRenderURL();
			userRole.setParameter("jspPage","/html/portlet/reportadmin/role/userrole.jsp");
			userRole.setParameter("id",String.valueOf(dmrole.getID()));
		%>
		<tr>
			<td style="text-align: center"><%=(searchContainer.getStart()+i)%></td>
			<td><a href="<%=permissionDMRole%>" title="Click để phân quyền"><%=dmrole.getNAME()%></a></td>
			<%-- <td style="text-align: center"><%=dmrole.getORDERS()%></td> --%>
			<td style="text-align: center;" ><%=dmrole.getSTATUS()==1?"Sử dụng":"Không sử dụng"%></td>
			<td style="text-align: center;">
			<a href="javascript:window.location ='<%=editDMRole.toString()%>'">Sửa</a>
			<%if(!ActionAdminUtil.checkRoleInCongchucRole(dmrole.getID())){%> 
			|<a href="javascript:if(confirm('Chắc chắn xóa !')){window.location='<%=deleteDMRole.toString()%>';}">Xóa</a> 
			<%}%>
			|<a href="<%=permissionDMRole.toString()%>">Phân quyền</a>
			<%if(ActionAdminUtil.checkRoleInCongchucRole(dmrole.getID())){%>
			|<a href="<%=userRole.toString()%>">Xóa người dùng</a>
			<%} %>
			</td>
		</tr>
		<%}%>
</table>
<div id = "pagination">
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
</div>
</div>