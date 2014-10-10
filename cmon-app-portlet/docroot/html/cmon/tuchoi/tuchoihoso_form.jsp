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
    //Quocdv add code for url role back
    String urlRoleBack = request.getParameter("ulrRoleBack");
    String loaiCanBo = request.getParameter("loaiCanBo");
    System.err.println("loaiCanBo:" +loaiCanBo);
	System.err.println("hoSoTTHCCongId tu choi form:" +hoSoTTHCCongId);
	
%>

<portlet:actionURL var="tuChoiHoSo"  name="tuChoiHoSo">
	<portlet:param name="hoSoTTHCCongId" value="<%= hoSoTTHCCongId.toString() %>"></portlet:param>
	<portlet:param name="loaiCanBo" value="<%= loaiCanBo %>"></portlet:param>
	<portlet:param name="nguoiGuiId" value="<%=String.valueOf( taiKhoanNguoiDung.getId()) %>"></portlet:param>
</portlet:actionURL>

<div class="egov-container">
	
	<form action="<%= tuChoiHoSo %>" method="post" enctype="multipart/form-data" name="tuchoihoso" id="tuchoihoso">
	       
	    	<table align="center" border="0" class="egov-table-form">  
	    		<tr>
					<td colspan="6"> 
						<input type="hidden" name="hoSoTTHCCongId" id="hoSoTTHCCongId"  value="<%=hoSoTTHCCongId%> "/> 
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
	     			
	     				<td  colspan="4"><label class="egov-label-bold">Ý kiến:</label> <br>
						<textarea id="yKien" class="egov-textarea" name="yKien" rows="7" style="width: 600px;"></textarea>
						</td>
				</tr>
				
	     </table>  
	    
			<table  align="center" border="0" class="egov-table-form">
				<tr>
					<td > <label class="egov-label-bold">Văn bản từ chối:</label> 
			       		<span class="egov-uploadfile" showfilename="showfilename1">
				      	<span>Chọn tệp tin</span>
				     	<input  type="file" name="vanbantuchoi" id="vanbantuchoi" class="egov-uploadfile" />
				      </span>
				      <span id="showfilename1" class="egov-label-uploadfile">Chưa chọn file</span>
				      	 	
					      		
			       </td>
				     
				</tr>
				<tr>
	     			
	     			<td style="margin-left: 200px">
							<input type="submit" 
								class="egov-button" value="Gửi ý kiến"
								onclick="return CheckTuChoi();">
							<a	href="<%=urlRoleBack.toString()%>" > <input
								type="button" class="egov-button" value="Quay lại"> </a>
					</td>
					
				</tr>
			</table>
			 
	</form>

</div>
<script type="text/javascript">
function CheckTuChoi(){
	var yKien = document.getElementById('yKien');
	var yKien = yKien.value;

	var vanbantuchoi = document.getElementById('vanbantuchoi');
	var vanbantuchoi = vanbantuchoi.value;
	
	if (vanbantuchoi.length<=0 && yKien.length<=0){
		alert("Bạn phải nhập nội dung hoặc chọn file upload");
		return false;
		// confirm("Bạn phải nhập nội dung hoặc chọn file upload");
	}
};

function changeColor(idComponent) {
	var input = document.getElementById("vanbantuchoi");
	input.style.background = 'white';
	var spanNode = input.parentNode;
	var tdNode = spanNode.parentNode;
	var newHtml = document.createElement("span");
	newHtml.setAttribute("style", "margin-top:0px; padding-left:0px;");
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

	
	
	