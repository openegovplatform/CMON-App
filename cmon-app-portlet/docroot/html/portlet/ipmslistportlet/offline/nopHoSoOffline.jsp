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
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>

<%
	String statusHS = "";
	if (renderRequest.getParameter("statusHS") != null) {
		statusHS = renderRequest.getParameter("statusHS");
	}
	String transType = "";
	if (renderRequest.getParameter("transType") != null) {
		transType = renderRequest.getParameter("transType");
	}
	String transactionKeyword = "";
	if (renderRequest.getParameter("transactionKeyword") != null) {
		transactionKeyword = renderRequest.getParameter("transactionKeyword");
	}

	String searchKeyWord = "";
	if (renderRequest.getParameter("searchKeyWord") != null) {
		searchKeyWord = renderRequest.getParameter("searchKeyWord");
	}
	long uid = PortalUtil.getUserId(request);
	long	 cqqlId = -1;
	//List<CongChuc>  congChucs =	 null;	
	TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
	List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId());
	
	if(congChucs.size() > 0 ){
   		cqqlId = congChucs.get(0).getCoQuanQuanLyId();
   	}
	
	PortletURL backRequestUrl = renderResponse.createRenderURL();
	backRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/view.jsp");
	backRequestUrl.setParameter("transactionKeyword", transactionKeyword);
	backRequestUrl.setParameter("transType", transType);
	backRequestUrl.setParameter("statusHS", statusHS);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/nopHoSoOffline.jsp");
	iteratorUrl.setParameter("transType", transType);
	iteratorUrl.setParameter("statusHS", statusHS);
	iteratorUrl.setParameter("searchKeyWord", searchKeyWord);
	iteratorUrl.setParameter("transactionKeyword", transactionKeyword);

	List<ThuTucHanhChinh> thuTucHanhChinhsTemp = new ArrayList<ThuTucHanhChinh>();
	if (searchKeyWord.length() == 0) {
		thuTucHanhChinhsTemp = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCQQL(cqqlId);
	} else {
		thuTucHanhChinhsTemp = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCQQLAndMa(cqqlId, searchKeyWord);
	}
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, iteratorUrl, null, "");
	//Paging
	List<ThuTucHanhChinh> thuTucHanhChinhs = ListUtil.subList(thuTucHanhChinhsTemp, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(thuTucHanhChinhsTemp.size());
	searchContainer.setResults(thuTucHanhChinhs);
	
	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchMaDichVuCongRequest");
%>
<div  class="egov-container">
	<form name = "searchForm" method = "post" action = "<%=searchUrl%>">
		<table style="width: 100%; background-color: white;">
		  <tr style="width: 100%;">
		    <td align = "right" style="width: 100%;" >	
		    	<a href="<%=backRequestUrl.toString() %>">Quay Lại</a>
		    </td>
		  </tr>
		 </table>
		<table class="egov-table-form" style="width: 100%;">
		  <tr>
		    <td align = "left">
		    	<label class="egov-label-header">Tìm theo mã quy trình:</label>
		    	<input name="searchKeyWord" id="searchKeyWord" type="text" size = "30" maxlength="13" class = "egov-inputfield custom" value = "<%=searchKeyWord%>"/>
				<input type="hidden" name = "transType" id = "transType" value = "<%=transType%>"/>
				<input type="hidden" name = "statusHS" id = "statusHS" value = "<%=statusHS%>"/>
				<input type="hidden" name = "transactionKeyword" id = "transactionKeyword" value = "<%=transactionKeyword%>"/>		    
				<input type="submit" style="height: 35px;padding:10px;" class = "egov-button" value="Tìm kiếm"/>
		    </td>
		  </tr>
		</table>
	</form>
	<table class="egov-table" width="100%">
		<tr>
			<th scope="col" width="5%">STT</th>
			<th scope="col" width="10%">Mã quy trình</th>
			<th scope="col" width="70%">Tên quy trình</th>
			<th scope="col" width="15%">Hành động</th>
		</tr>
		<%
		int i = 0;
		for (ThuTucHanhChinh thuTucHanhChinh : thuTucHanhChinhs) {
			%>
			<tr>
				<td align="center" style="text-align: center;"><%=(searchContainer.getStart()+i+1)%></td>
				<td align="center" style="text-align: center;"><%=thuTucHanhChinh.getMa() %></td>
				<td align="left"><%=thuTucHanhChinh.getTen() %></td>
				<%
				PortletURL editRequestUrl = renderResponse.createRenderURL();
				editRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/timCongDan.jsp");
				editRequestUrl.setParameter("_searchKeyWord", searchKeyWord);
				editRequestUrl.setParameter("transType", transType);
				editRequestUrl.setParameter("statusHS", statusHS);
				editRequestUrl.setParameter("transactionKeyword", transactionKeyword);
				editRequestUrl.setParameter("idQuyTrinh", String.valueOf(thuTucHanhChinh.getId()));
				
				PortletURL editCompanyRequestUrl = renderResponse.createRenderURL();
				editCompanyRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCompany.jsp");
				editCompanyRequestUrl.setParameter("_searchKeyWord", searchKeyWord);
				editCompanyRequestUrl.setParameter("transType", transType);
				editCompanyRequestUrl.setParameter("statusHS", statusHS);
				editCompanyRequestUrl.setParameter("transactionKeyword", transactionKeyword);
				editCompanyRequestUrl.setParameter("idQuyTrinh", String.valueOf(thuTucHanhChinh.getId()));
				%>
				<td align="center" style="text-align: center;">
				<%
				if (ConvertUtil.checkLoaiDoiTuongCongDan(thuTucHanhChinh.getId(), "003")) {
					%>
					<a href="<%=editCompanyRequestUrl.toString() %>">Nộp hồ sơ doanh nghiệp</a>
					<%
				} else {
					%>
					<a href="<%=editRequestUrl.toString() %>">Nộp hồ sơ công dân</a>
					<%
				}
				%>
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