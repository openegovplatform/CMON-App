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
<%@page import="org.oep.cmon.dao.dn.service.NganhNgheKinhDoanhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<script src="<%=request.getContextPath()%>/js/brms-jquery.js" type="text/javascript"></script>
	

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
		value="/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_doanhNghiepSearch.jsp" />
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



</script>
<%
	String tt= ParamUtil.getString(request, "doiTuongDialog");
	/* String titleAdd,title1,title2="";
	if(tt.equals("3")){
		title0= "Thêm mới tài khoản Doanh nghiep";
	}
	if(tt.equals("4")){
		title= "Thêm mới tài khoản Hợp tác xã";
	}
	if(tt.equals("5")){
		title= "Thêm mới tài khoản Hộ cá thể";
	}
	 */
	
	HoCaTheFormModel model= (HoCaTheFormModel)request.getAttribute("myForm");
	if (model == null) {
		model = new HoCaTheFormModel();
		model.setMode(0);
	}
	int mode = model.getMode();
%>
<portlet:actionURL name="addHoCaThe" var="doSubmit"/>
<portlet:actionURL name="updateHoCaThe" var="doUpdate"/>

<%
String actionURL = "";
if (mode == 0) {
    actionURL = doSubmit.toString();
} else if (mode == 1) {
    actionURL = doUpdate.toString();
} else {
    actionURL = "";
}
%>


<div class="egov-container">

<%if(model.getDsThanhVien() != null){
		for(int i =0; i<model.getDsThanhVien().length ;i++){
			
		%>
			<input type='hidden' name='idTVRq' value=' <%=model.getDsThanhVien()[i][0] %>'/>
			<input type='hidden' name='tenTVRq' value=' <%=model.getDsThanhVien()[i][1]%> '/>
			<input type='hidden' name='cmndTVRq' value='<%=model.getDsThanhVien()[i][2] %> '/>
			<input type='hidden' name='diaChiTVRq' value=' <%=model.getDsThanhVien()[i][3] %> '/>
			<input type='hidden' name='giaTriTVRq' value=' <%=model.getDsThanhVien()[i][4] %> '/>
			<input type='hidden' name='tyLeTVRq' value=' <%=model.getDsThanhVien()[i][5] %>'/>
			
								
		<%	}
	}%>


