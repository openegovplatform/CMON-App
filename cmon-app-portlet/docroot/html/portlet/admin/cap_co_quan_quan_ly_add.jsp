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
<%@page import="org.oep.cmon.dao.qlhc.model.impl.CapCoQuanQuanLyImpl"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
</script>
<%
	 PortletURL capCoQuanQuanLyUrl = renderResponse.createRenderURL();
	 capCoQuanQuanLyUrl.setParameter("jspPage","/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
	 
	 String capCoQuanQuanLyId = ParamUtil.getString(request, "capCoQuanQuanLyId");
	 String actionName = ParamUtil.getString(request, "actionName");
	 String parentId = ParamUtil.getString(request, "parentId");
	 	 
	 PortletURL actionUrl = renderResponse.createActionURL();
	 CapCoQuanQuanLy capCoQuanQuanLy = new CapCoQuanQuanLyImpl();
	 if (!"".equals(actionName) && actionName != null) {
		if ("edit".equals(actionName)) {
			actionUrl.setParameter(ActionRequest.ACTION_NAME, "updateCapCoQuanQuanLy");
			if (capCoQuanQuanLyId != null && capCoQuanQuanLyId.trim().length() > 0) {
				 capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(ConvertUtil.convertToLong(capCoQuanQuanLyId));
			 } else {
				 capCoQuanQuanLy = new CapCoQuanQuanLyImpl();
			 }
		} else if ("add".equals(actionName)) {
			actionUrl.setParameter(ActionRequest.ACTION_NAME, "addCapCoQuanQuanLy");
			capCoQuanQuanLy = new CapCoQuanQuanLyImpl();
		} else if ("new".equals(actionName)) {
			actionUrl.setParameter(ActionRequest.ACTION_NAME, "addCapCoQuanQuanLy");
			capCoQuanQuanLy = new CapCoQuanQuanLyImpl();
		}
	 }
	 
%>
<div class="wd-main-content">	
		<form id="capCoQuanQuanLyForm" name="capCoQuanQuanLyForm" method="post" action="<%=actionUrl%>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">	
		      	<liferay-ui:error key="existMaCapCoQuanQuanLy" message="Mã cấp cơ quan quản lý đã tồn tại"/>
				<liferay-ui:error key="existTenCapCoQuanQuanLy" message="Tên cấp cơ quan quản lý đã tồn tại"/>
				<liferay-ui:error key="emptyMaCapCoQuanQuanLy" message="Hãy nhập Mã cấp cơ quản quản lý"/>
				<liferay-ui:error key="emptyTenCapCoQuanQuanLy" message="Hãy nhập Tên cấp cơ quản quản lý"/>
				<liferay-ui:error key="errorAddCapCoQuanQuanLy" message="Lỗi xảy ra trong khi thêm mới Cấp cơ quan quản lý"/>
				<liferay-ui:error key="errorUpdateCapCoQuanQuanLy" message="Lỗi xảy ra trong khi sửa đổi Cấp cơ quan quản lý"/>
				      	
				<input type="hidden" name="capCoQuanQuanLyId" id = "capCoQuanQuanLyId" value = "<%=capCoQuanQuanLyId%>"/>
				<input type="hidden" name="actionName" id="actionName" value="<%=actionName%>"/>
				<input type="hidden" name="parentId" id="parentId" value="<%=parentId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã cấp cơ quan quản lý <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="ma" id="ma" type="text" size="10" maxlength="3" class="egov-inputfield" value="<%=capCoQuanQuanLy.getMa()%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên cấp cơ quan quản lý <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="ten" id="ten" type="text" size="50" maxlength="150" class="egov-inputfield" value="<%=capCoQuanQuanLy.getTen()%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <tr>
		    	<td align = "left">
		    	</td>
		      	<td align = "left">
		      		<input type="submit" class = "egov-button" name="submitButton"  value="Cập nhật" />
		      		<a href = "<%=capCoQuanQuanLyUrl%>"><input type="button" value="Quay lại"  class="egov-button-normal" /></a>
		      	</td>
		    </tr>
		  </table>
		</form>
</div>