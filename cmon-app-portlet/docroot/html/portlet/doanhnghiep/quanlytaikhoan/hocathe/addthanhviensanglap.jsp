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
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.oep.cmon.dao.cd.model.impl.CongDanImpl"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.DanToc"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%
long idTpDaNang = Long.valueOf(ThamSoLocalServiceUtil.getValue("DANANG"));
String saveOk = "";

long tvslGioiTinh = 0;
String tvslNgaySinh = "";
long tvslQuocTich = 0;
long tvslDanToc = 0;
String tvslNgayCapCMND = "";
long tvslNoiCapCMND = 0;
long tvslTtTinhId = 0;
long tvslTtHuyenId = 0;
long tvslTtXaId = 0;
long tvslCohtTinhId = 0;
long tvslCohtHuyenId = 0;
long tvslCohtXaId = 0;

String tvslGiaTri = "";
String tvslTyLe = "";
String tvslLoaiTaiSan = "";
String tvslNgayGopVon = "";
String tvslGhiChu = "";
CongDan congDan = new CongDanImpl();
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

if(Validator.isNotNull(ParamUtil.getString(request,"saveOk"))){
	saveOk = ParamUtil.getString(request,"saveOk");
}
if(Validator.isNotNull(ParamUtil.getString(request,"tvslGiaTri"))){
	tvslGiaTri = ParamUtil.getString(request,"tvslGiaTri");
}
if(Validator.isNotNull(ParamUtil.getString(request,"tvslTyLe"))){
	tvslTyLe = ParamUtil.getString(request,"tvslTyLe");
}
if(Validator.isNotNull(ParamUtil.getString(request,"tvslLoaiTaiSan"))){
	tvslLoaiTaiSan = ParamUtil.getString(request,"tvslLoaiTaiSan");
}
if(Validator.isNotNull(ParamUtil.getString(request,"tvslNgayGopVon"))){
	tvslNgayGopVon = ParamUtil.getString(request,"tvslNgayGopVon");
}
if(Validator.isNotNull(ParamUtil.getString(request,"tvslGhiChu"))){
	tvslGhiChu = ParamUtil.getString(request,"tvslGhiChu");
}
if(Validator.isNotNull(request.getAttribute("congDan"))){
	congDan = (CongDan)request.getAttribute("congDan");
	if(Validator.isNotNull(congDan.getGioiTinh())){
		tvslGioiTinh = 	congDan.getGioiTinh();
	}
	if(Validator.isNotNull(congDan.getNgaySinh())){
		tvslNgaySinh = 	df.format(congDan.getNgaySinh());
	}
	if(Validator.isNotNull(congDan.getQuocTichId())){
		tvslQuocTich = 	congDan.getQuocTichId();
	}
	if(Validator.isNotNull(congDan.getDanTocId())){
		tvslDanToc = 	congDan.getDanTocId();
	}
	if(Validator.isNotNull(congDan.getNgayCapCmnd())){
		tvslNgayCapCMND = 	df.format(congDan.getNgayCapCmnd());
	}
	if(Validator.isNotNull(congDan.getNoiCapCmndId())){
		tvslNoiCapCMND = 	congDan.getNoiCapCmndId();
	}
	if(Validator.isNotNull(congDan.getDiaChiThuongTruTinhId())){
		tvslTtTinhId = congDan.getDiaChiThuongTruTinhId();
	}else{
		tvslTtTinhId = idTpDaNang;
	}
	if(Validator.isNotNull(congDan.getDiaChiThuongTruHuyenId())){
		tvslTtHuyenId = congDan.getDiaChiThuongTruHuyenId();
	}
	if(Validator.isNotNull(congDan.getDiaChiThuongTruXaId())){
		tvslTtXaId = 	congDan.getDiaChiThuongTruXaId();
	}
	if(Validator.isNotNull(congDan.getDiaChiHienNayTinhId())){
		tvslCohtTinhId = congDan.getDiaChiHienNayTinhId();
	}else{
		tvslCohtTinhId = idTpDaNang;
	}
	if(Validator.isNotNull(congDan.getDiaChiHienNayHuyenId())){
		tvslCohtHuyenId =congDan.getDiaChiHienNayHuyenId();
	}
	if(Validator.isNotNull(congDan.getDiaChiHienNayXaId())){
		tvslCohtXaId = 	congDan.getDiaChiHienNayXaId();
	}
}else{
	tvslTtTinhId = idTpDaNang;
	tvslCohtTinhId = idTpDaNang;
}

List<DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();

