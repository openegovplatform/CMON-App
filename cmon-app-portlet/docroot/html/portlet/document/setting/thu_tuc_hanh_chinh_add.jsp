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
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="org.oep.cmon.dao.dvc.service.TTHC2DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.portlet.document.util.ListUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
PortletURL actionUrl 			= renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddTTHCRequest");

String actionTyPe				= ParamUtil.getString(request, "ActionType");
String tthcId					= ParamUtil.getString(request, "tthcId");

long ungDungId					= ParamUtil.getLong(request, "ungDungId");
long nhomTTHCId					= ParamUtil.getLong(request, "nhomTTHCId");
long capCQQLId 					= ParamUtil.getLong(request, "capCoQuanQuanLyId");

String giaTriDoiTuongId			= ParamUtil.getString(request, "doituongId","");

//Content editor by duongpt
String trinhTuThucHien 			= ParamUtil.getString(request, "trinhTuThucHien","");
String thanhPhanHoSo 			= ParamUtil.getString(request, "thanhPhanHoSo", "");
String linhVucThucHien 			= ParamUtil.getString(request, "linhVucThucHien", "");
String yeuCauDieuKienThucHien 	= ParamUtil.getString(request, "yeuCauDieuKienThucHien","");
String canCuPhapLy 				= ParamUtil.getString(request, "canCuPhapLy","");

if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (tthcId)) {
	tthcId = "";
}

List<DoiTuongSuDung> doiTuongList = null;
List<DoiTuongSuDung> doiTuongConfigList = null;
try {
	
	if (renderRequest.getAttribute("doiTuongList") == null || renderRequest.getAttribute("doiTuongConfigList") == null) {		
		List<List<DoiTuongSuDung>> configList = ThuTucHanhChinhBusiness.findAllDoiTuongnByTTHC(tthcId);	
		
		if (configList != null && configList.size() > 1) {
			doiTuongList			= (configList.get(0) != null)?configList.get(0): null;
			doiTuongConfigList	    = (configList.get(1) != null)?configList.get(1): null;
		}
	} else {
		doiTuongList 		= (List<DoiTuongSuDung>)renderRequest.getAttribute("doiTuongList");
		doiTuongConfigList = (List<DoiTuongSuDung>)renderRequest.getAttribute("doiTuongConfigList");
	}

} catch (Exception e) {
	SessionErrors.add(renderRequest, "errorAddTTHC");
}

ThuTucHanhChinh tthc = null;
long capCoQuanQuanLyId = 0L;
if (tthcId.trim().length() > 0) {
	tthc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(FormatUtil.convertToLong(tthcId));
	if (tthc != null){
		//capCoQuanQuanLyId =   tthc.getCapCoQuanQuanLyId();
		trinhTuThucHien = tthc.getTrinhTuThucHien()==null?"":tthc.getTrinhTuThucHien();
		thanhPhanHoSo = tthc.getThanhPhanHoSo()==null?"":tthc.getThanhPhanHoSo();
		linhVucThucHien = tthc.getLinhVucThucHien()==null?"":tthc.getLinhVucThucHien();
		yeuCauDieuKienThucHien = tthc.getYeuCauDieuKienThucHien()==null?"":tthc.getYeuCauDieuKienThucHien();
		canCuPhapLy = tthc.getCanCuPhapLy()==null?"":tthc.getCanCuPhapLy();
		nhomTTHCId= tthc.getNhomThuTucHanhChinhId();
		ungDungId=DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(nhomTTHCId).getDanhMucUngDungId()).getId();
	}
	
}

