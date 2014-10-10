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
<%@page import="org.oep.exch.dao.hoso.service.KetQuaHosoLocalServiceUtil"%>
<%@page import="org.oep.exch.dao.hoso.model.KetQuaHoso"%>
<%@page import="org.oep.exch.dao.hoso.service.TrangThaiHosoLocalServiceUtil"%>
<%@page import="org.oep.exch.dao.hoso.model.TrangThaiHoso"%>
<%@page import="org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil"%>
<%@page import="org.oep.exch.dao.hoso.model.HoSoMotCua"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
	function confirmDelete(){
		return confirm("Bạn thực sự muốn xóa record này?");
	}
</script>
<div class = "egov-container">
<%
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
	
	int refresh = ParamUtil.getInteger(request, "refresh");
	
	if ( refresh == 1) {
		// remove the old cached result
		renderRequest.getPortletSession().removeAttribute("SEARCH_HOSOMOTCUA_RESULT");
	}
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Get the search result from session if it exists
	List<HoSoMotCua>  result = (List<HoSoMotCua>)renderRequest.getPortletSession().getAttribute("SEARCH_HOSOMOTCUA_RESULT");
	 
	if ( result == null ) {		
		result = HoSoMotCuaLocalServiceUtil.findByTrangThaiXuLy(2); // 2: Error
		
		// set to session
		renderRequest.getPortletSession().setAttribute("SEARCH_HOSOMOTCUA_RESULT", result);		
	}
	 
	// Paging
	List<HoSoMotCua> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	
	PortletURL refreshUrl = renderResponse.createRenderURL();
	refreshUrl.setParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
	refreshUrl.setParameter("refresh", "1");
	
	%>
	<a href = "<%=refreshUrl %>">>>Load lại dữ liệu của màn hình</a>
	<br/>
	<br/>
	
	<label class = "egov-label"><b>1. Hồ sơ một cửa</b></label>
	<table class="egov-table" width = "100%">
		<tr>
		    <th width = "11%">Mã DVC</th>		    
		    <th scope="col" width = "13%">Mã số hồ sơ</th>
		    <th scope="col" width = "10%">Ngày chuyển</th>		    
		    <th scope="col" width = "10%">Đơn vị</th>
		    <th scope="col" width = "10%">Ngày xử lý</th>	
		    <th scope="col">Message</th>
		    <th scope="col" width = "11%">Hành động</th>
		</tr>
		<%
			DateFormat dfFormat = new SimpleDateFormat("dd/MM/yyyy");
		
			for (int i = 0; i< newResults.size(); i++) {
				HoSoMotCua hoSo = newResults.get(i);			
		%>
			<tr>
				<%
					PortletURL editHoSoMotCuaUrl = renderResponse.createRenderURL();
					editHoSoMotCuaUrl.setParameter("jspPage", "/html/portlet/admin/edit_hosomotcua.jsp");
					editHoSoMotCuaUrl.setParameter("id", hoSo.getId() + "");
					
					PortletURL deleteHoSoMotCuaUrl = renderResponse.createActionURL();
					deleteHoSoMotCuaUrl.setParameter(ActionRequest.ACTION_NAME, "deleteHoSoMotCua");
					deleteHoSoMotCuaUrl.setParameter("id", hoSo.getId() + "");
					
				%>
				<td align = "left"><%=hoSo.getMaLoaiHoSo() %></td>
				<td align = "left"><a href = "<%=editHoSoMotCuaUrl%>"><%=hoSo.getMaSoHoSo()%></a></td>
				<td align = "left"><%=dfFormat.format(hoSo.getNgayChuyen())%></td>
				<td align = "left"><%=hoSo.getDonViCungCap()%></td>
				<td align = "left"><%=dfFormat.format(hoSo.getNgayXuLy())%></td>
				<td align = "left"><%=hoSo.getLoiKhiXuLy()%></td>
				<td align = "center">
					<table class="egov-table-function" >
						<tr>
							<td>
								<a href = "<%=editHoSoMotCuaUrl%>"><input type="button" class="egov-func-edit" title="Chỉnh sửa"/></a>
							</td>
							<td>		
								<a href = "<%=deleteHoSoMotCuaUrl%>" onclick = "return confirmDelete()"><input type = "button" class="egov-func-delete" title="Xóa"/></a>

							</td>
						</tr>
					</table>				
				</td>		
			</tr>
		<%} %>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
	
