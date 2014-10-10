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
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	PortletURL searchUrl = renderResponse.createRenderURL();
	searchUrl.setParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_cong_chuc_list.jsp");
	
	// Get search keyword
	String keyWord = "";

	// Get search option
	String searchOption = ParamUtil.getString(request, "searchOption").trim();	

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_cong_chuc_list.jsp");
	iteratorUrl.setParameter("searchOption", searchOption);
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 100, iteratorUrl, null, "");
	
	// Get the search result from session if it exists
	List<CongChuc>  result = null;
	
	
	if (request.getParameter("keyWord") != null) {
		ArrayList<Long> taiKhoanId = new ArrayList<Long>();
		keyWord = request.getParameter("keyWord").toString().trim();
		

		
		// Tim tai khoan nguoi dung.
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiKhoanNguoiDung.class);       
                    
        // This is a test line for display all request if there's no search criteria
        Criterion criteria = null;
        if ("0".equals(searchOption)) {
        	criteria = RestrictionsFactoryUtil.ilike("tenDangNhap", "%" + keyWord + "%");
        } else if ("1".equals(searchOption)) {
        	criteria = RestrictionsFactoryUtil.ilike("tenNguoiDung", "%" + keyWord + "%");
        } else {
        	criteria = RestrictionsFactoryUtil.ilike("email", "%" + keyWord + "%");
        }
        Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
                    
        // Define search criteria
        query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
                    
        try {
             List<TaiKhoanNguoiDung> results = TaiKhoanNguoiDungLocalServiceUtil.dynamicQuery(query);
             if (results != null) {
            	 for (TaiKhoanNguoiDung taiKhoanNguoiDung : results) {
            		 taiKhoanId.add(taiKhoanNguoiDung.getId());
            	 }
             }
        } catch (Exception e) {
        }
        // Tim cong chuc.
        if (taiKhoanId.size() > 0) {
        	 DynamicQuery queryCongChuc = DynamicQueryFactoryUtil.forClass(CongChuc.class);
        	 Criterion criteriaCongChuc = RestrictionsFactoryUtil.in("taiKhoanNguoiDungId", taiKhoanId.toArray());
        	 queryCongChuc = queryCongChuc.add(criteriaCongChuc);
             
             try {
                  result = CongChucLocalServiceUtil.dynamicQuery(queryCongChuc);
             } catch (Exception e) {
             }
        }
	}
	 
	if ( result == null ) {
		result = new ArrayList<CongChuc>();		
	}
	 
	// Paging
	List<CongChuc> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	 
	searchContainer.setResults(newResults);
	
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	 
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
			    		<option value = "0">Tên đăng nhập</option>
                        <option value = "1" >Tên người dùng</option>
                        <option value = "2" selected>Email</option>    		
			    	<%} else {%>
			    		<%												
							String selected0 = "";
			    	        String selected1 = "";
			    	        String selected2 = "";
							if ("0".equals(searchOption )) {
								selected0 = "selected";
							} else if ("1".equals(searchOption)) {
								selected1 = "selected";
							} else {
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
					
					createNewUrl.setParameter("jspPage", "/html/portlet/admin/cong_chuc_add_edit.jsp");
					createNewUrl.setParameter("mode", "0"); // Insert mode
				 %>
		    	<a href = "<%=createNewUrl%>"><input type="button" value="+ THÊM MỚI"  class="egov-button-normal" /></a>			    
		    </td>
		  </tr>
		</table>
	</form>	
	<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th  width = "12%">Mã</th>
		    <th>Tên công chức</th>
		    <th width = "12%">Ngày sinh</th>
		    <th width = "15%">Số CMND</th>
		    <th width = "15%">Tài khoản người dùng ID</th>
		    <th width = "12%">Hành động</th>
		</tr>
		<%
			for (int i = 0; i< newResults.size(); i++) {
				CongChuc congChuc = newResults.get(i);
				
				// Edit Url
				PortletURL editUrl = renderResponse.createActionURL();
				editUrl.setParameter(ActionRequest.ACTION_NAME, "viewCongChuc");
				editUrl.setParameter("id", String.valueOf(congChuc.getId()));
		%>
			<tr>
				<td align = "left"><%=congChuc.getMa() %></td>
				<td align = "left"><%=congChuc.getHoVaTen() %></td>
				<td align = "center"><%=df.format(congChuc.getNgaySinh()) %></td>
				<td align = "left"><%=congChuc.getSoCmnd() %></td>				
				<%
					String accountId = "";
					if (congChuc.getTaiKhoanNguoiDungId() != null) {
						accountId = congChuc.getTaiKhoanNguoiDungId().longValue() + "";
					}
				%>
				<td align = "left"><%=accountId %></td>
				<td align = "center">
					<a href = "<%=editUrl%>"><input type = "button" class="egov-func-edit" title="Hiển thị"/></a>	
				</td>
			</tr>
		<%} %>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</div>

