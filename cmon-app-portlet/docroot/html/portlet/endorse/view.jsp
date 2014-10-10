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
<%@page import="org.oep.cmon.user.portlet.action.UserEndorsePortlet"%>
<%@page import="org.oep.cmon.user.portlet.util.StringUtil"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.csms.model.impl.YeuCauDangKyCongDanImpl"%>
<%@ include file="/html/portlet/endorse/init.jsp" %>
<%@page import="org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type = "text/javascript">
	function submitFormEndorseee(){
		var form = document.searchForm;
		if (form.keyword.value =="<liferay-ui:message key="vn.dtt.cmon.user.form.view.search.defaultValue"/>"){
			form.keyword.value = "";
		}
		form.submit();
	}
	
	function submitFormEndorse2(){
		var form = document.searchForm;
		if ( form.keyword.value =="<liferay-ui:message key="vn.dtt.cmon.user.form.view.search.defaultValue"/>"){
			form.keyword.value = "";
		}
	}
	
</script>
<body>
<%

	 String keyword = ParamUtil.getString(request, "keyword");
	 String reqStatus = ParamUtil.getString(request, "reqStatus");
	 
	 // Get default search value
	 String defaultSearch = LanguageUtil.get(pageContext, "vn.dtt.cmon.user.form.view.search.defaultValue");
	 
	 if ( Validator.isNull (keyword)) {
		 keyword = defaultSearch;
	 }
	 
	 String keywordSearch = "";
	 if (!keyword.equals(defaultSearch)) {
		 keywordSearch = keyword;
	 }
	 
	 
	 PortletURL iteratorUrl = renderResponse.createRenderURL();
	 iteratorUrl.setParameter("keyword", keywordSearch);
	
	
	%>
	<div class="egov-container">
		<%
			if (Validator.isNotNull(request.getAttribute("endorseSuccess"))) {
		%>
			<div class="portlet-msg-success" style="padding-left : 20px;">
		 		Xác thực thành công
		 	 </div>
		<%
			} else if (Validator.isNotNull(request.getAttribute("huySuccess"))) {
		%>
			<div class="portlet-msg-success"  style="padding-left : 20px;">
		 		Hủy đăng ký thành công
		 	 </div>
		<%
			} else if (Validator.isNotNull(request.getAttribute("endorseError"))) {
		%>
			<div style="color: red;">
				Lỗi hệ thống.
			</div>
		<%  } else if (Validator.isNotNull(request.getAttribute("emailDuplicate"))) {%>
			<div style="color: red;">
				Địa chỉ email đã được sử dụng.
			</div>
		<% 	} %>
		<br/>
		<form name = "searchForm" id="searchForm" method = "post" action = "<%=iteratorUrl%>" onsubmit="submitFormEndorse2();">
			<table class = "egov-table-form2" width="100%" border="0">
			  <tr>
			    <td align = "left">		    
			    	<input name="keyword" type="text"  class="egov-inputfield-search" style="width: 80%" size="40" value = "<%=keyword %>" 
			    		onfocus="if(this.value=='<liferay-ui:message key="vn.dtt.cmon.user.form.view.search.defaultValue"/>') this.value='';" onblur="if(this.value=='') this.value='<liferay-ui:message key="vn.dtt.cmon.user.form.view.search.defaultValue"/>'"/>
			    		
			    	<input type="submit" name="button" value=""  class="egov-button-search" style="vertical-align : bottom;" />
			    </td>
			    <td align = "right">
				    <select name="reqStatus" class="egov-select custom" onchange="submitFormEndorseee();">
				        <%			
							String selectedMinus1 = "";
							if ("-1".equals(reqStatus )) {
								selectedMinus1 = "selected";
							}												
							
							String selected0 = "";
							if ("0".equals(reqStatus )) {
								selected0 = "selected";
							}												
							
							String selected1 = "";
							if ("1".equals(reqStatus )) {
								selected1 = "selected";
							}												
							
							String selected2 = "";
							if ("2".equals(reqStatus )) {
								selected2 = "selected";
							}
												
						%>
				        <option value="-1"  <%= selectedMinus1 %> ><liferay-ui:message key="vn.dtt.cmon.user.form.view.filterStatus.defaultValue"/></option>
				        <option value="0" <%=selected0 %> ><liferay-ui:message key="vn.dtt.cmon.user.form.view.filterStatus.new"/></option>
				        <option value="1" <%=selected1 %> ><liferay-ui:message key="vn.dtt.cmon.user.form.view.filterStatus.confirmEmail"/></option>
				        <option value="2" <%=selected2 %> ><liferay-ui:message key="vn.dtt.cmon.user.form.view.filterStatus.endorsed"/></option>        
				    </select>
			    </td>
			  </tr>
			</table>
		
		<table cellpadding="0" cellspacing="0"  class="egov-table" width="100%">
		<tr>
		    <th width="10%" align = "center"><liferay-ui:message key="vn.dtt.cmon.user.form.view.labelCmnd"/></th>
		    <th width="30%" scope="col"><liferay-ui:message key="vn.dtt.cmon.user.form.view.labelHoVaTen"/></th>
		    <th width="25%" scope="col"><liferay-ui:message key="vn.dtt.cmon.user.form.view.labelEmail"/></th>
		    <th width="10%" scope="col"><liferay-ui:message key="vn.dtt.cmon.user.form.view.labelNgayYeuCau"/></th>
		    <th width="13%" scope="col"><liferay-ui:message key="vn.dtt.cmon.user.form.view.labelTrangThai"/></th>
		    <th width="12%" scope="col">Xác thực</th>
		</tr>
	<%
		 if (Validator.isNotNull(reqStatus)) {
			 iteratorUrl.setParameter("reqStatus", reqStatus);
		 }
		 SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
		
		 int reqStatusInt = -1;
		 if (Validator.isNotNull(reqStatus)) {
			 reqStatusInt = Integer.parseInt(reqStatus);
		 }
		 List<YeuCauDangKyCongDan>  result = UserEndorsePortlet.searchUserRequest(keywordSearch, reqStatusInt);
		 
		 if ( result == null ) {
		 	result = new ArrayList<YeuCauDangKyCongDan>();
		 }
		 
		 // Paging
		 List<YeuCauDangKyCongDan> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
		 searchContainer.setTotal(result.size());
		 searchContainer.setResults(newResults);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 DecimalFormat df = new DecimalFormat("0");
		for(int i=0; i< newResults.size(); i++) {											
			YeuCauDangKyCongDan yeuCau = newResults.get(i);	

			int status = yeuCau.getTrangThaiYeuCau();
			
			PortletURL viewRequestUrl = renderResponse.createActionURL();
			viewRequestUrl.setParameter(ActionRequest.ACTION_NAME, "viewUserRequest");											
			viewRequestUrl.setParameter("reqId", String.valueOf(yeuCau.getId()));
			
			String viewUrl = viewRequestUrl.toString();
			
			//if ( status != 2) {
				//viewUrl = viewRequestUrl.toString();
			//}			
	%>
							
		<tr>
			<td style="padding-left: 3px;"><%=yeuCau.getSoCmnd() %></td>
			<td class="bold" align = "left"><a href="<%=viewUrl%>"><%=yeuCau.getHoCongDan() + " " + yeuCau.getTenDem() + " " + yeuCau.getTenCongDan() %></a></td>
			<td align = "left"  style="padding-left: 3px;"><%=yeuCau.getEmail() %></td>
			<td  style="padding-left: 3px;"><%=yeuCau.getNgayYeuCau()==null? "": sdf.format(yeuCau.getNgayYeuCau()) %></td>
			<td  style="padding-left: 3px;">
			<%
				String statusMsg = "";
				if (status == 0) {
					statusMsg = LanguageUtil.get(pageContext, "vn.dtt.cmon.user.form.view.filterStatus.new");
				} else if ( status == 1 ) {
					statusMsg = LanguageUtil.get(pageContext, "vn.dtt.cmon.user.form.view.filterStatus.confirmEmail");
				} else {
					statusMsg = LanguageUtil.get(pageContext, "vn.dtt.cmon.user.form.view.filterStatus.endorsed");
				}						
			%>
			<%=statusMsg %>
			</td>
			
			<td align="center">
				<%
					if (yeuCau.getTrangThaiYeuCau() != StringUtil.TRANG_THAI_YEU_CAU_DK_CONG_DAN_DA_CHUNG_THUC) {
						 
						PortletURL endorseUrl = renderResponse.createActionURL();
						endorseUrl.setParameter(ActionRequest.ACTION_NAME, "endorseInList");
						endorseUrl.setParameter("yeuCauId", String.valueOf(yeuCau.getId()));
						
						PortletURL huyDangKy = renderResponse.createActionURL();
						huyDangKy.setParameter(ActionRequest.ACTION_NAME, "huyDangKy");
						huyDangKy.setParameter("yeuCauId", String.valueOf(yeuCau.getId()));
				%>
					<div style="padding-left: 10px;">
						<button onclick="submitForm('<%=huyDangKy%>', 'Bạn có muốn hủy yêu cầu đăng ký tài khoản này không ?');"  
							title="Hủy đăng ký" class="egov-func-delete" style="vertical-align: top;" ></button>
					
						<a href="#" onclick="submitForm('<%=endorseUrl%>', 'Bạn có muốn xác thực tài khoản này không ?');"  title="Xác thực">
							<span class="icon-13" style="vertical-align: top;" ></span>
						</a>
					</div>
					
				<%  } %>
			</td>
		</tr>
	<%} %>
		</table>
		
		</form>
		
		<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
	</div>
</body>

<script type="text/javascript">
function submitForm(url, confirmText) {
    if(confirm(confirmText)) {
		document.getElementById('searchForm').action = url;
		document.getElementById('searchForm').submit();
    } else {
    	return;
    }
    
}
</script>