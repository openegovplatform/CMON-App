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
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<script type = "text/javascript">
	function dongCuaSoPoup() {
	    window.close();
	}
	function ganQuyenToCanBo(){
		var checkboxs = $('input[name="choiced"]:checked');
	    if (checkboxs.length == 0) {
			alert ("Bạn cần phải chọn ít nhất 1 cơ quan");
			return false;
		}
	}
</script>
<%
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "popupCoQuanQuanLy");
searchUrl.setWindowState(LiferayWindowState.POP_UP);
List<CoQuanQuanLy> rows = new ArrayList<CoQuanQuanLy>();
int total = 0;

String maOrTen = ParamUtil.getString(request, "maOrTen");
PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("maOrTen", maOrTen);
iteratorUrl.setParameter("jspPage", "/html/portlet/admin/congchuc/congchuc/popupcoquanquanly.jsp");
PortletURL portletUrl = renderResponse.createRenderURL();
portletUrl.setParameter("jspPage", "/html/portlet/admin/congchuc/congchuc/popupcoquanquanly.jsp");
portletUrl.setParameter("maOrTen", maOrTen);
SearchContainer searchContainer = null;
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			currentTransPage, 10, portletUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 10,
			portletUrl, null, null);
}

int start = searchContainer.getStart();
int end = searchContainer.getEnd();

total = CoQuanQuanLyLocalServiceUtil.countDSCoQuanQuanlyByMaOrTen(maOrTen);
rows = CoQuanQuanLyLocalServiceUtil.getDSCoQuanQuanlyByMaOrTen(maOrTen,searchContainer.getStart(),searchContainer.getEnd());
searchContainer.setTotal(total);
searchContainer.setResults(rows);
%>
<div class="egov-container">
<form action="<%= searchUrl %>" method="post" name="frmPopupCoQuanQuanLy" id="frmPopupCoQuanQuanLy">
<table cellspacing="5" cellpadding="5" width="100%" border="0" class="egov-table-form">
	<tr>
		<td><input type="text" value="<%= maOrTen %>" name="maOrTen" style="width:70%;" class='egov-inputfield' placeholder="Tên, mã cơ quan quản lý"/> <input type="submit" value="Tìm kiếm" class="egov-button-search" /></td>
	</tr>
</table>
<table cellspacing="0" cellpadding="0" class="egov-table" width="100%">
		<thead>
			<tr>
				<th>STT</th>
				<th>Mã Cơ quan</th>
				<th>Tên Cơ quan</th>
				<th>Chọn</th>				
			</tr>
		</thead>
		<tbody>
			<%
			int i = searchContainer.getStart();
			for(CoQuanQuanLy row: rows){
				i++;
				%>
				<tr>
					<td><%= i %></td>
					<td><%= row.getMa()%></td>
					<td><%= row.getTen()%></td>
					<td><input type="radio" value="<%= row.getId() %>" name="choiced" data-title="<%= row.getTen()%>" /></td>
				</tr>
				<%
			}
			%>			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></td>						
			</tr>
		</tfoot>
	</table>
	<div style="width: 100%;margin-top: 10px;margin-bottom: 10px;text-align: left;">
		<input type="button" name="btnChoiced" value="Chọn" class="egov-button" onclick="ganQuyenToCanBo();window.opener.app.editcongchuc.choiceCoQuanQuanLy({value:$('input[name=choiced]:checked').val(),text:$('input[name=choiced]:checked').data('title')}); return false;" />
		<a href= "#" onclick="dongCuaSoPoup()"><input type="button" value="Đóng"  class="egov-button-normal" /></a>
	</div>
</form>	
</div>