PortletURL saveURL = renderResponse.createActionURL();
saveURL.setParameter(ActionRequest.ACTION_NAME, "saveThanhVienSangLap");
%>
<div class="egov-container">
<form method="post" name="frmAddThanhVienSangLap" id="frmAddThanhVienSangLap" action="<%=saveURL%>">
	<input type="hidden" id="saveOk" value="<%= saveOk%>" />
	<table class="egov-table" width="100%" border="0">
		<tbody>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='tvslTen'><liferay-ui:error key="emptyhoTenNDD" message = "Họ tên không được rỗng"/></option>
			      		<option value='tvslTen'><liferay-ui:error key="errorMaxLengTenNDD" message = "Tối đa 100 ký tự"/></option>
			      		<option value='tvslNgaySinh'><liferay-ui:error key="emptyngaySinhNDD" message = "Ngày sinh không được rỗng"/></option>
			      		
			      		<option value='tvslSoCMND'><liferay-ui:error key="cmndNotNumber" message = "Số CMND không cho phép nhập chữ"/></option>	
			      		<option value='tvslSoCMND'><liferay-ui:error key="errorsoCMNDNDD" message = "Lỗi số CMND"/></option>
			      		<option value='tvslSoCMND'><liferay-ui:error key="errorsoCMNDNDD9or12" message = "CMND chỉ được 9 số hoặc 12 số"/></option>
			      		<option value='tvslSoCMND'><liferay-ui:error key="emptysoCMNDNDD" message = "Số CMND không được rỗng"/></option>			      		
			      		<option value='tvslSoCMND'><liferay-ui:error key="cmndOverLimit" message = "Số CMND không hợp lệ"/></option>
			      		
			      		
			      		<option value='tvslNgayCapCMND'><liferay-ui:error key="emptyngayCapCMNDNDD" message = "Ngày cấp CMND không được rỗng"/></option>			      		
			      		<option value='tvslNoiCapCMND'><liferay-ui:error key="emptynoiCapCMNDNDD" message = "Nơi cấp CMND không được rỗng"/></option>
			      		
			      		
			      		<option value='tvslTtTinhId'><liferay-ui:error key="emptytinhTTIdNDD" message = "Chưa chọn tỉnh"/></option>
			      		<option value='tvslTtHuyenId'><liferay-ui:error key="emptyhuyenTTIdNDD" message = "Chưa chọn huyện"/></option>
			      		<option value='tvslTtXaId'><liferay-ui:error key="emptyxaTTIdNDD" message = "Chưa chọn xã"/></option>
			      		<option value='tvslTtMoTaDiaChi'><liferay-ui:error key="emptymoTaTTNDD" message = "Chưa mô tả địa chỉ thường trú"/></option>
			      		<option value='tvslTtMoTaDiaChi'><liferay-ui:error key="errorMaxLengmoTaTTNDD" message = "Mô tả thường trú tối đa 100 ký tự"/></option>
			      		
			      		<option value='tvslCohtTinhId'><liferay-ui:error key="emptytinhHTIdNDD" message = "Chưa chọn tỉnh"/></option>
			      		<option value='tvslCohtHuyenId'><liferay-ui:error key="emptyhuyenHTIdNDD" message = "Chưa chọn huyện"/></option>
			      		<option value='tvslCohtXaId'><liferay-ui:error key="emptyxaHTIdNDD" message = "Chưa chọn xã"/></option>
			      		<option value='tvslCohtMoTaChoO'><liferay-ui:error key="emptymoTaHTNDD" message = "Chưa mô tả địa chỉ hiện tại"/></option>
			      		<option value='tvslCohtMoTaChoO'><liferay-ui:error key="errorMaxLengmoTaHTNDD" message = "Mô tả địa chỉ hiện tại tối đa 100 ký tự"/></option>
			      		
			      		<option value='tvslGiaTri'><liferay-ui:error key="emptyGiaTri" message = "Giá trị góp vốn không được rỗng"/></option>
			      		<option value='tvslGiaTri'><liferay-ui:error key="notNumberGiaTri" message = "Giá trị góp vốn không hợp lệ"/></option>
			      		
			      		<option value='tvslTyLe'><liferay-ui:error key="emptyTyLe" message = "Chưa chọn tỷ lệ"/></option>
			      		<option value='tvslTyLe'><liferay-ui:error key="errorMaxLengTyLe" message = "Lỗi tỷ lệ"/></option>
			      		<option value='tvslTyLe'><liferay-ui:error key="notNumberTyLe" message = "Tỷ lệ không cho phép nhập chữ"/></option>
			      		
			      		<option value='tvslLoaiTaiSan'><liferay-ui:error key="emptyLoaiTaiSan" message = "Loại tài sản không được rỗng"/></option>
			      		<option value='tvslLoaiTaiSan'><liferay-ui:error key="errorMaxLengLoaiTaiSan" message = "Loại tài sản tối đa 200 ký tự"/></option>
			      		
			      		<option value='tvslNgayGopVon'><liferay-ui:error key="emptyNgayGopVon" message = "Ngày góp vốn không được rỗng"/></option>
			      		
			      		<option value='tvslGhiChu'><liferay-ui:error key="errorMaxLengLoaiTaiSan" message = "Ghi chú tối đa 255 ký tự"/></option>
			      		
					</select>
				</td>
			</tr>
			<tr>
				<%
				PortletURL urlPopupListCongDan = renderResponse.createRenderURL();
				urlPopupListCongDan.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistcongdan.jsp");
				urlPopupListCongDan.setWindowState(LiferayWindowState.POP_UP);
				%>
				<td colspan="4">
					<label class="egov-label-bold" >Họ và tên </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslTen" name="tvslTen" value="<%=congDan.getTenDayDu() %>" class="egov-inputfield" style="width: 70% !important"/>
					<input type="hidden" id="tvslId" name="tvslId" value="<%=congDan.getId() %>" />
					<input type="button" value="Tìm công dân" class="egov-button-search" onclick="addThanhVienSangLap.popupSearchCongDan('<%= urlPopupListCongDan %>'); return false;" />
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Giới tính </label><br/>
					<select class="egov-select" name="tvslGioiTinh" id="tvslGioiTinh" >
						<option value="0">--Hãy chọn--</option>
						<%
						List<GioiTinh> listGioiTinh = GioiTinhLocalServiceUtil.getDSGioiTinh();
						for(int i=0;i<listGioiTinh.size();i++){
							String selected = "";
							GioiTinh gioiTinh = listGioiTinh.get(i);
							if(gioiTinh.getId()==tvslGioiTinh){
								selected = "selected='selected'";
							}
						%>
							<option value="<%= gioiTinh.getId() %>" <%=selected%>><%= gioiTinh.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>	
			</tr>
			<tr>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslNgaySinh" name="tvslNgaySinh" value="<%=tvslNgaySinh %>" class="egov-calendar"/>	
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Quốc tịch </label><br/>
					<select class="egov-select" name="tvslQuocTich" id="tvslQuocTich" >
						<option value="0">--Hãy chọn--</option>
						<%
						List<QuocGia> listQuocGia = QuocGiaLocalServiceUtil.findByDaXoa(0);
						for(int i=0;i<listQuocGia.size();i++){
							String selected = "";
							QuocGia quocGia = listQuocGia.get(i);
							if(quocGia.getId()==tvslQuocTich){
								selected = "selected='selected'";
							}
						%>
							<option value="<%= quocGia.getId() %>" <%=selected %>><%= quocGia.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Dân tộc </label><br/>
					<select class="egov-select" name="tvslDanToc" id="tvslDanToc" >
						<option value="0">--Hãy chọn--</option>
						<%
						List<DanToc> listDanToc = DanTocLocalServiceUtil.findAll();
						for(int i=0;i<listDanToc.size();i++){
							String selected = "";
							DanToc danToc = listDanToc.get(i);
							if(danToc.getId()==tvslDanToc){
								selected = "selected='selected'";
							}
						%>
							<option value="<%= danToc.getId() %>" <%=selected %> ><%= danToc.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Số CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslSoCMND" name="tvslSoCMND" value="<%=congDan.getSoCmnd() %>" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslNgayCapCMND" name="tvslNgayCapCMND" value="<%=tvslNgayCapCMND %>" class="egov-calendar"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tvslNoiCapCMND" name="tvslNoiCapCMND">
						<option value="0">--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId()==tvslNoiCapCMND){
								selected = "selected";
							}
						%>
						<option value="<%=tinhThanh.getId() %>" <%=selected %> >Công an <%=tinhThanh.getTen() %></option>
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
					<select class="egov-select" id="tvslTtTinhId" name="tvslTtTinhId" onChange="addThanhVienSangLap.reDrawSelectBox('tvslTtTinhId','tvslTtHuyenId')">
						<option value="0">--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId()==tvslTtTinhId){
								selected = "selected";
							}
						%>
						<option value="<%=tinhThanh.getId() %>" <%=selected %> ><%=tinhThanh.getTen() %></option>
						<%} %>
					</select>	
				</td>
				
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tvslTtHuyenId" name="tvslTtHuyenId"  onChange="addThanhVienSangLap.reDrawSelectBox('tvslTtHuyenId','tvslTtXaId')">
						<option value="0">--Hãy chọn--</option>
						<%
						List <DonViHanhChinh> quanHuyenTtList = DonViHanhChinhLocalServiceUtil.findByChaId(tvslTtTinhId, 0);
						for(int i = 0;i<quanHuyenTtList.size();i++){
							String selected = "";
							DonViHanhChinh quanHuyenDD = quanHuyenTtList.get(i);
							if(quanHuyenDD.getId()==tvslTtHuyenId){
								selected = "selected";
							}
						%>
						<option value="<%=quanHuyenDD.getId() %>" <%=selected %>><%=quanHuyenDD.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tvslTtXaId" name="tvslTtXaId">
						<option value="0">--Hãy chọn--</option>
						<%
						if(tvslTtHuyenId!=0){
							List <DonViHanhChinh> xaTtList = DonViHanhChinhLocalServiceUtil.findByChaId(tvslTtHuyenId, 0);
							for(int i = 0;i<xaTtList.size();i++){
								String selected = "";
								DonViHanhChinh xaTt = xaTtList.get(i);
								if(xaTt.getId()==tvslTtXaId){
									selected = "selected";
								}
						%>
						<option value="<%=xaTt.getId() %>" <%=selected %>><%=xaTt.getTen() %></option>
						<%
						}}
						%>
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=congDan.getDiaChiThuongTru() %>" id="tvslTtMoTaDiaChi" name="tvslTtMoTaDiaChi"/>
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
					<select class="egov-select" id="tvslCohtTinhId" name="tvslCohtTinhId" onChange="addThanhVienSangLap.reDrawSelectBox('tvslCohtTinhId','tvslCohtHuyenId')">
						<option value="0">--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId()==tvslCohtTinhId){
								selected = "selected";
							}
						%>
						<option value="<%=tinhThanh.getId() %>" <%=selected %> ><%=tinhThanh.getTen() %></option>
						<%} %>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tvslCohtHuyenId" name="tvslCohtHuyenId" onChange="addThanhVienSangLap.reDrawSelectBox('tvslCohtHuyenId','tvslCohtXaId')">
						<option value="0">--Hãy chọn--</option>
						<%
						List <DonViHanhChinh> quanHuyenHtList = DonViHanhChinhLocalServiceUtil.findByChaId(tvslCohtTinhId, 0);
						for(int i = 0;i<quanHuyenHtList.size();i++){
							String selected = "";
							DonViHanhChinh quanHuyenHt = quanHuyenHtList.get(i);
							if(quanHuyenHt.getId()==tvslCohtHuyenId){
								selected = "selected";
							}
						%>
						<option value="<%=quanHuyenHt.getId() %>" <%=selected %>><%=quanHuyenHt.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tvslCohtXaId" name="tvslCohtXaId">
						<option value="0">--Hãy chọn--</option>
						<%
						if(tvslCohtHuyenId!=0){
						List <DonViHanhChinh> xaHtList = DonViHanhChinhLocalServiceUtil.findByChaId(tvslCohtHuyenId, 0);
						for(int i = 0;i<xaHtList.size();i++){
							String selected = "";
							DonViHanhChinh xaHt = xaHtList.get(i);
							if(xaHt.getId()==tvslCohtXaId){
								selected = "selected";
							}
						%>
						<option value="<%=xaHt.getId() %>" <%=selected %>><%=xaHt.getTen() %></option>
						<%
						}}
						%>
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả chỗ ở </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=congDan.getDiaChiHienNay() %>" id="tvslCohtMoTaChoO" name="tvslCohtMoTaChoO"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Giá trị góp vốn </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslGiaTri" name="tvslGiaTri" value="<%=tvslGiaTri %>" class="egov-inputfield"/>
				</td>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Tỷ lệ góp vốn (%) </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslTyLe" name="tvslTyLe" value="<%=tvslTyLe %>" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Loại tài sản </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslLoaiTaiSan" name="tvslLoaiTaiSan" value="<%=tvslLoaiTaiSan %>" class="egov-inputfield"/>
				</td>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Ngày góp vốn </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" id="tvslNgayGopVon" name="tvslNgayGopVon" value="<%=tvslNgayGopVon %>" class="egov-calendar"/>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Ghi chú</label><br/>
					<input type="text" id="tvslGhiChu" name="tvslGhiChu" value="<%=tvslGhiChu %>" class="egov-inputfield"/>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" style="padding: 10px !important">
					<a href="#"><input value="Thêm" type="submit" class="egov-button-normal" /></a>
					<a href="#" onclick="window.close();"><input value="Đóng"  type="button" class="egov-button-normal"  /></a>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</div>
</html>
<portlet:actionURL var="getDonViHanhChinhByIdURL" name="getDonViHanhChinhById">
</portlet:actionURL>
<%
PortletURL urlGetDataCongDan = renderResponse.createActionURL();
urlGetDataCongDan.setParameter(ActionRequest.ACTION_NAME, "getDataCongDan");
%>
<script type = "text/javascript">
var addThanhVienSangLap = {
	popupSearchCongDan: function(url){
		this.newWindow = window.open(url,'search cong dan popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
		if (window.focus) {
			this.newWindow.focus();
		}			
		return this;
	},
	reDrawSelectBox: function(selectName, changeName) {
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
	},
	reDrawSelectBoxAndSelectdValue: function(selectValue, changeName, selectedValue) {
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
				addThanhVienSangLap.selectedValueForSelectBox(changeName,selectedValue);
			}
		});
	},
	getDataCongDan: function(congDanId){
		var url='<%= urlGetDataCongDan %>';
		$.get(url,{congDanId:congDanId},function(data1){
			var congDan = JSON.parse(data1);
			$('input[name="tvslId"]').val(congDan.nddId);
			$('input[name="tvslTen"]').val(congDan.nddTen);
			$('input[name="tvslNgaySinh"]').val(congDan.nddNgaySinh);
			$('input[name="tvslSoCMND"]').val(congDan.nddSoCMND);
			$('input[name="tvslNgayCapCMND"]').val(congDan.nddNgayCapCMND);
			$('input[name="tvslTtMoTaDiaChi"]').val(congDan.nddTtMoTaDiaChi);
			$('input[name="tvslCohtMoTaChoO"]').val(congDan.nddCohtMoTaChoO);
			
			addThanhVienSangLap.selectedValueForSelectBox('tvslGioiTinh',congDan.nddGioiTinh);
			addThanhVienSangLap.selectedValueForSelectBox('tvslQuocTich',congDan.nddQuocTich);
			addThanhVienSangLap.selectedValueForSelectBox('tvslDanToc',congDan.nddDanToc);
			addThanhVienSangLap.selectedValueForSelectBox('tvslNoiCapCMND',congDan.nddNoiCapCMND);
			
			addThanhVienSangLap.selectedValueForSelectBox('tvslTtTinhId',congDan.nddTtTinhId);
			
			addThanhVienSangLap.reDrawSelectBoxAndSelectdValue(congDan.nddTtTinhId,'tvslTtHuyenId',congDan.nddTtHuyenId);			
			addThanhVienSangLap.reDrawSelectBoxAndSelectdValue(congDan.nddTtHuyenId,'tvslTtXaId',congDan.nddTtXaId);
			
			addThanhVienSangLap.selectedValueForSelectBox('tvslCohtTinhId',congDan.nddCohtTinhId);
			
			addThanhVienSangLap.reDrawSelectBoxAndSelectdValue(congDan.nddCohtTinhId,'tvslCohtHuyenId',congDan.nddCohtHuyenId);			
			addThanhVienSangLap.reDrawSelectBoxAndSelectdValue(congDan.nddCohtHuyenId,'tvslCohtXaId',congDan.nddCohtXaId);
		});	
	},
	selectedValueForSelectBox: function(idSelectBox,value){
		$("#"+idSelectBox+" option").removeAttr("selected");
		$("#"+idSelectBox+" option[value='"+value+"']").attr('selected','selected');
	},
	addThanhVienSangLap: function(){
		var tinh =$('#tvslTtTinhId option:selected').text();		
		var huyen =$('#tvslTtHuyenId option:selected').text();  
		var xa =$('#tvslTtXaId option:selected').text();   
		var moTaDiaChi=$('input[name=tvslTtMoTaDiaChi]').val() + "-" +xa+ "-" +huyen+ "-" + tinh ;
		window.opener.pushDataToDanhSachGopVon({'id':$('input[name=tvslId]').val(),'ten':$('input[name=tvslTen]').val(),'cmnd':$('input[name=tvslSoCMND]').val(),'diachi':moTaDiaChi,'giatri':$('input[name=tvslGiaTri]').val(),'tyle':$('input[name=tvslTyLe]').val()});
	}
};
function choiceCongDan(congDanId){
	addThanhVienSangLap.getDataCongDan(congDanId);
}
$( document ).ready(function() {
	if($('#saveOk').val()=='OK'){
		addThanhVienSangLap.addThanhVienSangLap();
	}
	$("#tvslTen").css( 'width','70%','important' );
	
});
</script>