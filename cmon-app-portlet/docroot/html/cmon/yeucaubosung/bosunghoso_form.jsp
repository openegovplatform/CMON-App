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
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
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
long userId = PortalUtil.getUserId(request);
TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
	
	String hoSoTTHCCongId =  request.getParameter("idHoSo");
System.err.println("idhoSoTTHCCongId_hoso:" +hoSoTTHCCongId);
  //Quocdv add code
   //Quocdv add code for url role back
    String urlRoleBack = request.getParameter("ulrRoleBack");
    String loaiCanBo = request.getParameter("loaiCanBo");
    System.err.println("loaiCanBo:" +loaiCanBo);
	String backUrl =  request.getParameter("backUrl");
	
%>

<portlet:actionURL var="boSungHoSo"  name="boSungHoSo">
	<portlet:param name="hoSoTTHCCongId" value="<%= hoSoTTHCCongId.toString() %>"></portlet:param>
	<portlet:param name="backUrl" value="<%= backUrl %>"></portlet:param>
	<portlet:param name="urlRoleBack" value="<%= urlRoleBack %>"></portlet:param>
	<portlet:param name="loaiCanBo" value="<%= loaiCanBo %>"></portlet:param>
	<portlet:param name="nguoiGuiId" value="<%= String.valueOf(taiKhoanNguoiDung.getId()) %>"></portlet:param>
</portlet:actionURL>
	
<div class="egov-container">
	
	<form action="<%=boSungHoSo%>" method="post" enctype="multipart/form-data" name="bosunghoso" id="bosunghoso" onsubmit="return checkBoSung()">
	       
	    	<table cellspacing="0" cellpadding="0" class="egov-table-form">   
	    	
	    		<tr>
					<td colspan="6">
						<select style="display: none;"	id="egov-form-errors" class="">
							<option value="yKien">
								<liferay-ui:error key="err.yKien"  message="Bạn chưa nhập nội dung yêu cầu" />
							</option>
							
						</select>
					</td>
				</tr>  
				<tr>
	     			
	     				<td colspan="6"><label class="egov-label-bold">Yêu cầu bổ sung hồ sơ</label> <br>
						</td>
				</tr>     
	     		<tr>
	     			
	     				<td colspan="4"><label class="egov-label-bold">Nội dung yêu cầu:</label> <br>
						<textarea  class="egov-textarea"  cols="50" rows="7"  id="yKien1" name="yKien1" style="width: 100%"> </textarea>
						</td>
				</tr>
				
				</table>
				
				<table  cellspacing="0" cellpadding="0" class="egov-table-form">
				
				<tr>
					<td > <label class="egov-label-bold">Văn bản yêu cầu:</label>
				      <span class="egov-uploadfile" showfilename="showfilename1">
				      	<span>Chọn tệp tin</span>
				     	<input type="file" name="vanbanbosung" id="vanbanbosung" class="egov-uploadfile"  /> 
				      </span>
				      <span id="showfilename1" class="egov-label-uploadfile">Chưa chọn file</span>
				      	 	
				       </td>
				</tr>
				<tr>
	     			
	     			<td >
							<input type="submit"
								class="egov-button" value="Gửi yêu cầu" >
							<%
								if (backUrl != null){
							%>	
								<a	href="javascript:history.back()" >  <input	type="button" class="egov-button" value="Quay lại" ></a>
							<%
								} else {
							%>
								<a	href="<%=urlRoleBack.toString()%>" >  <input	type="button" class="egov-button" value="Quay lại" ></a>
							<%} %>
								
								</td>
					
				</tr>
				
			   	
	     </table>  

			 
	</form>

</div>


<script type="text/javascript">
function checkBoSung(){
	console.log("just submit the form");
	var yKien = document.getElementById('yKien1').value.trim();
	console.log("dfdsf");
	
	if (yKien.length == 0){
		alert("Bạn phải nhập nội dung ý kiến");
		//yKien.focus();
		return false;
	}
	console.log("return");
	return true;
};

function changeColor(idComponent) {
	var input = document.getElementById("vanbanbosung");
	
	//input.style.background = 'white';
	var spanNode = input.parentNode;
	var tdNode = spanNode.parentNode;
	var newHtml = document.getElementById("span");
	newHtml.setAttribute("style", "margin-top:0px; padding-left:0px;");
	var fileNameArr = input.value.split("\\");
	var fileName = fileNameArr[fileNameArr.length - 1];
	newHtml.innerHTML = fileName; 
	tdNode.appendChild(fileName);
	
	if (selectedFileIds != "") {
		selectedFileIds = selectedFileIds +  ",";
	}
	selectedFileIds = selectedFileIds + idComponent; 
}
</script>				
				
	
	