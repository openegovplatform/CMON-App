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
<%@page import="org.oep.cmon.dao.qlhc.service.TrangThaiDoanhNghiepLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.TrangThaiDoanhNghiep"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
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
actionUrl.setParameter(ActionRequest.ACTION_NAME, "addDoanhNghiepRequest");
%>
<div class="egov-container">
	<form id="addCongDanRequestForm" name="addCongDanRequestForm" method="post" action="<%=actionUrl.toString() %>">
		<table  style="width: 100%; background-color: white;">
			<tr>
				<td align = "right" width="100%">
					<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCompany.jsp");
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
					<label class="egov-label-header">Thêm thông tin doanh nghiệp</label>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
					<liferay-ui:error key="requireMaSoDoanhNghiep" message = "org.oep.form.offline.company.empty.MaSoDoanhNghiep"/>
					<liferay-ui:error key="numberMaSoDoanhNghiep" message = "org.oep.form.offline.company.error.MaSoDoanhNghiep"/>
					<liferay-ui:error key="exitMaSoDoanhNghiep" message = "org.oep.form.offline.company.error.exit.MaSoDoanhNghiep"/>
					<liferay-ui:error key="requireMaSothueDoanhNghiep" message = "org.oep.form.offline.company.empty.MaSothueDoanhNghiep"/>
					<liferay-ui:error key="numberMaSothueDoanhNghiep" message = "org.oep.form.offline.company.error.MaSothueDoanhNghiep"/>
					<liferay-ui:error key="exitMaSothueDoanhNghiep" message = "org.oep.form.offline.company.error.exit.MaSothueDoanhNghiep"/>
					<liferay-ui:error key="requireTenDoanhNghiep" message = "org.oep.form.offline.company.error.TenDoanhNghiep"/>
					<liferay-ui:error key="exitTenDoanhNghiep" message = "org.oep.form.offline.company.error.exit.TenDoanhNghiep"/>
					<liferay-ui:error key="requireSoGiayPhepDangKyDoanhNghiep" message = "org.oep.form.offline.company.empty.SoGiayPhepDangKyDoanhNghiep"/>
					<liferay-ui:error key="numberSoGiayPhepDangKyDoanhNghiep" message = "org.oep.form.offline.company.error.SoGiayPhepDangKyDoanhNghiep"/>
					<liferay-ui:error key="exitSoGiayPhepDangKyDoanhNghiep" message = "org.oep.form.offline.company.error.exit.SoGiayPhepDangKyDoanhNghiep"/>
					<liferay-ui:error key="requireNgayCapGiayPhepDangKyDoanhNghiep" message = "org.oep.form.offline.company.error.NgayCapGiayPhepDangKyDoanhNghiep"/>
					<liferay-ui:error key="afterNgayCapGiayPhepDangKyDoanhNghiep" message = "org.oep.form.offline.company.error.after.NgayCapGiayPhepDangKyDoanhNghiep"/>
					<liferay-ui:error key="numberTongSoVon" message = "org.oep.form.offline.company.error.TongSoVon"/>
					<liferay-ui:error key="requireTongSoVon" message = "org.oep.form.offline.company.empty.TongSoVon"/>
					<liferay-ui:error key="numberLoaiDoiTuong" message = "org.oep.form.offline.company.error.LoaiDoiTuong"/>
					<liferay-ui:error key="numberQuocGia" message = "org.oep.form.offline.company.error.QuocGia"/>
					<liferay-ui:error key="requireNumberhome" message = "org.oep.form.offline.company.error.Numberhome"/>
					<liferay-ui:error key="requireTinh" message = "org.oep.form.offline.company.error.Tinh"/>
					<liferay-ui:error key="requireHuyen" message = "org.oep.form.offline.company.error.Huyen"/>
					<liferay-ui:error key="requireXa" message = "org.oep.form.offline.company.error.Xa"/>
					<liferay-ui:error key="numberIdTrangThai" message = "org.oep.form.offline.company.error.TrangThaiDoanhNghiep"/>
					<liferay-ui:error key="requireMoTaNganhNgheKinhDoanh" message = "org.oep.form.offline.company.error.MoTaNganhNgheKinhDoanh"/>
					<liferay-ui:error key="add_doanh_nghiep_error" message = "org.oep.form.offline.company.add.error"/>
					<liferay-ui:success key="add_doanh_nghiep_completed" message="org.oep.form.offline.add.company.completed"></liferay-ui:success>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số doanh nghiệp<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input type="hidden" name = "idQuyTrinh" id = "idQuyTrinh" value = "<%=idQuyTrinh%>"/>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=searchKeyWord%>"/>
					<input type="hidden" name = "_searchKeyWord" id = "_searchKeyWord" value = "<%=_searchKeyWord%>"/>
					<input type="hidden" name = "transType" id = "transType" value = "<%=transType%>"/>
					<input type="hidden" name = "statusHS" id = "statusHS" value = "<%=statusHS%>"/>
					<input type="hidden" name = "transactionKeyword" id = "transactionKeyword" value = "<%=transactionKeyword%>"/>	
					<input id="maSoDoanhNghiep" name="maSoDoanhNghiep" class = "egov-inputfield custom" type="text" maxlength="20" size="45" value="<%=ConvertUtil.getValueFromRenderRequest("maSoDoanhNghiep", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số thuế doanh nghiệp<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="maSothueDoanhNghiep" name="maSothueDoanhNghiep" class = "egov-inputfield custom" type="text" maxlength="20" size="45" value="<%=ConvertUtil.getValueFromRenderRequest("maSothueDoanhNghiep", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên doanh nghiệp<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="tenDoanhNghiep" name="tenDoanhNghiep" class = "egov-inputfield custom" type="text" maxlength="200" size="45" value="<%=ConvertUtil.getValueFromRenderRequest("tenDoanhNghiep", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số giấy phép đăng ký kinh doanh<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="soGiayPhepDangKyDoanhNghiep" name="soGiayPhepDangKyDoanhNghiep" class = "egov-inputfield custom" type="text" maxlength="20" size="45" value="<%=ConvertUtil.getValueFromRenderRequest("soGiayPhepDangKyDoanhNghiep", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày cấp giấy phép kinh doanh: <font color="red">(*)</font>:</label>
				</td>
				<td>
					<input name="ngayCapGiayPhepDangKyDoanhNghiep" type="text" id="ngayCapGiayPhepDangKyDoanhNghiep" class ="egov-calendar custom" readonly="readonly" size="45" value="<%=ConvertUtil.getValueFromRenderRequest("ngayCapGiayPhepDangKyDoanhNghiep", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tổng số vốn<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="tongSoVon" name="tongSoVon" class = "egov-inputfield custom" type="text" maxlength="18" size="45" value="<%=ConvertUtil.getValueFromRenderRequest("tongSoVon", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Loại đối tượng <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idLoaiDoiTuong" id="idLoaiDoiTuong" class = "egov-select" style="width:310px; display:block;">
						<option>--Chọn loại đối tượng--</option>
						<%
						List<String> listWithout = new ArrayList<String>();
						listWithout.add("001");
						listWithout.add("002");
						FormOfflineBusiness formOfflineBusiness = new FormOfflineBusiness();
						List<DoiTuongSuDung> listGioiTinh = formOfflineBusiness.findLoaiDoiTuong(listWithout);
						for(DoiTuongSuDung gioiTinh : listGioiTinh) {
							%>
							<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("idLoaiDoiTuong"), gioiTinh.getId()) %> value = "<%=gioiTinh.getId()%>"><%=gioiTinh.getTen()%></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Trạng thái doanh nghiệp <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idTrangThai" id="idTrangThai" class = "egov-select" style="width:310px; display:block;">
						<option>--Chọn trạng thái doanh nghiệp--</option>
						<%
						List<TrangThaiDoanhNghiep> listTrangThaiDoanhNghiep = TrangThaiDoanhNghiepLocalServiceUtil.findDaXoa(0);
						for(TrangThaiDoanhNghiep gioiTinh : listTrangThaiDoanhNghiep) {
							%>
							<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("idTrangThai"), gioiTinh.getId()) %> value = "<%=gioiTinh.getId()%>"><%=gioiTinh.getTen()%></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Quốc Gia <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="quocGiaId" id="quocGiaId" class = "egov-select" style="width:310px; display:block;">
						<option>--Chọn quốc gia--</option>
						<%
						List<QuocGia> listQuocGia = QuocGiaLocalServiceUtil.findAll();
						for(QuocGia gioiTinh : listQuocGia) {
							%>
							<option <%=ConvertUtil.checkSelectedValue(renderRequest.getParameter("quocGiaId"), gioiTinh.getId()) %> value = "<%=gioiTinh.getId()%>"><%=gioiTinh.getTen()%></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ doanh nghiệp<font color="red">(*)</font>:</label>
				</td>
				<td>
					<input id="numberHome" class = "egov-inputfield custom" name="numberHome" type="text" maxlength="100" size="45"  value="<%=ConvertUtil.getValueFromRenderRequest("numberHome", renderRequest) %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tỉnh/Thành Phố <font color="red">(*)</font>:</label>
				</td>
				<td>
					<select name="idTinhHienTai" id="idTinhHienTai"  onchange="reDrawSelectBox('idTinhHienTai','idHuyenHienTai')" class = "egov-select" style="width:310px; display:block;">
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
					<select name="idHuyenHienTai" id="idHuyenHienTai"  onchange="reDrawSelectBox('idHuyenHienTai','idXaHienTai')" class = "egov-select" style="width:310px; display:block;">
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
					<select name="idXaHienTai" id="idXaHienTai" class = "egov-select" style="width:310px; display:block;">
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
				<td valign="top">
					<label class ="egov-label-bold">Mô tả ngành nghề kinh doanh<font color="red">(*)</font>:</label>
				</td>
				<td>
					<textarea id="moTaNganhNgheKinhDoanh" name="moTaNganhNgheKinhDoanh" maxlength="1024" rows="4" style="width:296px; display:block;" class="egov-textarea"><%=ConvertUtil.getValueFromRenderRequest("moTaNganhNgheKinhDoanh", renderRequest) %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				<%
				PortletURL reloadCongDanRequestUrl = renderResponse.createRenderURL();
				reloadCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/themCompany.jsp");
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