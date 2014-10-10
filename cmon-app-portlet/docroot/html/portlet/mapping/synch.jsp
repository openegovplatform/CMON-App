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
<%@page import="org.oep.cmon.portlet.mapping.utils.SynchThread"%>
<%@page import="org.oep.cmon.dao.thamso.model.AnhXaClp"%>
<%@page import="org.oep.cmon.portlet.mapping.action.MappingPortlet"%>
<%@page import="org.oep.cmon.portlet.mapping.utils.Constaints"%>
<%@page import="org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.thamso.model.AnhXa"%>
<%@page import="org.oep.cmon.portlet.thamso.action.ThamSoPortlet"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.portlet.thamso.util.ThamSoConstants"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.thamso.business.ThamSoBusiness"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.thamso.model.ThamSo"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/html/portlet/mapping/view.jsp");

PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "synchronize");

Long appid = ParamUtil.getLong(request, "appid",0L);
String table = ParamUtil.getString(request, "table","");

%>
<div class="egov-container">
<%
	if(SynchThread.running){
		%>
			<h2 style="text-decoration: blink;color: blue;text-align: center;">
				<liferay-ui:message key="org.oep.cmon.anhxa.synch.running"/>
			</h2>
			<br>
			 <span style="padding-left: 10px;">
 					<a
						href="<%=backURL.toString()%>">
						<input type="button"	name="backUrl" 
							class="egov-button-normal" value="Quay lại danh sách" />
					</a>
		 </span>
<%
	}else{
%>
<form id="<portlet:namespace/>thamSoForm" name="<portlet:namespace/>thamSoForm" method="post" action="<%=actionUrl.toString() %>">

<liferay-ui:success key="<%=Constaints.SYNCH_RUNNING%>" message = "org.oep.cmon.anhxa.synch.running"/>
<input type="hidden" name="overwrite" id="overwriteid" value="false"/>


<select style="display: none;" id="egov-form-errors">
	<option value="tableid">
		<liferay-ui:error key="<%=Constaints.Errors.BANG_DNG_ISNULL%>" message = "org.oep.cmon.anhxa.error.table.empty"/>
	</option>
	<option value="appid">
		<liferay-ui:error key="<%=Constaints.Errors.UNGDUNG_DNG_ISNULL%>" message = "org.oep.cmon.anhxa.error.app.empty"/>
	</option>
	
</select>
<table align="center" border="0" class="egov-table-form">

		<tr>
			<td colspan="6" align="center">
			<br>
				<label class="egov-label-header">Quản lý đồng bộ hệ thống</label>
			<br><br>	
			</td>
		</tr>
		  
		  
		   
		      <tr>
		      <td colspan="3">
		      	<label class ="egov-label-bold">Ứng dụng</label><br>
		      	<select id="appid" name=appid class="egov-select" >
			      		<option value="">--Theo ứng dụng--</option>	 
			      		<%
			      		List<DanhMucUngDung> uList = ThamSoBusiness.getUngDungList();
				      		if(uList != null){
				      		for (DanhMucUngDung ungDung : uList) {
					      			%>
					      			<option value="<%=ungDung.getId() %>" 
					      				<%=ThamSoBusiness.checkSelectedValue(ungDung.getId(),appid)%>>
					      					<%=ungDung.getTen() %>
					      			</option>
					      			<%
				      		}
			      		}
			      		%>
		      		</select>	
		      		
		      		
		      </td>
		      <td colspan="3">
		      <label class ="egov-label-bold">Bảng hệ thống</label><br>
		      
	      	   <select id="tableid" name="table" class="egov-select">
	      			<option value="">--Theo bảng-</option>	 
		      		<%
		      		List<String> tList = AnhXaLocalServiceUtil.getDSBang();
		      		if(tList != null){
		      		for (String bang : tList) {
			      			%>
			      			<option value="<%=bang %>"
			      					<%=ThamSoBusiness.checkSelectedValue(bang,table)%>>
			      				<%=bang %>
			      			</option>
			      			<%
		      		}
		      		}
		      		%>
	      		</select>	
		      		
		      </td>
		    </tr>	
		   
		    	   
			<tr>
				
				<td align="left" colspan="2">
					 <span>
					 <input type="button" class="egov-button-normal" onclick="synchronizeDNG('false');"
						name="submitButton" value="Chỉ động bổ bản ghi mới" />
					</span>
					 <span>
					 <input type="button" class="egov-button-normal" onclick="synchronizeDNG('true');"
						name="submitButton" value="Đồng bộ lại tất cả" />
					</span>  
						
				 <span style="padding-left: 10px;">
 					<a
						href="<%=backURL.toString()%>">
						<input type="button"	name="backUrl" 
							class="egov-button-normal" value="Quay lại danh sách" />
					</a>
		</span>
		<br>
				</td>
			</tr>

		</table>
</form>
<%} %>
</div>

<script type="text/javascript">

 function synchronizeDNG(overwrite){
	 document.getElementById("overwriteid").value=overwrite;
	 if(confirm("Bạn chắc chắn muốn đồng bộ dữ liệu chứ ?")){
		document.getElementById('<portlet:namespace/>thamSoForm').submit();
	 }
	}
</script>