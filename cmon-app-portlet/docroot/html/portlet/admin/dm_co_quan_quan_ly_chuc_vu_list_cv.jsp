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
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.admin.portlet.business.ChucVuVaiTroBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>

<body>
<%
	String coQuanQuanLyId = renderRequest.getParameter("coQuanQuanLyId");

	PortletURL addNewUrl = renderResponse.createRenderURL();
	addNewUrl.setParameter("ActionType", "addDanhMucDonViHanhChinh");
	addNewUrl.setParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_add_cv.jsp");
	addNewUrl.setParameter("coQuanQuanLyId", coQuanQuanLyId);
	if (renderRequest.getParameter("searchKeyWord") != null) {
		 addNewUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
	}

	 PortletURL iteratorUrl = renderResponse.createRenderURL();
	 iteratorUrl.setParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cv.jsp");
	 iteratorUrl.setParameter("coQuanQuanLyId", coQuanQuanLyId);
	 if (renderRequest.getParameter("searchKeyWord") != null) {
		 iteratorUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
	 }
	 
	 SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");
	
	 // Get the search result from session if it exists
	 List<ChucVu2VaiTro>  result = new ArrayList<ChucVu2VaiTro>(); 
	 
	 if (request.getAttribute("SEARCH_REQUEST_RESULT") != null) {
		 result = (List<ChucVu2VaiTro>)request.getAttribute("SEARCH_REQUEST_RESULT");
	 } else {
		 if (renderRequest.getParameter("coQuanQuanLyId") != null) {
			 result = ChucVuVaiTroBusiness.findChucVuByCoQuanQuanLy(ConvertUtil.convertToLong(coQuanQuanLyId.trim()));
		 }
	 }
	 
	 if ( result == null ) {
		 result = new ArrayList<ChucVu2VaiTro>();
	 }
	 
	 // Paging
	 List<ChucVu2VaiTro> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());

	 searchContainer.setTotal(result.size());
	 searchContainer.setResults(newResults);
	%>
	<div class="wd-main-content" align="center">
		<table width="100%" border="0">
			<tr>
			     <td align = "right">
			    	<input type="button" name="button" value="+ THÊM MỚI CHỨC VỤ"  class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'"/>
			    </td>
			</tr>
			<tr>
			    <td>
			    	<liferay-ui:error key="errorDeleteChucVu2VaiTro" message = "vn.dtt.cmon.admin.coquanquanly.chucvu.vaitro.delete.error"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.coquanquanly.chucvu.vaitro.delete.completed"/>
					</font>					
					<%
				}
				%>
			    </td>
			 </tr>
		</table>
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th scope="col">Mã cơ quan quản lý</th>
		    <th scope="col">Tên chức vụ</th>
		    <th scope="col">Tên vai trò</th>
		    <th scope="col">Tên cơ quan quản lý</th>
		    <th scope="col">Hành động</th>
		</tr>
	<%
		CoQuanQuanLy coQuanQuanLy = ChucVuVaiTroBusiness.getCoQuanQuanLyByIdCoQuanQuanLy(coQuanQuanLyId);
		for(ChucVu2VaiTro quocGia : newResults) {											
			
			PortletURL viewRequestUrlChucVu = renderResponse.createRenderURL();
			viewRequestUrlChucVu.setParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_add_cv.jsp");
			viewRequestUrlChucVu.setParameter("chucVuId", String.valueOf(quocGia.getChucVuId()));
			viewRequestUrlChucVu.setParameter("coQuanQuanLyId", String.valueOf(coQuanQuanLyId));
			viewRequestUrlChucVu.setParameter("chucVuVaiTroId", String.valueOf(quocGia.getId()));
			viewRequestUrlChucVu.setParameter("ActionType", ChucVuVaiTroBusiness.VIEW_CHUC_VU_VAI_TRO);
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrlChucVu.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL viewRequestUrlVaiTro = renderResponse.createRenderURL();
			viewRequestUrlVaiTro.setParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_add_cv.jsp");
			viewRequestUrlVaiTro.setParameter("coQuanQuanLyId", String.valueOf(coQuanQuanLyId));
			viewRequestUrlVaiTro.setParameter("chucVuVaiTroId", String.valueOf(quocGia.getId()));
			viewRequestUrlVaiTro.setParameter("vaiTroId", String.valueOf(quocGia.getVaiTroId()));
			viewRequestUrlChucVu.setParameter("ActionType", ChucVuVaiTroBusiness.VIEW_CHUC_VU_VAI_TRO);
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrlVaiTro.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL editRequestUrlVaiTro = renderResponse.createRenderURL();
			editRequestUrlVaiTro.setParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_add_cv.jsp");
			editRequestUrlVaiTro.setParameter("coQuanQuanLyId", String.valueOf(coQuanQuanLyId));
			editRequestUrlVaiTro.setParameter("chucVuVaiTroId", String.valueOf(quocGia.getId()));
			editRequestUrlVaiTro.setParameter("ActionType", "EDIT_CHUC_VU_VAI_TRO");
			if (renderRequest.getParameter("searchKeyWord") != null) {
				editRequestUrlVaiTro.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL deleteRequestUrlVaiTro = renderResponse.createActionURL();
			deleteRequestUrlVaiTro.setParameter(ActionRequest.ACTION_NAME, "deleteChucVu2VaiTroRequest");
			deleteRequestUrlVaiTro.setParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cv.jsp");
			deleteRequestUrlVaiTro.setParameter("coQuanQuanLyId", String.valueOf(coQuanQuanLyId));
			deleteRequestUrlVaiTro.setParameter("chucVuVaiTroId", String.valueOf(quocGia.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				deleteRequestUrlVaiTro.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
	%>
		<tr>
			<td class="bold" align="left"><%=coQuanQuanLy.getMa() %></td>
			<td class="bold" align="left"><a href="<%=viewRequestUrlChucVu.toString()%>"><%=ChucVuVaiTroBusiness.findChucVuByChucVuId(quocGia.getChucVuId()).getTen() %></a></td>
			<td class="bold" align="left"><a href="<%=viewRequestUrlVaiTro.toString()%>"><%=ChucVuVaiTroBusiness.findVaiTroByVaiTroId(quocGia.getVaiTroId()).getTen() %></a></td>
			<td class="bold" align="left"><a href="<%=viewRequestUrlVaiTro.toString()%>"><%=coQuanQuanLy.getTen() %></a></td>
			<td class="bold" align="left">
				<a href="<%=editRequestUrlVaiTro.toString() %>">Sửa</a>|
				<a href="javascript: deleteRow('<%=deleteRequestUrlVaiTro.toString()%>')">Xóa</a>
			</td>
		</tr>
	<%} %>
	</table>
	<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
	<div align="left" style="width: 100%">
		<%			
		   // Create upload avatar URL
		   PortletURL backUrl = renderResponse.createRenderURL();	
		   backUrl.setParameter("jspPage","/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cqql.jsp");
		   backUrl.setParameter("coQuanQuanLyId",coQuanQuanLyId);
		 %>
		<a href = "<%=backUrl %>" title="Quay lại trang danh sách cơ quan quản lý">Quay Lại</a>
	</div>
</div>
</body>

<script type = "text/javascript">
function deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.admin.coquanquanly.chucvu.vaitro.confirm") %>');
	if (answer){
		window.location = url;
	}
}
</script>