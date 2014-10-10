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
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="org.oep.cmon.portlet.document.action.CitizenDocumentPortlet"%>
<%@page import="org.oep.cmon.portlet.document.business.CitizenDocumentBusiness"%>
<%@page import="org.oep.sharedservice.cmon.SharedserviceUtil"%>
<%@page import="org.oep.sharedservice.cmon.provider.thamso.ThamSoServiceImpl"%>
<%@page import="org.oep.sharedservice.cmon.provider.thamso.IThamSoService"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>

<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	CitizenDocumentPortlet portlet = new CitizenDocumentPortlet();

	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	int delta = ParamUtil.getInteger(renderRequest, "delta", 10);

	PortletURL actionUrl = renderResponse.createActionURL();
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddChungThucRequest");
	portlet.setSearchParameter(actionUrl, cur, delta);
	
	// Create back URL
	PortletURL backUrl = renderResponse.createRenderURL();
	backUrl.setParameter("jspPage",	"/html/portlet/document/citizen/citizen_document_list.jsp");
	portlet.setSearchParameter(backUrl, cur, delta);

	String luuTruId			= ParamUtil.getString(request, "luuTruId", "");	
	String modeView			= ParamUtil.getString(request, "modeView", "");
	String file				= ParamUtil.getString(request, "file", "");
	String danhMucGiayToId	= ParamUtil.getString(request, "danhMucGiayToId", "");
	long doiTuongId 		= ParamUtil.getLong(renderRequest, "doiTuongId");
	long congDanId 			= ParamUtil.getLong(renderRequest, "congDanId");
	String trangThai		= ParamUtil.getString(request, "trangThai", "");
	
	String fileType		= ParamUtil.getString(request, "fileType", "");
	
	String fileSize		= ParamUtil.getString(request, "fileSize", "");
	
	long fileSizeUp = ConvertUtil.convertToLong(fileSize)/1024/1024;
	
	String errorUploadFile		= ParamUtil.getString(request, "errorUploadFile", "");
	
	List<DanhMucGiayTo> danhMucGiayToList = null;
	
	try {
		
		danhMucGiayToList = portlet.listByCongDan(doiTuongId);
		if(doiTuongId <= 0) {
			try {
				IThamSoService  thamSo = new ThamSoServiceImpl();
				doiTuongId = (thamSo == null) ? 1	: FormatUtil.convertToLong(thamSo.getValue(Constants.TS_CONG_DAN));
			} catch (Exception e) {

			}
		}
		if(congDanId <= 0) {
			try {
				long liferay_user = PortalUtil.getUserId(request);
				TaiKhoanNguoiDung tkUser = new TaiKhoanNguoiDungImpl(); 
				tkUser = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(liferay_user);
				congDanId = (tkUser == null) ? 0	: tkUser.getId();
			} catch (Exception e) {

			}
		}

	} catch (Exception e) {
		SessionErrors.add(renderRequest, "errorAddOrUpdate");
	}
	
%>

<script type="text/javascript">
function checkFileUpLoad()
{ 	
	 var filesize;	
	 var fileId = document.getElementById('file').value;
	 filesize = fileId.files[0].size/1024/1024;
	 if(fileId != '')
	 { 
	  	var valid_extensions = /(.jpg|.jpeg|.gif|.doc|.docx|.xls|.xlsx|.pdf)$/i;   
	 	if(!valid_extensions.test(fileId))
	  	{ 
	 		 alert('Không đúng định dạng file.');
			  return false;
	  	}
	 } 
	
	 if (filesize > 10){
		 alert('Dung lượng file quá lớn.');
		 return false;
	 }
	
}
</script>

<div class="egov-container" id="_cttlCongDanForm">
<portlet:resourceURL var="listDanhMucGiayTo" id="listDanhMucGiayTo" />
<portlet:actionURL var="checkTrangThaiURL" name="checkTrangThaiUrl" >
	<portlet:param name="jspPage" value="/html/portlet/document/citizen/citizen_document_form.jsp"/>
