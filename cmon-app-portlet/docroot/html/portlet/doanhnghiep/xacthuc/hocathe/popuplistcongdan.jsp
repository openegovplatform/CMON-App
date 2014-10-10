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
<%@page import="org.oep.cmon.portlet.doanhnghiep.xacthuc.utils.XacThucDoanhNghiepUtils"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.FormatUtils"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

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


	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "popUpListCongDan");
	int cur = ParamUtil.getInteger(request,"currentTransPage");
	
	String maOrTenOrEmail = ParamUtil.getString(request, "maOrTenOrEmail");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistcongdan.jsp");
	iteratorUrl.setParameter("maOrTenOrEmail",maOrTenOrEmail);
	
	List<CongDan> listCongDan = new ArrayList<CongDan>();
	long longTotal = 0;
	int total = 0;
	SearchContainer searchContainer = null;

	if (cur > 0) {
		searchContainer = new SearchContainer<CongDan>(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, cur, 10,
				iteratorUrl, null, null);
	} else {
		searchContainer = new SearchContainer<CongDan>(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, 10,
				iteratorUrl, null, null);
	}
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	longTotal = XacThucDoanhNghiepUtils.countListCongDan(maOrTenOrEmail);
	if (longTotal > 0) {
		listCongDan = XacThucDoanhNghiepUtils.getListCongDan(maOrTenOrEmail, start, end);
	}

	total = Integer.parseInt(String.valueOf(longTotal));
	searchContainer.setTotal(total);
	searchContainer.setResults(listCongDan); 
	int k = 1;	
%>

<div class="egov-container" id="congdan_popup">
	<p class="egov-p-20">
		Tìm kiếm công dân
	</p>
	<form name="searchForm" class="searchForm" method="post" action="<%=searchUrl %>" >
		<table class="egov-table-form" >
			<tbody>
				<tr>
					<td> 
						<div class="left" style="width: 50%;">	
							<input style="width: 95%;" placeholder="Tìm kiếm theo tên/ Email/ Mã CDĐT hoặc CMND" name="maOrTenOrEmail" id="maOrTenOrEmail" type="text" size="25" maxlength="150"
							class="egov-inputfield custom" value="<%=maOrTenOrEmail %>" />
						</div>
						<div>
							<input type="submit" value="Tìm kiếm" class="egov-button-search" />
						</div>
					</td>
					
					
				</tr>
			</tbody>
		</table>
		
	</form>
	<form name="frmListCongDan">
		<table id="tblContent" class="egov-table cssTable" >
			<tbody>
				<tr>
					<th>STT </th>
					<th>Mã CDĐT</th>	
					<th>Họ và tên</th>					
					<th>Số CMND</th>
					<th>Ngày sinh</th>
					<th>Email</th>	
					<th>Chọn</th>
				</tr>
				<%
					if (total > 0 && listCongDan != null) {
						for (int i = 0; i < listCongDan.size(); i++) {
							CongDan hs = (CongDan) listCongDan.get(i);
				%>
				<tr>
					<td style="text-align: center;padding: 0;" ><%= Integer.toString(k++ + searchContainer.getStart()) %></td>
					<td><%=hs.getMa()%></td>
					<td><%=hs.getTenDayDu()%></td>
					<td><%=hs.getSoCmnd() %></td>
					<td><%=FormatUtils.getFormatDate(hs.getNgaySinh())%></td>
					<td><%=hs.getEmail() %></td>
					<td class="center">
						<input type="radio" class="egov-radio"  name="rdChonCD" id="rdChonCD" value="<%=hs.getId()%>" />	
					</td>
				</tr>
				<%
						}
					} else {
				%>
				<tr>
					<td colspan="4" align="center"><label class="egov-label">Không có dữ liệu !</label></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			if (searchContainer != null) {
		%>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
		<%
			}
		%>
		<br />
		<table style="margin-bottom: 20pt;">
			<tr>
				<td align="center">
					<input name="selectId" type="button" value="Chọn" class="egov-button-normal"  onclick="selectedCongDan();" />
					<input type="button" class="egov-button" onclick="window.close();"value="Đóng"/>	
				</td>
			</tr>
		</table>
</form>
<script type="text/javascript">
	function selectedCongDan() {
		var checkboxs = $('input[name="rdChonCD"]:checked');
	    if (checkboxs.length == 0) {
			alert ("Bạn cần phải chọn một công dân");
			return false;
		}else{
			window.opener.choiceCongDan($('input[name=rdChonCD]:checked').val());
			window.close();
		}
	}
</script>