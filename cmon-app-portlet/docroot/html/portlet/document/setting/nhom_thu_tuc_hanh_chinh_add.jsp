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
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
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
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddNhomTTHCRequest");

String formGroup = ParamUtil.getString(request, "formGroup", "");

String actionTyPe= ParamUtil.getString(request, "ActionType");
String nTTHCId= ParamUtil.getString(request, "nTTHCId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (nTTHCId)) {
	nTTHCId = "";
}
NhomThuTucHanhChinh nTTHC = null;
if (nTTHCId.trim().length() > 0) {
	nTTHC = NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(FormatUtil.convertToLong(nTTHCId));
}
%>
<div class="egov-container">
	<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<form id="<portlet:namespace/>nTTHCForm" name="<portlet:namespace/>nTTHCForm" method="post" action="<%=actionUrl.toString() %>">
<table align="center" border="0" class="egov-table-form">
	<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header">Quản lý nhóm thủ tục hành chính</label>
			<br><br>	
		</td>
	</tr>
	<tr>
	<td colspan="6">
			<select style="display: none;" id="egov-form-errors">
				<option value="maNTTHC"><liferay-ui:error key="existMaNTTHC" message = "org.oep.cmon.document.setting.ntthc.form.exist.ma"/></option>
				<option value="maNTTHC"><liferay-ui:error key="emptyMaNTTHC" message = "org.oep.cmon.document.setting.ntthc.form.empty.ma"/></option>
				<option value="tenNTTHC"><liferay-ui:error key="existTenNTTHC" message = "org.oep.cmon.document.setting.ntthc.form.exist.ten"/></option>
				<option value="tenNTTHC"><liferay-ui:error key="emptyTenNTTHC" message = "org.oep.cmon.document.setting.ntthc.form.empty.ten"/></option>
			</select>
				<liferay-ui:error key="errorAddNTTHC" message = "org.oep.cmon.document.setting.ntthc.form.error.add"/>
				<liferay-ui:error key="errorUpdateNTTHC" message = "org.oep.cmon.document.setting.ntthc.form.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateNTTHC") != null && ParamUtil.getString(request, "CompletedUpdateNTTHC").trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateNTTHC" message="org.oep.cmon.document.setting.ntthc.form.completed.update"/>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddNTTHC") != null && ParamUtil.getString(request, "CompletedAddNTTHC").trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddNTTHC" message="org.oep.cmon.document.setting.ntthc.form.completed.add"/>
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<%
				if (formGroup != null) {
				%>
					<input type="hidden" name = "formGroup" id = "formGroup" value = "<%=formGroup%>"/>
				<%} %>
				<input type="hidden" name = "nTTHCId" id = "nTTHCId" value = "<%=nTTHCId%>"/>
			  </td>	
		</tr>
		<tr>		
		<td colspan="2"><label class="egov-label-bold">Ứng dụng</label></td>
			<td colspan="3"> 
				<%
		      		if (actionTyPe.compareTo(ThuTucHanhChinhBusiness.VIEW_NHOM_TTHC) == 0) {
		      			%>
		      			<select id="DanhMucUDId" name="DanhMucUDId" class="egov-select" disabled="disabled" style="width: 71%">
		      			<%
		      		} else {
		      			%>
		      			<select id="DanhMucUDId" name="DanhMucUDId" class="egov-select" style="width: 71%">
		      			<%
		      		}
		      		List<DanhMucUngDung> ungDungList = DanhMucUngDungLocalServiceUtil.getDSUngDung(0);
		      		for (DanhMucUngDung dmUngDung : ungDungList) {
		      			if (nTTHC == null) {
			      			%>
			      			<option value="<%=dmUngDung.getId() %>" <%=ThuTucHanhChinhBusiness.checkSelectedValue(ParamUtil.getString(request, "DanhMucUDId"), dmUngDung.getId())%>><%=dmUngDung.getTen() %></option>
			      			<%
		      			} else {
		      				%>
			      			<option value="<%=dmUngDung.getId() %>" <%=ThuTucHanhChinhBusiness.checkSelectedValue(String.valueOf(nTTHC.getDanhMucUngDungId()), dmUngDung.getId())%>><%=dmUngDung.getTen() %></option>
			      			<%
		      			}
		      		}
		      		%>
		      		</select>	
			</td>
			</tr>
			<tr>
				<td colspan="2"><label class="egov-label-bold">Tên nhóm thủ tục hành chính </label>(<label
					class="egov-label-red">*</label>)</td>
				<td  colspan="2"><input name="tenNTTHC" type="text"					
					<%=ThuTucHanhChinhBusiness.checkNTTHCReadOnly(actionTyPe)%>
					id="tenNTTHC" maxlength="250" class="egov-inputfield"
					value="<%=ThuTucHanhChinhBusiness.checkNTTHCDataReturn(nTTHC,
					ParamUtil.getString(request, "tenNTTHC"), 1)%>" />
				</td>
			</tr>
			<tr >
				<td colspan="2"><label class="egov-label-bold">Mã nhóm thủ tục hành chính </label>(<label
					class="egov-label-red">*</label>)</td>
				<td><input name="maNTTHC" type="text"
					<%=ThuTucHanhChinhBusiness.checkNTTHCReadOnly(actionTyPe)%>
					id="maNTTHC" maxlength="5" class="egov-inputfield"
					value="<%=ThuTucHanhChinhBusiness.checkNTTHCDataReturn(nTTHC,
					ParamUtil.getString(request, "maNTTHC"), 3)%>" />
				</td>
				</tr>
		      <tr>
		      <td colspan="2">
		      		<label class ="egov-label-bold">Trạng thái</label>
		      </td>
		      <td>
		      		<%
		      		if (actionTyPe.compareTo(ThuTucHanhChinhBusiness.VIEW_NHOM_TTHC) == 0) {
		      			%>
		      			<select id="trangThaiNTTHC" name="trangThaiNTTHC" class="egov-select" disabled="disabled">
		      			<%
		      		} else {
		      			%>
		      			<select id="trangThaiNTTHC" name="trangThaiNTTHC" class="egov-select">
		      			<%
		      		}
		      		%>
		      			<option <%=ThuTucHanhChinhBusiness.checkNTTHCStatuSelected(nTTHC, ParamUtil.getString(request, "trangThaiNTTHC"), "0") %> value = "0">Hoạt động</option>
		      			<option <%=ThuTucHanhChinhBusiness.checkNTTHCStatuSelected(nTTHC, ParamUtil.getString(request, "trangThaiNTTHC"), "1") %> value = "1">Khóa</option>
		      		</select>
		      </td>
		    </tr>	
			<tr>
				<td align="left" colspan="2"></td>
				<td align="left">
					<%
						// Create upload avatar URL
						PortletURL backUrl = renderResponse.createRenderURL();
						backUrl.setParameter("jspPage",
								"/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_list.jsp");
						if (formGroup != null) {
							backUrl.setParameter("formGroup", formGroup);
						}
						if (actionTyPe.compareTo(ThuTucHanhChinhBusiness.VIEW_NHOM_TTHC) != 0) {
						%> 
						<span><input type="submit" class="egov-button-normal"
						name="submitButton" value="Lưu lại" /></span> 
						<%
						 	}
						%> 				
 						<span style="padding-left: 10px;"><a
						href="<%=backUrl.toString()%>"><input type="button"
							name="backUrl" class="egov-button-normal" value="Quay lại" /></a></span>
				</td>
			</tr>
	</tbody>
</table>
</form>
</div>
