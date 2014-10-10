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
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
	function confirmDelete(){
		return confirm("Bạn thực sự muốn xóa record này?");
	}
</script>
<%
	// Remove the object if it exists
	renderRequest.getPortletSession().removeAttribute("USER_REQUEST_CQQL_OBJECT");

	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
	
	// Get search keyword
	String keyWord = ParamUtil.getString(request, "keyWord");
	
	// Get search option
	String searchOption = ParamUtil.getString(request, "searchOption");
	
	// Get parent Id
	String strParentId = ParamUtil.getString(request, "parentId");
	long parentId = 0;
	 
	if ( Validator.isNotNull(strParentId)) {
		parentId = Long.parseLong( strParentId);
	}
	  
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_list.jsp");
	iteratorUrl.setParameter("searchOption", searchOption);
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Incase this is the first time the page is load
	if (Validator.isNull(searchOption)) {
		// Remove the search result if it exists in session
	 	renderRequest.getPortletSession().removeAttribute("SEARCH_CO_QUAN_QUAN_LY_RESULT");
	}
	 
	// Get the search result from session if it exists
	List<CoQuanQuanLy>  result = (List<CoQuanQuanLy>)renderRequest.getPortletSession().getAttribute("SEARCH_CO_QUAN_QUAN_LY_RESULT");

	if ( result == null ) {
		result = new ArrayList<CoQuanQuanLy>();		
	}
	 
	// Paging
	List<CoQuanQuanLy> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	 
	%>
	<div class="egov-container">
	<br/>
	<%
		PortletURL searchHighestLevelUrl = renderResponse.createActionURL();
		searchHighestLevelUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
		
		if ( parentId > 0 ) {
	%>
			>> <a href = "<%=searchHighestLevelUrl%>">Cấp cao nhất</a>
	<%			
			List <CoQuanQuanLy> lst = new ArrayList<CoQuanQuanLy>();			
			CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(parentId);
			
			lst.add(coQuanQuanLy);
			
			while ( coQuanQuanLy != null ) {
				try {
					coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanQuanLy.getChaId());
					if ( coQuanQuanLy != null ) {
						lst.add(coQuanQuanLy);
					}
				} catch (Exception es) {
					coQuanQuanLy = null;
				}
			}
			
			int cnt = lst.size();
			
			for (int i = cnt - 1; i > 0; i --) {
				// Direct search URL
				PortletURL directSearchUrl = renderResponse.createActionURL();
				directSearchUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
				directSearchUrl.setParameter("parentId", lst.get(i).getId() + "");
			%>
	
				>> <a href = "<%=directSearchUrl%>"><%=lst.get(i).getTen() %></a>
			
		<%	} //for %>
			>> <%=lst.get(0).getTen() %>
			
	<%	} %>
	<form name = "searchForm" method = "post" action = "<%=searchUrl%>">
		<table width="100%" border="0">
		  <tr>
		    <td align = "left">
		    	Tìm theo:		    
		    	<select name="searchOption" class="egov-select custom">
		    		<% if ( Validator.isNull(searchOption)) { %>				    		
			    		<option value = "0">Mã cơ quan quản lý</option>
			    		<option value = "1" selected>Tên cơ quan quản lý</option>
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
						%>
				        <option value = "0" <%=selected0%>>Mã cơ quan quản lý</option>
			    		<option value = "1" <%=selected1%>>Tên cơ quan quản lý</option>			    		
			    	<%} %>		    		
		    	</select>
		    	<input name="keyWord" type="text" size = "30" maxlength="150" class = "egov-inputfield custom" value = "<%=keyWord%>"/>
		    	<input type="submit" value=""  class="egov-button-search" />
		    	<input type = "hidden" name = "parentId" value = "<%=parentId%>" />		    			    			    	
		    </td>
		    <td align = "right">
				<%
					PortletURL createNewUrl = renderResponse.createRenderURL();
					
					createNewUrl.setParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_add_edit.jsp");
					createNewUrl.setParameter("mode", "0"); // Insert mode
				 %>
		    	<a href = "<%=createNewUrl%>"><input type="button" value="+ THÊM MỚI"  class="egov-button-normal" /></a>			    
		    </td>
		  </tr>
		</table>
	</form>	
	<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th align = "center" width = "5%">Mã</th>
		    <th scope="col" >Tên cơ quan quản lý</th>
		    <th scope="col" width = "10%">Điện thoại</th>
		    <th scope="col" width = "15%">Email</th>
		    <th scope="col" width = "10%">Cấp</th>
		    <th scope="col" width = "15%">Hành động</th>
		</tr>
		<%
		//
			for (int i = 0; i< newResults.size(); i++) {
				CoQuanQuanLy coQuanQuanLy = newResults.get(i);
				
				PortletURL searchSubUnitUrl = renderResponse.createActionURL();
				searchSubUnitUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
				searchSubUnitUrl.setParameter("parentId", String.valueOf(coQuanQuanLy.getId()));
							
				// Edit Url
				PortletURL editUrl = renderResponse.createActionURL();
				
				//editUrl.setParameter(ActionRequest.ACTION_NAME, "viewCoQuanQuanLy");
				editUrl.setParameter(ActionRequest.ACTION_NAME, "viewCoQuanQuanLy");
				//editUrl.setParameter("jspPage", "/html/portlet/admin/aa.jsp");
				editUrl.setParameter("id", String.valueOf(coQuanQuanLy.getId()));
				
				// Delete URL
				PortletURL deleteUrl = renderResponse.createActionURL();
				deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteCoQuanQuanLy");
				deleteUrl.setParameter("id", String.valueOf(coQuanQuanLy.getId()));
				
				// Create sub unit URL
				PortletURL createSubUnitUrl = renderResponse.createRenderURL();
					
				createSubUnitUrl.setParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_add_edit.jsp");
				createSubUnitUrl.setParameter("mode", "0"); // Insert mode
				createSubUnitUrl.setParameter("parentId", String.valueOf(coQuanQuanLy.getId()));	
				
				// BinhNT Add
				PortletURL createVaiTroChucVuChoCQQL = renderResponse.createRenderURL();
				createVaiTroChucVuChoCQQL.setParameter("jspPage", "/html/portlet/admin/themvaitro_chucvucho_coquanquanly.jsp");
				createVaiTroChucVuChoCQQL.setParameter("coQuanQuanLyID", String.valueOf(coQuanQuanLy.getId()));	
				createVaiTroChucVuChoCQQL.setParameter("keyWord", keyWord.trim());
				createVaiTroChucVuChoCQQL.setParameter("searchOption", searchOption.trim());
				createVaiTroChucVuChoCQQL.setParameter("parentId", String.valueOf(parentId));
		%>
			<tr>
				<td align = "left"><%=coQuanQuanLy.getMa() %></td>
				<td align = "left"><a href = "<%=searchSubUnitUrl%>"><%=coQuanQuanLy.getTen() %></a></td>
				<td align = "left"><%=coQuanQuanLy.getDienThoai() %></td>
				<td align = "left"><%=coQuanQuanLy.getEmail() %></td>
				<td align = "left"><%=ConvertUtil.getCapCoQuanQuanLy(coQuanQuanLy.getCapCoQuanQuanlyId()).getTen() %></td>
				<td align = "center">
					<table class="egov-table-function" >
						<tr>
							<td>
								<a href = "<%=editUrl%>"><input type = "button" class="egov-func-edit" title="Chỉnh sửa"/></a>
							</td>
							<td>
								<a href = "<%=deleteUrl%>" onclick = "return confirmDelete()"><input type = "button" class="egov-func-delete" title="Xóa"/></a>
							</td>
							<td>
								<a href = "<%=createSubUnitUrl%>"><input type = "button" class="egov-func-add" title="Tạo cấp dưới"/></a>
							</td>	
							<td>
								<a href="<%=createVaiTroChucVuChoCQQL %>" onclick=""><button class="egov-func-config" title="Thêm vai trò"></button></a>
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

