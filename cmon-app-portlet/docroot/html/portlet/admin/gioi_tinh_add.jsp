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
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.admin.portlet.business.GioiTinhBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddGioiTinhRequest");

String actionTyPe= ParamUtil.getString(request, "ActionType");
String gioiTinhId= ParamUtil.getString(request, "gioiTinhId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
GioiTinh GioiTinh = null;
if (gioiTinhId.trim().length() > 0) {
	GioiTinh = GioiTinhLocalServiceUtil.fetchGioiTinh(ConvertUtil.convertToLong(gioiTinhId));
}
%>

<div class="wd-main-content">	
		<form id="gioiTinhForm" name="gioiTinhForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">		      	
				<liferay-ui:error key="exitMaGioiTinh" message = "vn.dtt.cmon.admin.gioitinh.exit.ma"/>
				<liferay-ui:error key="exitTenGioiTinh" message = "vn.dtt.cmon.admin.gioitinh.exit.ten"/>
				<liferay-ui:error key="emptyMaGioiTinh" message = "vn.dtt.cmon.admin.gioitinh.empty.ma"/>
				<liferay-ui:error key="emptyTenGioiTinh" message = "vn.dtt.cmon.admin.gioitinh.empty.ten"/>
				<liferay-ui:error key="errorAddGioiTinh" message = "vn.dtt.cmon.admin.gioitinh.error.add"/>
				<liferay-ui:error key="errorUpdateGioiTinh" message = "vn.dtt.cmon.admin.gioitinh.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateGioiTinh") != null && ParamUtil.getString(request, "CompletedUpdateGioiTinh").trim().length() > 0) {
					%>
				<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.gioitinh.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddGioiTinh") != null && ParamUtil.getString(request, "CompletedAddGioiTinh").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.gioitinh.completed.add"/>
					</font>					
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<input type="hidden" name = "gioiTinhId" id = "gioiTinhId" value = "<%=gioiTinhId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã giới tính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maGioiTinh" type="text" <%=GioiTinhBusiness.checkReadOnly(actionTyPe) %> id="maGioiTinh" maxlength="10" class = "egov-inputfield" value = "<%=GioiTinhBusiness.checkDataReturn(GioiTinh, ParamUtil.getString(request, "maGioiTinh"), 2)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên giới tính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenGioiTinh" type="text"  <%=GioiTinhBusiness.checkReadOnly(actionTyPe) %> id="tenGioiTinh" maxlength="20" class = "egov-inputfield" value = "<%=GioiTinhBusiness.checkDataReturn(GioiTinh, ParamUtil.getString(request, "tenGioiTinh"), 1)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(GioiTinhBusiness.VIEW_GIOI_TINH) != 0) {
		    %>
		    <tr>
		    	<td align = "left">
		    	</td>
		      	<td align = "left">
		      		<input type="submit" class = "egov-button" name="submitButton"  value="Cập nhật" />
		      	</td>
		    </tr>
		    <%
		    	} 
		    %>
		     <tr>
		      <td colspan="2" align = "left">
		      	<%			
				// Create upload avatar URL
				PortletURL backUrl = renderResponse.createRenderURL();	
		      	backUrl.setParameter("jspPage","/html/portlet/admin/gioi_tinh_list.jsp");
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh sách giới tính">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
