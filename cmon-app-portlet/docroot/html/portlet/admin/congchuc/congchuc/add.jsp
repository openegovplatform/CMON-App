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
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChucClp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.cc.model.impl.CongChucImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
//define variables
long coQuanQuanLyId = 0l;
String maOrTenOrEmail = "";
String emailForm = "";
CongChuc congChuc = new CongChucClp();
TaiKhoanNguoiDung taiKhoan = new TaiKhoanNguoiDungClp();
CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyClp();
List<ChucVu> listChucVu = new ArrayList<ChucVu>();
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//get request atts
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = Long.valueOf(request.getAttribute("coQuanQuanLyId").toString());
}
if(Validator.isNotNull(request.getAttribute("maOrTenOrEmail"))){
	maOrTenOrEmail = request.getAttribute("maOrTenOrEmail").toString();
}
if(Validator.isNotNull(request.getAttribute("emailForm"))){
	emailForm = request.getAttribute("emailForm").toString();
}
if(Validator.isNotNull(request.getAttribute("congChuc"))){
	congChuc = (CongChuc) request.getAttribute("congChuc");
	listChucVu = (List<ChucVu>) ChucVuLocalServiceUtil.findByCoQuanQuanLy(congChuc.getCoQuanQuanLyId(), 0);
}else{
	listChucVu = (List<ChucVu>) ChucVuLocalServiceUtil.findByCoQuanQuanLy(coQuanQuanLyId, 0);
}
if(Validator.isNotNull(request.getAttribute("taiKhoan"))){
	taiKhoan = (TaiKhoanNguoiDung) request.getAttribute("taiKhoan");
}
if(Validator.isNotNull(request.getAttribute("coQuanQuanLy"))){
	coQuanQuanLy = (CoQuanQuanLy) request.getAttribute("coQuanQuanLy");
}
List<GioiTinh> listGioiTinh = GioiTinhLocalServiceUtil.getDSGioiTinh();
//url 
PortletURL saveURL = renderResponse.createActionURL();
saveURL.setParameter(ActionRequest.ACTION_NAME, "saveCongChuc");
saveURL.setParameter("maOrTenOrEmail",maOrTenOrEmail);
saveURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
saveURL.setParameter("tab","CC");

PortletURL urlPopup = renderResponse.createActionURL();
urlPopup.setParameter(ActionRequest.ACTION_NAME, "popupCoQuanQuanLy");
urlPopup.setWindowState(LiferayWindowState.POP_UP);
urlPopup.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));

PortletURL urlGetDataChucVu = renderResponse.createActionURL();
urlGetDataChucVu.setParameter(ActionRequest.ACTION_NAME, "getDataChucVu");
int isNew = (congChuc.getId() == 0)?1:0;
%>
<html>
<style>
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	border:none !important;
	padding: 0px 10px !important;	
}
.egov-inputfield{
	width: 100%;
	min-height: 20px !important ;
	padding: 5px 10px !important;
}
.aui-form-validator-error-container .aui-field-element{
	display: block !important;
}
.aui-label-required{
	display: none !important;
}
</style>	
<div class="egov-container">
<div>
	<liferay-ui:error key="not.login.error" message="vn.dtt.cmon.admin.portlet.congchuc.err.not.login"/>
