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
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.admin.portlet.business.HeThongBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddHeThongRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String quocGiaId= ParamUtil.getString(request, "heThongId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (quocGiaId)) {
	quocGiaId = "";
}
HeThong quocGia = null;
if (quocGiaId.trim().length() > 0) {
	quocGia = HeThongLocalServiceUtil.fetchHeThong(ConvertUtil.convertToLong(quocGiaId));
}
%>

<div class="wd-main-content">	
		<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">	
		      	<liferay-ui:error key="exitMaHeThong" message = "vn.dtt.cmon.admin.dmht.exit.ma"/>
				<liferay-ui:error key="emptyMaHeThong" message = "vn.dtt.cmon.admin.dmht.empty.ma"/>
				<liferay-ui:error key="exitTenHeThong" message = "vn.dtt.cmon.admin.dmht.exit.ten"/>
				<liferay-ui:error key="emptyTenHeThong" message = "vn.dtt.cmon.admin.dmht.empty.ten"/>
				<liferay-ui:error key="errorAddHeThong" message = "vn.dtt.cmon.admin.dmht.error.add"/>
				<liferay-ui:error key="errorUpdateHeThong" message = "vn.dtt.cmon.admin.dmht.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateHeThong") != null && ParamUtil.getString(request, "CompletedUpdateHeThong").trim().length() > 0) {
					%>
					<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.dmht.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddHeThong") != null && ParamUtil.getString(request, "CompletedAddHeThong").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.dmht.completed.add"/>
					</font>					
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<%
				if (keyWord != null) {
				%>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
				<input type="hidden" name = "heThongId" id = "heThongId" value = "<%=quocGiaId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã hệ thống <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maHeThong" type="text" <%=HeThongBusiness.checkReadOnly(actionTyPe) %> id="maHeThong" maxlength="20" class = "egov-inputfield" value = "<%=HeThongBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maHeThong"), 3)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên hệ thống <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenHeThong" type="text" <%=HeThongBusiness.checkReadOnly(actionTyPe) %> id="tenHeThong" maxlength="50" class = "egov-inputfield" value = "<%=HeThongBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenHeThong"), 1)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Trạng thái</label>
		      </td>
		      <td>
		       <%
		    	if (actionTyPe.compareTo(HeThongBusiness.VIEW_HE_THONG) == 0) {
		    		%>
		    		<select id="trangThaiHeThong" name="trangThaiHeThong" class="egov-select custom" disabled="disabled">
		    		<%
		    	} else {
		    		%>
		    		<select id="trangThaiHeThong" name="trangThaiHeThong" class="egov-select custom" >
		    		<%
		    	}
		    %>
		      			<option <%=HeThongBusiness.checkSelected(quocGia, ParamUtil.getString(request, "trangThaiHeThong"), "1") %> value = "1">Hoạt động</option>
		      			<option <%=HeThongBusiness.checkSelected(quocGia, ParamUtil.getString(request, "trangThaiHeThong"), "0") %> value = "0">Khóa</option>
		      		</select>
		      </td>
		    </tr>
		     <tr>
		      <td valign="top">
		      		<label class ="egov-label">Mô tả</label>
		      </td>
		      <td>
		      		<textarea name="moTaHeThong" id="moTaHeThong" class = "egov-textarea  custom" rows="2" cols="43" maxlength="255" <%=HeThongBusiness.checkReadOnly(actionTyPe)%>><%=HeThongBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "moTaHeThong"), 2)%></textarea>
		      </td>
		    </tr>
		    
		    
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(HeThongBusiness.VIEW_HE_THONG) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/dmht_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh mục hệ thống">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
