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
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DoanhNghiep"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.FileKetQua"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/dialog-ui.css" type="text/css" media="screen" />
<script src="<%=request.getContextPath()%>/js/jquery.form.js"	type="text/javascript"></script>

<%
String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}

String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}

HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
DoanhNghiep congDan = ConvertUtil.findDoanhNghiepById(hoSoTTHCCong.getDoiTuongCanXuLyId());
CongDan conDanNop = ConvertUtil.findCongDanById(hoSoTTHCCong.getCongDanNopId());
List<FileDinhKem> liFileUploadsIservice3 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));
%>
<div  class="egov-container">
	<table style="width: 100%; background-color: white;">
		<tr>
			<td align = "right" width="100%">
				<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/view.jsp");
					timCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
					timCongDanRequestUrl.setParameter("statusHS", statusHS);
					timCongDanRequestUrl.setParameter("transType", transType);
					%>
					<a href="<%=timCongDanRequestUrl.toString() %>">Quay lại&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</td>
		</tr>
	</table>
	<table class="egov-table-form">
		<tr>
			<td colspan="2" align = "center">
				<label class="egov-label-header">Tải kết quả xử lý</label>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<span style="color: red" id="message_error_delete_file"></span>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Cơ quan tiếp nhận:</label>
			</td>
			<td>
				<input id="coQuanTiepNhanTen" name="coQuanTiepNhanTen" class = "egov-inputfield custom" readonly="readonly" type="text" size="50" value="<%=hoSoTTHCCong.getTenCoQuanTiepNhan() %>"/>
				<input id="searchKeyWord" name="searchKeyWord" type="hidden" value="<%=transactionKeyword %>"/>
			</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên quy trình:</label>
				</td>
				<td>
					<input id="tenQuyTrinh" name="tenQuyTrinh" class = "egov-inputfield custom" readonly="readonly" value="<%=hoSoTTHCCong.getTenThuTucHanhChinh() %>" type="text" size="50"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold" style="color: blue;">Thông tin công dân nộp hồ sơ</label>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số CMND của công dân:</label>
				</td>
				<td>
					<input id="cmndCongDanNop" name="cmndCongDanNop" class = "egov-inputfield custom" readonly="readonly" value="<%=ConvertUtil.getCMNDCongDan(conDanNop) %>" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Họ tên công dân:</label>
				</td>
				<td>
					<input id="tenCongDanNop" name="tenCongDanNop" class = "egov-inputfield custom" value="<%=ConvertUtil.getTenCongDan(conDanNop) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ thường trú:</label>
				</td>
				<td>
					<input id="diaChiThuongTruCongDanNop" name="diaChiThuongTruCongDanNop" class = "egov-inputfield custom" value="<%=ConvertUtil.getDiaChiThuongTruCongDan(conDanNop) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số điện thoại:</label>
				</td>
				<td>
					<input id="soDienThoaiCongDan" name="soDienThoaiCongDan" class = "egov-inputfield custom" value="<%=ConvertUtil.getTelphoneCongDan(conDanNop, hoSoTTHCCong.getSoDienThoaiDiDongNguoiNop()) %>" type="text" maxlength="11" size="70"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label class ="egov-label-bold" style="color: blue;">Thông tin doanh nghiệp</label>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên doanh nghiệp:</label>
				</td>
				<td>
					<input id="tenCongDan" name="tenCongDan" class = "egov-inputfield custom" value="<%=congDan.getTen() %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số doanh nghiệp:</label>
				</td>
				<td>
					<input id="maSoDoanhNghiep" name="maSoDoanhNghiep" class = "egov-inputfield custom" readonly="readonly" value="<%=congDan.getMa() %>" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số thuế:</label>
				</td>
				<td>
					<input id="maSoThueDoanhNghiep" name="maSoThueDoanhNghiep" class = "egov-inputfield custom" value="<%=congDan.getMaSoThue() %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ doanh nghiệp:</label>
				</td>
				<td>
					<input id="diaChiThuongTruCongDan" name="diaChiThuongTruCongDan" class = "egov-inputfield custom" value="<%=ConvertUtil.getDiaChiDoanhNghiep(congDan) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày nộp hồ sơ:</label>
				</td>
				<td>
					<input id="ngayNopHoSo" name="ngayNopHoSo" class = "egov-inputfield custom" value="<%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayNopHoSo()) %>" readonly="readonly" type="text" size="50"/>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Kết quả xử lý:</label>
				</td>
				<td align="left">
					<table style="background-color: white;">
						<%
						TaiLieuChungThuc taiLieuChungThuc = null;
						for (FileDinhKem fileUpload : liFileUploadsIservice3) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
							<portlet:actionURL var="deleteTaiLieuURL" name="deleteFileUploadKetQua">
								<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
								<portlet:param name="taiLieuChungThucId" value="<%=String.valueOf(taiLieuChungThuc.getId()) %>"/>
								<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(fileUpload.getHoSoTTHCCongId()) %>"/>
							</portlet:actionURL>
							<tr style="display: inherit;" id="<%=fileUpload.getId() %>">
								<td>
									<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
								</td>
								<td>
								<%
								if (renderRequest.getAttribute("add_ho_so_completed") == null) {
								%>
									<img id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>_image_delete" style="display: inherit;" src="/cmon-app-portlet/images/delete-user.png" title="Xóa file tài liệu đã upload" onclick="javascript: deleteFileUpload('<%=deleteTaiLieuURL.toString()%>', '<%=fileUpload.getNoiLuuTruTaiLieuId() %>')"/>
								<%
								}
								%>
								</td>
							</tr>
							<%
							}
						}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<%
					if (renderRequest.getAttribute("add_tai_lieu_completed") == null) {
						%>
						<a href="#" id="themtailieudinhkem_popup">Tải tài liệu</a>
						<%
					}
					%>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				</td>
			</tr>
	</table>
