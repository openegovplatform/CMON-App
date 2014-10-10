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
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
if (Validator.isNull(HosotthcCongId)) {
	HosotthcCongId = renderRequest.getParameter("hoSoTTHCCongId");
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
List<FileDinhKem> liFileUploadsIservice3 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));

// BinhNT add 2013-12-27, theo yeu cau cua chi Dung tester qua mail.
List<FileDinhKem> liFileUploadsIservice1 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCong.getId()));
List<FileDinhKem> liFileUploadsIserviceKhongGiaiDoan = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCong.getId()));
// End BinhNT Add

TaiKhoanNguoiDung taiKhoanNguoiDung = null;
long congDanNopId = hoSoTTHCCong.getCongDanNopId();
CongDan congDan = CongDanLocalServiceUtil.fetchCongDan(congDanNopId);

if (congDan != null && congDan.getTaiKhoanNguoiDungId() != null) {
	
	taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(congDan.getTaiKhoanNguoiDungId());
}

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
			<td width="35%"></td>
			<td width="60%"></td>
		</tr>
		<tr>
			<td colspan="2" align = "center" width="100%">
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
				<label class ="egov-label-bold">Tên dịch vụ công:</label>
			</td>
			<td>
				<label class ="egov-label"><%=hoSoTTHCCong.getTenThuTucHanhChinh() %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Mã hồ sơ:</label>
			</td>
			<td>
				<label class ="egov-label"><%=hoSoTTHCCong.getMaSoHoSo() %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Người nộp hồ sơ:</label>
			</td>
			<td>
				<label class ="egov-label"><%=hoSoTTHCCong.getHoTenNguoiNopHoSo() %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Ngày nộp hồ sơ:</label>
			</td>
			<td>
				<label class ="egov-label"><%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayNopHoSo()) %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Ngày hết hiệu lực:</label>
			</td>
			<td>
				<label class ="egov-label"><%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayKetThucXuLy()) %></label> 
			</td>
		</tr>
			<tr>
                <td valign="top">
                    <label class ="egov-label-bold">Tài liệu công dân tải lên:</label>
                </td>
                <td align="left">
                    <table style="background-color: white;">
                        <%
                        TaiLieuChungThuc taiLieuChungThuc1 = null;
                        for (FileDinhKem fileUpload : liFileUploadsIservice1) {
                            taiLieuChungThuc1 = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
                            if (taiLieuChungThuc1 != null) {
                            %>
                            <tr style="display: inherit;" id="<%=fileUpload.getId() %>">
                                <td>
                                    <a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc1.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc1.getTen() %></a>
                                </td>
                            </tr>
                        <%
                            }
                        }
                        for (FileDinhKem fileUpload : liFileUploadsIserviceKhongGiaiDoan) {
                            taiLieuChungThuc1 = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
                            if (taiLieuChungThuc1 != null) {
                            %>
                            <tr style="display: inherit;" id="<%=fileUpload.getId() %>">
                                <td>
                                    <a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc1.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc1.getTen() %></a>
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
                <td valign="top">
                    <label class ="egov-label-bold">Tài liệu trong quá trình xử lý :</label>
                </td>
                <td align="left">
                    <table style="background-color: white;">
                        <%
                        
                        List<TaiLieuChungThuc> listTaiLieuChungThucBoXung = TaiLieuChungThucLocalServiceUtil.findByHosotthcCongIdAndLoai(Long.parseLong(HosotthcCongId), 1);
                        for (TaiLieuChungThuc taiLieuChungThucBoXung : listTaiLieuChungThucBoXung) {
                         %>
                            <tr style="display: inherit;" id="<%=taiLieuChungThucBoXung.getId() %>">
                                <td>
                                    <a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThucBoXung.getNoiLuuTruId()) %>" id = "<%=taiLieuChungThucBoXung.getNoiLuuTruId() %>" style="display: inherit;"><%=taiLieuChungThucBoXung.getTen() %></a>
                                </td>
                            </tr>
                         <% } %>
                    </table>
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
	
<% if (taiKhoanNguoiDung == null) {  %>
	<p><label class ="egov-label-bold" style="padding-left:0px;">(Công dân không có tài khoản nên không thể trả kết quả số) .</label>
<% } else { %>	
	<!-- begin upload result documents -->
	<portlet:actionURL var="uploadTaiLieuURL" name="uploadLoadFileKetQua">
		<portlet:param name="jspPage" value="/html/portlet/offline/view.jsp"/>
	</portlet:actionURL>
	<div id="themtailieudinhkem_dialog">
		<p><label class ="egov-label-bold" style="padding-left:0px;">Tài liệu kết quả xử lý:</label>
		<p>
			<span style="color: red" id="message_error"></span>
	
		<%
		List<FileKetQua> listFileDinhKem = ConvertUtil.findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(hoSoTTHCCong.getThuTucHanhChinhId(), 3);
		%>
		<form action="<%=uploadTaiLieuURL%>" method="POST" enctype="multipart/form-data" name="upload_data" id="upload_data">
			<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
			
			<input id="congDanNopId" name="congDanNopId" type="hidden" value="<%=congDanNopId %>"/>
			<input id="searchKeyWord" name="searchKeyWord" type="hidden" value="<%=transactionKeyword %>"/>
			<input id="trangThaiHoSo" name="trangThaiHoSo" type="hidden" value="<%=transType %>"/>
			<input id="statusHS" name="statusHS" type="hidden" value="<%=statusHS %>"/>
			<input id="ThuTucHanhChinhId" name="ThuTucHanhChinhId" type="hidden" value="<%=hoSoTTHCCong.getThuTucHanhChinhId() %>"/>
			<table id="myTable"  align="center" border="0" class="egov-table-form">
				<tr>
					<td width="16.67%">&nbsp;</td>
					<td width="16.67%">&nbsp;</td>
					<td width="16.67%">&nbsp;</td>
					<td width="16.67%">&nbsp;</td>
					<td width="16.67%">&nbsp;</td>
					<td width="16.67%">&nbsp;</td>
				</tr>
				<%
				
				
				for (int i=0; i< listFileDinhKem.size(); i ++) {
					FileKetQua danhMucGiayTo = listFileDinhKem.get(i);
					
					TaiLieuChungThuc taiLieuChungThucDB = null;
					FileDinhKem fileUploadDB = null;
					for (FileDinhKem fileUpload : liFileUploadsIservice3) {
						TaiLieuChungThuc taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
						if (taiLieuChungThuc != null && fileUpload.getDanhMucGiayToId()==danhMucGiayTo.getDanhMucGiayToId()) {
							taiLieuChungThucDB = taiLieuChungThuc;
							fileUploadDB = fileUpload;
							//break;
						}
					}
					String showfilename = "showfilename"+i;
				%>
				<tr id="<%=fileUploadDB != null? fileUploadDB.getId():0 %>">
					<td colspan="2"> 
						<label class ="egov-label"><%=(i+1) + ". "%></label>
						<label class ="egov-label" id="tenTL_<%=danhMucGiayTo.getDanhMucGiayToId()%>">
							<%=danhMucGiayTo.getTenTaiLieu()%>
						</label>
					</td>
					<td  colspan="2">
						<span showfilename="<%= showfilename %>" class="egov-uploadfile">
							<span>Chọn tệp tin</span>
							<input  style="background: white;" size="40" id="file_<%=danhMucGiayTo.getDanhMucGiayToId() %>" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>" 
								type="file" onchange="changeColor('<%=danhMucGiayTo.getDanhMucGiayToId() %>')"/>
							<input id="<%=danhMucGiayTo.getDanhMucGiayToId() %>_thutuc2giayto" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>_thutuc2giayto" type="hidden" value="<%=danhMucGiayTo.getThuTuc2GiayToId() %>"/>
							<input id="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ma" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ma" type="hidden" value="<%=danhMucGiayTo.getMaTaiLieu() %>"/>
							<input id="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ten" name="<%=danhMucGiayTo.getDanhMucGiayToId() %>_ten" type="hidden" value="<%=danhMucGiayTo.getTenTaiLieu() %>"/>
						</span>
						<span id="<%= showfilename %>" class="egov-label-uploadfile"></span>
												
					</td>
					<td id="name_<%=danhMucGiayTo.getDanhMucGiayToId()%>">
						<% if (taiLieuChungThucDB != null) { %>
							<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThucDB.getNoiLuuTruId()) %>" 
								id = "<%=fileUploadDB.getNoiLuuTruTaiLieuId() %>" style="display: inherit;">Tải xuống</a>
						<% } %>
					</td>
					
					<td>
						<% if (taiLieuChungThucDB != null && renderRequest.getAttribute("add_ho_so_completed") == null) { %>
							<portlet:actionURL var="deleteTaiLieuURL2" name="deleteFileUploadKetQua">
								<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
								<portlet:param name="taiLieuChungThucId" value="<%=String.valueOf(taiLieuChungThucDB.getId()) %>"/>
								<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(fileUploadDB.getHoSoTTHCCongId()) %>"/>
							</portlet:actionURL>
							<img id = "<%=fileUploadDB.getNoiLuuTruTaiLieuId() %>_image_delete" style="display: inherit;" 
										src="/cmon-app-portlet/images/delete-user.png" title="Xóa tài liệu đã tải" 
										onclick="javascript: deleteFileUpload('<%=deleteTaiLieuURL2.toString()%>', '<%=fileUploadDB.getNoiLuuTruTaiLieuId() %>')"/>
						<% } %>
					</td>
				</tr>
				<tr>
					<td style="padding-left: 15px;" colspan="1">
						<label class ="egov-label">Hiệu lực từ ngày: </label>
					</td>
					
					<%
						String tuNgay = "";
						String denNgay = "";
						String checked = ""; 
						if (taiLieuChungThucDB != null) {
							tuNgay = ConvertUtil.parseDateToTring(taiLieuChungThucDB.getHieuLucTuNgay());
							denNgay = ConvertUtil.parseDateToTring(taiLieuChungThucDB.getHieuLucDenNgay());
							if (taiLieuChungThucDB.getHieuLucDenNgay() == null) {
								checked = "checked";
							}
						}
						if (Validator.isNull(tuNgay)) {
							tuNgay = ConvertUtil.parseDateToTring(new Date());
						}
					%>
					<td> 
						<input type="text" readonly="readonly" class="egov-calendar"
							style="float: right;" name="tuNgay_<%=danhMucGiayTo.getDanhMucGiayToId()%>" id="tuNgay_<%=danhMucGiayTo.getDanhMucGiayToId()%>"
						value="<%=tuNgay %>" />
					</td>
					<td style="padding-left: 15px;">
						<label class ="egov-label">Đến ngày: </label>
					</td>
					<td> 
						<input type="text" readonly="readonly" class="egov-calendar" onchange="changeHieuLuc('<%=danhMucGiayTo.getDanhMucGiayToId() %>');"
							style="float: right;" name="denNgay_<%=danhMucGiayTo.getDanhMucGiayToId()%>" id="denNgay_<%=danhMucGiayTo.getDanhMucGiayToId()%>"
						value="<%=denNgay %>" />
					</td>
					<td style="text-align: right;">
						<input type="checkbox" class="egov-checkbox" id="voThoiHan_<%=danhMucGiayTo.getDanhMucGiayToId()%>" 
							onchange="disaleNgay(this,'<%=danhMucGiayTo.getDanhMucGiayToId()%>')" <%=checked%> />&nbsp;
						<label class="egov-label"> Vô thời hạn</label>
					</td>
				</tr>
					<%
				}
				%>
				<tr>
					<td colspan="2" align = "center">
						<input type="button" style="height: 35px;padding:10px;" onclick="validationBeforeSubmit()" class = "egov-button" name="submitButton"  value="Lưu lại" />
					</td>
				</tr>	
			</table>
		</form>
	</div>	
	
	<% } %>
