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
<%@page import="org.oep.cmon.dao.qlhc.model.DoanhNghiep"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>

<%
renderRequest.getPortletSession().removeAttribute(FormOfflineBusiness.DATA_UPLOAD_FILE);
renderRequest.getPortletSession().removeAttribute(FormOfflineBusiness.TEN_FILE_UPLOAD);

PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "searchCongTy");

String searchKeyWord = "";
if (renderRequest.getParameter("searchKeyWord") != null) {
	searchKeyWord = renderRequest.getParameter("searchKeyWord");
}
String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}
String _searchKeyWord = "";
if (renderRequest.getParameter("_searchKeyWord") != null) {
	_searchKeyWord = renderRequest.getParameter("_searchKeyWord");
}
String idQuyTrinh = "";
if (renderRequest.getParameter("idQuyTrinh") != null) {
	idQuyTrinh = renderRequest.getParameter("idQuyTrinh");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}
String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

PortletURL addCongDanRequestUrl = renderResponse.createRenderURL();
addCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/themCompany.jsp");
addCongDanRequestUrl.setParameter("searchKeyWord", searchKeyWord);
addCongDanRequestUrl.setParameter("_searchKeyWord", _searchKeyWord);
addCongDanRequestUrl.setParameter("statusHS", statusHS);
addCongDanRequestUrl.setParameter("idQuyTrinh", idQuyTrinh);
addCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
addCongDanRequestUrl.setParameter("transType", transType);
%>
<div class="egov-container">
	<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		<table style="width: 100%; background-color: white;">
			<tr>
				<td align="left" width="100%">
					<table  style="width: 100%; background-color: white;">
						<tr>
							<td align="left"><label class="egov-label-header">Tìm thông tin doanh nghiệp</label></td>
							<td align="right">
								<%
									PortletURL nopHoSoOfflineUrl = renderResponse.createRenderURL();
									nopHoSoOfflineUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/nopHoSoOffline.jsp");
									nopHoSoOfflineUrl.setParameter("searchKeyWord", _searchKeyWord);
									nopHoSoOfflineUrl.setParameter("transactionKeyword", transactionKeyword);
									nopHoSoOfflineUrl.setParameter("statusHS", statusHS);
									nopHoSoOfflineUrl.setParameter("transType", transType);
								%>
								<a href="<%=nopHoSoOfflineUrl.toString() %>">Quay lại&nbsp;&nbsp;&nbsp;&nbsp;</a>
							</td>
						</tr>
						<tr>
							<td align="left" colspan="2">
								Mã số thuê or mã số doanh nghiệp<font color="red">(*)</font>:
								<input id="_searchKeyWord" name="_searchKeyWord" value="<%=_searchKeyWord %>" type="hidden" maxlength="12" size="40"/>
								<input type="hidden" name = "idQuyTrinh" id = "idQuyTrinh" value = "<%=idQuyTrinh%>"/>
								<input type="hidden" name = "transType" id = "transType" value = "<%=transType%>"/>
								<input type="hidden" name = "statusHS" id = "statusHS" value = "<%=statusHS%>"/>
								<input type="hidden" name = "transactionKeyword" id = "transactionKeyword" value = "<%=transactionKeyword%>"/>	
								<input id="searchKeyWord" name="searchKeyWord" value="<%=searchKeyWord %>" class = "egov-inputfield custom" type="text" maxlength="12" size="40"/>
								<input type="submit" style="height: 35px;padding:10px;" class = "egov-button" name="submitButton"  value="Tìm kiếm" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="left"><a href="<%=addCongDanRequestUrl.toString() %>"><font size="4">Thêm mới thông tin doanh nghiệp</font></a></th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<%
	List<DoanhNghiep>  result = new ArrayList<DoanhNghiep>(); 
	
	if (request.getAttribute("SEARCH_REQUEST_RESULT") != null) {
		 result = (List<DoanhNghiep>)request.getAttribute("SEARCH_REQUEST_RESULT");
	} else {
		if (searchKeyWord.trim().length() > 0) {
			FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
			result = formOfflineBusiness.findByMaSoThueOrMaSoDoanhNghiep(searchKeyWord);
		}
	}
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("statusHS", statusHS);
	iteratorUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCompany.jsp");
	iteratorUrl.setParameter("transactionKeyword", transactionKeyword);
	iteratorUrl.setParameter("transType", transType);
	iteratorUrl.setParameter("searchKeyWord", searchKeyWord);
	iteratorUrl.setParameter("_searchKeyWord", _searchKeyWord);
	iteratorUrl.setParameter("idQuyTrinh", idQuyTrinh);
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");
	//Paging
	List<DoanhNghiep> thuTucHanhChinhs = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(result.size());
	searchContainer.setResults(thuTucHanhChinhs);
	
	%>
	<br>
	<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
			<tr>
				<th scope="col">STT</th>
				<th scope="col">Mã số doanh nghiệp</th>
				<th scope="col">Mã số thuế</th>
				<th scope="col">Tên doanh nghiệp</th>
				<th scope="col">Địa chỉ</th>
				<th scope="col">Hành động</th>
			</tr>
			<%
			int i = 0;
			for (DoanhNghiep congDan : thuTucHanhChinhs) {
				%>
			<tr>
				<td align="center" style="text-align: center;"><%=(searchContainer.getStart()+i+1)%></td>
				<td align="center" style="text-align: center;"><%=congDan.getMa() %></td>
				<td align="center" style="text-align: center;"><%=congDan.getMaSoThue() %></td>
				<td align="left" ><%=congDan.getTen() %></td>
				<td align="left"><%=congDan.getDiaChiDoanhNghiep() %>,<%=ConvertUtil.getTenDonViHanhChinh(congDan.getDiaChiDoanhNghiepXaId()) %>,<%=ConvertUtil.getTenDonViHanhChinh(congDan.getDiaChiDoanhNghiepHuyenId()) %>,<%=ConvertUtil.getTenDonViHanhChinh(congDan.getDiaChiDoanhNghiepTinhId()) %></td>
				<td align="center" style="text-align: center;">
				<%
				PortletURL editRequestUrl = renderResponse.createRenderURL();
				editRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/inputHoSo.jsp");
				editRequestUrl.setParameter("idCongDan", String.valueOf(congDan.getId()));
				editRequestUrl.setParameter("idQuyTrinh", idQuyTrinh);
				editRequestUrl.setParameter("transType", transType);
				editRequestUrl.setParameter("transactionKeyword", transactionKeyword);
				editRequestUrl.setParameter("searchKeyWord", searchKeyWord);
				editRequestUrl.setParameter("statusHS", statusHS);
				editRequestUrl.setParameter("_searchKeyWord", _searchKeyWord);
				%>
				<a href="<%=editRequestUrl.toString() %>">Nộp đơn</a>
				</td>
			</tr>
				<%
				i++;
			}
			%>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</div>