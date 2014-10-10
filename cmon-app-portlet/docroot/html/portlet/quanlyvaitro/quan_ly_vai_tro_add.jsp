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
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.quanlyvaitro.business.QuanLyVaiTroBusiness"%>
<%@page import="org.oep.cmon.portlet.quanlyvaitro.action.QuanLyVaiTroPortlet"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
	QuanLyVaiTroPortlet portlet = new QuanLyVaiTroPortlet();

	PortletURL actionUrl = renderResponse.createActionURL();
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddVaiTroRequest");
	portlet.setSearchParameter(actionUrl, renderRequest);
	
	// Create back URL
	PortletURL backUrl = renderResponse.createRenderURL();
	backUrl.setParameter("jspPage",	"/html/portlet/quanlyvaitro/quan_ly_vai_tro_list.jsp");
	portlet.setSearchParameter(backUrl, renderRequest);

	String actionType		= ParamUtil.getString(request, "actionType", "");
	String vaiTroId			= ParamUtil.getString(request, "vaiTroId", "");	
	String ten				= ParamUtil.getString(request, "ten", "");
	String ma				= ParamUtil.getString(request, "ma", "");
	String ungDungId		= ParamUtil.getString(request, "ungDungId", "");
	String trangThai		= ParamUtil.getString(request, "trangThai", "");
	String mota 			= ParamUtil.getString(request, "mota", "");
	
	List<DanhMucUngDung> danhMucUngDungList = null;
	List<TaiNguyen> taiNguyenList = null;
	List<TaiNguyen> taiNguyenConfigList = null;
	try {
		
		danhMucUngDungList = QuanLyVaiTroBusiness.findByDanhMucUngDung();
		
		if (renderRequest.getAttribute("taiNguyenList") == null || renderRequest.getAttribute("taiNguyenConfigList") == null) {		
			List<List<TaiNguyen>> configList = QuanLyVaiTroBusiness.findAllTaiNguyenByVaiTro(vaiTroId);	
			
			if (configList != null && configList.size() > 1) {
				taiNguyenList			= (configList.get(0) != null)?configList.get(0): null;
				taiNguyenConfigList	    = (configList.get(1) != null)?configList.get(1): null;
			}
		} else {
			taiNguyenList 		= (List<TaiNguyen>)renderRequest.getAttribute("taiNguyenList");
			taiNguyenConfigList = (List<TaiNguyen>)renderRequest.getAttribute("taiNguyenConfigList");
		}

	} catch (Exception e) {
		SessionErrors.add(renderRequest, "errorAddOrUpdate");
	}
	
