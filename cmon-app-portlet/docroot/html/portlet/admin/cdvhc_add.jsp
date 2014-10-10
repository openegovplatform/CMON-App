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
<%@page import="org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh"%>
<%@page import="org.oep.cmon.admin.portlet.business.CapDonViHanhChinhBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddCapDonViHanhChinhRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String quocGiaId= ParamUtil.getString(request, "CapDonViHanhChinhId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (quocGiaId)) {
	quocGiaId = "";
}
CapDonViHanhChinh quocGia = null;
if (quocGiaId.trim().length() > 0) {
	quocGia = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(ConvertUtil.convertToLong(quocGiaId));
}
%>

<div class="wd-main-content">	
		<form id="capDonViHanhChinhForm" name="capDonViHanhChinhForm" method="post" action="<%=actionUrl.toString()%>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">		      	
				<liferay-ui:error key="exitMaCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.exit.ma"/>
				<liferay-ui:error key="exitTenCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.exit.ten"/>
				<liferay-ui:error key="emptyMaCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.empty.ma"/>
				<liferay-ui:error key="emptyTenCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.empty.ten"/>
				<liferay-ui:error key="emptyMoTaCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.empty.mota"/>
				<liferay-ui:error key="errorAddCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.error.add"/>
				<liferay-ui:error key="errorUpdateCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.error.update"/>
				<liferay-ui:error key="emptyCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.empty.capDonViHanhChinh"/>
				<liferay-ui:error key="numberCapDonViHanhChinh" message = "vn.dtt.cmon.admin.cdvhc.error.number.capDonViHanhChinh"/>
				<%
					if (ParamUtil.getString(request, "CompletedUpdateCapDonViHanhChinh") != null && ParamUtil.getString(request, "CompletedUpdateCapDonViHanhChinh").trim().length() > 0) {
				%>
				<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.cdvhc.completed.update"/></font>					
					<%
					}
					if (ParamUtil.getString(request, "CompletedAddCapDonViHanhChinh") != null && ParamUtil.getString(request, "CompletedAddCapDonViHanhChinh").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.cdvhc.completed.add"/>
					</font>					
					<%
					}
					%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%=actionTyPe%>"/>
				<% if (keyWord != null) { %>
				<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
				<input type="hidden" name = "CapDonViHanhChinhId" id = "CapDonViHanhChinhId" value = "<%=quocGiaId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã cấp đơn vị hành chính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maCapDonViHanhChinh" type="text" <%=CapDonViHanhChinhBusiness.checkReadOnly(actionTyPe)%> id="maCapDonViHanhChinh" maxlength="5" class = "egov-inputfield" value = "<%=CapDonViHanhChinhBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maCapDonViHanhChinh"), 2)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên cấp đơn vị hành chính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenCapDonViHanhChinh" type="text"  <%=CapDonViHanhChinhBusiness.checkReadOnly(actionTyPe)%> id="tenCapDonViHanhChinh" maxlength="50" class = "egov-inputfield" value = "<%=CapDonViHanhChinhBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenCapDonViHanhChinh"), 1)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Cấp đơn vị hành chính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="capDonViHanhChinh" type="text"  <%=CapDonViHanhChinhBusiness.checkReadOnly(actionTyPe)%> id="capDonViHanhChinh" maxlength="2" class = "egov-inputfield" value = "<%=CapDonViHanhChinhBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "capDonViHanhChinh"), 3)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td valign="top">
		      		<label class ="egov-label">Mô tả</label>
		      </td>
		      <td>
		      		<textarea name="moTaCapDonViHanhChinh" id="moTaCapDonViHanhChinh" class = "egov-textarea  custom" rows="2" cols="43" maxlength="100" <%=CapDonViHanhChinhBusiness.checkReadOnly(actionTyPe)%>><%=CapDonViHanhChinhBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "moTaCapDonViHanhChinh"), 4)%></textarea>
		      </td>
		    </tr>
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(CapDonViHanhChinhBusiness.VIEW_DON_VI_HANH_CHINH) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/cdvhc_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh sách cấp đơn vị hành chính">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>