</portlet:actionURL>
<form id="<portlet:namespace/>cttlCongDanForm" name="<portlet:namespace/>cttlCongDanForm" method="post" action="<%=actionUrl.toString() %>" enctype="multipart/form-data">
<input type="hidden" name = "modeView" id = "modeView" value = "<%= modeView%>"/>
<input type="hidden" name="luuTruId" id="luuTruId" value="<%=luuTruId%>">
<input type="hidden" name="doiTuongId" id="doiTuongId" value="<%=doiTuongId%>">
<input type="hidden" name="congDanId" id="congDanId" value="<%=congDanId%>">
<input type="hidden" name="trangThai" id="trangThai" value="<%=trangThai%>">
<table align="center" border="0" class="egov-table-form" width="100%">
	<tr>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
		<td width="16.67%">&nbsp;</td>
	</tr>
	<tr>
			<tr>
			<td colspan="6" align="center" style="width: 100%">		
			<br>
				<label class="egov-label-header">
							<% if (CitizenDocumentBusiness.ADD_TAI_LIEU.equals(modeView)) { %>				
								<liferay-ui:message key="vn.dtt.cmon.document.citizen.form.add.title"/>
							<% } else if (CitizenDocumentBusiness.UPDATE_TAI_LIEU.equals(modeView)) { %>
								<liferay-ui:message key="vn.dtt.cmon.document.citizen.form.edit.title"/>
							<% } else if (CitizenDocumentBusiness.VIEW_TAI_LIEU.equals(modeView)) { %>
								<liferay-ui:message key="vn.dtt.cmon.document.citizen.form.view.title"/>
							<% } %>
				</label> 
			<br><br>	
			</td>
			</tr>
		    <tr>
		      <td colspan="6" align = "left">	
		      <%
		      	if (errorUploadFile.length() >0 ){
		      %>
		      	<label class="egov-label-bold" style="color: red;"> Bạn chỉ có thể upload file dạng <%=fileType %>, dung lượng file không vượt quá <%= fileSizeUp %> mb</label>
		      <%} %>
		      	<liferay-ui:error key="errorAddOrUpdate" message = "vn.dtt.cmon.document.citizen.error.system"/>
		       	<select style="display: none;" id="egov-form-errors">
					<option value="file"><liferay-ui:error 	key="emptyFile" message = "vn.dtt.cmon.document.citizen.error.file.empty"/></option>
					<option value="danhMucGiayToId"><liferay-ui:error 	key="emptyDanhMucGiayTo" message = "vn.dtt.cmon.document.citizen.error.dmgt.empty"/></option>
				</select>
				<liferay-ui:success key="successUpdate" message="vn.dtt.cmon.document.citizen.completed.edit"/>				
				<liferay-ui:success key="successAdd" message="vn.dtt.cmon.document.citizen.completed.add"/>
			  </td>	
		    </tr>
		    <tr>
		      <td colspan="3">
		      		<label class ="egov-label-bold"><liferay-ui:message key="vn.dtt.cmon.document.citizen.form.dmgt"/></label><label class="egov-label-red">*</label><br>
	      			<select id="danhMucGiayToId" name="danhMucGiayToId" class="egov-select" style="width: 98%" >
	      				<% 
	      				if (danhMucGiayToList != null && danhMucGiayToList.size() > 0) {
	      						for (DanhMucGiayTo danhMucGiayTo : danhMucGiayToList) {
	      							
	      							
	      				%>
	      						
     							<option value="<%=danhMucGiayTo.getId()%>"  <%= CitizenDocumentBusiness.checkSelectedValue(danhMucGiayToId, danhMucGiayTo.getId()) %>>
     								<%=HtmlUtil.escape(danhMucGiayTo.getTen())%></option>
	      				<% 
	      					}
		      			 }
	      				%>
      				</select>
		     	 </td>
		     	 <td colspan="3"></td>
		    </tr>	   
			 <tr>
		      <td colspan="3" >
		      		<!--<label class="egov-label-bold"><liferay-ui:message key="vn.dtt.cmon.document.citizen.form.file"/> </label><label class="egov-label-red">*</label><br>
		      		 <span class="egov-uploadfile">
		      		<input name="file" type="file" id="file"  />
		      		</span> -->
		      		
		      		 <span class="egov-uploadfile" showfilename="showfilename1">
				      	<span>Chọn tệp tin</span>
				     	 <input  type="file" name="file" id="file" class="egov-uploadfile" /> 
				      </span>
				      <span id="showfilename1" class="egov-label-uploadfile">Chưa chọn file</span>
		      		
		      </td>
		      <td colspan="3"></td>
		    </tr>
		     <%
		     	PortletURL historyUrl = renderResponse.createActionURL();
	    		historyUrl.setParameter(ActionRequest.ACTION_NAME, "viewChungThucCongDan");
	    		historyUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_history.jsp");
	    		historyUrl.setParameter("congDanId", String.valueOf(congDanId));
	    		historyUrl.setParameter("doiTuongId", String.valueOf(doiTuongId));
	    		historyUrl.setParameter("danhMucGiayToId", danhMucGiayToId);
	    		portlet.setSearchParameter(historyUrl, cur, delta);
		     	//Neu da chung thuc thi hien thi thong bao canh bao
		    	if(danhMucGiayToId != "" && CitizenDocumentBusiness.checkExistChungThuc(FormatUtil.convertToLong(danhMucGiayToId), congDanId))
		    	{
		    %>
		    <tr>
		     	<td colspan="6" >
			     	<p class="note" id="note">
			     		<span id="message"><liferay-ui:message key="vn.dtt.cmon.document.citizen.form.exist"/> <a href="<%=historyUrl.toString()%>"><liferay-ui:message key="vn.dtt.cmon.document.citizen.form.history"/></a></span> <span id="sp_history"></span>
			     	</p>
		     	</td>
		    </tr>
		    <%
		    	}
		    	else
		    	{
		    %>
		    <tr>
		     	<td colspan="6" >
			     	<p class="note" id="note">
			     		<span id="message"></span> <span id="sp_history"></span>
			     	</p>
		     	</td>
		    </tr>
		    <%
		    	}
		    %>
			<tr>
				<td colspan="6" align="left">
					<span style="margin-right: 10px">			
						<% if (CitizenDocumentBusiness.ADD_TAI_LIEU.equals(modeView)) { %>				
							<input type="button" class="egov-button-normal" name=submitButton id="submitButton" value="<liferay-ui:message key="vn.dtt.cmon.document.citizen.form.submit"/>" />
						<% } else if (CitizenDocumentBusiness.UPDATE_TAI_LIEU.equals(modeView)) { %>
							<input type="button" class="egov-button-normal" name=submitButton id="submitButton" value="<liferay-ui:message key="vn.dtt.cmon.document.citizen.form.submit"/>" />
						<% } %>
					</span> 
					<span>
	 					<a	href="<%=backUrl.toString()%>" id="linkBackToList">
							<input type="button"	name="backUrl" id="buttonBackToList"
								class="egov-button-normal" value="Quay lại danh sách" />
						</a>
					</span>
					<br>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
