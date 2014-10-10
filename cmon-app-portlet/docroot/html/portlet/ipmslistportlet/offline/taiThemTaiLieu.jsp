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
String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}

String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}

HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
List<FileDinhKem> liFileUploadsIservice1 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCong.getId()));
List<FileDinhKem> liFileUploadsIserviceKhongGiaiDoan = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCong.getId()));
%>
<div  class="egov-container">
	<table style="width: 100%; background-color: white;">
		<tr>
			<td align = "right"></td>
			<td align = "right">
				<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/view.jsp");
					timCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
					timCongDanRequestUrl.setParameter("transType", transType);
					timCongDanRequestUrl.setParameter("statusHS", statusHS);
					%>
					<a href="<%=timCongDanRequestUrl.toString() %>">Quay lại&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</td>
		</tr>
	</table>
	<table  class="egov-table-form">
		<tr>
			<td colspan="2" align = "center">
				<label class="egov-label-header">Tải thêm tài liệu</label>
			</td>
		</tr>
		<tr>
			<td align = "right"></td>
			<td align = "left">
				<span style="color: red" id="message_error_delete_file"></span>
			</td>
		</tr>
		<tr>
			<td style="width: 25%">
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
					<label class ="egov-label-bold">Họ tên công dân:</label>
				</td>
				<td>
					<input id="tenCongDan" name="tenCongDan" class = "egov-inputfield custom" value="<%=hoSoTTHCCong.getHoTenNguoiNopHoSo() %>" readonly="readonly" type="text" size="50"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số CMND của công dân:</label>
				</td>
				<td>
					<input id="cmndCongDan" name="cmndCongDan" class = "egov-inputfield custom" readonly="readonly" value="<%=ConvertUtil.findCongDanById(hoSoTTHCCong.getCongDanNopId()).getSoCmnd() %>" type="text" size="50"/>
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
					<label class ="egov-label-bold">Tài liệu đính kèm:</label>
				</td>
				<td align="left">
					<table style="background-color: white;">
						<%
						TaiLieuChungThuc taiLieuChungThuc = null;
						for (FileDinhKem fileUpload : liFileUploadsIservice1) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
							<tr style="display: inherit;" id="<%=fileUpload.getId() %>">
								<td>
									<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
								</td>
								<td>
									<portlet:actionURL var="deleteTaiLieuURL1" name="deleteFileUploadById">
										<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
										<portlet:param name="fileDinhKemId" value="<%=String.valueOf(fileUpload.getId()) %>"/>
										<portlet:param name="noiLuuTruId" value="<%=String.valueOf(taiLieuChungThuc.getNoiLuuTruId()) %>"/>
										<portlet:param name="taiLieuChungThucId" value="<%=String.valueOf(fileUpload.getNoiLuuTruTaiLieuId()) %>"/>
									</portlet:actionURL>
									<img id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>_image_delete" style="display: inherit;" src="/cmon-app-portlet/images/delete-user.png" title="Xóa file tài liệu đã upload" onclick="javascript: deleteFileUpload('<%=deleteTaiLieuURL1.toString()%>', '<%=fileUpload.getId() %>')"/>
								</td>
							</tr>
						<%
							}
						}
						for (FileDinhKem fileUpload : liFileUploadsIserviceKhongGiaiDoan) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
							<tr style="display: inherit;" id="<%=fileUpload.getId() %>">
								<td>
									<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
								</td>
								<td>
									<portlet:actionURL var="deleteTaiLieuURL2" name="deleteFileUploadById">
										<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
										<portlet:param name="fileDinhKemId" value="<%=String.valueOf(fileUpload.getId()) %>"/>
										<portlet:param name="noiLuuTruId" value="<%=String.valueOf(taiLieuChungThuc.getNoiLuuTruId()) %>"/>
										<portlet:param name="taiLieuChungThucId" value="<%=String.valueOf(fileUpload.getNoiLuuTruTaiLieuId()) %>"/>
									</portlet:actionURL>
									<img id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>_image_delete" style="display: inherit;" src="/cmon-app-portlet/images/delete-user.png" title="Xóa file tài liệu đã upload" onclick="javascript: deleteFileUpload('<%=deleteTaiLieuURL2.toString()%>', '<%=fileUpload.getId() %>')"/>
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

<portlet:actionURL var="uploadTaiLieuURL" name="addTaiLieuUpload">
	<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
