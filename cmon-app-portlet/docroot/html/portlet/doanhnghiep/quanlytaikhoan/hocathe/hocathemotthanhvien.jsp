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
<meta http-equiv="pragma" content="no-cache" />
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.HoCaTheFormModel"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.DanToc"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<html>
<style>
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	border:none !important;
	padding: 0px 10px !important;	
}
</style>	

<portlet:renderURL var="popupHCTSearch" 
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/popup_HCTSearch.jsp" />
</portlet:renderURL>


<portlet:renderURL var="popupCDSearch" 
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_congDanSearch.jsp" />
</portlet:renderURL>


<portlet:resourceURL var="getDVHCNDD" id="getDVHCNDD" />
<portlet:resourceURL var="getDVHCHCT" id="getDVHCHCT" />


<script type="text/javascript" >


function openWindowHCT(url) {
	var width = (screen.width) * 90 / 100;
	var newWindow = window
			.open(url,
					'Search popupHCT',
					'height=650,width='+ width +',scrollbars=yes,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

	if (window.focus) {
		newWindow.focus();
	}

	return false;
} 








function openWindowCD(url) {
	var width = (screen.width) * 90 / 100;
	var newWindow = window
			.open(url,
					'Search popupCD',
					'height=650,width='+ width +',scrollbars=yes,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

	if (window.focus) {
		newWindow.focus();
	}

	return false;
} 









/* this.newWindow = window.open(url,'congdan popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
if (window.focus) {
	this.newWindow.focus();
}			
return this; */







</script>
<%
	String tt= ParamUtil.getString(request, "doiTuongDialog");
	String title="";
	if(tt.equals("3")){
		title= "Thêm mới tài khoản Doanh nghiep";
	}
	if(tt.equals("4")){
		title= "Thêm mới tài khoản Hợp tác xã";
	}
	if(tt.equals("5")){
		title= "Thêm mới tài khoản Hộ cá thể";
	}
	
	
	HoCaTheFormModel model= (HoCaTheFormModel)request.getAttribute("myForm");
	if (model == null) {
		model = new HoCaTheFormModel();
	}
%>

<div class="egov-container">
<form method="post" name="frmXacThucHoCaTheMotThanhVien" id="frmXacThucHoCaTheMotThanhVien">
	<table class="egov-table" width="100%">
		<thead>
			<tr>
				<td colspan="6">
					<h3><%=title %></h3>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='<portlet:namespace/>ten'><liferay-ui:error key="error_name_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.ten"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<label class="egov-label-bold" >Email</label><label class="egov-label-note" > (Tài khoản đăng nhập) </label><label class='egov-label-red'>(*)</label>
					<input type="text" id="email" name="email" class="egov-inputfield"/>
				</td>
				
				<td colspan="2" style="width: 30% !important">
						<br/>
						<input type="button" onclick="openWindowHCT('<%=popupHCTSearch%>')"  value="Tìm hộ cá thể" class="egov-button-search normal"/>
					</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class='egov-label-red'>Thông tin người đại diện</label>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Họ và tên </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" id="hoTenNDD" name ="hoTenNDD" class="egov-inputfield" style="width: 80% !important"/>
					<input type="button" value="Tìm kiếm" onclick="openWindowCD('<%=popupCDSearch%>')" class="egov-button-search"/>
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" id="ngaySinhNDD" name="ngaySinhNDD" class="egov-calendar" />
				</td>
			</tr>
			<tr>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Giới tính </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="gioiTinhNDD" name="gioiTinhNDD" >				
						<option value ="0">--Hãy chọn--</option>
						<%
						List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.findAll();
						
						if(gioiTinhList!=null && gioiTinhList.size()>0){
		      	   		for ( GioiTinh gioiTinh: gioiTinhList) {
		      	   			String selected = "";			      	   		
		      	   			if ((model.getGioiTinhNDD() !=null)  && gioiTinh.getId() 
		      	   					== Long.parseLong(model.getGioiTinhNDD()) ) {
		        				selected = "selected";
		        			} 
			        	%>
			        	<option value = "<%=gioiTinh.getId()%>" <%=selected %> ><%=gioiTinh.getTen() %></option>
			        	<%} 
			        	}%>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Quốc tịch </label><br/>
					<select class="egov-select" id="quocTichNDD" name="quocTichNDD">
						<option value ="0">--Hãy chọn--</option>
						<%
						List <QuocGia> quocGiaList =  QuocGiaLocalServiceUtil.findAll();
						
						if(quocGiaList!=null && quocGiaList.size()>0){
		      	   		for ( QuocGia qg: quocGiaList) {
		      	   			String selected = "";			      	   		
		      	   			if ((model.getQuocTichNDD() !=null)  && qg.getId() 
		      	   					== Long.parseLong(model.getQuocTichNDD()) ) {
		        				selected = "selected";
		        			} 
			        	%>
			        	<option value = "<%=qg.getId()%>" <%=selected %> ><%=qg.getTen() %></option>
			        	<%} 
			        	}%>
						
						
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Dân tộc </label><br/>
					<select class="egov-select" id="danTocNDD" name="danTocNDD">
						<option value ="0">--Hãy chọn--</option>
						<%
						List <DanToc> danTocList = DanTocLocalServiceUtil.findAll();
						
						if(danTocList!=null && danTocList.size()>0){
		      	   		for ( DanToc dt: danTocList) {
		      	   			String selected = "";			      	   		
		      	   			if ((model.getDanTocNDD() !=null)  && dt.getId() 
		      	   					== Long.parseLong(model.getDanTocNDD()) ) {
		        				selected = "selected";
		        			} 
			        	%>
			        	<option value = "<%=dt.getId()%>" <%=selected %> ><%=dt.getTen() %></option>
			        	<%} 
			        	}%>
						
						
						
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Số CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" id="soCMNDNDD" name="soCMNDNDD"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" class="egov-calendar" id="ngayCapCMNDNDD" name="ngayCapCMNDNDD"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" id="noiCapCMNDNDD" name="noiCapCMNDNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Địa chỉ thường trú </label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tinhTTNDD" name="tinhTTNDD" onChange="reDrawSelectBox('tinhTTNDD','huyenTTNDD')">
						<option value="0">--Hãy chọn--</option>
						<% 		   
		      				List <DonViHanhChinh> list_tinh = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
							long diaChiThuongTruTinhId = 0;
							if (model.getTinhTTNDD() != null) {
				      			diaChiThuongTruTinhId = Long.parseLong(model.getTinhTTNDD());
				      		}
							
							for(int i=0;i<list_tinh.size();i++){ 
						    	 DonViHanhChinh donvihanhchinh = list_tinh.get(i);
						    	 String selected = "";
						    	 if (donvihanhchinh.getId() == diaChiThuongTruTinhId){
										selected = "selected";
									}
								%>
								<option value="<%=donvihanhchinh.getId()%>" <%=selected %>><%=donvihanhchinh.getTen()%></option>
								
								<%
								}
								%>
								
							
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="huyenTTNDD" name="huyenTTNDD" onChange="reDrawSelectBox('huyenTTNDD','xaTTNDD')" onload="reDrawSelectBox('huyenTTNDD','xaTTNDD')">
						<option value="0">--Hãy chọn--</option>
						<%   
							long diaChiThuongTruHuyenId= 0;
				      		if (model.getHuyenTTNDD() != null) {
				      			diaChiThuongTruHuyenId = Long.parseLong(model.getHuyenTTNDD());
				      		}
						
				      	// Get quan huyen belong to tinh thanh
							if (diaChiThuongTruTinhId > 0) {
								// Get all quan huyen
								List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(diaChiThuongTruTinhId, 0);
										
								for (DonViHanhChinh quanHuyen: quanHuyenList) {
									String selected = "";
									if ( quanHuyen.getId() == diaChiThuongTruHuyenId){
										selected = "selected";
									}
							%>
									<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
			
									<%} 
							} %>
						
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="xaTTNDD" name="xaTTNDD">
						<option value="0">--Hãy chọn--</option>
						<%
						long diaChiThuongTruXaId = 0;
			      		
			    		if (model.getXaTTNDD() != null) {
			    			diaChiThuongTruXaId = Long.parseLong(model.getXaTTNDD());
			      		}
			    		
						 
							// Get quan huyen belong to quan huyen
							if (diaChiThuongTruHuyenId > 0) {
								// Get all quan huyen
								List <DonViHanhChinh> phuongXaList =DonViHanhChinhLocalServiceUtil.findByChaId(diaChiThuongTruHuyenId, 0);
										
								for (DonViHanhChinh phuongXa: phuongXaList) {
									String selected = "";
									if ( phuongXa.getId() == diaChiThuongTruXaId){
										selected = "selected";
									}
							%>
									<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>

									<%}
							}%>
						
						
						
						
						
					
						
						
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" id="moTaTTNDD" name="moTaTTNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Chỗ ở hiện tại </label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tinhHTNDD" name="tinhHTNDD" onChange="reDrawSelectBox('tinhHTNDD','huyenHTNDD')">
						<option value="0">--Hãy chọn--</option>
						<% 		   
		      				List <DonViHanhChinh> listTinhHT = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
							long tinhIdHT = 0;
							if (model.getTinhHTNDD() != null) {
								tinhIdHT = Long.parseLong(model.getTinhHTNDD());
				      		}
							
							for(int i=0;i<listTinhHT.size();i++){ 
						    	 DonViHanhChinh donvihanhchinh = listTinhHT.get(i);
						    	 String selected = "";
						    	 if (donvihanhchinh.getId() == tinhIdHT){
										selected = "selected";
									}
								%>
								<option value="<%=donvihanhchinh.getId()%>" <%=selected %>><%=donvihanhchinh.getTen()%></option>
								
								<%
								}
								%>
						
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="huyenHTNDD" name="huyenHTNDD" onChange="reDrawSelectBox('huyenHTNDD','xaHTNDD')">
						<option value="0">--Hãy chọn--</option>
						<%   
							long diaChiHienTaiHuyenId= 0;
				      		if (model.getHuyenHTNDD() != null) {
				      			diaChiHienTaiHuyenId = Long.parseLong(model.getHuyenHTNDD());
				      		}
						
				      	// Get quan huyen belong to tinh thanh
							if (tinhIdHT > 0) {
								// Get all quan huyen
								List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(tinhIdHT, 0);
										
								for (DonViHanhChinh quanHuyen: quanHuyenList) {
									String selected = "";
									if ( quanHuyen.getId() == diaChiHienTaiHuyenId){
										selected = "selected";
									}
							%>
									<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
			
									<%} 
							} %>
						
						
						
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="xaHTNDD" name="xaHTNDD">
						<option value="0">--Hãy chọn--</option>
						<%
						long diaChiHienTaiXaId = 0;
			      		
			    		if (model.getXaTTNDD() != null) {
			    			diaChiHienTaiXaId = Long.parseLong(model.getXaTTNDD());
			      		}
			    		
						 
							// Get quan huyen belong to quan huyen
							if (diaChiHienTaiHuyenId > 0) {
								// Get all quan huyen
								List <DonViHanhChinh> phuongXaList =DonViHanhChinhLocalServiceUtil.findByChaId(diaChiHienTaiHuyenId, 0);
										
								for (DonViHanhChinh phuongXa: phuongXaList) {
									String selected = "";
									if ( phuongXa.getId() == diaChiHienTaiXaId){
										selected = "selected";
									}
							%>
									<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>

									<%}
							}%>
						
						
						
						
						
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả chỗ ở </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" id="moTaHTNDD" name="moTaHTNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Điện thoại </label><br/>
					<input type="text" class="egov-inputfield" id="dienThoaiNDD" name="dienThoaiNDD"/>
				</td>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" class="egov-inputfield" id="faxNDD" name="faxNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" class="egov-inputfield" id="emailNDD" name="emailNDD"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" class="egov-inputfield" id="websiteNDD" name="websiteNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class='egov-label-red'>Thông tin kinh doanh hộ cá thể</label>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Tên </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" id="tenHoCaThe" name="tenHoCaThe" style="width: 80% !important"/>
					
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="maGiayPhep" name="maGiayPhep" class="egov-inputfield" />
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Địa chỉ kinh doanh </label>					
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select id="tinhId" name="tinhId" class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select  id="huyenId" name="huyenId" class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select id="xaId" name="xaId" class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			
			<tr>
				<td colspan="6" >
					<label class="egov-label-bold" >Chi tiết địa chỉ </label><label class='egov-label-red'>(*)</label>
					<input type="text" name="chiTietDiaDiem" class="egov-inputfield"/>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Mã số thuế </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" name="maSoThue" id="maSoThue" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày đăng ký </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" name="ngayDangKy" id="ngayDangKy" class="egov-calendar"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Vốn kinh doanh (VNĐ) </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" name="vonKinhDoanh" id="vonKinhDoanh" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Điện thoại </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" name="dienThoai"  class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" name="fax" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text"  name="email" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" name="website" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả ngành nghề </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text"  name="moTaNgheNghiep" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Loại hộ kinh doanh </label><label class='egov-label-red'>(*)</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Radio" class="egov-radio" name="loaiHoKinhDoanh" value="caNhan" onclick="showOrHideDanhSachGopVon()" checked="checked"> Cá nhân&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Radio" class="egov-radio" name="loaiHoKinhDoanh" value="nhomTapThe" onclick="showOrHideDanhSachGopVon()"> Nhóm tập thể
				</td>
			</tr>
			<tr>
				<td colspan="6" style="padding: 0px">
					<div id="div-danh-sach-gop-von" style="display: none;">
						<%
						PortletURL urlPopup = renderResponse.createRenderURL();
						urlPopup.setParameter("jspPage","/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/addthanhviensanglap.jsp");
						urlPopup.setWindowState(LiferayWindowState.POP_UP);
						%>
						<h3>Danh sách góp vốn thành lập hộ kinh doanh</h3>
						<a href="#" style="float: right;">
							<input type="button" value="Thêm thành viên" class="egov-button" onclick="popupAddThanhVienSangLap('<%=urlPopup%>&js_fast_load=0&css_fast_load=0&strip=0')"/>
						</a>
						<table id="tbl-danh-sach-gop-von" class="egov-table" width="100%">
							<thead>
								<tr>
									<th style="text-align: center;" >STT</th>
									<th style="text-align: center;" >Họ và tên</th>
									<th style="text-align: center;" >CMND/Hộ chiếu</th>
									<th style="text-align: center;" >Địa chỉ thường trú</th>
									<th style="text-align: center;" >Giá trị góp vốn</th>
									<th style="text-align: center;" >Tỷ lệ (%)</th>
									<th style="text-align: center;" >Hành động</th>
								</tr>	
							</thead>
							<tbody>
						
								<tr id="thanh-vien-1" style="display: none;">
									<td style="border: #d6d6d6 solid 1px !important;text-align: center;" id="stt" ></td>
									<td style="border: #d6d6d6 solid 1px !important;" id="tenTV" ></td>
									<td style="border: #d6d6d6 solid 1px !important;text-align: center;" id="cmndTV"></td>
									<td style="border: #d6d6d6 solid 1px !important;" id="diaChiTTTV"></td>
									<td style="border: #d6d6d6 solid 1px !important;text-align: center;" id="gopVonTV"></td>
									<td style="border: #d6d6d6 solid 1px !important;text-align: center;" id="tyLeTV"></td>
									<td style="border: #d6d6d6 solid 1px !important;text-align: center;" ><a href='javascript:void(0)' class="deleteRowTV">Xóa</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="6" style="padding: 0px !important">
					<table class="egov-table" width="100%" border="0">
						<tbody>
							<tr>
								<td width="40%">
									<label class="egov-label-bold" >Ngành nghề kinh doanh</label><br/>
									<select name="" id="select-system-id" class="egov-multi-select" multiple="multiple" size="11">
										<option>abc</option>
										<option>cde</option>
									</select>
										<!-- du lieu cache du lieu nguon -->
									<select id="select-data-system" name="" style="display:none;">
										<option>abc</option>
										<option>cde</option>
									</select>
									<div>
					   					<input id="input-search-nganh-nghe" style="width: 70% !important" type="text" class="egov-inputfield"  onkeyup="searchOptions(this.value,'select-data-system','select-system-id','select-selected-id');" />
					   					<input type="button" value="reset" class="egov-button" onclick="resetSearchNganhNghe();" >
					   				</div>
								</td>
								<td width="10%" style="text-align: center !important">
									<input type="button" class="egov-func-select" value=">>" 
									onclick="moveOptions('select-system-id','select-selected-id');">
									<br><br>
									<input  type="button" class="egov-func-select" value="<<" 
									onclick="moveOptions('select-selected-id','select-system-id');">
								</td>
								<td width="40%">
									<label class="egov-label-bold" >Ngành nghề được chọn </label><label class='egov-label-red'>(*)</label><br/>
									<select name="" id="select-selected-id" multiple="multiple" class="egov-multi-select" size="13">
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
			<%
				PortletURL backUrl = renderResponse.createRenderURL();
			 %>
				<td colspan="6" style="padding: 10px !important">
					<input type="button" class="egov-button" id="dangKy" value="Xác thực" onClick="selectAllSelected()">
					<input value="Hủy đăng ký"  type="button" class="egov-button-normal"  />
					<a href="<%=backUrl%>"><input value="Quay lại danh sách"  type="button" class="egov-button-normal"/></a>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</div>
</html>
<portlet:actionURL var="getDonViHanhChinhByIdURL" name="getDonViHanhChinhById">
	<portlet:param name="jspPage" value="/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathemotthanhvien.jsp"/>
</portlet:actionURL>
<script type="text/javascript" >
	
		var url = '<%= getDonViHanhChinhByIdURL.toString() %>';
		//Ve lai danh sach don vi hanh chinh
		function reDrawSelectBox(selectName, changeName , bien) {
			var id = $('#'+selectName).val();
			var obj = $('#'+changeName);
			var temp;
			if(bien != null && bien != "" && bien != 0)
				{
					temp = bien ;					
				}
			var xhtml='<option value=""> --Hãy chọn-- </option>';
			if (id == ""){
				obj.html(xhtml);
				return;
			}
			$.ajax({
				type: 'POST'
				,url: url
				,data : {id: id}
				,success: function(data) {	
					data = JSON.parse(data);
					for (var i = 0; i < data.id.length; i++) {					  	
					  	if(data.id[i] == temp){
					  		console.log("xuat temp: " + temp + "dataid :" + data.id[i]);
					  		xhtml +='<option selected = "selected" value="'+data.id[i]+'">'+data.name[i]+'</option>';
					  	}else{
					  		xhtml +='<option value="'+data.id[i]+'">'+data.name[i]+'</option>';
					  	}
					 	
					};
					obj.html(xhtml);  
				}
			});
		}


</script>


<script type="text/javascript" >



	//Change event Nguoi Dai Dien
	<%-- $("#tinhTTNDD").change(function(){ 
	  	var url="<%=getDVHCNDD%>";
	  	var parentId = $("#tinhTTNDD").val();	  
	  	$("#huyenTTNDD").empty();
	  	$("#xaTTNDD").empty();
	  	$("#huyenTTNDD").append("<option value='0'>-- Chọn Quận/Huyện --</option>");
	  	$("#xaTTNDD").append("<option value='0'>-- Chọn Phường/Xã --</option>");
	  	if (parentId != "") {	
	  		console.log("vao jsp :" );
			jQuery.getJSON(url+"&parentId=" + parentId, function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			   		
			   		console.log("xuat :" + donViHanhChinhArray);
			   		
			    	$("#huyenTTNDD").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	  	}
		});	 

	//Change event Nguoi Dai Dien
	$("#huyenTTNDD").change(function(){
		var url="<%= getDVHCNDD %>";
		var parentId = $("#huyenTTNDD").val();
		$("#xaTTNDD").empty();
		$("#xaTTNDD").append("<option value='0'>-- Chọn Phường/Xã --</option>");
		if (parentId != "") {
								jQuery.getJSON(url+ "&parentId="+ parentId,function(data) {
									for ( var i = 0; i < data.donViHanhChinhArray.length; i++) {
										donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
										$("#xaTTNDD").append("<option value='"+ donViHanhChinhArray[0] +"'>"+ donViHanhChinhArray[1]+ "</option> ");
									}
								});
							}

	});
	 --%>
	

				
				



function selectAllSelected(){
	$('#select-selected-id option').prop('selected', true);
}
function resetSearchNganhNghe(){
	$("input#input-search-nganh-nghe").val("");
	searchOptions('','select-data-system','select-system-id','select-selected-id');
}
function xoaThanhVien(id){
	$("#tbl-danh-sach-gop-von tr#"+id).remove();
}
function popupAddThanhVienSangLap(url){
	this.newWindow = window.open(url,'Search popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
	if (window.focus) {
		this.newWindow.focus();
	}			
	return this;
}
function showOrHideDanhSachGopVon(){
	var a = $("input:radio:checked").val();
	if(a=='nhomTapThe'){
		$("#div-danh-sach-gop-von").show();
	}else{
		$("#div-danh-sach-gop-von").hide();
	};
};




function dataNDD(data)
{
	
	alert("xuat " +data['hoten']);
	
	$('#hoTenNDD').val(data['hoten']);
	$('#ngaySinhNDD').val(data['ngaysinh']);
	$('#gioiTinhNDD').val(data['gioitinh']);
	$('#quocTichNDD').val(data['quocgiaid']);
	$('#danTocNDD').val(data['dantocid']);

	$('#soCMNDNDD').val(data['socmnd']);
	$('#ngayCapCMNDNDD').val(data['ngaycapcmnd']);	
	$('#noiCapCMNDNDD').val(data['noicapcmndid']);
	
	$('#tinhTTNDD').val(data['thuongtrutinhid']);
	$('#huyenTTNDD').val(data['thuongtruhuyenid']);	
	$('#xaTTNDD').val(data['thuongtruxaid']);
	$('#moTaTTNDD').val(data['diachithuongtru']);
	
	
	var huyenTTNDD = data['thuongtruhuyenid'];
	var xaTTNDD = data['thuongtruxaid'];
	
	reDrawSelectBox('tinhTTNDD', 'huyenTTNDD' ,huyenTTNDD);
	alert(" xa TT:" + xaTTNDD);
	reDrawSelectBox('huyenTTNDD', 'xaTTNDD' ,xaTTNDD);
	
	
	$('#tinhHTNDD').val(data['hiennaytinhid']);
	$('#huyenHTNDD').val(data['hiennayhuyenid']);	
	$('#xaHTNDD').val(data['hiennayxaid']);
	$('#moTaHTNDD').val(data['diachihiennay']);
	
	var huyenHTNDD = data['hiennayhuyenid'];
	var xaHTNDD = data['hiennayxaid'];
	//alert("Huyen :" + huyenHTNDD + " xa :" + xaHTNDD);
	reDrawSelectBox('tinhHTNDD', 'huyenHTNDD' ,huyenHTNDD);
	reDrawSelectBox('huyenHTNDD', 'xaHTNDD' ,xaHTNDD);
	
	
	$('#dienThoaiNDD').val(data['dtdd']);
	$('#faxNDD').val(data['fax']);	
	$('#emailNDD').val(data['email']);
	$('#websiteNDD').val(data['website']);
	
}


var i=1;
function addThanhVien(value){
	
	//Lay du lieu tu popup tra ve
	$('#stt').text(i++);	
	$('#tenTV').text(value['hoten']);
	$('#cmndTV').text(value['socmnd']);
	$('#diaChiTTTV').text(value['diachithuongtru']);
	$('#gopVonTV').text(value['gopVonTV']);
	$('#tyLeTV').text(value['tyLeTV']);
	
	//append row vào table Them thanh vien
	var bien=$('#thanh-vien-1').clone().html();		
	$('#tbl-danh-sach-gop-von > tbody:last').append('<tr>'+bien+'</tr>');
	
}

// Remove row dynamic table 
	$("#tbl-danh-sach-gop-von").delegate( '.deleteRowTV', 'click', function(ev){
		var rowCount = $('#tbl-danh-sach-gop-von tr').length;
		
		$(this).parents('tr').first().remove();				
		//Loop row table
		$('#tbl-danh-sach-gop-von > tbody  > tr').each(function() {	
			//Lay index cua row
			if( $(this).index() !=0){//bo row dau tien
				var stt = $(this).index();
				//Tim td dau tien, them so thu tu
				 $(this).find('td:eq(0)').text(stt);    
								
			}			
		});
		
		ev.preventDefault();
	 });
		 




</script>