$(document).ready(function() {
		
	if (<%= CitizenDocumentBusiness.VIEW_TAI_LIEU.equals(modeView) %>) {
		disableAllItem();
	}

	 $('#submitButton').click(function() {
			document.<portlet:namespace/>cttlCongDanForm.submit();
	 });
	 
	$("#danhMucGiayToId").change(function(){
		document.getElementById('message').innerHTML ="";
		document.getElementById('sp_history').innerHTML = '';
		var congDanId = $('#_cttlCongDanForm').find('#congDanId').val();
		var doiTuongId = $('#_cttlCongDanForm').find('#doiTuongId').val();
		var dmgtId = $('#_cttlCongDanForm').find('#danhMucGiayToId').val();
		//var UrlCheck = '<%=checkTrangThaiURL.toString()%>';
		var UrlCheck = '<%=listDanhMucGiayTo.toString()%>';
		var UrlHistory= '<%=historyUrl.toString()%>';
		UrlHistory = UrlHistory+"&congDanId="+congDanId+"&danhMucGiayToId="+dmgtId+"&doiTuongId="+doiTuongId;
		//alert(UrlHistory);
		 $.getJSON(UrlCheck+"&congDanId="+congDanId+"&danhMucGiayToId="+dmgtId+"&doiTuongId="+doiTuongId, function(data) {
			if (data.exist=='true')
			{
				document.getElementById('message').innerHTML = '<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.form.exist") %>';
				document.getElementById('sp_history').innerHTML = '<a href='+UrlHistory+'>'+'<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.form.history") %>'+'</a>';
			} else {
				document.getElementById('message').innerHTML = '';
				document.getElementById('sp_history').innerHTML = '';
			}
   		 });
		
	});
});

function disableAllItem() {
	$('#<portlet:namespace/>cttlCongDanForm input').each(function() {
		   $(this).attr('disabled','disabled'); 
		   $(this).addClass('readonly');
		   if ($(this).attr('type') == 'button' || $(this).attr('type') == 'BUTTON' 
			   || $(this).attr('type') == 'submit' || $(this).attr('type') == 'SUBMIT') {
			   $(this).attr('style','display:none');  
		   } 
	});
	$('#<portlet:namespace/>cttlCongDanForm select').each(function() {
	  	   $(this).attr('disabled','disabled');  
	  	   $(this).addClass('readonly');
	});
	$('#<portlet:namespace/>cttlCongDanForm a').each(function() {
	  	   $(this).attr('style','display:none');  
	});
	$('#<portlet:namespace/>cttlCongDanForm textarea').each(function() {
		  $(this).attr('disabled','disabled');
		  $(this).addClass('readonly'); 
	});
	// Enable link back
	$("#linkBackToList").removeAttr('style');
	$("#buttonBackToList").removeAttr('style');
	$("#buttonBackToList").removeAttr('disabled');
	$("#buttonBackToList").removeClass('readonly');
}
</script>
<style>
	p.note
	{
	     color: #616E14;
	     border: solid 1px #BFD62F;
	     background-color: #DAE691;
	     -moz-border-radius: 6px;
	     -webkit-border-radius: 6px;
	     border-radius: 6px;
	     padding: 14px 20px;
	     mc-auto-number-format: '{b}Lưu ý: {/b}';
	}
</style>