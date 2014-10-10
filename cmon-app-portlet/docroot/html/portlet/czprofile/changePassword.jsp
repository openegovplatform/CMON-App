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
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	PortletURL changePassUrl = renderResponse.createActionURL();
	changePassUrl.setParameter(ActionRequest.ACTION_NAME, "changePassword");

	// Get user request from session
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
	if ( userRequest == null ) {
		userRequest = new HashMap<String, String>();
		
		userRequest.put("newPassword", "");
		userRequest.put("confirmPassword", "");
		
		renderRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
	}
%>
<script type="text/javascript">
// Check form goes here

</script>
<div class="egov-container">	
<br/>
	<form name="inputForm" method="post" action="<%=changePassUrl%>">
	  <table class ="egov-table-form2" align = "center" style = 'width:60%'>
	  	<tr>
	  		<td colspan = "2">
	  			<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.oldPassword" message = "vn.dtt.cmon.czprofile.form.input.err.oldPassword"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.oldPasswordNotCorrect" message = "vn.dtt.cmon.czprofile.form.input.err.oldPasswordNotCorrect"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.newPassword" message = "vn.dtt.cmon.czprofile.form.input.err.newPassword"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.confirmPassword" message = "vn.dtt.cmon.czprofile.form.input.err.confirmPassword"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.oldPassAndNewPass" message = "vn.dtt.cmon.czprofile.form.input.err.oldPassAndNewPass"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.newPassSameOldPass" message = "vn.dtt.cmon.czprofile.form.input.err.newPassSameOldPass"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.notLogin" message = "vn.dtt.cmon.czprofile.form.input.err.notLogin"/>
				<liferay-ui:error key="vn.dtt.cmon.czprofile.form.input.err.ldap" message = "vn.dtt.cmon.czprofile.form.input.err.ldap"/>					  			
				<liferay-ui:success key="success" message="Thông tin đã được đăng ký" />
			</td>
	  	</tr>

	    <tr>
	      <td> <label class="egov-label-bold">Mật khẩu mới:</label>  <font color = "red">(*)</font></td>
	      <td><input type="password" name="newPassword" id="newPassword" value = "<%=userRequest.get("newPassword")%>" class = "egov-inputfield custom" style = 'width: 95%'/></td>
	    </tr>
	   	<tr>
	      <td><label class="egov-label-bold">Xác nhận mật khẩu: </label> <font color = "red">(*)</font></td>
	      <td><input type="password" name="confirmPassword" id="confirmPassword" value = "<%=userRequest.get("confirmPassword")%>" class = "egov-inputfield custom" style = 'width:95%'/></td>
	    </tr>
	    
	    <tr>
	      <td>&nbsp;</td>
	      <td><input type="submit" name="button2" id="button2" value="Đổi mật khẩu" class = "egov-button-normal"/></td>
	    </tr>
	    <tr>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	    </tr>
	    <tr>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	    </tr>
	  </table>
	  <% 
          
            PortletURL redirectUrl= renderResponse.createRenderURL();
            redirectUrl.setParameter("jspPage","/html/portlet/czprofile/view.jsp");
            
		%>
		
		<input type="hidden" name=redirectUrl value="<%=redirectUrl%>"/>

			
	</form>
	<script type = "text/javascript">
		document.inputForm.oldPassword.focus();
	</script>
</div>
