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
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.ListUtil"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

PortletURL actionUrl = renderResponse.createActionURL();
//
actionUrl.setParameter(ActionRequest.ACTION_NAME, "addMoreTaiLieu");
actionUrl.setWindowState(LiferayWindowState.NORMAL);	
actionUrl.setParameter("jspPage", "/html/portlet/document/setting/popup_tai_lieu.jsp");


String actionTyPe= ParamUtil.getString(request, "ActionType");
String tthcId= ParamUtil.getString(request, "tt2popId");
long loaiTLId=ParamUtil.getLong(request, "loaiTL2popId");


if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (tthcId)) {
	tthcId = "";
}


%>
<div class="egov-container">
<form id="<portlet:namespace/>uploadFileTLForm" name="<portlet:namespace/>uploadFileTLForm" method="post" action="<%=actionUrl.toString() %>" enctype="multipart/form-data" >
<portlet:actionURL var="checkUploadTaiLieuURL" name="checkFileUpload" >
	<portlet:param name="jspPage" value="/html/portlet/document/setting/popup_tai_lieu.jsp"/>
</portlet:actionURL>
<table cellpadding="0" cellspacing="0" class="egov-table-form" style="width: 100%;">
<tr>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	
</tr>
	<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header">Bổ sung thêm tài liệu <%
			String strTLType="";
			if(loaiTLId==DocumentConstants.TTHC2VBBM.BIEU_MAU)
			{
				strTLType="biểu mẫu";
			}
			else
			{
				strTLType="hướng dẫn";
			}
			%><%=strTLType %></label>
			<br><br>
		</td>
	</tr>
	<tr>
	<td colspan="6">
		<span style="color: red" id="message_error"></span>
		<select style="display: none;" id="egov-form-errors">
			<option value="tenTaiLieu"><liferay-ui:error key="existTenFileUpLoad" message = "vn.dtt.cmon.document.setting.popup.tailieu.exist.ten"/></option>
			<option value="tenTaiLieu"><liferay-ui:error key="emptyTenFileUpLoad" message = "vn.dtt.cmon.document.setting.popup.tailieu.empty.ten"/></option>				
			<option value="taiLieuDinhKem"><liferay-ui:error key="existFileUpload" message = "vn.dtt.cmon.document.setting.popup.tailieu.exist.file"/></option>
			<option value="taiLieuDinhKem"><liferay-ui:error key="emptyFileUpload" message = "vn.dtt.cmon.document.setting.popup.tailieu.empty.file"/></option>
		</select>				
		<liferay-ui:error key="errorAddTaiLieu" message = "vn.dtt.cmon.document.setting.popup.tailieu.error.add"/>
		<%
		if (ParamUtil.getString(request, "CompletedAddTaiLieu") != null && ParamUtil.getString(request, "CompletedAddTaiLieu").trim().length() > 0) {
			%>
			<liferay-ui:success key="successAddTaiLieu" message="vn.dtt.cmon.document.setting.popup.tailieu.completed.add"/>
			<%
		}
		%>
		<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>				
		<input type="hidden" name = "tthcId" id = "tthcId" value = "<%=tthcId%>"/>
		<input type="hidden" id="loaiTaiLieuId" name="loaiTaiLieuId"	value="<%=loaiTLId %>" />
		<input type="hidden" name="action" id="action" value="">
	  </td>	
	</tr>
	<tr>
		<td colspan="6"><label class="egov-label-bold">Tên tài liệu
				</label> (<label class="egov-label-red">*</label>) <br> 
			<input name="tenTaiLieu" type="text" id="tenTaiLieu" maxlength="250" 
					class="egov-inputfield"  style="width:96%;" onchange="changeColor('tenTaiLieu'), checkFileFileUpload('tenTaiLieu');"		/>
		</td>

	</tr>
		<tr>
		
		<td colspan="6">
		<label class="egov-label-bold">Tải file lên
					</label> (<label class="egov-label-red">*</label>)<br> 
			<span class="egov-uploadfile">
			<input  style="background: white;" size="40" id="taiLieuDinhKem" name="taiLieuDinhKem" type="file" 
				onchange="changeColor('taiLieuDinhKem')"/>
			</span>
	</td>
	</tr>
	<tr>
		<td colspan="6" valign="top"><label class="egov-label-bold"> Mô tả về loại giấy tờ này </label><br>