<%	
	if ( refresh == 1) {
		// remove the old cached result
		renderRequest.getPortletSession().removeAttribute("SEARCH_TRANGTHAIHOSO_RESULT");
	}
	 
	SearchContainer searchTrangThaiHoSoContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Get the search result from session if it exists
	List<TrangThaiHoso>  resultTrangThaiHoSo = (List<TrangThaiHoso>)renderRequest.getPortletSession().getAttribute("SEARCH_TRANGTHAIHOSO_RESULT");
	 
	if ( resultTrangThaiHoSo == null ) {		
		resultTrangThaiHoSo = TrangThaiHosoLocalServiceUtil.findByTrangThaiXuLy(2); // 2: Error
		
		// set to session
		renderRequest.getPortletSession().setAttribute("SEARCH_TRANGTHAIHOSO_RESULT", resultTrangThaiHoSo);		
	}
	 
	// Paging
	List<TrangThaiHoso> newResultTrangThaiHoSo = ListUtil.subList(resultTrangThaiHoSo, searchTrangThaiHoSoContainer.getStart(), searchTrangThaiHoSoContainer.getEnd());
	 
	searchTrangThaiHoSoContainer.setTotal(resultTrangThaiHoSo.size());
	 
	searchTrangThaiHoSoContainer.setResults(newResultTrangThaiHoSo);
	
	%>
	<br/>
	<label class = "egov-label"><b>2. Trạng thái hồ sơ</b></label>
	<table class="egov-table" width = "100%">
		<tr>
		    <th width = "11%">Online Id</th>		    
		    <th scope="col" width = "13%">Mã số hồ sơ</th>
		    <th scope="col" width = "10%">Ngày chuyển</th>		    
		    <th scope="col" width = "10%">Đơn vị</th>
		    <th scope="col" width = "10%">Ngày xử lý</th>	
		    <th scope="col">Message</th>
		    <th scope="col" width = "11%">Hành động</th>
		</tr>
		<%
	
			for (int i = 0; i< newResultTrangThaiHoSo.size(); i++) {
				TrangThaiHoso trangThai = newResultTrangThaiHoSo.get(i);			
		%>
			<tr>
				<%
					PortletURL editTrangThaiHoSoUrl = renderResponse.createRenderURL();
					editTrangThaiHoSoUrl.setParameter("jspPage", "/html/portlet/admin/edit_trangthaihoso.jsp");
					editTrangThaiHoSoUrl.setParameter("id", trangThai.getId() + "");
					
					PortletURL deleteTrangThaiHoSoUrl = renderResponse.createActionURL();
					deleteTrangThaiHoSoUrl.setParameter(ActionRequest.ACTION_NAME, "deleteTrangThaiHoSo");
					deleteTrangThaiHoSoUrl.setParameter("id", trangThai.getId() + "");
					
				%>
				<td align = "left"><%=trangThai.getOnlineId() %></td>
				<td align = "left"><a href = "<%=editTrangThaiHoSoUrl%>"><%=trangThai.getMaSoHoSo()%></a></td>
				<td align = "left"><%=dfFormat.format(trangThai.getNgayChuyen())%></td>
				<td align = "left"><%=trangThai.getDonViCungCap()%></td>
				<td align = "left"><%=dfFormat.format(trangThai.getNgayXuLy())%></td>
				<td align = "left"><%=trangThai.getLoiKhiXuLy()%></td>
				<td align = "center">
					<table class="egov-table-function" >
						<tr>
							<td>
								<a href = "<%=editTrangThaiHoSoUrl%>"><input type="button" class="egov-func-edit" title="Chỉnh sửa"/></a>
							</td>
							<td>		
								<a href = "<%=deleteTrangThaiHoSoUrl%>" onclick = "return confirmDelete()"><input type = "button" class="egov-func-delete" title="Xóa"/></a>

							</td>
						</tr>
					</table>				
				</td>		
			</tr>
		<%} %>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchTrangThaiHoSoContainer %>" />
	</div>

