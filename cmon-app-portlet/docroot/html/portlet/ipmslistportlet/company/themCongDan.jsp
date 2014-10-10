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
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>

<%
String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}
String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}
String idQuyTrinh = "";
if (renderRequest.getParameter("idQuyTrinh") != null) {
	idQuyTrinh = renderRequest.getParameter("idQuyTrinh");
}
String searchKeyWord = "";
if (renderRequest.getParameter("searchKeyWord") != null) {
	searchKeyWord = renderRequest.getParameter("searchKeyWord");
}

String _searchKeyWord = "";
if (renderRequest.getParameter("_searchKeyWord") != null) {
	_searchKeyWord = renderRequest.getParameter("_searchKeyWord");
}

PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "addCongDanRequest");
%>
<div class="egov-container">
	<form id="addCongDanRequestForm" name="addCongDanRequestForm" method="post" action="<%=actionUrl.toString() %>">
		<table  style="width: 100%; background-color: white;">
			<tr>
				<td align = "right" width="100%">
					<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/timCongDan.jsp");
					timCongDanRequestUrl.setParameter("searchKeyWord", searchKeyWord);
					timCongDanRequestUrl.setParameter("_searchKeyWord", _searchKeyWord);
					timCongDanRequestUrl.setParameter("idQuyTrinh", idQuyTrinh);
					timCongDanRequestUrl.setParameter("statusHS", statusHS);
					timCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
					timCongDanRequestUrl.setParameter("transType", transType);
					%>
					<a href="<%=timCongDanRequestUrl.toString() %>">Quay lại&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</td>
			</tr>
		</table>
		<table  class="egov-table-form">
			<tr>
				<td colspan="2" align = "center">
					<label class="egov-label-header">Thêm thông tin công dân</label>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
					<liferay-ui:error key="requireFirstName" message = "vn.dtt.form.offline.error.firstname"/>
					<liferay-ui:error key="requireMiddleName" message = "vn.dtt.form.offline.error.middlename"/>
					<liferay-ui:error key="requireLastName" message = "vn.dtt.form.offline.error.lastname"/>
					<liferay-ui:error key="requireCMND" message = "vn.dtt.form.offline.error.cmnd"/>
					<liferay-ui:error key="exitCMND" message = "vn.dtt.form.offline.error.exit.cmnd"/>
					<liferay-ui:error key="numberCMND" message = "vn.dtt.form.offline.error.number.cmnd"/>
					<liferay-ui:error key="arrangeCMND" message = "vn.dtt.form.offline.error.arrange.cmnd"/>
					<liferay-ui:error key="requireNgaySinh" message = "vn.dtt.form.offline.error.ngaysinh"/>
					<liferay-ui:error key="requireGioiTinh" message = "vn.dtt.form.offline.error.gioitinh"/>
					<liferay-ui:error key="requireNumberhome" message = "vn.dtt.form.offline.error.numberhome"/>
					<liferay-ui:error key="requireTinh" message = "vn.dtt.form.offline.error.tinh"/>
					<liferay-ui:error key="requireHuyen" message = "vn.dtt.form.offline.error.huyen"/>
					<liferay-ui:error key="requireXa" message = "vn.dtt.form.offline.error.xa"/>
					<liferay-ui:error key="error_add_cong_dan" message = "vn.dtt.form.offline.error.add.citizen"/>
					<liferay-ui:success key="add_cong_dan_completed" message="vn.dtt.form.offline.add.citizen.completed"></liferay-ui:success>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Họ - Đệm - Tên công dân<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input type="hidden" name = "idQuyTrinh" id = "idQuyTrinh" value = "<%=idQuyTrinh%>"/>
					<input type="hidden" name = "quocGiaId" id = "quocGiaId" value = "1"/>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=searchKeyWord%>"/>
					<input type="hidden" name = "_searchKeyWord" id = "_searchKeyWord" value = "<%=_searchKeyWord%>"/>
					<input type="hidden" name = "transType" id = "transType" value = "<%=transType%>"/>
					<input type="hidden" name = "statusHS" id = "statusHS" value = "<%=statusHS%>"/>
					<input type="hidden" name = "transactionKeyword" id = "transactionKeyword" value = "<%=transactionKeyword%>"/>	
					<input id="firstName" name="firstName" class = "egov-inputfield custom" type="text" maxlength="20" size="10" value="<%=ConvertUtil.getValueFromRenderRequest("firstName", renderRequest) %>"/>
					<input id="middleName" name="middleName" class = "egov-inputfield custom" type="text" maxlength="50" size="10" value="<%=ConvertUtil.getValueFromRenderRequest("middleName", renderRequest) %>"/>
					<input id="lastName" name="lastName" class = "egov-inputfield custom" type="text" maxlength="20" size="10" value="<%=ConvertUtil.getValueFromRenderRequest("lastName", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số CMND <font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="cmnd" name="cmnd" class = "egov-inputfield custom" type="text" maxlength="15" size="30" value="<%=ConvertUtil.getValueFromRenderRequest("cmnd", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày sinh: <font color="red">(*)</font>:</label>
				</td>
				<td>
					<input name="ngaySinh" type="text" id="ngaySinh" class ="egov-calendar custom" readonly="readonly" size="30" value="<%=ConvertUtil.getValueFromRenderRequest("ngaySinh", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Giới tính <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idGioiTinh" id="idGioiTinh" class = "egov-select" style="width:227px; display:block;">
						<option>--Chọn giới tính--</option>
						<%
						FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
						List<GioiTinh> listGioiTinh = formOfflineBusiness.findAllGioiTinh();
						for(GioiTinh gioiTinh : listGioiTinh) {
							%>
							<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("idGioiTinh"), gioiTinh.getId()) %> value = "<%=gioiTinh.getId()%>"><%=gioiTinh.getTen()%></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số nhà <font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="numberHome" class = "egov-inputfield custom" name="numberHome" type="text" maxlength="100" size="30"  value="<%=ConvertUtil.getValueFromRenderRequest("numberHome", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tỉnh/Thành Phố <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idTinhHienTai" id="idTinhHienTai"  onchange="reDrawSelectBox('idTinhHienTai','idHuyenHienTai')" class = "egov-select" style="width:227px; display:block;">
						<option>--Chọn tỉnh/thành phố--</option>
						<%
						List<DonViHanhChinh> listTinh = formOfflineBusiness.findDonViHanhChinhCapTinhThanhPho();
						for(DonViHanhChinh donViHanhChinh : listTinh) {
							%>
							<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("idTinhHienTai"), donViHanhChinh.getId()) %> value = "<%=donViHanhChinh.getId()%>"><%=donViHanhChinh.getTen()%></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Quận/Huyện <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idHuyenHienTai" id="idHuyenHienTai"  onchange="reDrawSelectBox('idHuyenHienTai','idXaHienTai')" class = "egov-select" style="width:227px; display:block;">
						<option>--Chọn quận/huyện--</option>
						<%
						if (renderRequest.getParameter("idTinhHienTai") != null) {
							List<DonViHanhChinh> dsDVHC = formOfflineBusiness.findDonViHanhChinhByChaId(ConvertUtil.convertToLong(renderRequest.getParameter("idTinhHienTai")));
							for(DonViHanhChinh donViHanhChinh : dsDVHC) {
								%>
								<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("idHuyenHienTai"), donViHanhChinh.getId()) %> value = "<%=donViHanhChinh.getId()%>"><%=donViHanhChinh.getTen()%></option>
								<%
							}
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Xã/Phường <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idXaHienTai" id="idXaHienTai" class = "egov-select" style="width:227px; display:block;">
						<option>--Chọn xã/phường--</option>
						<%
						if (renderRequest.getParameter("idHuyenHienTai") != null) {
							List<DonViHanhChinh> dsDVHC = formOfflineBusiness.findDonViHanhChinhByChaId(ConvertUtil.convertToLong(renderRequest.getParameter("idHuyenHienTai")));
							for(DonViHanhChinh donViHanhChinh : dsDVHC) {
								%>
								<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("idXaHienTai"), donViHanhChinh.getId()) %> value = "<%=donViHanhChinh.getId()%>"><%=donViHanhChinh.getTen()%></option>
								<%
							}
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				<%
				PortletURL reloadCongDanRequestUrl = renderResponse.createRenderURL();
				reloadCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/themCongDan.jsp");
				reloadCongDanRequestUrl.setParameter("searchKeyWord", searchKeyWord);
				reloadCongDanRequestUrl.setParameter("_searchKeyWord", _searchKeyWord);
				reloadCongDanRequestUrl.setParameter("idQuyTrinh", idQuyTrinh);
				reloadCongDanRequestUrl.setParameter("statusHS", statusHS);
				reloadCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
				reloadCongDanRequestUrl.setParameter("transType", transType);
				%>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
					<input type="submit" style="height: 35px;padding:10px;" class = "egov-button" name="submitButton"  value="Lưu lại" />
					<input type="button" onclick="javascript: window.location = '<%=reloadCongDanRequestUrl %>'" style="height: 35px;padding:10px;" class = "egov-button" name="reset"  value="Nhập lại" />
				</td>
			</tr>
		</table>
	</form>
</div>
<portlet:actionURL var="getDonViHanhChinhByIdURL" name="getDonViHanhChinhById">
	<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
</portlet:actionURL>
<script type="text/javascript">
	var url = '<%= getDonViHanhChinhByIdURL.toString() %>';

	//Ve lai danh sach don vi hanh chinh
	function reDrawSelectBox(selectName, changeName) {
				
		var id = document.getElementById(selectName).options[document.getElementById(selectName).selectedIndex].value;
		var hidSelectedPhuongXa = document.getElementById("hiddenPhuongXaId");
		
		// if quan huyen is not selected then return
		if (id == "") return;
		
		var obj = document.getElementById(changeName);
	
		$.ajax({
			type: 'POST'
			,url: url
			,data : {id: id}
			,success: function(data) {		
	
				// preferred
				var data2 = JSON.parse(data);
				// Xoa cac old item in select
				
				while (obj.options.length > 1) {
					obj.remove(1);
				}				
	            
				for (var i = 0; i < data2.id.length; i++) {
					obj.add(new Option(data2.name[i], data2.id[i]), null);
					
					if (hidSelectedPhuongXa && (data2.id[i] == hidSelectedPhuongXa.value)) 
		            {
		                obj.selectedIndex = i + 1;
		            }
				}
			}
		});
	}
</script>