%>
<div class="egov-container">
<form id="<portlet:namespace/>vaiTroForm" name="<portlet:namespace/>vaiTroForm" method="post" action="<%=actionUrl.toString() %>">
<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionType%>"/>
<input type="hidden" name = "vaiTroId" id = "vaiTroId" value = "<%=vaiTroId%>"/>
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
		<td colspan="6" align="center">
			<label class="egov-label-header">
				<%=LanguageUtil.get(pageContext,"vn.dtt.cmon.quanlyvaitro.form.title"+ actionType, "Quản lý vai trò")%> </label>
		</td>
	</tr>
		    <tr>
		      <td colspan="6" align = "left">	
		      	<liferay-ui:error key="errorAddOrUpdate" message = "vn.dtt.cmon.quanlyvaitro.form.error.addOrUpdate"/>
		       	<select style="display: none;" id="egov-form-errors">
		      		<option value="ma"><liferay-ui:error 	key="existMa" message = "vn.dtt.cmon.quanlyvaitro.form.exist.ma"/></option>
					<option value="ma"><liferay-ui:error 	key="emptyMa" message = "vn.dtt.cmon.quanlyvaitro.form.empty.ma"/></option>
					<option value="ten"><liferay-ui:error 	key="emptyTen" message = "vn.dtt.cmon.quanlyvaitro.form.empty.ten"/></option>
				</select>
			 	<liferay-ui:error key="emptyCoQuanQuanly" message = "vn.dtt.cmon.quanlyvaitro.list.empty.coquanquanly"/>
				<liferay-ui:success key="successUpdateVaiTro" message="vn.dtt.cmon.quanlyvaitro.form.completed.update"/>				
				<liferay-ui:success key="successAddVaiTro" message="vn.dtt.cmon.quanlyvaitro.form.completed.add"/>
			  </td>	
		    </tr>
		    <tr>
		      <td colspan="3" >
		      		<label class="egov-label-bold"><liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.ten"/> </label><label class="egov-label-red">*</label><br>
		      		<input  name="ten" type="text" id="ten" maxlength="200" class = "egov-inputfield" 
		      		value = "<%=HtmlUtil.escape(ten)%>" style="width: 95%"/>
		      </td>
		      <td colspan="3">
		      		<label class="egov-label-bold"><liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.ma"/></label><label class="egov-label-red">*</label><br>
		      		<input name="ma" type="text" id="ma" maxlength="20" 
		      			class = "egov-inputfield" value = "<%=ma %>" style="width: 96%"/>
		      </td>
		     <tr>
		      <td colspan="3">
		      		<label class ="egov-label-bold"><liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.ungDung"/></label><label class="egov-label-red">*</label><br>
	      			<select id="ungDungId" name="ungDungId" class="egov-select" style="width: 98%">
	      				<% if (danhMucUngDungList != null && danhMucUngDungList.size() > 0) {
	      						for (DanhMucUngDung danhMucUngDung : danhMucUngDungList) { %>
	      							<option value="<%=danhMucUngDung.getId()%>"  <%= QuanLyVaiTroBusiness.checkSelectedValue(ungDungId, danhMucUngDung.getId()) %>>
	      								<%=HtmlUtil.escape(danhMucUngDung.getTen())%></option>
	      				<% 		}
	      					} %>
      				</select>
		     	 </td>
		    	<td colspan="3">
		    		<label class ="egov-label-bold"><liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.trangThai"/></label><label class="egov-label-red">*</label><br>
	      			<select id="trangThai" name="trangThai" class="egov-select" style="width: 99%">	      				
	      				<option value="<%=Constants.INACTIVE %>" <%= QuanLyVaiTroBusiness.checkSelectedValue(trangThai, Constants.VaiTro.TrangThai_HoatDong) %>>
	      					<liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.trangThai.1"/></option>
      					<option value="<%=Constants.ACTIVE %>" <%= QuanLyVaiTroBusiness.checkSelectedValue(trangThai, Constants.VaiTro.TrangThai_Khoa) %>>
	      					<liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.trangThai.0"/></option>
      				</select>		    	
		    	</td>
			</tr>	   
			<tr>
					<td colspan="6" valign="top">
						<table  cellpadding="0" cellspacing="0">										  
										<tr>
											<td width="43%">
											<label class="egov-label-bold">
												<liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.taiNguyenHeThong"/>
											</label>
											<select class="egov-multi-select" size="11" multiple="multiple" id="select-system-id">
												<% if (taiNguyenList != null && taiNguyenList.size() > 0) {
													for (int i = 0; i < taiNguyenList.size(); i++) {
														TaiNguyen taiNguyen = (TaiNguyen) taiNguyenList.get(i);
													%>
														<option value="<%= taiNguyen.getId() %>" title="<%= HtmlUtil.escape(taiNguyen.getMoTa()) %>">
															<%= HtmlUtil.escape(taiNguyen.getTen()) %>
														</option>
												<% }
												} %>
											</select>
											<!-- du lieu cache du lieu nguon -->
											<select id="select-data-system" style="display:none;">
												<% if (taiNguyenList != null && taiNguyenList.size() > 0) {
													for (int i = 0; i < taiNguyenList.size(); i++) {
														TaiNguyen taiNguyen = (TaiNguyen) taiNguyenList.get(i);
													%>
														<option value="<%= taiNguyen.getId() %>" title="<%= HtmlUtil.escape(taiNguyen.getMoTa()) %>">
															<%= HtmlUtil.escape(taiNguyen.getTen()) %>
														</option>
												<% }
												} %>
											</select>
											
											<input type="text" value=""
											onkeyup="searchOptions(this.value,'select-data-system','select-system-id','select-selected-id');" 
											class="egov-inputfield" style="width: 96.5%;">
											
											</td>
											<td width="4%" align="center" style="padding:10px; ">
												<br><br><br><br>
												<input type="button" class="egov-button-normal" value=">>" 
												onclick="moveOptions('select-system-id','select-selected-id');">
												<br><br>
												
												<input  type="button" class="egov-button-normal" value="<<" 
												onclick="moveOptions('select-selected-id','select-system-id');">
											</td>
											<td width="43%">
														
											<label class="egov-label-bold">
												<liferay-ui:message key="vn.dtt.cmon.quanlyvaitro.form.taiNguyenChon"/>
											</label>
											<select class="egov-multi-select" size="13" multiple="multiple" id="select-selected-id"
												name="taiNguyenDest" style="width: 99%">
												<% if (taiNguyenConfigList != null && taiNguyenConfigList.size() > 0) {
													for (int i = 0; i < taiNguyenConfigList.size(); i++) {
														TaiNguyen taiNguyen = (TaiNguyen) taiNguyenConfigList.get(i);
													%>
														<option value="<%= taiNguyen.getId() %>" title="<%= HtmlUtil.escape(taiNguyen.getMoTa()) %>">
															<%= HtmlUtil.escape(taiNguyen.getTen()) %>
														</option>
												<% }
												} %>
											</select>
														
											</td>
										</tr>
					</table>								
				</td>			
			</tr>
			<tr>
				<td colspan="6" valign="top">
				<label class="egov-label-bold"> Mô tả về loại tài nguyên này </label><br>
				<textarea name="mota" id="mota" class = "egov-textarea"	 rows="8" cols="43" maxlength="250"><%=HtmlUtil.escape(mota)%></textarea>
				 </td>
			</tr>
			<tr>
				<td colspan="6" align="left">
					<%
						if (!QuanLyVaiTroBusiness.VIEW_VAI_TRO.equals(actionType)) {
					%> 
						<span style="padding-right 15px;"><input type="button" class="egov-button-normal"
							name="submitButton" id="submitButton" value="Lưu lại" /></span> 
						<%
						}
						%> 
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
	$('#ma').alphanumeric();
	
	if (<%= QuanLyVaiTroBusiness.VIEW_VAI_TRO.equals(actionType) %>) {
		disableAllItem();
	}
		
	$("#ma").keyup(function() {
		var txtValue = $(this).val();
		txtValue = txtValue.toUpperCase();
		$(this).val(txtValue);
	});

	$('#submitButton').click(function() {
		$('#select-selected-id option').attr('selected', 'selected');
		document.<portlet:namespace/>vaiTroForm.submit();
	});
});

function disableAllItem() {
	$('#<portlet:namespace/>vaiTroForm input').each(function() {
		   $(this).attr('disabled','disabled'); 
		   $(this).addClass('readonly');
		   if ($(this).attr('type') == 'button' || $(this).attr('type') == 'BUTTON' 
			   || $(this).attr('type') == 'submit' || $(this).attr('type') == 'SUBMIT') {
			   $(this).attr('style','display:none');  
		   } 
	});
	$('#<portlet:namespace/>vaiTroForm select').each(function() {
	  	   $(this).attr('disabled','disabled');  
	  	   $(this).addClass('readonly');
	});
	$('#<portlet:namespace/>vaiTroForm a').each(function() {
	  	   $(this).attr('style','display:none');  
	});
	$('#<portlet:namespace/>vaiTroForm textarea').each(function() {
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