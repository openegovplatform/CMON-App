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
<%@page import="java.util.LinkedList"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucImpl"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.SoDanhMuc"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<script src="<%=request.getContextPath()%>/js/egovUI.js"	type="text/javascript"></script>	
<%
renderResponse.setTitle("Chứng thực");
SoDanhMuc soDanhMuc = null;
long idHoSo = ParamUtil.getLong(request, "idHoSo");
if (idHoSo > 0) {
	soDanhMuc = SoDanhMucLocalServiceUtil.getSoDanhMuc(idHoSo);
}

if (soDanhMuc == null) {
	soDanhMuc = (SoDanhMuc) request.getAttribute(Constants.ChungThuc.SO_DANH_MUC_NAME);
}

if (soDanhMuc == null) {
	soDanhMuc = new SoDanhMucImpl();
	soDanhMuc.setTenSo("");
	soDanhMuc.setTheoQuyetDinh("");
	soDanhMuc.setSoSo("");
	soDanhMuc.setNam((long)new Date().getYear());
	// TODO: 
}


long uid = PortalUtil.getUserId(request);
CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);
  	
// get thu tuc hanh chinh by can bo
List<NhomThuTucHanhChinh> listNhomTTHC =  NhomThuTucHanhChinhLocalServiceUtil.
			getDSNhomThuTucHanhChinhByCanBo(congChuc.getId()); 

// TEST
/* List<NhomThuTucHanhChinh> listNhomTTHC =  new LinkedList<NhomThuTucHanhChinh>();
NhomThuTucHanhChinh nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(19);
listNhomTTHC.add(nhomTTHC);
nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(20);
listNhomTTHC.add(nhomTTHC); */
// END TEST

//List<ThuTucHanhChinh> thuTucHanhChinhs = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCanBo(congChuc.getId());
// get id danh muc ung dung chung thuc
String maUngDung = ThamSoLocalServiceUtil.getValue("CTMS");
long idUngDung = DanhMucUngDungLocalServiceUtil.getIdDanhmucUngdung(maUngDung);

List<ThuTucHanhChinh> listTTHC = new LinkedList<ThuTucHanhChinh>();

//filter the tthc by ung dung chung thuc
if (listNhomTTHC != null && !listNhomTTHC.isEmpty()) {
	for (NhomThuTucHanhChinh ntthc: listNhomTTHC) {
		if (ntthc.getDanhMucUngDungId() == idUngDung) {
			List<ThuTucHanhChinh> listTthc = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, ntthc.getId(), 0, 1000);
			
			listTTHC.addAll(listTthc);
		}
	}
} 


/* String nhomTTHCChungThucId = ThamSoLocalServiceUtil.getValue("CT_NHOMTTHCID");
NhomThuTucHanhChinh ntthc =  NhomThuTucHanhChinhLocalServiceUtil.findTheoMa(nhomTTHCChungThucId);
 */
//List<ThuTucHanhChinh> listTTHC = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, (long)21, 0, 100);

String urlquaylai = ParamUtil.getString(request, "parentUrl");
 
%>
<style type="text/css">
	table tr td {
		padding: 3px !important;
}
</style>

<portlet:actionURL var="saveSoDanhMuc" name="saveSoDanhMuc">
	<portlet:param name="targetPage" value="/html/portlet/hosochungthuc/formSoChungThuc.jsp"></portlet:param> 
</portlet:actionURL>


<portlet:renderURL var="backUrl">
	<portlet:param name="jspPage"
		value="/html/portlet/hosochungthuc/soChungThuc.jsp" />
</portlet:renderURL>

<select style="display: none;" id="egov-form-errors">
						<option value="thuTucHanhChinhId">
						<liferay-ui:error key="thuTucHanhChinhId" >Chưa chọn loại hồ sơ</liferay-ui:error>
						</option>
						<option value="tenSo">
						<liferay-ui:error key="tenSo" >Chưa nhập tên sổ</liferay-ui:error>
						</option>
						<option value="soChungThuc">
						<liferay-ui:error key="soChungThuc" >Chưa nhập số chứng thực</liferay-ui:error>
						</option>
						<option value="nam">
						<liferay-ui:error key="nam" >Chưa chọn năm</liferay-ui:error>
						</option>
						<option value="theoQuyetDinh">
						<liferay-ui:error key="theoQuyetDinh" >Chưa nhập quyết định</liferay-ui:error>
						</option>
