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
<%@page import="java.util.Date"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="javax.portlet.PortletURL"%> 


<%
	String HosotthcCongId =  request.getParameter("HosotthcCongId");
	System.err.println("hoSoTTHCCongId luu tai lieu form:" +HosotthcCongId);
	if (HosotthcCongId== null){
		HosotthcCongId =  request.getParameter("idHoSo");
	}
	
	String backUrl =  request.getParameter("backUrl");
	System.err.println("backUrl:" +backUrl);
	
	String loaiCanBo = request.getParameter("loaiCanBo");
    System.err.println("loaiCanBo:" +loaiCanBo);
	
%>

<portlet:actionURL var="upLoadFileDangXuLy"  name="upLoadFileDangXuLy">
	<portlet:param name="HosotthcCongId" value="<%= HosotthcCongId.toString() %>"></portlet:param>
	<portlet:param name="loaiCanBo" value="<%= loaiCanBo %>"></portlet:param>
	<portlet:param name="backUrl" value="<%= backUrl %>"></portlet:param>
</portlet:actionURL>
<head>

<div class="egov-container">
	
	<form action="<%= upLoadFileDangXuLy %>" method="post" enctype="multipart/form-data" name="tuchoihoso" id="tuchoihoso">
	       <input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
	        <input id="backUrl" name="backUrl" type="hidden" value="<%=backUrl %>"/>
	       
	    	<table align="center" border="0" class="egov-table-form">  
	    		<tr>
					<td colspan="6"> 
				     </td>
				</tr> 
	    	
	    		<tr>
					<td colspan="6">
						<select style="display: none;"	id="egov-form-errors" class="">
							<option value="yKien">
								<liferay-ui:error key="err.yKien"  message="Bạn chưa nhập nội dung ý kiến" />
							</option>
							
						</select>
					</td>
				</tr>      
	     		<tr>
	     			
	     				<td colspan="4"><label class="egov-label-bold">Tên tài liệu:</label> <br>
						<input type ="text" id="tenTaiLieu" class="egov-inputfield" name="tenTaiLieu" style="width: 400px;" />
						</td>
				</tr>
				
	     </table>  
			<table  cellspacing="0" cellpadding="0" class="egov-table-form">
				<tr>
					<td > <label class="egov-label-bold">Chọn tài liệu:</label> 
				      <span class="egov-uploadfile" showfilename="showfilename1">
				      	<span>Chọn tệp tin</span>
				     	 <input  type="file" name="vanbandangxuly" id="vanbandangxuly" class="egov-uploadfile" /> 
				      </span>
				      <span id="showfilename1" class="egov-label-uploadfile">Chưa chọn file</span>
				     </td>
				      
				</tr>
				<tr>
	     			
	     			<td style="margin-left: 200px">
							<input type="submit"
								class="egov-button" value="Lưu lại"
								onclick="return CheckVanBan();">
							<a	href="javascript:history.back()" > <input
								type="button" class="egov-button" value="Quay lại"> </a>
					</td>
					
				</tr>
			</table>
			 
	</form>

</div>

<script type="text/javascript">
function CheckVanBan(){
	var tenTaiLieu = document.getElementById('tenTaiLieu');
	var tenTaiLieu = tenTaiLieu.value;

	var vanbandangxuly = document.getElementById('vanbandangxuly');
	var vanbandangxuly = vanbandangxuly.value;
	
	if (tenTaiLieu.length<=0 ){
		alert("Bạn phải nhập tên tài liệu");
		return false;
	}

	if (vanbandangxuly.length<=0 ){
		alert("Bạn phải chọn file upload");
		return false;
	}
};

function changeColor(idComponent) {
	var input = document.getElementById("vanbandangxuly");
	input.style.background = 'white';
	var spanNode = input.parentNode;
	var tdNode = spanNode.parentNode;
	var newHtml = document.createElement("span");
	newHtml.setAttribute("style", "float: left; margin-top:-26px; padding-left:100px;");
	var fileNameArr = input.value.split("\\");
	var fileName = fileNameArr[fileNameArr.length - 1];
	newHtml.innerHTML = fileName; 
	tdNode.appendChild(newHtml);
	
	if (selectedFileIds != "") {
		selectedFileIds = selectedFileIds +  ",";
	}
	selectedFileIds = selectedFileIds + idComponent; 
}
</script>			
	
	
	