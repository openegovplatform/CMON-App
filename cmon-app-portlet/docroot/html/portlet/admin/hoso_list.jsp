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
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo"%>
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
	function checkForm(){
		var form = document.searchForm1;
		
		if ( form.keyWord.value =="Hãy nhập mã số hồ sơ..."){
			form.keyWord.value = "";
		} 		
	}
</script>
<%
List<TrangThaiHoSo> lstTrangThaiHoSo = TrangThaiHoSoLocalServiceUtil.findAll();
%>
<%!	

	private String getTenTrangThai(int trangThai, List<TrangThaiHoSo> lstTrangThaiHoSo ) {
		for(TrangThaiHoSo obj : lstTrangThaiHoSo) {
			if ( obj.getId() == trangThai) {
				return obj.getTrangThai();
			}
		}
		
		return "";
	}
%>

<%

	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchHoSo");
	
	// Get search keyword
	String keyWord = ParamUtil.getString(request, "keyWord");
	
	if (Validator.isNull(keyWord)) {
		keyWord = "Hãy nhập mã số hồ sơ...";
	}

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/hoso_list.jsp");
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Get the search result from session if it exists
	List<HoSoTTHCCong>  result = (List<HoSoTTHCCong>)renderRequest.getPortletSession().getAttribute("SEARCH_HOSO_RESULT");
	 
	if ( result == null ) {
		result = new ArrayList<HoSoTTHCCong>();		
	}
	 
	// Paging
	List<HoSoTTHCCong> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	 
	%>
	<div class="egov-container">
	<br/>		
	<form name = "searchForm1" method = "post" action = "<%=searchUrl%>" onsubmit = "checkForm()">
		<table class = "egov-table-form2" width="100%" border="0">
		  <tr>
		    <td align = "left">
		    	<input name="keyWord" type="text" size = "30" maxlength="150" class = "egov-inputfield custom" value = "<%=keyWord%>" onfocus="if(this.value=='Hãy nhập mã số hồ sơ...') this.value='';" onblur="if(this.value=='') this.value='Hãy nhập mã số hồ sơ...'"/>
		    	<input type="submit" value=""  class="egov-button-search" />	    			    			    	
		    </td>
		    <td align = "right">					    
		    </td>
		  </tr>
		</table>
	</form>	
	<table class="egov-table" width = "100%">
		<tr>
		    <th width = "10%">Mã số hồ sơ</th>
		    <th >Tên dịch vụ công</th>
		    <th width = "12%" >Tên người nộp</th>		    
		    <th width = "15%">Cơ quan tiếp nhận</th>
		    <th width = "15%">Trạng thái</th>
		    <th width = "9%">Ngày hẹn trả</th>
		    <th width = "8%">Loại hồ sơ</th>
		</tr>
		<%
			for (int i = 0; i< newResults.size(); i++) {
				HoSoTTHCCong hoSo = newResults.get(i);
		%>
			<tr>
				<td align = "left"><%=hoSo.getMaSoHoSo() %></td>
				<td align = "left"><%=hoSo.getTenThuTucHanhChinh() %></td>
				<td align = "left"><%=hoSo.getHoTenNguoiNopHoSo() %></td>
				<td align = "left"><%=hoSo.getTenCoQuanTiepNhan()%></td>	
				<td align = "center"><%=getTenTrangThai(hoSo.getTrangThaiHoSo(), lstTrangThaiHoSo) %></td>
				<td align = "center">
				<%
					String ngayHenTra = "";
					if (Validator.isNotNull(hoSo.getNgayHenTraKetQua())) {
						ngayHenTra = sdf.format(hoSo.getNgayHenTraKetQua());
					}
				%>
					<%=ngayHenTra %>								 
				 </td>
				 
				 <%
				 	String loaiHoSo = "Online";
				 	if (hoSo.getLoaiHoSo() == 1) {
				 		loaiHoSo = "Offline";
				 	}
				 
				 %>
				 <td align = "center">
				 <%=loaiHoSo %>
				 </td>
			</tr>
		<%} %>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</div>

