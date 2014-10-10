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
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function openWindow(url) {
		var newWindow = window.open(url,'Search popup','height=350,width=700,left=90,top=100,resizable=yes,location=no,status=no,menubar=no,verticalbar=yes');

		if (window.focus) {
			newWindow.focus();
		}

		return false;
	} 
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "addEditTaiKhoanNguoiDung");
%>
<div class="wd-main-content">
	<br/>
	<%	
		int mode = ParamUtil.getInteger(request, "mode");
	  // Get user request from session
		Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_TKND_OBJECT");
	   	if (userRequest == null) {
	   		userRequest = new HashMap<String, String>();

			userRequest.put("fullName", "");
			
			userRequest.put("password", "");
			
			userRequest.put("email", "");
			
			userRequest.put("trangThai", "");
			
			userRequest.put("loaiDoiTuong", "");
			
			userRequest.put("congChuc", "");

			userRequest.put("TaiKhoanLiferayID", "");
	   	}
	%>	
		
	<form id="inputForm9" name="inputForm" method="post" action="<%=actionUrl%>">
	 	 <%
	 		PortletURL danhSachTaiKhoanUrl = renderResponse.createRenderURL();
	 		danhSachTaiKhoanUrl.setParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_list.jsp");
	 	 %>
	 	 <a href = "<%=danhSachTaiKhoanUrl%>">>> Danh sách người sử dụng</a>
	 	 <br/>
	 	 <br/>
	 	 <table width="100%" border="0">
	 	 		<tr>
		        	<td width = "30%"></td>
		        	<td></td>
		      	</tr>
	 	 		<tr>
	 	 			<td colspan = "2">
	 	 				<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.loginName" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.loginName"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.fullName" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.fullName"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.password" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.password"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.email" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.email"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.coQuanQuanLy" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.coQuanQuanLy"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateLoginName" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateLoginName"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateEmail" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateEmail"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.ldap" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.ldap"/>
						<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.emailNotValid" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.emailNotValid"/>
						<liferay-ui:success key="success" message="Thông tin đã được đăng ký" />
						<!-- <font color="blue"><liferay-ui:success key="vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.success" message = "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.success"/></font>  -->						
	 	 			</td>
	 	 		</tr>
		      <tr>
		        <td>Tên người dùng <font color = "red">(*)</font></td>
		        <td><input name="fullName" value = "<%=userRequest.get("fullName") %>" size = "40" class = "egov-inputfield custom" type="text" id="fullName" maxlength="100" /></td>
		      </tr>
		      <tr>
		        <td>Email <font color = "red">(*)</font></td>
		        
		        <td>
		        	<%
		        		String readOnly = "";
		        		if (mode == 1) {
		        			readOnly = "readonly";
		        		}
		        	%>
		        <input name="email" <%=readOnly %> value = "<%=userRequest.get("email") %>" size = "40" class = "egov-inputfield custom" type="text" id="email" maxlength="50" /></td>
		      </tr>
		      <tr>
		        <td>Mật khẩu <font color = "red">(*)</font></td>
		        <td><input name="password" value = "<%=userRequest.get("password") %>" size = "40" class = "egov-inputfield custom" type="password" id="password" maxlength="50" /></td>
		      </tr>
		      <tr>
		        <td>Trạng thái <font color = "red">(*)</font></td>
		        <td>
		          <select name="trangThai" id="trangThai" class = "egov-select custom" style="width:278px; display:block;">
		            <%
		            	String trangThai = userRequest.get("trangThai");
		            	if (Validator.isNull(trangThai)) {
		            %>
		            <option value="0">Không hoạt động</option>
		            <option value="1" selected>Đang hoạt động</option>
		            <%} else {
		            	String selected0 = "";
		            	String selected1 = "";
		            	
		            	if ("0".equals(trangThai)) {
		            		selected0 = "selected";
		            	} else {
		            		selected1 = "selected";
		            	}		            	
		            %>
		            <option value="0" <%=selected0 %>>Không hoạt động</option>
		            <option value="1" <%=selected1 %>>Đang hoạt động</option>
		          <%} %>
		          </select>
		        </td>
		      </tr>
		      <tr>
		        <td>Loại đối tượng <font color = "red">(*)</font></td>
		        <td><select name="loaiDoiTuong" id="loaiDoiTuong" class = "egov-select custom" style="width:278px; display:block;">
		        	<%
		        		// Get all loai doi tuong su dung
		        		List<DoiTuongSuDung> lstDoiTuongSuDung = DoiTuongSuDungLocalServiceUtil.getDSDoiTuongSuDung(0);
		        		String loaiDoiTuong = userRequest.get("loaiDoiTuong");
		        		for ( DoiTuongSuDung obj: lstDoiTuongSuDung) {
		        			String selected = "";
		        			
		        			// Temporarily harcode "CB"
		        			if ( Validator.isNull(loaiDoiTuong) ) {
		        				if ( obj.getMa().equals("CB")) {
		        					selected = "selected";
		        				}
		        			} else if ( obj.getId() == ConvertUtil.convertToLong(loaiDoiTuong)) {
		        				selected = "selected";
		        			}
		        	%>
		        		<option value  = "<%=obj.getId() %>" <%=selected %>><%=obj.getTen() %></option>
		        	<%
		        		}
		        	%>	
		        </select></td>
		      </tr>	
		       <tr>
                <td>Tài khoản liferay</td>
                <td><input name="liferayID" value = "<%=userRequest.get("TaiKhoanLiferayID") %>" size = "20" class = "egov-inputfield custom" id="liferayID" maxlength="20" /></td>
              </tr>	  
		      <tr>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		      </tr>
		      <tr>
		        <td>&nbsp;</td>
		        <td><input type="submit" class = "egov-button-normal" name="button" id="button" value="Đăng ký" /></td>
		      </tr>
		        <%
			  		PortletURL redirectUrl = renderResponse.createRenderURL();
			  		redirectUrl.setParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_add_edit.jsp");
			  		redirectUrl.setParameter("mode", mode + "");
	 			%>
  				<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl%>"/>
  				<input type = "hidden" name = "mode" value = "<%=mode +"" %>"/>
		</table>
	 </form>
</div>
<script>
	this.document.inputForm.loginName.focus();
</script>