</div>
<aui:form name="frmCreateCanBo" id="frmCreateCanBo" method="post" action="<%= saveURL %>">
	<input type="hidden" name="id" value="<%=congChuc.getId()%>">
	<table class="egov-table" width="100%" border="0">
		<thead>
			<tr>
				<td colspan="6">
					<%
					if(isNew == 1){
						%>
						<h3>Thêm mới Công chức</h3>
						<%
					}else{
						%>
						<h3>Hiệu chỉnh Công chức</h3>
						<%
					}
					%>
				</td>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='<portlet:namespace/>hoVaTen'><liferay-ui:error key="empty.hoVaTen" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.hovaten"/></option>
			      		<option value='<portlet:namespace/>ma'><liferay-ui:error key="empty.ma" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.ma"/></option>
			      		<option value='<portlet:namespace/>email'><liferay-ui:error key="empty.email" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.email"/></option>
			      		<option value='<portlet:namespace/>password'><liferay-ui:error key="empty.password" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.password"/></option>
			      		<option value='<portlet:namespace/>rePassword'><liferay-ui:error key="empty.rePassword" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.repassword"/></option>
			      		<option value='<portlet:namespace/>rePassword'><liferay-ui:error key="missmatch.password" message="vn.dtt.cmon.admin.portlet.congchuc.err.missmatch.password"/></option>
			      		<option value='<portlet:namespace/>ngaySinh'><liferay-ui:error key="empty.ngaySinh" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.ngaysinh"/></option>
			      		<option value='<portlet:namespace/>gioiTinh'><liferay-ui:error key="empty.gioiTinh" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.gioitinh"/></option>
			      		<option value='<portlet:namespace/>cqqlTen'><liferay-ui:error key="empty.cqqlId" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.cqql"/></option>
			      		<option value='<portlet:namespace/>chucVuId'><liferay-ui:error key="empty.chucVuId" message="vn.dtt.cmon.admin.portlet.congchuc.err.empty.chucvu"/></option>
			      		<option value='<portlet:namespace/>email'><liferay-ui:error key="invalid.email" message="vn.dtt.cmon.admin.portlet.congchuc.err.invalid.email"/></option>
			      		<option value='<portlet:namespace/>ma'><liferay-ui:error key="duplicate.ma" message="vn.dtt.cmon.admin.portlet.congchuc.err.duplicate.ma"/></option>
			      		<option value='<portlet:namespace/>email'><liferay-ui:error key="duplicate.email" message="vn.dtt.cmon.admin.portlet.congchuc.err.duplicate.email"/></option>
			      		
			      		
			      		<option value='<portlet:namespace/>hoVaTen'><liferay-ui:error key="toolong.hoVaTen" message="vn.dtt.cmon.admin.portlet.congchuc.err.toolong.hovaten"/></option>
			      		<option value='<portlet:namespace/>ma'><liferay-ui:error key="toolong.ma" message="vn.dtt.cmon.admin.portlet.congchuc.err.toolong.ma"/></option>
			      		<option value='<portlet:namespace/>email'><liferay-ui:error key="toolong.email" message="vn.dtt.cmon.admin.portlet.congchuc.err.toolong.email"/></option>
			      		<option value='<portlet:namespace/>soCmnd'><liferay-ui:error key="toolong.soCmnd" message="vn.dtt.cmon.admin.portlet.congchuc.err.toolong.socmnd"/></option>
			      		<option value='<portlet:namespace/>noiCapCmnd'><liferay-ui:error key="toolong.noiCapCmnd" message="vn.dtt.cmon.admin.portlet.congchuc.err.toolong.noicapcmnd"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<aui:input name="hoVaTen" value="<%= congChuc.getHoVaTen() %>" label="Họ và tên <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập họ và tên cán bộ"></aui:validator>
					</aui:input>
				</td>
				<td colspan="2" style="width: 30% !important">
					<aui:input name="ma" value="<%= congChuc.getMa() %>" label="Mã công chức <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập mã công chức"></aui:validator>
					</aui:input>
				</td>				
			</tr>
			<tr>
				<td colspan="4">
					<aui:input name="email" value='<%=emailForm.equals("")?taiKhoan.getEmail():emailForm %>' label="Email <label class='egov-label-red'>(*)</label><label class='egov-label-note'> Tài khoản đăng nhập</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập Email"></aui:validator>
						<aui:validator name="email" errorMessage="Định dạng email không đúng"/>
					</aui:input>
				</td>
				<td colspan="2"></td>						
			</tr>
		<%
		if(isNew == 1){
		%>
			<tr>
				<td colspan="3">
					<aui:input name="password" value="" label="Mật khẩu <label class='egov-label-red'>(*)</label>" type="password" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập mật khẩu"></aui:validator>
					</aui:input>
				</td>
				<td colspan="3">
					<aui:input name="rePassword" value="" label="Nhập lại mật khẩu <label class='egov-label-red'>(*)</label>" type="password" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập lại mật khẩu"></aui:validator>
						<aui:validator name="equalTo" errorMessage="Mật khẩu không khớp">'#<portlet:namespace />password'</aui:validator>
					</aui:input>
				</td>				
			</tr>
		<%
		}
		%>
			<tr>
				<td colspan="3">
					<aui:input name="ngaySinh" value='<%=congChuc.getNgaySinh()!=null?df.format(congChuc.getNgaySinh()):""%>' label="Ngày sinh <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-calendar">
						<aui:validator name="required" errorMessage="Hãy nhập ngày sinh"></aui:validator>
					</aui:input>
				</td>
				<td colspan="3">
					<aui:select name="gioiTinh" label="Giới tính <label class='egov-label-red'>(*)</label>" inputCssClass="egov-inputfield">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						for(int i=0;i<listGioiTinh.size();i++){
							GioiTinh gioiTinh = listGioiTinh.get(i);
							boolean selected = (gioiTinh.getId() == congChuc.getGioiTinhId())?true:false;
						%>
							<aui:option value="<%= gioiTinh.getId() %>" selected="<%=selected %>" ><%= gioiTinh.getTen() %></aui:option>
						<%
						}
						%>
					</aui:select>
				</td>				
			</tr>	
			<tr>
				<td colspan="2" style="width: 30% !important">
					<aui:input name="soCmnd" value="<%= congChuc.getSoCmnd() %>" label="Số CMND" type="text" inputCssClass="egov-inputfield">
					</aui:input>
				</td>
				<td colspan="2" style="width: 30% !important">
					<aui:input name="ngayCapCmnd" value='<%=congChuc.getNgayCapCmnd()!=null?df.format(congChuc.getNgayCapCmnd()):""%>' label="Ngày cấp CMND" type="text" inputCssClass="egov-calendar">
					</aui:input>
				</td>
				<td colspan="2" style="width: 30% !important">
					<aui:input name="noiCapCmnd" value="<%= congChuc.getNoiCapCmnd() %>" label="Nơi cấp CMND" type="text" inputCssClass="egov-inputfield">
					</aui:input>
				</td>				
			</tr>
			<tr>
				<td colspan="4" style="vertical-align: bottom !important;">
					<div style="width: 80% !important;float: left;display: inline-block;">
						<aui:input readonly="true" name="cqqlTen" value="<%=coQuanQuanLy.getTen() %>" label="Cơ quan quản lý <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
							<aui:validator name="required" errorMessage="Hãy Chọn cơ quan quản lý"></aui:validator>
						</aui:input>
					</div>
					<aui:input name="cqqlId" type="hidden" label="" value="<%= coQuanQuanLy.getId() %>">
						<aui:validator name="required" errorMessage="Hãy Chọn cơ quan quản lý"></aui:validator>
					</aui:input>
					<input style="margin-top: 31px;margin-left: 5px" type="button" value="Tìm kiếm" class="egov-button-search" onclick="app.editcongchuc.popupCoQuanQuanLy('<%= urlPopup %>'); return false;"/>
				</td>
				<td colspan="2">
					<aui:select name="chucVuId" label="Chức vụ <label class='egov-label-red'>(*)</label>" inputCssClass="egov-inputfield">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						for(int i=0;i<listChucVu.size();i++){
							ChucVu chucVu = listChucVu.get(i);
							boolean selected = (chucVu.getId() == congChuc.getChucVuId())?true:false;
						%>
							<aui:option value="<%= chucVu.getId() %>" selected="<%=selected %>"><%= chucVu.getTen() %></aui:option>
						<%
							}
						%>
					</aui:select>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" style="text-align: left;">
					<aui:button-row>
						<%
						if(isNew == 1){
						%>
						<aui:button type="submit" value="Thêm cán bộ" />
						<%
						}else{
						%>
						<aui:button type="submit" value="Cập nhật" />
						<%
						}
						%>
						<%
						PortletURL listCongChucURL = renderResponse.createRenderURL();
						listCongChucURL.setParameter("tab", "CC");
						listCongChucURL.setParameter("maOrTenOrEmail",maOrTenOrEmail);
						listCongChucURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
						%>
						<a href="<%=listCongChucURL%>"><aui:button
								type="cancel" value="Quay lại danh sách" /></a>
					</aui:button-row>
				</td>
			</tr>
		</tfoot>
	</table>