%>
<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<portlet:resourceURL var="fetchValues" id="fetchNhomTTHC" />
<form id="<portlet:namespace/>dMGTForm" name="<portlet:namespace/>dMGTForm" method="post" action="<%=actionUrl.toString() %>">
<table cellpadding="0" cellspacing="0" class="egov-table-form" >
<tbody>
	<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header">Quản lý thủ tục hành chính</label>
			<br><br>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<select style="display: none;" id="egov-form-errors">
				<option value="maTTHC"><liferay-ui:error key="existMaTTHC" message = "org.oep.cmon.document.setting.tthc.form.exist.ma"/></option>
				<option value="maTTHC"><liferay-ui:error key="emptyMaTTHC" message = "org.oep.cmon.document.setting.tthc.form.empty.ma"/></option>
				<option value="tenTTHC"><liferay-ui:error key="existTenTTHC" message = "org.oep.cmon.document.setting.tthc.form.exist.ten"/></option>
				<option value="tenTTHC"><liferay-ui:error key="emptyTenTTHC" message = "org.oep.cmon.document.setting.tthc.form.empty.ten"/></option>				
				<option value="soNgayXL"><liferay-ui:error key="emptySoNgayXLTTHC" message = "org.oep.cmon.document.setting.tthc.form.empty.songayxl"/></option>
				<option value="<portlet:namespace/>capCoQuanQuanLyId"><liferay-ui:error key="emptyCapCQQL" message = "Bạn chưa chọn cấp cơ quan quản lý"/></option>
				<option value="<portlet:namespace/>ungDungId"><liferay-ui:error key="emptyUngDung" message = "Bạn chưa chọn ứng dụng"/></option>
				<option value="<portlet:namespace/>nhomTTHCId"><liferay-ui:error key="emptyNhomTTHC" message = "Bạn chưa chọn nhóm thủ tục hành chính"/></option>
				
				<option value="<portlet:namespace/>doiTuongId"><liferay-ui:error key="emptyDoiTuongSuDung" message = "org.oep.cmon.document.setting.tthc.form.empty.dtsd"/></option>
			</select>
				<liferay-ui:error key="errorAddTTHC" message = "org.oep.cmon.document.setting.tthc.form.error.add"/>
				<liferay-ui:error key="errorAddTTHC2DT" message = "org.oep.cmon.document.setting.tthc.form.error.add2dt"/>
				<liferay-ui:error key="errorUpdateTTHC" message = "org.oep.cmon.document.setting.tthc.form.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateTTHC") != null && ParamUtil.getString(request, "CompletedUpdateTTHC").trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateTTHC" message="org.oep.cmon.document.setting.tthc.form.completed.update"/>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddTTHC") != null && ParamUtil.getString(request, "CompletedAddTTHC").trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddTTHC" message="org.oep.cmon.document.setting.tthc.form.completed.add"/>
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>				
				<input type="hidden" name = "tthcId" id = "tthcId" value = "<%=tthcId%>"/>
				<input type="hidden" id="giatridoituongId" name="giatridoituongId"	value="" />
		</td>	
	</tr>
	<tr>
		<td colspan="4"><label class="egov-label-bold">Tên thủ tục
				</label> (<label class="egov-label-red">*</label>) <br> 
				<input name="tenTTHC" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="tenTTHC" maxlength="250" 
					class="egov-inputfield"  style="width:95%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "tenTTHC"), 1)%>" /></td>

		<td colspan="2"><label class="egov-label-bold">Mã thủ tục</label>
				(<label class="egov-label-red">*</label>)<br> 
				<input name="maTTHC" type="text"  style="width:93%;"
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="maTTHC" maxlength="5" class="egov-inputfield"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "maTTHC"), 3)%>"  />
		</td>
	</tr>
	<tr>
				<td colspan="3"><label class="egov-label-bold">Ứng dụng</label><label class="egov-label-red">*</label>
					<br> <select class="egov-select" name="<portlet:namespace/>ungDungId" style="width: 98%;"
					id="<portlet:namespace/>ungDungId" <%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>>
					<option value="">--Chọn ứng dụng--</option>
						<%
							List<DanhMucUngDung> groups = DanhMucUngDungLocalServiceUtil.getDSUngDung(0);
							String selectedGroup = null;

							for (DanhMucUngDung group : groups) {
								selectedGroup = "";
								if (ungDungId > 0) {
									if (group.getId() == ungDungId) {
										selectedGroup = "selected";
									}
								}
						%>
						<option value="<%=group.getId()%>" <%=selectedGroup%>>
							<%=group.getTen()%></option>
						<%
							}
						%>
				</select></td>
				<td colspan="3">
					<label class="egov-label-bold">
					Nhóm thủ tục hành chính
				  </label><label class="egov-label-red">*</label><br>
				 <select class="egov-select" name="<portlet:namespace/>nhomTTHCId" id="<portlet:namespace/>nhomTTHCId" <%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>>
				 <option value="">--Chọn nhóm TTHC--</option>
						<%
							if (ungDungId > 0) {
								List<NhomThuTucHanhChinh> gpTTHC = NhomThuTucHanhChinhLocalServiceUtil
										.getDSNhomThuTucHanhChinhBoiUngDung(ungDungId, 0);
								String selectedNTTHC = null;

								for (NhomThuTucHanhChinh grp : gpTTHC) {
									selectedNTTHC = "";
									if (nhomTTHCId > 0) {
										if (grp.getId() == nhomTTHCId) {
											selectedNTTHC = "selected";
										}
									}
						%>
						<option value="<%=grp.getId()%>" <%=selectedNTTHC%>>
							<%=grp.getTen()%></option>
						<%
								}
							}
						%>
				</select>
				</td>
	</tr>
	<tr>
		<td colspan="2">
					<label class="egov-label-bold">
					Số ngày xử lý
				  </label>				 
				  (<label class="egov-label-red">*</label>) <br>				
				<input name="soNgayXL" type="text"  style="width:90%;"
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="soNgayXL" maxlength="9" class="egov-inputfield"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "soNgayXL"), 2)%>" >
				
				</td>
				<td colspan="2" ><label class="egov-label-bold">Trạng thái</label>
				<br> 		      			
		      			<select id="trangThaiTTHC" name="trangThaiTTHC" class="egov-select"  style="width:96%;"
		      				<%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>>
		      			<option <%=ThuTucHanhChinhBusiness.checkTTSelected(tthc, ParamUtil.getString(request, "trangThaiTTHC"), "1") %> value = "1">Hoạt động</option>
		      			<option <%=ThuTucHanhChinhBusiness.checkTTSelected(tthc, ParamUtil.getString(request, "trangThaiTTHC"), "0") %> value = "0">Khóa</option>
		      		
		      		</select>	
			</td>
			<td colspan="2" ><label class="egov-label-bold">Tích hợp</label>
				<br> 		      			
		      			<select id="tichHop" name="tichHop" class="egov-select" <%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>>
		      			<option <%=ThuTucHanhChinhBusiness.checkTHSelected(tthc, ParamUtil.getString(request, "tichHop"), "1") %> value = "1">Có</option>
		      			<option <%=ThuTucHanhChinhBusiness.checkTHSelected(tthc, ParamUtil.getString(request, "tichHop"), "0") %> value = "0">Không</option>
		      		
		      		</select>	
			</td>
	</tr>
	
	<tr>
		<td  colspan="6">
			<label class="egov-label-bold">Trình tự thực hiện</label> <br>			
			<liferay-ui:input-editor width="100%" height="150" name="trinhTu" toolbarSet="liferay-article" initMethod="initTrinhTuEditor" />
			<input name="<portlet:namespace />trinhTuThucHien" type="hidden" value="" />
		</td>
		
	</tr>
	<tr>
		<td  colspan="6">
			<label class="egov-label-bold">Cách thực hiện</label> <br>
			<input name="cachThucHien" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="cachThucHien" maxlength="1050" 
					class="egov-inputfield"  style="width:97.5%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "cachThucHien"), 5)%>" />
		</td>
		
	</tr>
	<tr>
		<td  colspan="6">
			<label class="egov-label-bold">Thành phần, số lượng hồ sơ</label> <br>						
			<liferay-ui:input-editor width="100%" height="300" name="thanhPhan" toolbarSet="liferay-article" initMethod="initThanhPhanEditor" />
			<input name="<portlet:namespace />thanhPhanHoSo" type="hidden" value="" />
		</td>
		
	</tr>
	
	<tr>
		
		<td  colspan="6">
			<label class="egov-label-bold">Lĩnh vực thực hiện</label> <br>				
			<liferay-ui:input-editor width="100%" height="150" name="linhVuc" toolbarSet="liferay-article" initMethod="initLinhVucEditor" />
			<input name="<portlet:namespace />linhVucThucHien" type="hidden" value="" />
		</td>
	</tr>
	
	<tr>
		<td  colspan="3">
			<label class="egov-label-bold">Lệ phí</label> <br>
			<input name="lePhi" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="lePhi" maxlength="250" 
					class="egov-inputfield"  style="width:94%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "lePhi"), 9)%>" />
		</td>
		<td  colspan="3">
			<label class="egov-label-bold">Đơn vị lệ phí</label> <br>
			<input name="donViLePhi" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="donViLePhi" maxlength="250" 
					class="egov-inputfield"  style="width:95%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "donViLePhi"), 10)%>" />
		</td>
	</tr>
	<tr>
		<td  colspan="3">
			<label class="egov-label-bold">Phí</label> <br>
			<input name="phi" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="phi" maxlength="250" 
					class="egov-inputfield"  style="width:94%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "phi"), 11)%>" />
		</td>
		<td  colspan="3">
			<label class="egov-label-bold">Đơn vị phí</label> <br>
			<input name="donViPhi" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="donViPhi" maxlength="250" 
					class="egov-inputfield"  style="width:95%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "donViPhi"), 12)%>" />
		</td>
	</tr>
	
	<tr>
		<td  colspan="6">
			<label class="egov-label-bold">Tên mẫu đơn, tờ khai</label> <br>
			<input name="tenMauDonToKhai" type="text"					
					<%=ThuTucHanhChinhBusiness.checkTTHCReadOnly(actionTyPe)%>
					id="tenMauDonToKhai" maxlength="250" 
					class="egov-inputfield"  style="width:97.5%;"
					value="<%=ThuTucHanhChinhBusiness.checkTTHCDataReturn(tthc,
					ParamUtil.getString(request, "tenMauDonToKhai"), 13)%>" />
		</td>
	</tr>
	
	<tr>
		<td  colspan="6">
			<label class="egov-label-bold">Yêu cầu, điều kiện thực hiện</label> <br>			
			<liferay-ui:input-editor width="100%" height="150" name="yeuCau" toolbarSet="liferay-article" initMethod="initYeuCauEditor" />
			<input name="<portlet:namespace />yeuCauDieuKienThucHien" type="hidden" value="" />
		</td>
		
	</tr>
	
	<tr>
		<td  colspan="6">
			<label class="egov-label-bold">Căn cứ pháp lý</label> <br>			
			<liferay-ui:input-editor width="100%" height="150" name="canCu" toolbarSet="liferay-article" initMethod="initCanCuEditor" />
			<input name="<portlet:namespace />canCuPhapLy" type="hidden" value="" />
		</td>
		
	</tr>
	
	<tr>
		<td  colspan="3">
			<label class="egov-label-bold">Cấp cơ quan quản lý</label> <label class="egov-label-red">*</label><br>
			<select class="egov-select" name="<portlet:namespace/>capCoQuanQuanLyId" id="<portlet:namespace/>capCoQuanQuanLyId" >
				 <option value="0">--Chọn Cấp CQQL--</option>
						<%
								List<CapCoQuanQuanLy> capCQQL = CapCoQuanQuanLyLocalServiceUtil.getCapCoQuanQuanLies(0, 500);
								String selectedCQQL = null;

								for (CapCoQuanQuanLy capCQ : capCQQL) {
									selectedCQQL = "";
									if (tthc !=null && tthc.getCapCoQuanQuanLyId() != null) {
										if (capCQ.getId() == tthc.getCapCoQuanQuanLyId()) {
											selectedCQQL = "selected";
										}
									} else {
										if (capCQ.getId() == capCQQLId) {
											selectedCQQL = "selected";
										}
									}
						%>
						<option value="<%=capCQ.getId()%>" <%=selectedCQQL%>> <%=capCQ.getTen()%></option>
						<%
								}
						%>
				</select>
		</td>
		
	</tr>
	
	<tr>
		<td colspan="6" valign="top">
					<table class="egov-table-form" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td width="43%"><label class="egov-label-bold">Đối tượng sử dụng</label> <label class="egov-label-red">*</label>
			      			<select class="egov-multi-select" size="10" multiple="multiple" id="select-system-id">
									<% if (doiTuongList != null && doiTuongList.size() > 0) {
										for (int i = 0; i < doiTuongList.size(); i++) {
											DoiTuongSuDung doiTuong = (DoiTuongSuDung) doiTuongList.get(i);
										%>
										<option value="<%= doiTuong.getId() %>" title="<%= HtmlUtil.escape(doiTuong.getTen()) %>">
											<%= HtmlUtil.escape(doiTuong.getTen()) %>
										</option>
									<% }
									} %>
							</select>
							</td>
							<td width="4%" align="center" style="text-agin:center; "><br><br> 
		      					<input type="button"class="egov-func-select" value=">>"
								onclick="moveOptions('select-system-id','<portlet:namespace/>doiTuongId');"
								<%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>
								>
		      				<br> <br> 
		      					<input type="button" class="egov-func-select" value="<<" 
								onclick="moveOptions('<portlet:namespace/>doiTuongId','select-system-id');"
											<%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>
								>
							</td>
							<td width="43%"><label class="egov-label-bold">Đối tượng được chọn</label>
			      			 <select class="egov-multi-select"	size="10" name="<portlet:namespace/>doiTuongId" multiple="multiple"	id="<portlet:namespace/>doiTuongId" 
									<%=ThuTucHanhChinhBusiness.checkDisabled(actionTyPe, ThuTucHanhChinhBusiness.VIEW_TTHC) %>
									>
									<% if (doiTuongConfigList != null && doiTuongConfigList.size() > 0) {
										for (int i = 0; i < doiTuongConfigList.size(); i++) {
											DoiTuongSuDung doiTuong = (DoiTuongSuDung) doiTuongConfigList.get(i);
										%>
											<option value="<%= doiTuong.getId() %>" title="<%= HtmlUtil.escape(doiTuong.getTen()) %>">
												<%= HtmlUtil.escape(doiTuong.getTen()) %>
											</option>
									<% }
									} %>
								</select>
							</td>
						</tr>
						</tbody>
					</table>
				</td>
	</tr>	
	<tr>
		<td colspan="6" align="center">
		<br>
					<%
						// Create upload avatar URL
						PortletURL backUrl = renderResponse.createRenderURL();
						backUrl.setParameter("jspPage",
								"/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
						if (ungDungId > 0) {
							backUrl.setParameter("ungDung", String.valueOf(ungDungId));
						}
						if (nhomTTHCId > 0) {
							backUrl.setParameter("nhomTTHC", String.valueOf(nhomTTHCId));
						}
						if (actionTyPe.compareTo(ThuTucHanhChinhBusiness.VIEW_TTHC) != 0) {
					%> <span><input type="button" class="egov-button-normal"
						name="<portlet:namespace/>submitButton" id="<portlet:namespace/>submitButton" value="Lưu lại" /></span> 
						<%
 						}
					%> 
 					<span style="padding-left: 10px;"><a href="<%=backUrl.toString()%>"><input type="button"
							name="backUrl" class="egov-button-normal" value="Quay lại danh sách" /></a></span>
			<br>				
		</td>
	</tr>
	
	</tbody>
</table>
</form>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#soNgayXL').bind('input propertychange', function () {
		    $(this).val($(this).val().replace(/[^0-9]/g, ''));
		});
		//$('input#maDMGT').val($(this).val().toUpperCase());
		  $('#maDMGT').keyup(function() {
		        $(this).val($(this).val().toUpperCase());
		});		  
	 
		$('#<portlet:namespace/>submitButton').click(function(){
			document.<portlet:namespace/>dMGTForm.<portlet:namespace />trinhTuThucHien.value = window.<portlet:namespace />trinhTu.getHTML();
			document.<portlet:namespace/>dMGTForm.<portlet:namespace />thanhPhanHoSo.value = window.<portlet:namespace />thanhPhan.getHTML();
			document.<portlet:namespace/>dMGTForm.<portlet:namespace />linhVucThucHien.value = window.<portlet:namespace />linhVuc.getHTML();
			document.<portlet:namespace/>dMGTForm.<portlet:namespace />yeuCauDieuKienThucHien.value = window.<portlet:namespace />yeuCau.getHTML();
			document.<portlet:namespace/>dMGTForm.<portlet:namespace />canCuPhapLy.value = window.<portlet:namespace />canCu.getHTML();
			$('#<portlet:namespace/>doiTuongId option').attr('selected', 'selected');
			//document.getElementById("giatridoituongId").value = getSelectValues('doiTuongId');
			//alert(document.getElementById("giatridoituongId").value);
			 document.<portlet:namespace/>dMGTForm.submit();
		});
	   
		// Change event on ungdung combobox		 
		$("#<portlet:namespace/>ungDungId").change(function(){
			 
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#<portlet:namespace/>ungDungId").val();	  	
		  	 
		  	
		  	$("#<portlet:namespace/>nhomTTHCId").empty();
		  	$("#<portlet:namespace/>nhomTTHCId").append("<option value=''>--Chọn nhóm TTHC--</option>");
		  	
		  	if (parentId != "") {	 
		  		 		 		 
				jQuery.getJSON(url+"&parentId=" + parentId, function(data)  {
					
				   	for(var i=0; i < data.nhomTTHCArray.length; i++){
				   		nhomTTHCArray = data.nhomTTHCArray[i].split(":");
				    	$("#<portlet:namespace/>nhomTTHCId").append("<option value='"+ nhomTTHCArray[0] +"'>"+nhomTTHCArray[1]+"</option> " );
				   	}
		  		});
		  	}
		  	
		  	$("#<portlet:namespace/>nhomTTHCId").change();
	 	});	 
	});
	//liemnn
	//doan trinh sau se thuc hien chon tat ca cac gia tri trong multi check
	function getSelectValues(selectId){
		var selectedValues = [];
		 $("#"+selectId+" option").each(function() {
			 selectedValues.push(this.value);
		  });
		 return selectedValues;
		     
	}
	//duong Editor
	function <portlet:namespace />initTrinhTuEditor() {
		 //var fckTomTatValue = document.<portlet:namespace/>tinTucForm.<portlet:namespace />editorSummary.value;
		 //return fckTomTatValue;
		 var elemSummary = document.getElementById("cke_contents_<portlet:namespace />trinhTu");
		 //var style = elemSummary.getAttribute("style");
		 elemSummary.setAttribute("style","height: 130px");
		 return "<%= UnicodeFormatter.toString(trinhTuThucHien)%>" ;
	    
	}
	function <portlet:namespace />initThanhPhanEditor() {
		 //var fckNoiDungValue = document.<portlet:namespace/>tinTucForm.<portlet:namespace />editorContent.value;
		 //return fckNoiDungValue ;
		 var elemContent = document.getElementById("cke_contents_<portlet:namespace />thanhPhan");
		 elemContent.setAttribute("style","height: 130px");
		 return "<%= UnicodeFormatter.toString(thanhPhanHoSo)%>" ;
	   
	}
	
	function <portlet:namespace />initLinhVucEditor() {
		 //var fckNoiDungValue = document.<portlet:namespace/>tinTucForm.<portlet:namespace />editorContent.value;
		 //return fckNoiDungValue ;
		 var elemContent = document.getElementById("cke_contents_<portlet:namespace />linhVuc");
		 elemContent.setAttribute("style","height: 130px");
		 return "<%= UnicodeFormatter.toString(linhVucThucHien)%>" ;
	   
	}
	
	function <portlet:namespace />initYeuCauEditor() {
		 //var fckNoiDungValue = document.<portlet:namespace/>tinTucForm.<portlet:namespace />editorContent.value;
		 //return fckNoiDungValue ;
		 var elemContent = document.getElementById("cke_contents_<portlet:namespace />yeuCau");
		 elemContent.setAttribute("style","height: 130px");
		 return "<%= UnicodeFormatter.toString(yeuCauDieuKienThucHien)%>" ;
	   
	}
	
	function <portlet:namespace />initCanCuEditor() {
		 //var fckNoiDungValue = document.<portlet:namespace/>tinTucForm.<portlet:namespace />editorContent.value;
		 //return fckNoiDungValue ;
		 var elemContent = document.getElementById("cke_contents_<portlet:namespace />canCu");
		 elemContent.setAttribute("style","height: 130px");
		 return "<%= UnicodeFormatter.toString(canCuPhapLy)%>" ;
	   
	}
	
</script>