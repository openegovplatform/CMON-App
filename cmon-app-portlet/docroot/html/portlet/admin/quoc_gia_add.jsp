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
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.nio.charset.CharsetEncoderUtil"%>
<%@page import="java.nio.charset.CharsetEncoder"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="org.oep.cmon.admin.portlet.business.QuocGiaBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddQuocGiaRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");

String actionTyPe= ParamUtil.getString(request, "ActionType");
String quocGiaId= ParamUtil.getString(request, "quocGiaId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (quocGiaId)) {
	quocGiaId = "";
}
QuocGia quocGia = null;
if (quocGiaId.trim().length() > 0) {
	quocGia = QuocGiaLocalServiceUtil.fetchQuocGia(ConvertUtil.convertToLong(quocGiaId));
}
%>

<div class="wd-main-content">	
		<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">		      	
				<liferay-ui:error key="exitMaQuocGia" message = "vn.dtt.cmon.admin.quocgia.exit.ma"/>
				<liferay-ui:error key="exitTenQuocGia" message = "vn.dtt.cmon.admin.quocgia.exit.ten"/>
				<liferay-ui:error key="emptyMaQuocGia" message = "vn.dtt.cmon.admin.quocgia.empty.ma"/>
				<liferay-ui:error key="emptyTenQuocGia" message = "vn.dtt.cmon.admin.quocgia.empty.ten"/>
				<liferay-ui:error key="errorAddQuocGia" message = "vn.dtt.cmon.admin.quocgia.error.add"/>
				<liferay-ui:error key="errorUpdateQuocGia" message = "vn.dtt.cmon.admin.quocgia.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateQuocGia") != null && ParamUtil.getString(request, "CompletedUpdateQuocGia").trim().length() > 0) {
					%>
				<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.quocgia.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddQuocGia") != null && ParamUtil.getString(request, "CompletedAddQuocGia").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.quocgia.completed.add"/>
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
				<input type="hidden" name = "quocGiaId" id = "quocGiaId" value = "<%=quocGiaId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã quốc gia <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maQuocGia" type="text" <%=QuocGiaBusiness.checkReadOnly(actionTyPe) %> id="maQuocGia" maxlength="3" class = "egov-inputfield" value = "<%=QuocGiaBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maQuocGia"), 2)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên quốc gia <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenQuocGia" type="text"  <%=QuocGiaBusiness.checkReadOnly(actionTyPe) %> id="tenQuocGia" maxlength="50" class = "egov-inputfield" value = "<%=QuocGiaBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenQuocGia"), 1)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(QuocGiaBusiness.VIEW_QUOC_GIA) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/quoc_gia_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh sách quốc gia">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
