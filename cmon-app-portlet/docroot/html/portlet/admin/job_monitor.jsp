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
<%@page import="org.oep.cmon.dao.job.service.TrangThaiJobLocalServiceUtil"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.oep.cmon.dao.job.model.TrangThaiJob"%>
<%@page import="org.oep.cmon.dao.job.service.DanhSachJobLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.job.model.DanhSachJob"%>
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
		var form = document.searchForm;
		
		if ( form.keyWord.value =="Hãy nhập Job Id..."){
			form.keyWord.value = "";
		} 		
	};
</script>
<%	
	List<DanhSachJob> danhSachJobLst = DanhSachJobLocalServiceUtil.getDanhSachJobs(0, DanhSachJobLocalServiceUtil.getDanhSachJobsCount());	 
%>
	<div class="egov-container">
	<label><b>> Danh sách Job</b></label>
	<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th width = "5%">Job ID</th>
		    <th scope="col" width = "12%">Tên Job</th>
		    <th scope="col" width = "12%">Job class</th>		    
		    <th scope="col" width = "15%">Mô tả Job</th>		    
		    <th scope="col" width = "6%">Hành động</th>
		</tr>
		<%
			for (int i = 0; i< danhSachJobLst.size(); i++) {
				DanhSachJob danhSachJob = danhSachJobLst.get(i);
				
				PortletURL runJobUrl = renderResponse.createActionURL();
				runJobUrl.setParameter(ActionRequest.ACTION_NAME, "runJob");
				runJobUrl.setParameter("id", String.valueOf(danhSachJob.getID()));							
					
		%>
			<tr>
				<td align = "center"><%=danhSachJob.getJobId() %></td>
				<td align = "left"><%=danhSachJob.getJobName() %></td>
				<td align = "left"><%=danhSachJob.getJobClass() %></td>				
				<td align = "left"><%=danhSachJob.getDescription()%></td>
				<td align = "center"><a href = "<%=runJobUrl%>">Run Job</a></td>				
			</tr>
		<%} %>
	</table>
	<br/>
	<%

	PortletURL searchJobStatusUrl = renderResponse.createActionURL();
	searchJobStatusUrl.setParameter(ActionRequest.ACTION_NAME, "searchJobStatus");
	  
	String keyWord = ParamUtil.getString(request, "keyWord");
	if (keyWord.trim().compareTo("0") == 0) {
		keyWord = "";
	}
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/admin/job_monitor.jsp");
	
	 
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	
	// Get the search result from session if it exists
	int totals = 0;
	List<TrangThaiJob>  result = null;
	if (request.getAttribute("SEARCH_TRANGTHAI_JOB_RESULT") != null) {
		result = (List<TrangThaiJob>)request.getAttribute("SEARCH_TRANGTHAI_JOB_RESULT");
		totals = result.size();
	}
	 
	if ( result == null ) {
		result = TrangThaiJobLocalServiceUtil.getTrangThaiJobs(searchContainer.getStart(), searchContainer.getEnd());
		totals = TrangThaiJobLocalServiceUtil.getTrangThaiJobsCount();
	}
	// Paging
	List<TrangThaiJob> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	 
	searchContainer.setTotal(totals);
	 
	searchContainer.setResults(newResults);
	
	%>
	<label class = "egov-label"><b>> Trạng thái chạy Job</b></label>
	<form name = "searchForm" method = "post" action = "<%=searchJobStatusUrl%>" onsubmit = "checkForm()">
		<table width="100%" border="0">
		  <tr>
		    <td align = "left">
		    	<input name="keyWord" type="text"  class="egov-inputfield-search" size="40" value = "<%=keyWord.trim() %>" onfocus="if(this.value=='Hãy nhập Job Id...') this.value='';" onblur="if(this.value=='') this.value='Hãy nhập Job Id...'"/>
			    	<input type="submit" name="button" value=""  class="egov-button-search" />				    		    			    			    	
		    </td>
		    <td align = "right">				    
		    </td>
		  </tr>
		</table>
	</form>	
	<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th width = "5%">Job ID</th>		    
		    <th scope="col" width = "20%">Tên Job</th>
		    <th scope="col" width = "14%">Bắt đầu</th>		    
		    <th scope="col" width = "14%">Kết thúc</th>
		    <th scope="col" width = "7%">Trạng thái</th>
		    <th scope="col" width = "10%">Chế độ</th>
		    <th scope="col">Message</th>
		</tr>
		<%
			DateFormat dfFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
			for (int i = 0; i< newResults.size(); i++) {
				TrangThaiJob trangThaiJob = newResults.get(i);			
		%>
			<tr>
				<td align = "left"><%=trangThaiJob.getJobId() %></td>
				<td align = "left"><%=trangThaiJob.getJobName() %></td>
				<td align = "left"><%=ConvertUtil.parseDateToTring(trangThaiJob.getStartTime())%></td>
				<td align = "left"><%=ConvertUtil.parseDateToTring(trangThaiJob.getEndTime())%></td>
				<%
					String status = "";
					if (trangThaiJob.getStatus() == 0) {
						status = "Success";
					} else {
						status = "Failure";
					}
				%>
				<td align = "center"><%=status%></td>
				<%
					String runMode = "";
					if (trangThaiJob.getRunMode() == 0) {
						runMode = "Scheduled";
					} else {
						runMode = "Manual";
					}
				%>
				<td align = "center"><%=runMode%></td>
				<td align = "left"><%=trangThaiJob.getMessage()%></td>					
			</tr>
		<%} %>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</div>

