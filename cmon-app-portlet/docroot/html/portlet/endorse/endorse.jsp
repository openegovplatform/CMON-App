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
<%@page import="org.oep.cmon.user.portlet.util.StringUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.QuanHeGiaDinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.QuanHeGiaDinh"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.cd.model.TinhTrangHonNhan"%>
<%@page import="org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.TrinhDoChuyenMonLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.TrinhDoChuyenMon"%>
<%@page import="org.oep.cmon.dao.cd.service.NgheNghiepLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.NgheNghiep"%>
<%@page import="org.oep.cmon.dao.cd.model.TrinhDoHocVan"%>
<%@page import="org.oep.cmon.dao.cd.service.TrinhDoHocVanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.TonGiaoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.TonGiao"%>
<%@page import="org.oep.cmon.dao.cd.model.DanToc"%>
<%@page import="org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/portlet/endorse/init.jsp" %>
<%@page import="org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:resourceURL var="fetchValues" id="fetchDonViHanhChinh"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css" 
 	type="text/css" media="screen" />
 	
<script type="text/javascript">
	$(document).ready(function(){		
		// CHange event on noisinh_tinhthanh combobox
		$("#noisinh_tinhthanh").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noisinh_tinhthanh").val();	  	
		  	
		  	$("#noisinh_quanhuyen").empty();
		  	$("#noisinh_quanhuyen").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId != "") {	 
				jQuery.getJSON(url+"&parentId=" + parentId, function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#noisinh_quanhuyen").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}
		  		});
		  	}
		  	
		  	$("#noisinh_quanhuyen").change();
	 	});	
		
		// CHange event on thuongtru_tinhthanh combobox
		$("#thuongtru_tinhthanh").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#thuongtru_tinhthanh").val();	  	
		  	
		  	$("#thuongtru_quanhuyen").empty();
			$("#thuongtru_quanhuyen").append("<option value=''>Chọn</option>");
			
		  	if (parentId != "") {	
		  		jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#thuongtru_quanhuyen").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}		   		
	  			});
		  	}
		  	
		  	$("#thuongtru_quanhuyen").change();
	 	});	
		
		// CHange event on noio tinh thanh combobox
		$("#noio_tinhthanh").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noio_tinhthanh").val();	  	
		  	
		  	$("#noio_quanhuyen").empty();
		  	$("#noio_quanhuyen").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId != "") {	  		
			  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#noio_quanhuyen").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}				   
		  		});
		  	}
		  	
			$("#noio_quanhuyen").change();
	 	});
		
		// CHange event on noisinh_quanhuyen combobox
		$("#noisinh_quanhuyen").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noisinh_quanhuyen").val();	  	
		  	
		  	$("#noisinh_phuongxa").empty();
		  	$("#noisinh_phuongxa").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId == "") {
		  		return;
		  	}	
		  	
		  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#noisinh_phuongxa").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	 	});
		
		
		// CHange event on thuongtru_quanhuyen combobox
		$("#thuongtru_quanhuyen").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#thuongtru_quanhuyen").val();	 	  	
		  	
		  	$("#thuongtru_phuongxa").empty();
		  	
		  	$("#thuongtru_phuongxa").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId == "") {
		  		return;
		  	}
		  	
		  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#thuongtru_phuongxa").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	 	});
		
		// CHange event on noio_quanhuyen combobox
		$("#noio_quanhuyen").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noio_quanhuyen").val();	  	
		  	
		  	$("#noio_phuongxa").empty();
		  	$("#noio_phuongxa").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId == "") {
		  		return;
		  	}
		  	
		  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#noio_phuongxa").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	 	});
	}); 
</script>
<script type="text/javascript">
function disableForm(theform) {
	for (var i = 0; i < theform.length; i++) {
		if (theform.elements[i].id != "backButton") {
			theform.elements[i].disabled = true;
		}
	}
}

function submitForm(actionUrl) {
	document.endorseForm.action = actionUrl;
	document.endorseForm.submit();
}
</script>

<%
	// Get user request from session
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
	PortletURL endorseUrl = renderResponse.createActionURL();
	endorseUrl.setParameter(ActionRequest.ACTION_NAME, "endorse");
	
	PortletURL huyDangKy = renderResponse.createActionURL();
	huyDangKy.setParameter(ActionRequest.ACTION_NAME, "huyDangKy");
	
	int status = Integer.parseInt(userRequest.get("TRANGTHAIYEUCAU"));
	List <DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