</div>

<script type="text/javascript">
var index = 1;
var tenTaiLieu = 'tenLieuDinhKem_1';
var taiLieuDinhKem = 'taiLieuDinhKem_1';
var messageDeleted = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.delete.file.upload") %>';
var exitName = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.file.upload.exit.name") %>';
var listFileName = '';
var idQuyTrinh = '<%=HosotthcCongId%>';
var selectedFileIds = "";
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
	if (selectedFileIds != "") {
		var fileIdArr = selectedFileIds.split(",");
		for (var i=0; i<fileIdArr.length; i++) {
			var fileId = fileIdArr[i];
			var checkBoxForever = document.getElementById("voThoiHan_" + fileId);
			if (checkBoxForever && !checkBoxForever.checked && (document.getElementById('denNgay_' + fileId).value=='')) {
				alert('Chọn thời hạn cho tài liệu : ' + document.getElementById('tenTL_' + fileId).innerHTML);
				return;
			}
		}
	}
		
	
	document.getElementById('message_error').innerHTML = '';
	var flag = true;
	if(flag) {
		document.getElementById("upload_data").submit();
	} else {
		document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.form.offline.empty.upload.file") %>';
	}
}

function disaleNgay(checkbox, danhMucGiayToId) {
	var denNgay = document.getElementById('denNgay_' + danhMucGiayToId);
	if(checkbox.checked) {
		denNgay.value = "";
		denNgay.disabled="disabled";
		//denNgay.disable=true;
	} else {
		denNgay.disabled=false;
	}
}

function changeHieuLuc(idComponent) {
	document.getElementById("voThoiHan_" + idComponent).checked = false;	
}

function changeColor(idComponent) {
	var input = document.getElementById("file_" + idComponent);
	input.style.background = 'white';
	
	// display file name
	/*
	var idFileName = "span_" + selectName;
	Remove(idFileName);
	
	var spanNode = input.parentNode;
	var tdNode = spanNode.parentNode;
	var newHtml = document.createElement("span");
	newHtml.setAttribute("style", "float: left");
	newHtml.setAttribute("id", idFileName);
	var fileNameArr = input.value.split("\\");
	var fileName = fileNameArr[fileNameArr.length - 1];
	newHtml.innerHTML = fileName; 
	tdNode.appendChild(newHtml);
	*/
	if (selectedFileIds != "") {
		selectedFileIds = selectedFileIds +  ",";
	}
	selectedFileIds = selectedFileIds + idComponent; 
}

function Remove(EId)
{
    return(EObj=document.getElementById(EId))?EObj.parentNode.removeChild(EObj):false;
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