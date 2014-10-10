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
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:resourceURL var="fetchValues" id="fetchDonViHanhChinh"/>
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
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "addEditCoQuanQuanLy");
%>
<div class="wd-main-content">
<br/>
<%	
	//Get parent Id
	String strParentId = ParamUtil.getString(request, "parentId");
	long parentId = 0;
	 
	if ( Validator.isNotNull(strParentId)) {
		parentId = Long.parseLong( strParentId);
	}
	
	int mode = ParamUtil.getInteger(request, "mode");
	
	PortletURL searchHighestLevelUrl = renderResponse.createActionURL();
	searchHighestLevelUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
	
	%>
	>> <a href = "<%=searchHighestLevelUrl%>">Cấp cao nhất</a>
	<%
	if ( parentId > 0 ) {
		List <CoQuanQuanLy> lst = new ArrayList<CoQuanQuanLy>();			
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(parentId);
		
		lst.add(coQuanQuanLy);
			
		while ( coQuanQuanLy != null ) {
			try {
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanQuanLy.getChaId());
				if ( coQuanQuanLy != null ) {
					lst.add(coQuanQuanLy);
				}
			} catch (Exception es) {
				coQuanQuanLy = null;
			}
		}
			
		int cnt = lst.size();
		
		for (int i = cnt - 1; i > 0; i --) {
			// Direct search URL
			PortletURL directSearchUrl = renderResponse.createActionURL();
			directSearchUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
			directSearchUrl.setParameter("parentId", lst.get(i).getId() + "");
		%>
	
		>> <a href = "<%=directSearchUrl%>"><%=lst.get(i).getTen() %></a>
			
		<%	} //for %>
			>> <%=lst.get(0).getTen() %>
			
	<%	} %>
	
