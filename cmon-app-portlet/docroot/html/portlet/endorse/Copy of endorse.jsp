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
		theform.elements[i].disabled = true;
	}
}
</script>

<%
	// Get user request from session
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
	
	PortletURL endorseUrl = renderResponse.createActionURL();
	endorseUrl.setParameter(ActionRequest.ACTION_NAME, "endorse");
	
%>
	<div class="egov-container">	
		<form id="endorseForm" name="endorseForm" method="post" action="<%=endorseUrl%>">
		  <table class = "egov-table-form2" style = 'width:90%'>
		    <tr>
		      <td colspan="6" align = "left">		      	
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.hoCongDan" message = "org.oep.cmon.user.form.endorse.err.hoCongDan"/>
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tenCongDan" message = "org.oep.cmon.user.form.endorse.err.tenCongDan"/>
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.soCmnd"  message = "org.oep.cmon.user.form.endorse.err.soCmnd" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngayCapCmnd"  message = "org.oep.cmon.user.form.endorse.err.ngayCapCmnd" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.noiCapCmnd"  message = "org.oep.cmon.user.form.endorse.err.noiCapCmnd" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.email"  message = "org.oep.cmon.user.form.endorse.err.email" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.gioiTinh"  message = "org.oep.cmon.user.form.endorse.err.gioiTinh" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.danToc"  message = "org.oep.cmon.user.form.endorse.err.danToc" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tonGiao"  message = "org.oep.cmon.user.form.endorse.err.tonGiao" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.quocTich"  message = "org.oep.cmon.user.form.endorse.err.quocTich" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngaySinh"  message = "org.oep.cmon.user.form.endorse.err.ngaySinh" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ngaySinh.greaterThanCurrent"  message = "org.oep.cmon.user.form.endorse.err.ngaySinh.greaterThanCurrent" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tinhTrangHonNhan"  message = "org.oep.cmon.user.form.endorse.err.tinhTrangHonNhan" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tinhNoiSinh"  message = "org.oep.cmon.user.form.endorse.err.tinhNoiSinh" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.huyenNoiSinh"  message = "org.oep.cmon.user.form.endorse.err.huyenNoiSinh" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.xaNoiSinh"  message = "org.oep.cmon.user.form.endorse.err.xaNoiSinh" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tinhThuongTru"  message = "org.oep.cmon.user.form.endorse.err.tinhThuongTru" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.huyenThuongTru"  message = "org.oep.cmon.user.form.endorse.err.huyenThuongTru" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.xaThuongTru"  message = "org.oep.cmon.user.form.endorse.err.xaThuongTru" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.tinhHienTai"  message = "org.oep.cmon.user.form.endorse.err.tinhHienTai" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.huyenHienTai"  message = "org.oep.cmon.user.form.endorse.err.huyenHienTai" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.xaHienTai"  message = "org.oep.cmon.user.form.endorse.err.xaHienTai" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.soHoKhau"  message = "org.oep.cmon.user.form.endorse.err.soHoKhau" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.chuHo"  message = "org.oep.cmon.user.form.endorse.err.chuHo" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.quanHeChuHo"  message = "org.oep.cmon.user.form.endorse.err.quanHeChuHo" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.motaNoiSinh"  message = "org.oep.cmon.user.form.endorse.err.motaNoiSinh" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.motaThuongTru"  message = "org.oep.cmon.user.form.endorse.err.motaThuongTru" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.motaDiachiHienTai"  message = "org.oep.cmon.user.form.endorse.err.motaDiachiHienTai" />
				<liferay-ui:error key="org.oep.cmon.user.form.endorse.err.ldap"  message = "org.oep.cmon.user.form.endorse.err.ldap" />
				</td>	
		    </tr>
		    <tr>
		      <td width="10" colspan="3" scope="col"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.hoVaTen"/> <font color = "red">(*)</font></label></td>
		      <td width="20" colspan="3" rowspan="8" scope="col">
			      <table class = "egov-table-form2">
			        <tr>
			          <td valign = "top">
			          	<%
			          	int status = Integer.parseInt(userRequest.get("TRANGTHAIYEUCAU"));
			          	
			          	PortletURL uploadUrl = renderResponse.createRenderURL();
			          	// This will remove header and footer in theme
			          	uploadUrl.setWindowState(LiferayWindowState.POP_UP);
			          	uploadUrl.setParameter("jspPage","/html/portlet/endorse/upload_avatar.jsp");
			          	uploadUrl.setParameter("status", status + "");
							
			          	%>
			          	<iframe src = "<%=uploadUrl %>" frameborder="0" scrolling = "no" height = "215px"></iframe>
			          </td>
			        </tr>			        
			      </table>
		      </td>
		    </tr>
		    <tr>
		      <td><input name="ho" type="text" id="ho"  maxlength="20" class = "egov-inputfield custom" value = "<%=userRequest.get("HOCONGDAN")%>" style = 'width:85%'/></td>
		      <td><input name="dem" type="text" id="dem"  maxlength="50" class = "egov-inputfield custom" value = "<%=userRequest.get("TENDEM")%>" style = 'width:85%'/></td>
		      <td><input name="ten" type="text" id="ten"  maxlength="20" class = "egov-inputfield custom" value = "<%=userRequest.get("TENCONGDAN")%>" style = 'width:85%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.soCmnd" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="soCmnd" type="text" id="soCmnd"  maxlength="12" class = "egov-inputfield custom" value = "<%=userRequest.get("SOCMND")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngayCapCmnd" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="ngayCapCmnd" type="text" id="ngayCapCmnd" maxlength="10" class = "egov-calendar custom" value = "<%=userRequest.get("NGAYCAPCMND")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.noiCapCmnd" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <%
				List <DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
		      	
		      %>
		        <select name="noiCapCmnd" id="noiCapCmnd" class = "egov-select custom" style="width:99%; display:block;">
		        	<%
		        		String selected = "";
		        		for ( DonViHanhChinh tinhThanh: tinhThanhList) {
		        			if ( tinhThanh.getId() == Long.parseLong(userRequest.get("IDNOICAPCMND") ) ) {
		        				selected = "selected";
		        			}else {
		        				selected = "";
		        			}
		        	%>
		        			<option value = "<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen() %></option>
		        	<%} %>
		      </select></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ghiChuCmnd" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.email" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="ghiChuCmnd" type="text" id="ghiChuCmnd" maxlength="150" class = "egov-inputfield custom" value = "<%=userRequest.get("GHICHUCMND")%>" style = 'width:95%'/></td>
		      <td colspan="3">
		      <input name="email" type="text" id="email"  maxlength="50" class = "egov-inputfield custom" value = "<%=userRequest.get("EMAIL")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.soHoChieu" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngayCapHoChieu" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="soHoChieu" type="text" id="soHoChieu"  maxlength="15" class = "egov-inputfield custom" value = "<%=userRequest.get("SOHOCHIEU")%>" style = 'width:95%'/></td>
		      <td colspan="3">
		      <input name="ngayCapHoChieu" type="text" id="ngayCapHoChieu" maxlength="10" class = "egov-calendar custom" value = "<%=userRequest.get("NGAYCAPHOCHIEU")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.noiCapHoChieu" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngayHetHanHoChieu" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      	<select name="noiCapHoChieu" id="noiCapHoChieu" class = "egov-select custom" style="width:99%; display:block;">
		      		<%
		      			selected = "";
		      			for ( DonViHanhChinh tinhThanh: tinhThanhList) {
		      				if ( tinhThanh.getId() == Long.parseLong(userRequest.get("IDNOICAPHOCHIEU") ) ) {
		        				selected = "selected";
		        			}else {
		        				selected = "";
		        			}
		        	%>
		        	<option value = "<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen() %></option>
		        	<%} %>
		      	</select>
		      </td>
		      <td colspan="3">
		      <input name="ngayHetHanHoChieu" type="text" id="ngayHetHanHoChieu" maxlength="10" class = "egov-calendar custom" value = "<%=userRequest.get("NGAYHETHANHOCHIEU")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ghiChuHoChieu" /></label></td>
		      <td><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.gioiTinh" /> <font color = "red">(*)</font></label></td>
		      <td><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.danToc" /> <font color = "red">(*)</font></label></td>
		      <td><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.tonGiao" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="ghiChuHoChieu" type="text" id="ghiChuHoChieu"  class = "egov-inputfield custom" value = "<%=userRequest.get("GHICHUHOCHIEU")%>" style = 'width:95%'/></td>
		      <td>
		      <%
		      	List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.getDSGioiTinh();
		      %>
		      <select name="gioiTinh" id="gioiTinh" class = "egov-select custom" style="width:99%; display:block;">
		      	   	<%
		        		selected = "";
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
		      <td>
		      <%
		      	List <DanToc> danTocList = DanTocLocalServiceUtil.findAll();
		      
		      %>
		      <select name="danToc" id="danToc" class = "egov-select custom" style="width:99%; display:block;">
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
		      <td>
		      <%
		      	List <TonGiao> tonGiaoList = TonGiaoLocalServiceUtil.findAll();
		      %>
		      <select name="tonGiao" id="tonGiao" class = "egov-select custom" style="width:99%; display:block;">
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
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.quocTich" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngaySinh" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      	<%
		      		List <QuocGia> quocGiaList = QuocGiaLocalServiceUtil.findAll();
		      	%>
		        <select name="quocTich" id="quocTich" class = "egov-select custom" style="width:99%; display:block;">
		        <%
	        		selected = "";
		        	for ( QuocGia quocGia: quocGiaList) {
		        		if ( quocGia.getId() == Long.parseLong(userRequest.get("IDQUOCTICH") ) ) {
	        				selected = "selected";
	        			}else {
	        				selected = "";
	        			}
	        	%>
	        	<option value = "<%=quocGia.getId()%>" <%=selected %>><%=quocGia.getTen() %></option>
	        	<%} %>
		        </select>
		     </td>
		      <td colspan="3">
		      <input name="ngaySinh" type="text" id="ngaySinh" class = "egov-calendar custom" value = "<%=userRequest.get("NGAYSINH")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.dtCoDinh" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.dtDiDong" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="dtCoDinh" type="text" id="dtCoDinh" maxlength="15" class = "egov-inputfield custom"  value = "<%=userRequest.get("DIENTHOAICODINH")%>" style = 'width:95%'/></td>
		      <td colspan="3">
		      <input name="dtDiDong" type="text" id="dtDiDong" maxlength="15" class = "egov-inputfield custom" value = "<%=userRequest.get("DIENTHOAIDIDONG")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.trinhDoHocVan" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.soBhyt" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <%
		      	List <TrinhDoHocVan> trinhDoHocVanList = TrinhDoHocVanLocalServiceUtil.findAll();
		      %>
		      <select name="trinhDoHocVan" id="trinhDoHocVan" class = "egov-select custom" style="width:99%; display:block;">
		      	<%
	        		selected = "";
		      		for ( TrinhDoHocVan trinhDoHocVan: trinhDoHocVanList) {
		      			if ( trinhDoHocVan.getId() == Long.parseLong(userRequest.get("IDTRINHDOHOCVAN") ) ) {
	        				selected = "selected";
	        			}else {
	        				selected = "";
	        			}
	        	%>
	        	<option value = "<%=trinhDoHocVan.getId()%>" <%=selected %>><%=trinhDoHocVan.getTen() %></option>
	        	<%} %>
		      </select></td>
		      <td colspan="3">
		      <input name="soBhyt" type="text" id="soBhyt"  maxlength="15" class = "egov-inputfield custom" value = "<%=userRequest.get("SOBAOHIEMYTE")%>" style = 'width:95%'/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.mstCaNhan" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.ngheNghiep" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="mstCaNhan" type="text" id="mstCaNhan"  maxlength="15" class = "egov-inputfield custom" value = "<%=userRequest.get("MASOTHUECANHAN")%>" style = 'width:95%'/></td>
		      <td colspan="3">
		      <%
		      	List <NgheNghiep> ngheNghiepList = NgheNghiepLocalServiceUtil.findAll();
		      %>
		      <select name="ngheNghiep" id="ngheNghiep" class = "egov-select custom" style="width:99%; display:block;">
		      	<%
	        		selected = "";
		      		for ( NgheNghiep ngheNghiep: ngheNghiepList) {
		      			if ( ngheNghiep.getId() == Long.parseLong(userRequest.get("IDNGHENGHIEP") ) ) {
	        				selected = "selected";
	        			}else {
	        				selected = "";
	        			}
	        	%>
	        	<option value = "<%=ngheNghiep.getId()%>" <%=selected %>><%=ngheNghiep.getTen() %></option>
	        	<%} %>
		      </select></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.trinhDoChuyenMon" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.tinhTrangHonNhan" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <%
		      	List <TrinhDoChuyenMon> trinhDoChuyenMonList = TrinhDoChuyenMonLocalServiceUtil.findAll();
		      %>
		      <select name="trinhDoChuyenMon" id="trinhDoChuyenMon" class = "egov-select custom" style="width:99%; display:block;">
		      	<%
	        		selected = "";
		      		for ( TrinhDoChuyenMon trinhDoChuyenMon: trinhDoChuyenMonList) {
		    			if ( trinhDoChuyenMon.getId() == Long.parseLong(userRequest.get("IDTRINHDOCHUYENMON") ) ) {
	        				selected = "selected";
	        			}else {
	        				selected = "";
	        			}
	        	%>
	        	<option value = "<%=trinhDoChuyenMon.getId()%>" <%=selected %>><%=trinhDoChuyenMon.getTen() %></option>
	        	<%} %>
		      </select></td>
		      <td colspan="3">
		      <%
		     	List <TinhTrangHonNhan> tinhTrangHonNhanList = TinhTrangHonNhanLocalServiceUtil.getTinhTrangHonNhans(0, TinhTrangHonNhanLocalServiceUtil.getTinhTrangHonNhansCount());
		      %>
		      <select name="tinhTrangHonNhan" id="trinhTrangHonNhan" class = "egov-select custom" style="width:99%; display:block;">
		      	<%
	        		selected = "";
		      		for ( TinhTrangHonNhan tinhTrangHonNhan: tinhTrangHonNhanList) {
		    			if ( tinhTrangHonNhan.getId() == Long.parseLong(userRequest.get("IDTINHTRANGHONNHAN") ) ) {
	        				selected = "selected";
	        			}else {
	        				selected = "";
	        			}
	        	%>
	        	<option value = "<%=tinhTrangHonNhan.getId()%>" <%=selected %>><%=tinhTrangHonNhan.getTen() %></option>
	        	<%} %>
		      </select></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.noiSinh" /> <font color = "red">(*)</font></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.motaNoiSinh" /></label></td>
		    </tr>
		    <tr>
		      <td>		
		      <select name="tinhNoiSinh" id="noisinh_tinhthanh" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idTinhNoiSinh = Long.parseLong(userRequest.get("IDTINHTHANHNOISINH"));
					if ( idTinhNoiSinh < 1 ){ %>
						<option id = "Chọn" value = "" selected>Chọn</option>
					<%} 
					for (DonViHanhChinh tinhThanh: tinhThanhList) {
						selected = "";
						if ( tinhThanh.getId() == idTinhNoiSinh){
							selected = "selected";
						}
					%>
						<option value="<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen()%></option>
							
				 <%	} // for
				  %>		      
		      </select></td>
		      <td><select name="huyenNoiSinh" id="noisinh_quanhuyen" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idHuyenNoiSinh = Long.parseLong(userRequest.get("IDQUANHUYENNOISINH"));
					 if ( idHuyenNoiSinh < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
					<%} else { 
						// Get quan huyen belong to tinh thanh
						if (idTinhNoiSinh > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(idTinhNoiSinh, 0);
									
							for (DonViHanhChinh quanHuyen: quanHuyenList) {
								selected = "";
								if ( quanHuyen.getId() == idHuyenNoiSinh){
									selected = "selected";
								}
						%>
								<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
							
				  <%		} // for
						} // If
				 } %>
		      
		      </select></td>
		      <td><select name="xaNoiSinh" id="noisinh_phuongxa" class = "egov-select custom" style="width:99%; display:block;">
		      		<% 		   
					long idXaNoiSinh = Long.parseLong(userRequest.get("IDPHUONGXANOISINH"));
					if ( idXaNoiSinh < 1 ){ %>
						<option id = "Chọn" value = "">Chọn</option>
					<%} else { 
						// Get quan huyen belong to quan huyen
						if (idHuyenNoiSinh > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyenNoiSinh, 0);
									
							for (DonViHanhChinh phuongXa: phuongXaList) {
								selected = "";
								if ( phuongXa.getId() == idXaNoiSinh){
									selected = "selected";
								}
						%>
								<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>
							
				  <%		} // for
						} // If
				 } %>
		      
		      </select></td>
		      <td colspan="3">
		      <input name="motaNoisinh" type="text" id="motaNoisinh" style = 'width:95%' maxlength="100" class = "egov-inputfield custom" value = "<%=userRequest.get("MOTADIACHINOISINH")%>"/></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.noiThuongTru" /> <font color = "red">(*)</font></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.motaThuongTru" /></label></td>
		    </tr>
		    <tr>
		      <td><select name="tinhThuongTru" id="thuongtru_tinhthanh" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idTinhThuongTru = Long.parseLong(userRequest.get("IDTINHTHANHTHUONGTRU"));
					if ( idTinhThuongTru < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
					<%}
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
		      <td><select name="huyenThuongTru" id="thuongtru_quanhuyen" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idHuyenThuongTru = Long.parseLong(userRequest.get("IDQUANHUYENTHUONGTRU"));
					if ( idHuyenThuongTru  < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
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
		      <td><select name="xaThuongTru" id="thuongtru_phuongxa" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idXaThuongTru = Long.parseLong(userRequest.get("IDPHUONGXATHUONGTRU"));
					if ( idXaThuongTru < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
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
		      <td colspan="3">
		      <input name="motaThuongTru" type="text" id="motaThuongTru" style = 'width:95%' maxlength="100" class = "egov-inputfield custom" value = "<%=userRequest.get("MOTADIACHITHUONGTRU")%>" /></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.noiOHienTai" /> <font color = "red">(*)</font></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.motaDiaChiHienTai" /> <font color = "red">(*)</font></label></td>
		    </tr>
		    <tr>
		      <td><select name="tinhHienTai" id="noio_tinhthanh" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idTinhHienTai = Long.parseLong(userRequest.get("IDTINHTHANHHIENTAI"));
					if ( idTinhHienTai < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
					<%} 
					for (DonViHanhChinh tinhThanh: tinhThanhList) {
						selected = "";
						if ( tinhThanh.getId() == idTinhHienTai){
							selected = "selected";
						}
					%>
						<option value="<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen()%></option>
				 <%	
				 } // for
				  %>
		      </select></td>
		      <td><select name="huyenHienTai" id="noio_quanhuyen" class = "egov-select custom" style="width:99%; display:block;">
		      	<% 		   
					long idHuyenHienTai = Long.parseLong(userRequest.get("IDQUANHUYENHIENTAI"));
					if ( idHuyenHienTai < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
					<%} else { 
						// Get quan huyen belong to tinh thanh
						if (idTinhHienTai > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(idTinhHienTai, 0);
									
							for (DonViHanhChinh quanHuyen: quanHuyenList) {
								selected = "";
								if ( quanHuyen.getId() == idHuyenHienTai){
									selected = "selected";
								}
						%>
								<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
							
				  <%		} // for
						} // If
				 } %>
		      </select></td>
		      <td><select name="xaHienTai" id="noio_phuongxa" class = "egov-select custom" style="width:99%; display:block;">
		      		<% 		   
					long idXaHienTai = Long.parseLong(userRequest.get("IDPHUONGXAHIENTAI"));
					if ( idXaHienTai < 1){ %>
						<option id = "Chọn" value = "">Chọn</option>
					<%} else { 
						// Get quan huyen belong to quan huyen
						if (idHuyenHienTai > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyenHienTai, 0);
									
							for (DonViHanhChinh phuongXa: phuongXaList) {
								selected = "";
								if ( phuongXa.getId() == idXaHienTai){
									selected = "selected";
								}
						%>
								<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>
							
				  <%		} // for
						} // If
				 } %>
		      </select></td>
		      <td colspan="3"><input name="motaDiachiHienTai" type="text" id="motaDiachiHienTai" style = 'width:95%' maxlength="100" class = "egov-inputfield custom" value = "<%=userRequest.get("MOTADIACHIHIENTAI")%>"/></td>
		    </tr>		   
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.soHoKhau" /></label></td>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.chuHo" /></label></td>
		    </tr>
		    <tr>
		      <td colspan="3">
		      <input name="soHoKhau" type="text" id="soHoKhau" style = 'width:95%' maxlength="15" class = "egov-inputfield custom" value = "<%=userRequest.get("SOHOKHAU")%>"/></td>
		      <td colspan="3">
		      <% 
				String selectedOwner = "";
		      	String selectedNotOwner = "";
		      	int chuHo = Integer.parseInt(userRequest.get("CHUHO"));
		      	
				if ( 1 == chuHo ) {
					selectedOwner = "selected";
				}
				
				if ( 0 == chuHo) {
					selectedNotOwner = "selected";
				}
		      %>
		      <select name="chuHo" id="chuHo" class = "egov-select custom" style="width:99%; display:block;">
					<option value = "0" <%=selectedNotOwner%>>Không phải chủ hộ</option>
					<option value = "1" <%=selectedOwner%>>Là chủ hộ</option>					
		      </select></td>
		    </tr>
		    <tr>
		      <td colspan="3"><label class ="egov-label"><liferay-ui:message key="org.oep.cmon.user.form.endorse.quanHeVoiChuHo" /></label></td>
		      <td colspan="3">&nbsp;</td>
		    </tr>
		    <tr>
		      <td colspan="3">
		       <%
		      	List <QuanHeGiaDinh> quanHeGiaDinhList = QuanHeGiaDinhLocalServiceUtil.findAll();
		      %>
		      <select name="quanHeChuHo" id="quanHeChuHo" class = "egov-select custom" style="width:99%; display:block;">
		      	<%
	        		
		      		for ( QuanHeGiaDinh quanHeGiaDinh: quanHeGiaDinhList) {
		      			selected = "";
		      			if ( quanHeGiaDinh.getId() == Long.parseLong(userRequest.get("IDQUANHE") ) ) {
	        				selected = "selected";
	        			}
		      			
	        	%>
	        	<option value = "<%=quanHeGiaDinh.getId()%>" <%=selected %>><%=quanHeGiaDinh.getTen() %></option>
	        	<%} %>
		      </select></td>
		      <td colspan="3">&nbsp;</td>
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
		   
		      	<input type="submit" class = "egov-button" name="submitButton"  value="<liferay-ui:message key="org.oep.cmon.user.form.endorse.submitButton"/>" />
		     
		      	<a href = "<%=backUrl %>" >
		      		<input type="button" class = "egov-button" name="backButton"  value="<liferay-ui:message key="org.oep.cmon.user.form.endorse.backButton"/>" />
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
/*
YeuCauDangKyCongDan yeuCauDB = new YeuCauDangKyCongDanImpl();
yeuCauDB.setId(CounterLocalServiceUtil.increment("CSMS_YEUCAUDANGKYCONGDAN"));

yeuCauDB.setHoCongDan("HOCONGDAN");

yeuCauDB.setTenDem("TENDEM");

yeuCauDB.setTenCongDan("TENCONGDAN");

yeuCauDB.setSoCmnd("SOCMND");

yeuCauDB.setGhiChuCmnd("GHICHUCMND");

yeuCauDB.setEmail("EMAIL");

yeuCauDB.setSoHoChieu("SOHOCHIEU");

yeuCauDB.setSoBaoHiemYte("SOBAOHIEMYTE");

yeuCauDB.setMaSoThueCaNhan("MASOTHUECANHAN");

yeuCauDB.setSoHoKhau("SOHOKHAU");

yeuCauDB.setTrangThaiYeuCau(0); // Endorsed		

	yeuCauDB.setLoaiYeuCau(0); // 0: register citizen and account

yeuCauDB.setTrangThaiYeuCau(0); // 0: Newly

yeuCauDB.setXoa(0);

Date currentDate =  new Date();

yeuCauDB.setNgayYeuCau(currentDate);

yeuCauDB.setNgayTao(currentDate);

yeuCauDB.setNgaySua(currentDate);

User currentUser = PortalUtil.getUser(renderRequest);

if ( currentUser != null) {		
	yeuCauDB.setNguoiTao(currentUser.getFullName());
	
	yeuCauDB.setNguoiSua(currentUser.getFullName());			
} else {
	yeuCauDB.setNguoiTao("DUMMY");
	
	yeuCauDB.setNguoiSua("DUMMY");
}

YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(yeuCauDB);
*/
//