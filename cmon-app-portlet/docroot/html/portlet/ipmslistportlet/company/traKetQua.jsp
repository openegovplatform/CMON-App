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
<%@page import="org.oep.cmon.dao.qlhc.model.DoanhNghiep"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/dialog-ui.css" type="text/css" media="screen" />
<script src="<%=request.getContextPath()%>/js/jquery.form.js"	type="text/javascript"></script>

<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "traHoSoDoanhNghiepRequest");

String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}

String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String ghiChu = "";
if (renderRequest.getParameter("ghiChu") != null) {
	ghiChu = renderRequest.getParameter("ghiChu");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}

long uid = PortalUtil.getUserId(request);
long cqqlId = -1;
TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId());

if(congChucs.size() > 0 ){
		cqqlId = congChucs.get(0).getCoQuanQuanLyId();
}

TaiKhoanNguoiDung taiKhoanNguoiDung = ConvertUtil.findTaiKhoanNguoiDungByUserID(user.getUserId());
HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
DoanhNghiep congDan = ConvertUtil.findDoanhNghiepById(hoSoTTHCCong.getDoiTuongCanXuLyId());
%>
<div class="egov-container">
	<form id="addHoSoRequestForm" name="addHoSoRequestForm" method="post" action="<%=actionUrl.toString() %>">
	   <table style="width: 100%; background-color: white;">
			<tr>
				<td width="100%" align = "right">
					<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/view.jsp");
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
					<label class="egov-label-header">Trả kết quả cho doanh nghiệp</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<liferay-ui:error key="erorUpdateFormForm" message = "org.oep.form.offline.form.update.ho.so.error"/>
				<liferay-ui:success key="update_ho_so_completed" message="org.oep.form.offline.form.update.ho.so.completed"></liferay-ui:success>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên quy trình:</label>
				</td>
				<td>
					<input id="tenQuyTrinh" name="tenQuyTrinh" class = "egov-inputfield custom" readonly="readonly" type="text" size="50" value="<%=hoSoTTHCCong.getTenThuTucHanhChinh() %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên người trả hồ sơ:</label>
				</td>
				<td>
					<input id="tenNguoiTraHoSo" name="tenNguoiTraHoSo" class = "egov-inputfield custom" readonly="readonly" type="text" size="50" value="<%=ConvertUtil.getTenCanBo(taiKhoanNguoiDung.getId()) %>"/>
					<input id="transactionKeyword" name="transactionKeyword" type="hidden" value="<%=transactionKeyword %>"/>
					<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
					<input id="trangThaiHoSo" name="trangThaiHoSo" type="hidden" value="<%=transType %>"/>
					<input id="cqqlId" name="cqqlId" type="hidden" value="<%=cqqlId %>"/>
					<input id="statusHS" name="statusHS" type="hidden" value="<%=statusHS %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên người nhận hồ sơ:</label>
				</td>
				<td>
					<input id="tenNguoiNhanHoSo" name="tenNguoiNhanHoSo" class = "egov-inputfield custom" readonly="readonly" type="text" size="50" value="<%=hoSoTTHCCong.getHoTenNguoiNopHoSo() %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số hồ sơ:</label>
				</td>
				<td>
					<input id="maSoHoSo" name="maSoHoSo" class = "egov-inputfield custom" readonly="readonly" type="text" size="50" value="<%=hoSoTTHCCong.getMaSoHoSo() %>"/>
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
				<td>
					<label class ="egov-label-bold">Ngày hẹn trả hồ sơ:</label>
				</td>
				<td>
					<input id="ngayHenTraHoSo" name="ngayHenTraHoSo"  value="<%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayHenTraKetQua()) %>" class = "egov-inputfield custom" readonly="readonly" type="text" size="50"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày kết thúc xử lý:</label>
				</td>
				<td>
					<input id="ngayKetThucXuLy" name="ngayKetThucXuLy"  value="<%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayKetThucXuLy()) %>" class = "egov-inputfield custom" readonly="readonly" type="text" size="50"/>
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
				<td valign="top">
					<label class ="egov-label-bold">Ghi chú:</label>
				</td>
				<td>
					<%
					if (!SessionMessages.contains(renderRequest, "update_ho_so_completed")) {
					%>
					<textarea id="ghiChu" name="ghiChu" rows="5" cols="1000" class="egov-textarea  custom" maxlength="500" style="margin: 0px; width: 334px; height: 40px;"><%=ghiChu %></textarea>
					<%
					} else {
						%>
					<textarea id="ghiChu" name="ghiChu" rows="5" cols="1000" class="egov-textarea  custom" maxlength="500" style="margin: 0px; width: 327px; height: 40px;" readonly="readonly"><%=ghiChu %></textarea>	
						<%
					}
					%>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Hồ sơ gồm có:</label>
				</td>
				<td align="left">
					<table style="background-color: white;">
						<%
						List<FileDinhKem> liFileUploads = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));
						TaiLieuChungThuc taiLieuChungThuc = null;
						for (FileDinhKem fileUpload : liFileUploads) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
								<tr>
									<td>
									<%
									if (!SessionMessages.contains(renderRequest, "update_ho_so_completed")) {
										if (fileUpload.getDaTra() == 1) {
									%>
										<input id="<%=fileUpload.getId() %>_trachocongdan" name="<%=fileUpload.getId() %>_trachocongdan" checked="checked" type="checkbox" value="<%=fileUpload.getId() %>"  onclick="deleteFileUpload('<%=fileUpload.getId() %>')"/>
									<%
										} else {
											%>
											<input id="<%=fileUpload.getId() %>_trachocongdan" name="<%=fileUpload.getId() %>_trachocongdan" type="checkbox" value="" onclick="deleteFileUpload('<%=fileUpload.getId() %>')"/>
											<%
										}
									}
									%>
									</td>
									<td>
										<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
									</td>
								</tr>
							<%
							}
						}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				<%
				if (!SessionMessages.contains(renderRequest, "update_ho_so_completed")) {
					%>
					<input type="submit" style="height: 35px;padding:10px;" class = "egov-button" name="submitButton"  value="Lưu lại" />
					<%
				}
				%>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">

function deleteFileUpload(fileId) {

	var giatri = document.getElementById(fileId + '_trachocongdan').value;
	if (giatri.length > 0) {
		document.getElementById(fileId + '_trachocongdan').value = '';
	} else {
		document.getElementById(fileId + '_trachocongdan').value = fileId;
	}
	
}
</script>
