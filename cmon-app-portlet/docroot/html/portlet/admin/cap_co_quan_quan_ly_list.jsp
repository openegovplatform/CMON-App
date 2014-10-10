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
<%@ include file="/html/portlet/admin/init.jsp" %>

<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
</script>
<%
	 
	 PortletURL searchUrl = renderResponse.createActionURL();
	 searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchCapCoQuanQuanLy");
	 
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
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
		 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
		
	// Incase this is the first time the page is load
	if (Validator.isNull(searchOption)) {
		// Remove the search result if it exists in session
	 	renderRequest.getPortletSession().removeAttribute("SEARCH_CO_QUAN_QUAN_LY_RESULT");
	}
		 
	// Get the search result from session if it exists
	List<CapCoQuanQuanLy>  result = (List<CapCoQuanQuanLy>)renderRequest.getPortletSession().getAttribute("SEARCH_CO_QUAN_QUAN_LY_RESULT");
		 
	if ( result == null ) {
		result = new ArrayList<CapCoQuanQuanLy>();		
	}
		 
	// Paging
	List<CapCoQuanQuanLy> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
		 
	searchContainer.setTotal(result.size());	 
	searchContainer.setResults(newResults);
	 
	
	PortletURL capCoQuanQuanLyAddUrl = renderResponse.createRenderURL();
	 capCoQuanQuanLyAddUrl.setParameter("jspPage","/html/portlet/admin/cap_co_quan_quan_ly_add.jsp");
	 capCoQuanQuanLyAddUrl.setParameter("actionName", "new");
	 capCoQuanQuanLyAddUrl.setParameter("parentId", Long.toString(parentId));
	
%>

<div class="wd-main-content">
	<br/>
	
	<%
		PortletURL searchHighestLevelUrl = renderResponse.createActionURL();
		searchHighestLevelUrl.setParameter(ActionRequest.ACTION_NAME, "searchCapCoQuanQuanLy");
		
		if ( parentId > 0 ) {
	%>
			>> <a href = "<%=searchHighestLevelUrl%>">Cấp cao nhất</a>
	<%			
			List <CapCoQuanQuanLy> lst = new ArrayList<CapCoQuanQuanLy>();	
			CapCoQuanQuanLy capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(parentId);
			
			lst.add(capCoQuanQuanLy);
			
			while ( capCoQuanQuanLy != null ) {
				Long chaId = capCoQuanQuanLy.getChaId();
				if (chaId == null) {
					chaId = 0L;
				}
				capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(chaId);
				if ( capCoQuanQuanLy != null ) {
					lst.add(capCoQuanQuanLy);
				}
			}
			
			int cnt = lst.size();
			
			for (int i = cnt - 1; i > 0; i --) {
				// Direct search URL
				PortletURL directSearchUrl = renderResponse.createActionURL();
				directSearchUrl.setParameter(ActionRequest.ACTION_NAME, "searchCapCoQuanQuanLy");
				directSearchUrl.setParameter("parentId", lst.get(i).getId() + "");
			%>
	
				>> <a href = "<%=directSearchUrl%>"><%=lst.get(i).getTen() %></a>
			
		<%	} //for %>
			>> <%=lst.get(0).getTen() %>
			
	<%	} %>
	
	<form name = "searchForm" method = "post" action = "<%=searchUrl%>" onsubmit = "checkForm2()">
		<table width="100%" border="0">
		  <tr>
		    <td align = "left">
		    	Tìm theo:		    
		    	<select name="searchOption" class="egov-select">
		    		<% if ( Validator.isNull(searchOption)) { %>				    		
			    		<option value = "0">Mã cấp cơ quan quản lý</option>
			    		<option value = "1" selected>Tên cấp cơ quan quản lý</option>
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
		    	<input name="keyWord" type="text"  size = "30" maxlength="150" class = "egov-inputfield" value = ""/>
		    	<input type="submit" value=""  class="egov-button-search" />
		    	<input type="hidden" name="parentId" value ="<%=parentId%>" />
		    </td>
		    <td align = "right">
		    	<a href = "<%=capCoQuanQuanLyAddUrl%>"><input type="button" value="THÊM MỚI"  class="egov-button-normal" /></a>			    
		    </td>
		  </tr>
		</table>
	</form>	
	<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%" border = "1">
		<tr>
		    <th align = "center" width = "5%">Mã</th>
		    <th scope="col" >Tên</th>	    
		    <th scope="col" width = "30%">Hành động</th>
		</tr>
		<%
			for (int i = 0; i< newResults.size(); i++) {
				CapCoQuanQuanLy capCoQuanQuanLy = newResults.get(i);
				
				PortletURL searchSubUnitUrl = renderResponse.createActionURL();
				searchSubUnitUrl.setParameter(ActionRequest.ACTION_NAME, "searchCapCoQuanQuanLy");
				searchSubUnitUrl.setParameter("parentId", String.valueOf(capCoQuanQuanLy.getId()));				
				
				// Edit Url
				PortletURL editUrl = renderResponse.createRenderURL();
				editUrl.setParameter(ActionRequest.ACTION_NAME, "edit");
				editUrl.setParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_add.jsp");
				editUrl.setParameter("capCoQuanQuanLyId", String.valueOf(capCoQuanQuanLy.getId()));
				editUrl.setParameter("actionName", "edit");
				
				// Add Url
				PortletURL addUrl = renderResponse.createRenderURL();
				addUrl.setParameter(ActionRequest.ACTION_NAME, "add");
				addUrl.setParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_add.jsp");
				addUrl.setParameter("capCoQuanQuanLyId", String.valueOf(capCoQuanQuanLy.getId()));
				addUrl.setParameter("actionName", "add");
				
				// Delete Url
				PortletURL deleteUrl = renderResponse.createActionURL();
				deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteCapCoQuanQuanLy");
				deleteUrl.setParameter("capCoQuanQuanLyId", String.valueOf(capCoQuanQuanLy.getId()));
		%>
		<tr>
			<td align = "left"><%=capCoQuanQuanLy.getMa() %></td>
			<td align = "left"><a href = "<%=searchSubUnitUrl%>"><%=capCoQuanQuanLy.getTen() %></a></td>
			<td>
				<a href = "<%=editUrl%>">Sửa</a>
				&nbsp; | &nbsp;
				<a href = "<%=deleteUrl%>">Xóa</a>
				&nbsp; | &nbsp;
				<a href = "<%=addUrl%>">Tạo cấp dưới</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
	

</div>

