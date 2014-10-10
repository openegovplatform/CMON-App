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
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
	function getSelectedId() {
		var radios = document.getElementsByName("capCoQuanQuanLy");

		var value = "";
		
	    for (var i = 0; i < radios.length; i++) {       
	        if (radios[i].checked) {
	        	value = radios[i].value;
	            break;
	        }
	    }

	    if (value == "") {
			alert ("Bạn cần phải chọn cấp cơ quan quản lý");

			return;
		}

	    window.opener.document.inputForm.capCoQuanQuanLy.value = value;

	    window.close();
	}
</script>
<%
	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopupCapCoQuanQuanLy");
	
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
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_list_popup.jsp");
	iteratorUrl.setParameter("searchOption", searchOption);
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, iteratorUrl, null, "");
	
	// Incase this is the first time the page is load
	if (Validator.isNull(searchOption)) {
		// Remove the search result if it exists in session
	 	renderRequest.getPortletSession().removeAttribute("SEARCH_CO_QUAN_QUAN_LY_POPUP_RESULT");
	}
	 
	// Get the search result from session if it exists
	List<CapCoQuanQuanLy>  result = (List<CapCoQuanQuanLy>)renderRequest.getPortletSession().getAttribute("SEARCH_CO_QUAN_QUAN_LY_POPUP_RESULT");
	 
	if ( result == null ) {
		result = new ArrayList<CapCoQuanQuanLy>();		
	}
	 
	// Paging
	List<CapCoQuanQuanLy> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	 
	%>
	<div class="wd-main-content">
	<br/>
	<%
		PortletURL searchHighestLevelUrl = renderResponse.createActionURL();
		searchHighestLevelUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopupCapCoQuanQuanLy");
		
		if ( parentId > 0 ) {
	%>
			>> <a href = "<%=searchHighestLevelUrl%>">Cấp cao nhất</a>
	<%			
			List <CapCoQuanQuanLy> lst = new ArrayList<CapCoQuanQuanLy>();			
			CapCoQuanQuanLy capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(parentId);
			
			lst.add(capCoQuanQuanLy);
			
			while ( capCoQuanQuanLy != null ) {				
				// This is the shit for by passing null problem
				long chaId = 0l;
				if (capCoQuanQuanLy.getChaId() != null ){
					chaId = capCoQuanQuanLy.getChaId().longValue();
				}
				
				try {
					capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(chaId);
					if ( capCoQuanQuanLy != null ) {
						lst.add(capCoQuanQuanLy);
					}
				} catch (Exception es) {
					capCoQuanQuanLy = null;
				}
			}
			
			int cnt = lst.size();
			
			for (int i = cnt - 1; i > 0; i --) {
				// Direct search URL
				PortletURL directSearchUrl = renderResponse.createActionURL();
				directSearchUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopupCapCoQuanQuanLy");
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
				        <option value = "0" <%=selected0%>>Mã cấp cơ quan quản lý</option>
			    		<option value = "1" <%=selected1%>>Tên cấp cơ quan quản lý</option>			    		
			    	<%} %>		    		
		    	</select>
		    	<input name="keyWord" type="text" size = "30" maxlength="150" class = "egov-inputfield custom" value = "<%=keyWord%>"/>
		    	<input type="submit" value=""  class="egov-button-search" />
		    	<input type = "hidden" name = "parentId" value = "<%=parentId%>" />		    			    			    	
		    </td>
		    <td align = "right">					    
		    </td>
		  </tr>
		</table>
	</form>
	<form name = "resultForm" >	
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
			<tr>
			    <th align = "center" width = "5%">Chọn</th>
			    <th align = "center" width = "10%">Mã</th>
			    <th align = "center" width = "10%">Cấp</th>
			    <th scope="col" >Tên cấp cơ quan quản lý</th>
			</tr>
			<%
				for (int i = 0; i< newResults.size(); i++) {
					CapCoQuanQuanLy capCoQuanQuanLy = newResults.get(i);
					
					PortletURL searchSubUnitUrl = renderResponse.createActionURL();
					searchSubUnitUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopupCapCoQuanQuanLy");
					searchSubUnitUrl.setParameter("parentId", String.valueOf(capCoQuanQuanLy.getId()));						
			%>
				<tr>
					<td ><input type="radio" name="capCoQuanQuanLy" id="capCoQuanQuanLy" value="<%=capCoQuanQuanLy.getId() + "-" + capCoQuanQuanLy.getTen() %>" /></td>
					<td align = "left"><%=capCoQuanQuanLy.getMa() %></td>
					<td align = "left"><%=capCoQuanQuanLy.getCap() %></td>
					<td align = "left"><a href = "<%=searchSubUnitUrl%>"><%=capCoQuanQuanLy.getTen() %></a></td>
			</tr>
			<%} %>
		</table>
		<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
		<br/>
		<table cellpadding="0" cellspacing="0"  width="100%">
			<tr>
			    <td align = "center"><input name = "selectId" type = "button" value = "Chọn" class = "egov-button-normal" onclick = "getSelectedId()"/></td>			   
			</tr>
		</table>
		<input type = "hidden" name = "selectedCapCoquanQuanLy"	/>	
	</form>
</div>

