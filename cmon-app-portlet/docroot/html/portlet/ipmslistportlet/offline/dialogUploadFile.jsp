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
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%
String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}
String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String searchKeyWord = "";
if (renderRequest.getParameter("searchKeyWord") != null) {
	searchKeyWord = renderRequest.getParameter("searchKeyWord");
}

String _searchKeyWord = "";
if (renderRequest.getParameter("_searchKeyWord") != null) {
	_searchKeyWord = renderRequest.getParameter("_searchKeyWord");
}

String idQuyTrinh = "";
if (renderRequest.getParameter("idQuyTrinh") != null) {
	idQuyTrinh = renderRequest.getParameter("idQuyTrinh");
}
String idCongDan = "";
if (renderRequest.getParameter("idCongDan") != null) {
	idCongDan = renderRequest.getParameter("idCongDan");
}

String soDienThoaiCongDan = "";
if (renderRequest.getParameter("soDienThoaiCongDan") != null) {
	soDienThoaiCongDan = renderRequest.getParameter("soDienThoaiCongDan");
}
%>
<portlet:actionURL var="uploadTaiLieuURL" name="uploadTaiLieu">
	<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
</portlet:actionURL>
<portlet:actionURL var="checkUploadTaiLieuURL" name="checkFileUpload">
	<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
</portlet:actionURL>

<div id="themtailieudinhkem_dialog">
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
				<label class ="egov-label">Tên tài liệu 1:</label>
				<input id="idCongDan" name="idCongDan" type="hidden" value="<%=idCongDan %>"/>
				<input id="idQuyTrinh" name="idQuyTrinh" type="hidden" value="<%=idQuyTrinh %>"/>
				<input id="searchKeyWord" name="searchKeyWord" type="hidden" value="<%=searchKeyWord %>"/>
				<input id="_searchKeyWord" name="_searchKeyWord" type="hidden" value="<%=_searchKeyWord %>"/>
				<input type="hidden" name = "transType" id = "transType" value = "<%=transType%>"/>
				<input type="hidden" name = "statusHS" id = "statusHS" value = "<%=statusHS%>"/>
				<input type="hidden" name = "transactionKeyword" id = "transactionKeyword" value = "<%=transactionKeyword%>"/>
				<input id="_soDienThoaiCongDan" name="_soDienThoaiCongDan" onchange="javascript: document.getElementById('message_error_delete_file').innerHTML = '';" type="hidden" value="<%=soDienThoaiCongDan %>" onload="javascript: document.getElementById('_soDienThoaiCongDan').value = window.opener.document.addHoSoRequestForm.soDienThoaiCongDan.value"/>
			</td>
			<td>
				<input style="background: white;" id="tenLieuDinhKem_1" name="tenLieuDinhKem_1" class = "egov-inputfield custom"  onchange="changeColor('tenLieuDinhKem_1'), checkFileFileUpload('tenLieuDinhKem_1');" type="text" maxlength="200" size="50"/>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label">Tài liệu 1:</label>
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
			</td>
		</tr>	
	</table>
	</form>
</div>

<script type="text/javascript">
var index = 1;
var tenTaiLieu = 'tenLieuDinhKem_1';
var taiLieuDinhKem = 'taiLieuDinhKem_1';
var messageDeleted = '<%=LanguageUtil.get(pageContext, "vn.dtt.form.offline.delete.file.upload") %>';
var exitName = '<%=LanguageUtil.get(pageContext, "vn.dtt.form.offline.file.upload.exit.name") %>';
var listFileName = '';

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
		document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "vn.dtt.form.offline.empty.upload.file") %>';
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
	cell1.innerHTML="<label class =\"egov-label\">Tên tài liệu " + index + ":</label>";
	cell2.innerHTML="<input  style=\"background: white;\" onchange=\"changeColor('tenLieuDinhKem_" + index + "'), checkFileFileUpload('tenLieuDinhKem_" + index + "');\" id=\"tenLieuDinhKem_" + index + "\" name=\"tenLieuDinhKem_" + index + "\" class = \"egov-inputfield custom\" type=\"text\" maxlength=\"200\" size=\"50\"/>";
	cell3.innerHTML="<label class =\"egov-label\">Tài liệu " + index + ":</label>";
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

<script type="text/javascript">

	var urlCheckFileUpload = '<%=checkUploadTaiLieuURL.toString()%>';
	var idQuyTrinh = '<%=idQuyTrinh%>';
	function checkFileFileUpload(checkName) {
		document.getElementById('message_error').innerHTML = '';
		document.getElementById('message_error_delete_file').innerHTML = '';
		var tenFileUpload = document.getElementById(checkName).value;
		//var status = flase;
		//var _listFileName = listFileName.split(",");
		//for (var j = 0; j < _listFileName.length; j++) {
		//}
		//if (status) {
			$.ajax({
				type: 'POST'
				,url: urlCheckFileUpload
				,data : {tenFileUpload: tenFileUpload, idQuyTrinh: idQuyTrinh, checkName: checkName}
				,success: function(data) {		
		
					// preferred
					var data2 = JSON.parse(data);
					// Xoa cac old item in select
					
					if (data2.exitFile == 'exitFile') {
						document.getElementById(checkName).value = '';
						document.getElementById('message_error').innerHTML = exitName;
						document.getElementById(checkName).style.background = 'red';
					} else {

					}
				}
			});
		//}
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
					document.getElementById(fileId + '_image_delete').style.display = 'none';
					document.getElementById('message_error_delete_file').innerHTML = messageDeleted;
				} else {
					document.getElementById('message_error').innerHTML = '';
					document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "vn.dtt.form.offline.error.delete.file.upload") %>';
				}
			}
		});
	}

	var url = '<%=uploadTaiLieuURL.toString() %>';

	//Ve lai danh sach don vi hanh chinh
	function uploadTaiLieuDinhKemHoSo() {
		var filename = document.getElementById('taiLieuDinhKem_1');
		var ten_file = document.getElementById('tenLieuDinhKem_1').value;
		
		var oMyForm = new FormData();
		oMyForm.append("taiLieuDinhKem_1", filename.files[0]);
		oMyForm.append("tenLieuDinhKem_1", ten_file);
		
		$.ajax({
			url: url,
		    data: oMyForm,
			dataType: 'multipart/form-data',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data){
				alert(data);
			}
		});
	}

	function viewFileUpload(url)
	{
	    var w=screen.width;
	    var h=screen.height;
	    var left = (screen.width/2)-(w/2);
	    var top = (screen.height/2)-(h/2);
	    popupWindow = window.open(url, '', 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	    popupWindow.focus();
	}
</script>