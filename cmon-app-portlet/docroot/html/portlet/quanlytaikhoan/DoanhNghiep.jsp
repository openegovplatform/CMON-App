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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ include file="/html/portlet/init.jsp"%>

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

.cssTable th 
{
	text-align:center; 	    
}
	
	
</style>	
<script type="text/javascript" >
function openWindow(url) {
	var width = (screen.width) * 90 / 100;
	var newWindow = window
			.open(url,
					'Search popup',
					'height=650,width='+ width +',scrollbars=yes,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

	if (window.focus) {
		newWindow.focus();
	}

	return false;
} 

</script>


	<%               /*  PortletURL searchUrl = renderResponse.createRenderURL(); 
								 	// This will remove header and footer in theme
								 	searchUrl.setWindowState(LiferayWindowState.POP_UP);
								 	
								 	searchUrl.setParameter("jspPage",
								 			"/html/portlet/ipmslistportlet/popup_doanhNghiepSearch.jsp"); */
	            %>

<portlet:renderURL var="popupDNSearch" 
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="/html/portlet/ipmslistportlet/popup_doanhNghiepSearch.jsp" />
</portlet:renderURL>


<portlet:renderURL var="popupAddMem" 
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="/html/portlet/ipmslistportlet/popup_addMembers.jsp" />
</portlet:renderURL>


<portlet:renderURL var="popupCongDanSearch" 
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="/html/portlet/ipmslistportlet/popup_congDanSearch.jsp" />
</portlet:renderURL>



<div class="egov-container">

<div id="dialog_addMembers"  title="Thêm thành viên góp vốn" style="display: none;">
	<form>
		<table class="egov-table">
			<tr>
				<td colspan="2">
					<div class="left" style="width: 73%;">	
						<label class='egov-label-bold'>Tên thành viên</label><label class='egov-label-red'>(*)</label><br/>
						<input type="text" class="egov-inputfield"/>
					</div><br/>
					<div class="left"style="margin-left: 10pt;">
						<input type="button" onclick="openWindow('<%=popupCongDanSearch%>')" style="width: 100% !important;float: right;" value="Tìm công dân" class="egov-button-search normal"/>
					</div>
				</td>
				
			</tr>
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Số CMND / Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
					<input style="width: 50%;"type="text" class="egov-inputfield"/>	
				</td>
				
			</tr>
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				
			</tr>
			
			<tr>
				<td >
					<label class="egov-label-bold" >Giá trị góp vốn </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td >
					<label class="egov-label-bold" >Tỷ lệ góp vốn % </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>	
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Ghi chú </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				
			</tr>
			
			
			<tfoot>
			<tr>
				<td colspan="2" style="padding: 10px !important">
					<input type="submit" class="egov-button" id="Them" value="Thêm">
				   	<input type="button" class="egov-button" id="Dong" value="Đóng">
			      	
				</td>
			</tr>
		</tfoot>	
		</table>
	</form>

</div>

<form method="post" name="frmXacThucHoCaTheMotThanhVien" id="frmXacThucHoCaTheMotThanhVien">
	<table class="egov-table">
		<thead>
			<tr>
				<td colspan="6">
					<h3>Xác thực tài khoản Doanh nghiệp</h3>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='<portlet:namespace/>ten'><liferay-ui:error key="error_name_required" message = "vn.dtt.cmon.admin.portlet.cqql.err.empty.ten"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<label class="egov-label-bold" >Loại doanh nghiệp</label>
					<select name="DNType" class="egov-select"  >
						<option value="0">Doanh nghiệp tư nhân</option>
						<option value="1">Công ty cổ phần</option>						
						<option value="2">Công ty hợp danh</option>
						<option value="3">Công ty trách nhiệm hữu hạn một thành viên</option>
						<option value="4">Công ty trách nhiệm hữu hạn 2 thành viên trở lên</option>
						
					</select>
				</td>
				<td colspan="2" style="width: 30% !important"></td>
			</tr>
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Email </label><label class="egov-label-note" > (Tài khoản đăng nhập) </label><label class='egov-label-red'>(*)</label>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="4"  style="width: 60% !important">
					<div class="left" style="width: 30%;margin-top: 10pt;">	
						<label class='egov-label-red'>Thông tin doanh nghiệp</label>
					</div>
					<div class="left fi20">
						<input type="button" onclick="openWindow('<%=popupDNSearch%>')" style="width: 100% !important;float: right;margin-top: 10pt;" value="Tìm kiếm doanh nghiệp" class="egov-button-search normal"/>
					</div>
				</td>
				<td colspan="2" style="width: 20% !important"></td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Tên tiếng việt </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Tên nước ngoài (nếu có) </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Tên viết tắt </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Địa chỉ trụ sở chính </label>					
				</td>
			</tr>
			<tr>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			
			<tr>
				<td colspan="6" >
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Điện thoại </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class='egov-label-bold'>Mã số thuế </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />
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
									<div class='egov-div-search' style='margin-top:3px;'>
					   					<input type="text"  onkeyup="searchOptions(this.value,'select-data-system','select-system-id','select-selected-id');" />
					   				</div>
								</td>
								<td width="10%" style="text-align: center !important">
									<input type="button" class="egov-func-select" value=">>" 
									onclick="moveAllOptions('select-system-id','select-selected-id');">
									<br><br>
									<input type="button" class="egov-func-select" value=">" 
									onclick="moveOptions('select-system-id','select-selected-id');">
									<br><br>
									<input  type="button" class="egov-func-select" value="<" 
									onclick="moveOptions('select-selected-id','select-system-id');">
									<br><br>
									<input type="button" class="egov-func-select" value="<<" 
									onclick="moveAllOptions('select-selected-id','select-system-id');">
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
			<div>
			<jsp:include page="../quanlytaikhoan/quanLyCtyTNHH2TV.jsp"/>
			<!--TNHH 2 TV <tr class="vonDT_PD">
				<td colspan="3">
					<label class="egov-label-bold" >Vốn đầu tư </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Vốn pháp định </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr> -->
			
			<!-- <tr class="vonDieuLe">
				<td colspan="4">
					<label class="egov-label-bold" >Vốn điều lệ </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					
				</td>
			</tr> -->
			
			<!-- <tr class="menhGiaCoPhan">
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Vốn điều lệ </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Mệnh giá cổ phần </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			<tr class="menhGiaCoPhan">
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Số cổ phần và giá trị cổ phần </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Số cổ phần được quyền chào bán</label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr> -->
			
			
			<jsp:include page="../quanlytaikhoan/quanLyCtyHopDanh.jsp"/>
			<!-- TNHH 2 TV <tr class="dSGopVon">
				<td colspan="6">
					<table id="danhSachThanhVienSangLap" class="taglib-search-iterator egov-table cssTable">
						<thead>							
							<tr>
								<td colspan="8">
									<label class="egov-label-bold" >Danh sách thành viên góp vốn </label><label class="egov-label-red">(*)</label>
								</td>
							</tr>
							<tr> 
								<td colspan="8" style="text-align: right;">
									<input type="button" id="addMem" class="egov-button" value="Thêm thành viên"/>
									
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="5%;">STT</th>
								<th width="20%;">Tên thành viên </th>
								<th width="20%;">CMND/Mã giấy phép</th>
								<th width="20%;">Địa chỉ </th>
								<th width="20%;">Giá trị phần góp vốn</th>
								<th width="5%;">Tỷ lệ (%)</th>
								<th width="7%;">Ghi chú</th>
								<th width="3%;">Hành động</th>
							</tr>
		
							 <tr>
								<td colspan="8" data="none" id="row_0" style="padding-right: 3px;padding-left: 3px;">Chưa có cá nhân góp vốn</td>                    
							</tr>
		
						</tbody>
					</table>
				</td>
			</tr> -->
			
			<jsp:include page="../quanlytaikhoan/quanLyCtyCoPhan.jsp"/>
			
			
			<!-- Cty Co Phan <tr class="dSCoDongSangLap">
				<td colspan="6">
					<table id="danhSachCoDongSangLap" class="taglib-search-iterator egov-table cssTable">
						<thead>							
							<tr>
								<td colspan="10">
									<label class="egov-label-bold" >Danh sách cổ đông đồng sáng lập </label><label class="egov-label-red">(*)</label>
								</td>
							</tr>
							<tr> 
								<td colspan="10" style="text-align: right;">
									<input type="button" id="addMem" class="egov-button" value="Thêm cổ đông"/>
									
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="5%;">STT</th>
								<th width="20%;">Tên cổ đông </th>
								<th width="20%;">CMND/Giấy phép</th>
								<th width="20%;">Địa chỉ </th>
								<th width="">Loại cp </th>
								<th width="">Số cp </th>
								<th width="">Giá trị cp </th>								
								<th width="5%;">Tỷ lệ (%)</th>
								<th width="7%;">Ghi chú</th>
								<th width="3%;">Hành động</th>
							</tr>
		
							 <tr>
								<td colspan="8" data="none" id="row_0" style="padding-right: 3px;padding-left: 3px;">Chưa có cá nhân góp vốn</td>                    
							</tr>
		
						</tbody>
					</table>
				</td>
			</tr> -->
			
			
			
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên chi nhánh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Địa chỉ chi nhánh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên văn phòng đại diện </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Địa chỉ văn phòng đại diện </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên địa điểm kinh doanh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Địa chỉ địa điểm kinh doanh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			<!-- Loại Cty TNHH 1 Thanh Vien  -->
			
			<jsp:include page="..//quanLyCtyTNHH1TV.jsp"/>
			
			<%-- <tr class="showHideLoaiSoHuu">
				<td colspan="6">
					<table>
						<!-- Start Loại Cty TNHH 1 Thanh Vien  -->
						<tr >
							<td colspan="6">
								<label class='egov-label-red'>Thông tin chủ sở hữu</label>
							</td>
						</tr>
						<tr >
							<td colspan="6">
								<label class="egov-label-bold" >Loại chủ sở hữu </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        
						        <input class="egov-radio"
						        	id="caNhan" 
						        	type="radio"
						        	name="loaiSoHuu"
						        	value="0"
						        	checked="checked"
						        />
						        <label class="egov-label-bold" for="CMND">Cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        
						        <input class="egov-radio"
						        	id="toChuc"
						        	type="radio"
						        	name="loaiSoHuu"
						        	value="1"
						        />
						        <label for="Khac">Tổ chức</label>
							</td>
						</tr>
						<!-- Start Loai so huu la To chuc -->
						<tr class="toChuc_LoaiSoHuu">
							<td colspan="6">
								<table>
									<tr>
										<td colspan="6">
											<label class="egov-label-bold" >Tên chủ sở hữu </label><label class='egov-label-red'>(*)</label><br/>
											<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
											<input type="button" value="Tìm kiếm" onclick="openWindow('<%=popupAddMem%>')"  class="egov-button-search"/>
										</td>
									</tr>
									<tr class="showHideCMND_CP">
											<td colspan="2">
												<label class="egov-label-bold" >Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
												<input type="text" class="egov-inputfield"/>
											</td>
											<td colspan="2">
												<label class="egov-label-bold" >Nơi cấp </label><label class='egov-label-red'>(*)</label><br/>
												<input readonly="readonly" class="egov-calendar" />	
											</td>
											<td colspan="2">
												<label class="egov-label-bold" >Ngày cấp </label><label class='egov-label-red'>(*)</label><br/>
												<input type="text" class="egov-inputfield"/>
											</td>				
									</tr>
									<tr >
										<td colspan="6">
											<label class='egov-label-bold'>Địa chỉ trụ sở chính</label>
										</td>
									</tr>
						
									<tr >
										<td colspan="2">
											<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
											<select class="egov-select" >
												<option>Thành phố Đà Nẵng</option>
											</select>	
										</td>
										<td colspan="2">
											<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
											<select class="egov-select" >
												<option>--Hãy chọn--</option>
											</select>	
										</td>
										<td colspan="2">
											<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
											<select class="egov-select" >
												<option>--Hãy chọn--</option>
											</select>	
										</td>
									</tr>
									<tr >
										<td colspan="6">
											<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
											<input type="text" class="egov-inputfield"/>
										</td>
									</tr>
									<tr >
										<td colspan="3" style="width: 45% !important">
											<label class="egov-label-bold" >Điện thoại </label><br/>
											<input type="text" class="egov-inputfield"/>
										</td>
										<td colspan="3" style="width: 45% !important">
											<label class="egov-label-bold" >Fax </label><br/>
											<input type="text" class="egov-inputfield"/>
										</td>
									</tr>
									
									<tr>
										<td colspan="3">
											<label class="egov-label-bold" >Email </label><br/>
											<input type="text" class="egov-inputfield"/>
										</td>
										<td colspan="3">
											<label class="egov-label-bold" >Website </label><br/>
											<input type="text" class="egov-inputfield"/>
										</td>
									</tr>	
									
								</table>
							</td>
						</tr>
						<!-- End Loai so huu la To chuc -->
						
						<!-- Start Loai so huu la Ca Nhan class="caNhan_LoaiSoHuu"-->
						<tr>
							<td colspan="4">
								<label class="egov-label-bold" >Tên chủ sở hữu </label><label class='egov-label-red'>(*)</label><br/>
								<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
								<input type="button" value="Tìm kiếm" onclick="openWindow('<%=popupAddMem%>')"  class="egov-button-search"/>
							</td>
							<td colspan="2" >
								<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
								<input readonly="readonly" class="egov-calendar" />
							</td>
						</tr>
						
						<tr >
							<td colspan="2">
								<label class="egov-label-bold" >Giới tính </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>
							<td colspan="2">
								<label class="egov-label-bold" >Quốc tịch </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>
							<td colspan="2">
								<label class="egov-label-bold" >Dân tộc </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>				
						</tr>
						
						<tr >
							<td colspan="6">
								<label class="egov-label-bold" >Giấy chứng thực cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        <input class="egov-radio"
						        	id="CMND" 
						        	type="radio"
						        	name="CMND_LoaiSH"
						        	value="0"
						        	checked="checked"
						        />
						        <label class="egov-label-bold" for="CMND">CMND</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        <input class="egov-radio"
						        	id="Khac"
						        	type="radio"
						        	name="CMND_LoaiSH"
						        	value="1"
						        />
						        <label for="Khac">Khác</label>
							</td>
						</tr>
						
						<tr class="showHideCMND_CP">
							<td colspan="2">
								<label class="egov-label-bold" >Số CMND </label><label class='egov-label-red'>(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
							<td colspan="2">
								<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
								<input readonly="readonly" class="egov-calendar" />	
							</td>
							<td colspan="2">
								<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>				
						</tr>
						
						<tr class="showHideKhac_CP">
							<td colspan="3">
								<label class="egov-label-bold" >Tên giấy tờ chứng thức cá nhân </label><label class="egov-label-red">(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
							<td colspan="3">
								<label class="egov-label-bold" >Số giấy tờ chứng thức cá nhân</label><label class="egov-label-red">(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
						</tr>
						
						<tr class="showHideKhac_CP">
							<td colspan="3">
								<label class="egov-label-bold" >Ngày cấp  </label><label class='egov-label-red'>(*)</label><br/>
								<input readonly="readonly" class="egov-calendar" />	
							</td>
							<td colspan="3">
								<label class="egov-label-bold" >Nơi cấp  </label><label class='egov-label-red'>(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>	
						</tr>
						
						<tr >
							<td colspan="6">
								<label class='egov-label-bold'>Địa chỉ thường trú</label>
							</td>
						</tr>
						
						<tr >
							<td colspan="2">
								<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>Thành phố Đà Nẵng</option>
								</select>	
							</td>
							<td colspan="2">
								<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>
							<td colspan="2">
								<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>
						</tr>
						<tr >
							<td colspan="6">
								<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
						</tr>
						
						<tr >
							<td colspan="6">
								<label class='egov-label-bold'>Chỗ ở hiện tại</label>
							</td>
						</tr>
						<tr >
							<td colspan="2">
								<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>Thành phố Đà Nẵng</option>
								</select>	
							</td>
							<td colspan="2">
								<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>
							<td colspan="2">
								<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
								<select class="egov-select" >
									<option>--Hãy chọn--</option>
								</select>	
							</td>
						</tr>
						<tr >
							<td colspan="6">
								<label class="egov-label-bold" >Mô tả chổ ở </label><label class='egov-label-red'>(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
						</tr>
						
						<tr >
							<td colspan="3" style="width: 45% !important">
								<label class="egov-label-bold" >Điện thoại </label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
							<td colspan="3" style="width: 45% !important">
								<label class="egov-label-bold" >Fax </label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
						</tr>
						
						<tr>
							<td colspan="3">
								<label class="egov-label-bold" >Email </label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
							<td colspan="3">
								<label class="egov-label-bold" >Website </label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
						</tr>	
						<!-- End Loại Cty TNHH 1 Thanh Vien  la Ca Nhan-->
					</table>
				</td>
			</tr> --%>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tr>
				<td colspan="6">
					<label id="labelDN" class='egov-label-red'>Thông tin chủ doanh nghiệp</label>
				</td>
			</tr>
			
			<tr class="dSGopVon">
				<td colspan="6" >
					<label class="egov-label-bold" >Chức danh </label><label class='egov-label-red'>(*)</label>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tr>
				<td colspan="4">
					<label id="labelHoTen" class="egov-label-bold" >Họ và tên </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
					<input type="button" value="Tìm kiếm" onclick="openWindow('<%=popupAddMem%>')"  class="egov-button-search"/>
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Giới tính </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quốc tịch </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Dân tộc </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>				
			</tr>
			
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Giấy chứng thực cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <input class="egov-radio"
			        	id="CMND" 
			        	type="radio"
			        	name="CMND"
			        	value="0"
			        	checked="checked"
			        />
			        <label class="egov-label-bold" for="CMND">CMND</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <input class="egov-radio"
			        	id="Khac"
			        	type="radio"
			        	name="CMND"
			        	value="1"
			        />
			        <label for="Khac">Khác</label>
				</td>
			</tr>
			
			<tr class="showHideCMND">
				<td colspan="2">
					<label class="egov-label-bold" >Số CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>				
			</tr>
			
			<tr class="showHideKhac">
				<td colspan="3">
					<label class="egov-label-bold" >Tên giấy tờ chứng thức cá nhân </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Số giấy tờ chứng thức cá nhân</label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr class="showHideKhac">
				<td colspan="3">
					<label class="egov-label-bold" >Ngày cấp  </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />	
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Nơi cấp  </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>	
			</tr>
			
			<tr>
				<td colspan="6">
					<label class='egov-label-bold'>Địa chỉ thường trú</label>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class='egov-label-bold'>Chỗ ở hiện tại</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả chổ ở </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>	
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" style="padding: 10px !important">
					<input type="submit" class="egov-button" id="dangKy" value="Xác thực">
				   	<input type="button" class="egov-button" id="huydangKy" value="Hủy đăng ký">
			      	<input class="egov-button" type="button" value="Quay lại danh dách" >
				</td>
			</tr>
		</tfoot>	
	</table>
</form>
</div>
</html>
<script type="text/javascript" >

function moveAllOptions(fromId,toId){
	$("#"+fromId+" option").each(function() {
					
			$('#'+toId).append($('<option>', { 
		        value: this.value,
		        text : this.text 
		    }));
			
			$(this).remove();
		
	    
	});
}

$(document).ready(function() {
	/* Show/Hidden : Thong tin khac */
	
	
	$('.showHideKhac').hide();
	$('.dSGopVon').hide();
	$('.dSCoDongSangLap').hide();
	$('.showHideLoaiSoHuu').hide();
	$('.vonDieuLe').hide();
	$('.menhGiaCoPhan').hide();
	
	$('input[name=CMND]').on('change',function() {		
	    if ($("input[name=CMND]:checked").val() == 1) {
	    	$('.showHideKhac').fadeIn('fast');
	    	$('.showHideCMND').fadeOut('fast');
	    	
	    } else {  
	    	$('.showHideKhac').fadeOut('fast');	 
	    	$('.showHideCMND').fadeIn('fast');
	    }
	});

	//Radio khi chon Loai so huu

	$('input[name=CMND_LoaiSH]').on('change',function() {		
	    if ($("input[name=CMND_LoaiSH]:checked").val() == 1) {
	    	$('.showHideKhac_CP').fadeIn('fast');
	    	$('.showHideCMND_CP').fadeOut('fast');
	    	
	    } else {  
	    	$('.showHideKhac_CP').fadeOut('fast');	 
	    	$('.showHideCMND_CP').fadeIn('fast');
	    }
	});
	
	
	$('select[name=DNType]').on('change',function() {
		if($(this).val()==1){//Cong ty co phan
			ShowCtyCoPhan();
			
		}else if($(this).val()==3){//Công ty trách nhiệm hữu hạn 1 thành viên
			
			ShowTNHH1TV();
			
			
		}else if($(this).val()==4){//Công ty trách nhiệm hữu hạn 2 thành viên trở lên
			
			ShowTNHH2TV();
		}
		 //labelHoTen
		
		
		else {  
	    	$('.dSGopVon').fadeOut('fast');	    
	    	$('#labelDN').text("Thông tin chủ doanh nghiệp");
	    }
		
	});
	
	// dialog  properties
    $('#dialog_addMembers').dialog({
    	width: 800,
        height: 450,
        autoOpen: false,
        show: 'slide',
        hide: 'slide',
        /* buttons: { 'Close': function() { $(this).dialog('close'); } }, */
        closeOnEscape: true,
        resizable: false
    });
 // dialog open/close
    $('#addMem').click(function() {
        if ($('#dialog_addMembers').dialog('isOpen') == true)
            $('#dialog_addMembers').dialog('close');
        else
            $('#dialog_addMembers').dialog('open');
        return false;
    });
 
    $('#Dong').click(function() {
    	 $('#dialog_addMembers').dialog('close'); 
    });
    
    
    //Show Cty TNHH 1 Thanh Vien
	function ShowCtyCoPhan() {
		$('.dSCoDongSangLap').fadeIn('fast');			
		$('#labelDN').text("Thông tin người đại diện theo pháp luật");
		$('.dSGopVon').hide();
		$('.menhGiaCoPhan').fadeIn('fast');	
    }
    
    
    //Show Cty TNHH 1 Thanh Vien
	function ShowTNHH1TV() {
		$('.showHideLoaiSoHuu').fadeIn('fast');//Bo sung thong tin chu so huu
		$('.vonDT_PD').hide(); //hide Von dau tu, von phap dinh
		$('.vonDieuLe').fadeIn('fast');//Bo sung von dieu le
		$('.dSGopVon').fadeIn('fast');//hien thi chuc danh
		$('#labelDN').text("Thông tin người đại diện theo pháp luật");
	}
    
	//Show Công ty trách nhiệm hữu hạn 2 thành viên trở lên
    function ShowTNHH2TV() {
    	$('.dSGopVon').fadeIn('fast');
		alert($('#labelDN').text());
		$('#labelDN').text("Thông tin người đại diện theo pháp luật");
		$('.dSCoDongSangLap').hide();
	}
    
	function Hide() {
		$('.showHideKhac').hide();
		$('.dSGopVon').hide();
		$('.dSCoDongSangLap').hide();
		$('.showHideLoaiSoHuu').hide();
		$('.vonDieuLe').hide();
		$('.menhGiaCoPhan').hide();
	}
	
});




</script>