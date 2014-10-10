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
<%@ include file="/html/portlet/userreg/init.jsp" %>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type = "text/javascript">
	$(document).ready(function () {
		$(".wd-refresh").click(function() {
		  	$(".captcha").attr("src", $(".captcha").attr("src")+"&force=" + new Date().getMilliseconds());
		  	return false;
		});			
	});
</script>
<%
	// Get user request from session
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
	if ( userRequest == null ) {
		userRequest = new HashMap<String, String>();
		
		userRequest.put("HOCONGDAN", "");
		userRequest.put("TENDEM", "");
		userRequest.put("TENCONGDAN", "");
		userRequest.put("SOCMND", "");
		userRequest.put("NGAYCAPCMND", "");
		userRequest.put("IDNOICAPCMND", "-1");
		userRequest.put("GHICHUCMND", "");
		userRequest.put("EMAIL", "");
		userRequest.put("SOHOCHIEU", "");
		userRequest.put("NGAYCAPHOCHIEU", "");
		userRequest.put("IDNOICAPHOCHIEU", "-1");
		userRequest.put("NGAYHETHANHOCHIEU", "");
		userRequest.put("GHICHUHOCHIEU", "");
		userRequest.put("IDGIOITINH", "-1");
		userRequest.put("IDDANTOC", "-1");
		userRequest.put("IDTONGIAO", "-1");
		userRequest.put("IDQUOCTICH", "-1");
		userRequest.put("NGAYSINH", "");
		userRequest.put("DIENTHOAICODINH", "");
		userRequest.put("DIENTHOAIDIDONG", "");
		userRequest.put("IDTRINHDOHOCVAN", "-1");
		userRequest.put("SOBAOHIEMYTE", "");
		userRequest.put("IDNGHENGHIEP", "-1");
		userRequest.put("IDTRINHDOCHUYENMON", "-1");
		userRequest.put("IDTINHTRANGHONNHAN", "-1");
		userRequest.put("IDTINHTHANHNOISINH", "-1");
		userRequest.put("IDQUANHUYENNOISINH", "-1");
		userRequest.put("IDPHUONGXANOISINH", "-1");
		userRequest.put("MOTADIACHINOISINH", "");
		userRequest.put("IDTINHTHANHTHUONGTRU", "-1");
		userRequest.put("IDQUANHUYENTHUONGTRU", "-1");
		userRequest.put("IDPHUONGXATHUONGTRU", "-1");
		userRequest.put("MOTADIACHITHUONGTRU", "");
		userRequest.put("IDTINHTHANHHIENTAI", "-1");
		userRequest.put("IDQUANHUYENHIENTAI", "-1");
		userRequest.put("IDPHUONGXAHIENTAI", "-1");
		userRequest.put("MOTADIACHIHIENTAI", "");		
		userRequest.put("SOHOKHAU", "");
		userRequest.put("CHUHO", "-1");
		userRequest.put("IDQUANHE", "-1");
		userRequest.put("MASOTHUECANHAN", "");
		
		renderRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
	}
	
	PortletURL inputUrl = renderResponse.createActionURL();
	inputUrl.setParameter(ActionRequest.ACTION_NAME, "inputBasic");
	
	