</portlet:actionURL>
<portlet:actionURL var="checkUploadTaiLieuURL" name="checkFileUpload">
	<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
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

	<form action="<%=uploadTaiLieuURL%>" method="POST" enctype="multipart/form-data" name="upload_data" id="upload_data">
		<table id="myTable">
			<tr>
				<td>
					<label class ="egov-label-bold">Tên tài liệu 1:</label>
					<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
					<input id="searchKeyWord" name="searchKeyWord" type="hidden" value="<%=transactionKeyword %>"/>
					<input id="trangThaiHoSo" name="trangThaiHoSo" type="hidden" value="<%=transType %>"/>
					<input id="statusHS" name="statusHS" type="hidden" value="<%=statusHS %>"/>
				</td>
				<td>
					<input style="background: white;" id="tenLieuDinhKem_1" name="tenLieuDinhKem_1" class = "egov-inputfield custom"  onchange="changeColor('tenLieuDinhKem_1'), checkFileFileUpload('tenLieuDinhKem_1');" type="text" maxlength="200" size="50"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tài liệu 1:</label>
				</td>
				<td>
					<span class="egov-uploadfile">
						<input  style="background: white;" size="40" id="taiLieuDinhKem_1" name="taiLieuDinhKem_1" type="file" onchange="changeColor('taiLieuDinhKem_1')"/><!-- onchange="uploadTaiLieuDinhKemHoSo()" -->
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<a href="#" onclick="addNewRowToTable()">Thêm tài liệu đính kèm</a>
				</td>
				<td></td>
			</tr>
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
var urlCheckFileUpload = '<%=checkUploadTaiLieuURL.toString()%>';
var idQuyTrinh = '<%=HosotthcCongId%>';
function checkFileFileUpload(checkName) {
	document.getElementById('message_error').innerHTML = '';
	document.getElementById('message_error_delete_file').innerHTML = '';
	var tenFileUpload = document.getElementById(checkName).value;
	$.ajax({
		type: 'POST'
		,url: urlCheckFileUpload
		,data : {tenFileUpload: tenFileUpload, idQuyTrinh: idQuyTrinh}
		,success: function(data) {		
			// preferred
			var data2 = JSON.parse(data);

			if (data2.exitFile == 'exitFile') {
				document.getElementById(checkName).value = '';
				document.getElementById('message_error').innerHTML = exitName;
				document.getElementById(checkName).style.background = 'red';
			} 
		}
	});
}

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
	var _tenTaiLieu = tenTaiLieu.split(",");
	var _taiLieuDinhKem = taiLieuDinhKem.split(",");
	for (var j = 0; j < _tenTaiLieu.length; j++) {
	   	var dataTenTaiLieu = document.getElementById(_tenTaiLieu[j]).value;
	   	var dataTaiLieuDinhKem = document.getElementById(_taiLieuDinhKem[j]).value;
	   	if (dataTenTaiLieu.length == 0) {
	   		document.getElementById(_tenTaiLieu[j]).style.background = 'red';
	   		flag = false;
	   	}
	   	if (dataTaiLieuDinhKem.length == 0) {
	   		document.getElementById(_taiLieuDinhKem[j]).style.background = 'red';
	   		flag = false;
	   	}
	}
	if(flag) {
		document.getElementById("upload_data").submit();
	} else {
		document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.empty.upload.file") %>';
	}
}

function removeRow() {
	index = 1;
	tenTaiLieu = 'tenLieuDinhKem_1';
	taiLieuDinhKem = 'taiLieuDinhKem_1';
	document.getElementById('tenLieuDinhKem_1').style.background = 'white';
	document.getElementById('taiLieuDinhKem_1').style.background = 'white';
	document.getElementById('message_error').innerHTML = '';
	while (document.getElementById("myTable").rows.length > 4)
	{
		document.getElementById("myTable").deleteRow(document.getElementById("myTable").rows.length - 3);
	}
}

function changeColor(idComponent) {
	document.getElementById(idComponent).style.background = 'white';
}

function addNewRowToTable()
{
	index = index + 1;
	var table=document.getElementById("myTable");
	var row1=table.insertRow(table.rows.length - 2);
	var cell1=row1.insertCell(0);
	var cell2=row1.insertCell(1);
	var row2=table.insertRow(table.rows.length - 2);
	var cell3=row2.insertCell(0);
	var cell4=row2.insertCell(1);
	cell1.innerHTML="<label class =\"egov-label-bold\">Tên tài liệu " + index + ":</label>";
	cell2.innerHTML="<input  style=\"background: white;\" onchange=\"changeColor('tenLieuDinhKem_" + index + "''), checkFileFileUpload('tenLieuDinhKem_" + index + "');\" id=\"tenLieuDinhKem_" + index + "\" name=\"tenLieuDinhKem_" + index + "\" class = \"egov-inputfield custom\" type=\"text\" maxlength=\"200\" size=\"50\"/>";
	cell3.innerHTML="<label class =\"egov-label-bold\">Tài liệu " + index + ":</label>";
	cell4.innerHTML="<span class=\"egov-uploadfile\"><input  size=\"40\"  style=\"background: white;\" onchange=\"changeColor('taiLieuDinhKem_" + index + "')\" id=\"taiLieuDinhKem_" + index + "\" name=\"taiLieuDinhKem_" + index + "\" type=\"file\"/></span>";
	tenTaiLieu += ',tenLieuDinhKem_' + index;
	taiLieuDinhKem += ',taiLieuDinhKem_' + index;
}

function func_close_themtailieudinhkem(){
	removeRow();
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