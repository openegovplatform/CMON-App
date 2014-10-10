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
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DoanhNghiep"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/dialog-ui.css" type="text/css" media="screen" />
<script src="<%=request.getContextPath()%>/js/jquery.form.js"	type="text/javascript"></script>

<%
String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}

String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}

HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
DoanhNghiep congDan = ConvertUtil.findDoanhNghiepById(hoSoTTHCCong.getDoiTuongCanXuLyId());
CongDan conDanNop = ConvertUtil.findCongDanById(hoSoTTHCCong.getCongDanNopId());
List<FileDinhKem> liFileUploadsIservice1 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCong.getId()));
%>
<div class="egov-container">
	<table width="100%">
		<tr>
			<td align = "right"></td>
			<td align = "right">
				<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/view.jsp");
					timCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
					timCongDanRequestUrl.setParameter("transType", transType);
					timCongDanRequestUrl.setParameter("statusHS", statusHS);
					%>
					<a href="<%=timCongDanRequestUrl.toString() %>">Quay lại&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</td>
		</tr>
	</table>
	<table class="egov-table-form">
		<tr>
			<td colspan="2" align="center"><label class="egov-label-header">Đối chiếu hồ sơ của công dân</label></td>
		</tr>
		<tr>
			<td align = "right"></td>
			<td align = "left">
				<liferay-ui:success key="doi_chieu_completed" message="org.oep.form.offline.doi.chieu.ho.so.completed"></liferay-ui:success>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Cơ quan tiếp nhận:</label>
			</td>
			<td>
				<input id="coQuanTiepNhanTen" name="coQuanTiepNhanTen" class = "egov-inputfield custom" readonly="readonly" type="text" size="50" value="<%=hoSoTTHCCong.getTenCoQuanTiepNhan() %>"/>
			</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên quy trình:</label>
				</td>
				<td>
					<input id="tenQuyTrinh" name="tenQuyTrinh" class = "egov-inputfield custom" readonly="readonly" value="<%=hoSoTTHCCong.getTenThuTucHanhChinh() %>" type="text" size="50"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold" style="color: blue;">Thông tin công dân nộp hồ sơ</label>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số CMND của công dân:</label>
				</td>
				<td>
					<input id="cmndCongDanNop" name="cmndCongDanNop" class = "egov-inputfield custom" readonly="readonly" value="<%=ConvertUtil.getCMNDCongDan(conDanNop) %>" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Họ tên công dân:</label>
				</td>
				<td>
					<input id="tenCongDanNop" name="tenCongDanNop" class = "egov-inputfield custom" value="<%=ConvertUtil.getTenCongDan(conDanNop) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ thường trú:</label>
				</td>
				<td>
					<input id="diaChiThuongTruCongDanNop" name="diaChiThuongTruCongDanNop" class = "egov-inputfield custom" value="<%=ConvertUtil.getDiaChiThuongTruCongDan(conDanNop) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số điện thoại:</label>
				</td>
				<td>
					<input id="soDienThoaiCongDan" name="soDienThoaiCongDan" class = "egov-inputfield custom" value="<%=ConvertUtil.getTelphoneCongDan(conDanNop, hoSoTTHCCong.getSoDienThoaiDiDongNguoiNop()) %>" type="text" maxlength="11" size="70"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label class ="egov-label-bold" style="color: blue;">Thông tin doanh nghiệp</label>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên doanh nghiệp:</label>
				</td>
				<td>
					<input id="tenCongDan" name="tenCongDan" class = "egov-inputfield custom" value="<%=congDan.getTen() %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số doanh nghiệp:</label>
				</td>
				<td>
					<input id="maSoDoanhNghiep" name="maSoDoanhNghiep" class = "egov-inputfield custom" readonly="readonly" value="<%=congDan.getMa() %>" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số thuế:</label>
				</td>
				<td>
					<input id="maSoThueDoanhNghiep" name="maSoThueDoanhNghiep" class = "egov-inputfield custom" value="<%=congDan.getMaSoThue() %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ doanh nghiệp:</label>
				</td>
				<td>
					<input id="diaChiThuongTruCongDan" name="diaChiThuongTruCongDan" class = "egov-inputfield custom" value="<%=ConvertUtil.getDiaChiDoanhNghiep(congDan) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày nộp hồ sơ:</label>
				</td>
				<td>
					<input id="ngayNopHoSo" name="ngayNopHoSo" class = "egov-inputfield custom" value="<%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayNopHoSo()) %>" readonly="readonly" type="text" size="50"/>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Danh sách tài liệu đối chiếu:</label>
				</td>
				<td></td>
			</tr>
			<tr>
				<td valign="top">
				</td>
				<td align="left">
					<%
					PortletURL actionUrl = renderResponse.createActionURL();
					actionUrl.setParameter(ActionRequest.ACTION_NAME, "doiChieuHoSoDoanhNghiepRequest");
					%>
					<form id="traHoSoRequestForm" name="traHoSoRequestForm" method="post" action="<%=actionUrl.toString() %>">
						<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
						<input id="transactionKeyword" name="transactionKeyword" type="hidden" value="<%=transactionKeyword %>"/>
						<input id="statusHS" name="statusHS" type="hidden" value="<%=statusHS %>"/>
						<input id="transType" name="transType" type="hidden" value="<%=transType %>"/>
						<table style="background-color: white;">
						<%
						TaiLieuChungThuc taiLieuChungThuc = null;
						for (FileDinhKem fileUpload : liFileUploadsIservice1) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
							<tr>
								<td><a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>"><%=taiLieuChungThuc.getTen() %></a></td>
								<td>
									<%
									if (fileUpload.getDaDoiChieu() == 1) {
										%>
										<input type="checkbox" value="<%=fileUpload.getId() %>" id="<%=fileUpload.getId() %>" name="<%=fileUpload.getId() %>" checked="checked" onclick="deleteFileUpload('<%=fileUpload.getId()%>')"/>
										<%
									} else {
										%>
										<input type="checkbox" value="" id="<%=fileUpload.getId() %>" name="<%=fileUpload.getId() %>" onclick="deleteFileUpload('<%=fileUpload.getId()%>')"/>
										<%
									}
									%>
								</td>
							</tr>
						<%
							}
						}
						%>
						</table>
						<%
						if (!SessionMessages.contains(renderRequest, "doi_chieu_completed")) {
						%>
							<input type="submit" style="height: 35px;padding:10px;" class = "egov-button" name="submitButton"  value="Lưu lại" />
						<%
						}
						%>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				</td>
			</tr>
	</table>
</div>
<script type="text/javascript">

function deleteFileUpload(fileId) {

	var giatri = document.getElementById(fileId).value;
	if (giatri.length > 0) {
		document.getElementById(fileId).value = '';
	} else {
		document.getElementById(fileId).value = fileId;
	}
	
}
</script>
