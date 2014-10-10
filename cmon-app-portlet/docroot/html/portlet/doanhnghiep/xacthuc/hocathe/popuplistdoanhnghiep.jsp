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
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dn.service.DoanhNghiepLocalService"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.xacthuc.utils.XacThucDoanhNghiepUtils"%>
<%@page import="org.oep.cmon.dao.dn.model.DoanhNghiep"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<style>
	.cssTable th 
	{
	    text-align:center; 	    
	}
	.searchForm
	{
		margin-bottom: 10pt;
		margin-top: 20pt;
	}
</style>
<%
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "popupListDoanhNghiep");
searchUrl.setWindowState(LiferayWindowState.POP_UP);
List<DoanhNghiep> listDoanhNghiep = new ArrayList<DoanhNghiep>();
int total = 0;

String searchInputText = ParamUtil.getString(request, "searchInputText");

PortletURL portletUrl = renderResponse.createRenderURL();
portletUrl.setParameter("jspPage", "/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistdoanhnghiep.jsp");
portletUrl.setParameter("searchInputText", searchInputText);

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

total = XacThucDoanhNghiepUtils.countDoanhNghiep(searchInputText,Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE")), 0);
listDoanhNghiep = XacThucDoanhNghiepUtils.searchDoanhNghiep(searchInputText,Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE")), 0, searchContainer.getStart(),searchContainer.getEnd());
searchContainer.setTotal(total);
searchContainer.setResults(listDoanhNghiep);
%>

<div class="egov-container">
	<p class="egov-p-20">
		Tìm kiếm hộ cá thể
	</p>	
	<form name="searchDoanhNghiepForm" class="searchDoanhNghiepForm" method="post" action="<%=searchUrl %>" >
		<table cellspacing="5" cellpadding="5" width="100%" border="0" class="egov-table-form">
			<tr>
				<td><input type="text" value="<%=searchInputText %>" name="searchInputText" style="width:70%;" class='egov-inputfield' placeholder="Nhập Tên/ Mã giấy phép/ Mã số thuế"/> <input type="submit" value="Tìm kiếm" class="egov-button-search" /></td>
			</tr>
		</table>
	</form>
	<form name="resultForm">
		<table  class="egov-table cssTable">
			<tbody>
				<tr>
					<th>STT</th>					
					<th>Tên</th>
					<th>Mã giấy phép</th>
					<th>Mã số thuế</th>
					<th>Chọn</th>
				</tr>
				<%
				int i = searchContainer.getStart();
				for(DoanhNghiep row: listDoanhNghiep){
					i++;
				%>
				<tr>
					<td style="text-align: center;width: 10px"><%= i %></td>
					<td><%= row.getTen()%></td>
					<td style="text-align: center;" ><%= row.getMa()%></td>
					<td style="text-align: center;"><%= row.getMaSoThue()%></td>
					<td style="text-align: center;"><input type="radio" value="<%= row.getId() %>" name="choiced" data-title="<%= row.getTen()%>" /></td>
				</tr>
				<%
				}
				%>	
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></td>						
				</tr>
			</tfoot>
		</table>
		<div style="width: 100%;margin-top: 10px;margin-bottom: 10px;text-align: left;">
			<input type="button" class="egov-button" id="chapNhan" value="Chấp nhận" onclick="getSelectedId();window.opener.choiceHoCaThe({value:$('input[name=choiced]:checked').val(),text:$('input[name=choiced]:checked').data('title')}); return false;" >
		   	<input type="button" class="egov-button" onclick="window.close();"value="Đóng lại">			      	
		</div>
	</form>
</div>
<script type="text/javascript">
	function getSelectedId() {
		var checkboxs = $('input[name="choiced"]:checked');
	    if (checkboxs.length == 0) {
			alert ("Bạn cần phải chọn hộ kinh doanh cá thể");
			return false;
		}
	}
</script>