<textarea name="motaTaiLieu" id="motaTaiLieu" class = "egov-textarea" rows="8" cols="43" maxlength="255" ></textarea>
		      </td>
	</tr>
	</table>
	
	<table cellpadding="0" cellspacing="0" class="egov-table-form" style="width: 100%;">
	<tr>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="6" align="left">		
		<input type="button" class = "egov-button-normal" name="submitButton"  value="Upload tài liệu"  onclick="validationBeforeSubmit()"/>
		<button type="button" name="closeForm" id="closeForm" class="egov-button-normal" title="Đóng lại" onClick="javascript:closeAuiPopUp();" >Đóng lại</button>
		</td>
	</tr>
	</table>
</form>
	</div>
<script type="text/javascript">
	
	function closeAuiPopUp(){
		var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.chdmgt.confirm.exit.popup") %>');
		if (answer){
			top.document.getElementById('closethick').click();
		}
	}
	function validationBeforeSubmit() {
		document.getElementById('message_error').innerHTML = '';
		var flag = true;
	
	   	var dataTenTaiLieu = document.getElementById('tenTaiLieu').value;
	   	var dataTaiLieuDinhKem = document.getElementById('taiLieuDinhKem').value;
	   	if (dataTenTaiLieu.length == 0) {
	   		document.getElementById('tenTaiLieu').style.background = 'red';
	   		flag = false;
	   	}
	   	if (dataTaiLieuDinhKem.length == 0) {
	   		document.getElementById('taiLieuDinhKem').style.background = 'red';
	   		flag = false;
	   	}
		
		if(flag) {
			document.getElementById("<portlet:namespace/>uploadFileTLForm").submit();
		} else {
			document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.popup.tailieu.empty.upload.file") %>';
		}
	}
	var exitName = '<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.popup.tailieu.exist.file") %>';
	var listFileName = '';
	var urlCheckFileUpload = '<%=checkUploadTaiLieuURL.toString()%>';
	var idQuyTrinh = '<%=tthcId%>';
	var idLoaiTL='<%=loaiTLId%>';
	function checkFileFileUpload(checkName) {
		document.getElementById('message_error').innerHTML = '';		
		var tenFileUpload = document.getElementById(checkName).value;
		$.ajax({
			type: 'POST'
			//,contentType:attr("enctype", "multipart/form-data")
			,url: urlCheckFileUpload
			,data : {tenFileUpload: tenFileUpload, idQuyTrinh: idQuyTrinh, idLoaiTL:idLoaiTL}
			,success: function(data) {		
				// preferred
				var data2 = JSON.parse(data);

				if (data2.existFile == 'existFile') {
					document.getElementById(checkName).value = '';
					document.getElementById('message_error').innerHTML = exitName;
					document.getElementById(checkName).style.background = 'red';
				} 
			}
		});
	}


	function changeColor(idComponent) {
		document.getElementById(idComponent).style.background = 'white';
	}

	function <portlet:namespace/>submitForm(url) {	
		document.<portlet:namespace/>uploadFileTLForm.action=url;
		document.<portlet:namespace/>uploadFileTLForm.submit();
	}
	
	function func_close_themtailieu(){
		var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.chdmgt.confirm.exit.popup") %>');
		if (answer){
			window.close();
		}
	}
	
	<%
	if(request.getAttribute("action")!= null){
		%>
		//window.opener.reloadForm(self);
        top.document.getElementById('closethick').click();
        var curPortletBoundaryId = '#p_p_id<portlet:namespace />';
        Liferay.Portlet.refresh(curPortletBoundaryId);
		<%
	}
		
	%>

</script>