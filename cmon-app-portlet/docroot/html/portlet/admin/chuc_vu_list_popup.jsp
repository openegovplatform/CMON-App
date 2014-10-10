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
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
	function getSelectedId() {
		var radios = document.getElementsByName("chucVu");

		var value = "";
		
	    for (var i = 0; i < radios.length; i++) {       
	        if (radios[i].checked) {
	        	value = radios[i].value;
	            break;
	        }
	    }

	    if (value == "") {
			alert ("Bạn cần phải chọn một chức vụ");

			return;
		}

	    if (window.opener.document.inputForm.chucVu.value != value) {
	    	window.opener.document.inputForm.vaiTroThem.value = '';
		}
	    window.opener.document.inputForm.chucVu.value = value;

	    window.close();
	}
	document.getElementById('coQuanQuanLyID').value = window.opener.document.inputForm.coQuanQuanLy.value;
</script>
<%
	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopUpChucVu");
	
	// Get search keyword
	String keyWord = ParamUtil.getString(request, "keyWord");
	String coQuanQuanLyID = ParamUtil.getString(request, "coQuanQuanLyID").trim();
	
	// Get search option
	String searchOption = ParamUtil.getString(request, "searchOption");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/chuc_vu_list_popup.jsp");
	iteratorUrl.setParameter("searchOption", searchOption);
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, iteratorUrl, null, "");
	
	// Incase this is the first time the page is load
	if (Validator.isNull(searchOption)) {
		// Remove the search result if it exists in session
	 	renderRequest.getPortletSession().removeAttribute("SEARCH_CHUC_VU_RESULT");
	}
	 
	// Get the search result from session if it exists
	List<ChucVu>  result = (List<ChucVu>)renderRequest.getPortletSession().getAttribute("SEARCH_CHUC_VU_RESULT");
	 
	if ( result == null ) {
		result = new ArrayList<ChucVu>();		
	}
	 
	// Paging
	List<ChucVu> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	 
	%>
	<div class="wd-main-content">
	<br/>		
	<form name = "searchForm" method = "post" action = "<%=searchUrl%>">
		<table width="100%" border="0">
		  <tr>
		    <td align = "left">
		   Tìm theo:		    
		    	<select name="searchOption" class="egov-select custom">
		    		<% if ( Validator.isNull(searchOption)) { %>				    		
			    		<option value = "1">Mã chức vụ</option>
			    		<option value = "0" selected>Tên chức vụ</option>
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
				        <option value = "1" <%=selected0%>>Mã chức vụ</option>
			    		<option value = "0" <%=selected1%>>Tên chức vụ</option>			    		
			    	<%} %>		    		
		    	</select>
		    	<input name="keyWord" type="text" size = "30" maxlength="150" class = "egov-inputfield custom" value = "<%=keyWord%>"/>
		    	<input type="submit" value=""  class="egov-button-search" />
		    	<input type = "hidden" name = "popup" value = "1" />		
		    	<input id="coQuanQuanLyID" name="coQuanQuanLyID" type="hidden" value="<%=coQuanQuanLyID %>"/>    			    			    	
		    </td>
		    <td align = "right">					    
		    </td>
		  </tr>
		</table>
	</form>
	<form name = "resultForm" >	
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
			<tr>
	    		<th width = "8%">Chọn</th>
			    <th  width = "20%">Mã</th>
			    <th>Tên chức vụ</th>

		</tr>
		<%
			for (int i = 0; i< newResults.size(); i++) {
				ChucVu chucVu = newResults.get(i);
		
		%>
			<tr>
				<td ><input type="radio" name="chucVu" id="chucVu" value="<%=chucVu.getId() + "-" + chucVu.getTen() %>" /></td>
				<td align = "left"><%=chucVu.getMa() %></td>
				<td align = "left"><%=chucVu.getTen() %></td>
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
	</form>
</div>
<script type = "text/javascript">
<%
	if (coQuanQuanLyID.trim().length() == 0) {
		%>
		document.getElementById('coQuanQuanLyID').value = window.opener.document.inputForm.coQuanQuanLy.value;
		<%
	}
%>
</script>

