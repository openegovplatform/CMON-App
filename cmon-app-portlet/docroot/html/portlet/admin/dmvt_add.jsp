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
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.admin.portlet.business.VaiTroBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddVaiTroRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String quocGiaId= ParamUtil.getString(request, "VaiTroId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (quocGiaId)) {
	quocGiaId = "";
}
VaiTro quocGia = null;
if (quocGiaId.trim().length() > 0) {
	quocGia = VaiTroLocalServiceUtil.fetchVaiTro(ConvertUtil.convertToLong(quocGiaId));
}
%>

<div class="wd-main-content">	
		<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">	
		      	<liferay-ui:error key="exitMaVaiTro" message = "vn.dtt.cmon.admin.dmvt.exit.ma"/>
				<liferay-ui:error key="emptyMaVaiTro" message = "vn.dtt.cmon.admin.dmvt.empty.ma"/>
				<liferay-ui:error key="exitTenVaiTro" message = "vn.dtt.cmon.admin.dmvt.exit.ten"/>
				<liferay-ui:error key="emptyTenVaiTro" message = "vn.dtt.cmon.admin.dmvt.empty.ten"/>
				<liferay-ui:error key="errorAddVaiTro" message = "vn.dtt.cmon.admin.dmvt.error.add"/>
				<liferay-ui:error key="errorUpdateVaiTro" message = "vn.dtt.cmon.admin.dmvt.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateVaiTro") != null && ParamUtil.getString(request, "CompletedUpdateVaiTro").trim().length() > 0) {
					%>
					<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.dmvt.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddVaiTro") != null && ParamUtil.getString(request, "CompletedAddVaiTro").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.dmvt.completed.add"/>
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
				<input type="hidden" name = "VaiTroId" id = "VaiTroId" value = "<%=quocGiaId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã vai trò <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maVaiTro" type="text" <%=VaiTroBusiness.checkReadOnly(actionTyPe) %> id="maVaiTro" maxlength="20" class = "egov-inputfield" value = "<%=VaiTroBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maVaiTro"), 3)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên vai trò <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenVaiTro" type="text" <%=VaiTroBusiness.checkReadOnly(actionTyPe) %> id="tenVaiTro" maxlength="50" class = "egov-inputfield" value = "<%=VaiTroBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenVaiTro"), 1)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Ứng dụng </label>
		      </td>
		      <td>
					
					<%
		      		if (actionTyPe.compareTo(VaiTroBusiness.VIEW_VAI_TRO) == 0) {
		      			%>
		      			<select id="UngDungId" name="UngDungId" class="egov-select custom" disabled="disabled">
		      			<%
		      		} else {
		      			%>
		      			<select id="UngDungId" name="UngDungId" class="egov-select custom">
		      			<%
		      		}
		      		List<DanhMucUngDung> listUngDung = VaiTroBusiness.findByTenUngDung("");
		      		for (DanhMucUngDung ungDung : listUngDung) {
		      			if (quocGia == null) {
			      			%>
			      			<option value="<%=ungDung.getId() %>" <%=VaiTroBusiness.checkSelectedValue(ParamUtil.getString(request, "UngDungId"), ungDung.getId())%>><%=ungDung.getTen() %></option>
			      			<%
		      			} else {
		      				%>
			      			<option value="<%=ungDung.getId() %>" <%=VaiTroBusiness.checkSelectedValue(String.valueOf(quocGia.getUngDungId()), ungDung.getId())%>><%=ungDung.getTen() %></option>
			      			<%
		      			}
		      		}
		      		%>
		      		</select>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Trạng thái</label>
		      </td>
		      <td>
		      		<%
		      		if (actionTyPe.compareTo(VaiTroBusiness.VIEW_VAI_TRO) == 0) {
		      			%>
		      			<select id="trangThaiVaiTro" name="trangThaiVaiTro" class="egov-select custom" disabled="disabled">
		      			<%
		      		} else {
		      			%>
		      			<select id="trangThaiVaiTro" name="trangThaiVaiTro" class="egov-select custom">
		      			<%
		      		}
		      		%>
		      			<option <%=VaiTroBusiness.checkSelected(quocGia, ParamUtil.getString(request, "trangThaiVaiTro"), "1") %> value = "1">Hoạt động</option>
		      			<option <%=VaiTroBusiness.checkSelected(quocGia, ParamUtil.getString(request, "trangThaiVaiTro"), "0") %> value = "0">Khóa</option>
		      		</select>
		      </td>
		    </tr>
		     <tr>
		      <td valign="top">
		      		<label class ="egov-label">Mô tả</label>
		      </td>
		      <td>
		      		<textarea name="moTaVaiTro" id="moTaVaiTro" class = "egov-textarea  custom" rows="2" cols="43" maxlength="255" <%=VaiTroBusiness.checkReadOnly(actionTyPe)%>><%=VaiTroBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "moTaVaiTro"), 2)%></textarea>
		      </td>
		    </tr>
		    
		    
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(VaiTroBusiness.VIEW_VAI_TRO) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/dmvt_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh mục vai trò">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
