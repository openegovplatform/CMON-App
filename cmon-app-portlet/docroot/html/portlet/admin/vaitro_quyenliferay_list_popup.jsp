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
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// Get search option
	String vaitro_id = ParamUtil.getString(request, "vaitro_id");
    TaiNguyen taiNguyen = null;
    TaiNguyen2VaiTro taiNguyen2VaiTro = null;
	// Get the search result from session if it exists
	List<TaiNguyen2VaiTro> result = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(ConvertUtil.convertToLong(vaitro_id), 0);
	 
	if ( result == null ) {
		result = new ArrayList<TaiNguyen2VaiTro>();		
	}
	 
	%>
	<div class="wd-main-content">
	<br/>		
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
			<tr>
	    		<th width = "8%">TT</th>
			    <th  width = "50%">Tên</th>
			    <th  width = "20%">Giá trị</th>
			    <th  width = "22%">Hệ thống</th>

		</tr>
		<%
			for (int i = 0; i< result.size(); i++) {
				taiNguyen2VaiTro = result.get(i);
				taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
		
		%>
			<tr>
				<td style="text-align: center;"><%= (i + 1) %></td>
				<td align = "left"><%=taiNguyen.getTen() %></td>
				<td style="text-align: center;"><%=taiNguyen.getGiaTri() %></td>
				<td align = "left"><%=HeThongLocalServiceUtil.fetchHeThong(taiNguyen.getHeThongId()).getTen() %></td>
			</tr>
		<%} %>
		</table>
</div>

