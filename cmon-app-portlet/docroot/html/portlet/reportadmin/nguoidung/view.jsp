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
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
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

PortletURL searchNguoidung = renderResponse.createActionURL();
searchNguoidung.setParameter(ActionRequest.ACTION_NAME,"searchTaikhoannguoidung");

String keyword = request.getParameter("keyword")!=null?URLDecoder.decode(request.getParameter("keyword")):"";
String id_donvi = request.getParameter("id_donvi")!=null?request.getParameter("id_donvi"):"0";
String phanquyen = request.getParameter("phanquyen")!=null?request.getParameter("phanquyen"):"2";

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("paging","true");
iteratorUrl.setParameter("keyword",keyword);
iteratorUrl.setParameter("id_donvi",id_donvi);
iteratorUrl.setParameter("phanquyen",phanquyen);
iteratorUrl.setParameter("tab","nguoidung");

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");

List<CapCoQuanQuanLy> ccqQuanly = ActionAdminUtil.getAllCapcoquanquanly(0);
List<CoQuanQuanLy> cqQuanly = new ArrayList<CoQuanQuanLy>() ;
List<TaiKhoanNguoiDung> result = ActionAdminUtil.getAllTaiKhoanNguoiDung(0,keyword,Long.valueOf(id_donvi),phanquyen); 

if(Validator.isNotNull(request.getAttribute("listtknd"))){
	result = (List<TaiKhoanNguoiDung>) request.getAttribute("listtknd");
}
if ( result == null ) {
	 result = new ArrayList<TaiKhoanNguoiDung>();
}
List<TaiKhoanNguoiDung> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setTotal(result.size());
searchContainer.setResults(newResults);

%>

<div align="center">
<form action="<%=searchNguoidung%>" method="post" name="frmSearchTKND">
<table width="100%">
	<tr>
		<td colspan="4">
			<liferay-ui:success key="save-successfully" message="vn.dtt.cmon.reportadmin.savesuccess"/>
			<liferay-ui:error key="errorAddUserRole" message="vn.dtt.cmon.reportadmin.error"/>
		</td>
	</tr>
	<tr>
		<td style="width: 20%;">
			<input type="text" name="keyword" value="<%=keyword%>" placeholder="Tên/ email cán bộ" class="egov-inputfield">
		</td>
		<td style="width:40%">
			<select  name="id_donvi" class="egov-select" onchange="document.frmSearchTKND.submit()">
				<option value="0" <%=id_donvi.equals("0")?"selected":""%>>--Chọn cơ quan quản lý--</option>
				<%
					for(int j=0;j<ccqQuanly.size();j++){
						cqQuanly = CoQuanQuanLyLocalServiceUtil.findByCapCoQuanQuanLyId(ccqQuanly.get(j).getId(),0);
						if(cqQuanly.size()>0){
				%>
					<optgroup label="<%=ccqQuanly.get(j).getTen()%>">
						<%
						  for(CoQuanQuanLy cq : cqQuanly){
						%>	
							<option value="<%=cq.getId()%>" <%=cq.getId()==Long.valueOf(id_donvi)?"selected":""%>><%=cq.getTen()%></option>
						<%}%>
					</optgroup>
				<%}}%>
			</select>
		</td>
		<td>
			<select name="phanquyen" class="egov-select" onchange="document.frmSearchTKND.submit()">
				<option value="2" <%=phanquyen.equals("2")?"selected":""%>>--Chọn trạng thái--</option>
				<option value="1" <%=phanquyen.equals("1")?"selected":""%>>Đã phân quyền</option>
				<option value="0" <%=phanquyen.equals("0")?"selected":""%>>Chưa phân quyền</option>
			</select>
		</td>
		<td style="width: 10%;text-align: center">
			<input type="submit" value="Tìm" class="egov-button-search">
		</td>
	</tr>
</table>
</form>
<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
			<th style="text-align: center;width: 10px">STT</th>
		    <th style="text-align: center;">Tên người dùng</th>
		    <th style="text-align: center;">Tên đăng nhập</th>
		    <th style="text-align: center;">Trạng thái</th>
		</tr>
		<%
		int i=0;
		for(TaiKhoanNguoiDung nguoidung : newResults){
			i++;
			PortletURL permissionDMRole = renderResponse.createRenderURL();
			permissionDMRole.setParameter("jspPage","/html/portlet/reportadmin/nguoidung/userrole.jsp");
			permissionDMRole.setParameter("id",String.valueOf(nguoidung.getId()));
			permissionDMRole.setParameter("id_donvi",id_donvi);
			permissionDMRole.setParameter("phanquyen",phanquyen);
			permissionDMRole.setParameter("tab","nguoidung");
			permissionDMRole.setParameter("keyword",URLEncoder.encode(keyword,StringPool.UTF8));
		%>
		<tr>
			<td style="text-align: center"><%=(searchContainer.getStart()+i)%></td>
			<td><a href="<%=permissionDMRole%>"><%=nguoidung.getTenNguoiDung()%></a></td>
			<td><a href="<%=permissionDMRole%>"><%=nguoidung.getTenDangNhap()%></a></td>
			<td style="text-align: center;"><%=(ActionAdminUtil.checkRoleByIdUser(nguoidung.getId()))?"Đã phân quyền":""%></td>
		</tr>
		<%}%>
</table>
<div id = "pagination">
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
</div>
</div>