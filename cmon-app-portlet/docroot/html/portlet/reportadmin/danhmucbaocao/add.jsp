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
<%@page import="org.oep.cmon.dao.report.service.DanhMucBaoCaoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucBaoCao"%>
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
actionUrl.setParameter(ActionRequest.ACTION_NAME, "addOrEditDanhmucbaocao");
PortletURL backUrl = renderResponse.createRenderURL();
backUrl.setParameter("tab","baocao");
String reportname =request.getParameter("reportname")!=null?request.getParameter("reportname"):"" ;
String url =request.getParameter("url")!=null?request.getParameter("url"):"" ;
String order = request.getParameter("order")!=null?request.getParameter("order"):"" ;
String status = request.getParameter("status")!=null?request.getParameter("status"):"1" ;
String publish = request.getParameter("publish")!=null?request.getParameter("publish"):"0" ;
String id = request.getParameter("id")!=null?request.getParameter("id"):"" ;
DanhMucBaoCao dmBaocao = null;
if(id.trim().length()>0){
	dmBaocao = DanhMucBaoCaoLocalServiceUtil.getDanhMucBaoCao(Long.valueOf(id));
	reportname = dmBaocao.getTENBAOCAO();
	url = dmBaocao.getDUONGDAN();
	order = String.valueOf(dmBaocao.getORDERS());
	status = String.valueOf(dmBaocao.getSTATUS());
	publish = String.valueOf(dmBaocao.getPUBLISH());
	id = String.valueOf(dmBaocao.getID());
}

%>
<div>
	<form action="<%=actionUrl%>" method="post">
	<table>
		<tr>
			<td colspan="2">
				<liferay-ui:error key="emptyTenBaoCao" message="vn.dtt.cmon.reportadmin.dmbaocao.exit.ten"/>
				<liferay-ui:error key="emptyDuongDan" message="vn.dtt.cmon.reportadmin.dmbaocao.exit.duongdan"/>
			</td>
		</tr>
		<tr>
			<td><label class ="egov-label">Tên báo cáo<font color="red">(*)</font></label></td>
			<td><input type="text" name="reportname" maxlength="255" value="<%=reportname%>" class="egov-inputfield"></td>
		</tr>
		<tr>
			<td><label class ="egov-label">Đường dẫn<font color="red">(*)</font></label></td>
			<td><input type="text" name="url" maxlength="255" value="<%=url%>" class="egov-inputfield"></td>
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
			<td><label class ="egov-label">Pulic</label></td>
			<td><input type="checkbox" name="publish" <%=publish.equals("1")?"checked":""%> class="egov-checkbox"></td>
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