<form method="post" name="frmXacThucHoCaTheMotThanhVien" id="frmXacThucHoCaTheMotThanhVien" action="<%=actionURL%>">
	<input type="hidden" name="mode" value="<%= mode %>">
	<table class="egov-table" width="100%">
		<thead>
			<tr>
				<td colspan="6">
					<h3>
							<% if (tt.equals("3") || mode == 0) { %>
		                     Thêm mới tài khoản Hộ cá thể
		                 <% } else if (mode == 1) { %>
		                     Cập nhật tài khoản Hộ cá thể
		                 <% } else if (mode == 2) { %>
		                     Chi tiết Hộ cá thể
		                 <% } %>

					</h3>
				</td>
			</tr>
		</thead>
		<tbody>
		<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<%-- <option value='emailDN'><liferay-ui:error key="emptyMailDangNhap" message = "Email không được rỗng"/></option> --%>
			      		<option value='emailDN'><liferay-ui:error key="errerMaxLengMailDangNhap" message = "Tối đa 50 ký tự"/></option>
			      		<option value='emailDN'><liferay-ui:error key="errorMailKhongDungDinhDang" message = "Chưa chọn Email hoặc Email không đúng định dạng"/></option>			      				      		
			      		<option value='emailDN'><liferay-ui:error key="errorEmailDaTonTai" message = "Email đã tồn tại"/></option>
			      		
			      		<option value='hoTenNDD'><liferay-ui:error key="emptyhoTenNDD" message = "Họ tên không được rỗng"/></option>
			      		
			      		<option value='ngaySinhNDD'><liferay-ui:error key="emptyngaySinhNDD" message = "Ngày sinh không được rỗng"/></option>
			      		
			      		<option value='gioiTinhNDD'><liferay-ui:error key="emptygioiTinhNDD" message = "Chưa chọn giới tính"/></option>
			      		
			      		<option value='quocTichNDD'><liferay-ui:error key="emptyquocTichNDD" message = "Chưa chọn quốc tịch"/></option>
			      		
			      		<option value='danTocNDD'><liferay-ui:error key="emptydanTocNDD" message = "Chưa chọn dân tộc"/></option>
			      		
			      		
			      		<option value='soCMNDNDD'><liferay-ui:error key="cmndNotNumber" message = "Số CMND không cho phép nhập chữ"/></option>	
			      		<option value='soCMNDNDD'><liferay-ui:error key="errorsoCMNDNDD" message = "Lỗi số CMND"/></option>			      		
			      		<option value='soCMNDNDD'><liferay-ui:error key="errorsoCMNDNDD9or12" message = "CMND chỉ được 9 số hoặc 12 số"/></option>
			      		<option value='soCMNDNDD'><liferay-ui:error key="emptysoCMNDNDD" message = "Số CMND không được rỗng"/></option>
			      		<option value='soCMNDNDD'><liferay-ui:error key="cmndOverLimit" message = "Số CMND không hợp lệ"/></option>
			      		
			      		<option value='ngayCapCMNDNDD'><liferay-ui:error key="emptyngayCapCMNDNDD" message = "Ngày cấp CMND không được rỗng"/></option>
			      		<option value='noiCapCMNDNDD'><liferay-ui:error key="emptynoiCapCMNDNDD" message = "Nơi cấp CMND không được rỗng"/></option>
			      		
			      		<option value='tinhTTNDD'><liferay-ui:error key="emptytinhTTIdNDD" message = "Chưa chọn tỉnh"/></option>
			      		<option value='huyenTTNDD'><liferay-ui:error key="emptyhuyenTTIdNDD" message = "Chưa chọn huyện"/></option>
			      		<option value='xaTTNDD'><liferay-ui:error key="emptyxaTTIdNDD" message = "Chưa chọn xã"/></option>
			      		<option value='moTaTTNDD'><liferay-ui:error key="emptymoTaTTNDD" message = "Chưa mô tả địa chỉ thường trú"/></option>
			      		<option value='moTaTTNDD'><liferay-ui:error key="errorMaxLengmoTaTTNDD" message = "Mô tả thường trú tối đa 100 ký tự"/></option>
			      		
			      		<option value='tinhHTNDD'><liferay-ui:error key="emptytinhHTIdNDD" message = "Chưa chọn tỉnh"/></option>
			      		<option value='huyenHTNDD'><liferay-ui:error key="emptyhuyenHTIdNDD" message = "Chưa chọn huyện"/></option>
			      		<option value='xaHTNDD'><liferay-ui:error key="emptyxaHTIdNDD" message = "Chưa chọn xã"/></option>
			      		<option value='moTaHTNDD'><liferay-ui:error key="emptymoTaHTNDD" message = "Chưa mô tả địa chỉ hiện tại"/></option>
			      		<option value='moTaHTNDD'><liferay-ui:error key="errorMaxLengmoTaHTNDD" message = "Mô tả địa chỉ hiện tại tối đa 100 ký tự"/></option>
			      		
			      		
			      		<option value='dienThoaiNDD'><liferay-ui:error key="errorMaxLengdienThoaiNDD" message = "Điện thoại tối đa 15 ký tự"/></option>
			      		<option value='dienThoaiNDD'><liferay-ui:error key="errorNumberdienThoaiNDD" message = "Điện thoại không cho phép nhập chữ"/></option>
			      		
			      		<option value='faxNDD'><liferay-ui:error key="errorMaxLengfaxNDD" message = "Fax tối đa 15 ký tự"/></option>
			      		<option value='faxNDD'><liferay-ui:error key="errorNumberFax" message = "Fax không cho phép nhập chữ"/></option>
			      		
			      		<option value='emailNDD'><liferay-ui:error key="errorMaxLengemailNDD" message = "Tối đa 50 ký tự"/></option>
			      		<option value='websiteNDD'><liferay-ui:error key="errorMaxLengwebsiteNDD" message = "Tối đa 100 ký tự"/></option>
			      		
			      		
			      		<option value='tenHoCaThe'><liferay-ui:error key="emptytenHoCaThe" message = "Tên Hộ cá thể không được rỗng"/></option>
			      		<option value='tenHoCaThe'><liferay-ui:error key="errorMaxLengtenHoCaThe" message = "Tối đa 200 ký tự"/></option>
			      		
			      		<option value='maGiayPhep'><liferay-ui:error key="emptymaGiayPhep" message = "Mã giấy phép không được rỗng"/></option>
			      		<option value='maGiayPhep'><liferay-ui:error key="errorMaxLengmaGiayPhep" message = "Tối đa 20 ký tự"/></option>
			      		
			      		<option value='tinhId'><liferay-ui:error key="emptytinhId" message = "Chưa chọn tỉnh"/></option>
			      		<option value='huyenId'><liferay-ui:error key="emptyhuyenId" message = "Chưa chọn huyện"/></option>
			      		<option value='xaId'><liferay-ui:error key="emptyxaId" message = "Chưa chọn xã"/></option>
			      		<option value='chiTietDiaDiem'><liferay-ui:error key="emptychiTietDiaDiem" message = "Chi tiết địa điểm không được rỗng"/></option>
			      		<option value='chiTietDiaDiem'><liferay-ui:error key="errorMaxLengchiTietDiaDiem" message = "Chi tiết địa điểm tối đa 200 ký tự"/></option>
			      		
			      		
			      		<option value='maSoThue'><liferay-ui:error key="emptymaSoThue" message = "Mã số thuế không được rỗng"/></option>
			      		<option value='maSoThue'><liferay-ui:error key="errorMaxLengmaSoThue" message = "Tối đa 20 ký tự"/></option>
			      		
			      		<option value='ngayDangKy'><liferay-ui:error key="emptyngayDangKy" message = "Ngày đăng ký không được rỗng"/></option>
			      		
			      		<option value='vonKinhDoanh'><liferay-ui:error key="emptyVon" message = "Chưa nhập vốn"/></option>
			      		<option value='vonKinhDoanh'><liferay-ui:error key="errorVon" message = "Nhập vốn không hợp lệ"/></option>
			      	
			      		<option value='dienThoai'><liferay-ui:error key="emptydienThoai" message = "Điện thoại không được rỗng"/></option>
			      		<option value='dienThoai'><liferay-ui:error key="errorMaxLengdienThoai" message = "Điện thoại tối đa 15 ký tự"/></option>
			      		
			      		
			      		<option value='fax'><liferay-ui:error key="errorMaxfax" message = "Fax tối đa 15 ký tự"/></option>			      	
			      		<option value='email'><liferay-ui:error key="errorMaxemail" message = "Tối đa 50 ký tự"/></option>
			      		<option value='website'><liferay-ui:error key="errorMaxwebsite" message = "Tối đa 100 ký tự"/></option>
			      		
			      		
			      		<option value='moTaNgheNghiep'><liferay-ui:error key="emptymoTaNgheNghiep" message = "Chưa mô tả ngành nghề"/></option>
			      		<option value='select-selected-id'><liferay-ui:error key="emptyngheDuocChon" message = "Chưa chọn ngành nghề"/></option>
			      		
			      		
			      		
					</select>
				</td>
			</tr>
		
		
		
			<%-- <tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='<portlet:namespace/>ten'><liferay-ui:error key="error_name_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.ten"/></option>
					</select>
				</td>
			</tr> --%>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<label class="egov-label-bold" >Email</label><label class="egov-label-note" > (Tài khoản đăng nhập) </label><label class='egov-label-red'>(*)</label>
					<input type="text" id="emailDN" name="emailDN" class="egov-inputfield"/>
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
					<input type="text" readonly="readonly" value="<%=model.getHoTenNDD()==null? "" : model.getHoTenNDD()  %>" id="hoTenNDD" name ="hoTenNDD" class="egov-inputfield valid" style="width: 80% !important"/>
					<input type="hidden" name="nddId" />
					<input type="button" value="Tìm kiếm" onclick="openWindowCD('<%=popupCDSearch%>')" class="egov-button-search"/>
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" value="<%=model.getNgaySinhNDD()==null? "" : model.getNgaySinhNDD()  %>"  id="ngaySinhNDD" name="ngaySinhNDD" class="egov-calendar" />
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
					<input type="text" class="egov-inputfield" value="<%=model.getSoCMNDNDD()==null? "" : model.getSoCMNDNDD()  %>" id="soCMNDNDD" name="soCMNDNDD"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" value="<%=model.getNgayCapCMNDNDD()==null? "" : model.getNgayCapCMNDNDD()%>" class="egov-calendar" id="ngayCapCMNDNDD" name="ngayCapCMNDNDD"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<!-- <input type="text" class="egov-inputfield" id="noiCapCMNDNDD" name="noiCapCMNDNDD"/> -->
					<select class="egov-select" id="noiCapCMNDNDD" name="noiCapCMNDNDD">
						<option value="0">--Hãy chọn--</option>
						<%
						List <DonViHanhChinh> list_tinhCapCMND = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
						long idTinhCapCMND = 0;
						if (model.getNoiCapCMNDNDD() != null) {
							idTinhCapCMND = Long.parseLong(model.getNoiCapCMNDNDD());
			      		}
						
						for(int i=0;i<list_tinhCapCMND.size();i++){ 
					    	 DonViHanhChinh donvihanhchinh = list_tinhCapCMND.get(i);
					    	 String selected = "";
					    	 if (donvihanhchinh.getId() == idTinhCapCMND){
									selected = "selected";
								}
						%>
						<option value="<%=donvihanhchinh.getId() %>" <%=selected %> >Công an <%=donvihanhchinh.getTen() %></option>
						<%} %>
					</select>
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
					<input type="text" class="egov-inputfield" id="moTaTTNDD" name="moTaTTNDD" value="<%=model.getMoTaTTNDD()==null? "" : model.getMoTaTTNDD()%>"/>
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
					<input type="text" class="egov-inputfield" value="<%=model.getMoTaHTNDD()==null? "" : model.getMoTaHTNDD()%>" id="moTaHTNDD" name="moTaHTNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Điện thoại </label><br/>
					<input type="text" class="egov-inputfield" value="<%=model.getdTNDD()==null? "" : model.getdTNDD()%>" id="dienThoaiNDD" name="dienThoaiNDD"/>
				</td>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" class="egov-inputfield" value="<%=model.getFaxNDD()==null? "" : model.getFaxNDD()%>" id="faxNDD" name="faxNDD"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" class="egov-inputfield" value="<%=model.getEmailTNDD()==null? "" : model.getEmailTNDD()%>" id="emailNDD" name="emailNDD"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" class="egov-inputfield" value="<%=model.getWebNDD()==null? "" : model.getWebNDD()%>" id="websiteNDD" name="websiteNDD"/>
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
					<input type="text" class="egov-inputfield" id="tenHoCaThe" name="tenHoCaThe" value="<%=model.getTenHCT()==null? "" : model.getTenHCT()%>" style="width: 80% !important"/>
					<input type="hidden" name="id"/>
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="maGiayPhep" name="maGiayPhep" value="<%=model.getMaGPHCT()==null? "" : model.getMaGPHCT()%>" class="egov-inputfield" />
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
					<select id="tinhId" name="tinhId" class="egov-select" onChange="reDrawSelectBox('tinhId','huyenId')">
						<option value="0">--Hãy chọn--</option>
						<% 		   
		      				List <DonViHanhChinh> listTinhHCT = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
							long tinhIdHCT = 0;
							if (model.getTinhHCT() != null) {
								tinhIdHCT = Long.parseLong(model.getTinhHCT());
				      		}
							
							for(int i=0;i<listTinhHCT.size();i++){ 
						    	 DonViHanhChinh donvihanhchinh = listTinhHCT.get(i);
						    	 String selected = "";
						    	 if (donvihanhchinh.getId() == tinhIdHCT){
										selected = "selected";
									}
								%>
								<option value="<%=donvihanhchinh.getId()%>" <%=selected %>><%=donvihanhchinh.getTen()%></option>
								
								<%
								}
								%>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select  id="huyenId" name="huyenId" class="egov-select" onChange="reDrawSelectBox('huyenId','xaId')" >
						<option value="0">--Hãy chọn--</option>
						<%   
							long diaChiHCTHuyenId= 0;
				      		if (model.getHuyenHCT() != null) {
				      			diaChiHCTHuyenId = Long.parseLong(model.getHuyenHCT());
				      		}
						
				      	// Get quan huyen belong to tinh thanh
							if (tinhIdHCT > 0) {
								// Get all quan huyen
								List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(tinhIdHCT, 0);
										
								for (DonViHanhChinh quanHuyen: quanHuyenList) {
									String selected = "";
									if ( quanHuyen.getId() == diaChiHCTHuyenId){
										selected = "selected";
									}
							%>
									<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
			
									<%} 
							} %>
						
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select id="xaId" name="xaId" class="egov-select" >
						<option value="0">--Hãy chọn--</option>
						<%
						long diaChiHCTXaId = 0;
			      		
			    		if (model.getXaHCT() != null) {
			    			diaChiHCTXaId = Long.parseLong(model.getXaHCT());
			      		}			    		
						 
							// Get quan huyen belong to quan huyen
							if (diaChiHCTHuyenId > 0) {
								// Get all quan huyen
								List <DonViHanhChinh> phuongXaList =DonViHanhChinhLocalServiceUtil.findByChaId(diaChiHCTHuyenId, 0);
										
								for (DonViHanhChinh phuongXa: phuongXaList) {
									String selected = "";
									if ( phuongXa.getId() == diaChiHCTXaId){
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
				<td colspan="6" >
					<label class="egov-label-bold" >Chi tiết địa chỉ </label><label class='egov-label-red'>(*)</label>
					<input type="text" name="chiTietDiaDiem" value="<%=model.getChiTietDCHCT()==null? "" : model.getChiTietDCHCT()%>" id="chiTietDiaDiem"class="egov-inputfield"/>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Mã số thuế </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" name="maSoThue" id="maSoThue" value="<%=model.getMaThueHCT()==null? "" : model.getMaThueHCT()%>" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày đăng ký </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" readonly="readonly" value="<%=model.getNgayDKHCT()==null? "" : model.getNgayDKHCT()%>" name="ngayDangKy" id="ngayDangKy" class="egov-calendar"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Vốn kinh doanh (VNĐ) </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text"  value="<%=model.getVonKDHCT()==null? "" : model.getVonKDHCT()%>" style="text-align: right;" maxlength="23" name="vonKinhDoanh" id="vonKinhDoanh" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Điện thoại </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" value="<%=model.getdTHCT()==null? "" : model.getdTHCT()%>" name="dienThoai"  id="dienThoai"class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" name="fax" value="<%=model.getFaxHCT()==null? "" : model.getFaxHCT()%>" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" value="<%=model.getEmailHCT()==null? "" : model.getEmailHCT()%>" name="email" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" value="<%=model.getWebHCT()==null? "" : model.getWebHCT()%>" name="website" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả ngành nghề </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text"  value="<%=model.getMoTaNganhNghe()==null? "" : model.getMoTaNganhNghe()%>"  name="moTaNgheNghiep" id="moTaNgheNghiep" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Loại hộ kinh doanh </label><label class='egov-label-red'>(*)</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Radio" class="egov-radio" name="loaiHoKinhDoanh" value="caNhan" onclick="showOrHideDanhSachGopVon()" checked="checked"/> Cá nhân&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Radio" class="egov-radio" name="loaiHoKinhDoanh" value="nhomTapThe" onclick="showOrHideDanhSachGopVon()" <%= model.isCheck() == true ? "checked=\"checked\"" : "" %> /> Nhóm tập thể
				</td>
			</tr>
			<tr>
				<td colspan="6" style="padding: 0px">
					<div id="div-danh-sach-gop-von">
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
							<tbody id="body-danh-sach-gop-von">
								
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
										<%
										List<NganhNgheKinhDoanh> listNganhNghe = NganhNgheKinhDoanhLocalServiceUtil.findByCap(Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE")), 0);
										for(int i = 0;i<listNganhNghe.size();i++){
										%>
										<option value="<%=listNganhNghe.get(i).getId() %>" ><%=listNganhNghe.get(i).getTen() %></option>
										<%} %>
									</select>
										<!-- du lieu cache du lieu nguon -->
									<select id="select-data-system" name="" style="display:none;">
										<%
										for(int i = 0;i<listNganhNghe.size();i++){
										%>
										<option value="<%=listNganhNghe.get(i).getId() %>" ><%=listNganhNghe.get(i).getTen() %></option>
										<%} %>
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
									<select id="select-selected-id" name="nganhNgheDuocChon" multiple="multiple" class="egov-multi-select" size="13">
										<%
											if(model.getNganhNgheDuocChon() !=null){												
												NganhNgheKinhDoanh listNN ;
												for(int i = 0;i<model.getNganhNgheDuocChon().length;i++){
													if (!model.getNganhNgheDuocChon()[i].trim().isEmpty()) {
														listNN=NganhNgheKinhDoanhLocalServiceUtil.getNganhNgheKinhDoanh(GetterUtil.getLong(model.getNganhNgheDuocChon()[i].trim()));
														
														%>
														<option value="<%=listNN.getId() %>" ><%=listNN.getTen() %></option>
													<%} 
												}
											}
										
										%>
									
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
	<portlet:param name="jspPage" value="/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathe.jsp"/>
</portlet:actionURL>

<%
PortletURL urlGetDataHoCaThe = renderResponse.createActionURL();
urlGetDataHoCaThe.setParameter(ActionRequest.ACTION_NAME, "getDataHoCaThe");

PortletURL urlGetDataCongDan = renderResponse.createActionURL();
urlGetDataCongDan.setParameter(ActionRequest.ACTION_NAME, "getDataCongDan");
%>
<script type="text/javascript" >
	
/* 
function selectAllSelected(){
	$('#select-selected-id option').prop('selected', true);
}
function resetSearchNganhNghe(){
	$("input#input-search-nganh-nghe").val("");
	searchOptions('','select-data-system','select-system-id','select-selected-id');
}
function xoaThanhVien(id){
	$("#tbl-danh-sach-gop-von tr#"+id).remove();
} */



function popupAddThanhVienSangLap(url){
	this.newWindow = window.open(url,'Search popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
	if (window.focus) {
		this.newWindow.focus();
	}			
	return this;
}




var arrayDanhSachGopVon = [];

function objectRemoveByKey(array, key, value) {
    for (var i = 0; i < array.length; i++) {
        if (array[i][key] === value) {
        	array.splice(i, 1);
        	drawTableDanhSachGopVon();
        	break;
        }
    }
    return false;
}
function pushDataToDanhSachGopVon(data){
	arrayDanhSachGopVon.push(data);
	drawTableDanhSachGopVon();
	this.newWindow.close();
}
function drawTableDanhSachGopVon(){
	var bodydanhsach = $('#body-danh-sach-gop-von');	
	var xhtml = "";
	for (var i = 0; i < arrayDanhSachGopVon.length; i++) {
		xhtml += "<tr id='"+arrayDanhSachGopVon[i]['id']+"'>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+(i+1)+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;' >"  +arrayDanhSachGopVon[i]['ten']+  "</td>"; 
				
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+arrayDanhSachGopVon[i]['cmnd']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;' >"+arrayDanhSachGopVon[i]['diachi']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+arrayDanhSachGopVon[i]['giatri']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+arrayDanhSachGopVon[i]['tyle']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' ><a href='#' onclick=\"objectRemoveByKey(arrayDanhSachGopVon,'id','"+arrayDanhSachGopVon[i]['id']+"');return false;\" >Xóa</a></td>";
		
		xhtml += "<input type='hidden' name='stt' value='" +(i+1)+ "'/>";
		xhtml += "<input type='hidden' name='idTV' value='" +arrayDanhSachGopVon[i]['id']+ "'/>";
		xhtml += "<input type='hidden' name='tenTV' value='" +arrayDanhSachGopVon[i]['ten']+ "'/>";
		xhtml += "<input type='hidden' name='cmndTV' value='" +arrayDanhSachGopVon[i]['cmnd']+ "'/>";
		xhtml += "<input type='hidden' name='diaChiTV' value='" +arrayDanhSachGopVon[i]['diachi']+ "'/>";
		xhtml += "<input type='hidden' name='giaTriTV' value='" +arrayDanhSachGopVon[i]['giatri']+ "'/>";
		xhtml += "<input type='hidden' name='tyLeTV' value='" +arrayDanhSachGopVon[i]['tyle']+ "'/>";
		xhtml += "</tr>";
	}
	bodydanhsach.html(xhtml);  
}










function choiceHoCaThe(choicedItem){
	if(typeof choicedItem.value == 'undefined'){
		return false;
	}
	
	$('input[name="tenHoCaThe"]').val(choicedItem.text);
	$('input[name="idHoCaThe"]').val(choicedItem.value);
	this.getDataHoCaThe(choicedItem.value);
	this.newWindow.close();
	
}
function getDataHoCaThe(idHoCaThe){
	var url='<%= urlGetDataHoCaThe %>';
	$.get(url,{hoCaTheId:idHoCaThe},function(data){
		var el = $('#select-selected-id');
		var hoCaThe = JSON.parse(data);
		$('input[name="id"]').val(hoCaThe.id);
		$('input[name="ten"]').val(hoCaThe.ten);
		$('input[name="maGiayPhep"]').val(hoCaThe.maGiayPhep);
		$('input[name="chiTietDiaDiem"]').val(hoCaThe.chiTietDiaDiem);
		$('input[name="maSoThue"]').val(hoCaThe.maSoThue);
		$('input[name="ngayDangKy"]').val(hoCaThe.ngayDangKy);
		$('input[name="vonKinhDoanh"]').val(hoCaThe.vonKinhDoanh);
		$('input[name="dienThoai"]').val(hoCaThe.dienThoai);
		$('input[name="fax"]').val(hoCaThe.fax);
		$('input[name="email"]').val(hoCaThe.email);
		$('input[name="website"]').val(hoCaThe.website);
		$('input[name="moTaNgheNghiep"]').val(hoCaThe.moTaNgheNghiep);
		
		selectedValueForSelectBox('tinhId',hoCaThe.tinhId);
		
		reDrawSelectBoxAndSelectdValue(hoCaThe.tinhId,'huyenId',hoCaThe.huyenId);			
		reDrawSelectBoxAndSelectdValue(hoCaThe.huyenId,'xaId',hoCaThe.xaId);
		
		//fill data ndd
		getDataCongDan(hoCaThe.nddId);
		var xhtml='';
		$.each(hoCaThe.listNganhNghe,function(i,val){
			$("#select-system-id option[value='"+val.id+"']").remove();
			xhtml +='<option value="'+val.id+'" selected="selected">'+val.name+'</option>';
		});
		el.html(xhtml);
	});	
}

function choiceCongDan(congDanId){
	this.getDataCongDan(congDanId);
}
function getDataCongDan(congDanId){
	var url='<%= urlGetDataCongDan %>';
	$.get(url,{congDanId:congDanId},function(data1){
		var congDan = JSON.parse(data1);
		$('input[name="nddId"]').val(congDan.nddId);
		$('input[name="hoTenNDD"]').val(congDan.nddTen);
		$('input[name="ngaySinhNDD"]').val(congDan.nddNgaySinh);
		$('input[name="soCMNDNDD"]').val(congDan.nddSoCMND);
		$('input[name="ngayCapCMNDNDD"]').val(congDan.nddNgayCapCMND);
		$('input[name="noiCapCMNDNDD"]').val(congDan.nddNoiCapCMND);
		$('input[name="moTaTTNDD"]').val(congDan.nddTtMoTaDiaChi);
		$('input[name="moTaHTNDD"]').val(congDan.nddCohtMoTaChoO);
		$('input[name="dienThoaiNDD"]').val(congDan.nddDienThoai);
		$('input[name="faxNDD"]').val(congDan.nddFax);
		$('input[name="emailNDD"]').val(congDan.nddEmail);
		$('input[name="websiteNDD"]').val(congDan.nddWebsite);
		
		selectedValueForSelectBox('gioiTinhNDD',congDan.nddGioiTinh);
		selectedValueForSelectBox('quocTichNDD',congDan.nddQuocTich);
		selectedValueForSelectBox('danTocNDD',congDan.nddDanToc);
		//dia chi thuong tru
		selectedValueForSelectBox('tinhTTNDD',congDan.nddTtTinhId);		
		reDrawSelectBoxAndSelectdValue(congDan.nddTtTinhId,'huyenTTNDD',congDan.nddTtHuyenId);			
		reDrawSelectBoxAndSelectdValue(congDan.nddTtHuyenId,'xaTTNDD',congDan.nddTtXaId);
		//cho o hien tai
		selectedValueForSelectBox('tinhHTNDD',congDan.nddCohtTinhId);		
		reDrawSelectBoxAndSelectdValue(congDan.nddCohtTinhId,'huyenHTNDD',congDan.nddCohtHuyenId);			
		reDrawSelectBoxAndSelectdValue(congDan.nddCohtHuyenId,'xaHTNDD',congDan.nddCohtXaId);
	});	
}

//Ve lai danh sach don vi hanh chinh
function reDrawSelectBox(selectName, changeName) {
	var url = '<%= getDonViHanhChinhByIdURL.toString() %>';
	var id = $('#'+selectName).val();
	var obj = $('#'+changeName);	
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
			  	console.log(data.id[i]);
			 	xhtml +='<option value="'+data.id[i]+'">'+data.name[i]+'</option>';
			};
			obj.html(xhtml);  
		}
	});
}
function reDrawSelectBoxAndSelectdValue(selectValue, changeName, selectedValue) {
	var url = '<%= getDonViHanhChinhByIdURL.toString() %>';
	var id = selectValue;
	var obj = $('#'+changeName);	
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
			  	console.log(data.id[i]);
			 	xhtml +='<option value="'+data.id[i]+'">'+data.name[i]+'</option>';
			};
			obj.html(xhtml);  
			selectedValueForSelectBox(changeName,selectedValue);
		}
	});
}
function selectedValueForSelectBox(idSelectBox,value){
	$("#"+idSelectBox+" option").removeAttr("selected");
	$("#"+idSelectBox+" option[value='"+value+"']").attr('selected','selected');
}

