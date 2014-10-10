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
<%@page import="org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// Get search option
	String coQuanQuanLyId = ParamUtil.getString(request, "coQuanQuanLyId");
    String chucVuId = ParamUtil.getString(request, "chucVuId");
    String coQuanQuanLyIdList[] = coQuanQuanLyId.split("-");
    String chucVuIdList[] = chucVuId.split("-");
	
	// Get the search result from session if it exists
	List<ChucVu2VaiTro>  result = (List<ChucVu2VaiTro>)ChucVu2VaiTroLocalServiceUtil.findByIdChucVuAndIdCoQuanQuanLy(ConvertUtil.convertToLong(chucVuIdList[0]), ConvertUtil.convertToLong(coQuanQuanLyIdList[0]), 0);
	 
	if ( result == null ) {
		result = new ArrayList<ChucVu2VaiTro>();		
	}
	 
	%>
	<div class="wd-main-content">
	<br/>		
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
			<tr>
	    		<th width = "8%">TT</th>
			    <th  width = "20%">Mã</th>
			    <th>Tên vai trò</th>

		</tr>
		<%
			for (int i = 0; i< result.size(); i++) {
				VaiTro chucVu = VaiTroLocalServiceUtil.fetchVaiTro(result.get(i).getVaiTroId());
		
		%>
			<tr>
				<td align="center"><%= (i + 1) %></td>
				<td align = "left"><%=chucVu.getMa() %></td>
				<td align = "left"><%=chucVu.getTen() %></td>
			</tr>
		<%} %>
		</table>
</div>

