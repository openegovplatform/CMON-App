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
<%@page import="org.oep.cmon.portlet.document.action.ThuTucHanhChinhPortlet"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
ThuTucHanhChinhPortlet portlet =new ThuTucHanhChinhPortlet();
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddUngDungRequest");
portlet.setSearchParameter(actionUrl, renderRequest);

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String ungDungId= ParamUtil.getString(request, "ungDungId");

//Create upload avatar URL
PortletURL backUrl = renderResponse.createRenderURL();
backUrl.setParameter("jspPage",
		"/html/portlet/document/setting/ung_dung_list.jsp");
if (keyWord != null) {
	backUrl.setParameter("searchKeyWord", keyWord);
}
portlet.setSearchParameter(backUrl, renderRequest);


if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (ungDungId)) {
	ungDungId = "";
}
DanhMucUngDung ungDung = null;
if (ungDungId.trim().length() > 0) {
	ungDung = DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(FormatUtil.convertToLong(ungDungId));
}
%>
<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<form id="<portlet:namespace/>ungDungForm" name="<portlet:namespace/>ungDungForm" method="post" action="<%=actionUrl.toString() %>">
<table align="center" border="0" class="egov-table-form">
	<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header">Quản lý danh mục ứng dụng</label>
		<br><br>	
		</td>
	</tr>
		    <tr>
		      <td colspan="2" align = "left">	
		      <select style="display: none;" id="egov-form-errors">
		      	<option value="maUngDung"><liferay-ui:error key="existMaUngDung" message = "vn.dtt.cmon.document.setting.dmud.form.exist.ma"/></option>
				<option value="maUngDung"><liferay-ui:error key="emptyMaUngDung" message = "vn.dtt.cmon.document.setting.dmud.form.empty.ma"/></option>
				<option value="tenUngDung"><liferay-ui:error key="existTenUngDung" message = "vn.dtt.cmon.document.setting.dmud.form.exist.ten"/></option>
				<option value="tenUngDung"><liferay-ui:error key="emptyTenUngDung" message = "vn.dtt.cmon.document.setting.dmud.form.empty.ten"/></option>
			</select>
				<liferay-ui:error key="errorAddUngDung" message = "vn.dtt.cmon.document.setting.dmud.form.error.add"/>
				<liferay-ui:error key="errorUpdateUngDung" message = "vn.dtt.cmon.document.setting.dmud.form.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateUngDung") != null && ParamUtil.getString(request, "CompletedUpdateUngDung").trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateUngDung" message="vn.dtt.cmon.document.setting.dmud.form.completed.update"/>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddUngDung") != null && ParamUtil.getString(request, "CompletedAddUngDung").trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddUngDung" message="vn.dtt.cmon.document.setting.dmud.form.completed.add"/>
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<%
				if (keyWord != null) {
				%>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
				<input type="hidden" name = "ungDungId" id = "ungDungId" value = "<%=ungDungId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class="egov-label-bold">Tên ứng dụng </label>(<label class="egov-label-red">*</label>)
		      </td>
		      <td style="width: 300px;">
		      		<input name="tenUngDung" type="text" <%=ThuTucHanhChinhBusiness.checkUDReadOnly(actionTyPe) %> id="tenUngDung" maxlength="250" class = "egov-inputfield" value = "<%=ThuTucHanhChinhBusiness.checkDataReturn(ungDung, ParamUtil.getString(request, "tenUngDung"), 1)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class="egov-label-bold">Mã ứng dụng </label>(<label class="egov-label-red">*</label>)
		      </td>
		      <td>
		      		<input name="maUngDung" type="text" <%=ThuTucHanhChinhBusiness.checkUDReadOnly(actionTyPe) %> id="maUngDung" maxlength="5" class = "egov-inputfield" value = "<%=ThuTucHanhChinhBusiness.checkDataReturn(ungDung, ParamUtil.getString(request, "maUngDung"), 3)%>"/>
		      </td>
		    </tr>		    
		      <tr>
		      <td>
		      		<label class ="egov-label-bold">Trạng thái</label>
		      </td>
		      <td>
		      		<%
		      		if (actionTyPe.compareTo(ThuTucHanhChinhBusiness.VIEW_UNG_DUNG) == 0) {
		      			%>
		      			<select id="trangThaiUngDung" name="trangThaiUngDung" class="egov-select" disabled="disabled">
		      			<%
		      		} else {
		      			%>
		      			<select id="trangThaiUngDung" name="trangThaiUngDung" class="egov-select">
		      			<%
		      		}
		      		%>
		      			<option <%=ThuTucHanhChinhBusiness.checkSelected(ungDung, ParamUtil.getString(request, "trangThaiUngDung"), "0") %> value = "0">Hoạt động</option>
		      			<option <%=ThuTucHanhChinhBusiness.checkSelected(ungDung, ParamUtil.getString(request, "trangThaiUngDung"), "1") %> value = "1">Khóa</option>
		      		</select>
		      </td>
		    </tr>		   
			<tr>
				<td align="left"></td>
				<td align="left" colspan="2">
						<%

						if (actionTyPe.compareTo(ThuTucHanhChinhBusiness.VIEW_UNG_DUNG) != 0) {
						%> 
					<span><input type="submit" class="egov-button-normal"
						name="submitButton" value="Lưu lại" /></span> <%
					 	}
					 %> 				
 					<span style="padding-left: 10px;">
 					<a
						href="<%=backUrl.toString()%>">
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
