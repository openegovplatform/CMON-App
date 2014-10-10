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
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.admin.portlet.business.ChucVuBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddChucVuRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String quocGiaId= ParamUtil.getString(request, "ChucVuId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (quocGiaId)) {
	quocGiaId = "";
}
ChucVu quocGia = null;
if (quocGiaId.trim().length() > 0) {
	quocGia = ChucVuLocalServiceUtil.fetchChucVu(ConvertUtil.convertToLong(quocGiaId));
}
%>

<div class="wd-main-content">	
		<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">	
		      	<liferay-ui:error key="exitMaChucVu" message = "vn.dtt.cmon.admin.dmcv.exit.ma"/>
				<liferay-ui:error key="emptyMaChucVu" message = "vn.dtt.cmon.admin.dmcv.empty.ma"/>
				<liferay-ui:error key="exitTenChucVu" message = "vn.dtt.cmon.admin.dmcv.exit.ten"/>
				<liferay-ui:error key="emptyTenChucVu" message = "vn.dtt.cmon.admin.dmcv.empty.ten"/>
				<liferay-ui:error key="errorAddChucVu" message = "vn.dtt.cmon.admin.dmcv.error.add"/>
				<liferay-ui:error key="errorUpdateChucVu" message = "vn.dtt.cmon.admin.dmcv.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateChucVu") != null && ParamUtil.getString(request, "CompletedUpdateChucVu").trim().length() > 0) {
					%>
					<font color="blue"><liferay-ui:message key="vn.dtt.cmon.admin.dmcv.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddChucVu") != null && ParamUtil.getString(request, "CompletedAddChucVu").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="vn.dtt.cmon.admin.dmcv.completed.add"/>
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
				<input type="hidden" name = "ChucVuId" id = "ChucVuId" value = "<%=quocGiaId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã chức vụ <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maChucVu" type="text" <%=ChucVuBusiness.checkReadOnly(actionTyPe) %> id="maChucVu" maxlength="5" class = "egov-inputfield" value = "<%=ChucVuBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maChucVu"), 3)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên chức vụ <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenChucVu" type="text" <%=ChucVuBusiness.checkReadOnly(actionTyPe) %> id="tenChucVu" maxlength="50" class = "egov-inputfield" value = "<%=ChucVuBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenChucVu"), 1)%>"/>
		      </td>
		    </tr>
		    
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(ChucVuBusiness.VIEW_CHUC_VU) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/chuc_vu_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh mục chức vụ">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
