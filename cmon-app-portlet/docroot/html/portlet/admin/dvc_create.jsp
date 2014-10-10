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
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function openWindow(url) {
		var newWindow = window.open(url,'Search popup','height=350,width=700,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

		if (window.focus) {
			newWindow.focus();
		}

		return false;
	} 
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "addDichVuCong");
	
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_DVC_OBJECT");
   	if (userRequest == null) {
   		userRequest = new HashMap<String, String>();

		userRequest.put("ma", "");
		
		userRequest.put("ten", "");
		
		userRequest.put("groupId", "");
		
		userRequest.put("coQuanQuanLy", "");
   	}
   	
   	renderRequest.getPortletSession().setAttribute("USER_REQUEST_DVC_OBJECT", userRequest);
	
%>
<div class="egov-container">
<br/>
<form id="inputForm" name="inputForm" method="post" action="<%=actionUrl%>">
  <table width="100%" border="0" align = "center" cellpadding="0" cellspacing="0"> 
  <tr>
  	<td colspan = "2">
  		<liferay-ui:error key="err.ma" message = "Bạn chưa nhập mã dịch vụ công"/>
		<liferay-ui:error key="err.ten" message = "Bạn chưa nhập tên dịch vụ công"/>
		<liferay-ui:error key="err.groupId" message = "Bạn chưa nhập nhóm dịch vụ công"/>
		<liferay-ui:error key="err.coQuanQuanLy" message = "Bạn chưa nhập đơn vị triển khai dịch vụ công"/>		
		<liferay-ui:success key="success" message="Thông tin đã được đăng ký" />  	
  	</td>
  </tr>   
    
   <tr>
      <td>Mã dịch vụ công<font color = "red">(*)</font></td>
      <td ><input name="ma" class = "egov-inputfield custom" type="text" id="ma" size="10" maxlength="15" value = "<%=userRequest.get("ma")%>" /></td>
    </tr>
    <tr>
      <td>Tên dịch vụ công<font color = "red">(*)</font></td>
      <td ><input name="ten" type="text" id="ten" size="100" maxlength="300" class = "egov-inputfield custom" value = "<%=userRequest.get("ten")%>"/></td>
    </tr>    
    <tr>
      <td>Nhóm dịch vụ công<font color = "red">(*)</font></td>
      <td >
      	<select name="groupId" id="groupId" class = "egov-select custom" style="width:278px; display:block;">
       	<%
       		// Get all nhóm thủ tục hành chính       		
       		List<NhomThuTucHanhChinh> lstNhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinhs(0, NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinhsCount());
        		for ( NhomThuTucHanhChinh obj: lstNhomThuTucHanhChinh) {
       			String selected = "";
       			
       			// Temporarily harcode "CB"
       			if ( Validator.isNull(userRequest.get("groupId")) ) {
						selected = "";  
       			} else if ( obj.getId() == Long.parseLong(userRequest.get("groupId"))) {
       				selected = "selected";
       			}
       	%>
       		<option value  = "<%=obj.getId() %>" <%=selected %>><%=obj.getTen() %></option>
       	<%
       		}
       	%>	
       </select>
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
  		redirectUrl.setParameter("jspPage", "/html/portlet/admin/dvc_create.jsp");
  	%>
  	<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl %>"/>
</form>
	
</div>
<script>
	this.document.inputForm.ma.focus();
</script>
<br/>

