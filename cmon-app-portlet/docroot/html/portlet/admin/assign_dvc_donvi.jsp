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
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function openWindow(url) {
		var newWindow = window.open(url,'Search popup','height=400,width=750,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

		if (window.focus) {
			newWindow.focus();
		}

		return false;
	} 
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "assignDichVuCong");
	
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_DVC_DONVI_OBJECT");
   	if (userRequest == null) {
   		userRequest = new HashMap<String, String>();

		userRequest.put("ma", "");
		userRequest.put("coQuanQuanLy", "");
   	}
   	
   	renderRequest.getPortletSession().setAttribute("USER_REQUEST_DVC_DONVI_OBJECT", userRequest);
	
%>
<div class="egov-container">
<br/>
<form id="inputForm" name="inputForm" method="post" action="<%=actionUrl%>">
  <table width="100%" border="0" align = "center" cellpadding="0" cellspacing="0"> 
  <tr>
  	<td colspan = "2">
  		<liferay-ui:error key="err.ma" message = "Bạn chưa nhập mã dịch vụ công"/>
		<liferay-ui:error key="err.coQuanQuanLy" message = "Bạn chưa nhập đơn vị triển khai dịch vụ công"/>
		<liferay-ui:success key="success" message="Thông tin đã được đăng ký" /> 
  	</td>
  </tr>   
  <tr>
      <td>Đơn vị tiếp nhận<font color = "red">(*)</font></td>
      <td >
      	<input type="text" name="coQuanQuanLy" class = "egov-inputfield custom" readonly size = "50" value = "<%=userRequest.get("coQuanQuanLy")%>" />
		      <%
		    		PortletURL searchUrl = renderResponse.createRenderURL();
		    		// This will remove header and footer in theme
		    		searchUrl.setWindowState(LiferayWindowState.POP_UP);
		    		searchUrl.setParameter("jspPage","/html/portlet/admin/co_quan_quan_ly_list_popup.jsp");
     		 	%>
      
		<a href = "#" onclick="openWindow('<%=searchUrl%>')" ><input type="BUTTON" name="button" id="button" value="" class = "egov-button-search"/></a>      
      </td>
    </tr>
    
    <tr>
      <td>Mã dịch vụ công<font color = "red">(*)</font></td>
      <td ><input name="ma" class = "egov-inputfield custom" type="text" id="ma" size="100" maxlength="1000" value = "<%=userRequest.get("ma")%>" /></td>
    </tr> 
   <tr>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="button2" id="button2" value="ĐĂNG KÝ" class = "egov-button-normal" /></td>
    </tr>
  </table>
  	<%
  		PortletURL redirectUrl = renderResponse.createRenderURL();
  		redirectUrl.setParameter("jspPage", "/html/portlet/admin/assign_dvc_donvi.jsp");
  	%>
  	<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl %>"/>
  	
  	<br/>	
	<% List<String> errLst = (List<String>)renderRequest.getPortletSession().getAttribute("MA_DICH_VU_ERR");
		if (errLst != null) {	
	%>
	<b>Các mã dịch vụ công không tồn tại</b>
	<table class = "egov-table" style  = "align:left;width:100%">

     <tr>
     
     <% for (int i = 0; i < errLst.size(); i++)
        {
            
            if (i % 15 == 0 & i !=0)
            {
     %>
            </tr>
            <tr>

     <%     } %>
                <td><%=errLst.get(i) %></td>
      <%
            
         } 
     
      %>
      </tr>
	
	</table>
  	<%} %>
</form>
	
</div>
<script>
	this.document.inputForm.coQuanQuanLy.focus();
</script>
<br/>

