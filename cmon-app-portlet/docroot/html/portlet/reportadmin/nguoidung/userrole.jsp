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
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
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
String tkNguoidungId = request.getParameter("id")!=null?request.getParameter("id"):"";
String id_donvi = request.getParameter("id_donvi")!=null?request.getParameter("id_donvi"):"0";
String phanquyen = request.getParameter("phanquyen")!=null?request.getParameter("phanquyen"):"0";
String keyword = request.getParameter("keyword")!=null?URLDecoder.decode(request.getParameter("keyword")):"";
List<DanhMucRole> listrole = ActionAdminUtil.getAllDMRole(1);
List<Long> id_role = new ArrayList<Long>();
if(tkNguoidungId.trim().length()>0){
	id_role = ActionAdminUtil.getRoleByTkNguoiDungId(Long.valueOf(tkNguoidungId));
}

PortletURL backURL = renderResponse.createRenderURL();
//backURL.setParameter("jspPage","/html/portlet/reportadmin/nguoidung/view.jsp");
backURL.setParameter("id_donvi",id_donvi);
backURL.setParameter("phanquyen",phanquyen);
backURL.setParameter("tab","nguoidung");
backURL.setParameter("keyword",URLEncoder.encode(keyword,StringPool.UTF8));

PortletURL saveUserRole = renderResponse.createActionURL();
saveUserRole.setParameter(ActionRequest.ACTION_NAME,"saveUserRole");
%>
<form action="<%=saveUserRole%>" method="post">
<table class="egov-table">
	<tr>
		<th width="10px">TT</th>
		<th width="10px">#</th>
		<th>Role</th>
	</tr>
	<%
		for(int i=0;i<listrole.size();i++){
			String chk_role = "";
			if(id_role.size()>0){
				chk_role = id_role.contains(listrole.get(i).getID())?"checked":"";
			}
	%>
	<tr>
		<td style="text-align: center;"><%=(i+1)%></td>
		<td style="text-align: center;"><input type="checkbox" class="egov-checkbox" name="role_id" <%=chk_role%> value="<%=listrole.get(i).getID()%>"></td>
		<td><%=listrole.get(i).getNAME()%></td>
	</tr>
	<%	} %>
	<tr>
		<td colspan="3" style="text-align: center;">
			<input type="submit" class="egov-button" value="Lưu">
			<input type="button" class="egov-button" value="Quay lại" onclick="window.location='<%=backURL%>'">
			<input type="hidden" name="tkNguoidungId" value="<%=tkNguoidungId%>">
			<input type="hidden" name="id_donvi" value="<%=id_donvi%>">
			<input type="hidden" name="keyword" value="<%=keyword%>">
			<input type="hidden" name="phanquyen" value="<%=phanquyen%>">
		</td>
	</tr>
</table>
</form>