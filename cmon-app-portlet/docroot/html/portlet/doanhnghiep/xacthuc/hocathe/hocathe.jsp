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
<%@page import="org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.DanToc"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.dao.dn.service.NganhNgheKinhDoanhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
long loaiDoiTuongId = 0l;
int trangThai = 99;
String maOrTenOrEmail = "";
//get render params
if ( Validator.isNotNull(ParamUtil.getString(request,"loaiDoiTuongId")) ) {
	loaiDoiTuongId = ParamUtil.getLong(request,"loaiDoiTuongId");
}
if ( Validator.isNotNull(ParamUtil.getString(request,"trangThai")) ) {
	trangThai = ParamUtil.getInteger(request,"trangThai");
}
if ( Validator.isNotNull(ParamUtil.getString(request,"maOrTenOrEmail")) ) {
	maOrTenOrEmail = ParamUtil.getString(request,"maOrTenOrEmail");
}
%>
<%
Map<String, String> HCT_OBJECT = new HashMap<String, String>();
if(Validator.isNotNull(request.getAttribute("HCT_OBJECT"))){
	HCT_OBJECT = (Map<String,String>)request.getAttribute("HCT_OBJECT");
}
String idTinh = ThamSoLocalServiceUtil.getValue("DANANG");
List<DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
List <DonViHanhChinh> quanHuyenDDList = DonViHanhChinhLocalServiceUtil.findByChaId(Long.valueOf(idTinh), 0);

