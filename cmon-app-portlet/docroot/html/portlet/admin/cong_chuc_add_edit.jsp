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
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
.red {
	color: #F00;
}
</style>
<script type="text/javascript">
	function openWindow(url) {
			var newWindow = window.open(url,'Search popup','height=400,width=800,left=90,top=100,resizable=yes,location=no,status=no,menubar=no,verticalbar=yes');
	
			if (window.focus) {
				newWindow.focus();
			}
	
			return false;
	} 

	function openWindowChucVu(url) {
		if (document.getElementById("coQuanQuanLy").value.trim().length > 0) {
			document.getElementById('message_error').innerHTML = '';
			var newWindow = window.open(url,'Search popup','height=350,width=800,left=90,top=100,resizable=yes,location=no,status=no,menubar=no,verticalbar=yes');
	
			if (window.focus) {
				newWindow.focus();
			}
	
			return false;
		} else {
			document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.cmon.admin.form.add_edit_congchuc.coquanquanly.empty") %>';
		}
	}

	function openWindowVaiTro(url) {
		if (document.getElementById("chucVu").value.trim().length > 0) {
			var newWindow = window.open(url,'Search popup','height=350,width=500,left=90,top=100,resizable=yes,location=no,status=no,menubar=no,verticalbar=yes');
	
			if (window.focus) {
				newWindow.focus();
			}
	
			return false;
		} else {
			document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.cmon.admin.dmcv.selected.empty") %>';
		}
	} 
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "addEditCongChuc");
%>
<div class="wd-main-content">
	<br/>
	<%	
		int mode = ParamUtil.getInteger(request, "mode");
	  // Get user request from session
		Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_CC_OBJECT");
	   	if (userRequest == null) {
	   		userRequest = new HashMap<String, String>();

			userRequest.put("ma", "");
			
			userRequest.put("hoVaTen", "");
			
			userRequest.put("ngaySinh", "");
			
			userRequest.put("gioiTinh", "");
			
			userRequest.put("chucVu", "");
			
			userRequest.put("coQuanQuanLy", "");			
			
			userRequest.put("soCmnd", "");
			
			userRequest.put("ngayCapCmnd", "");
			
			userRequest.put("noiCapCmnd", "");
			
			userRequest.put("taiKhoanNguoiDung", "");
			userRequest.put("vaiTroThem", "");
	   	}
	%>	
		
	<form id="inputForm" name="inputForm" method="post" action="<%=actionUrl%>">
	 	 <%
	 		PortletURL danhSachCongChucUrl = renderResponse.createRenderURL();
	 		danhSachCongChucUrl.setParameter("jspPage", "/html/portlet/admin/cong_chuc_list.jsp");
	 	 %>
	 	 <a href = "<%=danhSachCongChucUrl%>">>> Danh sách công chức</a>
	 	 <br/>
	 	 <br/>
	 	   <table width="100%" border="0">
		    	<tr>
		        	<td width = "30%"></td>
		        	<td></td>
		      	</tr>
	 	 		<tr>
	 	 			<td colspan = "2">
	 	 				<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.ma" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.ma"/>
	 	 				<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.taiKhoanNguoiDung" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.taiKhoanNguoiDung"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.hoVaTen" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.hoVaTen"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.ngaySinh" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.ngaySinh"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.chucVu" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.chucVu"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.coQuanQuanLy" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.coQuanQuanLy"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.duplicateMa" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.duplicateMa"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.ngaySinh.greaterThanCurrent" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.ngaySinh.greaterThanCurrent"/>
						<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_congchuc.err.ngayCapCmnd.greaterThanCurrent" message = "org.oep.cmon.admin.form.add_edit_congchuc.err.ngayCapCmnd.greaterThanCurrent"/>
						<liferay-ui:error key="org.oep.form.congchuc.error.number.cmnd" message = "org.oep.form.congchuc.error.number.cmnd"/>
						<liferay-ui:error key="org.oep.form.congchuc.error.arrange.cmnd" message = "org.oep.form.congchuc.error.arrange.cmnd"/>
						<liferay-ui:success key="success" message="Thông tin đã được đăng ký" />
						<span style="color: red" id="message_error"></span>
	 	 			</td>
	 	 		</tr>
		    <tr>		    	
		      <td>Mã<span class="red"> (*)</span></td>
		      <%
		      	String readonly = "";
		      	if ( mode ==1) {
		      		readonly = "readonly";
		      	}
		      %>
		      <td><input name="ma" <%=readonly%> type="text" id="ma" maxlength="20" class = "egov-inputfield custom" size = "30" value = "<%=userRequest.get("ma")%>"/></td>
		    </tr>
		    <tr>
		      <td>Họ và tên<span class="red"> (*)</span></td>
		      <td><input name="hoVaTen" type="text" id="hoVaTen" maxlength="30" class = "egov-inputfield custom" size = "30" value = "<%=userRequest.get("hoVaTen")%>" /></td>
		    </tr>
		    <tr>
		      <td>Ngày sinh <span class="red">(*)</span></td>
		      <td><input name="ngaySinh" type="text" id="ngaySinh" maxlength="10" class = "egov-calendar custom" size = "30" value = "<%=userRequest.get("ngaySinh")%>"  /></td>
		    </tr>
		    <tr>
		      <td>Giới tính <span class="red">(*)</span></td>
		      <td>
		       <%
		      	List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.getDSGioiTinh();
		      %>
		      <select name="gioiTinh" id="gioiTinh" class = "egov-select custom" style="width:220px; display:block;">
	     		<%
	        		String selected = "";
	      	   		for ( GioiTinh gioiTinh: gioiTinhList) {
	      	   			selected = "";
	      	   			if ( Validator.isNotNull(userRequest.get("gioiTinh")) && gioiTinh.getId() == Long.parseLong(userRequest.get("gioiTinh")) ) {
	        				selected = "selected";
	        			} 
	        	%>
	        	<option value = "<%=gioiTinh.getId()%>" <%=selected %> ><%=gioiTinh.getTen() %></option>
	        	<%} %>
		      </select>
		      </td>
		    </tr>
		    <tr>
		      <td>Cơ quan quản lý <span class="red">(*)</span></td>
		      <td><input type="text" id="coQuanQuanLy" name="coQuanQuanLy" class = "egov-inputfield custom" readonly size = "50" value = "<%=userRequest.get("coQuanQuanLy")%>" onchange="javascript: resetAlert()"/>
		      <%
		    		PortletURL searchUrl = renderResponse.createRenderURL();
		    		// This will remove header and footer in theme
		    		searchUrl.setWindowState(LiferayWindowState.POP_UP);
		    		searchUrl.setParameter("jspPage","/html/portlet/admin/co_quan_quan_ly_list_popup.jsp");
     		 	%>
      
      			<a href = "#" onclick="openWindow('<%=searchUrl%>')" ><input type="BUTTON" name="button" id="button" value="" class = "egov-button-search" onclick="javascript: resetAlert()"/></a>
		      
		      </td>
		    </tr>
		    <tr>
		      <td>Chức vụ <span class="red">(*)</span></td>
		      <td><input type="text" readonly name="chucVu" id="chucVu" class = "egov-inputfield custom" size = "50" value = "<%=userRequest.get("chucVu")%>" />
		      <%
		    		PortletURL searchChucVuUrl = renderResponse.createRenderURL();
		    		// This will remove header and footer in theme
		    		searchChucVuUrl.setWindowState(LiferayWindowState.POP_UP);
		    		searchChucVuUrl.setParameter("jspPage","/html/portlet/admin/chuc_vu_list_popup.jsp");
     		 	%>
		      	<a href = "#" onclick="openWindowChucVu('<%=searchChucVuUrl%>')" >
		      		<input type="button" name="button2" id="button2" value="" class = "egov-button-search" />
		   		</a> <a href = "#" onclick="showChucVuChiTietPopup()" >Xem vai trò</a>
		   	</td>
		    </tr>
		    <tr>
		      <td>Số CMND</td>
		      <td><input name="soCmnd" type="text" id="soCmnd" maxlength="15" class = "egov-inputfield custom" size = "30" value = "<%=userRequest.get("soCmnd")%>" /></td>
		    </tr>
		    <tr>
		      <td>Ngày cấp CMND</td>
		      <td><input type="text" name="ngayCapCmnd" id="ngayCapCmnd" class = "egov-calendar custom" size = "30" value = "<%=userRequest.get("ngayCapCmnd")%>"  /></td>
		    </tr>
		    <tr>
		      <td>Nơi cấp CMND</td>
		      <td><input name="noiCapCmnd" type="text" id="noiCapCmnd" maxlength="100" class = "egov-inputfield custom" size = "50" value = "<%=userRequest.get("noiCapCmnd")%>" /></td>
		    </tr>
		     <tr>
			      <td>Tài khoản người dùng<span class="red">(*)</span></td>
			      <td><input type="text" name="taiKhoanNguoiDung" id="taiKhoanNguoiDung" class = "egov-inputfield custom" readonly size = "50" value = "<%=userRequest.get("taiKhoanNguoiDung")%>" />
			      <%
			    		PortletURL searchTaiKhoanNguoiDungUrl = renderResponse.createRenderURL();
			    		// This will remove header and footer in theme
			    		searchTaiKhoanNguoiDungUrl.setWindowState(LiferayWindowState.POP_UP);
			    		searchTaiKhoanNguoiDungUrl.setParameter("jspPage","/html/portlet/admin/tai_khoan_nguoi_dung_list_popup.jsp");
	     		 	%>
	      			<input type = "button" class="egov-func-delete" title="Xóa" onclick = "javascript:document.inputForm.taiKhoanNguoiDung.value='';"/>
      				<a href = "#" onclick="openWindow('<%=searchTaiKhoanNguoiDungUrl%>')" ><input type="BUTTON" name="button" id="button" value="" class = "egov-button-search"/></a>
			      
			      </td>
		    </tr>
		    <tr>
		      <td>&nbsp;</td>
		      <td>
		      	<%
		    		PortletURL searchVaiTroUrl = renderResponse.createRenderURL();
		    		// This will remove header and footer in theme
		    		searchVaiTroUrl.setWindowState(LiferayWindowState.POP_UP);
		    		searchVaiTroUrl.setParameter("jspPage","/html/portlet/admin/themVaiTroToCongChuc.jsp");
     		 	%>
		      	<a href = "#" onclick="showDocumentPopup('<%=searchVaiTroUrl%>')" >Thêm vai trò</a>
		      </td>
		    </tr>
		     <tr>
		      <td></td>
		      <td align="left">
		      	  <%
		      	  StringBuilder vaiTroThem = new StringBuilder("");
		      	//
		      		if (userRequest.get("id") != null && userRequest.get("id").trim().length() > 0) {
		      			String[] taiKhoanNguoiDungId = userRequest.get("taiKhoanNguoiDung").split("-");
	      				int index = 1;
	      				List<NguoiDung2VaiTro> liNguoiDung2VaiTros = NguoiDung2VaiTroLocalServiceUtil.findByTaiKhoanNguoiDungID(ConvertUtil.convertToLong(taiKhoanNguoiDungId[0]), 0);
	      				if (liNguoiDung2VaiTros.size() > 0) {
		      			%>
		      			<table class= "egov-table" style="margin:0;" width="300">
		      				<tr>
					    		<th width="10%">TT</th>
							    <th width="55%">Vai trò</th>
							    <th width="25%">Chức năng</th>
		      				</tr>
		      				<%
		      				VaiTro vaiTro = null;
		      				for (NguoiDung2VaiTro nguoiDung2VaiTro : liNguoiDung2VaiTros) {
		      					if (vaiTroThem.length() == 0) {
		      						vaiTroThem.append(nguoiDung2VaiTro.getVaiTroId());
		      					} else {
		      						vaiTroThem.append("-").append(nguoiDung2VaiTro.getVaiTroId());
		      					}
		      					vaiTro = ConvertUtil.getVaiTroById(nguoiDung2VaiTro.getVaiTroId());
		      					if (vaiTro != null) {
		      						PortletURL deleteRoleUrl = renderResponse.createActionURL();
		      						deleteRoleUrl.setParameter(ActionRequest.ACTION_NAME, "deleteRoleCongChuc");
		      						deleteRoleUrl.setParameter("taiKhoanNguoiDungId", String.valueOf(nguoiDung2VaiTro.getTaiKhoanNguoiDungId()));
		      						deleteRoleUrl.setParameter("vaiTroId", String.valueOf(nguoiDung2VaiTro.getVaiTroId()));
		      						deleteRoleUrl.setParameter("nguoiDung2VaiTroId", String.valueOf(nguoiDung2VaiTro.getId()));
		      					%>
		      					<tr id="<%=nguoiDung2VaiTro.getVaiTroId()%>" style="display: '';">
									<td align = "center"><%=index++ %></td>
									<td align = "left"><%=vaiTro.getTen() %></td>
									<td><a href="#" onclick="javascript: deleteVaiTroInseted('<%=nguoiDung2VaiTro.getVaiTroId() %>', '<%=deleteRoleUrl.toString()%>')">Xóa</a></td>
								</tr>
		      					<%
		      					}
		      				}
		      				//
		      				if (userRequest.get("vaiTroThem") != null && userRequest.get("vaiTroThem").trim().length() > 0) {
		      					// Vai tro chon them moi.
		      					String _vaiTroThem = userRequest.get("vaiTroThem").trim();
				      		 	String[] _vaiTroIdsNew = _vaiTroThem.split("-");
				      		 	
				      		 	//Vai tro da insert.
				      		 	String[] _vaiTroIdsOld = vaiTroThem.toString().split("-");
				      		 	
				      		 	
				      		 	// Vai tro se ve.
				      		 	String[] vaiTroIds = ConvertUtil.checkTwoArray(_vaiTroIdsOld, _vaiTroIdsNew);
				      		 	if (vaiTroIds.length > 0) {
				      		 		for (String data : vaiTroIds) {
					      		 		if (ConvertUtil.convertToLong(data) > 0) {
					      		 			vaiTro = ConvertUtil.getVaiTroById(ConvertUtil.convertToLong(data));
					      		 			if (vaiTro != null) {
					      		 				if (vaiTroThem.length() == 0) {
						      						vaiTroThem.append(vaiTro.getId());
						      					} else {
						      						vaiTroThem.append("-").append(vaiTro.getId());
						      					}
					      						PortletURL deleteRoleUrl = renderResponse.createActionURL();
					      						deleteRoleUrl.setParameter(ActionRequest.ACTION_NAME, "deleteRoleCongChucRiengChuaAdd");
					      						deleteRoleUrl.setParameter("vaiTroId", String.valueOf(vaiTro.getId()));
					      					%>
					      					<tr id="<%=vaiTro.getId()%>" style="display: '';">
												<td align = "center"><%=index++ %></td>
												<td align = "left"><%=vaiTro.getTen() %></td>
												<td><a href="#" onclick="javascript: deleteVaiTroNotInseted('<%=vaiTro.getId() %>', '<%=deleteRoleUrl.toString()%>')">Xóa</a></td>
											</tr>
					      					<%
					      					}
					      		 		}
					      		 	}
				      		 	}
		      				}
		      				%>
		      			</table>
		      			<%
	      				} else {
	      					
		      				if (userRequest.get("vaiTroThem") != null && userRequest.get("vaiTroThem").trim().length() > 0) {
		      					// Vai tro chon them moi.
		      					String _vaiTroThem = userRequest.get("vaiTroThem").trim();
				      		 	String[] vaiTroIds = _vaiTroThem.split("-");
				      		 	
				      		 	if (vaiTroIds.length > 0) {
				      		 		VaiTro vaiTro = null;
				      		 		%>
				      		 		<table class= "egov-table" style="margin:0;" width="300">
					      				<tr>
								    		<th width="10%">TT</th>
										    <th width="55%">Vai trò</th>
										    <th width="25%">Chức năng</th>
					      				</tr>
				      		 		<%
				      		 		for (String data : vaiTroIds) {
					      		 		if (ConvertUtil.convertToLong(data) > 0) {
					      		 			vaiTro = ConvertUtil.getVaiTroById(ConvertUtil.convertToLong(data));
					      		 			if (vaiTro != null) {
					      		 				if (vaiTroThem.length() == 0) {
						      						vaiTroThem.append(vaiTro.getId());
						      					} else {
						      						vaiTroThem.append("-").append(vaiTro.getId());
						      					}
					      						PortletURL deleteRoleUrl = renderResponse.createActionURL();
					      						deleteRoleUrl.setParameter(ActionRequest.ACTION_NAME, "deleteRoleCongChucRiengChuaAdd");
					      						deleteRoleUrl.setParameter("vaiTroId", String.valueOf(vaiTro.getId()));
					      					%>
					      					<tr id="<%=vaiTro.getId()%>" style="display: '';">
												<td align = "center"><%=index++ %></td>
												<td align = "left"><%=vaiTro.getTen() %></td>
												<td><a href="#" onclick="javascript: deleteVaiTroNotInseted('<%=vaiTro.getId() %>', '<%=deleteRoleUrl.toString()%>')">Xóa</a></td>
											</tr>
					      					<%
					      					}
					      		 		}
					      		 	}
				      		 		%>
				      		 		</table>
				      		 		<%
				      		 	}
		      				}
	      				}
		      		}
		      	  	if (userRequest.get("vaiTroThem") != null && userRequest.get("vaiTroThem").trim().length() > 0 && (userRequest.get("id") == null || userRequest.get("id").trim().length() == 0)) {
		      		 	vaiTroThem.append(userRequest.get("vaiTroThem").trim());
		      		 	String[] vaiTroIds = userRequest.get("vaiTroThem").trim().split("-");
		      		 	VaiTro vaiTro = null;
		      		 	int index = 1;
		      		 	if (vaiTroIds.length > 0) {
		      		 		%>
		      		 		<table class= "egov-table" style="margin:0;" width="300">
			      				<tr>
						    		<th width="10%">TT</th>
								    <th width="55%">Vai trò</th>
								    <th width="25%">Chức năng</th>
			      				</tr>
		      		 		<%
			      		 	for (String data : vaiTroIds) {
			      		 		if (ConvertUtil.convertToLong(data) > 0) {
			      		 			vaiTro = ConvertUtil.getVaiTroById(ConvertUtil.convertToLong(data));
			      		 			if (vaiTro != null) {
			      						PortletURL deleteRoleUrl = renderResponse.createActionURL();
			      						deleteRoleUrl.setParameter(ActionRequest.ACTION_NAME, "deleteRoleCongChucRiengChuaAdd");
			      						deleteRoleUrl.setParameter("vaiTroId", String.valueOf(vaiTro.getId()));
			      					%>
			      					<tr id="<%=vaiTro.getId()%>" style="display:'';">
										<td align = "center"><%=index++ %></td>
										<td align = "left"><%=vaiTro.getTen() %></td>
										<td><a href="#" onclick="javascript: deleteVaiTroNotInseted('<%=vaiTro.getId() %>', '<%=deleteRoleUrl.toString()%>')">Xóa</a></td>
									</tr>
			      					<%
			      					}
			      		 		}
			      		 	}
		      		 		%>
		      		 		</table>
		      		 		<%
		      		 	}
		      	  	}
		      	  %>
		      </td>
		    </tr>
		     
		    <tr>
		      <td><input type = "hidden" name = "vaiTroThem" id="vaiTroThem" value = "<%=vaiTroThem.toString().trim()%>"/></td>
		      <td><input type="submit" name="button" id="button" value="ĐĂNG KÝ" class = "egov-button-normal" /></td>
		    </tr>
		  </table>
	  		<%
		  		PortletURL redirectUrl = renderResponse.createRenderURL();
		  		redirectUrl.setParameter("jspPage", "/html/portlet/admin/cong_chuc_add_edit.jsp");
		  		redirectUrl.setParameter("mode", mode + "");
 			%>
 				<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl%>"/>
 				<input type = "hidden" name = "mode" value = "<%=mode +"" %>"/>
	 </form>
	 <br/>
