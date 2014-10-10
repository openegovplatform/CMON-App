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
<%@page import="org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucRole"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/init.jsp"%>
<portlet:defineObjects />
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "addOrEditDanhmucrole");
PortletURL backUrl = renderResponse.createRenderURL();
backUrl.setParameter("tab","vaitro");
String name =request.getParameter("name")!=null?request.getParameter("name"):"" ;
String order = request.getParameter("order")!=null?request.getParameter("order"):"" ;
String status = request.getParameter("status")!=null?request.getParameter("status"):"1" ;
String id = request.getParameter("id")!=null?request.getParameter("id"):"" ;
DanhMucRole dmRole = null;
if(id.trim().length()>0){
	dmRole = DanhMucRoleLocalServiceUtil.getDanhMucRole(Long.valueOf(id));
	name = dmRole.getNAME();
	order = String.valueOf(dmRole.getORDERS());
	status = String.valueOf(dmRole.getSTATUS());
	id = String.valueOf(dmRole.getID());
}

%>
<div>
	<form action="<%=actionUrl%>" method="post">
	<table>
		<tr>
			<td colspan="2">
				<liferay-ui:error key="emptyTenRole" message="vn.dtt.cmon.reportadmin.dmrole.exit.ten"/>
			</td>
		</tr>
		<tr>
			<td><label class ="egov-label">Tên<font color="red">(*)</font></label></td>
			<td><input type="text" name="name" maxlength="255" value="<%=name%>" class="egov-inputfield"></td>
		</tr>
		<tr>
			<td><label class ="egov-label">Sắp xếp</label></td>
			<td><input type="text" name="order" value="<%=order%>" class="egov-inputfield" size="10"></td>
		</tr>
		<tr>
			<td><label class ="egov-label">Sử dụng</label></td>
			<td><input type="checkbox" name="status" <%=status.equals("1")?"checked":""%> class="egov-checkbox"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center">
			<input type="hidden" name="id" value="<%=id%>">
			<input type="submit" value="Lưu" class="egov-button"/>
			<input type="button" value="Quay lại" class="egov-button" onclick="javascript: window.location='<%=backUrl.toString()%>'"/>
			</td>
		</tr>
	</table>
	</form>
</div>