%>
<div class="egov-container">
<form method="post" name="frmXacThucHoCaTheMotThanhVien" id="frmXacThucHoCaTheMotThanhVien">
	<table class="egov-table" width="100%">
		<thead>
			<tr>
				<td colspan="6">
					<h3>Xác thực tài khoản Hộ cá thể</h3>
				</td>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='taiKhoanDangNhap'><liferay-ui:error key="error_taikhoandangnhap_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.ten"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<label class="egov-label-bold" >Email</label><label class="egov-label-note" > (Tài khoản đăng nhập) </label><label class='egov-label-red'>(*)</label>
					<input type="text" name="taiKhoanDangNhap" value="<%=HCT_OBJECT.get("taiKhoanDangNhap") %>" class="egov-inputfield"/>
					<input type="hidden" name="idYeuCau" value="<%=HCT_OBJECT.get("idYeuCau") %>" />
				</td>
				<%
				PortletURL urlPopupListDoanhNghiep = renderResponse.createRenderURL();
				urlPopupListDoanhNghiep.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistdoanhnghiep.jsp");
				urlPopupListDoanhNghiep.setWindowState(LiferayWindowState.POP_UP);
				%>
				
				<td colspan="2" style="width: 30% !important">
					<a href="#">
						<br/>
						<input type="button" value="Tìm hộ cá thể" class="egov-button-search" onclick="popupSearchHoCaThe('<%= urlPopupListDoanhNghiep %>'); return false;"/>
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class='egov-label-red'>Thông tin người đại diện</label>
				</td>
			</tr>
			<%
				PortletURL urlPopupListCongDan = renderResponse.createRenderURL();
				urlPopupListCongDan.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/hocathe/popuplistcongdan.jsp");
				urlPopupListCongDan.setWindowState(LiferayWindowState.POP_UP);
			%>
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Họ và tên </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" name="nddTen" readonly="readonly" value="<%=HCT_OBJECT.get("nddTen") %>" class="egov-inputfield" style="width: 80% !important"/>
					<input type="hidden" name="nddId" />
					<input type="button" value="Tìm kiếm" class="egov-button-search" onclick="popupSearchCongDan('<%= urlPopupListCongDan %>'); return false;"/>
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" name="nddNgaySinh" class="egov-calendar" />
				</td>
			</tr>
			<tr>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Giới tính </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" name="nddGioiTinh" id="nddGioiTinh" >
						<option>--Hãy chọn--</option>
						<%
						List<GioiTinh> listGioiTinh = GioiTinhLocalServiceUtil.getDSGioiTinh();
						for(int i=0;i<listGioiTinh.size();i++){
							GioiTinh gioiTinh = listGioiTinh.get(i);
						%>
							<option value="<%= gioiTinh.getId() %>"><%= gioiTinh.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Quốc tịch </label><br/>
					<select class="egov-select" name="nddQuocTich" id="nddQuocTich" >
						<option>--Hãy chọn--</option>
						<%
						List<QuocGia> listQuocGia = QuocGiaLocalServiceUtil.findByDaXoa(0);
						for(int i=0;i<listQuocGia.size();i++){
							QuocGia quocGia = listQuocGia.get(i);
						%>
							<option value="<%= quocGia.getId() %>"><%= quocGia.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important">
					<label class="egov-label-bold" >Dân tộc </label><br/>
					<select class="egov-select" name="nddDanToc" id="nddDanToc" >
						<option>--Hãy chọn--</option>
						<%
						List<DanToc> listDanToc = DanTocLocalServiceUtil.findAll();
						for(int i=0;i<listDanToc.size();i++){
							DanToc danToc = listDanToc.get(i);
						%>
							<option value="<%= danToc.getId() %>"><%= danToc.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Số CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=HCT_OBJECT.get("nddSoCMND") %>" name="nddSoCMND" />
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-calendar" value="<%=HCT_OBJECT.get("nddNgayCapCMND") %>" name="nddNgayCapCMND"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="nddNoiCapCMND" name="nddNoiCapCMND">
						<option>--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId()==Long.valueOf(HCT_OBJECT.get("nddNoiCapCMND"))){
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
					<select class="egov-select" id="nddTtTinhId" name="nddTtTinhId" onChange="reDrawSelectBox('nddTtTinhId','nddTtHuyenId')">
						<option>--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId()==Long.valueOf(idTinh)){
								selected = "selected";
							}
						%>
						<option value="<%=tinhThanh.getId() %>" <%=selected %> ><%=tinhThanh.getTen() %></option>
						<%} %>
					</select>	
				</td>
				
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="nddTtHuyenId" name="nddTtHuyenId"  onChange="reDrawSelectBox('nddTtHuyenId','nddTtXaId')">
						<option>--Hãy chọn--</option>
						<%
						for(int i = 0;i<quanHuyenDDList.size();i++){
							DonViHanhChinh quanHuyenDD = quanHuyenDDList.get(i);
						%>
						<option value="<%=quanHuyenDD.getId() %>"><%=quanHuyenDD.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="nddTtXaId" name="nddTtXaId">
						<option>--Hãy chọn--</option>
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" name="nddTtMoTaDiaChi"/>
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
					<select class="egov-select" id="nddCohtTinhId" name="nddCohtTinhId" onChange="reDrawSelectBox('nddCohtTinhId','nddCohtHuyenId')">
						<option>--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId()==Long.valueOf(idTinh)){
								selected = "selected";
							}
						%>
						<option value="<%=tinhThanh.getId() %>" <%=selected %> ><%=tinhThanh.getTen() %></option>
						<%} %>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="nddCohtHuyenId" name="nddCohtHuyenId" onChange="reDrawSelectBox('nddCohtHuyenId','nddCohtXaId')">
						<option>--Hãy chọn--</option>
						<%
						for(int i = 0;i<quanHuyenDDList.size();i++){
							DonViHanhChinh quanHuyenDD = quanHuyenDDList.get(i);
						%>
						<option value="<%=quanHuyenDD.getId() %>"><%=quanHuyenDD.getTen() %></option>
						<%
						}
						%>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="nddCohtXaId" name="nddCohtXaId">
						<option>--Hãy chọn--</option>
					</select>	
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả chỗ ở </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" name="nddCohtMoTaChoO"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Điện thoại </label><br/>
					<input type="text" class="egov-inputfield" name="nddDienThoai"/>
				</td>
				<td colspan="3" style="width: 45%">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" class="egov-inputfield" name="nddFax"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" class="egov-inputfield" value="<%=HCT_OBJECT.get("nddEmail") %>" name="nddEmail" />
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" class="egov-inputfield" name="nddWebsite"/>
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
					<input type="text" readonly="readonly" name="ten" value="<%=HCT_OBJECT.get("ten") %>" class="egov-inputfield"/>
					<input type="hidden" name="id"/>
					
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=HCT_OBJECT.get("maGiayPhep") %>" name="maGiayPhep" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="tinhId" name="tinhId" onChange="reDrawSelectBox('tinhId','huyenId')">
						<option>--Hãy chọn--</option>
						<%
						for(int i=0;i<tinhThanhList.size();i++){
							String selected = "";
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId() == Long.valueOf(HCT_OBJECT.get("tinhId"))){
								selected = "selected";
							}
						%>
						<option value="<%=tinhThanh.getId() %>" <%=selected %> ><%=tinhThanh.getTen() %></option>
						<%} %>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" id="huyenId" name="huyenId" onChange="reDrawSelectBox('huyenId','xaId')">
						<option>--Hãy chọn--</option>
						<%
						List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(Long.valueOf(HCT_OBJECT.get("tinhId")), 0);
						for(int i = 0;i<quanHuyenList.size();i++){
							String selected = "";
							DonViHanhChinh quanHuyen = quanHuyenList.get(i);
							if(quanHuyen.getId() == Long.valueOf(HCT_OBJECT.get("huyenId"))){
								selected = "selected";
							}
						%>
						<option value="<%=quanHuyen.getId() %>" <%=selected %> ><%=quanHuyen.getTen() %></option>
						<%} %>
					</select>	
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Phường/Xã </label><br/>
					<select class="egov-select" id="xaId" name="xaId" >
						<option>--Hãy chọn--</option>
						<%
						List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(Long.valueOf(HCT_OBJECT.get("huyenId")), 0);
						for(int i = 0;i<phuongXaList.size();i++){
							String selected = "";
							DonViHanhChinh phuongXa = phuongXaList.get(i);
							if(phuongXa.getId() == Long.valueOf(HCT_OBJECT.get("xaId"))){
								selected = "selected";
							}
						%>
						<option value="<%=phuongXa.getId() %>" <%=selected %> ><%=phuongXa.getTen() %></option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Chi tiết địa điểm </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=HCT_OBJECT.get("chiTietDiaDiem") %>" name="chiTietDiaDiem"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Mã số thuế </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=HCT_OBJECT.get("maSoThue") %>" name="maSoThue"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày đăng ký </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-calendar" name="ngayDangKy" />
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Vốn kinh doanh (VNĐ) </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" name="vonKinhDoanh" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Điện thoại </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" name="dienThoai" />
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" class="egov-inputfield" name="fax"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" class="egov-inputfield" name="email"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" class="egov-inputfield" name="website" />
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả nghề nghiệp </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield" value="<%=HCT_OBJECT.get("moTaNgheNghiep") %>" name="moTaNgheNghiep" />
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Loại hộ kinh doanh </label><label class='egov-label-red'>(*)</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Radio" class="egov-radio" name="loaiHoKinhDoanh" value="caNhan" onclick="showOrHideDanhSachGopVon()" checked> Cá nhân&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Radio" class="egov-radio" name="loaiHoKinhDoanh" value="nhomTapThe" onclick="showOrHideDanhSachGopVon()"> Nhóm tập thể
				</td>
			</tr>
			<tr>
				<td colspan="6" style="padding: 0px">
					<div id="div-danh-sach-gop-von" style="display: none;">
						<%
						PortletURL urlPopup = renderResponse.createRenderURL();
						urlPopup.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/hocathe/addthanhviensanglap.jsp");
						urlPopup.setWindowState(LiferayWindowState.POP_UP);
						%>
						<h3>Danh sách góp vốn thành lập hộ kinh doanh</h3>
						<a href="#" style="float: right;">
							<input type="button" value="Thêm thành viên" class="egov-button" onclick="popupAddThanhVienSangLap('<%= urlPopup %>'); return false;"/>
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
									<select name="" id="select-selected-id" name="select-selected-id" multiple="multiple" class="egov-multi-select" size="13">
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
				backUrl.setParameter("maOrTenOrEmail",maOrTenOrEmail);
				backUrl.setParameter("trangThai",String.valueOf(trangThai));
				backUrl.setParameter("loaiDoiTuongId",String.valueOf(loaiDoiTuongId));
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
</portlet:actionURL>
<%
PortletURL urlGetDataHoCaThe = renderResponse.createActionURL();
urlGetDataHoCaThe.setParameter(ActionRequest.ACTION_NAME, "getDataHoCaThe");

PortletURL urlGetDataCongDan = renderResponse.createActionURL();
urlGetDataCongDan.setParameter(ActionRequest.ACTION_NAME, "getDataCongDan");
%>
<script type="text/javascript" >
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
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;' >"+arrayDanhSachGopVon[i]['ten']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+arrayDanhSachGopVon[i]['cmnd']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;' >"+arrayDanhSachGopVon[i]['diachi']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+arrayDanhSachGopVon[i]['giatri']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' >"+arrayDanhSachGopVon[i]['tyle']+"</td>";
		xhtml += "<td style='border: #d6d6d6 solid 1px !important;text-align: center;' ><a href='#' onclick=\"objectRemoveByKey(arrayDanhSachGopVon,'id','"+arrayDanhSachGopVon[i]['id']+"');return false;\" >Xóa</a></td>";
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
		$('input[name="nddTen"]').val(congDan.nddTen);
		$('input[name="nddNgaySinh"]').val(congDan.nddNgaySinh);
		$('input[name="nddSoCMND"]').val(congDan.nddSoCMND);
		$('input[name="nddNgayCapCMND"]').val(congDan.nddNgayCapCMND);
		$('input[name="nddNoiCapCMND"]').val(congDan.nddNoiCapCMND);
		$('input[name="nddTtMoTaDiaChi"]').val(congDan.nddTtMoTaDiaChi);
		$('input[name="nddCohtMoTaChoO"]').val(congDan.nddCohtMoTaChoO);
		$('input[name="nddDienThoai"]').val(congDan.nddDienThoai);
		$('input[name="nddFax"]').val(congDan.nddFax);
		$('input[name="nddEmail"]').val(congDan.nddEmail);
		$('input[name="nddWebsite"]').val(congDan.nddWebsite);
		
		selectedValueForSelectBox('nddGioiTinh',congDan.nddGioiTinh);
		selectedValueForSelectBox('nddQuocTich',congDan.nddQuocTich);
		selectedValueForSelectBox('nddDanToc',congDan.nddDanToc);
		//dia chi thuong tru
		selectedValueForSelectBox('nddTtTinhId',congDan.nddTtTinhId);
		
		reDrawSelectBoxAndSelectdValue(congDan.nddTtTinhId,'nddTtHuyenId',congDan.nddTtHuyenId);			
		reDrawSelectBoxAndSelectdValue(congDan.nddTtHuyenId,'nddTtXaId',congDan.nddTtXaId);
		//cho o hien tai
		selectedValueForSelectBox('nddCohtTinhId',congDan.nddCohtTinhId);
		
		reDrawSelectBoxAndSelectdValue(congDan.nddCohtTinhId,'nddCohtHuyenId',congDan.nddCohtHuyenId);			
		reDrawSelectBoxAndSelectdValue(congDan.nddCohtHuyenId,'nddCohtXaId',congDan.nddCohtXaId);
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

function popupAddThanhVienSangLap(url){
	this.newWindow = window.open(url,'thanh vien sang lap popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
	if (window.focus) {
		this.newWindow.focus();
	}			
	return this;
}
function popupSearchHoCaThe(url){
	this.newWindow = window.open(url,'tim kiem ho ca the popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
	if (window.focus) {
		this.newWindow.focus();
	}			
	return this;
}
function popupSearchCongDan(url){
	this.newWindow = window.open(url,'tim kiem cong dan popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');
	if (window.focus) {
		this.newWindow.focus();
	}			
	return this;
}
$( document ).ready(function() {
	showOrHideDanhSachGopVon();
	drawTableDanhSachGopVon();
});
</script>