<%	
	if ( refresh == 1) {
		// remove the old cached result
		renderRequest.getPortletSession().removeAttribute("SEARCH_KETQUAHOSO_RESULT");
	}
	 
	SearchContainer searchKetQuaHoSoContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Get the search result from session if it exists
	List<KetQuaHoso>  resultKetQuaHoSo = (List<KetQuaHoso>)renderRequest.getPortletSession().getAttribute("SEARCH_KETQUAHOSO_RESULT");
	 
	if ( resultKetQuaHoSo == null ) {		
		resultKetQuaHoSo = KetQuaHosoLocalServiceUtil.findByTrangThaiXuLy(2); // 2: Error
		
		// set to session
		renderRequest.getPortletSession().setAttribute("SEARCH_KETQUAHOSO_RESULT", resultKetQuaHoSo);		
	}
	 
	// Paging
	List<KetQuaHoso> newResultKetQuaHoSo = ListUtil.subList(resultKetQuaHoSo, searchKetQuaHoSoContainer.getStart(), searchKetQuaHoSoContainer.getEnd());
	 
	searchKetQuaHoSoContainer.setTotal(resultKetQuaHoSo.size());
	 
	searchKetQuaHoSoContainer.setResults(newResultKetQuaHoSo);
	
	%>
	<br/>
	<label class = "egov-label"><b>3. Kết quả hồ sơ</b></label>
	<table class="egov-table" width = "100%">
		<tr>   
		    <th scope="col" width = "13%">Mã số hồ sơ</th>
		    <th scope="col" width = "10%">Ngày chuyển</th>		    
		    <th scope="col" width = "10%">Đơn vị</th>
		    <th scope="col" width = "10%">Ngày xử lý</th>	
		    <th scope="col">Message</th>
		    <th scope="col" width = "11%">Hành động</th>
		</tr>
		<%
	
			for (int i = 0; i< newResultKetQuaHoSo.size(); i++) {
				KetQuaHoso ketQuaHoSo = newResultKetQuaHoSo.get(i);			
		%>
			<tr>
				<%
					PortletURL editKetQuaHoSoUrl = renderResponse.createRenderURL();
					editKetQuaHoSoUrl.setParameter("jspPage", "/html/portlet/admin/edit_ketquahoso.jsp");
					editKetQuaHoSoUrl.setParameter("id", ketQuaHoSo.getId() + "");
					
					PortletURL deleteKetQuaHoSoUrl = renderResponse.createActionURL();
					deleteKetQuaHoSoUrl.setParameter(ActionRequest.ACTION_NAME, "deleteKetQuaHoSo");
					deleteKetQuaHoSoUrl.setParameter("id", ketQuaHoSo.getId() + "");
					
				%>
				<td align = "left"><a href = "<%=editKetQuaHoSoUrl%>"><%=ketQuaHoSo.getMaSoHoSo()%></a></td>
				<td align = "left"><%=dfFormat.format(ketQuaHoSo.getNgayChuyen())%></td>
				<td align = "left"><%=ketQuaHoSo.getDonViCungCap()%></td>
				<td align = "left"><%=dfFormat.format(ketQuaHoSo.getNgayXuLy())%></td>
				<td align = "left"><%=ketQuaHoSo.getLoiKhiXuLy()%></td>
				<td align = "center">
					<table class="egov-table-function" >
						<tr>
							<td>
								<a href = "<%=editKetQuaHoSoUrl%>"><input type="button" class="egov-func-edit" title="Chỉnh sửa"/></a>
							</td>
							<td>		
								<a href = "<%=deleteKetQuaHoSoUrl%>" onclick = "return confirmDelete()"><input type = "button" class="egov-func-delete" title="Xóa"/></a>

							</td>
						</tr>
					</table>				
				</td>		
			</tr>
		<%} %>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchKetQuaHoSoContainer %>" />
	</div>
</div>

