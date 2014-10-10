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
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page import="org.oep.cmon.admin.portlet.business.LoaiDoiTuongBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>

<body>
<%
	 PortletURL searchUrl = renderResponse.createActionURL();
	 searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchLoaiDoiTuongRequest");
	 
	 PortletURL addNewUrl = renderResponse.createRenderURL();
	 addNewUrl.setParameter("ActionType", "addLoaiDoiTuong");
	 addNewUrl.setParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_add.jsp");
	 
	 String keyWord = renderRequest.getParameter("searchKeyWord");
	 
	 // Get default search value
	 String defaultSearch = LanguageUtil.get(pageContext, "vn.dtt.cmon.admin.ldtsd.search.defaultValue");
	 if (keyWord == null) {
		 keyWord = defaultSearch;
	 } else if (keyWord != null && keyWord.trim().length() == 0) { 
		 keyWord = defaultSearch;
		 addNewUrl.setParameter("searchKeyWord", "");
	 } else {
		 addNewUrl.setParameter("searchKeyWord", keyWord);
		 keyWord = renderRequest.getPortletSession().getAttribute("searchKeyWord").toString();
	 }
	 
	 PortletURL iteratorUrl = renderResponse.createRenderURL();
	 iteratorUrl.setParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_list.jsp");
	 if (renderRequest.getParameter("searchKeyWord") != null) {
		 iteratorUrl.setParameter("searchKeyWord", renderRequest.getPortletSession().getAttribute("searchKeyWord").toString());
	 }
	 
	 SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");
	
	 // Get the search result from session if it exists
	 List<DoiTuongSuDung>  result = new ArrayList<DoiTuongSuDung>(); 
	 
	 if (request.getAttribute("SEARCH_REQUEST_RESULT") != null) {
		 result = (List<DoiTuongSuDung>)request.getAttribute("SEARCH_REQUEST_RESULT");
	 } else {
		 if (renderRequest.getParameter("searchKeyWord") != null) {
			 result = LoaiDoiTuongBusiness.findByTenDoiTuongSuDung(renderRequest.getPortletSession().getAttribute("searchKeyWord").toString());
		 } else {
			 result = LoaiDoiTuongBusiness.findByTenDoiTuongSuDung("");
		 }
	 }
	 
	 if ( result == null ) {
		 result = new ArrayList<DoiTuongSuDung>();
	 }
	 
	 // Paging
	 List<DoiTuongSuDung> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	 searchContainer.setTotal(result.size());
	 searchContainer.setResults(newResults);
	%>
	<div class="wd-main-content" align="center">
		<br/>
		<form name = "searchForm" method = "post" action = "<%=searchUrl%>" onsubmit = "checkForm2()">
			<table width="100%" border="0">
			  <tr>
			    <td align = "left">		    
			    	<input name="searchKeyWord" type="text"  class="egov-inputfield-search" size="40" width = "100%" value = "<%=keyWord %>" onfocus="if(this.value=='<%=defaultSearch %>') this.value='';" onblur="if(this.value=='') this.value='<%=defaultSearch %>'"/>
			    	<input name="searchKeyWordHidden" type="hidden"  value = "<%=defaultSearch %>"/>
			    	<input type="submit" name="button" value=""  class="egov-button-search" />
			    </td>
			    <td align = "right">
			    	<input type="button" name="button" value="+ THÊM MỚI"  class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'"/>
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<liferay-ui:error key="errorDeleteDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.ldtsd.completed.delete"/>
					</font>					
					<%
				}
				%>
			    </td>
			 </tr>
			</table>
		</form>
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th scope="col">Mã đối tượng sử dụng</th>
		    <th scope="col">Tên đối tượng sử dụng</th>
		    <th scope="col">Hành động</th>
		</tr>
	<%
		for(DoiTuongSuDung quocGia : newResults) {											
			
			PortletURL viewRequestUrl = renderResponse.createRenderURL();
			viewRequestUrl.setParameter("ActionType", LoaiDoiTuongBusiness.VIEW_LOAI_DOI_TUONG);
			viewRequestUrl.setParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_add.jsp");
			viewRequestUrl.setParameter("doiTuongSuDungId", String.valueOf(quocGia.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			editRequestUrl.setParameter("ActionType", "editQuocGia");		
			editRequestUrl.setParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_add.jsp");
			editRequestUrl.setParameter("doiTuongSuDungId", String.valueOf(quocGia.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				editRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteLoaiDoiTuongRequest");
			deleteUrl.setParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_list.jsp");
			deleteUrl.setParameter("doiTuongSuDungId", String.valueOf(quocGia.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				deleteUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
	%>
		<tr>
			<td class="bold" align="left"><%=quocGia.getMa() %></td>
			<td class="bold" align="left"><a href="<%=viewRequestUrl.toString()%>"><%=quocGia.getTen() %></a></td>
			<td>
				<a href="<%=editRequestUrl.toString() %>">Sửa</a>|
				<a href="javascript: deleteRow('<%=deleteUrl.toString()%>')">Xóa</a>
			</td>
		</tr>
	<%} %>
		</table>
		<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
	</div>
</body>

<script type = "text/javascript">
function deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.admin.confirm.delete.ldtsd") %>');
	if (answer){
		window.location = url;
	}
}

	function checkForm(){
		var form = document.searchForm;
		
		if ( form.searchKeyWord.value == "<%=defaultSearch %>"){
			form.searchKeyWord.value = "";
		} 		
	};	
	
	function checkForm2(){
		var form = document.searchForm;
		
		if ( form.searchKeyWord.value == "<%=defaultSearch %>"){
			form.searchKeyWord.value = "";
		}

		form.reqStatus.options.selectedIndex = 0;
	};
</script>