</div>

<portlet:actionURL var="uploadTaiLieuURL" name="uploadLoadFileKetQuaDoanhNghiep">
	<portlet:param name="jspPage" value="/html/portlet/offline/view.jsp"/>
</portlet:actionURL>
<div id="themtailieudinhkem_dialog" style="display: none;">
	<table>
		<tr>
			<td>
			</td>
			<td align="left">
				<span style="color: red" id="message_error"></span>
			</td>
		</tr>
	</table>

	<%
	List<FileKetQua> listFileDinhKem = ConvertUtil.findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(hoSoTTHCCong.getThuTucHanhChinhId(), 3);
	%>
	<form action="<%=uploadTaiLieuURL%>" method="POST" enctype="multipart/form-data" name="upload_data" id="upload_data">
		<table id="myTable">
			<tr>
				<td style="display: none;">
					<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
					<input id="searchKeyWord" name="searchKeyWord" type="hidden" value="<%=transactionKeyword %>"/>
					<input id="trangThaiHoSo" name="trangThaiHoSo" type="hidden" value="<%=transType %>"/>
					<input id="statusHS" name="statusHS" type="hidden" value="<%=statusHS %>"/>
					<input id="ThuTucHanhChinhId" name="ThuTucHanhChinhId" type="hidden" value="<%=hoSoTTHCCong.getThuTucHanhChinhId() %>"/>
				</td>
				<td>
				</td>
			</tr>
			<%
			for (FileKetQua danhMucGiayTo : listFileDinhKem) {
				%>
			<tr>
				<td>
					<label class ="egov-label-bold"><%=danhMucGiayTo.getTenTaiLieu() %>:</label>
				</td>
				<td>
					<span class="egov-uploadfile">
						<input  style="background: white;" size="40" id="<%=danhMucGiayTo.getDanhMucGiayToId() %>" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>" type="file" onchange="changeColor('<%=danhMucGiayTo.getDanhMucGiayToId() %>')"/>
						<input id="<%=danhMucGiayTo.getDanhMucGiayToId() %>_thutuc2giayto" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>_thutuc2giayto" type="hidden" value="<%=danhMucGiayTo.getThuTuc2GiayToId() %>"/>
						<input id="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ma" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ma" type="hidden" value="<%=danhMucGiayTo.getMaTaiLieu() %>"/>
						<input id="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ten" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ten" type="hidden" value="<%=danhMucGiayTo.getTenTaiLieu() %>"/>
					</span>
				</td>
			</tr>
				<%
			}
			%>
			<tr>
				<td colspan="2" align = "center">
					<input type="button" style="height: 35px;padding:10px;" onclick="validationBeforeSubmit()" class = "egov-button" name="submitButton"  value="Lưu lại" />
					<input type="reset" style="height: 35px;padding:10px;" onclick="func_close_themtailieudinhkem();" class = "egov-button" name="reset"  value="Thoát" />
				</td>
			</tr>	
		</table>
	</form>
</div>	

<script type="text/javascript">
var index = 1;
var tenTaiLieu = 'tenLieuDinhKem_1';
var taiLieuDinhKem = 'taiLieuDinhKem_1';
var messageDeleted = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.delete.file.upload") %>';
var exitName = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.file.upload.exit.name") %>';
var listFileName = '';
var idQuyTrinh = '<%=HosotthcCongId%>';

function deleteFileUpload(UrlDelete, fileId) {
	document.getElementById('message_error').innerHTML = '';
	document.getElementById('message_error_delete_file').innerHTML = '';
	$.ajax({
		type: 'POST'
		,url: UrlDelete
		,data : {}
		,success: function(data) {		

			// preferred
			var data2 = JSON.parse(data);
			// Xoa cac old item in select
			
			if (data2.deleteComplete == 'completed') {
				document.getElementById(fileId).style.display = 'none';
				document.getElementById(fileId + '_image_delete').style.display = 'none';
				document.getElementById('message_error_delete_file').innerHTML = messageDeleted;
			} else {
				document.getElementById('message_error').innerHTML = '';
				document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.error.delete.file.upload") %>';
			}
		}
	});
}

function validationBeforeSubmit() {
	document.getElementById('message_error').innerHTML = '';
	
	var flag = true;
	if(flag) {
		document.getElementById("upload_data").submit();
	} else {
		document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.empty.upload.file") %>';
	}
}

function changeColor(idComponent) {
	document.getElementById(idComponent).style.background = 'white';
}

function func_close_themtailieudinhkem(){
	$('#themtailieudinhkem_dialog').dialog('close');
}

function func_themtailieudinhkem(){
	document.getElementById('message_error_delete_file').innerHTML = '';
	$("#themtailieudinhkem_dialog").dialog({
		title:'Thêm tài liệu đính kèm',
        resizable: false,
        modal: true,
        width: '550px',
        
        closeOnEscape: false,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                $('#themtailieudinhkem_dialog').dialog('close');
            });
        }
	});
}

$(document).ready(function(){
	
	$("#themtailieudinhkem_popup").click(function(e){
		func_themtailieudinhkem();
	});
	
});
</script>