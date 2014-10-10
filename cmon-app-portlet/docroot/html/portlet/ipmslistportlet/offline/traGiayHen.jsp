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
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.form.TaiLieuDinhKem"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.form.ThuTucHanhChinh"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.form.IFormService"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<%
String maSoHoSo = "";
if (renderRequest.getParameter("maSoHoSo") != null) {
	maSoHoSo = renderRequest.getParameter("maSoHoSo");
}

String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String cqqlId = "";
if (renderRequest.getParameter("cqqlId") != null) {
	cqqlId = renderRequest.getParameter("cqqlId");
}
String idQuyTrinh = "";
if (renderRequest.getParameter("idQuyTrinh") != null) {
	idQuyTrinh = renderRequest.getParameter("idQuyTrinh");
}
String idCongDan = "";
if (renderRequest.getParameter("idCongDan") != null) {
	idCongDan = renderRequest.getParameter("idCongDan");
}

String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}
HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
hoSoTTHCCong.setDaGuiGiayHen(1);
HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
	</head>
	<body>
	<table align="center" border="0" class="egov-table-form">
		<tr>
		<%
			for (int j = 0; j < 2; j ++) { 
		%>
			<td width="50%" style="padding-left:15px;">
				<table align="center" border="0" class="egov-table-form" style="font: 60%/1.5em Tahoma,Helvetica,sans-serif;">
					<tr>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
					</tr>	
					<tr>
						<td colspan="3">
							<b>SỞ XÂY DỰNG THÀNH PHỐ ĐÀ NẴNG</b>
						</td>
						<td colspan="3">
							<b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<b>TỔ TIẾP NHẬN VÀ TRẢ HỒ SƠ</b>
						</td>
						<td colspan="3">
							<b>Độc lập-Tự do-Hạnh phúc</b>
						</td>
					</tr>	
					<tr>
						<td colspan="3">
							<b>Số hồ sơ: <%=maSoHoSo %></b>
						</td>
						<td colspan="3">
						</td>
					</tr>
					<tr>
						<td colspan="6" align="center">
							<p class="egov-p-20">
								<b>BIÊN NHẬN HỒ SƠ</b>
							</p>
						</td>
					</tr>
					<tr>
						<td colspan="6" align="center">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
							Nhận của Ông(bà):
						</td>
						<td  colspan="4">
							 <b><%=hoSoTTHCCong.getHoTenNguoiNopHoSo() %></b>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							Địa chỉ:
						</td>
						<td colspan="4">
							 <b><%=hoSoTTHCCong.getDiaChiThuongTruNguoiNop() %></b>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Điện thoại:
						</td>
						<td colspan="4">
							 <b><%= Validator.isNull(hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop())? "":hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop() %></b>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Loại hồ sơ:
						</td>
						<td colspan="4">
							 <b><%=hoSoTTHCCong.getTenThuTucHanhChinh() %></b>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Loại công trình:
						</td>
						<td colspan="4">
							 <b></b>
						</td>
					</tr>
					<tr>
						<td colspan="5">
							<b>HỒ SƠ GỒM CÓ</b>
						</td>
						<td  colspan="1">
							<b>Số lượng</b>
						</td>
					</tr>
					<%
						IFormService  service = WebserviceFactory.getFormService();
						ThuTucHanhChinh thuTucHanhChinh = service.getThuTucHanhChinhTheoId(user.getUserId(), Long.parseLong(idQuyTrinh));
						List<TaiLieuDinhKem> listTaiLieu = new ArrayList<TaiLieuDinhKem>();
						if (thuTucHanhChinh != null) {
							listTaiLieu = thuTucHanhChinh.getTaiLieuDinhKems();
							
						} else {
							
						}
						
						for (int i = 0; i < listTaiLieu.size(); i++) {
							TaiLieuDinhKem taiLieuDinhKem = listTaiLieu.get(i);
							long idTaiLieu = taiLieuDinhKem.getId();
					%>
					<tr>
						<td colspan="5">
							<%=(i+1)%>.&nbsp; <%= taiLieuDinhKem.getTen() %>	
						</td>
						<td colspan="1">
							<input type="text" class="egov-inputfield" id="<%=idTaiLieu%>" name="<%=idTaiLieu%>">
						</td>
					</tr>
					<% } %>
					<tr>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
						<td width="16.67%">&nbsp;</td>
					</tr>	
					<tr>
						<td colspan="3">
							Cán bộ thụ lý:<%=ConvertUtil.getTenCanBo(hoSoTTHCCong.getCanBoTiepNhanId()) %>
						</td>
						<td colspan="3">
							Số điện thoại:<%=Validator.isNull(hoSoTTHCCong.getSoDienThoaiNguoiNhan())? "":hoSoTTHCCong.getSoDienThoaiNguoiNhan()%>
						</td>
					</tr>
					<tr>
						<td colspan="6">
							(Sở xây dựng sẽ chủ động liên lạc với chủ đầu tư kiểm tra thực địa)
						</td>
					</tr>
					
					<%
						Calendar nowCalendar = GregorianCalendar.getInstance();
						nowCalendar.setTime(new Date());
					%>
					<tr>
						<td colspan="3">
							Nhận lúc: ......... giờ
						</td>
						<td colspan="3">
							Ngày <%=nowCalendar.get(Calendar.DAY_OF_MONTH)%>
							Tháng <%=nowCalendar.get(Calendar.MONTH) + 1%>
							Năm <%=nowCalendar.get(Calendar.YEAR)%>
						</td>
					</tr>
					
					<%
						Calendar nhanCalendar = GregorianCalendar.getInstance();
						nhanCalendar.setTime(hoSoTTHCCong.getNgayHenTraKetQua());
					%>
					<tr>
						<td colspan="3">
							Ngày nhận kết quả:.......... giờ
						</td>
						<td colspan="3">
							Ngày <%=nhanCalendar.get(Calendar.DAY_OF_MONTH)%>
							Tháng <%=nhanCalendar.get(Calendar.MONTH) + 1%>
							Năm <%=nhanCalendar.get(Calendar.YEAR)%>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<b>Người nộp hồ sơ</b><br>
							(Ký, ghi rõ họ tên)
						</td>
						<td colspan="2">
							<b>Phòng chuyên môn</b><br>
							(Ký, ghi rõ họ tên)
						</td>
						<td colspan="2">
							<b>Người nhận hồ sơ</b><br>
							(Ký, ghi rõ họ tên)
						</td>
					</tr>
				</table>
			</td>
			<% } %>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="6">
				<input id="button_printer" type = "button" style="height: 35px;padding:10px;display: inherit;" class = "egov-button" onclick="javascript:beforePrint();" value="In giấy" />
			</td>
		</tr>
	</table>
	</body>
</html>

<script type="text/javascript">
function beforePrint() {
	document.getElementById('button_printer').style.display = 'none';
	window.print();
}
</script>