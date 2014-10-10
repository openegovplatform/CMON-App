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
<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page import="org.oep.cmon.admin.portlet.business.LoaiDoiTuongBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddLoaiDoiTuongRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String quocGiaId= ParamUtil.getString(request, "doiTuongSuDungId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (quocGiaId)) {
	quocGiaId = "";
}
DoiTuongSuDung quocGia = null;
if (quocGiaId.trim().length() > 0) {
	quocGia = DoiTuongSuDungLocalServiceUtil.fetchDoiTuongSuDung(ConvertUtil.convertToLong(quocGiaId));
}
%>

<div class="wd-main-content">	
		<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">	
		      	<liferay-ui:error key="exitMaDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.exit.ma"/>
				<liferay-ui:error key="emptyMaDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.empty.ma"/>
				<liferay-ui:error key="exitTenDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.exit.ten"/>
				<liferay-ui:error key="emptyTenDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.empty.ten"/>
				<liferay-ui:error key="errorAddDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.error.add"/>
				<liferay-ui:error key="errorUpdateDoiTuongSuDung" message = "vn.dtt.cmon.admin.ldtsd.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateDoiTuongSuDung") != null && ParamUtil.getString(request, "CompletedUpdateDoiTuongSuDung").trim().length() > 0) {
					%>
					<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.ldtsd.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddDoiTuongSuDung") != null && ParamUtil.getString(request, "CompletedAddDoiTuongSuDung").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.ldtsd.completed.add"/>
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
				<input type="hidden" name = "doiTuongSuDungId" id = "doiTuongSuDungId" value = "<%=quocGiaId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã đối tượng sử dụng <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maDoiTuongSuDung" type="text" <%=LoaiDoiTuongBusiness.checkReadOnly(actionTyPe) %> id="maDoiTuongSuDung" maxlength="8" class = "egov-inputfield" value = "<%=LoaiDoiTuongBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maDoiTuongSuDung"), 3)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên đối tượng sử dụng <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenDoiTuongSuDung" type="text" <%=LoaiDoiTuongBusiness.checkReadOnly(actionTyPe) %> id="tenDoiTuongSuDung" maxlength="50" class = "egov-inputfield" value = "<%=LoaiDoiTuongBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenDoiTuongSuDung"), 1)%>"/>
		      </td>
		    </tr>
		     <tr>
		      <td valign="top">
		      		<label class ="egov-label">Mô tả đối tượng sử dụng</label>
		      </td>
		      <td>
		      		<textarea name="moTaDoiTuongSuDung" id="moTaDoiTuongSuDung" class = "egov-textarea  custom" rows="2" cols="43" maxlength="255" <%=LoaiDoiTuongBusiness.checkReadOnly(actionTyPe)%>><%=LoaiDoiTuongBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "moTaDoiTuongSuDung"), 2)%></textarea>
		      </td>
		    </tr>
		    
		    
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(LoaiDoiTuongBusiness.VIEW_LOAI_DOI_TUONG) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/loai_doi_tuong_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh sách đối tượng sử dụng">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