%>
	<div class="egov-container">	
		<form id="endorseForm" name="endorseForm" method="post" action="<%=endorseUrl%>">
			<%
				if (Validator.isNotNull(request.getAttribute("endorseSuccess"))) {
			%>
				<div class="portlet-msg-success" style="padding-left: 20px;">
			 		Xác thực thành công
			 	 </div>
			<%
				} else if (Validator.isNotNull(request.getAttribute("endorseError"))) {
			%>
				<div style="color: red;">
					Lỗi hệ thống.
				</div>
			<%  } %>
		  <table class = "egov-table-form" style = 'width:90%'>
		  	<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
						<option value="ho">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.hoCongDan" message = "org.oep.cmon.user.form.endorse.err.hoCongDan"/>
						</option>
						<option value="ten">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tenCongDan" message = "org.oep.cmon.user.form.endorse.err.tenCongDan"/>
						</option>
		  				<option value="soCmnd">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.soCmnd"  message = "Số Chứng minh nhân dân không được để trống và phải có 9 hoặc 12 số" />
						</option>
						<option value="ngayCapCmnd">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngayCapCmnd"  message = "org.oep.cmon.user.form.endorse.err.ngayCapCmnd" />
						</option>
						<option value="ngayCapCmnd">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngayCap.greaterThanCurrent"  message = "Ngày cấp không được lớn hơn hiện tại" />
						</option>
						
		  				<option value="email">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.email"  message = "Địa chỉ email không được để trống và phải đúng định dạng" />
						</option>
						<option value="email">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.emailDuplicate"  message = "Địa chỉ email đã được sử dụng" />
						</option>
						
		  				<option value="gioiTinh">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.gioiTinh"  message = "org.oep.cmon.user.form.endorse.err.gioiTinh" />
						</option>
		  				<option value="ngaySinh">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngaySinh"  message = "org.oep.cmon.user.form.endorse.err.ngaySinh" />
						</option>
		  				<option value="ngaySinh">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngaySinh.greaterThanCurrent"  message = "org.oep.cmon.user.form.endorse.err.ngaySinh.greaterThanCurrent" />
						</option>
						
						
						<option value="thuongtru_tinhthanh">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tinhThuongTru"  message = "org.oep.cmon.user.form.endorse.err.tinhThuongTru" />
						</option>
						
						<option value="thuongtru_quanhuyen">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.huyenThuongTru"  message = "org.oep.cmon.user.form.endorse.err.huyenThuongTru" />
						</option>
						
						<option value="thuongtru_phuongxa">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.xaThuongTru"  message = "org.oep.cmon.user.form.endorse.err.xaThuongTru" />
						</option>
						
						<option value="tinhHienTai">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tinhHienTai"  message = "org.oep.cmon.user.form.endorse.err.tinhHienTai" />
						</option>
						
						<option value="danToc">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.danToc"  message = "org.oep.cmon.user.form.endorse.err.danToc" />
						</option>
						
						<option value="tonGiao">
							<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tonGiao"  message = "org.oep.cmon.user.form.endorse.err.tonGiao" />
						</option>
		  			</select>
		  		</td>
		  	</tr>
		    
		     <tr>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;</td>
			</tr>
		    
		    <!--  email -->
		    <tr>
		      <td colspan="3"><label class ="egov-label-bold">Email (Tài khoản đăng nhập hệ thống)</label>
		      	<label class="egov-label-red">(*)</label></td>
		      <td colspan="3"></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		     	 <input name="email" type="text" id="email"  maxlength="50" class = "egov-inputfield" value = "<%=userRequest.get("EMAIL")%>" style = 'width:95%'/></td>
		      <td colspan="3">
		      </td>
		    </tr>
		    
		    <!--  ho ten  ngay sinh-->
		     <tr>
		      <td colspan="3" scope="col"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.hoVaTen"/></label>
		      	<label class="egov-label-red">(*)</label></td>
		      <td colspan="1"></td>
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngaySinh" /></label>
		      	<label class="egov-label-red">(*)</label></td>
		    </tr>
		    <tr>
		      <td><input name="ho" type="text" id="ho"  maxlength="20" class = "egov-inputfield" value = "<%=userRequest.get("HOCONGDAN")%>" style = 'width:85%'/></td>
		      <td><input name="dem" type="text" id="dem"  maxlength="50" class = "egov-inputfield" value = "<%=userRequest.get("TENDEM")%>" style = 'width:85%'/></td>
		      <td><input name="ten" type="text" id="ten"  maxlength="20" class = "egov-inputfield" value = "<%=userRequest.get("TENCONGDAN")%>" style = 'width:85%'/></td>
		      <td colspan="1"></td>
		      <td colspan="2">
		      <input name="ngaySinh" type="text" id="ngaySinh" class = "egov-calendar custom" value = "<%=userRequest.get("NGAYSINH")%>" style = 'width:85%'/></td>
		    </tr>
		    
			<!-- cmnd -->
			<tr>
		      <td colspan="3"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.soCmnd" /></label>
		      	 <label class="egov-label-red">(*)</label></td>
		      <td></td>
		      <td colspan="2">
		      	<label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngayCapCmnd" /></label>
		      	<label class="egov-label-red">(*)</label>
		      </td>
		    </tr>
		    <tr>
		    	<td colspan="3">
		      		<input name="soCmnd" type="text" id="soCmnd"  maxlength="12" class = "egov-inputfield" value = "<%=userRequest.get("SOCMND")%>" style = 'width:95%'/></td>
		    	<td></td>
		    	<td colspan="2">
		      		<input name="ngayCapCmnd" type="text" id="ngayCapCmnd" maxlength="10" class = "egov-calendar custom" value = "<%=userRequest.get("NGAYCAPCMND")%>" style = 'width:85%'/></td>
		    </tr>
				
			<!-- gioi tinh, dan toc, ton giao -->
			 <tr>
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.gioiTinh" /></label>
		      	 <label class="egov-label-red">(*)</label></td>
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.danToc" /></label><label class="egov-label-red">(*)</label></td>
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.tonGiao" /></label><label class="egov-label-red">(*)</label></td>
		    </tr>
		    <tr>
		      <td colspan="2">
			      <%
			      	List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.getDSGioiTinh();
			      %>
			      <select name="gioiTinh" id="gioiTinh" class = "egov-select custom" style="width:99%; display:block;">
			      	<option id = "Chọn" value = "">--Chọn--</option>
			      	   	<%
			        		String selected = "";
			      	   		for ( GioiTinh gioiTinh: gioiTinhList) {
				      	  		if ( gioiTinh.getId() == Long.parseLong(userRequest.get("IDGIOITINH") ) ) {
			        				selected = "selected";
			        			} else {
			        				selected = "";
			        			}
			        	%>
			        	<option value = "<%=gioiTinh.getId()%>" <%=selected %>><%=gioiTinh.getTen() %></option>
			        	<%} %>
			      </select></td>
		      <td colspan="2">
			      <%
			      	List <DanToc> danTocList = DanTocLocalServiceUtil.findAll();
			      
			      %>
			      <select name="danToc" id="danToc" class = "egov-select custom" style="width:99%; display:block;">
			      		<option id = "Chọn" value = "">--Chọn--</option>
			      		<%
			        		selected = "";
			      			for ( DanToc danToc: danTocList) {
			      				if ( danToc.getId() == Long.parseLong(userRequest.get("IDDANTOC") ) ) {
			        				selected = "selected";
			        			} else {
			        				selected = "";
			        			}
			        	%>
			        	<option value = "<%=danToc.getId()%>" <%=selected %>><%=danToc.getTen() %></option>
			        	<%} %>
			      </select></td>
		      <td colspan="2">
			      <%
			      	List <TonGiao> tonGiaoList = TonGiaoLocalServiceUtil.findAll();
			      %>
			      <select name="tonGiao" id="tonGiao" class = "egov-select custom" style="width:99%; display:block;">
		      	   		<option id = "Chọn" value = "">--Chọn--</option>
		      	   	<%
		        		selected = "";
		      	   		for ( TonGiao tonGiao: tonGiaoList) {
			      	   		if ( tonGiao.getId() == Long.parseLong(userRequest.get("IDTONGIAO") ) ) {
		        				selected = "selected";
		        			} else {
		        				selected = "";
		        			}
		        	%>
		        	<option value = "<%=tonGiao.getId()%>" <%=selected%>><%=tonGiao.getTen() %></option>
		        	<%} %>
			      </select></td>
		    </tr>
			
			<!-- thuong tru -->
			 <tr>
		     	<td colspan="6"><label class ="egov-label-bold">Địa chỉ thường trú</label></td>
		     </tr>
		   <tr>
			   <td colspan="6"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.user.form.endorse.motaThuongTru" /></label></td>
		   </tr>
		   <tr>
			 <td colspan="6">
		      	<input name="motaThuongTru" type="text" id="motaThuongTru" style = 'width:97%' maxlength="100" 
		      		class = "egov-inputfield" value = "<%=userRequest.get("MOTADIACHITHUONGTRU")%>" />
		      </td>
		    </tr>
			
			
			<tr>
		      <td colspan="2"><label class ="egov-label-bold">Tỉnh/ Thành phố</label><label class="egov-label-red">(*)</label></td>
		      <td colspan="2"><label class ="egov-label-bold">Quận/ Huyện</label><label class="egov-label-red">(*)</label></td>
		      <td colspan="2"><label class ="egov-label-bold">Phường/ Xã</label><label class="egov-label-red">(*)</label></td>
		    </tr>
		    <tr>
		      <td colspan="2">
		      		<select name="tinhThuongTru" id="thuongtru_tinhthanh" class = "egov-select custom" style="width:99%; display:block;">
						<option id = "Chọn" value = "">--Chọn Tỉnh--</option>
		      	<% 		   
					long idTinhThuongTru = Long.parseLong(userRequest.get("IDTINHTHANHTHUONGTRU"));
				%>
					<%
					for (DonViHanhChinh tinhThanh: tinhThanhList) {
						selected = "";
						if ( tinhThanh.getId() == idTinhThuongTru){
							selected = "selected";
						}
					%>
						<option value="<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen()%></option>
							
				 <%	} // for
				  %>		      
		      
		      </select></td>
		      <td colspan="2">
		      		<select name="huyenThuongTru" id="thuongtru_quanhuyen" class = "egov-select custom" style="width:99%; display:block;">
						<option id = "Chọn" value = "">--Chọn Huyện--</option>
		      	<% 		   
					long idHuyenThuongTru = Long.parseLong(userRequest.get("IDQUANHUYENTHUONGTRU"));
					if ( idHuyenThuongTru  < 1){ %>
					<%} else { 
						// Get quan huyen belong to tinh thanh
						if (idTinhThuongTru > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(idTinhThuongTru, 0);
									
							for (DonViHanhChinh quanHuyen: quanHuyenList) {
								selected = "";
								if ( quanHuyen.getId() == idHuyenThuongTru){
									selected = "selected";
								}
						%>
								<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
							
				  <%		} // for
						} // If
				 } %>
		      </select></td>
		      <td  colspan="2">
		      		<select name="xaThuongTru" id="thuongtru_phuongxa" class = "egov-select custom" style="width:99%; display:block;">
						<option id = "Chọn" value = "">--Chọn Xã--</option>
		      	<% 		   
					long idXaThuongTru = Long.parseLong(userRequest.get("IDPHUONGXATHUONGTRU"));
					if ( idXaThuongTru < 1){ %>
					<%} else { 
						// Get quan huyen belong to quan huyen
						if (idHuyenThuongTru > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyenThuongTru, 0);
									
							for (DonViHanhChinh phuongXa: phuongXaList) {
								selected = "";
								if ( phuongXa.getId() == idXaThuongTru){
									selected = "selected";
								}
						%>
								<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>
							
				  <%		} // for
						} // If
				 } %>
		      </select></td>
		    </tr>
			
		    <tr>
		      <td colspan="3">&nbsp;</td>
		      <td colspan="3">&nbsp;</td>
		    </tr>
		    <tr>
		      <td colspan="6" align = "center">
		      	<%			
				// Create upload avatar URL
				PortletURL backUrl = renderResponse.createRenderURL();	
		      	backUrl.setParameter("jspPage","/html/portlet/endorse/view.jsp");
		      	
				PortletURL redirectUrl = renderResponse.createRenderURL();	
				redirectUrl.setParameter("jspPage","/html/portlet/endorse/endorse.jsp");
		      	
		      	%>
		      	<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl %>" />
		      	
		      	<input type = "hidden" name = "successUrl" value = "<%=backUrl %>" />
		   
		   		<%
		   			if (status != StringUtil.TRANG_THAI_YEU_CAU_DK_CONG_DAN_DA_CHUNG_THUC) {
		   		%>
		      			<input type="submit" class = "egov-button" name="submitButton"  value="Xác thực" />
		      			<input type="button" class = "egov-button" name="cancelButton"  value="Hủy đăng ký" onclick="submitForm('<%=huyDangKy%>')" />
		     	<%  } %>
		     	
		      	<a href = "<%=backUrl %>" >
		      		<input type="button" id="backButton" class = "egov-button" name="backButton"  value="<liferay-ui:message key="org.oep.cmon.user.form.endorse.backButton"/>" />
		      	</a>		      	
		      </td>
		    </tr>
		  </table>
		</form>
		
		   	<%
		      		
		      		if ( status == 2) {		      		
		      %>
		      <script type="text/javascript">
		      	disableForm(document.endorseForm);
		      </script>
		      <%
		      		}
		      %>
	</div>
	<br/>