</select>

<div class="_outer egov-container">
	<%
		if (request.getAttribute("savemessage") != null) {
	%>
	<div class="portlet-msg-success" style="padding-left: 20px;">Đã lưu sổ chứng thực</div>
	<%
		}
	%>
	
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
		<form
			id="main_form"
			method="post"
			action="<%= saveSoDanhMuc %>" 
		>
			<input  type="hidden" name="idHoSo" value="<%= idHoSo%>"/>
			<h1 class="center clear septop20 sepbot20" style="padding: 15px 0">
				<label id="main_title" class="egov-label font20-bu">
					Thêm mới sổ chứng thực
				</label>
			</h1>
			
			<table style="background: none repeat scroll 0% 0% transparent; width: 90%">
				<tr>
						<td width="20%"><label class="egov-label-bold right">Loại sổ chứng thực <label class="egov-label-red">*</label> </label>
						
						</td>
						<td style="width: 40%;">
						<select class="egov-select" id="thuTucHanhChinhId" name="thuTucHanhChinhId" >
							<!-- <option value="0">- Chọn loại hồ sơ - </option> -->
							<% 
								for (ThuTucHanhChinh tthc: listTTHC) {
							%>
									<option value="<%= tthc.getId()%>" 
									<%	if (soDanhMuc.getThuTucHanhChinhId() != null && soDanhMuc.getThuTucHanhChinhId() == tthc.getId())  { %>
									selected
									<% } %>><%= tthc.getTen() %>
									</option> 
							<%
								}
							%>
						</select>
					</td>
				</tr>
				
<%-- 				<tr>
					<td><label class="egov-label-bold right">Tên sổ chứng thực</label>  </td>
						<td style="width: 60%;"><input type="text" class="egov-inputfield" value="<%= soDanhMuc.getTenSo() %>" name="tenSo" id="tenSo"/>
					</td>
				</tr> --%>
				
				<tr>
					<td><label class="egov-label-bold right">Số sổ chứng thực<label class="egov-label-red">*</label> </label> </td>
						<td><input type="text" class="egov-inputfield"  value="<%= soDanhMuc.getSoSo()%>" name="soChungThuc"  id="soChungThuc" />
					</td>
				</tr>

				<tr>
					<td><label class="egov-label-bold right">Năm <label class="egov-label-red">*</label> </label> </td>
						<td style="width: 60%;">
							<select
								name="nam" 
								id="nam" 
								class="egov-select egov-yearpicker"
								defyear="<%=soDanhMuc.getNam()%>"
								range="-80|+0"
								reverse="true"
							></select>
					</td>
				</tr>
				<tr>
					<td><label class="egov-label-bold right">Theo quyết định</label>  </td>
						<td style="width: 60%;"><input type="text" class="egov-inputfield" value="<%= soDanhMuc.getTheoQuyetDinh() %>" name="theoQuyetDinh" id="theoQuyetDinh"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
							<div class="button-bar left">
								<input type="submit" class="egov-button" value="Lưu thông tin" style="margin-left: 0px;" />
								<input type="button" onclick="location.href='<%= backUrl %>'" class="egov-button" value="Quay lại"/>
							</div>
					</td>
				</tr>
			</table>
			

		</form>
	</div>
</div>

<script>
$(document).ready(function(){
	// hidden save message
  	$('.portlet-msg-success').fadeOut("slow");
	
	//setTenSo();
	
/* 	$('#thuTucHanhChinhId').bind('change', function() {
		this.title = $(this).find('option:selected').text();
		
		$('#tenSo').val(this.title);
	}); */

});

/* function setTenSo() {
	$('#tenSo').val("");
	tenso = $('#thuTucHanhChinhId').text().trim();
	$('#tenSo').val(tenso);
} */


</script>