function selectAllSelected(){
	$('#select-selected-id option').prop('selected', true);
	
	$('#frmXacThucHoCaTheMotThanhVien').submit();
}

function showOrHideDanhSachGopVon(){
	var a = $("input:radio:checked").val();
	if(a=='nhomTapThe'){
		$("#div-danh-sach-gop-von").show();
	}else{
		$("#div-danh-sach-gop-von").hide();
	};
};
function resetSearchNganhNghe(){
	$("input#input-search-nganh-nghe").val("");
	searchOptions('','select-data-system','select-system-id','select-selected-id');
}





$(document).ready(function(){
	showOrHideDanhSachGopVon();
	
	if(typeof $('input[name=idTVRq]').val() !== "undefined" ){
		var ids= document.getElementsByName("idTVRq") ;
		var tens= document.getElementsByName("tenTVRq") ;
		var cmnds= document.getElementsByName("cmndTVRq") ;
		var diachis= document.getElementsByName("diaChiTVRq") ;
		var giatris= document.getElementsByName("giaTriTVRq");
		var tyles= document.getElementsByName("tyLeTVRq");
		var id,ten,cmnd,diachi,giatri,tyle;
		for ( var i = 0; i < ids.length; i++) {
			id = ids[i].value;
			ten= tens[i].value;
			cmnd= cmnds[i].value;
			diachi= diachis[i].value;
			giatri= giatris[i].value;
			tyle= tyles[i].value;
			arrayDanhSachGopVon.push({'id':id,'ten':ten,'cmnd':cmnd,'diachi':diachi,'giatri':giatri,'tyle':tyle});
		}	
					
	}
	
		drawTableDanhSachGopVon();
		$('#vonKinhDoanh').vndFormat();
		//overwrite CSS when validate
		$("#hoTenNDD").css('width', '80%', 'important');
		$("#vonKinhDoanh").css('text-align', 'right', 'important');

	});

	/* 
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
	
	 */
</script>