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
actionUrl.setParameter(ActionRequest.ACTION_NAME, "save");
actionUrl.setParameter(Constaints.ACTION_SAVE, Constaints.ACTION_SAVE);

String action = ParamUtil.getString(request, Constaints.ACTION_SAVE,null);
String error = ParamUtil.getString(request, Constaints.ACTION_ERRORS,null);
long anhxaid= ParamUtil.getLong(request, "anhxaid",0L);
AnhXa anhXa = new AnhXaClp();

if(error != null 
    && action != null 
	&& action.equals(Constaints.ACTION_SAVE)
	&& !SessionMessages.contains(request, Constaints.ACTION_SUCCESS)){
	anhXa = (AnhXa)request.getAttribute(AnhXa.class.getName());
}else if (anhxaid > 0) {
	anhXa = AnhXaLocalServiceUtil.fetchAnhXa(anhxaid);
} 

%>
<div class="egov-container">
<form id="<portlet:namespace/>thamSoForm" name="<portlet:namespace/>thamSoForm" method="post" action="<%=actionUrl.toString() %>">

<input type="hidden" value="<%=anhxaid%>" name="anhxaid">
<liferay-ui:success key="<%=Constaints.ACTION_SUCCESS%>" message = "vn.dtt.cmon.anhxa.success"/>
<liferay-ui:error key="<%=Constaints.Errors.SYSTEM%>" message = "vn.dtt.cmon.anhxa.error.id.incre"/>

<select style="display: none;" id="egov-form-errors">
	
	<option value="tendngid">
		<liferay-ui:error key="<%=Constaints.Errors.TEN_DNG_ISNULL%>" message = "vn.dtt.cmon.anhxa.error.tendng.empty"/>
	</option>
	<option value="madngid">
		<liferay-ui:error key="<%=Constaints.Errors.MA_DNG_ISNULL%>" message = "vn.dtt.cmon.anhxa.error.madng.empty"/>
	</option>
	<option value="tenkhacid">
		<liferay-ui:error key="<%=Constaints.Errors.TEN_KHAC_ISNULL%>" message = "vn.dtt.cmon.anhxa.error.tenkhac.empty"/>
	</option>
	<option value="makhacid">
		<liferay-ui:error key="<%=Constaints.Errors.MA_KHAC_ISNULL%>" message = "vn.dtt.cmon.anhxa.error.makhac.empty"/>
	</option>
	<option value="tableid">
		<liferay-ui:error key="<%=Constaints.Errors.BANG_DNG_ISNULL%>" message = "vn.dtt.cmon.anhxa.error.table.empty"/>
	</option>
	<option value="appid">
		<liferay-ui:error key="<%=Constaints.Errors.UNGDUNG_DNG_ISNULL%>" message = "vn.dtt.cmon.anhxa.error.app.empty"/>
	</option>
	
</select>
<table align="center" border="0" class="egov-table-form">

		<tr>
			<td colspan="6" align="center">
			<br>
				<label class="egov-label-header">Quản lý cấu hình ánh xạ hệ thống với hệ thống khác</label>
			<br><br>	
			</td>
		</tr>
		    <tr>
		      <td colspan="4">
		      		<label class="egov-label-bold">Tên hệ thống</label>(<label class="egov-label-red">*</label>)<br>
		      		<input name="tendng" type="text" style="width: 96%;"
		      		id="tendngid" maxlength="250" class = "egov-inputfield" 
		      		value = "<%= Constaints.getValue(anhXa.getTenDNG())%>"/>
		      </td>
		      <td colspan="2">
		      	<label class ="egov-label-bold">Mã hệ thống</label>
		      	(<label class="egov-label-red">*</label>)<br>
		      	
		      		<input name="madng" type="text" style="width: 50%;"
		      		id="madngid" maxlength="50" class = "egov-inputfield" 
		      		value = "<%= Constaints.getValue(anhXa.getMaDNG())%>"/>	
		      	
		      </td>
		    </tr>
		    
		     <tr>
		      <td colspan="4">
		      		<label class="egov-label-bold">Tên hệ thống khác</label>(<label class="egov-label-red">*</label>)<br>
		      		<input name="tenkhac" type="text" style="width: 96%;"
		      		id="tenkhacid" maxlength="250" class = "egov-inputfield" 
		      		value = "<%= Constaints.getValue(anhXa.getTenKhac())%>"/>
		      </td>
		      <td colspan="2">
		      	<label class ="egov-label-bold">Mã hệ thống khác</label>
		      	(<label class="egov-label-red">*</label>)<br>
		      	
		      		<input name="makhac" type="text" style="width: 50%;"
		      		id="makhacid" maxlength="50" class = "egov-inputfield" 
		      		value = "<%= Constaints.getValue(anhXa.getMaKhac())%>"/>	
		      	
		      </td>
		    </tr>
		  
		  
		   
		      <tr>
		      <td colspan="3">
		      	<label class ="egov-label-bold">Ứng dụng</label><br>
		      	<select id="appid" name=appid class="egov-select" style="width: 99%;">
			      		<option value="">--Theo ứng dụng--</option>	 
			      		<%
			      		List<DanhMucUngDung> uList = ThamSoBusiness.getUngDungList();
				      		if(uList != null){
				      		for (DanhMucUngDung ungDung : uList) {
					      			%>
					      			<option value="<%=ungDung.getId() %>" 
					      				<%=ThamSoBusiness.checkSelectedValue(ungDung.getId(), anhXa.getUngDungId())%>>
					      					<%=ungDung.getTen() %>
					      			</option>
					      			<%
				      		}
			      		}
			      		%>
		      		</select>	
		      		
		      		
		      </td>
		      <td colspan="3">
		      <label class ="egov-label-bold">Hệ thống</label><br>
		      
	      	   <select id="tableid" name="table" class="egov-select" style="width: 71%;">
	      			<option value="">--Theo bảng-</option>	 
		      		<%
		      		List<String> tList = AnhXaLocalServiceUtil.getDSBang();
		      		if(tList != null){
		      		for (String bang : tList) {
			      			%>
			      			<option value="<%=bang %>"
			      			<%=ThamSoBusiness.checkSelectedValue(bang, anhXa.getTenBang())%>>
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
				<td align="left"></td>
				<td align="left" colspan="2">
					 <span><input type="submit" class="egov-button-normal"
						name="submitButton" value="Lưu lại" /></span> 
						
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
</div>