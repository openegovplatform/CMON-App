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
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
String type = "";
String searchInputText = ""; 
long parentId = 0l;
Map <String, String> userRequest = new HashMap<String,String>();
List<CoQuanQuanLy> listCoQuanQuanLy= new ArrayList<CoQuanQuanLy>();
List<CapCoQuanQuanLy> listCapCoQuanQuanLy= new ArrayList<CapCoQuanQuanLy>();
String id = "";
String ma = "";
String ten ="";
String diaChi ="";
String dienThoai ="";
String email ="";
String fax ="";
String website ="";
String noiBo ="";
long chaId =0l;
String merChant ="";
String accessCode ="";
String secureSecret ="";
String maCapSoBienNhan ="";
long capCoQuanQuanLyId =0l;
long idTinh = 0l;
long idHuyen = 0l;
long idXa = 0l;
//get request atts
if(Validator.isNotNull(request.getAttribute("type"))){
	type = request.getAttribute("type").toString();
}
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
if(Validator.isNotNull(request.getAttribute("parentId"))){
	parentId = Long.valueOf(request.getAttribute("parentId").toString());
}
if(Validator.isNotNull(request.getAttribute("CQQL_OBJECT"))){
	userRequest = (Map <String, String>)request.getAttribute("CQQL_OBJECT");
}
if(Validator.isNotNull(request.getAttribute("listCoQuanQuanLy"))){
	listCoQuanQuanLy = (List<CoQuanQuanLy>)request.getAttribute("listCoQuanQuanLy");
}
if(Validator.isNotNull(request.getAttribute("listCapCoQuanQuanLy"))){
	listCapCoQuanQuanLy = (List<CapCoQuanQuanLy>)request.getAttribute("listCapCoQuanQuanLy");
}
if(type.equals("add")){
	chaId = parentId;
}
if(Validator.isNotNull(userRequest.get("id"))){
	id = userRequest.get("id");
}
if(Validator.isNotNull(userRequest.get("chaId"))){
	chaId = Long.valueOf(userRequest.get("chaId"));
}
if(Validator.isNotNull(userRequest.get("capCoQuanQuanLyId"))){
	capCoQuanQuanLyId = Long.valueOf(userRequest.get("capCoQuanQuanLyId"));
}
if(Validator.isNotNull(userRequest.get("ma"))){
	ma = userRequest.get("ma");
}
if(Validator.isNotNull(userRequest.get("ten"))){
	ten = userRequest.get("ten");
}
if(Validator.isNotNull(userRequest.get("diaChi"))){
	diaChi = userRequest.get("diaChi");
}
if(Validator.isNotNull(userRequest.get("dienThoai"))){
	dienThoai = userRequest.get("dienThoai");
}
if(Validator.isNotNull(userRequest.get("email"))){
	email = userRequest.get("email");
}
if(Validator.isNotNull(userRequest.get("fax"))){
	fax = userRequest.get("fax");
}
if(Validator.isNotNull(userRequest.get("website"))){
	website = userRequest.get("website");
}
if(Validator.isNotNull(userRequest.get("noiBo"))){
	noiBo = userRequest.get("noiBo");
}
if(Validator.isNotNull(userRequest.get("merChant"))){
	merChant = userRequest.get("merChant");
}
if(Validator.isNotNull(userRequest.get("accessCode"))){
	accessCode = userRequest.get("accessCode");
}
if(Validator.isNotNull(userRequest.get("secureSecret"))){
	secureSecret = userRequest.get("secureSecret");
}
if(Validator.isNotNull(userRequest.get("maCapSoBienNhan"))){
	maCapSoBienNhan = userRequest.get("maCapSoBienNhan");
}
if(Validator.isNotNull(userRequest.get("idHuyen"))){
	idHuyen = Long.valueOf(userRequest.get("idHuyen"));
}
if(Validator.isNotNull(userRequest.get("idXa"))){
	idXa = Long.valueOf(userRequest.get("idXa"));
}
if(Validator.isNotNull(userRequest.get("idTinh"))){
	idTinh = Long.valueOf(userRequest.get("idTinh"));
}
//end get params
//save CQQL URL
PortletURL saveCQQLURL = renderResponse.createActionURL();
saveCQQLURL.setParameter(ActionRequest.ACTION_NAME, "saveCoQuanQuanLy");
saveCQQLURL.setParameter("parentId",parentId==0l?"":String.valueOf(parentId));
saveCQQLURL.setParameter("searchInputText", searchInputText);
//back to list CQQL URL
PortletURL backToCQQLURL = renderResponse.createRenderURL();
backToCQQLURL.setParameter("parentId", parentId==0l?"":String.valueOf(parentId));
backToCQQLURL.setParameter("searchInputText", searchInputText);

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
<div style="padding-top: 10px;padding-bottom: 10px;font-weight: bold;">
<%
PortletURL searchCQQLURL = renderResponse.createActionURL();
searchCQQLURL.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
if(chaId!=0l){
%>
	>> <a href="<%=searchCQQLURL.toString()%>">Cấp cao nhất</a>
<%
	List<CoQuanQuanLy> listParent = new ArrayList<CoQuanQuanLy>();
	CoQuanQuanLy cqql = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(chaId);
	listParent.add(cqql);
	long idP = 0l;
	while(cqql != null){
		if(cqql.getChaId() == null){
			idP = 0l;		
		}else{
			idP = cqql.getChaId();
		}
		cqql = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(idP);
		if(cqql!=null){
			listParent.add(cqql);
		}
	}
	for(int i = (listParent.size()-1);i>0;i--){
		//search sub CQQL URL
		PortletURL searchSubCQQLURL = renderResponse.createActionURL();
		searchSubCQQLURL.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
		searchSubCQQLURL.setParameter("parentId",String.valueOf(listParent.get(i).getId()));
%>
	>> <a href="<%=searchSubCQQLURL.toString()%>"><%=listParent.get(i).getTen() %></a>
<%
	}
%>
	>> <%=listParent.get(0).getTen() %>
<%
}else{
%>
>>Cấp cao nhất
<%} %>
</div>
<aui:form action="<%=saveCQQLURL.toString()%>" method="post" name="frmCreateCoQuanQuanLy" id="frmCreateCoQuanQuanLy">
	<input type="hidden" name="type" value="<%=type %>" />
	<input type="hidden" name="id" value="<%=id%>"/>
	<input type="hidden" name="chaId" value="<%=chaId %>" />
	<table class="egov-table" width="100%" border="0">
		<thead>
			<tr>
				<td colspan="6">
					<%
					if(type.equals("add")){
					%>
					<h3>Thêm cơ quan quản lý</h3>
					<%}else{ %>
					<h3>Cập nhật cơ quan quản lý</h3>
					<%} %>
				</td>
			</tr>
		</thead>
		<tbody>
			<%-- <tr>
				<td colspan="6">
					<aui:select name="chaId" label="abc" inputCssClass="egov-inputfield">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						for(int i=0;i<listCoQuanQuanLy.size();i++){
							boolean selected = false;
							CoQuanQuanLy coQuan = listCoQuanQuanLy.get(i);
							if(coQuan.getId()==chaId){
								selected = true;
							}
						%>
						<aui:option value="<%=coQuan.getId() %>" selected="<%=selected %>" ><%=coQuan.getTen() %></aui:option>
						<%} %>
					</aui:select>
				</td>
			</tr> --%>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='<portlet:namespace/>ten'><liferay-ui:error key="error_name_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.ten"/></option>
			      		<option value='<portlet:namespace/>ma'><liferay-ui:error key="error_code_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.ma"/></option>
			      		<option value='<portlet:namespace/>ma'><liferay-ui:error key="error_ma_duplicate" message = "org.oep.cmon.admin.portlet.cqql.err.duplicate.ma"/></option>
			      		<option value='<portlet:namespace/>idTinh'><liferay-ui:error key="error_idTinh_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.tinh"/></option>
			      		<option value='<portlet:namespace/>diaChi'><liferay-ui:error key="error_address_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.diachi"/></option>
			      		<option value='<portlet:namespace/>dienThoai'><liferay-ui:error key="error_phone_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.phone"/></option>
			      		<option value='<portlet:namespace/>capCoQuanQuanLyId'><liferay-ui:error key="error_ccq_required" message = "org.oep.cmon.admin.portlet.cqql.err.empty.capcqql"/></option>
			      		<option value='<portlet:namespace/>email'><liferay-ui:error key="error_email_invalid" message = "org.oep.cmon.admin.portlet.congchuc.err.invalid.email"/></option>
			      		
			      		<option value='<portlet:namespace/>ma'><liferay-ui:error key="error_ma_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.ma"/></option>
			      		<option value='<portlet:namespace/>ten'><liferay-ui:error key="error_name_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.ten"/></option>
			      		<option value='<portlet:namespace/>diaChi'><liferay-ui:error key="error_diachi_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.diachi"/></option>
			      		<option value='<portlet:namespace/>dienThoai'><liferay-ui:error key="error_phone_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.phone"/></option>
			      		<option value='<portlet:namespace/>fax'><liferay-ui:error key="error_fax_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.fax"/></option>
			      		<option value='<portlet:namespace/>email'><liferay-ui:error key="error_email_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.email"/></option>
			      		<option value='<portlet:namespace/>website'><liferay-ui:error key="error_website_toolong" message = "org.oep.cmon.admin.portlet.cqql.err.toolong.website"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<aui:input name="ten" value="<%=ten %>" label="Tên cơ quan quản lý <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập tên cơ quan quản lý"></aui:validator>
					</aui:input>
				</td>
				<td colspan="2" style="width: 30% !important">
					<aui:input name="ma" value="<%=ma %>" label="Mã cơ quan quản lý <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập mã cơ quan quản lý"></aui:validator>
					</aui:input>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<b>Địa chỉ</b>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="width: 30% !important">
					<aui:select name="idTinh" label="Tỉnh/Thành phố <label class='egov-label-red'>(*)</label>" inputCssClass="egov-inputfield egov-select" onChange="reDrawSelectBox('idTinh','idHuyen')">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						List<DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
						for(int i=0;i<tinhThanhList.size();i++){
							boolean selected = false;
							DonViHanhChinh tinhThanh = tinhThanhList.get(i);
							if(tinhThanh.getId() == idTinh){
								selected = true;
							}
						%>
						<aui:option value="<%=tinhThanh.getId() %>" selected="<%=selected %>" ><%=tinhThanh.getTen() %></aui:option>
						<%} %>
					</aui:select>
				</td>
				<td colspan="2" style="width: 30% !important">
					<aui:select name="idHuyen" label="Quận/Huyện" inputCssClass="egov-inputfield egov-select" onChange="reDrawSelectBox('idHuyen','idXa')">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						if(idTinh>0){
							List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(idTinh, 0);
							for(int i = 0;i<quanHuyenList.size();i++){
								boolean selected = false;
								DonViHanhChinh quanHuyen = quanHuyenList.get(i);
								if(quanHuyen.getId() == idHuyen){
									selected = true;
								}
						%>
						<aui:option value="<%=quanHuyen.getId() %>" selected="<%=selected %>" ><%=quanHuyen.getTen() %></aui:option>
						<%
						}}
						%>
					</aui:select>
				</td>
				<td colspan="2" style="width: 30% !important">
					<aui:select name="idXa" label="Phường/Xã" inputCssClass="egov-inputfield egov-select">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						if(idHuyen>0){
							List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyen, 0);
							for(int i = 0;i<phuongXaList.size();i++){
								boolean selected = false;
								DonViHanhChinh phuongXa = phuongXaList.get(i);
								if(phuongXa.getId() == idXa){
									selected = true;
								}
						%>
						<aui:option value="<%=phuongXa.getId() %>" selected="<%=selected %>" ><%=phuongXa.getTen() %></aui:option>
						<%}} %>
					</aui:select>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<aui:input name="diaChi" value="<%=diaChi %>" label="Mô tả địa chỉ <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập mô tả địa chỉ"></aui:validator>
					</aui:input>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<aui:input name="dienThoai" value="<%=dienThoai %>" label="Điện thoại <label class='egov-label-red'>(*)</label>" type="text" inputCssClass="egov-inputfield">
						<aui:validator name="required" errorMessage="Hãy nhập số điện thoại"></aui:validator>
						<aui:validator name="number" errorMessage="Hãy nhập số"></aui:validator>
					</aui:input>
				</td>
				<td colspan="3">
					<aui:input name="fax" value="<%= fax%>" label="Fax" type="text" inputCssClass="egov-inputfield"></aui:input>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<aui:input name="email" value="<%= email%>" label="Email" type="text" inputCssClass="egov-inputfield"></aui:input>
				</td>
				<td colspan="3">
					<aui:input name="website" value="<%= website%>" label="Website" type="text" inputCssClass="egov-inputfield"></aui:input>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<aui:select name="capCoQuanQuanLyId" label="Cấp cơ quan quản lý <label class='egov-label-red'>(*)</label>" inputCssClass="egov-inputfield egov-select">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						for(int i=0;i<listCapCoQuanQuanLy.size();i++){
							boolean selected = false;
							CapCoQuanQuanLy capCoQuan = listCapCoQuanQuanLy.get(i);
							if(capCoQuan.getId() == capCoQuanQuanLyId){
								selected = true;
							}
						%>
						<aui:option value="<%=capCoQuan.getId() %>" selected="<%=selected %>" ><%=capCoQuan.getTen() %></aui:option>
						<%} %>
					</aui:select>
				</td>
				<td colspan="3">
					<span><b>Nội bộ</b></span>
					<%
						String checked = "";
						if(noiBo.equals("1")){
							checked = "checked";
						}
					%>
					<input name="noiBo" type="checkbox" <%=checked %> value="1" class="egov-checkbox"></input>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" style="text-align: left;">
					<aui:button-row>
						<%if(type.equals("add")){ %>
						<aui:button type="submit" value="Thêm cơ quan quản lý" />
						<%}else{ %>
						<aui:button type="submit" value="Cập nhật" />
						<%} %>
						<a href="<%=backToCQQLURL%>"><aui:button
								type="cancel" value="Quay lại danh sách" /></a>
					</aui:button-row>
				</td>
			</tr>
		</tfoot>
	</table><br/>