<form id="inputForm" name="inputForm" method="post" action="<%=actionUrl%>">
  <table width="100%" border="0" align = "center" cellpadding="0" cellspacing="0">
    <tr>
    	<td colspan = "5">
    		<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.ma" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.ma"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.ten" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.ten"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.tinh" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.tinh"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.huyen" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.huyen"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.xa" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.xa"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.motaDiaChi" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.motaDiaChi"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.dienThoai" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.dienThoai"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.dublicateMa" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.dublicateMa"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.capCoQuanQuanLy" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.capCoQuanQuanLy"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.email" message = "org.oep.cmon.admin.form.add_edit_coquanquanly.err.email"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.merChant" message = "Bạn phải nhập mã Access Code và mã Secure Secret"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.accessCode" message = "Bạn phải nhập mã Merchant và mã Secure Secret"/>
			<liferay-ui:error key="org.oep.cmon.admin.form.add_edit_coquanquanly.err.secureSecret" message = "Bạn phải nhập mã Merchant và mã Access Code"/>
			<liferay-ui:success key="success" message="Thông tin đã được đăng ký" />
		</td>
    </tr>    	
    <tr>
      <td width="30%" scope="col">&nbsp;</td>
      <td colspan="4" scope="col">&nbsp;</td>
    </tr>
   <% // Get user request from session
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_CQQL_OBJECT");
   	if (userRequest == null) {
   		userRequest = new HashMap<String, String>();
   		userRequest.put("ma", "");
   		userRequest.put("ten", "");
   		userRequest.put("tinh", "");
   		userRequest.put("huyen", "");
   		userRequest.put("xa", "");
   		userRequest.put("motaDiaChi", "");
   		userRequest.put("dienThoai", "");
   		userRequest.put("email", "");		
   		userRequest.put("fax", "");
   		userRequest.put("website", "");
   		userRequest.put("noiBo", "");
   		userRequest.put("capCoQuanQuanLy", "");
   	}
   %>
   <tr>
      <td>Mã cơ quan quản lý <font color = "red">(*)</font></td>
      <%
      	String readonly = "";
      	if ( mode ==1) {
      		readonly = "readonly";
      	}
      %>
      <td colspan="4"><input name="ma" <%=readonly %> class = "egov-inputfield custom" type="text" id="ma" size="10" maxlength="8" value = "<%=userRequest.get("ma")%>"/></td>
    </tr>
    <tr>
      <td>Tên cơ quan quản lý <font color = "red">(*)</font></td>
      <td colspan="4"><input name="ten" type="text" id="ten" size="61" maxlength="100" class = "egov-inputfield custom" value = "<%=userRequest.get("ten")%>"/></td>
    </tr>
    <tr>
      <td>Địa chỉ: Tỉnh-Quận-Huyện <font color = "red">(*)</font></td>
      <td width="5%"><select name="tinh" id="tinh" class = "egov-select custom"  style="width:135px; display:block;" onchange="reDrawSelectBox('tinh','huyen')">
      	<% 		   
      	List <DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
      		
      		long idTinh = 0l;
      		if (Validator.isNotNull(userRequest.get("tinh"))) {
      			idTinh = Long.parseLong(userRequest.get("tinh"));
      		}
      		
			//if ( idTinh < 1 ){ 
			%>
				<option id = "Chọn" value = "" selected>--</option>
			<%
			//} 
			for (DonViHanhChinh tinhThanh: tinhThanhList) {
				String selected = "";
				if ( tinhThanh.getId() == idTinh){
					selected = "selected";
				}
			%>
				<option value="<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen()%></option>
					
		 <%	} // for
		%>		
      </select></td>
      <td width="5%"><select name="huyen" id="huyen" class = "egov-select custom"  style="width:135px; display:block;" onchange="reDrawSelectBox('huyen','xa')">
      	<% 		   
      		long idHuyen= 0l;
      		
      		if (Validator.isNotNull(userRequest.get("huyen"))) {
      			idHuyen = Long.parseLong(userRequest.get("huyen"));
      		}
			// if ( idHuyen < 1){ 
			 %>
				<option id = "Chọn" value = "">--</option>
			<%
			//} 
	
				// Get quan huyen belong to tinh thanh
				if (idTinh > 0) {
					// Get all quan huyen
					List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(idTinh, 0);
							
					for (DonViHanhChinh quanHuyen: quanHuyenList) {
						String selected = "";
						if ( quanHuyen.getId() == idHuyen){
							selected = "selected";
						}
				%>
						<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
					
		  <%		} // for
				} // If
	 %>
		      
      </select></td>
      <td width="5%"><select name="xa" id="xa" class = "egov-select custom"  style="width:135px; display:block;">
      	<% 		   
      		long idXa = 0l;
      		
    		if (Validator.isNotNull(userRequest.get("xa"))) {
    			idXa = Long.parseLong(userRequest.get("xa"));
      		}
    		
			//if ( idXa < 1 ){
				%>
				<option id = "Chọn" value = "">--</option>
			<%
			//} 
			//else { 
				// Get quan huyen belong to quan huyen
				if (idHuyen > 0) {
					// Get all quan huyen
					List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyen, 0);
							
					for (DonViHanhChinh phuongXa: phuongXaList) {
						String selected = "";
						if ( phuongXa.getId() == idXa){
							selected = "selected";
						}
				%>
						<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>
					
		  <%		} // for
				} // If
		// } 
		%>
      
      </select></td>
      <td width="45%"></td>
    </tr>
     <tr>
      <td>Mô tả địa chỉ <font color = "red">(*)</font></td>
      <td colspan="4"><input name="motaDiaChi" type="text" id="motaDiaChi" class = "egov-inputfield custom"  size="61" maxlength="150" value = "<%=userRequest.get("motaDiaChi")%>"/></td>
    </tr>
    <tr>
      <td>Điện thoại <font color = "red">(*)</font></td>
      <td colspan="4"><input name="dienThoai" value = "<%=userRequest.get("dienThoai")%>" type="text" id="dienThoai" class = "egov-inputfield custom" maxlength="15" /></td>
    </tr>
    <tr>
      <td>Email</td>
      <td colspan="4"><input name="email" value = "<%=userRequest.get("email")%>" type="text" id="email" maxlength="50" class = "egov-inputfield custom" /></td>
    </tr>
    <tr>
      <td>Fax</td>
      <td colspan="4"><input type="text" name="fax" value = "<%=userRequest.get("fax")%>" class = "egov-inputfield custom" /></td>
    </tr>
    <tr>
      <td>Website</td>
      <td colspan="4"><input name="website" value = "<%=userRequest.get("website")%>" type="text" id="website" size="61" maxlength="100" class = "egov-inputfield custom" /></td>
    </tr>
    <tr>
      <td>Nội bộ</td>
      <td colspan="4">
      	<%
      		String check = "";
      		if ( "1".equals(userRequest.get("noiBo") ) ){
      			check = "checked";
      		}
      	%>
      	<input type="checkbox" name="noiBo" value = "1" id="noiBo" class = "egov-checkbox" <%=check%> />
      </td>
    </tr>
    <tr>
      <td>Cấp cơ quan quản lý <font color = "red">(*)</font></td>
      <td colspan="4"><input name="capCoQuanQuanLy" size = "54" value = "<%=userRequest.get("capCoQuanQuanLy")%>" type="text" id="capCoQuanQuanLy" readonly="readonly" class = "egov-inputfield custom" />
      <%
    		PortletURL searchUrl = renderResponse.createRenderURL();
    		// This will remove header and footer in theme
    		searchUrl.setWindowState(LiferayWindowState.POP_UP);
    		searchUrl.setParameter("jspPage","/html/portlet/admin/cap_co_quan_quan_ly_list_popup.jsp");
      %>
      
      <a href = "#" onclick="openWindow('<%=searchUrl%>')" ><input type="BUTTON" name="button" id="button" value="" class = "egov-button-search"/></a></td>
    </tr>
     <tr>
      <td>Merchant </td>
      <td colspan="4"><input name="merChant" size = "54" value = "<%=userRequest.get("merChant")%>" type="text" id="merChant"  class = "egov-inputfield custom" />
      </td>
    </tr>
    
    <tr>
      <td>Access Code </td>
      <td colspan="4"><input name="accessCode" size = "54" value = "<%=userRequest.get("accessCode")%>" type="text" id="accessCode"  class = "egov-inputfield custom" />
      </td>
    </tr>
    
    <tr>
      <td>Secure Secret </td>
      <td colspan="4"><input name="secureSecret" size = "54" value = "<%=userRequest.get("secureSecret")%>" type="text" id="secureSecret"  class = "egov-inputfield custom" />
      </td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td colspan="4">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="4"><input type="submit" name="button2" id="button2" value="ĐĂNG KÝ" class = "egov-button-normal" /></td>
    </tr>
  </table>
  	<input type = "hidden" name = "parentId" value = "<%=parentId +"" %>" />
  	<input type = "hidden" name = "mode" value = "<%=mode +"" %>"/>
  	<%
  		PortletURL redirectUrl = renderResponse.createRenderURL();
  		redirectUrl.setParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_add_edit.jsp");
  		redirectUrl.setParameter("mode", mode +""); // Insert mode
  		redirectUrl.setParameter("parentId", parentId + ""); // parent id
  	%>
  	<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl %>"/>
