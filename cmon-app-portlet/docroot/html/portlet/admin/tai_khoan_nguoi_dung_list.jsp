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
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
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
		return confirm("Bạn thực sự muốn de-activate người dùng này?");
	}
</script>
<%
// Get all doi tuong
	List<DoiTuongSuDung> lstDoiTuongSuDung = DoiTuongSuDungLocalServiceUtil.getDoiTuongSuDungs(0, DoiTuongSuDungLocalServiceUtil.getDoiTuongSuDungsCount());
%>
<%!	

	private String getTenDoiTuong(long id, List<DoiTuongSuDung> lstDoiTuongSuDung ) {
		for(DoiTuongSuDung obj : lstDoiTuongSuDung) {
			if ( obj.getId() == id) {
				return obj.getTen();
			}
		}
		
		return "";
	}
%>

<%
	// Remove the insert object if exists
	renderRequest.getPortletSession().removeAttribute("USER_REQUEST_TKND_OBJECT");

	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchTaiKhoanNguoiDung");
	
	// Get search keyword
	String keyWord = ParamUtil.getString(request, "keyWord");
	
	// Get search option
	String searchOption = ParamUtil.getString(request, "searchOption");	

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_list.jsp");
	iteratorUrl.setParameter("searchOption", searchOption);
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Incase this is the first time the page is load
	if (Validator.isNull(searchOption)) {
		// Remove the search result if it exists in session
	 	renderRequest.getPortletSession().removeAttribute("SEARCH_TAI_KHOAN_NGUOI_DUNG_RESULT");
	}
	 
	// Get the search result from session if it exists
	List<TaiKhoanNguoiDung>  result = (List<TaiKhoanNguoiDung>)renderRequest.getPortletSession().getAttribute("SEARCH_TAI_KHOAN_NGUOI_DUNG_RESULT");
	 
	if ( result == null ) {
		result = new ArrayList<TaiKhoanNguoiDung>();		
	}
	 
	// Paging
	List<TaiKhoanNguoiDung> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	 
	%>
	<div class="egov-container">
	<br/>		
	<form name = "searchForm" method = "post" action = "<%=searchUrl%>">
		<table class = "egov-table-form2" width="100%" border="0">
		  <tr>
		    <td align = "left">
		    	Tìm theo:		    
		    	<select name="searchOption" class="egov-select custom">
		    		<% if ( Validator.isNull(searchOption)) { %>				    		
			    		<option value = "0" selected>Tên đăng nhập</option>
			    		<option value = "1" >Tên người dùng</option>
			    		<option value = "2" >Email</option>			    		
			    	<%} else {%>
			    		<%												
							String selected0 = "";
							if ("0".equals(searchOption )) {
								selected0 = "selected";
							}												
							
							String selected1 = "";
							if ("1".equals(searchOption )) {
								selected1 = "selected";
							}	
							
							String selected2 = "";
							if ("2".equals(searchOption )) {
								selected2 = "selected";
							}
						%>
				        <option value = "0" <%=selected0%>>Tên đăng nhập</option>
			    		<option value = "1" <%=selected1%>>Tên người dùng</option>	
			    		<option value = "2" <%=selected2%>>Email</option>		    		
			    	<%} %>		    		
		    	</select>
		    	<input name="keyWord" type="text" size = "30" maxlength="150" class = "egov-inputfield custom" value = "<%=keyWord%>"/>
		    	<input type="submit" value=""  class="egov-button-search" />	    			    			    	
		    </td>
		    <td align = "right">
				<%
					PortletURL createNewUrl = renderResponse.createRenderURL();
					
					createNewUrl.setParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_add_edit.jsp");
					createNewUrl.setParameter("mode", "0"); // Insert mode
				 %>
		    	<a href = "<%=createNewUrl%>"><input type="button" value="+ THÊM MỚI"  class="egov-button-normal" /></a>			    
		    </td>
		  </tr>
		</table>
	</form>	
	<table class="egov-table" width = "100%">
		<tr>
		    <th  width = "12%">Tên đăng nhập</th>
		    <th>Tên người dùng</th>
		    <th width = "20%">Email</th>
		    <th width = "15%">Loại đối tượng</th>
		    <th width = "15%">Trạng thái</th>
		    <th width = "12%">Hành động</th>
		</tr>
		<%
			for (int i = 0; i< newResults.size(); i++) {
				TaiKhoanNguoiDung taiKhoanNguoiDung = newResults.get(i);
				
				// Edit Url
				PortletURL editUrl = renderResponse.createActionURL();
				editUrl.setParameter(ActionRequest.ACTION_NAME, "viewTaiKhoanNguoiDung");
				editUrl.setParameter("id", String.valueOf(taiKhoanNguoiDung.getId()));
				
				// Delete URL
				PortletURL deleteUrl = renderResponse.createActionURL();
				deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteTaiKhoanNguoiDung");
				deleteUrl.setParameter("id", String.valueOf(taiKhoanNguoiDung.getId()));
		%>
			<tr>
				<td align = "left"><%=taiKhoanNguoiDung.getTenDangNhap() %></td>
				<td align = "left"><a href = "<%=editUrl%>"><%=taiKhoanNguoiDung.getTenNguoiDung() %></a></td>
				<td align = "left"><%=taiKhoanNguoiDung.getEmail() %></td>
				<td align = "left"><%=getTenDoiTuong(taiKhoanNguoiDung.getLoaiDoiTuongId(), lstDoiTuongSuDung) %></td>
				<%
					String strTrangThai = null;
					int trangThai = taiKhoanNguoiDung.getTrangThai();
					if ( trangThai == 0) {
						strTrangThai = "Không hoạt động";
					} else {
						strTrangThai = "Đang hoạt động";	
					}
				%>
				<td align = "left"><%=strTrangThai %></td>
				<td align = "center">
					<table class="egov-table-function" >
						<tr>
							<td>
								<a href = "<%=editUrl%>"><input type="button" class="egov-func-edit" title="Chỉnh sửa"/></a>
							</td>
							<td>
							<%
							 	if ( trangThai == 1) {
							 %>
								<a href = "<%=deleteUrl%>" onclick = "return confirmDelete()"><input type = "button" class="egov-func-inactive" title="De-actiavte"/></a>
							 <%
							 	} else {
							 %>	
							 ...
							 <%} %>	
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
</div>