%>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css" type="text/css" media="screen" />	
</head>
<div class="egov-container">	
<br/>
	<form name="inputForm" id = "inputForm" method="post" action="<%=inputUrl%>">
	  <table cellspacing="0" cellpadding="0" class="egov-table-form" width="100%">
	  	<tr>
	  		<td colspan = "1">
		  		<select style="display: none;"	id="egov-form-errors" >
		  			<option value="ho">
		  				<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.hoCongDan" message = "vn.dtt.cmon.userreg.form.input.err.hoCongDan"/>
		  			</option>
		  			<option  value="ten">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.tenCongDan" message = "vn.dtt.cmon.userreg.form.input.err.tenCongDan"/>
					</option>
					<option  value="soCmnd">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.soCmnd"  message = "vn.dtt.cmon.userreg.form.input.err.soCmnd" />
						
					</option>
					<option  value="soCmnd">	
						<liferay-ui:error key="err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo"  message = "Số CMND phải có 9 số hoặc 12 số" />
					</option>
					<option  value="ngaySinh">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.ngaySinh"  message = "vn.dtt.cmon.userreg.form.input.err.ngaySinh" />
					</option>
					<option  value="ngaySinh">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent"  message = "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent" />
					</option>
					<option  value="email">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.email"  message = "vn.dtt.cmon.userreg.form.input.err.email" />
					</option>
					<option  value="email">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned"  message = "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned" />
					</option>
					<option value="captcha" >	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.captcha"  message = "vn.dtt.cmon.userreg.form.input.err.captcha" />
					</option>
					<option  value="soCmnd">	
						<liferay-ui:error key="vn.dtt.cmon.userreg.form.input.err.requestExists"  message = "Số cmdn đã được sử dụng. Hãy chờ yêu cầu được xử lý hoặc chọn một số cmdn khác" />
					</option>	
				</select>
			</td>
			<td colspan = "6">
			
						
			</td>
	  	</tr>
	  	
	  	<% 
			PortletURL inputDetailDialogUrl = renderResponse.createRenderURL();
	  		inputDetailDialogUrl.setParameter("jspPage","/html/portlet/userreg/input_detail_dialog.jsp");
	  		
	  		PortletURL inputDetailDialogUrlExistInCongDan = renderResponse.createRenderURL();
	  		inputDetailDialogUrlExistInCongDan.setParameter("jspPage","/html/portlet/userreg/input_detail_dialog_exist.jsp");
            
	  		PortletURL accountExistDialog = renderResponse.createRenderURL();
	  		accountExistDialog.setParameter("jspPage","/html/portlet/userreg/account_exist.jsp");
	  		
	  		
            PortletURL accountRegisterSuccessUrl = renderResponse.createRenderURL();
            accountRegisterSuccessUrl.setParameter("jspPage","/html/portlet/userreg/account_register_success.jsp");  
            
            PortletURL accountCreationUrl = renderResponse.createRenderURL();            
            accountCreationUrl.setParameter("jspPage","/html/portlet/userreg/account_creation.jsp");
            accountCreationUrl.setParameter("authCode", "DUMMY_AUTH_CODE"); 
            
            PortletURL redirectUrl= renderResponse.createRenderURL();
            redirectUrl.setParameter("jspPage","/html/portlet/userreg/view.jsp");
            
		%>
			<input type="hidden" name="accountExistDialog"  value="<%= accountExistDialog%>"/>
			<input type="hidden" name="inputDetailDialogUrlExistInCongDan"  value="<%= inputDetailDialogUrlExistInCongDan%>"/>
			<input type="hidden" name="inputDetailDialogUrl"  value="<%= inputDetailDialogUrl%>"/>
			<input type="hidden" name=redirectUrl value="<%=redirectUrl%>"/>
			<input type="hidden" name="accountCreationUrl" value="<%= accountCreationUrl%>"/>
			<input type="hidden" name="accountRegisterSuccessUrl" value="<%= accountRegisterSuccessUrl%>"/>
	  	</tale>
	  	<table cellspacing="0" cellpadding="0" class="egov-table-form"  width="100%">
	    <tr>
	      <td style="padding-top: 25px;"><font style="font-weight: bold; padding-top: 5px;">Họ - Đệm - Tên</font> <font color = "red">(*)</font></td>
	      <td colspan="3" >
		         <table class="egov-table-form" >
		      	<tr>
		      		<td >
		      			<input style = 'width:85%; margin-left: -5px;' name="ho" value = "<%=userRequest.get("HOCONGDAN")%>" type="text" id="ho" maxlength="20" class = "egov-inputfield" />
		      		</td>
		      		<td>
		      			<input style = 'width:85%' name="dem" type="text" id="dem" value = "<%=userRequest.get("TENDEM")%>" maxlength="50"  class = "egov-inputfield " />
		      		</td>
		      		<td>
		      			<input name="ten" type="text" id="ten" value = "<%=userRequest.get("TENCONGDAN")%>" maxlength="20" class = "egov-inputfield" style = 'width:85%; margin-left: 5px;'/>
		      		</td>
		      	</tr>
		      </table>	   
	      </td>
	    </tr>
	    <tr>
	      <td style="padding-top: 18px;"><font style="font-weight: bold;">Số CMND </font> <font color = "red">(*)</font></td>
	      <td colspan="3"><input name="soCmnd" type="text" id="soCmnd" value = "<%=userRequest.get("SOCMND")%>" maxlength="12" class = "egov-inputfield " style = 'width: 95%' /></td>
	    </tr>
	    <tr>
	      <td style="padding-top: 18px;"><font style="font-weight: bold;">Ngày sinh </font> <font color = "red">(*)</font></td>
	      <td colspan="3"><input type="text" name="ngaySinh" id="ngaySinh" value = "<%=userRequest.get("NGAYSINH")%>" class = "egov-calendar" style = 'width: 95%'/></td>
	    </tr>
	   	<tr>
	      <td style="padding-top: 18px;"><font style="font-weight: bold;">Email </font> <font color = "red">(*)</font></td>
	      <td colspan="3"><input type="text" name="email" id="email" value = "<%=userRequest.get("EMAIL")%>" class = "egov-inputfield " style = 'width:95%'/></td>
	    </tr>
	    <tr>
	      <td style="padding-top: 20px;"><font style="font-weight: bold;">Mã xác nhận </font> <font color = "red">(*) </font>
	      </td>
	      <td colspan="4" style="padding-top: 0px;"> 
	      	
	      	 <table class="egov-table-form" >
		      	<tr>
		      		<td  style="padding-top: 20px;">
		      			<input type="text" id = "captcha" name = "captcha" class = "egov-inputfield" maxlength = "20" style = 'width:95%; margin-left: -5px; margin-top: -7px;'>
		      		</td>
		      		<td  style="padding-top: 12px;">
		      			 <portlet:resourceURL var="captchaURL" id="captcha"/>
							<img class="captcha" src="<%= captchaURL%> alt="Text to identify" style = ' width:85px; height:32px; margin-left: -4px; margin-top: 3px;' />	
							<input id="reloadcapchar" name="reloadcapchar" type="hidden" value="" style = ' margin-left: -4px; margin-top: -7px;'/>
					        <a href="javascript: submitReloadCapcha()" class="wd-refresh">
				                <img src="<%=request.getContextPath()%>/images/reload_capcha.jpg" alt="Lấy lại mã bảo mật" style = 'margin-left: 3px; margin-top: 3px;height:32px;'/> 	        
					        </a>
		      		</td>
		      		
		      	</tr>
		      </table>	   
	      </td>		      	

	    </tr>
	    <!--   <tr>
	      <td>&nbsp;</td>
	      <td>
	      <portlet:resourceURL var="captchaURL" id="captcha"/>
			<img class="captcha" src="<%= captchaURL%> alt="Text to identify"/>	
			<input id="reloadcapchar" name="reloadcapchar" type="hidden" value=""/>
	        <a href="javascript: submitReloadCapcha()" class="wd-refresh">
                <img src="<%//=request.getContextPath()%>/images/reload_capcha.jpg" alt="Lấy lại mã bảo mật"/> 	        
	        </a> 
	        </td>
	    </tr>-->
	    <tr>
	      <td>&nbsp;</td>
	      <td><input type="submit" name="button2" id="button2" value="Đăng ký tài khoản" class = "egov-button"/></td>
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
	  
			
	</form>
	<script type = "text/javascript">
		document.inputForm.ho.focus();

		function submitReloadCapcha() {
			document.getElementById("reloadcapchar").value = 'reloadcapchar';
			document.getElementById("inputForm").submit();
		}
	</script>
</div>