</form>
	
</div>
<script>
	this.document.inputForm.ma.focus();
</script>

<portlet:actionURL var="getDonViHanhChinhByIdURL" name="getDonViHanhChinhById">
	<portlet:param name="jspPage" value="/html/portlet/admin/co_quan_quan_ly_add_edit.jsp"/>
</portlet:actionURL>
<script type="text/javascript">
	var url = '<%= getDonViHanhChinhByIdURL.toString() %>';

	//Ve lai danh sach don vi hanh chinh
	function reDrawSelectBox(selectName, changeName) {
				
		var id = document.getElementById(selectName).options[document.getElementById(selectName).selectedIndex].value;
		var hidSelectedPhuongXa = document.getElementById("hiddenPhuongXaId");
		
		// if quan huyen is not selected then return
		if (id == "") return;
		
		var obj = document.getElementById(changeName);
	
		$.ajax({
			type: 'POST'
			,url: url
			,data : {id: id}
			,success: function(data) {		
	
				// preferred
				var data2 = JSON.parse(data);
				// Xoa cac old item in select
				
				while (obj.options.length > 1) {
					obj.remove(1);
				}				
	            
				for (var i = 0; i < data2.id.length; i++) {
					obj.add(new Option(data2.name[i], data2.id[i]), null);
					
					if (hidSelectedPhuongXa && (data2.id[i] == hidSelectedPhuongXa.value)) 
		            {
		                obj.selectedIndex = i + 1;
		            }
				}
			}
		});
	}
</script>