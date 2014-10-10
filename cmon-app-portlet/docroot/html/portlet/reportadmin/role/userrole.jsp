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
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucRole"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/init.jsp"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />    
<%
String roleId = request.getParameter("id")!=null?request.getParameter("id"):"";
List<TaiKhoanNguoiDung> listtknd = new ArrayList<TaiKhoanNguoiDung>();
List<Long> id_tknd = new ArrayList<Long>();
if(roleId.trim().length()>0){
	id_tknd = ActionAdminUtil.getTkNguoiDungByRoleId(Long.valueOf(roleId));
	if(id_tknd.size()>0){
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiKhoanNguoiDung.class);
		query.add(PropertyFactoryUtil.forName("id").in(id_tknd.toArray()));
		listtknd = TaiKhoanNguoiDungLocalServiceUtil.dynamicQuery(query);
	}
}
PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("roleId",roleId);
iteratorUrl.setParameter("tab","vaitro");

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");

List<TaiKhoanNguoiDung> newResults = ListUtil.subList(listtknd, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setTotal(listtknd.size());
searchContainer.setResults(newResults);


PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("tab","vaitro");
PortletURL removeUserInRole = renderResponse.createActionURL();
removeUserInRole.setParameter(ActionRequest.ACTION_NAME,"removeUserInRole");
%>
<form action="<%=removeUserInRole%>" method="post">
<table class="egov-table">
	<tr>
		<th width="10px">TT</th>
		<th width="10px" style="text-align: center;"><input type="checkbox" name="check-all" onclick="SelectAll(this,'tkNguoidungId')"></th>
		<th>Tên người dùng</th>
	</tr>
	<%
		for(int i=0;i<listtknd.size();i++){
	%>
	<tr>
		<td style="text-align: center;"><%=(i+1)%></td>
		<td style="text-align: center;"><input type="checkbox"  name="tkNguoidungId[]" value="<%=listtknd.get(i).getId()%>"></td>
		<td><%=listtknd.get(i).getTenNguoiDung()%></td>
	</tr>
	<%	} %>
	<tr>
		<td colspan="3" style="text-align: center;">
			<input type="submit" class="egov-button" value="Lưu">
			<input type="button" class="egov-button" value="Quay lại" onclick="window.location='<%=backURL%>'">
			<input type="hidden" name="roleId" value="<%=roleId%>">
		</td>
	</tr>
</table>
<div id = "pagination">
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
</div>
</form>