</aui:form>
</div>
</html>
<aui:script>
AUI().ready('aui-form-validator', 'aui-overlay-context-panel', function(A) {
    var validator = new A.FormValidator({
        boundingBox: document.<portlet:namespace/>frmCreateCanBo,
        rules: {
            <portlet:namespace/>gioiTinh: {
                required: true
            },
            <portlet:namespace/>chucVuId: {
                required: true
            }
        },

        //custom message
        fieldStrings: {
            <portlet:namespace/>gioiTinh: {
                required: 'Hãy chọn giới tính'
            },
            <portlet:namespace/>chucVuId: {
                required: 'Hãy chọn chức vụ'
            }
        },

        on: {
            submitError: function(event) {
                var formEvent = event.validator.formEvent;
                var errors = event.validator.errors;
            },

            submit: function(event) {
                var formEvent = event.validator.formEvent;
            }
        }
    });
});
</aui:script>
<script type="text/javascript">
$('#<portlet:namespace/>ngaySinh').bind("change paste keyup", function() {
	$('#<portlet:namespace/>ngaySinh').focus();	
});

var app = app || {};
//var app = {};
app.editcongchuc = {
		config:null,
		newWindow:null,
		portletNamespace:null,
		init:function(portletNamespace,config){
			this.config = config;
			this.portletNamespace = portletNamespace;
			//console.log(this.portletNamespace);
			return this;
		},
		backUrl:function(url){
			window.location.href=url;
		},
		test:function(){
			console.log(this.portletNamespace);
		},
		popupCoQuanQuanLy:function(url){
			//jQuery("#dialogDiv").dialog({modal: true, title: 'Confirmation',show: 'slide', hide: 'slide', width : '370px', height : 'auto', resizable: true, closeOnEscape:true, focus:true});
			
			this.newWindow = window.open(url,'Search popup','height=550,width=800,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');

			if (window.focus) {
				this.newWindow.focus();
			}			
			return this;
		},
		choiceCoQuanQuanLy:function(choicedItem){
			if(typeof choicedItem.value == 'undefined'){
				//console.log('OK');
				return false;
			}
			$('input[name="<portlet:namespace/>cqqlTen"]').val(choicedItem.text);
			$('input[name="<portlet:namespace/>cqqlId"]').val(choicedItem.value);
			this.buildCboChucVu(choicedItem.value);
			$('input[name="<portlet:namespace/>cqqlTen"]').focus();
			//console.log(choicedItem.text);
			this.newWindow.close();
			//console.log('choiceCoQuanQuanLy',choicedItem);
		},
		buildCboChucVu:function(coQuanQuanLyId){
			var el = $('select[name="<portlet:namespace/>chucVuId"]');
			var chucVuId = el.val();
			var url='<%= urlGetDataChucVu %>';
			$.get(url,{coQuanQuanLyId:coQuanQuanLyId},function(data){
				var xhtml='<option value=""> - </option>';
				$.each(JSON.parse(data),function(i,val){
					//console.log(val);
					var selected = ((val.id == chucVuId)?' selected="selected"':'');				
					xhtml +='<option value="'+val.id+'" '+selected+'>'+val.name+'</option>';
				});
				el.html(xhtml);				
			});	
			//return false;
		}
};
//jQuery(document).ready(function($){
	app.editcongchuc.init('<portlet:namespace/>',null);
//});
</script>