</aui:form>
</div>
</html>
<aui:script>
AUI().ready('aui-form-validator', 'aui-overlay-context-panel', function(A) {
    var validator = new A.FormValidator({
        boundingBox: document.<portlet:namespace/>frmCreateCoQuanQuanLy,
        rules: {
            <portlet:namespace/>idTinh: {
                required: true
            },
            <portlet:namespace/>capCoQuanQuanLyId: {
                required: true
            }
        },

        //custom message
        fieldStrings: {
            <portlet:namespace/>idTinh: {
                required: 'Hãy chọn Tỉnh/ Thành phố'
            },
            <portlet:namespace/>capCoQuanQuanLyId: {
                required: 'Hãy chọn cấp cơ quan quản lý'
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
<portlet:actionURL var="getDonViHanhChinhByIdURL" name="getDonViHanhChinhById">
	<portlet:param name="jspPage" value="/html/portlet/admin/congchuc/coquanquanly/add.jsp"/>
</portlet:actionURL>
<script type="text/javascript">
	var url = '<%= getDonViHanhChinhByIdURL.toString() %>';

	//Ve lai danh sach don vi hanh chinh
	function reDrawSelectBox(selectName, changeName) {
		var id = $('#<%=renderResponse.getNamespace()%>'+selectName).val();
		var obj = $('#<%=renderResponse.getNamespace()%>'+changeName);	
		var xhtml='<option value=""> --Hãy chọn-- </option>';
		if (id == ""){
			obj.html(xhtml);
			return;
		}
		$.ajax({
			type: 'POST'
			,url: url
			,data : {id: id}
			,success: function(data) {	
				data = JSON.parse(data);
				for (var i = 0; i < data.id.length; i++) {
				  	console.log(data.id[i]);
				 	xhtml +='<option value="'+data.id[i]+'">'+data.name[i]+'</option>';
				};
				obj.html(xhtml);  
			}
		});
	}
</script>