</div>

 <%
		 PortletURL viewChucVuChiTietPopup = renderResponse.createRenderURL();
		 // This will remove header and footer in theme
		 viewChucVuChiTietPopup.setWindowState(LiferayWindowState.POP_UP);
		 viewChucVuChiTietPopup.setParameter("jspPage","/html/portlet/admin/vaitro_chucvu_list_popup.jsp");
 %>


<script>
	this.document.inputForm.ma.focus();
	function resetAlert() {
		document.getElementById('message_error').innerHTML = '';
	}

	function deleteVaiTroInseted(vaiTroId, urlDelete) {
		var vaiTroThem = document.getElementById('vaiTroThem').value;
		$.ajax({
			type: 'POST'
			,url: urlDelete
			,data : {vaiTroThem: vaiTroThem}
			,success: function(data) {		

				// preferred
				var data2 = JSON.parse(data);
				if (data2.status_delete) {
					document.getElementById(vaiTroId).style.display = 'none';
					document.getElementById('vaiTroThem').value = data2.vaiTroThem; 
				}
			}
		});
	}

	function deleteVaiTroNotInseted(vaiTroId, urlDelete) {
		var vaiTroThem = document.getElementById('vaiTroThem').value;
		$.ajax({
			type: 'POST'
			,url: urlDelete
			,data : {vaiTroThem: vaiTroThem}
			,success: function(data) {		

				// preferred
				var data2 = JSON.parse(data);
				if (data2.status_delete) {
					document.getElementById(vaiTroId).style.display = 'none';
					document.getElementById('vaiTroThem').value = data2.vaiTroThem; 
				}
			}
		});
	}

	function showDocumentPopup(viewDocumentURL) {			
		var _vaiTroThem = document.getElementById('vaiTroThem').value.trim();
		var _coQuanQuanLy = document.getElementById('coQuanQuanLy').value.trim();
		var _ma = document.getElementById('ma').value.trim();
		var _hoVaTen = document.getElementById('hoVaTen').value.trim();
		var _ngaySinh = document.getElementById('ngaySinh').value.trim();
		var _gioiTinh = document.getElementById('gioiTinh').value.trim();
		var _chucVu = document.getElementById('chucVu').value.trim();
		var _soCmnd = document.getElementById('soCmnd').value.trim();
		var _noiCapCmnd = document.getElementById('noiCapCmnd').value.trim();
		var _ngayCapCmnd = document.getElementById('ngayCapCmnd').value.trim();
		var _taiKhoanNguoiDung = document.getElementById('taiKhoanNguoiDung').value.trim();
	    AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
	   
	    	var dialog = new A.Dialog({
	            title: '',
	            draggable: true,
	            modal: true,
	            centered: true,
	            width: $(window).width()*0.6,
	            height: $(window).height()*0.5,
	            
	        }).plug(A.Plugin.IO, {uri: viewDocumentURL, data: {chucVuID: _chucVu, vaiTroThem: _vaiTroThem, coQuanQuanLy: _coQuanQuanLy, ma: _ma, hoVaTen: _hoVaTen, ngaySinh: _ngaySinh, gioiTinh:_gioiTinh, chucVu: _chucVu, soCmnd: _soCmnd, noiCapCmnd: _noiCapCmnd, ngayCapCmnd: _ngayCapCmnd, taiKhoanNguoiDung: _taiKhoanNguoiDung}}).render();
	  });
	}

	var viewChucVuChiTietPopupURL = '<%=viewChucVuChiTietPopup.toString() %>';
	
	function showChucVuChiTietPopup() {			
		var _coQuanQuanLy = document.getElementById('coQuanQuanLy').value.trim();
		var _chucVu = document.getElementById('chucVu').value.trim();
	    if (_coQuanQuanLy.length > 0 && _chucVu.length > 0) {
	    	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
	    		   
		    	var dialog = new A.Dialog({
		            title: '',
		            draggable: true,
		            modal: true,
		            centered: true,
		            width: $(window).width()*0.6,
		            height: $(window).height()*0.5,
		            
		        }).plug(A.Plugin.IO, {uri: viewChucVuChiTietPopupURL, data: {coQuanQuanLyId: _coQuanQuanLy, chucVuId: _chucVu}}).render();
		  });
		} else {
			alert('Cần chọn chức vụ của cơ quan quản lý tương ứng.');
		}
	}
</script>

